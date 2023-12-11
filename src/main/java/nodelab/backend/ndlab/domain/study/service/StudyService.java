package nodelab.backend.ndlab.domain.study.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nodelab.backend.ndlab.domain.post.StudyPost;
import nodelab.backend.ndlab.domain.post.mappers.StudyPostMapper;
import nodelab.backend.ndlab.domain.post.repository.StudyPostRepository;
import nodelab.backend.ndlab.domain.study.RequestStatus;
import nodelab.backend.ndlab.domain.study.Study;
import nodelab.backend.ndlab.domain.study.UserStudy;
import nodelab.backend.ndlab.domain.study.mappers.StudyMapper;
import nodelab.backend.ndlab.domain.study.model.StudyCreateDTO;
import nodelab.backend.ndlab.domain.study.model.UserStudyApplyDTO;
import nodelab.backend.ndlab.domain.study.repository.StudyRepository;
import nodelab.backend.ndlab.domain.study.repository.UserStudyRepository;
import nodelab.backend.ndlab.domain.user.User;
import nodelab.backend.ndlab.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
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
        studyRepository.save(study);
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
        if (dto.postTitle() != null) {
            StudyPost post = StudyPostMapper.createStudyPostFromDto(dto, user);
            post.setStudy(study);
            studyPostRepository.save(post);
        }

        return study;
    }

//    @Transactional(readOnly = true)
//    public List<GetAllStudyDto> getAllStudyByCreatedAt() {
//        LocalDate today = LocalDate.now();
//        List<GetAllStudyDto> studyList = new ArrayList<>();
//        List<Study> studies;
//        return studyList;
//    }
//
//    @Transactional(readOnly = true)
//    public List<GetAllStudyDto> getAllStudyByStartDay(Long id) {
//        List<GetAllStudyDto> studyList = new ArrayList<>();
//        List<Object[]> studies = studyRepository.getAllStudyByStartDay(id);
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        studies.stream().forEach(study -> {
//            log.info("why? {}", study);
//            studyList.add(objectMapper.convertValue(study, GetAllStudyDto.class));
//        });
//
//        return studyList;
//    }

    public UserStudy applyStudy(UserStudyApplyDTO dto, Long userId, Long studyId) {
        UserStudy userStudy = StudyMapper.createUserStudyFromDTO(dto);
        Study study = studyRepository.findById(studyId).orElseThrow(() -> new IllegalArgumentException("studyId"));
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("userId"));
        userStudy.setStudy(study);
        userStudy.setUser(user);
        return userStudyRepository.save(userStudy);
    }
}
