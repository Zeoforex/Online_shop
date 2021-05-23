package Online_shop.Murat.service;

import Online_shop.Murat.entity.Item;
import Online_shop.Murat.repo.Item_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class ItemService {

        @Autowired
        private Item_Repo itemRepo;

        public void create(Item item){itemRepo.save(item);}

        public void update(Item item){itemRepo.save(item);}

        public void delete(Item item){itemRepo.delete(item);}

        public Optional<Item> find(Long id){return itemRepo.findById(id);}

        public List<Item> findAll(){return itemRepo.findAll();}

    }