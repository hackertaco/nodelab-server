package nodelab.backend.ndlab.domain.study.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nodelab.backend.ndlab.domain.study.Study;
import nodelab.backend.ndlab.domain.study.mappers.StudyMapper;
import nodelab.backend.ndlab.domain.study.model.StudyCreateDTO;
import nodelab.backend.ndlab.domain.study.service.StudyService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Component
@RequiredArgsConstructor
public class StudyMutation implements GraphQLMutationResolver {
    private final StudyService studyService;
    @MutationMapping
    public Study createStudy(@Valid @Argument StudyCreateDTO input, @Argument Long userId){
        log.info("Creating study for {}", input);
        Study study = StudyMapper.createStudyFromDto(input);

        return studyService.createStudy(study, userId);
    }
}
