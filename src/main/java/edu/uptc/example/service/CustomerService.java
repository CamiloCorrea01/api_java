package edu.uptc.example.service;

import edu.uptc.example.entityes.Customer;
import edu.uptc.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerService() {}

    // Obtener todos los clientes
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    // Obtener cliente por id
    public Customer getCustomer(Long id) {
        Optional<Customer> opt = customerRepository.findById(id);
        return opt.isPresent() ? opt.get() : null;
    }

    // Guardar cliente
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Buscar cliente por nombre
    public List<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }

    // Buscar cliente por correo electrónico
    public Optional<Customer> findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
}
