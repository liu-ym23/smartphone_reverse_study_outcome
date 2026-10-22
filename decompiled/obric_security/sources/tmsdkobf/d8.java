package tmsdkobf;

import android.content.Context;
import android.os.Build;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.tmsecure.vd.TNative$aa;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public abstract class d8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f148a = 0;
    public static final AtomicBoolean b = null;
    public static final AtomicBoolean c = null;
    public static final ka d = null;
    public static final ka e = null;

    static {
        f148a = System.currentTimeMillis();
        b = new AtomicBoolean(false);
        c = new AtomicBoolean(false);
        d = new ka(false);
        e = new ka(true);
    }

    public static void a(k3 r7) {
        b5 r0 = b5.l;
        r0.f111a = r7;
        if (r0.c == true) goto L36;
        r0.c = true;
        mh.a(r7.b());
        HandlerThread r2 = new HandlerThread("TuringFdCore_90_" + n0.f360a + "_vd", -8);
        r2.start();
        r0.b = new b5.a(r0, r2.getLooper(), r7.b());
        d5 r1 = new d5(r0.b);
        r0.d = r1;
        q5 r3 = q5.f;
        r3.d = r7;
        r3.e = r1;
        Set r8 = r7.A;
        if (r8 == null) goto L15;
        Set r4 = r3.f433a;
        monitor-enter(r4);
        r3.f433a.addAll(r8);     // Catch: Throwable -> L12
        monitor-exit(r4);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L15:
        String r9 = Build.BRAND;
        if ("xiaomi".equalsIgnoreCase(r9) == false) goto L18;
    L19:
        Set r10 = r3.f433a;
        monitor-enter(r10);
        r3.f433a.add(148);     // Catch: Throwable -> L38
        monitor-exit(r10);     // Catch: Throwable -> L38
    L23:
        int[] r11 = nh.f374a;
        if (r11.length <= 0) goto L35;
        Set r5 = r3.f433a;
        monitor-enter(r5);
        int r6 = r11.length;     // Catch: Throwable -> L32
        int r12 = 0;
    L28:
        if (r12 >= r6) goto L30;
        r3.f433a.add(Integer.valueOf(r11[r12]));     // Catch: Throwable -> L32
        r12 = r12 + 1;     // Catch: Throwable -> L32
        goto L28
    L30:
        monitor-exit(r5);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    L35:
        r3.b();
        new c4(r0).start();
    L38:
        th = move-exception;
        throw th;
    L18:
        if ("redmi".equalsIgnoreCase(r9) == false) goto L23;
    L36:
        i0.a();
    }

    public static int b(k3 r5) {
        AtomicBoolean r1 = b;
        if (r1.get() == false) goto L5;
        return 0;
    L5:
        boolean r4 = true;
        if (r5.g == false) goto L18;
        TextUtils.isEmpty(r5.j);
        String r6 = r5.j;
    L13:
        th = move-exception;
        Log.w("TuringFdJava", th);
        r4 = false;
    L15:
        b.set(r4);
        if (r4 == true) goto L20;
        Log.e("TuringFdJava", "load so failure");
    L20:
        if (b.get() == true) goto L27;
        return -10001;
    L27:
        return 0;
    L9:
        if (TextUtils.isEmpty(r6) == false) goto L11;
        System.loadLibrary("turingvd");     // Catch: Throwable -> L13
    L24:
        goto L15
    L11:
        System.load(r6);     // Catch: Throwable -> L13
        goto L24
    L18:
        r1.set(true);
        goto L20
    }

    public static int c(k3 r11) {
        Context r2 = r11.b();
        HashMap r3 = new HashMap();
        o5 r1 = o5.f;
        boolean r4 = jd.a();
        String r5 = "1";
        if (r4 == true) goto L5;
    L7:
        Object r8 = "0";
    L8:
        r3.put("2008", r8);
        if (r4 == true) goto L11;
    L13:
        Object r9 = "0";
    L14:
        r3.put("2009", r9);
        if (r4 == true) goto L17;
    L19:
        Object r10 = "0";
    L20:
        r3.put("2010", r10);
        if (r4 == true) goto L23;
    L25:
        Object r6 = "0";
    L26:
        r3.put("2011", r6);
        r3.put("2025", "0");
        if (r11.C == true) goto L30;
        r5 = "0";
    L30:
        r3.put("2028", r5);
        int r7 = ca.b(TNative$aa.i90_A43184BF099FF466(new SparseArray(), r2, r3, d, e, (t5) t5.f526a.b()));
        if (r7 == 0) goto L36;
        Log.e("TuringFdJava", "native init fail, err: " + r7);
        return -10020;
    L36:
        return 0;
    L37:
        th = move-exception;
        Log.e("TuringFdJava", "native init exception", th);
        return -10020;
    L23:
        if (r1.a("e_r_nd", true) == false) goto L25;
        r6 = "1";
        goto L26
    L17:
        if (r1.a("e_w_nd", true) == false) goto L19;
        r10 = "1";
        goto L20
    L11:
        if (r1.a("e_r_d", true) == false) goto L13;
        r9 = "1";
        goto L14
    L5:
        if (r1.a("e_w_d", false) == false) goto L7;
        r8 = "1";
        goto L8
    }

    public static int a() {
        if (c.get() == true) goto L7;
        return -10002;
    L7:
        if (n0.f360a != 0) goto L11;
        return -10018;
    L11:
        if (b.get() == true) goto L15;
        return -10001;
    L15:
        monitor-enter(k3.class);
        k3 r1 = k3.D;     // Catch: Throwable -> L24
        monitor-exit(k3.class);
        if (r1.c().a() == true) goto L22;
        return -10019;
    L22:
        return 0;
    L24:
        th = move-exception;
        throw th;
    }
}
