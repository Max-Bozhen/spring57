package app.config;

import app.model.User;
import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractPdfView;

public class PdfReportViewGenerator extends AbstractPdfView {

  @Override
  protected void buildPdfDocument(Map model, Document document,
      PdfWriter writer, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if (model.get("users") != null) {

      List<User> userList = (List<User>) model.get("users");


      Table table = new Table(2);
      table.addCell("Name");
      table.addCell("Phone numbers");

      for (User user : userList) {

        table.addCell(user.getFullName());
        table.addCell(user.getPhoneNumber().stream()
            .reduce((a,b)-> a + "\n" + b)
            .orElse(""));
      }

      document.add(table);
    }
  }
}
