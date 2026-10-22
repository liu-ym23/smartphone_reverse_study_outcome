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
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.google.android.material.math.MathUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
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
    private Drawable overlayDrawable;
    private CircularRevealWidget.RevealInfo revealInfo;
    private final Paint revealPaint;
    private final Path revealPath;
    private final Paint scrimPaint;
    private final View view;

    public interface Delegate {
        void actualDraw(Canvas r1);

        boolean actualIsOpaque();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Strategy {
    }

    static {
        STRATEGY = 2;
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

    public void buildCircularRevealCache() {
        if (STRATEGY != 0) goto L15;
        this.buildingCircularRevealCache = true;
        this.hasCircularRevealCache = false;
        this.view.buildDrawingCache();
        Bitmap r2 = this.view.getDrawingCache();
        if (r2 == null) goto L7;
    L11:
        if (r2 == null) goto L13;
        this.revealPaint.setShader(new BitmapShader(r2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
    L13:
        this.buildingCircularRevealCache = false;
        this.hasCircularRevealCache = true;
        return;
    L7:
        if (this.view.getWidth() == 0) goto L11;
        if (this.view.getHeight() == 0) goto L11;
        r2 = Bitmap.createBitmap(this.view.getWidth(), this.view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r3 = new Canvas(r2);
        this.view.draw(r3);
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

    public void setRevealInfo(CircularRevealWidget.RevealInfo r3) {
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

    public CircularRevealWidget.RevealInfo getRevealInfo() {
        if (this.revealInfo != null) goto L6;
        return null;
    L6:
        CircularRevealWidget.RevealInfo r0 = new CircularRevealWidget.RevealInfo(this.revealInfo);
        if (r0.isInvalid() == false) goto L9;
        r0.radius = getDistanceToFurthestCorner(r0);
    L9:
        return r0;
    }

    public void setCircularRevealScrimColor(int r2) {
        this.scrimPaint.setColor(r2);
        this.view.invalidate();
    }

    public int getCircularRevealScrimColor() {
        return this.scrimPaint.getColor();
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.overlayDrawable;
    }

    public void setCircularRevealOverlayDrawable(Drawable r1) {
        this.overlayDrawable = r1;
        this.view.invalidate();
    }

    private void invalidateRevealInfo() {
        if (STRATEGY != 1) goto L7;
        this.revealPath.rewind();
        CircularRevealWidget.RevealInfo r0 = this.revealInfo;
        if (r0 == null) goto L7;
        this.revealPath.addCircle(r0.centerX, this.revealInfo.centerY, this.revealInfo.radius, Path.Direction.CW);
    L7:
        this.view.invalidate();
    }

    private float getDistanceToFurthestCorner(CircularRevealWidget.RevealInfo r7) {
        return MathUtils.distanceToFurthestCorner(r7.centerX, r7.centerY, 0.0f, 0.0f, this.view.getWidth(), this.view.getHeight());
    }

    public void draw(Canvas r9) {
        if (shouldDrawCircularReveal() == false) goto L22;
        int r0 = STRATEGY;
        if (r0 != 0) goto L7;
        r9.drawCircle(this.revealInfo.centerX, this.revealInfo.centerY, this.revealInfo.radius, this.revealPaint);
        if (shouldDrawScrim() == false) goto L25;
        r9.drawCircle(this.revealInfo.centerX, this.revealInfo.centerY, this.revealInfo.radius, this.scrimPaint);
    L25:
        drawOverlayDrawable(r9);
        return;
    L7:
        if (r0 != 1) goto L9;
        int r1 = r9.save();
        r9.clipPath(this.revealPath);
        this.delegate.actualDraw(r9);
        if (shouldDrawScrim() == false) goto L18;
        r9.drawRect(0.0f, 0.0f, this.view.getWidth(), this.view.getHeight(), this.scrimPaint);
    L18:
        r9.restoreToCount(r1);
        goto L25
    L9:
        if (r0 != 2) goto L14;
        this.delegate.actualDraw(r9);
        if (shouldDrawScrim() == false) goto L25;
        r9.drawRect(0.0f, 0.0f, this.view.getWidth(), this.view.getHeight(), this.scrimPaint);
        goto L25
    L14:
        throw new IllegalStateException("Unsupported strategy " + r0);
    L22:
        this.delegate.actualDraw(r9);
        if (shouldDrawScrim() == false) goto L25;
        r9.drawRect(0.0f, 0.0f, this.view.getWidth(), this.view.getHeight(), this.scrimPaint);
        goto L25
    }

    private void drawOverlayDrawable(Canvas r5) {
        if (shouldDrawOverlayDrawable() == false) goto L6;
        Rect r0 = this.overlayDrawable.getBounds();
        float r1 = this.revealInfo.centerX - (r0.width() / 2.0f);
        float r2 = this.revealInfo.centerY - (r0.height() / 2.0f);
        r5.translate(r1, r2);
        this.overlayDrawable.draw(r5);
        r5.translate(-r1, -r2);
        return;
    }

    public boolean isOpaque() {
        if (this.delegate.actualIsOpaque() == true) goto L5;
    L7:
        return false;
    L5:
        if (shouldDrawCircularReveal() == true) goto L7;
        return true;
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

    private boolean shouldDrawScrim() {
        if (this.buildingCircularRevealCache == false) goto L5;
    L7:
        return false;
    L5:
        if (Color.alpha(this.scrimPaint.getColor()) == 0) goto L7;
        return true;
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

    private void drawDebugMode(Canvas r5) {
        this.delegate.actualDraw(r5);
        if (shouldDrawScrim() == false) goto L6;
        r5.drawCircle(this.revealInfo.centerX, this.revealInfo.centerY, this.revealInfo.radius, this.scrimPaint);
    L6:
        if (shouldDrawCircularReveal() == false) goto L8;
        drawDebugCircle(r5, -16777216, 10.0f);
        drawDebugCircle(r5, SupportMenu.CATEGORY_MASK, 5.0f);
    L8:
        drawOverlayDrawable(r5);
    }

    private void drawDebugCircle(Canvas r4, int r5, float r6) {
        this.debugPaint.setColor(r5);
        this.debugPaint.setStrokeWidth(r6);
        r4.drawCircle(this.revealInfo.centerX, this.revealInfo.centerY, this.revealInfo.radius - (r6 / 2.0f), this.debugPaint);
    }
}
