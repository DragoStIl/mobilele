package lab.entity.validations;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = PasswordMatchValidator.class)
public @interface PasswordMatch {

    String pass();
    String confirmation();

    String message() default "Passwords don`t match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
