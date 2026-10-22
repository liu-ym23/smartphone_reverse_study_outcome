package d.b.b.f.e;

import android.text.TextUtils;
import com.bytedance.apm6.perf.base.model.ThreadStatInfo;
import com.bytedance.monitor.collector.k;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class i {
    public static void a(int r6, List<j> r7, double r8, Map<String, Double> r10) {
        b(r6, r7, new LinkedList(), r8, r10);
    }

    public static void b(int r19, List<j> r20, List<j> r21, double r22, Map<String, Double> r24) {
        String r6 = "/proc/" + r19 + "/task/";
        d.b.b.o.m.b.d("APM-CPU", "size: " + r20.size());
        long r8 = d.b.b.o.n.a.a();
        Iterator<j> r10 = r20.iterator();
        BufferedReader r11 = null;
    L4:
        if (r10.hasNext() == false) goto L48;
        j r0 = r10.next();
        if (r0 != null) goto L55;
        com.bytedance.common.utility.n.b.a(r11);
        String r110 = r6;
        Iterator<j> r17 = r10;
    L41:
        r6 = r110;
        r10 = r17;
        goto L4
    L55:
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L37
        r15.append(r6);     // Catch: Throwable -> L37
        r110 = r6;
        r15.append(r0.f());     // Catch: Throwable -> L50
        r15.append("/stat");     // Catch: Throwable -> L50
        BufferedReader r12 = new BufferedReader(new InputStreamReader(new FileInputStream(r15.toString())), 1000);     // Catch: Throwable -> L50
        String r7 = r12.readLine();     // Catch: Throwable -> L33
        String[] r9 = r7.substring(r7.lastIndexOf(41) + 4).split(" ");     // Catch: Throwable -> L33
        long r13 = Long.parseLong(r9[10]) + Long.parseLong(r9[11]);     // Catch: Throwable -> L33
        r17 = r10;
        BufferedReader r18 = r12;
        float r14 = (r13 - r0.e()) / (r8 - r0.c());
        d.b.b.o.m.b.d("APM-CPU", r0.g() + " judge: " + r13 + " " + r0.e() + " " + r14 + " " + r22);     // Catch: Throwable -> L29
        if (r24 != null) goto L18;
    L24:
        double r16 = r14;
        if (r16 >= r22) goto L26;
    L23:
        r21.add(r0);     // Catch: Throwable -> L29
    L27:
        d.b.b.o.m.b.d("APM-CPU", "after item: " + r0);     // Catch: Throwable -> L29
        com.bytedance.common.utility.n.b.a(r18);
        r11 = r18;
        goto L41
    L26:
        r0.i(r16);     // Catch: Throwable -> L29
        int r23 = Integer.parseInt(r9[18]);     // Catch: Throwable -> L29
    L22:
        r0.j(r23);     // Catch: Throwable -> L29
        goto L27
    L18:
        if (r24.containsKey(r0.g()) == false) goto L24;
        double r111 = r14;
        if (r111 < r24.get(r0.g()).doubleValue()) goto L23;
        r0.i(r111);     // Catch: Throwable -> L29
        r23 = Integer.parseInt(r9[18]);     // Catch: Throwable -> L29
    L29:
        th = th;
    L36:
        r11 = r18;
    L51:
        d.b.b.o.m.b.d("APM-CPU", "error: " + th.getLocalizedMessage());     // Catch: Throwable -> L45
    L40:
        com.bytedance.common.utility.n.b.a(r11);
    L45:
        th = move-exception;
        com.bytedance.common.utility.n.b.a(r11);
        throw th;
    L31:
        th = th;
    L35:
        r18 = r12;
    L33:
        th = th;
        r17 = r10;
    L38:
        r17 = r10;
        r21.add(r0);     // Catch: Throwable -> L42
    L42:
        th = th;
    L37:
        r110 = r6;
        goto L38
    L48:
        r20.removeAll(r21);
        d.b.b.o.m.b.d("APM-CPU", "after size: " + r20.size());
    }

    public static void c(int r14, List<j> r15) {
        File[] r16 = new File("/proc/" + r14 + "/task/").listFiles();
        long r0 = d.b.b.o.n.a.a();
        int r2 = r16.length;
        BufferedReader r4 = null;
        int r5 = 0;
    L3:
        if (r5 >= r2) goto L21;
        BufferedReader r7 = new BufferedReader(new InputStreamReader(new FileInputStream(r16[r5].getPath() + "/stat")), 1000);     // Catch: Throwable -> L22
        String r6 = r7.readLine();     // Catch: Throwable -> L18
        int r8 = r6.lastIndexOf(41);     // Catch: Throwable -> L18
        String r9 = r6.substring(0, r8);     // Catch: Throwable -> L18
        String r10 = r6.substring(r8 + 4);     // Catch: Throwable -> L18
        int r11 = r9.indexOf(40);     // Catch: Throwable -> L18
        int r12 = Integer.valueOf(r9.substring(0, r11 - 1)).intValue();     // Catch: Throwable -> L18
        String r13 = r9.substring(r11 + 1);     // Catch: Throwable -> L18
        String[] r17 = r10.split(" ");     // Catch: Throwable -> L18
        long r18 = Long.parseLong(r17[10]) + Long.parseLong(r17[11]);     // Catch: Throwable -> L18
        if (r12 != 0) goto L9;
    L17:
        d.b.l.a.d.b(r7);
        r4 = r7;
    L20:
        r5 = r5 + 1;
        goto L3
    L9:
        if (r13.isEmpty() == true) goto L17;
        if (r18 == 0) goto L17;
        if (Thread.currentThread().getName().contains(r13) == true) goto L17;
        j r19 = new j();     // Catch: Throwable -> L18
        r19.o(r13);     // Catch: Throwable -> L18
        r19.n(r12);     // Catch: Throwable -> L18
        r19.m(r18);     // Catch: Throwable -> L18
        r19.k(r0);     // Catch: Throwable -> L18
        r19.j(Integer.parseInt(r17[14]));     // Catch: Throwable -> L18
        r15.add(r19);     // Catch: Throwable -> L18
    L18:
        r4 = r7;
    L19:
        d.b.l.a.d.b(r4);
        goto L20
    }

    public static void d(int r9, Map<Integer, j> r10) {
        File[] r0 = new File("/proc/" + r9 + "/task/").listFiles();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L15;
        int r3 = Integer.parseInt(r0[r2].getName());     // Catch: NumberFormatException -> L16
        ThreadStatInfo r4 = k.n().j(r9, r3);     // Catch: NumberFormatException -> L16
        if (r3 == 0) goto L14;
        if (r4 == null) goto L14;
        if (TextUtils.isEmpty(r4.threadName) == true) goto L14;
        if (r4.threadCpuTime == 0) goto L14;
        j r5 = new j();     // Catch: NumberFormatException -> L16
        r5.n(r3);     // Catch: NumberFormatException -> L16
        r5.o(r4.threadName);     // Catch: NumberFormatException -> L16
        r5.m(r4.threadCpuTime);     // Catch: NumberFormatException -> L16
        r10.put(Integer.valueOf(r3), r5);     // Catch: NumberFormatException -> L16
    L14:
        r2 = r2 + 1;
        goto L3
    }
}
