package net.javagudes.springboot.repository;

import net.javagudes.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long> {
}
