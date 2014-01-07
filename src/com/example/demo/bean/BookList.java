package com.example.demo.bean;

import java.util.ArrayList;
import java.util.List;

public class BookList
{
	private int total;
	private int start;
	private int count;
	private List<Book> bookList = new ArrayList<Book>();
	
	public int getTotal()
	{
		return total;
	}
	public void setTotal(int total)
	{
		this.total = total;
	}
	public int getStart()
	{
		return start;
	}
	public void setStart(int start)
	{
		this.start = start;
	}
	public int getCount()
	{
		return count;
	}
	public void setCount(int count)
	{
		this.count = count;
	}
	public List<Book> getBookList()
	{
		return bookList;
	}
	public void setBookList(List<Book> bookList)
	{
		this.bookList = bookList;
	}
	
	public static BookList parse()
	{
		BookList bookList = new BookList();
		return bookList;
	}
	
	
}
