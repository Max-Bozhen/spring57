package app.controller;

import app.model.PhoneCompany;
import app.model.User;
import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.view.document.AbstractPdfView;

public class PDFView extends AbstractPdfView {

  @Override
  protected void buildPdfDocument(Map<String, Object> model, Document document,
      PdfWriter writer, HttpServletRequest request,
      HttpServletResponse response) throws Exception {

    List<User> users = (List<User>) model.get("users");
    List<PhoneCompany> companyList = (List<PhoneCompany>) model.get("companies");

    Table table = new Table(3);
    table.addCell("fullName");
    table.addCell("PhoneNumbers");
    table.addCell("phoneCompany");
    Map<@NotEmpty String, List<String>> collect = companyList.stream()
        .collect(Collectors.toMap(phoneCompany -> phoneCompany.getCompanyName(),
            phoneCompany -> phoneCompany.getPhoneCode()));
    for (User user : users) {
      table.addCell(user.getFullName());
      List<String> phoneNumber = user.getPhoneNumber();
      StringBuilder sb = new StringBuilder();
      for (String phone : phoneNumber) {
        companyList.stream()
            .flatMap(phoneCompany -> Stream.of(phoneCompany.getPhoneCode()))
            .flatMap(Collection::stream)
            .filter(phone::startsWith)
            .findFirst().ifPresent(s1 -> {
          collect.forEach((s2, strings) -> {
            if (strings.contains(s1)) {
              sb.append(s2 + "\n");
            }
          });
        });
      }
      String join = StringUtils.join(phoneNumber, "\n");
      table.addCell(join);
      table.addCell(sb.toString());
    }

    document.add(table);
  }
}
