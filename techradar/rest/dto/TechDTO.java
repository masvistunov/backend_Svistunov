package t1.debute.techradar.rest.dto;

import lombok.Builder;
import lombok.Data;
import t1.debute.techradar.entity.Tech;

@Data
@Builder
public class TechDTO {
    private Integer id;
    private String  quadrant;
    private String ring;

    private String label;
    private String link;
    private boolean active;
    private String  moved;
    private String department;
    private String description;
    private int rank;

    static public TechDTO fromTech(Tech tech){

        return TechDTO.builder().active(tech.isActive()).rank(tech.getRank()).description(tech.getDescription()).label(tech.getLabel()).link(tech.getLink()).quadrant(tech.getQuadrant()).ring(tech.getRing()).moved(tech.getMoved()).department(tech.getDepartament()).id(tech.getId()).build();
    }

}
