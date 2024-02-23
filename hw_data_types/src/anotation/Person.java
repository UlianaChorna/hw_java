package anotation;

import java.math.BigDecimal;

public class Person {
    @DataValidation(type = DataType.STRING, min = "3", max = "7")
    private final String name;

    @DataValidation(type = DataType.NUMBER, min = "5", max = "150")
    private final int age;

    @DataValidation(type = DataType.STRING, min = "5", max = "50")
    private final String email;

    @DataValidation(type = DataType.DECIMALS, min = "0.15" , max = "2.50")
    private final BigDecimal height;

    public Person(String name, int age, String email, BigDecimal height) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.height = height;
    }
}
