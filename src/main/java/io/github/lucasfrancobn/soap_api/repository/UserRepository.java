package io.github.lucasfrancobn.soap_api.repository;

import io.github.lucasfrancobn.soap_api.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
