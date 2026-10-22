package d.b.w.a.c;

import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f15236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<List<File>> f15237e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f15238f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<Integer> f15239g;

    public f() {
        super("");
        this.f15236d = false;
        this.f15237e = new ArrayList();
        this.f15238f = -1;
    }

    private b c(List<List<File>> r3) {
        if (r3 != null) goto L4;
        return null;
    L4:
        if (r3.isEmpty() == true) goto L20;
        d.b.w.a.b.e.a r0 = new d.b.w.a.b.e.a();
        Iterator<List<File>> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L12;
        List<Long> r1 = d(r4.next());
        if (r1 == null) goto L8;
        r0.f(r1);
        goto L8
    L12:
        return r0;
    L20:
        return null;
    }

    private List<Long> d(List<File> r6) {
        ArrayList r5 = new ArrayList();
        Iterator<File> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L24;
        BufferedReader r0 = d.b.w.a.d.c.b(r7.next());
        if (r0 == null) goto L7;
    L25:
        String r1 = r0.readLine();     // Catch: Throwable -> L17 Exception -> L19
        if (r1 == null) goto L16;
        if (r1.isEmpty() == true) goto L16;
        r5.add(Long.valueOf(Long.parseLong(r1) / 1000));     // Catch: Throwable -> L17 Exception -> L19
    L16:
        d.b.w.a.d.c.a(r0);
    L19:
        e = move-exception;
        d.b.w.a.d.b.c(Log.getStackTraceString(e));     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        d.b.w.a.d.c.a(r0);
        throw th;
    L7:
        return null;
    L24:
        return r5;
    }

    @Override // d.b.w.a.c.a
    public b b() {
        if (this.f15236d == true) goto L6;
        this.f15238f = d.b.w.a.d.a.c();
        this.f15239g = d.b.w.a.d.a.e();
        this.f15236d = true;
    L6:
        if (this.f15239g != null) goto L10;
        return null;
    L10:
        if (this.f15237e.isEmpty() == false) goto L18;
        int r1 = 0;
    L13:
        if (r1 >= this.f15238f) goto L18;
        int r2 = this.f15239g.get(r1).intValue();
        ArrayList r3 = new ArrayList();
        int r4 = 0;
    L15:
        if (r4 >= r2) goto L17;
        r3.add(new File("/sys/devices/system/cpu/cpu" + r1 + "/cpuidle/state" + r4 + "/time"));
        r4 = r4 + 1;
        goto L15
    L17:
        this.f15237e.add(r3);
        r1 = r1 + 1;
    L18:
        b r0 = c(this.f15237e);
        this.f15232a = r0;
        return r0;
    }
}
