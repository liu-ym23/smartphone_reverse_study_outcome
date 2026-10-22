package tmsdkobf;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.obric.oui.texteffects.preset.DimPointEffectTokens;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public class u {
    private static final byte[] p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f539a;
    private HandlerThread b;
    private int c;
    private eg d;
    private HashMap e;
    private HashMap f;
    private HashMap g;
    private d6 h;
    private String i;
    private final int j;
    private int k;
    private long l;
    private int m;
    private long n;
    private volatile AtomicBoolean o;

    class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ u f540a;

        a(u r1, Looper r2) {
            this.f540a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r6) {
            super.handleMessage(r6);
            if (r6.what != 10001) goto L29;
            boolean r7 = u.m2445$$Nest$fgetd(this.f540a).d();
            q8.a("ArpShield", " wifiInfo.refresh() : " + r7);
            if (r7 == false) goto L15;
            q8.d("ArpShield", "arp loop");
            u r8 = this.f540a;
            int r1 = u.m2444$$Nest$fgetc(r8) + 1;
            u.m2449$$Nest$fputc(r8, r1);
            u.m2450$$Nest$fputk(r8, u.m2447$$Nest$fgetk(r8) + 1);
            if (r1 != 1) goto L10;
            q8.c("ArpShield", "devicesDiscovery ARP_LOOP");
            u.m2451$$Nest$ma(this.f540a);
        L10:
            u.m2445$$Nest$fgetd(this.f540a).a();
            u.m2452$$Nest$ma(this.f540a, 10001);     // Catch: Exception -> L13
        L13:
            e = move-exception;
            q8.c("ArpShield", "ARP_LOOP " + e.getMessage());
        L15:
            q8.b("ArpShield", "ARP_LOOP mStop.get() = " + u.m2448$$Nest$fgeto(this.f540a).get());
            u r9 = this.f540a;
            if (u.m2447$$Nest$fgetk(r9) < Integer.MAX_VALUE) goto L18;
        L24:
            removeMessages(10001);
            q8.b("ArpShield", "ARP_LOOP arp检测次数够了");
            this.f540a.f();
            return;
        L18:
            if (u.m2448$$Nest$fgeto(r9).get() == true) goto L24;
            q8.c("ArpShield", "ARP_LOOP arp检测次数" + u.m2447$$Nest$fgetk(this.f540a));
            if (u.m2446$$Nest$fgeth(this.f540a) == null) goto L28;
            sendEmptyMessageDelayed(10001, 100);
            return;
        L28:
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetc, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2444$$Nest$fgetc(u r0) {
        return r0.c;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetd, reason: not valid java name */
    static /* bridge */ /* synthetic */ eg m2445$$Nest$fgetd(u r0) {
        return r0.d;
    }

    /* JADX INFO: renamed from: -$$Nest$fgeth, reason: not valid java name */
    static /* bridge */ /* synthetic */ d6 m2446$$Nest$fgeth(u r0) {
        return r0.h;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetk, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2447$$Nest$fgetk(u r0) {
        return r0.k;
    }

    /* JADX INFO: renamed from: -$$Nest$fgeto, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicBoolean m2448$$Nest$fgeto(u r0) {
        return r0.o;
    }

    /* JADX INFO: renamed from: -$$Nest$fputc, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2449$$Nest$fputc(u r0, int r1) {
        r0.c = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputk, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2450$$Nest$fputk(u r0, int r1) {
        r0.k = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$ma, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2451$$Nest$ma(u r0) {
        r0.a();
    }

    /* JADX INFO: renamed from: -$$Nest$ma, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2452$$Nest$ma(u r0, int r1) {
        r0.a(r1);
    }

    static {
        p = new byte[]{-126, 40, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 32, 67, 75, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 0, 0, 33, 0, 1};
    }

    u(Context r5, String r6, d6 r7) {
        this.f539a = null;
        this.b = new HandlerThread("ArpHandlerThread");
        this.c = 0;
        this.d = null;
        this.e = new HashMap();
        this.f = new HashMap();
        this.g = new HashMap();
        this.h = null;
        this.j = Integer.MAX_VALUE;
        this.k = 0;
        this.m = 0;
        this.o = new AtomicBoolean(false);
    L7:
        th = move-exception;
        q8.a("ArpShield", "Thread.start (Throwable)", th);
    L9:
        this.f539a = new a(this, this.b.getLooper());
        this.d = new eg(r5);
        this.h = r7;
        this.i = r6;
        this.m = 0;
        return;
    L4:
        if (this.b.isAlive() == true) goto L9;
        this.b.start();     // Catch: Throwable -> L7
        goto L9
    }

    private void a(int r14) {
        int r4 = 1;
        this.m++;     // Catch: Throwable -> L74
        if (TextUtils.equals(this.i, this.d.b) == true) goto L7;
        q8.b("ArpShield", "ARP检测过程中，发现Wifi已经切换了 原来的Wifi bssid = " + this.i + "现在的 wifi bSsid = " + this.i);     // Catch: Throwable -> L74
        f();     // Catch: Throwable -> L74
        return;
    L7:
        int r2 = this.d.h.size();     // Catch: Throwable -> L74
        q8.a("ArpShield", "deviceSize : " + r2);     // Catch: Throwable -> L74
        if (r2 > 1) goto L11;
        q8.b("ArpShield", "只有一台设备,不用检测了");     // Catch: Throwable -> L74
        return;
    L11:
        String r1 = "";
        String r5 = "";
        int r6 = 0;
        int r7 = 0;
        boolean r8 = false;
    L12:
        if (r6 >= r2) goto L53;
        String r9 = ((String[]) this.d.h.get(r6))[0];     // Catch: Throwable -> L74
        String r10 = ((String[]) this.d.h.get(r6))[1];     // Catch: Throwable -> L74
        if (TextUtils.isEmpty(r9) == true) goto L52;
        if (TextUtils.isEmpty(r10) == true) goto L52;
        String r11 = (String) this.e.get(r9);     // Catch: Throwable -> L74
        if (r11 != null) goto L22;
        this.e.put(r9, r10);     // Catch: Throwable -> L74
    L36:
        String r12 = (String) this.f.get(r10);     // Catch: Throwable -> L74
        if (r12 != null) goto L40;
        this.f.put(r10, r9);     // Catch: Throwable -> L74
        goto L52
    L40:
        if (TextUtils.equals(r12, r9) == true) goto L52;
        r7 = r7 + 1;     // Catch: Throwable -> L74
        if (TextUtils.equals(r12, this.d.e) == true) goto L46;
        if (TextUtils.equals(r9, this.d.e) == false) goto L52;
    L46:
        if (TextUtils.equals(r12, this.d.e) == true) goto L49;
        r9 = r12;
    L49:
        if (this.d.a(r9) == true) goto L51;
        q8.b("ArpShield", "存在arp欺骗，mac地址相同，但是因为是ip不在同一网段，所以放过! attackIP = " + r9 + " 网关 IP = " + this.d.e + " 网关Mac = " + this.d.f);     // Catch: Throwable -> L74
        goto L52
    L51:
        r8 = true;
        r1 = r9;
        r5 = r10;
        goto L52
    L22:
        if (TextUtils.equals(r11, r10) == true) goto L36;
        if (r9.equals(this.d.e) == false) goto L36;
        if (r10.equals(this.d.f) == false) goto L28;
        String r3 = (String) this.e.get(r9);     // Catch: Throwable -> L74
    L29:
        String r13 = (String) this.f.get(r10);     // Catch: Throwable -> L74
        if (r13 != null) goto L32;
    L33:
        r13 = a(r3, this.d.e);     // Catch: Throwable -> L74
    L34:
        String r15 = "arp attack gateway mac different checkCount = " + this.m + " costTime = " + (System.currentTimeMillis() - this.l);     // Catch: Throwable -> L74
        q8.b("ArpShield", "检测出有ARP攻击，明确的网关mac前后不一样了，耗时 = " + (System.currentTimeMillis() - this.l));     // Catch: Throwable -> L74
        a(r13, r3, r14, r15);     // Catch: Throwable -> L74
        return;
    L32:
        if (r13.equals(this.d.e) == false) goto L34;
    L28:
        r3 = r10;
    L52:
        r6 = r6 + 1;     // Catch: Throwable -> L74
        goto L12
    L53:
        if (r7 != 1) goto L88;
        if (r8 == false) goto L89;
        long r16 = System.currentTimeMillis() - this.l;     // Catch: Throwable -> L74
        long r17 = this.n;     // Catch: Throwable -> L74
        long r18 = r17 - r16;     // Catch: Throwable -> L74
        if (r18 >= 0) goto L58;
        return;
    L58:
        if (r17 >= 0) goto L61;
        return;
    L61:
        if (r18 > DimPointEffectTokens.PendingCycleMs) goto L67;
        if (r17 <= 0) goto L66;
        q8.b("ArpShield", "arpCheck ,时间不够ping了 dxTime " + r18);     // Catch: Throwable -> L74
        return;
    L66:
        r4 = 3;
    L67:
        int r19 = new pa().a(-1, r4, this.d.e);     // Catch: Throwable -> L74
        if (pa.a(r19) == false) goto L71;
        q8.b("ArpShield", "arpCheck ,arp表不一样，但是ttl =  " + r19 + "所以不是arp 攻击");     // Catch: Throwable -> L74
        return;
    L71:
        r8.b("ArpShield", "arpCheck，检测出有ARP攻击 maybeattackIp = " + r1 + " attack = " + r5 + "ttl = " + r19 + " 耗时 = " + (System.currentTimeMillis() - this.l));     // Catch: Throwable -> L74
        a(r1, r5, r14, "ttl =" + r19);     // Catch: Throwable -> L74
        return;
    L89:
        return;
    L88:
        return;
    L74:
        th = move-exception;
        q8.b("ArpShield", "arpCheck (Throwable) ", th);
    }

    private String b() {
        ArrayList r0 = this.d.h;
        if (r0 != null) goto L5;
    L14:
        return "";
    L5:
        if (r0.size() <= 0) goto L14;
        StringBuilder r1 = new StringBuilder();
        Iterator r3 = this.d.h.iterator();
    L8:
        if (r3.hasNext() == false) goto L16;
        String[] r2 = (String[]) r3.next();
        r1.append(r2[0]);
        r1.append("-");
        r1.append(r2[1]);
        r1.append("`");
        goto L8
    L16:
        return URLEncoder.encode(r1.toString(), "UTF-8");
    L12:
        e = move-exception;
        q8.a("ArpShield", "getCurrentArpTable (UnsupportedEncodingException)", e);
        goto L14
    }

    public void c() {
        HashMap r0 = this.e;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        HashMap r1 = this.f;
        if (r1 == null) goto L8;
        r1.clear();
    L8:
        HashMap r2 = this.g;
        if (r2 == null) goto L11;
        r2.clear();
    L11:
        this.k = Integer.MAX_VALUE;
    }

    void d() {
        q8.c("ArpShield", "sendArpCheck");
        this.o.compareAndSet(true, false);
        if (this.f539a == null) goto L5;
        this.l = System.currentTimeMillis();
        this.f539a.sendEmptyMessage(10001);
        return;
    L5:
        q8.b("ArpShield", "mArpHandler == null");
    }

    void e() {
        q8.c("ArpShield", "stop");
        this.o.compareAndSet(false, true);
        d6 r3 = this.h;
        if (r3 == null) goto L6;
        r3.a();
        return;
    }

    void f() {
        q8.c("ArpShield", "stopAndRelease mScanWifiBssid = " + this.i);
        HandlerThread r0 = this.b;
        if (r0 == null) goto L8;
        Looper r1 = r0.getLooper();
        if (r1 == null) goto L7;
        r1.quit();
    L7:
        this.b.quit();
    L8:
        this.h = null;
        Handler r2 = this.f539a;
        if (r2 == null) goto L11;
        r2.removeMessages(10001);
    L11:
        c();
    }

    private void a() {
        int r0 = this.d.b();
        if (r0 != 0) goto L5;
        return;
    L5:
        int r1 = 0;
    L7:
        if (r1 == 256) goto L14;
        String r2 = eg.a(r0);
        if (r2.equals(this.d.g) == true) goto L13;
        if (r2.equals(this.d.e) == true) goto L13;
        a(r2);
    L13:
        r0 = eg.b(r0);
        r1 = r1 + 1;
        goto L7
    }

    private String a(String r6, String r7) {
        int r1 = 0;
    L4:
        if (r1 == this.d.h.size()) goto L11;
        String r2 = ((String[]) this.d.h.get(r1))[0];
        if (((String[]) this.d.h.get(r1))[1].equals(r6) == false) goto L10;
        if (r2.equals(r7) == true) goto L10;
        return r2;
    L10:
        r1 = r1 + 1;
        goto L4
    L11:
        Set r0 = this.e.keySet();
        if (r0 != null) goto L14;
    L24:
        return "0.0.0.0";
    L14:
        if (r0.size() <= 0) goto L24;
        Iterator r3 = r0.iterator();
    L18:
        if (r3.hasNext() == false) goto L24;
        String r4 = (String) r3.next();
        if (TextUtils.equals((String) this.e.get(r4), r6) == false) goto L18;
        if (TextUtils.equals(r4, r7) == true) goto L18;
        return r4;
    }

    private void a(String r7, String r8, int r9, String r10) {
        d6 r0 = this.h;
        if (r0 == null) goto L5;
        r0.a(r7, r8, r9, b(), r10);
    L5:
        c();
    }

    private static void a(String r5) {
        DatagramSocket r0 = null;
        DatagramSocket r1 = new DatagramSocket();     // Catch: Throwable -> L9 Exception -> L16
        goto L13
    L19:
        byte[] r2 = p;     // Catch: Throwable -> L6 Exception -> L8
        DatagramPacket r3 = new DatagramPacket(r2, r2.length, InetAddress.getByName(r5), 137);     // Catch: Throwable -> L6 Exception -> L8
        r1.setSoTimeout(100);     // Catch: Throwable -> L6 Exception -> L8
        r1.send(r3);     // Catch: Throwable -> L6 Exception -> L8
        r1.close();     // Catch: Throwable -> L6 Exception -> L8
        r1.close();
        return;
    L8:
        r0 = r1;
    L6:
        th = th;
        r0 = r1;
    L10:
        if (r0 == null) goto L12;
        r0.close();
    L12:
        throw th;
    L9:
        th = th;
    L13:
        if (r0 == null) goto L22;
        r0.close();
        return;
    }

    void a(long r1) {
        this.n = r1;
    }
}
