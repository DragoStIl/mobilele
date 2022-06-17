package lab.entity.validations;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, Object> {


    private String first;
    private String second;
    private String message;
    @Override
    public void initialize(PasswordMatch constraintAnnotation) {
        this.first = constraintAnnotation.pass();
        this.second = constraintAnnotation.confirmation();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(value);

        Object firstValue = beanWrapper.getPropertyValue(this.first);
        Object secondValue = beanWrapper.getPropertyValue(this.second);

        boolean result;
        if (firstValue == null){
            result = secondValue == null;
        } else {
            result = firstValue.equals(secondValue);
        }
        if (!result){
            context
                    .buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(second)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }
        return result;
    }
}
