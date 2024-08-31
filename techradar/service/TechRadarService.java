package t1.debute.techradar.service;

import jakarta.validation.constraints.NotNull;
import t1.debute.techradar.rest.dto.TechDTO;

import java.util.List;

public interface TechRadarService {
    List<TechDTO> findAllTeches(String filter);
    List<TechDTO>  findAllTechesByDepartment(String dep);
    TechDTO createTech(String quadrant, String ring, String label, String link, boolean active, String moved, @NotNull String departament, String description,int rank);
    void updateTech(Integer id , String quadrant, String ring, String label, String link, boolean active, String moved, @NotNull String departament,String description,int rank);
    void deleteTech(Integer id);
    void deleteTech(String label);
}
