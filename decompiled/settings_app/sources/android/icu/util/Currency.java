package android.icu.util;

import java.util.Date;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class Currency extends MeasureUnit {
    public static final int FORMAL_SYMBOL_NAME = 4;
    public static final int LONG_NAME = 1;
    public static final int NARROW_SYMBOL_NAME = 3;
    public static final int PLURAL_LONG_NAME = 2;
    public static final int SYMBOL_NAME = 0;
    public static final int VARIANT_SYMBOL_NAME = 5;

    public static final enum CurrencyUsage extends Enum<CurrencyUsage> {
        private static final /* synthetic */ CurrencyUsage[] $VALUES = null;
        public static final CurrencyUsage CASH = null;
        public static final CurrencyUsage STANDARD = null;

        public static CurrencyUsage valueOf(String r1) {
            return (CurrencyUsage) Enum.valueOf(CurrencyUsage.class, r1);
        }

        public static CurrencyUsage[] values() {
            return (CurrencyUsage[]) $VALUES.clone();
        }

        private CurrencyUsage(String r1, int r2) {
            super(r1, r2);
        }

        static {
            CurrencyUsage r0 = new CurrencyUsage("STANDARD", 0);
            STANDARD = r0;
            CurrencyUsage r1 = new CurrencyUsage("CASH", 1);
            CASH = r1;
            $VALUES = new CurrencyUsage[]{r0, r1};
        }
    }

    protected Currency(String r1) {
        throw new RuntimeException("Stub!");
    }

    public static Currency getInstance(Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public static Currency getInstance(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static String[] getAvailableCurrencyCodes(ULocale r0, Date r1) {
        throw new RuntimeException("Stub!");
    }

    public static String[] getAvailableCurrencyCodes(Locale r0, Date r1) {
        throw new RuntimeException("Stub!");
    }

    public static Set<Currency> getAvailableCurrencies() {
        throw new RuntimeException("Stub!");
    }

    public static Currency getInstance(String r1) {
        throw new RuntimeException("Stub!");
    }

    public static Currency fromJavaCurrency(java.util.Currency r1) {
        throw new RuntimeException("Stub!");
    }

    public java.util.Currency toJavaCurrency() {
        throw new RuntimeException("Stub!");
    }

    public static Locale[] getAvailableLocales() {
        throw new RuntimeException("Stub!");
    }

    public static ULocale[] getAvailableULocales() {
        throw new RuntimeException("Stub!");
    }

    public static final String[] getKeywordValuesForLocale(String r0, ULocale r1, boolean r2) {
        throw new RuntimeException("Stub!");
    }

    public String getCurrencyCode() {
        throw new RuntimeException("Stub!");
    }

    public int getNumericCode() {
        throw new RuntimeException("Stub!");
    }

    public String getSymbol() {
        throw new RuntimeException("Stub!");
    }

    public String getSymbol(Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public String getSymbol(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public String getName(Locale r1, int r2, boolean[] r3) {
        throw new RuntimeException("Stub!");
    }

    public String getName(ULocale r1, int r2, boolean[] r3) {
        throw new RuntimeException("Stub!");
    }

    public String getName(Locale r1, int r2, String r3, boolean[] r4) {
        throw new RuntimeException("Stub!");
    }

    public String getName(ULocale r1, int r2, String r3, boolean[] r4) {
        throw new RuntimeException("Stub!");
    }

    public String getDisplayName() {
        throw new RuntimeException("Stub!");
    }

    public String getDisplayName(Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public int getDefaultFractionDigits() {
        throw new RuntimeException("Stub!");
    }

    public int getDefaultFractionDigits(CurrencyUsage r1) {
        throw new RuntimeException("Stub!");
    }

    public double getRoundingIncrement() {
        throw new RuntimeException("Stub!");
    }

    public double getRoundingIncrement(CurrencyUsage r1) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.util.MeasureUnit
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    public static boolean isAvailable(String r0, Date r1, Date r2) {
        throw new RuntimeException("Stub!");
    }
}
