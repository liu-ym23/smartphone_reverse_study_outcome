package tmsdkobf;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import tmsdk.common.TMSDKContext;

/* JADX INFO: loaded from: classes5.dex */
public final class f {
    static f b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    me f188a;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f189a;
        final /* synthetic */ int b;
        final /* synthetic */ f c;

        a(f r1, int r2, int r3) {
            this.c = r1;
            this.f189a = r2;
            this.b = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            r8.c("ccrService", "doSaveActionData() modelId:" + this.f189a);
            String r0 = f.a(this.f189a);
            long r1 = System.currentTimeMillis();
            String r3 = this.c.d().getString(r0, null);
            if (r3 != null) goto L5;
        L7:
            ArrayList r4 = new ArrayList();
            e r5 = new e();
            r5.f168a = this.f189a;
            r5.c = r1;
            r5.b = 1;
            r5.d = this.b;
            r4.add(r5);
            String r2 = f.b(r4);
            if (r2 == null) goto L14;
            StringBuilder r6 = new StringBuilder();
            if (r3 == null) goto L12;
            r6.append(r3);
        L12:
            r6.append(r2);
            this.c.d().putString(r0, r6.toString());
            return;
        L14:
            return;
        L5:
            if (r3.length() <= 8192) goto L7;
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f190a;
        final /* synthetic */ int b;
        final /* synthetic */ f c;

        b(f r1, int r2, int r3) {
            this.c = r1;
            this.f190a = r2;
            this.b = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            r8.c("ccrService", "doSaveActionData() modelId:" + this.f190a);
            String r0 = f.a(this.f190a);
            long r1 = System.currentTimeMillis();
            ArrayList r3 = new ArrayList();
            e r4 = new e();
            r4.f168a = this.f190a;
            r4.c = r1;
            r4.b = 1;
            r4.d = this.b;
            r3.add(r4);
            String r2 = f.b(r3);
            if (r2 == null) goto L6;
            this.c.d().putString(r0, r2);
            return;
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f191a;
        final /* synthetic */ String b;
        final /* synthetic */ p6 c;
        final /* synthetic */ boolean d;
        final /* synthetic */ f e;

        c(f r1, int r2, String r3, p6 r4, boolean r5) {
            this.e = r1;
            this.f191a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            r8.c("ccrService", "doSavePiStringData() modelId:" + this.f191a + ", flag:" + this.b);
            String r0 = this.b;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.length() <= 0) goto L18;
            String r1 = f.a(this.f191a);
            String r2 = this.c.getString(r1, null);
            if (r2 != null) goto L10;
        L11:
            r2 = "";
        L12:
            StringBuilder r3 = new StringBuilder();
            r3.append(r2);
            r3.append(System.currentTimeMillis());
            r3.append("|");
            r3.append(this.b);
            r3.append("$");
            if (r3.length() <= 16384) goto L15;
            return;
        L15:
            this.c.putString(r1, r3.toString());
            return;
        L10:
            if (this.d == false) goto L12;
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f192a;
        final /* synthetic */ int b;
        final /* synthetic */ p6 c;
        final /* synthetic */ f d;

        d(f r1, int r2, int r3, p6 r4) {
            this.d = r1;
            this.f192a = r2;
            this.b = r3;
            this.c = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            String r0 = f.a(this.f192a);
            String r1 = String.valueOf(this.b);
            this.c.putString(r0, r1);
        }
    }

    f(Context r1) {
        this.f188a = (me) qd.a(9);
    }

    public static void a(int r3, String r4) {
        e().a(e().g(), r3, r4, false);
    }

    public static void b(int r3, String r4) {
        e().a(e().g(), r3, r4, true);
    }

    public static f e() {
        if (b != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new f(TMSDKContext.getApplicaionContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    public void c() {
        g().clear();
    }

    p6 d() {
        return this.f188a.b("actionStats");
    }

    p6 f() {
        return this.f188a.b("mulDataStats");
    }

    p6 g() {
        return this.f188a.b("stringStats");
    }

    public ArrayList h() {
        return a(d(), "Action");
    }

    public ArrayList i() {
        return b(f(), "MultiValue");
    }

    public ArrayList j() {
        return a(e().g());
    }

    public static void d(int r1) {
        String r2 = a(r1);
        e().g().remove(r2);
    }

    public static void e(int r2) {
        e().a(r2, 0);
    }

    public static void f(int r2) {
        e().b(r2, 0);
    }

    public void a() {
        d().clear();
    }

    public void b() {
        f().clear();
    }

    void c(int r2, int r3) {
        a(f(), r2, r3);
    }

    public static void c(int r1) {
        String r2 = a(r1);
        e().f().remove(r2);
    }

    public static void d(int r1, int r2) {
        e().c(r1, r2);
    }

    void a(int r3, int r4) {
        ve.f().a(new a(this, r3, r4), "doxxx");
    }

    void b(int r3, int r4) {
        ve.f().a(new b(this, r3, r4), "doxxx");
    }

    void a(p6 r9, int r10, String r11, boolean r12) {
        ve.f().a(new c(this, r10, r11, r9, r12), "doxxx");
    }

    ArrayList b(p6 r4, String r5) {
        if (r4 != null) goto L5;
        return null;
    L5:
        ArrayList r6 = new ArrayList();
        Map r7 = r4.getAll();
        if (r7 == null) goto L17;
        Iterator r8 = r7.entrySet().iterator();
    L9:
        if (r8.hasNext() == false) goto L17;
        Map.Entry r0 = (Map.Entry) r8.next();
        String r1 = (String) r0.getKey();     // Catch: Exception -> L18
        Object r2 = r0.getValue();     // Catch: Exception -> L18
        if ((r2 instanceof String) == false) goto L9;
        q4 r3 = c(Integer.valueOf(r1).intValue(), (String) r2);     // Catch: Exception -> L18
        if (r3 == null) goto L9;
        r6.add(r3);     // Catch: Exception -> L18
    L17:
        return r6;
    }

    q4 c(int r4, String r5) {
        q4 r0 = new q4();
        r0.f432a = r4;
        r0.d = a(r5);
        r0.b = (int) (System.currentTimeMillis() / 1000);
        return r0;
    }

    ArrayList d(int r11, String r12) {
        ArrayList r0 = new ArrayList();
        if (r12 != null) goto L24;
        return r0;
    L24:
        int r1 = r12.indexOf(";");     // Catch: Exception -> L23
        if (r1 == (-1)) goto L22;
        e r3 = new e();     // Catch: Exception -> L23
        String r5 = r12.substring(0, r1);     // Catch: Exception -> L23
        if (r5.indexOf("&") == (-1)) goto L18;
        r3.f168a = r11;     // Catch: Exception -> L23
        long r6 = Long.parseLong(r5.substring(0, r5.indexOf("&")));     // Catch: Exception -> L23
        r3.c = r6;     // Catch: Exception -> L23
        if (r6 != 0) goto L12;
        r3.c = System.currentTimeMillis();     // Catch: Exception -> L23
    L12:
        String r7 = r5.substring(r5.indexOf("&") + 1);     // Catch: Exception -> L23
        if (r7.indexOf("&") == (-1)) goto L15;
        r3.b = Integer.parseInt(r7.substring(0, r7.indexOf("&")));     // Catch: Exception -> L23
        r3.d = Integer.parseInt(r7.substring(r7.indexOf("&") + 1));     // Catch: Exception -> L23
    L16:
        r0.add(r3);     // Catch: Exception -> L23
        goto L18
    L15:
        r3.b = Integer.parseInt(r7);     // Catch: Exception -> L23
    L18:
        if (r1 == r12.length()) goto L22;
        r12 = r12.substring(r1 + 1);     // Catch: Exception -> L23
    L22:
        return r0;
    }

    static String a(int r2) {
        return "" + r2;
    }

    public static void b(int r1) {
        String r2 = a(r1);
        e().d().remove(r2);
    }

    public static String b(ArrayList r4) {
        StringBuffer r0 = new StringBuffer();
        int r1 = 0;
    L4:
        if (r1 >= r4.size()) goto L10;
        r0.append(((e) r4.get(r1)).c);
        r0.append("&");
        r0.append(((e) r4.get(r1)).b);
        if (((e) r4.get(r1)).d == 0) goto L8;
        r0.append("&");
        r0.append(((e) r4.get(r1)).d);
    L8:
        r0.append(";");
        r1 = r1 + 1;
        goto L4
    L10:
        return r0.toString();
    }

    ArrayList a(p6 r4, String r5) {
        Map r6 = null;
        if (r4 != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        r6 = r4.getAll();     // Catch: Exception -> L18
    L7:
        if (r6 == null) goto L17;
        Iterator r7 = r6.entrySet().iterator();
    L10:
        if (r7.hasNext() == false) goto L17;
        Map.Entry r8 = (Map.Entry) r7.next();
        String r1 = (String) r8.getKey();     // Catch: Exception -> L19
        Object r9 = r8.getValue();     // Catch: Exception -> L19
        if ((r9 instanceof String) == false) goto L10;
        r0.addAll(d(Integer.valueOf(r1).intValue(), (String) r9));     // Catch: Exception -> L19
    L17:
        return a(r0);
    }

    ArrayList a(p6 r12) {
        ArrayList r11 = new ArrayList();
        Map r13 = r12.getAll();
        if (r13 == null) goto L29;
        Iterator r14 = r13.entrySet().iterator();
    L6:
        if (r14.hasNext() == false) goto L29;
        Map.Entry r0 = (Map.Entry) r14.next();
        String r1 = (String) r0.getKey();     // Catch: Exception -> L30
        Object r2 = r0.getValue();     // Catch: Exception -> L30
        if (r2 == null) goto L6;
        if ((r2 instanceof String) == false) goto L6;
        String r3 = (String) r2;     // Catch: Exception -> L30
        if (r3.indexOf("$") <= 0) goto L6;
        int r4 = Integer.valueOf(r1).intValue();     // Catch: Exception -> L30
        String[] r5 = r3.split("\\$");     // Catch: Exception -> L30
        if (r5 == null) goto L6;
        if (r5.length <= 0) goto L6;
        int r6 = r5.length;     // Catch: Exception -> L30
        int r7 = 0;
    L21:
        if (r7 >= r6) goto L6;
        String[] r8 = r5[r7].split("\\|");     // Catch: Exception -> L30
        if (r8 == null) goto L28;
        if (r8.length != 2) goto L28;
        long r9 = Long.valueOf(r8[0]).longValue();     // Catch: Exception -> L30
        String r10 = r8[1];     // Catch: Exception -> L30
        q4 r15 = new q4();     // Catch: Exception -> L30
        r15.f432a = r4;     // Catch: Exception -> L30
        r15.b = (int) (r9 / 1000);     // Catch: Exception -> L30
        ArrayList r16 = new ArrayList();     // Catch: Exception -> L30
        r15.e = r16;     // Catch: Exception -> L30
        r16.add(r10);     // Catch: Exception -> L30
        r11.add(r15);     // Catch: Exception -> L30
    L28:
        r7 = r7 + 1;
    L29:
        return r11;
    }

    ArrayList a(ArrayList r7) {
        if (r7 != null) goto L5;
        return null;
    L5:
        ArrayList r6 = new ArrayList();
        Iterator r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L14;
        e r0 = (e) r8.next();
        if (r0.b <= 0) goto L7;
        q4 r1 = new q4();
        r1.f432a = r0.f168a;
        r1.b = (int) (r0.c / 1000);
        r1.c = r0.b;
        if (r0.d == 0) goto L13;
        ArrayList r2 = new ArrayList();
        r1.d = r2;
        r2.add(Integer.valueOf(r0.d));
    L13:
        r6.add(r1);
        goto L7
    L14:
        return r6;
    }

    ArrayList a(String r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        ArrayList r3 = new ArrayList();
        String[] r5 = r4.split("\\|");
        int r0 = r5.length;     // Catch: NumberFormatException -> L11
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L10;
        r3.add(Integer.valueOf(r5[r1]));     // Catch: NumberFormatException -> L11
        r1 = r1 + 1;
    L10:
        return r3;
    }

    void a(p6 r3, int r4, int r5) {
        ve.f().a(new d(this, r4, r5, r3), "doxxx");
    }
}
