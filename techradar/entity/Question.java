package t1.debute.techradar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "t_questionvariant",nullable = false)
    private int questionVariant;
    @Column(name = "t_description", nullable = false)
    private String description ;
    @Column(name = "t_category",nullable = false)
    private String category;
    @Column(name = "t_topic",nullable = false)
    private String topic;
    @Column(name = "t_active", nullable = false)
    private boolean active = false;

}
