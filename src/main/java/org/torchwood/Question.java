package org.example;

import java.util.ArrayList;

public abstract class Question {
    private static int nextID = 1;
    private final int ID;
    private String questionText;
    private ArrayList<String> answers;
    private double pointValue;

    public Question(String questionText, ArrayList<String> answers, double pointValue) {
        this.ID = nextID++;

        this.questionText = questionText;
        this.answers = answers;
        this.pointValue = pointValue;
    }


    public int getID() {
        return ID;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public double getPointValue() {
        return pointValue;
    }

    public void setPointValue(double pointValue) {
        this.pointValue = pointValue;
    }
}
