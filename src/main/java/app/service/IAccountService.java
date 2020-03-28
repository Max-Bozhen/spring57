package app.service;

import app.model.UserAccount;
import java.util.List;

public interface IAccountService {

  List<UserAccount> findByUserId(Long id);

  UserAccount changeMobileOperator(UserAccount account, String companyName);
}
