package nodelab.backend.ndlab.domain.post.model;

import java.util.Optional;

public record InqueryCreateDTO(
        Optional<Long> parentId,
        String content,
        boolean isSecret
) {
}
