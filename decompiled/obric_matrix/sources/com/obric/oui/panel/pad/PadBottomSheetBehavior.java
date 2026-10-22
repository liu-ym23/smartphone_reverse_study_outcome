package com.obric.oui.panel.pad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.oui.panel.BottomSheetBehavior;
import kotlin.Metadata;
import kotlin.n0.d.o;
import kotlin.r0.e;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u000f\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ?\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/obric/oui/panel/pad/PadBottomSheetBehavior;", "Landroid/view/View;", "V", "Lcom/obric/oui/panel/BottomSheetBehavior;", "Lkotlin/f0;", "calculateCollapsedOffset", "()V", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "parent", "child", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "", "onInterceptTouchEvent", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/MotionEvent;)Z", "onTouchEvent", "coordinatorLayout", "directTargetChild", TypedValues.AttributesType.S_TARGET, "", "axes", WsConstants.KEY_CONNECTION_TYPE, "onStartNestedScroll", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;Landroid/view/View;II)Z", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class PadBottomSheetBehavior<V extends View> extends BottomSheetBehavior<V> {
    public PadBottomSheetBehavior(Context r2, AttributeSet r3) {
        o.f(r2, "context");
        o.f(r3, "attributes");
        super(r2, r3);
    }

    @Override // com.obric.oui.panel.BottomSheetBehavior
    protected void calculateCollapsedOffset() {
        if (this.f11155a == false) goto L5;
        int r0 = e.c(this.v - this.f11162h, this.f11163i);
    L6:
        this.f11165k = r0;
        this.f11165k = r0 / 2;
        return;
    L5:
        r0 = this.v - this.f11162h;
        goto L6
    }

    @Override // com.obric.oui.panel.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout r1, V r2, MotionEvent r3) {
        o.f(r1, "parent");
        o.f(r2, "child");
        o.f(r3, NotificationCompat.CATEGORY_EVENT);
        return false;
    }

    @Override // com.obric.oui.panel.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout r1, V r2, View r3, View r4, int r5, int r6) {
        o.f(r1, "coordinatorLayout");
        o.f(r2, "child");
        o.f(r3, "directTargetChild");
        o.f(r4, TypedValues.AttributesType.S_TARGET);
        return false;
    }

    @Override // com.obric.oui.panel.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout r1, V r2, MotionEvent r3) {
        o.f(r1, "parent");
        o.f(r2, "child");
        o.f(r3, NotificationCompat.CATEGORY_EVENT);
        return false;
    }
}
