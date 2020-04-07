package bootcamp.everis.bankAccount.documentbA;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "BankAccount")
public class BankAccount {

    @Id
    private Long idba;
    @NotNull(message = "El campo accountnumber no debe estar vacio")
    private String accountnumber;
    @NotNull(message = "El campo accounttype no debe estar vacio")
    private String accounttype;

    private String id;
}
