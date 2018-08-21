package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

/**
 * Created by sharov on 25.12.2015.
 */
public class HtmlView implements View {
    private Controller controller;

    private final String filePath = "./src/" + this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies) {
        try{
            updateFile(getUpdatedFileContent(vacancies));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Some exception occurred");
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() throws IOException {
        controller.onCitySelect("Dnepropetrovsk");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancyList) throws IOException{
        Document doc = getDocument();
        Element element = doc.getElementsByClass("template").first();
        Element template = element.clone();
        template.removeAttr("style");
        template.removeClass("template");
        doc.select("tr[class=vacancy]").remove();
        for (Vacancy vacancy : vacancyList) {
            Element newElement = template.clone();
            newElement.getElementsByClass("city").first().text(vacancy.getCity());
            newElement.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
            newElement.getElementsByClass("salary").first().text(vacancy.getSalary());
            newElement.getElementsByTag("a").attr("href", vacancy.getUrl()).first().text(vacancy.getTitle());
            element.before(newElement.outerHtml());
        }
        return doc.html();
    }

    private void updateFile(String file) throws IOException {
        PrintStream r = new PrintStream(new FileOutputStream(filePath));
        r.print(file);
        r.close();
    }

    protected Document getDocument() throws IOException{
        return Jsoup.parse(new File(filePath), "UTF-8");
    }
}
