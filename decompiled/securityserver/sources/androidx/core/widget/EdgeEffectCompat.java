package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class EdgeEffectCompat {
    private EdgeEffect mEdgeEffect;

    @Deprecated
    public EdgeEffectCompat(Context r2) {
        this.mEdgeEffect = new EdgeEffect(r2);
    }

    @Deprecated
    public boolean draw(Canvas r1) {
        return this.mEdgeEffect.draw(r1);
    }

    @Deprecated
    public void finish() {
        this.mEdgeEffect.finish();
    }

    @Deprecated
    public boolean isFinished() {
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public boolean onAbsorb(int r1) {
        this.mEdgeEffect.onAbsorb(r1);
        return true;
    }

    @Deprecated
    public boolean onPull(float r1) {
        this.mEdgeEffect.onPull(r1);
        return true;
    }

    @Deprecated
    public boolean onRelease() {
        this.mEdgeEffect.onRelease();
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public void setSize(int r1, int r2) {
        this.mEdgeEffect.setSize(r1, r2);
    }

    @Deprecated
    public boolean onPull(float r1, float r2) {
        onPull(this.mEdgeEffect, r1, r2);
        return true;
    }

    public static void onPull(@NonNull EdgeEffect r0, float r1, float r2) {
        r0.onPull(r1, r2);
    }
}
