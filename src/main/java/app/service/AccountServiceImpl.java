package app.service;

import app.model.PhoneCompany;
import app.model.UserAccount;
import app.repository.AccountRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService {

  @Value("${price.change.company}")
  private String price;
  private final AccountRepository accountRepository;
  private final PhoneCompanyServiceImpl companyService;
  @Override
  public List<UserAccount> findByUserId(Long id) {
    return accountRepository.findByUserId(id);
  }

  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
  @Override
  public UserAccount changeCompany(UserAccount account, String companyName) {

    if (account.getPhoneCompany().getCompanyName().equals(companyName)) {
      throw new RuntimeException("same company");
    }
    UserAccount byPhoneNumber = accountRepository.findByPhoneNumber(account.getPhoneNumber());
    if (byPhoneNumber.getAmount() < Double.parseDouble(price)) {
      throw new RuntimeException("Your operation can't be done. Not enough money");
    }
    PhoneCompany byCompanyName = companyService.findByCompanyName(companyName);
    Long accountId = accountRepository
        .changeCompany(byCompanyName, account.getAmount() - Double.parseDouble(price));
    Optional<UserAccount> byId = accountRepository.findById(accountId);
    if(byId.isPresent()){
      return byId.get();
    }
    throw new RuntimeException("Account doesn't exists");
  }
}
