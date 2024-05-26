package telran_bank_171023_ii.telran_bank_171023_ii.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccountController {


    @Autowired
    private AccountBalanceStorage accountBalanceStorage;


    @RequestMapping(value = "/account", method = RequestMethod.GET)
    @ResponseBody
    public String accountInfo() {
        return "I'm some account";
    }

    @RequestMapping(value = "/account/balance", method = RequestMethod.GET)
    @ResponseBody
    public String accountBalancer(@RequestParam("accountId") String accountId, @RequestParam("accountType") String accountType) {
        int balance = accountBalanceStorage.getBalance(accountId);
        return "The balance for  accountId = " + accountId + " is " + balance + " on " + accountType;
        //  return "<html><body><h1>Hello world</h1></body></html>";
    }


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloWorld() {
        return "Hello world";
    }

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    @ResponseBody
    public String status() {
        return "Ok";
    }
}









