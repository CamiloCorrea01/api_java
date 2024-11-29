package edu.uptc.example.entityes;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(nullable = false, length = 100)
    private String name;
    
    @Column(nullable = false)
    private int stock;

    // Relación con la clase User
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Métodos para agregar y actualizar el stock
    public void addProduct() {
        // Lógica para agregar producto
    }

    public void updateStock() {
        // Lógica para actualizar stock
    }

    public void readProduct() {
        // Lógica para leer producto
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
