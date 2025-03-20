package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.HomePage;
import com.qa.opencart.factory.PlaywrightFactory;

public class HomePageTest {
	PlaywrightFactory pf;
Page page;
HomePage homePage;
@BeforeTest
public void setup() {
	pf = new PlaywrightFactory();
	page = pf.initBrowser("chromium");
	homePage = new HomePage(page);
}

@Test
public void homePageTitleTest() {
	String actualTitle =homePage.getHomePageTitle();
	Assert.assertEquals(actualTitle, "Your Store");
}

@Test
public void homePageURLTest() {
	String actualURL = homePage.getHomePageTitle();
	System.out.println(actualURL);
	Assert.assertEquals(actualURL, "https://naveenautomationlabs.com/opencart/");
}

@Test
public void searchTest() {
	String actualSearchHeader = homePage.doSearch("Macbook");
	Assert.assertEquals(actualSearchHeader, "Search - Macbook");
}

@AfterTest
public void tearDown() {
	page.context().browser().close();
}
}
