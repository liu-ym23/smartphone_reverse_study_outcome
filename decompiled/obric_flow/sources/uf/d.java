package uf;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.lynx.base.log.LynxLog;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends TextureView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Surface f22343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SurfaceTexture f22344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextureView.SurfaceTextureListener f22345c;
    public boolean d;
    public int e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f22346h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f22347i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f22348j;

    public d(Context r5) {
        super(r5, null, 0);
        this.g = 2;
        new Matrix();
        this.f22348j = false;
        setReuseSurfaceTexture(true);
        super.setSurfaceTextureListener(new c(0, this));
    }

    public final void a() {
        if (this.f22348j == true) goto L5;
        return;
    L5:
        if (this.f22344b != null) goto L7;
        return;
    L7:
        if (this.d == false) goto L26;
        Surface r5 = this.f22343a;
        if (r5 != null) goto L11;
        return;
    L11:
        if (r5.isValid() == true) goto L13;
        return;
    L13:
        if (this.f22344b == getSurfaceTexture()) goto L29;
        SurfaceTexture r10 = this.f22344b;
        if (r10 != null) goto L17;
        boolean r11 = true;
    L18:
        LynxLog.b(4, "TextureVideoView", "isSurfaceTextureReleased:" + r11);
        if (r11 == true) goto L30;
        setSurfaceTexture(this.f22344b);
        TextureView.SurfaceTextureListener r12 = this.f22345c;
        if (r12 == null) goto L31;
        r12.onSurfaceTextureAvailable(this.f22344b, 0, 0);
        return;
    L31:
        return;
    L30:
        return;
    L17:
        r11 = r10.isReleased();
        goto L18
    L29:
        return;
    }

    public Surface getSurface() {
        return this.f22343a;
    }

    @Override // android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        this.f22346h = 0;
        this.f22347i = 0;
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        int r14 = getWidth();
        int r15 = getHeight();
        if (this.e == r14) goto L5;
    L8:
        this.e = r14;
        this.f = r15;
        return;
    L5:
        if (this.f != r15) goto L8;
    }

    @Override // android.view.View
    public final void onMeasure(int r10, int r11) {
        int r5 = getSuggestedMinimumWidth();
        int r12 = getPaddingLeft() + r5;
        int r13 = getPaddingRight() + r12;
        int r14 = getSuggestedMinimumHeight();
        int r15 = getPaddingTop() + r14;
        int r16 = getPaddingBottom() + r15;
        int r17 = View.MeasureSpec.getMode(r10);
        int r18 = View.MeasureSpec.getSize(r10);
        int r19 = View.MeasureSpec.getMode(r11);
        int r20 = View.MeasureSpec.getSize(r11);
        if (r17 != 1073741824) goto L5;
        r13 = r18;
    L7:
        if (r19 != 1073741824) goto L9;
        r16 = r20;
    L12:
        if (this.f22346h == r13) goto L14;
    L15:
        this.f22346h = r13;
        this.f22347i = r16;
    L16:
        setMeasuredDimension(r13, r16);
        return;
    L14:
        if (this.f22347i == r16) goto L16;
    L9:
        if (r19 != Integer.MIN_VALUE) goto L12;
        r16 = Math.min(r16, r20);
        goto L12
    L5:
        if (r17 != Integer.MIN_VALUE) goto L7;
        r13 = Math.min(r13, r18);
        goto L7
    }

    @Override // android.view.TextureView, android.view.View
    public final void onVisibilityChanged(View r5, int r10) {
        super.onVisibilityChanged(r5, r10);     // Catch: Exception -> L4
    L6:
        if (r5 != this) goto L12;
        if (r10 != 0) goto L13;
        a();
        return;
    L13:
        return;
    L12:
        return;
    L4:
        e = move-exception;
        LynxLog.b(4, "TextureVideoView", "onVisibilityChanged encounter exception " + e.getMessage());
        goto L6
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r5) {
        super.onWindowVisibilityChanged(r5);
        if (getVisibility() != 0) goto L7;
        if (r5 != 0) goto L8;
        a();
        return;
    L8:
        return;
    }

    public void setReuseSurfaceTexture(boolean r5) {
        this.f22348j = r5;
        this.f22348j = true;
    }

    @Override // android.view.TextureView
    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener r5) {
        this.f22345c = r5;
    }

    public void setVideoViewLayout(int r5) {
        if (this.g == r5) goto L6;
        this.g = r5;
        requestLayout();
        return;
    }
}
