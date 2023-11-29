package nodelab.backend.ndlab.domain.post;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nodelab.backend.ndlab.domain.shared.BaseTimeEntity;
import nodelab.backend.ndlab.domain.study.Study;
import nodelab.backend.ndlab.domain.user.User;

@Entity
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudyInquery extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studyId")
    private Study study;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
    private StudyInquery parentId;

    @Column(nullable = false)
    private Boolean isSecret;

    @Column
    private LocalDateTime deletedAt;
}
