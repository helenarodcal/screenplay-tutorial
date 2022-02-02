package serenitylabs.tutorials.trains.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.targets.TargetTextValues;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import serenitylabs.tutorials.trains.ui.SearchResultsPage;

public class TheSearchResults {
    public static TargetTextValues descriptions() {
        return TheTarget.textValuesOf(SearchResultsPage.ARTICLE_ABSTRACTS);
    }

    public static Question<String> firstArticleHeading() {
        return TheTarget.textOf(SearchResultsPage.FIRST_ARTICLE_HEADINGS);
    }
}
