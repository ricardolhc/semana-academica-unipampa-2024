package com.codefolio.backend.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.codefolio.backend.entidade.Usuario;

@Controller
public class UsuarioControlador {

    private List<Usuario> usuarios = new ArrayList<>();

    @CrossOrigin(origins = "*")
    @PostMapping("/usuarios/cadastro")
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario request) {
        if (request.getEmail() == null || request.getEmail().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(request.getEmail())) {
                return ResponseEntity.badRequest().build();
            }
        }

        usuarios.add(request);
        return ResponseEntity.ok(request);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/usuarios/listar")
    public ResponseEntity<List<Usuario>> listar() {
        return ResponseEntity.ok(usuarios);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/usuarios/{email}")
    public ResponseEntity<Usuario> buscarPorEmail(@PathVariable("email") String email) {
        if (email.isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return ResponseEntity.ok(usuario);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{email}")
    public ResponseEntity<Usuario> deletarPorEmail(@PathVariable("email") String email) {
        if (email.isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                usuarios.remove(usuario);
                return ResponseEntity.ok(usuario);
            }
        }
        return ResponseEntity.notFound().build();
    }
    
}
