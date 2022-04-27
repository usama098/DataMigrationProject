package validate;

import com.sparta.datamigration.model.validate.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// complete this after csvreader is done
class NameTest {
    @Test
    @DisplayName("Enter valid Name of the person")
    void rightValidatedData() {
        Assertions.assertEquals(true, Name.validateData("Usama"));
    }

    @Test
    @DisplayName("Enter invalid Name of the person")
    void wrongValidatedData() {
        Assertions.assertEquals(false, Name.validateData("Usama123"));
    }

    @Test
    @DisplayName("Enter invalid Name of the person with spaces in it")
    void inValidatedData() {
        Assertions.assertEquals(false, Name.validateData("Usama  "));
    }
}