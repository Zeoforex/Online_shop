package Online_shop.Murat.repo;

import Online_shop.Murat.entity.User_Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_Profile_Repo extends JpaRepository<User_Profile, Long> {
}