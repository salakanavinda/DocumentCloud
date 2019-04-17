package com.navinda.document.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navinda.document.model.Document;

public interface DocumentRepository extends JpaRepository<Document,Integer>{

}
