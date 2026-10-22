package android.icu.number;

import android.icu.number.NumberFormatterSettings;
import android.icu.text.DecimalFormatSymbols;
import android.icu.text.NumberingSystem;
import android.icu.util.MeasureUnit;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes.dex */
public abstract class NumberFormatterSettings<T extends NumberFormatterSettings<?>> {
    NumberFormatterSettings() {
        throw new RuntimeException("Stub!");
    }

    public T notation(Notation r1) {
        throw new RuntimeException("Stub!");
    }

    public T unit(MeasureUnit r1) {
        throw new RuntimeException("Stub!");
    }

    public T perUnit(MeasureUnit r1) {
        throw new RuntimeException("Stub!");
    }

    public T precision(Precision r1) {
        throw new RuntimeException("Stub!");
    }

    public T roundingMode(RoundingMode r1) {
        throw new RuntimeException("Stub!");
    }

    public T grouping(NumberFormatter.GroupingStrategy r1) {
        throw new RuntimeException("Stub!");
    }

    public T integerWidth(IntegerWidth r1) {
        throw new RuntimeException("Stub!");
    }

    public T symbols(DecimalFormatSymbols r1) {
        throw new RuntimeException("Stub!");
    }

    public T symbols(NumberingSystem r1) {
        throw new RuntimeException("Stub!");
    }

    public T unitWidth(NumberFormatter.UnitWidth r1) {
        throw new RuntimeException("Stub!");
    }

    public T sign(NumberFormatter.SignDisplay r1) {
        throw new RuntimeException("Stub!");
    }

    public T decimal(NumberFormatter.DecimalSeparatorDisplay r1) {
        throw new RuntimeException("Stub!");
    }

    public T scale(Scale r1) {
        throw new RuntimeException("Stub!");
    }

    public T usage(String r1) {
        throw new RuntimeException("Stub!");
    }

    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    public boolean equals(Object r1) {
        throw new RuntimeException("Stub!");
    }
}
