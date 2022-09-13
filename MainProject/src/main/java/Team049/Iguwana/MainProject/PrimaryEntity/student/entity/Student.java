package Team049.Iguwana.MainProject.PrimaryEntity.student.entity;

import Team049.Iguwana.MainProject.PrimaryEntity.review.entity.Review;
import Team049.Iguwana.MainProject.PrimaryEntity.tutoring.entity.Tutoring;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;

    @Column
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(columnDefinition = "Text")
    private String aboutMe;

    @Column
    private String roles;

    @OneToMany(mappedBy = "student")
    private List<Tutoring> tutoringList = new ArrayList<>();

    @OneToMany(mappedBy = "student")
    private List<Review> reviewList = new ArrayList<>();

    public void addTutoring(Tutoring tutoring){
        this.tutoringList.add(tutoring);
        if(tutoring.getStudent() != this){
            tutoring.setStudent(this);
        }
    }

    public void addReview(Review review){
        this.reviewList.add(review);
        if(review.getStudent() != this){
            review.setStudent(this);
        }
    }

    public List<String> getRoleList() {
        if(this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }
}
