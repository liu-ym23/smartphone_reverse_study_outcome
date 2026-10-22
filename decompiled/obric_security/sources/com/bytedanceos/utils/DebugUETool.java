package com.bytedanceos.utils;

import android.content.Context;
import android.provider.Settings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DebugUETool.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedanceos/utils/DebugUETool;", "", "()V", "isUiDebuggerShowing", "", "turn", "", "context", "Landroid/content/Context;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class DebugUETool {
    public static final DebugUETool INSTANCE = null;
    private static boolean isUiDebuggerShowing;

    static {
        INSTANCE = new DebugUETool();
    }

    private DebugUETool() {
    }

    public final void turn(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if (Settings.canDrawOverlays(r1) == false) goto L6;
        isUiDebuggerShowing = !isUiDebuggerShowing;
        return;
    }
}
