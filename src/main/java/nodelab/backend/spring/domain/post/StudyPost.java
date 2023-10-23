package nodelab.backend.spring.domain.post;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.NoArgsConstructor;
import nodelab.backend.spring.domain.study.Study;
import nodelab.backend.spring.domain.user.User;
import nodelab.backend.spring.domain.shared.BaseTimeEntity;

@Entity
@NoArgsConstructor
public class StudyPost extends BaseTimeEntity {
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
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private Boolean isNotice;

    @Column
    private LocalDateTime deletedAt;
}
