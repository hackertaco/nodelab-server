package nodelab.backend.spring.domain.study;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import nodelab.backend.spring.domain.shared.BaseTimeEntity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Study extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private State state;
    @Column(nullable = false)
    private String title;
    @Column
    private String imgUrl;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(nullable = false)
    private LocalDate startDay;
    @Column(nullable = false)
    private LocalDate endDay;
    @Column(nullable = false)
    private int peopleLimit;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StudyDivision division;
    @Column
    private LocalDateTime deletedAt;
    @Column(nullable = false)
    private String introductionTitle;
    @Column(nullable = false)
    private String introductionContent;
}
