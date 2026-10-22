package vn;

import android.view.MotionEvent;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class g extends a {
    public final HashMap g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f22638h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f22639i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f22640j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f22641k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f22642l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public on.h f22643m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f22644n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f22645o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f22646p;

    public g(int r5, LynxContext r10, un.a r11, rn.a r12) {
        super(r5, r10, r11, r12);
        this.f22638h = com.lynx.tasm.utils.g.a(0.0f, 0.0f);
        this.f22639i = 0.0f;
        this.f22640j = 0.0f;
        this.f22641k = 0.0f;
        this.f22642l = 0.0f;
        this.f22644n = false;
        this.f22645o = false;
        this.f22646p = false;
        ReadableMap r13 = r11.e;
        if (r13 == null) goto L6;
        this.f22638h = com.lynx.tasm.utils.g.a(r13.getLong("minDistance", 0), 0.0f);
    L6:
        this.g = new HashMap();
    }

    @Override // vn.a
    public final void d() {
        this.f22607b = 4;
        j(this.f22643m);
    }

    @Override // vn.a
    public final void e(MotionEvent r5, on.h r10, float r11, float r12, boolean r13, tn.a r14) {
        if (r10 == null) goto L4;
        this.f22643m = r10;
    L4:
        if (r5 != null) goto L8;
        this.f22607b = 5;
        return;
    L8:
        if (this.f22607b >= 3) goto L61;
        int r15 = r5.getActionMasked();
        HashMap r16 = this.d;
        if (r15 == 0) goto L52;
        if (r15 != 1) goto L14;
        g();
        j(this.f22643m);
        return;
    L14:
        if (r15 != 2) goto L62;
        this.f22641k = r5.getX();
        this.f22642l = r5.getY();
        if (this.f22607b != 0) goto L25;
        this.f22607b = 1;
        if (((Boolean) r16.get("onBegin")).booleanValue() == false) goto L25;
        if (this.f22644n == true) goto L25;
        this.f22644n = true;
        f("onBegin", i(r10));
    L25:
        if (this.f22607b >= 3) goto L40;
        float r17 = Math.abs(this.f22641k - this.f22639i);
        float r18 = Math.abs(this.f22642l - this.f22640j);
        float r19 = this.f22638h;
        if (r17 > r19) goto L32;
        if (r18 <= r19) goto L40;
    L32:
        if (((Boolean) r16.get("onStart")).booleanValue() == true) goto L34;
    L39:
        this.f22607b = 2;
        goto L40
    L34:
        if (this.f22645o == true) goto L39;
        if (this.f22644n == false) goto L39;
        this.f22645o = true;
        f("onStart", i(r10));
    L40:
        int r20 = this.f22607b;
        if (r20 == 2) goto L43;
        if (r20 < 3) goto L59;
        j(r10);
        return;
    L59:
        return;
    L43:
        if (((Boolean) r16.get("onUpdate")).booleanValue() == false) goto L63;
        f("onUpdate", i(r10));
        return;
    L63:
        return;
    L62:
        return;
    L52:
        this.f22639i = r5.getX();
        this.f22640j = r5.getY();
        this.f22646p = false;
        this.f22607b = 1;
        if (((Boolean) r16.get("onBegin")).booleanValue() == true) goto L55;
        return;
    L55:
        if (this.f22644n == true) goto L64;
        this.f22644n = true;
        f("onBegin", i(r10));
        return;
    L64:
        return;
    }

    @Override // vn.a
    public final void g() {
        this.f22607b = 3;
        j(this.f22643m);
    }

    @Override // vn.a
    public final void h() {
        this.f22607b = 0;
        this.f22644n = false;
        this.f22645o = false;
        this.f22646p = false;
    }

    public final HashMap i(on.h r5) {
        HashMap r10 = this.g;
        rn.a r11 = this.f;
        r10.put("scrollX", Integer.valueOf(a(r11.getMemberScrollX())));
        r10.put("scrollY", Integer.valueOf(a(r11.getMemberScrollY())));
        r10.put("isAtStart", Boolean.valueOf(r11.isAtBorder(true)));
        r10.put("isAtEnd", Boolean.valueOf(r11.isAtBorder(false)));
        r10.putAll(c(r5));
        return r10;
    }

    public final void j(on.h r5) {
        if (((Boolean) this.d.get("onEnd")).booleanValue() == true) goto L5;
        return;
    L5:
        if (this.f22646p == false) goto L7;
        return;
    L7:
        if (this.f22644n == false) goto L13;
        this.f22646p = true;
        f("onEnd", i(r5));
        return;
    }
}
