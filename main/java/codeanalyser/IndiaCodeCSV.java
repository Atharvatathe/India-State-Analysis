package codeanalyser;
import com.opencsv.bean.CsvBindByName;
public class IndiaCodeCSV {

    @CsvBindByName(column = "srNo", required = true)
    public int srNo;

    @CsvBindByName(column = "State", required = true)
    public String State;

    @CsvBindByName(column = "TIN", required = true)
    public int TIN;

    @CsvBindByName(column = "StateCode", required = true)
    public String StateCode;

    @Override
    public String toString() {
        return "IndiaCodeCSV{" +
                "srNo='" + srNo + '\'' +
                ", State='" + State + '\'' +
                ", TIN='" + TIN + '\'' +
                ",StateCode='" + StateCode +'\'' +
                '}';
    }

}
