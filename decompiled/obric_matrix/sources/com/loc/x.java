package com.loc;

import android.content.Context;
import com.obric.matrix.common_api.INetworkApi;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class x extends o5 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public JSONObject f7949l;
    public Context m;

    public x() {
        this.f7949l = null;
        this.m = null;
    }

    @Override // com.loc.t0
    public final Map<String, String> b() {
        HashMap r0 = new HashMap();
        r0.put(INetworkApi.CONTENT_TYPE, "application/x-www-form-urlencoded");
        r0.put("Accept-Encoding", "gzip");
        r0.put("User-Agent", "AMAP SDK Android core 4.3.6");
        r0.put("X-INFO", k5.b(this.m));
        r0.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", new Object[]{"4.3.6", "core"}));
        r0.put("logversion", "2.1");
        return r0;
    }

    @Override // com.loc.t0
    public final String j() {
        if (n5.a().h() == false) goto L6;
        return "https://restsdk.amap.com/sdk/compliance/params";
    L6:
        return "http://restsdk.amap.com/sdk/compliance/params";
    }

    @Override // com.loc.t0
    public final String p() {
        return "core";
    }

    @Override // com.loc.t0
    public final byte[] q() {
        StringBuffer r0 = new StringBuffer();     // Catch: Throwable -> L11
        JSONObject r1 = this.f7949l;     // Catch: Throwable -> L11
        if (r1 == null) goto L9;
        Iterator<String> r2 = r1.keys();     // Catch: Throwable -> L11
    L7:
        if (r2.hasNext() == false) goto L9;
        String r3 = r2.next();     // Catch: Throwable -> L11
        r0.append(r3 + "=" + URLEncoder.encode(this.f7949l.get(r3).toString(), "utf-8") + "&");     // Catch: Throwable -> L11
    L9:
        r0.append("output=json");     // Catch: Throwable -> L11
        String r4 = i5.j(this.m);     // Catch: Throwable -> L11
        r0.append("&key=".concat(String.valueOf(r4)));     // Catch: Throwable -> L11
        String r5 = k5.a();     // Catch: Throwable -> L11
        r0.append("&ts=".concat(String.valueOf(r5)));     // Catch: Throwable -> L11
        r0.append("&scode=" + k5.c(this.m, r5, "key=".concat(String.valueOf(r4))));     // Catch: Throwable -> L11
        return r0.toString().getBytes("utf-8");
    L11:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    @Override // com.loc.t0
    public final Map<String, String> r() {
        return null;
    }
}
