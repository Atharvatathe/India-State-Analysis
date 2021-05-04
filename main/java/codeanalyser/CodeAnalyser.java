package codeanalyser;

import censusanalyser.CensusAnalyserException;
import censusanalyser.IndiaCensusCSV;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class CodeAnalyser {

    public int loadIndiaCodeData(String csvFilePath) throws CodeAnalyserException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBeanBuilder<IndiaCodeCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IndiaCodeCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndiaCodeCSV> csvToBean = csvToBeanBuilder.build();
            Iterator<IndiaCodeCSV> codeCSVIterator = csvToBean.iterator();;
            int namOfEateries = 0;
            while (codeCSVIterator.hasNext()) {
                namOfEateries++;
                IndiaCodeCSV codeData = codeCSVIterator.next();
            }
            return namOfEateries;
        } catch (IOException e) {
            throw new CodeAnalyserException(e.getMessage(),
                    CodeAnalyserException.ExceptionType.CODE_FILE_PROBLEM);
        }
    }

}
