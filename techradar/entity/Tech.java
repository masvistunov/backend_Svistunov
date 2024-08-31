package t1.debute.techradar.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_tech")
public class Tech {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "t_quadrant",nullable = false)
    @Size(max=15)
    private String  quadrant;
    @Column(name = "t_ring",nullable = false)
    @Size(max = 15)
    private String ring;
    @Column(name = "t_label", unique = true,nullable = false    )
    @Size(max = 50)
    private String label;
    @Column(name = "t_link")
    @Size(max = 1000)
    private String link;
    @Column(name = "t_active",nullable = false)
    private boolean active;
    @Column(name = "t_moved",nullable = false)
    @Size(max = 15)
    private String  moved;
    @Column(name = "t_departament",nullable = false)
    @Size(max = 15)
    private String departament;
    @Column(name = "t_description")
    @Size(max = 2000)
    private String description;
    @Column(name = "t_rank")
    private Integer rank;



}
