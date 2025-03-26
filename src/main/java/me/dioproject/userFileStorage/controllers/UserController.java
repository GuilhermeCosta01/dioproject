package me.dioproject.userFileStorage.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.dioproject.userFileStorage.entities.UserEntity;
import me.dioproject.userFileStorage.repositories.FileRepository;
import me.dioproject.userFileStorage.repositories.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository UserRepository;
	
	@Autowired
	private FileRepository FileRepository;
	
	@PostMapping("/criar")
	public ResponseEntity<UserEntity> criar(@RequestBody UserEntity userr){
		UserEntity usuarioSalvo = UserRepository.save(userr);
		userr.setUserPassword(DigestUtils.md5DigestAsHex(userr.getUserPassword().getBytes()));
		return ResponseEntity.ok(usuarioSalvo);
		
	}
	

	  @GetMapping("/buscar/{id}")
	  public ResponseEntity<?> buscar(@PathVariable Long id) {
	      return UserRepository.findById(id)
	              .map(ResponseEntity::ok)
	              .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	  }
	  
		
	@GetMapping("/listar")
	public List<UserEntity> listar(){
		return UserRepository.findAll();
	
	}
	@DeleteMapping("deletar/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id){
		Optional<UserEntity> usuario = UserRepository.findById(id);
		
		if(usuario.isPresent()) {
			UserRepository.deleteById(id);
			
			return ResponseEntity.ok("Usuário e arquivos deletados com sucesso!");
			
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
    
	}
	
}
