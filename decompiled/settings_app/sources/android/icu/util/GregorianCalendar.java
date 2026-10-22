package android.icu.util;

import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class GregorianCalendar extends Calendar {
    public static final int AD = 1;
    public static final int BC = 0;
    protected transient boolean invertGregorian;
    protected transient boolean isGregorian;

    public GregorianCalendar() {
        throw new RuntimeException("Stub!");
    }

    public GregorianCalendar(TimeZone r1) {
        throw new RuntimeException("Stub!");
    }

    public GregorianCalendar(Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public GregorianCalendar(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public GregorianCalendar(TimeZone r1, Locale r2) {
        throw new RuntimeException("Stub!");
    }

    public GregorianCalendar(TimeZone r1, ULocale r2) {
        throw new RuntimeException("Stub!");
    }

    public GregorianCalendar(int r1, int r2, int r3) {
        throw new RuntimeException("Stub!");
    }

    public GregorianCalendar(int r1, int r2, int r3, int r4, int r5) {
        throw new RuntimeException("Stub!");
    }

    public GregorianCalendar(int r1, int r2, int r3, int r4, int r5, int r6) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.util.Calendar
    protected int handleGetLimit(int r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public void setGregorianChange(Date r1) {
        throw new RuntimeException("Stub!");
    }

    public final Date getGregorianChange() {
        throw new RuntimeException("Stub!");
    }

    public boolean isLeapYear(int r1) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.util.Calendar
    public boolean isEquivalentTo(Calendar r1) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.util.Calendar
    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.util.Calendar
    public void roll(int r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.util.Calendar
    public int getActualMinimum(int r1) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.util.Calendar
    public int getActualMaximum(int r1) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.util.Calendar
    protected int handleGetMonthLength(int r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.util.Calendar
    protected int handleGetYearLength(int r1) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.util.Calendar
    protected void handleComputeFields(int r1) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.util.Calendar
    protected int handleGetExtendedYear() {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.util.Calendar
    protected int handleComputeJulianDay(int r1) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.util.Calendar
    protected int handleComputeMonthStart(int r1, int r2, boolean r3) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.util.Calendar
    public String getType() {
        throw new RuntimeException("Stub!");
    }
}
