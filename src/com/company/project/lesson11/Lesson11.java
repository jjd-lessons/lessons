package com.company.project.lesson11;

public class Lesson11 {
    public static void main(String[] args) {
        Point point01 = new Point(2, 8);
        Point point02 = new Point(2, 8);

        System.out.println(point01.toString());

        System.out.println(point01 == point02);
        System.out.println(point01.equals(point02));

        Point pointCopy = point01.clone();
        System.out.println(point01 == pointCopy); // false
        System.out.println(point01.equals(pointCopy)); // true

        Figure figure01 = new Figure(2);
        Figure figure02 = new Figure(2);
        figure01.addPoint(point01);
        figure01.addPoint(point02);

        figure02.addPoint(point01);
        figure02.addPoint(point02);

        System.out.println(figure01.equals(figure02));

        Country country = Country.UK;
        Article article01 = new Article(country);
        Article article02 = new Article(Country.UK);

        System.out.println(country == article02.getCountry());

        // [USA, UK, BRAZIL]
        Country[] countries = Country.values();
        int index = Country.UK.ordinal(); // 1
        String name01 = Country.UK.name(); // "UK"
        String name02 = Country.UK.toString(); // "UK"
        Country uk = Country.valueOf("UK");
    }
}
