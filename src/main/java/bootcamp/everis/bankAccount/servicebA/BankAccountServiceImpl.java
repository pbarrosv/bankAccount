package bootcamp.everis.bankAccount.servicebA;

import bootcamp.everis.bankAccount.documentbA.BankAccount;
import bootcamp.everis.bankAccount.repositorybA.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class BankAccountServiceImpl implements BankAccountService{
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public Flux<BankAccount> allBankAccount() {
        return this.bankAccountRepository.findAll();
    }

    @Override
    public Mono<BankAccount> saveBankAccount(BankAccount BankAccountSer) {
        return this.bankAccountRepository.save(BankAccountSer);
    }

    @Override
    public Mono<BankAccount> updateBankAccount(Long idba, BankAccount BankAccountSer) {
        return this.bankAccountRepository.findById(idba)
                .flatMap(bankAccountP -> {
                    BankAccountSer.setIdba(idba);
                    return saveBankAccount(BankAccountSer);
                }).switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<BankAccount> deleteBankAccount(Long idba) {
        return this.bankAccountRepository
                .findById(idba)
                .flatMap(BA ->
                        this.bankAccountRepository.deleteById(BA.getIdba()).thenReturn(BA));
    }
}
