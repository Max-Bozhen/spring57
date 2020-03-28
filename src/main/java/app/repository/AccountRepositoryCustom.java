package app.repository;

import app.model.PhoneCompany;

public interface AccountRepositoryCustom {

  long changeCompany(PhoneCompany changeTo, double amount);
}
