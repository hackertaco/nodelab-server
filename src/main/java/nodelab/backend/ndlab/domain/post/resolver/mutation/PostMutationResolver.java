package nodelab.backend.ndlab.domain.post.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nodelab.backend.ndlab.domain.post.StudyInquery;
import nodelab.backend.ndlab.domain.post.model.InqueryCreateDTO;
import nodelab.backend.ndlab.domain.post.service.PostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;


@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
public class PostMutationResolver implements GraphQLMutationResolver {
    private final PostService postService;

    @MutationMapping(name = "createInquiry")
    public StudyInquery createInquery(@Valid @Argument(name = "input") InqueryCreateDTO input,
                                      @Argument(name = "userId") Long userId,
                                      @Argument(name = "studyId") Long studyId) {

        log.info("Creating inquery for {}", input);

        return postService.createInquery(input, userId, studyId);
    }
}
