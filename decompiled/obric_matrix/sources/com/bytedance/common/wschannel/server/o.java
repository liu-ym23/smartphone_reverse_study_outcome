package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.model.SsWsApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
class o implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f3805b = "o";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f3806a;

    static {
    }

    o(Context r1) {
        this.f3806a = r1;
    }

    private boolean c(IWsApp r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r2.c() > 0) goto L9;
        return false;
    L9:
        if (r2.getAppId() > 0) goto L12;
        return false;
    L12:
        if (com.bytedance.common.utility.k.c(r2.r()) == false) goto L15;
        return false;
    L15:
        if (r2.a() > 0) goto L18;
        return false;
    L18:
        if (r2.f0().isEmpty() == false) goto L21;
        return false;
    L21:
        if (com.bytedance.common.utility.k.c(r2.getDeviceId()) == false) goto L24;
        return false;
    L24:
        if (r2.b0() > 0) goto L27;
        return false;
    L27:
        if (com.bytedance.common.utility.k.c(r2.getInstallId()) == false) goto L30;
        return false;
    L30:
        if (r2.o() == 0) goto L32;
        return false;
    L32:
        return true;
    }

    @Override // com.bytedance.common.wschannel.server.g
    public Map<Integer, IWsApp> a() {
        LinkedHashMap r0 = new LinkedHashMap();
        String r1 = com.bytedance.common.wschannel.o.f(this.f3806a).e();     // Catch: Exception -> L29
        if (Logger.debug() == false) goto L7;
        Logger.d(f3805b, "load from sp wsAppStr: " + r1);     // Catch: Exception -> L29
    L7:
        if (TextUtils.isEmpty(r1) == false) goto L9;
        return r0;
    L9:
        JSONArray r2 = new JSONArray(r1);     // Catch: Exception -> L29
        int r3 = r2.length();     // Catch: Exception -> L29
        if (r3 > 0) goto L12;
        return r0;
    L12:
        ArrayList<Integer> r4 = com.bytedance.common.wschannel.o.f(this.f3806a).a();     // Catch: Exception -> L29
        if (Logger.debug() == false) goto L15;
        Logger.d(f3805b, "load from sp disabledList: " + r4);     // Catch: Exception -> L29
    L15:
        int r5 = 0;
    L16:
        if (r5 >= r3) goto L26;
        SsWsApp r6 = new SsWsApp.b().c(r2.optJSONObject(r5));     // Catch: Exception -> L29
        if (c(r6) == false) goto L24;
        if (r4 != null) goto L21;
    L23:
        r0.put(Integer.valueOf(WsChannelService.d(r6)), r6);     // Catch: Exception -> L29
        goto L24
    L21:
        if (r4.contains(Integer.valueOf(WsChannelService.d(r6))) == false) goto L23;
    L24:
        r5 = r5 + 1;     // Catch: Exception -> L29
        goto L16
    L26:
        if (Logger.debug() == false) goto L31;
        Logger.d(f3805b, "loadWsChannels final wsApp: " + r0);     // Catch: Exception -> L29
    L31:
        return r0;
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L31
    }

    @Override // com.bytedance.common.wschannel.server.g
    public void b(Map<Integer, IWsApp> r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        JSONArray r0 = new JSONArray();
        monitor-enter(WsChannelService.class);
        Iterator<Map.Entry<Integer, IWsApp>> r6 = r5.entrySet().iterator();     // Catch: Throwable -> L22
    L8:
        if (r6.hasNext() == false) goto L16;
        Map.Entry<Integer, IWsApp> r2 = r6.next();     // Catch: Throwable -> L22
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L22
        goto L8
    L11:
        if (c(r2.getValue()) == false) goto L8;
        r0.put(r2.getValue().m());     // Catch: Exception -> L14 Throwable -> L22
    L16:
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L22
        Logger.d(f3805b, "save to sp : " + r0.toString());     // Catch: Exception -> L19
        com.bytedance.common.wschannel.o.f(this.f3806a).l(r0.toString());     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
        return;
    L22:
        th = move-exception;
        throw th;
    }
}
