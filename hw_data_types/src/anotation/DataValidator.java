package anotation;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Objects;

public class DataValidator {
    public static void validate(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(DataValidation.class)) {
                DataValidation annotation = field.getAnnotation(DataValidation.class);
                field.setAccessible(true);
                Object value = field.get(obj);

                switch (annotation.type()) {
                    case STRING:
                        if (value instanceof String) {
                            int length = ((String) value).length();
                            int min = Objects.nonNull(annotation.min())
                                    ? Integer.parseInt(annotation.min())
                                    : Integer.MIN_VALUE;

                            int max = Objects.nonNull(annotation.max())
                                    ? Integer.parseInt(annotation.max())
                                    : Integer.MAX_VALUE;

                            if (length <  min || length > max) {
                                System.out.println("Invalid length for field " + field.getName());
                            }
                        }
                        break;
                    case NUMBER:
                        if (value instanceof Integer) {
                            int intValue = (int) value;

                            int min = Objects.nonNull(annotation.min())
                                    ? Integer.parseInt(annotation.min())
                                    : Integer.MIN_VALUE;

                            int max = Objects.nonNull(annotation.max())
                                    ? Integer.parseInt(annotation.max())
                                    : Integer.MAX_VALUE;

                            if (intValue < min || intValue > max) {
                                System.out.println("Invalid range for field " + field.getName());
                            }
                        }
                    case DECIMALS:
                        if (value instanceof BigDecimal) {

                            BigDecimal bigDecimal = new BigDecimal(String.valueOf(value));
                            BigDecimal min = Objects.nonNull(annotation.min())
                                    ? new BigDecimal(annotation.min())
                                    : null;

                            BigDecimal max = Objects.nonNull(annotation.max())
                                    ? new BigDecimal(annotation.max())
                                    : null;

                            if (Objects.nonNull(min) && bigDecimal.compareTo(min) < 0) {
                                System.out.println("Invalid range for field " + field.getName());
                            }

                            if (Objects.nonNull(max) &&  bigDecimal.compareTo(max) > 0) {
                                System.out.println("Invalid range for field " + field.getName());
                            }
                        }

                        break;
                    default:
                        break;
                }
            }
        }
    }
}
