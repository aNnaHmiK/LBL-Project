package kr.pe.playdata.model.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
public class Book {
	
	@Id
	private Long seq;
	private String title;
	private String writer;
	private String category;
	private String publisher;
}
