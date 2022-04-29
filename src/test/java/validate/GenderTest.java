package validate;

import com.sparta.datamigration.model.Validate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenderTest {

    @Test
    @DisplayName("Enter valid gender Male")
    void validateMale() {
        assertEquals(true, Validate.gender("M"));
    }
    @Test
    @DisplayName("Enter valid gender female")
    void validatedFemale() {
        assertEquals(true, Validate.gender("F"));
    }
    @Test
    @DisplayName("Enter invalid gender female")
    void invalidatedFemale() {
        assertEquals(false, Validate.gender("f"));
    }
    @Test
    @DisplayName("Enter invalid gender male")
    void invalidatedmale() {
        assertEquals(false, Validate.gender("m"));
    }
}