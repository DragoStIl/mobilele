package lab.entity.validations;

import lab.repositories.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUserEmailValidator implements ConstraintValidator<UniqueUserEmail, String> {
    private UserRepository userRepository;

    public UniqueUserEmailValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String registerEmailInput, ConstraintValidatorContext context) {
        return userRepository.findByEmail(registerEmailInput).isEmpty();
    }
}
