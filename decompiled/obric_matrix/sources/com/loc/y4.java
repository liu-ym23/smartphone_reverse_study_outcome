package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class y4 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static List<z0> f7997g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static JSONArray f7998h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static AMapLocation f7999i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static boolean f8000j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SparseArray<Long> f8001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f8003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String[] f8004d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8005e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f8006f;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8007a = null;

        static {
            int[] r0 = new int[AMapLocationClientOption.b.values().length];
            f8007a = r0;
            r0[AMapLocationClientOption.b.f489f.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f8007a[AMapLocationClientOption.b.f490g.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f8007a[AMapLocationClientOption.b.f491h.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        f7997g = new ArrayList();
        f7998h = null;
        f7999i = null;
        f8000j = false;
    }

    public y4() {
        this.f8001a = new SparseArray();
        this.f8002b = -1;
        this.f8003c = 0;
        this.f8004d = new String[]{"ol", "cl", "gl", "ha", "bs", "ds"};
        this.f8005e = -1;
        this.f8006f = -1;
    }

    private static String a(int r1) {
        if (r1 != 2011) goto L5;
        return "ContextIsNull";
    L5:
        if (r1 != 2031) goto L7;
        return "CreateApsReqException";
    L7:
        if (r1 != 2041) goto L9;
        return "ResponseResultIsNull";
    L9:
        if (r1 != 2081) goto L11;
        return "LocalLocException";
    L11:
        if (r1 != 2091) goto L13;
        return "InitException";
    L13:
        if (r1 != 2111) goto L15;
        return "ErrorCgiInfo";
    L15:
        if (r1 != 2121) goto L17;
        return "NotLocPermission";
    L17:
        if (r1 != 2141) goto L19;
        return "NoEnoughStatellites";
    L19:
        if (r1 != 2021) goto L21;
        return "OnlyMainWifi";
    L21:
        if (r1 != 2022) goto L23;
        return "OnlyOneWifiButNotMain";
    L23:
        if (r1 != 2061) goto L25;
        return "ServerRetypeError";
    L25:
        if (r1 == 2062) goto L45;
        switch(r1) {
            case 2051: goto L44;
            case 2052: goto L43;
            case 2053: goto L42;
            case 2054: goto L41;
            default: goto L27;
        };
    L27:
        switch(r1) {
            case 2101: goto L40;
            case 2102: goto L39;
            case 2103: goto L38;
            default: goto L28;
        };
    L28:
        switch(r1) {
            case 2131: goto L37;
            case 2132: goto L36;
            case 2133: goto L35;
            default: goto L29;
        };
    L29:
        switch(r1) {
            case 2151: goto L34;
            case 2152: goto L33;
            case 2153: goto L32;
            case 2154: goto L31;
            default: goto L30;
        };
    L30:
        return "";
    L31:
        return "UNSUPPORT_CONTINUE_LOC";
    L32:
        return "UNSUPPORT_COARSE_LBSLOC";
    L33:
        return "MaybeMockGPSLoc";
    L34:
        return "MaybeMockNetLoc";
    L35:
        return "NoCgiAndWifiOff";
    L36:
        return "AirPlaneModeAndWifiOff";
    L37:
        return "NoCgiOAndWifiInfo";
    L38:
        return "NotConfigAPSService";
    L39:
        return "AuthClientScodeFail";
    L40:
        return "BindAPSServiceException";
    L41:
        return "ParserDataException";
    L42:
        return "DecryptResponseException";
    L43:
        return "MaybeIntercepted";
    L44:
        return "NeedLoginNetWork\t";
    L45:
        return "ServerLocFail";
    }

    public static void b(long r5, long r7) {
        if (f8000j == false) goto L6;
        return;
    L6:
        StringBuffer r2 = new StringBuffer();     // Catch: Throwable -> L16
        r2.append("gpsTime:");     // Catch: Throwable -> L16
        r2.append(a5.i(r5, "yyyy-MM-dd HH:mm:ss.SSS"));     // Catch: Throwable -> L16
        r2.append(",");     // Catch: Throwable -> L16
        r2.append("sysTime:");     // Catch: Throwable -> L16
        r2.append(a5.i(r7, "yyyy-MM-dd HH:mm:ss.SSS"));     // Catch: Throwable -> L16
        r2.append(",");     // Catch: Throwable -> L16
        long r8 = r4.L();     // Catch: Throwable -> L16
        String r0 = BDLocationException.ERROR_TIMEOUT;
        if (0 == r8) goto L9;
        r0 = a5.i(r8, "yyyy-MM-dd HH:mm:ss.SSS");     // Catch: Throwable -> L16
    L9:
        r2.append("serverTime:");     // Catch: Throwable -> L16
        r2.append(r0);     // Catch: Throwable -> L16
        q("checkgpstime", r2.toString());     // Catch: Throwable -> L16
        if (0 != r8) goto L12;
    L14:
        r2.delete(0, r2.length());     // Catch: Throwable -> L16
        f8000j = true;     // Catch: Throwable -> L16
        return;
    L12:
        if (Math.abs(r5 - r8) >= 31536000000L) goto L14;
        r2.append(", correctError");     // Catch: Throwable -> L16
        q("checkgpstimeerror", r2.toString());     // Catch: Throwable -> L16
    }

    public static synchronized void c(Context r3) {
        monitor-enter(y4.class);
        if (r3 != null) goto L27;
    L23:
        monitor-exit(y4.class);
        return;
    L27:
    L16:
        th = move-exception;
        s4.h(th, "ReportUtil", "destroy");     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    L6:
        if (r4.e() == false) goto L23;
        List<z0> r1 = f7997g;     // Catch: Throwable -> L16
        if (r1 != null) goto L11;
    L13:
        z(r3);     // Catch: Throwable -> L16
        monitor-exit(y4.class);
        return;
    L11:
        if (r1.size() <= 0) goto L13;
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L16
        r2.addAll(f7997g);     // Catch: Throwable -> L16
        a1.h(r2, r3);     // Catch: Throwable -> L16
        f7997g.clear();     // Catch: Throwable -> L16
        goto L13
    }

    public static void e(Context r9, int r10, int r11, long r12, long r14) {
        if (r10 == (-1)) goto L13;
        if (r11 == (-1)) goto L14;
        k(r9, "O012", r10, r11, r12, r14);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        s4.h(th, "ReportUtil", "reportServiceAliveTime");
        return;
    L14:
        return;
    }

    public static void f(Context r1, long r2, boolean r4) {
        if (r1 == null) goto L13;
    L8:
        th = move-exception;
        s4.h(th, "ReportUtil", "reportGPSLocUseTime");
        return;
    L4:
        if (r4.e() == false) goto L14;
        g(r1, r2, r4, "O015");     // Catch: Throwable -> L8
        return;
    L14:
        return;
    }

    private static void g(Context r0, long r1, boolean r3, String r4) {
        int r2 = Long.valueOf(r1).intValue();
        if (r3 == true) goto L5;
        String r5 = "abroad";
    L6:
        l(r0, r4, r5, r2);
        return;
    L5:
        r5 = "domestic";
        goto L6
    }

    public static synchronized void h(Context r8, AMapLocation r9) {
        monitor-enter(y4.class);
    L51:
        th = move-exception;
        s4.h(th, "ReportUtil", "recordOfflineLocLog");     // Catch: Throwable -> L55
        return;
    L55:
        th = move-exception;
        throw th;
    L5:
        if (a5.p(r9) == true) goto L8;
        monitor-exit(y4.class);
        return;
    L8:
        int r1 = r9.Y();     // Catch: Throwable -> L51
        int r3 = 0;
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L22;
        if (r1 == 4) goto L22;
        if (r1 != 11) goto L15;
        int r2 = 4;
    L24:
        r3 = 1;
    L25:
        if (r3 == 0) goto L49;
        int r4 = r4.l();     // Catch: Throwable -> L51
        if (r4 == 0) goto L38;
        if (r2 == 0) goto L34;
        if (r2 == 4) goto L34;
        if (r4 != 1) goto L38;
        monitor-exit(y4.class);
        return;
    L34:
        if (r4 != 2) goto L38;
        monitor-exit(y4.class);
        return;
    L38:
        if (f7998h != null) goto L40;
        f7998h = new JSONArray();     // Catch: Throwable -> L51
    L40:
        JSONObject r5 = new JSONObject();     // Catch: Throwable -> L51
        r5.put("lon", a5.y(r9.getLongitude()));     // Catch: Throwable -> L51
        r5.put("lat", a5.y(r9.getLatitude()));     // Catch: Throwable -> L51
        r5.put(WsConstants.KEY_CONNECTION_TYPE, r2);     // Catch: Throwable -> L51
        r5.put("timestamp", a5.f());     // Catch: Throwable -> L51
        if (r9.Q().equalsIgnoreCase("WGS84") == false) goto L43;
        r5.put("coordType", 1);     // Catch: Throwable -> L51
    L44:
        if (r2 != 0) goto L46;
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L51
        r6.put(LocationMonitorConst.ACCURACY, a5.H(r9.getAccuracy()));     // Catch: Throwable -> L51
        r6.put("altitude", a5.H(r9.getAltitude()));     // Catch: Throwable -> L51
        r6.put("bearing", a5.H(r9.getBearing()));     // Catch: Throwable -> L51
        r6.put("speed", a5.H(r9.getSpeed()));     // Catch: Throwable -> L51
        r5.put("extension", r6);     // Catch: Throwable -> L51
    L46:
        JSONArray r10 = f7998h.put(r5);     // Catch: Throwable -> L51
        f7998h = r10;     // Catch: Throwable -> L51
        if (r10.length() < r4.i()) goto L49;
        z(r8);     // Catch: Throwable -> L51
        goto L49
    L43:
        r5.put("coordType", 2);     // Catch: Throwable -> L51
    L49:
        monitor-exit(y4.class);
        return;
    L15:
        if (r1 != 8) goto L17;
        r3 = 3;
        goto L23
    L17:
        if (r1 == 9) goto L19;
        r2 = 0;
        goto L25
    L19:
        r2 = 2;
    L22:
        r2 = 1;
        r3 = 1;
    L23:
        r2 = r3;
        goto L24
    }

    public static void i(Context r8, AMapLocation r9, eq r10) {
        if (r9 != null) goto L35;
        return;
    L35:
    L32:
        th = move-exception;
        s4.h(th, "ReportUtil", "reportBatting");
        return;
    L5:
        if ("gps".equalsIgnoreCase(r9.getProvider()) == false) goto L7;
        return;
    L7:
        if (r9.Y() == 1) goto L38;
        String r0 = "domestic";
        if (t(r9) == false) goto L12;
        r0 = "abroad";
    L12:
        String r3 = r0;
        int r1 = r9.U();     // Catch: Throwable -> L32
        String r2 = LocationMonitorConst.CACHE;
        if (r1 == 0) goto L24;
        int r4 = r9.U();     // Catch: Throwable -> L32
        if (r4 == 4) goto L22;
        if (r4 == 5) goto L22;
        if (r4 == 6) goto L22;
        if (r4 == 11) goto L22;
    L23:
        int r5 = 0;
    L30:
        m(r8, "O016", r2, r3, r5, r9.U(), r10);     // Catch: Throwable -> L32
        return;
    L22:
        r2 = "net";
        goto L23
    L24:
        int r6 = r9.Y();     // Catch: Throwable -> L32
        if (r6 == 5) goto L28;
        if (r6 == 6) goto L28;
    L29:
        r5 = 1;
    L28:
        r2 = "net";
        goto L29
    }

    private static void k(Context r2, String r3, int r4, int r5, long r6, long r8) {
        if (r2 == null) goto L13;
    L8:
        th = move-exception;
        s4.h(th, "ReportUtil", "applyStatisticsEx");
        return;
    L4:
        if (r4.e() == false) goto L14;
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L8
        r0.put("param_int_first", r4);     // Catch: Throwable -> L8
        r0.put("param_int_second", r5);     // Catch: Throwable -> L8
        r0.put("param_long_first", r6);     // Catch: Throwable -> L8
        r0.put("param_long_second", r8);     // Catch: Throwable -> L8
        n(r2, r3, r0);     // Catch: Throwable -> L8
        return;
    L14:
        return;
    }

    private static void l(Context r2, String r3, String r4, int r5) {
        if (r2 == null) goto L22;
    L17:
        th = move-exception;
        s4.h(th, "ReportUtil", "applyStatisticsEx");
        return;
    L4:
        if (r4.e() == false) goto L23;
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r4) == true) goto L10;
        r0.put("param_string_first", r4);     // Catch: Throwable -> L17
    L10:
        if (TextUtils.isEmpty(null) == true) goto L13;
        r0.put("param_string_second", null);     // Catch: Throwable -> L17
    L13:
        if (r5 == Integer.MAX_VALUE) goto L15;
        r0.put("param_int_first", r5);     // Catch: Throwable -> L17
    L15:
        n(r2, r3, r0);     // Catch: Throwable -> L17
        return;
    L23:
        return;
    }

    private static void m(Context r3, String r4, String r5, String r6, int r7, int r8, eq r9) {
        if (r3 == null) goto L49;
    L44:
        th = move-exception;
        s4.h(th, "ReportUtil", "applyStatisticsEx");
        return;
    L4:
        if (r4.e() == false) goto L50;
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L44
        if (TextUtils.isEmpty(r5) == true) goto L10;
        r0.put("param_string_first", r5);     // Catch: Throwable -> L44
    L10:
        if (TextUtils.isEmpty(r6) == true) goto L13;
        r0.put("param_string_second", r6);     // Catch: Throwable -> L44
    L13:
        if (r7 == Integer.MAX_VALUE) goto L15;
        r0.put("param_int_first", r7);     // Catch: Throwable -> L44
    L15:
        if (r8 == Integer.MAX_VALUE) goto L17;
        r0.put("param_int_second", r8);     // Catch: Throwable -> L44
    L17:
        if (r9 != null) goto L19;
    L42:
        n(r3, r4, r0);     // Catch: Throwable -> L44
        return;
    L19:
        if (TextUtils.isEmpty(r9.p()) == true) goto L22;
        r0.put("dns", r9.p());     // Catch: Throwable -> L44
    L22:
        if (TextUtils.isEmpty(r9.v()) == true) goto L25;
        r0.put("domain", r9.v());     // Catch: Throwable -> L44
    L25:
        if (TextUtils.isEmpty(r9.x()) == true) goto L28;
        r0.put(WsConstants.KEY_CONNECTION_TYPE, r9.x());     // Catch: Throwable -> L44
    L28:
        if (TextUtils.isEmpty(r9.z()) == true) goto L31;
        r0.put("reason", r9.z());     // Catch: Throwable -> L44
    L31:
        if (TextUtils.isEmpty(r9.i()) == true) goto L34;
        r0.put("ip", r9.i());     // Catch: Throwable -> L44
    L34:
        if (TextUtils.isEmpty(r9.f()) == true) goto L37;
        r0.put("stack", r9.f());     // Catch: Throwable -> L44
    L37:
        if (r9.A() <= 0) goto L40;
        r0.put("ctime", String.valueOf(r9.A()));     // Catch: Throwable -> L44
    L40:
        if (r9.b() <= 0) goto L42;
        r0.put("ntime", String.valueOf(r9.b()));     // Catch: Throwable -> L44
        goto L42
    L50:
        return;
    }

    public static synchronized void n(Context r4, String r5, JSONObject r6) {
        monitor-enter(y4.class);
        if (r4 != null) goto L25;
    L23:
        monitor-exit(y4.class);
        return;
    L25:
    L16:
        th = move-exception;
        s4.h(th, "ReportUtil", "applyStatistics");     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    L6:
        if (r4.e() == false) goto L23;
        z0 r1 = new z0(r4, "loc", "6.4.0", r5);     // Catch: Throwable -> L16
        if (r6 == null) goto L11;
        r1.a(r6.toString());     // Catch: Throwable -> L16
    L11:
        f7997g.add(r1);     // Catch: Throwable -> L16
        if (f7997g.size() < 30) goto L14;
        ArrayList r7 = new ArrayList();     // Catch: Throwable -> L16
        r7.addAll(f7997g);     // Catch: Throwable -> L16
        a1.h(r7, r4);     // Catch: Throwable -> L16
        f7997g.clear();     // Catch: Throwable -> L16
    L14:
        monitor-exit(y4.class);
    }

    public static void o(AMapLocation r8, AMapLocation r9) {
        if (f7999i != null) goto L11;
        if (a5.p(r8) == true) goto L9;
        f7999i = r9;     // Catch: Throwable -> L51
        return;
    L9:
        f7999i = r8.z();     // Catch: Throwable -> L51
    L11:
        if (a5.p(f7999i) == true) goto L13;
        return;
    L13:
        if (a5.p(r9) == false) goto L54;
        AMapLocation r10 = r9.z();     // Catch: Throwable -> L51
        if (f7999i.Y() != 1) goto L17;
    L49:
        f7999i = r10;     // Catch: Throwable -> L51
        return;
    L17:
        if (f7999i.Y() == 9) goto L49;
        if ("gps".equalsIgnoreCase(f7999i.getProvider()) == true) goto L49;
        if (f7999i.Y() == 7) goto L49;
        if (r10.Y() == 1) goto L49;
        if (r10.Y() == 9) goto L49;
        if ("gps".equalsIgnoreCase(r10.getProvider()) == true) goto L49;
        if (r10.Y() == 7) goto L49;
        long r2 = Math.abs(r10.getTime() - f7999i.getTime()) / 1000;     // Catch: Throwable -> L51
        if (r2 > 0) goto L34;
        r2 = 1;
    L34:
        if (r2 > 1800) goto L49;
        float r0 = a5.c(f7999i, r10);     // Catch: Throwable -> L51
        float r3 = r0 / r2;     // Catch: Throwable -> L51
        if (r0 <= 30000.0f) goto L49;
        if (r3 <= 1000.0f) goto L49;
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L51
        r1.append(f7999i.getLatitude());     // Catch: Throwable -> L51
        r1.append(",");     // Catch: Throwable -> L51
        r1.append(f7999i.getLongitude());     // Catch: Throwable -> L51
        r1.append(",");     // Catch: Throwable -> L51
        r1.append(f7999i.getAccuracy());     // Catch: Throwable -> L51
        r1.append(",");     // Catch: Throwable -> L51
        r1.append(f7999i.Y());     // Catch: Throwable -> L51
        r1.append(",");     // Catch: Throwable -> L51
        if (r8.getTime() == 0) goto L43;
        r1.append(a5.i(f7999i.getTime(), "yyyyMMdd_HH:mm:ss:SS"));     // Catch: Throwable -> L51
    L44:
        r1.append("#");     // Catch: Throwable -> L51
        r1.append(r10.getLatitude());     // Catch: Throwable -> L51
        r1.append(",");     // Catch: Throwable -> L51
        r1.append(r10.getLongitude());     // Catch: Throwable -> L51
        r1.append(",");     // Catch: Throwable -> L51
        r1.append(r10.getAccuracy());     // Catch: Throwable -> L51
        r1.append(",");     // Catch: Throwable -> L51
        r1.append(r10.Y());     // Catch: Throwable -> L51
        r1.append(",");     // Catch: Throwable -> L51
        if (r10.getTime() == 0) goto L47;
        r1.append(a5.i(r10.getTime(), "yyyyMMdd_HH:mm:ss:SS"));     // Catch: Throwable -> L51
    L48:
        q("bigshiftstatistics", r1.toString());     // Catch: Throwable -> L51
        r1.delete(0, r1.length());     // Catch: Throwable -> L51
        goto L49
    L47:
        r1.append(r10.getTime());     // Catch: Throwable -> L51
        goto L48
    L43:
        r1.append(f7999i.getTime());     // Catch: Throwable -> L51
        goto L44
    L54:
        return;
    }

    public static void p(String r1, int r2) {
        r(r1, String.valueOf(r2), a(r2));
    }

    public static void q(String r1, String r2) {
        v.l(s4.q(), r2, r1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        s4.h(th, "ReportUtil", "reportLog");
    }

    public static void r(String r2, String r3, String r4) {
        v.i(s4.q(), "/mobile/binary", r4, r2, r3);     // Catch: Throwable -> L4
        return;
    }

    public static void s(String r1, Throwable r2) {
        if ((r2 instanceof h5) == false) goto L9;
        v.h(s4.q(), r1, (h5) r2);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    private static boolean t(AMapLocation r7) {
        if (a5.p(r7) == false) goto L9;
        if (s4.i(r7.getLatitude(), r7.getLongitude()) == false) goto L7;
        return false;
    L7:
        return true;
    L9:
        if ("http://abroad.apilocate.amap.com/mobile/binary".equals(s4.f7770c) == false) goto L11;
        return true;
    L11:
        return false;
    }

    public static void v(Context r1, long r2, boolean r4) {
        if (r1 == null) goto L13;
    L8:
        th = move-exception;
        s4.h(th, "ReportUtil", "reportCoarseLocUseTime");
        return;
    L4:
        if (r4.e() == false) goto L14;
        g(r1, r2, r4, "O024");     // Catch: Throwable -> L8
        return;
    L14:
        return;
    }

    private static void z(Context r3) {
        JSONArray r0 = f7998h;     // Catch: Throwable -> L8
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length() <= 0) goto L14;
        y0.d(new x0(r3, s4.q(), f7998h.toString()), r3);     // Catch: Throwable -> L8
        f7998h = null;     // Catch: Throwable -> L8
        return;
    L14:
        return;
    L8:
        th = move-exception;
        s4.h(th, "ReportUtil", "writeOfflineLocLog");
    }

    public final void d(Context r9, int r10) {
        int r0 = this.f8002b;     // Catch: Throwable -> L11
        if (r0 != r10) goto L6;
        return;
    L6:
        if (r0 == (-1)) goto L9;
        if (r0 == r10) goto L9;
        long r1 = a5.A() - this.f8003c;     // Catch: Throwable -> L11
        long r4 = this.f8001a.get(this.f8002b, 0L).longValue();     // Catch: Throwable -> L11
        this.f8001a.append(this.f8002b, Long.valueOf(r1 + r4));     // Catch: Throwable -> L11
    L9:
        long r2 = z4.c(r9, "pref1", this.f8004d[r10], 0);     // Catch: Throwable -> L11
        this.f8003c = a5.A() - r2;     // Catch: Throwable -> L11
        this.f8002b = r10;     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        s4.h(th, "ReportUtil", "setLocationType");
    }

    public final void j(Context r10, AMapLocationClientOption r11) {
        int r12 = a.f8007a[r11.B().ordinal()];     // Catch: Throwable -> L19
        int r1 = 3;
        if (r12 != 1) goto L5;
        r1 = 4;
    L10:
        int r13 = this.f8005e;     // Catch: Throwable -> L19
        if (r13 != r1) goto L14;
        return;
    L14:
        if (r13 == (-1)) goto L17;
        if (r13 == r1) goto L17;
        this.f8001a.append(this.f8005e, Long.valueOf((a5.A() - this.f8006f) + this.f8001a.get(this.f8005e, 0L).longValue()));     // Catch: Throwable -> L19
    L17:
        this.f8006f = a5.A() - z4.c(r10, "pref1", this.f8004d[r1], 0);     // Catch: Throwable -> L19
        this.f8005e = r1;     // Catch: Throwable -> L19
        return;
    L5:
        if (r12 == 2) goto L8;
        if (r12 == 3) goto L10;
        r1 = -1;
        goto L10
    L8:
        r1 = 5;
    L19:
        th = move-exception;
        s4.h(th, "ReportUtil", "setLocationMode");
    }

    public final void u(Context r11) {
        long r1 = a5.A() - this.f8003c;     // Catch: Throwable -> L20
        int r3 = this.f8002b;     // Catch: Throwable -> L20
        if (r3 == (-1)) goto L6;
        long r7 = this.f8001a.get(r3, 0L).longValue();     // Catch: Throwable -> L20
        this.f8001a.append(this.f8002b, Long.valueOf(r1 + r7));     // Catch: Throwable -> L20
    L6:
        long r2 = a5.A() - this.f8006f;     // Catch: Throwable -> L20
        int r4 = this.f8005e;     // Catch: Throwable -> L20
        if (r4 == (-1)) goto L9;
        long r5 = this.f8001a.get(r4, 0L).longValue();     // Catch: Throwable -> L20
        this.f8001a.append(this.f8005e, Long.valueOf(r2 + r5));     // Catch: Throwable -> L20
    L9:
        SharedPreferences.Editor r6 = z4.d(r11, "pref1");     // Catch: Throwable -> L20
        int r8 = 0;
    L11:
        if (r8 >= this.f8004d.length) goto L18;
        long r9 = this.f8001a.get(r8, 0L).longValue();     // Catch: Throwable -> L20
        if (r9 <= 0) goto L17;
        if (r9 <= z4.c(r11, "pref1", this.f8004d[r8], 0)) goto L17;
        z4.j(r6, this.f8004d[r8], r9);     // Catch: Throwable -> L20
    L17:
        r8 = r8 + 1;     // Catch: Throwable -> L20
        goto L11
    L18:
        z4.g(r6);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        s4.h(th, "ReportUtil", "saveLocationTypeAndMode");
    }

    public final int w(Context r12) {
        long r6 = z4.c(r12, "pref1", this.f8004d[2], 0);     // Catch: Throwable -> L21
        long r9 = z4.c(r12, "pref1", this.f8004d[0], 0);     // Catch: Throwable -> L21
        long r11 = z4.c(r12, "pref1", this.f8004d[1], 0);     // Catch: Throwable -> L21
        if (r6 == 0) goto L7;
    L11:
        long r10 = r9 - r6;
        long r13 = r11 - r6;
        if (r6 <= r10) goto L18;
        if (r6 <= r13) goto L16;
        return 2;
    L16:
        return 1;
    L18:
        if (r10 <= r13) goto L20;
        return 0;
    L20:
        return 1;
    L7:
        if (r9 != 0) goto L11;
        if (r11 != 0) goto L11;
        return -1;
    L21:
        return -1;
    }

    public final int x(Context r12) {
        long r6 = z4.c(r12, "pref1", this.f8004d[3], 0);     // Catch: Throwable -> L21
        long r9 = z4.c(r12, "pref1", this.f8004d[4], 0);     // Catch: Throwable -> L21
        long r11 = z4.c(r12, "pref1", this.f8004d[5], 0);     // Catch: Throwable -> L21
        if (r6 != 0) goto L12;
        if (r9 != 0) goto L12;
        if (r11 != 0) goto L12;
        return -1;
    L12:
        if (r6 <= r9) goto L18;
        if (r6 <= r11) goto L16;
        return 3;
    L16:
        return 5;
    L18:
        if (r9 <= r11) goto L20;
        return 4;
    L20:
        return 5;
    L21:
        return -1;
    }

    public final void y(Context r5) {
        SharedPreferences.Editor r6 = z4.d(r5, "pref1");     // Catch: Throwable -> L8
        int r0 = 0;
    L3:
        String[] r1 = this.f8004d;     // Catch: Throwable -> L8
        if (r0 >= r1.length) goto L6;
        z4.j(r6, r1[r0], 0);     // Catch: Throwable -> L8
        r0 = r0 + 1;     // Catch: Throwable -> L8
        goto L3
    L6:
        z4.g(r6);     // Catch: Throwable -> L8
        return;
    }
}
