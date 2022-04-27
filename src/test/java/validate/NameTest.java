package validate;

import com.sparta.datamigration.model.validate.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// complete this after csvreader is done
class NameTest {
    @Test
    @DisplayName("Enter valid email address format")
    void rightValidatedData() {
        Assertions.assertEquals(true, Name.validateData("Usama Navid"));
    }
}