package app.service;

import app.model.PhoneCompany;
import java.util.List;

public interface IPhoneCompanyService {

  List<PhoneCompany> findAll();
  String findByPhoneCode(String phoneCode);
}
