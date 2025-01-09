package Bomhofsoft.Personal_ERP.controller;
import Bomhofsoft.Personal_ERP.model.finance.BankAccount;
import Bomhofsoft.Personal_ERP.model.finance.FinanceModule;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Value;

import java.util.Optional;

@Controller
public class FinancePageController {
    FinanceModule dataModel;
    //@Value("${app.base-url}")
    private String baseUrl;
    public FinancePageController() {
        dataModel = new FinanceModule();

        //Test data:
        BankAccount account1 = new BankAccount("Test1", "Test1234", 10.50d);
        BankAccount account2 = new BankAccount("Test2", "Test5678", 110.50d);

        dataModel.addAccount(account1);
        dataModel.addAccount(account2);
    }
    @GetMapping("/finance")
    public String finance_index(Model model){
        model.addAttribute("baseUrl", baseUrl);
        model.addAttribute("bankaccounts", dataModel.bankAccounts);
        return "finance";
    }
    @GetMapping("/finance/accounts/{id}")
    public String finance_accountdetails(@PathVariable("id") long id,Model model){
        Optional<BankAccount> account = dataModel.bankAccounts.stream()
                .filter(accounti -> accounti.internalId == id)
                .findFirst();

        model.addAttribute("baseUrl", baseUrl);
        model.addAttribute("account", account.get());
        return "accountdetails";
    }
}
