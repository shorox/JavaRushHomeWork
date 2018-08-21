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
 * Created by sharov on 24.12.2015.
 */
public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) throws IOException {
        List<Vacancy> list = new ArrayList<>();
        int page = 0;
        Document doc;
        while(true) {
            doc = getDocument(searchString, page++);
            Elements elements = doc.select("[data-qa=vacancy-serp__vacancy]");
            if(elements.size() == 0) break;
            for (Element element : elements) {
                Vacancy vacancy = new Vacancy();
                vacancy.setTitle(element.select("[data-qa=vacancy-serp__vacancy-title]").text());
                vacancy.setSalary(element.select("[data-qa=vacancy-serp__vacancy-compensation]").text());
                vacancy.setCity(element.select("[data-qa=vacancy-serp__vacancy-address]").text());
                vacancy.setCompanyName(element.select("[data-qa=vacancy-serp__vacancy-employer]").text());
                vacancy.setSiteName(doc.title());
                vacancy.setUrl(element.select("[data-qa=vacancy-serp__vacancy-title]").attr("href"));
                list.add(vacancy);
            }
        }
        return list;
    }

    protected Document getDocument(String searchString, int page) throws IOException{
        return Jsoup.connect(String.format(URL_FORMAT, searchString, page))
                .userAgent("Mozilla/5.0")
                .referrer("com/javarush/test")
                .timeout(5000)
                .get();
    }
}
