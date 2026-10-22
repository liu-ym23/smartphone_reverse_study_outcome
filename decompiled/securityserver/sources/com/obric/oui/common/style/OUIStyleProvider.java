package com.obric.oui.common.style;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.securityserver.R;
import com.obric.oui.common.SdkInit;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class OUIStyleProvider implements IOUIStyleProvider {
    public final OUILayoutHelper b;
    public final OUIAlphaHelper c;
    public OUIEffectHelper e;

    @Metadata
    public static final class Companion {
    }

    static {
        new SdkInit();
    }

    public OUIStyleProvider(Context r7, AttributeSet r8, int r9, int r10) {
        Intrinsics.f(r7, "context");
        OUILayoutHelper r0 = new OUILayoutHelper();
        r0.c = 0;
        r0.e = 0;
        r0.f = 0;
        r0.i = 0;
        r0.j = 0;
        r0.k = 0;
        r0.l = 0;
        r0.n = 255;
        r0.o = 0;
        r0.p = 0;
        r0.q = 0;
        r0.s = 255;
        r0.t = 0;
        r0.u = 0;
        r0.v = 0;
        r0.x = 255;
        r0.y = 0;
        r0.z = 0;
        r0.A = 0;
        r0.C = 255;
        r0.E = 1.0f;
        r0.I = 0;
        r0.f198J = 0;
        r0.K = 0;
        r0.L = 0;
        r0.O = 0;
        r0.P = 1;
        r0.Q = 0;
        r0.S = false;
        r0.T = new Path();
        r0.U = true;
        r0.V = 0;
        r0.X = ViewCompat.MEASURED_STATE_MASK;
        r0.Y = 0;
        r0.Z = 0;
        r0.a0 = 0;
        r0.b0 = 0;
        r0.c0 = 0;
        r0.d0 = 0;
        r0.h0 = false;
        r0.i0 = new Shadow(Color.parseColor("#00000000"));
        r0.j0 = new Shadow(Color.parseColor("#00000000"));
        r0.k0 = 0.0f;
        r0.b = r7;
        r0.e0 = r8;
        r0.f0 = r9;
        r0.g0 = r10;
        this.b = r0;
        OUIAlphaHelper r1 = new OUIAlphaHelper();
        r1.c = true;
        r1.e = false;
        r1.f = true;
        r1.i = false;
        r1.j = 0;
        r1.k = -1;
        r1.l = 0.3f;
        r1.m = r7;
        r1.n = r8;
        r1.o = r9;
        r1.p = r10;
        this.c = r1;
    }

    public final OUIEffectHelper a() {
        OUIEffectHelper r0 = this.e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("mOUIEffectHelper");
        throw null;
    }

    public final void b(View r21) {
        Intrinsics.f(r21, "owner");
        OUILayoutHelper r2 = this.b;
        r2.getClass();
        r2.R = new WeakReference(r21);
        Context r3 = r2.b;
        int r5 = ContextCompat.getColor(r3, R.color.oui_line_2);
        r2.m = r5;
        r2.r = r5;
        int r4 = ContextCompat.getColor(r3, R.color.oui_line_2);
        r2.B = r4;
        r2.w = r4;
        new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        Paint r6 = new Paint();
        r2.F = r6;
        r6.setAntiAlias(true);
        Resources.Theme r7 = r3.getTheme();
        if (OUIResHelper.f200a != null) goto L6;
        OUIResHelper.f200a = new TypedValue();
    L6:
        if (r7.resolveAttribute(R.attr.oui_general_shadow_alpha, OUIResHelper.f200a, true) == true) goto L8;
        float r8 = -1.0f;
    L10:
        if (r8 <= 0.0f) goto L12;
        r2.W = r8;
    L12:
        r2.N = new RectF();
        boolean r9 = r2.h0;
        int r10 = r2.g0;
        int r11 = r2.f0;
        AttributeSet r12 = r2.e0;
        int r13 = 0;
        if (r9 == true) goto L19;
        if (r12 != null) goto L19;
        if (r11 != 0) goto L19;
        if (r10 != 0) goto L19;
        int r14 = 0;
        int r15 = 0;
        boolean r18 = false;
    L140:
        if (r15 != 0) goto L150;
        if (r18 == false) goto L150;
        if (OUIResHelper.f200a != null) goto L146;
        OUIResHelper.f200a = new TypedValue();
    L146:
        if (r3.getTheme().resolveAttribute(R.attr.oui_general_shadow_elevation, OUIResHelper.f200a, true) == false) goto L149;
        r13 = TypedValue.complexToDimensionPixelSize(OUIResHelper.f200a.data, r3.getResources().getDisplayMetrics());
    L149:
        r15 = r13;
    L150:
        r2.y(r2.W, r14, r15);
        OUIAlphaHelper r16 = this.c;
        r16.getClass();
        r16.b = new WeakReference(r21);
        r16.d(r21);
        this.e = new OUIEffectHelper(r21);
        return;
    L19:
        TypedArray r17 = r3.obtainStyledAttributes(r12, com.obric.common.oui.R.styleable.u, r11, r10);
        int r19 = r17.getIndexCount();
        int r20 = 0;
        r15 = 0;
        r18 = false;
        int r110 = 0;
    L20:
        if (r20 >= r19) goto L135;
        int r111 = r17.getIndex(r20);
        if (r111 != 0) goto L24;
        r2.c = r17.getDimensionPixelSize(r111, r2.c);
    L126:
        if (r111 != 8) goto L129;
        r2.K = r17.getDimensionPixelSize(r111, 0);
    L129:
        if (r111 != 9) goto L132;
        r2.L = r17.getDimensionPixelSize(r111, 0);
    L132:
        if (r111 != 48) goto L134;
        r2.f198J = r17.getDimensionPixelSize(r111, 0);
    L134:
        r20 = r20 + 1;
        goto L20
    L24:
        if (r111 != 1) goto L27;
        r2.e = r17.getDimensionPixelSize(r111, r2.e);
        goto L126
    L27:
        if (r111 != 2) goto L30;
        r2.f = r17.getDimensionPixelSize(r111, r2.f);
        goto L126
    L30:
        if (r111 != 3) goto L33;
        r2.i = r17.getDimensionPixelSize(r111, r2.i);
        goto L126
    L33:
        if (r111 != 43) goto L36;
        r2.m = r17.getColor(r111, r2.m);
        goto L126
    L36:
        if (r111 != 44) goto L39;
        r2.j = r17.getDimensionPixelSize(r111, r2.j);
        goto L126
    L39:
        if (r111 != 45) goto L42;
        r2.k = r17.getDimensionPixelSize(r111, r2.k);
        goto L126
    L42:
        if (r111 != 46) goto L45;
        r2.l = r17.getDimensionPixelSize(r111, r2.l);
        goto L126
    L45:
        if (r111 != 4) goto L48;
        r2.r = r17.getColor(r111, r2.r);
        goto L126
    L48:
        if (r111 != 5) goto L51;
        r2.o = r17.getDimensionPixelSize(r111, r2.o);
        goto L126
    L51:
        if (r111 != 6) goto L54;
        r2.p = r17.getDimensionPixelSize(r111, r2.p);
        goto L126
    L54:
        if (r111 != 7) goto L57;
        r2.q = r17.getDimensionPixelSize(r111, r2.q);
        goto L126
    L57:
        if (r111 != 17) goto L60;
        r2.w = r17.getColor(r111, r2.w);
        goto L126
    L60:
        if (r111 != 20) goto L63;
        r2.t = r17.getDimensionPixelSize(r111, r2.t);
        goto L126
    L63:
        if (r111 != 19) goto L66;
        r2.u = r17.getDimensionPixelSize(r111, r2.u);
        goto L126
    L66:
        if (r111 != 18) goto L69;
        r2.v = r17.getDimensionPixelSize(r111, r2.v);
        goto L126
    L69:
        if (r111 != 28) goto L72;
        r2.B = r17.getColor(r111, r2.B);
        goto L126
    L72:
        if (r111 != 31) goto L75;
        r2.y = r17.getDimensionPixelSize(r111, r2.y);
        goto L126
    L75:
        if (r111 != 30) goto L78;
        r2.z = r17.getDimensionPixelSize(r111, r2.z);
        goto L126
    L78:
        if (r111 != 29) goto L81;
        r2.A = r17.getDimensionPixelSize(r111, r2.A);
        goto L126
    L81:
        if (r111 != 15) goto L84;
        r2.O = r17.getColor(r111, r2.O);
        goto L126
    L84:
        if (r111 != 16) goto L87;
        r2.P = r17.getDimensionPixelSize(r111, r2.P);
        goto L126
    L87:
        if (r111 != 27) goto L90;
        r110 = r17.getDimensionPixelSize(r111, 0);
        goto L126
    L90:
        if (r111 != 21) goto L93;
        r2.Q = r17.getColor(r111, r2.Q);
        goto L126
    L93:
        if (r111 != 41) goto L96;
        r2.U = r17.getBoolean(r111, r2.U);
        goto L126
    L96:
        if (r111 != 39) goto L99;
        r15 = r17.getDimensionPixelSize(r111, r15);
        goto L126
    L99:
        if (r111 != 37) goto L102;
        r2.W = r17.getFloat(r111, r2.W);
        goto L126
    L102:
        if (r111 != 49) goto L105;
        r18 = r17.getBoolean(r111, false);
        goto L126
    L105:
        if (r111 != 24) goto L108;
        r2.a0 = r17.getDimensionPixelSize(r111, 0);
        goto L126
    L108:
        if (r111 != 25) goto L111;
        r2.b0 = r17.getDimensionPixelSize(r111, 0);
        goto L126
    L111:
        if (r111 != 26) goto L114;
        r2.c0 = r17.getDimensionPixelSize(r111, 0);
        goto L126
    L114:
        if (r111 != 23) goto L117;
        r2.d0 = r17.getDimensionPixelSize(r111, 0);
        goto L126
    L117:
        if (r111 != 22) goto L120;
        r2.S = r17.getBoolean(r111, false);
        goto L126
    L120:
        if (r111 != 42) goto L123;
        r17.getBoolean(r111, false);
        goto L126
    L123:
        if (r111 != 47) goto L126;
        r2.I = r17.getDimensionPixelSize(r111, 0);
        goto L126
    L135:
        int r22 = r17.getResourceId(40, 0);
        if (r22 == 0) goto L138;
        r2.b(r3, r22);
    L139:
        r2.k0 = r17.getDimension(38, 0.0f);
        r17.recycle();
        r14 = r110;
        goto L140
    L138:
        OUILayoutHelper.p(r17, r2.i0, 13, 12, 10, 11, 14);
        OUILayoutHelper.p(r17, r2.j0, 35, 34, 32, 33, 36);
        goto L139
    L8:
        r8 = OUIResHelper.f200a.getFloat();
        goto L10
    }
}
