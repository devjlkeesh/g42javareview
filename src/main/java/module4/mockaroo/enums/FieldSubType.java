package module4.mockaroo.enums;

public enum FieldSubType {
    FIRST_NAME(FieldType.NAME),
    LAST_NAME(FieldType.NAME),
    FULL_NAME(FieldType.NAME),
    AGE(FieldType.NUMBER),
    SALARY(FieldType.NUMBER),
    RANDOM(FieldType.NUMBER),
    RANDOM_INT(FieldType.NUMBER);

    private final FieldType superType;

    FieldSubType(FieldType superType) {
        this.superType = superType;
    }
}
