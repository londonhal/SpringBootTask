package transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(TransactionRepository repository) {

    return args -> {
    log.info("Preloading " + repository.save(new Transaction(20210901, "buy",1000,"USD","stock")));
    log.info("Preloading " + repository.save(new Transaction(20210902, "sell",500,"GBP","stock")));	  
    };
  }
}