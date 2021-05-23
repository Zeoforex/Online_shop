package Online_shop.Murat.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@NoArgsConstructor
public class Item_Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemInfoId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Item parentItem;

    private String colour;
    private Double price;
    private Integer amount;


}