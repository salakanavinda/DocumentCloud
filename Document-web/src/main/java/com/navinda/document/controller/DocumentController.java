package com.navinda.document.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.navinda.document.model.Document;
import com.navinda.document.model.Paragraph;
import com.navinda.document.services.DocumentException;
import com.navinda.document.services.DocumentService;

@RestController
@RequestMapping(value="/documentcloud")
public class DocumentController {
	@Autowired
	DocumentService documentService;
	
	@RequestMapping(value="/document", method= RequestMethod.POST)
	public ResponseEntity<Document> save(@RequestBody Document document) {
		try {
			Document documentOne = documentService.save(document);
			return ResponseEntity.ok(documentOne);
		}catch (DocumentException ed) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	@RequestMapping(value="/document",method=RequestMethod.GET)
	public List<Document> fetch(){
		return documentService.fetch();
	}
	
	@RequestMapping(value="/document/{id}",method=RequestMethod.GET)
	public ResponseEntity<Document> fetch(@PathVariable Integer id){
		if(id<=0) {
			return ResponseEntity.badRequest().build();
		}else {
			Document document = documentService.fetch(id);
			if(document==null) {
				return ResponseEntity.notFound().build();
			}else {
				return ResponseEntity.ok(document);
			}
		}
	}
   
}
