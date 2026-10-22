package android.icu.text;

import android.icu.util.Freezable;
import android.icu.util.ULocale;
import android.icu.util.VersionInfo;
import java.util.Comparator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class Collator implements Comparator<Object>, Freezable<Collator>, Cloneable {
    public static final int CANONICAL_DECOMPOSITION = 17;
    public static final int FULL_DECOMPOSITION = 15;
    public static final int IDENTICAL = 15;
    public static final int NO_DECOMPOSITION = 16;
    public static final int PRIMARY = 0;
    public static final int QUATERNARY = 3;
    public static final int SECONDARY = 1;
    public static final int TERTIARY = 2;

    public interface ReorderCodes {
        public static final int CURRENCY = 4099;
        public static final int DEFAULT = -1;
        public static final int DIGIT = 4100;
        public static final int FIRST = 4096;
        public static final int NONE = 103;
        public static final int OTHERS = 103;
        public static final int PUNCTUATION = 4097;
        public static final int SPACE = 4096;
        public static final int SYMBOL = 4098;
    }

    public abstract int compare(String r1, String r2);

    public abstract CollationKey getCollationKey(String r1);

    public abstract VersionInfo getUCAVersion();

    public abstract int getVariableTop();

    public abstract VersionInfo getVersion();

    @Override // android.icu.util.Freezable
    public /* bridge */ /* synthetic */ Collator cloneAsThawed() {
        return cloneAsThawed();
    }

    @Override // android.icu.util.Freezable
    public /* bridge */ /* synthetic */ Collator freeze() {
        return freeze();
    }

    protected Collator() {
        throw new RuntimeException("Stub!");
    }

    @Override // java.util.Comparator
    public boolean equals(Object r1) {
        throw new RuntimeException("Stub!");
    }

    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    public void setStrength(int r1) {
        throw new RuntimeException("Stub!");
    }

    public void setDecomposition(int r1) {
        throw new RuntimeException("Stub!");
    }

    public void setReorderCodes(int... r1) {
        throw new RuntimeException("Stub!");
    }

    public static final Collator getInstance() {
        throw new RuntimeException("Stub!");
    }

    public Object clone() throws CloneNotSupportedException {
        throw new RuntimeException("Stub!");
    }

    public static final Collator getInstance(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static final Collator getInstance(Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public static Locale[] getAvailableLocales() {
        throw new RuntimeException("Stub!");
    }

    public static final ULocale[] getAvailableULocales() {
        throw new RuntimeException("Stub!");
    }

    public static final String[] getKeywords() {
        throw new RuntimeException("Stub!");
    }

    public static final String[] getKeywordValues(String r1) {
        throw new RuntimeException("Stub!");
    }

    public static final String[] getKeywordValuesForLocale(String r0, ULocale r1, boolean r2) {
        throw new RuntimeException("Stub!");
    }

    public static final ULocale getFunctionalEquivalent(String r0, ULocale r1, boolean[] r2) {
        throw new RuntimeException("Stub!");
    }

    public static final ULocale getFunctionalEquivalent(String r0, ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static String getDisplayName(Locale r0, Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public static String getDisplayName(ULocale r0, ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static String getDisplayName(Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public static String getDisplayName(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public int getStrength() {
        throw new RuntimeException("Stub!");
    }

    public int getDecomposition() {
        throw new RuntimeException("Stub!");
    }

    public boolean equals(String r1, String r2) {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet getTailoredSet() {
        throw new RuntimeException("Stub!");
    }

    @Override // java.util.Comparator
    public int compare(Object r1, Object r2) {
        throw new RuntimeException("Stub!");
    }

    public Collator setMaxVariable(int r1) {
        throw new RuntimeException("Stub!");
    }

    public int getMaxVariable() {
        throw new RuntimeException("Stub!");
    }

    public int[] getReorderCodes() {
        throw new RuntimeException("Stub!");
    }

    public static int[] getEquivalentReorderCodes(int r1) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.util.Freezable
    public boolean isFrozen() {
        throw new RuntimeException("Stub!");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.icu.util.Freezable
    public Collator freeze() {
        throw new RuntimeException("Stub!");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.icu.util.Freezable
    public Collator cloneAsThawed() {
        throw new RuntimeException("Stub!");
    }
}
