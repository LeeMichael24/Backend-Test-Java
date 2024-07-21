package academy.atl.customers.controllers;

import academy.atl.customers.entities.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.PrinterIOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CustomerController {

    //porque retornara una lista de clientes
    private List<Customer> list = new ArrayList<>();

    public CustomerController() {
        list.add(Customer.builder()
                .id(1)
                .firstname("Juan")
                .lastname("Perez")
                .email("juanpe@gmail.com")
                .address("Calle 123")
                .build());
        list.add(Customer.builder()
                .id(2)
                .firstname("Albert")
                .lastname("Narv")
                .email("albert@gmail.com")
                .address("Calle 555")
                .build());
        list.add(Customer.builder()
                .id(3)
                .firstname("Jorge")
                .lastname("magico")
                .email("magico@gmail.com")
                .address("Calle 777")
                .build());
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable Integer id) {
        for (Customer customer : list) {
            if( customer.getId().equals(id)){
                return customer;
            }
        }
        return null;
    }

    @GetMapping("/customer")
    public List<Customer> getAllCustomers() {
        return list;
    }


    @GetMapping("/addCustomer")
    public void addCustomer(Customer customer) {
    }

    @GetMapping("/removeCustomer")
    public void removeCustomer() {
    }

    @GetMapping("/updateCustomer")
    public void updateCustomer() {
    }

    @GetMapping("/searchCustomer")
    public List<Customer> searchCustomer() {
        return null;
    }


}
