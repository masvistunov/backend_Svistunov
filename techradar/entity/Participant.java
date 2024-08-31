package t1.debute.techradar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_participant_id",nullable = false)
    private Long participant_id;
    @Column(name = "t_participant_name",nullable = false,unique = true)
    private String participant_name;
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;
}
