package com.loc;

import android.content.Context;
import com.obric.matrix.common_api.INetworkApi;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class f extends o5 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Context f7283l;

    public f(Context r1) {
        this.f7283l = r1;
        c(5000);
        l(5000);
    }

    @Override // com.loc.t0
    public final Map<String, String> b() {
        HashMap r3 = new HashMap();
        r3.put(INetworkApi.CONTENT_TYPE, "application/json");
        r3.put("Accept-Encoding", "gzip");
        r3.put("User-Agent", "AMAP SDK Android core 4.3.6");
        r3.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", new Object[]{"4.3.6", "core"}));
        r3.put("logversion", "2.1");
        return r3;
    }

    @Override // com.loc.t0
    public final String j() {
        if (n5.a().h() == false) goto L6;
        return "https://restapi.amap.com/rest/aaid/get";
    L6:
        return "http://restapi.amap.com/rest/aaid/get";
    }

    @Override // com.loc.t0
    public final String p() {
        return "core";
    }

    @Override // com.loc.t0
    public final Map<String, String> r() {
        HashMap r0 = new HashMap();
        r0.put("key", i5.j(this.f7283l));
        String r1 = k5.a();
        String r3 = k5.c(this.f7283l, r1, u5.r(r0));
        r0.put("ts", r1);
        r0.put("scode", r3);
        return r0;
    }
}
