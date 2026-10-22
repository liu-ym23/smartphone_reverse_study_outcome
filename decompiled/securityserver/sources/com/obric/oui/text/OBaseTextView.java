package com.obric.oui.text;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SuppressLint({"AppCompatCustomView"})
public final class OBaseTextView extends TextView {
    @JvmOverloads
    public OBaseTextView(@NotNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, 4);
    }

    public OBaseTextView(Context r1, AttributeSet r2, int r3) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        Intrinsics.f(r1, "context");
        super(r1, r2, 0);
    }
}
