package com.example.Quiz2;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    // Endpoint for creating a new quiz
    @PostMapping
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        Quiz createdQuiz = quizService.createQuiz(quiz);
        return ResponseEntity.ok(createdQuiz);
    }

    // Endpoint for retrieving quiz details
    @GetMapping("{quizId}")
    public ResponseEntity<Quiz> getQuiz(@PathVariable Long quizId) {
        Optional<Quiz> quizOptional = quizService.getQuizById(quizId);
        if (quizOptional.isPresent()) {
            Quiz quiz = quizOptional.get();
            return ResponseEntity.ok(quiz);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @Autowired
    private QuizRepository quizRepository;
    @GetMapping
    public List<Quiz> list() {
        return quizRepository.findAll();
    }

}

