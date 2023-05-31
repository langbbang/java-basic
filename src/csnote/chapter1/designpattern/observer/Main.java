package csnote.chapter1.designpattern.observer;

public class Main {
    public static void main(String[] args) {
        Topic topic = new Topic();

        Observer observer1 = new TopicSubscriber("홍길동", topic);
        Observer observer2 = new TopicSubscriber("김철수", topic);
        Observer observer3 = new TopicSubscriber("김영희", topic);

        topic.register(observer1);
        topic.register(observer2);
        topic.register(observer3);

        topic.postMessage("I am a champion!!");
    }
}