package app.repository;

import app.model.PhoneCompany;
import app.model.UserAccount;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class AccountRepositoryCustomImpl implements AccountRepositoryCustom {

  @PersistenceContext
  private EntityManager entityManager;

  @Transactional(propagation = Propagation.REQUIRED)
  @Override
  public long changeCompany(PhoneCompany changeTo, double amount, Long accountId) {
    String sql = "UPDATE UserAccount SET phoneCompany.id = :company , amount = :amount WHERE id = :id";
    Query query = entityManager.createQuery(sql);
    query.setParameter("company", changeTo.getId());
    query.setParameter("amount", amount);
    query.setParameter("id", accountId);
    int i = query.executeUpdate();
    if (i == 0) {
      throw new RuntimeException("ERROR");
    }

    return i;
  }
}
