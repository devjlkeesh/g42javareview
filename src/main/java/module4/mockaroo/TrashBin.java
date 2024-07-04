package module4.mockaroo;

import com.github.javafaker.Faker;
import module4.mockaroo.dto.FieldDto;
import module4.mockaroo.dto.GenerateFieldDto;
import module4.mockaroo.enums.FieldSubType;
import module4.mockaroo.generators.NameGenerator;
import module4.mockaroo.generators.NumberGenerator;

public class TrashBin {
    public static void main(String[] args) {
        Faker faker = new Faker();

        /*Name name = faker.name();
        Address address = faker.address();
        Number number = faker.number();
        PhoneNumber phoneNumber = faker.phoneNumber();
        Lorem lorem = faker.lorem();
        Animal animal = faker.animal();
        Color color = faker.color();
        Company company = faker.company();*/

        NameGenerator nameGenerator = new NameGenerator();
        NumberGenerator numberGenerator = new NumberGenerator();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            // "age:AGE:min:max"
            var generateIdDto = new GenerateFieldDto("id", FieldSubType.RANDOM_INT, 1, 100000);
            FieldDto id = numberGenerator.generateNumber(generateIdDto);

            var generateFNDto = new GenerateFieldDto("firstname", FieldSubType.FIRST_NAME);
            FieldDto fn = nameGenerator.generateName(generateFNDto);

            var generateLNDto = new GenerateFieldDto("lastname", FieldSubType.LAST_NAME);
            FieldDto ln = nameGenerator.generateName(generateLNDto);

            var generateAGEDto = new GenerateFieldDto("age", FieldSubType.AGE, 20, 40);
            FieldDto age = numberGenerator.generateNumber(generateAGEDto);

            stringBuilder.append(id.fieldName()).append(" : ").append(id.value())
                    .append(", ").append(fn.fieldName()).append(" : ").append(fn.value())
                    .append(", ").append(ln.fieldName()).append(" : ").append(ln.value())
                    .append(", ").append(age.fieldName()).append(" : ").append(age.value()).append("\n");

        }
        System.out.println(stringBuilder.toString());

    }
}
