package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GifDrawable extends Drawable implements GifFrameLoader.FrameCallback, Animatable, Animatable2Compat {
    private static final int GRAVITY = 119;
    public static final int LOOP_FOREVER = -1;
    public static final int LOOP_INTRINSIC = 0;
    private List<Animatable2Compat.AnimationCallback> animationCallbacks;
    private boolean applyGravity;
    private Rect destRect;
    private boolean isRecycled;
    private boolean isRunning;
    private boolean isStarted;
    private boolean isVisible;
    private int loopCount;
    private int maxLoopCount;
    private Paint paint;
    private final GifState state;

    static final class GifState extends Drawable.ConstantState {
        final GifFrameLoader frameLoader;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        GifState(GifFrameLoader r1) {
            this.frameLoader = r1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r1) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new GifDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Deprecated
    public GifDrawable(Context r8, GifDecoder r9, BitmapPool r10, Transformation<Bitmap> r11, int r12, int r13, Bitmap r14) {
        this(r8, r9, r11, r12, r13, r14);
    }

    public GifDrawable(Context r10, GifDecoder r11, Transformation<Bitmap> r12, int r13, int r14, Bitmap r15) {
        this(new GifState(new GifFrameLoader(Glide.get(r10), r11, r13, r14, r12, r15)));
    }

    GifDrawable(GifState r2) {
        this.isVisible = true;
        this.maxLoopCount = -1;
        this.state = (GifState) Preconditions.checkNotNull(r2);
    }

    GifDrawable(GifFrameLoader r2, Paint r3) {
        this(new GifState(r2));
        this.paint = r3;
    }

    public int getSize() {
        return this.state.frameLoader.getSize();
    }

    public Bitmap getFirstFrame() {
        return this.state.frameLoader.getFirstFrame();
    }

    public void setFrameTransformation(Transformation<Bitmap> r1, Bitmap r2) {
        this.state.frameLoader.setFrameTransformation(r1, r2);
    }

    public Transformation<Bitmap> getFrameTransformation() {
        return this.state.frameLoader.getFrameTransformation();
    }

    public ByteBuffer getBuffer() {
        return this.state.frameLoader.getBuffer();
    }

    public int getFrameCount() {
        return this.state.frameLoader.getFrameCount();
    }

    public int getFrameIndex() {
        return this.state.frameLoader.getCurrentIndex();
    }

    private void resetLoopCount() {
        this.loopCount = 0;
    }

    public void startFromFirstFrame() {
        Preconditions.checkArgument(!this.isRunning, "You cannot restart a currently running animation.");
        this.state.frameLoader.setNextStartFromFirstFrame();
        start();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.isStarted = true;
        resetLoopCount();
        if (this.isVisible == false) goto L6;
        startRunning();
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.isStarted = false;
        stopRunning();
    }

    private void startRunning() {
        Preconditions.checkArgument(!this.isRecycled, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.state.frameLoader.getFrameCount() != 1) goto L6;
        invalidateSelf();
        return;
    L6:
        if (this.isRunning == true) goto L10;
        this.isRunning = true;
        this.state.frameLoader.subscribe(this);
        invalidateSelf();
        return;
    }

    private void stopRunning() {
        this.isRunning = false;
        this.state.frameLoader.unsubscribe(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r3, boolean r4) {
        Preconditions.checkArgument(!this.isRecycled, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.isVisible = r3;
        if (r3 == true) goto L6;
        stopRunning();
    L9:
        return super.setVisible(r3, r4);
    L6:
        if (this.isStarted == false) goto L9;
        startRunning();
        goto L9
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.state.frameLoader.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.state.frameLoader.getHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.isRunning;
    }

    void setIsRunning(boolean r1) {
        this.isRunning = r1;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r1) {
        super.onBoundsChange(r1);
        this.applyGravity = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r6) {
        if (this.isRecycled == false) goto L6;
        return;
    L6:
        if (this.applyGravity == false) goto L8;
        Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), getDestRect());
        this.applyGravity = false;
    L8:
        r6.drawBitmap(this.state.frameLoader.getCurrentFrame(), null, getDestRect(), getPaint());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r1) {
        getPaint().setAlpha(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
        getPaint().setColorFilter(r1);
    }

    private Rect getDestRect() {
        if (this.destRect != null) goto L6;
        this.destRect = new Rect();
    L6:
        return this.destRect;
    }

    private Paint getPaint() {
        if (this.paint != null) goto L6;
        this.paint = new Paint(2);
    L6:
        return this.paint;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Drawable.Callback findCallback() {
        Drawable.Callback r1 = getCallback();
    L4:
        if ((r1 instanceof Drawable) == false) goto L6;
        r1 = ((Drawable) r1).getCallback();
        goto L4
    L6:
        return r1;
    }

    @Override // com.bumptech.glide.load.resource.gif.GifFrameLoader.FrameCallback
    public void onFrameReady() {
        if (findCallback() != null) goto L6;
        stop();
        invalidateSelf();
        return;
    L6:
        invalidateSelf();
        if (getFrameIndex() != (getFrameCount() - 1)) goto L9;
        this.loopCount++;
    L9:
        int r0 = this.maxLoopCount;
        if (r0 != (-1)) goto L12;
        return;
    L12:
        if (this.loopCount < r0) goto L16;
        notifyAnimationEndToListeners();
        stop();
        return;
    }

    private void notifyAnimationEndToListeners() {
        List<Animatable2Compat.AnimationCallback> r0 = this.animationCallbacks;
        if (r0 == null) goto L7;
        int r1 = r0.size();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L9;
        this.animationCallbacks.get(r2).onAnimationEnd(this);
        r2 = r2 + 1;
        goto L5
    L9:
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.state;
    }

    public void recycle() {
        this.isRecycled = true;
        this.state.frameLoader.clear();
    }

    boolean isRecycled() {
        return this.isRecycled;
    }

    public void setLoopCount(int r2) {
        int r0 = -1;
        if (r2 > 0) goto L9;
        if (r2 == (-1)) goto L9;
        if (r2 == 0) goto L9;
        throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
    L9:
        if (r2 != 0) goto L15;
        int r3 = this.state.frameLoader.getLoopCount();
        if (r3 == 0) goto L14;
        r0 = r3;
    L14:
        this.maxLoopCount = r0;
        return;
    L15:
        this.maxLoopCount = r2;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(Animatable2Compat.AnimationCallback r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (this.animationCallbacks != null) goto L7;
        this.animationCallbacks = new ArrayList();
    L7:
        this.animationCallbacks.add(r2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback r1) {
        List<Animatable2Compat.AnimationCallback> r0 = this.animationCallbacks;
        if (r0 == null) goto L8;
        if (r1 != null) goto L7;
        return false;
    L7:
        return r0.remove(r1);
    L8:
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        List<Animatable2Compat.AnimationCallback> r0 = this.animationCallbacks;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }
}
