package com.bytedance.badger.i;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.SystemClock;
import com.bytedance.badger.Badger;
import com.bytedance.badger.h.h;
import com.bytedance.badger.j.i;
import com.bytedance.badger.monitor.TriggerStage;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.common.wschannel.WsConstants;
import java.util.List;
import kotlin.c0;
import kotlin.n0.d.o;
import kotlin.u0.k;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public final class d implements com.bytedance.badger.k.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile long f2595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile SharedPreferences f2596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f2597c = null;

    static {
        f2597c = new d();
    }

    private d() {
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    static SharedPreferences b(d r0, Context r1, int r2, Object r3) {
        if (f2596b == null) goto L9;
        SharedPreferences r4 = f2596b;
        if (r4 != null) goto L11;
        o.p();
        throw null;
    L11:
        return r4;
    L9:
        SharedPreferences r5 = a(Badger.INSTANCE.getContext().getApplicationContext(), "bd_badger", 0);
        f2596b = r5;
        o.b(r5, "sp");
        return r5;
    }

    private final void c(com.bytedance.badger.data.e r7, long r8, TriggerStage r10) {
        com.bytedance.badger.h.a r6 = com.bytedance.badger.h.a.t;
        if (r6.p() == true) goto L5;
    L15:
        com.bytedance.badger.d.g("BadgerNetworkHandler", "sendFollowUpRequest - Badger not initialized or not enabled");
        return;
    L5:
        if (Badger.INSTANCE.isInitialized() == false) goto L15;
        if (r10 != TriggerStage.manual) goto L10;
    L13:
        f2595a = SystemClock.elapsedRealtime();
        new Thread(new a(new b(r8, r10, r7), new c(r10, r7))).start();
        return;
    L10:
        if ((SystemClock.elapsedRealtime() - f2595a) >= r6.t().c()) goto L13;
        com.bytedance.badger.d.g("BadgerNetworkHandler", "sendFollowUpRequest - report interval not satisfied, return");
    }

    @Override // com.bytedance.badger.k.a
    public boolean checkUnfinishedTasks() {
        com.bytedance.badger.h.a r0 = com.bytedance.badger.h.a.t;
        if (r0.p() == true) goto L6;
        return false;
    L6:
        if (Badger.INSTANCE.isInitialized() == true) goto L10;
        String r14 = "Badger not initialized";
    L8:
        com.bytedance.badger.d.e("BadgerNetworkHandler", r14);
        return false;
    L10:
        SharedPreferences r5 = b(this, null, 1, null);
        String r6 = r5.getString("badger_status", null);
        if (r6 == null) goto L46;
        int r7 = r6.hashCode();
        if (r7 == (-995409728)) goto L22;
        if (r7 != (-682587753)) goto L46;
        if (r6.equals("pending") == false) goto L46;
    L23:
        com.bytedance.badger.d.f("BadgerNetworkHandler", "Need badger but not done <" + r6 + ">, start follow-up request");
        com.bytedance.badger.data.e r1 = com.bytedance.badger.data.e.f2544g.a(r5.getString("pending_badger_request", null));     // Catch: JSONException -> L44
        if (r1 != null) goto L28;
        r14 = "Failed to parse pending request: loadedRequest is null";
        goto L8
    L28:
        if (k.q(r1.c()) == false) goto L30;
        r14 = "Failed to parse pending request: challengeKey is empty";
        goto L8
    L30:
        h r8 = r0.k();
        long r9 = System.currentTimeMillis();
        long r10 = r1.b() + r8.c();
        if (r8.b() < 0) goto L33;
        boolean r11 = true;
    L34:
        if (r11 == true) goto L36;
    L39:
        com.bytedance.badger.d.g("BadgerNetworkHandler", "Pending request expired, curTime: " + r9 + ", expireTime: " + r10);
        boolean r12 = true;
    L40:
        if (r12 == false) goto L42;
        r14 = "Failed to parse pending request: expired";
        goto L8
    L42:
        c(r1, r0.u().c(), TriggerStage.recollect);
        return true;
    L36:
        if (r9 > r10) goto L39;
        r12 = false;
        goto L40
    L33:
        r11 = false;
    L44:
        e = move-exception;
        r14 = "Failed to parse pending request: " + e.getMessage();
        goto L8
    L22:
        if (r6.equals("partly") == true) goto L23;
    L46:
        return false;
    }

    @Override // com.bytedance.badger.k.a
    public void handleResponse(String r18, List r19, List r20) {
        o.g(r18, WsConstants.KEY_CONNECTION_URL);
        o.g(r19, "requestHeaders");
        o.g(r20, "responseHeaders");
        com.bytedance.badger.h.a r3 = com.bytedance.badger.h.a.t;
        if (r3.p() == true) goto L6;
        return;
    L6:
        if (Badger.INSTANCE.isInitialized() == true) goto L9;
        com.bytedance.badger.d.g("BadgerNetworkHandler", "handleResponse - Badger not initialized");
        return;
    L9:
        String r4 = i.a(r18);
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        if (r3.s().contains(r4) == false) goto L69;
        String r7 = com.bytedance.badger.k.c.b(r20, "bd-tt-error-code", false, 2, null);
        if (r7 != null) goto L18;
    L21:
        boolean r10 = true;
    L22:
        if (r10 == false) goto L24;
    L27:
        boolean r8 = true;
    L28:
        if (r8 == false) goto L30;
    L31:
        String r5 = com.bytedance.badger.k.c.a(r20, "x-tt-token", true);
        if (r5 != null) goto L36;
        r5 = "";
    L36:
        if (k.q(r5) == false) goto L39;
        com.bytedance.badger.d.e("BadgerNetworkHandler", "handleResponse - token is empty");
        return;
    L39:
        String r0 = com.bytedance.badger.k.c.a(r20, "x-tt-logid", true);
        if (r0 == null) goto L42;
        String r13 = r0;
    L65:
        String r1 = Uri.parse(r18).getQueryParameter(WsConstants.KEY_DEVICE_ID);     // Catch: Exception -> L45
    L67:
        com.bytedance.badger.j.g r2 = com.bytedance.badger.j.g.f2620a;     // Catch: Exception -> L62
        byte[] r6 = r5.getBytes(kotlin.u0.d.f21429a);     // Catch: Exception -> L62
        o.b(r6, "(this as java.lang.String).getBytes(charset)");     // Catch: Exception -> L62
        int r9 = com.bytedance.badger.j.g.b(r2, r6, 0, 2, null);     // Catch: Exception -> L62
        c0.b(r9);     // Catch: Exception -> L62
        com.bytedance.badger.d.f("BadgerNetworkHandler", "Get param from request,ck: " + c0.j(r9) + ", logid: " + r13 + ", deviceId: " + r1);
        String r11 = c0.j(r9);
        if (r1 == null) goto L51;
        String r12 = r1;
    L52:
        com.bytedance.badger.data.e r14 = new com.bytedance.badger.data.e(r11, 15, r12, 0, r4, r13, 8, null);
        com.bytedance.badger.d.f("BadgerNetworkHandler", "<<Handle report path>> Real time report path: " + r4);
        SharedPreferences r15 = b(this, null, 1, null);
        if (r15 == null) goto L61;
        SharedPreferences.Editor r16 = r15.edit();
        if (r16 == null) goto L61;
        SharedPreferences.Editor r17 = r16.putString("badger_status", "pending");
        if (r17 == null) goto L61;
        SharedPreferences.Editor r21 = r17.putString("pending_badger_request", r14.h());
        if (r21 == null) goto L61;
        r21.apply();
    L61:
        c(r14, 0, TriggerStage.login_finished);
        com.bytedance.badger.d.f("BadgerNetworkHandler", "<<Handle report path>> OK");
        return;
    L51:
        r12 = "";
    L62:
        e = move-exception;
        com.bytedance.badger.d.e("BadgerNetworkHandler", "genChallengeKey - failed to gen challenge key: " + e.getMessage());
        return;
    L45:
        e = move-exception;
        com.bytedance.badger.d.e("BadgerNetworkHandler", "getDeviceId - failed to parse url: " + r18 + ", error: " + e.getMessage());
        r1 = null;
        goto L67
    L42:
        r13 = "";
        goto L65
    L30:
        if (r3.r() == true) goto L31;
        return;
    L24:
        if (o.a(r7, BDLocationException.ERROR_TIMEOUT) == true) goto L27;
        r8 = false;
        goto L28
    L18:
        if (r7.length() == 0) goto L21;
        r10 = false;
        goto L22
    }

    @Override // com.bytedance.badger.k.a
    public boolean invalidateRecord() {
        if (com.bytedance.badger.h.a.t.p() == true) goto L5;
        return false;
    L5:
        if (Badger.INSTANCE.isInitialized() == false) goto L17;
        SharedPreferences r2 = b(this, null, 1, null);
        if (r2 == null) goto L14;
        SharedPreferences.Editor r3 = r2.edit();
        if (r3 == null) goto L14;
        SharedPreferences.Editor r4 = r3.clear();
        if (r4 == null) goto L14;
        r4.apply();
    L14:
        return true;
    L17:
        return false;
    }

    @Override // com.bytedance.badger.k.a
    public void sendFollowUpRequest(com.bytedance.badger.data.e r2, long r3) {
        o.g(r2, "request");
        c(r2, r3, TriggerStage.manual);
    }
}
