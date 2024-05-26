package telran_bank_171023_ii.telran_bank_171023_ii;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SampleTest {

//    @Autowired не работает тест, так как нет аннотации SpringBootTest
//    private AccountBalanceStorage accountBalanceStorage;

    @Test
    void shouldSumTwoNumbers() {
        // accountBalanceStorage.getBalance("3");
        Assertions.assertEquals(2, 1 + 1);
    }
}
