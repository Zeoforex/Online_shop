package Online_shop.Murat.repo;


import Online_shop.Murat.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Country_Repo extends JpaRepository<Country, Long> {

}