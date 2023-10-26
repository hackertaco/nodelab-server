package nodelab.backend.ndlab.domain.study.mappers;

import nodelab.backend.ndlab.domain.study.State;
import nodelab.backend.ndlab.domain.study.Study;
import nodelab.backend.ndlab.domain.study.model.StudyCreateDTO;

public class StudyMapper {
    public static Study createStudyFromDto(StudyCreateDTO dto){
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
}
