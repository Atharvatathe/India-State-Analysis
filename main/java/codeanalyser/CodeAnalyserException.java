package codeanalyser;

public class CodeAnalyserException extends Exception{

    enum ExceptionType {
        CODE_FILE_PROBLEM
    }

    ExceptionType type;

    public CodeAnalyserException(String message, ExceptionType codeFileProblem) {
        super(message);
        this.type = type;
    }

    public CodeAnalyserException(String message, CodeAnalyserException.ExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }

}
