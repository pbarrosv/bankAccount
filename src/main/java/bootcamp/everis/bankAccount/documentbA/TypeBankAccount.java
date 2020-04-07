package bootcamp.everis.bankAccount.documentbA;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "TypeBankAccount")
public class TypeBankAccount {

    @Id
    private Long idt;
    @NotNull(message = "The field typename must not be empty")
    private String nametype;
}
