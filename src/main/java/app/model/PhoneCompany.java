package app.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
@Table(name = "PHONE_COMPANIES")
public class PhoneCompany {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "COMPANY_NAME")
  @NotEmpty
  private String companyName;
  @Column(name = "PHONE_CODE")
  @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
  private List<String> phoneCode;

  public PhoneCompany(@NotEmpty String companyName, List<String> phoneCode) {
    this.companyName = companyName;
    this.phoneCode = phoneCode;
  }

  public PhoneCompany() {
  }
}
