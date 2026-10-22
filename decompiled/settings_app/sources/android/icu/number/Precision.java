package android.icu.number;

import android.icu.util.Currency;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public abstract class Precision {
    Precision() {
        throw new RuntimeException("Stub!");
    }

    public static Precision unlimited() {
        throw new RuntimeException("Stub!");
    }

    public static FractionPrecision integer() {
        throw new RuntimeException("Stub!");
    }

    public static FractionPrecision fixedFraction(int r1) {
        throw new RuntimeException("Stub!");
    }

    public static FractionPrecision minFraction(int r1) {
        throw new RuntimeException("Stub!");
    }

    public static FractionPrecision maxFraction(int r1) {
        throw new RuntimeException("Stub!");
    }

    public static FractionPrecision minMaxFraction(int r0, int r1) {
        throw new RuntimeException("Stub!");
    }

    public static Precision fixedSignificantDigits(int r1) {
        throw new RuntimeException("Stub!");
    }

    public static Precision minSignificantDigits(int r1) {
        throw new RuntimeException("Stub!");
    }

    public static Precision maxSignificantDigits(int r1) {
        throw new RuntimeException("Stub!");
    }

    public static Precision minMaxSignificantDigits(int r0, int r1) {
        throw new RuntimeException("Stub!");
    }

    public static Precision increment(BigDecimal r1) {
        throw new RuntimeException("Stub!");
    }

    public static CurrencyPrecision currency(Currency.CurrencyUsage r1) {
        throw new RuntimeException("Stub!");
    }
}
