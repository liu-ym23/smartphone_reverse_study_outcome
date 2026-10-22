package android.icu.text;

import android.icu.util.ULocale;
import java.util.Enumeration;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class Transliterator {
    public static final int FORWARD = 0;
    public static final int REVERSE = 1;

    public static class Position {
        public int contextLimit;
        public int contextStart;
        public int limit;
        public int start;

        public Position() {
            throw new RuntimeException("Stub!");
        }

        public Position(int r1, int r2, int r3) {
            throw new RuntimeException("Stub!");
        }

        public Position(int r1, int r2, int r3, int r4) {
            throw new RuntimeException("Stub!");
        }

        public Position(Position r1) {
            throw new RuntimeException("Stub!");
        }

        public void set(Position r1) {
            throw new RuntimeException("Stub!");
        }

        public boolean equals(Object r1) {
            throw new RuntimeException("Stub!");
        }

        public int hashCode() {
            throw new RuntimeException("Stub!");
        }

        public String toString() {
            throw new RuntimeException("Stub!");
        }

        public final void validate(int r1) {
            throw new RuntimeException("Stub!");
        }
    }

    Transliterator() {
        throw new RuntimeException("Stub!");
    }

    public final int transliterate(Replaceable r1, int r2, int r3) {
        throw new RuntimeException("Stub!");
    }

    public final void transliterate(Replaceable r1) {
        throw new RuntimeException("Stub!");
    }

    public final String transliterate(String r1) {
        throw new RuntimeException("Stub!");
    }

    public final void transliterate(Replaceable r1, Position r2, String r3) {
        throw new RuntimeException("Stub!");
    }

    public final void transliterate(Replaceable r1, Position r2, int r3) {
        throw new RuntimeException("Stub!");
    }

    public final void transliterate(Replaceable r1, Position r2) {
        throw new RuntimeException("Stub!");
    }

    public final void finishTransliteration(Replaceable r1, Position r2) {
        throw new RuntimeException("Stub!");
    }

    public void filteredTransliterate(Replaceable r1, Position r2, boolean r3) {
        throw new RuntimeException("Stub!");
    }

    public final int getMaximumContextLength() {
        throw new RuntimeException("Stub!");
    }

    public final String getID() {
        throw new RuntimeException("Stub!");
    }

    public static final String getDisplayName(String r1) {
        throw new RuntimeException("Stub!");
    }

    public static String getDisplayName(String r0, Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public static String getDisplayName(String r0, ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public final UnicodeFilter getFilter() {
        throw new RuntimeException("Stub!");
    }

    public void setFilter(UnicodeFilter r1) {
        throw new RuntimeException("Stub!");
    }

    public static final Transliterator getInstance(String r1) {
        throw new RuntimeException("Stub!");
    }

    public static Transliterator getInstance(String r0, int r1) {
        throw new RuntimeException("Stub!");
    }

    public static final Transliterator createFromRules(String r0, String r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public String toRules(boolean r1) {
        throw new RuntimeException("Stub!");
    }

    public Transliterator[] getElements() {
        throw new RuntimeException("Stub!");
    }

    public final UnicodeSet getSourceSet() {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet getTargetSet() {
        throw new RuntimeException("Stub!");
    }

    public final Transliterator getInverse() {
        throw new RuntimeException("Stub!");
    }

    public static final Enumeration<String> getAvailableIDs() {
        throw new RuntimeException("Stub!");
    }

    public static final Enumeration<String> getAvailableSources() {
        throw new RuntimeException("Stub!");
    }

    public static final Enumeration<String> getAvailableTargets(String r1) {
        throw new RuntimeException("Stub!");
    }

    public static final Enumeration<String> getAvailableVariants(String r0, String r1) {
        throw new RuntimeException("Stub!");
    }
}
