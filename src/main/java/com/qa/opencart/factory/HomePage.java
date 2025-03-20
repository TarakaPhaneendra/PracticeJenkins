package com.qa.opencart.factory;

import com.microsoft.playwright.Page;

public class HomePage {
private Page page;

//1. String Locators  -  OR

private String search ="input[name='search']";
private String searchIcon = "div#search button";
private String searchPageHeader ="div#content h1";


//2. page constructor:
public HomePage(Page page) {
	this.page = page;
}

//3. page actions/methods:
public String getHomePageTitle() {
	String title = page.title();
	System.out.println("page title: " +title);
	return page.title();
}

public String getHomePageURL() {
	String url = page.url();
	System.out.println("page url : "+url);
	return page.url();
}

public String doSearch(String productName) {
	page.fill(search, productName);
	page.click(searchIcon);
	String header = page.textContent(searchPageHeader);
	System.out.println("search header: " +header);
	return header;
	
}
}
