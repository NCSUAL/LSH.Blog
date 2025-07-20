package com.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.domain.Image;

public interface ImageRepository extends JpaRepository<Image, Long>{

    Optional<Image> findByEncryptName(final String encryptName);
} 