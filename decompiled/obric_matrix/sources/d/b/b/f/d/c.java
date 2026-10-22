package d.b.b.f.d;

import androidx.annotation.NonNull;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f12792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f12793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double f12794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double f12795d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double f12796e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, Double> f12797f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f12798g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map<String, Double> f12799h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map<String, Double> f12800i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f12801j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f12802k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f12803l;
    private boolean m;

    public c() {
        this.f12792a = false;
        this.f12793b = false;
        this.f12794c = 3.0d;
        this.f12795d = 6.0d;
        this.f12796e = 0.05d;
        this.f12798g = false;
        this.f12801j = true;
        this.m = false;
    }

    @NonNull
    public Map<String, Double> a() {
        return this.f12799h;
    }

    @NonNull
    public Map<String, Double> b() {
        return this.f12800i;
    }

    public double c() {
        return this.f12794c;
    }

    public double d() {
        return this.f12795d;
    }

    public double e() {
        return this.f12796e;
    }

    public Map<String, Double> f() {
        return this.f12797f;
    }

    public int g() {
        return this.f12802k;
    }

    public int h() {
        return this.f12803l;
    }

    public boolean i() {
        return this.f12798g;
    }

    public boolean j() {
        return this.f12793b;
    }

    public boolean k() {
        return this.m;
    }

    public boolean l() {
        return this.f12801j;
    }

    public boolean m() {
        return this.f12792a;
    }

    public void n(Map<String, Double> r1) {
        this.f12799h = r1;
    }

    public void o(boolean r1) {
        this.f12798g = r1;
    }

    public void p(boolean r1) {
        this.f12793b = r1;
    }

    public void q(boolean r1) {
        this.m = r1;
    }

    public void r(boolean r1) {
        this.f12801j = r1;
    }

    public void s(Map<String, Double> r1) {
        this.f12800i = r1;
    }

    public void t(double r1) {
        this.f12794c = r1;
    }

    public String toString() {
        return "CpuExceptionConfig{isOpen=" + this.f12792a + ", isCollectMainThread=" + this.f12793b + ", maxProcessBackCpuSpeed=" + this.f12794c + ", maxProcessForeCpuSpeed=" + this.f12795d + ", maxThreadCpuRate=" + this.f12796e + ", isCollectAllProcess=" + this.f12798g + ", backSceneMaxSpeedMap=" + this.f12799h + ", foreSceneMaxSpeedMap=" + this.f12800i + '}';
    }

    public void u(double r1) {
        this.f12795d = r1;
    }

    public void v(double r1) {
        this.f12796e = r1;
    }

    public void w(Map<String, Double> r1) {
        this.f12797f = r1;
    }

    public void x(boolean r1) {
        this.f12792a = r1;
    }

    public void y(int r1) {
        this.f12802k = r1;
    }

    public void z(int r1) {
        this.f12803l = r1;
    }
}
