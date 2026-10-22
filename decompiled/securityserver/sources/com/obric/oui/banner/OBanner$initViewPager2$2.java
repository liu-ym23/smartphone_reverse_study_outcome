package com.obric.oui.banner;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OBanner$initViewPager2$2 extends AccessibilityDelegateCompat {
    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final boolean onRequestSendAccessibilityEvent(ViewGroup r3, View r4, AccessibilityEvent r5) {
        if (r5 == null) goto L9;
        if (r5.getEventType() != 4096) goto L9;
        int r2 = OBanner.s;
        throw null;
    L9:
        return super.onRequestSendAccessibilityEvent(r3, r4, r5);
    }
}
