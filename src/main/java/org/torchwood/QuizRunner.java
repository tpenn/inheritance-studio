package org.torchwood;

import java.util.ArrayList;
import java.util.Scanner;

public class QuizRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Question> quizQuestions = new ArrayList<>();

        quizQuestions.add(new MultipleChoice("Which programming language is used for Android app development?",
                new ArrayList<>() {{
                    add("Java");
                    add("Python");
                    add("C++");
                    add("Ada");
                }}, 1, 1.0));

        quizQuestions.add(new Checkbox("Select the primary colors:",
                new ArrayList<>() {{ add("Purple"); add("Red"); add("Green"); add("Blue"); add("Orange"); add("Yellow"); }},
                new ArrayList<>() {{ add(2); add(4); add(6); }}, 2.0));

        quizQuestions.add(new TrueFalse("Java is an interpreted language.", 0, 1.0));

//        // Create short answer question
//        quizQuestions.add(new ShortAnswer("What is 2 + 2?", 4, 1.0));
//
//        // Create linear scale question
//        quizQuestions.add(new LinearScale("Rate your programming skills from 1 (novice) to 5 (expert):", 1, 5, 1.0));
//
//        // Create paragraph question
//        quizQuestions.add(new Paragraph("Explain your favorite programming concept (up to 500 characters):", 500, 1.0));

        // Run the quiz
        double totalPoints = 0.0;
        double userScore = 0.0;

        System.out.println("Welcome to the Quiz!");
        for (Question question : quizQuestions) {
            System.out.println("\nQuestion ID: " + question.getID());
            System.out.println(question.getQuestionText());
            System.out.println(question.getPossibleAnswerText());

            String userAnswer;
            boolean isValidResponse;

            do {
                System.out.print("Your answer: ");
                userAnswer = scanner.nextLine();
                isValidResponse = question.isValidResponse(userAnswer);

                if (!isValidResponse) {
                    System.out.println("Invalid response. Please try again.");
                }
            } while (!isValidResponse);

            System.out.println("Your answer is valid.");

            if (question.isCorrect(userAnswer)) {
                System.out.println("Correct! You earned " + question.getPointValue() + " points.");
                userScore += question.getPointValue();
            } else {
                System.out.println("Incorrect. The correct answer(s) is/are: " + question.getCorrectAnswerText());
            }

            totalPoints += question.getPointValue();
        }

        System.out.println("\nQuiz completed!");
        System.out.println("Your total score: " + userScore + " out of " + totalPoints);
        scanner.close();
    }
}
