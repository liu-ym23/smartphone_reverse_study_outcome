package com.android.settingslib.graph;

import android.R;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.DrawableWrapper;
import android.os.Handler;
import android.telephony.CellSignalStrength;
import android.util.PathParser;
import androidx.profileinstaller.ProfileVerifier;
import com.android.settingslib.Utils;
import com.android.settingslib.flags.Flags;

/* JADX INFO: loaded from: classes.dex */
public class SignalDrawable extends DrawableWrapper {
    private static final long DOT_DELAY = 1000;
    private static final float DOT_PADDING = 0.0625f;
    private static final float DOT_SIZE = 0.125f;
    private static final int ICON_RES = 0;
    private static final int LEVEL_MASK = 255;
    private static final int NUM_DOTS = 3;
    private static final int NUM_LEVEL_MASK = 65280;
    private static final int NUM_LEVEL_SHIFT = 8;
    private static final float PAD = 0.083333336f;
    private static final int STATE_CARRIER_CHANGE = 3;
    private static final int STATE_CUT = 2;
    private static final int STATE_MASK = 16711680;
    private static final int STATE_SHIFT = 16;
    private static final String TAG = "SignalDrawable";
    private static final float VIEWPORT = 24.0f;
    private boolean mAnimating;
    private final Path mAttributionPath;
    private final Matrix mAttributionScaleMatrix;
    private final Runnable mChangeDot;
    private int mCurrentDot;
    private final float mCutoutHeightFraction;
    private final Path mCutoutPath;
    private final float mCutoutWidthFraction;
    private float mDarkIntensity;
    private final int mDarkModeFillColor;
    private final Paint mForegroundPaint;
    private final Path mForegroundPath;
    private final Handler mHandler;
    private final int mIntrinsicSize;
    private final int mLightModeFillColor;
    private final Path mScaledAttributionPath;
    private final Paint mTransparentPaint;

    public static int getCarrierChangeState(int r1) {
        return (r1 << 8) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
    }

    public static int getState(int r1) {
        return (r1 & STATE_MASK) >> 16;
    }

    public static int getState(int r0, int r1, boolean r2) {
        if (r2 == false) goto L4;
        int r3 = 2;
    L5:
        int r4 = r1 << 8;
        return r0 | (r4 | (r3 << 16));
    L4:
        r3 = 0;
        goto L5
    }

    static /* synthetic */ int access$002(SignalDrawable r0, int r1) {
        r0.mCurrentDot = r1;
        return r1;
    }

    static /* synthetic */ int access$004(SignalDrawable r1) {
        int r0 = r1.mCurrentDot + 1;
        r1.mCurrentDot = r0;
        return r0;
    }

    static /* synthetic */ Runnable access$100(SignalDrawable r0) {
        return r0.mChangeDot;
    }

    static /* synthetic */ Handler access$200(SignalDrawable r0) {
        return r0.mHandler;
    }

    static {
        ICON_RES = getIconRes();
    }

    public SignalDrawable(Context r4) {
        super(r4.getDrawable(ICON_RES));
        this.mForegroundPaint = new Paint(1);
        Paint r0 = new Paint(1);
        this.mTransparentPaint = r0;
        this.mCutoutPath = new Path();
        this.mForegroundPath = new Path();
        Path r1 = new Path();
        this.mAttributionPath = r1;
        this.mAttributionScaleMatrix = new Matrix();
        this.mScaledAttributionPath = new Path();
        this.mDarkIntensity = -1.0f;
        this.mChangeDot = new AnonymousClass1(this);
        r1.set(PathParser.createPathFromPathData(r4.getString(R.string.config_useragentprofile_url)));
        updateScaledAttributionPath();
        this.mCutoutWidthFraction = r4.getResources().getFloat(R.dimen.datepicker_list_year_activated_label_size);
        this.mCutoutHeightFraction = r4.getResources().getFloat(R.dimen.datepicker_header_text_size);
        this.mDarkModeFillColor = Utils.getColorStateListDefaultColor(r4, com.android.settingslib.R.color.dark_mode_icon_color_single_tone);
        this.mLightModeFillColor = Utils.getColorStateListDefaultColor(r4, com.android.settingslib.R.color.light_mode_icon_color_single_tone);
        this.mIntrinsicSize = r4.getResources().getDimensionPixelSize(com.android.settingslib.R.dimen.signal_icon_size);
        r0.setColor(r4.getColor(R.color.transparent));
        r0.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.mHandler = new Handler();
        setDarkIntensity(0.0f);
    }

    private void updateScaledAttributionPath() {
        if (getBounds().isEmpty() == false) goto L5;
        this.mAttributionScaleMatrix.setScale(1.0f, 1.0f);
    L6:
        this.mAttributionPath.transform(this.mAttributionScaleMatrix, this.mScaledAttributionPath);
        return;
    L5:
        this.mAttributionScaleMatrix.setScale(getBounds().width() / 24.0f, getBounds().height() / 24.0f);
        goto L6
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mIntrinsicSize;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mIntrinsicSize;
    }

    private void updateAnimation() {
        if (isInState(3) == true) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (r0 != this.mAnimating) goto L11;
        return;
    L11:
        this.mAnimating = r0;
        if (r0 == false) goto L14;
        this.mChangeDot.run();
        return;
    L14:
        this.mHandler.removeCallbacks(this.mChangeDot);
        return;
    L5:
        if (isVisible() == false) goto L7;
        r0 = true;
        goto L9
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int r1) {
        super.onLevelChange(unpackLevel(r1));
        updateAnimation();
        setTintList(ColorStateList.valueOf(this.mForegroundPaint.getColor()));
        invalidateSelf();
        return true;
    }

    private int unpackLevel(int r4) {
        int r2 = 0;
        if (((65280 & r4) >> 8) != (CellSignalStrength.getNumSignalStrengthLevels() + 1)) goto L5;
        int r0 = 10;
    L6:
        int r5 = r4 & 255;
        if (Flags.newStatusBarIcons() == false) goto L12;
        if (isInState(2) == false) goto L12;
        r2 = 20;
    L12:
        return (r5 + r0) + r2;
    L5:
        r0 = 0;
        goto L6
    }

    public void setDarkIntensity(float r2) {
        if (r2 != this.mDarkIntensity) goto L5;
        return;
    L5:
        setTintList(ColorStateList.valueOf(getFillColor(r2)));
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList r3) {
        super.setTintList(r3);
        int r0 = this.mForegroundPaint.getColor();
        this.mForegroundPaint.setColor(r3.getDefaultColor());
        if (r0 == this.mForegroundPaint.getColor()) goto L6;
        invalidateSelf();
        return;
    }

    private int getFillColor(float r3) {
        return getColorForDarkIntensity(r3, this.mLightModeFillColor, this.mDarkModeFillColor);
    }

    private int getColorForDarkIntensity(float r1, int r2, int r3) {
        return ((Integer) ArgbEvaluator.getInstance().evaluate(r1, Integer.valueOf(r2), Integer.valueOf(r3))).intValue();
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r1) {
        super.onBoundsChange(r1);
        updateScaledAttributionPath();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas r14) {
        r14.saveLayer(null, null);
        float r0 = getBounds().width();
        float r1 = getBounds().height();
        boolean r3 = true;
        if (getLayoutDirection() == 1) goto L7;
        r3 = false;
    L7:
        if (r3 == false) goto L9;
        r14.save();
        r14.translate(r0, 0.0f);
        r14.scale(-1.0f, 1.0f);
    L9:
        super.draw(r14);
        this.mCutoutPath.reset();
        this.mCutoutPath.setFillType(Path.FillType.WINDING);
        float r4 = Math.round(PAD * r0);
        if (isInState(3) == false) goto L13;
        float r2 = DOT_SIZE * r1;
        float r11 = r1 * DOT_PADDING;
        float r12 = r11 + r2;
        float r5 = (r0 - r4) - r2;
        float r6 = (r1 - r4) - r2;
        this.mForegroundPath.reset();
        drawDotAndPadding(r5, r6, r11, r2, 2);
        drawDotAndPadding(r5 - r12, r6, r11, r2, 1);
        drawDotAndPadding(r5 - (r12 * 2.0f), r6, r11, r2, 0);
        r14.drawPath(this.mCutoutPath, this.mTransparentPaint);
        r14.drawPath(this.mForegroundPath, this.mForegroundPaint);
    L17:
        if (r3 == false) goto L19;
        r14.restore();
    L19:
        r14.restore();
        return;
    L13:
        if (Flags.newStatusBarIcons() == true) goto L17;
        if (isInState(2) == false) goto L17;
        float r7 = (this.mCutoutWidthFraction * r0) / 24.0f;
        float r8 = (this.mCutoutHeightFraction * r1) / 24.0f;
        this.mCutoutPath.moveTo(r0, r1);
        this.mCutoutPath.rLineTo(-r7, 0.0f);
        this.mCutoutPath.rLineTo(0.0f, -r8);
        this.mCutoutPath.rLineTo(r7, 0.0f);
        this.mCutoutPath.rLineTo(0.0f, r8);
        r14.drawPath(this.mCutoutPath, this.mTransparentPaint);
        r14.drawPath(this.mScaledAttributionPath, this.mForegroundPaint);
        goto L17
    }

    private void drawDotAndPadding(float r10, float r11, float r12, float r13, int r14) {
        if (r14 != this.mCurrentDot) goto L6;
        float r7 = r10 + r13;
        float r8 = r11 + r13;
        this.mForegroundPath.addRect(r10, r11, r7, r8, Path.Direction.CW);
        this.mCutoutPath.addRect(r10 - r12, r11 - r12, r7 + r12, r8 + r12, Path.Direction.CW);
        return;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void setAlpha(int r1) {
        super.setAlpha(r1);
        this.mForegroundPaint.setAlpha(r1);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
        super.setColorFilter(r1);
        this.mForegroundPaint.setColorFilter(r1);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean setVisible(boolean r1, boolean r2) {
        boolean r3 = super.setVisible(r1, r2);
        updateAnimation();
        return r3;
    }

    private boolean isInState(int r1) {
        if (getState(getLevel()) != r1) goto L5;
        return true;
    L5:
        return false;
    }

    public static int getEmptyState(int r2) {
        return getState(0, r2, true);
    }

    private static int getIconRes() {
        if (Flags.newStatusBarIcons() == true) goto L5;
        return R.drawable.pointer_grab;
    L5:
        return com.android.settingslib.R.drawable.ic_mobile_level_list;
    }
}
