package nodelab.backend.ndlab.global.config;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import nodelab.backend.ndlab.domain.study.Category;
import nodelab.backend.ndlab.domain.user.Position;
import nodelab.backend.ndlab.domain.user.User;
import nodelab.backend.ndlab.domain.user.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseInit implements ApplicationRunner {
    private final UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user1 = User.builder()
                .nickname("admin")
                .level(1)
                .interest(List.of(Category.DATABASE, Category.ANDROID))
                .avgAchievementRate(20)
                .position(Position.DATABASE)
                .introduction("안녕하세요 샘플입니다.")
                .build();
        userRepository.save(user1);
    }
}
