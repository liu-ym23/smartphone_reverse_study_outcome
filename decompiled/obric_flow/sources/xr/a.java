package xr;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.animation.AccelerateInterpolator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f23213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f23214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f23215c;
    public long d;
    public int e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f23216h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f23217i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f23218j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AccelerateInterpolator f23219k;

    public a(Drawable r5, Drawable r10) {
        Intrinsics.checkNotNullParameter(r5, "startDrawable");
        Intrinsics.checkNotNullParameter(r10, "endDrawable");
        this.f23213a = r5;
        this.f23214b = r10;
        this.f23218j = true;
        this.f23219k = new AccelerateInterpolator();
    }

    public final void a(Canvas r5, int r10) {
        Rect r11 = getBounds();
        Drawable r12 = this.f23213a;
        r12.setBounds(r11);
        Rect r13 = getBounds();
        Drawable r14 = this.f23214b;
        r14.setBounds(r13);
        boolean r15 = this.f23218j;
        if (r15 == false) goto L5;
        r12.setAlpha(255 - r10);
    L5:
        r12.draw(r5);
        if (r15 == false) goto L8;
        r12.setAlpha(255);
    L8:
        if (r10 <= 0) goto L11;
        r14.setAlpha(r10);
        r14.draw(r5);
        r14.setAlpha(255);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        int r5 = this.f23215c;
        if (r5 == 1) goto L10;
        if (r5 != 2) goto L11;
        long r11 = SystemClock.uptimeMillis() - this.d;
        int r12 = this.e;
        if (r11 < r12) goto L9;
        this.f23216h = this.g;
        this.f23215c = 0;
        goto L11
    L9:
        float r13 = this.f23219k.getInterpolation(r11 / r12);
        int r14 = this.f;
        this.f23216h = r14 + ((int) ((this.g - r14) * r13));
    L11:
        int r15 = this.f23216h;
        if (this.f23215c != 0) goto L20;
        if (r15 != 0) goto L15;
        Rect r16 = getBounds();
        Drawable r17 = this.f23213a;
        r17.setBounds(r16);
        r17.draw(r10);
        return;
    L15:
        if (r15 == 255) goto L17;
        a(r10, r15);
        return;
    L17:
        Rect r18 = getBounds();
        Drawable r19 = this.f23214b;
        r19.setBounds(r18);
        r19.draw(r10);
        return;
    L20:
        a(r10, r15);
        if (this.f23215c != 2) goto L26;
        invalidateSelf();
        return;
    L26:
        return;
    L10:
        this.d = SystemClock.uptimeMillis();
        this.f23215c = 2;
        goto L11
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return Math.max(this.f23213a.getIntrinsicHeight(), this.f23214b.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.max(this.f23213a.getIntrinsicWidth(), this.f23214b.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r5) {
        this.f23213a.setAlpha(r5);
        this.f23214b.setAlpha(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r5) {
        this.f23213a.setColorFilter(r5);
        this.f23214b.setColorFilter(r5);
    }
}
