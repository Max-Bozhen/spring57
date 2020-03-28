package app.service;

import app.model.UserAccount;
import java.util.List;

public interface IAccountService {

  List<UserAccount> findByUserId(Long id);

  UserAccount changeCompany(UserAccount account, String companyName);
}
