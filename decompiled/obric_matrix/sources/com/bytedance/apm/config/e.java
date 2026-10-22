package com.bytedance.apm.config;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f1440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1443f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1444g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f1445h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1446i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f1447j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f1448k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f1449l;
    private long m;
    private boolean n;
    private boolean o;

    public e() {
    }

    public int a() {
        return this.f1443f;
    }

    public long b() {
        return this.f1449l;
    }

    public long c() {
        return this.f1445h;
    }

    public long d() {
        return this.m;
    }

    public boolean e() {
        return this.f1441d;
    }

    public boolean f() {
        return this.n;
    }

    public boolean g() {
        return this.o;
    }

    public boolean h() {
        return this.f1442e;
    }

    public boolean i() {
        return this.f1444g;
    }

    public void j(JSONObject r1) {
    }

    public void k(long r1) {
        this.f1440c = r1;
    }

    public void l(boolean r1) {
        this.f1441d = r1;
    }

    public void m(boolean r1) {
        this.n = r1;
    }

    public void n(int r1) {
        this.f1443f = r1;
    }

    public void o(long r1) {
        this.f1449l = r1;
    }

    public void p(boolean r1) {
        this.f1447j = r1;
    }

    public void q(boolean r1) {
        this.o = r1;
    }

    public void r(boolean r1) {
        this.f1442e = r1;
    }

    public void s(boolean r1) {
        this.f1438a = r1;
    }

    public void t(boolean r1) {
        this.f1439b = r1;
    }

    public String toString() {
        return "FluencyConfig{enableStackSampling=" + this.f1438a + ", enableTrace=" + this.f1439b + ", atraceTag=" + this.f1440c + ", blockDumpStackEnable=" + this.f1441d + ", enableGfxMonitor=" + this.f1442e + ", blockMonitorMode=" + this.f1443f + ", seriousBlockEnableUpload=" + this.f1444g + ", seriousBlockThreshold=" + this.f1445h + ", slowMethodEnableUpload=" + this.f1446i + ", dropEnableUpload=" + this.f1447j + ", fpsEnableUpload=" + this.f1448k + ", blockThreshold=" + this.f1449l + ", slowMethodDropThreshold=" + this.m + ", blockEnableUpload=" + this.n + ", dropSlowMethodSwitch=" + this.o + '}';
    }

    public void u(boolean r1) {
        this.f1448k = r1;
    }

    public void v(boolean r1) {
        this.f1444g = r1;
    }

    public void w(long r1) {
        this.f1445h = r1;
    }

    public void x(long r1) {
        this.m = r1;
    }

    public void y(boolean r1) {
        this.f1446i = r1;
    }
}
