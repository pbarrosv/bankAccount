package bootcamp.everis.bankAccount.repositorybA;

import bootcamp.everis.bankAccount.documentbA.TypeBankAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeBankAccountRepository extends ReactiveMongoRepository<TypeBankAccount,Long> {
}
