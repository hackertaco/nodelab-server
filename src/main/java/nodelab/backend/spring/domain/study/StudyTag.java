package nodelab.backend.spring.domain.study;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import nodelab.backend.spring.domain.shared.BaseTimeEntity;

@Entity
@Data
@NoArgsConstructor
public class StudyTag extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studyId")
    private Study study;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="tagId")
    private Tag tag;
}
