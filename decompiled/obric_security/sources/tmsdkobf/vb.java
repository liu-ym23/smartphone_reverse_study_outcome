package tmsdkobf;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedance.librarian.LibrarianImpl;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tmsdk.common.TMSDKContext;
import tmsdk.common.roach.nest.tt;
import tmsdk.common.tcc.TccCryptor;
import tmsdk.common.tcc.TccDiff;

/* JADX INFO: loaded from: classes5.dex */
public class vb {
    static final int[] f = null;
    static vb g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    HashMap f578a;
    HashMap b;
    HandlerThread c;
    Handler d;
    private t3 e;

    class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ vb f579a;

        a(vb r1, Looper r2) {
            this.f579a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r11) {
            int r1 = r11.what;     // Catch: Throwable -> L95
            if (r1 != 259) goto L38;
            vb r2 = this.f579a;     // Catch: Throwable -> L95
            if (vb.m2465$$Nest$fgete(r2) != null) goto L8;
            vb.m2466$$Nest$fpute(r2, t3.g());     // Catch: Throwable -> L95
        L8:
            s3 r12 = (s3) r11.obj;     // Catch: Throwable -> L95
            if (r12 == null) goto L36;
            jb r3 = r12.f498a;     // Catch: Throwable -> L95
            if (r3 == null) goto L124;
            s3 r4 = vb.m2465$$Nest$fgete(this.f579a).b(r3.f286a);     // Catch: Throwable -> L95
            if (r4 == null) goto L29;
            int r7 = r12.f498a.b;     // Catch: Throwable -> L95
            int r8 = r4.f498a.b;     // Catch: Throwable -> L95
            if (r7 < r8) goto L35;
            int r9 = r12.b;     // Catch: Throwable -> L95
            if (r9 == 1) goto L20;
            if (r9 != 2) goto L35;
            vb.m2468$$Nest$ma(this.f579a, r4, true);     // Catch: Throwable -> L95
            goto L35
        L20:
            if (r4.c != 3) goto L25;
            if (r7 != r8) goto L23;
            vb.m2467$$Nest$ma(this.f579a, r4, 1);     // Catch: Throwable -> L95
            goto L35
        L23:
            vb.m2468$$Nest$ma(this.f579a, r4, true);     // Catch: Throwable -> L95
        L32:
            vb.m2465$$Nest$fgete(this.f579a).a(r12);     // Catch: Throwable -> L95
            goto L35
        L25:
            if (r7 <= r8) goto L35;
            vb.m2465$$Nest$fgete(this.f579a).c(r12);     // Catch: Throwable -> L95
        L35:
            this.f579a.d.removeMessages(260);     // Catch: Throwable -> L95
            this.f579a.d.sendEmptyMessage(260);     // Catch: Throwable -> L95
            this.f579a.d.removeMessages(258);     // Catch: Throwable -> L95
            this.f579a.d.sendEmptyMessage(258);     // Catch: Throwable -> L95
            this.f579a.d.removeMessages(262);     // Catch: Throwable -> L95
            this.f579a.d.sendEmptyMessage(262);     // Catch: Throwable -> L95
            return;
        L29:
            int r5 = r12.b;     // Catch: Throwable -> L95
            if (r5 == 1) goto L32;
            if (r5 != 2) goto L35;
            vb.m2468$$Nest$ma(this.f579a, r12, true);     // Catch: Throwable -> L95
            goto L35
        L124:
            return;
        L36:
            return;
        L38:
            if (r1 != 257) goto L59;
            List r13 = vb.m2465$$Nest$fgete(this.f579a).d();     // Catch: Throwable -> L95
            if (r13 != null) goto L42;
            return;
        L42:
            if (r13.size() <= 0) goto L127;
            Iterator r14 = r13.iterator();     // Catch: Throwable -> L95
        L45:
            if (r14.hasNext() == false) goto L135;
            s3 r6 = (s3) r14.next();     // Catch: Throwable -> L95
            if (r6.c != 3) goto L45;
            if (r6.b != 1) goto L45;
            jb r10 = r6.f498a;     // Catch: Throwable -> L95
            if (r10 == null) goto L45;
            if (r10.e < System.currentTimeMillis()) goto L45;
            if (new File(r6.c() + File.separator + r6.b()).exists() == false) goto L45;
            vb.m2467$$Nest$ma(this.f579a, r6, 1);     // Catch: Throwable -> L95
            goto L45
        L135:
            return;
        L127:
            return;
        L59:
            if (r1 != 258) goto L67;
            List r15 = vb.m2465$$Nest$fgete(this.f579a).h();     // Catch: Throwable -> L95
            if (r15 == null) goto L66;
            Iterator r16 = r15.iterator();     // Catch: Throwable -> L95
        L64:
            if (r16.hasNext() == false) goto L66;
            vb.m2469$$Nest$mb(this.f579a, (s3) r16.next());     // Catch: Throwable -> L95
        L66:
            d.b(true);     // Catch: Throwable -> L95
            return;
        L67:
            if (r1 != 260) goto L81;
            List r17 = vb.m2465$$Nest$fgete(this.f579a).e();     // Catch: Throwable -> L95
            if (r17 == null) goto L74;
            Iterator r18 = r17.iterator();     // Catch: Throwable -> L95
        L72:
            if (r18.hasNext() == false) goto L74;
            vb.m2468$$Nest$ma(this.f579a, (s3) r18.next(), true);     // Catch: Throwable -> L95
        L74:
            List r19 = vb.m2465$$Nest$fgete(this.f579a).c();     // Catch: Throwable -> L95
            if (r19 == null) goto L129;
            Iterator r110 = r19.iterator();     // Catch: Throwable -> L95
        L78:
            if (r110.hasNext() == false) goto L136;
            vb.m2468$$Nest$ma(this.f579a, (s3) r110.next(), false);     // Catch: Throwable -> L95
            goto L78
        L136:
            return;
        L129:
            return;
        L81:
            if (r1 != 261) goto L92;
            tt r111 = (tt) r11.obj;     // Catch: Throwable -> L95
            if (r111 != null) goto L100;
            return;
        L100:
            Iterator r0 = this.f579a.b.keySet().iterator();     // Catch: Throwable -> L99
        L87:
            if (r0.hasNext() == false) goto L137;
            jb r20 = (jb) r0.next();     // Catch: Throwable -> L99
            if (((tt) this.f579a.b.get(r20)) != r111) goto L87;
            this.f579a.b.remove(r20);     // Catch: Throwable -> L99
            return;
        L137:
            return;
        L134:
            return;
        L92:
            if (r1 != 262) goto L130;
            vb.m2470$$Nest$mc(this.f579a);     // Catch: Throwable -> L95
            return;
        L130:
            return;
        L95:
            Handler r112 = this.f579a.d;
            if (r112 == null) goto L131;
            r112.removeMessages(262);
            this.f579a.d.sendEmptyMessage(262);
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgete, reason: not valid java name */
    static /* bridge */ /* synthetic */ t3 m2465$$Nest$fgete(vb r0) {
        return r0.e;
    }

    /* JADX INFO: renamed from: -$$Nest$fpute, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2466$$Nest$fpute(vb r0, t3 r1) {
        r0.e = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$ma, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2467$$Nest$ma(vb r0, s3 r1, int r2) {
        r0.a(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$ma, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2468$$Nest$ma(vb r0, s3 r1, boolean r2) {
        r0.a(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mb, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2469$$Nest$mb(vb r0, s3 r1) {
        r0.b(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mc, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2470$$Nest$mc(vb r0) {
        r0.c();
    }

    static {
        f = new int[]{201};
    }

    private vb() {
        this.f578a = new HashMap();
        this.b = new HashMap();
        this.c = null;
        this.d = null;
        this.e = null;
    }

    private boolean a(s3 r7) {
        if (r7 != null) goto L5;
        return false;
    L5:
        if (r7.f498a == null) goto L22;
        String r0 = r7.c() + File.separator + r7.b();
        File r1 = new File(r0);
        if (r1.exists() == true) goto L12;
        f.a(1320038, "0;1005;" + r7.b());
        return false;
    L12:
        if (r1.length() == r7.f498a.f) goto L16;
        f.a(1320038, "0;1006;" + r7.b());
        return false;
    L16:
        if (TccDiff.fileMd5(r0).compareToIgnoreCase(r7.f498a.g) == 0) goto L19;
        f.a(1320038, "0;1007;" + r7.b());
        return false;
    L19:
        f.a(1320038, "1;;" + r7.b());
        return true;
    L22:
        return false;
    }

    private void b(s3 r7) {
    L31:
        f.a(1320036, "0;1004;" + r7.b());
        a(r7, false);
        return;
    L4:
        if (this.e.b(r7.f498a.f286a) != null) goto L8;
        a(r7, false);     // Catch: Throwable -> L31
        return;
    L8:
        if (r7.f498a.f > 204800) goto L10;
    L12:
        File r3 = new File(r7.c());     // Catch: Throwable -> L31
        if (r3.exists() == true) goto L15;
        r3.mkdir();     // Catch: Throwable -> L31
    L15:
        r7.c = 2;     // Catch: Throwable -> L31
        this.e.c(r7);     // Catch: Throwable -> L31
        b6 r4 = new b6(TMSDKContext.getApplicaionContext());     // Catch: Throwable -> L31
        r4.b(r7.c());     // Catch: Throwable -> L31
        r4.a(r7.b());     // Catch: Throwable -> L31
    L16:
        int r5 = r4.a(null, r7.f498a.h, false, null);     // Catch: Throwable -> L31
        if (r5 == (-7)) goto L16;
        if (this.e.b(r7.f498a.f286a) != null) goto L23;
        a(r7, false);     // Catch: Throwable -> L31
        return;
    L23:
        if (r5 != 0) goto L29;
        f.a(1320036, "1;;" + r7.b());     // Catch: Throwable -> L31
        if (a(r7) == true) goto L28;
        a(r7, false);     // Catch: Throwable -> L31
        return;
    L28:
        r7.c = 3;     // Catch: Throwable -> L31
        this.e.c(r7);     // Catch: Throwable -> L31
        a(r7, 1);     // Catch: Throwable -> L31
        return;
    L29:
        f.a(1320036, "0;1004;" + r7.b());     // Catch: Throwable -> L31
        a(r7, false);     // Catch: Throwable -> L31
        return;
    L10:
        if (k9.b(TMSDKContext.getApplicaionContext()) == true) goto L12;
    }

    private void c() {
        if (this.c != null) goto L5;
    L21:
        t3 r0 = this.e;
        if (r0 == null) goto L24;
        r0.b();
        this.e = null;
    L24:
        d.b(true);
        return;
    L5:
        if (this.d.hasMessages(257) == false) goto L7;
    L19:
        this.d.removeMessages(262);
        this.d.sendEmptyMessage(262);
        return;
    L7:
        if (this.d.hasMessages(258) == true) goto L19;
        if (this.d.hasMessages(259) == true) goto L19;
        if (this.d.hasMessages(260) == true) goto L19;
        if (this.d.hasMessages(261) == true) goto L19;
        if (this.e.f() > 0) goto L18;
        m9.e().b(Boolean.FALSE);
    L18:
        this.c.quit();
        this.c = null;
        this.d = null;
        goto L21
    }

    private void a(s3 r3, boolean r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.f498a != null) goto L7;
        return;
    L7:
        if (r4 == true) goto L20;
    L18:
        z4.a(new File(r3.c()));     // Catch: Throwable -> L17
        z4.a(new File(r3.a()));     // Catch: Throwable -> L17
        z4.b(r3.c());     // Catch: Throwable -> L17
        z4.b(r3.a());     // Catch: Throwable -> L17
    L11:
        this.e.a(r3.f498a.f286a);     // Catch: Throwable -> L15
        StringBuilder r2 = new StringBuilder("1;;");
    L13:
        f.a(1320043, r2.append(r3.b()).toString());
        return;
    L15:
        r2 = new StringBuilder("0;1019;");
        goto L13
    L20:
        a(r3, 2);     // Catch: Throwable -> L15
        goto L18
    }

    private void b() {
        if (this.e != null) goto L6;
        this.e = t3.g();
    L6:
        if (this.c != null) goto L9;
        HandlerThread r0 = ve.f().b("m_d");
        this.c = r0;
        r0.start();
        this.d = new a(this, this.c.getLooper());
        return;
    }

    public static boolean a(String r7, String r8, boolean r9) {
        boolean r0 = false;
        BufferedInputStream r1 = null;
        long r2 = new File(r7).length();     // Catch: Throwable -> L23
        if (r2 > 0) goto L6;
        return false;
    L6:
        byte[] r3 = new byte[(int) r2];     // Catch: Throwable -> L23
        BufferedInputStream r4 = new BufferedInputStream(new FileInputStream(r7));     // Catch: Throwable -> L23
        byte[] r10 = new byte[8192];     // Catch: Throwable -> L21
        int r5 = 0;
    L9:
        int r6 = r4.read(r10);     // Catch: Throwable -> L21
        if (r6 == (-1)) goto L12;
        System.arraycopy(r10, 0, r3, r5, r6);     // Catch: Throwable -> L21
        r5 = r5 + r6;     // Catch: Throwable -> L21
        goto L9
    L12:
        FileOutputStream r11 = new FileOutputStream(r8);     // Catch: Throwable -> L21
        if (r9 == false) goto L15;
        r11.write(TccCryptor.encrypt(r3, null));     // Catch: Throwable -> L31
    L16:
        r11.flush();     // Catch: Throwable -> L31
        r4.close();     // Catch: Throwable -> L29
    L18:
        r0 = true;
    L43:
        r11.close();     // Catch: Throwable -> L30
    L28:
        return r0;
    L15:
        r11.write(TccCryptor.decrypt(r3, null));     // Catch: Throwable -> L31
    L22:
        r1 = r4;
    L24:
        if (r1 != null) goto L39;
    L26:
        if (r11 == null) goto L28;
    L39:
        r1.close();     // Catch: Throwable -> L32
    L21:
        r11 = null;
    L23:
        r11 = null;
        goto L24
    }

    public static synchronized vb a() {
        monitor-enter(vb.class);
        monitor-enter(vb.class);     // Catch: Throwable -> L25
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L7:
        if (g == null) goto L9;
    L18:
        monitor-exit(vb.class);     // Catch: Throwable -> L22
        vb r1 = g;     // Catch: Throwable -> L25
        monitor-exit(vb.class);
        return r1;
    L9:
        monitor-enter(vb.class);     // Catch: Throwable -> L22
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L11:
        if (g != null) goto L13;
        g = new vb();     // Catch: Throwable -> L15
    L13:
        monitor-exit(vb.class);     // Catch: Throwable -> L15
    L25:
        th = move-exception;
        throw th;
    }

    private void a(s3 r28, int r29) {
        jb r3 = r28.f498a;
        Iterator r4 = this.b.keySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L27;
        jb r5 = (jb) r4.next();
        if (r5.f286a != r3.f286a) goto L4;
        tt r11 = (tt) this.b.get(r5);
        int r12 = r3.b;     // Catch: Throwable -> L21
        int r13 = r5.b;     // Catch: Throwable -> L21
        if (r12 > r13) goto L10;
        if (r12 != r13) goto L114;
        if (r29 == 1) goto L17;
        if (r29 != 2) goto L4;
        r11.y();     // Catch: Throwable -> L21
        r11.z();     // Catch: Throwable -> L21
        this.b.remove(r5);     // Catch: Throwable -> L21
        this.f578a.remove(r5);     // Catch: Throwable -> L21
        return;
    L17:
        return;
    L114:
        return;
    L10:
        r11.y();     // Catch: Throwable -> L21
        r11.z();     // Catch: Throwable -> L21
        this.b.remove(r5);     // Catch: Throwable -> L21
        this.f578a.remove(r5);     // Catch: Throwable -> L21
        if (r29 == 1) goto L27;
        if (r29 != 2) goto L4;
        return;
    L21:
        if (r29 != 1) goto L24;
        StringBuilder r0 = new StringBuilder("0;1017;");
    L23:
        f.a(1320042, r0.append(r28.b()).toString());
        return;
    L24:
        if (r29 != 2) goto L115;
        r0 = new StringBuilder("0;1018;");
        goto L23
    L115:
        return;
    L27:
        Iterator r6 = this.f578a.keySet().iterator();
    L29:
        if (r6.hasNext() == false) goto L94;
        jb r7 = (jb) r6.next();
        if (r7.f286a != r3.f286a) goto L29;
        int r14 = r3.b;     // Catch: Throwable -> L46
        int r15 = r7.b;     // Catch: Throwable -> L46
        if (r14 <= r15) goto L39;
        ((tt) ((Class) this.f578a.get(r7)).getConstructor(new Class[0]).newInstance(new Object[0])).z();     // Catch: Throwable -> L46
        if (r29 == 1) goto L94;
        if (r29 != 2) goto L29;
        return;
    L39:
        if (r15 != r14) goto L116;
        tt r8 = (tt) ((Class) this.f578a.get(r7)).getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L46
        if (r29 != 1) goto L43;
        Bundle r9 = new Bundle();     // Catch: Throwable -> L46
        r9.putString(tt.ttKey, r28.c());     // Catch: Throwable -> L46
        r8.x(r9);     // Catch: Throwable -> L46
        this.b.put(r7, r8);     // Catch: Throwable -> L46
        return;
    L43:
        if (r29 != 2) goto L118;
        r8.z();     // Catch: Throwable -> L46
        this.f578a.remove(r7);     // Catch: Throwable -> L46
        return;
    L118:
        return;
    L116:
        return;
    L46:
        if (r29 != 1) goto L49;
        StringBuilder r1 = new StringBuilder("0;1017;");
    L48:
        f.a(1320042, r1.append(r28.b()).toString());
        return;
    L49:
        if (r29 != 2) goto L119;
        r1 = new StringBuilder("0;1018;");
        goto L48
    L119:
        return;
    L94:
        String r10 = r28.c() + File.separator + r28.b();     // Catch: Throwable -> L79
        File r16 = new File(r10);     // Catch: Throwable -> L79
        if (r16.exists() == true) goto L56;
        return;
    L56:
        if (a(r10, r10, false) == true) goto L59;
        f.a(1320038, "0;1016;" + r28.b());     // Catch: Throwable -> L79
        a(r28, false);     // Catch: Throwable -> L79
        return;
    L59:
        String r17 = r16.getAbsolutePath();     // Catch: Throwable -> L79
        int r18 = r16.getAbsolutePath().lastIndexOf(LibrarianImpl.Constants.DOT);     // Catch: Throwable -> L79
        if (r18 <= 0) goto L62;
        r17 = r16.getAbsolutePath().substring(0, r18);     // Catch: Throwable -> L79
    L62:
        File r19 = new File(r17 + new String(TccCryptor.decrypt(new byte[]{-82, 6, 122, -22, 71, -51, 117, -65}, null)));     // Catch: Throwable -> L79
        r16.renameTo(r19);     // Catch: Throwable -> L79
        Class<?> r20 = Class.forName(new String(TccCryptor.decrypt(new byte[]{-101, 38, 9, 38, 105, 0, 126, -7, -108, 117, 56, 22, 112, 122, -95, 120, -36, 43, -26, 29, 96, 126, 62, 34, -85, -2, -40, 69, 89, 118, 7, -83}, null)));     // Catch: Throwable -> L79
        Object r110 = r20.getConstructor(new Class[]{String.class, String.class, String.class, ClassLoader.class}).newInstance(new Object[]{r19.getAbsolutePath(), r28.a(), null, TMSDKContext.class.getClassLoader()});     // Catch: Throwable -> L79
        Method r21 = r20.getMethod(new String(TccCryptor.decrypt(new byte[]{114, 59, 15, -78, -74, -94, 79, -103, 57, -8, 114, -96, -107, 107, -78, 5}, null)), new Class[]{String.class});     // Catch: Throwable -> L79
        z4.a(new File(r28.a()));     // Catch: Throwable -> L88
        z4.b(r28.a());     // Catch: Throwable -> L88
    L64:
        r19.renameTo(r16);     // Catch: Throwable -> L79
        if (a(r10, r10, true) == true) goto L67;
        f.a(1320038, "0;1015;" + r28.b());     // Catch: Throwable -> L79
        a(r28, false);     // Catch: Throwable -> L79
    L67:
        if (r21 == null) goto L76;
        r21.setAccessible(true);     // Catch: Throwable -> L79
        Class r22 = (Class) r21.invoke(r110, new Object[]{"com.rr.rr"});     // Catch: Throwable -> L79
        tt r23 = (tt) r22.getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L79
        if (r29 != 1) goto L74;
        Bundle r24 = new Bundle(vb.class.getClassLoader());     // Catch: Throwable -> L79
        r24.putString(tt.ttKey, r28.c());     // Catch: Throwable -> L79
        r23.x(r24);     // Catch: Throwable -> L79
        this.f578a.put(r3, r22);     // Catch: Throwable -> L79
        this.b.put(r3, r23);     // Catch: Throwable -> L79
        if (r3.d != 2) goto L76;
        a(r28, true);     // Catch: Throwable -> L79
        goto L76
    L74:
        if (r29 != 2) goto L76;
        r23.z();     // Catch: Throwable -> L79
    L76:
        if (r29 != 1) goto L120;
        f.a(1320042, "1;;" + r28.b());
        return;
    L120:
        return;
    L79:
        if (r29 != 1) goto L83;
        StringBuilder r2 = new StringBuilder().append("0;1017;");
    L85:
        f.a(1320042, r2.append(r28.b()).toString());
    L86:
        a(r28, false);
        return;
    L83:
        if (r29 != 2) goto L86;
        r2 = new StringBuilder().append("0;1018;");
        goto L85
    }

    public synchronized void a(tt r3) {
        monitor-enter(this);
        b();     // Catch: Throwable -> L6
        Message.obtain(this.d, 261, r3).sendToTarget();     // Catch: Throwable -> L6
        this.d.sendEmptyMessage(262);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
