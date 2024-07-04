package module4.mockaroo.generators;

import com.github.javafaker.Faker;
import com.github.javafaker.Number;
import module4.mockaroo.dto.FieldDto;
import module4.mockaroo.dto.GenerateFieldDto;
import module4.mockaroo.enums.FieldSubType;

import java.util.HashMap;
import java.util.function.Function;

public class NumberGenerator {
    private final Number number = new Faker().number();
    private final HashMap<FieldSubType, Function<GenerateFieldDto, FieldDto>> map;

    public NumberGenerator() {
        map = new HashMap<>();
        map.put(FieldSubType.AGE, this::ageGenerator);
        map.put(FieldSubType.SALARY, this::salaryGenerator);
        map.put(FieldSubType.RANDOM, this::randomGenerator);
        map.put(FieldSubType.RANDOM_INT, this::randomIntGenerator);
    }

    public FieldDto generateNumber(GenerateFieldDto dto) {
        return map.get(dto.getFieldSubType()).apply(dto);
    }

    private FieldDto ageGenerator(GenerateFieldDto dto) {
        var value = number.numberBetween(dto.getMin(), dto.getMax());
        return new FieldDto(dto.getFieldName(), value);
    }

    private FieldDto salaryGenerator(GenerateFieldDto dto) {
        var value = number.randomDouble(2, dto.getMin(), dto.getMax());
        return new FieldDto(dto.getFieldName(), value);
    }

    private FieldDto randomGenerator(GenerateFieldDto dto) {
        var value = number.randomDouble(3, dto.getMin(), dto.getMax());
        return new FieldDto(dto.getFieldName(), value);
    }
    private FieldDto randomIntGenerator(GenerateFieldDto dto) {
        var value = number.randomDouble(0, dto.getMin(), dto.getMax());
        return new FieldDto(dto.getFieldName(), value);
    }

}
