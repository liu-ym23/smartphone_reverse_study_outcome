package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.google.android.material.math.MathUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class CircularRevealHelper {
    public static final int BITMAP_SHADER = 0;
    public static final int CLIP_PATH = 1;
    private static final boolean DEBUG = false;
    public static final int REVEAL_ANIMATOR = 2;
    public static final int STRATEGY = 0;
    private boolean buildingCircularRevealCache;
    private Paint debugPaint;
    private final Delegate delegate;
    private boolean hasCircularRevealCache;

    @Nullable
    private Drawable overlayDrawable;

    @Nullable
    private CircularRevealWidget.RevealInfo revealInfo;

    @NonNull
    private final Paint revealPaint;

    @NonNull
    private final Path revealPath;

    @NonNull
    private final Paint scrimPaint;

    @NonNull
    private final View view;

    public interface Delegate {
        void actualDraw(Canvas r1);

        boolean actualIsOpaque();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Strategy {
    }

    static {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 21) goto L7;
        int r1 = 2;
    L5:
        STRATEGY = r1;
        return;
    L7:
        if (r0 < 18) goto L9;
        r1 = 1;
        goto L5
    L9:
        r1 = 0;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CircularRevealHelper(Delegate r3) {
        this.delegate = r3;
        View r4 = (View) r3;
        this.view = r4;
        r4.setWillNotDraw(false);
        this.revealPath = new Path();
        this.revealPaint = new Paint(7);
        Paint r5 = new Paint(1);
        this.scrimPaint = r5;
        r5.setColor(0);
    }

    private void drawDebugCircle(@NonNull Canvas r4, int r5, float r6) {
        this.debugPaint.setColor(r5);
        this.debugPaint.setStrokeWidth(r6);
        CircularRevealWidget.RevealInfo r7 = this.revealInfo;
        r4.drawCircle(r7.centerX, r7.centerY, r7.radius - (r6 / 2.0f), this.debugPaint);
    }

    private void drawDebugMode(@NonNull Canvas r5) {
        this.delegate.actualDraw(r5);
        if (shouldDrawScrim() == false) goto L6;
        CircularRevealWidget.RevealInfo r0 = this.revealInfo;
        r5.drawCircle(r0.centerX, r0.centerY, r0.radius, this.scrimPaint);
    L6:
        if (shouldDrawCircularReveal() == false) goto L8;
        drawDebugCircle(r5, ViewCompat.MEASURED_STATE_MASK, 10.0f);
        drawDebugCircle(r5, SupportMenu.CATEGORY_MASK, 5.0f);
    L8:
        drawOverlayDrawable(r5);
    }

    private void drawOverlayDrawable(@NonNull Canvas r5) {
        if (shouldDrawOverlayDrawable() == false) goto L6;
        Rect r0 = this.overlayDrawable.getBounds();
        float r1 = this.revealInfo.centerX - (r0.width() / 2.0f);
        float r2 = this.revealInfo.centerY - (r0.height() / 2.0f);
        r5.translate(r1, r2);
        this.overlayDrawable.draw(r5);
        r5.translate(-r1, -r2);
        return;
    }

    private float getDistanceToFurthestCorner(@NonNull CircularRevealWidget.RevealInfo r7) {
        return MathUtils.distanceToFurthestCorner(r7.centerX, r7.centerY, 0.0f, 0.0f, this.view.getWidth(), this.view.getHeight());
    }

    private void invalidateRevealInfo() {
        if (STRATEGY != 1) goto L7;
        this.revealPath.rewind();
        CircularRevealWidget.RevealInfo r0 = this.revealInfo;
        if (r0 == null) goto L7;
        this.revealPath.addCircle(r0.centerX, r0.centerY, r0.radius, Path.Direction.CW);
    L7:
        this.view.invalidate();
    }

    private boolean shouldDrawCircularReveal() {
        CircularRevealWidget.RevealInfo r0 = this.revealInfo;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (STRATEGY != 0) goto L17;
        if (r1 == false) goto L13;
        return false;
    L13:
        if (this.hasCircularRevealCache == true) goto L15;
        return false;
    L15:
        return true;
    L17:
        return !r1;
    L5:
        if (r0.isInvalid() == true) goto L8;
        r1 = false;
        goto L10
    }

    private boolean shouldDrawOverlayDrawable() {
        if (this.buildingCircularRevealCache == false) goto L5;
    L9:
        return false;
    L5:
        if (this.overlayDrawable == null) goto L9;
        if (this.revealInfo == null) goto L9;
        return true;
    }

    private boolean shouldDrawScrim() {
        if (this.buildingCircularRevealCache == false) goto L5;
    L7:
        return false;
    L5:
        if (Color.alpha(this.scrimPaint.getColor()) == 0) goto L7;
        return true;
    }

    public void buildCircularRevealCache() {
        if (STRATEGY != 0) goto L15;
        this.buildingCircularRevealCache = true;
        this.hasCircularRevealCache = false;
        this.view.buildDrawingCache();
        Bitmap r2 = this.view.getDrawingCache();
        if (r2 == null) goto L7;
    L11:
        if (r2 == null) goto L13;
        Paint r3 = this.revealPaint;
        Shader.TileMode r5 = Shader.TileMode.CLAMP;
        r3.setShader(new BitmapShader(r2, r5, r5));
    L13:
        this.buildingCircularRevealCache = false;
        this.hasCircularRevealCache = true;
        return;
    L7:
        if (this.view.getWidth() == 0) goto L11;
        if (this.view.getHeight() == 0) goto L11;
        r2 = Bitmap.createBitmap(this.view.getWidth(), this.view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r4 = new Canvas(r2);
        this.view.draw(r4);
        goto L11
    }

    public void destroyCircularRevealCache() {
        if (STRATEGY != 0) goto L6;
        this.hasCircularRevealCache = false;
        this.view.destroyDrawingCache();
        this.revealPaint.setShader(null);
        this.view.invalidate();
        return;
    }

    public void draw(@NonNull Canvas r9) {
        if (shouldDrawCircularReveal() == false) goto L22;
        int r0 = STRATEGY;
        if (r0 != 0) goto L7;
        CircularRevealWidget.RevealInfo r1 = this.revealInfo;
        r9.drawCircle(r1.centerX, r1.centerY, r1.radius, this.revealPaint);
        if (shouldDrawScrim() == false) goto L25;
        CircularRevealWidget.RevealInfo r2 = this.revealInfo;
        r9.drawCircle(r2.centerX, r2.centerY, r2.radius, this.scrimPaint);
    L25:
        drawOverlayDrawable(r9);
        return;
    L7:
        if (r0 != 1) goto L9;
        int r3 = r9.save();
        r9.clipPath(this.revealPath);
        this.delegate.actualDraw(r9);
        if (shouldDrawScrim() == false) goto L18;
        r9.drawRect(0.0f, 0.0f, this.view.getWidth(), this.view.getHeight(), this.scrimPaint);
    L18:
        r9.restoreToCount(r3);
        goto L25
    L9:
        if (r0 != 2) goto L14;
        this.delegate.actualDraw(r9);
        if (shouldDrawScrim() == false) goto L25;
    L24:
        r9.drawRect(0.0f, 0.0f, this.view.getWidth(), this.view.getHeight(), this.scrimPaint);
        goto L25
    L14:
        throw new IllegalStateException("Unsupported strategy " + r0);
    L22:
        this.delegate.actualDraw(r9);
        if (shouldDrawScrim() == false) goto L25;
        goto L24
    }

    @Nullable
    public Drawable getCircularRevealOverlayDrawable() {
        return this.overlayDrawable;
    }

    @ColorInt
    public int getCircularRevealScrimColor() {
        return this.scrimPaint.getColor();
    }

    @Nullable
    public CircularRevealWidget.RevealInfo getRevealInfo() {
        CircularRevealWidget.RevealInfo r0 = this.revealInfo;
        if (r0 != null) goto L6;
        return null;
    L6:
        CircularRevealWidget.RevealInfo r1 = new CircularRevealWidget.RevealInfo(r0);
        if (r1.isInvalid() == false) goto L9;
        r1.radius = getDistanceToFurthestCorner(r1);
    L9:
        return r1;
    }

    public boolean isOpaque() {
        if (this.delegate.actualIsOpaque() == true) goto L5;
    L7:
        return false;
    L5:
        if (shouldDrawCircularReveal() == true) goto L7;
        return true;
    }

    public void setCircularRevealOverlayDrawable(@Nullable Drawable r1) {
        this.overlayDrawable = r1;
        this.view.invalidate();
    }

    public void setCircularRevealScrimColor(@ColorInt int r2) {
        this.scrimPaint.setColor(r2);
        this.view.invalidate();
    }

    public void setRevealInfo(@Nullable CircularRevealWidget.RevealInfo r3) {
        if (r3 != null) goto L4;
        this.revealInfo = null;
    L11:
        invalidateRevealInfo();
        return;
    L4:
        CircularRevealWidget.RevealInfo r0 = this.revealInfo;
        if (r0 != null) goto L7;
        this.revealInfo = new CircularRevealWidget.RevealInfo(r3);
    L9:
        if (MathUtils.geq(r3.radius, getDistanceToFurthestCorner(r3), 1.0E-4f) == false) goto L11;
        this.revealInfo.radius = Float.MAX_VALUE;
        goto L11
    L7:
        r0.set(r3);
        goto L9
    }
}
