package com.bytedance.apm.u;

import com.bytedance.common.wschannel.WsConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f2007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f2009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f2010d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f2011e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f2012f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f2013g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f2014h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f2015i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f2016j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f2017k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f2018l;
    private boolean m;

    public a(boolean r1, long r2, String r4, boolean r5, long r6, String r8) {
        this.f2008b = r1;
        this.f2009c = r2;
        this.f2010d = r4;
        this.f2011e = r5;
        this.f2013g = r6;
        this.f2012f = r8;
    }

    public a(boolean r1, long r2, String r4, boolean r5, long r6, String r8, String r9) {
        this.f2008b = r1;
        this.f2009c = r2;
        this.f2010d = r4;
        this.f2011e = r5;
        this.f2013g = r6;
        this.f2012f = r8;
        this.f2014h = r9;
    }

    public long a() {
        return this.f2013g;
    }

    public long b() {
        return this.f2007a;
    }

    public String c() {
        return this.f2016j;
    }

    public String d() {
        return this.f2012f;
    }

    public String e() {
        return this.f2014h;
    }

    public String f() {
        return this.f2018l;
    }

    public long g() {
        return this.f2009c;
    }

    public String h() {
        return this.f2010d;
    }

    public long i() {
        return this.f2015i;
    }

    public boolean j() {
        return !this.f2008b;
    }

    public boolean k() {
        return this.f2008b;
    }

    public boolean l() {
        return this.f2017k;
    }

    public boolean m() {
        return this.f2011e;
    }

    public boolean n() {
        return this.f2011e;
    }

    public void o(long r1) {
        this.f2007a = r1;
    }

    public void p(boolean r1) {
        this.f2017k = r1;
    }

    public void q(String r1) {
        this.f2016j = r1;
    }

    public void r(String r1) {
        this.f2012f = r1;
    }

    public void s(String r1) {
        this.f2018l = r1;
    }

    public void t(boolean r1) {
        this.f2011e = r1;
    }

    public String toString() {
        return "BatteryLogEntity{id=" + this.f2007a + ", front=" + this.f2008b + ", time=" + this.f2009c + ", type='" + this.f2010d + "', status=" + this.f2011e + ", scene='" + this.f2012f + "', accumulation=" + this.f2013g + ", source='" + this.f2014h + "', versionId=" + this.f2015i + ", processName='" + this.f2016j + "', mainProcess=" + this.f2017k + ", startUuid='" + this.f2018l + "', deleteFlag=" + this.m + '}';
    }

    public void u(long r1) {
        this.f2015i = r1;
    }

    public JSONObject v() {
        JSONObject r0 = new JSONObject();
        r0.put("front", this.f2008b);
        r0.put("time", this.f2009c);
        r0.put(WsConstants.KEY_CONNECTION_TYPE, this.f2010d);
        r0.put("scene", this.f2012f);
        r0.put("processName", this.f2016j);
        return r0;
    }
}
