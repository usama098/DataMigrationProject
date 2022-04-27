package validate;

import com.sparta.datamigration.model.validate.MiddleInitial;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MiddleInitialTest {

    @Test
    @DisplayName("Enter valid character as a name")
    void validateMiddleNamesAsACharacter() {
        assertEquals(true, MiddleInitial.validateData("G"));
    }

    @Test
    @DisplayName("Enter number as a middle name")
    void invalidateMiddleNamesAsACharacter() {
        assertEquals(false, MiddleInitial.validateData("1"));
    }
    @Test
    @DisplayName("Enter symbol as a middle name")
    void invalidateSymbolMiddleNamesAsACharacter() {
        assertEquals(false, MiddleInitial.validateData("*"));
    }
    @Test
    @DisplayName("Enter symbol as a middle name")
    void invalidateMiddleNames() {
        assertEquals(false, MiddleInitial.validateData("abc"));
    }
}