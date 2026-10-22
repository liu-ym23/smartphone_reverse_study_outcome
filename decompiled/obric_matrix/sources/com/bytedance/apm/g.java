package com.bytedance.apm;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f1534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1535d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f1536e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1537f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f1538g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f1539h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private JSONObject f1540i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Map<String, String> f1541j;

    public g() {
    }

    public int a() {
        return this.f1532a;
    }

    public String b() {
        return this.f1538g;
    }

    public String c() {
        return this.f1534c;
    }

    public String d() {
        return this.f1533b;
    }

    public int e() {
        return this.f1537f;
    }

    public Map<String, String> f() {
        return this.f1541j;
    }

    public String g() {
        return this.f1539h;
    }

    public String h() {
        if (d.j() != null) goto L5;
        return null;
    L5:
        return d.j().getSessionId();
    }

    public JSONObject i() {
        return this.f1540i;
    }

    public long j() {
        if (d.j() != null) goto L5;
        return 0;
    L5:
        return d.j().getUid();
    }

    public int k() {
        return this.f1535d;
    }

    public String l() {
        return this.f1536e;
    }

    public void m(int r1) {
        this.f1532a = r1;
    }

    public void n(String r1) {
        this.f1538g = r1;
    }

    public void o(String r1) {
        this.f1534c = r1;
    }

    public void p(String r1) {
        this.f1533b = r1;
    }

    public void q(int r1) {
        this.f1537f = r1;
    }

    public void r(Map<String, String> r1) {
        this.f1541j = r1;
    }

    public void s(String r1) {
    }

    public void t(String r1) {
        this.f1539h = r1;
    }

    public void u(JSONObject r1) {
        this.f1540i = r1;
    }

    public void v(int r1) {
        this.f1535d = r1;
    }

    public void w(int r1) {
    }

    public void x(String r1) {
        this.f1536e = r1;
    }
}
