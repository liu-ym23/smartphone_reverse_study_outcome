package android.icu.text;

import android.icu.number.FormattedNumber;
import android.icu.number.FormattedNumberRange;
import android.icu.util.ULocale;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class PluralRules implements Serializable {
    public static final PluralRules DEFAULT = null;
    public static final String KEYWORD_FEW = "few";
    public static final String KEYWORD_MANY = "many";
    public static final String KEYWORD_ONE = "one";
    public static final String KEYWORD_OTHER = "other";
    public static final String KEYWORD_TWO = "two";
    public static final String KEYWORD_ZERO = "zero";
    public static final double NO_UNIQUE_VALUE = -0.00123456777d;

    public static final enum PluralType extends Enum<PluralType> {
        private static final /* synthetic */ PluralType[] $VALUES = null;
        public static final PluralType CARDINAL = null;
        public static final PluralType ORDINAL = null;

        public static PluralType valueOf(String r1) {
            return (PluralType) Enum.valueOf(PluralType.class, r1);
        }

        public static PluralType[] values() {
            return (PluralType[]) $VALUES.clone();
        }

        private PluralType(String r1, int r2) {
            super(r1, r2);
        }

        static {
            PluralType r0 = new PluralType("CARDINAL", 0);
            CARDINAL = r0;
            PluralType r1 = new PluralType("ORDINAL", 1);
            ORDINAL = r1;
            $VALUES = new PluralType[]{r0, r1};
        }
    }

    static {
    }

    private PluralRules() {
        throw new RuntimeException("Stub!");
    }

    public static PluralRules parseDescription(String r1) throws ParseException {
        throw new RuntimeException("Stub!");
    }

    public static PluralRules createRules(String r1) {
        throw new RuntimeException("Stub!");
    }

    public static PluralRules forLocale(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static PluralRules forLocale(Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public static PluralRules forLocale(ULocale r0, PluralType r1) {
        throw new RuntimeException("Stub!");
    }

    public static PluralRules forLocale(Locale r0, PluralType r1) {
        throw new RuntimeException("Stub!");
    }

    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    public String select(double r1) {
        throw new RuntimeException("Stub!");
    }

    public String select(FormattedNumber r1) {
        throw new RuntimeException("Stub!");
    }

    public String select(FormattedNumberRange r1) {
        throw new RuntimeException("Stub!");
    }

    public Set<String> getKeywords() {
        throw new RuntimeException("Stub!");
    }

    public double getUniqueKeywordValue(String r1) {
        throw new RuntimeException("Stub!");
    }

    public Collection<Double> getAllKeywordValues(String r1) {
        throw new RuntimeException("Stub!");
    }

    public Collection<Double> getSamples(String r1) {
        throw new RuntimeException("Stub!");
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }

    public boolean equals(Object r1) {
        throw new RuntimeException("Stub!");
    }

    public boolean equals(PluralRules r1) {
        throw new RuntimeException("Stub!");
    }
}
