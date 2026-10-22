package com.github.mikephil.charting.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.keva.KevaImpl;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import java.util.List;
import tmsdk.common.tcc.DeepCleanSAFEngine;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Utils {
    public static final double DEG2RAD = 0.017453292519943295d;
    public static final double DOUBLE_EPSILON = 0.0d;
    public static final float FDEG2RAD = 0.017453292f;
    public static final float FLOAT_EPSILON = 0.0f;
    private static final int[] POW_10 = null;
    private static Rect mCalcTextHeightRect = null;
    private static Rect mCalcTextSizeRect = null;
    private static ValueFormatter mDefaultValueFormatter = null;
    private static Rect mDrawTextRectBuffer = null;
    private static Rect mDrawableBoundsCache = null;
    private static Paint.FontMetrics mFontMetrics = null;
    private static Paint.FontMetrics mFontMetricsBuffer = null;
    private static int mMaximumFlingVelocity = 8000;
    private static DisplayMetrics mMetrics = null;
    private static int mMinimumFlingVelocity = 50;

    public static float getNormalizedAngle(float r2) {
    L3:
        if (r2 >= 0.0f) goto L6;
        r2 = r2 + 360.0f;
        goto L3
    L6:
        return r2 % 360.0f;
    }

    public Utils() {
    }

    static {
        DOUBLE_EPSILON = Double.longBitsToDouble(1);
        FLOAT_EPSILON = Float.intBitsToFloat(1);
        mCalcTextHeightRect = new Rect();
        mFontMetrics = new Paint.FontMetrics();
        mCalcTextSizeRect = new Rect();
        POW_10 = new int[]{1, 10, 100, 1000, KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD, 100000, 1000000, 10000000, 100000000, 1000000000};
        mDefaultValueFormatter = generateDefaultValueFormatter();
        mDrawableBoundsCache = new Rect();
        mDrawTextRectBuffer = new Rect();
        mFontMetricsBuffer = new Paint.FontMetrics();
    }

    public static void init(Context r2) {
        if (r2 != null) goto L4;
        mMinimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
        mMaximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
        Log.e("MPChartLib-Utils", "Utils.init(...) PROVIDED CONTEXT OBJECT IS NULL");
        return;
    L4:
        ViewConfiguration r0 = ViewConfiguration.get(r2);
        mMinimumFlingVelocity = r0.getScaledMinimumFlingVelocity();
        mMaximumFlingVelocity = r0.getScaledMaximumFlingVelocity();
        mMetrics = r2.getResources().getDisplayMetrics();
    }

    @Deprecated
    public static void init(Resources r0) {
        mMetrics = r0.getDisplayMetrics();
        mMinimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
        mMaximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
    }

    public static float convertDpToPixel(float r2) {
        DisplayMetrics r0 = mMetrics;
        if (r0 != null) goto L7;
        Log.e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertDpToPixel(...). Otherwise conversion does not take place.");
        return r2;
    L7:
        return r2 * r0.density;
    }

    public static float convertPixelsToDp(float r2) {
        DisplayMetrics r0 = mMetrics;
        if (r0 != null) goto L7;
        Log.e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertPixelsToDp(...). Otherwise conversion does not take place.");
        return r2;
    L7:
        return r2 / r0.density;
    }

    public static int calcTextWidth(Paint r0, String r1) {
        return (int) r0.measureText(r1);
    }

    public static int calcTextHeight(Paint r3, String r4) {
        Rect r0 = mCalcTextHeightRect;
        r0.set(0, 0, 0, 0);
        r3.getTextBounds(r4, 0, r4.length(), r0);
        return r0.height();
    }

    public static float getLineHeight(Paint r1) {
        return getLineHeight(r1, mFontMetrics);
    }

    public static float getLineHeight(Paint r0, Paint.FontMetrics r1) {
        r0.getFontMetrics(r1);
        return r1.descent - r1.ascent;
    }

    public static float getLineSpacing(Paint r1) {
        return getLineSpacing(r1, mFontMetrics);
    }

    public static float getLineSpacing(Paint r1, Paint.FontMetrics r2) {
        r1.getFontMetrics(r2);
        return (r2.ascent - r2.top) + r2.bottom;
    }

    public static FSize calcTextSize(Paint r1, String r2) {
        FSize r0 = FSize.getInstance(0.0f, 0.0f);
        calcTextSize(r1, r2, r0);
        return r0;
    }

    public static void calcTextSize(Paint r3, String r4, FSize r5) {
        Rect r0 = mCalcTextSizeRect;
        r0.set(0, 0, 0, 0);
        r3.getTextBounds(r4, 0, r4.length(), r0);
        r5.width = r0.width();
        r5.height = r0.height();
    }

    private static ValueFormatter generateDefaultValueFormatter() {
        return new DefaultValueFormatter(1);
    }

    public static ValueFormatter getDefaultValueFormatter() {
        return mDefaultValueFormatter;
    }

    public static String formatNumber(float r1, int r2, boolean r3) {
        return formatNumber(r1, r2, r3, '.');
    }

    public static String formatNumber(float r17, int r18, boolean r19, char r20) {
        float r0 = r17;
        char[] r2 = new char[35];
        if (r0 != 0.0f) goto L6;
        return "0";
    L6:
        int r6 = 0;
        if (r0 < 1.0f) goto L9;
    L11:
        boolean r4 = false;
    L13:
        if (r0 >= 0.0f) goto L15;
        r0 = -r0;
        boolean r3 = true;
    L16:
        int[] r7 = POW_10;
        if (r18 <= r7.length) goto L19;
        int r8 = r7.length - 1;
    L20:
        long r9 = Math.round(r0 * r7[r8]);
        int r1 = 34;
        boolean r10 = false;
    L22:
        if (r9 == 0) goto L24;
    L32:
        int r11 = (int) (r9 % 10);
        r9 = r9 / 10;
        int r12 = r1 - 1;
        r2[r1] = (char) (r11 + 48);
        r6 = r6 + 1;
        if (r6 == r8) goto L34;
        if (r19 == false) goto L47;
        if (r9 == 0) goto L47;
        if (r6 <= r8) goto L47;
        if (r10 == false) goto L44;
        if (((r6 - r8) % 4) != 0) goto L47;
        r1 = r12 - 1;
        r2[r12] = r20;
    L46:
        r6 = r6 + 1;
        goto L22
    L44:
        if (((r6 - r8) % 4) != 3) goto L47;
        r1 = r12 - 1;
        r2[r12] = r20;
    L47:
        r1 = r12;
        goto L22
    L34:
        r1 = r12 - 1;
        r2[r12] = ',';
        r6 = r6 + 1;
        r10 = true;
        goto L22
    L24:
        if (r6 < (r8 + 1)) goto L32;
        if (r4 == false) goto L28;
        r2[r1] = DeepCleanSAFEngine.DetailPath.KEY;
        r6 = r6 + 1;
        r1 = r1 - 1;
    L28:
        if (r3 == false) goto L30;
        r2[r1] = '-';
        r6 = r6 + 1;
    L30:
        int r5 = 35 - r6;
        return String.valueOf(r2, r5, 35 - r5);
    L19:
        r8 = r18;
        goto L20
    L15:
        r3 = false;
        goto L16
    L9:
        if (r0 <= (-1.0f)) goto L11;
        r4 = true;
        goto L13
    }

    public static float roundToNextSignificant(double r5) {
        if (Double.isInfinite(r5) == false) goto L5;
        return 0.0f;
    L5:
        if (Double.isNaN(r5) == false) goto L7;
        return 0.0f;
    L7:
        if (r5 != 0.0d) goto L10;
        return 0.0f;
    L10:
        if (r5 >= 0.0d) goto L12;
        double r0 = -r5;
    L13:
        float r1 = (float) Math.pow(10.0d, 1 - ((int) Math.ceil((float) Math.log10(r0))));
        return Math.round(r5 * ((double) r1)) / r1;
    L12:
        r0 = r5;
        goto L13
    }

    public static int getDecimals(float r2) {
        float r3 = roundToNextSignificant(r2);
        if (Float.isInfinite(r3) == false) goto L7;
        return 0;
    L7:
        return ((int) Math.ceil(-Math.log10(r3))) + 2;
    }

    public static int[] convertIntegers(List<Integer> r1) {
        int[] r0 = new int[r1.size()];
        copyIntegers(r1, r0);
        return r0;
    }

    public static void copyIntegers(List<Integer> r3, int[] r4) {
        if (r4.length >= r3.size()) goto L5;
        int r0 = r4.length;
    L6:
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L9;
        r4[r1] = r3.get(r1).intValue();
        r1 = r1 + 1;
        goto L7
    L9:
        return;
    L5:
        r0 = r3.size();
        goto L6
    }

    public static String[] convertStrings(List<String> r4) {
        int r0 = r4.size();
        String[] r1 = new String[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = r4.get(r2);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public static void copyStrings(List<String> r3, String[] r4) {
        if (r4.length >= r3.size()) goto L5;
        int r0 = r4.length;
    L6:
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L9;
        r4[r1] = r3.get(r1);
        r1 = r1 + 1;
        goto L7
    L9:
        return;
    L5:
        r0 = r3.size();
        goto L6
    }

    public static double nextUp(double r4) {
        if (r4 != Double.POSITIVE_INFINITY) goto L5;
        return r4;
    L5:
        double r5 = r4 + 0.0d;
        long r2 = Double.doubleToRawLongBits(r5);
        if (r5 < 0.0d) goto L8;
        long r6 = 1;
    L10:
        return Double.longBitsToDouble(r2 + r6);
    L8:
        r6 = -1;
        goto L10
    }

    public static MPPointF getPosition(MPPointF r1, float r2, float r3) {
        MPPointF r0 = MPPointF.getInstance(0.0f, 0.0f);
        getPosition(r1, r2, r3, r0);
        return r0;
    }

    public static void getPosition(MPPointF r6, float r7, float r8, MPPointF r9) {
        double r2 = r7;
        double r10 = r8;
        r9.x = (float) (((double) r6.x) + (Math.cos(Math.toRadians(r10)) * r2));
        r9.y = (float) (((double) r6.y) + (r2 * Math.sin(Math.toRadians(r10))));
    }

    public static void velocityTrackerPointerUpCleanUpIfNecessary(MotionEvent r7, VelocityTracker r8) {
        r8.computeCurrentVelocity(1000, mMaximumFlingVelocity);
        int r0 = r7.getActionIndex();
        int r1 = r7.getPointerId(r0);
        float r2 = r8.getXVelocity(r1);
        float r3 = r8.getYVelocity(r1);
        int r4 = r7.getPointerCount();
        int r5 = 0;
    L3:
        if (r5 >= r4) goto L15;
        if (r5 == r0) goto L9;
        int r6 = r7.getPointerId(r5);
        if (((r8.getXVelocity(r6) * r2) + (r8.getYVelocity(r6) * r3)) >= 0.0f) goto L9;
        r8.clear();
        return;
    L9:
        r5 = r5 + 1;
        goto L3
    }

    public static void postInvalidateOnAnimation(View r0) {
        r0.postInvalidateOnAnimation();
    }

    public static int getMinimumFlingVelocity() {
        return mMinimumFlingVelocity;
    }

    public static int getMaximumFlingVelocity() {
        return mMaximumFlingVelocity;
    }

    public static void drawImage(Canvas r2, Drawable r3, int r4, int r5, int r6, int r7) {
        MPPointF r0 = MPPointF.getInstance();
        r0.x = r4 - (r6 / 2);
        r0.y = r5 - (r7 / 2);
        r3.copyBounds(mDrawableBoundsCache);
        r3.setBounds(mDrawableBoundsCache.left, mDrawableBoundsCache.top, mDrawableBoundsCache.left + r6, mDrawableBoundsCache.top + r6);
        int r8 = r2.save();
        r2.translate(r0.x, r0.y);
        r3.draw(r2);
        r2.restoreToCount(r8);
    }

    public static void drawXAxisValue(Canvas r7, String r8, float r9, float r10, Paint r11, MPPointF r12, float r13) {
        float r0 = r11.getFontMetrics(mFontMetricsBuffer);
        r11.getTextBounds(r8, 0, r8.length(), mDrawTextRectBuffer);
        float r1 = 0.0f - mDrawTextRectBuffer.left;
        float r3 = (-mFontMetricsBuffer.ascent) + 0.0f;
        Paint.Align r4 = r11.getTextAlign();
        r11.setTextAlign(Paint.Align.LEFT);
        if (r13 == 0.0f) goto L11;
        float r2 = r1 - (mDrawTextRectBuffer.width() * 0.5f);
        float r5 = r3 - (r0 * 0.5f);
        if (r12.x == 0.5f) goto L7;
    L8:
        FSize r6 = getSizeOfRotatedRectangleByDegrees(mDrawTextRectBuffer.width(), r0, r13);
        r9 = r9 - (r6.width * (r12.x - 0.5f));
        r10 = r10 - (r6.height * (r12.y - 0.5f));
        FSize.recycleInstance(r6);
    L9:
        r7.save();
        r7.translate(r9, r10);
        r7.rotate(r13);
        r7.drawText(r8, r2, r5, r11);
        r7.restore();
    L16:
        r11.setTextAlign(r4);
        return;
    L7:
        if (r12.y == 0.5f) goto L9;
    L11:
        if (r12.x == 0.0f) goto L13;
    L14:
        r1 = r1 - (mDrawTextRectBuffer.width() * r12.x);
        r3 = r3 - (r0 * r12.y);
    L15:
        r7.drawText(r8, r1 + r9, r3 + r10, r11);
        goto L16
    L13:
        if (r12.y == 0.0f) goto L15;
        goto L14
    }

    public static void drawMultilineText(Canvas r7, StaticLayout r8, float r9, float r10, TextPaint r11, MPPointF r12, float r13) {
        float r0 = r11.getFontMetrics(mFontMetricsBuffer);
        float r1 = r8.getWidth();
        float r2 = r8.getLineCount() * r0;
        float r3 = 0.0f - mDrawTextRectBuffer.left;
        float r4 = r2 + 0.0f;
        Paint.Align r5 = r11.getTextAlign();
        r11.setTextAlign(Paint.Align.LEFT);
        if (r13 == 0.0f) goto L11;
        float r6 = r3 - (r1 * 0.5f);
        float r14 = r4 - (r2 * 0.5f);
        if (r12.x == 0.5f) goto L7;
    L8:
        FSize r15 = getSizeOfRotatedRectangleByDegrees(r1, r2, r13);
        r9 = r9 - (r15.width * (r12.x - 0.5f));
        r10 = r10 - (r15.height * (r12.y - 0.5f));
        FSize.recycleInstance(r15);
    L9:
        r7.save();
        r7.translate(r9, r10);
        r7.rotate(r13);
        r7.translate(r6, r14);
        r8.draw(r7);
        r7.restore();
    L16:
        r11.setTextAlign(r5);
        return;
    L7:
        if (r12.y == 0.5f) goto L9;
    L11:
        if (r12.x == 0.0f) goto L13;
    L14:
        r3 = r3 - (r1 * r12.x);
        r4 = r4 - (r2 * r12.y);
    L15:
        r7.save();
        r7.translate(r3 + r9, r4 + r10);
        r8.draw(r7);
        r7.restore();
        goto L16
    L13:
        if (r12.y == 0.0f) goto L15;
        goto L14
    }

    public static void drawMultilineText(Canvas r11, String r12, float r13, float r14, TextPaint r15, FSize r16, MPPointF r17, float r18) {
        drawMultilineText(r11, new StaticLayout(r12, 0, r12.length(), r15, (int) Math.max(Math.ceil(r16.width), 1.0d), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false), r13, r14, r15, r17, r18);
    }

    public static FSize getSizeOfRotatedRectangleByDegrees(FSize r1, float r2) {
        float r0 = r1.width;
        float r3 = r1.height;
        return getSizeOfRotatedRectangleByRadians(r0, r3, r2 * 0.017453292f);
    }

    public static FSize getSizeOfRotatedRectangleByRadians(FSize r1, float r2) {
        return getSizeOfRotatedRectangleByRadians(r1.width, r1.height, r2);
    }

    public static FSize getSizeOfRotatedRectangleByDegrees(float r1, float r2, float r3) {
        return getSizeOfRotatedRectangleByRadians(r1, r2, r3 * 0.017453292f);
    }

    public static FSize getSizeOfRotatedRectangleByRadians(float r4, float r5, float r6) {
        double r0 = r6;
        return FSize.getInstance(Math.abs(((float) Math.cos(r0)) * r4) + Math.abs(((float) Math.sin(r0)) * r5), Math.abs(r4 * ((float) Math.sin(r0))) + Math.abs(r5 * ((float) Math.cos(r0))));
    }

    public static int getSDKInt() {
        return Build.VERSION.SDK_INT;
    }
}
