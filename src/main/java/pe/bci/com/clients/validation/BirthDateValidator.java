package pe.bci.com.clients.validation;

import pe.bci.com.clients.constant.Constants;
import pe.bci.com.clients.config.validator.BirthDateConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BirthDateValidator implements ConstraintValidator<BirthDateConstraint, String> {

    @Override
    public void initialize(BirthDateConstraint contactNumber) {
    }

    @Override
    public boolean isValid(String birthDate,
                           ConstraintValidatorContext cxt) {
        Pattern pattern = Pattern.compile(Constants.BIRTH_DATE_PATTERN);
        Matcher matcher = pattern.matcher(birthDate);
        return matcher.matches();
    }

}

