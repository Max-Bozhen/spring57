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

@Data
@Entity
@Table(name = "USERS")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @Column(name = "FULL_NAME")
  @NotEmpty
  private String fullName;

  @Column(name = "PHONE_NUMBER")
  @ElementCollection(targetClass = String.class)
  private List<String> phoneNumber;


  public User() {
  }

}
