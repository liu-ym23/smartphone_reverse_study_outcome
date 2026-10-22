package android.icu.text;

import android.icu.util.Freezable;
import android.icu.util.ULocale;
import java.io.Serializable;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class DateIntervalInfo implements Cloneable, Freezable<DateIntervalInfo>, Serializable {

    public static final class PatternInfo implements Cloneable, Serializable {
        public PatternInfo(String r1, String r2, boolean r3) {
            throw new RuntimeException("Stub!");
        }

        public String getFirstPart() {
            throw new RuntimeException("Stub!");
        }

        public String getSecondPart() {
            throw new RuntimeException("Stub!");
        }

        public boolean firstDateInPtnIsLaterDate() {
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
    }

    @Override // android.icu.util.Freezable
    public /* bridge */ /* synthetic */ DateIntervalInfo cloneAsThawed() {
        return cloneAsThawed();
    }

    @Override // android.icu.util.Freezable
    public /* bridge */ /* synthetic */ DateIntervalInfo freeze() {
        return freeze();
    }

    public DateIntervalInfo(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public DateIntervalInfo(Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public void setIntervalPattern(String r1, int r2, String r3) {
        throw new RuntimeException("Stub!");
    }

    public PatternInfo getIntervalPattern(String r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public String getFallbackIntervalPattern() {
        throw new RuntimeException("Stub!");
    }

    public void setFallbackIntervalPattern(String r1) {
        throw new RuntimeException("Stub!");
    }

    public boolean getDefaultOrder() {
        throw new RuntimeException("Stub!");
    }

    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.util.Freezable
    public boolean isFrozen() {
        throw new RuntimeException("Stub!");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.icu.util.Freezable
    public DateIntervalInfo freeze() {
        throw new RuntimeException("Stub!");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.icu.util.Freezable
    public DateIntervalInfo cloneAsThawed() {
        throw new RuntimeException("Stub!");
    }

    public boolean equals(Object r1) {
        throw new RuntimeException("Stub!");
    }

    public int hashCode() {
        throw new RuntimeException("Stub!");
    }
}
