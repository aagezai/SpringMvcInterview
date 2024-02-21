package com.InterviewCompleteJavaSpring.designPattern.ObservableDesignPattern;

import java.util.Observable;
import java.util.Observer;

// Subject (Observable) class
class NewsAgency extends Observable {
    private String news;

    public void setNews(String news) {
        this.news = news;
        setChanged();
        notifyObservers(news);
    }
}

// Observer class
class NewsChannel implements Observer {
    private String news;

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof NewsAgency) {
            this.news = (String) arg;
            display();
        }
    }

    public void display() {
        System.out.println("News Channel received news: " + news);
    }
}

// Example usage
public class ObserverPatternExample {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();
        NewsChannel newsChannel1 = new NewsChannel();
        NewsChannel newsChannel2 = new NewsChannel();

        // Registering observers
        newsAgency.addObserver(newsChannel1);
        newsAgency.addObserver(newsChannel2);

        // Setting news in the subject (Observable)
        newsAgency.setNews("Breaking News: Observer pattern works!");
    }
}
