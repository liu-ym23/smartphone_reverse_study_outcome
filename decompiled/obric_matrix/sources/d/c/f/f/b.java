package d.c.f.f;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import com.ss.ttuploader.TTVideoUploader;
import d.c.c.d.i;
import d.c.f.e.p;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static final p.b r = null;
    public static final p.b s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Resources f15685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Drawable f15687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private p.b f15688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Drawable f15689e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private p.b f15690f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Drawable f15691g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private p.b f15692h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Drawable f15693i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private p.b f15694j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private p.b f15695k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private PointF f15696l;
    private ColorFilter m;
    private Drawable n;
    private List<Drawable> o;
    private Drawable p;
    private d q;

    static {
        r = p.b.f15667f;
        s = p.b.f15668g;
    }

    public b(Resources r1) {
        this.f15685a = r1;
        s();
    }

    private void E() {
        List<Drawable> r1 = this.o;
        if (r1 == null) goto L8;
        Iterator<Drawable> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        i.g(r2.next());
        goto L6
    L10:
        return;
    }

    private void s() {
        this.f15686b = TTVideoUploader.KeyIsGetTosKey;
        this.f15687c = null;
        p.b r1 = r;
        this.f15688d = r1;
        this.f15689e = null;
        this.f15690f = r1;
        this.f15691g = null;
        this.f15692h = r1;
        this.f15693i = null;
        this.f15694j = r1;
        this.f15695k = s;
        this.f15696l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
    }

    public b A(p.b r1) {
        this.f15688d = r1;
        return this;
    }

    public b B(int r2) {
        this.f15689e = this.f15685a.getDrawable(r2);
        return this;
    }

    public b C(p.b r1) {
        this.f15690f = r1;
        return this;
    }

    public b D(d r1) {
        this.q = r1;
        return this;
    }

    public a a() {
        E();
        return new a(this);
    }

    public ColorFilter b() {
        return this.m;
    }

    public PointF c() {
        return this.f15696l;
    }

    public p.b d() {
        return this.f15695k;
    }

    public Drawable e() {
        return this.n;
    }

    public int f() {
        return this.f15686b;
    }

    public Drawable g() {
        return this.f15691g;
    }

    public p.b h() {
        return this.f15692h;
    }

    public List<Drawable> i() {
        return this.o;
    }

    public Drawable j() {
        return this.f15687c;
    }

    public p.b k() {
        return this.f15688d;
    }

    public Drawable l() {
        return this.p;
    }

    public Drawable m() {
        return this.f15693i;
    }

    public p.b n() {
        return this.f15694j;
    }

    public Resources o() {
        return this.f15685a;
    }

    public Drawable p() {
        return this.f15689e;
    }

    public p.b q() {
        return this.f15690f;
    }

    public d r() {
        return this.q;
    }

    public b t(p.b r1) {
        this.f15695k = r1;
        return this;
    }

    public b u(Drawable r1) {
        this.n = r1;
        return this;
    }

    public b v(int r1) {
        this.f15686b = r1;
        return this;
    }

    public b w(int r2) {
        this.f15691g = this.f15685a.getDrawable(r2);
        return this;
    }

    public b x(p.b r1) {
        this.f15692h = r1;
        return this;
    }

    public b y(int r2) {
        this.f15687c = this.f15685a.getDrawable(r2);
        return this;
    }

    public b z(Drawable r1) {
        this.f15687c = r1;
        return this;
    }
}
