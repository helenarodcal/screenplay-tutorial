package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchResultsPage {

//    public static final Target SEARCH_RESULTS_HEADING
//            = Target.the("Search results heading").located(By.cssSelector("h1.hero-headline"));
    public static final Target SEARCH_RESULTS_HEADING
            = Target.the("Search results heading").located(By.xpath("//h1[@class='hero-headline']"));

    public static final Target ARTICLE_HEADINGS
            = Target.the("Articles headings").locatedBy(".search-results h2.h3");

    public static final Target ARTICLE_ABSTRACTS
            = Target.the("Articles abstracts").locatedBy(".search-results p");
}
