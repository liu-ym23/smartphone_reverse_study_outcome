package com.obric.matrix.platform.sdk.ones.commonmonitor.page;

import android.view.Window;
import androidx.core.view.OneShotPreDrawListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Ext.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"onPreDrawOnce", "", "Landroid/view/Window;", "action", "Ljava/lang/Runnable;", "sdk_platform_ones_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ExtKt {
    public static final void onPreDrawOnce(Window r1, Runnable r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        if (r1 != null) goto L5;
        return;
    L5:
        OneShotPreDrawListener.add(r1.getDecorView(), r2);
    }
}
