package Online_shop.Murat.repo;

import Online_shop.Murat.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Role_Repo extends JpaRepository<Role, Long> {
}
