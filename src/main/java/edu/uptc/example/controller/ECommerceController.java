package edu.uptc.example.controller;


import edu.uptc.example.entityes.*;
import edu.uptc.example.handling.ResponseHandler;
import edu.uptc.example.service.CustomerService;
import edu.uptc.example.service.ProductService;
import edu.uptc.example.service.SaleService;
import edu.uptc.example.service.SaleItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.uptc.example.handling.ResponseHandler;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ECommerceController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private SaleService saleService;

    @Autowired
    private SaleItemService saleItemService;

    // Customer endpoints
    @GetMapping("/customers")
    public ResponseEntity<Object> getCustomers() {
        try {
            List<Customer> result = customerService.getCustomers();
            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, result);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Object> getCustomer(@PathVariable("id") long id) {
        try {
            Customer result = customerService.getCustomer(id);
            if (result != null) {
                return new ResponseHandler().generateResponse("Success", HttpStatus.OK, result);
            }
            return new ResponseHandler().generateResponse("Customer not found", HttpStatus.NOT_FOUND, null);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping("/customers")
    public ResponseEntity<Object> saveCustomer(@RequestBody Customer customer) {
        try {
            Customer result = customerService.saveCustomer(customer);
            return new ResponseHandler().generateResponse("Success", HttpStatus.CREATED, result);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    // Product endpoints
    @GetMapping("/products")
    public ResponseEntity<Object> getProducts() {
        try {
            List<Product> result = productService.getProducts();
            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, result);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable("id") long id) {
        try {
            Product result = productService.getProduct(id);
            if (result != null) {
                return new ResponseHandler().generateResponse("Success", HttpStatus.OK, result);
            }
            return new ResponseHandler().generateResponse("Product not found", HttpStatus.NOT_FOUND, null);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Object> saveProduct(@RequestBody Product product) {
        try {
            Product result = productService.saveProduct(product);
            return new ResponseHandler().generateResponse("Success", HttpStatus.CREATED, result);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    // Sale endpoints
    @GetMapping("/sales")
    public ResponseEntity<Object> getSales() {
        try {
            List<Sale> result = saleService.getSales();
            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, result);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/sales/{id}")
    public ResponseEntity<Object> getSale(@PathVariable("id") long id) {
        try {
            Sale result = saleService.getSale(id);
            if (result != null) {
                return new ResponseHandler().generateResponse("Success", HttpStatus.OK, result);
            }
            return new ResponseHandler().generateResponse("Sale not found", HttpStatus.NOT_FOUND, null);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping("/sales")
    public ResponseEntity<Object> saveSale(@RequestBody Sale sale) {
        try {
            Sale result = saleService.saveSale(sale);
            return new ResponseHandler().generateResponse("Success", HttpStatus.CREATED, result);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    // SaleItem endpoints
    @GetMapping("/sale-items")
    public ResponseEntity<Object> getSaleItems() {
        try {
            List<SaleItem> result = saleItemService.getSaleItems();
            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, result);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/sale-items/{id}")
    public ResponseEntity<Object> getSaleItem(@PathVariable("id") long id) {
        try {
            SaleItem result = saleItemService.getSaleItem(id);
            if (result != null) {
                return new ResponseHandler().generateResponse("Success", HttpStatus.OK, result);
            }
            return new ResponseHandler().generateResponse("SaleItem not found", HttpStatus.NOT_FOUND, null);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping("/sale-items")
    public ResponseEntity<Object> saveSaleItem(@RequestBody SaleItem saleItem) {
        try {
            SaleItem result = saleItemService.saveSaleItem(saleItem);
            return new ResponseHandler().generateResponse("Success", HttpStatus.CREATED, result);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
