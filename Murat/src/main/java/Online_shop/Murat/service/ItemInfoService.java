package Online_shop.Murat.service;

import Online_shop.Murat.entity.Item_Info;
import Online_shop.Murat.repo.Item_Info_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemInfoService<ItemInfoRepo> {

    @Autowired
    private Item_Info_Repo itemInfoRepo;

    public void create(Item_Info itemInfo){itemInfoRepo.save(itemInfo);}

    public void update(Item_Info itemInfo){itemInfoRepo.save(itemInfo);}

    public void delete(Item_Info itemInfo){itemInfoRepo.delete(itemInfo);}

    public Optional<Item_Info> find(Long id){return itemInfoRepo.findById(id);}

    public List<Item_Info> findAll(){return itemInfoRepo.findAll();}

}