package nodelab.backend.ndlab.domain.study.model;

import java.util.List;

public record UserStudyApplyDTO(
        String position,
        List<String> interest,
        String introduction
) {

}
