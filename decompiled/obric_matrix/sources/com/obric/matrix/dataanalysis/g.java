package com.obric.matrix.dataanalysis;

import android.app.usage.StorageStatsManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.storage.StorageManager;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.obric.matrix.base.settings.iconfig.ITeaSettings;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.a0;
import kotlin.f0;
import kotlin.i0.m0;
import kotlin.n0.d.i0;
import kotlin.n0.d.o;
import kotlin.u;
import kotlin.u0.k;
import kotlin.v;
import kotlin.w;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 T2\u00020\u0001:\u0001TB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010 \u001a\u00020!J\b\u0010\"\u001a\u00020!H\u0002J(\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010$2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010$J\u0006\u0010&\u001a\u00020\fJ\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020\fJ\u0006\u0010*\u001a\u00020(J\u0006\u0010+\u001a\u00020\fJ\u0006\u0010,\u001a\u00020(J\u0006\u0010-\u001a\u00020\fJ\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u00020(J\u0006\u00101\u001a\u00020\fJ\u0006\u00102\u001a\u00020(J\u0006\u00103\u001a\u00020\nJ\u0006\u00104\u001a\u00020\fJ\u0006\u00105\u001a\u00020\fJ\b\u00106\u001a\u00020\fH\u0002J\u0006\u00107\u001a\u00020\fJ\u0006\u00108\u001a\u00020\fJ\u0006\u00109\u001a\u00020(J\b\u0010:\u001a\u00020\fH\u0007J\u0006\u0010;\u001a\u00020\fJ\u0006\u0010<\u001a\u00020(J\u0006\u0010=\u001a\u00020\fJ\u0006\u0010>\u001a\u00020\fJ\u0006\u0010?\u001a\u00020\fJ\u0006\u0010@\u001a\u00020\fJ\u0006\u0010A\u001a\u00020\fJ\u0006\u0010B\u001a\u00020\fJ\u0006\u0010C\u001a\u00020\fJ\u0006\u0010D\u001a\u00020\fJ\u0006\u0010E\u001a\u00020\fJ\u000e\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020\fJ\u0006\u0010H\u001a\u00020\fJ\b\u0010I\u001a\u00020!H\u0002J\b\u0010J\u001a\u00020!H\u0002J\b\u0010K\u001a\u00020!H\u0002J\b\u0010L\u001a\u00020!H\u0002J\u0018\u0010M\u001a\u00020\f2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020QH\u0002J\u0010\u0010R\u001a\u00020!2\u0006\u0010S\u001a\u00020\bH\u0002R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/obric/matrix/dataanalysis/CommonParamUtil;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appContext", "kotlin.jvm.PlatformType", "batteryReceiver", "Landroid/content/BroadcastReceiver;", "cachedIsCharging", "", "cachedLanguage", "", "cachedNetworkType", "cachedOtaVersion", "cachedRomMajorVersion", "cachedStorageAvailable", "cachedStorageTotal", "cachedTimezone", "city", "country", "district", "initLock", "latitude", "localeReceiver", "longitude", "networkCallback", "Landroid/net/ConnectivityManager$NetworkCallback;", "paramsListenersInited", "province", "storageReceiver", "timezoneReceiver", "destroy", "", "ensureParamsListenersInited", "getAllProperties", "", "params", "getAppPackageName", "getAppVersionCode", "", "getAppVersionName", "getBatteryCapacity", "getCpuArchitecture", "getCpuCoreCount", "getCpuString", "getCurrentScreenBrightness", "", "getDeviceBatteryPercent", "getDeviceBrand", "getDeviceHeight", "getDeviceIsCharging", "getDeviceModel", "getDevicePoweronDuration", "getDeviceProcessorInfo", "getDeviceResolution", "getDeviceSerialNumber", "getDeviceWidth", "getImei", "getIpAddress", "getOsApi", "getOsBaseband", "getOsBuildDate", "getOsKernal", "getOsLanguage", "getOsNetworkType", "getOsOtaMajorVersion", "getOsOtaVersion", "getOsTimezone", "getSDAvailableSize", "getSystemProperty", "fieldName", "getTotalStorageSize", "registerBatteryReceiver", "registerLocaleReceiver", "registerNetworkCallback", "registerTimezoneReceiver", "resolveNetworkTypeName", "cm", "Landroid/net/ConnectivityManager;", "network", "Landroid/net/Network;", "safeUnregister", "receiver", "Companion", "dataanalysis_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f9042l = null;
    private static g m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f9044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f9045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f9046d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile String f9047e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile String f9048f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile String f9049g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile String f9050h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile String f9051i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile String f9052j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile String f9053k;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/matrix/dataanalysis/CommonParamUtil$Companion;", "", "()V", "TAG", "", "instance", "Lcom/obric/matrix/dataanalysis/CommonParamUtil;", "getInstance", "context", "Landroid/content/Context;", "dataanalysis_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final g a(Context r2) {
            o.f(r2, "context");
            if (g.b() != null) goto L5;
            g.h(new g(r2, null));
        L5:
            g r1 = g.b();
            o.c(r1);
            return r1;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/dataanalysis/CommonParamUtil$registerBatteryReceiver$receiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "dataanalysis_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f9054a;

        b(g r1) {
            this.f9054a = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r2, Intent r3) {
            o.f(r2, "context");
            o.f(r3, "intent");
            int r4 = r3.getIntExtra("status", -1);
            g r1 = this.f9054a;
            if (r4 != 2) goto L5;
        L8:
            boolean r5 = true;
        L9:
            g.d(r1, r5);
            return;
        L5:
            if (r4 == 5) goto L8;
            r5 = false;
            goto L9
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/dataanalysis/CommonParamUtil$registerLocaleReceiver$receiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "dataanalysis_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f9055a;

        c(g r1) {
            this.f9055a = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r2, Intent r3) {
            o.f(r2, "context");
            o.f(r3, "intent");
            g r1 = this.f9055a;
            g.e(r1, r1.B());
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"com/obric/matrix/dataanalysis/CommonParamUtil$registerNetworkCallback$callback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", "network", "Landroid/net/Network;", "onCapabilitiesChanged", "caps", "Landroid/net/NetworkCapabilities;", "onLost", "dataanalysis_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f9056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ConnectivityManager f9057b;

        d(g r1, ConnectivityManager r2) {
            this.f9056a = r1;
            this.f9057b = r2;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r2) {
            o.f(r2, "network");
            g r0 = this.f9056a;
            g.f(r0, g.c(r0, this.f9057b, r2));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network r2, NetworkCapabilities r3) {
            o.f(r2, "network");
            o.f(r3, "caps");
            g r4 = this.f9056a;
            g.f(r4, g.c(r4, this.f9057b, r2));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network r2) {
            o.f(r2, "network");
            g.f(this.f9056a, "Unknown");
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/dataanalysis/CommonParamUtil$registerTimezoneReceiver$receiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "dataanalysis_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class e extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f9058a;

        e(g r1) {
            this.f9058a = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r2, Intent r3) {
            o.f(r2, "context");
            o.f(r3, "intent");
            g r1 = this.f9058a;
            g.g(r1, r1.F());
        }
    }

    static {
        f9042l = new a(null);
    }

    private g(Context r3) {
        this.f9043a = r3.getApplicationContext();
        this.f9044b = new Object();
        this.f9047e = EnvironmentCompat.MEDIA_UNKNOWN;
        this.f9048f = EnvironmentCompat.MEDIA_UNKNOWN;
        this.f9049g = "";
        this.f9050h = "Unknown";
        this.f9051i = EnvironmentCompat.MEDIA_UNKNOWN;
        this.f9052j = EnvironmentCompat.MEDIA_UNKNOWN;
        this.f9053k = "";
    }

    public /* synthetic */ g(Context r1, kotlin.n0.d.g r2) {
        this(r1);
    }

    private final void J() {
        b r0 = new b(this);     // Catch: Exception -> L4
        a(this.f9043a, r0, new IntentFilter("android.intent.action.BATTERY_CHANGED"));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.obric.matrix.r.c.c.t("CommonParamUtil", "registerBatteryReceiver failed", e);
    }

    private final void K() {
        c r0 = new c(this);     // Catch: Exception -> L4
        a(this.f9043a, r0, new IntentFilter("android.intent.action.LOCALE_CHANGED"));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.obric.matrix.r.c.c.t("CommonParamUtil", "registerLocaleReceiver failed", e);
    }

    private final void L() {
        if (this.f9043a.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) goto L13;
        return;
    L13:
        Object r0 = this.f9043a.getSystemService("connectivity");     // Catch: Exception -> L10
        if (r0 == null) goto L9;
        ConnectivityManager r1 = (ConnectivityManager) r0;     // Catch: Exception -> L10
        r1.registerDefaultNetworkCallback(new d(this, r1));     // Catch: Exception -> L10
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");     // Catch: Exception -> L10
    L10:
        e = move-exception;
        com.obric.matrix.r.c.c.t("CommonParamUtil", "registerNetworkCallback failed", e);
    }

    private final void M() {
        e r0 = new e(this);     // Catch: Exception -> L4
        a(this.f9043a, r0, new IntentFilter("android.intent.action.TIMEZONE_CHANGED"));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.obric.matrix.r.c.c.t("CommonParamUtil", "registerTimezoneReceiver failed", e);
    }

    private final String N(ConnectivityManager r1, Network r2) {
        NetworkInfo r3 = r1.getNetworkInfo(r2);     // Catch: Exception -> L12
        if (r3 == null) goto L7;
        String r4 = r3.getTypeName();     // Catch: Exception -> L12
    L8:
        if (r4 != null) goto L11;
        return "Unknown";
    L11:
        return r4;
    L7:
        r4 = null;
    L16:
        return "Unknown";
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent a(Context r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    public static final /* synthetic */ g b() {
        return m;
    }

    public static final /* synthetic */ String c(g r0, ConnectivityManager r1, Network r2) {
        return r0.N(r1, r2);
    }

    public static final /* synthetic */ void d(g r0, boolean r1) {
        r0.f9046d = r1;
    }

    public static final /* synthetic */ void e(g r0, String r1) {
        r0.f9049g = r1;
    }

    public static final /* synthetic */ void f(g r0, String r1) {
        r0.f9050h = r1;
    }

    public static final /* synthetic */ void g(g r0, String r1) {
        r0.f9053k = r1;
    }

    public static final /* synthetic */ void h(g r0) {
        m = r0;
    }

    private final void i() {
        if (this.f9045c == false) goto L5;
        return;
    L5:
        Object r0 = this.f9044b;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (this.f9045c == false) goto L11;
        monitor-exit(r0);
        return;
    L11:
        this.f9046d = q();     // Catch: Throwable -> L14
        this.f9047e = I();     // Catch: Throwable -> L14
        this.f9049g = B();     // Catch: Throwable -> L14
        this.f9050h = C();     // Catch: Throwable -> L14
        this.f9051i = E();     // Catch: Throwable -> L14
        this.f9052j = D();     // Catch: Throwable -> L14
        this.f9053k = F();     // Catch: Throwable -> L14
        J();     // Catch: Throwable -> L14
        K();     // Catch: Throwable -> L14
        M();     // Catch: Throwable -> L14
        L();     // Catch: Throwable -> L14
        this.f9045c = true;     // Catch: Throwable -> L14
        f0 r2 = f0.f18324a;     // Catch: Throwable -> L14
        monitor-exit(r0);
    }

    private final String t() {
        BufferedReader r1 = new BufferedReader(new FileReader("/proc/cpuinfo"));     // Catch: Exception -> L18
    L20:
        String r2 = r1.readLine();     // Catch: Throwable -> L15
        o.e(r2, "it");     // Catch: Throwable -> L15
        if (r2 == null) goto L13;
        if (k.A(r2, "Hardware", false, 2, null) == false) goto L20;
        Matcher r3 = Pattern.compile("Hardware\\s*:\\s*(.*)$").matcher(r2);     // Catch: Throwable -> L15
        if (r3.matches() == false) goto L20;
        String r0 = r3.group(1);     // Catch: Throwable -> L15
        o.e(r0, "m.group(1)");     // Catch: Throwable -> L15
        r1.close();     // Catch: Exception -> L18
        return r0;
    L13:
        r1.close();     // Catch: Exception -> L18
        return "Unknown";
    L15:
        th = move-exception;
        r1.close();     // Catch: Exception -> L18
        throw th;     // Catch: Exception -> L18
    L18:
        return "Unknown";
    }

    public final String A() {
        return System.getProperty("os.version").toString();
    }

    public final String B() {
        String r1 = this.f9043a.getResources().getConfiguration().getLocales().get(0).getLanguage();
        o.e(r1, "appContext.resources.con…ation.locales[0].language");
        return r1;
    }

    public final String C() {
        if (this.f9043a.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) goto L16;
        Object r3 = this.f9043a.getSystemService("connectivity");     // Catch: Exception -> L17
        if (r3 == null) goto L15;
        NetworkInfo r4 = ((ConnectivityManager) r3).getActiveNetworkInfo();     // Catch: Exception -> L17
        if (r4 == null) goto L10;
        String r5 = r4.getTypeName();     // Catch: Exception -> L17
    L11:
        if (r5 != null) goto L20;
        return "Unknown";
    L20:
        return r5;
    L10:
        r5 = null;
        goto L11
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");     // Catch: Exception -> L17
    L16:
        return "Unknown";
    L21:
        return "Unknown";
    }

    public final String D() {
        String r5 = E();     // Catch: Exception -> L10
        kotlin.u0.g r6 = kotlin.u0.i.b(new kotlin.u0.i("^\\d+\\.\\d+\\.\\d+"), r5, 0, 2, null);     // Catch: Exception -> L10
        if (r6 == null) goto L13;
        String r7 = r6.getValue();     // Catch: Exception -> L10
        if (r7 != null) goto L9;
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L9:
        return r7;
    L13:
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L15:
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public final String E() {
        return H("ro.os.ota.version");
    }

    public final String F() {
        String r1 = TimeZone.getDefault().getID();
        o.e(r1, "getDefault().id");
        return r1;
    }

    public final String G() {
        v.a r4 = v.f21457g;     // Catch: Throwable -> L4
        Object r5 = (new StatFs(Environment.getExternalStorageDirectory().getPath()).getAvailableBytes() / ((long) 1000000)) + " MB";     // Catch: Throwable -> L4
        v.b(r5);     // Catch: Throwable -> L4
    L7:
        if (v.f(r5) == false) goto L10;
        r5 = EnvironmentCompat.MEDIA_UNKNOWN;
    L10:
        return (String) r5;
    L4:
        th = move-exception;
        v.a r0 = v.f21457g;
        r5 = w.a(th);
        v.b(r5);
        goto L7
    }

    public final String H(String r7) {
        o.f(r7, "fieldName");
        String r8 = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke(null, new Object[]{r7});     // Catch: Exception -> L7
        if (r8 != null) goto L12;
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L12:
        return r8;
    L7:
        e = move-exception;
        e.printStackTrace();
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public final String I() {
        Context r9 = this.f9043a;     // Catch: Exception -> L29
        Object r1 = r9.getSystemService("storagestats");     // Catch: Exception -> L29
        if (r1 == null) goto L28;
        StorageStatsManager r2 = (StorageStatsManager) r1;     // Catch: Exception -> L29
        StorageManager r10 = (StorageManager) r9.getSystemService(StorageManager.class);     // Catch: Exception -> L29
        Object r11 = r10.getClass().getMethod("getVolumes", new Class[0]).invoke(r10, new Object[0]);     // Catch: Exception -> L29
        Object r3 = null;
        if ((r11 instanceof List) == false) goto L8;
        List r12 = (List) r11;     // Catch: Exception -> L29
    L9:
        Class<?> r4 = Class.forName("android.os.storage.VolumeInfo");     // Catch: Exception -> L29
        Method r5 = r4.getMethod("isPrimary", new Class[0]);     // Catch: Exception -> L29
        Method r6 = r4.getMethod("getFsUuid", new Class[0]);     // Catch: Exception -> L29
        if (r12 == null) goto L21;
        Iterator r13 = r12.iterator();     // Catch: Exception -> L29
    L13:
        if (r13.hasNext() == false) goto L21;
        Object r7 = r13.next();     // Catch: Exception -> L29
        Object r8 = r5.invoke(r7, new Object[0]);     // Catch: Exception -> L29
        if (r8 == null) goto L20;
        if (((Boolean) r8).booleanValue() == false) goto L13;
        r3 = r7;
        goto L21
    L20:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");     // Catch: Exception -> L29
    L21:
        if (r3 == null) goto L37;
        Object r14 = r2.getClass().getMethod("getTotalBytes", new Class[]{String.class}).invoke(r2, new Object[]{r6.invoke(r3, new Object[0])});     // Catch: Exception -> L29
        if (r14 == null) goto L26;
        return NumberFormat.getNumberInstance(Locale.getDefault()).format(((((Long) r14).longValue() / 1000.0d) / 1000.0d) / 1000.0d) + " GB";
    L26:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");     // Catch: Exception -> L29
    L37:
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L8:
        r12 = null;
        goto L9
    L28:
        throw new NullPointerException("null cannot be cast to non-null type android.app.usage.StorageStatsManager");     // Catch: Exception -> L29
    L29:
        e = move-exception;
        e.printStackTrace();
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public final Map<String, Object> j(Map<String, ? extends Object> r20) {
        if (((ITeaSettings) com.bytedance.news.common.settings.e.e(ITeaSettings.class)).enableParamsOpt() == true) goto L5;
        Map<String, Object> r0 = m0.k(new u[]{a0.a("device_brand", o()), a0.a("device_brightness", Float.valueOf(n())), a0.a("device_cpu_architecture", k()), a0.a("device_cpu_corenum", Integer.valueOf(l())), a0.a("device_cpu_info", m()), a0.a("device_height", Integer.valueOf(p())), a0.a("device_ip_address", w()), a0.a("device_is_charging", Boolean.valueOf(q())), a0.a("device_model", r()), a0.a("device_poweron_duration", s()), a0.a("device_resolution", u()), a0.a("device_storage_total", I()), a0.a("device_storage_available", G()), a0.a("device_width", Integer.valueOf(v())), a0.a("os_api", Integer.valueOf(x())), a0.a("os_baseband", y()), a0.a("os_build_date", z()), a0.a("os_kernal", A()), a0.a("os_language", B()), a0.a("os_network_type", C()), a0.a("os_ota_version", E()), a0.a("os_rom_version", D()), a0.a("os_timezone", F())});
    L6:
        if (r20 != null) goto L8;
        return r0;
    L8:
        return m0.n(r0, r20);
    L5:
        i();
        r0 = m0.k(new u[]{a0.a("device_is_charging", Boolean.valueOf(this.f9046d)), a0.a("device_poweron_duration", s()), a0.a("device_storage_total", this.f9047e), a0.a("device_storage_available", this.f9048f), a0.a("os_language", this.f9049g), a0.a("os_network_type", this.f9050h), a0.a("os_ota_version", this.f9051i), a0.a("os_rom_version", this.f9052j), a0.a("os_timezone", this.f9053k)});
        goto L6
    }

    public final String k() {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        String[] r1 = Build.SUPPORTED_ABIS;
        o.e(r1, "SUPPORTED_ABIS");
        String r2 = (String) kotlin.i0.i.x(r1);
        if (r2 != null) goto L9;
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L9:
        return r2;
    L7:
        String r3 = Build.CPU_ABI;
        o.e(r3, "{\n            Build.CPU_ABI\n        }");
        return r3;
    }

    public final int l() {
        return Runtime.getRuntime().availableProcessors();
    L4:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }

    public final String m() {
        if (o.a(H("ro.soc.model"), "SM8750") == false) goto L6;
        return "Qualcomm® Snapdragon™ 8 Gen 4";
    L6:
        return t();
    }

    public final float n() {
        return Settings.System.getInt(this.f9043a.getContentResolver(), "screen_brightness") / 255.0f;
    L4:
        return -1.0f;
    }

    public final String o() {
        return "Ocean";
    }

    public final int p() {
        Object r1 = this.f9043a.getSystemService("window");
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.view.WindowManager");
        DisplayMetrics r0 = new DisplayMetrics();
        ((WindowManager) r1).getDefaultDisplay().getMetrics(r0);
        return r0.heightPixels;
    }

    public final boolean q() {
        IntentFilter r0 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        Intent r2 = a(this.f9043a, null, r0);
        int r1 = -1;
        if (r2 == null) goto L6;
        r1 = r2.getIntExtra("status", -1);
    L6:
        if (r1 != 2) goto L8;
    L11:
        return true;
    L8:
        if (r1 == 5) goto L11;
        return false;
    }

    public final String r() {
        String r1 = Build.MODEL;
        o.e(r1, "MODEL");
        return r1;
    }

    public final String s() {
        int r6 = (int) (SystemClock.elapsedRealtime() / ((long) 1000));     // Catch: Exception -> L4
        int r0 = r6 / 3600;     // Catch: Exception -> L4
        int r7 = r6 % 3600;     // Catch: Exception -> L4
        i0 r2 = i0.f18445a;     // Catch: Exception -> L4
        String r8 = String.format("%02d小时%02d分%02d秒", Arrays.copyOf(new Object[]{Integer.valueOf(r0), Integer.valueOf(r7 / 60), Integer.valueOf(r7 % 60)}, 3));     // Catch: Exception -> L4
        o.e(r8, "format(format, *args)");     // Catch: Exception -> L4
        return r8;
    L4:
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public final String u() {
        StringBuilder r0 = new StringBuilder();
        r0.append(v());
        r0.append('x');
        r0.append(p());
        return r0.toString();
    }

    public final int v() {
        Object r1 = this.f9043a.getSystemService("window");
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.view.WindowManager");
        DisplayMetrics r0 = new DisplayMetrics();
        ((WindowManager) r1).getDefaultDisplay().getMetrics(r0);
        return r0.widthPixels;
    }

    public final String w() {
        Enumeration<NetworkInterface> r3 = NetworkInterface.getNetworkInterfaces();     // Catch: Exception -> L13
    L4:
        if (r3.hasMoreElements() == false) goto L26;
        Enumeration<InetAddress> r0 = r3.nextElement().getInetAddresses();     // Catch: Exception -> L13
    L7:
        if (r0.hasMoreElements() == false) goto L4;
        InetAddress r1 = r0.nextElement();     // Catch: Exception -> L13
        if (r1.isLoopbackAddress() == true) goto L7;
        if (r1 == null) goto L7;
        String r4 = r1.getHostAddress();     // Catch: Exception -> L13
        o.e(r4, "address.hostAddress");     // Catch: Exception -> L13
        return r4;
    L26:
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L13:
        e = move-exception;
        e.printStackTrace();
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public final int x() {
        return Build.VERSION.SDK_INT;
    }

    public final String y() {
        String r1 = Build.getRadioVersion();
        o.e(r1, "getRadioVersion()");
        return r1;
    }

    public final String z() {
        return String.valueOf(Build.TIME);
    }
}
