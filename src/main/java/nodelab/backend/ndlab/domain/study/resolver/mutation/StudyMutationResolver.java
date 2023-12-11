package nodelab.backend.ndlab.domain.study.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nodelab.backend.ndlab.domain.study.Study;
import nodelab.backend.ndlab.domain.study.UserStudy;
import nodelab.backend.ndlab.domain.study.model.StudyCreateDTO;
import nodelab.backend.ndlab.domain.study.model.UserStudyApplyDTO;
import nodelab.backend.ndlab.domain.study.service.StudyService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
public class StudyMutationResolver implements GraphQLMutationResolver {
    private final StudyService studyService;

    @MutationMapping(name = "createStudy")
    public Study createStudy(@Valid @Argument(name = "input") StudyCreateDTO input,
                             @Argument(name = "userId") Long userId) {
        log.info("Creating study for {}", input);
        return studyService.createStudy(input, userId);
    }

    @MutationMapping(name = "applyStudy")
    public UserStudy applyStudy(@Valid @Argument(name = "input") UserStudyApplyDTO input,
                                @Argument(name = "userId") Long userId,
                                @Argument(name = "studyId") Long studyId) {
        log.info("Creating userStudy {}", input);
        return studyService.applyStudy(input, userId, studyId);
    }
}
