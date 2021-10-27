package me.tipsuy.twitterpostsweb.job;

import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionManager;

/**
 * @author Daniel Baharian
 * @since 23 oct. 2021
 */
@Component
public class JobRepository {

   @Autowired
   private TransactionManager transactionManager;

   @Bean
   public TransactionManager getTransactionManager() {
      return new ResourcelessTransactionManager();
   }

   @Bean
   public JobRepositoryFactoryBean jobRepositoryFactoryBean() {
   }
}
