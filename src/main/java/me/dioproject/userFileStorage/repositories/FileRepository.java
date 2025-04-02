package me.dioproject.userFileStorage.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



import me.dioproject.userFileStorage.entities.FileEntity;
import me.dioproject.userFileStorage.entities.UserEntity;

public interface FileRepository extends JpaRepository<FileEntity,Long> {

	 List<FileEntity> findByUser(UserEntity user);
}
