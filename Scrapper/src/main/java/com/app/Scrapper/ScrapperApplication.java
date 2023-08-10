package com.app.Scrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class ScrapperApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScrapperApplication.class, args);
		try{
			scrap();
		}catch (Exception e){
			System.out.println(""+e.getMessage());
		}
	}

	public static void scrap() throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter you search keywork: ");
		String searchWord=scan.nextLine();
		String url="https://www.google.com/search?"+"q="+searchWord;
		Document doc = Jsoup.connect(url).get();
		String html = doc.html();
		System.out.println(html);
	}
}
