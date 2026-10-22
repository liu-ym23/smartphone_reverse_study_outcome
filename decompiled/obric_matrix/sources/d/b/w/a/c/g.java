package d.b.w.a.c;

import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<File> f15240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<Integer> f15241e;

    public g() {
        super("");
        this.f15240d = new ArrayList();
        this.f15241e = new ArrayList();
    }

    private b c(List<File> r6, List<Integer> r7) {
        if (r6 != null) goto L4;
        return null;
    L4:
        if (r6.isEmpty() == true) goto L23;
        if (r7 != null) goto L7;
        return null;
    L7:
        if (r7.isEmpty() == false) goto L9;
        return null;
    L9:
        if (r6.size() != r7.size()) goto L26;
        d.b.w.a.b.e.c r0 = new d.b.w.a.b.e.c();
        int r1 = r6.size();
        int r2 = 0;
    L12:
        if (r2 >= r1) goto L17;
        LinkedHashMap<Long, Long> r3 = d(r6.get(r2), r7.get(r2).intValue());
        if (r3 == null) goto L16;
        r0.f(r3);
    L16:
        r2 = r2 + 1;
        goto L12
    L17:
        return r0;
    L26:
        return null;
    L23:
        return null;
    }

    private LinkedHashMap<Long, Long> d(File r8, int r9) {
        BufferedReader r7 = d.b.w.a.d.c.b(r8);
        LinkedHashMap<Long, Long> r10 = null;
        if (r7 != null) goto L25;
        return null;
    L25:
        String r0 = r7.readLine();     // Catch: Exception -> L19 Throwable -> L23
        if (r0 == null) goto L17;
        if (r0.isEmpty() == true) goto L17;
        String[] r1 = r0.split(" ");     // Catch: Exception -> L19 Throwable -> L23
        if (r1.length <= 1) goto L17;
        if (r10 != null) goto L15;
        r10 = new LinkedHashMap();     // Catch: Exception -> L19 Throwable -> L23
    L15:
        r10.put(Long.valueOf(Long.parseLong(r1[0])), Long.valueOf(((long) (r9 * 10)) * Long.parseLong(r1[1])));     // Catch: Exception -> L19 Throwable -> L23
    L17:
        d.b.w.a.d.c.a(r7);
        return r10;
    L23:
        d.b.w.a.d.c.a(r7);
        return r10;
    L19:
        e = move-exception;
        d.b.w.a.d.b.c(Log.getStackTraceString(e));     // Catch: Throwable -> L23
        d.b.w.a.d.c.a(r7);
        return r10;
    }

    @Override // d.b.w.a.c.a
    public b b() {
        if (this.f15240d.isEmpty() == false) goto L12;
        List<d.b.w.a.d.a.g> r0 = d.b.w.a.d.a.b();
        if (r0 != null) goto L8;
        return null;
    L8:
        Iterator<d.b.w.a.d.a.g> r1 = r0.iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        d.b.w.a.d.a.g r2 = r1.next();
        this.f15240d.add(new File("/sys/devices/system/cpu/cpufreq/" + r2.b() + "/stats/time_in_state"));
        this.f15241e.add(Integer.valueOf(r2.a().size()));
    L12:
        b r3 = c(this.f15240d, this.f15241e);
        this.f15232a = r3;
        return r3;
    }
}
