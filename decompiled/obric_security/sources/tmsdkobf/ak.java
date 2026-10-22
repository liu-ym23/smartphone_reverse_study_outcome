package tmsdkobf;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import java.util.Random;

/* JADX INFO: loaded from: classes5.dex */
public class ak {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private qg f103a;
    private final Object b;
    private nd c;
    private Pair d;

    public ak(Context r1, qg r2) {
        this.b = new Object();
        this.f103a = r2;
        this.c = new nd();
        b();
    }

    private void b() {
        nd r0 = this.f103a.c().d(this.f103a.f444a.l());
        if (r0 == null) goto L12;
        Object r1 = this.b;
        monitor-enter(r1);
        nd r2 = this.c;     // Catch: Throwable -> L9
        r2.f372a = r0.f372a;     // Catch: Throwable -> L9
        nd r3 = this.c;     // Catch: Throwable -> L9
        r3.b = r0.b;     // Catch: Throwable -> L9
        nd r4 = this.c;     // Catch: Throwable -> L9
        r4.c = r0.c;     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public nd a() {
        Object r0 = this.b;
        monitor-enter(r0);
        nd r1 = nd.a(this.c);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public Pair a(qg.n r10) {
        Object r3 = this.b;
        monitor-enter(r3);
    L44:
        th = move-exception;
        throw th;
    L5:
        if (this.d == null) goto L16;
        nd r0 = r10.j;     // Catch: Throwable -> L44
        if (r0 != null) goto L9;
    L13:
        Pair r9 = this.d;     // Catch: Throwable -> L44
        monitor-exit(r3);     // Catch: Throwable -> L44
        return r9;
    L9:
        if (r0.b == null) goto L11;
    L12:
        r10.j.b = (String) this.d.first;     // Catch: Throwable -> L44
        goto L13
    L11:
        cj.b("KeyManager", "[shark_debug]getSecretPair(), sharkSend.secretKey.randomKey == null! sharkSeq: " + r10.f451a);     // Catch: Throwable -> L44
        goto L12
    L16:
        ud.b r2 = this.f103a.f444a.f460a;     // Catch: Throwable -> L44
        int r4 = r2.k;     // Catch: Throwable -> L44
        td r5 = r2.e.n();     // Catch: Throwable -> L44
        int r6 = r5.a();     // Catch: Throwable -> L44
        String r7 = r5.a(r4);     // Catch: Throwable -> L44
        String r8 = r5.b(r4);     // Catch: Throwable -> L44
        if (r6 != 2) goto L19;
        int r11 = 32;
    L20:
        String r12 = a(r11);     // Catch: Throwable -> L44
        ci r13 = new ci();     // Catch: Throwable -> L44
        r13.f134a = 1;     // Catch: Throwable -> L44
        r13.d = r6;     // Catch: Throwable -> L44
        r13.c = r8;     // Catch: Throwable -> L44
        ud.b r14 = this.f103a.f444a.f460a;     // Catch: Throwable -> L44
        r13.e = r14.h ? 1 : 0;     // Catch: Throwable -> L44
        r13.f = r14.g;     // Catch: Throwable -> L44
        r13.b = jk.a(uj.c(r12), a(r6, r7), this.f103a.f444a.i());     // Catch: Throwable -> L47
    L22:
        byte[] r15 = r13.b;     // Catch: Throwable -> L44
        if (r15 == null) goto L43;
        if (r15.length == 0) goto L43;
        byte[] r1 = z7.a(r13);     // Catch: Throwable -> L44
        if (r1 == null) goto L41;
        if (r1.length == 0) goto L41;
        Object r16 = this.b;     // Catch: Throwable -> L44
        monitor-enter(r16);     // Catch: Throwable -> L44
        this.c.f372a = this.f103a.f444a.l();     // Catch: Throwable -> L37
        this.c.b = r12;     // Catch: Throwable -> L37
        this.c.c = null;     // Catch: Throwable -> L37
        monitor-exit(r16);     // Catch: Throwable -> L37
        r10.j = a();     // Catch: Throwable -> L44
        Pair r17 = new Pair(r12, r1);     // Catch: Throwable -> L44
        this.d = r17;     // Catch: Throwable -> L44
        monitor-exit(r3);     // Catch: Throwable -> L44
        return r17;
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L44
    L41:
        throw new ni("getSecret(), jce bytes of CSSecret is empty: " + r1);     // Catch: Throwable -> L44
    L43:
        throw new ni("asymmetricEncrypt(), encrypted result is empty: " + r13.b);     // Catch: Throwable -> L44
    L19:
        r11 = 16;
        goto L20
    }

    public nd a(byte[] r3, nd r4) {
        ii r5 = (ii) z7.b(r3, new ii(), false);
        if (r5 != null) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r5.f275a) == false) goto L8;
        return null;
    L8:
        if (r4 != null) goto L10;
    L12:
        Object r6 = this.b;
        monitor-enter(r6);
        Pair r1 = this.d;     // Catch: Throwable -> L26
        if (r1 == null) goto L24;
        Object r2 = r1.first;     // Catch: Throwable -> L26
        if (r2 == null) goto L24;
        String r0 = (String) r2;     // Catch: Throwable -> L26
        monitor-exit(r6);     // Catch: Throwable -> L26
        String r7 = r0;
    L22:
        nd r8 = new nd();
        r8.f372a = this.f103a.f444a.l();
        r8.b = r7;
        r8.c = r5.f275a;
        a(r8);
        return r8;
    L24:
        monitor-exit(r6);     // Catch: Throwable -> L26
        return null;
    L26:
        th = move-exception;
        throw th;
    L10:
        if (r4.b == null) goto L12;
        r7 = r4.b;
        goto L22
    }

    public void a(nd r4, int r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r4.b) == true) goto L32;
        Object r6 = this.b;
        monitor-enter(r6);
        String r0 = this.c.b;     // Catch: Throwable -> L25
        if (TextUtils.isEmpty(r0) == false) goto L11;
    L13:
        boolean r1 = false;
    L14:
        Pair r2 = this.d;     // Catch: Throwable -> L25
        if (r2 == null) goto L21;
        Object r3 = r2.first;     // Catch: Throwable -> L25
        if (r3 == null) goto L21;
        if (((String) r3).equals(r4.b) == false) goto L21;
        this.d = null;     // Catch: Throwable -> L25
    L21:
        monitor-exit(r6);     // Catch: Throwable -> L25
        if (r1 == false) goto L31;
        this.f103a.c().c(this.f103a.f444a.l());
        return;
    L31:
        return;
    L11:
        if (r0.equals(r4.b) == false) goto L13;
        this.c.b = null;     // Catch: Throwable -> L25
        this.c.c = null;     // Catch: Throwable -> L25
        r1 = true;
    L25:
        th = move-exception;
        throw th;
    }

    private void a(nd r4) {
        Object r0 = this.b;
        monitor-enter(r0);
        nd r1 = this.c;     // Catch: Throwable -> L8
        r1.f372a = r4.f372a;     // Catch: Throwable -> L8
        nd r2 = this.c;     // Catch: Throwable -> L8
        r2.b = r4.b;     // Catch: Throwable -> L8
        nd r3 = this.c;     // Catch: Throwable -> L8
        r3.c = r4.c;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.f103a.c().a(r4);
        a(rd.e(), this.f103a.f444a.f460a.c, 0, r4);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static byte[] a(int r2, String r3) {
        if (r2 != 0) goto L7;
        return ai.a(jk.b(r3), 0);
    L7:
        if (r2 != 2) goto L11;
        return ai.a(jk.a(r3), 0);
    L11:
        if (r2 != 1) goto L19;
        if (r3 == null) goto L17;
        if (r3.length() == 128) goto L19;
    L17:
        throw new ni("SM2 public key must be 128 chars! actually: " + r3);
    L19:
        return uj.b(r3);
    }

    private String a(int r5) {
        StringBuffer r4 = new StringBuffer();
        Random r0 = new Random();
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L6;
        r4.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(r0.nextInt(62)));
        r1 = r1 + 1;
        goto L3
    L6:
        return r4.toString();
    }

    private static void a(Context r4, String r5, int r6, nd r7) {
        Intent r1 = new Intent(String.format("action.sk.got:%s", new Object[]{r4.getPackageName()}));     // Catch: Throwable -> L14
        r1.setPackage(r4.getPackageName());     // Catch: Throwable -> L14
        r1.putExtra("k.s.p", r5);     // Catch: Throwable -> L14
        r1.putExtra("k.rc", r6);     // Catch: Throwable -> L14
        if (r6 != 0) goto L12;
        if (r7 == null) goto L12;
        r1.putExtra("k.sc.a", r7.f372a);     // Catch: Throwable -> L14
        r1.putExtra("k.sc.k", r7.b);     // Catch: Throwable -> L14
        r1.putExtra("k.sc.s", r7.c);     // Catch: Throwable -> L14
    L12:
        r4.sendBroadcast(r1, rd.f());     // Catch: Throwable -> L14
        return;
    }
}
