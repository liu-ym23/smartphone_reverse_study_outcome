package com.obric.oui.oswitch;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import com.android.settings.search.IndexDatabaseHelper;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomTransitionDrawable.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\bH\u0002J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\bH\u0017J\u0006\u0010\u001b\u001a\u00020\u0006J\u0006\u0010\u001c\u001a\u00020\u0013J\u000e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\bJ\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\bH\u0016J\u0012\u0010 \u001a\u00020\u00132\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u000e\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u0006J\u000e\u0010%\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010&\u001a\u00020\u0013J\u000e\u0010'\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/obric/oui/oswitch/CustomTransitionDrawable;", "Landroid/graphics/drawable/Drawable;", "startDrawable", "endDrawable", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V", "crossFadeEnabled", "", "currentAlpha", "", "currentState", "duration", "fromAlpha", "interpolator", "Landroid/view/animation/Interpolator;", "isReverse", "startTime", "", "toAlpha", "draw", "", "canvas", "Landroid/graphics/Canvas;", "drawWithAlpha", "alpha", "getIntrinsicHeight", "getIntrinsicWidth", "getOpacity", "isCrossFadeEnabled", "resetTransition", "reverseTransition", "durationMillis", "setAlpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setCrossFadeEnabled", IndexDatabaseHelper.IndexColumns.ENABLED, "setInterpolator", "showSecondLayer", "startTransition", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomTransitionDrawable extends Drawable {
    public static final Companion Companion = null;
    private static final int STATE_IDLE = 0;
    private static final int STATE_RUNNING = 2;
    private static final int STATE_STARTING = 1;
    private boolean crossFadeEnabled;
    private int currentAlpha;
    private int currentState;
    private int duration;
    private final Drawable endDrawable;
    private int fromAlpha;
    private Interpolator interpolator;
    private boolean isReverse;
    private final Drawable startDrawable;
    private long startTime;
    private int toAlpha;

    /* JADX INFO: compiled from: CustomTransitionDrawable.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/oswitch/CustomTransitionDrawable$Companion;", "", "()V", "STATE_IDLE", "", "STATE_RUNNING", "STATE_STARTING", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public int getOpacity() {
        return -3;
    }

    public CustomTransitionDrawable(Drawable r2, Drawable r3) {
        Intrinsics.checkNotNullParameter(r2, "startDrawable");
        Intrinsics.checkNotNullParameter(r3, "endDrawable");
        this.startDrawable = r2;
        this.endDrawable = r3;
        this.crossFadeEnabled = true;
        this.interpolator = new AccelerateInterpolator();
    }

    public final void setInterpolator(Interpolator r2) {
        Intrinsics.checkNotNullParameter(r2, "interpolator");
        this.interpolator = r2;
    }

    public final void setCrossFadeEnabled(boolean r1) {
        this.crossFadeEnabled = r1;
    }

    public final boolean isCrossFadeEnabled() {
        return this.crossFadeEnabled;
    }

    public final void startTransition(int r3) {
        this.fromAlpha = 0;
        this.toAlpha = 255;
        this.currentAlpha = 0;
        this.duration = r3;
        this.isReverse = false;
        this.currentState = 1;
        invalidateSelf();
    }

    public final void reverseTransition(int r13) {
        long r0 = SystemClock.uptimeMillis();
        int r4 = 0;
        if (this.currentState != 2) goto L17;
        long r2 = this.startTime;
        long r7 = r0 - r2;
        int r9 = this.duration;
        if (r7 > r9) goto L17;
        boolean r14 = !this.isReverse;
        this.isReverse = r14;
        this.fromAlpha = this.currentAlpha;
        if (r14 == true) goto L11;
        r4 = 255;
    L11:
        this.toAlpha = r4;
        long r1 = r0 - r2;
        if (r14 == false) goto L14;
        int r15 = (int) r1;
    L15:
        this.duration = r15;
        this.currentState = 1;
        invalidateSelf();
        return;
    L14:
        r15 = r9 - ((int) r1);
    L17:
        this.fromAlpha = 255;
        this.toAlpha = 0;
        this.currentAlpha = 255;
        this.duration = r13;
        this.isReverse = true;
        this.currentState = 1;
        invalidateSelf();
    }

    public final void resetTransition() {
        this.currentAlpha = 0;
        this.currentState = 0;
        invalidateSelf();
    }

    public final void showSecondLayer() {
        this.currentAlpha = 255;
        this.currentState = 0;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        int r0 = this.currentState;
        if (r0 == 1) goto L10;
        if (r0 != 2) goto L11;
        long r1 = SystemClock.uptimeMillis() - this.startTime;
        int r3 = this.duration;
        if (r1 < r3) goto L9;
        this.currentAlpha = this.toAlpha;
        this.currentState = 0;
        goto L11
    L9:
        float r2 = this.interpolator.getInterpolation(r1 / r3);
        int r4 = this.fromAlpha;
        this.currentAlpha = r4 + ((int) ((this.toAlpha - r4) * r2));
    L11:
        int r5 = this.currentAlpha;
        if (this.currentState != 0) goto L20;
        if (r5 != 0) goto L15;
        this.startDrawable.setBounds(getBounds());
        this.startDrawable.draw(r7);
        return;
    L15:
        if (r5 == 255) goto L17;
        drawWithAlpha(r7, r5);
        return;
    L17:
        this.endDrawable.setBounds(getBounds());
        this.endDrawable.draw(r7);
        return;
    L20:
        drawWithAlpha(r7, r5);
        if (this.currentState != 2) goto L26;
        invalidateSelf();
        return;
    L26:
        return;
    L10:
        this.startTime = SystemClock.uptimeMillis();
        this.currentState = 2;
        goto L11
    }

    private final void drawWithAlpha(Canvas r3, int r4) {
        this.startDrawable.setBounds(getBounds());
        this.endDrawable.setBounds(getBounds());
        if (this.crossFadeEnabled == false) goto L5;
        this.startDrawable.setAlpha(255 - r4);
    L5:
        this.startDrawable.draw(r3);
        if (this.crossFadeEnabled == false) goto L8;
        this.startDrawable.setAlpha(255);
    L8:
        if (r4 <= 0) goto L11;
        this.endDrawable.setAlpha(r4);
        this.endDrawable.draw(r3);
        this.endDrawable.setAlpha(255);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        this.startDrawable.setAlpha(r2);
        this.endDrawable.setAlpha(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        this.startDrawable.setColorFilter(r2);
        this.endDrawable.setColorFilter(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.max(this.startDrawable.getIntrinsicWidth(), this.endDrawable.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return Math.max(this.startDrawable.getIntrinsicHeight(), this.endDrawable.getIntrinsicHeight());
    }
}
