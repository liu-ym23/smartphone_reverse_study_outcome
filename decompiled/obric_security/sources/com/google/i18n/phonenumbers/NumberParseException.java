package com.google.i18n.phonenumbers;

/* JADX INFO: loaded from: classes2.dex */
public class NumberParseException extends Exception {
    private ErrorType errorType;
    private String message;

    public static final enum ErrorType extends Enum<ErrorType> {
        private static final /* synthetic */ ErrorType[] $VALUES = null;
        public static final ErrorType INVALID_COUNTRY_CODE = null;
        public static final ErrorType NOT_A_NUMBER = null;
        public static final ErrorType TOO_LONG = null;
        public static final ErrorType TOO_SHORT_AFTER_IDD = null;
        public static final ErrorType TOO_SHORT_NSN = null;

        private static /* synthetic */ ErrorType[] $values() {
            return new ErrorType[]{INVALID_COUNTRY_CODE, NOT_A_NUMBER, TOO_SHORT_AFTER_IDD, TOO_SHORT_NSN, TOO_LONG};
        }

        private ErrorType(String r1, int r2) {
            super(r1, r2);
        }

        public static ErrorType valueOf(String r1) {
            return (ErrorType) Enum.valueOf(ErrorType.class, r1);
        }

        public static ErrorType[] values() {
            return (ErrorType[]) $VALUES.clone();
        }

        static {
            INVALID_COUNTRY_CODE = new ErrorType("INVALID_COUNTRY_CODE", 0);
            NOT_A_NUMBER = new ErrorType("NOT_A_NUMBER", 1);
            TOO_SHORT_AFTER_IDD = new ErrorType("TOO_SHORT_AFTER_IDD", 2);
            TOO_SHORT_NSN = new ErrorType("TOO_SHORT_NSN", 3);
            TOO_LONG = new ErrorType("TOO_LONG", 4);
            $VALUES = $values();
        }
    }

    public NumberParseException(ErrorType r1, String r2) {
        super(r2);
        this.message = r2;
        this.errorType = r1;
    }

    public ErrorType getErrorType() {
        return this.errorType;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "Error type: " + this.errorType + ". " + this.message;
    }
}
