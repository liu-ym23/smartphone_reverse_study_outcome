package com.android.settingslib.graph;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.android.settingslib.R;
import com.android.settingslib.Utils;

/* JADX INFO: loaded from: classes.dex */
public class BatteryMeterDrawableBase extends Drawable {
    private static final float ASPECT_RATIO = 0.58f;
    private static final float BOLT_LEVEL_THRESHOLD = 0.3f;
    private static final int FULL = 96;
    private static final float RADIUS_RATIO = 0.05882353f;
    private static final boolean SINGLE_DIGIT_PERCENT = false;
    public static final String TAG = "BatteryMeterDrawableBase";
    protected final Paint mBatteryPaint;
    private final RectF mBoltFrame;
    protected final Paint mBoltPaint;
    private final Path mBoltPath;
    private final float[] mBoltPoints;
    private final RectF mButtonFrame;
    protected float mButtonHeightFraction;
    private int mChargeColor;
    private boolean mCharging;
    private final int[] mColors;
    protected final Context mContext;
    private final int mCriticalLevel;
    private final RectF mFrame;
    protected final Paint mFramePaint;
    private int mHeight;
    private int mIconTint;
    private final int mIntrinsicHeight;
    private final int mIntrinsicWidth;
    private int mLevel;
    private float mOldDarkIntensity;
    private final Path mOutlinePath;
    private final Rect mPadding;
    private final RectF mPlusFrame;
    protected final Paint mPlusPaint;
    private final Path mPlusPath;
    private final float[] mPlusPoints;
    protected boolean mPowerSaveAsColorError;
    private boolean mPowerSaveEnabled;
    protected final Paint mPowersavePaint;
    private final Path mShapePath;
    private boolean mShowPercent;
    private float mSubpixelSmoothingLeft;
    private float mSubpixelSmoothingRight;
    private float mTextHeight;
    protected final Paint mTextPaint;
    private final Path mTextPath;
    private String mWarningString;
    private float mWarningTextHeight;
    protected final Paint mWarningTextPaint;
    private int mWidth;

    public static /* synthetic */ void $r8$lambda$oXu2YS6tvdEK74wa4DBqiv0oeA8(BatteryMeterDrawableBase r0) {
        r0.invalidateSelf();
    }

    static {
    }

    protected float getAspectRatio() {
        return 0.58f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    protected float getRadiusRatio() {
        return RADIUS_RATIO;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r1) {
    }

    public BatteryMeterDrawableBase(Context r11, int r12) {
        this.mLevel = -1;
        this.mPowerSaveAsColorError = true;
        this.mIconTint = -1;
        this.mOldDarkIntensity = -1.0f;
        this.mBoltPath = new Path();
        this.mPlusPath = new Path();
        this.mPadding = new Rect();
        this.mFrame = new RectF();
        this.mButtonFrame = new RectF();
        this.mBoltFrame = new RectF();
        this.mPlusFrame = new RectF();
        this.mShapePath = new Path();
        this.mOutlinePath = new Path();
        this.mTextPath = new Path();
        this.mContext = r11;
        Resources r0 = r11.getResources();
        TypedArray r2 = r0.obtainTypedArray(R.array.batterymeter_color_levels);
        TypedArray r3 = r0.obtainTypedArray(R.array.batterymeter_color_values);
        int r4 = r2.length();
        this.mColors = new int[r4 * 2];
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L9;
        int r8 = r6 * 2;
        this.mColors[r8] = r2.getInt(r6, 0);
        if (r3.getType(r6) != 2) goto L7;
        this.mColors[r8 + 1] = Utils.getColorAttrDefaultColor(r11, r3.getThemeAttributeId(r6, 0));
    L8:
        r6 = r6 + 1;
        goto L3
    L7:
        this.mColors[r8 + 1] = r3.getColor(r6, 0);
        goto L8
    L9:
        r2.recycle();
        r3.recycle();
        this.mWarningString = r11.getString(R.string.battery_meter_very_low_overlay_symbol);
        this.mCriticalLevel = this.mContext.getResources().getInteger(android.R.integer.config_datagram_wait_for_connected_state_for_last_message_timeout_millis);
        this.mButtonHeightFraction = r11.getResources().getFraction(R.fraction.battery_button_height_fraction, 1, 1);
        this.mSubpixelSmoothingLeft = r11.getResources().getFraction(R.fraction.battery_subpixel_smoothing_left, 1, 1);
        this.mSubpixelSmoothingRight = r11.getResources().getFraction(R.fraction.battery_subpixel_smoothing_right, 1, 1);
        Paint r5 = new Paint(1);
        this.mFramePaint = r5;
        r5.setColor(r12);
        r5.setDither(true);
        r5.setStrokeWidth(0.0f);
        r5.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint r7 = new Paint(1);
        this.mBatteryPaint = r7;
        r7.setDither(true);
        r7.setStrokeWidth(0.0f);
        r7.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint r13 = new Paint(1);
        this.mTextPaint = r13;
        r13.setTypeface(Typeface.create("sans-serif-condensed", 1));
        r13.setTextAlign(Paint.Align.CENTER);
        Paint r14 = new Paint(1);
        this.mWarningTextPaint = r14;
        r14.setTypeface(Typeface.create("sans-serif", 1));
        r14.setTextAlign(Paint.Align.CENTER);
        int[] r9 = this.mColors;
        if (r9.length <= 1) goto L12;
        r14.setColor(r9[1]);
    L12:
        this.mChargeColor = Utils.getColorStateListDefaultColor(this.mContext, R.color.meter_consumed_color);
        Paint r15 = new Paint(1);
        this.mBoltPaint = r15;
        r15.setColor(Utils.getColorStateListDefaultColor(this.mContext, R.color.batterymeter_bolt_color));
        this.mBoltPoints = loadPoints(r0, R.array.batterymeter_bolt_points);
        Paint r16 = new Paint(1);
        this.mPlusPaint = r16;
        r16.setColor(Utils.getColorStateListDefaultColor(this.mContext, R.color.batterymeter_plus_color));
        this.mPlusPoints = loadPoints(r0, R.array.batterymeter_plus_points);
        Paint r1 = new Paint(1);
        this.mPowersavePaint = r1;
        r1.setColor(r16.getColor());
        r1.setStyle(Paint.Style.STROKE);
        r1.setStrokeWidth(r11.getResources().getDimensionPixelSize(R.dimen.battery_powersave_outline_thickness));
        this.mIntrinsicWidth = r11.getResources().getDimensionPixelSize(R.dimen.battery_width);
        this.mIntrinsicHeight = r11.getResources().getDimensionPixelSize(R.dimen.battery_height);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mIntrinsicHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mIntrinsicWidth;
    }

    public void setShowPercent(boolean r1) {
        this.mShowPercent = r1;
        postInvalidate();
    }

    public void setCharging(boolean r1) {
        this.mCharging = r1;
        postInvalidate();
    }

    public boolean getCharging() {
        return this.mCharging;
    }

    public void setBatteryLevel(int r1) {
        this.mLevel = r1;
        postInvalidate();
    }

    public int getBatteryLevel() {
        return this.mLevel;
    }

    public void setPowerSave(boolean r1) {
        this.mPowerSaveEnabled = r1;
        postInvalidate();
    }

    public boolean getPowerSave() {
        return this.mPowerSaveEnabled;
    }

    protected void setPowerSaveAsColorError(boolean r1) {
        this.mPowerSaveAsColorError = r1;
    }

    protected void postInvalidate() {
        unscheduleSelf(new BatteryMeterDrawableBase$$ExternalSyntheticLambda0(this));
        scheduleSelf(new BatteryMeterDrawableBase$$ExternalSyntheticLambda0(this), 0);
    }

    private static float[] loadPoints(Resources r6, int r7) {
        int[] r8 = r6.getIntArray(r7);
        int r9 = 0;
        int r0 = 0;
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r0 >= r8.length) goto L6;
        r1 = Math.max(r1, r8[r0]);
        r2 = Math.max(r2, r8[r0 + 1]);
        r0 = r0 + 2;
        goto L4
    L6:
        float[] r3 = new float[r8.length];
    L8:
        if (r9 >= r8.length) goto L10;
        r3[r9] = r8[r9] / r1;
        int r4 = r9 + 1;
        r3[r4] = r8[r4] / r2;
        r9 = r9 + 2;
        goto L8
    L10:
        return r3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int r1, int r2, int r3, int r4) {
        super.setBounds(r1, r2, r3, r4);
        updateSize();
    }

    private void updateSize() {
        Rect r0 = getBounds();
        this.mHeight = (r0.bottom - this.mPadding.bottom) - (r0.top + this.mPadding.top);
        this.mWidth = (r0.right - this.mPadding.right) - (r0.left + this.mPadding.left);
        this.mWarningTextPaint.setTextSize(this.mHeight * 0.75f);
        this.mWarningTextHeight = -this.mWarningTextPaint.getFontMetrics().ascent;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect r2) {
        if (this.mPadding.left == 0) goto L5;
    L12:
        r2.set(this.mPadding);
        return true;
    L5:
        if (this.mPadding.top != 0) goto L12;
        if (this.mPadding.right != 0) goto L12;
        if (this.mPadding.bottom != 0) goto L12;
        return super.getPadding(r2);
    }

    public void setPadding(int r2, int r3, int r4, int r5) {
        this.mPadding.left = r2;
        this.mPadding.top = r3;
        this.mPadding.right = r4;
        this.mPadding.bottom = r5;
        updateSize();
    }

    private int getColorForLevel(int r5) {
        int r0 = 0;
        int r1 = 0;
    L3:
        int[] r2 = this.mColors;
        if (r0 >= r2.length) goto L13;
        int r3 = r2[r0];
        int r4 = r2[r0 + 1];
        if (r5 <= r3) goto L8;
        r0 = r0 + 2;
        r1 = r4;
        goto L3
    L8:
        if (r0 == (r2.length - 2)) goto L10;
        return r4;
    L10:
        return this.mIconTint;
    L13:
        return r1;
    }

    public void setColors(int r2, int r3) {
        this.mIconTint = r2;
        this.mFramePaint.setColor(r3);
        this.mBoltPaint.setColor(r2);
        this.mChargeColor = r2;
        invalidateSelf();
    }

    protected int batteryColorForLevel(int r2) {
        if (this.mCharging == true) goto L11;
        if (this.mPowerSaveEnabled == false) goto L12;
        if (this.mPowerSaveAsColorError == true) goto L11;
    L12:
        return getColorForLevel(r2);
    L11:
        return this.mChargeColor;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r23) {
        int r2 = this.mLevel;
        Rect r3 = getBounds();
        if (r2 != (-1)) goto L5;
        return;
    L5:
        float r4 = r2 / 100.0f;
        int r5 = this.mHeight;
        int r6 = (int) (getAspectRatio() * this.mHeight);
        int r7 = (this.mWidth - r6) / 2;
        float r9 = r5;
        int r10 = Math.round(this.mButtonHeightFraction * r9);
        int r11 = this.mPadding.left + r3.left;
        int r8 = (r3.bottom - this.mPadding.bottom) - r5;
        float r13 = r11;
        float r14 = r8;
        this.mFrame.set(r13, r14, r11 + r6, r5 + r8);
        this.mFrame.offset(r7, 0.0f);
        float r12 = r6 * 0.28f;
        float r15 = r10;
        this.mButtonFrame.set(this.mFrame.left + Math.round(r12), this.mFrame.top, this.mFrame.right - Math.round(r12), this.mFrame.top + r15);
        this.mFrame.top += r15;
        this.mBatteryPaint.setColor(batteryColorForLevel(r2));
        if (r2 < 96) goto L9;
        r4 = 1.0f;
    L12:
        if (r4 != 1.0f) goto L14;
        float r16 = this.mButtonFrame.top;
    L15:
        this.mShapePath.reset();
        this.mOutlinePath.reset();
        float r17 = getRadiusRatio() * (this.mFrame.height() + r15);
        this.mShapePath.setFillType(Path.FillType.WINDING);
        this.mShapePath.addRoundRect(this.mFrame, r17, r17, Path.Direction.CW);
        this.mShapePath.addRect(this.mButtonFrame, Path.Direction.CW);
        this.mOutlinePath.addRoundRect(this.mFrame, r17, r17, Path.Direction.CW);
        Path r18 = new Path();
        r18.addRect(this.mButtonFrame, Path.Direction.CW);
        this.mOutlinePath.op(r18, Path.Op.XOR);
        boolean r19 = false;
        if (this.mCharging == false) goto L35;
        float r20 = (this.mFrame.left + (this.mFrame.width() / 4.0f)) + 1.0f;
        float r110 = this.mFrame.top + (this.mFrame.height() / 6.0f);
        float r111 = (this.mFrame.right - (this.mFrame.width() / 4.0f)) + 1.0f;
        float r21 = this.mFrame.bottom - (this.mFrame.height() / 10.0f);
        if (this.mBoltFrame.left == r20) goto L20;
    L25:
        this.mBoltFrame.set(r20, r110, r111, r21);
        this.mBoltPath.reset();
        this.mBoltPath.moveTo(this.mBoltFrame.left + (this.mBoltPoints[0] * this.mBoltFrame.width()), this.mBoltFrame.top + (this.mBoltPoints[1] * this.mBoltFrame.height()));
        int r22 = 2;
    L27:
        if (r22 >= this.mBoltPoints.length) goto L29;
        this.mBoltPath.lineTo(this.mBoltFrame.left + (this.mBoltPoints[r22] * this.mBoltFrame.width()), this.mBoltFrame.top + (this.mBoltPoints[r22 + 1] * this.mBoltFrame.height()));
        r22 = r22 + 2;
        goto L27
    L29:
        this.mBoltPath.lineTo(this.mBoltFrame.left + (this.mBoltPoints[0] * this.mBoltFrame.width()), this.mBoltFrame.top + (this.mBoltPoints[1] * this.mBoltFrame.height()));
    L31:
        if (Math.min(Math.max((this.mBoltFrame.bottom - r16) / (this.mBoltFrame.bottom - this.mBoltFrame.top), 0.0f), 1.0f) > 0.3f) goto L33;
        r23.drawPath(this.mBoltPath, this.mBoltPaint);
    L53:
        if (this.mCharging == false) goto L55;
    L69:
        String r24 = null;
        float r25 = 0.0f;
        float r26 = 0.0f;
    L70:
        r23.drawPath(this.mShapePath, this.mFramePaint);
        this.mFrame.top = r16;
        r23.save();
        r23.clipRect(this.mFrame);
        r23.drawPath(this.mShapePath, this.mBatteryPaint);
        r23.restore();
        if (this.mCharging == true) goto L80;
        if (this.mPowerSaveEnabled == true) goto L80;
        if (r2 > this.mCriticalLevel) goto L77;
        r23.drawText(this.mWarningString, (this.mWidth * 0.5f) + r13, ((this.mHeight + this.mWarningTextHeight) * 0.48f) + r14, this.mWarningTextPaint);
        goto L80
    L77:
        if (r19 == false) goto L80;
        r23.drawText(r24, r25, r26, this.mTextPaint);
    L80:
        if (this.mCharging == false) goto L82;
        return;
    L82:
        if (this.mPowerSaveEnabled == true) goto L84;
        return;
    L84:
        if (this.mPowerSaveAsColorError == false) goto L91;
        r23.drawPath(this.mOutlinePath, this.mPowersavePaint);
        return;
    L91:
        return;
    L55:
        if (this.mPowerSaveEnabled == true) goto L69;
        if (r2 <= this.mCriticalLevel) goto L69;
        if (this.mShowPercent == false) goto L69;
        this.mTextPaint.setColor(getColorForLevel(r2));
        Paint r27 = this.mTextPaint;
        if (this.mLevel != 100) goto L63;
        float r28 = 0.38f;
    L64:
        r27.setTextSize(r9 * r28);
        this.mTextHeight = -this.mTextPaint.getFontMetrics().ascent;
        r24 = String.valueOf(r2);
        r25 = (this.mWidth * 0.5f) + r13;
        r26 = ((this.mHeight + this.mTextHeight) * 0.47f) + r14;
        if (r16 <= r26) goto L67;
        r19 = true;
    L67:
        if (r19 == true) goto L70;
        this.mTextPath.reset();
        this.mTextPaint.getTextPath(r24, 0, r24.length(), r25, r26, this.mTextPath);
        this.mShapePath.op(this.mTextPath, Path.Op.DIFFERENCE);
        goto L70
    L63:
        r28 = 0.5f;
        goto L64
    L33:
        this.mShapePath.op(this.mBoltPath, Path.Op.DIFFERENCE);
        goto L53
    L20:
        if (this.mBoltFrame.top != r110) goto L25;
        if (this.mBoltFrame.right != r111) goto L25;
        if (this.mBoltFrame.bottom == r21) goto L31;
    L35:
        if (this.mPowerSaveEnabled == false) goto L53;
        float r29 = (this.mFrame.width() * 2.0f) / 3.0f;
        float r30 = this.mFrame.left + ((this.mFrame.width() - r29) / 2.0f);
        float r112 = this.mFrame.top + ((this.mFrame.height() - r29) / 2.0f);
        float r113 = this.mFrame.right - ((this.mFrame.width() - r29) / 2.0f);
        float r114 = this.mFrame.bottom - ((this.mFrame.height() - r29) / 2.0f);
        if (this.mPlusFrame.left == r30) goto L39;
    L44:
        this.mPlusFrame.set(r30, r112, r113, r114);
        this.mPlusPath.reset();
        this.mPlusPath.moveTo(this.mPlusFrame.left + (this.mPlusPoints[0] * this.mPlusFrame.width()), this.mPlusFrame.top + (this.mPlusPoints[1] * this.mPlusFrame.height()));
        int r31 = 2;
    L46:
        if (r31 >= this.mPlusPoints.length) goto L48;
        this.mPlusPath.lineTo(this.mPlusFrame.left + (this.mPlusPoints[r31] * this.mPlusFrame.width()), this.mPlusFrame.top + (this.mPlusPoints[r31 + 1] * this.mPlusFrame.height()));
        r31 = r31 + 2;
        goto L46
    L48:
        this.mPlusPath.lineTo(this.mPlusFrame.left + (this.mPlusPoints[0] * this.mPlusFrame.width()), this.mPlusFrame.top + (this.mPlusPoints[1] * this.mPlusFrame.height()));
    L49:
        this.mShapePath.op(this.mPlusPath, Path.Op.DIFFERENCE);
        if (this.mPowerSaveAsColorError == false) goto L53;
        r23.drawPath(this.mPlusPath, this.mPlusPaint);
        goto L53
    L39:
        if (this.mPlusFrame.top != r112) goto L44;
        if (this.mPlusFrame.right != r113) goto L44;
        if (this.mPlusFrame.bottom == r114) goto L49;
    L14:
        r16 = this.mFrame.top + (this.mFrame.height() * (1.0f - r4));
        goto L15
    L9:
        if (r2 > this.mCriticalLevel) goto L12;
        r4 = 0.0f;
        goto L12
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        this.mFramePaint.setColorFilter(r2);
        this.mBatteryPaint.setColorFilter(r2);
        this.mWarningTextPaint.setColorFilter(r2);
        this.mBoltPaint.setColorFilter(r2);
        this.mPlusPaint.setColorFilter(r2);
    }

    public int getCriticalLevel() {
        return this.mCriticalLevel;
    }
}
