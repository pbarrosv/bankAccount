package bootcamp.everis.bankAccount.servicebA;

import bootcamp.everis.bankAccount.documentbA.BankAccount;
import bootcamp.everis.bankAccount.documentbA.TypeBankAccount;
import bootcamp.everis.bankAccount.repositorybA.TypeBankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TypeBankAccountServiceImpl implements TypeBankAccountService{

    @Autowired
    private TypeBankAccountRepository typeBankAccountRepository;


    @Override
    public Flux<TypeBankAccount> allTypeBankAccount() {
        return this.typeBankAccountRepository.findAll();
    }

    @Override
    public Mono<TypeBankAccount> saveTypeBankAccount(TypeBankAccount TBankAccSer) {
        return this.typeBankAccountRepository.save(TBankAccSer);
    }

    @Override
    public Mono<TypeBankAccount> updateTypeBankAccount(Long idt, TypeBankAccount TBankAccSer) {
        return this.typeBankAccountRepository.findById(idt)
                .flatMap(TbankAccP -> {
                    TBankAccSer.setIdt(idt);
                    return saveTypeBankAccount(TBankAccSer);
                }).switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<TypeBankAccount> deleteTypeBankAccount(Long IdTBA) {
        return this.typeBankAccountRepository
                .findById(IdTBA)
                .flatMap(TBA ->
                        this.typeBankAccountRepository.deleteById(TBA.getIdt()).thenReturn(TBA));
    }
}
