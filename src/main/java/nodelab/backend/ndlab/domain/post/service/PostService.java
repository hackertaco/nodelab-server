package nodelab.backend.ndlab.domain.post.service;

import lombok.RequiredArgsConstructor;
import nodelab.backend.ndlab.domain.post.StudyInquery;
import nodelab.backend.ndlab.domain.post.mappers.StudyPostMapper;
import nodelab.backend.ndlab.domain.post.model.InqueryCreateDTO;
import nodelab.backend.ndlab.domain.post.repository.StudyInquiryRepository;
import nodelab.backend.ndlab.domain.study.Study;
import nodelab.backend.ndlab.domain.study.repository.StudyRepository;
import nodelab.backend.ndlab.domain.user.User;
import nodelab.backend.ndlab.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final StudyRepository studyRepository;
    private final UserRepository userRepository;
    private final StudyInquiryRepository studyInquiryRepository;

    @Transactional
    public StudyInquery createInquery(InqueryCreateDTO dto, Long userId, Long studyId) {
        StudyInquery studyInquery = StudyPostMapper.createStudyInqueryFromDto(dto);
        Study study = studyRepository.findById(studyId).orElseThrow(() -> new IllegalArgumentException("studyId"));
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("userId"));
        studyInquery.setStudy(study);
        studyInquery.setUser(user);
        return studyInquiryRepository.save(studyInquery);
    }
}
