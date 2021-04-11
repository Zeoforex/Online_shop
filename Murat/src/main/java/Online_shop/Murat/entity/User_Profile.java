package Online_shop.Murat.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
public class User_Profile {

    @Id
    @Column(name = "user_id")
    private Long userProfileId;

    private String firstName;
    private String lastName;
    private String middleName;
    private Date birthday;

    private String city;
    private String street;
    private String flat;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private Users users;




}