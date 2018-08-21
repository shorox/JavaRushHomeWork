package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharov on 28.12.2015.
 */
public class MoikrugStrategy implements Strategy {
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?page=%d&q=java+%s";

    @Override
    public List<Vacancy> getVacancies(String searchString) throws IOException {
        List<Vacancy> list = new ArrayList<>();
        int page = 1;
        Document doc;
        while(true) {
            doc = getDocument(searchString, page++);
            Elements elements = doc.getElementsByClass("job");
            if(elements.isEmpty()) break;
            for (Element element : elements) {
                Vacancy vacancy = new Vacancy();
                vacancy.setTitle(element.getElementsByAttributeValue("class", "title").attr("title"));
                vacancy.setSalary(element.getElementsByAttributeValue("class", "salary").text());
                vacancy.setCity(element.getElementsByAttributeValue("class", "location").text());
                vacancy.setCompanyName(element.getElementsByAttributeValue("class", "company_name").first().getElementsByTag("a").text());
                vacancy.setSiteName(doc.title());
                vacancy.setUrl(element.getElementsByClass("title").first().child(0).attr("abs:href"));
                list.add(vacancy);
            }
        }
        return list;
    }

    protected Document getDocument(String searchString, int page) throws IOException{
        return Jsoup.connect(String.format(URL_FORMAT, page, searchString))
                .userAgent("Mozilla/5.0")
                .referrer("")
                .get();
    }

}
