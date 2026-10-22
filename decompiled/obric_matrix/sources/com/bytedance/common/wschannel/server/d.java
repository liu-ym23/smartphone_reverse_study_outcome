package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile e f3744a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f3745b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f3746c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicBoolean f3747d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static CountDownLatch f3748e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static b f3749f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Object f3750g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f3751h = null;

    static class a extends com.bytedance.common.wschannel.u.e {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b(new e(d.c()));
            d.a().o();
        }
    }

    public interface b {
        void a(String r1, JSONObject r2);
    }

    static {
        f3747d = new AtomicBoolean(false);
        f3748e = new CountDownLatch(1);
        f3751h = d.class.getSimpleName();
    }

    public d() {
    }

    static /* synthetic */ e a() {
        return f3744a;
    }

    static /* synthetic */ e b(e r0) {
        f3744a = r0;
        return r0;
    }

    static /* synthetic */ Context c() {
        return f3745b;
    }

    @Nullable
    private static Map<String, String> d(List<WsChannelMsg.MsgHeader> r3) {
        if (r3 != null) goto L4;
        return null;
    L4:
        if (r3.isEmpty() == true) goto L24;
        HashMap r0 = new HashMap();
        Iterator<WsChannelMsg.MsgHeader> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L14;
        WsChannelMsg.MsgHeader r1 = r4.next();
        if (TextUtils.isEmpty(r1.b()) == true) goto L8;
        if (TextUtils.isEmpty(r1.d()) == true) goto L8;
        r0.put(r1.b(), r1.d());
        goto L8
    L14:
        return r0;
    L24:
        return null;
    }

    @Nullable
    private static String[] e(Map<String, String> r4) {
        if (r4.containsKey("x_frontier_is_ack") == true) goto L5;
    L15:
        return null;
    L5:
        if (r4.containsKey("x_frontier_ack_msgid") == false) goto L15;
        if (r4.get("x_frontier_is_ack").equals(LocationInfoConst.ALLOW_USE_LOCATION) == true) goto L11;
        return null;
    L11:
        if (TextUtils.isEmpty(r4.get("x_frontier_ack_msgid")) == false) goto L14;
        return null;
    L14:
        return r4.get("x_frontier_ack_msgid").split(",");
    }

    private static void f() {
        if (f3750g == null) goto L12;
        return;
    L12:
        f3750g = Class.forName("com.bytedance.ttnet.TTNetInit").newInstance();     // Catch: Throwable -> L9
        if (Logger.debug() == false) goto L14;
        Logger.d(f3751h, "Get TTNetInit instance success.");     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        Logger.e(f3751h, "Get TTNetInit instance failed.");
        th.printStackTrace();
    }

    private static boolean g(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return false;
    L6:
        if (r2.equals("x_frontier_qos") == false) goto L8;
    L15:
        return true;
    L8:
        if (r2.equals(WsConstants.KEY_FRONTIER_MSGID) == true) goto L15;
        if (r2.equals("x_frontier_ttl") == true) goto L15;
        if (r2.equals("x_frontier_ack_msgid") == true) goto L15;
        if (r2.equals("x_frontier_is_ack") == true) goto L15;
        return false;
    }

    public static boolean h() {
        return f3746c;
    }

    private static boolean i(Map<String, String> r6) {
        if (r6.containsKey("x_frontier_qos") == true) goto L5;
    L31:
        return false;
    L5:
        if (r6.containsKey("x_frontier_qos_ack") == false) goto L31;
        if (r6.containsKey("x_frontier_is_ack") == false) goto L31;
        if (r6.containsKey("x_frontier_ack_msgid") == false) goto L31;
        if (r6.get("x_frontier_qos") == null) goto L31;
        if (r6.get("x_frontier_qos").equals("2") == false) goto L31;
        if (r6.get("x_frontier_qos_ack") == null) goto L31;
        if (r6.get("x_frontier_qos_ack").equals(LocationInfoConst.ALLOW_USE_LOCATION) == false) goto L31;
        if (r6.get("x_frontier_is_ack") == null) goto L31;
        if (r6.get("x_frontier_is_ack").equals(LocationInfoConst.ALLOW_USE_LOCATION) == false) goto L31;
        if (TextUtils.isEmpty(r6.get("x_frontier_ack_msgid")) == false) goto L29;
        return false;
    L29:
        return true;
    }

    private static boolean j(Map<String, String> r5) {
        if (r5.containsKey("x_frontier_qos") == true) goto L5;
    L26:
        return false;
    L5:
        if (r5.containsKey(WsConstants.KEY_FRONTIER_MSGID) == false) goto L26;
        if (r5.containsKey("x_frontier_ttl") == false) goto L26;
        if (r5.get("x_frontier_qos") == null) goto L26;
        if (r5.get("x_frontier_qos").equals("2") == false) goto L26;
        String r0 = r5.get(WsConstants.KEY_FRONTIER_MSGID);
        if (TextUtils.isEmpty(r0) == true) goto L26;
        if (r0.getBytes("UTF-8").length != 32) goto L26;
        if (Long.valueOf(r5.get("x_frontier_ttl")).longValue() > 0) goto L24;
        return false;
    L24:
        return true;
    }

    private static void k(WsChannelMsg r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.g() == null) goto L20;
        Iterator<WsChannelMsg.MsgHeader> r2 = r1.g().iterator();
        if (r2 != null) goto L10;
        return;
    L10:
        if (r2.hasNext() == false) goto L21;
        if (g(r2.next().b()) == false) goto L10;
        r2.remove();
        goto L10
    L21:
        return;
    }

    public static void l(JSONObject r8) {
        b r0 = f3749f;
        if (r0 == null) goto L10;
        r0.a("frontier_qos2", r8);
    L10:
        Object r1 = f3750g;     // Catch: Throwable -> L9
        if (r1 == null) goto L12;
        Reflect.on(r1).call("monitorLogSend", new Class[]{String.class, JSONObject.class}, new Object[]{"frontier_qos2", r8});     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }

    static void m() {
        f3747d.set(true);
        f3748e.countDown();
    }

    public static boolean n(WsChannelMsg r6) {
        if (f3746c == true) goto L35;
        return false;
    L35:
        Map<String, String> r0 = d(r6.g());     // Catch: Throwable -> L32
        if (r0 != null) goto L8;
    L31:
        return false;
    L8:
        if (r0.isEmpty() == true) goto L31;
        boolean r2 = i(r0);     // Catch: Throwable -> L32
        boolean r3 = j(r0);     // Catch: Throwable -> L32
        if (r2 == true) goto L14;
        if (r3 == true) goto L14;
        return false;
    L14:
        AtomicBoolean r4 = f3747d;     // Catch: Throwable -> L32
        if (r4.get() == true) goto L18;
        f();     // Catch: Throwable -> L32
        com.bytedance.common.wschannel.u.d.d().e(new a());     // Catch: Throwable -> L32
        o();     // Catch: Throwable -> L32
    L18:
        if (r4.get() == true) goto L21;
        return false;
    L21:
        if (f3744a != null) goto L24;
        return false;
    L24:
        if (Logger.debug() == false) goto L26;
        Logger.d(f3751h, "origin wschannel msg:" + r6.toString());     // Catch: Throwable -> L32
    L26:
        if (r2 == false) goto L29;
        f3744a.i(r0.get("x_frontier_ack_msgid").split(","));     // Catch: Throwable -> L32
        return true;
    L29:
        f3744a.i(e(r0));     // Catch: Throwable -> L32
        k(r6);     // Catch: Throwable -> L32
        return f3744a.B(r0.get(WsConstants.KEY_FRONTIER_MSGID), Long.valueOf(r0.get("x_frontier_ttl")).longValue());
    L32:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    private static void o() {
        if (f3747d.get() == true) goto L11;
        f3748e.await(WsConstants.EXIT_DELAY_TIME, TimeUnit.MILLISECONDS);     // Catch: Exception -> L8
        if (f3748e.getCount() != 1) goto L12;
        f3748e.countDown();     // Catch: Exception -> L8
        return;
    L12:
        return;
    L13:
        return;
    }
}
