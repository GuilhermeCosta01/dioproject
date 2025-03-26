package me.dioproject.userFileStorage.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data	
@Entity

public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(nullable=false)
	private String userName;
	
	@Column(unique=true,nullable=false)
	private String email;
	
	@Column(nullable=false)
	private String userPassword;
	
	@Enumerated(EnumType.STRING)
	private Plan plan;
	
	//@OneToMany(mappedBy = "user", cascade =CascadeType.ALL )
	//private List<FileEntity> files= new ArrayList<>();
	
	// Método para obter a lista de arquivos
   // public List<FileEntity> getFiles() {
      //  return files;
 //  }
   }

