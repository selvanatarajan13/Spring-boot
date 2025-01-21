package cm.SpringBoot.MVC.CURDDemo.dao;

import cm.SpringBoot.MVC.CURDDemo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    /* This is the magic method, because it automatically doing the CRUD operation without any manual code */
}
