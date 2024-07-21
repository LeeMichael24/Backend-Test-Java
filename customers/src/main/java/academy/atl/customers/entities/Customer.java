package academy.atl.customers.entities;

import lombok.*;

import java.beans.ConstructorProperties;
import java.util.Objects;
import java.util.UUID;


//@Getter @Setter @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode @ToString
@Data @Builder
public class Customer {

    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String address;
}
