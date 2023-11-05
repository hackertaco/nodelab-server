package nodelab.backend.ndlab.domain.study.service;

import lombok.RequiredArgsConstructor;
import nodelab.backend.ndlab.domain.post.StudyPost;
import nodelab.backend.ndlab.domain.post.mappers.StudyPostMapper;
import nodelab.backend.ndlab.domain.post.repository.StudyPostRepository;
import nodelab.backend.ndlab.domain.study.RequestStatus;
import nodelab.backend.ndlab.domain.study.Study;
import nodelab.backend.ndlab.domain.study.UserStudy;
import nodelab.backend.ndlab.domain.study.mappers.StudyMapper;
import nodelab.backend.ndlab.domain.study.model.StudyCreateDTO;
import nodelab.backend.ndlab.domain.study.repository.StudyRepository;
import nodelab.backend.ndlab.domain.study.repository.UserStudyRepository;
import nodelab.backend.ndlab.domain.user.User;
import nodelab.backend.ndlab.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StudyService {
    private final StudyRepository studyRepository;
    private final UserRepository userRepository;
    private final UserStudyRepository userStudyRepository;
    private final StudyPostRepository studyPostRepository;

    @Transactional
    public Study createStudy(StudyCreateDTO dto, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("원하는 Id를 찾을 수 없습니다."));
        Study study = StudyMapper.createStudyFromDto(dto);
        StudyPost post = StudyPostMapper.createStudyPostFromDto(dto, user);
        studyRepository.save(study);
        post.setStudy(study);
        UserStudy userStudy = UserStudy.builder()
                .user(user)
                .study(study)
                .isOwner(true)
                .requestStatus(RequestStatus.ACCEPTED)
                .interest(user.getInterest())
                .introduction("")
                .position(user.getPosition())
                .build();
        userStudyRepository.save(userStudy);
        studyPostRepository.save(post);

        return study;
    }

}
