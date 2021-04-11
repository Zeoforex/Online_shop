package Online_shop.Murat.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String email;
    private String hashedPassword;
    private Boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    private Role role_id;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "users")
    @PrimaryKeyJoinColumn
    private User_Profile userProfile;

}