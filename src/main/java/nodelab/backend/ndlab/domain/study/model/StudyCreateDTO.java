package nodelab.backend.ndlab.domain.study.model;


import java.time.LocalDate;
import nodelab.backend.ndlab.domain.study.Category;
import nodelab.backend.ndlab.domain.study.StudyDivision;
public record StudyCreateDTO(
        String title,
         String imgUrl,
         Category category,
         LocalDate startDay,
         LocalDate endDay,
         int peopleLimit,
         StudyDivision division,
         String introductionTitle,
         String introductionContent
) {
}
