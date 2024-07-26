package academy.atl.customers.controllers;

import academy.atl.customers.entities.Customer;
import org.springframework.web.bind.annotation.*;

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
        //lamba function
        //cretae a lanba function to iterate the list
        //if the id is equal to the id of the customer return the customer
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


    @PostMapping("/addCustomer")
    public void addCustomer(@RequestBody Customer customer) {
        list.add(customer);
    }

    @GetMapping("/removeCustomer")
    public void removeCustomer() {
        for(Customer customer : list){
            if(customer.getId().equals(1)){
                list.remove(customer);
                break;
            }
        }
    }

    @PutMapping("/updateCustomer/{id}")
    public void updateCustomer(@RequestBody Integer id ,
                               @RequestBody Customer updateCustomer) {
        for(Customer c : list){
            if(c.getId().equals(id)){
                list.remove(c);
                updateCustomer.setId(id); //le seteamos el id en caso de que no lo tenga
                list.add(updateCustomer);
                break;
            }
        }

    }

    @GetMapping("/searchCustomer")
    public List<Customer> searchCustomer() {
        return null;
    }


}
