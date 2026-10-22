package com.obric.oui.divider;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ODivider extends View {

    @Metadata
    public static final class Companion {
    }

    @JvmOverloads
    public ODivider(@NotNull Context r3, @Nullable AttributeSet r4) {
        if ((4 & 2) == 0) goto L5;
        r4 = null;
    L5:
        Intrinsics.f(r3, "context");
        super(r3, r4, 0);
        TypedArray r5 = r3.getTheme().obtainStyledAttributes(r4, R.styleable.j, 0, 0);
        int r6 = r5.getInt(0, 0);     // Catch: Throwable -> L9
        r5.recycle();
        setStyle(r6);
        return;
    L9:
        th = move-exception;
        r5.recycle();
        throw th;
    }

    @Override // android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    public final void setStyle(int r2) {
        setBackgroundColor(ContextCompat.getColor(getContext(), com.bytedance.securityserver.R.color.oui_line_2));
    }
}
