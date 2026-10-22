package vn;

import android.view.MotionEvent;
import com.lynx.tasm.behavior.LynxContext;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends a {
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f22615h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f22616i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final HashMap f22617j;

    public c(int r5, LynxContext r10, un.a r11, rn.a r12) {
        super(r5, r10, r11, r12);
        this.g = false;
        this.f22615h = false;
        this.f22616i = false;
        this.f22617j = new HashMap();
    }

    @Override // vn.a
    public final void d() {
        this.f22607b = 4;
        j();
    }

    @Override // vn.a
    public final void e(MotionEvent r10, on.h r11, float r12, float r13, boolean r14, tn.a r15) {
        this.f.onInvalidate();
        if (r10 != null) goto L5;
    L10:
        HashMap r16 = this.d;
        if (r10 != null) goto L13;
    L21:
        int r17 = this.f22607b;
        if (r17 < 3) goto L28;
        if (r17 > 4) goto L28;
        j();
        return;
    L28:
        if (r12 == Float.MIN_VALUE) goto L30;
    L33:
        if (r17 == 0) goto L41;
        if (r17 == 5) goto L41;
        if (((Boolean) r16.get("onUpdate")).booleanValue() == false) goto L60;
        f("onUpdate", i(r12, r13));
        return;
    L60:
        return;
    L41:
        this.f22607b = 2;
        if (((Boolean) r16.get("onBegin")).booleanValue() == false) goto L48;
        if (this.g == true) goto L48;
        this.g = true;
        f("onBegin", i(0.0f, 0.0f));
    L48:
        if (((Boolean) r16.get("onStart")).booleanValue() == true) goto L50;
        return;
    L50:
        if (this.f22615h == false) goto L52;
        return;
    L52:
        if (this.g == false) goto L61;
        this.f22615h = true;
        f("onStart", i(0.0f, 0.0f));
        return;
    L61:
        return;
    L30:
        if (r13 != Float.MIN_VALUE) goto L33;
        g();
        j();
        return;
    L13:
        if (r10.getActionMasked() != 1) goto L21;
        this.f22607b = 1;
        if (((Boolean) r16.get("onBegin")).booleanValue() == true) goto L17;
        return;
    L17:
        if (this.g == true) goto L59;
        this.g = true;
        f("onBegin", i(0.0f, 0.0f));
        return;
    L59:
        return;
    L5:
        if (r10.getActionMasked() != 0) goto L7;
    L8:
        this.f22607b = 5;
        return;
    L7:
        if (r10.getActionMasked() != 2) goto L10;
        goto L8
    }

    @Override // vn.a
    public final void g() {
        this.f22607b = 3;
        j();
    }

    @Override // vn.a
    public final void h() {
        this.f22607b = 0;
        this.g = false;
        this.f22615h = false;
        this.f22616i = false;
    }

    public final HashMap i(float r5, float r10) {
        HashMap r11 = this.f22617j;
        rn.a r12 = this.f;
        r11.put("scrollX", Integer.valueOf(a(r12.getMemberScrollX())));
        r11.put("scrollY", Integer.valueOf(a(r12.getMemberScrollY())));
        r11.put("deltaX", Integer.valueOf(a(r5)));
        r11.put("deltaY", Integer.valueOf(a(r10)));
        r11.put("isAtStart", Boolean.valueOf(r12.isAtBorder(true)));
        r11.put("isAtEnd", Boolean.valueOf(r12.isAtBorder(false)));
        return r11;
    }

    public final void j() {
        if (((Boolean) this.d.get("onEnd")).booleanValue() == true) goto L5;
        return;
    L5:
        if (this.f22616i == false) goto L7;
        return;
    L7:
        if (this.g == false) goto L13;
        this.f22616i = true;
        f("onEnd", i(0.0f, 0.0f));
        return;
    }
}
