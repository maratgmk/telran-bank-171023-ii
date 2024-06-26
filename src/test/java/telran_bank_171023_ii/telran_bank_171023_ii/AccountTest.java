package telran_bank_171023_ii.telran_bank_171023_ii;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import telran_bank_171023_ii.telran_bank_171023_ii.account.AccountBalanceStorage;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private AccountBalanceStorage accountBalanceStorage;

    @Test
    void shouldCheckThatAccountUrlReturnsString() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/account"))
                .andExpect(content().string("I'm some account"));
    }

    @Test
    void shouldReturnHelloFromHelloUrl() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(content().string("Hello world"));
    }

    @Test
    void shouldReturnOkStatusRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/status"))
                .andExpect(content().string("Ok"));
    }

    @Test
    void shouldCheckBalanceInStorage() {
        Assertions.assertEquals(accountBalanceStorage.getBalance("3"), 1235);
    }

    @Test
    void shouldCheckIfANumberIsEven() {
        // given
        int a = 4;
        // when
        boolean isEven = a % 2 == 0;
        // then
        Assertions.assertTrue(isEven);

    }

    @Test
    void shouldGetAccountBalance() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/account/balance")
                        .queryParam("accountId", "3")
                        .queryParam("accountType", "checking"))
                .andExpect(content().string("The balance for  accountId = 3 is 1235 on checking"));

    }

    @Test
    void shouldGetAccountBalanceFor1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/account/balance")
                        .queryParam("accountId", "1")
                        .queryParam("accountType", "checking"))
                .andExpect(content().string("The balance for  accountId = 1 is 0 on checking"));

    }
}
