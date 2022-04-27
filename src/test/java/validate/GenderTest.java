package validate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GenderTest {

    @Test
    @DisplayName("Enter valid gender Male")
    void validateMale() {
        assertEquals(true, Gender.validateData("M"));
    }
    @Test
    @DisplayName("Enter valid gender female")
    void validatedFemale() {
        assertEquals(true, Gender.validateData("F"));
    }
    @Test
    @DisplayName("Enter invalid gender female")
    void invalidatedFemale() {
        assertEquals(false, Gender.validateData("f"));
    }
    @Test
    @DisplayName("Enter invalid gender male")
    void invalidatedmale() {
        assertEquals(false, Gender.validateData("m"));
    }


}