package module4.mockaroo.generators;

import module4.mockaroo.dto.FieldDto;
import module4.mockaroo.dto.GenerateFieldDto;
import module4.mockaroo.enums.FieldSubType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {
    NumberGenerator numberGenerator;


    @BeforeEach
    void setUp() {
        numberGenerator = new NumberGenerator();
    }

    @Test
    void ageGenerator() {
        GenerateFieldDto dto = new GenerateFieldDto("age", FieldSubType.AGE,10,30);
        FieldDto response = numberGenerator.generateNumber(dto);
        assertThat(response).isNotNull();
        assertThat(response.fieldName()).isEqualTo("age");
        assertThat(response.value()).isOfAnyClassIn(Long.class);
    }

    @Test
    void salaryGenerator() {
        GenerateFieldDto dto = new GenerateFieldDto("oylik", FieldSubType.SALARY,10000,300000);
        FieldDto response = numberGenerator.generateNumber(dto);
        assertThat(response).isNotNull();
        assertThat(response.fieldName()).isEqualTo("oylik");
        assertThat(response.value()).isOfAnyClassIn(Double.class);
    }

    @Test
    void randomGenerator() {
        GenerateFieldDto dto = new GenerateFieldDto("rand_number", FieldSubType.RANDOM,1,300000000);
        FieldDto response = numberGenerator.generateNumber(dto);
        assertThat(response).isNotNull();
        assertThat(response.fieldName()).isEqualTo("rand_number");
        assertThat(response.value()).isOfAnyClassIn(Double.class);
    }

    @Test
    void randomIntGenerator() {
        GenerateFieldDto dto = new GenerateFieldDto("rand_number_int", FieldSubType.RANDOM_INT,1,300000000);
        FieldDto response = numberGenerator.generateNumber(dto);
        assertThat(response).isNotNull();
        assertThat(response.fieldName()).isEqualTo("rand_number_int");
        assertThat(response.value()).isOfAnyClassIn(Double.class);
    }
}