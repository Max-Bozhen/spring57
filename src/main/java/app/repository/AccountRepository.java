package app.repository;

import app.model.UserAccount;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<UserAccount, Long>, AccountRepositoryCustom{

  List<UserAccount> findByUserId(Long id);


  UserAccount findByPhoneNumber(String phoneNumber);

}
