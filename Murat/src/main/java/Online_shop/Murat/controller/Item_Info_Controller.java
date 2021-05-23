package Online_shop.Murat.controller;

import Online_shop.Murat.entity.Item_Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Item_Info_Controller {

    private final Item_Info_Service itemInfoService;

    @Autowired
    public Item_Info_Controller(Item_Info_Service itemInfoService){
        this.itemInfoService = itemInfoService;
    }
    @PostMapping("/api/itemInfo")
    public ResponseEntity<?> create(@RequestBody Item_Info itemInfo){
        itemInfoService.create(itemInfo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/itemInfo")
    public ResponseEntity<List<ItemInfo>> findALL(){
        final List<ItemInfo> itemInfoList = itemInfoService.findAll();
        return itemInfoList != null && !itemInfoList.isEmpty()
                ? new ResponseEntity<>(itemInfoList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/itemInfo/{id}")
    public ResponseEntity<Optional<ItemInfo>> find(@PathVariable(name = "id")Long id){
        final Optional<ItemInfo> itemInfo = itemInfoService.find(id);
        return itemInfo!=null
                ? new ResponseEntity<>(itemInfo, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/api/itemInfo/{id}")
    public ResponseEntity<?> updateItemInfo(@PathVariable(name = "id")Long id, @RequestBody ItemInfo itemInfoUpdate){
        return itemInfoService.find(id).map(itemInfo -> {
            itemInfo.setParentItem(itemInfoUpdate.getParentItem());
            itemInfo.setAmount(itemInfoUpdate.getAmount());
            itemInfo.setColour(itemInfoUpdate.getColour());
            itemInfo.setPrice(itemInfoUpdate.getPrice());
            itemInfoService.update(itemInfo);
            return new ResponseEntity<>(itemInfo, HttpStatus.OK);
        }).orElseThrow(() -> new IllegalArgumentException());
    }


}