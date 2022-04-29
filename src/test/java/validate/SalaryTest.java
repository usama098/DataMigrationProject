package validate;

import com.sparta.datamigration.model.Validate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class SalaryTest {


    //add test cases here too
    @DisplayName("Enter '12345' as a salary")
    @Test
    void validateDataOne() {
        assertEquals(true, Validate.salary("12345"));
    }

    @DisplayName("Enter '45' as a salary")
    @Test
    void validateDataTwo() {
        assertEquals(true, Validate.salary("45"));
    }

    @DisplayName("Enter '45!!!' as a salary")
    @Test
    void invalidateDataOne() {
        assertFalse( Validate.salary("45!!!"));
    }

    @DisplayName("Enter 'abced' as a salary")
    @Test
    void invalidateDataTwo() {
        assertFalse(Validate.salary("abced"));
    }
}