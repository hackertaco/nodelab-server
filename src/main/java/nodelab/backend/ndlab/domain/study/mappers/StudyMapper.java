package nodelab.backend.ndlab.domain.study.mappers;

import java.util.stream.Collectors;
import nodelab.backend.ndlab.domain.study.Category;
import nodelab.backend.ndlab.domain.study.RequestStatus;
import nodelab.backend.ndlab.domain.study.State;
import nodelab.backend.ndlab.domain.study.Study;
import nodelab.backend.ndlab.domain.study.UserStudy;
import nodelab.backend.ndlab.domain.study.model.StudyCreateDTO;
import nodelab.backend.ndlab.domain.study.model.UserStudyApplyDTO;
import nodelab.backend.ndlab.domain.user.Position;

public class StudyMapper {
    public static Study createStudyFromDto(StudyCreateDTO dto) {
        return Study.builder()
                .title(dto.title())
                .imgUrl(dto.imgUrl())
                .category(dto.category())
                .startDay(dto.startDay())
                .endDay(dto.endDay())
                .state(State.RECRUIT)
                .peopleLimit(dto.peopleLimit())
                .division(dto.division())
                .introductionTitle(dto.introductionTitle())
                .introductionContent(dto.introductionContent())
                .build();
    }

//    public static GetAllStudyDto createDtoFromStudy(Object[] objects){
//        return GetAllStudyDto.builder()
//                .title(objects.d)
//                .peopleLimit().isBookmarked().studyInqueryCount().applicationCount().build();
//    }

    public static UserStudy createUserStudyFromDTO(UserStudyApplyDTO dto) {
        return UserStudy.builder()
                .interest(dto.interest().stream().map(Category::valueOf).collect(Collectors.toList()))
                .position(Position.valueOf(dto.position()))
                .isOwner(false)
                .introduction(dto.introduction())
                .requestStatus(RequestStatus.READY)
                .build();
    }
}
