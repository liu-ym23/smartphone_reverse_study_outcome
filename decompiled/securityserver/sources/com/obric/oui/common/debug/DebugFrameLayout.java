package com.obric.oui.common.debug;

import a.a;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class DebugFrameLayout extends FrameLayout {

    @Metadata
    public static final class Companion {
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        super.onLayout(r4, r5, r6, r7, r8);
        int r3 = r7 - r5;
        StringBuilder r9 = a.r("Layout left: ", r5, ", top: ", r6, ", right: ");
        r9.append(r7);
        r9.append(", bottom: ");
        r9.append(r8);
        String r10 = r9.toString();
        Intrinsics.f(r10, NotificationCompat.CATEGORY_MESSAGE);
        Log.d("DebugFrameLayout onLayout", r10);
        String r11 = "Layout width: " + r3 + ", height: " + (r8 - r6);
        Intrinsics.f(r11, NotificationCompat.CATEGORY_MESSAGE);
        Log.d("DebugFrameLayout onLayout", r11);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        int r0 = View.MeasureSpec.getMode(r10);
        int r12 = View.MeasureSpec.getSize(r10);
        int r1 = View.MeasureSpec.getMode(r11);
        int r13 = View.MeasureSpec.getSize(r11);
        int r2 = getMeasuredWidth();
        int r9 = getMeasuredHeight();
        String r3 = "AT_MOST";
        if (r0 == Integer.MIN_VALUE) goto L9;
        if (r0 == 0) goto L8;
        if (r0 == 1073741824) goto L7;
        String r4 = NetworkStackConstant.UNKNOWN_TYPE;
    L10:
        if (r1 == Integer.MIN_VALUE) goto L16;
        if (r1 == 0) goto L15;
        if (r1 == 1073741824) goto L14;
        r3 = NetworkStackConstant.UNKNOWN_TYPE;
        goto L16
    L14:
        r3 = "EXACTLY";
        goto L16
    L15:
        r3 = "UNSPECIFIED";
    L16:
        String r14 = "Width mode: " + r4 + ", width size: " + r12 + ", measured width: " + r2;
        Intrinsics.f(r14, NotificationCompat.CATEGORY_MESSAGE);
        Log.d("DebugFrameLayout onMeasure", r14);
        String r15 = "Height mode: " + r3 + ", height size: " + r13 + ", measured height: " + r9;
        Intrinsics.f(r15, NotificationCompat.CATEGORY_MESSAGE);
        Log.d("DebugFrameLayout onMeasure", r15);
        return;
    L7:
        r4 = "EXACTLY";
        goto L10
    L8:
        r4 = "UNSPECIFIED";
        goto L10
    L9:
        r4 = "AT_MOST";
        goto L10
    }
}
