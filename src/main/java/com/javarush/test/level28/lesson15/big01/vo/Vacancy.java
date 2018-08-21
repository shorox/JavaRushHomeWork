package com.javarush.test.level28.lesson15.big01.vo;

/**
 * Created by sharov on 24.12.2015.
 */
public class Vacancy {
    private String title;           // Название
    private String salary;          // Зарплата
    private String city;            // Город
    private String companyName;     // Название компании
    private String siteName;        // Название сайта, на котором вакансия найдена
    private String url;             // Ссылка на вакансию.

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int hashCode() {
        return this.title.hashCode() + 31 * this.url.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        Vacancy v = (Vacancy) obj;
        return this.hashCode() == v.hashCode() ?
                v.getTitle().equals(this.getTitle()) &&
                        v.getSalary().equals(this.salary) &&
                        v.getCity().equals(this.city) &&
                        v.getCompanyName().equals(this.companyName) &&
                        v.getSiteName().equals(this.siteName) &&
                        v.getUrl().equals(this.url) : false;
    }
}
