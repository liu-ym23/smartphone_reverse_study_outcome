package vn;

import android.util.Pair;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.OverScroller;
import com.lynx.tasm.behavior.LynxContext;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OverScroller f22618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LynxContext f22619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f22620c;
    public int d;
    public int e;
    public VelocityTracker f;
    public HashSet g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HashSet f22621h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public rn.a f22622i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public rn.a f22623j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public rn.a f22624k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public rn.a f22625l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final s6.c f22626m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public tn.a f22627n;

    public d(LynxContext r5, s6.c r10) {
        this.f22618a = new OverScroller(r5);
        this.f22619b = r5;
        this.f22626m = r10;
    }

    public final int a(rn.a r10) {
        if (r10 != null) goto L5;
        return 3;
    L5:
        Map r5 = r10.getGestureHandlers();
        if (r5 != null) goto L8;
        return 3;
    L8:
        Iterator r11 = r5.values().iterator();
        int r12 = -1;
    L10:
        if (r11.hasNext() == false) goto L33;
        a r13 = (a) r11.next();
        int r14 = r13.f22607b;
        if (r14 == 4) goto L13;
        if (r14 == 2) goto L17;
        if (r12 < 0) goto L32;
        if (r12 <= r14) goto L10;
    L32:
        r12 = r14;
        goto L10
    L17:
        un.a r15 = r13.e;
        HashSet r16 = this.f22621h;
        Map r17 = r10.getGestureHandlers();
        if (r17 == null) goto L28;
        Iterator r18 = r17.values().iterator();
    L22:
        if (r18.hasNext() == false) goto L28;
        a r19 = (a) r18.next();
        un.a r20 = r19.e;
        int r21 = r15.f22417a;
        int r22 = r20.f22417a;
        if (r22 == r21) goto L22;
        if (r16.contains(Integer.valueOf(r22)) == true) goto L22;
        r19.g();
    L28:
        return 2;
    L13:
        e(r10);
        this.f22624k = null;
        return 4;
    L33:
        return r12;
    }

    public final rn.a b(LinkedList r10, rn.a r11) {
        if (r11 == null) goto L5;
    L6:
        if (r10 != null) goto L8;
    L7:
        return null;
    L8:
        int r5 = 0;
        if (r11 != null) goto L13;
        rn.a r12 = this.f22624k;
        if (r12 == null) goto L13;
        e(r12);
        boolean r13 = true;
        r11 = r12;
    L14:
        int r14 = a(r11);
        if (r14 > 2) goto L18;
        return r11;
    L18:
        if (r14 != 4) goto L20;
        return null;
    L20:
        if (r13 == false) goto L22;
        return null;
    L22:
        int r15 = r10.indexOf(r11);
        int r16 = r10.lastIndexOf(r11);
        if (r15 == r16) goto L28;
        rn.a r17 = this.f22622i;
        if (r17 == null) goto L27;
        e(r17);
        r15 = r16;
        goto L28
    L27:
        this.f22622i = (rn.a) r10.get(r15);
    L28:
        if (r15 >= 0) goto L30;
    L62:
        return null;
    L30:
        if (r15 >= r10.size()) goto L62;
        int r18 = ((rn.a) r10.get(r15)).getGestureArenaMemberId();
        int r19 = r15 + 1;
    L34:
        if (r19 >= r10.size()) goto L48;
        rn.a r20 = (rn.a) r10.get(r19);
        if (r20.getGestureArenaMemberId() == r18) goto L47;
        if (this.f22622i != r20) goto L41;
        this.f22622i = null;
    L42:
        int r21 = a(r20);
        if (r21 <= 2) goto L44;
        if (r21 != 4) goto L47;
        return null;
    L44:
        return r20;
    L41:
        e(r20);
    L47:
        r19 = r19 + 1;
    L48:
        if (r5 >= r15) goto L62;
        rn.a r22 = (rn.a) r10.get(r5);
        if (r22.getGestureArenaMemberId() == r18) goto L61;
        if (this.f22622i != r22) goto L55;
        this.f22622i = null;
    L56:
        int r23 = a(r22);
        if (r23 <= 2) goto L58;
        if (r23 != 4) goto L61;
        return null;
    L58:
        return r22;
    L55:
        e(r22);
    L61:
        r5 = r5 + 1;
    L13:
        r13 = false;
        goto L14
    L5:
        if (this.f22624k == null) goto L7;
        goto L6
    }

    public final void c(on.h r11, LinkedList r12, float r13, float r14, MotionEvent r15) {
        int r5 = 0;
    L4:
        if (r5 >= r12.size()) goto L13;
        rn.a r10 = this.f22623j;
        rn.a r16 = this.f22624k;
        if (r10 == r16) goto L12;
        if (r10 == null) goto L20;
        if (r16 == r10) goto L11;
        this.f22624k = r10;
    L11:
        f(r10);
        d(this.f22623j, r13, r14, r11, r12, r15);
        r5 = r5 + 1;
        goto L4
    L20:
        return;
    L12:
        return;
    L13:
        d(this.f22624k, r13, r14, r11, r12, r15);
    }

    public final void d(rn.a r10, float r11, float r12, on.h r13, LinkedList r14, MotionEvent r15) {
        if (r10 == null) goto L39;
        tn.a r16 = this.f22627n;
        Map r17 = r10.getGestureHandlers();
        if (r17 == null) goto L11;
        Iterator r18 = r17.values().iterator();
    L9:
        if (r18.hasNext() == false) goto L11;
        ((a) r18.next()).e(r15, r13, r11, r12, false, r16);
    L11:
        HashSet r19 = this.g;
        if (r19 == null) goto L27;
        Iterator r110 = r19.iterator();
    L15:
        if (r110.hasNext() == false) goto L26;
        rn.a r5 = (rn.a) r110.next();
        tn.a r20 = this.f22627n;
        if (r5 == null) goto L15;
        Map r21 = r5.getGestureHandlers();
        if (r21 == null) goto L15;
        Iterator r22 = r21.values().iterator();
    L24:
        if (r22.hasNext() == false) goto L15;
        ((a) r22.next()).e(r15, r13, r11, r12, true, r20);
        goto L24
    L26:
        tn.a r111 = this.f22627n;
        r111.f22155b = 0.0f;
        r111.f22156c = 0.0f;
        r111.d = false;
    L27:
        if (r14 == null) goto L38;
        this.f22623j = b(r14, this.f22623j);
        return;
    L38:
        return;
    }

    public final void e(rn.a r5) {
        if (r5 == null) goto L11;
        Map r10 = r5.getGestureHandlers();
        if (r10 == null) goto L11;
        Iterator r11 = r10.values().iterator();
    L9:
        if (r11.hasNext() == false) goto L11;
        ((a) r11.next()).h();
    L11:
        HashSet r12 = this.g;
        if (r12 == null) goto L26;
        Iterator r13 = r12.iterator();
    L15:
        if (r13.hasNext() == false) goto L35;
        rn.a r14 = (rn.a) r13.next();
        if (r14 == null) goto L15;
        Map r15 = r14.getGestureHandlers();
        if (r15 == null) goto L15;
        Iterator r16 = r15.values().iterator();
    L24:
        if (r16.hasNext() == false) goto L15;
        ((a) r16.next()).h();
        goto L24
    L35:
        return;
    }

    public final void f(rn.a r12) {
        Pair r5 = null;
        s6.c r10 = this.f22626m;
        if (r12 != null) goto L5;
        r10.getClass();
    L48:
        if (r5 != null) goto L50;
        return;
    L50:
        this.g = (HashSet) r5.first;
        this.f22621h = (HashSet) r5.second;
        return;
    L5:
        if (((sn.a) r10.f21829c) == null) goto L48;
        Map r11 = r12.getGestureDetectorMap();
        if (r11 == null) goto L48;
        HashSet r13 = new HashSet();
        HashSet r14 = new HashSet();
        HashSet r15 = new HashSet();
        Iterator r16 = r11.entrySet().iterator();
    L12:
        if (r16.hasNext() == false) goto L14;
        r14.add(Integer.valueOf(((un.a) ((Map.Entry) r16.next()).getValue()).f22417a));
        goto L12
    L14:
        Iterator r17 = r11.entrySet().iterator();
    L16:
        if (r17.hasNext() == false) goto L46;
        Map.Entry r18 = (Map.Entry) r17.next();
        if (r18.getValue() == null) goto L16;
        List r19 = (List) ((un.a) r18.getValue()).d.get("simultaneous");
        if (r19 == null) goto L16;
        if (r19.isEmpty() == true) goto L16;
        Iterator r20 = r19.iterator();
    L27:
        if (r20.hasNext() == false) goto L16;
        Integer r21 = (Integer) r20.next();
        r21.getClass();
        if (r14.contains(r21) == true) goto L30;
        Set r22 = (Set) ((HashMap) r10.f21828b).get(r21);
        if (r22 == null) goto L27;
        Iterator r23 = r22.iterator();
    L36:
        if (r23.hasNext() == false) goto L27;
        Integer r24 = (Integer) r23.next();
        r24.getClass();
        WeakReference r25 = (WeakReference) ((sn.a) r10.f21829c).f21956a.get(r24);
        if (r25 == null) goto L40;
        rn.a r26 = (rn.a) r25.get();
    L41:
        if (r26 == null) goto L36;
        if (r26.getGestureArenaMemberId() == r12.getGestureArenaMemberId()) goto L36;
        r13.add(r26);
        goto L36
    L40:
        r26 = null;
        goto L41
    L30:
        r15.add(r21);
        goto L27
    L46:
        r5 = new Pair(r13, r15);
        goto L48
    }
}
