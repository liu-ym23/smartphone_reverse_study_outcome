package d.b.k.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class t {

    @SuppressLint({"CI_StaticFieldLeak"})
    public static final t P = null;
    private v A;
    private p B;
    private String C;
    private Executor D;
    private d E;
    private k F;
    private ImageView G;
    private d.b.k.a.y.f H;
    private d.b.k.a.y.g I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private d.b.k.a.y.i f14060J;
    private boolean K;
    private boolean L;
    private d.b.k.a.w.a M;
    private int N;
    private d.b.k.a.y.c O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Uri f14061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f14062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f14063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f14064d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f14065e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f14066f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f14067g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f14068h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f14069i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f14070j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f14071k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f14072l;
    private int m;
    private int n;
    private Drawable o;
    private u p;
    private int q;
    private u r;
    private Drawable s;
    private int t;
    private u u;
    private Bitmap.Config v;
    private u w;
    private e x;
    private b y;
    private f z;

    static {
        t r0 = new t(new d.b.k.a.w.a(Collections.emptyList()));
        r0.c0(Uri.parse(""));
        P = r0;
    }

    public t(@NonNull Uri r3) {
        this.f14064d = false;
        this.f14065e = true;
        this.f14066f = false;
        this.f14067g = -1;
        this.f14068h = false;
        this.f14069i = -1;
        this.f14070j = -1;
        this.f14071k = -1;
        this.f14072l = -1;
        this.m = -1;
        this.n = -1;
        this.q = -1;
        this.x = null;
        this.B = p.f14016g;
        this.E = d.f13980g;
        this.N = a.f13976c.b();
        this.f14061a = r3;
    }

    public t(@NonNull d.b.k.a.w.a r3) {
        this.f14064d = false;
        this.f14065e = true;
        this.f14066f = false;
        this.f14067g = -1;
        this.f14068h = false;
        this.f14069i = -1;
        this.f14070j = -1;
        this.f14071k = -1;
        this.f14072l = -1;
        this.m = -1;
        this.n = -1;
        this.q = -1;
        this.x = null;
        this.B = p.f14016g;
        this.E = d.f13980g;
        this.N = a.f13976c.b();
        this.M = r3;
    }

    public t(@NonNull Object r3) {
        this.f14064d = false;
        this.f14065e = true;
        this.f14066f = false;
        this.f14067g = -1;
        this.f14068h = false;
        this.f14069i = -1;
        this.f14070j = -1;
        this.f14071k = -1;
        this.f14072l = -1;
        this.m = -1;
        this.n = -1;
        this.q = -1;
        this.x = null;
        this.B = p.f14016g;
        this.E = d.f13980g;
        this.N = a.f13976c.b();
        this.f14062b = r3;
    }

    public t(@NonNull String r3) {
        this.f14064d = false;
        this.f14065e = true;
        this.f14066f = false;
        this.f14067g = -1;
        this.f14068h = false;
        this.f14069i = -1;
        this.f14070j = -1;
        this.f14071k = -1;
        this.f14072l = -1;
        this.m = -1;
        this.n = -1;
        this.q = -1;
        this.x = null;
        this.B = p.f14016g;
        this.E = d.f13980g;
        this.N = a.f13976c.b();
        this.f14061a = d.b.k.a.z.c.a(r3);
    }

    private void Q() {
        Context r0 = this.f14063c;
        if (r0 != null) goto L5;
    L7:
        String r1 = "";
    L9:
        if (TextUtils.isEmpty(r1) == true) goto L15;
        if (TextUtils.isEmpty(this.C) == true) goto L13;
        r1 = r1 + "-" + this.C;
    L13:
        this.C = r1;
    L15:
        if (TextUtils.isEmpty(this.C) == false) goto L18;
        Log.e("Lighten:", "can't infer callerId load context, please set it by callerId()");
        return;
    L18:
        return;
    L5:
        if ((r0 instanceof Activity) == false) goto L7;
        r1 = ((Activity) r0).getClass().getSimpleName();
        goto L9
    }

    private void R() {
        if (this != P) goto L6;
        this.f14063c = q.c().c().getApplicationContext();
    L6:
        if (this.f14063c == null) goto L8;
        return;
    L8:
        Object r0 = this.F;
        if ((r0 instanceof View) == false) goto L16;
        Context r1 = ((View) r0).getContext();
        this.f14063c = r1;
        if ((r1 instanceof Activity) == false) goto L14;
        return;
    L14:
        if ((r1 instanceof ContextWrapper) == false) goto L25;
    L15:
        this.f14063c = ((ContextWrapper) r1).getBaseContext();
    L25:
        if (this.f14063c != null) goto L28;
        Log.e("Lighten:", "inferContext: needs context for loading image, use with(context)");
        this.f14063c = q.c().c();
        return;
    L28:
        return;
    L16:
        ImageView r2 = this.G;
        if (r2 == null) goto L25;
        r1 = r2.getContext();
        this.f14063c = r1;
        if ((r1 instanceof Activity) == false) goto L22;
        return;
    L22:
        if ((r1 instanceof ContextWrapper) == false) goto L25;
        goto L15
    }

    private boolean Y() {
        if (this.f14061a != null) goto L10;
        d.b.k.a.w.a r1 = this.M;
        if (r1 != null) goto L7;
    L8:
        Log.e("Lighten:", "uri & urlModel are empty");
        return true;
    L7:
        if (r1.b() == true) goto L8;
        return false;
    L10:
        return false;
    }

    private void b0() {
        if (this.v != null) goto L6;
        this.v = q.c().b();
    L6:
        if (this.f14067g != (-1)) goto L9;
        this.f14067g = q.c().l();
        return;
    }

    private void f() {
        if (this.f14062b != null) goto L5;
        return;
    L5:
        if (this.M == null) goto L7;
        return;
    L7:
        if (this.f14061a == null) goto L10;
        return;
    L10:
        if (q.c().d() != null) goto L12;
        return;
    L12:
        if (q.c().d().a() == null) goto L20;
        this.M = q.c().d().a().a(this.f14062b, this);
        return;
    }

    public d.b.k.a.y.g A() {
        return this.I;
    }

    public d.b.k.a.y.i B() {
        return this.f14060J;
    }

    public int C() {
        return this.m;
    }

    public Drawable D() {
        return this.o;
    }

    public u E() {
        return this.p;
    }

    public int F() {
        return this.f14067g;
    }

    public p G() {
        return this.B;
    }

    public int H() {
        return this.f14072l;
    }

    public int I() {
        return this.f14071k;
    }

    public int J() {
        return this.t;
    }

    public u K() {
        return this.u;
    }

    public v L() {
        return this.A;
    }

    @NonNull
    public Uri M() {
        return this.f14061a;
    }

    public d.b.k.a.w.a N() {
        return this.M;
    }

    public k O() {
        return this.F;
    }

    public int P() {
        return this.f14069i;
    }

    public t S(ImageView r1) {
        this.G = r1;
        return this;
    }

    public boolean T() {
        return this.K;
    }

    public boolean U() {
        return this.f14064d;
    }

    public boolean V() {
        return this.f14065e;
    }

    public boolean W() {
        return this.L;
    }

    public boolean X() {
        return this.f14066f;
    }

    public boolean Z() {
        return this.f14068h;
    }

    public t a(u r1) {
        this.w = r1;
        return this;
    }

    public t a0(int r1, int r2) {
        this.f14069i = r1;
        this.f14070j = r2;
        return this;
    }

    public t b(boolean r1) {
        this.f14064d = r1;
        return this;
    }

    public s c() {
        f();
        if (Y() == false) goto L6;
        return null;
    L6:
        b0();
        R();
        Q();
        Log.d("Lighten:", "callerId: " + this.C);
        return new s(this);
    }

    public t c0(Uri r1) {
        this.f14061a = r1;
        return this;
    }

    public t d(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L5;
        this.C = r2;
    L5:
        return this;
    }

    public t e(@Nullable e r1) {
        this.x = r1;
        return this;
    }

    public void g() {
        if (this.F == null) goto L5;
    L9:
        q.a(c());
        return;
    L5:
        if (this.G != null) goto L9;
        throw new IllegalArgumentException("Lighten:needs SmartImageView to display, use with(view)");
    }

    public t h(boolean r1) {
        this.K = r1;
        if (r1 == false) goto L5;
        this.f14067g = 1;
    L5:
        return this;
    }

    public u i() {
        return this.w;
    }

    public int j() {
        return this.N;
    }

    public Drawable k() {
        return this.s;
    }

    public ImageView l() {
        return this.G;
    }

    public Bitmap.Config m() {
        return this.v;
    }

    public b n() {
        return this.y;
    }

    public d o() {
        return this.E;
    }

    public Executor p() {
        return this.D;
    }

    public String q() {
        return this.C;
    }

    public e r() {
        return this.x;
    }

    public Context s() {
        return this.f14063c;
    }

    public f t() {
        return this.z;
    }

    public int u() {
        return this.n;
    }

    public int v() {
        return this.q;
    }

    public u w() {
        return this.r;
    }

    public d.b.k.a.y.c x() {
        return this.O;
    }

    public int y() {
        return this.f14070j;
    }

    public d.b.k.a.y.f z() {
        return this.H;
    }
}
