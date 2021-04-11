package Online_shop.Murat.repo;


import Online_shop.Murat.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Manufacturer_Repo extends JpaRepository<Manufacturer, Long> {
}