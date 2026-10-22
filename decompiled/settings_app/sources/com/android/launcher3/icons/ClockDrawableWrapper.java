package com.android.launcher3.icons;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.util.TypedValue;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.util.function.IntFunction;

/* JADX INFO: loaded from: classes.dex */
public class ClockDrawableWrapper extends AdaptiveIconDrawable implements BitmapInfo.Extender {
    private static final String DEFAULT_HOUR_METADATA_KEY = "com.android.launcher3.DEFAULT_HOUR";
    private static final String DEFAULT_MINUTE_METADATA_KEY = "com.android.launcher3.DEFAULT_MINUTE";
    private static final String DEFAULT_SECOND_METADATA_KEY = "com.android.launcher3.DEFAULT_SECOND";
    private static final boolean DISABLE_SECONDS = true;
    private static final String HOUR_INDEX_METADATA_KEY = "com.android.launcher3.HOUR_LAYER_INDEX";
    public static final int INVALID_VALUE = -1;
    private static final String LAUNCHER_PACKAGE = "com.android.launcher3";
    private static final int LEVELS_PER_SECOND = 10;
    private static final String MINUTE_INDEX_METADATA_KEY = "com.android.launcher3.MINUTE_LAYER_INDEX";
    private static final int NO_COLOR = -1;
    private static final String ROUND_ICON_METADATA_KEY = "com.android.launcher3.LEVEL_PER_TICK_ICON_ROUND";
    private static final String SECOND_INDEX_METADATA_KEY = "com.android.launcher3.SECOND_LAYER_INDEX";
    private static final String TAG = "ClockDrawableWrapper";
    public static final long TICK_MS = 0;
    public static boolean sRunningInTest = false;
    private final AnimationInfo mAnimationInfo;
    private AnimationInfo mThemeInfo;

    /* JADX INFO: renamed from: com.android.launcher3.icons.ClockDrawableWrapper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class AnimationInfo {
        public Drawable.ConstantState baseDrawableState;
        public int defaultHour;
        public int defaultMinute;
        public int defaultSecond;
        public int hourLayerIndex;
        public int minuteLayerIndex;
        public int secondLayerIndex;

        private AnimationInfo() {
        }

        /* synthetic */ AnimationInfo(AnonymousClass1 r1) {
            this();
        }

        public AnimationInfo copyForIcon(Drawable r2) {
            AnimationInfo r0 = new AnimationInfo();
            r0.baseDrawableState = r2.getConstantState();
            r0.defaultHour = this.defaultHour;
            r0.defaultMinute = this.defaultMinute;
            r0.defaultSecond = this.defaultSecond;
            r0.hourLayerIndex = this.hourLayerIndex;
            r0.minuteLayerIndex = this.minuteLayerIndex;
            r0.secondLayerIndex = this.secondLayerIndex;
            return r0;
        }

        boolean applyTime(Calendar r9, LayerDrawable r10) {
            r9.setTimeInMillis(System.currentTimeMillis());
            int r1 = (r9.get(10) + (12 - this.defaultHour)) % 12;
            int r2 = (r9.get(12) + (60 - this.defaultMinute)) % 60;
            int r4 = (r9.get(13) + (60 - this.defaultSecond)) % 60;
            int r5 = this.hourLayerIndex;
            if (r5 != (-1)) goto L5;
        L7:
            boolean r3 = false;
        L8:
            int r6 = this.minuteLayerIndex;
            if (r6 != (-1)) goto L11;
        L13:
            int r8 = this.secondLayerIndex;
            if (r8 == (-1)) goto L19;
            if (r10.getDrawable(r8).setLevel(r4 * 10) == false) goto L19;
            return true;
        L19:
            return r3;
        L11:
            if (r10.getDrawable(r6).setLevel((r9.get(10) * 60) + r2) == false) goto L13;
            r3 = true;
            goto L13
        L5:
            if (r10.getDrawable(r5).setLevel((r1 * 60) + r9.get(12)) == false) goto L7;
            r3 = true;
            goto L8
        }
    }

    static class ClockBitmapInfo extends BitmapInfo {
        public final AnimationInfo animInfo;
        public final float boundsOffset;
        public final Bitmap mFlattenedBackground;
        public final Bitmap themeBackground;
        public final AnimationInfo themeData;

        @Override // com.android.launcher3.icons.BitmapInfo
        public boolean canPersist() {
            return false;
        }

        @Override // com.android.launcher3.icons.BitmapInfo
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo69clone() throws CloneNotSupportedException {
            return clone();
        }

        ClockBitmapInfo(Bitmap r1, int r2, float r3, AnimationInfo r4, Bitmap r5, AnimationInfo r6, Bitmap r7) {
            super(r1, r2);
            this.boundsOffset = Math.max(0.035f, (1.0f - r3) / 2.0f);
            this.animInfo = r4;
            this.mFlattenedBackground = r5;
            this.themeData = r6;
            this.themeBackground = r7;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.android.launcher3.icons.BitmapInfo
        public FastBitmapDrawable newIcon(Context r14, int r15) {
            if ((r15 & 1) != 0) goto L5;
        L7:
            AnimationInfo r1 = this.animInfo;
            Bitmap r3 = this.mFlattenedBackground;
            int r2 = -1;
            BlendModeColorFilter r4 = null;
        L8:
            AnimationInfo r10 = r1;
            int r8 = r2;
            Bitmap r11 = r3;
            BlendModeColorFilter r12 = r4;
            if (r10 == null) goto L11;
            FastBitmapDrawable r0 = new ClockIconDrawable.ClockConstantState(this.icon, this.color, r8, this.boundsOffset, r10, r11, r12).newDrawable();
            applyFlags(r14, r0, r15);
            return r0;
        L11:
            return super.newIcon(r14, r15);
        L5:
            if (this.themeData == null) goto L7;
            int[] r5 = ThemedIconDrawable.getColors(r14);
            Drawable r6 = this.themeData.baseDrawableState.newDrawable().mutate();
            r2 = r5[1];
            r6.setTint(r2);
            r1 = this.themeData.copyForIcon(r6);
            r3 = this.themeBackground;
            r4 = new BlendModeColorFilter(r5[0], BlendMode.SRC_IN);
            goto L8
        }

        @Override // com.android.launcher3.icons.BitmapInfo
        public BitmapInfo clone() {
            return copyInternalsTo(new ClockBitmapInfo(this.icon, this.color, 1.0f - (this.boundsOffset * 2.0f), this.animInfo, this.mFlattenedBackground, this.themeData, this.themeBackground));
        }
    }

    private static class ClockIconDrawable extends FastBitmapDrawable implements Runnable {
        private final AnimationInfo mAnimInfo;
        private final Bitmap mBG;
        private final ColorFilter mBgFilter;
        private final Paint mBgPaint;
        private final float mBoundsOffset;
        private final float mCanvasScale;
        private final LayerDrawable mFG;
        private final AdaptiveIconDrawable mFullDrawable;
        private final int mThemedFgColor;
        private final Calendar mTime;

        private static class ClockConstantState extends FastBitmapDrawable.FastBitmapConstantState {
            private final AnimationInfo mAnimInfo;
            private final Bitmap mBG;
            private final ColorFilter mBgFilter;
            private final float mBoundsOffset;
            private final int mThemedFgColor;

            static /* synthetic */ float access$100(ClockConstantState r0) {
                return r0.mBoundsOffset;
            }

            static /* synthetic */ AnimationInfo access$200(ClockConstantState r0) {
                return r0.mAnimInfo;
            }

            static /* synthetic */ Bitmap access$300(ClockConstantState r0) {
                return r0.mBG;
            }

            static /* synthetic */ ColorFilter access$400(ClockConstantState r0) {
                return r0.mBgFilter;
            }

            static /* synthetic */ int access$500(ClockConstantState r0) {
                return r0.mThemedFgColor;
            }

            ClockConstantState(Bitmap r1, int r2, int r3, float r4, AnimationInfo r5, Bitmap r6, ColorFilter r7) {
                super(r1, r2);
                this.mBoundsOffset = r4;
                this.mAnimInfo = r5;
                this.mBG = r6;
                this.mBgFilter = r7;
                this.mThemedFgColor = r3;
            }

            @Override // com.android.launcher3.icons.FastBitmapDrawable.FastBitmapConstantState
            public FastBitmapDrawable createDrawable() {
                return new ClockIconDrawable(this);
            }
        }

        ClockIconDrawable(ClockConstantState r6) {
            super(r6.mBitmap, r6.mIconColor);
            Calendar r0 = Calendar.getInstance();
            this.mTime = r0;
            Paint r1 = new Paint(3);
            this.mBgPaint = r1;
            float r2 = ClockConstantState.access$100(r6);
            this.mBoundsOffset = r2;
            AnimationInfo r3 = ClockConstantState.access$200(r6);
            this.mAnimInfo = r3;
            this.mBG = ClockConstantState.access$300(r6);
            this.mBgFilter = ClockConstantState.access$400(r6);
            r1.setColorFilter(ClockConstantState.access$400(r6));
            this.mThemedFgColor = ClockConstantState.access$500(r6);
            AdaptiveIconDrawable r7 = (AdaptiveIconDrawable) r3.baseDrawableState.newDrawable().mutate();
            this.mFullDrawable = r7;
            LayerDrawable r8 = (LayerDrawable) r7.getForeground();
            this.mFG = r8;
            r3.applyTime(r0, r8);
            this.mCanvasScale = 1.0f - (r2 * 2.0f);
        }

        @Override // com.android.launcher3.icons.FastBitmapDrawable, android.graphics.drawable.Drawable
        public void setAlpha(int r2) {
            super.setAlpha(r2);
            this.mBgPaint.setAlpha(r2);
            this.mFG.setAlpha(r2);
        }

        @Override // com.android.launcher3.icons.FastBitmapDrawable, android.graphics.drawable.Drawable
        protected void onBoundsChange(Rect r3) {
            super.onBoundsChange(r3);
            this.mFullDrawable.setBounds(0, 0, r3.width(), r3.height());
        }

        @Override // com.android.launcher3.icons.FastBitmapDrawable
        public void drawInternal(Canvas r4, Rect r5) {
            if (this.mAnimInfo != null) goto L6;
            super.drawInternal(r4, r5);
            return;
        L6:
            r4.drawBitmap(this.mBG, null, r5, this.mBgPaint);
            this.mAnimInfo.applyTime(this.mTime, this.mFG);
            int r0 = r4.save();
            r4.translate(r5.left, r5.top);
            float r1 = this.mCanvasScale;
            r4.scale(r1, r1, r5.width() / 2, r5.height() / 2);
            r4.clipPath(this.mFullDrawable.getIconMask());
            this.mFG.draw(r4);
            r4.restoreToCount(r0);
            reschedule();
        }

        @Override // com.android.launcher3.icons.FastBitmapDrawable
        public boolean isThemed() {
            if (this.mBgPaint.getColorFilter() == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.android.launcher3.icons.FastBitmapDrawable
        protected void updateFilter() {
            super.updateFilter();
            if (this.mIsDisabled == false) goto L5;
            int r0 = (int) (this.mDisabledAlpha * 255.0f);
        L6:
            setAlpha(r0);
            Paint r1 = this.mBgPaint;
            if (this.mIsDisabled == false) goto L9;
            ColorFilter r2 = getDisabledColorFilter();
        L10:
            r1.setColorFilter(r2);
            LayerDrawable r3 = this.mFG;
            if (this.mIsDisabled == false) goto L13;
            ColorFilter r4 = getDisabledColorFilter();
        L14:
            r3.setColorFilter(r4);
            return;
        L13:
            r4 = null;
            goto L14
        L9:
            r2 = this.mBgFilter;
            goto L10
        L5:
            r0 = 255;
            goto L6
        }

        @Override // com.android.launcher3.icons.FastBitmapDrawable
        public int getIconColor() {
            if (isThemed() == false) goto L6;
            return this.mThemedFgColor;
        L6:
            return super.getIconColor();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mAnimInfo.applyTime(this.mTime, this.mFG) == false) goto L5;
            invalidateSelf();
            return;
        L5:
            reschedule();
        }

        @Override // android.graphics.drawable.Drawable
        public boolean setVisible(boolean r1, boolean r2) {
            boolean r3 = super.setVisible(r1, r2);
            if (r1 == false) goto L5;
            reschedule();
        L6:
            return r3;
        L5:
            unscheduleSelf(this);
            goto L6
        }

        private void reschedule() {
            if (isVisible() == true) goto L5;
            return;
        L5:
            unscheduleSelf(this);
            long r0 = SystemClock.uptimeMillis();
            long r2 = ClockDrawableWrapper.TICK_MS;
            scheduleSelf(this, (r0 - (r0 % r2)) + r2);
        }

        @Override // com.android.launcher3.icons.FastBitmapDrawable
        public FastBitmapDrawable.FastBitmapConstantState newConstantState() {
            return new ClockConstantState(this.mBitmap, this.mIconColor, this.mThemedFgColor, this.mBoundsOffset, this.mAnimInfo, this.mBG, this.mBgPaint.getColorFilter());
        }
    }

    @Override // com.android.launcher3.icons.BitmapInfo.Extender
    public /* bridge */ /* synthetic */ BitmapInfo getExtendedInfo(Bitmap r1, int r2, BaseIconFactory r3, float r4) {
        return getExtendedInfo(r1, r2, r3, r4);
    }

    static {
        TICK_MS = TimeUnit.MINUTES.toMillis(1);
    }

    private ClockDrawableWrapper(AdaptiveIconDrawable r2) {
        super(r2.getBackground(), r2.getForeground());
        this.mAnimationInfo = new AnimationInfo(null);
        this.mThemeInfo = null;
    }

    private void applyThemeData(final IconProvider.ThemeData r9) {
        if (IconProvider.ATLEAST_T == true) goto L5;
        return;
    L5:
        if (this.mThemeInfo != null) goto L30;
        TypedArray r0 = r9.mResources.obtainTypedArray(r9.mResID);     // Catch: Exception -> L20
        int r1 = r0.length();     // Catch: Exception -> L20
        Bundle r2 = new Bundle();     // Catch: Exception -> L20
        int r3 = 0;
    L8:
        if (r3 >= r1) goto L16;
        TypedValue r4 = r0.peekValue(r3 + 1);     // Catch: Exception -> L20
        String r5 = r0.getString(r3);     // Catch: Exception -> L20
        if (r4.type >= 16) goto L12;
    L14:
        int r6 = r4.resourceId;     // Catch: Exception -> L20
    L15:
        r2.putInt(r5, r6);     // Catch: Exception -> L20
        r3 = r3 + 2;     // Catch: Exception -> L20
        goto L8
    L12:
        if (r4.type > 31) goto L14;
        r6 = r4.data;     // Catch: Exception -> L20
        goto L15
    L16:
        r0.recycle();     // Catch: Exception -> L20
        ClockDrawableWrapper r10 = forExtras(r2, new ClockDrawableWrapper$$ExternalSyntheticLambda0(r9));     // Catch: Exception -> L20
        if (r10 == null) goto L29;
        this.mThemeInfo = r10.mAnimationInfo;     // Catch: Exception -> L20
        return;
    L29:
        return;
    L20:
        e = move-exception;
        Log.e(TAG, "Error loading themed clock", e);
        return;
    }

    static /* synthetic */ Drawable lambda$applyThemeData$0(IconProvider.ThemeData r2, int r3) {
        return new AdaptiveIconDrawable(new ColorDrawable(-1), r2.mResources.getDrawable(r3).mutate());
    }

    @Override // android.graphics.drawable.AdaptiveIconDrawable
    public Drawable getMonochrome() {
        AnimationInfo r0 = this.mThemeInfo;
        if (r0 != null) goto L5;
        return null;
    L5:
        Drawable r1 = r0.baseDrawableState.newDrawable().mutate();
        if ((r1 instanceof AdaptiveIconDrawable) == false) goto L9;
        Drawable r2 = ((AdaptiveIconDrawable) r1).getForeground();
        this.mThemeInfo.applyTime(Calendar.getInstance(), (LayerDrawable) r2);
        return r2;
    L9:
        return null;
    }

    public static ClockDrawableWrapper forPackage(Context r1, String r2, final int r3, IconProvider.ThemeData r4) {
        PackageManager r5 = r1.getPackageManager();     // Catch: Exception -> L7
        ApplicationInfo r6 = r5.getApplicationInfo(r2, 8320);     // Catch: Exception -> L7
        final Resources r7 = r5.getResourcesForApplication(r6);     // Catch: Exception -> L7
        ClockDrawableWrapper r8 = forExtras(r6.metaData, new ClockDrawableWrapper$$ExternalSyntheticLambda1(r7, r3));     // Catch: Exception -> L7
        if (r8 == null) goto L6;
        if (r4 == null) goto L6;
        r8.applyThemeData(r4);     // Catch: Exception -> L7
    L6:
        return r8;
    L7:
        e = move-exception;
        Log.d(TAG, "Unable to load clock drawable info", e);
        return null;
    }

    static /* synthetic */ Drawable lambda$forPackage$1(Resources r0, int r1, int r2) {
        return r0.getDrawableForDensity(r2, r1);
    }

    private static ClockDrawableWrapper forExtras(Bundle r6, IntFunction<Drawable> r7) {
        if (r6 != null) goto L5;
        return null;
    L5:
        int r1 = r6.getInt(ROUND_ICON_METADATA_KEY, 0);
        if (r1 != 0) goto L8;
        return null;
    L8:
        Drawable r8 = r7.apply(r1).mutate();
        if ((r8 instanceof AdaptiveIconDrawable) == true) goto L11;
        return null;
    L11:
        AdaptiveIconDrawable r2 = (AdaptiveIconDrawable) r8;
        ClockDrawableWrapper r3 = new ClockDrawableWrapper(r2);
        AnimationInfo r4 = r3.mAnimationInfo;
        r4.baseDrawableState = r8.getConstantState();
        r4.hourLayerIndex = r6.getInt(HOUR_INDEX_METADATA_KEY, -1);
        r4.minuteLayerIndex = r6.getInt(MINUTE_INDEX_METADATA_KEY, -1);
        r4.secondLayerIndex = r6.getInt(SECOND_INDEX_METADATA_KEY, -1);
        r4.defaultHour = r6.getInt(DEFAULT_HOUR_METADATA_KEY, 0);
        r4.defaultMinute = r6.getInt(DEFAULT_MINUTE_METADATA_KEY, 0);
        r4.defaultSecond = r6.getInt(DEFAULT_SECOND_METADATA_KEY, 0);
        LayerDrawable r9 = (LayerDrawable) r3.getForeground();
        int r10 = r9.getNumberOfLayers();
        if (r4.hourLayerIndex >= 0) goto L14;
    L15:
        r4.hourLayerIndex = -1;
    L17:
        if (r4.minuteLayerIndex >= 0) goto L19;
    L20:
        r4.minuteLayerIndex = -1;
    L22:
        if (r4.secondLayerIndex >= 0) goto L24;
    L27:
        r4.secondLayerIndex = -1;
    L29:
        if (IconProvider.ATLEAST_T == true) goto L31;
    L33:
        r4.applyTime(Calendar.getInstance(), r9);
        return r3;
    L31:
        if ((r2.getMonochrome() instanceof LayerDrawable) == false) goto L33;
        r3.mThemeInfo = r4.copyForIcon(new AdaptiveIconDrawable(new ColorDrawable(-1), r2.getMonochrome().mutate()));
        goto L33
    L24:
        if (r4.secondLayerIndex >= r10) goto L27;
        r9.setDrawable(r4.secondLayerIndex, null);
        r4.secondLayerIndex = -1;
        goto L29
    L19:
        if (r4.minuteLayerIndex < r10) goto L22;
    L14:
        if (r4.hourLayerIndex < r10) goto L17;
        goto L15
    }

    @Override // com.android.launcher3.icons.BitmapInfo.Extender
    public ClockBitmapInfo getExtendedInfo(Bitmap r12, int r13, BaseIconFactory r14, float r15) {
        Bitmap r2 = null;
        Bitmap r8 = r14.createScaledBitmap(new AdaptiveIconDrawable(getBackground().getConstantState().newDrawable(), null), 4);
        if (r14.mMonoIconEnabled == false) goto L5;
        AnimationInfo r9 = this.mThemeInfo;
    L6:
        if (r9 == null) goto L10;
        r2 = r14.getWhiteShadowLayer();
    L10:
        return new ClockBitmapInfo(r12, r13, r15, this.mAnimationInfo, r8, r9, r2);
    L5:
        r9 = null;
        goto L6
    }

    @Override // com.android.launcher3.icons.BitmapInfo.Extender
    public void drawForPersistence(Canvas r3) {
        LayerDrawable r0 = (LayerDrawable) getForeground();
        resetLevel(r0, this.mAnimationInfo.hourLayerIndex);
        resetLevel(r0, this.mAnimationInfo.minuteLayerIndex);
        resetLevel(r0, this.mAnimationInfo.secondLayerIndex);
        draw(r3);
        this.mAnimationInfo.applyTime(Calendar.getInstance(), (LayerDrawable) getForeground());
    }

    private void resetLevel(LayerDrawable r1, int r2) {
        if (r2 == (-1)) goto L6;
        r1.getDrawable(r2).setLevel(0);
        return;
    }
}
