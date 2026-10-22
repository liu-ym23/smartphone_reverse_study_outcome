package com.obric.matrix.platform.sdk.ones.commonmonitor.page;

import android.view.Window;
import androidx.core.view.OneShotPreDrawListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ExtKt {
    public static final void onPreDrawOnce(@Nullable Window r1, @NotNull Runnable r2) {
        Intrinsics.f(r2, "action");
        if (r1 != null) goto L5;
        return;
    L5:
        OneShotPreDrawListener.add(r1.getDecorView(), r2);
    }
}
