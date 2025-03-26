package me.dioproject.userFileStorage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dioproject.userFileStorage.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
