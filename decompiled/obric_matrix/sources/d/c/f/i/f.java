package d.c.f.i;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import d.c.c.b.h;
import d.c.c.d.l;

/* JADX INFO: loaded from: classes.dex */
public class f extends d {
    private static l<? extends d.c.f.c.b> o = null;
    private static boolean p = false;
    private static boolean q = true;
    private d.c.f.c.b n;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f15740f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f15741g;

        a(f r1, boolean r2) {
            this.f15741g = r1;
            this.f15740f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.k(this.f15741g, this.f15740f);
            if (f.l() == false) goto L8;
            Drawable r2 = this.f15741g.getDrawable();
            if (r2 == null) goto L9;
            r2.setVisible(true, false);
            return;
        L9:
            return;
        }
    }

    static {
    }

    static /* synthetic */ void k(f r0, boolean r1) {
        super.onVisibilityAggregated(r1);
    }

    static /* synthetic */ boolean l() {
        return q;
    }

    public static void m(l<? extends d.c.f.c.b> r0) {
        o = r0;
    }

    protected d.c.f.c.b getControllerBuilder() {
        return this.n;
    }

    public Uri getImageUri() {
        d.c.f.h.a r1 = getController();
        if ((r1 instanceof d.c.f.c.a) == false) goto L8;
        d.c.i.q.b r2 = ((d.c.f.c.a) r1).w();
        if ((r2 instanceof d.c.i.q.b) == true) goto L7;
        return null;
    L7:
        return r2.v();
    L8:
        return null;
    }

    public void n(@DrawableRes int r1, Object r2) {
        o(d.c.c.k.f.c(r1), r2);
    }

    public void o(Uri r2, Object r3) {
        if (p == false) goto L6;
        if (r2 == null) goto L6;
        d.c.f.c.b r0 = o.get();
        r0.y(r3);
        r0.E(getController());
        setLazySizeAttach(new e(d.c.i.q.c.x(r2), r0, this));
        return;
    L6:
        d.c.f.c.b r1 = this.n;
        r1.y(r3);
        d.c.f.h.d r4 = r1.a(r2);
        r4.b(getController());
        setController(r4.build());
    }

    @Override // android.widget.ImageView, android.view.View
    public void onVisibilityAggregated(boolean r3) {
        h.g().execute(new a(this, r3));
    }

    public void p(String r1, Object r2) {
        if (r1 == null) goto L4;
        Uri r3 = Uri.parse(r1);
    L5:
        o(r3, r2);
        return;
    L4:
        r3 = null;
        goto L5
    }

    public void setActualImageResource(@DrawableRes int r2) {
        n(r2, null);
    }

    public void setImageRequest(d.c.i.q.b r2) {
        d.c.f.c.b r0 = this.n;
        r0.D(r2);
        r0.E(getController());
        setController(r0.c());
    }

    @Override // d.c.f.i.c, android.widget.ImageView
    public void setImageResource(int r1) {
        super.setImageResource(r1);
    }

    @Override // d.c.f.i.c, android.widget.ImageView
    public void setImageURI(Uri r2) {
        o(r2, null);
    }

    public void setImageURI(String r2) {
        p(r2, null);
    }
}
