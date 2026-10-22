package tmsdkobf;

import android.content.Context;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class zh implements rl.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private lj f666a;
    private rl b;
    private c c;
    private tj d;
    private z6 e;
    private qg f;

    class a implements jj.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ qg.n f667a;
        final /* synthetic */ zh b;

        a(zh r1, qg.n r2) {
            this.b = r1;
            this.f667a = r2;
        }

        @Override // tmsdkobf.jj.a
        public void a(int r5, byte[] r6) {
            if (r5 == 0) goto L5;
        L7:
            zh.b(this.b).a(this.f667a, 52, r5, 0);
            zh.c(this.b).a(false, r5, r6, this.f667a);
            return;
        L5:
            if (zh.a(this.b) == null) goto L7;
            zh.a(this.b).n();
            goto L7
        }
    }

    class b implements jj.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ qg.n f668a;
        final /* synthetic */ zh b;

        b(zh r1, qg.n r2) {
            this.b = r1;
            this.f668a = r2;
        }

        @Override // tmsdkobf.jj.a
        public void a(int r5, byte[] r6) {
            zh.b(this.b).a(this.f668a, 52, r5, 0);
            zh.c(this.b).a(false, r5, r6, this.f668a);
        }
    }

    public interface c {
        void a(boolean r1, int r2, qg.n r3);

        void a(boolean r1, int r2, byte[] r3, qg.n r4);
    }

    public zh(Context r7, z6 r8, int r9, c r10, qg r11) {
        this.c = r10;
        this.e = r8;
        this.f = r11;
        this.d = new tj(r7, r9, r8, r11);
        this.f666a = new lj(r7, r8, this.d, this.f);
        if (this.f.f444a.w() == false) goto L6;
        this.b = new rl(r8, this.d, r10, this, this.f);
        return;
    }

    static /* synthetic */ rl a(zh r0) {
        return r0.b;
    }

    static /* synthetic */ qg b(zh r0) {
        return r0.f;
    }

    static /* synthetic */ c c(zh r0) {
        return r0.c;
    }

    public rl a() {
        if (this.f.f444a.w() == false) goto L7;
        return this.b;
    L7:
        throw new RuntimeException("getTcpNetworkManager(), without TcpChannel!");
    }

    public synchronized void a(qg.n r6) {
        monitor-enter(this);
        if (r6 != null) goto L73;
        monitor-exit(this);
        return;
    L73:
        Iterator r0 = r6.k.iterator();     // Catch: Throwable -> L71
    L8:
        if (r0.hasNext() == false) goto L72;
        pi r1 = (pi) r0.next();     // Catch: Throwable -> L71
        if (r1 == null) goto L8;
        cj.a("TMSDK_SK_HB", "sendData, cmdID:" + r1.f422a);     // Catch: Throwable -> L71
    L72:
    L68:
        th = move-exception;
        throw th;
    L16:
        if (this.f.f444a.r() == false) goto L48;
        if (r6.b() == true) goto L48;
        if (r6.b == 1024) goto L48;
        rl r2 = this.b;     // Catch: Throwable -> L68
        if (r2 != null) goto L25;
    L27:
        boolean r3 = false;
    L29:
        if (this.f.f444a.s() == true) goto L31;
    L41:
        r6.h = false;     // Catch: Throwable -> L68
        qg r4 = this.f;     // Catch: Throwable -> L68
        byte[] r5 = r4.a(r6, false, r4.b(), this.e);     // Catch: Throwable -> L68
        if (r5 != null) goto L46;
        this.c.a(false, -30000021, r6);     // Catch: Throwable -> L68
        monitor-exit(this);
        return;
    L46:
        this.f.a(r6, 50, 0, r5.length);     // Catch: Throwable -> L68
        this.f666a.b(r6, r5, new a(this, r6));     // Catch: Throwable -> L68
    L63:
        monitor-exit(this);
        return;
    L31:
        if (this.f.f444a.w() == false) goto L41;
        int r7 = r6.b;     // Catch: Throwable -> L68
        if (r7 == 2560) goto L41;
        if (r7 == 2048) goto L41;
        if (r7 == 512) goto L41;
        if (r6.q == true) goto L41;
        if (r3 == true) goto L41;
    L52:
        r6.h = true;     // Catch: Throwable -> L68
        if (r6.f == false) goto L58;
        this.b.a(r6);     // Catch: Throwable -> L68
        monitor-exit(this);
        return;
    L58:
        if (r6.a() == false) goto L62;
        this.b.a(r6);     // Catch: Throwable -> L68
        monitor-exit(this);
        return;
    L62:
        this.b.b(r6);     // Catch: Throwable -> L68
        goto L63
    L25:
        if (r2.m() == true) goto L27;
        r3 = true;
    L48:
        if (this.f.f444a.s() == true) goto L50;
    L65:
        this.c.a(true, -30001400, r6);     // Catch: Throwable -> L68
        monitor-exit(this);
        return;
    L50:
        if (this.f.f444a.w() == true) goto L52;
        goto L52
    }

    @Override // tmsdkobf.rl.h
    public void a(qg.n r5, int r6) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.f.f444a.r() == true) goto L9;
        this.c.a(true, r6, r5);
        return;
    L9:
        if (r5.b != 1024) goto L13;
        this.c.a(true, r6, r5);
        return;
    L13:
        if (r5.b() == false) goto L16;
        this.c.a(true, r6, r5);
        return;
    L16:
        r5.h = false;
        qg r0 = this.f;
        byte[] r1 = r0.a(r5, false, r0.b(), this.e);
        if (r1 != null) goto L20;
        this.c.a(false, -42000021, r5);
        return;
    L20:
        this.f.a(r5, 50, 0, r1.length);
        this.f666a.b(r5, r1, new b(this, r5));
    }
}
