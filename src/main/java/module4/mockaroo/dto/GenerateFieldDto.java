package module4.mockaroo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import module4.mockaroo.enums.FieldSubType;

@Getter
@Setter
@AllArgsConstructor
public class GenerateFieldDto {
    private final String fieldName;
    private final FieldSubType fieldSubType;
    private long min;
    private long max;

    public GenerateFieldDto(String fieldName, FieldSubType fieldSubType) {
        this.fieldName = fieldName;
        this.fieldSubType = fieldSubType;
    }
}
