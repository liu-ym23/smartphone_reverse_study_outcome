package com.obric.oui.banner;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.app.NotificationCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J-\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/obric/oui/banner/OBanner$initViewPager2$2", "Landroidx/core/view/AccessibilityDelegateCompat;", "Landroid/view/ViewGroup;", "host", "Landroid/view/View;", "child", "Landroid/view/accessibility/AccessibilityEvent;", NotificationCompat.CATEGORY_EVENT, "", "onRequestSendAccessibilityEvent", "(Landroid/view/ViewGroup;Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)Z", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class OBanner$initViewPager2$2 extends AccessibilityDelegateCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OBanner f10786a;

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public boolean onRequestSendAccessibilityEvent(ViewGroup r3, View r4, AccessibilityEvent r5) {
        if (r5 == null) goto L9;
        if (r5.getEventType() != 4096) goto L9;
        int r0 = OBanner.e(this.f10786a).e();
        r5.setItemCount(r0);
        if (r0 <= 0) goto L9;
        r5.setFromIndex(this.f10786a.getViewPager2().getCurrentItem() % r0);
        r5.setToIndex(this.f10786a.getViewPager2().getCurrentItem() % r0);
    L9:
        return super.onRequestSendAccessibilityEvent(r3, r4, r5);
    }
}
