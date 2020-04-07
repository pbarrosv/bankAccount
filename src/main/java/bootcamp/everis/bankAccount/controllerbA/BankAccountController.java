package bootcamp.everis.bankAccount.controllerbA;

import bootcamp.everis.bankAccount.documentbA.BankAccount;
import bootcamp.everis.bankAccount.servicebA.BankAccountService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/BankAccount")
public class BankAccountController {
    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping(value = "/allBankAccount")
    @ApiOperation(value = "Find all Bank Account",notes = "It shows me the information of all the Bank Account")
    public Flux<BankAccount> getBankAccountAll(){
        return this.bankAccountService.allBankAccount();
    }

    @PostMapping("/saveBankAccount")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Registered Bank Account",notes = "Register Bank Account information")
    public Mono<BankAccount> saveBankAccount(@Valid @RequestBody BankAccount saveBAccount){
        return this.bankAccountService.saveBankAccount(saveBAccount);
    }

    @DeleteMapping("/deleteBankA/{idba}")
    @ApiOperation(value = "Delete Bank Account by id",notes = "Bank accounts are searched by id and removed")
    public Mono<ResponseEntity<BankAccount>> delBankAcc(@PathVariable("idba") Long idba){
        return this.bankAccountService.deleteBankAccount(idba)
                .flatMap(bankAdel-> Mono.just(ResponseEntity.ok(bankAdel)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/updateBnkA/{idba}")
    @ApiOperation(value = "Update Bank Account by id",notes = "Bank accounts are searched by id and modified")
    public Mono<ResponseEntity<BankAccount>> upBankAcc(@PathVariable("idba") Long idba,@RequestBody BankAccount delBankAc){
        return this.bankAccountService.updateBankAccount(idba, delBankAc)
                .flatMap(bankAdel-> Mono.just(ResponseEntity.ok(bankAdel)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
}
