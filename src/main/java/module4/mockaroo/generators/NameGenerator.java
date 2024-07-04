package module4.mockaroo.generators;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import module4.mockaroo.dto.FieldDto;
import module4.mockaroo.dto.GenerateFieldDto;
import module4.mockaroo.enums.FieldSubType;

import java.util.HashMap;
import java.util.function.Function;

public class NameGenerator {
    private final Name name = new Faker().name();
    private final HashMap<FieldSubType, Function<GenerateFieldDto, FieldDto>> map;

    public NameGenerator() {
        map = new HashMap<>();
        map.put(FieldSubType.FIRST_NAME, this::firstnameGenerator);
        map.put(FieldSubType.LAST_NAME, this::lastnameGenerator);
        map.put(FieldSubType.FULL_NAME, this::fullnameGenerator);
    }

    public FieldDto generateName(GenerateFieldDto dto) {
        return map.get(dto.getFieldSubType()).apply(dto);
    }

    private FieldDto firstnameGenerator(GenerateFieldDto dto) {
        return new FieldDto(dto.getFieldName(), name.firstName());
    }

    private FieldDto lastnameGenerator(GenerateFieldDto dto) {
        return new FieldDto(dto.getFieldName(), name.lastName());
    }

    private FieldDto fullnameGenerator(GenerateFieldDto dto) {
        return new FieldDto(dto.getFieldName(), name.fullName());
    }

}
