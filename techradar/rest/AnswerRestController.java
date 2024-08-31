package t1.debute.techradar.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import t1.debute.techradar.rest.dto.AnswerDTO;
import t1.debute.techradar.service.AnswerService;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5174")
@RequiredArgsConstructor
@Slf4j
public class AnswerRestController {

    @Autowired
    AnswerService service;

    @PostMapping("/answer")
    public void sendAnswer(@RequestBody List<AnswerDTO> answerDTO){
        log.info("createAnswer" + answerDTO);
        answerDTO.stream().forEach(el -> service.createNewAnswer(el.getQuestion_id(), el.getAnswer()));

    }
    @DeleteMapping("/answer")
    public void deleteAnswer(@RequestBody AnswerDTO answerDTO){
        service.deleteAnswer(answerDTO.getId());
    }
    @GetMapping("/answer")
    public List<AnswerDTO> getListOfAnswers(@RequestParam (name = "id",required = false) Long id){
        if(id!=null)return service.getListOfAnswersByQuestionId(id);
        else return service.getAllAnswers();
    }


}
