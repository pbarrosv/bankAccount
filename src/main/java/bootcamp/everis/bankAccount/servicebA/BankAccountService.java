package bootcamp.everis.bankAccount.servicebA;

import bootcamp.everis.bankAccount.documentbA.BankAccount;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface BankAccountService {

    public Flux<BankAccount> allBankAccount();
 //   public Mono<BankAccount> findByIdBankAccount(Long idba);
    public Mono<BankAccount> saveBankAccount(BankAccount BankAccountSer);
    public Mono<BankAccount> updateBankAccount(Long idba,BankAccount BankAccountSer);
    public Mono<BankAccount> deleteBankAccount(Long idba);
}
