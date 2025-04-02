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
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade =CascadeType.ALL )
	private List<FileEntity> files= new ArrayList<>();

	// Método para obter a lista de arquivos
    public List<FileEntity> getFiles() {
        return files;
   }
	
	public void setFiles(List<FileEntity> files) {
		this.files = files;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	
   }

