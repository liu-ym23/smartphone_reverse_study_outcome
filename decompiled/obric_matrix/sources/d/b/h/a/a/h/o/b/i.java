package d.b.h.a.a.h.o.b;

import android.os.Build;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.lego.init.IdleTaskConfig;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import p000j.a0;
import p000j.b0;
import p000j.d0;
import p000j.f0;
import p000j.h0;
import p000j.i0;
import p000j.x;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f13498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f13499c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a0 f13500a;

    class a implements x {
        a(i r1) {
        }

        @Override // p000j.x
        public f0 a(x.a r3) {
            d0 r2 = r3.b();
            InetSocketAddress r0 = null;
            p000j.j r1 = r3.e();     // Catch: Throwable -> L21
            if (r1 == null) goto L6;
            h0 r4 = r1.a();     // Catch: Throwable -> L21
        L7:
            if (r4 == null) goto L9;
            r0 = r4.e();     // Catch: Throwable -> L21
        L9:
            Logger.debug();     // Catch: Throwable -> L21
            goto L26
        L6:
            r4 = null;
        L26:
            f0 r5 = r3.d(r2);     // Catch: IOException -> L14
            if (r0 == null) goto L32;
            f0.a r6 = r5.Q();     // Catch: Throwable -> L22
            r6.a("x-net-info.remoteaddr", r0.getAddress().getHostAddress());     // Catch: Throwable -> L22
            return r6.c();
        L33:
            return r5;
        L32:
            return r5;
        L14:
            e = move-exception;
            if (r0 != null) goto L28;
        L20:
            throw e;
        L28:
            String r7 = e.getMessage();     // Catch: Throwable -> L23
            StringBuilder r8 = new StringBuilder();     // Catch: Throwable -> L23
            r8.append(r0.getAddress().getHostAddress());     // Catch: Throwable -> L23
            r8.append("|");     // Catch: Throwable -> L23
            if (r7 != null) goto L19;
            r7 = "null";
        L19:
            r8.append(r7);     // Catch: Throwable -> L23
            Reflect.on(e).set("detailMessage", r8.toString());     // Catch: Throwable -> L23
            goto L20
        }
    }

    public interface b {
        void a(a0.b r1);
    }

    static {
    }

    public i() {
    }

    private static a0 b(a0 r2) {
        int r0 = f13499c;
        if (r0 > 0) goto L5;
        return r2;
    L5:
        if (r0 >= 4) goto L10;
        if (r2 == null) goto L11;
        a0.b r3 = r2.v();
        f(r3);
        return r3.c();
    L11:
        return r2;
    L10:
        return r2;
    }

    public static void c(int r1) {
        if (r1 > 0) goto L4;
        return;
    L4:
        if (f13499c != 0) goto L8;
        f13499c = r1;
        return;
    }

    private static a0.b d(a0.b r4) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 16) goto L5;
    L11:
        return r4;
    L5:
        if (r0 >= 22) goto L11;
        SSLContext r1 = SSLContext.getInstance("TLSv1.2");     // Catch: Exception -> L12
        r1.init(null, null, null);     // Catch: Exception -> L12
        r4.p(new w(r1.getSocketFactory()));     // Catch: Exception -> L9
    L10:
        j.l.a r2 = new j.l.a(p000j.l.f18124i);     // Catch: Exception -> L12
        r2.f(new i0[]{i0.f17776h});     // Catch: Exception -> L12
        p000j.l r3 = r2.a();     // Catch: Exception -> L12
        ArrayList r5 = new ArrayList();     // Catch: Exception -> L12
        r5.add(r3);     // Catch: Exception -> L12
        r5.add(p000j.l.f18125j);     // Catch: Exception -> L12
        r5.add(p000j.l.f18126k);     // Catch: Exception -> L12
        r4.f(r5);     // Catch: Exception -> L12
        goto L11
    L9:
        e(r4, r1);     // Catch: Exception -> L12
        goto L10
    }

    private static a0.b e(a0.b r3, SSLContext r4) {
        TrustManagerFactory r0 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        r0.init(null);
        TrustManager[] r1 = r0.getTrustManagers();
        if (r1.length != 1) goto L9;
        if ((r1[0] instanceof X509TrustManager) == false) goto L9;
        r3.q(new w(r4.getSocketFactory()), (X509TrustManager) r1[0]);
        return r3;
    L9:
        throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(r1));
    }

    private static void f(a0.b r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        ArrayList r0 = new ArrayList();
        int r1 = f13499c;
        if (r1 != 1) goto L7;
        b0 r2 = b0.f17675j;
    L13:
        r0.add(r2);
    L14:
        f13499c = 4;
        r0.add(b0.f17673h);
        r3.k(Collections.unmodifiableList(r0));
        return;
    L7:
        if (r1 != 2) goto L9;
    L11:
        r2 = b0.f17674i;
        goto L13
    L9:
        if (r1 == 3) goto L14;
        r0.add(b0.f17675j);
        goto L11
    }

    public a0 a(boolean r7) {
        if (r7 == false) goto L5;
        d.b.h.a.a.h.g.e0();
    L5:
        monitor-enter(d.b.h.a.a.h.g.class);
        a0 r0 = this.f13500a;     // Catch: Throwable -> L22
        if (r0 == null) goto L11;
        b(r0);     // Catch: Throwable -> L22
        a0 r6 = this.f13500a;     // Catch: Throwable -> L22
        monitor-exit(d.b.h.a.a.h.g.class);     // Catch: Throwable -> L22
        return r6;
    L11:
        a0.b r1 = new a0.b();     // Catch: Throwable -> L22
        int r2 = f13499c;     // Catch: Throwable -> L22
        if (r2 > 0) goto L14;
    L16:
        TimeUnit r5 = TimeUnit.MILLISECONDS;     // Catch: Throwable -> L22
        r1.e(new p000j.k(15, 180000, r5));     // Catch: Throwable -> L22
        r1.d(IdleTaskConfig.IDLE_START_TIME_OUT, r5);     // Catch: Throwable -> L22
        r1.n(IdleTaskConfig.IDLE_START_TIME_OUT, r5);     // Catch: Throwable -> L22
        r1.s(IdleTaskConfig.IDLE_START_TIME_OUT, r5);     // Catch: Throwable -> L22
        r1.b(new a(this));     // Catch: Throwable -> L22
        r1.r(k.c());     // Catch: Throwable -> L22
        r1.g(p000j.o.f18176a);     // Catch: Throwable -> L22
        r1.b(new j());     // Catch: Throwable -> L22
        r1.a(new o());     // Catch: Throwable -> L22
        r1.a(new p());     // Catch: Throwable -> L22
        r1.b(new m());     // Catch: Throwable -> L22
        d(r1);     // Catch: Throwable -> L22
        r1.j(true);     // Catch: Throwable -> L22
        b r3 = f13498b;     // Catch: Throwable -> L22
        if (r3 == null) goto L19;
        r3.a(r1);     // Catch: Throwable -> L22
    L19:
        a0 r4 = r1.c();     // Catch: Throwable -> L22
        this.f13500a = r4;     // Catch: Throwable -> L22
        monitor-exit(d.b.h.a.a.h.g.class);     // Catch: Throwable -> L22
        return r4;
    L14:
        if (r2 >= 4) goto L16;
        f(r1);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }
}
