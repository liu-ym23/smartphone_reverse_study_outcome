package d.c.f.f;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import d.c.f.e.f;
import d.c.f.e.s;
import d.c.f.e.t;

/* JADX INFO: loaded from: classes.dex */
public class c extends f implements s {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static boolean f15697k = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Drawable f15698i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private t f15699j;

    static {
    }

    public c(Drawable r1) {
        super(r1);
        this.f15698i = null;
    }

    @Override // d.c.f.e.f, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas r3) {
        if (f15697k == false) goto L5;
    L7:
        t r0 = this.f15699j;
        if (r0 == null) goto L10;
        r0.a();
    L10:
        super.draw(r3);
        Drawable r1 = this.f15698i;
        if (r1 == null) goto L14;
        r1.setBounds(getBounds());
        this.f15698i.draw(r3);
        return;
    L14:
        return;
    L5:
        if (isVisible() == true) goto L7;
    }

    @Override // d.c.f.e.f, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return -1;
    }

    @Override // d.c.f.e.f, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return -1;
    }

    @Override // d.c.f.e.s
    public void j(t r1) {
        this.f15699j = r1;
    }

    public void p(Drawable r1) {
        this.f15698i = r1;
        invalidateSelf();
    }

    @Override // d.c.f.e.f, android.graphics.drawable.Drawable
    public boolean setVisible(boolean r2, boolean r3) {
        t r0 = this.f15699j;
        if (r0 == null) goto L6;
        r0.b(r2);
    L6:
        return super.setVisible(r2, r3);
    }
}
