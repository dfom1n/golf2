package ru.javarush.golf2.repository;

import ru.javarush.golf2.model.Answer;
import ru.javarush.golf2.model.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Repository {
    private List<Question> questionList;

    public Repository() {
        this.questionList = Arrays.asList(
                new Question("question1", 1, Arrays.asList(new Answer("otvet1", 2), new Answer("otvet2",3))),
                new Question("question2", 2, Arrays.asList(new Answer("otvet3", 3), new Answer("otvet2",4))),
                new Question("question3", 3, Arrays.asList(new Answer("otvet1", 2), new Answer("otvet2",3))),
                new Question("question4", 4, Arrays.asList(new Answer("otvet1", 2), new Answer("otvet2",3)))
        );
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public String getNextQuestion(int id){
        return questionList.stream()
                .filter(question -> question.getCurrent()==id)
                .findFirst()
                .get()
                .getText();
    }

    public List<Answer> getAnswersByQuestion(int id){
        return new ArrayList<>(questionList.stream()
                .filter(question -> question.getCurrent() == id)
                .findFirst()
                .get()
                .getAnswerList());
    }
}
