package com.navinda.document.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navinda.document.model.Card;
import com.navinda.document.model.Document;
import com.navinda.document.model.Page;
import com.navinda.document.model.Paragraph;
import com.navinda.document.model.Section;
import com.navinda.document.repository.DocumentRepository;

@Service
public class DocumentServiceImp implements DocumentService{

	@Autowired
	DocumentRepository documentRepository;
	@Override
	public Document save(Document document) throws DocumentException {
		
		//try {
			validateDocument(document.getId());
		//}catch (DocumentException ed) {
			//ed.printStackTrace();
			//throw new RuntimeException("Document Id is Exits",ed);
		//}
		/*for(Card card:document.getCards()) {
			card.setDocument(document);
			for(Section section:card.getSections()) {
				section.setCard(card);
				for(Page page:section.getPages()) {
					page.setSection(section);
					for(Paragraph paragraph:page.getParagraphs() ) {
						paragraph.setPage(page);
					}
				}
			}
		}*/
		return documentRepository.save(document);
	}
	public boolean validateDocument(Integer id) throws DocumentException {
		
		if(fetch(id)!=null) {
			throw new DocumentException("Document allready Exixts");
		}else {
			return true;
		}
	}

	@Override
	public List<Document> fetch() {
		
		return documentRepository.findAll();
	}

	@Override
	public Document fetch(Integer id) {
		
		Optional<Document> document = documentRepository.findById(id);
		
		//try {
			
			if(document.isPresent()) {
				return document.get();
			}
			
		//}catch (RuntimeException e) {
			//throw new RecordException("This document doesn't exits",e);
		//}
		
		
		return null;
	}
	

}
}
