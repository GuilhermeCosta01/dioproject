package me.dioproject.userFileStorage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dioproject.userFileStorage.entities.FileEntity;

public interface FileRepository extends JpaRepository<FileEntity,Long> {

}
