package validate;

import com.sparta.datamigration.model.Validate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MiddleInitialTest {

    @Test
    @DisplayName("Enter valid character as a name")
    void validateMiddleNamesAsACharacter() {
        assertEquals(true, Validate.initial("G"));
    }

    @Test
    @DisplayName("Enter number as a middle name")
    void invalidateMiddleNamesAsACharacter() {
        assertEquals(false, Validate.initial("1"));
    }
    @Test
    @DisplayName("Enter symbol as a middle name")
    void invalidateSymbolMiddleNamesAsACharacter() {
        assertEquals(false, Validate.initial("*"));
    }
    @Test
    @DisplayName("Enter symbol as a middle name")
    void invalidateMiddleNames() {
        assertEquals(false, Validate.initial("abc"));
    }
}