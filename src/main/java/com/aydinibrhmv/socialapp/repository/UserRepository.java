package com.aydinibrhmv.socialapp.repository;

import com.aydinibrhmv.socialapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
