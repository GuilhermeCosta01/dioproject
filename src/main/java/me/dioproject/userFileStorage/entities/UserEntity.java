package me.dioproject.userFileStorage.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity

public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@NotBlank
	@Column(nullable=false)
	private String userName;
	
	@NotBlank
	@Email
	@Column(unique=true,nullable=false)
	private String email;
	
	@NotBlank
	@Column(nullable=false)
	private String userPassword;
	

	@Enumerated(EnumType.STRING)
	private Plan plan;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade =CascadeType.ALL )
	private List<FileEntity> files= new ArrayList<>();

   }

