package Online_shop.Murat.repo;

import Online_shop.Murat.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Users_Repo extends JpaRepository<Users, Long>{

}