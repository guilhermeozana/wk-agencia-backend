package br.com.wkagencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wkagencia.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}