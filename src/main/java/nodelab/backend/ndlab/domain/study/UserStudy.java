package nodelab.backend.ndlab.domain.study;

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
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import nodelab.backend.ndlab.domain.shared.BaseTimeEntity;
import nodelab.backend.ndlab.domain.user.Position;
import nodelab.backend.ndlab.domain.user.User;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserStudy extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;
    @Column(nullable = false)
    private boolean isOwner;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "studyId")
    private Study study;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Position position;
    @Column(nullable = false)
    private int achievementRate;
    @Column(nullable = false)
    private List<Category> interest;
    @Column(nullable = false)
    private String introduction;


    @Column
    private LocalDateTime deletedAt;
}
