package com.loc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import androidx.core.location.LocationRequestCompat;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"NewApi"})
public final class q4 {
    protected static String Q;
    protected static String R;
    protected ArrayList<b4> A;
    protected ArrayList<b4> B;
    protected String C;
    protected String D;
    protected ArrayList<i3> E;
    protected String F;
    protected String G;
    protected byte[] H;
    private byte[] I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private int f7635J;
    protected String K;
    protected String L;
    protected String M;
    protected int N;
    private List<d4> O;
    private List<b4> P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected short f7637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected String f7638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected String f7639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected String f7640e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected String f7641f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected String f7642g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f7643h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f7644i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected String f7645j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected String f7646k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected String f7647l;
    protected String m;
    protected String n;
    protected String o;
    protected String p;
    protected String q;
    protected String r;
    protected String s;
    protected String t;
    protected String u;
    protected String v;
    protected String w;
    protected String x;
    protected String y;
    protected int z;

    static {
    }

    public q4() {
        this.f7636a = LocationInfoConst.ALLOW_USE_LOCATION;
        this.f7637b = 0;
        this.f7638c = null;
        this.f7639d = null;
        this.f7640e = null;
        this.f7641f = null;
        this.f7642g = null;
        this.f7643h = null;
        this.f7644i = null;
        this.f7645j = null;
        this.f7646k = null;
        this.f7647l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = 0;
        this.A = new ArrayList();
        this.B = new ArrayList();
        this.C = null;
        this.D = null;
        this.E = new ArrayList();
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.f7635J = 0;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = 0;
        this.O = null;
        this.P = Collections.synchronizedList(new ArrayList());
    }

    private static int a(String r3, byte[] r4, int r5) {
    L11:
        th = move-exception;
        s4.h(th, "Req", "copyContentWithByteLen");
        r4[r5] = 0;
    L14:
        return r5 + 1;
    L4:
        if (TextUtils.isEmpty(r3) == false) goto L6;
        r4[r5] = 0;     // Catch: Throwable -> L11
        goto L14
    L6:
        byte[] r6 = r3.getBytes("GBK");     // Catch: Throwable -> L11
        int r1 = r6.length;     // Catch: Throwable -> L11
        if (r1 <= 127) goto L9;
        r1 = 127;
    L9:
        r4[r5] = (byte) r1;     // Catch: Throwable -> L11
        int r7 = r5 + 1;     // Catch: Throwable -> L11
        System.arraycopy(r6, 0, r4, r7, r1);     // Catch: Throwable -> L11
        return r7 + r1;
    }

    private static void c(b4 r9, List<b4> r10) {
        if (r9 == null) goto L37;
        if (r10 == null) goto L41;
        int r0 = r10.size();
        if (r0 != 0) goto L9;
        r10.add(r9);
        return;
    L9:
        long r1 = LocationRequestCompat.PASSIVE_INTERVAL;
        int r3 = 0;
        int r4 = -1;
        int r5 = -1;
    L10:
        if (r3 >= r0) goto L22;
        b4 r6 = r10.get(r3);
        if (r9.c() != null) goto L14;
    L18:
        r1 = Math.min(r1, r6.t);
        if (r1 != r6.t) goto L21;
        r5 = r3;
    L21:
        r3 = r3 + 1;
        goto L10
    L14:
        if (r9.c().equals(r6.c()) == false) goto L18;
        int r7 = r9.s;
        if (r7 == r6.s) goto L23;
        r6.t = r9.t;
        r6.s = r7;
    L23:
        if (r4 >= 0) goto L25;
        return;
    L25:
        if (r0 >= 3) goto L29;
        r10.add(r9);
        return;
    L29:
        if (r9.t <= r1) goto L39;
        if (r4 >= r0) goto L40;
        r10.remove(r4);
        r10.add(r9);
        return;
    L40:
        return;
    L39:
        return;
    L22:
        r4 = r5;
        goto L23
    L41:
        return;
    }

    private void d(ArrayList<b4> r3, ArrayList<b4> r4) {
        if (r4 != null) goto L4;
    L14:
        if (r3 != null) goto L16;
        return;
    L16:
        if (r3.size() <= 0) goto L26;
        c(r3.get(0), this.P);
        return;
    L26:
        return;
    L4:
        if (r4.size() <= 0) goto L14;
        Iterator<b4> r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L14;
        b4 r0 = r5.next();
        if (r0.r == false) goto L7;
        if (r0.n == false) goto L7;
        c(r0, this.P);
    }

    private byte[] f(String r7) {
        String[] r0 = r7.split(":");
        byte[] r2 = new byte[6];
        if (r0 != null) goto L20;
    L6:
        r0 = new String[6];     // Catch: Throwable -> L17
        int r4 = 0;
    L7:
        if (r4 >= 6) goto L9;
        r0[r4] = BDLocationException.ERROR_TIMEOUT;     // Catch: Throwable -> L17
        r4 = r4 + 1;     // Catch: Throwable -> L17
    L9:
        int r1 = 0;
    L10:
        if (r1 >= r0.length) goto L24;
        if (r0[r1].length() <= 2) goto L15;
        r0[r1] = r0[r1].substring(0, 2);     // Catch: Throwable -> L17
    L15:
        r2[r1] = (byte) Integer.parseInt(r0[r1], 16);     // Catch: Throwable -> L17
        r1 = r1 + 1;
        goto L10
    L24:
        return r2;
    L17:
        th = move-exception;
        s4.h(th, "Req", "getMacBa ".concat(String.valueOf(r7)));
        return f("00:00:00:00:00:00");
    L20:
        if (r0.length == 6) goto L9;
        goto L6
    }

    private void g() {
        String[] r1 = new String[27];
        r1[0] = this.f7636a;
        r1[1] = this.f7638c;
        r1[2] = this.f7639d;
        r1[3] = this.f7640e;
        r1[4] = this.f7641f;
        r1[5] = this.f7642g;
        r1[6] = this.f7643h;
        r1[7] = this.f7644i;
        r1[8] = this.f7647l;
        r1[9] = this.m;
        r1[10] = this.n;
        r1[11] = this.o;
        r1[12] = this.p;
        r1[13] = this.q;
        r1[14] = this.r;
        r1[15] = this.s;
        r1[16] = this.t;
        r1[17] = this.u;
        r1[18] = this.v;
        r1[19] = this.w;
        r1[20] = this.x;
        r1[21] = this.D;
        r1[22] = this.F;
        r1[23] = this.G;
        r1[24] = Q;
        r1[25] = this.L;
        r1[26] = this.M;
        int r2 = 0;
    L3:
        if (r2 >= 27) goto L9;
        if (TextUtils.isEmpty(r1[r2]) == false) goto L7;
        r1[r2] = "";
    L7:
        r2 = r2 + 1;
        goto L3
    L9:
        if (TextUtils.isEmpty(this.f7645j) == false) goto L12;
    L10:
        this.f7645j = BDLocationException.ERROR_TIMEOUT;
    L17:
        if (TextUtils.isEmpty(this.f7646k) == false) goto L20;
    L18:
        this.f7646k = BDLocationException.ERROR_TIMEOUT;
    L25:
        if (TextUtils.isEmpty(this.y) == false) goto L28;
    L26:
        this.y = BDLocationException.ERROR_TIMEOUT;
    L33:
        if (c4.p(this.z) == true) goto L36;
        this.z = 0;
    L36:
        if (this.H != null) goto L42;
        this.H = new byte[0];
        return;
    L42:
        return;
    L28:
        if (LocationInfoConst.ALLOW_USE_LOCATION.equals(this.y) == true) goto L33;
        if ("2".equals(this.y) == true) goto L33;
    L20:
        if (BDLocationException.ERROR_TIMEOUT.equals(this.f7646k) == true) goto L25;
        if (LocationInfoConst.ALLOW_USE_LOCATION.equals(this.f7646k) == true) goto L25;
    L12:
        if (BDLocationException.ERROR_TIMEOUT.equals(this.f7645j) == true) goto L17;
        if ("2".equals(this.f7645j) == true) goto L17;
        goto L10
    }

    public final void b(Context r19, boolean r20, boolean r21, c4 r22, g4 r23, ConnectivityManager r24, String r25, e4 r26) {
        int r2 = Build.VERSION.SDK_INT;
        String r3 = i5.j(r19);
        int r4 = a5.O();
        this.K = r25;
        this.O = null;
        if (r21 == true) goto L5;
        String r0 = "UC_nlp_20131029";
        String r6 = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U";
    L6:
        String r7 = r6;
        String r8 = r0;
        StringBuilder r9 = new StringBuilder();
        int r10 = r22.B();
        int r1 = r22.C();
        TelephonyManager r11 = r22.D();
        ArrayList<b4> r12 = r22.v();
        ArrayList<b4> r13 = r22.w();
        ArrayList<i3> r14 = r23.p();
        if (r1 != 2) goto L9;
        String r16 = LocationInfoConst.ALLOW_USE_LOCATION;
    L11:
        if (r11 != null) goto L13;
        String r17 = LocationInfoConst.ALLOW_USE_LOCATION;
    L117:
        NetworkInfo r5 = r24.getActiveNetworkInfo();     // Catch: Throwable -> L36
    L38:
        boolean r15 = r23.h(r24);
        if (a5.e(r5) == (-1)) goto L44;
        String r18 = a5.j(r24);
        if (r15 == false) goto L43;
        String r110 = "2";
    L46:
        if ((r10 & 4) == 4) goto L48;
    L50:
        this.B.clear();
    L51:
        this.A.clear();
        this.A.addAll(r12);
        StringBuilder r27 = new StringBuilder();
        if (r23.v() == false) goto L73;
        if (r15 == false) goto L69;
        WifiInfo r28 = r23.x();
        if (g4.i(r28) == false) goto L69;
        r27.append(r28.getBSSID());
        r27.append(",");
        int r111 = r28.getRssi();
        if (r111 >= (-128)) goto L60;
    L58:
        r111 = 0;
    L62:
        r27.append(r111);
        r27.append(",");
        String r112 = r28.getSSID();
        int r29 = r28.getSSID().getBytes("UTF-8").length;     // Catch: Exception -> L65
    L66:
        if (r29 < 32) goto L68;
        r112 = "unkwn";
    L68:
        r27.append(r112.replace("*", "."));
    L65:
        r29 = 32;
        goto L66
    L60:
        if (r111 <= 127) goto L62;
    L69:
        if (r14 == null) goto L76;
        ArrayList<i3> r30 = this.E;
        if (r30 == null) goto L76;
        r30.clear();
        this.E.addAll(r14);
    L76:
        this.f7637b = 0;
        if (r20 == true) goto L79;
        this.f7637b = (short) (2 | 0);
    L79:
        this.f7638c = r8;
        this.f7639d = r7;
        this.f7641f = Build.MODEL;
        this.f7642g = "android" + Build.VERSION.RELEASE;
        this.f7643h = a5.C(r19);
        this.f7644i = r16;
        this.f7645j = BDLocationException.ERROR_TIMEOUT;
        this.f7646k = BDLocationException.ERROR_TIMEOUT;
        this.f7647l = BDLocationException.ERROR_TIMEOUT;
        this.m = BDLocationException.ERROR_TIMEOUT;
        this.n = BDLocationException.ERROR_TIMEOUT;
        this.o = r3;
        this.p = s4.f7774g;
        this.q = s4.f7775h;
        this.s = String.valueOf(r4);
        this.t = a5.a0(r19);
        this.v = "6.4.0";
        this.w = null;
        this.u = "";
        this.x = r18;
        this.y = r110;
        this.z = r10;
        this.C = r22.G();
        this.F = g4.A();
        this.D = r27.toString();
        this.N = (int) ((a5.A() - r23.B()) / 1000);
        if (TextUtils.isEmpty(Q) == false) goto L109;
        Q = l5.F(r19);     // Catch: Throwable -> L99
    L109:
        if (TextUtils.isEmpty(R) == false) goto L105;
        R = l5.p(r19);     // Catch: Throwable -> L100
    L105:
        if (TextUtils.isEmpty(this.L) == false) goto L103;
        this.L = l5.E();     // Catch: Throwable -> L101
    L103:
        if (TextUtils.isEmpty(this.M) == false) goto L107;
        this.M = l5.D(r19);     // Catch: Throwable -> L102
    L107:
        this.O = r26.a(this.B, this.E);     // Catch: Throwable -> L94
        d(this.A, this.B);     // Catch: Throwable -> L94
    L96:
        r9.delete(0, r9.length());
        r27.delete(0, r27.length());
        return;
    L94:
        th = move-exception;
        th.printStackTrace();
        goto L96
    L73:
        r23.r();
        ArrayList<i3> r31 = this.E;
        if (r31 == null) goto L76;
        r31.clear();
        goto L76
    L48:
        if (r13.isEmpty() == true) goto L50;
        this.B.clear();
        this.B.addAll(r13);
        goto L51
    L43:
        r110 = r17;
        goto L46
    L44:
        r18 = "";
        r110 = r18;
    L36:
        th = move-exception;
        s4.h(th, "Aps", "getApsReq part");
        r5 = null;
        goto L38
    L13:
        if (TextUtils.isEmpty(s4.f7774g) == true) goto L113;
    L18:
        boolean r32 = TextUtils.isEmpty(s4.f7774g);
        r17 = LocationInfoConst.ALLOW_USE_LOCATION;
        if (r32 == false) goto L23;
        if (r2 >= 29) goto L23;
        s4.f7774g = "888888888888888";
    L23:
        if (TextUtils.isEmpty(s4.f7775h) == false) goto L29;
        s4.f7775h = l5.U();     // Catch: Throwable -> L26 SecurityException -> L98
    L26:
        th = move-exception;
        s4.h(th, "Aps", "getApsReq part2");
    L29:
        if (TextUtils.isEmpty(s4.f7775h) == false) goto L117;
        if (r2 >= 29) goto L117;
        s4.f7775h = "888888888888888";
        goto L117
    L113:
        s4.f7774g = l5.P();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        s4.h(th, "Aps", "getApsReq part4");
        goto L18
    L9:
        r16 = BDLocationException.ERROR_TIMEOUT;
        goto L11
    L5:
        r0 = "api_serverSDK_130905";
        r6 = "S128DF1572465B890OE3F7A13167KLEI";
        goto L6
    }

    public final byte[] e() {
        g();
        int r3 = 2;
        byte[] r4 = new byte[2];
        byte[] r6 = new byte[4];
        byte[] r0 = this.H;
        int r7 = 4096;
        int r8 = 1;
        if (r0 == null) goto L5;
        r7 = 4096 + (r0.length + 1);
    L5:
        byte[] r1 = this.I;
        if (r1 != null) goto L8;
    L9:
        r1 = new byte[r7];
        this.I = r1;
        this.f7635J = r7;
    L10:
        byte[] r9 = r1;
        int r10 = 0;
        r9[0] = a5.W(this.f7636a);
        byte[] r11 = null;
        byte[] r2 = a5.u(this.f7637b, null);
        System.arraycopy(r2, 0, r9, 1, r2.length);
        int r12 = a(this.q, r9, a(this.p, r9, a(this.f7643h, r9, a(this.u, r9, a(this.f7642g, r9, a(this.f7641f, r9, a(this.f7640e, r9, a(this.o, r9, a(this.f7639d, r9, a(this.f7638c, r9, r2.length + 1))))))))));
    L16:
        th = move-exception;
        s4.h(th, "Req", "buildV4Dot219");
        r9[r12] = 0;
    L18:
        int r13 = r12 + 1;
    L19:
        int r5 = a(this.x, r9, a(R, r9, a(Q, r9, a(this.w, r9, a(this.v, r9, r13)))));
        r9[r5] = Byte.parseByte(this.y);
        int r14 = r5 + 1;
        r9[r14] = Byte.parseByte(this.f7645j);
        int r15 = r14 + 1;
        int r16 = this.z;
        int r17 = r16 & 3;
        r9[r15] = (byte) r16;
        int r18 = r15 + 1;
        long r19 = 0;
        if (r17 == 1) goto L25;
        if (r17 == 2) goto L25;
        r6 = r6;
    L128:
        String r20 = this.C;
        if (r20 != null) goto L131;
    L134:
        r9[r18] = 0;
        int r21 = r18 + 1;
    L135:
        ArrayList<b4> r22 = this.B;
        int r23 = r22.size();
        int r110 = 5;
        int r111 = 3;
        if ((this.z & 4) != 4) goto L200;
        if (r23 <= 0) goto L200;
        r22.get(0);
        r9[r21] = (byte) r23;
        byte r112 = 1;
        int r24 = r21 + 1;
        int r113 = 0;
    L139:
        if (r113 >= r23) goto L199;
        b4 r114 = r22.get(r113);
        int r115 = r114.f7195l;
        if (r115 == r112) goto L158;
        if (r115 == r111) goto L158;
        if (r115 == 4) goto L158;
        if (r115 != r3) goto L151;
        byte r116 = (byte) r115;
        if (r114.n == false) goto L150;
        r116 = (byte) (r116 | 8);
    L150:
        r9[r24] = r116;
        int r25 = r24 + 1;
        byte[] r117 = a5.u(r114.f7184a, r4);
        System.arraycopy(r117, 0, r9, r25, r117.length);
        int r26 = r25 + r117.length;
        byte[] r118 = a5.u(r114.f7191h, r4);
        System.arraycopy(r118, 0, r9, r26, r118.length);
        int r27 = r26 + r118.length;
        byte[] r119 = a5.u(r114.f7192i, r4);
        System.arraycopy(r119, 0, r9, r27, r119.length);
        int r28 = r27 + r119.length;
        byte[] r120 = a5.u(r114.f7193j, r4);
        System.arraycopy(r120, 0, r9, r28, r120.length);
        int r29 = r28 + r120.length;
        byte[] r121 = r6;
        byte[] r122 = a5.G(r114.f7190g, r121);
        System.arraycopy(r122, 0, r9, r29, r122.length);
        int r30 = r29 + r122.length;
        byte[] r123 = a5.G(r114.f7189f, r121);
        System.arraycopy(r123, 0, r9, r30, r123.length);
        r24 = r30 + r123.length;
        byte[] r31 = r121;
    L162:
        int r32 = r114.f7194k;
        if (r32 <= 127) goto L166;
    L164:
        r32 = 99;
    L168:
        r9[r24] = (byte) r32;
        int r33 = r24 + 1;
        byte[] r34 = a5.u((short) ((a5.A() - r114.t) / 1000), r4);
        System.arraycopy(r34, 0, r9, r33, r34.length);
        r24 = r33 + r34.length;
        int r35 = r114.f7195l;
        int r124 = 32767;
        if (r35 == 3) goto L188;
        if (r35 == 4) goto L188;
        if (r35 == 5) goto L188;
        if (r35 != 1) goto L198;
        if (Double.valueOf(s4.f7768a).doubleValue() < 5.3d) goto L198;
        int r36 = r114.o;
        if (r36 <= 32767) goto L182;
        r36 = 32767;
    L182:
        if (r36 < 0) goto L185;
        r124 = r36;
    L185:
        byte[] r37 = a5.u(r124, r4);
        System.arraycopy(r37, 0, r9, r24, r37.length);
        int r38 = r24 + r37.length;
        byte[] r39 = a5.G(r114.p, r31);
        System.arraycopy(r39, 0, r9, r38, r39.length);
        int r40 = r38 + r39.length;
        byte[] r41 = a5.G(r114.q, r31);
        System.arraycopy(r41, 0, r9, r40, r41.length);
        int r42 = r41.length;
    L186:
        r24 = r40 + r42;
    L198:
        r113 = r113 + 1;
        r6 = r31;
        r23 = r23;
        r3 = 2;
        r112 = 1;
        r111 = 3;
        r110 = 5;
    L188:
        if (Double.valueOf(s4.f7768a).doubleValue() < 5.0d) goto L198;
        int r43 = r114.o;
        if (r43 <= 32767) goto L192;
        r43 = 32767;
    L192:
        if (r43 < 0) goto L195;
        r124 = r43;
    L195:
        byte[] r44 = a5.u(r124, r4);
        System.arraycopy(r44, 0, r9, r24, r44.length);
        r24 = r24 + r44.length;
        if (Double.valueOf(s4.f7768a).doubleValue() < 5.3d) goto L198;
        byte[] r45 = a5.G(r114.p, r31);
        System.arraycopy(r45, 0, r9, r24, r45.length);
        r40 = r24 + r45.length;
        byte[] r46 = a5.G(r114.q, r31);
        System.arraycopy(r46, 0, r9, r40, r46.length);
        r42 = r46.length;
        goto L186
    L166:
        if (r32 >= (-128)) goto L168;
    L151:
        r31 = r6;
        if (r115 != r110) goto L162;
        byte r125 = (byte) r115;
        if (r114.n == false) goto L156;
        r125 = (byte) (r125 | 8);
    L156:
        r9[r24] = r125;
        int r47 = r24 + 1;
        byte[] r126 = a5.u(r114.f7184a, r4);
        System.arraycopy(r126, 0, r9, r47, r126.length);
        int r48 = r47 + r126.length;
        byte[] r127 = a5.u(r114.f7185b, r4);
        System.arraycopy(r127, 0, r9, r48, r127.length);
        int r49 = r48 + r127.length;
        byte[] r128 = a5.u(r114.f7186c, r4);
        System.arraycopy(r128, 0, r9, r49, r128.length);
        int r50 = r49 + r128.length;
        System.arraycopy(a5.v(r114.f7188e), 0, r9, r50, 8);
        r24 = r50 + 8;
    L158:
        r31 = r6;
        byte r51 = (byte) r115;
        if (r114.n == false) goto L161;
        r51 = (byte) (r51 | 8);
    L161:
        r9[r24] = r51;
        int r52 = r24 + 1;
        byte[] r53 = a5.u(r114.f7184a, r4);
        System.arraycopy(r53, 0, r9, r52, r53.length);
        int r54 = r52 + r53.length;
        byte[] r55 = a5.u(r114.f7185b, r4);
        System.arraycopy(r55, 0, r9, r54, r55.length);
        int r56 = r54 + r55.length;
        byte[] r57 = a5.u(r114.f7186c, r4);
        System.arraycopy(r57, 0, r9, r56, r57.length);
        int r58 = r56 + r57.length;
        byte[] r59 = a5.G(r114.f7187d, r31);
        System.arraycopy(r59, 0, r9, r58, r59.length);
        r24 = r58 + r59.length;
        goto L162
    L199:
        byte[] r60 = r6;
        byte r61 = r112;
    L202:
        if (TextUtils.isEmpty(this.D) == false) goto L204;
    L229:
        int r62 = r61;
        byte r63 = 0;
        r9[r24] = 0;
        int r64 = r24 + 1;
    L230:
        ArrayList<i3> r65 = this.E;
        int r129 = Math.min(r65.size(), 25);
        if (r129 != 0) goto L233;
        r9[r64] = r63;
        int r66 = r64 + r62;
        byte r130 = 0;
    L260:
        r9[r66] = r130;
        int r67 = 1;
        int r68 = r66 + 1;
        String r69 = this.G;     // Catch: Throwable -> L271
        if (r69 != null) goto L264;
        r9[r68] = r130;     // Catch: Throwable -> L271
    L272:
        int r70 = r68 + r67;
    L273:
        byte[] r71 = {0, 0};
        boolean r72 = TextUtils.isEmpty(this.K);     // Catch: Throwable -> L285
        if (r72 == true) goto L388;
        r71 = a5.u(this.K.length(), r4);     // Catch: Throwable -> L285
    L388:
        System.arraycopy(r71, 0, r9, r70, 2);     // Catch: Throwable -> L284
        int r73 = r70 + 2;
        if (r72 == false) goto L384;
    L283:
        int r74 = 2;
    L394:
        System.arraycopy(a5.u(0, r4), 0, r9, r73, r74);     // Catch: Throwable -> L379
    L289:
        int r75 = r73 + r74;
        byte[] r76 = new byte[r74];
        r76 = {x0916: FILL_ARRAY_DATA , data: [0, 0} // fill-array;
        System.arraycopy(r76, 0, r9, r75, r74);     // Catch: Throwable -> L380
    L291:
        int r77 = r75 + r74;
        byte[] r78 = this.H;
        if (r78 == null) goto L294;
        int r79 = r78.length;
    L295:
        byte[] r80 = a5.u(r79, null);
        System.arraycopy(r80, 0, r9, r77, r80.length);
        int r81 = r77 + r80.length;
        if (r79 <= 0) goto L299;
        byte[] r82 = this.H;
        System.arraycopy(r82, 0, r9, r81, r82.length);
        r81 = r81 + this.H.length;
    L299:
        if (Double.valueOf(s4.f7768a).doubleValue() < 5.0d) goto L356;
        List<b4> r83 = this.P;
        if (r83 == null) goto L303;
        int r84 = r83.size();
    L304:
        r9[r81] = (byte) r84;
        int r85 = r81 + 1;
        byte[] r86 = new byte[r85];
        System.arraycopy(r9, 0, r86, 0, r85);
        if (r84 > 0) goto L382;
    L354:
        r81 = a(this.L, r9, r85);
        goto L356
    L382:
        Iterator<b4> r87 = this.P.iterator();     // Catch: Throwable -> L352
        int r88 = r85;
    L307:
        if (r87.hasNext() == false) goto L351;
        b4 r89 = r87.next();     // Catch: Throwable -> L352
        int r131 = r89.f7195l;     // Catch: Throwable -> L352
        if (r131 != 1) goto L312;
    L335:
        byte r132 = (byte) r131;
        if (r89.n == false) goto L339;
        r132 = (byte) (r132 | 8);     // Catch: Throwable -> L352
    L339:
        r9[r88] = r132;     // Catch: Throwable -> L352
        int r90 = r88 + 1;     // Catch: Throwable -> L352
        byte[] r133 = a5.u(r89.f7186c, r4);     // Catch: Throwable -> L352
        System.arraycopy(r133, 0, r9, r90, r133.length);     // Catch: Throwable -> L350
        int r91 = r90 + r133.length;     // Catch: Throwable -> L350
        byte[] r134 = a5.G(r89.f7187d, r60);     // Catch: Throwable -> L350
        System.arraycopy(r134, 0, r9, r91, r134.length);     // Catch: Throwable -> L350
        int r135 = r134.length;     // Catch: Throwable -> L352
    L343:
        r88 = r91 + r135;     // Catch: Throwable -> L352
    L344:
        byte[] r92 = a5.u((short) ((a5.A() - r89.t) / 1000), r4);     // Catch: Throwable -> L352
        System.arraycopy(r92, 0, r9, r88, r92.length);     // Catch: Throwable -> L349
        r88 = r88 + r92.length;
    L349:
        byte r93 = 0;
    L353:
        System.arraycopy(r86, r93, r9, r93, r85);
        r9[r85 - 1] = r93;
    L350:
        r93 = 0;
        goto L353
    L312:
        if (r131 == 3) goto L335;
        if (r131 == 4) goto L335;
        if (r131 != 2) goto L327;
        byte r136 = (byte) r131;     // Catch: Throwable -> L352
        if (r89.n == false) goto L321;
        r136 = (byte) (r136 | 8);     // Catch: Throwable -> L352
    L321:
        r9[r88] = r136;     // Catch: Throwable -> L352
        int r94 = r88 + 1;     // Catch: Throwable -> L352
        byte[] r137 = a5.u(r89.f7191h, r4);     // Catch: Throwable -> L352
        System.arraycopy(r137, 0, r9, r94, r137.length);     // Catch: Throwable -> L325
        int r95 = r94 + r137.length;     // Catch: Throwable -> L325
        byte[] r138 = a5.u(r89.f7192i, r4);     // Catch: Throwable -> L325
        System.arraycopy(r138, 0, r9, r95, r138.length);     // Catch: Throwable -> L325
        r91 = r95 + r138.length;     // Catch: Throwable -> L325
        byte[] r139 = a5.u(r89.f7193j, r4);     // Catch: Throwable -> L325
        System.arraycopy(r139, 0, r9, r91, r139.length);     // Catch: Throwable -> L325
        r135 = r139.length;     // Catch: Throwable -> L352
    L325:
        r93 = 0;
        goto L353
    L327:
        if (r131 != 5) goto L344;
        byte r140 = (byte) r131;     // Catch: Throwable -> L352
        if (r89.n == false) goto L331;
        r140 = (byte) (r140 | 8);     // Catch: Throwable -> L352
    L331:
        r9[r88] = r140;     // Catch: Throwable -> L352
        int r96 = r88 + 1;     // Catch: Throwable -> L352
        byte[] r141 = a5.u(r89.f7186c, r4);     // Catch: Throwable -> L352
        System.arraycopy(r141, 0, r9, r96, r141.length);     // Catch: Throwable -> L349
        int r97 = r96 + r141.length;     // Catch: Throwable -> L349
        System.arraycopy(a5.v(r89.f7188e), 0, r9, r97, 8);     // Catch: Throwable -> L349
        r88 = r97 + 8;
        goto L344
    L351:
        r85 = r88;
    L352:
        r93 = 0;
        goto L353
    L303:
        r84 = 0;
    L356:
        if (Double.valueOf(s4.f7768a).doubleValue() < 5.2d) goto L374;
        List<d4> r98 = this.O;
        if (r98 != null) goto L360;
        int r99 = 0;
    L361:
        r9[r81] = (byte) r99;
        r81 = r81 + 1;
        if (r99 <= 0) goto L374;
        Iterator<d4> r100 = this.O.iterator();
    L365:
        if (r100.hasNext() == false) goto L374;
        d4 r101 = r100.next();
        int r102 = ((int) (System.currentTimeMillis() - r101.f7243d)) / 1000;
        if (r102 <= 65535) goto L369;
        r102 = 65535;
    L369:
        System.arraycopy(a5.u(r102, r4), 0, r9, r81, 2);
        int r103 = r81 + 2;
        System.arraycopy(a5.G((int) Math.round(r101.f7242c * 1.0E7d), r60), 0, r9, r103, 4);
        int r104 = r103 + 4;
        System.arraycopy(a5.G((int) Math.round(r101.f7241b * 1.0E7d), r60), 0, r9, r104, 4);
        int r105 = r104 + 4;
        float r106 = r101.f7244e;
        if (r106 <= 65535.0f) goto L372;
        r106 = 65535.0f;
    L372:
        System.arraycopy(a5.u((int) r106, r4), 0, r9, r105, 2);
        int r107 = r105 + 2;
        System.arraycopy(a5.u((short) ((r101.f7247h | ((r101.f7240a << 13) | (r101.f7246g << 6))) & SupportMenu.USER_MASK), r4), 0, r9, r107, 2);
        r81 = r107 + 2;
        goto L365
    L360:
        r99 = r98.size();
    L374:
        if (Double.valueOf(s4.f7768a).doubleValue() < 5.3d) goto L376;
        r81 = a(this.M, r9, r81);
    L376:
        byte[] r108 = new byte[r81];
        System.arraycopy(r9, 0, r108, 0, r81);
        CRC32 r109 = new CRC32();
        r109.update(r108);
        byte[] r142 = a5.v(r109.getValue());
        byte[] r143 = new byte[r81 + 8];
        System.arraycopy(r108, 0, r143, 0, r81);
        System.arraycopy(r142, 0, r143, r81, 8);
        return r143;
    L294:
        r79 = 0;
        goto L295
    L384:
        byte[] r144 = this.K.getBytes("GBK");     // Catch: Throwable -> L378
        System.arraycopy(r144, 0, r9, r73, r144.length);     // Catch: Throwable -> L378
        r73 = r73 + r144.length;
    L284:
        r74 = 2;
    L286:
        r73 = r70 + r74;
    L285:
        r74 = 2;
        goto L286
    L264:
        byte[] r145 = r69.getBytes("GBK");     // Catch: Throwable -> L271
        if (r145.length <= 127) goto L267;
        r145 = null;
    L267:
        if (r145 != null) goto L269;
        r9[r68] = 0;     // Catch: Throwable -> L271
        r67 = 1;
        goto L272
    L269:
        r9[r68] = (byte) r145.length;     // Catch: Throwable -> L271
        int r146 = r68 + 1;     // Catch: Throwable -> L271
        System.arraycopy(r145, 0, r9, r146, r145.length);     // Catch: Throwable -> L271
        r70 = r146 + r145.length;
    L271:
        r9[r68] = 0;
        r67 = 1;
        goto L272
    L233:
        r9[r64] = (byte) r129;
        int r147 = r64 + r62;
        if (a5.J() < 17) goto L236;
        boolean r148 = true;
    L237:
        if (r148 == false) goto L239;
        r19 = a5.A() / 1000;
    L239:
        int r149 = 0;
    L240:
        if (r149 >= r129) goto L259;
        i3 r150 = r65.get(r149);
        byte[] r151 = f(i3.c(r150.f7373a));
        System.arraycopy(r151, 0, r9, r147, r151.length);
        int r152 = r147 + r151.length;
        byte[] r153 = r150.f7374b.getBytes("GBK");     // Catch: Exception -> L244
        r9[r152] = (byte) r153.length;     // Catch: Exception -> L244
        r152 = r152 + 1;     // Catch: Exception -> L244
        System.arraycopy(r153, 0, r9, r152, r153.length);     // Catch: Exception -> L244
        int r154 = r152 + r153.length;
        int r155 = 1;
    L245:
        int r156 = r150.f7375c;
        if (r156 <= 127) goto L249;
        r156 = 0;
    L251:
        r9[r154] = Byte.parseByte(String.valueOf(r156));
        int r157 = r154 + r155;
        if (r148 == false) goto L255;
        int r158 = (int) (r19 - (r150.f7378f / 1000));
        if (r158 < 0) goto L255;
    L256:
        if (r158 <= 65535) goto L258;
        r158 = 65535;
    L258:
        byte[] r159 = a5.u(r158, r4);
        System.arraycopy(r159, 0, r9, r157, r159.length);
        int r160 = r157 + r159.length;
        byte[] r161 = a5.u(r150.f7376d, r4);
        System.arraycopy(r161, 0, r9, r160, r161.length);
        r147 = r160 + r161.length;
        r149 = r149 + 1;
    L255:
        r158 = 0;
        goto L256
    L249:
        if (r156 >= (-128)) goto L251;
        r156 = 0;
    L244:
        r9[r152] = 0;
        r155 = 1;
        r154 = r152 + 1;
        goto L245
    L259:
        r130 = 0;
        byte[] r162 = a5.u(Integer.parseInt(this.F), r4);
        System.arraycopy(r162, 0, r9, r147, r162.length);
        r66 = r147 + r162.length;
        goto L260
    L236:
        r148 = false;
        goto L237
    L204:
        if (this.D.length() == 0) goto L229;
        r9[r24] = r61;
        r64 = r24 + 1;
        String[] r163 = this.D.split(",");     // Catch: Throwable -> L227
        byte[] r164 = f(r163[0]);     // Catch: Throwable -> L227
        System.arraycopy(r164, 0, r9, r64, r164.length);     // Catch: Throwable -> L227
        r64 = r64 + r164.length;
        byte[] r165 = r163[2].getBytes("GBK");     // Catch: Throwable -> L214
        int r166 = r165.length;     // Catch: Throwable -> L214
        if (r166 <= 127) goto L212;
        r166 = 127;
    L212:
        r9[r64] = (byte) r166;     // Catch: Throwable -> L214
        r64 = r64 + 1;     // Catch: Throwable -> L214
        System.arraycopy(r165, 0, r9, r64, r166);     // Catch: Throwable -> L214
        int r167 = r64 + r166;
    L216:
        int r168 = Integer.parseInt(r163[1]);     // Catch: Throwable -> L227
        if (r168 <= 127) goto L220;
    L218:
        r168 = 0;
    L222:
        r9[r167] = Byte.parseByte(String.valueOf(r168));     // Catch: Throwable -> L227
        r64 = r167 + 1;     // Catch: Throwable -> L227
        if (Double.valueOf(s4.f7768a).doubleValue() < 5.2d) goto L226;
        byte[] r169 = a5.u(this.N, r4);     // Catch: Throwable -> L227
        System.arraycopy(r169, 0, r9, r64, r169.length);     // Catch: Throwable -> L227
        r64 = r64 + r169.length;
    L226:
        r62 = 1;
        r63 = 0;
        goto L230
    L220:
        if (r168 >= (-128)) goto L222;
    L214:
        th = move-exception;
        s4.h(th, "Req", "buildV4Dot214");     // Catch: Throwable -> L227
        r9[r64] = 0;     // Catch: Throwable -> L227
        r167 = r64 + 1;     // Catch: Throwable -> L227
    L227:
        th = move-exception;
        s4.h(th, "Req", "buildV4Dot216");
        byte[] r170 = f("00:00:00:00:00:00");
        r63 = 0;
        System.arraycopy(r170, 0, r9, r64, r170.length);
        int r171 = r64 + r170.length;
        r9[r171] = 0;
        r62 = 1;
        int r172 = r171 + 1;
        r9[r172] = Byte.parseByte(BDLocationException.ERROR_TIMEOUT);
        r64 = r172 + 1;
    L200:
        r60 = r6;
        r9[r21] = 0;
        r61 = 1;
        r24 = r21 + 1;
        goto L202
    L131:
        if ((this.z & 8) != 8) goto L134;
        byte[] r173 = r20.getBytes("GBK");     // Catch: Exception -> L381
        int r174 = Math.min(r173.length, 60);     // Catch: Exception -> L381
        r9[r18] = (byte) r174;     // Catch: Exception -> L381
        r18 = r18 + 1;     // Catch: Exception -> L381
        System.arraycopy(r173, 0, r9, r18, r174);     // Catch: Exception -> L381
        r21 = r18 + r174;
    L25:
        if (this.A.size() <= 0) goto L27;
        int r175 = this.A.get(0).f7184a;
    L28:
        byte[] r176 = a5.u(r175, null);
        System.arraycopy(r176, 0, r9, r18, r176.length);
        int r177 = r18 + r176.length;
        if (r17 == 1) goto L31;
        if (r17 == 2) goto L46;
    L67:
        if (this.A.size() <= 0) goto L69;
        int r178 = this.A.get(0).f7194k;
    L70:
        if (r178 <= 127) goto L72;
    L71:
        r178 = 0;
    L74:
        r9[r177] = (byte) r178;
        int r179 = r177 + 1;
        if (this.A.size() <= 0) goto L77;
        long r180 = (a5.A() - this.A.get(0).t) / 1000;
    L79:
        if (r180 <= 65535) goto L82;
        r180 = 65535;
    L82:
        if (r180 >= 0) goto L84;
        r180 = 0;
    L84:
        byte[] r181 = a5.u((int) r180, r4);
        System.arraycopy(r181, 0, r9, r179, r181.length);
        r18 = r179 + 2;
        if (r17 != 1) goto L125;
        if (this.A.size() != 0) goto L89;
        r9[r18] = 0;
    L127:
        r18 = r18 + 1;
        goto L128
    L89:
        int r182 = this.A.size();
        r9[r18] = (byte) r182;
        r18 = r18 + 1;
        int r183 = 0;
    L90:
        if (r183 >= r182) goto L128;
        if (this.A.size() <= 0) goto L94;
        int r184 = this.A.get(r183).f7186c;
    L95:
        byte[] r185 = a5.u(r184, r11);
        System.arraycopy(r185, r10, r9, r18, r185.length);
        int r186 = r18 + r185.length;
        if (this.A.size() <= 0) goto L98;
        int r187 = this.A.get(r183).f7187d;
    L99:
        byte[] r188 = a5.G(r187, r11);
        System.arraycopy(r188, r10, r9, r186, r188.length);
        int r189 = r186 + r188.length;
        if (this.A.size() <= 0) goto L102;
        int r190 = this.A.get(r183).f7194k;
    L104:
        if (r190 <= 127) goto L107;
    L105:
        r190 = r10;
    L109:
        r9[r189] = (byte) r190;
        r18 = r189 + r8;
        if (Double.valueOf(s4.f7768a).doubleValue() >= 5.2d) goto L112;
        int r191 = r10;
    L123:
        r183 = r183 + 1;
        r10 = r191;
        r8 = 1;
        r11 = null;
        goto L90
    L112:
        if (this.A.size() <= 0) goto L114;
        long r192 = (a5.A() - this.A.get(r10).t) / 1000;
    L116:
        if (r192 <= 65535) goto L119;
        r192 = 65535;
    L119:
        if (r192 >= 0) goto L121;
        r192 = 0;
    L121:
        byte[] r193 = a5.u((int) r192, r4);
        r191 = 0;
        System.arraycopy(r193, 0, r9, r18, r193.length);
        r18 = r18 + r193.length;
        goto L123
    L114:
        r192 = 0;
        goto L116
    L107:
        if (r190 >= (-128)) goto L109;
    L102:
        r190 = r10;
        goto L104
    L98:
        r187 = r10;
        goto L99
    L94:
        r184 = r10;
        goto L95
    L125:
        if (r17 != 2) goto L128;
        r9[r18] = 0;
        goto L127
    L77:
        r180 = 0;
        goto L79
    L72:
        if (r178 >= (-128)) goto L74;
    L69:
        r178 = 0;
        goto L70
    L46:
        if (this.A.size() <= 0) goto L48;
        int r194 = this.A.get(0).f7191h;
    L49:
        byte[] r195 = a5.u(r194, null);
        System.arraycopy(r195, 0, r9, r177, r195.length);
        int r196 = r177 + r195.length;
        if (this.A.size() <= 0) goto L52;
        int r197 = this.A.get(0).f7192i;
    L53:
        byte[] r198 = a5.u(r197, null);
        System.arraycopy(r198, 0, r9, r196, r198.length);
        int r199 = r196 + r198.length;
        if (this.A.size() <= 0) goto L56;
        int r1100 = this.A.get(0).f7193j;
    L57:
        byte[] r1101 = a5.u(r1100, null);
        System.arraycopy(r1101, 0, r9, r199, r1101.length);
        int r200 = r199 + r1101.length;
        if (this.A.size() <= 0) goto L60;
        int r1102 = this.A.get(0).f7190g;
    L61:
        byte[] r1103 = a5.G(r1102, null);
        System.arraycopy(r1103, 0, r9, r200, r1103.length);
        int r201 = r200 + r1103.length;
        if (this.A.size() <= 0) goto L64;
        int r1104 = this.A.get(0).f7189f;
    L65:
        byte[] r1105 = a5.G(r1104, null);
        System.arraycopy(r1105, 0, r9, r201, r1105.length);
        int r1106 = r1105.length;
    L43:
        r177 = r201 + r1106;
        goto L67
    L64:
        r1104 = 0;
        goto L65
    L60:
        r1102 = 0;
        goto L61
    L56:
        r1100 = 0;
        goto L57
    L52:
        r197 = 0;
        goto L53
    L48:
        r194 = 0;
        goto L49
    L31:
        if (this.A.size() <= 0) goto L33;
        int r1107 = this.A.get(0).f7185b;
    L34:
        byte[] r1108 = a5.u(r1107, null);
        System.arraycopy(r1108, 0, r9, r177, r1108.length);
        int r202 = r177 + r1108.length;
        if (this.A.size() <= 0) goto L37;
        int r1109 = this.A.get(0).f7186c;
    L38:
        byte[] r1110 = a5.u(r1109, null);
        System.arraycopy(r1110, 0, r9, r202, r1110.length);
        r201 = r202 + r1110.length;
        if (this.A.size() <= 0) goto L41;
        int r1111 = this.A.get(0).f7187d;
    L42:
        byte[] r1112 = a5.G(r1111, null);
        System.arraycopy(r1112, 0, r9, r201, r1112.length);
        r1106 = r1112.length;
        goto L43
    L41:
        r1111 = 0;
        goto L42
    L37:
        r1109 = 0;
        goto L38
    L33:
        r1107 = 0;
        goto L34
    L27:
        r175 = 0;
        goto L28
    L12:
        if (TextUtils.isEmpty(this.t) == false) goto L14;
        r9[r12] = 0;     // Catch: Throwable -> L16
        goto L18
    L14:
        byte[] r203 = f(this.t);     // Catch: Throwable -> L16
        r9[r12] = (byte) r203.length;     // Catch: Throwable -> L16
        int r1113 = r12 + 1;     // Catch: Throwable -> L16
        System.arraycopy(r203, 0, r9, r1113, r203.length);     // Catch: Throwable -> L16
        r13 = r1113 + r203.length;
        goto L19
    L8:
        if (r7 <= this.f7635J) goto L10;
        goto L9
    }
}
