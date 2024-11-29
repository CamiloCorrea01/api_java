package edu.uptc.example.entityes;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "sale_items")
public class SaleItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(nullable = false)
    private int quantity;
    
    @Column(nullable = false)
    private double subtotal;

    // Relación con la clase Sale
    @ManyToOne
    @JoinColumn(name = "sale_id", nullable = false)
    private Sale sale;

    // Relación con la clase Product
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    // Método para calcular el subtotal
    public void calculateSubtotal() {
        this.subtotal = product.getStock() * quantity;  // Ejemplo, la lógica puede cambiar según lo que necesites
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
