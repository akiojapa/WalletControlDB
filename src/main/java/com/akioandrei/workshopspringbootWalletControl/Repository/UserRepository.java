package com.akioandrei.workshopspringbootWalletControl.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akioandrei.workshopspringbootWalletControl.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
