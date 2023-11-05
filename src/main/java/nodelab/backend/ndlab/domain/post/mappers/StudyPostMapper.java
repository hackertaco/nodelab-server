package nodelab.backend.ndlab.domain.post.mappers;

import nodelab.backend.ndlab.domain.post.StudyInquery;
import nodelab.backend.ndlab.domain.post.StudyPost;
import nodelab.backend.ndlab.domain.post.model.InqueryCreateDTO;
import nodelab.backend.ndlab.domain.study.model.StudyCreateDTO;
import nodelab.backend.ndlab.domain.user.User;

public class StudyPostMapper {
    public static StudyPost createStudyPostFromDto(StudyCreateDTO dto, User user) {
        return StudyPost.builder()
                .title(dto.postTitle())
                .content(dto.postContent())
                .isNotice(true)
                .user(user)
                .build();
    }

    public static StudyInquery createStudyInqueryFromDto(InqueryCreateDTO dto) {
        return StudyInquery.builder()
                .content(dto.content())
                .isSecret(dto.isSecret())
                .build();
    }
}
