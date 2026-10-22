package android.icu.text;

import android.icu.util.Measure;
import android.icu.util.MeasureUnit;
import android.icu.util.ULocale;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class MeasureFormat extends UFormat {

    public static final enum FormatWidth extends Enum<FormatWidth> {
        private static final /* synthetic */ FormatWidth[] $VALUES = null;
        public static final FormatWidth NARROW = null;
        public static final FormatWidth NUMERIC = null;
        public static final FormatWidth SHORT = null;
        public static final FormatWidth WIDE = null;

        public static FormatWidth valueOf(String r1) {
            return (FormatWidth) Enum.valueOf(FormatWidth.class, r1);
        }

        public static FormatWidth[] values() {
            return (FormatWidth[]) $VALUES.clone();
        }

        private FormatWidth(String r1, int r2) {
            super(r1, r2);
        }

        static {
            FormatWidth r0 = new FormatWidth("WIDE", 0);
            WIDE = r0;
            FormatWidth r1 = new FormatWidth("SHORT", 1);
            SHORT = r1;
            FormatWidth r3 = new FormatWidth("NARROW", 2);
            NARROW = r3;
            FormatWidth r5 = new FormatWidth("NUMERIC", 3);
            NUMERIC = r5;
            $VALUES = new FormatWidth[]{r0, r1, r3, r5};
        }
    }

    @Override // java.text.Format
    public /* bridge */ /* synthetic */ Object parseObject(String r1, ParsePosition r2) {
        return parseObject(r1, r2);
    }

    MeasureFormat() {
        throw new RuntimeException("Stub!");
    }

    public static MeasureFormat getInstance(ULocale r0, FormatWidth r1) {
        throw new RuntimeException("Stub!");
    }

    public static MeasureFormat getInstance(Locale r0, FormatWidth r1) {
        throw new RuntimeException("Stub!");
    }

    public static MeasureFormat getInstance(ULocale r0, FormatWidth r1, NumberFormat r2) {
        throw new RuntimeException("Stub!");
    }

    public static MeasureFormat getInstance(Locale r0, FormatWidth r1, NumberFormat r2) {
        throw new RuntimeException("Stub!");
    }

    @Override // java.text.Format
    public StringBuffer format(Object r1, StringBuffer r2, FieldPosition r3) {
        throw new RuntimeException("Stub!");
    }

    @Override // java.text.Format
    public Measure parseObject(String r1, ParsePosition r2) {
        throw new RuntimeException("Stub!");
    }

    public final String formatMeasures(Measure... r1) {
        throw new RuntimeException("Stub!");
    }

    public StringBuilder formatMeasurePerUnit(Measure r1, MeasureUnit r2, StringBuilder r3, FieldPosition r4) {
        throw new RuntimeException("Stub!");
    }

    public StringBuilder formatMeasures(StringBuilder r1, FieldPosition r2, Measure... r3) {
        throw new RuntimeException("Stub!");
    }

    public String getUnitDisplayName(MeasureUnit r1) {
        throw new RuntimeException("Stub!");
    }

    public final boolean equals(Object r1) {
        throw new RuntimeException("Stub!");
    }

    public final int hashCode() {
        throw new RuntimeException("Stub!");
    }

    public FormatWidth getWidth() {
        throw new RuntimeException("Stub!");
    }

    public final ULocale getLocale() {
        throw new RuntimeException("Stub!");
    }

    public NumberFormat getNumberFormat() {
        throw new RuntimeException("Stub!");
    }

    public static MeasureFormat getCurrencyFormat(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static MeasureFormat getCurrencyFormat(Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public static MeasureFormat getCurrencyFormat() {
        throw new RuntimeException("Stub!");
    }
}
