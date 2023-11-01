package nodelab.backend.ndlab.domain.user;

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
import nodelab.backend.ndlab.domain.shared.BaseTimeEntity;

@Entity
@NoArgsConstructor
public class UserAccount extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;
    @Column(nullable = false)
    private String secret;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OAuthProvider provider;
    @Column
    private LocalDateTime deletedAt;
}
