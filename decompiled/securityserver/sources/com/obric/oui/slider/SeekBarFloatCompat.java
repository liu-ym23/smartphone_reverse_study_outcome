package com.obric.oui.slider;

import android.content.Context;
import android.util.AttributeSet;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SeekBarFloatCompat extends SeekBarCompat {

    @Metadata
    public static final class Companion {
    }

    @JvmOverloads
    public SeekBarFloatCompat(@NotNull Context r3, @Nullable AttributeSet r4) {
        Intrinsics.f(r3, "context");
        super(r3, r4, 0);
    }

    public static float f(int r2) {
        return Float.parseFloat(String.format(Locale.CHINA, "%.2f", Arrays.copyOf(new Object[]{Float.valueOf(r2 / 100)}, 1)));
    }

    public final float getFloatProgress() {
        return f(super.getProgress());
    }

    public final float getMaxValue() {
        return f(getMaxRealValue());
    }

    public final float getMinValue() {
        return f(getMinRealValue());
    }

    public final void setMaxValue(float r2) {
        setMaxValue((int) (r2 * 100));
    }

    public final void setMinValue(float r2) {
        setMinValue((int) (r2 * 100));
    }

    public final void setProgress(float r2) {
        super.setProgress((int) (r2 * 100));
    }
}
