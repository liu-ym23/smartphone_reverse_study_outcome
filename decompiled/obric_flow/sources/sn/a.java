package sn;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import on.h;
import s6.c;
import vn.d;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap f21956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinkedList f21957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinkedList f21958c;
    public final Handler d;
    public c e;
    public boolean f;
    public rn.a g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f21959h;

    public a() {
        this.d = new Handler(Looper.getMainLooper());
    }

    public final void a() {
        if (this.f == true) goto L5;
        return;
    L5:
        if (this.f21959h == null) goto L12;
        Handler r5 = this.d;
        if (r5 == null) goto L13;
        r5.post(new com.obric.oui.lisitem.a(this, 25));
        return;
    L13:
        return;
    }

    public final void b(String r12, h r13) {
        if (this.f == true) goto L5;
        return;
    L5:
        if (this.f21959h == null) goto L84;
        LinkedList r10 = this.f21958c;
        if (this.g != null) goto L11;
        return;
    L11:
        if ("touchstart".equals(r12) == false) goto L13;
    L19:
        int r11 = 0;
    L21:
        if (r11 >= r10.size()) goto L87;
        Map r14 = ((rn.a) r10.get(r11)).getGestureHandlers();
        if (r14 == null) goto L61;
        Iterator r15 = r14.values().iterator();
    L27:
        if (r15.hasNext() == false) goto L61;
        vn.a r16 = (vn.a) r15.next();
        byte r17 = -1;
        switch(r12.hashCode()) {
            case -1578593149: goto L44;
            case -819532484: goto L40;
            case 364536720: goto L36;
            case 2127979129: goto L32;
            default: goto L47;
        };
    L47:
        switch(r17) {
            case 0: goto L59;
            case 1: goto L56;
            case 2: goto L53;
            case 3: goto L50;
            default: goto L27;
        };
    L50:
        if (((Boolean) r16.d.get("onTouchesCancel")).booleanValue() == false) goto L27;
        r16.f("onTouchesCancel", r16.c(r13));
        goto L27
    L53:
        if (((Boolean) r16.d.get("onTouchesMove")).booleanValue() == false) goto L27;
        r16.f("onTouchesMove", r16.c(r13));
        goto L27
    L56:
        if (((Boolean) r16.d.get("onTouchesUp")).booleanValue() == false) goto L27;
        r16.f("onTouchesUp", r16.c(r13));
        goto L27
    L59:
        if (((Boolean) r16.d.get("onTouchesDown")).booleanValue() == false) goto L27;
        r16.f("onTouchesDown", r16.c(r13));
        goto L27
    L32:
        if (r12.equals("touchcancel") == false) goto L47;
        r17 = 3;
        goto L47
    L36:
        if (r12.equals("touchmove") == false) goto L47;
        r17 = 2;
        goto L47
    L40:
        if (r12.equals("touchend") == false) goto L47;
        r17 = 1;
        goto L47
    L44:
        if (r12.equals("touchstart") == false) goto L47;
        r17 = 0;
    L61:
        r11 = r11 + 1;
        goto L21
    L87:
        return;
    L13:
        if ("touchmove".equals(r12) == true) goto L19;
        if ("touchcancel".equals(r12) == true) goto L19;
        if ("touchend".equals(r12) == true) goto L19;
        return;
    }
}
