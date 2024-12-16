package com.fernando.basic.core.helpers;

import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator {

    public static int calculateAge(LocalDate birthDate){

        if ((birthDate != null)) {
            return Period.between(birthDate, LocalDate.now()).getYears();
        } else {
            throw new IllegalArgumentException("La fecha de nacimiento no debe ser nula.");
        }
    }
}
