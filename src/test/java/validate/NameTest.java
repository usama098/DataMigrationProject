package validate;

import com.sparta.datamigration.model.Validate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {
    @Test
    @DisplayName("Enter valid Name of the person")
    void rightValidatedData() {
        Assertions.assertEquals(true, Validate.name("Usama"));
    }

    @Test
    @DisplayName("Enter invalid Name of the person")
    void wrongValidatedData() {
        Assertions.assertEquals(false, Validate.name("Usama123"));
    }

    @Test
    @DisplayName("Enter invalid Name of the person with spaces in it")
    void inValidatedData() {
        Assertions.assertEquals(false, Validate.name("Usama  "));
    }
}