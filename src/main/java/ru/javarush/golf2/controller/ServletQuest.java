package ru.javarush.golf2.controller;

import ru.javarush.golf2.model.Answer;
import ru.javarush.golf2.model.Question;
import ru.javarush.golf2.repository.Repository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletQuest", value = "/ServletQuest")
public class ServletQuest extends HttpServlet {
    private Repository repository;

    @Override
    public void init() throws ServletException {
        repository = new Repository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id!= null){
            int i = Integer.parseInt(id);
            String nextQuestion = repository.getNextQuestion(i);
            List<Answer> answersByQuestion = repository.getAnswersByQuestion(i);
            request.setAttribute("question", nextQuestion);
            request.setAttribute("answers", answersByQuestion);
            request.getRequestDispatcher("quest.jsp").forward(request, response);
        }
//        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        else {
//            response.sendRedirect("quest.jsp");
//        }
    }
}
