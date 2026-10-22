package tmsdkobf;

import com.android.apksig.internal.apk.v1.V1SchemeConstants;
import com.qq.taf.jce.JceStruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import tmsdk.common.CallerIdent;
import tmsdk.common.TMServiceFactory;

/* JADX INFO: loaded from: classes5.dex */
public class ee implements q6, o6 {
    private static ee c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    q6.b f180a;
    te b;

    class a extends q6.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ee f181a;

        a(ee r1) {
            this.f181a = r1;
        }

        @Override // tmsdkobf.q6.c
        public ArrayList a() {
            return this.f181a.c();
        }
    }

    static {
    }

    private ee() {
        this.f180a = null;
        this.b = null;
        this.b = (te) qd.a(12);
    }

    public static ee d() {
        if (c != null) goto L15;
        monitor-enter(ee.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = new ee();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ee.class);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    @Override // tmsdkobf.q6
    public int a() {
        return 2;
    }

    @Override // tmsdkobf.q6
    public boolean a(ArrayList r2) {
        boolean r1 = de.c().a(r2);
        q8.c("SoftListProfileService", "SoftListProfile UpdateImage : " + r1);
        return r1;
    }

    public ArrayList b(ArrayList r10) {
        ArrayList r0 = new ArrayList();
        if (r10 != null) goto L5;
    L41:
        return r0;
    L5:
        if (r10.size() == 0) goto L41;
        ArrayList r1 = de.c().b();
        if (r1 != null) goto L10;
    L38:
        q8.c("SoftListProfileService", "fullCheck|AllReport size:" + r10.size());
        a(r0, r10, 0);
        if (fe.c().b() == false) goto L41;
        fe.c().a(false);
        goto L41
    L10:
        if (r1.size() == 0) goto L38;
        if (fe.c().b() == true) goto L38;
        q8.c("SoftListProfileService", "not !!! fullCheck|AllReport size:" + r10.size());
        LinkedList r2 = new LinkedList();
        LinkedList r3 = new LinkedList();
        Iterator r4 = r1.iterator();
    L16:
        if (r4.hasNext() == false) goto L36;
        ge r5 = (ge) r4.next();
        if (r5 == null) goto L16;
        String r6 = r5.f218a;
        if (r6 == null) goto L16;
        if (r6.trim().equals("") == true) goto L16;
        Iterator r7 = r10.iterator();
    L26:
        if (r7.hasNext() == false) goto L32;
        ge r8 = (ge) ((JceStruct) r7.next());
        if (r8.f218a.equals(r5.f218a) == false) goto L26;
        if (a(r8, r5) == true) goto L33;
        r2.add(r8);
    L33:
        if (r8 == null) goto L34;
        r10.remove(r8);
        goto L16
    L34:
        r5.j = 0;
        r3.add(r5);
        goto L16
    L32:
        r8 = null;
        goto L33
    L36:
        a(r0, r2, 3);
        a(r0, r3, 2);
        a(r0, r10, 1);
        return r0;
    }

    public ArrayList c() {
        ArrayList r3 = new ArrayList();
        ArrayList r0 = TMServiceFactory.getSystemInfoService().getInstalledApp(89, 2);
        if (r0 != null) goto L5;
    L14:
        return r3;
    L5:
        if (r0.size() <= 0) goto L14;
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L14;
        m r2 = (m) r1.next();
        if (r2 == null) goto L9;
        r3.add(a(r2, r2.k()));
        goto L9
    }

    public void e() {
        fe.c().a(true);
    }

    private void a(List r2, Collection r3, int r4) {
        Iterator r1 = r3.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        JceStruct r5 = (JceStruct) r1.next();
        if (r5 == null) goto L4;
        q6.a r0 = new q6.a();
        r0.b = r4;
        r0.f434a = r5;
        r2.add(r0);
        goto L4
    }

    @Override // tmsdkobf.q6
    public void b() {
        ArrayList r4 = ((te) qd.a(12)).getInstalledApp(89, 2);
        LinkedList r0 = new LinkedList();
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L16;
        m r1 = (m) r5.next();
        if (r1 == null) goto L4;
        ge r2 = a(r1, r1.k());
        if (r2 == null) goto L4;
        String r3 = r2.f218a;
        if (r3 == null) goto L4;
        if ("".equals(r3) == true) goto L4;
        r0.add(r2);
        goto L4
    }

    public void c(ArrayList r15) {
        if (r15 != null) goto L4;
        return;
    L4:
        if (r15.size() == 0) goto L73;
        Iterator r0 = r15.iterator();
        ArrayList r7 = null;
        ArrayList r8 = null;
        ArrayList r9 = null;
        ArrayList r10 = null;
    L8:
        if (r0.hasNext() == false) goto L35;
        q6.a r1 = (q6.a) r0.next();
        if (r1 == null) goto L8;
        if (r1.f434a == null) goto L8;
        int r2 = r1.b;
        if (r2 != 0) goto L16;
        if (r7 != null) goto L33;
        r7 = new ArrayList();
    L33:
        r7.add(r1.f434a);
        goto L8
    L16:
        if (r2 != 1) goto L18;
        if (r10 != null) goto L30;
        r10 = new ArrayList();
    L30:
        r10.add(r1.f434a);
        goto L8
    L18:
        if (r2 != 2) goto L20;
        if (r9 != null) goto L27;
        r9 = new ArrayList();
    L27:
        r9.add(r1.f434a);
        goto L8
    L20:
        if (r2 != 3) goto L8;
        if (r8 != null) goto L24;
        r8 = new ArrayList();
    L24:
        r8.add(r1.f434a);
        goto L8
    L35:
        if (r7 != null) goto L37;
    L39:
        if (r8 != null) goto L41;
    L43:
        if (r9 != null) goto L45;
    L47:
        if (r10 != null) goto L49;
        return;
    L49:
        if (r10.size() <= 0) goto L72;
        va.a().a(CallerIdent.getIdent(1, 4294967296L), 2, 1, r10);
        return;
    L72:
        return;
    L45:
        if (r9.size() <= 0) goto L47;
        va.a().a(CallerIdent.getIdent(1, 4294967296L), 2, 2, r9);
        goto L47
    L41:
        if (r8.size() <= 0) goto L43;
        va.a().a(CallerIdent.getIdent(1, 4294967296L), 2, 3, r8);
        goto L43
    L37:
        if (r7.size() <= 0) goto L39;
        va.a().a(CallerIdent.getIdent(1, 4294967296L), 2, 0, r7);
        goto L39
    }

    private boolean a(ge r6, ge r7) {
        if (r6 != null) goto L7;
        if (r7 != null) goto L7;
        return true;
    L7:
        if (r6 == null) goto L38;
        if (r7 == null) goto L38;
        if (r6.d == r7.d) goto L14;
        return false;
    L14:
        if (r6.h == r7.h) goto L17;
        return false;
    L17:
        if (a(r6.f218a, r7.f218a) == true) goto L20;
        return false;
    L20:
        if (a(r6.b, r7.b) == true) goto L23;
        return false;
    L23:
        if (a(r6.c, r7.c) == true) goto L26;
        return false;
    L26:
        if (a(r6.g, r7.g) == true) goto L29;
        return false;
    L29:
        if (a(r6.i, r7.i) == true) goto L32;
        return false;
    L32:
        if (a(r6.f, r7.f) == true) goto L35;
        return false;
    L35:
        if (r6.e == r7.e) goto L37;
        return false;
    L37:
        return true;
    L38:
        return false;
    }

    @Override // tmsdkobf.q6
    public void a(q6.b r2) {
        this.b.removePackageChangeListener(this);
        this.b.addPackageChangeListener(this);
        this.f180a = r2;
    }

    public static String a(String r6) {
        if (r6 != null) goto L5;
        return "";
    L5:
        BufferedReader r2 = null;
        ZipFile r3 = new ZipFile(r6);     // Catch: Throwable -> L44
        if (new File(r6).exists() == false) goto L73;
        ZipEntry r7 = r3.getEntry(V1SchemeConstants.MANIFEST_ENTRY_NAME);     // Catch: Throwable -> L56
        if (r7 == null) goto L39;
        BufferedReader r4 = new BufferedReader(new InputStreamReader(r3.getInputStream(r7)));     // Catch: Throwable -> L56
    L67:
        String r8 = r4.readLine();     // Catch: Throwable -> L38
        if (r8 == null) goto L37;
        if (r8.contains("classes.dex") == false) goto L67;
        String r9 = r4.readLine();     // Catch: Throwable -> L38
        if (r9 == null) goto L67;
        if (r9.contains("SHA1-Digest") == false) goto L67;
        int r5 = r9.indexOf(":");     // Catch: Throwable -> L38
        if (r5 <= 0) goto L67;
        String r10 = r9.substring(r5 + 1).trim();     // Catch: Throwable -> L38
        r4.close();     // Catch: Throwable -> L30
    L59:
        r3.close();     // Catch: Throwable -> L34
    L36:
        return r10;
    L34:
        th = move-exception;
        q8.b("SoftListProfileService", th);
    L30:
        th = move-exception;
        q8.b("SoftListProfileService", th);
        goto L59
    L37:
        r2 = r4;
    L38:
        r2 = r4;
    L39:
        if (r2 == null) goto L63;
        r2.close();     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        q8.b("SoftListProfileService", th);
    L63:
        r3.close();     // Catch: Throwable -> L53
    L55:
        return "";
    L53:
        th = move-exception;
        q8.b("SoftListProfileService", th);
        goto L55
    L73:
        r3.close();     // Catch: Throwable -> L11
    L13:
        return "";
    L11:
        th = move-exception;
        q8.b("SoftListProfileService", th);
    L45:
        if (r2 != null) goto L71;
    L50:
        if (r3 == null) goto L55;
    L71:
        r2.close();     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        q8.b("SoftListProfileService", th);
    L44:
        r3 = null;
        goto L45
    }

    @Override // tmsdkobf.q6
    public void a(wa r9) {
        int r0 = fe.c().a();
        if (r0 > 0) goto L5;
        r0 = 500000;
    L5:
        int r7 = r0;
        q8.a("SoftListProfileService", "softListFullUploadQuantity : " + r7);
        va.a().a(CallerIdent.getIdent(1, 4294967296L), 2, new a(this), r9, r7);
    }

    private static final boolean a(String r0, String r1) {
        if (r0 != r1) goto L5;
        return true;
    L5:
        if (r0 != null) goto L9;
        return false;
    L9:
        return r0.equals(r1);
    }

    private static ge a(m r5, String r6) {
        ge r0 = new ge();
        if (r5 != null) goto L6;
        r0.f218a = r6;
        return r0;
    L6:
        r0.d = r5.m();
        r0.c = r5.e();
        r0.e = r5.t();
        r0.f218a = r5.k();
        r0.b = r5.b();
        r0.i = r5.p();
        r0.h = r5.q();
        r0.j = r5.j() / 1000;
        String r7 = r5.a();
        r0.g = "";
        r0.f = a(r7);
        return r0;
    }

    @Override // tmsdkobf.q6
    public void a(int r1) {
        fe.c().a(r1);
    }
}
