package d.b.o.a;

import android.util.Log;
import androidx.core.location.LocationRequestCompat;
import com.bytedance.apm.d;
import com.bytedance.apm.r.m.f;
import com.bytedance.apm.r.m.g;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: d.b.o.a.a$a, reason: collision with other inner class name */
    static class C0381a implements Comparator<g> {
        C0381a() {
        }

        public int a(g r1, g r2) {
            return Integer.compare((r2.f1949d + 1) * r2.f1947b, (r1.f1949d + 1) * r1.f1947b);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(g r1, g r2) {
            return a(r1, r2);
        }
    }

    public interface b {
        boolean a(long r1, int r3);

        int b();

        void c(List<g> r1, int r2);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        g f14178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        c f14179b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        LinkedList<c> f14180c;

        c(g r2, c r3) {
            this.f14180c = new LinkedList();
            this.f14178a = r2;
            this.f14179b = r3;
        }

        static /* synthetic */ int a(c r0) {
            return r0.d();
        }

        static /* synthetic */ void b(c r0, c r1) {
            r0.c(r1);
        }

        private void c(c r1) {
            this.f14180c.addFirst(r1);
        }

        private int d() {
            g r0 = this.f14178a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.f1949d;
        }
    }

    private static int a(LinkedList<g> r3, g r4) {
        if (d.C() == false) goto L5;
        Log.v("TraceDataUtils", "method:" + r4);
    L5:
        g r0 = null;
        if (r3.isEmpty() == true) goto L8;
        r0 = r3.peek();
    L8:
        if (r0 != null) goto L10;
    L19:
        r3.push(r4);
        return r4.f1947b;
    L10:
        if (r0.f1946a != r4.f1946a) goto L19;
        int r1 = r0.f1949d;
        int r2 = r4.f1949d;
        if (r1 != r2) goto L19;
        if (r2 == 0) goto L19;
        int r5 = r4.f1947b;
        if (r5 != 5000) goto L17;
        r5 = r0.f1947b;
    L17:
        r4.f1947b = r5;
        r0.a(r5);
        return r0.f1947b;
    }

    public static int b(long r2) {
        return (int) ((r2 >> 43) & 1048575);
    }

    private static long c(long r2) {
        return r2 & 8796093022207L;
    }

    public static String d(List<g> r6, long r7) {
        StringBuilder r0 = new StringBuilder();
        long r8 = (long) (r7 * 0.3f);
        LinkedList r1 = new LinkedList();
        Iterator<g> r2 = r6.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        g r3 = r2.next();
        if (r3.f1947b < r8) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Collections.sort(r1, new C0381a());
        if (r1.isEmpty() == false) goto L14;
        if (r6.isEmpty() == true) goto L14;
        r1.add(r6.get(0));
    L18:
        Iterator r9 = r1.iterator();
        if (r9.hasNext() == false) goto L22;
        r0.append(((g) r9.next()).f1946a + "\n");
    L22:
        return r0.toString();
    L14:
        if (r1.size() <= 1) goto L18;
        if (((g) r1.peek()).f1946a != 1048574) goto L18;
        r1.removeFirst();
        goto L18
    }

    private static boolean e(long r2) {
        if (((r2 >> 63) & 1) != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public static void f(List<g> r1, int r2) {
        if (r2 >= 0) goto L5;
        r1.clear();
        return;
    L5:
        ListIterator<g> r3 = r1.listIterator(r1.size());
    L7:
        if (r3.hasPrevious() == false) goto L11;
        if (r3.previous().f1947b >= r2) goto L7;
        r3.remove();
        goto L7
    }

    public static long g(LinkedList<g> r5, StringBuilder r6) {
        Iterator<g> r7 = r5.iterator();
        long r0 = 0;
    L4:
        if (r7.hasNext() == false) goto L8;
        g r2 = r7.next();
        r6.append(r2.toString());
        r6.append('\n');
        int r3 = r2.f1947b;
        if (r0 >= r3) goto L4;
        r0 = r3;
        goto L4
    L8:
        return r0;
    }

    public static int h(LinkedList<g> r6, c r7) {
        ListIterator<g> r8 = r6.listIterator(0);
        c r1 = null;
        int r2 = 0;
    L4:
        if (r8.hasNext() == false) goto L31;
        c r3 = new c(r8.next(), r1);
        r2 = r2 + 1;
        if (r1 == null) goto L8;
    L13:
        int r4 = c.a(r3);
        if (r1 == null) goto L29;
        if (r4 == 0) goto L29;
        if (c.a(r1) < r4) goto L28;
    L19:
        if (r1 == null) goto L23;
        if (c.a(r1) <= r4) goto L23;
        r1 = r1.f14179b;
    L23:
        if (r1 == null) goto L4;
        c r5 = r1.f14179b;
        if (r5 == null) goto L30;
        r3.f14179b = r5;
        r1 = r1.f14179b;
    L30:
        r1 = r3;
    L28:
        c.b(r1, r3);
    L29:
        c.b(r7, r3);
        goto L30
    L8:
        if (c.a(r3) == 0) goto L13;
        if (d.C() == false) goto L12;
        com.bytedance.apm.x.g.a("TraceDataUtils", "[stackToTree] SceneMethodsInfo begin error! why the first node'depth is not 0!", new Object[0]);
    L12:
        return 0;
    L31:
        com.bytedance.apm.x.g.b("SceneMethodsInfo", "[stackToTree] count [%d] ", new Object[]{Integer.valueOf(r2)});
        return r2;
    }

    public static void i(int r24, long[] r25, LinkedList<g> r26, boolean r27, long r28, int r30) {
        if (r25 != null) goto L5;
        return;
    L5:
        if (r25.length == 0) goto L116;
        long r3 = LocationRequestCompat.PASSIVE_INTERVAL;
        int r6 = 1;
        long r9 = 0;
        if (r25[r25.length - 1] == 0) goto L10;
        r3 = c(r25[r25.length - 1]);
    L10:
        int r5 = 0;
        int r7 = 0;
    L12:
        if (r7 >= r25.length) goto L17;
        if (c(r25[r7]) < r3) goto L17;
        r7 = r7 + 1;
    L17:
        if (r24 > 0) goto L19;
        int r4 = 1048574;
    L20:
        LinkedList r8 = new LinkedList();
        int r10 = 0;
        int r11 = 0;
    L22:
        if (r7 >= r25.length) goto L72;
        long r16 = r25[r7];
        if (r9 != r16) goto L26;
    L25:
        long r22 = r9;
    L71:
        r7 = r7 + 1;
        r9 = r22;
        r5 = 0;
        r6 = 1;
        goto L22
    L26:
        if (r27 == false) goto L37;
        if (e(r16) == true) goto L30;
    L32:
        if (r11 != 0) goto L37;
        if (b(r16) <= 1048000) goto L25;
        Object[] r12 = new Object[2];
        r12[r5] = Integer.valueOf(b(r16));
        r12[r6] = Boolean.valueOf(e(r16));
        com.bytedance.apm.x.g.b("SceneMethodsInfo", "s2 pass this method[%s], isIn [%b] ", r12);
        goto L25
    L30:
        if (r4 != b(r16)) goto L32;
        r11 = r6;
    L37:
        if (e(r16) == true) goto L39;
        int r13 = b(r16);
        if (r8.isEmpty() == true) goto L68;
        long r18 = ((Long) r8.pop()).longValue();
        r10 = r10 - 1;
        LinkedList r14 = new LinkedList();
    L45:
        r14.push(Long.valueOf(r18));
        int r15 = b(r18);
        if (r15 == r13) goto L53;
        if (r8.isEmpty() == true) goto L53;
        if (d.C() == false) goto L52;
        Object[] r17 = new Object[2];
        r17[r5] = Integer.valueOf(r15);
        r17[r6] = Integer.valueOf(r13);
        com.bytedance.apm.x.g.c("TraceDataUtils", "pop inMethodId[%s] to continue match ouMethodId[%s]", r17);
    L52:
        r18 = ((Long) r8.pop()).longValue();
        r10 = r10 - 1;
    L53:
        if (r15 == r13) goto L56;
        if (r15 != r4) goto L56;
        d.C();
        r8.addAll(r14);
        r10 = r10 + r8.size();
    L67:
        r22 = 0;
    L56:
        long r19 = c(r16) + f.C();
    L58:
        if (r14.size() == 0) goto L67;
        long r110 = c(((Long) r14.pop()).longValue()) + f.C();
        long r20 = r19 - r110;
        if (r20 < 0) goto L62;
        a(r26, new g(r13, (int) r20, r110, r10));
        goto L58
    L62:
        if (d.C() == false) goto L64;
        com.bytedance.apm.x.g.a("TraceDataUtils", "[structuredDataToStack] trace during invalid:%d", new Object[]{Long.valueOf(r20)});
    L64:
        r8.clear();
        r26.clear();
        return;
    L68:
        r22 = r9;
        if (d.C() == false) goto L71;
        com.bytedance.apm.x.g.c("TraceDataUtils", "[structuredDataToStack] method[%s] not found in! ", new Object[]{Integer.valueOf(r13)});
        goto L71
    L39:
        if (b(r16) != r4) goto L41;
        r8.clear();
        r10 = r5;
    L41:
        r10 = r10 + r6;
        r8.push(Long.valueOf(r16));
        goto L25
    L72:
        com.bytedance.apm.x.g.b("SceneMethodsInfo", "structuredDataToStack inner, result.size: " + r26.size() + ", " + r8.size(), new Object[0]);
    L74:
        if (r8.isEmpty() == true) goto L89;
        long r21 = ((Long) r8.pop()).longValue();
        int r111 = b(r21);
        boolean r0 = e(r21);
        long r112 = c(r21) + f.C();
        if (d.C() == false) goto L78;
        com.bytedance.apm.x.g.c("TraceDataUtils", "[structuredDataToStack] has never out method[%s], isIn:%s, inTime:%s, endTime:%s,rawData size:%s", new Object[]{Integer.valueOf(r111), Boolean.valueOf(r0), Long.valueOf(r112), Long.valueOf(r28), Integer.valueOf(r8.size())});
    L78:
        if (r0 == false) goto L80;
        if (r30 <= 0) goto L85;
        boolean r23 = true;
    L86:
        if (r23 == false) goto L88;
        if (r10 > r30) goto L74;
    L88:
        a(r26, new g(r111, (int) (r28 - r112), r112, r8.size()));
        goto L74
    L85:
        r23 = false;
        goto L86
    L80:
        if (d.C() == false) goto L74;
        com.bytedance.apm.x.g.a("TraceDataUtils", "[structuredDataToStack] why has out Method[%s]? is wrong! ", new Object[]{Integer.valueOf(r111)});
        goto L74
    L89:
        c r1 = new c(null, null);
        h(r26, r1);
        r26.clear();
        k(r1, r26);
        return;
    L19:
        r4 = r24;
        goto L20
    }

    public static void j(long[] r7, LinkedList<g> r8, boolean r9, long r10) {
        i(1048574, r7, r8, r9, r10, -1);
    }

    private static void k(c r3, LinkedList<g> r4) {
        LinkedList r0 = new LinkedList();
    L3:
        if (r3 == null) goto L13;
        g r1 = r3.f14178a;
        if (r1 == null) goto L7;
        r4.add(r1);
    L7:
        LinkedList<c> r5 = r3.f14180c;
        if (r5.isEmpty() == true) goto L12;
        int r2 = r5.size() - 1;
    L10:
        if (r2 < 0) goto L12;
        r0.add(r5.get(r2));
        r2 = r2 - 1;
    L12:
        r3 = (c) r0.pollLast();
        goto L3
    }

    public static void l(List<g> r1, int r2) {
        ListIterator<g> r3 = r1.listIterator(r1.size());
    L4:
        if (r3.hasPrevious() == false) goto L10;
        g r0 = r3.previous();
        if (r0 == null) goto L4;
        if (r0.f1947b >= r2) goto L4;
        r3.remove();
        goto L4
    }

    public static void m(List<g> r5, int r6, b r7) {
        if (r6 >= 0) goto L5;
        r5.clear();
        return;
    L5:
        int r0 = r5.size();
        int r1 = 1;
    L6:
        if (r0 <= r6) goto L17;
        ListIterator<g> r2 = r5.listIterator(r5.size());
    L9:
        if (r2.hasPrevious() == false) goto L15;
        if (r7.a(r2.previous().f1947b, r1) == false) goto L9;
        r2.remove();
        r0 = r0 - 1;
        if (r0 > r6) goto L9;
        return;
    L15:
        r0 = r5.size();
        r1 = r1 + 1;
        if (r7.b() >= r1) goto L6;
    L17:
        int r3 = r5.size();
        if (r3 <= r6) goto L30;
        r7.c(r5, r3);
        return;
    }
}
