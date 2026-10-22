package it.sephiroth.android.library.imagezoom;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes2.dex */
public class ImageViewTouch extends it.sephiroth.android.library.imagezoom.a {
    protected ScaleGestureDetector D;
    protected GestureDetector E;
    protected float F;
    protected int G;
    protected GestureDetector.OnGestureListener H;
    protected ScaleGestureDetector.OnScaleGestureListener I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    protected boolean f17601J;
    protected boolean K;
    protected boolean L;
    private b M;
    private c N;

    public class a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageViewTouch f17602a;

        public a(ImageViewTouch r1) {
            this.f17602a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent r6) {
            Log.i("ImageViewTouchBase", "onDoubleTap. double tap enabled? " + this.f17602a.f17601J);
            ImageViewTouch r0 = this.f17602a;
            if (r0.f17601J == false) goto L6;
            r0.f17611l = true;
            float r1 = r0.getScale();
            ImageViewTouch r2 = this.f17602a;
            this.f17602a.F(Math.min(this.f17602a.getMaxScale(), Math.max(r2.I(r1, r2.getMaxScale()), this.f17602a.getMinScale())), r6.getX(), r6.getY(), 200.0f);
            this.f17602a.invalidate();
        L6:
            if (ImageViewTouch.H(this.f17602a) == null) goto L9;
            ImageViewTouch.H(this.f17602a).onDoubleTap();
        L9:
            return super.onDoubleTap(r6);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent r1) {
            return this.f17602a.J(r1);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent r4, MotionEvent r5, float r6, float r7) {
            if (this.f17602a.L == true) goto L6;
            return false;
        L6:
            if (r4.getPointerCount() <= 1) goto L8;
        L18:
            return false;
        L8:
            if (r5.getPointerCount() > 1) goto L18;
            if (this.f17602a.D.isInProgress() == false) goto L14;
            return false;
        L14:
            if (this.f17602a.getScale() != 1.0f) goto L17;
            return false;
        L17:
            return this.f17602a.K(r4, r5, r6, r7);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent r2) {
            if (this.f17602a.isLongClickable() == true) goto L5;
            return;
        L5:
            if (this.f17602a.D.isInProgress() == true) goto L9;
            this.f17602a.setPressed(true);
            this.f17602a.performLongClick();
            return;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent r4, MotionEvent r5, float r6, float r7) {
            if (this.f17602a.L == true) goto L5;
            return false;
        L5:
            if (r4 == null) goto L18;
            if (r5 == null) goto L18;
            if (r4.getPointerCount() > 1) goto L18;
            if (r5.getPointerCount() > 1) goto L18;
            if (this.f17602a.D.isInProgress() == false) goto L17;
            return false;
        L17:
            return this.f17602a.L(r4, r5, r6, r7);
        L18:
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent r2) {
            if (ImageViewTouch.G(this.f17602a) == null) goto L6;
            ImageViewTouch.G(this.f17602a).a();
        L6:
            return this.f17602a.M(r2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent r1) {
            return this.f17602a.N(r1);
        }
    }

    public interface b {
        void onDoubleTap();
    }

    public interface c {
        void a();
    }

    public class d extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected boolean f17603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ImageViewTouch f17604b;

        public d(ImageViewTouch r1) {
            this.f17604b = r1;
            this.f17603a = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector r7) {
            float r0 = r7.getCurrentSpan() - r7.getPreviousSpan();
            float r1 = this.f17604b.getScale() * r7.getScaleFactor();
            ImageViewTouch r2 = this.f17604b;
            if (r2.K == false) goto L12;
            boolean r3 = this.f17603a;
            if (r3 == true) goto L7;
        L10:
            if (r3 == true) goto L12;
            this.f17603a = true;
            goto L12
        L7:
            if (r0 == 0.0f) goto L10;
            r2.f17611l = true;
            float r4 = Math.min(r2.getMaxScale(), Math.max(r1, this.f17604b.getMinScale() - 0.1f));
            this.f17604b.E(r4, r7.getFocusX(), r7.getFocusY());
            ImageViewTouch r6 = this.f17604b;
            r6.G = 1;
            r6.invalidate();
            return true;
        L12:
            return true;
        }
    }

    public ImageViewTouch(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ImageViewTouch(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.f17601J = true;
        this.K = true;
        this.L = true;
    }

    static /* synthetic */ c G(ImageViewTouch r0) {
        return r0.N;
    }

    static /* synthetic */ b H(ImageViewTouch r0) {
        return r0.M;
    }

    protected float I(float r3, float r4) {
        if (this.G != 1) goto L10;
        float r0 = this.F;
        if (((2.0f * r0) + r3) <= r4) goto L7;
        this.G = -1;
        return r4;
    L7:
        return r3 + r0;
    L10:
        this.G = 1;
        return 1.0f;
    }

    public boolean J(MotionEvent r1) {
        return true;
    }

    public boolean K(MotionEvent r3, MotionEvent r4, float r5, float r6) {
        float r0 = r4.getX() - r3.getX();
        float r7 = r4.getY() - r3.getY();
        if (Math.abs(r5) <= 800.0f) goto L5;
    L9:
        this.f17611l = true;
        y(r0 / 2.0f, r7 / 2.0f, 300.0d);
        invalidate();
        return true;
    L5:
        if (Math.abs(r6) > 800.0f) goto L9;
        return false;
    }

    public boolean L(MotionEvent r1, MotionEvent r2, float r3, float r4) {
        if (getScale() != 1.0f) goto L6;
        return false;
    L6:
        this.f17611l = true;
        x(-r3, -r4);
        invalidate();
        return true;
    }

    public boolean M(MotionEvent r1) {
        return true;
    }

    public boolean N(MotionEvent r1) {
        return true;
    }

    public boolean O(MotionEvent r2) {
        if (getScale() >= getMinScale()) goto L7;
        D(getMinScale(), 50.0f);
        return true;
    L7:
        return true;
    }

    @Override // it.sephiroth.android.library.imagezoom.a
    protected void a(Drawable r1, Matrix r2, float r3, float r4) {
        super.a(r1, r2, r3, r4);
        this.F = getMaxScale() / 3.0f;
    }

    public boolean getDoubleTapEnabled() {
        return this.f17601J;
    }

    protected GestureDetector.OnGestureListener getGestureListener() {
        return new a(this);
    }

    protected ScaleGestureDetector.OnScaleGestureListener getScaleListener() {
        return new d(this);
    }

    @Override // it.sephiroth.android.library.imagezoom.a
    protected void n(Context r3, AttributeSet r4, int r5) {
        super.n(r3, r4, r5);
        ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.H = getGestureListener();
        this.I = getScaleListener();
        this.D = new ScaleGestureDetector(getContext(), this.I);
        this.E = new GestureDetector(getContext(), this.H, null, true);
        this.G = 1;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r3) {
        this.D.onTouchEvent(r3);
        if (this.D.isInProgress() == true) goto L6;
        this.E.onTouchEvent(r3);
    L6:
        if ((r3.getAction() & 255) == 1) goto L9;
        return true;
    L9:
        return O(r3);
    }

    @Override // it.sephiroth.android.library.imagezoom.a
    protected void s(float r2) {
        if (r2 >= getMinScale()) goto L6;
        D(getMinScale(), 50.0f);
        return;
    }

    public void setDoubleTapEnabled(boolean r1) {
        this.f17601J = r1;
    }

    public void setDoubleTapListener(b r1) {
        this.M = r1;
    }

    public void setScaleEnabled(boolean r1) {
        this.K = r1;
    }

    public void setScrollEnabled(boolean r1) {
        this.L = r1;
    }

    public void setSingleTapListener(c r1) {
        this.N = r1;
    }
}
