package t1.debute.techradar.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import t1.debute.techradar.rest.dto.QuestionDTO;
import t1.debute.techradar.service.QuestionService;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:5174")
@RequiredArgsConstructor
@Slf4j
public class QuestionRestController {
    @Autowired
    QuestionService questionService;
    @GetMapping("/question")
    public List<QuestionDTO> getListOfQuestions(@RequestParam(name ="filter",required = false) String filter) throws Exception{
      log.info("question_get");
        return questionService.getAllQuestion(filter);

    }
    @PostMapping("/question")
    public QuestionDTO createQuestion(@RequestBody QuestionDTO questionDTO){
        log.info("createQuestion " + questionDTO);
        return questionService.createNewQuestion(questionDTO.getDescription(),questionDTO.getQuestionVariant(),questionDTO.isActive(),questionDTO.getTopic(),questionDTO.getCategory());
    }
    @PutMapping("/question")
    public void updateQuestion (@RequestBody QuestionDTO questionDTO){
        log.info("updateQuestion" + questionDTO);
        questionService.updateQuestion(questionDTO.getId(),questionDTO.getDescription(),questionDTO.getQuestionVariant(),questionDTO.isActive(),questionDTO.getTopic(),questionDTO.getCategory());
    }
    @DeleteMapping("/question")
    public void deleteQuestion(@RequestBody QuestionDTO questionDTO){

        log.info("deleteQuestion ");
        questionService.deleteQuestion(questionDTO.getId());
    }
}
