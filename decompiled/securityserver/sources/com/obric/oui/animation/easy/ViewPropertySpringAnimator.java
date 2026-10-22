package com.obric.oui.animation.easy;

import android.view.View;
import com.bytedance.apm.constant.AgentConstants;
import com.github.lcdsmao.springx.SpringAnimationHolder;
import com.obric.oui.animation.engine.DynamicAnimation;
import com.obric.oui.animation.engine.FloatPropertyCompat;
import com.obric.oui.animation.engine.SpringAnimation;
import com.obric.oui.animation.engine.SpringForce;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ViewPropertySpringAnimator<T extends View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f158a;
    public final LinkedHashMap b;
    public float c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f159d;
    public AnimatorListener e;
    public DynamicAnimation.OnAnimationUpdateListener f;
    public final View g;

    @Metadata
    public interface AnimatorListener<T extends View> {

        @Metadata
        public static final class DefaultImpls {
        }

        void a(ViewPropertySpringAnimator r1);

        void b(ViewPropertySpringAnimator r1);
    }

    public ViewPropertySpringAnimator(View r2) {
        Intrinsics.f(r2, "view");
        this.g = r2;
        this.f158a = new ArrayList();
        this.b = new LinkedHashMap();
        this.c = 0.5f;
        this.f159d = 1500.0f;
    }

    public static /* synthetic */ void b(ViewPropertySpringAnimator r1, FloatPropertyCompat r2, float r3) {
        r1.a(r2, r3, ViewPropertySpringAnimator$animateProperty$2.b);
    }

    public static void c(ViewPropertySpringAnimator r1, final Function1 r2, final Function1 r3, final Function1 r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r2 = ViewPropertySpringAnimator$setListener$1.b;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = ViewPropertySpringAnimator$setListener$2.b;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = ViewPropertySpringAnimator$setListener$3.b;
    L11:
        Intrinsics.f(r2, AgentConstants.ON_START);
        Intrinsics.f(r3, "onCancel");
        Intrinsics.f(r4, "onEnd");
        r1.e = new ViewPropertySpringAnimator$setListener$4(r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.obric.oui.animation.easy.ViewPropertySpringAnimator$cleanSelfOnEnd$updateListener$1, java.lang.Object] */
    public final void a(final FloatPropertyCompat r7, float r8, Function1 r9) {
        Intrinsics.f(r7, "property");
        Intrinsics.f(r9, "config");
        LinkedHashMap r0 = this.b;
        SpringAnimation r1 = (SpringAnimation) r0.get(r7);
        if (r1 != null) goto L15;
        r1 = new SpringAnimation(this.g, r7);
        r1.t = null;
        r1.u = Float.MAX_VALUE;
        r1.v = false;
        final ?? r3 = new ViewPropertySpringAnimator$cleanSelfOnEnd$updateListener$1(this);
        if (r1.f == true) goto L14;
        ArrayList r4 = r1.l;
        if (r4.contains(r3) == true) goto L9;
        r4.add(r3);
    L9:
        DynamicAnimation.OnAnimationEndListener r5 = new ViewPropertySpringAnimator$cleanSelfOnEnd$listener$1(this, r7, r3);
        ArrayList r6 = r1.k;
        if (r6.contains(r5) == true) goto L12;
        r6.add(r5);
    L12:
        r0.put(r7, r1);
        goto L15
    L14:
        throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
    L15:
        SpringAnimationConfig r10 = new SpringAnimationConfig();
        r10.j = r8;
        r10.b = Float.MAX_VALUE;
        r10.c = -3.4028235E38f;
        r10.e = 0.5f;
        r10.f = 0.5f;
        r10.h = 1500.0f;
        r10.i = 1500.0f;
        r9.invoke(r10);
        r10.e = this.c;
        r10.h = this.f159d;
        this.f158a.add(new SpringAnimationHolder(r1, r10));
    }

    public final void d() {
        ArrayList r0 = this.f158a;
        if (r0.isEmpty() == true) goto L34;
        List r1 = CollectionsKt.q(r0);
        r0.clear();
        AnimatorListener r2 = this.e;
        if (r2 == null) goto L8;
        r2.b(this);
    L8:
        Iterator r8 = r1.iterator();
    L10:
        if (r8.hasNext() == false) goto L38;
        SpringAnimationHolder r3 = (SpringAnimationHolder) r8.next();
        SpringAnimationConfig r4 = r3.b;
        r4.getClass();
        SpringAnimation r5 = r3.f91a;
        Intrinsics.f(r5, "animation");
        r5.h = r4.c;
        r5.g = Float.MAX_VALUE;
        if (r4.f156a == false) goto L15;
        r5.b = r4.b;
        r5.c = true;
    L15:
        if (r5.t != null) goto L17;
        r5.t = new SpringForce();
    L17:
        SpringForce r6 = r5.t;
        Intrinsics.e(r6, "animation.spring");
        if (r4.f157d == false) goto L20;
        float r7 = r4.f;
    L22:
        if (r7 < 0.0f) goto L33;
        r6.b = r7;
        r6.c = false;
        SpringForce r9 = r5.t;
        Intrinsics.e(r9, "animation.spring");
        if (r4.g == false) goto L26;
        float r10 = r4.i;
    L28:
        if (r10 <= 0.0f) goto L31;
        r9.f170a = Math.sqrt(r10);
        r9.c = false;
        SpringForce r11 = r5.t;
        Intrinsics.e(r11, "animation.spring");
        r11.i = r4.j;
        r5.d();
        goto L10
    L31:
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    L26:
        r10 = r4.h;
        goto L28
    L33:
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    L20:
        r7 = r4.e;
        goto L22
    L38:
        return;
    }
}
