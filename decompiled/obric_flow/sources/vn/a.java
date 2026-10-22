package vn;

import android.view.MotionEvent;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.core.LynxEngineProxy;
import com.lynx.tasm.event.LynxEvent$LynxEventType;
import com.lynx.tasm.i;
import com.lynx.tasm.r;
import com.lynx.tasm.utils.j;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LynxContext f22608c;
    public final HashMap d;
    public final un.a e;
    public final rn.a f;

    public a(int r5, LynxContext r10, un.a r11, rn.a r12) {
        this.f22607b = 0;
        this.f22606a = r5;
        this.f22608c = r10;
        this.e = r11;
        this.f = r12;
        HashMap r13 = new HashMap();
        this.d = r13;
        ArrayList r14 = r11.f22419c;
        Boolean r15 = Boolean.FALSE;
        r13.put("onTouchesDown", r15);
        r13.put("onTouchesMove", r15);
        r13.put("onTouchesUp", r15);
        r13.put("onTouchesCancel", r15);
        r13.put("onBegin", r15);
        r13.put("onUpdate", r15);
        r13.put("onStart", r15);
        r13.put("onEnd", r15);
        if (r14 == null) goto L10;
        Iterator r16 = r14.iterator();
    L6:
        if (r16.hasNext() == false) goto L16;
        String r17 = (String) r16.next();
        if (this.d.containsKey(r17) == false) goto L6;
        this.d.put(r17, Boolean.TRUE);
        goto L6
    L16:
        return;
    }

    public static HashMap b(int r10, LynxContext r11, rn.a r12, Map r13) {
        HashMap r5 = new HashMap();
        Iterator r14 = r13.keySet().iterator();
    L4:
        if (r14.hasNext() == false) goto L26;
        Integer r15 = (Integer) r14.next();
        r15.getClass();
        un.a r16 = (un.a) r13.get(r15);
        if (r16 == null) goto L4;
        int r17 = r16.f22418b;
        if (r17 == 0) goto L10;
        if (r17 == 2) goto L13;
        if (r17 == 1) goto L16;
        if (r17 == 3) goto L19;
        if (r17 == 4) goto L22;
        if (r17 != 7) goto L4;
        r5.put(Integer.valueOf(r17), new f(r10, r11, r16, r12));
        goto L4
    L22:
        r5.put(Integer.valueOf(r17), new e(r10, r11, r16, r12, 0));
        goto L4
    L19:
        r5.put(Integer.valueOf(r17), new e(r10, r11, r16, r12, 1));
        goto L4
    L16:
        r5.put(Integer.valueOf(r17), new c(r10, r11, r16, r12));
        goto L4
    L13:
        r5.put(Integer.valueOf(r17), new b(r10, r11, r16, r12));
        goto L4
    L10:
        r5.put(Integer.valueOf(r17), new g(r10, r11, r16, r12));
        goto L4
    L26:
        return r5;
    }

    public final int a(float r5) {
        LynxContext r10 = this.f22608c;
        if (r10 == null) goto L12;
        if (r10.getResources() == null) goto L12;
        if (r10.getResources().getDisplayMetrics() == null) goto L12;
        return (int) (((double) (r5 / r10.getResources().getDisplayMetrics().density)) + 0.5d);
    L12:
        return (int) r5;
    }

    public final HashMap c(on.h r5) {
        HashMap r10 = new HashMap();
        if (r5 == null) goto L13;
        r10.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        r10.put("type", r5.f20780b);
        on.g r11 = r5.f20787i;
        if (r11 == null) goto L7;
        r10.put("x", Integer.valueOf(a(r11.f20784a)));
        r10.put("y", Integer.valueOf(a(r11.f20785b)));
    L7:
        on.g r12 = r5.f20786h;
        if (r12 == null) goto L10;
        r10.put("pageX", Integer.valueOf(a(r12.f20784a)));
        r10.put("pageY", Integer.valueOf(a(r12.f20785b)));
    L10:
        on.g r13 = r5.g;
        if (r13 == null) goto L13;
        r10.put("clientX", Integer.valueOf(a(r13.f20784a)));
        r10.put("clientY", Integer.valueOf(a(r13.f20785b)));
    L13:
        return r10;
    }

    public abstract void d();

    public abstract void e(MotionEvent r5, on.h r10, float r11, float r12, boolean r13, tn.a r14);

    public final void f(String r11, HashMap r12) {
        LynxEvent$LynxEventType r5 = LynxEvent$LynxEventType.f10839a;
        System.currentTimeMillis();
        r r10 = this.f22608c.g;
        un.a r13 = this.e;
        r10.getClass();
        i r14 = r10.e;
        if (r14 != null) goto L5;
    L14:
        LynxLog.b(4, "EventEmitter", "sendGestureEvent event: " + r11 + " failed since mEngineProxy is null or in preload.");
        return;
    L5:
        if (r10.f10940b == true) goto L14;
        ByteBuffer r15 = kn.b.b(r12);
        if (r15 != null) goto L10;
        int r16 = 0;
    L9:
        int r17 = r16;
        LynxEngineProxy r18 = (LynxEngineProxy) r14.f10879a;
        if (r18 == null) goto L16;
        j.f(new mn.d(r18, r11, this.f22606a, r13.f22417a, r15, r17));
        return;
    L16:
        return;
    L10:
        r16 = r15.position();
        goto L9
    }

    public abstract void g();

    public abstract void h();
}
