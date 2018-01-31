package sso.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sso.domain.Account;
import sso.domain.DocumentType;
import sso.domain.Gender;
import sso.service.AccountSsoService;
import java.util.UUID;

@Component
public class initData implements CommandLineRunner {

    @Autowired
    private AccountSsoService ssoService;

    public void run(String... args) throws Exception {
        Account acc = new Account();
        acc.setDocumentType(DocumentType.ID_CARD.getCode());
        acc.setDocumentNum("217380193021");
        acc.setEmail("fdse_microservices@163.com");
        acc.setPassword("DefaultPassword");
        acc.setName("Normal_User");
        acc.setGender(Gender.MALE.getCode());
        acc.setId(UUID.fromString("4d2a46c7-71cb-4cf1-b5bb-b68406d9da6f"));
        ssoService.createAccount(acc);

        acc = new Account();
        acc.setDocumentType(DocumentType.ID_CARD.getCode());
        acc.setDocumentNum("dsadsada");
        acc.setEmail("vip_microservices@163.com");
        acc.setPassword("DefaultPassword");
        acc.setName("VIP_User");
        acc.setGender(Gender.MALE.getCode());
        acc.setId(UUID.fromString("5e3b57c7-71cb-4cf1-b5bb-b68406d9da6f"));
        ssoService.createAccount(acc);

    }


}