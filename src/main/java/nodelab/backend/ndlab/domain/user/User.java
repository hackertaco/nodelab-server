package nodelab.backend.ndlab.domain.user;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nodelab.backend.ndlab.domain.post.Bookmark;
import nodelab.backend.ndlab.domain.shared.BaseTimeEntity;
import nodelab.backend.ndlab.domain.study.Category;

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
    @Column
    private String githubUrl;
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Bookmark> bookmarks = new ArrayList<>();
    @Column
    private LocalDateTime deletedAt;

}
