package transaction;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TransactionController {
  private final TransactionRepository repository;

  TransactionController(TransactionRepository repository) {
    this.repository = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/transactions")
  List<Transaction> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/transactions")
  Transaction newTransaction(@RequestBody Transaction newTransaction) {
    return repository.save(newTransaction);
  }

  // Single item
  
  @GetMapping("/transactions/{id}")
  Transaction one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new TransactionNotFoundException(id));
  }

  @PutMapping("/transactions/{id}")
  Transaction replaceTransaction(@RequestBody Transaction newTransaction, @PathVariable Long id) {
    return repository.findById(id)
      .map(transaction -> {
        transaction.setDate(newTransaction.getDate());
        transaction.setStatus(newTransaction.getStatus());
        transaction.setAmount(newTransaction.getAmount());
        transaction.setCurrency(newTransaction.getCurrency());
        transaction.setDescription(newTransaction.getDescription());
        return repository.save(transaction);
      })
      .orElseGet(() -> {
    	  newTransaction.setId(id);
        return repository.save(newTransaction);
      });
  }

  @DeleteMapping("/transactions/{id}")
  void deleteTransaction(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
