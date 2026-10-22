package com.android.launcher3.icons;

import android.content.Context;
import android.content.pm.LauncherApps;
import android.content.pm.ShortcutInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;

/* JADX INFO: loaded from: classes.dex */
public class BubbleIconFactory extends BaseIconFactory {
    private final BaseIconFactory mBadgeFactory;
    private final int mRingColor;
    private final int mRingWidth;

    private static class CircularAdaptiveIcon extends AdaptiveIconDrawable {
        final Path mPath;

        CircularAdaptiveIcon(Drawable r1, Drawable r2) {
            super(r1, r2);
            this.mPath = new Path();
        }

        @Override // android.graphics.drawable.AdaptiveIconDrawable
        public Path getIconMask() {
            this.mPath.reset();
            Rect r0 = getBounds();
            this.mPath.addOval(r0.left, r0.top, r0.right, r0.bottom, Path.Direction.CW);
            return this.mPath;
        }

        @Override // android.graphics.drawable.AdaptiveIconDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas r3) {
            int r0 = r3.save();
            r3.clipPath(getIconMask());
            Drawable r1 = getBackground();
            if (r1 == null) goto L5;
            r1.draw(r3);
        L5:
            Drawable r2 = getForeground();
            if (r2 == null) goto L8;
            r2.draw(r3);
        L8:
            r3.restoreToCount(r0);
        }
    }

    private class CircularRingDrawable extends CircularAdaptiveIcon {
        final Drawable mDr;
        final Rect mInnerBounds;
        final /* synthetic */ BubbleIconFactory this$0;

        CircularRingDrawable(BubbleIconFactory r1, Drawable r2) {
            this.this$0 = r1;
            super(null, null);
            this.mInnerBounds = new Rect();
            this.mDr = r2;
        }

        @Override // com.android.launcher3.icons.BubbleIconFactory.CircularAdaptiveIcon, android.graphics.drawable.AdaptiveIconDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas r6) {
            int r0 = r6.save();
            r6.clipPath(getIconMask());
            r6.drawColor(BubbleIconFactory.access$000(this.this$0));
            this.mInnerBounds.set(getBounds());
            this.mInnerBounds.inset(BubbleIconFactory.access$100(this.this$0), BubbleIconFactory.access$100(this.this$0));
            r6.translate(this.mInnerBounds.left, this.mInnerBounds.top);
            this.mDr.setBounds(0, 0, this.mInnerBounds.width(), this.mInnerBounds.height());
            this.mDr.draw(r6);
            r6.restoreToCount(r0);
        }
    }

    static /* synthetic */ int access$000(BubbleIconFactory r0) {
        return r0.mRingColor;
    }

    static /* synthetic */ int access$100(BubbleIconFactory r0) {
        return r0.mRingWidth;
    }

    public BubbleIconFactory(Context r2, int r3, int r4, int r5, int r6) {
        super(r2, r2.getResources().getConfiguration().densityDpi, r3);
        this.mRingColor = r5;
        this.mRingWidth = r6;
        this.mBadgeFactory = new BaseIconFactory(r2, r2.getResources().getConfiguration().densityDpi, r4);
    }

    public Drawable getBubbleDrawable(Context r2, ShortcutInfo r3, Icon r4) {
        if (r3 != null) goto L4;
        if (r4 != null) goto L7;
        return null;
    L7:
        if (r4.getType() != 4) goto L9;
    L10:
        r2.grantUriPermission(r2.getPackageName(), r4.getUri(), 1);
    L12:
        return r4.loadDrawable(r2);
    L9:
        if (r4.getType() != 6) goto L12;
    L4:
        return ((LauncherApps) r2.getSystemService(LauncherApps.class)).getShortcutIconDrawable(r3, r2.getResources().getConfiguration().densityDpi);
    }

    public Bitmap getBubbleBitmap(Drawable r2, float[] r3) {
        if (r3 != null) goto L5;
        r3 = new float[1];
    L5:
        return createIconBitmap(normalizeAndWrapToAdaptiveIcon(r2, null, r3), r3[0], 2);
    }

    public BitmapInfo getBadgeBitmap(Drawable r3, boolean r4) {
        if ((r3 instanceof AdaptiveIconDrawable) == false) goto L5;
        AdaptiveIconDrawable r5 = (AdaptiveIconDrawable) r3;
        r3 = new CircularAdaptiveIcon(r5.getBackground(), r5.getForeground());
    L5:
        if (r4 == false) goto L7;
        r3 = new CircularRingDrawable(this, r3);
    L7:
        Bitmap r6 = this.mBadgeFactory.createIconBitmap(r3, 1.0f, 2);
        return this.mBadgeFactory.createIconBitmap(r6);
    }
}
