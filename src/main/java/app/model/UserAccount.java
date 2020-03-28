package app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class UserAccount {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private User user;

  private double amount;

  @ManyToOne
  private PhoneCompany phoneCompany;

  private String phoneNumber;

  public UserAccount() {
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Double getAmount() {
    return amount;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public PhoneCompany getPhoneCompany() {
    return phoneCompany;
  }

  public void setPhoneCompany(PhoneCompany phoneCompany) {
    this.phoneCompany = phoneCompany;
  }

  public Long getId() {
    return id;
  }
}
