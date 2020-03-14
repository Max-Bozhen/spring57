package app.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
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
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @Column(name = "COMPANY_NAME")
  @NotEmpty
  private String companyName;
  @Column(name = "PHONE_CODE")
  @ElementCollection(targetClass = String.class)
  private List<String> phoneCode;

  public PhoneCompany() {
  }
}
