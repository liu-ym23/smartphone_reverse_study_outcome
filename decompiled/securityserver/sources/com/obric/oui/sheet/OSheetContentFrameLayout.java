package com.obric.oui.sheet;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OSheetContentFrameLayout extends FrameLayout {
    @JvmOverloads
    public OSheetContentFrameLayout(@NotNull Context r2, @Nullable AttributeSet r3) {
        Intrinsics.f(r2, "context");
        super(r2, r3, 0);
    }
}
