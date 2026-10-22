package com.obric.oui.image;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.obric.common.oui.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppIconDrawable.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0014J\b\u0010\"\u001a\u00020\u0018H\u0002J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0006H\u0016J\u000e\u0010%\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000bJ\u0012\u0010&\u001a\u00020\u00182\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0017\u0010)\u001a\u00020\u00182\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020\u00182\b\b\u0001\u0010\u0007\u001a\u00020\u0006R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/oui/image/AppIconDrawable;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "icon", "backgroundColor", "", "strokeColor", "strokeWidthPixels", "", "clipToMask", "", "(Landroid/content/Context;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;IFZ)V", "backgroundAvoidsStroke", "Ljava/lang/Integer;", "backgroundMaskPath", "Landroid/graphics/Path;", "backgroundPaint", "Landroid/graphics/Paint;", "maskPath", "pathMatrix", "Landroid/graphics/Matrix;", "strokePaint", "draw", "", "canvas", "Landroid/graphics/Canvas;", "drawClipMask", "drawMaskBackground", "drawNoClipMask", "getOpacity", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "refreshMaskPath", "setAlpha", "alpha", "setClipToMask", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setIconBackgroundColor", "(Ljava/lang/Integer;)V", "setStrokeColor", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppIconDrawable extends Drawable {
    public static final Companion Companion = null;
    private static final String TAG = "OImageAppIcon";
    private boolean backgroundAvoidsStroke;
    private Integer backgroundColor;
    private final Path backgroundMaskPath;
    private final Paint backgroundPaint;
    private boolean clipToMask;
    private final Context context;
    private final Drawable icon;
    private final Path maskPath;
    private final Matrix pathMatrix;
    private int strokeColor;
    private final Paint strokePaint;
    private final float strokeWidthPixels;

    /* JADX INFO: compiled from: AppIconDrawable.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/image/AppIconDrawable$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    public /* synthetic */ AppIconDrawable(Context r8, Drawable r9, Integer r10, int r11, float r12, boolean r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 4) == 0) goto L5;
        r10 = null;
    L5:
        Integer r3 = r10;
        if ((r14 & 8) == 0) goto L8;
        r11 = r8.getColor(R.color.oui_line_1);
    L8:
        int r4 = r11;
        if ((r14 & 16) == 0) goto L11;
        r12 = r8.getResources().getDimension(R.dimen.oui_image_stroke_width);
    L11:
        float r5 = r12;
        if ((r14 & 32) == 0) goto L14;
        r13 = false;
    L14:
        this(r8, r9, r3, r4, r5, r13);
    }

    public AppIconDrawable(Context r2, Drawable r3, Integer r4, int r5, float r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "icon");
        this.context = r2;
        this.icon = r3;
        this.backgroundColor = r4;
        this.strokeColor = r5;
        this.strokeWidthPixels = r6;
        this.clipToMask = r7;
        Paint r8 = new Paint(1);
        r8.setStyle(Paint.Style.STROKE);
        r8.setColor(this.strokeColor);
        this.strokePaint = r8;
        Paint r9 = new Paint(1);
        r9.setStyle(Paint.Style.FILL);
        this.backgroundPaint = r9;
        this.maskPath = new Path();
        this.backgroundMaskPath = new Path();
        this.pathMatrix = new Matrix();
        Integer r10 = this.backgroundColor;
        if (r10 == null) goto L6;
        r9.setColor(r10.intValue());
    L6:
        refreshMaskPath();
    }

    public final void setClipToMask(boolean r2) {
        if (this.clipToMask != r2) goto L5;
        return;
    L5:
        this.clipToMask = r2;
        invalidateSelf();
    }

    public final void setIconBackgroundColor(Integer r3) {
        if (Intrinsics.areEqual(this.backgroundColor, r3) == false) goto L5;
        return;
    L5:
        this.backgroundColor = r3;
        if (r3 == null) goto L8;
        boolean r0 = true;
    L9:
        this.backgroundAvoidsStroke = r0;
        Log.d(TAG, Intrinsics.stringPlus("backgroundAvoidsStroke =  ", Boolean.valueOf(r0)));
        if (r3 == null) goto L13;
        int r4 = r3.intValue();
        this.backgroundPaint.setColor(r4);
    L13:
        invalidateSelf();
        return;
    L8:
        r0 = false;
        goto L9
    }

    public final void setStrokeColor(int r2) {
        if (this.strokeColor != r2) goto L5;
        return;
    L5:
        this.strokeColor = r2;
        this.strokePaint.setColor(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        if (this.clipToMask == true) goto L6;
        drawNoClipMask(r2);
        return;
    L6:
        drawClipMask(r2);
    }

    private final void drawClipMask(Canvas r5) {
        if (this.maskPath.isEmpty() == false) goto L6;
        Log.w(TAG, "draw skipped mask because maskPath is empty");
        this.icon.draw(r5);
        return;
    L6:
        int r0 = r5.save();
        r5.clipPath(this.maskPath);
        drawMaskBackground(r5);
        this.icon.draw(r5);
        float r2 = this.strokeWidthPixels;
        if (r2 > 0.0f) goto L10;
        Log.d(TAG, Intrinsics.stringPlus("draw skipped stroke because strokeWidthPixels=", Float.valueOf(r2)));
        r5.restoreToCount(r0);
        return;
    L10:
        this.strokePaint.setStrokeWidth(r2 * 2);
        this.strokePaint.setStrokeJoin(Paint.Join.ROUND);
        this.strokePaint.setStrokeCap(Paint.Cap.ROUND);
        r5.drawPath(this.maskPath, this.strokePaint);
        r5.restoreToCount(r0);
    }

    private final void drawNoClipMask(Canvas r5) {
        drawMaskBackground(r5);
        this.icon.draw(r5);
        if (this.maskPath.isEmpty() == false) goto L6;
        Log.w(TAG, "draw skipped stroke because maskPath is empty");
        return;
    L6:
        float r0 = this.strokeWidthPixels;
        if (r0 > 0.0f) goto L10;
        Log.d(TAG, Intrinsics.stringPlus("draw skipped stroke because strokeWidthPixels=", Float.valueOf(r0)));
        return;
    L10:
        int r1 = r5.save();
        r5.clipPath(this.maskPath);
        this.strokePaint.setStrokeWidth(this.strokeWidthPixels * 2);
        this.strokePaint.setStrokeJoin(Paint.Join.ROUND);
        this.strokePaint.setStrokeCap(Paint.Cap.ROUND);
        r5.drawPath(this.maskPath, this.strokePaint);
        r5.restoreToCount(r1);
    }

    private final void drawMaskBackground(Canvas r2) {
        if (this.backgroundColor != null) goto L6;
        return;
    L6:
        if (this.maskPath.isEmpty() == false) goto L10;
        Log.w(TAG, "draw skipped background because maskPath is empty");
        return;
    L10:
        if (this.backgroundAvoidsStroke == false) goto L12;
        Path r0 = this.backgroundMaskPath;
    L13:
        r2.drawPath(r0, this.backgroundPaint);
        return;
    L12:
        r0 = this.maskPath;
        goto L13
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "bounds");
        super.onBoundsChange(r2);
        this.icon.setBounds(r2);
        refreshMaskPath();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        this.icon.setAlpha(r2);
        this.backgroundPaint.setAlpha(r2);
        this.strokePaint.setAlpha(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        this.icon.setColorFilter(r2);
        this.backgroundPaint.setColorFilter(r2);
        this.strokePaint.setColorFilter(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.icon.getOpacity();
    }

    private final void refreshMaskPath() {
        this.maskPath.reset();
        this.backgroundMaskPath.reset();
        if (getBounds().isEmpty() == false) goto L6;
        Log.w(TAG, "refreshMaskPath skipped because bounds is empty, check if in whitelist");
        return;
    L6:
        Path r0 = new AdaptiveIconDrawable(null, null, null).getIconMask();
        if (r0.isEmpty() == false) goto L10;
        Log.w(TAG, "refreshMaskPath found empty icon mask");
        return;
    L10:
        float r1 = getBounds().width();
        float r2 = getBounds().height();
        float r3 = Math.min(r1, r2);
        float r5 = 0.0f;
        if (r1 <= r2) goto L13;
        float r4 = (r1 - r2) / 2.0f;
    L15:
        if (r2 <= r1) goto L17;
        r5 = (r2 - r1) / 2.0f;
    L17:
        this.pathMatrix.reset();
        float r6 = r3 / 100.0f;
        this.pathMatrix.setScale(r6, r6);
        this.maskPath.set(r0);
        this.maskPath.transform(this.pathMatrix);
        this.maskPath.offset(getBounds().left + r4, getBounds().top + r5);
        float r7 = this.strokeWidthPixels + 1;
        this.pathMatrix.reset();
        float r8 = (r3 - (2.0f * r7)) / 100.0f;
        this.pathMatrix.setScale(r8, r8);
        this.backgroundMaskPath.set(r0);
        this.backgroundMaskPath.transform(this.pathMatrix);
        this.backgroundMaskPath.offset((getBounds().left + r4) + r7, (getBounds().top + r5) + r7);
        return;
    L13:
        r4 = 0.0f;
        goto L15
    }
}
