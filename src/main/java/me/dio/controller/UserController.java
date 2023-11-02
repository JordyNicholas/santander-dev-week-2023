package me.dio.controller;

import jakarta.validation.Valid;
import me.dio.domain.model.User;
import me.dio.domain.repository.UserRepository;
import me.dio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}") //Pesquisa de um usuário
    public ResponseEntity<User> findById(@PathVariable Long id){
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping //Pesquisa de Todos os Usuários
    public ResponseEntity<Iterable<User>> findAllUsers(){
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @DeleteMapping("/{id}") //Deletar as informações do Usuário
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody User userToCreate){
        var userCreated = userService.create(userToCreate);
        URI location  = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(userCreated);
    }
}
