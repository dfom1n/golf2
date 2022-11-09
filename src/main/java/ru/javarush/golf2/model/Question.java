package ru.javarush.golf2.model;

import java.util.List;

public class Question {
    private String text;
    private Integer current;
    private List<Answer> answerList;

    public Question(String text, Integer current, List<Answer> answerList) {
        this.text = text;
        this.current = current;
        this.answerList = answerList;
    }

    public String getText() {
        return text;
    }

    public Integer getCurrent() {
        return current;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }
}