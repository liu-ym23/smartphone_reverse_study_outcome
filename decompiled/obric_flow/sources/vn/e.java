package vn;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends a {
    public final /* synthetic */ int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f22628h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f22629i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f22630j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f22631k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f22632l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f22633m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f22634n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public on.h f22635o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Handler f22636p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Runnable f22637q;

    public e(int r5, LynxContext r10, un.a r11, rn.a r12, int r13) {
        this.g = r13;
        switch(r13) {
            case 1: goto L9;
            default: goto L4;
        };
    L4:
        super(r5, r10, r11, r12);
        this.f22629i = 500;
        this.f22628h = com.lynx.tasm.utils.g.a(10.0f, 0.0f);
        this.f22636p = null;
        this.f22630j = 0.0f;
        this.f22631k = 0.0f;
        this.f22632l = 0.0f;
        this.f22633m = 0.0f;
        this.f22635o = null;
        this.f22634n = false;
        this.f22637q = new com.obric.oui.lisitem.a(this, 29);
        ReadableMap r14 = r11.e;
        if (r14 == null) goto L14;
        this.f22629i = r14.getLong("minDuration", 500);
        this.f22628h = com.lynx.tasm.utils.g.a(r14.getLong("maxDistance", 10), 0.0f);
        return;
    L14:
        return;
    L9:
        super(r5, r10, r11, r12);
        this.f22628h = com.lynx.tasm.utils.g.a(10.0f, 0.0f);
        this.f22629i = 500;
        this.f22630j = 0.0f;
        this.f22631k = 0.0f;
        this.f22632l = 0.0f;
        this.f22633m = 0.0f;
        this.f22634n = false;
        this.f22635o = null;
        this.f22636p = null;
        this.f22637q = new h(this, 0);
        ReadableMap r15 = r11.e;
        if (r15 == null) goto L15;
        this.f22629i = r15.getLong("maxDuration", 500);
        this.f22628h = com.lynx.tasm.utils.g.a(r15.getLong("maxDistance", 10), 0.0f);
        return;
    }

    @Override // vn.a
    public final void d() {
        switch(this.g) {
            case 0: goto L14;
            default: goto L5;
        };
    L5:
        if (this.f22607b == 4) goto L22;
        this.f22607b = 4;
        on.h r5 = this.f22635o;
        if (((Boolean) this.d.get("onEnd")).booleanValue() == true) goto L9;
        return;
    L9:
        if (this.f22634n == true) goto L24;
        this.f22634n = true;
        f("onEnd", c(r5));
        return;
    L24:
        return;
    L22:
        return;
    L14:
        if (this.f22607b == 4) goto L25;
        this.f22607b = 4;
        on.h r10 = this.f22635o;
        if (((Boolean) this.d.get("onEnd")).booleanValue() == true) goto L18;
        return;
    L18:
        if (this.f22634n == true) goto L27;
        this.f22634n = true;
        f("onEnd", c(r10));
        return;
    L27:
        return;
    }

    @Override // vn.a
    public final void e(MotionEvent r5, on.h r10, float r11, float r12, boolean r13, tn.a r14) {
        switch(this.g) {
            case 0: goto L51;
            default: goto L4;
        };
    L4:
        this.f22635o = r10;
        if (r5 != null) goto L10;
        this.f22607b = 5;
        Handler r15 = this.f22636p;
        if (r15 == null) goto L86;
        r15.removeCallbacksAndMessages(null);
        this.f22636p = null;
        return;
    L86:
        return;
    L10:
        if (this.f22607b < 3) goto L14;
        Handler r16 = this.f22636p;
        if (r16 == null) goto L88;
        r16.removeCallbacksAndMessages(null);
        this.f22636p = null;
        return;
    L88:
        return;
    L14:
        int r17 = r5.getActionMasked();
        HashMap r18 = this.d;
        if (r17 != 0) goto L17;
        this.f22630j = r5.getX();
        this.f22631k = r5.getY();
        this.f22634n = false;
        this.f22607b = 1;
        if (((Boolean) r18.get("onBegin")).booleanValue() == false) goto L45;
        f("onBegin", c(r10));
    L45:
        Handler r19 = this.f22636p;
        if (r19 != null) goto L48;
        this.f22636p = new Handler(Looper.getMainLooper());
    L49:
        this.f22636p.postDelayed((h) this.f22637q, this.f22629i);
        return;
    L48:
        r19.removeCallbacksAndMessages(null);
        goto L49
    L17:
        if (r17 == 1) goto L25;
        if (r17 != 2) goto L94;
        this.f22632l = r5.getX();
        this.f22633m = r5.getY();
        float r20 = Math.abs(this.f22632l - this.f22630j);
        float r21 = Math.abs(this.f22633m - this.f22631k);
        float r22 = this.f22628h;
        if (r20 <= r22) goto L23;
    L24:
        g();
        return;
    L23:
        if (r21 > r22) goto L24;
        return;
    L94:
        return;
    L25:
        this.f22632l = r5.getX();
        this.f22633m = r5.getY();
        if (this.f22607b < 3) goto L28;
        g();
    L38:
        Handler r23 = this.f22636p;
        if (r23 == null) goto L92;
        r23.removeCallbacksAndMessages(null);
        this.f22636p = null;
        return;
    L92:
        return;
    L28:
        this.f22607b = 2;
        if (((Boolean) r18.get("onStart")).booleanValue() == false) goto L33;
        f("onStart", c(r10));
    L33:
        if (((Boolean) r18.get("onEnd")).booleanValue() == false) goto L38;
        if (this.f22634n == true) goto L38;
        this.f22634n = true;
        f("onEnd", c(r10));
        goto L38
    L51:
        this.f22635o = r10;
        if (r5 != null) goto L55;
        this.f22607b = 5;
        return;
    L55:
        if (this.f22607b < 3) goto L59;
        Handler r24 = this.f22636p;
        if (r24 == null) goto L96;
        r24.removeCallbacksAndMessages(null);
        this.f22636p = null;
        return;
    L96:
        return;
    L59:
        int r25 = r5.getActionMasked();
        if (r25 == 0) goto L76;
        if (r25 != 1) goto L63;
        Handler r26 = this.f22636p;
        if (r26 == null) goto L75;
        r26.removeCallbacksAndMessages(null);
        this.f22636p = null;
    L75:
        g();
        return;
    L63:
        if (r25 != 2) goto L102;
        this.f22632l = r5.getX();
        this.f22633m = r5.getY();
        float r27 = Math.abs(this.f22632l - this.f22630j);
        float r28 = Math.abs(this.f22633m - this.f22631k);
        float r29 = this.f22628h;
        if (r27 <= r29) goto L68;
    L69:
        g();
        Handler r30 = this.f22636p;
        if (r30 == null) goto L99;
        r30.removeCallbacksAndMessages(null);
        this.f22636p = null;
        return;
    L99:
        return;
    L68:
        if (r28 > r29) goto L69;
        return;
    L102:
        return;
    L76:
        this.f22630j = r5.getX();
        this.f22631k = r5.getY();
        this.f22634n = false;
        this.f22607b = 1;
        if (((Boolean) this.d.get("onBegin")).booleanValue() == false) goto L80;
        f("onBegin", c(r10));
    L80:
        Handler r31 = this.f22636p;
        if (r31 != null) goto L83;
        this.f22636p = new Handler(Looper.getMainLooper());
    L84:
        this.f22636p.postDelayed((com.obric.oui.lisitem.a) this.f22637q, this.f22629i);
        return;
    L83:
        r31.removeCallbacksAndMessages(null);
        goto L84
    }

    @Override // vn.a
    public final void g() {
        switch(this.g) {
            case 0: goto L14;
            default: goto L5;
        };
    L5:
        if (this.f22607b == 3) goto L22;
        this.f22607b = 3;
        on.h r5 = this.f22635o;
        if (((Boolean) this.d.get("onEnd")).booleanValue() == true) goto L9;
        return;
    L9:
        if (this.f22634n == true) goto L24;
        this.f22634n = true;
        f("onEnd", c(r5));
        return;
    L24:
        return;
    L22:
        return;
    L14:
        if (this.f22607b == 3) goto L25;
        this.f22607b = 3;
        on.h r10 = this.f22635o;
        if (((Boolean) this.d.get("onEnd")).booleanValue() == true) goto L18;
        return;
    L18:
        if (this.f22634n == true) goto L27;
        this.f22634n = true;
        f("onEnd", c(r10));
        return;
    L27:
        return;
    }

    @Override // vn.a
    public final void h() {
        switch(this.g) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.f22607b = 0;
        this.f22634n = false;
        return;
    L6:
        this.f22607b = 0;
        this.f22634n = false;
    }
}
