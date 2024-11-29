package edu.uptc.example.service;

import edu.uptc.example.entityes.User;
import edu.uptc.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService() {}

    // Obtener todos los usuarios
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    // Obtener usuario por id
    public User getUser(Long id) {
        Optional<User> opt = userRepository.findById(id);
        return opt.isPresent() ? opt.get() : null;
    }

    // Guardar usuario
    public User save(User user) {
        return userRepository.save(user);
    }

    // Buscar usuario por nombre
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    // Buscar usuario por correo electrónico
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
