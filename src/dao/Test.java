package dao;

import bean.Hero;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Hero> list=new HeroDAO().getAllHeros();
        for (Hero hero : list) {
            System.out.println(hero.toString());
        }
    }
}
