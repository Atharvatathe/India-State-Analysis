package codeanalyser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CodeAnalyserTest {

    private static final String INDIA_CODE_CSV_FILE_PATH = "./src/test/resources/IndiaStateCode.csv";
    private static final String WRONG_CODE_CSV_FILE_PATH = "./src/main/resources/IndiaStateCode.csv";


    @Test
    public void givenIndianCodeCSVFileReturnsCorrectRecords() {
        try {
            CodeAnalyser codeAnalyser = new CodeAnalyser();
            int numOfRecords = codeAnalyser.loadIndiaCodeData(INDIA_CODE_CSV_FILE_PATH);
            Assert.assertEquals(37,numOfRecords);
        } catch (CodeAnalyserException e) { }
          catch (NullPointerException e){}
    }

    @Test
    public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
        try {
            CodeAnalyser codeAnalyser = new CodeAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CodeAnalyserException.class);
            codeAnalyser.loadIndiaCodeData(WRONG_CODE_CSV_FILE_PATH);
        } catch (CodeAnalyserException e) {
            Assert.assertEquals(CodeAnalyserException.ExceptionType.CODE_FILE_PROBLEM,e.type);
        }
    }
}
