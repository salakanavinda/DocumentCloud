package com.navinda.document.services;

import java.util.List;

import com.navinda.document.model.Document;

public interface DocumentService {
	
	Document save(Document document) throws DocumentException;
	List<Document> fetch();
	Document fetch(Integer id);
	

}
