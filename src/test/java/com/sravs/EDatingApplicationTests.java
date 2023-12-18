package com.sravs;

import com.sravs.controller.UserAccountController;
import com.sravs.entities.UserAccount;
import com.sravs.repo.InterestRepo;
import com.sravs.repo.UserAccountRepo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@SpringBootTest
class EDatingApplicationTests {
    @Mock
    UserAccountRepo userAccountRepo;
    @Mock
    InterestRepo interestRepo;

    @InjectMocks
    UserAccountController userAccountController;

    @Test
    void testRegisterUser() {
       UserAccount account = new UserAccount();
       UserAccount savedAccount = new UserAccount();
       savedAccount.setId(123);
//       when(userAccountRepo.save(account).thenReturn(savedAccount));
       userAccountController.register(account);
    }

}
