package com.obric.matrix.account.p;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.sdk.account.impl.g;
import com.obric.matrix.account.http.i;
import com.obric.matrix.account_api.ISecShareService;
import com.obric.matrix.q.h.k;
import com.obric.matrix.r.e.j;
import com.obric.matrix.ws_api.IWs;
import com.ss.android.token.n;
import com.ss.android.ug.bus.UgCallbackCenter;
import d.b.s.a.q.f;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.i0.r;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.v;
import kotlin.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010#\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u001e*\u0001\u000f\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u000278B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0001J\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0012J\b\u0010\u001f\u001a\u00020\u001bH\u0002J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0012H\u0007J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\bH\u0016J\b\u0010#\u001a\u00020\u001bH\u0016J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u0005H\u0016J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u0014H\u0016J\u0010\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u0014H\u0016J\b\u0010*\u001a\u00020\u001bH\u0002J\b\u0010+\u001a\u00020\u001bH\u0002J\b\u0010,\u001a\u00020\u001bH\u0002J\u000e\u0010-\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0001J\b\u0010.\u001a\u00020\u001bH\u0002J\b\u0010/\u001a\u00020\u001bH\u0002J\b\u00100\u001a\u00020\u001bH\u0002J\b\u00101\u001a\u00020\u001bH\u0002J\b\u00102\u001a\u00020\u001bH\u0002J\b\u00103\u001a\u00020\u001bH\u0002J\b\u00104\u001a\u00020\u001bH\u0002J\b\u00105\u001a\u00020\u001bH\u0002J\u0010\u00106\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/obric/matrix/account/manager/OAccountManager;", "Lcom/obric/matrix/account_api/IAccountStatusListener;", "Lcom/obric/matrix/base/system/ISystemStateListener;", "()V", "ACCOUNT_FRONTIER_METHOD", "", "ACCOUNT_FRONTIER_SERVICE", "SETTINGS_NAME", "", "TAG", "boeTokenHost", "", "mAccountStatusListenerSet", "", "mCallback", "com/obric/matrix/account/manager/OAccountManager$mCallback$1", "Lcom/obric/matrix/account/manager/OAccountManager$mCallback$1;", "mContext", "Landroid/content/Context;", "<set-?>", "", "mHasInitPre", "getMHasInitPre", "()Z", "mInit", "onlineTokenHost", "addAccountStatusListener", "", "listener", "init", "context", "initAccount", "initPre", "onAccountInfoUpdate", "scene", "onLogin", "onLogout", "logoutScene", "onPowerSaveModeChanged", "enter", "onScreenStateChanged", "on", "registerAppLogCallback", "registerDozeCallback", "registerNetworkCallback", "removeAccountStatusListener", "sendBroadcastForAccountLogin", "sendBroadcastForAccountLoginToSettings", "sendBroadcastForAccountLogout", "sendBroadcastForAccountLogoutToSettings", "sendBroadcastForAccountRefresh", "sendSecureBroadcastForAccountLogin", "sendSecureBroadcastForAccountLogout", "sendSecureBroadcastForAccountRefresh", "updateKevaContext", "mAccountEventListener", "mAppLogIdListener", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"StaticFieldLeak"})
public final class b implements com.obric.matrix.account_api.c, com.obric.matrix.q.h.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8600a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<String> f8601b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<String> f8602c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Context f8603d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f8604e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile boolean f8605f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final d f8606g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Set<com.obric.matrix.account_api.c> f8607h = null;

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "wsMsg", "Lcom/bytedance/common/wschannel/model/WsChannelMsg;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends q implements l<WsChannelMsg, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f8608f = null;

        static {
            f8608f = new a();
        }

        a() {
            super(1);
        }

        public final void a(WsChannelMsg r6) {
            StringBuilder r5 = new StringBuilder();
            r5.append("init wsMsg.method=");
            if (r6 == null) goto L5;
            Integer r1 = Integer.valueOf(r6.f());
        L6:
            r5.append(r1);
            com.obric.matrix.r.c.c.j("OAccountManager", r5.toString());
            boolean r7 = true;
            if (r6 != null) goto L9;
        L11:
            boolean r3 = false;
        L12:
            if (r3 == false) goto L27;
            if (r6 != null) goto L15;
        L17:
            r7 = false;
        L18:
            if (r7 == false) goto L28;
            byte[] r8 = r6.i();
            if (r8 != null) goto L22;
            r8 = new byte[0];
        L22:
            String r9 = new String(r8, kotlin.u0.d.f21429a);
            com.obric.matrix.r.c.c.j("OAccountManager", "onReceiveMsg: msgStr=" + r9);
            Context r10 = b.g();
            if (r10 == null) goto L25;
            g.d(r10).c(r9);
            return;
        L25:
            o.v("mContext");
            throw null;
        L28:
            return;
        L15:
            if (r6.f() != 1001) goto L17;
        L27:
            return;
        L9:
            if (r6.s() != 33554645) goto L11;
            r3 = true;
            goto L12
        L5:
            r1 = null;
            goto L6
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(WsChannelMsg r1) {
            a(r1);
            return f0.f18324a;
        }
    }

    /* JADX INFO: renamed from: com.obric.matrix.account.p.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/matrix/account/manager/OAccountManager$mAccountEventListener;", "Lcom/bytedance/sdk/account/api/BDAccountEventListener;", "()V", "onReceiveAccountEvent", "", NotificationCompat.CATEGORY_EVENT, "Lcom/bytedance/sdk/account/api/BDAccountEvent;", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class C0224b implements d.b.s.a.q.c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final C0224b f8609f = null;

        static {
            f8609f = new C0224b();
        }

        private C0224b() {
        }

        @Override // d.b.s.a.q.c
        public void F(d.b.s.a.q.b r6) {
            StringBuilder r5 = new StringBuilder();
            r5.append("on receive account event ");
            Integer r0 = null;
            if (r6 == null) goto L5;
            Integer r1 = Integer.valueOf(r6.f14879a);
        L6:
            r5.append(r1);
            com.obric.matrix.r.c.c.b("OAccountManager", r5.toString());
            if (r6 == null) goto L9;
            r0 = Integer.valueOf(r6.f14879a);
        L9:
            if (r0 == null) goto L15;
            if (r0.intValue() != 0) goto L15;
            b.f8600a.j("receiveRefreshEvent");
            return;
        L15:
            if (r0 == null) goto L29;
            if (r0.intValue() != 1) goto L29;
            com.obric.matrix.r.c.c.j("OAccountManager", "on EVENT_ACCOUNT_LOGOUT LogoutScene = " + r6.f14880b + ", sessionDropProtocolType = " + r6.f14881c + " extra = " + r6.f14883e + ' ');
            if (r6 == null) goto L27;
            Map<String, String> r7 = r6.f14883e;
            if (r7 == null) goto L27;
            Iterator<Map.Entry<String, String>> r8 = r7.entrySet().iterator();
        L25:
            if (r8.hasNext() == false) goto L27;
            Map.Entry<String, String> r2 = r8.next();
            com.obric.matrix.r.c.c.j("OAccountManager", "on EVENT_ACCOUNT_LOGOUT extras " + r2.getKey() + " = " + r2.getValue());
        L27:
            b.f8600a.h(r6.f14880b);
            return;
        L29:
            if (r0 != null) goto L32;
            return;
        L32:
            if (r0.intValue() != 2) goto L38;
            com.obric.matrix.r.c.c.j("OAccountManager", "on EVENT_ACCOUNT_SESSION_EXIPIRED sessionDropProtocolType = " + r6.f14881c + " sessionDropMessage = " + r6.f14882d + ' ');
            return;
        L38:
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/matrix/account/manager/OAccountManager$mAppLogIdListener;", "Lcom/obric/matrix/ostracker_api/IOSTrackerListener;", "()V", "init", "", "did", "", WsConstants.KEY_INSTALL_ID, "onDeviceIdLoaded", "onInstallIdLoaded", "installId", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class c implements com.obric.matrix.ostracker_api.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f8610a = null;

        static {
            f8610a = new c();
        }

        private c() {
        }

        @Override // com.obric.matrix.ostracker_api.a
        public void a(String r1) {
            BdTuringConfig r0 = com.bytedance.bdturing.b.f().e();
            if (r0 == null) goto L7;
            r0.setDeviceId(r1);
            return;
        }

        @Override // com.obric.matrix.ostracker_api.a
        public void b(String r1) {
            BdTuringConfig r0 = com.bytedance.bdturing.b.f().e();
            if (r0 == null) goto L7;
            r0.setInstallId(r1);
            return;
        }

        public final void c(String r1, String r2) {
            o.f(r1, "did");
            o.f(r2, WsConstants.KEY_INSTALL_ID);
            BdTuringConfig r0 = com.bytedance.bdturing.b.f().e();
            if (r0 == null) goto L6;
            r0.setDeviceId(r1);
        L6:
            BdTuringConfig r3 = com.bytedance.bdturing.b.f().e();
            if (r3 == null) goto L11;
            r3.setInstallId(r2);
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/obric/matrix/account/manager/OAccountManager$mCallback$1", "Lcom/ss/android/ug/bus/UgCallbackCenter$Callback;", "Lcom/ss/android/ug/bus/account/event/OnLoginEvent;", "onCall", "", NotificationCompat.CATEGORY_EVENT, "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d implements UgCallbackCenter.d<com.ss.android.ug.bus.c.b.a> {
        d() {
        }

        @Override // com.ss.android.ug.bus.UgCallbackCenter.d
        public /* bridge */ /* synthetic */ void a(com.ss.android.ug.bus.c.b.a r1) {
            b(r1);
        }

        public void b(com.ss.android.ug.bus.c.b.a r1) {
            b.f8600a.e();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/matrix/account/manager/OAccountManager$registerNetworkCallback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", "network", "Landroid/net/Network;", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class e extends ConnectivityManager.NetworkCallback {
        e() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r4) {
            o.f(r4, "network");
            com.obric.matrix.r.c.c.j("OAccountManager", "network onAvailable.");
            com.obric.matrix.account.p.a r3 = com.obric.matrix.account.p.a.f8593f;
            com.obric.matrix.account.p.a.m(r3, "netRecovery", false, 2, null);
            com.obric.matrix.account.p.a.k(r3, false, 1, null);
        }
    }

    static {
        f8600a = new b();
        f8601b = r.j(new String[]{"os-assistant-boe.bytedance.net", "bytedance.com"});
        f8602c = r.j(new String[]{"os.obriccloud.com", "bytedance.com"});
        f8606g = new d();
        f8607h = new HashSet();
    }

    private b() {
    }

    private final void A(Context r7) {
        if (com.obric.matrix.r.b.f9910a.f() == false) goto L37;
        return;
    L37:
        v.a r0 = v.f21457g;     // Catch: Throwable -> L31
        Object r1 = d.b.a.a.a.c.a.b(KevaBuilder.class.getName(), "mContext", KevaBuilder.getInstance());     // Catch: Throwable -> L31
        if (r1 != null) goto L9;
        KevaBuilder.getInstance().setContext(r7);     // Catch: Throwable -> L31
        Keva.forceInit();     // Catch: Throwable -> L31
        com.obric.matrix.r.c.c.f("OAccountManager", "keva context is null, no need update");     // Catch: Throwable -> L31
    L12:
        d.b.a.a.a.c.a.a(KevaBuilder.class.getName(), "mContext").set(KevaBuilder.getInstance(), r7);     // Catch: Throwable -> L31
        Method r6 = Class.forName("com.bytedance.keva.KevaImpl").getDeclaredMethod("initialize", new Class[]{new String().getClass()});     // Catch: Throwable -> L31
        r6.setAccessible(true);     // Catch: Throwable -> L31
        File r8 = r7.getFilesDir();     // Catch: Throwable -> L31
        com.obric.matrix.r.c.c.j("OAccountManager", "update keva context filesDir " + r8.getAbsolutePath() + ' ' + r8.exists());     // Catch: Throwable -> L31
        if (r8.exists() == true) goto L15;
        r8.mkdirs();     // Catch: Throwable -> L31
    L15:
        com.obric.matrix.r.c.c.j("OAccountManager", "update keva context filesDir2 " + r8.getAbsolutePath() + ' ' + r8.exists());     // Catch: Throwable -> L31
        File r2 = new File(r8, "keva");     // Catch: Throwable -> L31
        if (r2.exists() == true) goto L18;
        r2.mkdirs();     // Catch: Throwable -> L31
    L18:
        com.obric.matrix.r.c.c.j("OAccountManager", "update keva context " + r2.getAbsolutePath() + ' ' + r2.exists());     // Catch: Throwable -> L31
        Object[] r9 = {r2.getAbsolutePath()};     // Catch: Throwable -> L31
        HashMap r3 = null;
        r6.invoke(null, r9);     // Catch: Throwable -> L31
        Object r10 = d.b.a.a.a.c.a.b("com.bytedance.keva.KevaImpl", "sRepoMap", null);     // Catch: Throwable -> L31
        if ((r10 instanceof HashMap) == false) goto L21;
        r3 = (HashMap) r10;     // Catch: Throwable -> L31
    L21:
        if (r3 == null) goto L29;
        monitor-enter(r3);     // Catch: Throwable -> L31
        r3.clear();     // Catch: Throwable -> L26
        f0 r11 = f0.f18324a;     // Catch: Throwable -> L26
        monitor-exit(r3);     // Catch: Throwable -> L31
        goto L29
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L29:
        com.obric.matrix.r.c.c.j("OAccountManager", "update keva context success " + r3);     // Catch: Throwable -> L31
        Object r12 = f0.f18324a;     // Catch: Throwable -> L31
        v.b(r12);     // Catch: Throwable -> L31
    L33:
        Throwable r13 = v.d(r12);
        if (r13 == null) goto L40;
        com.obric.matrix.r.c.c.g("OAccountManager", "update keva context failed", r13);
        return;
    L40:
        return;
    L9:
        if (o.a(r1, r7) == false) goto L12;
        com.obric.matrix.r.c.c.f("OAccountManager", "keva context is origin context, no need update");     // Catch: Throwable -> L31
        return;
    L31:
        th = move-exception;
        v.a r14 = v.f21457g;
        r12 = w.a(th);
        v.b(r12);
        goto L33
    }

    public static final /* synthetic */ Context g() {
        return f8603d;
    }

    private final void m() {
        com.obric.matrix.r.c.c.j("OAccountManager", "initAccount.");
        com.obric.matrix.account.p.a.f8593f.l("init", true);
        n.y();
        o();
        q();
        p();
        j("init");
    }

    private final void o() {
        c r3 = c.f8610a;
        String r0 = com.obric.matrix.ostracker_api.b.c();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r2 = com.obric.matrix.ostracker_api.b.e();
        if (r2 == null) goto L9;
        r1 = r2;
    L9:
        r3.c(r0, r1);
        com.obric.matrix.ostracker_api.b.a(r3);
    }

    private final void p() {
        k.l(this);
    }

    private final void q() {
        com.obric.matrix.account.r.d.a r2 = com.obric.matrix.account.r.d.f8622c;
        Context r0 = f8603d;
        if (r0 == null) goto L6;
        r2.c(r0, new e());
        return;
    L6:
        o.v("mContext");
        throw null;
    }

    private final void s() {
        Context r3 = f8603d;
        if (r3 == null) goto L6;
        Intent r0 = new Intent();
        com.obric.matrix.r.c.c.b("OAccountManager", "send account login.");
        r0.setAction("obric.intent.action.account.LOGIN");
        r0.setFlags(r0.getFlags() | 32);
        r3.sendBroadcast(r0);
        return;
    L6:
        o.v("mContext");
        throw null;
    }

    private final void t() {
        Context r3 = f8603d;
        if (r3 == null) goto L6;
        Intent r0 = new Intent();
        com.obric.matrix.r.c.c.b("OAccountManager", "send account login to settings.");
        r0.setAction("com.android.settings.action.oaccount.LOGIN");
        r0.setPackage("com.android.settings");
        r3.sendBroadcast(r0);
        return;
    L6:
        o.v("mContext");
        throw null;
    }

    private final void u() {
        Context r3 = f8603d;
        if (r3 == null) goto L6;
        Intent r0 = new Intent();
        com.obric.matrix.r.c.c.b("OAccountManager", "send account logout.");
        r0.setAction("obric.intent.action.account.LOGOUT");
        r0.putExtra("obric.intent.extra.account.LOGOUT_SCENE", com.obric.matrix.account.a.f8438a.j());
        r0.setFlags(r0.getFlags() | 32);
        r3.sendBroadcast(r0);
        return;
    L6:
        o.v("mContext");
        throw null;
    }

    private final void v() {
        Context r3 = f8603d;
        if (r3 == null) goto L6;
        Intent r0 = new Intent();
        com.obric.matrix.r.c.c.b("OAccountManager", "send account logout to settings.");
        r0.setPackage("com.android.settings");
        r0.setAction("com.android.settings.action.oaccount.LOGOUT");
        r0.putExtra("obric.intent.extra.account.LOGOUT_SCENE", com.obric.matrix.account.a.f8438a.j());
        r0.setFlags(r0.getFlags() | 32);
        r3.sendBroadcast(r0);
        return;
    L6:
        o.v("mContext");
        throw null;
    }

    private final void w() {
        Context r3 = f8603d;
        if (r3 == null) goto L6;
        Intent r0 = new Intent();
        com.obric.matrix.r.c.c.b("OAccountManager", "send account info update broad.");
        r0.setAction("obric.intent.action.account.ACCOUNT_INFO_UPDATE");
        r0.setFlags(r0.getFlags() | 32);
        r3.sendBroadcast(r0);
        return;
    L6:
        o.v("mContext");
        throw null;
    }

    private final void x() {
        Context r3 = f8603d;
        if (r3 == null) goto L6;
        Intent r0 = new Intent();
        com.obric.matrix.r.c.c.b("OAccountManager", "send secure account login.");
        r0.setAction("obric.intent.action.account.SECURE_LOGIN");
        r0.setFlags(r0.getFlags() | 32);
        r3.sendBroadcast(r0, "com.obric.account.permission.ACCOUNT_STATUS");
        return;
    L6:
        o.v("mContext");
        throw null;
    }

    private final void y() {
        Context r3 = f8603d;
        if (r3 == null) goto L6;
        Intent r0 = new Intent();
        com.obric.matrix.r.c.c.b("OAccountManager", "send secure account logout.");
        r0.setAction("obric.intent.action.account.SECURE_LOGOUT");
        r0.putExtra("obric.intent.extra.account.LOGOUT_SCENE", com.obric.matrix.account.a.f8438a.j());
        r0.setFlags(r0.getFlags() | 32);
        r3.sendBroadcast(r0, "com.obric.account.permission.ACCOUNT_STATUS");
        return;
    L6:
        o.v("mContext");
        throw null;
    }

    private final void z() {
        Context r3 = f8603d;
        if (r3 == null) goto L6;
        Intent r0 = new Intent();
        com.obric.matrix.r.c.c.b("OAccountManager", "send secure account info update broad.");
        r0.setAction("obric.intent.action.account.SECURE_ACCOUNT_INFO_UPDATE");
        r0.setFlags(r0.getFlags() | 32);
        r3.sendBroadcast(r0, "com.obric.account.permission.ACCOUNT_STATUS");
        return;
    L6:
        o.v("mContext");
        throw null;
    }

    @Override // com.obric.matrix.q.h.d
    public void b(boolean r4) {
        com.obric.matrix.r.c.c.j("OAccountManager", "onScreenChanged: dozeMode=" + j.b() + ", screen=" + j.c());
        com.obric.matrix.account.p.a r3 = com.obric.matrix.account.p.a.f8593f;
        if (r4 == false) goto L5;
        com.obric.matrix.account.p.a.m(r3, "screenOn", false, 2, null);
        com.obric.matrix.account.p.a.k(r3, false, 1, null);
        return;
    L5:
        r3.h();
    }

    @Override // com.obric.matrix.q.h.d
    public void c(boolean r1) {
        com.obric.matrix.r.c.c.j("OAccountManager", "onPowerSaveModeChanged: dozeMode=" + j.b() + ", screen=" + j.c());
    }

    @Override // com.obric.matrix.account_api.c
    public void e() {
        com.obric.matrix.account.q.c r0 = com.obric.matrix.account.q.c.a();
        if (r0 == null) goto L5;
        r0.g("login", -1);
    L5:
        f r1 = g.d(com.ss.android.i.j.k().e());
        if (r1 == null) goto L10;
        d.b.s.a.k0.a r2 = r1.a();
        if (r2 == null) goto L10;
        Object r3 = r2.j();
    L11:
        if (r3 != null) goto L13;
        r3 = "";
    L13:
        com.obric.matrix.r.c.e.a("OAccountManager", "login dataJson = " + r3);
        com.obric.matrix.account.p.a.f8593f.i(r3.toString());
        com.obric.matrix.r.d.a.g().k(true);
        s();
        t();
        x();
        Iterator<T> r4 = f8607h.iterator();
    L15:
        if (r4.hasNext() == false) goto L17;
        ((com.obric.matrix.account_api.c) r4.next()).e();
        goto L15
    L17:
        j("login");
        return;
    L10:
        r3 = null;
        goto L11
    }

    @Override // com.obric.matrix.account_api.c
    public void h(int r6) {
        com.obric.matrix.account.q.c r0 = com.obric.matrix.account.q.c.a();
        if (r0 == null) goto L5;
        r0.g("logout", r6);
    L5:
        com.obric.matrix.account.a r1 = com.obric.matrix.account.a.f8438a;
        r1.A(r6);
        r1.z(0);
        r1.y("");
        com.obric.matrix.r.c.e.a("OAccountManager", "onLogout loginInfo: loginUtcTime=" + r1.i() + ", loginPhoneNumber=" + r1.h());
        com.obric.matrix.account.p.a.f8593f.d();
        com.obric.matrix.r.d.a.g().k(false);
        u();
        v();
        y();
        Iterator<T> r2 = f8607h.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        ((com.obric.matrix.account_api.c) r2.next()).h(r6);
        goto L7
    L9:
        j("logout");
    }

    public final void i(com.obric.matrix.account_api.c r1) {
        o.f(r1, "listener");
        f8607h.add(r1);
    }

    @Override // com.obric.matrix.account_api.c
    public void j(String r3) {
        o.f(r3, "scene");
        com.obric.matrix.r.c.c.j("OAccountManager", "manager onAccountInfoUpdate " + r3);
        com.obric.matrix.account.q.c r0 = com.obric.matrix.account.q.c.a();
        if (r0 == null) goto L5;
        r0.c(r3);
    L5:
        w();
        z();
        Iterator<T> r2 = f8607h.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        ((com.obric.matrix.account_api.c) r2.next()).j(r3);
        goto L7
    }

    public final boolean k() {
        return f8604e;
    }

    public final synchronized void l(Context r5) {
        monitor-enter(this);
        o.f(r5, "context");     // Catch: Throwable -> L29
        if (f8605f == false) goto L8;
        com.obric.matrix.r.c.c.s("OAccountManager", "Init already.");     // Catch: Throwable -> L29
        monitor-exit(this);
        return;
    L8:
        com.obric.matrix.r.c.c.j("OAccountManager", "init start isDeviceProtectedStorage = " + r5.isDeviceProtectedStorage());     // Catch: Throwable -> L29
        if (r5.isDeviceProtectedStorage() == false) goto L12;
        monitor-exit(this);
        return;
    L12:
        com.obric.matrix.r.b r0 = com.obric.matrix.r.b.f9910a;     // Catch: Throwable -> L29
        if (r0.d() == false) goto L15;
    L19:
        com.obric.matrix.r.c.c.j("OAccountManager", "init start isCredentialProtectedStorage = " + r5.getFilesDir().getAbsolutePath());     // Catch: Throwable -> L29
        ((ISecShareService) com.bytedance.news.common.service.manager.d.a(ISecShareService.class)).initSecShare(r5);     // Catch: Throwable -> L29
        A(r5);     // Catch: Throwable -> L29
        n(r5);     // Catch: Throwable -> L29
        m();     // Catch: Throwable -> L29
        com.obric.matrix.r.c.c.j("OAccountManager", "init");     // Catch: Throwable -> L29
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L29
        r1.append("init end secUid = ");     // Catch: Throwable -> L29
        com.obric.matrix.account.a r2 = com.obric.matrix.account.a.f8438a;     // Catch: Throwable -> L29
        r1.append(kotlin.u0.k.K0(r2.b().k(), 4));     // Catch: Throwable -> L29
        r1.append(" uid=");     // Catch: Throwable -> L29
        r1.append(kotlin.u0.k.K0(r2.b().n(), 4));     // Catch: Throwable -> L29
        com.obric.matrix.r.c.c.j("OAccountManager", r1.toString());     // Catch: Throwable -> L29
        IWs r6 = (IWs) com.bytedance.news.common.service.manager.d.a(IWs.class);     // Catch: Exception -> L24 Throwable -> L29
        if (r6 == null) goto L26;
        r6.registerWsMsgReceivedListener(a.f8608f);     // Catch: Exception -> L24 Throwable -> L29
    L26:
        f8605f = true;     // Catch: Throwable -> L29
        monitor-exit(this);
        return;
    L24:
        e = move-exception;
        com.obric.matrix.r.c.c.g("OAccountManager", "listen ws msg failed.", e);     // Catch: Throwable -> L29
        goto L26
    L15:
        if (r0.f() == true) goto L19;
        com.obric.matrix.r.c.c.f("OAccountManager", "init failed, context is not unlocked.");     // Catch: Throwable -> L29
        monitor-exit(this);
        return;
    L29:
        th = move-exception;
        throw th;
    }

    @SuppressLint({"WrongConstant"})
    public final void n(Context r6) {
        o.f(r6, "context");
        com.obric.matrix.r.b r5 = com.obric.matrix.r.b.f9910a;
        if (r5.d() == true) goto L9;
        if (r5.f() == true) goto L9;
        com.obric.matrix.r.c.c.f("OAccountManager", "initPre failed, context is not unlocked.");
        return;
    L9:
        if (f8604e == false) goto L12;
        com.obric.matrix.r.c.c.s("OAccountManager", "PreInit already.");
        return;
    L12:
        Context r7 = r6.getApplicationContext();
        o.e(r7, "context.applicationContext");
        f8603d = r7;
        StringBuilder r8 = new StringBuilder();
        r8.append("initPre start filesDir ");
        Context r9 = f8603d;
        if (r9 == null) goto L32;
        r8.append(r9.getFilesDir().getAbsolutePath());
        com.obric.matrix.r.c.c.j("OAccountManager", r8.toString());
        com.obric.matrix.r.c.c.j("OAccountManager", "initPre3333");
        com.obric.matrix.r.c.c.j("OAccountManager", "initPre3333");
        com.obric.matrix.account.n.b.f8591a.a();
        com.ss.android.i.j.p(new com.obric.matrix.account.n.d());
        ArrayList r10 = new ArrayList();
        if (i.c().a() == false) goto L17;
        List<String> r11 = f8601b;
    L18:
        r10.addAll(r11);
        com.ss.android.token.l r12 = new com.ss.android.token.l();
        r12.s(600000);
        r12.d(r10);
        r12.r(true);
        Context r3 = f8603d;
        if (r3 == null) goto L30;
        n.l(r3, r12);
        d r13 = f8606g;
        UgCallbackCenter.e(r13);
        UgCallbackCenter.d(r13);
        Context r14 = f8603d;
        if (r14 == null) goto L28;
        f r15 = g.d(r14);
        C0224b r4 = C0224b.f8609f;
        r15.h(r4);
        Context r16 = f8603d;
        if (r16 == null) goto L26;
        g.d(r16).b(r4);
        com.obric.matrix.r.d.a.g().k(com.obric.matrix.account.a.f8438a.v());
        f8604e = true;
        com.obric.matrix.r.c.c.j("OAccountManager", "initPre done");
        return;
    L26:
        o.v("mContext");
        throw null;
    L28:
        o.v("mContext");
        throw null;
    L30:
        o.v("mContext");
        throw null;
    L17:
        r11 = f8602c;
        goto L18
    L32:
        o.v("mContext");
        throw null;
    }

    public final void r(com.obric.matrix.account_api.c r1) {
        o.f(r1, "listener");
        f8607h.remove(r1);
    }
}
