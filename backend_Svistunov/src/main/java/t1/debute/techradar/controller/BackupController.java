package t1.debute.techradar.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import t1.debute.techradar.repository.TechRadarRepository;

@Controller
public class BackupController {
    @Autowired
    TechRadarRepository techRadarRepository;
    @RequestMapping(method = RequestMethod.GET , value = "/backup")
    public void makeABackup(){
        java.time.LocalDate dateTime = java.time.LocalDate.now();
        techRadarRepository.backupDB(dateTime.toString() + ".zip" );

    }
}
