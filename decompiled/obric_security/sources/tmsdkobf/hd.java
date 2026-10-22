package tmsdkobf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class hd extends fd {
    public hd(s6 r2, ArrayList r3, int r4) {
        super(r2, r3, 2, r4);
    }

    @Override // tmsdkobf.fd
    protected boolean b() {
        monitor-enter(this);
        int r1 = 0;
        if (this.m != null) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L60
        return false;
    L7:
        Map r0 = this.m.e().c(this.m.g());     // Catch: Throwable -> L60
        if (r0 != null) goto L10;
    L57:
        this.m.c(-2);     // Catch: Throwable -> L60
        monitor-exit(this);     // Catch: Throwable -> L60
        return false;
    L10:
        if (r0.size() == 0) goto L57;
        String[] r2 = (String[]) r0.keySet().toArray(new String[0]);     // Catch: Throwable -> L60
        this.g.setRootPaths(r2);     // Catch: Throwable -> L60
        if (this.h == null) goto L15;
        this.h.setRootPaths(r2);     // Catch: Throwable -> L60
    L15:
        List r3 = this.m.e().b();     // Catch: Throwable -> L60
        if (r3 == null) goto L23;
        int r4 = r3.size();     // Catch: Throwable -> L60
        String[] r5 = new String[r4];     // Catch: Throwable -> L60
        StringBuilder r6 = new StringBuilder();     // Catch: Throwable -> L60
        int r7 = 0;
    L18:
        if (r7 >= r4) goto L20;
        r6.setLength(0);     // Catch: Throwable -> L60
        kd.a(r6, (kd) r3.get(r7));     // Catch: Throwable -> L60
        r5[r7] = r6.toString();     // Catch: Throwable -> L60
        r7 = r7 + 1;     // Catch: Throwable -> L60
        goto L18
    L20:
        this.g.setComRubRule(r5);     // Catch: Throwable -> L60
        if (this.h == null) goto L23;
        this.h.setComRubRule(r5);     // Catch: Throwable -> L60
    L23:
        List r8 = this.m.e().c();     // Catch: Throwable -> L60
        if (r8 == null) goto L32;
        int r9 = r8.size();     // Catch: Throwable -> L60
        String[] r10 = new String[r9];     // Catch: Throwable -> L60
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L60
        int r12 = 0;
    L26:
        if (r12 >= r9) goto L28;
        r11.setLength(0);     // Catch: Throwable -> L60
        kd.a(r11, (kd) r8.get(r12));     // Catch: Throwable -> L60
        r10[r12] = r11.toString();     // Catch: Throwable -> L60
        r12 = r12 + 1;     // Catch: Throwable -> L60
        goto L26
    L28:
        this.g.setOtherFilterRule(r10);     // Catch: Throwable -> L60
        if (this.h == null) goto L32;
        this.h.setOtherFilterRule(r10);     // Catch: Throwable -> L60
    L32:
        if (this.q != null) goto L34;
    L36:
        List r13 = this.m.a();     // Catch: Throwable -> L60
    L37:
        if (r13 != null) goto L39;
    L54:
        this.m.c(-3);     // Catch: Throwable -> L60
        monitor-exit(this);     // Catch: Throwable -> L60
        return false;
    L39:
        if (r13.isEmpty() == true) goto L54;
        long r14 = System.currentTimeMillis();     // Catch: Throwable -> L60
        int r15 = r2.length;     // Catch: Throwable -> L60
    L42:
        if (r1 >= r15) goto L50;
        String r16 = r2[r1];     // Catch: Throwable -> L60
        Iterator r17 = r13.iterator();     // Catch: Throwable -> L60
    L45:
        if (r17.hasNext() == false) goto L49;
        String r18 = (String) r17.next();     // Catch: Throwable -> L60
        if (this.n == true) goto L45;
        this.g.scanPath(r18, r16, this.r + 5);     // Catch: Throwable -> L60
        goto L45
    L49:
        r1 = r1 + 1;     // Catch: Throwable -> L60
        goto L42
    L50:
        q8.c("ScanPkg", "ScanPkg, pathSize = " + r2.length + ", storageSize = " + r13.size() + ", costTimeOne = " + (System.currentTimeMillis() - r14));     // Catch: Throwable -> L60
        monitor-exit(this);     // Catch: Throwable -> L60
        return true;
    L34:
        if (this.q.isEmpty() == true) goto L36;
        r13 = new ArrayList(this.q);     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        throw th;
    }

    @Override // tmsdkobf.fd
    protected void k() {
        this.o.a(2);
    }
}
