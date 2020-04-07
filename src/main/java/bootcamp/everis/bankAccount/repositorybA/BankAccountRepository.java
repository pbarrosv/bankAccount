package bootcamp.everis.bankAccount.repositorybA;

import bootcamp.everis.bankAccount.documentbA.BankAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends ReactiveMongoRepository<BankAccount,Long> {
}
