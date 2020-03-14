package app.service;

import app.model.PhoneCompany;
import app.repository.PhoneCompanyRepository;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhoneCompanyServiceImpl implements IPhoneCompanyService {

  private final PhoneCompanyRepository companyRepository;
  private final Gson gson;

  private List<PhoneCompany> phoneCompanyList;
  @Value("${companiesURL}")
  private Resource companyList;

  @PostConstruct
  public void init() {
    try (final Reader reader = new InputStreamReader(companyList.getInputStream())) {
      phoneCompanyList = Arrays.asList(
          gson.fromJson(reader, PhoneCompany[].class));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    companyRepository.saveAll(phoneCompanyList);
  }

  @Override
  public List<PhoneCompany> findAll() {
    return companyRepository.findAll();
  }

  @Override
  public String findByPhoneCode(String phoneCode) {
    return companyRepository.findByPhoneCode(phoneCode).getCompanyName();
  }
}
