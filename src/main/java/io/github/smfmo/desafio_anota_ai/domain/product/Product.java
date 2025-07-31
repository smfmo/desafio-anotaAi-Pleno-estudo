package io.github.smfmo.desafio_anota_ai.domain.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    private String id;

    private String title;

    private String description;

    private Integer price;

    private String categoryId;

    private String ownerId;

    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("title", title);
        json.put("description", description);
        json.put("price", price);
        json.put("categoryId", categoryId);
        json.put("ownerId", ownerId);
        json.put("type", "product");
        return json.toString();
    }

    public String deleteToString(){
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("ownerId", ownerId);
        json.put("type", "delete-product");
        return json.toString();
    }
}
