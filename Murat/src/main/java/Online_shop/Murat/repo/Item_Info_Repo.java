package Online_shop.Murat.repo;

import Online_shop.Murat.entity.Item_Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Item_Info_Repo extends JpaRepository<Item_Info, Long> {
}