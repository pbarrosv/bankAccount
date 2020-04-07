package bootcamp.everis.bankAccount.controllerbA;

import bootcamp.everis.bankAccount.documentbA.TypeBankAccount;
import bootcamp.everis.bankAccount.servicebA.TypeBankAccountService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/BankAccountType")
public class TypeBankAccountController {

    @Autowired
    private TypeBankAccountService typeBankAccountService;

    @GetMapping(value = "/allTypeBA")
    @ApiOperation(value = "Find all Bank Account Type ",notes = "It shows me the information of all the Bank Account Type")
    public Flux<TypeBankAccount> getTypeBankAccountAll(){
        return this.typeBankAccountService.allTypeBankAccount();
    }

    @PostMapping("/saveTypeBA")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Registered Bank Account Type",notes = "Register Bank Account Type information")
    public Mono<TypeBankAccount> saveTypeBA(@Valid @RequestBody TypeBankAccount saveTypeBA){
        return  this.typeBankAccountService.saveTypeBankAccount(saveTypeBA);
    }

    @DeleteMapping("/deleteTypeBA/{idt}")
    @ApiOperation(value = "Delete Bank Account Type by id",notes = "Bank account types are searched by id and removed")
    public Mono<ResponseEntity<TypeBankAccount>> delTypeBA(@PathVariable("idt") Long idt){
        return this.typeBankAccountService.deleteTypeBankAccount(idt)
                .flatMap(TypebankAdel-> Mono.just(ResponseEntity.ok(TypebankAdel)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/updateTypeBA/{idt}")
    @ApiOperation(value = "Update Bank Account Type by id",notes = "Bank account types are searched by id and modified")
    public Mono<ResponseEntity<TypeBankAccount>> upTypeBankAcc(@PathVariable("idt") Long idt, @RequestBody TypeBankAccount delTypeBankAc){
        return this.typeBankAccountService.updateTypeBankAccount(idt, delTypeBankAc)
                .flatMap(typebankAdel-> Mono.just(ResponseEntity.ok(typebankAdel)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

}
