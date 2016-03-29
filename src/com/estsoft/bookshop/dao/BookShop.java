package com.estsoft.bookshop.dao;

import java.util.List;
import java.util.Scanner;

import com.estsoft.bookshop.vo.BookVo;

public class BookShop {
public static void main(String[] args){

	
	Scanner scanner = new Scanner(System.in);
	System.out.println("대여할 책번호를 입력하시오");
	int no = scanner.nextInt();
	
	BookVo bookVo = new BookVo();
	bookVo.setNo((long)no);
	bookVo.setState("rent");
	new BookDao().updateState(bookVo);
	
	scanner.close();
	printBookList();
}
public static void printBookList(){
	BookDao bookDAO = new BookDao();
	List<BookVo> list = bookDAO.getList();
	System.out.println("*****도서 정보 출력하기*****");
	for(BookVo bookVo : list){
		System.out.println("책 제목:"+bookVo.getTitle()+", 작가:"+bookVo.getAuthorName()+", 대여 유무:"+bookVo.getState());
	}
}
}
