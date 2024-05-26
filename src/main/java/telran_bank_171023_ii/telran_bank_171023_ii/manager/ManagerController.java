package telran_bank_171023_ii.telran_bank_171023_ii.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ManagerController {
    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    @ResponseBody
    public String managerInfo() {

        return "I'm some manager";
    }
}
