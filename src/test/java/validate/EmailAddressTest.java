package validate;

import com.sparta.datamigration.model.Validate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmailAddressTest {

    @Test
    @DisplayName("Enter valid email address format")
    void rightValidatedData() {
        assertEquals(true, Validate.email("usama.navid@gmail.com"));
    }

    @DisplayName("Enter wrong email format without @")
    @Test
    void wrongValidatedData() {
        assertEquals(false, Validate.email("usama.navidgmail.com"));
    }

    @DisplayName("Enter wrong email format without @ & .")
    @Test
    void wrongValidatedDataTwo() {
        assertEquals(false, Validate.email("usama.navidgmailcom"));
    }
}