package tmsdkobf;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class dk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private qg f159a;
    private volatile String b;
    private volatile String c;
    private volatile long d;

    class a implements z6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ dk f160a;

        a(dk r1) {
            this.f160a = r1;
        }
    }

    class b extends h {
        b(dk r1) {
            super(r1);
        }

        @Override // tmsdkobf.dk.h
        public void a(int r1, String r2) {
        }
    }

    class c extends h {
        final /* synthetic */ o7 b;
        final /* synthetic */ ql c;
        final /* synthetic */ dk d;

        c(dk r1, o7 r2, ql r3) {
            this.d = r1;
            this.b = r2;
            this.c = r3;
            super(r1);
        }

        @Override // tmsdkobf.dk.h
        public void a(int r2, String r3) {
            if (r2 != 0) goto L4;
            dk.a(this.d, this.b, r3, this.c);
            return;
        L4:
            this.b.a(r2, null);
        }
    }

    class d implements a7 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ dk f161a;

        d(dk r1) {
            this.f161a = r1;
        }

        @Override // tmsdkobf.a7
        public Cif a(int r9, long r10, int r12, JceStruct r13) {
            if (r13 != null) goto L6;
            return null;
        L6:
            if (r12 == 15020) goto L11;
            if (r12 == 15021) goto L11;
            return null;
        L11:
            return dk.a(this.f161a, r12, r10, r9, (ih) r13);
        }
    }

    class e implements qg.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f162a;
        final /* synthetic */ h b;
        final /* synthetic */ j1 c;
        final /* synthetic */ dk d;

        e(dk r1, int r2, h r3, j1 r4) {
            this.d = r1;
            this.f162a = r2;
            this.b = r3;
            this.c = r4;
        }

        @Override // tmsdkobf.qg.j
        public void a(boolean r7, int r8, int r9, ArrayList r10) {
            dk.a(this.d).f444a.k().a("VidManagerV2", 5010, this.f162a, 62, r8);
            dk.a(this.d).f444a.k().a(this.f162a);
            if (r8 == 0) goto L7;
            this.b.b(r8, null);
            return;
        L7:
            if (r10 != null) goto L11;
            this.b.b(-21002600, null);
            return;
        L11:
            if (r10.size() > 0) goto L14;
            this.b.b(-21002600, null);
            return;
        L14:
            ij r11 = (ij) r10.get(0);
            if (r11 != null) goto L19;
            this.b.b(-21002600, null);
            return;
        L19:
            if (r11.d == 0) goto L23;
            this.b.b(r8, null);
            return;
        L23:
            if (r11.e == 0) goto L26;
            this.b.b(-21300000, null);
            return;
        L26:
            byte[] r12 = r11.f;
            if (r12 != null) goto L30;
            this.b.b(-21000005, null);
            return;
        L30:
            uh r13 = (uh) z7.b(r12, new uh(), false);
            if (r13 != null) goto L34;
            this.b.b(-21000700, null);
            return;
        L34:
            dk.a(this.d, r13, this.b, this.c);
        }
    }

    class f implements w6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f163a;
        final /* synthetic */ j1 b;
        final /* synthetic */ dk c;

        f(dk r1, h r2, j1 r3) {
            this.c = r1;
            this.f163a = r2;
            this.b = r3;
        }

        @Override // tmsdkobf.w6
        public void onFinish(int r1, int r2, int r3, int r4, JceStruct r5) {
            if (r3 != 0) goto L6;
            if (r4 != 0) goto L6;
            if (r5 == null) goto L6;
            dk r6 = this.c;
            dk.a(r6, (uh) r5, this.f163a, this.b);
            return;
        L6:
            h r0 = this.f163a;
            if (r3 != 0) goto L10;
            r3 = r4;
        L10:
            r0.b(r3, null);
        }
    }

    class g implements w6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ o7 f164a;

        g(dk r1, o7 r2, String r3) {
            this.f164a = r2;
        }

        @Override // tmsdkobf.w6
        public void onFinish(int r1, int r2, int r3, int r4, JceStruct r5) {
            if (r3 != 0) goto L6;
            if (r4 != 0) goto L6;
            if (r5 == null) goto L6;
            this.f164a.a(0, ((jh) r5).b);
            return;
        L6:
            if (r3 != 0) goto L9;
            r3 = r4;
        L9:
            this.f164a.a(r3, null);
        }
    }

    public abstract class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ dk f165a;

        public h(dk r1) {
            this.f165a = r1;
        }

        public abstract void a(int r1, String r2);

        void b(int r2, String r3) {
            int r4 = j4.d(r2);
            a(r4, r3);
            dk.a(rd.e(), dk.a(this.f165a).f444a.f460a.c, r4, r3);
        }
    }

    public dk(Context r3, qg r4, int r5) {
        this.b = "";
        this.c = "";
        this.d = 0;
        this.f159a = r4;
        d();
        this.f159a.c().a(new a(this));
        e();
    }

    static /* synthetic */ qg a(dk r0) {
        return r0.f159a;
    }

    public boolean b() {
        return this.f159a.f444a.f460a.x;
    }

    public boolean c() {
        if (this.f159a.c().a() == true) goto L7;
        return false;
    L7:
        return TextUtils.isEmpty(this.b);
    }

    public void d() {
        this.b = this.f159a.c().o();
        this.c = this.f159a.c().p();
    }

    public void e() {
        d r7 = new d(this);
        this.f159a.f444a.a(0, 15021, new ih(), 0, r7);
        this.f159a.f444a.a(0, 15020, new ih(), 0, r7);
    }

    static /* synthetic */ void a(dk r0, o7 r1, String r2, ql r3) {
        r0.a(r1, r2, r3);
    }

    private j1 b(boolean r4, boolean r5, int r6) {
        if (c() == false) goto L6;
        return null;
    L6:
        if (a(r4) == true) goto L8;
        return null;
    L8:
        d1 r7 = qj.a(this.f159a.c());
        if (r7 != null) goto L11;
        return null;
    L11:
        if (r5 == true) goto L31;
        j1 r8 = this.f159a.c().j();
        if (r8 == null) goto L16;
        d1 r9 = r8.f280a;
    L17:
        if (r9 == null) goto L31;
        boolean r10 = qj.a(r7, r9);
        if (r10 == true) goto L28;
        String r11 = this.f159a.c().p();
        String r0 = this.b;
        if (TextUtils.isEmpty(r11) == false) goto L24;
    L29:
        return null;
    L24:
        if (TextUtils.isEmpty(r0) == true) goto L29;
        if (r11.equals(r0) == true) goto L29;
    L28:
        if (r10 == true) goto L31;
    L16:
        r9 = null;
    L31:
        return a(r7, r6);
    }

    static /* synthetic */ Cif a(dk r0, int r1, long r2, int r4, ih r5) {
        return r0.a(r1, r2, r4, r5);
    }

    static /* synthetic */ void a(dk r0, uh r1, h r2, j1 r3) {
        r0.a(r1, r2, r3);
    }

    public ah a() {
        ah r0 = new ah();
        r0.f101a = 1;
        if (TextUtils.isEmpty(this.c) == true) goto L5;
        String r2 = this.c;
    L6:
        r0.b = r2;
        return r0;
    L5:
        r2 = this.b;
        goto L6
    }

    public void a(h r3) {
        if (this.f159a.c().a() == true) goto L7;
        r3.b(-22, null);
        return;
    L7:
        if (c() == true) goto L10;
        r3.b(0, this.b);
        return;
    L10:
        a(a(this.f159a.c().l(), 0), r3);
    }

    public void a(boolean r2, boolean r3, int r4) {
        if (this.f159a.c().a() == true) goto L5;
        return;
    L5:
        j1 r5 = b(r2, r3, r4);
        if (r5 != null) goto L8;
        return;
    L8:
        a(r5, new b(this));
    }

    public void a(o7 r2, z6 r3, ql r4) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (r3.a() == true) goto L8;
        r2.a(-22, null);
        return;
    L8:
        a(a(this.f159a.c().l(), 0), new c(this, r2, r4));
    }

    private j1 a(d1 r2, int r3) {
        j1 r0 = new j1();
        r0.f280a = r2;
        r0.c = this.b;
        r0.b = this.f159a.c().p();
        r0.e = this.f159a.c().k();
        r0.d = r3;
        return r0;
    }

    private boolean a(boolean r8) {
        long r0 = System.currentTimeMillis();
        if (r8 == false) goto L7;
        this.d = r0;
        return true;
    L7:
        if (this.d > 0) goto L9;
    L13:
        this.d = r0;
        return true;
    L9:
        if (bk.a(r0, this.d, 60) == true) goto L13;
        return false;
    }

    public static void b(Context r4, String r5) {
        cj.b("VidManagerV2", "[shark_vid][shark_ipc]requestMainChannelRegisterTicket()");     // Catch: Throwable -> L6
        Intent r1 = new Intent(String.format("action.reg.tk:%s", new Object[]{r4.getPackageName()}));     // Catch: Throwable -> L6
        r1.setPackage(r4.getPackageName());     // Catch: Throwable -> L6
        r1.putExtra("k.s.p", r5);     // Catch: Throwable -> L6
        r4.sendBroadcast(r1, rd.f());     // Catch: Throwable -> L6
        return;
    }

    public static void b(Context r4, String r5, int r6, String r7) {
        Intent r1 = new Intent(String.format("action.vid.got:%s", new Object[]{r4.getPackageName()}));     // Catch: Throwable -> L5
        r1.setPackage(r4.getPackageName());     // Catch: Throwable -> L5
        r1.putExtra("k.s.p", r5);     // Catch: Throwable -> L5
        r1.putExtra("k.rc", r6);     // Catch: Throwable -> L5
        r1.putExtra("k.v", r7);     // Catch: Throwable -> L5
        r4.sendBroadcast(r1, rd.f());     // Catch: Throwable -> L5
        return;
    }

    private void a(j1 r11, h r12) {
        ch r2 = new ch();
        r2.f133a = 1;
        r2.b = z7.a(r11);
        if (b() == false) goto L13;
        int r0 = jl.b().a();
        if (r2.b != null) goto L8;
        r12.b(-20001500, null);
        return;
    L8:
        byte[] r1 = z7.a(r2);
        if (r1 != null) goto L12;
        r12.b(-20001500, null);
        return;
    L12:
        pi r3 = new pi();
        r3.f422a = 5010;
        r3.b = r0;
        r3.d = r1;
        ArrayList r4 = new ArrayList();
        r4.add(r3);
        this.f159a.f444a.k().a(r3.b, 5010, -1, null);
        this.f159a.b(r4, new e(this, r0, r12, r11));
        return;
    L13:
        this.f159a.f444a.a(5010, r2, new uh(), 0, new f(this, r12, r11), 60000);
    }

    private void a(uh r5, h r6, j1 r7) {
        byte[] r8 = r5.b;
        if (r8 != null) goto L6;
        r6.b(-21000700, null);
        return;
    L6:
        bi r9 = (bi) z7.b(r8, new bi(), false);
        if (r9 != null) goto L9;
    L13:
        r6.b(-21000700, null);
        return;
    L9:
        if (TextUtils.isEmpty(r9.f121a) == true) goto L13;
        String r10 = r9.f121a;
        a(r10, r7, true);
        r6.b(0, r10);
    }

    private void a(String r2, j1 r3, boolean r4) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        this.b = r2;
        this.f159a.c().a(r3);
        this.f159a.c().c(r2, r4);
        this.f159a.c().d(r2, r4);
    }

    private Cif a(int r1, long r2, int r4, ih r5) {
        int r3 = r5.f274a;
        if (r3 != 0) goto L5;
        a(true, true, 1);
        return null;
    L5:
        if (r3 != 1) goto L10;
        a(true, false, 1);
        return null;
    L10:
        return null;
    }

    private void a(o7 r9, String r10, ql r11) {
        ug r2 = new ug();
        r2.f559a = 1;
        r2.b = r10;
        r11.a(5011, r2, new jh(), 0, new g(this, r9, r10), 60000);
    }

    public static void a(Context r4, String r5, int r6, String r7) {
        Intent r1 = new Intent(String.format("action.tk.got:%s", new Object[]{r4.getPackageName()}));     // Catch: Throwable -> L5
        r1.setPackage(r4.getPackageName());     // Catch: Throwable -> L5
        r1.putExtra("k.s.p", r5);     // Catch: Throwable -> L5
        r1.putExtra("k.rc", r6);     // Catch: Throwable -> L5
        r1.putExtra("k.tk", r7);     // Catch: Throwable -> L5
        r4.sendBroadcast(r1, rd.f());     // Catch: Throwable -> L5
        return;
    }

    public static void a(Context r4, String r5) {
        cj.b("VidManagerV2", "[shark_vid][shark_ipc]requestMainChannelRegisterTicket()");     // Catch: Throwable -> L6
        Intent r1 = new Intent(String.format("action.get.vid:%s", new Object[]{r4.getPackageName()}));     // Catch: Throwable -> L6
        r1.setPackage(r4.getPackageName());     // Catch: Throwable -> L6
        r1.putExtra("k.s.p", r5);     // Catch: Throwable -> L6
        r4.sendBroadcast(r1, rd.f());     // Catch: Throwable -> L6
        return;
    }
}
