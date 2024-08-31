package t1.debute.techradar.rest.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TechListDTO {
    private String date;
    private List<TechDTO> entries;

}
