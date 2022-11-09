package ru.javarush.golf2.model;

public class Answer {
    private String text;
    private Integer next;

    public Answer(String text, int next) {
        this.text = text;
        this.next = next;
    }

    public String getText() {
        return text;
    }

    public int getNext() {
        return next;
    }
}
