package services;

import entities.News;

public class NewsService implements INews{
    @Override
    public void display(News news) {
        System.out.println(news.getAuthor());
        System.out.println(news.getPublicDate());
        System.out.println(news.getRate());
        System.out.println(news.getTitle());
    }
}
