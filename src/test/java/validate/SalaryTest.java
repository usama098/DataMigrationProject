package validate;

import com.sparta.datamigration.model.validate.Salary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class SalaryTest {


    //add test cases here too
    @DisplayName("Enter '12345' as a salary")
    @Test
    void validateDataOne() {
        assertEquals(true, Salary.validateData("12345"));
    }

    @DisplayName("Enter '45' as a salary")
    @Test
    void validateDataTwo() {
        assertEquals(true, Salary.validateData("45"));
    }

    @DisplayName("Enter '45!!!' as a salary")
    @Test
    void invalidateDataOne() {
        assertFalse( Salary.validateData("45!!!"));
    }

    @DisplayName("Enter 'abced' as a salary")
    @Test
    void invalidateDataTwo() {
        assertFalse(Salary.validateData("abced"));
    }
}