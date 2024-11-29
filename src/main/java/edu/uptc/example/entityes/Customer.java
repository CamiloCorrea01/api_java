package edu.uptc.example.entityes;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(nullable = false, length = 100)
    private String name;
    
    @Column(nullable = false, length = 100, unique = true)
    private String email;

    // Relación con la clase User
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Métodos para agregar, eliminar y leer un cliente
    public void addCustomer() {
        // Lógica para agregar cliente
    }

    public void deleteCustomer() {
        // Lógica para eliminar cliente
    }

    public void readCustomer() {
        // Lógica para leer cliente
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
