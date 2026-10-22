package tmsdkobf;

import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tmsdk.common.tcc.DeepCleanEngine;
import tmsdk.common.tcc.DeepCleanSAFEngine;

/* JADX INFO: loaded from: classes5.dex */
public class gd extends fd {
    public gd(s6 r2, ArrayList r3, int r4) {
        super(r2, r3, 1, r4);
    }

    private String[] a(List r4, String[] r5, Set r6, boolean r7) {
        if (r6 != null) goto L4;
    L46:
        return r5;
    L4:
        if (r6.isEmpty() == true) goto L46;
        if (r7 == true) goto L14;
        HashSet r3 = new HashSet();
        Iterator r8 = r6.iterator();
    L10:
        if (r8.hasNext() == false) goto L35;
        String r9 = (String) r8.next();
        if (r9.toLowerCase().startsWith("/storage/emulated/".toLowerCase()) == true) goto L10;
        r3.add(r9);
    L35:
        if (r5 == null) goto L45;
        if (r5.length == 0) goto L45;
        String[] r10 = (String[]) Arrays.copyOf(r5, r5.length + r3.size());
        int r11 = r5.length;
        Iterator r12 = r3.iterator();
    L41:
        if (r12.hasNext() == false) goto L43;
        r10[r11] = (String) r12.next();
        r11 = r11 + 1;
        goto L41
    L43:
        return r10;
    L45:
        return (String[]) r3.toArray(new String[0]);
    L14:
        r3 = new HashSet();
        if (r4 == null) goto L35;
        if (r4.isEmpty() == true) goto L35;
        Iterator r13 = r4.iterator();
    L20:
        if (r13.hasNext() == false) goto L35;
        String r14 = (String) r13.next();
        if (TextUtils.isEmpty(r14) == true) goto L20;
        Iterator r0 = r6.iterator();
    L26:
        if (r0.hasNext() == false) goto L20;
        String r1 = (String) r0.next();
        if (TextUtils.isEmpty(r1) == true) goto L26;
        if (r1.startsWith(r14) == false) goto L26;
        String r2 = r1.substring(r14.length());
        if (TextUtils.isEmpty(r2) == true) goto L26;
        r3.add(r2);
        goto L26
    }

    @Override // tmsdkobf.fd
    protected boolean b() {
        if (this.m != null) goto L5;
        return false;
    L5:
        List r0 = g();
        if (r0 != null) goto L8;
    L28:
        this.m.c(-3);
        return false;
    L8:
        if (r0.isEmpty() == true) goto L28;
        if (a(r0, this.m, this.g, this.h, this.b) == true) goto L13;
        return false;
    L13:
        long r1 = System.currentTimeMillis();
        Iterator r2 = r0.iterator();
    L15:
        if (r2.hasNext() == false) goto L20;
        String r3 = (String) r2.next();
        if (this.n == true) goto L15;
        this.g.scanPath(r3, LibrarianImpl.Constants.SEPARATOR, this.r);
        goto L15
    L20:
        if (this.h != null) goto L22;
    L26:
        q8.c("ScanTime", "ScanDisk doScan costTime = " + (System.currentTimeMillis() - r1));
        return true;
    L22:
        if (this.n == true) goto L26;
        if (ve.f581a == false) goto L26;
        this.h.scanPath("", "/android/data");
        goto L26
    }

    @Override // tmsdkobf.fd
    protected boolean c(List r7) {
        if (a(r7, this.m, this.i, this.j, null) == true) goto L6;
        return false;
    L6:
        long r0 = System.currentTimeMillis();
        a("AnData2", this.m, this.i, this.j);
        q8.c("ScanTime", "ScanDisk doScanAnData2 costTime = " + (System.currentTimeMillis() - r0));
        return true;
    }

    @Override // tmsdkobf.fd
    protected boolean d(List r7) {
        if (a(r7, this.m, this.k, this.l, null) == true) goto L6;
        return false;
    L6:
        long r0 = System.currentTimeMillis();
        a("AnData3", this.m, this.k, this.l);
        q8.c("ScanTime", "ScanDisk doScanAnData3 costTime = " + (System.currentTimeMillis() - r0));
        return true;
    }

    @Override // tmsdkobf.fd
    protected boolean j() {
        if (this.m != null) goto L6;
        return false;
    L6:
        if (this.m.k() == true) goto L9;
        this.m.c(-2);
        return false;
    L9:
        return true;
    }

    @Override // tmsdkobf.fd
    protected void k() {
        if (this.m != null) goto L5;
        return;
    L5:
        if (this.o == null) goto L14;
        boolean r0 = this.m.i();
        s6 r1 = this.o;
        if (r0 == false) goto L10;
        int r2 = 1;
    L11:
        r1.a(r2);
        return;
    L10:
        r2 = 0;
        goto L11
    }

    private void a(String r7, ad r8, DeepCleanEngine r9) {
        if (this.e.getAndSet(true) == false) goto L5;
        return;
    L5:
        if (r8 == null) goto L29;
        if (r9 == null) goto L31;
        long r2 = System.currentTimeMillis();
        List r0 = g();
        if (r0 != null) goto L11;
        return;
    L11:
        if (r0.isEmpty() == true) goto L32;
        String[] r10 = a(r0, r8.e().e(), this.c, true);
        if (r10 == null) goto L16;
        r9.setWhitePaths(r10);
    L16:
        Iterator r11 = r0.iterator();
    L18:
        if (r11.hasNext() == false) goto L22;
        String r1 = (String) r11.next();
        if (this.n == true) goto L18;
        r9.scanPath(r1, LibrarianImpl.Constants.SEPARATOR, this.r);
        goto L18
    L22:
        q8.c("ScanTime", "ScanDisk doLastScanSD " + r7 + " costTime = " + (System.currentTimeMillis() - r2) + ", storageSize = " + r0.size());
        return;
    L32:
        return;
    L31:
        return;
    }

    @Override // tmsdkobf.fd
    protected boolean b(List r7) {
        if (a(r7, this.m, this.g, this.h, null) == true) goto L6;
        return false;
    L6:
        long r0 = System.currentTimeMillis();
        a("AnData1", this.m, this.g, this.h);
        q8.c("ScanTime", "ScanDisk doScanAnData1 costTime = " + (System.currentTimeMillis() - r0));
        return true;
    }

    @Override // tmsdkobf.fd
    protected boolean c() {
        if (this.m != null) goto L5;
        return false;
    L5:
        List r0 = g();
        if (r0 != null) goto L8;
    L37:
        this.m.c(-3);
        return false;
    L8:
        if (r0.isEmpty() == true) goto L37;
        if (a(r0, this.m, this.i, this.j, null) == true) goto L13;
        return false;
    L13:
        long r1 = System.currentTimeMillis();
        Set r3 = this.b;
        if (r3 != null) goto L16;
    L35:
        q8.c("ScanTime", "ScanDisk doScanEx costTime = " + (System.currentTimeMillis() - r1));
        return true;
    L16:
        if (r3.isEmpty() == true) goto L35;
        Iterator r4 = this.b.iterator();
    L19:
        if (r4.hasNext() == false) goto L35;
        String r5 = (String) r4.next();
        Iterator r6 = r0.iterator();
    L22:
        if (r6.hasNext() == false) goto L29;
        String r7 = (String) r6.next();
        if (this.i == null) goto L22;
        if (this.n == true) goto L22;
        this.i.scanPath(r7, r5, this.r);
        goto L22
    L29:
        if (this.j == null) goto L19;
        if (this.n == true) goto L19;
        if (ve.f581a == false) goto L19;
        this.j.scanPath("", r5);
        goto L19
    }

    private void a(String r6, ad r7, DeepCleanSAFEngine r8) {
        if (this.f.getAndSet(true) == false) goto L5;
        return;
    L5:
        if (r7 == null) goto L13;
        if (r8 == null) goto L14;
        long r0 = System.currentTimeMillis();
        String[] r5 = a(g(), r7.e().e(), this.c, false);
        if (r5 == null) goto L11;
        r8.setWhitePaths(r5);
    L11:
        r8.scanPath("", "/android/data");
        q8.c("ScanTime", "ScanDisk doLastScanSaf " + r6 + " costTime = " + (System.currentTimeMillis() - r0));
        return;
    L14:
        return;
    }

    private void a(String r7, ad r8, DeepCleanEngine r9, DeepCleanSAFEngine r10) {
        if (r8 != null) goto L5;
        return;
    L5:
        if (this.d.isEmpty() == true) goto L23;
        if (this.n == true) goto L23;
        ha r0 = (ha) this.d.poll();
        if (r0 == null) goto L5;
        if (TextUtils.isEmpty(r0.b) == true) goto L5;
        long r1 = System.currentTimeMillis();
        if (TextUtils.isEmpty(r0.f242a) == false) goto L18;
        if (r10 == null) goto L20;
        r10.scanPath(r0.f242a, r0.b);
    L20:
        long r3 = System.currentTimeMillis() - r1;
        if (r3 <= 1000) goto L5;
        q8.a("ScanTime", "ScanDisk " + r7 + " costTime = " + r3 + ", scanPath = " + r0.f242a + r0.b);
        goto L5
    L18:
        if (r9 == null) goto L20;
        r9.scanPath(r0.f242a, r0.b, this.r);
    L23:
        if (r9 == null) goto L25;
        a(r7, r8, r9);
    L25:
        if (r10 == null) goto L38;
        a(r7, r8, r10);
        return;
    }

    private boolean a(List r5, ad r6, DeepCleanEngine r7, DeepCleanSAFEngine r8, Set r9) {
        if (r7 != null) goto L6;
        if (r8 != null) goto L6;
        return false;
    L6:
        e6 r1 = r6.e();
        String[] r4 = a(r5, r1.e(), r9, false);
        if (r7 == null) goto L10;
        if (r4 == null) goto L10;
        r7.setWhitePaths(r4);
    L10:
        if (r8 == null) goto L13;
        if (r4 == null) goto L13;
        r8.setWhitePaths(r4);
    L13:
        String[] r10 = r1.d();
        if (r10 != null) goto L16;
    L42:
        r6.c(-2);
        return false;
    L16:
        if (r10.length == 0) goto L42;
        if (r7 == null) goto L20;
        r7.setRootPaths(r10);
    L20:
        if (r8 == null) goto L22;
        r8.setRootPaths(r10);
    L22:
        List r11 = r1.b();
        if (r11 == null) goto L31;
        int r12 = r11.size();
        String[] r13 = new String[r12];
        StringBuilder r14 = new StringBuilder();
        int r2 = 0;
    L25:
        if (r2 >= r12) goto L27;
        r14.setLength(0);
        kd.a(r14, (kd) r11.get(r2));
        r13[r2] = r14.toString();
        r2 = r2 + 1;
        goto L25
    L27:
        if (r7 == null) goto L29;
        r7.setComRubRule(r13);
    L29:
        if (r8 == null) goto L31;
        r8.setComRubRule(r13);
    L31:
        List r15 = r1.c();
        if (r15 == null) goto L46;
        int r16 = r15.size();
        String[] r17 = new String[r16];
        StringBuilder r18 = new StringBuilder();
        int r3 = 0;
    L34:
        if (r3 >= r16) goto L36;
        r18.setLength(0);
        kd.a(r18, (kd) r15.get(r3));
        r17[r3] = r18.toString();
        r3 = r3 + 1;
        goto L34
    L36:
        if (r7 == null) goto L38;
        r7.setOtherFilterRule(r17);
    L38:
        if (r8 == null) goto L47;
        r8.setOtherFilterRule(r17);
        return true;
    L47:
        return true;
    L46:
        return true;
    }
}
