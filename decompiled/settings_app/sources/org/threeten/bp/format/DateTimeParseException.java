package org.threeten.bp.format;

import org.threeten.bp.DateTimeException;

/* JADX INFO: loaded from: classes6.dex */
public class DateTimeParseException extends DateTimeException {
    private static final long serialVersionUID = 4304633501674722597L;
    private final int errorIndex;
    private final String parsedString;

    public DateTimeParseException(String r1, CharSequence r2, int r3) {
        super(r1);
        this.parsedString = r2.toString();
        this.errorIndex = r3;
    }

    public DateTimeParseException(String r1, CharSequence r2, int r3, Throwable r4) {
        super(r1, r4);
        this.parsedString = r2.toString();
        this.errorIndex = r3;
    }

    public String getParsedString() {
        return this.parsedString;
    }

    public int getErrorIndex() {
        return this.errorIndex;
    }
}
