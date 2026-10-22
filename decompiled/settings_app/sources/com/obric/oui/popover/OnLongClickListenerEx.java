package com.obric.oui.popover;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LongClickUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H&R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/popover/OnLongClickListenerEx;", "", "()V", "clickPos", "", "getClickPos", "()[I", "onTouchListener", "Landroid/view/View$OnTouchListener;", "getOnTouchListener", "()Landroid/view/View$OnTouchListener;", "onLongClick", "", "view", "Landroid/view/View;", "rawPos", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OnLongClickListenerEx {
    private final int[] clickPos;
    private final View.OnTouchListener onTouchListener;

    /* JADX INFO: renamed from: $r8$lambda$6yoBhw4h_TIT-2c7DpbuVrx-xeE, reason: not valid java name */
    public static /* synthetic */ boolean m1294$r8$lambda$6yoBhw4h_TIT2c7DpbuVrxxeE(OnLongClickListenerEx r0, View r1, MotionEvent r2) {
        return m1295onTouchListener$lambda0(r0, r1, r2);
    }

    public abstract boolean onLongClick(View r1, int[] r2);

    public OnLongClickListenerEx() {
        this.clickPos = new int[2];
        this.onTouchListener = new OnLongClickListenerEx$$ExternalSyntheticLambda0(this);
    }

    public final int[] getClickPos() {
        return this.clickPos;
    }

    public final View.OnTouchListener getOnTouchListener() {
        return this.onTouchListener;
    }

    /* JADX INFO: renamed from: onTouchListener$lambda-0, reason: not valid java name */
    private static final boolean m1295onTouchListener$lambda0(OnLongClickListenerEx r2, View r3, MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        if (r4 == null) goto L5;
        r2.clickPos[0] = (int) r4.getRawX();
        r2.clickPos[1] = (int) r4.getRawY();
    L5:
        return false;
    }
}
