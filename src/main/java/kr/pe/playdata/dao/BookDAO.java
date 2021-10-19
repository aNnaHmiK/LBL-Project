package kr.pe.playdata.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import kr.pe.playdata.model.domain.Book;

public interface BookDAO extends CrudRepository<Book, Long> {
	
	//동일한 단어 검색
	List<Book> findBookByTitle(String title);
	List<Book> findBookByWriter(String writer);
	
	//특정 단어 포함된것 검색
	List<Book> findBookByTitleContaining(String title);
	List<Book> findBookByWriterContaining(String writer);
	List<Book> findBookByCategoryContaining(String category);
	List<Book> findBookByPublisherContaining(String publisher);
	
	
	
}
