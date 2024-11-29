package edu.uptc.example.repository;

import edu.uptc.example.entityes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query; 

import java.util.Optional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    
    @Query("SELECT u FROM User u WHERE u.name LIKE CONCAT('%', :name, '%')")
    public List<User> findByName(String name);

    
    @Query("SELECT u FROM User u WHERE u.email = :email")
    public Optional<User> findByEmail(String email);
}
