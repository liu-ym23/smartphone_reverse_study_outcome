package com.android.settingslib.widget;

import android.R;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.DrawableWrapper;
import android.util.PathParser;
import android.view.WindowManagerGlobal;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class AdaptiveOutlineDrawable extends DrawableWrapper {
    private static final float ADVANCED_ICON_CENTER = 50.0f;
    private static final float ADVANCED_ICON_RADIUS = 48.0f;
    public static final int ICON_TYPE_ADVANCED = 1;
    public static final int ICON_TYPE_DEFAULT = 0;
    private Bitmap mBitmap;
    private int mInsetPx;
    Paint mOutlinePaint;
    private Path mPath;
    private int mStrokeWidth;
    private int mType;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AdaptiveOutlineIconType {
    }

    public AdaptiveOutlineDrawable(Resources r2, Bitmap r3) {
        super(new AdaptiveIconShapeDrawable(r2));
        init(r2, r3, 0);
    }

    public AdaptiveOutlineDrawable(Resources r2, Bitmap r3, int r4) {
        super(new AdaptiveIconShapeDrawable(r2));
        init(r2, r3, r4);
    }

    private void init(Resources r3, Bitmap r4, int r5) {
        this.mType = r5;
        getDrawable().setTint(-1);
        this.mPath = new Path(PathParser.createPathFromPathData(r3.getString(R.string.config_mobile_hotspot_provision_app_no_ui)));
        this.mStrokeWidth = r3.getDimensionPixelSize(com.android.settingslib.R.dimen.adaptive_outline_stroke);
        Paint r0 = new Paint();
        this.mOutlinePaint = r0;
        r0.setColor(getColor(r3, r5));
        this.mOutlinePaint.setStyle(Paint.Style.STROKE);
        this.mOutlinePaint.setStrokeWidth(this.mStrokeWidth);
        this.mOutlinePaint.setAntiAlias(true);
        this.mInsetPx = getDimensionPixelSize(r3, r5);
        this.mBitmap = r4;
    }

    private int getColor(Resources r1, int r2) {
        if (r2 == 1) goto L5;
        int r0 = com.android.settingslib.R.color.bt_outline_color;
    L7:
        return r1.getColor(r0, null);
    L5:
        r0 = com.android.settingslib.R.color.advanced_outline_color;
        goto L7
    }

    private int getDimensionPixelSize(Resources r1, int r2) {
        if (r2 == 1) goto L5;
        int r0 = com.android.settingslib.R.dimen.dashboard_tile_foreground_image_inset;
    L7:
        return r1.getDimensionPixelSize(r0);
    L5:
        r0 = com.android.settingslib.R.dimen.advanced_dashboard_tile_foreground_image_inset;
        goto L7
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas r6) {
        super.draw(r6);
        Rect r0 = getBounds();
        float r1 = (r0.right - r0.left) / 100.0f;
        float r3 = (r0.bottom - r0.top) / 100.0f;
        int r2 = r6.save();
        r6.scale(r1, r3);
        if (this.mType != 0) goto L5;
        r6.drawPath(this.mPath, this.mOutlinePaint);
    L6:
        r6.restoreToCount(r2);
        r6.drawBitmap(this.mBitmap, r0.left + this.mInsetPx, r0.top + this.mInsetPx, null);
        return;
    L5:
        r6.drawCircle(50.0f, 50.0f, ADVANCED_ICON_RADIUS, this.mOutlinePaint);
        goto L6
    }

    private static int getDefaultDisplayDensity(int r1) {
        return WindowManagerGlobal.getWindowManagerService().getInitialDisplayDensity(r1);
    L4:
        return -1;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mBitmap.getHeight() + (this.mInsetPx * 2);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mBitmap.getWidth() + (this.mInsetPx * 2);
    }
}
