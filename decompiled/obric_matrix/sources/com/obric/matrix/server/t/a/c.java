package com.obric.matrix.server.t.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.applog.e;
import com.bytedance.applog.l;
import com.bytedance.applog.m;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.server.q;
import com.obric.matrix.w.b0;
import com.obric.matrix.w.c0;
import com.obric.matrix.w.d0;
import com.obric.matrix.w.i0;
import com.obric.matrix.w.p;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.i0.m0;
import kotlin.i0.t0;
import kotlin.n0.d.o;
import kotlin.u;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u00107\u001a\u000208H\u0002J\u0010\u00109\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020\u001cH\u0002J\u000e\u0010;\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020\u001cJ\u001e\u0010<\u001a\u0002082\u0006\u0010:\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0005J\u0006\u0010@\u001a\u00020\u0005J\u0012\u0010A\u001a\u00020\"2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u000e\u0010B\u001a\u0002082\u0006\u0010:\u001a\u00020\u001cJ\u0016\u0010B\u001a\u0002082\u0006\u0010:\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020\u0005J\u001c\u0010C\u001a\u0002082\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050EH\u0002J\u0018\u0010F\u001a\u0002082\u0006\u0010G\u001a\u00020\u00052\b\u0010H\u001a\u0004\u0018\u00010IJ\u0006\u0010J\u001a\u000208J\u001a\u0010K\u001a\u0002082\u0006\u0010G\u001a\u00020\u00052\b\u0010H\u001a\u0004\u0018\u00010IH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0013R\u001a\u0010\u0019\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b.\u0010,R\u001a\u0010/\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010,\"\u0004\b1\u00102R\u000e\u00103\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00104\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010,\"\u0004\b6\u00102¨\u0006L"}, d2 = {"Lcom/obric/matrix/server/thirdapp/applog/ThirdApplogManager;", "", "()V", "BLACK_PKG_SET", "", "", "WHITE_PKG_SET", "appUeVersion", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "hasCheckSystemApp", "", "getHasCheckSystemApp", "()Z", "setHasCheckSystemApp", "(Z)V", "hasInitThirdApplog", "getHasInitThirdApplog", "setHasInitThirdApplog", "isUpLoadThirdDid", "setUpLoadThirdDid", "isUseMatrixSendApplog", "setUseMatrixSendApplog", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "matrixAppVersionCode", "", "pendingEventList", "Ljava/util/concurrent/ConcurrentHashMap;", "getPendingEventList", "()Ljava/util/concurrent/ConcurrentHashMap;", "setPendingEventList", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "platformSdkVersion", "spKeyOpenUid", "getSpKeyOpenUid", "()Ljava/lang/String;", "spName", "getSpName", "thirdAppId", "getThirdAppId", "setThirdAppId", "(Ljava/lang/String;)V", "thirdAppVersionCode", "thirdDid", "getThirdDid", "setThirdDid", "checkSendPendingEvent", "", "checkSysApp", "context", "checkUseMatrixSendEvent", "forceGetDeviceId", "observer", "Lcom/bytedance/applog/IDataObserver;", "appId", "getOpenUserId", "getVersionCode", "init", "invokeSendLog", "eventMap", "", "onEvent", "name", "param", "Lorg/json/JSONObject;", "onServiceConnected", "sendApplogUseBinder", "sdk_platform_server_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"StaticFieldLeak"})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f10010a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f10011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f10012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f10013d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static ConcurrentHashMap<String, String> f10014e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f10015f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Set<String> f10016g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Set<String> f10017h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f10018i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f10019j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static String f10020k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static long f10021l;
    private static long m;
    private static String n;
    private static final String o = null;
    private static final String p = null;

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J&\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0016JL\u0010\u0012\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0019"}, d2 = {"com/obric/matrix/server/thirdapp/applog/ThirdApplogManager$init$1", "Lcom/bytedance/applog/IDataObserver;", "onAbVidsChange", "", "vids", "", "extVids", "onIdLoaded", "did", WsConstants.KEY_INSTALL_ID, "ssid", "onRemoteAbConfigGet", "changed", "", "abConfig", "Lorg/json/JSONObject;", "onRemoteConfigGet", "config", "onRemoteIdGet", "oldDid", "newDid", "oldIid", "newIid", "oldSsid", "newSsid", "sdk_platform_server_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements e {
        a() {
        }

        @Override // com.bytedance.applog.e
        public void a(boolean r2, String r3, String r4, String r5, String r6, String r7, String r8) {
            com.obric.matrix.server.t.b.b.a("ThirdApplogInit", "onRemoteIdGet() called with: changed = " + r2 + ", oldDid = " + r3 + ", newDid = " + r4 + ", oldIid = " + r5 + ", newIid = " + r6 + ", oldSsid = " + r7 + ", newSsid = " + r8);
            c r1 = c.f10010a;
            if (TextUtils.equals(r1.h(), r4) == true) goto L6;
            r1.p(r4);
            return;
        }

        @Override // com.bytedance.applog.e
        public void b(String r2, String r3, String r4) {
            com.obric.matrix.server.t.b.b.a("ThirdApplogInit", "onIdLoaded() called with: did = " + r2 + ", iid = " + r3 + ", ssid = " + r4);
            if (TextUtils.isEmpty(r2) == false) goto L5;
            return;
        L5:
            c.f10010a.p(r2);
        }

        @Override // com.bytedance.applog.e
        public void c(boolean r1, JSONObject r2) {
        }

        @Override // com.bytedance.applog.e
        public void d(String r1, String r2) {
        }

        @Override // com.bytedance.applog.e
        public void e(boolean r1, JSONObject r2) {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/server/thirdapp/applog/ThirdApplogManager$invokeSendLog$1", "Lcom/obric/matrix/platform/server/IServerCallback$Stub;", "onResult", "", "cmd", "", "bytes", "", "sdk_platform_server_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b extends com.obric.matrix.platform.e.b.a {
        b() {
        }

        @Override // com.obric.matrix.platform.e.b
        public void A(int r1, byte[] r2) {
            if (r2 == null) goto L5;
            d0 r0 = d0.o.decode(r2);
            return;
        }
    }

    static {
        f10010a = new c();
        new Handler(Looper.getMainLooper());
        f10012c = "";
        f10013d = "";
        f10014e = new ConcurrentHashMap();
        f10016g = t0.b();
        f10017h = t0.b();
        f10021l = -1;
        m = -1;
        n = "";
        o = "__matrix_third_sp";
        p = "current_open_uid";
    }

    private c() {
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    private final void b() {
        Log.d("ThirdApplogInit", "sendPendingEvent: pendingEventList = " + f10014e);
        if ((!f10014e.isEmpty()) == false) goto L6;
        l(f10014e);
        f10014e.clear();
        return;
    }

    private final boolean c(Context r10) {
        String r0 = r10.getPackageName();
        boolean r1 = false;
        PackageInfo r3 = r10.getPackageManager().getPackageInfo(r0, 0);     // Catch: Exception -> L17
        if (r3 == null) goto L6;
        ApplicationInfo r4 = r3.applicationInfo;     // Catch: Exception -> L17
    L7:
        if (r4 != null) goto L9;
    L11:
        boolean r5 = false;
    L12:
        if (r5 == false) goto L20;
        if (f10017h.contains(r0) == true) goto L20;
        f10018i = true;     // Catch: Exception -> L17
    L20:
        if (f10018i == true) goto L25;
        if (f10016g.contains(r0) == false) goto L25;
        f10018i = true;
    L25:
        if (f10018i == true) goto L37;
        Cursor r11 = r10.getContentResolver().query(Uri.parse("content://com.obric.matrix.third.provider/check_is_ones"), null, null, null, null);
        if (r11 != null) goto L29;
    L34:
        com.obric.matrix.r.c.c.b("ThirdApplogInit", "checkSysApp: isUseMatrixSendApplog = " + f10018i);
        if (r11 == null) goto L37;
        r11.close();
        goto L37
    L29:
        if (r11.moveToFirst() == false) goto L34;
        if (r11.getInt(r11.getColumnIndex("is_ones")) != 1) goto L33;
        r1 = true;
    L33:
        f10018i = r1;
    L37:
        f10019j = true;
        return f10018i;
    L9:
        if ((r3.applicationInfo.flags & 1) == 0) goto L11;
        r5 = true;
        goto L12
    L6:
        r4 = null;
    L17:
        e = move-exception;
        Log.e("ThirdApplogInit", "checkSysApp failed", e);
        goto L20
    }

    private final long i(Context r4) {
        if (r4 != null) goto L17;
    L11:
        Long r5 = null;
    L12:
        o.c(r5);     // Catch: PackageManager.NameNotFoundException -> L9
        long r0 = r5.longValue();     // Catch: PackageManager.NameNotFoundException -> L9
    L15:
        com.obric.matrix.server.t.b.b.a("ThirdApplogInit", "getVersionCode = " + r0);
        return r0;
    L9:
        e = move-exception;
        com.obric.matrix.server.t.b.b.d("ThirdApplogInit", "getVersionCode error", e);
        r0 = 0;
        goto L15
    L17:
        PackageManager r1 = r4.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L9
        if (r1 == null) goto L11;
        PackageInfo r6 = r1.getPackageInfo(r4.getPackageName(), 0);     // Catch: PackageManager.NameNotFoundException -> L9
        if (r6 == null) goto L11;
        r5 = Long.valueOf(r6.getLongVersionCode());     // Catch: PackageManager.NameNotFoundException -> L9
        goto L12
    }

    private final void l(Map<String, String> r4) {
        i0.a r3 = new i0.a();
        r3.a(f10012c);
        r3.c(r4);
        i0 r5 = r3.b();
        b0.a r6 = new b0.a();
        p r0 = p.v;
        r6.h(Integer.valueOf(r0.getValue()));
        c0.a r1 = new c0.a();
        r1.k(r5);
        r6.e(r1.b());
        byte[] r7 = r6.f().encode();
        q.f9994a.n(r0.getValue(), "", r7, new b());
    }

    private final void o(String r3, JSONObject r4) {
        if (r4 != null) goto L4;
        r4 = new JSONObject();
    L4:
        r4.put("third_app_id", f10012c);
        if (q.f9994a.e() != null) goto L7;
        ConcurrentHashMap<String, String> r2 = f10014e;
        String r5 = r4.toString();
        o.e(r5, "realParam.toString()");
        r2.put(r3, r5);
        return;
    L7:
        b();
        l(m0.e(new u(r3, r4.toString())));
    }

    public final boolean d(Context r2) {
        o.f(r2, "context");
        if (f10019j == true) goto L6;
        c(r2);
    L6:
        return f10018i;
    }

    public final void e(Context r6, e r7, String r8) {
        o.f(r6, "context");
        o.f(r7, "observer");
        o.f(r8, "appId");
        Log.i("ThirdApplogInit", "forceGetDeviceId() called with: context = " + r6 + ", appId = " + r8);
        f10011b = r6.getApplicationContext();
        l r2 = new l(r8, "release");     // Catch: Exception -> L5
        r2.S(true);     // Catch: Exception -> L5
        r2.R("o_project_test");     // Catch: Exception -> L5
        r2.W(i(f10011b));     // Catch: Exception -> L5
        r2.V("applog_matrix_" + r8);     // Catch: Exception -> L5
        r2.X(m.a(0));     // Catch: Exception -> L5
        r2.T(new com.obric.matrix.server.t.a.b());     // Catch: Exception -> L5
        com.bytedance.applog.a.x(r6, r2);     // Catch: Exception -> L5
        com.bytedance.applog.a.a(r7);     // Catch: Exception -> L5
        Log.d("ThirdApplogInit", "forceGetDeviceId finished");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e("ThirdApplogInit", "forceGetDeviceId exception", e);
    }

    public final Context f() {
        return f10011b;
    }

    public final String g() {
        Context r3 = f10011b;
        if (r3 != null) goto L5;
        return "";
    L5:
        if (r3 == null) goto L9;
        SharedPreferences r4 = a(r3, o, 0);
        if (r4 == null) goto L9;
        String r5 = r4.getString(p, "");
    L10:
        if (r5 != null) goto L13;
        return "";
    L13:
        return r5;
    L9:
        r5 = null;
        goto L10
    }

    public final String h() {
        return f10013d;
    }

    public final synchronized void j(Context r2) {
        monitor-enter(this);
        o.f(r2, "context");     // Catch: Throwable -> L6
        k(r2, "");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void k(Context r7, String r8) {
        monitor-enter(this);
        o.f(r7, "context");     // Catch: Throwable -> L27
        o.f(r8, "appId");     // Catch: Throwable -> L27
        Log.e("ThirdApplogInit", "init() called with: context = " + r7 + ", appId = " + r8);     // Catch: Throwable -> L27
        f10011b = r7.getApplicationContext();     // Catch: Throwable -> L27
        if (r8.length() <= 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L31;
        f10012c = r8;     // Catch: Throwable -> L27
    L31:
    L23:
        e = move-exception;
        Log.e("ThirdApplogInit", "init exception", e);     // Catch: Throwable -> L27
    L25:
        monitor-exit(this);
        return;
    L10:
        if (f10015f == false) goto L13;
        monitor-exit(this);
        return;
    L13:
        f10015f = true;     // Catch: Exception -> L23 Throwable -> L27
        if (d(r7) == false) goto L17;
        monitor-exit(this);
        return;
    L17:
        l r3 = new l("508474", "release");     // Catch: Exception -> L23 Throwable -> L27
        r3.S(true);     // Catch: Exception -> L23 Throwable -> L27
        r3.R("o_project_test");     // Catch: Exception -> L23 Throwable -> L27
        r3.W(i(f10011b));     // Catch: Exception -> L23 Throwable -> L27
        r3.V("applog_matrix_508474");     // Catch: Exception -> L23 Throwable -> L27
        r3.X(m.a(0));     // Catch: Exception -> L23 Throwable -> L27
        r3.T(new com.obric.matrix.server.t.a.b());     // Catch: Exception -> L23 Throwable -> L27
        com.bytedance.applog.a.x(r7, r3);     // Catch: Exception -> L23 Throwable -> L27
        com.bytedance.applog.a.a(new a());     // Catch: Exception -> L23 Throwable -> L27
        Iterator<Map.Entry<String, String>> r9 = f10014e.entrySet().iterator();     // Catch: Exception -> L23 Throwable -> L27
    L19:
        if (r9.hasNext() == false) goto L21;
        Map.Entry<String, String> r10 = r9.next();     // Catch: Exception -> L23 Throwable -> L27
        com.bytedance.applog.a.F(r10.getKey(), new JSONObject(r10.getValue()));     // Catch: Exception -> L23 Throwable -> L27
        goto L19
    L21:
        Log.d("ThirdApplogInit", "init: isUseMatrixSendApplog = " + f10018i);     // Catch: Exception -> L23 Throwable -> L27
    L6:
        r0 = false;
    L27:
        th = move-exception;
        throw th;
    }

    public final void m(String r12, JSONObject r13) {
        o.f(r12, "name");
        Context r1 = f10011b;     // Catch: Exception -> L73
        if (r13 != null) goto L6;
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L73
    L7:
        r2.put("third_app_id", f10012c);     // Catch: Exception -> L73
        if (f10020k != null) goto L39;
        if (r1 == null) goto L39;
        PackageManager r3 = r1.getPackageManager();     // Catch: Exception -> L73
        String r4 = null;
        if (r3 == null) goto L14;
        ApplicationInfo r5 = r3.getApplicationInfo(r1.getPackageName(), 128);     // Catch: Exception -> L73
    L15:
        String r6 = "";
        if (r5 == null) goto L21;
        Bundle r7 = r5.metaData;     // Catch: Exception -> L73
        if (r7 == null) goto L21;
        String r8 = r7.getString("com.epicgames.ue4.GameActivity.EngineVersion");     // Catch: Exception -> L73
        if (r8 == null) goto L21;
    L22:
        f10020k = r8;     // Catch: Exception -> L73
        if (TextUtils.isEmpty(r8) == false) goto L31;
        if (r5 == null) goto L29;
        Bundle r9 = r5.metaData;     // Catch: Exception -> L73
        if (r9 == null) goto L29;
        String r10 = r9.getString("com.epicgames.unreal.GameActivity.EngineVersion");     // Catch: Exception -> L73
        if (r10 == null) goto L29;
    L30:
        f10020k = r10;     // Catch: Exception -> L73
    L29:
        r10 = "";
    L31:
        if (r5 == null) goto L35;
        Bundle r11 = r5.metaData;     // Catch: Exception -> L73
        if (r11 == null) goto L35;
        r4 = r11.getString("pvr.sdk.version");     // Catch: Exception -> L73
    L35:
        if (r4 == null) goto L38;
        r6 = r4;
    L38:
        n = r6;     // Catch: Exception -> L73
    L21:
        r8 = "";
        goto L22
    L14:
        r5 = null;
    L39:
        r2.put("app_ue_version", f10020k);     // Catch: Exception -> L73
        if (r1 == null) goto L60;
        r2.put("third_app_name", r1.getPackageName());     // Catch: Exception -> L73
        long r14 = -1;
        if (f10021l >= 0) goto L51;
        PackageManager r15 = r1.getPackageManager();     // Catch: Exception -> L73
        if (r15 == null) goto L48;
        PackageInfo r16 = r15.getPackageInfo(r1.getPackageName(), 0);     // Catch: Exception -> L73
        if (r16 == null) goto L48;
        long r17 = r16.getLongVersionCode();     // Catch: Exception -> L73
    L49:
        f10021l = r17;     // Catch: Exception -> L73
    L48:
        r17 = -1;
    L51:
        if (m >= 0) goto L58;
        PackageManager r18 = r1.getPackageManager();     // Catch: Exception -> L73
        if (r18 == null) goto L57;
        PackageInfo r19 = r18.getPackageInfo("com.obric.matrix", 0);     // Catch: Exception -> L73
        if (r19 == null) goto L57;
        r14 = r19.getLongVersionCode();     // Catch: Exception -> L73
    L57:
        m = r14;     // Catch: Exception -> L73
    L58:
        r2.put("third_app_version", f10021l);     // Catch: Exception -> L73
        r2.put("matrix_app_version", m);     // Catch: Exception -> L73
        r2.put("platform_sdk_version", n);     // Catch: Exception -> L73
        r2.put("third_open_id", g());     // Catch: Exception -> L73
    L60:
        if ("coverage" != "release") goto L63;
        com.obric.matrix.server.t.b.b.a("ThirdApplogInit", "onEvent() called with: name = " + r12 + ", param = " + r2 + " isUseMatrixSendApplog= " + f10018i);     // Catch: Exception -> L73
    L63:
        if (f10019j == true) goto L65;
    L71:
        ConcurrentHashMap<String, String> r110 = f10014e;     // Catch: Exception -> L73
        String r111 = r2.toString();     // Catch: Exception -> L73
        o.e(r111, "realParam.toString()");     // Catch: Exception -> L73
        r110.put(r12, r111);     // Catch: Exception -> L73
        return;
    L65:
        if (f10011b == null) goto L71;
        if (f10018i == false) goto L70;
        o(r12, r13);     // Catch: Exception -> L73
        return;
    L70:
        com.bytedance.applog.a.F(r12, r2);     // Catch: Exception -> L73
        return;
    L6:
        r2 = r13;
    L73:
        e = move-exception;
        Log.e("ThirdApplogInit", "OnEvent failed", e);
    }

    public final void n() {
        if (f10018i == false) goto L6;
        b();
        return;
    }

    public final void p(String r1) {
        f10013d = r1;
    }
}
