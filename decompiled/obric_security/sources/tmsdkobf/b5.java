package tmsdkobf;

import android.content.Context;
import android.content.res.Resources;
import android.media.MediaDrm;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.work.WorkRequest;
import com.tencent.tmsecure.vd.TNative$aa;
import com.ttnet.org.chromium.base.TimeUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import obric.widget.ChipsView;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes5.dex */
public class b5 {
    public static final String i = null;
    public static final String j = null;
    public static final String k = null;
    public static final b5 l = null;
    public static final long m = 0;
    public static final int[] n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k3 f111a;
    public Handler b;
    public boolean c;
    public d5 d;
    public final Object e;
    public final AtomicReference f;
    public final AtomicReference g;
    public final AtomicReference h;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f112a;
        public final /* synthetic */ b5 b;

        public a(b5 r1, Looper r2, Context r3) {
            this.b = r1;
            super(r2);
            this.f112a = r3;
        }

        @Override // android.os.Handler
        public void handleMessage(Message r5) {
            int r0 = r5.what;
            if (r0 != 1) goto L5;
            this.b.a(this.f112a, true, 3);
            return;
        L5:
            if (r0 != 2) goto L20;
            int r6 = ((Integer) r5.obj).intValue();
            w3 r7 = this.b.a(this.f112a, true, false, r6);
            this.b.a(r7, false);
            AtomicReference r8 = this.b.g;
            monitor-enter(r8);
            this.b.g.set(Boolean.FALSE);     // Catch: Throwable -> L12
            this.b.g.notifyAll();     // Catch: Throwable -> L12
            monitor-exit(r8);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }
    }

    static {
        i = xk.a(xk.a1);
        j = xk.a(xk.b1);
        k = xk.a(xk.c1);
        l = new b5();
        m = TimeUnit.MINUTES.toMillis(30);
        n = new int[]{0, 15, 30, 90, 240, 360, 600, 1200, 2400, 3200, 4800, 7200};
    }

    public b5() {
        this.c = false;
        this.e = new Object();
        this.f = new AtomicReference(null);
        this.g = new AtomicReference(Boolean.FALSE);
        this.h = new AtomicReference(null);
    }

    public static void a(b5 r13) {
        r13.getClass();
        monitor-enter(mh.class);
        Context r1 = mh.f353a;     // Catch: Throwable -> L108
        monitor-exit(mh.class);
        i8.a(r1, r13.d);
        r13.f111a.getClass();
        q5 r0 = q5.f;
        r0.getClass();
        r0.b(r1);     // Catch: Throwable -> L111
        r0.b();     // Catch: Throwable -> L111
    L9:
        if (r0.a(39) == false) goto L59;
        r13.d.getClass();
        if (TextUtils.isEmpty(d5.b(r1, "405")) == false) goto L59;
        StringBuilder r2 = new StringBuilder();
        String[] r6 = new String(xj.a("/proc/self/maps")).split(IOUtils.LINE_SEPARATOR_UNIX);     // Catch: Throwable -> L112
        HashSet r7 = new HashSet();     // Catch: Throwable -> L112
        int r8 = r6.length;     // Catch: Throwable -> L112
        int r9 = 0;
    L14:
        if (r9 >= r8) goto L54;
        String[] r10 = r6[r9].split(" +");     // Catch: Throwable -> L112
        if (r10.length < 2) goto L53;
        String r11 = r10[r10.length - 1].trim();     // Catch: Throwable -> L112
        File r12 = new File(r11);     // Catch: Throwable -> L24
        if (r12.exists() == false) goto L53;
        String r14 = r12.getName();     // Catch: Throwable -> L24
    L25:
        if (r14 == null) goto L53;
        if (r14.contains("res") == false) goto L53;
        if (r14.endsWith(".apk") == false) goto L53;
        if (r14.contains("mediatek") == true) goto L53;
        if (TextUtils.equals("/system/framework/framework-res.apk", r11) == true) goto L53;
        if (r7.contains(r11) == true) goto L53;
        r7.add(r11);     // Catch: Throwable -> L112
        String r15 = xg.a(r1, r11);     // Catch: Throwable -> L112
        if (r15 == null) goto L53;
        if (TextUtils.equals(r15, "android.auto_generated_rro__") == true) goto L53;
        if (TextUtils.equals(r15, "android.overlay") == true) goto L53;
        if (r2.length() <= 0) goto L52;
        r2.append(":");     // Catch: Throwable -> L112
    L52:
        r2.append(r15);     // Catch: Throwable -> L112
    L24:
        r14 = null;
    L53:
        r9 = r9 + 1;
    L54:
        r2.append(",");
        String r16 = Resources.getSystem().getClass().getName();
        if (TextUtils.equals("android.content.res.Resources", r16) == true) goto L57;
        r2.append(r16);
    L57:
        r13.d.a(r1, "405", r2.toString().replace("(\\|)|\\s*|\t|\r|\n", ""), true);
    L59:
        if (r13.f111a.t == true) goto L61;
    L86:
        k3 r3 = r13.f111a;
        if (r3.q == true) goto L89;
        return;
    L89:
        if (r3.c().a() == true) goto L92;
        return;
    L92:
        if (r0.a(41) == false) goto L94;
        Map r4 = n9.f365a;
        xh.b.execute(new w8(r1));
    L94:
        r13.a(r13.f111a.b(), false, 0);
        String r17 = i0.f256a;
        monitor-enter(mh.class);
        Context r5 = mh.f353a;     // Catch: Throwable -> L104
        monitor-exit(mh.class);
        if (i0.a(r5) == null) goto L102;
        return;
    L102:
        if (ia.b(r1) == false) goto L141;
        new i0.a(null, true).a();
        return;
    L141:
        return;
    L104:
        th = move-exception;
        throw th;
    L61:
        if (r0.a(45) == false) goto L86;
        d5 r18 = r13.d;
        int r19 = s1.b;
        r18.getClass();
        long r20 = Long.valueOf(d5.b(r1, "902")).longValue();     // Catch: Throwable -> L65
    L67:
        if (Math.abs(r20 - System.currentTimeMillis()) < s1.f496a) goto L86;
        if (TextUtils.isEmpty(d5.b(r1, "901")) == true) goto L78;
        long r21 = Math.abs(r20 - System.currentTimeMillis());
        o5 r22 = o5.f;
        long r23 = o5.e;
        String r24 = r22.a("sid_refresh_period");
        if (r24 == null) goto L77;
        r23 = Long.parseLong(r24) * 3600000;
    L77:
        if (r21 >= r23) goto L78;
    L85:
        r18.b(r1, System.currentTimeMillis());
    L78:
        t0 r25 = u1.a(r1);
        if (r25.f520a == 0) goto L83;
        r25 = u1.a();
    L83:
        if (r25.f520a != 0) goto L85;
        String r26 = r25.d;
        HashMap r27 = new HashMap();
        r27.put("901", r26);
        d5.a(r1, r27);
        String r28 = r25.toString();
        HashMap r29 = new HashMap();
        r29.put("904", r28);
        d5.a(r1, r29);
    L65:
        r20 = 0;
    L108:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v47 */
    /* JADX WARN: Type inference failed for: r0v53 */
    /* JADX WARN: Type inference failed for: r0v55 */
    /* JADX WARN: Type inference failed for: r0v57 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r3v80, types: [java.lang.Object, tmsdkobf.d5] */
    /* JADX WARN: Type inference failed for: r4v30, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r4v34, types: [tmsdkobf.o5] */
    /* JADX WARN: Type inference failed for: r7v16, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final w3 b(Context r28, boolean r29, int r30) {
        long r12 = q5.f.a(r28);
        long r14 = System.currentTimeMillis();
        String r0 = q3.f431a;
        long r16 = System.currentTimeMillis();
        ((HashMap) wj.f605a).clear();
        HashMap r1 = new HashMap();
        r1.put("1", p.a("").append(n0.f360a).toString());
        k3 r2 = this.f111a;
        if (r2 != null) goto L5;
    L7:
        k3 r3 = this.f111a;
        if (TextUtils.isEmpty(r3.p) == false) goto L10;
        String r4 = "";
    L11:
        r1.put("101", r4);
        r1.put("207", this.d.a(r28).f594a);
        k3 r5 = this.f111a;
        if (TextUtils.isEmpty(r5.f) == false) goto L14;
        String r6 = "";
    L15:
        r1.put("209", r6);
        boolean r7 = this.f111a.s;
        d5 r8 = this.d;
        StringBuilder r9 = new StringBuilder();
        gk.a(r9);
        r9.append(",");
        r9.append("F:");
        if (r29 == false) goto L18;
        String r10 = "1";
    L19:
        r9.append(r10);
        r9.append(",");
        r9.append("PT:");
        char r11 = 0;
        r9.append(0);
        r9.append(",");
        r9.append("PKG:");
        r9.append("1");
        r9.append(",");
        r9.append("SC:");
        if (r7 == false) goto L22;
        String r13 = "1";
    L23:
        r9.append(r13);
        if (n0.f360a != 105748) goto L26;
        r9.append(",");
        r9.append("SOTR:");
        r9.append(u1.a().toString() + ";" + u1.a(r28).toString());
    L26:
        r9.append(",");
        r9.append("SRT:");
        r9.append(r30);
        String r15 = d5.b(r28, "204");
        if (TextUtils.isEmpty(r15) == false) goto L34;
        StringBuilder r17 = p.a("0_");
        if (r29 == false) goto L31;
        String r18 = "1";
    L32:
        r15 = r17.append(r18).toString();
        goto L34
    L31:
        r18 = "0";
    L34:
        if (TextUtils.isEmpty(r15) == true) goto L36;
        r9.append(",");
        r9.append("R:");
        r9.append(r15);
    L36:
        r9.append(",");
        r9.append("US:");
        long r19 = Long.valueOf(d5.b(r28, "503")).longValue();     // Catch: Throwable -> L39
    L40:
        r9.append(r19);
        r9.append("_");
        r9.append(r8.a(r28, "502"));
        r9.append("_");
        r9.append(Process.myUid());
        r9.append(",");
        r9.append("STIF:");
        r9.append(d5.b(r28, "904"));
        r9.append(",");
        r9.append("GCI:");
        r9.append("30eeafe");
        r1.put("210", r9.toString());
        q5 r20 = q5.f;
        r1.put("2001", r20.a());
        o5 r21 = o5.f;
        int r22 = n0.f360a;
        if (r22 == 105668) goto L48;
        if (r22 == 105928) goto L48;
        if (r29 == true) goto L52;
        r1.put("1001", "1");
    L52:
        StringBuilder r23 = p.a("");
        String r24 = r21.a("m_p_s");
        if (r24 != null) goto L392;
    L57:
        long r110 = 300;
    L58:
        r1.put("2012", r23.append((int) r110).toString());
        if (r20.a(136) == false) goto L65;
        if (jd.a(r28, k) != 0) goto L65;
        r1.put("501", "1");
    L65:
        if (r20.a(143) == true) goto L68;
    L98:
        int r25 = 2;
        if (this.f111a.B == false) goto L101;
    L104:
        String r26 = o5.f.a("d_i_l");
        if (r26 != null) goto L108;
        r26 = o5.d;
    L108:
        if (TextUtils.isEmpty(r26) == false) goto L110;
        String r27 = null;
        boolean r31 = true;
    L128:
        if (TextUtils.isEmpty(r27) == true) goto L130;
        r1.put("2023", r27);
    L131:
        q5 r32 = q5.f;
        o5 r33 = o5.f;
        if (r32.a(41) == true) goto L134;
        r1.put("2003", "0");
    L135:
        i7 r34 = this.f111a.d;
        if (r34 == null) goto L150;
        Object r35 = new Object();
        AtomicBoolean r36 = new AtomicBoolean(false);
        long r210 = System.currentTimeMillis();
        l7 r111 = null;
        new t4(this, r36, r1, r34, r210, r35).start();
        monitor-enter(r35);
        r35.wait(1000);     // Catch: Throwable -> L141 InterruptedException -> L377
    L141:
        th = move-exception;
        throw th;
    L143:
        monitor-exit(r35);     // Catch: Throwable -> L141
        if ((System.currentTimeMillis() - r210) <= 1000) goto L147;
        Log.w("Turing", "invoke info impl timeout");
    L147:
        boolean r37 = true;
        r36.set(true);
    L151:
        r1.put("264", qk.a());
        if (r32.a(10002) == true) goto L155;
        r1.put("2005", "0");
    L155:
        if (r32.a(10003) == true) goto L157;
        r1.put("2006", "0");
    L157:
        r1.put("266", d5.b(r28, "901"));
        if (r32.a(115) == false) goto L164;
        String r38 = j8.b();
        if (r38 != null) goto L162;
        r38 = "";
    L162:
        r1.put("268", r38);
    L164:
        if (r32.a(116) == false) goto L170;
        String r39 = q1.a();
        if (r39 != null) goto L168;
        r39 = "";
    L168:
        r1.put("269", r39);
    L170:
        if (r32.a(117) == false) goto L173;
        r1.put("270", p.a("").append(j8.a(r28)).toString());
    L173:
        if (r32.a(46) == false) goto L176;
        r1.put("271", p.a("").append(gl.a()).toString());
    L176:
        if (r32.a(118) == false) goto L179;
        r1.put("272", p.a("").append(v1.b()).toString());
    L179:
        if (r32.a(17) == false) goto L181;
    L184:
        b5 r40 = this;
        r40.f111a.getClass();
        List r41 = od.a(r111);
        HashSet r42 = new HashSet();
        if (r41 != null) goto L187;
    L190:
        Set r43 = r33.c();
        if (r43 == null) goto L193;
        r42.addAll(r43);
    L193:
        r42.add(r28.getPackageName());
        r1.put("277", od.a(r42));
    L195:
        if (r32.a(126) == false) goto L197;
        r1.put("281", String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
    L197:
        String r44 = r33.a("x_l2_p_i");
        if (r44 == null) goto L200;
        r1.put("2014", r44);
    L200:
        String r45 = r33.a("x_u_p_i");
        if (r45 == null) goto L203;
        r1.put("2015", r45);
    L203:
        String r46 = r33.a();
        if (r46 == null) goto L206;
        r1.put("2013", r46);
    L206:
        q5 r47 = q5.f;
        if (r47.a(39) == false) goto L210;
        r40.d.getClass();
        r1.put("239", d5.b(r28, "405"));
    L210:
        if (r47.a(100) == false) goto L216;
        long r48 = System.currentTimeMillis();
        String r49 = q1.a(r28);
        if (r49 != null) goto L214;
        r49 = "";
    L214:
        r1.put("250", r49);
        wj.a(30, System.currentTimeMillis() - r48);
    L216:
        if (r47.a(101) == false) goto L223;
        long r50 = System.currentTimeMillis();
        int r51 = b9.b(r28);
        if (r51 <= 0) goto L220;
        String r112 = "1";
    L221:
        r1.put("251", r112);
        r1.put("288", String.valueOf(r51));
        wj.a(31, System.currentTimeMillis() - r50);
        goto L223
    L220:
        r112 = "0";
    L223:
        if (r47.a(102) == false) goto L229;
        ?? r113 = 0;
        if (Settings.Secure.getInt(r28.getContentResolver(), "mock_location", 0) == 0) goto L227;
        String r52 = "1";
    L228:
        r1.put("252", r52);
    L231:
        if (r47.a(103) == false) goto L234;
        r1.put("253", p.a("").append(j8.d(r28)).toString());
    L234:
        if (r47.a(104) == false) goto L237;
        r1.put("254", p.a("").append(j8.b(r28)).toString());
    L237:
        if (r47.a(105) == false) goto L240;
        r1.put("255", p.a("").append(qi.a(r28)).toString());
    L240:
        if (r47.a(106) == false) goto L246;
        long r211 = System.currentTimeMillis();
        String r114 = j8.a();
        if (r114 != null) goto L244;
        r114 = "";
    L244:
        r1.put("256", r114);
        wj.a(32, System.currentTimeMillis() - r211);
    L246:
        if (r47.a(107) == false) goto L252;
        String r115 = j8.f(r28);
        if (r115 != null) goto L250;
        r115 = "";
    L250:
        r1.put("257", r115);
    L252:
        if (r47.a(113) == false) goto L259;
        long r212 = System.currentTimeMillis();
        if (hf.a() == false) goto L256;
        String r116 = "1";
    L257:
        r1.put("258", r116);
        wj.a(40, System.currentTimeMillis() - r212);
        goto L259
    L256:
        r116 = "0";
    L259:
        if (r47.a(44) == false) goto L262;
        long r53 = System.currentTimeMillis();
        r1.put("240", g3.a());
        wj.a(42, System.currentTimeMillis() - r53);
    L262:
        if (r47.a(138) == false) goto L264;
        r1.put("282", j8.c(r28));
    L264:
        r1.put("403", p.a("").append(r40.f111a.m).toString());
        r1.put("402", r40.f111a.k);
        r1.put("404", r40.f111a.l);
        r1.put("401", r40.f111a.n);
        r40.f111a.getClass();
        ?? r54 = r111;
        r1.put("405", r54);
        Map r55 = r40.f111a.o;
        StringBuilder r56 = new StringBuilder();
        Iterator r117 = r55.keySet().iterator();
    L266:
        if (r117.hasNext() == false) goto L271;
        int r57 = ((Integer) r117.next()).intValue();
        r56.append(r57);
        r56.append("_");
        r56.append(z1.a(",", "%54", z1.a("_", "%5F", (String) r55.get(Integer.valueOf(r57)))));
        if (r117.hasNext() == false) goto L266;
        r56.append(",");
        goto L266
    L271:
        r1.put("406", r56.toString());
        r40.d.getClass();
        r1.put("302", d5.b(r28, "201"));
        r40.d.getClass();
        r1.put("303", d5.b(r28, "202"));
        r40.d.getClass();
        r1.put("305", d5.b(r28, "203"));
        r1.put("308", "" + ia.a(r28));
        r40.d.getClass();
        r1.put("309", d5.b(r28, "404"));
        r40.d.getClass();
        r1.put("310", d5.b(r28, "205"));
        r40.f111a.getClass();
        SparseArray<Object> r58 = TNative$aa.a90_A43184BF099FF466(new SparseArray(), r28, r1, r54, r113);     // Catch: Throwable -> L287
        r40.d.a(r28, "201", (System.currentTimeMillis() - r16) + "_" + (r29 ? 1 : 0));
        int r59 = ca.b(r58);
        byte[] r60 = ca.a(r58);
        StringBuilder r61 = new StringBuilder();
        String r62 = (String) ca.a(r58, 2, String.class);
        int r63 = z1.f651a;
        if (r62 != null) goto L276;
        r62 = "";
    L276:
        StringBuilder r64 = r61.append(r62);
        StringBuilder r65 = new StringBuilder();
        Iterator r66 = ((HashMap) wj.f605a).keySet().iterator();
    L278:
        if (r66.hasNext() == false) goto L280;
        int r67 = ((Integer) r66.next()).intValue();
        r65.append(",");
        r65.append(r67);
        r65.append("_");
        r65.append(((HashMap) wj.f605a).get(Integer.valueOf(r67)));
        goto L278
    L280:
        r40.d.a(r28, "205", r64.append(r65.toString()).toString());
        d5 r68 = r40.d;
        long r69 = r60.length;
        r68.getClass();
        r68.a(r28, "203", "" + r69 + "_" + (r29 ? 1 : 0));
        if (r59 == 0) goto L284;
        w5 r70 = w5.a(r59);
    L288:
        w5 r71 = r70;
        long r72 = System.currentTimeMillis() - r14;
        int r73 = r71.f596a;
        if (r73 != 0) goto L291;
        long r74 = System.currentTimeMillis();
        x5 r75 = s5.b.a(r71.b, 8117, 18117);
        NetworkInfo r76 = ((ConnectivityManager) r28.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L313
        if (r76 != null) goto L296;
    L319:
        ?? r77 = -1;
    L320:
        r40.d.a(r28, "202", r77 + "_" + (System.currentTimeMillis() - r74) + "_" + r12 + "_" + (r29 ? 1 : 0) + "_" + r71.b.length + "_" + r72 + "_" + (System.currentTimeMillis() - r14));
        int r78 = r75.f613a;
        if (r78 != 0) goto L323;
        byte[] r79 = r75.b;
        String r80 = q3.f431a;
        HashMap r81 = new HashMap();     // Catch: Throwable -> L374
        if (o5.f.a("e_w_t", r113) == false) goto L328;
        r81.put("2007", "1");     // Catch: Throwable -> L374
    L328:
        SparseArray<Object> r82 = TNative$aa.b90_A43184BF099FF466(new SparseArray(), r79, r81, r113);     // Catch: Throwable -> L374
        int r83 = ca.b(r82);
        if (r83 != 0) goto L413;
        Integer r84 = (Integer) ca.a(r82, 102, Integer.class);
        if (r84 != null) goto L336;
        return w3.a(-30000);
    L336:
        if (r84.intValue() < 0) goto L415;
        String r85 = (String) ca.a(r82, 101, String.class);
        int r86 = z1.f651a;
        if (r85 != null) goto L342;
        r85 = "";
    L342:
        if (TextUtils.isEmpty(r85) == true) goto L416;
        String r87 = (String) ca.a(r82, 104, String.class);
        if (r87 != null) goto L347;
        r87 = "";
    L347:
        String r88 = (String) ca.a(r82, 105, String.class);
        if (r88 != null) goto L350;
        r88 = "";
    L350:
        String r89 = (String) ca.a(r82, 106, String.class);
        if (r89 != null) goto L353;
        r89 = "";
    L353:
        Integer r90 = (Integer) ca.a(r82, 107, Integer.class);
        String r91 = (String) ca.a(r82, 108, String.class);
        if (r91 != null) goto L357;
        r91 = "";
    L357:
        if (r90 != null) goto L359;
    L360:
        r90 = 3600;
    L361:
        long r92 = (System.currentTimeMillis() / 1000) + ((long) r90.intValue());
        w3.a r118 = new w3.a(r113);
        r118.b = r92;
        r118.f595a = r85;
        r118.d = r87;
        r118.e = r88;
        r118.f = r89;
        r118.g = r91;
        w3 r93 = new w3(r118);
        ?? r94 = r40.d;
        r94.getClass();
        HashMap r95 = new HashMap();
        r95.put("101", r93.f594a);
        r95.put("102", "" + r93.b);
        if (TextUtils.isEmpty(r93.d) == true) goto L365;
        r95.put("104", r93.d);
    L365:
        if (TextUtils.isEmpty(r93.e) == true) goto L368;
        r95.put("105", r93.e);
    L368:
        if (TextUtils.isEmpty(r93.f) == true) goto L371;
        r95.put("106", r93.f);
    L371:
        if (TextUtils.isEmpty(r93.g) == true) goto L373;
        r95.put("110", r93.g);
    L373:
        r94.a(r28, r95, r37);
        d5 r96 = r40.d;
        long r97 = r90.intValue();
        r96.getClass();
        r96.a(r28, "107", "" + r97, r37);
        r96.a(r28, "108", "" + (System.currentTimeMillis() / 1000), r37);
        return r93;
    L359:
        if (r90.intValue() >= 3600) goto L361;
    L416:
        return w3.a(r84.intValue() - 10010);
    L415:
        return w3.a(r84.intValue() - 30000);
    L413:
        return w3.a(r83);
    L375:
        return w3.a(-10007);
    L323:
        return new w3(r78, w3.j, r113, r113);
    L296:
        if (r76.getState() == NetworkInfo.State.CONNECTING) goto L301;
        if (r76.getState() != NetworkInfo.State.CONNECTED) goto L319;
    L301:
        if (r76.getType() != r37) goto L304;
    L318:
        r77 = r113;
        goto L320
    L304:
        if (r76.getType() == 0) goto L306;
        r77 = 3;
        goto L320
    L306:
        if (Proxy.getDefaultHost() != null) goto L311;
        if (Proxy.getHost(r28) != null) goto L311;
        r77 = r37;
    L311:
        r77 = 2;
    L313:
        th = move-exception;
        String r98 = th.getMessage();
        if (r98 == null) goto L319;
        if (r98.contains("ACCESS_NETWORK_STATE") == false) goto L319;
    L291:
        return w3.a(r73);
    L284:
        if (r60.length != 0) goto L286;
        r70 = w5.a(-10003);
        goto L288
    L286:
        r70 = new w5(r113, r60);
    L287:
        r70 = w5.a(-10006);
        goto L288
    L227:
        r52 = "0";
        goto L228
    L229:
        r113 = 0;
        goto L231
    L187:
        if (((ArrayList) r41).isEmpty() == true) goto L190;
        r42.addAll(r41);
        goto L190
    L181:
        if (r32.a(40) == true) goto L184;
        r40 = this;
        goto L195
    L150:
        r37 = r31;
        r111 = null;
        goto L151
    L134:
        long r99 = System.currentTimeMillis();
        r1.put("100", n9.a(r28).f551a);
        wj.a(20, System.currentTimeMillis() - r99);
        goto L135
    L130:
        r1.put("2023", "");
        goto L131
    L110:
        StringBuilder r100 = new StringBuilder();
        String[] r101 = r26.split(",");
        int r102 = r101.length;
        int r103 = 0;
    L111:
        if (r103 >= r102) goto L126;
        String[] r104 = r101[r103].split(":");
        if (r104.length != r25) goto L125;
        String r105 = a(Long.parseLong(r104[r11], 16), Long.parseLong(r104[1], 16));     // Catch: Throwable -> L379
        if (TextUtils.isEmpty(r105) == true) goto L125;
        if (r100.length() <= 0) goto L124;
        r100.append(",");
    L124:
        r100.append(r105);
    L125:
        r103 = r103 + 1;
        r25 = 2;
        r11 = 0;
        goto L111
    L126:
        r31 = true;
        r27 = r100.toString();
        goto L128
    L101:
        if (r20.a(ChipsView.HISTORY) == true) goto L104;
        r31 = true;
        goto L131
    L68:
        if (jd.a(r28, i) != 0) goto L403;
    L72:
        AtomicReference r106 = this.h;
        monitor-enter(r106);
        FutureTask r107 = (FutureTask) this.h.get();     // Catch: Throwable -> L94
        if (r107 != null) goto L77;
        r107 = new FutureTask(new s4(this));     // Catch: Throwable -> L94
        xh.b.submit(r107);     // Catch: Throwable -> L94
        this.h.set(r107);     // Catch: Throwable -> L94
    L77:
        monitor-exit(r106);     // Catch: Throwable -> L94
        ok.a r108 = (ok.a) r107.get(1, TimeUnit.SECONDS);     // Catch: Throwable -> L93
        if (r108 != null) goto L81;
        r1.put("2020", "-1");     // Catch: Throwable -> L93
    L383:
        goto L98
    L81:
        if (r108.b == true) goto L83;
    L86:
        StringBuilder r109 = new StringBuilder();     // Catch: Throwable -> L93
        if (r108.b == false) goto L89;
        String r119 = "1";
    L90:
        r1.put("2020", r109.append(r119).append(",").append(r108.f401a).toString());     // Catch: Throwable -> L93
        goto L383
    L89:
        r119 = "0";
        goto L90
    L83:
        if (r21.a("ig_g_a_l", false) == true) goto L86;
        r1.put("2020", "1");     // Catch: Throwable -> L93
    L93:
        r1.put("2020", "-3");
    L94:
        th = move-exception;
        throw th;
    L403:
        if (r28.getPackageManager().getApplicationInfo(r28.getPackageName(), 128).metaData.containsKey(j) == true) goto L72;
    L97:
        r1.put("2020", "-2");
        goto L98
    L392:
        r110 = Long.parseLong(r24);     // Catch: NumberFormatException -> L380
    L48:
        if (r20.a(17) == true) goto L52;
        if (r20.a(18) == true) goto L52;
        r1.put("1001", "2");
    L39:
        r19 = 0;
        goto L40
    L22:
        r13 = "0";
        goto L23
    L18:
        r10 = "0";
        goto L19
    L14:
        r6 = r5.f;
        goto L15
    L10:
        r4 = r3.p;
        goto L11
    L5:
        if (r2.u == false) goto L7;
        r1.put("2", "1");
        goto L7
    }

    public w3 a(Context r3) {
        AtomicReference r0 = this.f;
        monitor-enter(r0);
        w3 r1 = (w3) this.f.get();     // Catch: Throwable -> L14
        if (r1 != null) goto L12;
        d5 r2 = this.d;     // Catch: Throwable -> L14
        if (r2 == null) goto L10;
        w3 r4 = r2.a(r3);     // Catch: Throwable -> L14
    L9:
        r1 = r4;
        this.f.set(r1);     // Catch: Throwable -> L14
        goto L12
    L10:
        r4 = w3.a(1);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r1;
    L14:
        th = move-exception;
        throw th;
    }

    public final void a(w3 r2, boolean r3) {
        AtomicReference r0 = this.f;
        monitor-enter(r0);
        if (r2 != null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        if (r3 == false) goto L11;
    L14:
        this.f.set(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L11:
        if (r2.c == 0) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void a() {
        AtomicReference r0 = this.g;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (((Boolean) this.g.get()).booleanValue() == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        this.g.set(Boolean.TRUE);     // Catch: Throwable -> L11
        Message r1 = Message.obtain(this.b, 2, 3);     // Catch: Throwable -> L11
        this.b.sendMessageDelayed(r1, 0);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public final w3 a(Context r7, boolean r8, int r9) {
        w3 r0 = a(r7);
        if (this.f111a == null) goto L5;
        int r1 = a(r0);
        if (r1 != 1) goto L10;
        return r0;
    L10:
        if (r1 != 2) goto L48;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L15;
        a();
        return w3.a(-10008);
    L15:
        Object r3 = this.e;
        monitor-enter(r3);
        w3 r2 = a(r7);     // Catch: Throwable -> L44
        if (r2 != r0) goto L20;
    L23:
        AtomicReference r4 = this.g;     // Catch: Throwable -> L44
        monitor-enter(r4);     // Catch: Throwable -> L44
    L41:
        th = move-exception;
        throw th;     // Catch: Throwable -> L44
    L26:
        if (((Boolean) this.g.get()).booleanValue() == true) goto L55;
        this.g.set(Boolean.TRUE);     // Catch: Throwable -> L41
        this.b.post(new h4(this, r7, true, r9));     // Catch: Throwable -> L41
    L55:
        AtomicReference r10 = this.g;     // Catch: InterruptedException -> L51 Throwable -> L41
        if (r8 == false) goto L31;
        long r5 = this.f111a.v;     // Catch: InterruptedException -> L51 Throwable -> L41
    L32:
        r10.wait(r5);     // Catch: InterruptedException -> L51 Throwable -> L41
        goto L33
    L31:
        r5 = WorkRequest.MIN_BACKOFF_MILLIS;
    L33:
        monitor-exit(r4);     // Catch: Throwable -> L41
        r2 = a(r7);     // Catch: Throwable -> L44
        if (r2 == r0) goto L38;
        monitor-exit(r3);     // Catch: Throwable -> L44
    L40:
        return r2;
    L38:
        r2 = w3.a(-10004);     // Catch: Throwable -> L44
        monitor-exit(r3);     // Catch: Throwable -> L44
        goto L40
    L20:
        if (a(r2) != 1) goto L23;
        monitor-exit(r3);     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        throw th;
    L48:
        if (r1 != 3) goto L50;
        a();
    L50:
        return r0;
    L5:
        return w3.a(-10002);
    }

    public final int a(w3 r8) {
        if (this.f111a.r == false) goto L6;
        return 2;
    L6:
        if (r8.c == 0) goto L8;
    L38:
        return 2;
    L8:
        if (TextUtils.isEmpty(r8.f594a) == true) goto L38;
        long r0 = System.currentTimeMillis() / 1000;
        if (r0 < r8.b) goto L14;
        this.f111a.getClass();
        return 3;
    L14:
        d5 r9 = this.d;
        monitor-enter(mh.class);
        Context r4 = mh.f353a;     // Catch: Throwable -> L35
        monitor-exit(mh.class);
        r9.getClass();
        long r3 = Long.valueOf(d5.b(r4, "107")).longValue();     // Catch: Throwable -> L21
    L22:
        d5 r10 = this.d;
        monitor-enter(mh.class);
        Context r6 = mh.f353a;     // Catch: Throwable -> L32
        monitor-exit(mh.class);
        if (Math.abs(r0 - r10.a(r6, "108")) < r3) goto L30;
        this.f111a.getClass();
        return 3;
    L30:
        return 1;
    L32:
        th = move-exception;
        throw th;
    L21:
        r3 = 0;
    L35:
        th = move-exception;
        throw th;
    }

    public final w3 a(Context r17, boolean r18, boolean r19, int r20) {
        if (ia.b(r17) == true) goto L7;
        return w3.a(-10012);
    L7:
        if (this.f111a.r == false) goto L9;
    L68:
        d5 r0 = this.d;
        monitor-enter(mh.class);
        Context r9 = mh.f353a;     // Catch: Throwable -> L139
        monitor-exit(mh.class);
        e4 r1 = r0.a(r9, 30);
        r1.a(Long.valueOf(System.currentTimeMillis()));
        d5 r4 = this.d;
        monitor-enter(mh.class);
        Context r10 = mh.f353a;     // Catch: Throwable -> L135
        monitor-exit(mh.class);
        r4.getClass();
        StringBuilder r8 = new StringBuilder();
        int r11 = 0;
    L78:
        if (r11 >= r1.b.size()) goto L83;
        r8.append(r1.b.get(r11));
        if (r11 == (r1.b.size() - 1)) goto L82;
        r8.append("_");
    L82:
        r11 = r11 + 1;
        goto L78
    L83:
        r4.a(r10, "402", r8.toString(), true);
        monitor-enter(id.class);
        String r2 = id.a(r17, id.f271a);     // Catch: Throwable -> L132
        monitor-exit(id.class);
        if (TextUtils.isEmpty(r2) == true) goto L90;
        this.d.a(r17, "404", r2, true);
    L90:
        i8.a(r17, this.d);
        d5 r3 = this.d;
        long r12 = r3.a(r17, "502");
        int r5 = Process.myUid();
        if (r12 != 0) goto L93;
        r3.c(r17, 0);
    L99:
        if (o5.f.a("e_b_d", false) == false) goto L149;
        SparseArray r6 = new SparseArray();
        TNative$aa.c90_A43184BF099FF466(r6, r17);
        ca.b(r6);
    L149:
        w3 r7 = b(r17, r18, r20);     // Catch: Throwable -> L104
    L107:
        if (r7.c != (-30015)) goto L110;
        d5 r13 = this.d;
        long r14 = System.currentTimeMillis();
        r13.getClass();
        r13.a(r17, "109", "" + r14, true);
    L112:
        this.d.getClass();
        long r15 = Long.valueOf(d5.b(r17, "401")).longValue();     // Catch: Throwable -> L115
    L117:
        if (r7.c >= 0) goto L120;
        this.d.a(r17, r15 + 1);
    L122:
        this.d.getClass();
        if (TextUtils.isEmpty(d5.b(r17, "404")) == true) goto L126;
        this.d.a(r17, "404", "", true);
    L126:
        if (r7.c != 0) goto L130;
        d5 r16 = this.d;
        String r21 = i8.f266a;
        long r22 = r16.a(r17, "502");
        long r110 = Process.myUid();
        if (r22 == r110) goto L130;
        r16.a(r17, "502", "" + r110, false);
    L130:
        this.d.a(r17, "204", String.format("%d_%d_%d_%d_%d_%d", new Object[]{Integer.valueOf(r7.c), Integer.valueOf(r18 ? 1 : 0), Integer.valueOf(r20), 0, Integer.valueOf(r7.h), Integer.valueOf(r7.i)}));
        return r7;
    L120:
        if (r15 == 0) goto L122;
        this.d.a(r17, 0);
    L115:
        r15 = 0;
        goto L117
    L110:
        if (this.d.a(r17, "109") == 0) goto L112;
        d5 r23 = this.d;
        r23.getClass();
        r23.a(r17, "109", "0", true);
    L104:
        th = move-exception;
        Log.w("TuringFdJava", th);
        r7 = w3.a(-10015);
        goto L107
    L93:
        if (r12 != 0) goto L95;
    L97:
        r3.c(r17, 1);
        goto L99
    L95:
        if (r5 == r12) goto L97;
        r3.c(r17, -1);
    L132:
        th = move-exception;
        throw th;
    L135:
        th = move-exception;
        throw th;
    L139:
        th = move-exception;
        throw th;
    L9:
        monitor-enter(mh.class);
        Context r24 = mh.f353a;     // Catch: Throwable -> L64
        monitor-exit(mh.class);
        if (Math.abs((System.currentTimeMillis() / 1000) - (this.d.a(r24, "109") / 1000)) <= TimeUtils.SECONDS_PER_HOUR) goto L15;
        d5 r25 = this.d;
        monitor-enter(mh.class);
        Context r26 = mh.f353a;     // Catch: Throwable -> L60
        monitor-exit(mh.class);
        e4 r27 = r25.a(r26, 30);
        if (r27.b.size() == 0) goto L68;
        d5 r28 = this.d;
        monitor-enter(mh.class);
        Context r111 = mh.f353a;     // Catch: Throwable -> L56
        monitor-exit(mh.class);
        r28.getClass();
        long r29 = Long.valueOf(d5.b(r111, "401")).longValue();     // Catch: Throwable -> L30
    L32:
        if (r29 <= 0) goto L46;
        long r112 = Math.abs(System.currentTimeMillis() - ((Long) r27.b.getLast()).longValue());
        int[] r113 = n;
        if (r29 >= r113.length) goto L37;
        int r30 = (int) r29;
    L38:
        if (r30 < 1) goto L46;
        int r31 = r113[r30 - 1];
        int r32 = r113[r30];
        if (r31 >= r32) goto L55;
        if (r112 > TimeUnit.SECONDS.toMillis(new Random().nextInt((r32 - r31) + 1) + r31)) goto L46;
        if (r19 == true) goto L68;
    L53:
        return w3.a(-10011);
    L55:
        throw new IllegalArgumentException("");
    L37:
        r30 = r113.length - 1;
    L46:
        Long r33 = (Long) r27.b.getFirst();
        if (r27.b.size() < r27.f171a) goto L68;
        if (Math.abs(System.currentTimeMillis() - r33.longValue()) < m) goto L53;
    L30:
        r29 = 0;
    L56:
        th = move-exception;
        throw th;
    L60:
        th = move-exception;
        throw th;
    L15:
        return w3.a(-30015);
    L64:
        th = move-exception;
        throw th;
    }

    public static String a(long r2, long r4) {
        UUID r1 = new UUID(r2, r4);     // Catch: Throwable -> L11
        MediaDrm r3 = new MediaDrm(r1);     // Catch: Throwable -> L11
        byte[] r5 = r3.getPropertyByteArray("deviceUniqueId");     // Catch: Throwable -> L17
        if (r5.length == 0) goto L21;
        String r6 = r1 + ":" + z1.a(r5);     // Catch: Throwable -> L17
        r3.close();     // Catch: Throwable -> L15
    L10:
        return r6;
    L21:
        r3.close();     // Catch: Throwable -> L16
    L7:
        return null;
    L12:
        if (r3 != null) goto L27;
    L14:
        return null;
    L27:
        r3.close();     // Catch: Throwable -> L18
    L11:
        r3 = null;
        goto L12
    }
}
