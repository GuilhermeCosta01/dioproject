package me.dioproject.userFileStorage.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class FileEntity {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long fileId;
	
	@NotBlank
	@Column(unique=true)
	private String Filename;
	
	private String fileDescription;
	
	@ManyToOne()
	private UserEntity user;

	}
