package app.repository;

import app.model.PhoneCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneCompanyRepository extends JpaRepository<PhoneCompany, Long> {

  PhoneCompany findByPhoneCode(String phoneCode);
}
