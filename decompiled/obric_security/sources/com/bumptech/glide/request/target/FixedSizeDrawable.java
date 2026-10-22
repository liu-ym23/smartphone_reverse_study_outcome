package com.bumptech.glide.request.target;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class FixedSizeDrawable extends Drawable {
    private final RectF bounds;
    private final Matrix matrix;
    private boolean mutated;
    private State state;
    private Drawable wrapped;
    private final RectF wrappedRect;

    static final class State extends Drawable.ConstantState {
        final int height;
        final int width;
        private final Drawable.ConstantState wrapped;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        State(State r3) {
            this(r3.wrapped, r3.width, r3.height);
        }

        State(Drawable.ConstantState r1, int r2, int r3) {
            this.wrapped = r1;
            this.width = r2;
            this.height = r3;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new FixedSizeDrawable(this, this.wrapped.newDrawable());
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r3) {
            return new FixedSizeDrawable(this, this.wrapped.newDrawable(r3));
        }
    }

    public FixedSizeDrawable(Drawable r3, int r4, int r5) {
        this(new State(r3.getConstantState(), r4, r5), r3);
    }

    FixedSizeDrawable(State r3, Drawable r4) {
        this.state = (State) Preconditions.checkNotNull(r3);
        this.wrapped = (Drawable) Preconditions.checkNotNull(r4);
        r4.setBounds(0, 0, r4.getIntrinsicWidth(), r4.getIntrinsicHeight());
        this.matrix = new Matrix();
        this.wrappedRect = new RectF(0.0f, 0.0f, r4.getIntrinsicWidth(), r4.getIntrinsicHeight());
        this.bounds = new RectF();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int r2, int r3, int r4, int r5) {
        super.setBounds(r2, r3, r4, r5);
        this.bounds.set(r2, r3, r4, r5);
        updateMatrix();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect r2) {
        super.setBounds(r2);
        this.bounds.set(r2);
        updateMatrix();
    }

    private void updateMatrix() {
        this.matrix.setRectToRect(this.wrappedRect, this.bounds, Matrix.ScaleToFit.CENTER);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int r1) {
        this.wrapped.setChangingConfigurations(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.wrapped.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated
    public void setDither(boolean r1) {
        this.wrapped.setDither(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean r1) {
        this.wrapped.setFilterBitmap(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.Callback getCallback() {
        return this.wrapped.getCallback();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.wrapped.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int r1, PorterDuff.Mode r2) {
        this.wrapped.setColorFilter(r1, r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.wrapped.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.wrapped.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r1, boolean r2) {
        return this.wrapped.setVisible(r1, r2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.state.width;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.state.height;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.wrapped.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.wrapped.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect r1) {
        return this.wrapped.getPadding(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        this.wrapped.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable r1) {
        super.unscheduleSelf(r1);
        this.wrapped.unscheduleSelf(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable r1, long r2) {
        super.scheduleSelf(r1, r2);
        this.wrapped.scheduleSelf(r1, r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r2) {
        r2.save();
        r2.concat(this.matrix);
        this.wrapped.draw(r2);
        r2.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r1) {
        this.wrapped.setAlpha(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
        this.wrapped.setColorFilter(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.wrapped.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.mutated == false) goto L5;
    L7:
        return this;
    L5:
        if (super.mutate() != this) goto L7;
        this.wrapped = this.wrapped.mutate();
        this.state = new State(this.state);
        this.mutated = true;
        goto L7
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.state;
    }
}
