package d.c.i.f;

import android.graphics.Bitmap;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f16004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f16006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f16007e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f16008f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f16009g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Bitmap.Config f16010h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private d.c.i.i.c f16011i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private d.c.i.t.a f16012j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Object f16013k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f16014l;
    private boolean m;
    private Rect n;

    public d() {
        this.f16003a = 100;
        this.f16005c = d.c.i.c.b.b.c();
        this.f16010h = Bitmap.Config.ARGB_8888;
    }

    public c a() {
        return new c(this);
    }

    public Bitmap.Config b() {
        return this.f16010h;
    }

    public d.c.i.t.a c() {
        return this.f16012j;
    }

    public d.c.i.i.c d() {
        return this.f16011i;
    }

    public boolean e() {
        return this.f16007e;
    }

    public Object f() {
        return this.f16013k;
    }

    public boolean g() {
        return this.f16004b;
    }

    public boolean h() {
        return this.f16008f;
    }

    public int i() {
        return this.f16003a;
    }

    public int j() {
        return this.f16005c;
    }

    public Rect k() {
        return this.n;
    }

    public boolean l() {
        return this.f16009g;
    }

    public boolean m() {
        return this.f16006d;
    }

    public boolean n() {
        return this.f16014l;
    }

    public boolean o() {
        return this.m;
    }

    public d p(Bitmap.Config r1) {
        this.f16010h = r1;
        this.f16014l = true;
        return this;
    }

    public d q(boolean r1) {
        this.f16007e = r1;
        return this;
    }

    public void r(Object r1) {
        this.f16013k = r1;
    }

    public d s(c r2) {
        this.f16004b = r2.f15992b;
        this.f16005c = r2.f15993c;
        this.f16006d = r2.f15994d;
        this.f16007e = r2.f15995e;
        this.f16008f = r2.f15996f;
        this.f16010h = r2.f15998h;
        this.f16011i = r2.f15999i;
        this.f16009g = r2.f15997g;
        this.f16012j = r2.f16000j;
        this.f16013k = r2.f16001k;
        this.f16014l = r2.f16002l;
        this.m = r2.m;
        this.n = r2.n;
        return this;
    }

    public d t(int r1) {
        this.f16005c = r1;
        return this;
    }
}
