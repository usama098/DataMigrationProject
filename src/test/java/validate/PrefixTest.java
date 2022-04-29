package validate;

import com.sparta.datamigration.model.Validate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrefixTest {

    @DisplayName("Enter 'Dr.' as a prefix")
    @Test
    void validateDataOne() {
        assertEquals(true, Validate.prefix("Dr."));
    }

    @DisplayName("Enter 'Esq.' as a prefix")
    @Test
    void validateDataTwo() {
        assertEquals(true, Validate.prefix("Esq."));
    }

    @DisplayName("Enter 'Hon.' as a prefix")
    @Test
    void validateDataThree() {
        assertEquals(true, Validate.prefix("Hon."));
    }

    @DisplayName("Enter 'Jr.' as a prefix")
    @Test
    void validateDataFour() {
        assertEquals(true, Validate.prefix("Jr."));
    }

    @DisplayName("Enter 'Mr.' as a prefix")
    @Test
    void validateDataFive() {
        assertEquals(true, Validate.prefix("Mr."));
    }

    @DisplayName("Enter 'Mrs.' as a prefix")
    @Test
    void validateDataSix() {
        assertEquals(true, Validate.prefix("Mrs."));
    }

    @DisplayName("Enter 'Ms.' as a prefix")
    @Test
    void validateDataSeven() {
        assertEquals(true, Validate.prefix("Ms."));
    }

    @DisplayName("Enter 'Messrs.' as a prefix")
    @Test
    void validateDataEight() {
        assertEquals(true, Validate.prefix("Messrs."));
    }

    @DisplayName("Enter 'Mmes.' as a prefix")
    @Test
    void validateDataNine() {
        assertEquals(true, Validate.prefix("Mmes."));
    }

    @DisplayName("Enter 'Msgr.' as a prefix")
    @Test
    void validateDataTen() {
        assertEquals(true, Validate.prefix("Msgr."));
    }

    @DisplayName("Enter 'Prof.' as a prefix")
    @Test
    void validateDataEleven() {
        assertEquals(true, Validate.prefix("Prof."));
    }

    @DisplayName("Enter 'Rev.' as a prefix")
    @Test
    void validateDataTwelve() {
        assertEquals(true, Validate.prefix("Rev."));
    }

    @DisplayName("Enter 'Rt. Hon.' as a prefix")
    @Test
    void validateDataThirteen() {
        assertEquals(true, Validate.prefix("Rt. Hon."));
    }

    @DisplayName("Enter 'Sr.' as a prefix")
    @Test
    void validateDataFourteen() {
        assertEquals(true, Validate.prefix("Sr."));
    }

    @DisplayName("Enter 'St.' as a prefix")
    @Test
    void validateDataFifteen() {
        assertEquals(true, Validate.prefix("St."));
    }

    @DisplayName("Enter '123' as a prefix")
    @Test
    void invalidateData() {
        assertEquals(false, Validate.prefix("123"));
    }
}