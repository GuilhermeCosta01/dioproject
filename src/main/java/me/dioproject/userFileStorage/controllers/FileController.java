package me.dioproject.userFileStorage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.dioproject.userFileStorage.entities.FileEntity;
import me.dioproject.userFileStorage.entities.UserEntity;
import me.dioproject.userFileStorage.repositories.FileRepository;
import me.dioproject.userFileStorage.repositories.UserRepository;

@RestController
@RequestMapping("/file")
public class FileController {

	@Autowired
	public FileRepository FileRepository;
	
	@Autowired
	public UserRepository UserRepository;
	
	
	@PostMapping("/incluir")
    public ResponseEntity<FileEntity> incluirFile(@RequestBody FileEntity file,
    											  @RequestParam ("userId")Long userId) {
        
		UserEntity user = UserRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
		
		  file.setUser(user);
		
		FileEntity arquivoSalvo = FileRepository.save(file);
             return ResponseEntity.ok(arquivoSalvo);
    }

	@GetMapping("/listar/{userId}")
    public ResponseEntity<List<FileEntity>> listarArquivosPorUsuario(@PathVariable Long userId) {
        // Busca o usuário pelo ID
        UserEntity user = UserRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        
        // Usando o método findByUser para obter os arquivos relacionados ao usuário
        List<FileEntity> arquivos = FileRepository.findByUser(user);
        
        return ResponseEntity.ok(arquivos);
    }

	
	@GetMapping("/listar")
	public ResponseEntity <List <FileEntity>> listarFile(){
	
	return ResponseEntity.ok(FileRepository.findAll());
	}

	@DeleteMapping("/excluir/{fileId}")
	public ResponseEntity<String> excluirArquivo(@PathVariable Long fileId) {
   
    FileEntity file = FileRepository.findById(fileId)
            .orElseThrow(() -> new RuntimeException("Arquivo não encontrado"));
    
    FileRepository.delete(file);
    
    return ResponseEntity.ok("Arquivo excluído com sucesso");
	}

}
