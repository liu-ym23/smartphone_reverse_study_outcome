package tmsdkobf;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes5.dex */
public class o5 {
    public static final String d = null;
    public static final long e = 0;
    public static final o5 f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile fi f386a;
    public final AtomicBoolean b;
    public final ReentrantReadWriteLock c;

    static {
        d = xk.a(xk.Z0);
        e = TimeUnit.HOURS.toMillis(32);
        f = new o5();
    }

    public o5() {
        this.f386a = null;
        this.b = new AtomicBoolean(false);
        this.c = new ReentrantReadWriteLock();
    }

    public void a(fi r4, boolean r5) {
        this.c.writeLock().lock();
        if (r5 == true) goto L15;
    L13:
        this.f386a = r4;
        this.c.writeLock().unlock();
        return;
    L15:
        i2 r6 = new i2(128);     // Catch: Throwable -> L10
        r4.a(r6);     // Catch: Throwable -> L10
        byte[] r0 = new byte[r6.f259a.position()];     // Catch: Throwable -> L10
        System.arraycopy(r6.f259a.array(), 0, r0, 0, r6.f259a.position());     // Catch: Throwable -> L10
        if (xj.a(b("2"), zj.b(kl.a(r0), zj.a()), true) == false) goto L13;
        File r7 = new File(b("1"));     // Catch: Throwable -> L10
        if (r7.exists() == false) goto L13;
        r7.delete();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.f386a = r4;
        this.c.writeLock().unlock();
        throw th;
    }

    public final String b(String r4) {
        monitor-enter(mh.class);
        Context r0 = mh.f353a;     // Catch: Throwable -> L18
        monitor-exit(mh.class);
        File r3 = r0.getDir("turingfd", 0);
        if (r3 != null) goto L10;
        return "";
    L10:
        StringBuilder r5 = new StringBuilder().append(r3.getAbsolutePath());
        String r1 = File.separator;
        File r2 = new File(r5.append(r1).append("12").toString());
        if (r2.exists() == true) goto L17;
        if (r2.mkdirs() == true) goto L17;
        return "";
    L17:
        return r2.getAbsolutePath() + r1 + n0.f360a + "_vd_" + r4;
    L18:
        th = move-exception;
        throw th;
    }

    public Set c() {
        if (d() == true) goto L5;
        String r2 = xk.a(xk.e1);
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return null;
    L10:
        HashSet r0 = new HashSet();
        Collections.addAll(r0, r2.split(","));
        return r0;
    L5:
        r2 = a("p_l_h_l");
        goto L7
    }

    public final boolean d() {
        if (b() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final fi b(String r2, boolean r3) {
        byte[] r1 = xj.a(r2, true);     // Catch: Throwable -> L14
        if (r1 != null) goto L6;
        return null;
    L6:
        if (r3 == false) goto L12;
        r1 = kl.b(zj.a(r1, zj.a()));     // Catch: Throwable -> L14
        if (r1 != null) goto L10;
    L11:
        return null;
    L10:
        if (r1.length == 0) goto L11;
    L12:
        fi r4 = new fi();     // Catch: Throwable -> L14
        r4.a(new y1(r1));     // Catch: Throwable -> L14
        return r4;
    L14:
        return null;
    }

    public fi b() {
        this.c.readLock().lock();
    L27:
        th = move-exception;
        this.c.readLock().unlock();
        throw th;
    L4:
        if (this.b.get() == false) goto L8;
        fi r0 = this.f386a;     // Catch: Throwable -> L27
        this.c.readLock().unlock();
        return r0;
    L8:
        AtomicBoolean r1 = this.b;     // Catch: Throwable -> L27
        monitor-enter(r1);     // Catch: Throwable -> L27
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L11:
        if (this.b.get() == false) goto L16;
        fi r2 = this.f386a;     // Catch: Throwable -> L24
        monitor-exit(r1);     // Catch: Throwable -> L24
        this.c.readLock().unlock();
        return r2;
    L16:
        fi r3 = b(b("2"), true);     // Catch: Throwable -> L24
        if (r3 != null) goto L20;
        r3 = b(b("1"), false);     // Catch: Throwable -> L24
    L20:
        this.f386a = r3;     // Catch: Throwable -> L24
        this.b.set(true);     // Catch: Throwable -> L24
        fi r4 = this.f386a;     // Catch: Throwable -> L24
        monitor-exit(r1);     // Catch: Throwable -> L24
        this.c.readLock().unlock();
        return r4;
    }

    public final String a(String r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        fi r1 = b();
        if (r1 == null) goto L12;
        Map r3 = r1.g;
        if (r3 == null) goto L12;
        return (String) r3.get(r2);
    L12:
        return null;
    }

    public final boolean a(String r1, boolean r2) {
        String r0 = a(r1);
        if (r0 != null) goto L11;
        return r2;
    L11:
        if (Integer.parseInt(r0) <= 0) goto L8;
        return true;
    L8:
        return false;
    L10:
        return r2;
    }

    public String a() {
        if (d() == true) goto L5;
        String r0 = xk.a(xk.d1);
    L6:
        String r8 = a("a_f_ok_s");
        HashSet r1 = new HashSet();
        int r3 = 0;
        if (TextUtils.isEmpty(r0) == true) goto L15;
        String[] r2 = r0.split(",");
        int r4 = r2.length;
        int r5 = 0;
    L9:
        if (r5 >= r4) goto L15;
        String r6 = r2[r5];
        if (TextUtils.isEmpty(r6) == true) goto L13;
        r1.add(r6);
    L13:
        r5 = r5 + 1;
    L15:
        if (TextUtils.isEmpty(r8) == true) goto L26;
        ((t5) t5.f526a.b()).a();
        if (jd.a() == false) goto L26;
        String[] r9 = r8.split(",");
        int r7 = r9.length;
    L19:
        if (r3 >= r7) goto L26;
        String r10 = r9[r3];
        if (TextUtils.isEmpty(r10) == true) goto L24;
        r1.add(r10);
    L24:
        r3 = r3 + 1;
    L26:
        if (r1.isEmpty() == false) goto L29;
        return null;
    L29:
        StringBuilder r11 = new StringBuilder();
        Iterator r12 = r1.iterator();
    L31:
        if (r12.hasNext() == false) goto L37;
        String r13 = (String) r12.next();
        if (r11.length() <= 0) goto L35;
        r11.append(",");
    L35:
        r11.append(r13);
        goto L31
    L37:
        return r11.toString();
    L5:
        r0 = a("a_f_ok_c");
        goto L6
    }
}
