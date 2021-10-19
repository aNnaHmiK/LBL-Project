package kr.pe.playdata.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.pe.playdata.dao.BookDAO;
import kr.pe.playdata.model.domain.Book;

@RestController
public class Controller {
	public Controller() {
		System.out.println("===컨트롤러 부분===");
	}
	@Autowired
	private BookDAO bookdao;
	
	//============ 책 정보 저장 =====================//
	@PostMapping("/save")
	public String data1(Long i) {
		System.out.println("===DB 저장 시도===");
		
		bookdao.save(new Book(i, "인어공주", "안데르센", "동화", "응애출판사"));
		bookdao.save(new Book(i+1, "성냥팔이 소녀", "안데르센", "동화", "응애출판사"));
		bookdao.save(new Book(i+2, "눈의여왕", "안데르센", "동화", "응애출판사"));
		bookdao.save(new Book(i+3, "서시", "윤동주", "시", "힘내출판사"));
		bookdao.save(new Book(i+4, "광야", "이육사", "시", "힘내출판사"));
		bookdao.save(new Book(i+5, "빼앗긴 들 에도 봄은 오는가", "안데르센", "시", "힘내출판사"));
		
		return "책 저장 성공" + i ;
	}
	
	@PostMapping("/addsave")
	public String addSave(@RequestBody Book data) {
		System.out.println("===저장 시도===");
		bookdao.save(data);
		return "책 추가 저장 완료";
	}
	
	//========= 책 배열 변경 ===========================//
		@PostMapping
		public List<Book> m1(String id){
			System.out.println("===배열 변경 시도===" + id);
			List<Book> all = new ArrayList<>();
			for(long i=0; i < 10; i++) {
				all.add(new Book(i, "인어공주" + i,
						"안데르센" + i,
						"동화" + i,
						"응애출판사"));
			}
			return all;
		}
	
	
	
	//========= 책 정보 수정 ============================//
	@PutMapping("/update")
	public String update(Long i) {	//========================String 으로 가야하는지 book으로 가야하는지 체크 필요 =====//
		System.out.println("===장르 수정 시도===");
		
		Book book = bookdao.findById(i).get();
		book.setCategory("동화");
		bookdao.save(book);
		
		return "장르 수정 완료" + book;
	}
	
	
	
	//========== 책 정보 삭제 ========================//
	@DeleteMapping("/delete")
	public String delete(Long seq) {
		System.out.println("===책 정보 삭제 시도=== " + seq);
		bookdao.deleteById(seq);
		return "삭제 완료";
	}
	
	//========== 책 전체 조회 ============================//
	@GetMapping("/selectall")
	public Iterable<Book> selectAll(){
		System.out.println("===전체 조회 시도===");
		Iterable<Book> all = bookdao.findAll();
		
		return all;
	}
	
	
	
	//========== 책 제목 조회 ==================================//
	@GetMapping("/selecttitle")
	public List<Book> selectTitle(@RequestParam String title){
		System.out.println("===제목 조회 시도===");
		List<Book> all = bookdao.findBookByTitleContaining(title);
		return all;
	}
	
	
}
