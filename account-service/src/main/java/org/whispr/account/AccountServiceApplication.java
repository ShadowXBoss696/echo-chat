package org.whispr.account;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.whispr.account.domain.entity.UserAccount;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient(autoRegister = false)
public class AccountServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void run(String... args) throws Exception {
        List<UserAccount> accountList = entityManager.createQuery("SELECT u FROM UserAccount u", UserAccount.class)
            .getResultList();

        for (UserAccount account : accountList) {
            System.out.println(account);
        }

        System.exit(0);
    }
}
