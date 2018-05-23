package com.assignment;

import java.util.List;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Web_Crawler4 {
	
	public static void web_crawling(String keyword,int page_no) throws Exception {
		String url = "http://www.shopping.com/products?KW="+keyword;
		Document doc = Jsoup.connect(url).get();
		List<Element> elements = doc.getElementsByClass("quickLookGridItemFullName hide");
		for(Element e : elements) {
			System.out.println(e.text());
		}
	}
	
	public static void web_crawling(String keyword) throws Exception {
		String url = "http://www.shopping.com/products?KW="+keyword;
		Document doc = Jsoup.connect(url).get();
		Elements e1 = doc.getElementsByClass("numTotalResults");
		//System.out.println(e1.text());
		String str = e1.text();
		String str1[] = str.split(" ");
		System.out.println(str1[3]);
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter keyword : ");
		String keyword = sc.next();
		int page_no = -1;
		System.out.println("Enter page_no(y/n) : ");
		String ans = sc.next();
		
		if(ans.equals("N")||ans.equals("n")) {
			web_crawling(keyword);
		}
		else if(ans.equals("Y")||ans.equals("y"))
		{	System.out.println("Page_No : ");
			page_no = sc.nextInt();
			web_crawling(keyword,page_no);
		}
			
		
		
	}

}
