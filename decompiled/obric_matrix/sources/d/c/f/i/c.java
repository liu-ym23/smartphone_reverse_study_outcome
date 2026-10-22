package d.c.f.i;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import d.c.c.b.h;
import d.c.f.h.b;

/* JADX INFO: loaded from: classes.dex */
public class c<DH extends d.c.f.h.b> extends ImageView {
    private static boolean m = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d.c.f.i.a.C0423a f15727f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f15728g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private b<DH> f15729h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f15730i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f15731j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private d.c.i.a f15732k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private e f15733l;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f15734f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f15735g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ c f15736h;

        a(c r1, View r2, int r3) {
            this.f15736h = r1;
            this.f15734f = r2;
            this.f15735g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a(this.f15736h, this.f15734f, this.f15735g);
            c.b(this.f15736h);
        }
    }

    static {
    }

    static /* synthetic */ void a(c r0, View r1, int r2) {
        super.onVisibilityChanged(r1, r2);
    }

    static /* synthetic */ void b(c r0) {
        r0.h();
    }

    private void g(Context r4) {
    L32:
        th = move-exception;
        if (d.c.i.r.b.d() == false) goto L36;
        d.c.i.r.b.b();
    L36:
        throw th;
    L3:
        if (d.c.i.r.b.d() == false) goto L6;
        d.c.i.r.b.a("DraweeView#init");     // Catch: Throwable -> L32
    L6:
        if (this.f15730i == true) goto L8;
        boolean r0 = true;
        this.f15730i = true;     // Catch: Throwable -> L32
        this.f15729h = b.e(null, r4);     // Catch: Throwable -> L32
        this.f15732k = new d.c.i.a(this);     // Catch: Throwable -> L32
        if (Build.VERSION.SDK_INT < 21) goto L22;
        ColorStateList r1 = getImageTintList();     // Catch: Throwable -> L32
        if (r1 == null) goto L17;
        setColorFilter(r1.getDefaultColor());     // Catch: Throwable -> L32
        goto L22
    L17:
        if (d.c.i.r.b.d() == false) goto L40;
        d.c.i.r.b.b();
        return;
    L40:
        return;
    L22:
        if (m == true) goto L24;
    L26:
        r0 = false;
    L27:
        this.f15731j = r0;     // Catch: Throwable -> L32
        if (d.c.i.r.b.d() == false) goto L41;
        d.c.i.r.b.b();
        return;
    L41:
        return;
    L24:
        if (r4.getApplicationInfo().targetSdkVersion < 24) goto L26;
    L8:
        if (d.c.i.r.b.d() == false) goto L39;
        d.c.i.r.b.b();
        return;
    }

    private void h() {
        if (this.f15731j == false) goto L12;
        Drawable r0 = getDrawable();
        if (r0 != null) goto L7;
        return;
    L7:
        if (getVisibility() != 0) goto L9;
        boolean r2 = true;
    L10:
        r0.setVisible(r2, false);
        return;
    L9:
        r2 = false;
        goto L10
    }

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean r0) {
        m = r0;
    }

    public void c() {
        e r0 = this.f15733l;
        if (r0 == null) goto L6;
        this.f15732k.m(r0);
        this.f15733l = null;
        return;
    }

    public void d(d.c.f.h.a r2) {
        if ((r2 instanceof d.c.f.c.a) == false) goto L8;
        d.c.i.q.b r3 = ((d.c.f.c.a) r2).w();
        if (r3 == null) goto L9;
        r3.F(this.f15732k);
        return;
    L9:
        return;
    }

    protected void e() {
        this.f15729h.k();
    }

    protected void f() {
        this.f15729h.l();
    }

    public float getAspectRatio() {
        return this.f15728g;
    }

    public d.c.f.h.a getController() {
        return this.f15729h.g();
    }

    public DH getHierarchy() {
        return (DH) this.f15729h.h();
    }

    public Drawable getTopLevelDrawable() {
        return this.f15729h.i();
    }

    protected void i() {
        e();
    }

    protected void j() {
        f();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
        i();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
        this.f15732k.b();
        j();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        h();
        i();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int r5, int r6) {
        d.c.f.i.a.C0423a r0 = this.f15727f;
        r0.f15719a = r5;
        r0.f15720b = r6;
        d.c.f.i.a.b(r0, this.f15728g, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        d.c.f.i.a.C0423a r7 = this.f15727f;
        super.onMeasure(r7.f15719a, r7.f15720b);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        h();
        j();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r2) {
        if (this.f15729h.m(r2) == false) goto L7;
        return true;
    L7:
        return super.onTouchEvent(r2);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View r3, int r4) {
        h.g().execute(new a(this, r3, r4));
    }

    public void setAspectRatio(float r2) {
        if (r2 != this.f15728g) goto L5;
        return;
    L5:
        this.f15728g = r2;
        requestLayout();
    }

    public void setController(d.c.f.h.a r2) {
        c();
        d(r2);
        this.f15729h.o(r2);
        super.setImageDrawable(this.f15729h.i());
    }

    public void setHierarchy(DH r2) {
        this.f15729h.p(r2);
        super.setImageDrawable(this.f15729h.i());
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap r3) {
        g(getContext());
        c();
        this.f15729h.o(null);
        super.setImageBitmap(r3);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable r3) {
        g(getContext());
        c();
        this.f15729h.o(null);
        super.setImageDrawable(r3);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int r3) {
        g(getContext());
        c();
        this.f15729h.o(null);
        super.setImageResource(r3);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri r3) {
        g(getContext());
        c();
        this.f15729h.o(null);
        super.setImageURI(r3);
    }

    public void setLazySizeAttach(e r2) {
        if (this.f15733l == null) goto L5;
        c();
    L5:
        this.f15733l = r2;
        this.f15732k.e(r2);
    }

    public void setLegacyVisibilityHandlingEnabled(boolean r1) {
        this.f15731j = r1;
    }

    @Override // android.view.View
    public String toString() {
        d.c.c.d.h.b r0 = d.c.c.d.h.d(this);
        b<DH> r2 = this.f15729h;
        if (r2 == null) goto L5;
        String r3 = r2.toString();
    L6:
        r0.b("holder", r3);
        return r0.toString();
    L5:
        r3 = "<no holder set>";
        goto L6
    }
}
