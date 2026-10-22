package com.obric.oui.sheet;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.bytedance.apm.alog.AlogMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OActionSheet$onViewCreated$3$2 extends View.AccessibilityDelegate {
    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View r2, AccessibilityNodeInfo r3) {
        Intrinsics.f(r2, "host");
        Intrinsics.f(r3, AlogMonitor.ALOG_RESULT_INFO);
        super.onInitializeAccessibilityNodeInfo(r2, r3);
        r3.setClassName("android.widget.ImageButton");
        throw null;
    }
}
