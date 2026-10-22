package d.c.f.e;

import android.graphics.Canvas;
import android.graphics.drawable.NinePatchDrawable;

/* JADX INFO: loaded from: classes.dex */
public class n extends m {
    public n(NinePatchDrawable r1) {
        super(r1);
    }

    @Override // d.c.f.e.m, android.graphics.drawable.Drawable
    public void draw(Canvas r2) {
        if (d.c.i.r.b.d() == false) goto L6;
        d.c.i.r.b.a("RoundedNinePatchDrawable#draw");
    L6:
        if (d() == true) goto L11;
        super.draw(r2);
        if (d.c.i.r.b.d() == false) goto L15;
        d.c.i.r.b.b();
        return;
    L15:
        return;
    L11:
        g();
        f();
        r2.clipPath(this.f15655j);
        super.draw(r2);
        if (d.c.i.r.b.d() == false) goto L16;
        d.c.i.r.b.b();
        return;
    }
}
