package cm.SpringBoot.MVC.CURDDemo.controller;

import cm.SpringBoot.MVC.CURDDemo.entity.Customer;
import cm.SpringBoot.MVC.CURDDemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/Customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/List")
    public String getCustomerList(Model theModel) {

        List<Customer> theCustomers = customerService.findAll();

        theModel.addAttribute("customer", theCustomers);

        return "Customer-List";
    }

    @RequestMapping("/add-new-customer")
    public String addNewCustomer(Model theModel) {

        theModel.addAttribute("customer", new Customer());
        return "Add-New-Customer";
    }

    @PostMapping("/save-customer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

        customerService.save(theCustomer);

        return "redirect:/Customer/List";
    }

    @RequestMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId) {

        System.out.println(theId);
        customerService.deleteById(theId);
        return "redirect:/Customer/List";
    }

    @GetMapping("/update")
    public String updateCustomer(@RequestParam("customerId") int theId, Model theModel) {

        Optional<Customer> theCustomer = customerService.findById(theId);

        theModel.addAttribute("customer",theCustomer);


        System.out.println(theCustomer.toString());

        return "Update-Customer";
    }
}
