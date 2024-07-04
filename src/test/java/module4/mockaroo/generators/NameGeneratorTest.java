package module4.mockaroo.generators;

import module4.mockaroo.dto.FieldDto;
import module4.mockaroo.dto.GenerateFieldDto;
import module4.mockaroo.enums.FieldSubType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class NameGeneratorTest {

    NameGenerator nameGenerator;

    @BeforeEach
    void setUp() {
        nameGenerator = new NameGenerator();
    }


    @Test
    void testFirstName() {
        GenerateFieldDto dto = new GenerateFieldDto("first_name", FieldSubType.FIRST_NAME);
        FieldDto response = nameGenerator.generateName(dto);
        assertThat(response).isNotNull();
        assertThat(response.fieldName()).isEqualTo("first_name");
        assertThat(response.value()).isNotNull();
    }

    @Test
    void testLastName() {
        GenerateFieldDto dto = new GenerateFieldDto("last_name", FieldSubType.LAST_NAME);
        FieldDto response = nameGenerator.generateName(dto);
        assertThat(response).isNotNull();
        assertThat(response.fieldName()).isEqualTo("last_name");
        assertThat(response.value()).isNotNull();
    }

    @Test
    void testfullName() {
        GenerateFieldDto dto = new GenerateFieldDto("full_name", FieldSubType.FULL_NAME);
        FieldDto response = nameGenerator.generateName(dto);
        System.out.println("response = " + response);
        assertThat(response).isNotNull();
        assertThat(response.fieldName()).isEqualTo("full_name");
        assertThat(response.value()).isNotNull();
        assertThat(response.value()).asString().contains(" ");

    }
}