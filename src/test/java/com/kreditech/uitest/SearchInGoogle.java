package com.kreditech.uitest;

import com.kreditech.uipack.socialpages.GooglePage;
import com.kreditech.uipack.socialpages.GoogleResultsPage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

/**
 * Created by pc on 30.07.2017.
 */
public class SearchInGoogle extends BaseTest{

    @Test
    @Description("Test can search in google.com by company name")
    public void testCanSearchInGoogle() {
        GooglePage searchPage = new GooglePage();
        GoogleResultsPage resultsPage = searchPage.searchByKey("kreditech");
        resultsPage.clickRelevantResultByKey("www.kreditech.com");
    }
}
