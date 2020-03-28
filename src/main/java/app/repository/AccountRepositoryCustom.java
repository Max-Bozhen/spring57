package app.repository;

import app.model.PhoneCompany;

public interface AccountRepositoryCustom {

  long changeMobileOperator(PhoneCompany changeTo, double amount, Long accountId);
}
