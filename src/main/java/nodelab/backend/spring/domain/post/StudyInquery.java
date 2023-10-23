package nodelab.backend.spring.domain.post;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.NoArgsConstructor;
import nodelab.backend.spring.domain.study.Study;
import nodelab.backend.spring.domain.shared.BaseTimeEntity;
import nodelab.backend.spring.domain.user.User;

@Entity
@NoArgsConstructor
public class StudyInquery extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "studyId")
    private Study study;

    @Column(nullable = false)
    private String content;
    @Column
    @Enumerated(EnumType.STRING)
    private StudyInquery parentId;
    @Column(nullable = false)
    private Boolean isSecret;

    @Column
    private LocalDateTime deletedAt;
}
