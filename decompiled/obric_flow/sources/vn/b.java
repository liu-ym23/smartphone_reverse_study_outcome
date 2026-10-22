package vn;

import android.view.MotionEvent;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.a1;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends a {
    public final HashMap g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f22609h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f22610i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f22611j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f22612k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f22613l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public on.h f22614m;

    public b(int r5, LynxContext r10, un.a r11, rn.a r12) {
        super(r5, r10, r11, r12);
        this.f22609h = 0.0f;
        this.f22610i = 0.0f;
        this.f22611j = false;
        this.f22612k = false;
        this.f22613l = 3;
        ReadableMap r13 = r11.e;
        if (r13 == null) goto L6;
        this.f22613l = r13.getInt("tapSlop", 3);
    L6:
        this.g = new HashMap();
    }

    @Override // vn.a
    public final void d() {
        this.f22607b = 4;
        if (this.f22614m != null) goto L6;
        l();
        return;
    L6:
        l();
    }

    @Override // vn.a
    public final void e(MotionEvent r10, on.h r11, float r12, float r13, boolean r14, tn.a r15) {
        this.f22614m = r11;
        rn.a r16 = this.f;
        if (r14 == false) goto L10;
        if (r15 == null) goto L10;
        if (r15.d == false) goto L112;
        r16.onGestureScrollBy(r15.f22155b, r15.f22156c);
        r16.onInvalidate();
        return;
    L112:
        return;
    L10:
        if (this.f22607b < 3) goto L13;
        l();
        return;
    L13:
        HashMap r17 = this.d;
        if (r10 == null) goto L76;
        int r18 = r10.getActionMasked();
        if (r18 == 0) goto L69;
        if (r18 == 1) goto L62;
        if (r18 != 2) goto L117;
        float r19 = this.f22609h - r10.getX();
        float r110 = this.f22610i - r10.getY();
        if (r19 == 0.0f) goto L23;
    L25:
        if (r15 != null) goto L27;
    L33:
        if (r15 == null) goto L40;
        int r5 = r15.f22154a;
        if (r5 == 0) goto L40;
        if (r5 != (-1)) goto L38;
        r110 = 0.0f;
        goto L40
    L38:
        r19 = 0.0f;
    L40:
        if (this.f22607b != 0) goto L51;
        if (((Boolean) r17.get("onBegin")).booleanValue() == false) goto L48;
        if (this.f22611j == true) goto L48;
        this.f22611j = true;
        f("onBegin", i(0.0f, 0.0f));
    L48:
        if (this.f22607b > 1) goto L59;
        this.f22607b = 2;
    L59:
        this.f22609h = r10.getX();
        this.f22610i = r10.getY();
        return;
    L51:
        if (k(r19, r110, r15) == true) goto L53;
        this.f22607b = 2;
        j(r19, r110, r15);
        goto L59
    L53:
        if (r16.isAtBorder(true) == false) goto L55;
    L57:
        g();
        l();
        goto L59
    L55:
        if (r16.isAtBorder(false) == true) goto L57;
        j(r19, r110, r15);
        goto L57
    L27:
        if (r15.f22154a != 0) goto L33;
        if (Math.abs(r19) <= Math.abs(r110)) goto L31;
        int r20 = -1;
    L32:
        r15.f22154a = r20;
        goto L33
    L31:
        r20 = 1;
        goto L32
    L23:
        if (r110 != 0.0f) goto L25;
        return;
    L117:
        return;
    L62:
        if (this.f22607b == 2) goto L64;
        return;
    L64:
        if (r12 == Float.MIN_VALUE) goto L66;
        return;
    L66:
        if (r13 != Float.MIN_VALUE) goto L115;
        g();
        l();
        return;
    L115:
        return;
    L69:
        this.f22609h = r10.getX();
        this.f22610i = r10.getY();
        this.f22612k = false;
        this.f22607b = 1;
        if (((Boolean) r17.get("onBegin")).booleanValue() == true) goto L72;
        return;
    L72:
        if (this.f22611j == true) goto L119;
        this.f22611j = true;
        f("onBegin", i(0.0f, 0.0f));
        return;
    L119:
        return;
    L76:
        r16.onInvalidate();
        if (this.f22607b == 2) goto L79;
    L84:
        if (r15 == null) goto L91;
        int r21 = r15.f22154a;
        if (r21 == 0) goto L91;
        if (r21 != (-1)) goto L89;
        r13 = 0.0f;
        goto L91
    L89:
        r12 = 0.0f;
    L91:
        if (k(r12, r13, r15) == false) goto L99;
        if (r16.isAtBorder(true) == false) goto L95;
    L97:
        g();
        l();
    L110:
        r16.onInvalidate();
        return;
    L95:
        if (r16.isAtBorder(false) == true) goto L97;
        j(r12, r13, r15);
        goto L97
    L99:
        if (this.f22607b == 0) goto L101;
    L109:
        j(r12, r13, r15);
        goto L110
    L101:
        if (((Boolean) r17.get("onBegin")).booleanValue() == false) goto L107;
        if (this.f22611j == true) goto L107;
        this.f22611j = true;
        f("onBegin", i(0.0f, 0.0f));
    L107:
        if (this.f22607b > 1) goto L109;
        this.f22607b = 2;
        goto L109
    L79:
        if (r12 != Float.MIN_VALUE) goto L84;
        if (r13 != Float.MIN_VALUE) goto L84;
        g();
        l();
    }

    @Override // vn.a
    public final void g() {
        this.f22607b = 3;
        if (this.f22614m != null) goto L6;
        l();
        return;
    L6:
        l();
    }

    @Override // vn.a
    public final void h() {
        this.f22607b = 0;
        this.f22609h = 0.0f;
        this.f22610i = 0.0f;
        this.f22611j = false;
        this.f22612k = false;
    }

    public final HashMap i(float r5, float r10) {
        HashMap r11 = this.g;
        rn.a r12 = this.f;
        r11.put("scrollX", Integer.valueOf(a(r12.getMemberScrollX())));
        r11.put("scrollY", Integer.valueOf(a(r12.getMemberScrollY())));
        r11.put("deltaX", Integer.valueOf(a(r5)));
        r11.put("deltaY", Integer.valueOf(a(r10)));
        r11.put("isAtStart", Boolean.valueOf(r12.isAtBorder(true)));
        r11.put("isAtEnd", Boolean.valueOf(r12.isAtBorder(false)));
        return r11;
    }

    public final void j(float r5, float r10, tn.a r11) {
        this.f.onGestureScrollBy(r5, r10);
        if (r11 == null) goto L5;
        r11.d = true;
        r11.f22155b = r5;
        r11.f22156c = r10;
    L5:
        int r12 = Math.abs((int) r5);
        int r13 = this.f22613l;
        if (r12 <= r13) goto L8;
    L9:
        a1 r14 = this.f22608c.f10140h;
        if (r14 == null) goto L15;
        HashSet r15 = r14.s;
        if (r15 == null) goto L15;
        r15.add(Integer.valueOf(this.f22606a));
    L15:
        if (((Boolean) this.d.get("onUpdate")).booleanValue() == true) goto L17;
        return;
    L17:
        f("onUpdate", i(r5, r10));
        return;
    L8:
        if (Math.abs((int) r10) <= r13) goto L15;
        goto L9
    }

    public final boolean k(float r5, float r10, tn.a r11) {
        rn.a r12 = this.f;
        if (r11 == null) goto L15;
        if (r11.f22154a != (-1)) goto L10;
        if (r12.getScrollContainerDirection() == (-1)) goto L10;
        return true;
    L10:
        if (r11.f22154a != 1) goto L15;
        if (r12.getScrollContainerDirection() == 1) goto L15;
        return true;
    L15:
        return !r12.canConsumeGesture(r5, r10);
    }

    public final void l() {
        if (((Boolean) this.d.get("onEnd")).booleanValue() == true) goto L5;
        return;
    L5:
        if (this.f22612k == false) goto L7;
        return;
    L7:
        if (this.f22611j == false) goto L13;
        this.f22612k = true;
        f("onEnd", i(0.0f, 0.0f));
        return;
    }
}
