package d.b.b.e.a.h;

import android.text.TextUtils;
import d.b.b.o.f;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f12594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f12595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<String> f12596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<String> f12597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f12598e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f12599f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f12600g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f12601h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f12602i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f12603j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f12604k;

    public a() {
        this.f12598e = true;
        this.f12599f = true;
    }

    public int a() {
        return this.f12604k;
    }

    public List<String> b() {
        return this.f12596c;
    }

    public int c() {
        return this.f12602i;
    }

    public int d() {
        return this.f12601h;
    }

    public int e() {
        return this.f12603j;
    }

    public long f() {
        return this.f12594a;
    }

    public long g() {
        return this.f12600g;
    }

    public List<String> h() {
        return this.f12595b;
    }

    public List<String> i() {
        return this.f12597d;
    }

    public boolean j() {
        return this.f12598e;
    }

    public void k(int r1) {
        this.f12604k = r1;
    }

    public void l(boolean r1) {
        this.f12598e = r1;
    }

    public void m(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList();
        this.f12596c = r0;
        r0.add(r2);
    }

    public void n(int r1) {
        this.f12602i = r1;
    }

    public void o(int r1) {
        this.f12601h = r1;
    }

    public void p(int r1) {
        this.f12603j = r1;
    }

    public void q(long r1) {
        this.f12594a = r1;
    }

    public void r(long r1) {
        this.f12600g = r1;
    }

    public void s(List<String> r2) {
        if (f.b(r2) == false) goto L5;
        return;
    L5:
        this.f12595b = r2;
    }

    public void t(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList();
        this.f12597d = r0;
        r0.add(r2);
    }

    public String toString() {
        return "SlardarHandlerConfig{onceReportMaxSizeBytes=" + this.f12594a + ", reportUrlList=" + this.f12595b + ", exceptionUrl=" + this.f12596c + ", traceReportUrl=" + this.f12597d + ", isEncrypt=" + this.f12598e + ", isUploadInternalExcetpion=" + this.f12599f + ", reportInterval=" + this.f12600g + ", maxSizeMB=" + this.f12601h + ", keepDays=" + this.f12602i + ", maxSizeMBToday=" + this.f12603j + '}';
    }

    public void u(boolean r1) {
        this.f12599f = r1;
    }
}
