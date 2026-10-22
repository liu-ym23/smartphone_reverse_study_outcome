package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import com.obric.common.oea.foundation.animation.builder.PropertyAnimatable;
import com.obric.common.oea.foundation.animation.builder.PropertyAnimatableKt;
import com.obric.common.oea.foundation.animation.manager.AnimationManager;
import com.obric.common.oea.foundation.animation.spec.AnimationSpecKt;
import com.obric.common.oea.foundation.animation.spec.spring.FloatSpringSpec;
import com.obric.common.oea.foundation.animation.token.AnimationProperty;
import com.obric.common.oui.R;
import com.obric.oui.common.style.OUILayoutHelper;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.utils.log.L;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class OShadowFrame extends OUIFrameLayout {
    public AnimationManager k;
    public AnimationManager l;
    public int m;
    public final int n;
    public final float o;
    public final float p;
    public final float q;
    public OUIFrameLayout r;
    public final List s;
    public final List t;

    @Metadata
    public static final class Companion {
    }

    public OShadowFrame(Context r10, AttributeSet r11, int r12) {
        Intrinsics.f(r10, "context");
        super(r10, r11, r12, 8);
        this.o = 1.0f;
        this.p = 1.0f;
        this.q = 0.01f;
        TypedArray r13 = r10.obtainStyledAttributes(r11, R.styleable.q);
        Intrinsics.e(r13, "context.obtainStyledAttr…R.styleable.OShadowFrame)");
        this.r = new OUIFrameLayout(r10, null, 0, 14);
        this.m = r13.getColor(0, getResources().getColor(com.bytedance.securityserver.R.color.oui_floating_button_bg_color_1, null));
        this.n = r13.getColor(1, getResources().getColor(com.bytedance.securityserver.R.color.oui_floating_button_bg_color_1, null));
        int r1 = this.m;
        if (r1 == 0) goto L9;
        OUIFrameLayout r6 = this.r;
        if (r6 == null) goto L7;
        r6.setBackgroundColor(r1);
        goto L9
    L7:
        Intrinsics.m("contentView");
        throw null;
    L9:
        this.p = r13.getFloat(8, 1.0f);
        setChangeAlphaWhenPress(false);
        int r14 = r13.getDimensionPixelSize(4, 0);
        int r0 = r13.getDimensionPixelSize(5, 0);
        int r2 = r13.getDimensionPixelSize(6, 0);
        int r7 = r13.getDimensionPixelSize(3, 0);
        int r8 = r13.getDimensionPixelSize(9, 0);
        OUIFrameLayout r9 = this.r;
        if (r9 == null) goto L42;
        r9.setPadding(r14, r2, r0, r7);
        OUIFrameLayout r15 = this.r;
        if (r15 == null) goto L40;
        r15.setRadius(r8);
        int r16 = r13.getColor(7, 0);
        OUIFrameLayout r3 = this.r;
        if (r3 == null) goto L38;
        r3.setOverridePressColor(r16);
        OUIFrameLayout r17 = this.r;
        if (r17 == null) goto L36;
        r17.c("OShadowFrame");
        OUIFrameLayout r18 = this.r;
        if (r18 == null) goto L34;
        addView(r18, new FrameLayout.LayoutParams(-1, -1));
        setShadowCornerRadius(r8);
        OUIFrameLayout r19 = this.r;
        if (r19 == null) goto L32;
        j(r10, r19, r13);
        OUIFrameLayout r110 = this.r;
        if (r110 == null) goto L30;
        r110.setChangeAlphaWhenDisable(false);
        setChangeAlphaWhenDisable(false);
        int r111 = r13.getResourceId(10, 0);
        int r4 = r13.getResourceId(11, 0);
        if (r111 == 0) goto L26;
        ArrayList r112 = OUILayoutHelper.j(r10, r111);
        List r113 = CollectionsKt.k(new Shadow[]{(Shadow) r112.get(0), (Shadow) r112.get(1)});
        this.s = r113;
        Shadow r114 = (Shadow) CollectionsKt.g(r113, 0);
        List r5 = this.s;
        Intrinsics.c(r5);
        g(r114, (Shadow) CollectionsKt.g(r5, 1));
    L26:
        if (r4 == 0) goto L28;
        ArrayList r115 = OUILayoutHelper.j(r10, r4);
        this.t = CollectionsKt.k(new Shadow[]{(Shadow) r115.get(0), (Shadow) r115.get(1)});
    L28:
        r13.recycle();
        setClipChildren(false);
        setClickable(true);
        k(isEnabled());
        return;
    L30:
        Intrinsics.m("contentView");
        throw null;
    L32:
        Intrinsics.m("contentView");
        throw null;
    L34:
        Intrinsics.m("contentView");
        throw null;
    L36:
        Intrinsics.m("contentView");
        throw null;
    L38:
        Intrinsics.m("contentView");
        throw null;
    L40:
        Intrinsics.m("contentView");
        throw null;
    L42:
        Intrinsics.m("contentView");
        throw null;
    }

    public static final List h(OShadowFrame r10, float r11, float r12, float r13, List r14, List r15) {
        r10.getClass();
        float r16 = RangesKt.a((r11 - r12) / (r13 - r12), 0.0f, 1.0f);
        if (r14 == null) goto L17;
        if (r15 != null) goto L6;
        return r14;
    L6:
        if (r14.size() != r15.size()) goto L19;
        Iterator r17 = r14.iterator();
        Iterator r18 = r15.iterator();
        ArrayList r19 = new ArrayList(Math.min(CollectionsKt.e(r14, 10), CollectionsKt.e(r15, 10)));
    L9:
        if (r17.hasNext() == false) goto L14;
        if (r18.hasNext() == false) goto L14;
        Object r110 = r17.next();
        Shadow r111 = (Shadow) r18.next();
        Shadow r112 = (Shadow) r110;
        int r0 = r112.f204a;
        int r1 = r111.f204a;
        int r2 = (r0 >> 24) & 255;
        int r3 = (r0 >> 16) & 255;
        int r4 = (r0 >> 8) & 255;
        int r5 = r0 & 255;
        float r9 = r2;
        int r6 = (int) (((((r1 >> 24) & 255) - r2) * r16) + r9);
        float r7 = r3;
        int r8 = (int) (((((r1 >> 16) & 255) - r3) * r16) + r7);
        float r20 = r4;
        int r21 = (int) (((((r1 >> 8) & 255) - r4) * r16) + r20);
        r19.add(new Shadow((((r6 << 24) | (r8 << 16)) | (r21 << 8)) | ((int) ((((r1 & 255) - r5) * r16) + r5)), Utils.a(r112.b, r111.b, r16), Utils.a(r112.c, r111.c, r16), Utils.a(r112.f205d, r111.f205d, r16), Utils.a(r112.e, r111.e, r16)));
    L14:
        return r19;
    L19:
        return r14;
    L17:
        return r14;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r3) {
        Intrinsics.f(r3, "event");
        boolean r0 = super.dispatchTouchEvent(r3);
        int r4 = r3.getAction();
        if (r4 == 0) goto L9;
        if (r4 != 1) goto L6;
    L8:
        i(false);
    L10:
        return r0;
    L6:
        if (r4 == 3) goto L8;
    L9:
        i(true);
        goto L10
    }

    @NotNull
    public final OUIFrameLayout getContentView() {
        OUIFrameLayout r0 = this.r;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("contentView");
        throw null;
    }

    public final void i(boolean r12) {
        if (isEnabled() == true) goto L6;
        L.a("OShadowFrame", "doPressAnim, skip, isEnabled=false");
        return;
    L6:
        L.a("OShadowFrame", "doPressAnim: " + r12);
        AnimationManager r0 = this.k;
        if (r0 == null) goto L9;
        int r2 = AnimationManager.f122d;
        r0.a(false);
    L9:
        AnimationManager r1 = this.l;
        if (r1 == null) goto L12;
        int r3 = AnimationManager.f122d;
        r1.a(false);
    L12:
        AnimationProperty.FloatProperty r4 = AnimationProperty.FloatProperty.e;
        AnimationProperty.FloatProperty r6 = AnimationProperty.FloatProperty.c;
        float r5 = this.q;
        if (r12 == false) goto L15;
        PropertyAnimatable.Builder r13 = PropertyAnimatableKt.a(this);
        Float r7 = Float.valueOf(getScaleX());
        float r8 = this.p;
        FloatSpringSpec r9 = AnimationSpecKt.a();
        r9.b = r5;
        r13.b(r6, r7, r8, r9, null);
        Float r10 = Float.valueOf(getScaleY());
        float r11 = this.p;
        FloatSpringSpec r14 = AnimationSpecKt.a();
        r14.b = r5;
        r13.b(r4, r10, r11, r14, null);
        r13.f105d = new OShadowFrame$doPressAnim$$inlined$let$lambda$1(this);
        this.k = PropertyAnimatable.a(r13.a());
        return;
    L15:
        PropertyAnimatable.Builder r15 = PropertyAnimatableKt.a(this);
        Float r16 = Float.valueOf(getScaleX());
        FloatSpringSpec r17 = AnimationSpecKt.a();
        r17.b = r5;
        r15.b(r6, r16, this.o, r17, null);
        Float r18 = Float.valueOf(getScaleY());
        FloatSpringSpec r19 = AnimationSpecKt.a();
        r19.b = r5;
        r15.b(r4, r18, this.o, r19, null);
        r15.f105d = new OShadowFrame$doPressAnim$$inlined$let$lambda$2(this);
        this.l = PropertyAnimatable.a(r15.a());
    }

    public abstract void j(Context r1, FrameLayout r2, TypedArray r3);

    public void k(boolean r3) {
        if (r3 == false) goto L9;
        OUIFrameLayout r4 = this.r;
        if (r4 == null) goto L7;
        r4.setBackgroundColor(this.m);
        return;
    L7:
        Intrinsics.m("contentView");
        throw null;
    L9:
        OUIFrameLayout r5 = this.r;
        if (r5 == null) goto L13;
        r5.setBackgroundColor(this.n);
        return;
    L13:
        Intrinsics.m("contentView");
        throw null;
    }

    public final void setBgColor(@ColorInt int r1) {
        this.m = r1;
        k(isEnabled());
    }

    public final void setContentView(@NotNull OUIFrameLayout r2) {
        Intrinsics.f(r2, "<set-?>");
        this.r = r2;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        k(r1);
    }

    public final void setPressColor(@ColorInt int r4) {
        OUIFrameLayout r0 = this.r;
        if (r0 == null) goto L10;
        r0.setOverridePressColor(r4);
        OUIFrameLayout r3 = this.r;
        if (r3 == null) goto L8;
        r3.c("OShadowFrame");
        return;
    L8:
        Intrinsics.m("contentView");
        throw null;
    L10:
        Intrinsics.m("contentView");
        throw null;
    }
}
