package com.obric.oui.swipeaction;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J7\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"com/obric/oui/swipeaction/OSwipeActionLayout$dragHelperCallback$1", "Landroidx/customview/widget/ViewDragHelper$Callback;", "", WsConstants.KEY_CONNECTION_STATE, "Lkotlin/f0;", "onViewDragStateChanged", "(I)V", "Landroid/view/View;", "changedView", "left", "top", "dx", "dy", "onViewPositionChanged", "(Landroid/view/View;IIII)V", "child", "getViewHorizontalDragRange", "(Landroid/view/View;)I", "view", "pointerId", "", "tryCaptureView", "(Landroid/view/View;I)Z", "clampViewPositionHorizontal", "(Landroid/view/View;II)I", "releasedChild", "", "xVel", "yVel", "onViewReleased", "(Landroid/view/View;FF)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class OSwipeActionLayout$dragHelperCallback$1 extends ViewDragHelper.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f11437a;

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public int clampViewPositionHorizontal(View r3, int r4, int r5) {
        o.f(r3, "child");
        if (this.f11437a.getSwipeEnabled() == true) goto L5;
        return 0;
    L5:
        int r6 = this.f11437a.getDirection();
        if (r6 == 1) goto L15;
        if (r6 == 2) goto L17;
        if (r6 == 3) goto L16;
        return 0;
    L16:
        return a.a(this.f11437a, r4, r5);
    L17:
        return a.c(this.f11437a, r4);
    L15:
        return a.b(this.f11437a, r4);
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public int getViewHorizontalDragRange(View r2) {
        o.f(r2, "child");
        return a.j(this.f11437a);
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public void onViewDragStateChanged(int r3) {
        if (r3 != a.d(this.f11437a)) goto L6;
        return;
    L6:
        if (a.s(this.f11437a, r3) == false) goto L9;
        a.w(this.f11437a);
    L23:
        a.t(this.f11437a, r3);
        return;
    L9:
        if (r3 != 1) goto L23;
        a.InterfaceC0300a r0 = this.f11437a.getActionsListener();
        if (r0 == null) goto L14;
        r0.a();
    L14:
        if (a.p(this.f11437a) == true) goto L19;
        View r1 = a.q(this.f11437a);
        if (r1 == null) goto L19;
        View r2 = a.q(this.f11437a);
        o.c(r2);
        r1.offsetLeftAndRight((r2.getWidth() / 2) * (-1));
    L19:
        if (a.k(this.f11437a) == true) goto L23;
        View r4 = a.l(this.f11437a);
        if (r4 == null) goto L23;
        View r5 = a.l(this.f11437a);
        o.c(r5);
        r4.offsetLeftAndRight(r5.getWidth() / 2);
        goto L23
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public void onViewPositionChanged(View r1, int r2, int r3, int r4, int r5) {
        o.f(r1, "changedView");
        a.u(this.f11437a, r2);
        int r6 = r4 % 2;
        if (r6 != 0) goto L5;
    L8:
        int r7 = this.f11437a.getDirection();
        if (r7 == 1) goto L23;
        if (r7 != 2) goto L12;
        View r8 = a.m(this.f11437a);
        o.c(r8);
        View r9 = a.f(this.f11437a);
        o.c(r9);
        r8.setRight(r9.getLeft());
        View r0 = a.l(this.f11437a);
        if (r0 == null) goto L29;
    L25:
        r4 = r4 / 2;
    L26:
        r0.offsetLeftAndRight(r4);
        return;
    L29:
        return;
    L12:
        if (r7 != 3) goto L31;
        View r10 = a.l(this.f11437a);
        if (r10 == null) goto L17;
        r10.offsetLeftAndRight(r4);
    L17:
        r0 = a.q(this.f11437a);
        if (r0 != null) goto L26;
        return;
    L31:
        return;
    L23:
        View r11 = a.r(this.f11437a);
        o.c(r11);
        View r12 = a.f(this.f11437a);
        o.c(r12);
        r11.setLeft(r12.getRight());
        r0 = a.q(this.f11437a);
        if (r0 != null) goto L25;
        return;
    L5:
        if (a.o(this.f11437a) == 0) goto L7;
        r4 = r4 + a.o(this.f11437a);
        a.v(this.f11437a, 0);
        goto L8
    L7:
        a.v(this.f11437a, r6);
        goto L8
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public void onViewReleased(View r1, float r2, float r3) {
        o.f(r1, "releasedChild");
        if (this.f11437a.getDirection() != 1) goto L6;
        int r4 = a.h(this.f11437a, r2);
    L14:
        ViewDragHelper r5 = a.e(this.f11437a);
        o.c(r5);
        View r6 = a.f(this.f11437a);
        o.c(r6);
        if (r5.settleCapturedViewAt(r4, r6.getTop()) == false) goto L18;
        ViewCompat.postInvalidateOnAnimation(this.f11437a);
        return;
    L18:
        return;
    L6:
        if (this.f11437a.getDirection() != 2) goto L9;
        r4 = a.i(this.f11437a, r2);
        goto L14
    L9:
        if (this.f11437a.getDirection() != 3) goto L13;
        r4 = a.g(this.f11437a, r2);
        if (r4 != (-1)) goto L14;
        r4 = a.n(this.f11437a);
        goto L14
    L13:
        r4 = 0;
        goto L14
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public boolean tryCaptureView(View r1, int r2) {
        o.f(r1, "view");
        View r0 = a.f(this.f11437a);
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r1.getId() != r0.getId()) goto L9;
        return true;
    L9:
        return false;
    }
}
