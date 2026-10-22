package com.bytedance.feedbackerlib.m;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class v {
    public static void a(@Nullable View r1, int r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        if (r0 != null) goto L7;
        return;
    L7:
        r0.height = r2;
        r1.setLayoutParams(r0);
    }
}
