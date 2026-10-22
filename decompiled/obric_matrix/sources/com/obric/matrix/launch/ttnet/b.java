package com.obric.matrix.launch.ttnet;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.mpaas.app.AppInfo;
import com.bytedance.mpaas.applog.IBdtrackerService;
import com.bytedance.news.common.service.manager.d;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f9158a;

    public b() {
        this.f9158a = new d.b.m.c.a(getContext(), "tt_net_sp", 1);
    }

    @Override // com.bytedance.ttnet.e
    public void a(Context r1, JSONObject r2) {
    }

    @Override // com.bytedance.ttnet.e
    public void b(Context r3, Map<String, ?> r4) {
        SharedPreferences.Editor r2 = this.f9158a.edit();     // Catch: Throwable -> L24
        if (r4 == null) goto L44;
        Iterator<Map.Entry<String, ?>> r5 = r4.entrySet().iterator();     // Catch: Throwable -> L24
    L6:
        if (r5.hasNext() == false) goto L22;
        Map.Entry<String, ?> r6 = r5.next();     // Catch: Throwable -> L24
        Object r0 = r6.getValue();     // Catch: Throwable -> L24
        if ((r0 instanceof Integer) == true) goto L9;
        if ((r0 instanceof Long) == true) goto L12;
        if ((r0 instanceof Float) == true) goto L15;
        if ((r0 instanceof Boolean) == true) goto L18;
        if ((r0 instanceof String) == false) goto L6;
        r2.putString(r6.getKey(), (String) r0);     // Catch: Throwable -> L24
        goto L6
    L18:
        r2.putBoolean(r6.getKey(), ((Boolean) r0).booleanValue());     // Catch: Throwable -> L24
        goto L6
    L15:
        r2.putFloat(r6.getKey(), ((Float) r0).floatValue());     // Catch: Throwable -> L24
        goto L6
    L12:
        r2.putLong(r6.getKey(), ((Long) r0).longValue());     // Catch: Throwable -> L24
        goto L6
    L9:
        r2.putInt(r6.getKey(), ((Integer) r0).intValue());     // Catch: Throwable -> L24
        goto L6
    L22:
        r2.commit();     // Catch: Throwable -> L24
        return;
    L44:
        return;
    }

    @Override // com.bytedance.ttnet.e
    public void c(String r1, JSONObject r2) {
    }

    @Override // com.bytedance.ttnet.e
    public void d(Context r2, String r3, String r4, JSONObject r5) {
        IBdtrackerService r1 = (IBdtrackerService) d.a(IBdtrackerService.class);
        if (r1 == null) goto L7;
        JSONObject r6 = new JSONObject();
        r6.put("labelName", r4);     // Catch: JSONException -> L9
        r6.put("extraJson", r5);     // Catch: JSONException -> L9
        r1.onEventV3(r3, r6);     // Catch: JSONException -> L9
        return;
    L13:
        return;
    L7:
        d.b.m.d.a.g("TTNetDependService", new Object[]{"IBdtrackerService not found"});
    }

    @Override // com.bytedance.ttnet.e
    public void e(String r1) {
    }

    @Override // com.bytedance.ttnet.e
    public String[] f() {
        return new String[]{"tnc0-aliec2.zijieapi.com", "tnc0-alisc1.zijieapi.com"};
    }

    @Override // com.bytedance.ttnet.e
    public boolean g() {
        return true;
    }

    @Override // com.bytedance.ttnet.e
    public int getAppId() {
        return Integer.parseInt(AppInfo.getInstatnce().getAid());
    }

    @Override // com.bytedance.ttnet.e
    public Context getContext() {
        return com.bytedance.mpaas.app.a.f5245g;
    }

    @Override // com.bytedance.ttnet.e
    public String h(Context r1, String r2, String r3) {
        return this.f9158a.getString(r2, r3);
    }

    @Override // com.bytedance.ttnet.e
    public int i(Context r1, String r2, int r3) {
        return this.f9158a.getInt(r2, r3);
    }

    @Override // com.bytedance.ttnet.e
    public Map<String, String> j() {
        HashMap r2 = new HashMap();
        r2.put(TTNetInit.DOMAIN_HTTPDNS_KEY, "dig.bdurl.net");
        r2.put(TTNetInit.DOMAIN_NETLOG_KEY, "crash.snssdk.com");
        r2.put(TTNetInit.DOMAIN_BOE_KEY, ".boe-gateway.byted.org");
        return r2;
    }

    @Override // com.bytedance.ttnet.e
    public String k() {
        return ".snssdk.com";
    }

    @Override // com.bytedance.ttnet.e
    public String l() {
        return ".snssdk.com";
    }

    @Override // com.bytedance.ttnet.e
    public ArrayList<String> m() {
        return null;
    }

    @Override // com.bytedance.ttnet.e
    public void onColdStartFinish() {
    }
}
