package nodelab.backend.spring.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nodelab.backend.spring.domain.shared.BaseTimeEntity;
import nodelab.backend.spring.domain.study.Category;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Table(name = "users")
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nickname;
    @Column
    private String imgUrl;
    @Column
    private String introduction;
    @Column(nullable = false)
    private int level;
    @Column
    private List<Category> interest;
    @Column
    private Position position;
    @Column(nullable = false)
    private int avgAchievementRate;
    @Column
    private String githubUrl;
    @Column
    private LocalDateTime deletedAt;

}
