package com.obric.oui.common.util;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ViewExtensionsKt$setButtonAccessibilityDelegate$1 extends AccessibilityDelegateCompat {
    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View r1, AccessibilityNodeInfoCompat r2) {
        super.onInitializeAccessibilityNodeInfo(r1, r2);
        if (r2 == null) goto L5;
        r2.setClassName("android.widget.Button");
    L5:
        StringsKt.t(null);
        throw null;
    }
}
