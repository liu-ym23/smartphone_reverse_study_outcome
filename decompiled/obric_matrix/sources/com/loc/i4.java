package com.loc;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class i4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Hashtable<String, ArrayList<a>> f7381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f7382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f7384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f7385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f7386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    long f7387g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    String f7388h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    b4 f7389i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f7390j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f7391k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f7392l;
    boolean m;
    String n;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ew f7393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f7394b;

        protected a() {
            this.f7393a = null;
            this.f7394b = null;
        }

        public final ew a() {
            return this.f7393a;
        }

        public final void b(ew r1) {
            this.f7393a = r1;
        }

        public final void c(String r3) {
            if (TextUtils.isEmpty(r3) == false) goto L7;
            String r4 = null;
        L5:
            this.f7394b = r4;
            return;
        L7:
            r4 = r3.replace("##", "#");
            goto L5
        }

        public final String d() {
            return this.f7394b;
        }
    }

    public i4() {
        this.f7381a = new Hashtable();
        this.f7382b = 0;
        this.f7383c = false;
        this.f7384d = "2.0.201501131131".replace(".", "");
        this.f7385e = null;
        this.f7386f = true;
        this.f7387g = 0;
        this.f7388h = null;
        this.f7389i = null;
        this.f7390j = null;
        this.f7391k = 0;
        this.f7392l = true;
        this.m = true;
        this.n = String.valueOf(AMapLocationClientOption.e.f500f);
    }

    private ew c(String r5, StringBuilder r6, boolean r7) {
    L35:
        th = move-exception;
        s4.h(th, "Cache", "get1");
    L37:
        return null;
    L4:
        if (r5.contains("cgiwifi") == false) goto L6;
    L16:
        a r8 = d(r6, r5);     // Catch: Throwable -> L35
    L17:
        if (r8 == null) goto L37;
        if (a5.q(r8.a()) == false) goto L37;
        ew r1 = r8.a();     // Catch: Throwable -> L35
        r1.k1("mem");     // Catch: Throwable -> L35
        r1.q1(r8.d());     // Catch: Throwable -> L35
        if (r7 == true) goto L31;
        if (r4.f(r1.getTime()) == true) goto L31;
        Hashtable<String, ArrayList<a>> r9 = this.f7381a;     // Catch: Throwable -> L35
        if (r9 == null) goto L37;
        if (r9.containsKey(r5) == false) goto L37;
        this.f7381a.get(r5).remove(r8);     // Catch: Throwable -> L35
    L31:
        if (a5.q(r1) == false) goto L33;
        this.f7387g = 0;     // Catch: Throwable -> L35
    L33:
        r1.L0(4);     // Catch: Throwable -> L35
        return r1;
    L6:
        if (r5.contains("wifi") == true) goto L16;
        if (r5.contains("cgi") == true) goto L11;
    L15:
        r8 = null;
        goto L17
    L11:
        if (this.f7381a.containsKey(r5) == false) goto L15;
        if (this.f7381a.get(r5).size() <= 0) goto L15;
        r8 = this.f7381a.get(r5).get(0);     // Catch: Throwable -> L35
        goto L17
    }

    private a d(StringBuilder r24, String r25) {
        if (this.f7381a.isEmpty() == true) goto L58;
        if (TextUtils.isEmpty(r24) == true) goto L58;
        if (this.f7381a.containsKey(r25) == true) goto L10;
        return null;
    L10:
        Hashtable r2 = new Hashtable();
        Hashtable r4 = new Hashtable();
        Hashtable r5 = new Hashtable();
        ArrayList<a> r0 = this.f7381a.get(r25);
        char r6 = 1;
        int r1 = r0.size() - 1;
    L11:
        if (r1 < 0) goto L54;
        a r7 = r0.get(r1);
        if (TextUtils.isEmpty(r7.d()) == true) goto L53;
        if (q(r7.d(), r24) == true) goto L17;
        char r8 = 0;
    L21:
        n(r7.d(), r2);
        n(r24.toString(), r4);
        r5.clear();
        Iterator r11 = r2.keySet().iterator();
    L23:
        if (r11.hasNext() == false) goto L25;
        r5.put((String) r11.next(), "");
        goto L23
    L25:
        Iterator r12 = r4.keySet().iterator();
    L27:
        if (r12.hasNext() == false) goto L29;
        r5.put((String) r12.next(), "");
        goto L27
    L29:
        Set r13 = r5.keySet();
        double[] r14 = new double[r13.size()];
        double[] r15 = new double[r13.size()];
        Iterator r16 = r13.iterator();
        int r17 = 0;
    L30:
        if (r16 == null) goto L42;
        if (r16.hasNext() == false) goto L42;
        String r3 = (String) r16.next();
        double r18 = 1.0d;
        if (r2.containsKey(r3) == false) goto L36;
        double r21 = 1.0d;
    L37:
        r14[r17] = r21;
        if (r4.containsKey(r3) == true) goto L41;
        r18 = 0.0d;
    L41:
        r15[r17] = r18;
        r17 = r17 + 1;
        goto L30
    L36:
        r21 = 0.0d;
    L42:
        r13.clear();
        double[] r9 = s(r14, r15);
        if (r9[0] >= 0.800000011920929d) goto L18;
        a r26 = r7;
        if (r9[r6] >= Math.min(r4.u(), 0.618d)) goto L51;
        if (r8 == 0) goto L53;
        if (r9[0] < Math.min(r4.u(), 0.618d)) goto L53;
    L51:
        a r10 = r26;
    L55:
        r2.clear();
        r4.clear();
        r5.clear();
        return r10;
    L18:
        r26 = r7;
        goto L51
    L17:
        if (a5.s(r7.d(), r24.toString()) == true) goto L18;
        r8 = r6;
    L53:
        r1 = r1 - 1;
        r6 = 1;
        goto L11
    L54:
        r10 = null;
    L58:
        return null;
    }

    private String e(String r9, StringBuilder r10, Context r11) {
        if (r11 != null) goto L5;
        return null;
    L5:
        JSONObject r5 = new JSONObject();
        this.f7385e = a5.d0(r11);     // Catch: Throwable -> L24
        if (r9.contains("&") == false) goto L9;
        r9 = r9.substring(0, r9.indexOf("&"));     // Catch: Throwable -> L24
    L9:
        String r12 = r9.substring(r9.lastIndexOf("#") + 1);     // Catch: Throwable -> L24
        if (r12.equals("cgi") == false) goto L13;
        r5.put("cgi", r9.substring(0, r9.length() - 12));     // Catch: Throwable -> L24
    L22:
        return m5.f(h4.e(r5.toString().getBytes("UTF-8"), this.f7385e));
    L13:
        if (TextUtils.isEmpty(r10) == true) goto L22;
        if (r10.indexOf(",access") == (-1)) goto L22;
        r5.put("cgi", r9.substring(0, r9.length() - (r12.length() + 9)));     // Catch: Throwable -> L24
        String[] r13 = r10.toString().split(",access");     // Catch: Throwable -> L24
        if (r13[0].contains("#") == false) goto L19;
        String r14 = r13[0].substring(r13[0].lastIndexOf("#") + 1);     // Catch: Throwable -> L24
    L20:
        r5.put("mmac", r14);     // Catch: Throwable -> L24
        goto L22
    L19:
        r14 = r13[0];     // Catch: Throwable -> L24
    L24:
        return null;
    }

    private void h(Context r20, String r21, boolean r22) {
        if (r4.r() == true) goto L5;
        return;
    L5:
        if (r20 != null) goto L7;
        return;
    L7:
        SQLiteDatabase r3 = null;
        int r9 = 0;
        SQLiteDatabase r6 = r20.openOrCreateDatabase("hmdb", 0, null);     // Catch: Throwable -> L109
    L106:
        th = th;
        SQLiteDatabase r13 = r6;
        Cursor r10 = null;
    L108:
        r3 = r13;
    L135:
        s4.h(th, "DB", "fetchHist p2");     // Catch: Throwable -> L119
        if (r10 == null) goto L114;
        r10.close();
    L114:
        if (r3 != null) goto L116;
        return;
    L116:
        if (r3.isOpen() == false) goto L146;
        r3.close();
        return;
    L146:
        return;
    L119:
        th = move-exception;
        if (r10 == null) goto L122;
        r10.close();
    L122:
        if (r3 != null) goto L124;
    L126:
        throw th;
    L124:
        if (r3.isOpen() == false) goto L126;
        r3.close();
        goto L126
    L139:
        if (a5.n(r6, "hist") == true) goto L20;
        if (r6 != null) goto L13;
        return;
    L13:
        if (r6.isOpen() == false) goto L141;
        r6.close();     // Catch: Throwable -> L16
        return;
    L141:
        return;
    L20:
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L106
        if (r22 == true) goto L28;
        long r12 = a5.f() - r4.o();     // Catch: Throwable -> L16
        r5.append("time >");     // Catch: Throwable -> L16
        r5.append(r12);     // Catch: Throwable -> L16
        if (r21 == null) goto L32;
        r5.append(" and feature = '");     // Catch: Throwable -> L16
        String r1 = r21 + "'";     // Catch: Throwable -> L16
    L26:
        r5.append(r1);     // Catch: Throwable -> L16
    L32:
        r10 = r6.query("hist" + this.f7384d, new String[]{"feature", " nb", "loc"}, r5.toString(), null, null, null, "time ASC", null);     // Catch: Throwable -> L106
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L104
        if (this.f7385e == null) goto L129;
    L39:
        if (r10 != null) goto L41;
    L96:
        r13 = r6;
    L97:
        if (r10 == null) goto L99;
        r10.close();
    L99:
        if (r13 != null) goto L101;
        return;
    L101:
        if (r13.isOpen() == false) goto L144;
        r13.close();
        return;
    L144:
        return;
    L41:
        if (r10.moveToFirst() == false) goto L96;
    L42:
        String r4 = ",access";
        if (r10.getString(r9).startsWith("{") == false) goto L56;
        JSONObject r2 = new JSONObject(r10.getString(r9));     // Catch: Throwable -> L37
        r11.delete(r9, r11.length());     // Catch: Throwable -> L37
        if (TextUtils.isEmpty(r10.getString(1)) == true) goto L50;
        r4 = r10.getString(1);     // Catch: Throwable -> L37
    L48:
        r11.append(r4);     // Catch: Throwable -> L37
    L52:
        JSONObject r7 = new JSONObject(r10.getString(2));     // Catch: Throwable -> L37
        if (a5.t(r7, WsConstants.KEY_CONNECTION_TYPE) == false) goto L70;
        r7.put(WsConstants.KEY_CONNECTION_TYPE, "new");     // Catch: Throwable -> L37
    L70:
        ew r8 = new ew("");     // Catch: Throwable -> L104
        r8.e1(r7);     // Catch: Throwable -> L104
        if (a5.t(r2, "mmac") == false) goto L82;
        if (a5.t(r2, "cgi") == false) goto L82;
        String r14 = (r2.getString("cgi") + "#") + "network#";     // Catch: Throwable -> L37
        if (r2.getString("cgi").contains("#") == false) goto L79;
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L37
        r15.append(r14);     // Catch: Throwable -> L37
        r15.append("cgiwifi");     // Catch: Throwable -> L37
    L78:
        String r16 = r15.toString();     // Catch: Throwable -> L37
    L86:
        r13 = r6;
        m(r16, r11, r8, r20, false);     // Catch: Throwable -> L94
    L90:
        if (r10.moveToNext() == false) goto L91;
        r5 = r5;
        r6 = r13;
        r9 = 0;
        goto L42
    L91:
        r11.delete(0, r11.length());     // Catch: Throwable -> L94
        r5.delete(0, r5.length());     // Catch: Throwable -> L94
    L94:
        th = th;
        goto L108
    L79:
        r15 = new StringBuilder();     // Catch: Throwable -> L37
        r15.append(r14);     // Catch: Throwable -> L37
        r15.append("wifi");     // Catch: Throwable -> L37
    L82:
        if (a5.t(r2, "cgi") == false) goto L88;
        String r17 = (r2.getString("cgi") + "#") + "network#";     // Catch: Throwable -> L104
        if (r2.getString("cgi").contains("#") == false) goto L88;
        r16 = r17 + "cgi";     // Catch: Throwable -> L104
    L88:
        r13 = r6;
        goto L90
    L50:
        if (a5.t(r2, "mmac") == false) goto L52;
        r11.append("#");     // Catch: Throwable -> L37
        r11.append(r2.getString("mmac"));     // Catch: Throwable -> L37
    L37:
        th = th;
    L18:
        r3 = r6;
        goto L135
    L56:
        JSONObject r18 = new JSONObject(new String(h4.h(m5.g(r10.getString(r9)), this.f7385e), "UTF-8"));     // Catch: Throwable -> L104
        r11.delete(0, r11.length());     // Catch: Throwable -> L104
        if (TextUtils.isEmpty(r10.getString(1)) == true) goto L62;
        r4 = new String(h4.h(m5.g(r10.getString(1)), this.f7385e), "UTF-8");     // Catch: Throwable -> L37
    L59:
        r11.append(r4);     // Catch: Throwable -> L37
    L66:
        r7 = new JSONObject(new String(h4.h(m5.g(r10.getString(2)), this.f7385e), "UTF-8"));     // Catch: Throwable -> L104
        if (a5.t(r7, WsConstants.KEY_CONNECTION_TYPE) == false) goto L69;
        r7.put(WsConstants.KEY_CONNECTION_TYPE, "new");     // Catch: Throwable -> L37
    L69:
        r2 = r18;
        goto L70
    L62:
        if (a5.t(r18, "mmac") == false) goto L66;
        r11.append("#");     // Catch: Throwable -> L37
        r11.append(r18.getString("mmac"));     // Catch: Throwable -> L37
        goto L59
    L129:
        this.f7385e = a5.d0(r20);     // Catch: Throwable -> L37
    L104:
        th = th;
        r13 = r6;
        goto L108
    L28:
        long r19 = a5.f() - 172800000;     // Catch: Throwable -> L106
        r5.append("time >");     // Catch: Throwable -> L106
        r5.append(r19);     // Catch: Throwable -> L106
        if (r21 == null) goto L32;
        r5.append(" and feature = '");     // Catch: Throwable -> L16
        r1 = r21 + "'";     // Catch: Throwable -> L16
    L16:
        th = th;
        r10 = null;
    L109:
        th = th;
        r10 = null;
        goto L135
    }

    private void l(String r6, AMapLocation r7, StringBuilder r8, Context r9) {
        if (r9 != null) goto L6;
        return;
    L6:
        if (this.f7385e != null) goto L8;
        this.f7385e = a5.d0(r9);
    L8:
        String r10 = e(r6, r8, r9);
        StringBuilder r1 = new StringBuilder();
        SQLiteDatabase r2 = null;
        r2 = r9.openOrCreateDatabase("hmdb", 0, null);     // Catch: Throwable -> L19
        r1.append("CREATE TABLE IF NOT EXISTS hist");     // Catch: Throwable -> L19
        r1.append(this.f7384d);     // Catch: Throwable -> L19
        r1.append(" (feature VARCHAR PRIMARY KEY, nb VARCHAR, loc VARCHAR, time VARCHAR);");     // Catch: Throwable -> L19
        r2.execSQL(r1.toString());     // Catch: Throwable -> L19
        r1.delete(0, r1.length());     // Catch: Throwable -> L19
        r1.append("REPLACE INTO ");     // Catch: Throwable -> L19
        r1.append("hist");     // Catch: Throwable -> L19
        r1.append(this.f7384d);     // Catch: Throwable -> L19
        r1.append(" VALUES (?, ?, ?, ?)");     // Catch: Throwable -> L19
        Object[] r11 = new Object[4];     // Catch: Throwable -> L19
        r11[0] = r10;     // Catch: Throwable -> L19
        byte[] r12 = h4.e(r8.toString().getBytes("UTF-8"), this.f7385e);     // Catch: Throwable -> L19
        int r13 = 1;
        r11[1] = r12;     // Catch: Throwable -> L19
        r11[2] = h4.e(r7.V0().getBytes("UTF-8"), this.f7385e);     // Catch: Throwable -> L19
        r11[3] = Long.valueOf(r7.getTime());     // Catch: Throwable -> L19
    L10:
        if (r13 >= 3) goto L12;
        r11[r13] = m5.f((byte[]) r11[r13]);     // Catch: Throwable -> L19
        r13 = r13 + 1;     // Catch: Throwable -> L19
        goto L10
    L12:
        r2.execSQL(r1.toString(), r11);     // Catch: Throwable -> L19
        r1.delete(0, r1.length());     // Catch: Throwable -> L19
        r1.delete(0, r1.length());
        if (r2 != null) goto L16;
        return;
    L16:
        if (r2.isOpen() == false) goto L40;
        r2.close();
        return;
    L40:
        return;
    L19:
        th = move-exception;
        s4.h(th, "DB", "updateHist");     // Catch: Throwable -> L27
        r1.delete(0, r1.length());
        if (r2 != null) goto L24;
        return;
    L24:
        if (r2.isOpen() == false) goto L42;
        r2.close();
        return;
    L42:
        return;
    L27:
        th = move-exception;
        r1.delete(0, r1.length());
        if (r2 != null) goto L31;
    L33:
        throw th;
    L31:
        if (r2.isOpen() == false) goto L33;
        r2.close();
        goto L33
    }

    private static void n(String r4, Hashtable<String, String> r5) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        r5.clear();
        String[] r6 = r4.split("#");
        int r0 = r6.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L13;
        String r2 = r6[r1];
        if (TextUtils.isEmpty(r2) == true) goto L12;
        if (r2.contains("|") == true) goto L12;
        r5.put(r2, "");
    L12:
        r1 = r1 + 1;
        goto L6
    }

    private boolean o(ew r2, boolean r3) {
        if (r(r3) == true) goto L5;
        return false;
    L5:
        if (r2 != null) goto L7;
        return true;
    L7:
        if (r4.f(r2.getTime()) == true) goto L12;
        if (r3 == true) goto L13;
        return false;
    L13:
        return true;
    L12:
        return true;
    }

    private static boolean p(String r2, ew r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L12:
        return false;
    L5:
        if (a5.q(r3) == false) goto L12;
        if (r2.startsWith("#") == false) goto L11;
        return false;
    L11:
        return r2.contains("network");
    }

    private static boolean q(String r4, StringBuilder r5) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
    L21:
        return false;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L21;
        if (r4.contains(",access") == false) goto L21;
        if (r5.indexOf(",access") == (-1)) goto L21;
        String[] r6 = r4.split(",access");
        if (r6[0].contains("#") == false) goto L15;
        String r7 = r6[0].substring(r6[0].lastIndexOf("#") + 1);
    L17:
        if (TextUtils.isEmpty(r7) == false) goto L20;
        return false;
    L20:
        return r5.toString().contains(r7 + ",access");
    L15:
        r7 = r6[0];
        goto L17
    }

    private boolean r(boolean r3) {
        if (r4.r() == true) goto L7;
        if (r3 == true) goto L7;
        return false;
    L7:
        if (this.f7386f == false) goto L9;
        return true;
    L9:
        if (r4.t() == true) goto L15;
        if (r3 == true) goto L16;
        return false;
    L16:
        return true;
    L15:
        return true;
    }

    private static double[] s(double[] r19, double[] r20) {
        double[] r1 = new double[3];
        double r2 = 0.0d;
        int r4 = 0;
        double r5 = 0.0d;
        double r7 = 0.0d;
        int r9 = 0;
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r9 >= r19.length) goto L11;
        r5 = r5 + (r19[r9] * r19[r9]);
        r7 = r7 + (r20[r9] * r20[r9]);
        r2 = r2 + (r19[r9] * r20[r9]);
        if (r20[r9] != 1.0d) goto L10;
        r11 = r11 + 1;
        if (r19[r9] != 1.0d) goto L10;
        r10 = r10 + 1;
    L10:
        r9 = r9 + 1;
        goto L4
    L11:
        r1[0] = r2 / (Math.sqrt(r5) * Math.sqrt(r7));
        double r3 = r10;
        r1[1] = (r3 * 1.0d) / ((double) r11);
        r1[2] = r3;
    L12:
        if (r4 >= 2) goto L17;
        if (r1[r4] <= 1.0d) goto L16;
        r1[r4] = 1.0d;
    L16:
        r4 = r4 + 1;
        goto L12
    L17:
        return r1;
    }

    private boolean u() {
        long r0 = a5.A();
        long r2 = this.f7382b;
        long r1 = r0 - r2;
        if (r2 != 0) goto L6;
        return false;
    L6:
        if (this.f7381a.size() <= 360) goto L8;
    L9:
        return true;
    L8:
        if (r1 > 172800000) goto L9;
        return false;
    }

    private void v() {
        this.f7382b = 0;
        if (this.f7381a.isEmpty() == true) goto L5;
        this.f7381a.clear();
    L5:
        this.f7383c = false;
    }

    private void w(Context r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        SQLiteDatabase r2 = null;
        r2 = r10.openOrCreateDatabase("hmdb", 0, null);     // Catch: Throwable -> L25
        if (a5.n(r2, "hist") == true) goto L38;
        if (r2 != null) goto L10;
        return;
    L10:
        if (r2.isOpen() == false) goto L44;
        r2.close();     // Catch: Throwable -> L25
        return;
    L44:
        return;
    L38:
        r2.delete("hist" + this.f7384d, "time<?", new String[]{String.valueOf(a5.f() - 172800000)});     // Catch: Throwable -> L16
    L20:
        if (r2 != null) goto L22;
        return;
    L22:
        if (r2.isOpen() == false) goto L46;
        r2.close();
        return;
    L46:
        return;
    L16:
        th = move-exception;
        s4.h(th, "DB", "clearHist");     // Catch: Throwable -> L25
        String r9 = th.getMessage();     // Catch: Throwable -> L25
        if (TextUtils.isEmpty(r9) == true) goto L20;
        r9.contains("no such table");     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        s4.h(th, "DB", "clearHist p2");     // Catch: Throwable -> L32
        if (r2 != null) goto L29;
        return;
    L29:
        if (r2.isOpen() == false) goto L48;
        r2.close();
        return;
    L48:
        return;
    L32:
        th = move-exception;
        if (r2 != null) goto L35;
    L37:
        throw th;
    L35:
        if (r2.isOpen() == false) goto L37;
        r2.close();
        goto L37
    }

    public final ew a(Context r4, String r5, StringBuilder r6, boolean r7, boolean r8) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return null;
    L6:
        if (r4.r() == true) goto L8;
        return null;
    L8:
        String r9 = r5 + "&" + this.f7392l + "&" + this.m + "&" + this.n;
        if (r9.contains("gps") == false) goto L11;
    L27:
        return null;
    L11:
        if (r4.r() == false) goto L27;
        if (r6 == null) goto L27;
        if (u() == false) goto L18;
        v();
        return null;
    L18:
        if (r7 == false) goto L23;
        if (this.f7383c == true) goto L23;
        String r10 = e(r9, r6, r4);     // Catch: Throwable -> L28
        v();     // Catch: Throwable -> L28
        h(r4, r10, r8);     // Catch: Throwable -> L28
    L23:
        if (this.f7381a.isEmpty() == false) goto L26;
        return null;
    L26:
        return c(r9, r6, r8);
    }

    public final ew b(c4 r16, boolean r17, ew r18, g4 r19, StringBuilder r20, String r21, Context r22, boolean r23) {
        if (o(r18, r23) == true) goto L79;
        return null;
    L79:
        b4 r2 = r16.z();     // Catch: Throwable -> L78
        if (r2 == null) goto L8;
    L9:
        b4 r3 = this.f7389i;     // Catch: Throwable -> L78
        if (r3 != null) goto L12;
    L15:
        boolean r4 = true;
    L16:
        if (r18 == null) goto L24;
        int r5 = r19.p().size();     // Catch: Throwable -> L78
        if (r18.getAccuracy() > 299.0f) goto L20;
    L22:
        boolean r6 = false;
    L23:
        boolean r10 = r6;
    L26:
        if (r18 == null) goto L43;
        String r7 = this.f7388h;     // Catch: Throwable -> L78
        if (r7 == null) goto L43;
        if (r10 == true) goto L43;
        if (r4 == true) goto L43;
        boolean r8 = a5.s(r7, r20.toString());     // Catch: Throwable -> L78
        if (this.f7387g != 0) goto L34;
    L36:
        boolean r9 = false;
    L37:
        if (r8 == true) goto L40;
        if (r9 == true) goto L40;
    L44:
        if (r8 == true) goto L46;
        this.f7387g = a5.A();     // Catch: Throwable -> L78
    L47:
        String r0 = this.f7390j;     // Catch: Throwable -> L78
        if (r0 == null) goto L57;
        if (r21.equals(r0) == true) goto L57;
        if ((a5.f() - this.f7391k) >= WsConstants.EXIT_DELAY_TIME) goto L54;
        String r11 = this.f7390j;     // Catch: Throwable -> L78
    L61:
        if (r10 == true) goto L64;
        if (r17 == true) goto L64;
        ew r1 = a(r22, r11, r20, false, false);     // Catch: Throwable -> L78
    L65:
        if (r17 == false) goto L67;
    L69:
        boolean r12 = false;
    L70:
        if (r12 == true) goto L77;
        if (r10 == true) goto L77;
        if (r17 == false) goto L75;
        return null;
    L75:
        this.f7387g = 0;     // Catch: Throwable -> L78
        r1.L0(4);     // Catch: Throwable -> L78
        return r1;
    L67:
        if (a5.q(r1) == true) goto L69;
        r12 = true;
    L64:
        r1 = null;
        goto L65
    L54:
        long r13 = a5.f();     // Catch: Throwable -> L78
    L55:
        this.f7391k = r13;     // Catch: Throwable -> L78
        this.f7390j = r21;     // Catch: Throwable -> L78
    L60:
        r11 = r21;
    L57:
        if (this.f7390j != null) goto L59;
        r13 = a5.f();     // Catch: Throwable -> L78
        goto L55
    L59:
        this.f7391k = a5.f();     // Catch: Throwable -> L78
        goto L60
    L46:
        this.f7387g = 0;     // Catch: Throwable -> L78
    L40:
        if (a5.q(r18) == false) goto L44;
        r18.k1("mem");     // Catch: Throwable -> L78
        r18.L0(2);     // Catch: Throwable -> L78
        return r18;
    L34:
        if ((a5.A() - this.f7387g) >= WsConstants.EXIT_DELAY_TIME) goto L36;
        r9 = true;
    L43:
        r8 = false;
        goto L44
    L20:
        if (r5 <= 5) goto L22;
        r6 = true;
        goto L23
    L24:
        r10 = false;
        goto L26
    L12:
        if (r3.equals(r2) == false) goto L15;
    L14:
        r4 = false;
        goto L16
    L8:
        if (this.f7389i == null) goto L14;
    L77:
        return null;
    }

    public final void f() {
        this.f7387g = 0;
        this.f7388h = null;
    }

    public final void g(Context r3) {
        if (this.f7383c == false) goto L11;
        return;
    L11:
        v();     // Catch: Throwable -> L7
        h(r3, null, false);     // Catch: Throwable -> L7
    L9:
        this.f7383c = true;
        return;
    L7:
        th = move-exception;
        s4.h(th, "Cache", "loadDB");
        goto L9
    }

    public final void i(AMapLocationClientOption r2) {
        this.m = r2.L();
        this.f7392l = r2.M();
        this.f7386f = r2.H();
        this.n = String.valueOf(r2.q());
    }

    public final void j(b4 r1) {
        this.f7389i = r1;
    }

    public final void k(String r1) {
        this.f7388h = r1;
    }

    public final void m(String r16, StringBuilder r17, ew r18, Context r19, boolean r20) {
    L82:
        th = move-exception;
        s4.h(th, "Cache", "add");
        return;
    L4:
        if (a5.q(r18) == true) goto L6;
        return;
    L6:
        String r11 = r16 + "&" + r18.l0() + "&" + r18.s1() + "&" + r18.t1();     // Catch: Throwable -> L82
        if (p(r11, r18) == true) goto L10;
        return;
    L10:
        if (r18.j1().equals("mem") == false) goto L12;
        return;
    L12:
        if (r18.j1().equals("file") == false) goto L14;
        return;
    L14:
        if (r18.j1().equals("wifioff") == false) goto L17;
        return;
    L17:
        if ("-3".equals(r18.h1()) == false) goto L20;
        return;
    L20:
        if (u() == false) goto L22;
        v();     // Catch: Throwable -> L82
    L22:
        JSONObject r3 = r18.l1();     // Catch: Throwable -> L82
        if (a5.t(r3, "offpct") == false) goto L27;
        r3.remove("offpct");     // Catch: Throwable -> L82
        r18.a1(r3);     // Catch: Throwable -> L82
    L27:
        if (r11.contains("wifi") == false) goto L53;
        if (TextUtils.isEmpty(r17) == false) goto L32;
        return;
    L32:
        if (r18.getAccuracy() < 300.0f) goto L43;
        String[] r2 = r17.toString().split("#");     // Catch: Throwable -> L82
        int r5 = r2.length;     // Catch: Throwable -> L82
        int r6 = 0;
        int r13 = 0;
    L34:
        if (r6 >= r5) goto L40;
        if (r2[r6].contains(",") == false) goto L38;
        r13 = r13 + 1;     // Catch: Throwable -> L82
    L38:
        r6 = r6 + 1;     // Catch: Throwable -> L82
        goto L34
    L40:
        if (r13 < 8) goto L46;
        return;
    L46:
        if (r11.contains("cgiwifi") == true) goto L48;
    L61:
        ew r1 = c(r11, r17, false);     // Catch: Throwable -> L82
        if (a5.q(r1) == true) goto L64;
    L66:
        this.f7382b = a5.A();     // Catch: Throwable -> L82
        a r4 = new a();     // Catch: Throwable -> L82
        r4.b(r18);     // Catch: Throwable -> L82
        if (TextUtils.isEmpty(r17) == false) goto L69;
        String r7 = null;
    L70:
        r4.c(r7);     // Catch: Throwable -> L82
        if (this.f7381a.containsKey(r11) == false) goto L73;
        this.f7381a.get(r11).add(r4);     // Catch: Throwable -> L82
    L74:
        if (r20 == true) goto L85;
        return;
    L85:
        l(r11, r18, r17, r19);     // Catch: Throwable -> L78
        return;
    L78:
        th = move-exception;
        s4.h(th, "Cache", "add");     // Catch: Throwable -> L82
        return;
    L73:
        ArrayList<a> r8 = new ArrayList();     // Catch: Throwable -> L82
        r8.add(r4);     // Catch: Throwable -> L82
        this.f7381a.put(r11, r8);     // Catch: Throwable -> L82
        goto L74
    L69:
        r7 = r17.toString();     // Catch: Throwable -> L82
        goto L70
    L64:
        if (r1.V0().equals(r18.W0(3)) == false) goto L66;
        return;
    L48:
        if (TextUtils.isEmpty(r18.n1()) == true) goto L61;
        String r9 = r11.replace("cgiwifi", "cgi");     // Catch: Throwable -> L82
        ew r10 = r18.p1();     // Catch: Throwable -> L82
        if (a5.q(r10) == false) goto L61;
        m(r9, new StringBuilder(), r10, r19, true);     // Catch: Throwable -> L82
        goto L61
    L43:
        if (r18.getAccuracy() > 3.0f) goto L46;
        return;
    L53:
        if (r11.contains("cgi") == false) goto L61;
        if (r17 == null) goto L59;
        if (r17.indexOf(",") == (-1)) goto L59;
        return;
    L59:
        if ("4".equals(r18.h1()) == false) goto L61;
    }

    public final void t(Context r3) {
        v();     // Catch: Throwable -> L4
        w(r3);     // Catch: Throwable -> L4
        this.f7383c = false;     // Catch: Throwable -> L4
        this.f7388h = null;     // Catch: Throwable -> L4
        this.f7391k = 0;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        s4.h(th, "Cache", "destroy part");
    }
}
