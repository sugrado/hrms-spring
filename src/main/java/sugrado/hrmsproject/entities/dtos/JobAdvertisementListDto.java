package sugrado.hrmsproject.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementListDto {
    private int id;
    private int jobPositionName;
    private int openPositionNumber;
    private LocalDate releaseDate;
    private LocalDate applicationDeadline;
}
