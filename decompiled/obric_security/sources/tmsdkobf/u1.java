package tmsdkobf;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public abstract class u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f542a = null;

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f543a;
        public final /* synthetic */ long b;
        public final /* synthetic */ Object c;

        /* JADX INFO: renamed from: tmsdkobf.u1$a$a, reason: collision with other inner class name */
        public class C0108a extends Thread {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ IBinder f544a;
            public final /* synthetic */ a b;

            public C0108a(a r1, IBinder r2) {
                this.b = r1;
                this.f544a = r2;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                IBinder r1 = this.f544a;
                String r2 = r.a.f461a;
                if (r1 != null) goto L5;
                r r3 = null;
            L40:
            L22:
                int r4 = -1;
            L23:
                this.b.f543a.set(t0.a(-2003, r4));
            L24:
                Object r5 = this.b.c;
                monitor-enter(r5);
                this.b.c.notify();     // Catch: Throwable -> L36
                monitor-exit(r5);     // Catch: Throwable -> L36
                if (o5.f.a("s_t_d_ask", false) == true) goto L47;
                return;
            L47:
                r3.a(2000);     // Catch: RemoteException -> L33
                return;
            L33:
                e = move-exception;
                e.printStackTrace();
                return;
            L36:
                th = move-exception;
                throw th;
            L13:
                if (r3.c(2000) == true) goto L16;
                r3.b(2000);     // Catch: Throwable -> L22
                r4 = 1;
            L43:
                b r6 = u1.a(r3.d(2000).b);     // Catch: Throwable -> L39
                int r7 = r6.f545a;     // Catch: Throwable -> L39
                if (r7 == 0) goto L20;
                this.b.f543a.set(t0.a(r7, r4));     // Catch: Throwable -> L39
            L42:
            L20:
                t1 r8 = r6.b;     // Catch: Throwable -> L39
                int r11 = r3.a();     // Catch: Throwable -> L39
                this.b.f543a.set(new t0(0, 200, System.currentTimeMillis() - this.b.b, r8.c, r11, r4));     // Catch: Throwable -> L39
                goto L42
            L16:
                r4 = 0;
                goto L43
            L5:
                IInterface r9 = r1.queryLocalInterface(r.a.f461a);
                if (r9 != null) goto L8;
            L10:
                r3 = new r.a.C0104a(r1);
                goto L40
            L8:
                if ((r9 instanceof r) == false) goto L10;
                r3 = (r) r9;
                goto L40
            }
        }

        public a(AtomicReference r1, long r2, Object r4) {
            this.f543a = r1;
            this.b = r2;
            this.c = r4;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r1, IBinder r2) {
            new C0108a(this, r2).start();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r3) {
            this.f543a.set(t0.a(-2004, -3));
            Object r4 = this.c;
            monitor-enter(r4);
            this.c.notify();     // Catch: Throwable -> L7
            monitor-exit(r4);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f545a;
        public t1 b;

        public b(int r1, t1 r2) {
            this.f545a = r1;
            this.b = r2;
        }
    }

    static {
        f542a = xk.a(xk.F0);
    }

    public static t0 a() {
        long r1 = System.currentTimeMillis();
        Method r3 = Class.forName(xk.a(xk.G0)).getMethod(xk.a(xk.H0), new Class[0]);     // Catch: ClassNotFoundException -> L86 IllegalAccessException -> L88 NoSuchMethodException -> L90 InvocationTargetException -> L92
        boolean r4 = true;
        r3.setAccessible(true);     // Catch: ClassNotFoundException -> L86 IllegalAccessException -> L88 NoSuchMethodException -> L90 InvocationTargetException -> L92
        r3.invoke(null, new Object[0]);     // Catch: ClassNotFoundException -> L86 IllegalAccessException -> L88 NoSuchMethodException -> L90 InvocationTargetException -> L92
        Provider[] r5 = Security.getProviders();
        if (r5 == null) goto L7;
        int r6 = r5.length;
        int r8 = 0;
    L9:
        if (r8 >= r6) goto L16;
        String r9 = r5[r8].getName();
        if (r9 == null) goto L15;
        if (r9.startsWith(f542a) == false) goto L15;
    L18:
        if (TextUtils.isEmpty(r9) == false) goto L22;
        return t0.a(-1202);
    L22:
        if (r9.split("\\.").length > 1) goto L111;
        r4 = false;
    L111:
        KeyStore r7 = KeyStore.getInstance(r9);     // Catch: NoSuchAlgorithmException -> L78 IOException -> L80 CertificateException -> L82 KeyStoreException -> L84
        r7.load(null);     // Catch: NoSuchAlgorithmException -> L78 IOException -> L80 CertificateException -> L82 KeyStoreException -> L84
        int r10 = Process.myUid();
        if (r7.getCertificate("dddd" + r10) == null) goto L107;
    L38:
        if (r4 == false) goto L109;
        return new t0(0, 100, System.currentTimeMillis() - r1, new t1(r7.getCertificateChain("dddd" + r10)).c, -1, -2);
    L41:
        e = move-exception;
        e.printStackTrace();
    L55:
        return t0.a(-1901);
    L109:
        Key r11 = r7.getKey("dddd" + r10, xk.a(xk.J0).toCharArray());     // Catch: UnrecoverableKeyException -> L56 NoSuchAlgorithmException -> L58 KeyStoreException -> L60
        if (r11 == null) goto L55;
        b r12 = a(r11.getEncoded());
        int r13 = r12.f545a;
        if (r13 != 0) goto L48;
        t1 r14 = r12.b;
        if (o5.f.a("s_t_d_entry", false) == false) goto L53;
        r7.deleteEntry("dddd" + r10);     // Catch: Throwable -> L95
    L53:
        return new t0(0, 100, System.currentTimeMillis() - r1, r14.c, -1, -2);
    L48:
        return t0.a(r13);
    L61:
        return t0.a(-1801);
    L59:
        return t0.a(-1802);
    L57:
        return t0.a(-1803);
    L107:
        KeyPairGenerator r15 = KeyPairGenerator.getInstance("RSA", r9);     // Catch: NoSuchProviderException -> L74 NoSuchAlgorithmException -> L76
    L115:
        String r16 = "dddd" + r10 + xk.a(xk.I0);     // Catch: InstantiationException -> L64 InvocationTargetException -> L66 IllegalAccessException -> L68 NoSuchMethodException -> L70 ClassNotFoundException -> L72
        if (r4 == false) goto L34;
        int r17 = 16;
    L35:
        r15.initialize(d4.a(r16, r17).a(new String[]{"SHA-256"}).b(new String[]{"PSS"}).a());     // Catch: InvalidAlgorithmParameterException -> L62
        r15.generateKeyPair();     // Catch: Throwable -> L94
    L63:
        return t0.a(-1701);
    L34:
        r17 = 4;
    L73:
        return t0.a(-1601);
    L69:
        return t0.a(-1603);
    L65:
        return t0.a(-1605);
    L71:
        return t0.a(-1602);
    L67:
        return t0.a(-1604);
    L77:
        return t0.a(-1501);
    L75:
        return t0.a(-1502);
    L81:
        return t0.a(-1303);
    L85:
        return t0.a(-1301);
    L79:
        return t0.a(-1304);
    L83:
        return t0.a(-1302);
    L15:
        r8 = r8 + 1;
        goto L9
    L16:
        r9 = null;
        goto L18
    L7:
        return t0.a(-1201);
    L87:
        return t0.a(-1104);
    L89:
        return t0.a(-1103);
    L91:
        return t0.a(-1102);
    L93:
        return t0.a(-1101);
    }

    public static t0 a(Context r7) {
        long r0 = System.currentTimeMillis();
        Intent r2 = new Intent();
        r2.setAction(xk.a(xk.K0));
        r2.setPackage(xk.a(xk.L0));
        Object r3 = new Object();
        AtomicReference r4 = new AtomicReference();
        r4.set(t0.a(-2001, -1));
        if (r7.getApplicationContext().bindService(r2, new a(r4, r0, r3), 1) == false) goto L14;
        monitor-enter(r3);
        r3.wait(5000);     // Catch: Throwable -> L8 InterruptedException -> L17
    L8:
        th = move-exception;
        throw th;
    L10:
        monitor-exit(r3);     // Catch: Throwable -> L8
    L16:
        return (t0) r4.get();
    L14:
        r4.set(t0.a(-2002, -1));
        goto L16
    }

    public static b a(byte[] r8) {
        if (r8 != null) goto L7;
        return new b(-3001, null);
    L7:
        if (r8.length < 4) goto L9;
        byte[] r0 = new byte[4];
        System.arraycopy(r8, 0, r0, 0, 4);
        int r4 = 0;
        int r5 = 0;
    L11:
        if (r4 >= 4) goto L14;
        r5 = r5 + ((r0[r4] & 255) << (r4 * 8));
        r4 = r4 + 1;
        goto L11
    L14:
        if (r5 > 1048576) goto L16;
        byte[] r1 = new byte[r5];
        int r6 = r5 + 4;
        if (r8.length < r6) goto L20;
        System.arraycopy(r8, 4, r1, 0, r5);
        t1 r2 = new t1(new String(r1), "");
        int r3 = r8.length - r6;
        if (r3 == 0) goto L26;
        byte[] r7 = new byte[r3];
        System.arraycopy(r8, r6, r7, 0, r3);
        Base64.encodeToString(r7, 2);
        return new b(0, r2);
    L26:
        return new b(-3005, null);
    L20:
        return new b(-3004, null);
    L16:
        return new b(-3003, null);
    L9:
        return new b(-3001, null);
    }
}
