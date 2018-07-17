package com.qa.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContactNumberValidator implements
ConstraintValidator<ContactNumberConstraint, String> {


  public void initialize(ContactNumberConstraint contactNumber) {
  }


  public boolean isValid(String contactField,
    ConstraintValidatorContext cxt) {
      return contactField != null && contactField.matches("[0-9]+")
        && (contactField.length() > 8) && (contactField.length() < 14);
  }

}