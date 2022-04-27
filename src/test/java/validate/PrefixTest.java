package validate;

import com.sparta.datamigration.model.validate.Prefix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrefixTest {

    @DisplayName("Enter 'Dr.' as a prefix")
    @Test
    void validateDataOne() {
        assertEquals(true, Prefix.validateData("Dr."));
    }

    @DisplayName("Enter 'Esq.' as a prefix")
    @Test
    void validateDataTwo() {
        assertEquals(true, Prefix.validateData("Esq."));
    }

    @DisplayName("Enter 'Hon.' as a prefix")
    @Test
    void validateDataThree() {
        assertEquals(true, Prefix.validateData("Hon."));
    }

    @DisplayName("Enter 'Jr.' as a prefix")
    @Test
    void validateDataFour() {
        assertEquals(true, Prefix.validateData("Jr."));
    }

    @DisplayName("Enter 'Mr.' as a prefix")
    @Test
    void validateDataFive() {
        assertEquals(true, Prefix.validateData("Mr."));
    }

    @DisplayName("Enter 'Mrs.' as a prefix")
    @Test
    void validateDataSix() {
        assertEquals(true, Prefix.validateData("Mrs."));
    }

    @DisplayName("Enter 'Ms.' as a prefix")
    @Test
    void validateDataSeven() {
        assertEquals(true, Prefix.validateData("Ms."));
    }

    @DisplayName("Enter 'Messrs.' as a prefix")
    @Test
    void validateDataEight() {
        assertEquals(true, Prefix.validateData("Messrs."));
    }

    @DisplayName("Enter 'Mmes.' as a prefix")
    @Test
    void validateDataNine() {
        assertEquals(true, Prefix.validateData("Mmes."));
    }

    @DisplayName("Enter 'Msgr.' as a prefix")
    @Test
    void validateDataTen() {
        assertEquals(true, Prefix.validateData("Msgr."));
    }

    @DisplayName("Enter 'Prof.' as a prefix")
    @Test
    void validateDataEleven() {
        assertEquals(true, Prefix.validateData("Prof."));
    }

    @DisplayName("Enter 'Rev.' as a prefix")
    @Test
    void validateDataTwelve() {
        assertEquals(true, Prefix.validateData("Rev."));
    }

    @DisplayName("Enter 'Rt. Hon.' as a prefix")
    @Test
    void validateDataThirteen() {
        assertEquals(true, Prefix.validateData("Rt. Hon."));
    }

    @DisplayName("Enter 'Sr.' as a prefix")
    @Test
    void validateDataFourteen() {
        assertEquals(true, Prefix.validateData("Sr."));
    }

    @DisplayName("Enter 'St.' as a prefix")
    @Test
    void validateDataFifteen() {
        assertEquals(true, Prefix.validateData("St."));
    }

    @DisplayName("Enter '123' as a prefix")
    @Test
    void invalidateData() {
        assertEquals(false, Prefix.validateData("123"));
    }
}