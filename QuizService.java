package com.example.Quiz2;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class QuizService {
    private final QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Quiz createQuiz(Quiz quiz) {
        Quiz createdQuiz = quizRepository.save(quiz);
        return createdQuiz;
    }

    public Optional<Quiz> getQuizById(Long quizId) {
        return quizRepository.findById(quizId);
    }

    public Quiz updateQuiz(Quiz quiz) {
        // Check if the quiz exists in the database
        if (!quizRepository.existsById(quiz.getId())) {
            throw new NoSuchElementException("Quiz not found");
        }
        
        Quiz updatedQuiz = quizRepository.save(quiz);
        return updatedQuiz;
    }

    public void deleteQuiz(Long quizId) {
        // Check if the quiz exists in the database
        if (!quizRepository.existsById(quizId)) {
            throw new NoSuchElementException("Quiz not found");
        }
        
        quizRepository.deleteById(quizId);
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

}

