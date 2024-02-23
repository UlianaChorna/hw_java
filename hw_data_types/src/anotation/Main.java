package anotation;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person("Jonh", 30, "example@example.com", BigDecimal.valueOf(1.86));

        DataValidator.validate(person);
    }
}
