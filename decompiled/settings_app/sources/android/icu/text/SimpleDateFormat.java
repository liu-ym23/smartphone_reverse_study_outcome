package android.icu.text;

import android.icu.util.Calendar;
import android.icu.util.ULocale;
import java.text.AttributedCharacterIterator;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class SimpleDateFormat extends DateFormat {
    public SimpleDateFormat() {
        throw new RuntimeException("Stub!");
    }

    public SimpleDateFormat(String r1) {
        throw new RuntimeException("Stub!");
    }

    public SimpleDateFormat(String r1, Locale r2) {
        throw new RuntimeException("Stub!");
    }

    public SimpleDateFormat(String r1, ULocale r2) {
        throw new RuntimeException("Stub!");
    }

    public SimpleDateFormat(String r1, String r2, ULocale r3) {
        throw new RuntimeException("Stub!");
    }

    public SimpleDateFormat(String r1, DateFormatSymbols r2) {
        throw new RuntimeException("Stub!");
    }

    public void set2DigitYearStart(Date r1) {
        throw new RuntimeException("Stub!");
    }

    public Date get2DigitYearStart() {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.text.DateFormat
    public void setContext(DisplayContext r1) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.text.DateFormat
    public StringBuffer format(Calendar r1, StringBuffer r2, FieldPosition r3) {
        throw new RuntimeException("Stub!");
    }

    protected DateFormat.Field patternCharToDateFormatField(char r1) {
        throw new RuntimeException("Stub!");
    }

    protected String subFormat(char r1, int r2, int r3, FieldPosition r4, DateFormatSymbols r5, Calendar r6) throws IllegalArgumentException {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.text.DateFormat
    public void setNumberFormat(NumberFormat r1) {
        throw new RuntimeException("Stub!");
    }

    protected String zeroPaddingNumber(long r1, int r3, int r4) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.text.DateFormat
    public void parse(String r1, Calendar r2, ParsePosition r3) {
        throw new RuntimeException("Stub!");
    }

    protected int matchString(String r1, int r2, int r3, String[] r4, Calendar r5) {
        throw new RuntimeException("Stub!");
    }

    protected int matchQuarterString(String r1, int r2, int r3, String[] r4, Calendar r5) {
        throw new RuntimeException("Stub!");
    }

    protected int subParse(String r1, int r2, char r3, int r4, boolean r5, boolean r6, boolean[] r7, Calendar r8) {
        throw new RuntimeException("Stub!");
    }

    public String toPattern() {
        throw new RuntimeException("Stub!");
    }

    public String toLocalizedPattern() {
        throw new RuntimeException("Stub!");
    }

    public void applyPattern(String r1) {
        throw new RuntimeException("Stub!");
    }

    public void applyLocalizedPattern(String r1) {
        throw new RuntimeException("Stub!");
    }

    public DateFormatSymbols getDateFormatSymbols() {
        throw new RuntimeException("Stub!");
    }

    public void setDateFormatSymbols(DateFormatSymbols r1) {
        throw new RuntimeException("Stub!");
    }

    protected DateFormatSymbols getSymbols() {
        throw new RuntimeException("Stub!");
    }

    public TimeZoneFormat getTimeZoneFormat() {
        throw new RuntimeException("Stub!");
    }

    public void setTimeZoneFormat(TimeZoneFormat r1) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.text.DateFormat, java.text.Format
    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.text.DateFormat
    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.text.DateFormat
    public boolean equals(Object r1) {
        throw new RuntimeException("Stub!");
    }

    @Override // java.text.Format
    public AttributedCharacterIterator formatToCharacterIterator(Object r1) {
        throw new RuntimeException("Stub!");
    }

    public void setNumberFormat(String r1, NumberFormat r2) {
        throw new RuntimeException("Stub!");
    }

    public NumberFormat getNumberFormat(char r1) {
        throw new RuntimeException("Stub!");
    }
}
