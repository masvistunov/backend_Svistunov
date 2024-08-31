package t1.debute.techradar.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import t1.debute.techradar.entity.Tech;
import t1.debute.techradar.rest.dto.TechListDTO;
import t1.debute.techradar.service.TechRadarService;

import java.time.LocalDate;

@RestController
@CrossOrigin("http://localhost:5174")
@RequiredArgsConstructor
@Slf4j
public class TechRadarRestController {
   @Autowired
    private TechRadarService techRadarService;

    @GetMapping("/tech/**")
    public TechListDTO findTeches( @RequestParam(name ="filter",required = false) String filter) throws Exception {
        return TechListDTO.builder().entries(techRadarService.findAllTeches(filter)).date(LocalDate.now().toString()).build();
    }
    @PostMapping(path = "/tech",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public void createTech(@AuthenticationPrincipal UserDetails userDetails, @Valid @RequestBody Tech payload, BindingResult bindingResult) throws BindException {
       // log.info("-------create Tech---------"+payload + "userD" + userDetails.getUsername() + " " + userDetails.getAuthorities());
            if (bindingResult.hasErrors()) {
                if (bindingResult instanceof BindException exception) {
                    throw exception;
                } else {
                    throw new BindException(bindingResult);
                }
            } else {

                techRadarService.createTech(payload.getQuadrant()
                        , payload.getRing(), payload.getLabel(), payload.getLink(), payload.isActive(), payload.getMoved(), payload.getDepartament(), payload.getDescription(),payload.getRank()
                );
            }

    }
    @PutMapping("/tech")
    public void uploadTech( @Valid @RequestBody Tech payload, BindingResult bindingResult) throws BindException{
        log.info("-------update Tech---------"+payload);
        if (bindingResult.hasErrors()) {
                if (bindingResult instanceof BindException exception) {
                    throw exception;
                } else {
                    throw new BindException(bindingResult);
                }
            } else {
                techRadarService.updateTech(payload.getId(), payload.getQuadrant()
                        , payload.getRing(), payload.getLabel(), payload.getLink(), payload.isActive(), payload.getMoved(), payload.getDepartament(), payload.getDescription(),payload.getRank());
            }
    }
    @DeleteMapping("/tech")
    public void deleteTech( @Valid @RequestBody Tech tech){
        log.info("-------delete Tech---------"+tech);
        if (tech.getId() != null) {
                techRadarService.deleteTech(tech.getId());
            } else {
                techRadarService.deleteTech(tech.getLabel());
            }
    }


}
