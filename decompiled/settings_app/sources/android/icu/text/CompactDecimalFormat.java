package android.icu.text;

import android.icu.util.CurrencyAmount;
import android.icu.util.ULocale;
import java.text.ParsePosition;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class CompactDecimalFormat extends DecimalFormat {

    public static final enum CompactStyle extends Enum<CompactStyle> {
        private static final /* synthetic */ CompactStyle[] $VALUES = null;
        public static final CompactStyle LONG = null;
        public static final CompactStyle SHORT = null;

        public static CompactStyle valueOf(String r1) {
            return (CompactStyle) Enum.valueOf(CompactStyle.class, r1);
        }

        public static CompactStyle[] values() {
            return (CompactStyle[]) $VALUES.clone();
        }

        private CompactStyle(String r1, int r2) {
            super(r1, r2);
        }

        static {
            CompactStyle r0 = new CompactStyle("SHORT", 0);
            SHORT = r0;
            CompactStyle r1 = new CompactStyle("LONG", 1);
            LONG = r1;
            $VALUES = new CompactStyle[]{r0, r1};
        }
    }

    CompactDecimalFormat() {
        throw new RuntimeException("Stub!");
    }

    public static CompactDecimalFormat getInstance(ULocale r0, CompactStyle r1) {
        throw new RuntimeException("Stub!");
    }

    public static CompactDecimalFormat getInstance(Locale r0, CompactStyle r1) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.text.DecimalFormat, android.icu.text.NumberFormat
    public Number parse(String r1, ParsePosition r2) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.text.DecimalFormat, android.icu.text.NumberFormat
    public CurrencyAmount parseCurrency(CharSequence r1, ParsePosition r2) {
        throw new RuntimeException("Stub!");
    }
}
