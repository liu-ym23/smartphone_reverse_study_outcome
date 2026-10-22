package android.icu.text;

import android.icu.util.Calendar;
import android.icu.util.DateInterval;
import android.icu.util.TimeZone;
import android.icu.util.ULocale;
import java.text.AttributedCharacterIterator;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class DateIntervalFormat extends UFormat {

    public static final class FormattedDateInterval implements FormattedValue {
        FormattedDateInterval() {
            throw new RuntimeException("Stub!");
        }

        @Override // android.icu.text.FormattedValue, java.lang.CharSequence
        public String toString() {
            throw new RuntimeException("Stub!");
        }

        @Override // java.lang.CharSequence
        public int length() {
            throw new RuntimeException("Stub!");
        }

        @Override // java.lang.CharSequence
        public char charAt(int r1) {
            throw new RuntimeException("Stub!");
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int r1, int r2) {
            throw new RuntimeException("Stub!");
        }

        @Override // android.icu.text.FormattedValue
        public <A extends Appendable> A appendTo(A r1) {
            throw new RuntimeException("Stub!");
        }

        @Override // android.icu.text.FormattedValue
        public boolean nextPosition(ConstrainedFieldPosition r1) {
            throw new RuntimeException("Stub!");
        }

        @Override // android.icu.text.FormattedValue
        public AttributedCharacterIterator toCharacterIterator() {
            throw new RuntimeException("Stub!");
        }
    }

    DateIntervalFormat() {
        throw new RuntimeException("Stub!");
    }

    public static final DateIntervalFormat getInstance(String r1) {
        throw new RuntimeException("Stub!");
    }

    public static final DateIntervalFormat getInstance(String r0, Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public static final DateIntervalFormat getInstance(String r0, ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static final DateIntervalFormat getInstance(String r0, DateIntervalInfo r1) {
        throw new RuntimeException("Stub!");
    }

    public static final DateIntervalFormat getInstance(String r0, Locale r1, DateIntervalInfo r2) {
        throw new RuntimeException("Stub!");
    }

    public static final DateIntervalFormat getInstance(String r0, ULocale r1, DateIntervalInfo r2) {
        throw new RuntimeException("Stub!");
    }

    @Override // java.text.Format
    public synchronized Object clone() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    @Override // java.text.Format
    public final StringBuffer format(Object r1, StringBuffer r2, FieldPosition r3) {
        throw new RuntimeException("Stub!");
    }

    public final StringBuffer format(DateInterval r1, StringBuffer r2, FieldPosition r3) {
        throw new RuntimeException("Stub!");
    }

    public FormattedDateInterval formatToValue(DateInterval r1) {
        throw new RuntimeException("Stub!");
    }

    public final StringBuffer format(Calendar r1, Calendar r2, StringBuffer r3, FieldPosition r4) {
        throw new RuntimeException("Stub!");
    }

    public FormattedDateInterval formatToValue(Calendar r1, Calendar r2) {
        throw new RuntimeException("Stub!");
    }

    @Override // java.text.Format
    @Deprecated
    public Object parseObject(String r1, ParsePosition r2) {
        throw new RuntimeException("Stub!");
    }

    public DateIntervalInfo getDateIntervalInfo() {
        throw new RuntimeException("Stub!");
    }

    public void setDateIntervalInfo(DateIntervalInfo r1) {
        throw new RuntimeException("Stub!");
    }

    public TimeZone getTimeZone() {
        throw new RuntimeException("Stub!");
    }

    public void setTimeZone(TimeZone r1) {
        throw new RuntimeException("Stub!");
    }

    public void setContext(DisplayContext r1) {
        throw new RuntimeException("Stub!");
    }

    public DisplayContext getContext(DisplayContext.Type r1) {
        throw new RuntimeException("Stub!");
    }

    public synchronized DateFormat getDateFormat() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }
}
