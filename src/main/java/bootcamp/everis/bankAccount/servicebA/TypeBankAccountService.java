package bootcamp.everis.bankAccount.servicebA;

import bootcamp.everis.bankAccount.documentbA.TypeBankAccount;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface TypeBankAccountService {

    public Flux<TypeBankAccount> allTypeBankAccount();
    public Mono<TypeBankAccount> saveTypeBankAccount(TypeBankAccount TBankAccSer);
    public Mono<TypeBankAccount> updateTypeBankAccount(Long idt,TypeBankAccount TBankAccSer);
    public Mono<TypeBankAccount> deleteTypeBankAccount(Long idt);
}
