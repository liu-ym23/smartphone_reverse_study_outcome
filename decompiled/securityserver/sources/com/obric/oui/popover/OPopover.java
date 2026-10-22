package com.obric.oui.popover;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.PathInterpolator;
import android.widget.PopupWindow;
import androidx.core.view.ViewGroupKt;
import com.bytedance.frameworks.baselib.network.http.util.HttpStatus;
import com.bytedance.securityserver.R;
import com.obric.oui.animation.easy.ViewPropertySpringAnimator;
import com.obric.oui.animation.easy.ViewPropertySpringAnimatorExtKt;
import com.obric.oui.animation.engine.SpringAnimation;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.utils.log.L;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.FilteringSequence;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class OPopover extends PopupWindow {
    public static final /* synthetic */ int e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f263a;
    public boolean b;
    public AnimatorSet c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f264d;

    @Metadata
    public static final class Builder {
    }

    @Metadata
    public static final class CommonFloatProperty {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f265a;
    }

    @Metadata
    public static final class Companion {
        public static int a(int r1) {
            if (r1 != 8388611) goto L5;
            return 3;
        L5:
            if (r1 != 8388613) goto L11;
            return 5;
        L11:
            return r1;
        }
    }

    @Metadata
    public interface OnBubbleClickListener {
    }

    @Metadata
    public interface OnBubbleDismissListener {
        void a();
    }

    @Metadata
    public interface OnBubbleShowListener {
    }

    public final Pair a(int r8) {
        ViewGroup r6 = this.f263a;
        if (r6 != null) goto L5;
        Intrinsics.m("mWindowFrame");
        throw null;
    L5:
        if ((r6 instanceof SingleChildFrameLayout) == false) goto L8;
        r6.setVisibility(4);
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        View r0 = getContentView();
        Intrinsics.e(r0, "contentView");
        Context r1 = r0.getContext();
        Intrinsics.e(r1, "contentView.context");
        setWidth(OUnitExtensionKt.c(r1));
        return new Pair(Integer.valueOf(r8), Integer.valueOf(this.f264d));
    L8:
        View r7 = LayoutInflater.from(null).inflate(R.layout.o_layout_popover_shadow_frame, null);
        if (r7 == null) goto L13;
        SingleChildFrameLayout r9 = (SingleChildFrameLayout) r7;
        Intrinsics.m("mOBubbleLayout");
        throw null;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.popover.SingleChildFrameLayout");
    }

    public final void b(final boolean r15) {
        final ViewGroup r10 = this.f263a;
        if (r10 == null) goto L96;
        if (r15 == true) goto L6;
        this.b = true;
    L6:
        this.c = new AnimatorSet();
        int r3 = Companion.a(0);
        if (r3 != 3) goto L9;
        r10.getX();
        r10.getMeasuredWidth();
        r10.getY();
        Intrinsics.m("mOBubbleLayout");
        throw null;
    L9:
        if (r3 == 5) goto L92;
        if (r3 != 48) goto L12;
        r10.getX();
        Intrinsics.m("mOBubbleLayout");
        throw null;
    L12:
        if (r3 == 80) goto L88;
        View r4 = r10.getChildAt(0);
        if (r4 == null) goto L16;
        float r5 = r4.getX();
    L17:
        r10.setPivotY(0.0f);
        r10.setPivotX(r5 + 0.0f);
        float r9 = 1.0f;
        PathInterpolator r6 = new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f);
        PathInterpolator r7 = new PathInterpolator(0.0f, 0.0f, 1.0f, 1.0f);
        if (r15 == false) goto L20;
        float r8 = 0.0f;
    L21:
        if (r15 == false) goto L23;
        float r11 = 1.0f;
    L25:
        if (r10.getAlpha() != 0.0f) goto L27;
    L29:
        ObjectAnimator r12 = ObjectAnimator.ofFloat(r10, "alpha", new float[]{r8, r11});
        if (r15 == true) goto L33;
        r6 = r7;
    L33:
        r12.setInterpolator(r6);
        if (r15 == false) goto L37;
        int r13 = HttpStatus.SC_MULTIPLE_CHOICES;
    L38:
        r12.setDuration(r13);
        r10.setVisibility(0);
        final Ref.ObjectRef r14 = new Ref.ObjectRef();
        r14.b = null;
        AnimatorSet r16 = this.c;
        if (r16 == null) goto L42;
        r16.play(r12);
    L42:
        if (r15 == false) goto L44;
        final float r17 = 0.5f;
    L45:
        if (r15 == false) goto L47;
        float r18 = 1.0f;
    L49:
        if (Companion.a(0) == 48) goto L51;
        int r1 = 1;
    L53:
        if (r15 == false) goto L55;
        Resources r19 = Resources.getSystem();
        Intrinsics.e(r19, "Resources.getSystem()");
        float r20 = -TypedValue.applyDimension(1, 10, r19.getDisplayMetrics());
    L56:
        float r2 = r1;
        final float r110 = r20 * r2;
        if (r15 == false) goto L59;
        float r0 = 0.0f;
    L60:
        final float r21 = r0 * r2;
        if (r15 == false) goto L63;
        final float r22 = 0.0f;
    L64:
        if (r15 == false) goto L66;
        final float r23 = 10000.0f;
    L67:
        Collection r24 = ViewPropertySpringAnimatorExtKt.a(r10).b.values();
        if ((r24 instanceof Collection) == true) goto L70;
    L72:
        Iterator r25 = r24.iterator();
    L74:
        if (r25.hasNext() == false) goto L78;
        if (((SpringAnimation) r25.next()).f == false) goto L74;
    L79:
        if (r15 == false) goto L81;
        r9 = 0.8f;
    L81:
        ViewPropertySpringAnimator r26 = ViewPropertySpringAnimatorExtKt.a(r10);
        r26.c = r9;
        r26.f159d = 439.0f;
        ViewPropertySpringAnimator.b(r26, null, r23);
        final float r27 = r18;
        r26.f = new OPopover$animatorEasyInOut$$inlined$apply$lambda$1(r10, r22, r23, r17, r27, r110, r21);
        r14.b = r26;
        AnimatorSet r28 = this.c;
        if (r28 == null) goto L84;
        r28.addListener(new OPopover$animatorEasyInOut$2(this, r15, r10, r14));
    L84:
        AnimatorSet r111 = this.c;
        if (r111 == null) goto L101;
        r111.start();
        return;
    L101:
        return;
    L78:
        r10.setScaleX(r17);
        r10.setScaleY(r17);
        r10.setTranslationY(r110);
        CommonFloatProperty r29 = new CommonFloatProperty();
        r29.f265a = r22;
        r10.setTag(R.id.o_popover_anim_p, r29);
        goto L79
    L70:
        if (r24.isEmpty() == false) goto L72;
    L66:
        r23 = 0.0f;
        goto L67
    L63:
        r22 = 10000.0f;
        goto L64
    L59:
        Resources r30 = Resources.getSystem();
        Intrinsics.e(r30, "Resources.getSystem()");
        r0 = -TypedValue.applyDimension(1, 10, r30.getDisplayMetrics());
        goto L60
    L55:
        r20 = 0.0f;
        goto L56
    L51:
        r1 = -1;
        goto L53
    L47:
        r18 = 0.5f;
        goto L49
    L44:
        r17 = 1.0f;
        goto L45
    L37:
        r13 = 100;
        goto L38
    L27:
        if (r10.getAlpha() == 1.0f) goto L29;
        r8 = r10.getAlpha();
        goto L29
    L23:
        r11 = 0.0f;
        goto L25
    L20:
        r8 = 1.0f;
        goto L21
    L16:
        r5 = 0.0f;
        goto L17
    L88:
        r10.getX();
        Intrinsics.m("mOBubbleLayout");
        throw null;
    L92:
        r10.getX();
        r10.getY();
        Intrinsics.m("mOBubbleLayout");
        throw null;
    L96:
        Intrinsics.m("mWindowFrame");
        throw null;
    }

    public final void c() {
        Activity r4 = null;
        Intrinsics.f(null, "activity");
        Window r5 = r4.getWindow();     // Catch: Exception -> L5
        Intrinsics.e(r5, "activity.window");     // Catch: Exception -> L5
        ViewGroup r6 = (ViewGroup) r5.getDecorView().findViewById(android.R.id.content);     // Catch: Exception -> L5
    L7:
        if (r6 == null) goto L14;
        Sequence<View> r0 = ViewGroupKt.getChildren(r6);
        if (r0 == null) goto L18;
        FilteringSequence.AnonymousClass1 r1 = new FilteringSequence.AnonymousClass1(new FilteringSequence(r0, true, OPopover$clearFakeAnchorViewIfNecessary$1.b));
    L12:
        if (r1.hasNext() == false) goto L19;
        r6.removeView((View) r1.next());
        L.a("OPopover", "remove fake anchor view");
        goto L12
    L19:
        return;
    L18:
        return;
    L14:
        return;
    L5:
        e = move-exception;
        L.c("ViewUtil", "getActivityContentView, error", e);
        r6 = null;
        goto L7
    }

    public final void d() {
        AnimatorSet r0 = this.c;
        if (r0 == null) goto L5;
        r0.removeAllListeners();
    L5:
        AnimatorSet r1 = this.c;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        this.c = null;
        c();
        throw null;
    }

    @Override // android.widget.PopupWindow
    public final void dismiss() {
        if (this.b == true) goto L6;
        b(false);
        getContentView().removeCallbacks(null);
        return;
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View r3, int r4, int r5, int r6) {
        int r7 = Companion.a(r6);
        Pair r0 = a(r4);     // Catch: Exception -> L8
        super.showAsDropDown(r3, r4 - ((Number) r0.b).intValue(), r5 - ((Number) r0.c).intValue(), r7);     // Catch: Exception -> L8
        this.b = false;     // Catch: Exception -> L8
        ViewGroup r2 = this.f263a;     // Catch: Exception -> L8
        if (r2 == null) goto L6;
        r2.setVisibility(0);     // Catch: Exception -> L8
        return;
    L6:
        Intrinsics.m("mWindowFrame");     // Catch: Exception -> L8
        throw null;     // Catch: Exception -> L8
    L8:
        e = move-exception;
        L.c("OPopover", "showAsDropDown, error", e);
    }

    @Override // android.widget.PopupWindow
    public final void showAtLocation(View r3, int r4, int r5, int r6) {
        Intrinsics.f(r3, "anchor");
        int r7 = Companion.a(r4);
        Pair r0 = a(r5);     // Catch: Exception -> L8
        super.showAtLocation(r3, r7, r5 - ((Number) r0.b).intValue(), r6 - ((Number) r0.c).intValue());     // Catch: Exception -> L8
        this.b = false;     // Catch: Exception -> L8
        ViewGroup r2 = this.f263a;     // Catch: Exception -> L8
        if (r2 == null) goto L6;
        r2.setVisibility(0);     // Catch: Exception -> L8
        return;
    L6:
        Intrinsics.m("mWindowFrame");     // Catch: Exception -> L8
        throw null;     // Catch: Exception -> L8
    L8:
        e = move-exception;
        L.c("OPopover", "showAtLocation, error", e);
    }
}
