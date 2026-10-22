package com.obric.common.oea.style.scene.qsanim.common;

import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.android.settings.utils.HanziToPinyin;
import com.obric.common.oea.foundation.util.OEALogger;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UIDebugTools.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\f\u0010\t\u001a\u00020\u0006*\u00020\nH\u0007J\u001c\u0010\u000b\u001a\u00020\u0006*\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\f\u0010\u0010\u001a\u00020\u0006*\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/common/UIDebugTools;", "", "()V", "TAG", "", "dumpViewTree", "", "window", "Landroid/view/Window;", "dumpChildViewTree", "Landroid/view/View;", "dumpChildren", "depth", "", "count", "Ljava/util/concurrent/atomic/AtomicInteger;", "dumpFullViewTree", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class UIDebugTools {
    public static final UIDebugTools INSTANCE = null;
    private static final String TAG = "UIDebugTools";

    static {
        INSTANCE = new UIDebugTools();
    }

    private UIDebugTools() {
    }

    @JvmStatic
    public static final void dumpViewTree(Window r4) {
        Intrinsics.checkNotNullParameter(r4, "window");
        AtomicInteger r0 = new AtomicInteger(0);
        UIDebugTools r2 = INSTANCE;
        View r5 = r4.getDecorView();
        Intrinsics.checkNotNullExpressionValue(r5, "window.decorView");
        r2.dumpChildren(r5, 0, r0);
    }

    @JvmStatic
    public static final void dumpChildViewTree(View r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$dumpChildViewTree");
        AtomicInteger r0 = new AtomicInteger(0);
        INSTANCE.dumpChildren(r3, 0, r0);
    }

    @JvmStatic
    public static final void dumpFullViewTree(View r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$dumpFullViewTree");
    L4:
        if ((r1.getParent() instanceof View) == false) goto L10;
        Object r2 = r1.getParent();
        if (r2 == null) goto L9;
        r1 = (View) r2;
        goto L4
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L10:
        dumpChildViewTree(r1);
    }

    private final void dumpChildren(View r7, int r8, AtomicInteger r9) {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r8) goto L5;
        r0.append(HanziToPinyin.Token.SEPARATOR);
        r2 = r2 + 1;
        goto L3
    L5:
        OEALogger.INSTANCE.d(TAG, "dumpChildren, depth: " + r8 + ",\tcount: " + r9.getAndIncrement() + "\t|" + r0 + r7);
        boolean r3 = r7 instanceof ViewGroup;
        if (r3 == false) goto L28;
        KtExt r4 = KtExt.INSTANCE;
        if (r3 == false) goto L10;
        View r5 = r7;
    L11:
        ViewGroup r6 = (ViewGroup) r5;
        if (r6 == null) goto L14;
        int r10 = r6.getChildCount();
    L15:
        if (r10 <= 0) goto L33;
    L16:
        if (r1 >= r10) goto L34;
        KtExt r11 = KtExt.INSTANCE;
        if (r3 == false) goto L20;
        View r12 = r7;
    L21:
        ViewGroup r13 = (ViewGroup) r12;
        if (r13 == null) goto L24;
        View r14 = r13.getChildAt(r1);
    L25:
        if (r14 == null) goto L27;
        dumpChildren(r14, r8 + 1, r9);
    L27:
        r1 = r1 + 1;
        goto L16
    L24:
        r14 = null;
        goto L25
    L20:
        r12 = null;
        goto L21
    L34:
        return;
    L33:
        return;
    L14:
        r10 = 0;
        goto L15
    L10:
        r5 = null;
        goto L11
    }
}
