package com.bytedance.apm6.hub.b;

import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h implements d.b.b.e.a.h.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f2171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f2172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f2173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f2174d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f2175e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f2176f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    String f2177g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    String f2178h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    String f2179i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile d.b.b.e.a.h.a f2180j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private JSONObject f2181k;

    class a implements com.bytedance.apm6.hub.b.i.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f2182a;

        a(h r1) {
            this.f2182a = r1;
        }

        @Override // com.bytedance.apm6.hub.b.i.b
        public void a(JSONObject r1, boolean r2) {
            h.a(this.f2182a, r1, r2);
        }
    }

    public h(JSONObject r2) {
        this.f2171a = "report_setting";
        this.f2172b = "enable_encrypt";
        this.f2173c = "hosts";
        this.f2174d = "apm6_once_max_size_kb";
        this.f2175e = "apm6_uploading_interval";
        this.f2176f = "enable_report_internal_exception";
        this.f2177g = "log_reserve_days";
        this.f2178h = "log_max_size_mb";
        this.f2179i = "compress_type";
        this.f2181k = r2;
        b();
    }

    static /* synthetic */ void a(h r0, JSONObject r1, boolean r2) {
        r0.c(r1, r2);
    }

    private void b() {
        com.bytedance.apm6.hub.b.i.a.g().h();
        com.bytedance.apm6.hub.b.i.a.g().k(new a(this));
    }

    private void c(JSONObject r14, boolean r15) {
        if (r14 != null) goto L4;
        return;
    L4:
        JSONObject r16 = d.b.b.o.e.h(r14, "general", "slardar_api_settings", this.f2171a);
        if (r16 != null) goto L7;
        return;
    L7:
        List<String> r1 = d(r16.optJSONArray(this.f2173c));
        ArrayList r2 = new ArrayList();
        String r4 = null;
        if (d.b.b.o.f.b(r1) == true) goto L17;
        Iterator<String> r3 = r1.iterator();
        String r5 = null;
    L11:
        if (r3.hasNext() == false) goto L18;
        String r6 = r3.next();
        r2.add("https://" + r6 + "/monitor/collect/batch/");
        if (r4 != null) goto L15;
        r4 = "https://" + r6 + "/monitor/collect/c/exception";
    L15:
        if (r5 != null) goto L11;
        r5 = "https://" + r6 + "/monitor/collect/c/trace_collect";
    L18:
        boolean r7 = true;
        boolean r8 = r16.optBoolean(this.f2172b, true);
        long r9 = r16.optLong(this.f2174d, -1) * 1024;
        long r10 = r16.optLong(this.f2175e, -1) * 1000;
        if (d.b.b.o.e.f(r14, "general", this.f2176f) == 1) goto L22;
        r7 = false;
    L22:
        d.b.b.e.a.h.a r11 = new d.b.b.e.a.h.a();
        r11.s(r2);
        r11.m(r4);
        r11.t(r5);
        r11.q(r9);
        r11.l(r8);
        r11.r(r10);
        r11.u(r7);
        JSONObject r12 = this.f2181k;
        if (r12 == null) goto L25;
        r11.p(r12.optInt("max_size_mb_today", -1));
    L25:
        r11.k(r16.optInt(this.f2179i, 2));
        JSONObject r17 = r14.optJSONObject("general");
        if (r17 == null) goto L30;
        JSONObject r18 = r17.optJSONObject("cleanup");
        if (r18 == null) goto L30;
        r11.o(r18.optInt(this.f2178h, 80));
        r11.n(r18.optInt(this.f2177g, 5));
    L30:
        this.f2180j = r11;
        if (d.b.b.o.a.c() == false) goto L33;
        d.b.b.o.m.b.a("APM-Config", "received reportSetting=" + r16);
        d.b.b.o.m.b.a("APM-Config", "parsed SlardarHandlerConfig=" + this.f2180j);
    L33:
        d.b.b.i.d.b.h(r7);
        d.b.b.i.d.b.i(r4);
        d.b.b.e.a.e.d().e(getConfig());
        return;
    L17:
        r5 = null;
        goto L18
    }

    private static List<String> d(JSONArray r6) {
        if (r6 == null) goto L21;
    L15:
        e = e;
        String r1 = "parse setting host malformedurl exception";
    L19:
        d.b.b.o.m.b.c("APM-Setting", r1, e);
    L17:
        e = e;
        r1 = "parse setting host json exception";
        goto L19
    L5:
        if (r6.length() <= 0) goto L21;
        ArrayList r2 = new ArrayList(2);     // Catch: MalformedURLException -> L15 JSONException -> L17
        int r3 = r6.length();     // Catch: MalformedURLException -> L15 JSONException -> L17
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L14;
        String r5 = new URL(r6.getString(r4)).getHost();     // Catch: MalformedURLException -> L15 JSONException -> L17
        if (TextUtils.isEmpty(r5) == true) goto L13;
        if (r5.indexOf(46) <= 0) goto L13;
        r2.add(r5);     // Catch: MalformedURLException -> L15 JSONException -> L17
    L13:
        r4 = r4 + 1;
        goto L7
    L14:
        return r2;
    L21:
        return Collections.emptyList();
    }

    @Override // d.b.b.e.a.h.b
    public d.b.b.e.a.h.a getConfig() {
        return this.f2180j;
    }
}
