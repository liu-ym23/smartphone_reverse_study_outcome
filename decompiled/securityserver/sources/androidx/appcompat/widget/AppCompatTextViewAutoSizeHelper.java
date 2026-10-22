package androidx.appcompat.widget;

import a.a;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
class AppCompatTextViewAutoSizeHelper {
    private static final int DEFAULT_AUTO_SIZE_GRANULARITY_IN_PX = 1;
    private static final int DEFAULT_AUTO_SIZE_MAX_TEXT_SIZE_IN_SP = 112;
    private static final int DEFAULT_AUTO_SIZE_MIN_TEXT_SIZE_IN_SP = 12;
    private static final String TAG = "ACTVAutoSizeHelper";
    private static final RectF TEMP_RECTF = null;
    static final float UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE = -1.0f;
    private static final int VERY_WIDE = 1048576;
    private static ConcurrentHashMap<String, Field> sTextViewFieldByNameCache;
    private static ConcurrentHashMap<String, Method> sTextViewMethodByNameCache;
    private float mAutoSizeMaxTextSizeInPx;
    private float mAutoSizeMinTextSizeInPx;
    private float mAutoSizeStepGranularityInPx;
    private int[] mAutoSizeTextSizesInPx;
    private int mAutoSizeTextType;
    private final Context mContext;
    private boolean mHasPresetAutoSizeValues;
    private final Impl mImpl;
    private boolean mNeedsAutoSizeText;
    private TextPaint mTempTextPaint;

    @NonNull
    private final TextView mTextView;

    public static class Impl {
        public Impl() {
        }

        public void computeAndSetTextDirection(StaticLayout.Builder r1, TextView r2) {
        }

        public boolean isHorizontallyScrollable(TextView r2) {
            return ((Boolean) AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(r2, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    @RequiresApi(23)
    public static class Impl23 extends Impl {
        public Impl23() {
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        public void computeAndSetTextDirection(StaticLayout.Builder r2, TextView r3) {
            r2.setTextDirection((TextDirectionHeuristic) AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(r3, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    @RequiresApi(29)
    public static class Impl29 extends Impl23 {
        public Impl29() {
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl23, androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        public void computeAndSetTextDirection(StaticLayout.Builder r1, TextView r2) {
            r1.setTextDirection(r2.getTextDirectionHeuristic());
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        public boolean isHorizontallyScrollable(TextView r1) {
            return r1.isHorizontallyScrollable();
        }
    }

    static {
        TEMP_RECTF = new RectF();
        sTextViewMethodByNameCache = new ConcurrentHashMap();
        sTextViewFieldByNameCache = new ConcurrentHashMap();
    }

    public AppCompatTextViewAutoSizeHelper(@NonNull TextView r3) {
        this.mAutoSizeTextType = 0;
        this.mNeedsAutoSizeText = false;
        this.mAutoSizeStepGranularityInPx = UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE;
        this.mAutoSizeMinTextSizeInPx = UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE;
        this.mAutoSizeMaxTextSizeInPx = UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE;
        this.mAutoSizeTextSizesInPx = new int[0];
        this.mHasPresetAutoSizeValues = false;
        this.mTextView = r3;
        this.mContext = r3.getContext();
        this.mImpl = new Impl29();
    }

    private static <T> T accessAndReturnWithDefault(@NonNull Object r2, @NonNull String r3, @NonNull T r4) {
        Field r0 = getTextViewField(r3);     // Catch: IllegalAccessException -> L7
        if (r0 != null) goto L5;
        return r4;
    L5:
        return (T) r0.get(r2);
    L7:
        e = move-exception;
        Log.w(TAG, "Failed to access TextView#" + r3 + " member", e);
        return r4;
    }

    private int[] cleanupAutoSizePresetSizes(int[] r6) {
        int r5 = r6.length;
        if (r5 != 0) goto L5;
        return r6;
    L5:
        Arrays.sort(r6);
        ArrayList r0 = new ArrayList();
        int r1 = 0;
        int r2 = 0;
    L6:
        if (r2 >= r5) goto L14;
        int r3 = r6[r2];
        if (r3 <= 0) goto L12;
        if (Collections.binarySearch(r0, Integer.valueOf(r3)) >= 0) goto L12;
        r0.add(Integer.valueOf(r3));
    L12:
        r2 = r2 + 1;
        goto L6
    L14:
        if (r5 != r0.size()) goto L16;
        return r6;
    L16:
        int r7 = r0.size();
        int[] r8 = new int[r7];
    L17:
        if (r1 >= r7) goto L19;
        r8[r1] = ((Integer) r0.get(r1)).intValue();
        r1 = r1 + 1;
        goto L17
    L19:
        return r8;
    }

    private void clearAutoSizeConfiguration() {
        this.mAutoSizeTextType = 0;
        this.mAutoSizeMinTextSizeInPx = UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE;
        this.mAutoSizeMaxTextSizeInPx = UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE;
        this.mAutoSizeStepGranularityInPx = UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE;
        this.mAutoSizeTextSizesInPx = new int[0];
        this.mNeedsAutoSizeText = false;
    }

    @RequiresApi(23)
    private StaticLayout createStaticLayoutForMeasuring(CharSequence r4, Layout.Alignment r5, int r6, int r7) {
        StaticLayout.Builder r8 = StaticLayout.Builder.obtain(r4, 0, r4.length(), this.mTempTextPaint, r6);
        StaticLayout.Builder r9 = r8.setAlignment(r5).setLineSpacing(this.mTextView.getLineSpacingExtra(), this.mTextView.getLineSpacingMultiplier()).setIncludePad(this.mTextView.getIncludeFontPadding()).setBreakStrategy(this.mTextView.getBreakStrategy()).setHyphenationFrequency(this.mTextView.getHyphenationFrequency());
        if (r7 != (-1)) goto L5;
        r7 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    L5:
        r9.setMaxLines(r7);
        this.mImpl.computeAndSetTextDirection(r8, this.mTextView);     // Catch: ClassCastException -> L8
    L10:
        return r8.build();
    L8:
        Log.w(TAG, "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
        goto L10
    }

    private StaticLayout createStaticLayoutForMeasuringPre16(CharSequence r10, Layout.Alignment r11, int r12) {
        float r6 = ((Float) accessAndReturnWithDefault(this.mTextView, "mSpacingMult", Float.valueOf(1.0f))).floatValue();
        float r7 = ((Float) accessAndReturnWithDefault(this.mTextView, "mSpacingAdd", Float.valueOf(0.0f))).floatValue();
        boolean r8 = ((Boolean) accessAndReturnWithDefault(this.mTextView, "mIncludePad", Boolean.TRUE)).booleanValue();
        return new StaticLayout(r10, this.mTempTextPaint, r12, r11, r6, r7, r8);
    }

    @RequiresApi(16)
    private StaticLayout createStaticLayoutForMeasuringPre23(CharSequence r10, Layout.Alignment r11, int r12) {
        float r6 = this.mTextView.getLineSpacingMultiplier();
        float r7 = this.mTextView.getLineSpacingExtra();
        boolean r8 = this.mTextView.getIncludeFontPadding();
        return new StaticLayout(r10, this.mTempTextPaint, r12, r11, r6, r7, r8);
    }

    private int findLargestTextSizeWhichFits(RectF r6) {
        int r0 = this.mAutoSizeTextSizesInPx.length;
        if (r0 == 0) goto L13;
        int r1 = 1;
        int r2 = r0 - 1;
        int r3 = 0;
    L5:
        if (r1 > r2) goto L11;
        int r4 = (r1 + r2) / 2;
        if (suggestedSizeFitsInSpace(this.mAutoSizeTextSizesInPx[r4], r6) == true) goto L8;
        r3 = r4 - 1;
        r2 = r3;
        goto L5
    L8:
        int r5 = r4 + 1;
        r3 = r1;
        r1 = r5;
        goto L5
    L11:
        return this.mAutoSizeTextSizesInPx[r3];
    L13:
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    @Nullable
    private static Field getTextViewField(@NonNull String r3) {
        Field r0 = sTextViewFieldByNameCache.get(r3);     // Catch: NoSuchFieldException -> L8
        if (r0 != null) goto L10;
        r0 = TextView.class.getDeclaredField(r3);     // Catch: NoSuchFieldException -> L8
        if (r0 == null) goto L10;
        r0.setAccessible(true);     // Catch: NoSuchFieldException -> L8
        sTextViewFieldByNameCache.put(r3, r0);     // Catch: NoSuchFieldException -> L8
    L10:
        return r0;
    L8:
        e = move-exception;
        Log.w(TAG, "Failed to access TextView#" + r3 + " member", e);
        return null;
    }

    @Nullable
    private static Method getTextViewMethod(@NonNull String r4) {
        Method r1 = sTextViewMethodByNameCache.get(r4);     // Catch: Exception -> L9
        if (r1 != null) goto L11;
        r1 = TextView.class.getDeclaredMethod(r4, null);     // Catch: Exception -> L9
        if (r1 == null) goto L11;
        r1.setAccessible(true);     // Catch: Exception -> L9
        sTextViewMethodByNameCache.put(r4, r1);     // Catch: Exception -> L9
    L11:
        return r1;
    L9:
        e = move-exception;
        Log.w(TAG, "Failed to retrieve TextView#" + r4 + "() method", e);
        return null;
    }

    public static <T> T invokeAndReturnWithDefault(@NonNull Object r3, @NonNull String r4, @NonNull T r5) {
    L14:
        return (T) getTextViewMethod(r4).invoke(r3, null);
    L7:
        e = move-exception;
        Log.w(TAG, "Failed to invoke TextView#" + r4 + "() method", e);
        return r5;
    L5:
        th = move-exception;
        throw th;
    }

    private void setRawTextSize(float r4) {
        if (r4 == this.mTextView.getPaint().getTextSize()) goto L20;
        this.mTextView.getPaint().setTextSize(r4);
        boolean r5 = this.mTextView.isInLayout();
        if (this.mTextView.getLayout() == null) goto L21;
        this.mNeedsAutoSizeText = false;
        Method r0 = getTextViewMethod("nullLayouts");     // Catch: Exception -> L11
        if (r0 == null) goto L13;
        r0.invoke(this.mTextView, null);     // Catch: Exception -> L11
    L13:
        if (r5 == true) goto L15;
        this.mTextView.requestLayout();
    L16:
        this.mTextView.invalidate();
        return;
    L15:
        this.mTextView.forceLayout();
    L11:
        e = move-exception;
        Log.w(TAG, "Failed to invoke TextView#nullLayouts() method", e);
        goto L13
    L21:
        return;
    }

    private boolean setupAutoSizeText() {
        int r1 = 0;
        if (supportsAutoSizeText() == true) goto L5;
    L15:
        this.mNeedsAutoSizeText = false;
    L17:
        return this.mNeedsAutoSizeText;
    L5:
        if (this.mAutoSizeTextType != 1) goto L15;
        if (this.mHasPresetAutoSizeValues == true) goto L9;
    L10:
        int r0 = ((int) Math.floor((this.mAutoSizeMaxTextSizeInPx - this.mAutoSizeMinTextSizeInPx) / this.mAutoSizeStepGranularityInPx)) + 1;
        int[] r3 = new int[r0];
    L11:
        if (r1 >= r0) goto L13;
        r3[r1] = Math.round((r1 * this.mAutoSizeStepGranularityInPx) + this.mAutoSizeMinTextSizeInPx);
        r1 = r1 + 1;
        goto L11
    L13:
        this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(r3);
    L14:
        this.mNeedsAutoSizeText = true;
        goto L17
    L9:
        if (this.mAutoSizeTextSizesInPx.length != 0) goto L14;
        goto L10
    }

    private void setupAutoSizeUniformPresetSizes(TypedArray r5) {
        int r0 = r5.length();
        int[] r1 = new int[r0];
        if (r0 <= 0) goto L10;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L7;
        r1[r2] = r5.getDimensionPixelSize(r2, -1);
        r2 = r2 + 1;
        goto L5
    L7:
        this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(r1);
        setupAutoSizeUniformPresetSizesConfiguration();
        return;
    }

    private boolean setupAutoSizeUniformPresetSizesConfiguration() {
        int[] r0 = this.mAutoSizeTextSizesInPx;
        int r1 = r0.length;
        if (r1 <= 0) goto L5;
        boolean r4 = true;
    L6:
        this.mHasPresetAutoSizeValues = r4;
        if (r4 == false) goto L9;
        this.mAutoSizeTextType = 1;
        this.mAutoSizeMinTextSizeInPx = r0[0];
        this.mAutoSizeMaxTextSizeInPx = r0[r1 - 1];
        this.mAutoSizeStepGranularityInPx = UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE;
    L9:
        return r4;
    L5:
        r4 = false;
        goto L6
    }

    private boolean suggestedSizeFitsInSpace(int r5, RectF r6) {
        CharSequence r0 = this.mTextView.getText();
        TransformationMethod r1 = this.mTextView.getTransformationMethod();
        if (r1 == null) goto L7;
        CharSequence r2 = r1.getTransformation(r0, this.mTextView);
        if (r2 == null) goto L7;
        r0 = r2;
    L7:
        int r3 = this.mTextView.getMaxLines();
        initTempTextPaint(r5);
        StaticLayout r4 = createLayout(r0, (Layout.Alignment) invokeAndReturnWithDefault(this.mTextView, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(r6.right), r3);
        if (r3 == (-1)) goto L15;
        if (r4.getLineCount() <= r3) goto L12;
    L13:
        return false;
    L12:
        if (r4.getLineEnd(r4.getLineCount() - 1) != r0.length()) goto L13;
    L15:
        if (r4.getHeight() <= r6.bottom) goto L17;
        return false;
    L17:
        return true;
    }

    private boolean supportsAutoSizeText() {
        return !(this.mTextView instanceof AppCompatEditText);
    }

    private void validateAndSetAutoSizeTextTypeUniformConfiguration(float r4, float r5, float r6) {
        if (r4 <= 0.0f) goto L15;
        if (r5 <= r4) goto L13;
        if (r6 <= 0.0f) goto L11;
        this.mAutoSizeTextType = 1;
        this.mAutoSizeMinTextSizeInPx = r4;
        this.mAutoSizeMaxTextSizeInPx = r5;
        this.mAutoSizeStepGranularityInPx = r6;
        this.mHasPresetAutoSizeValues = false;
        return;
    L11:
        throw new IllegalArgumentException("The auto-size step granularity (" + r6 + "px) is less or equal to (0px)");
    L13:
        throw new IllegalArgumentException("Maximum auto-size text size (" + r5 + "px) is less or equal to minimum auto-size text size (" + r4 + "px)");
    L15:
        throw new IllegalArgumentException("Minimum auto-size text size (" + r4 + "px) is less or equal to (0px)");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void autoSizeText() {
        if (isAutoSizeEnabled() == true) goto L6;
        return;
    L6:
        if (this.mNeedsAutoSizeText == true) goto L8;
    L32:
        this.mNeedsAutoSizeText = true;
        return;
    L8:
        if (this.mTextView.getMeasuredHeight() > 0) goto L10;
        return;
    L10:
        if (this.mTextView.getMeasuredWidth() > 0) goto L13;
        return;
    L13:
        if (this.mImpl.isHorizontallyScrollable(this.mTextView) == false) goto L15;
        int r0 = 1048576;
    L16:
        int r1 = (this.mTextView.getHeight() - this.mTextView.getCompoundPaddingBottom()) - this.mTextView.getCompoundPaddingTop();
        if (r0 <= 0) goto L36;
        if (r1 <= 0) goto L38;
        RectF r2 = TEMP_RECTF;
        monitor-enter(r2);
        r2.setEmpty();     // Catch: Throwable -> L25
        r2.right = r0;     // Catch: Throwable -> L25
        r2.bottom = r1;     // Catch: Throwable -> L25
        float r3 = findLargestTextSizeWhichFits(r2);     // Catch: Throwable -> L25
        if (r3 == this.mTextView.getTextSize()) goto L27;
        setTextSizeInternal(0, r3);     // Catch: Throwable -> L25
    L27:
        monitor-exit(r2);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    L38:
        return;
    L36:
        return;
    L15:
        r0 = (this.mTextView.getMeasuredWidth() - this.mTextView.getTotalPaddingLeft()) - this.mTextView.getTotalPaddingRight();
        goto L16
    }

    @VisibleForTesting
    public StaticLayout createLayout(CharSequence r1, Layout.Alignment r2, int r3, int r4) {
        return createStaticLayoutForMeasuring(r1, r2, r3, r4);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMaxTextSize() {
        return Math.round(this.mAutoSizeMaxTextSizeInPx);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMinTextSize() {
        return Math.round(this.mAutoSizeMinTextSizeInPx);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeStepGranularity() {
        return Math.round(this.mAutoSizeStepGranularityInPx);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextSizesInPx;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeTextType() {
        return this.mAutoSizeTextType;
    }

    @VisibleForTesting
    public void initTempTextPaint(int r3) {
        TextPaint r0 = this.mTempTextPaint;
        if (r0 != null) goto L5;
        this.mTempTextPaint = new TextPaint();
    L6:
        this.mTempTextPaint.set(this.mTextView.getPaint());
        this.mTempTextPaint.setTextSize(r3);
        return;
    L5:
        r0.reset();
        goto L6
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isAutoSizeEnabled() {
        if (supportsAutoSizeText() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mAutoSizeTextType == 0) goto L7;
        return true;
    }

    public void loadFromAttributes(@Nullable AttributeSet r11, int r12) {
        TypedArray r0 = this.mContext.obtainStyledAttributes(r11, R.styleable.AppCompatTextView, r12, 0);
        TextView r3 = this.mTextView;
        ViewCompat.saveAttributeDataForStyleable(r3, r3.getContext(), R.styleable.AppCompatTextView, r11, r0, r12, 0);
        if (r0.hasValue(R.styleable.AppCompatTextView_autoSizeTextType) == false) goto L6;
        this.mAutoSizeTextType = r0.getInt(R.styleable.AppCompatTextView_autoSizeTextType, 0);
    L6:
        if (r0.hasValue(R.styleable.AppCompatTextView_autoSizeStepGranularity) == false) goto L8;
        float r13 = r0.getDimension(R.styleable.AppCompatTextView_autoSizeStepGranularity, UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE);
    L10:
        if (r0.hasValue(R.styleable.AppCompatTextView_autoSizeMinTextSize) == false) goto L12;
        float r1 = r0.getDimension(R.styleable.AppCompatTextView_autoSizeMinTextSize, UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE);
    L14:
        if (r0.hasValue(R.styleable.AppCompatTextView_autoSizeMaxTextSize) == false) goto L16;
        float r4 = r0.getDimension(R.styleable.AppCompatTextView_autoSizeMaxTextSize, UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE);
    L18:
        if (r0.hasValue(R.styleable.AppCompatTextView_autoSizePresetSizes) == false) goto L22;
        int r5 = r0.getResourceId(R.styleable.AppCompatTextView_autoSizePresetSizes, 0);
        if (r5 <= 0) goto L22;
        TypedArray r6 = r0.getResources().obtainTypedArray(r5);
        setupAutoSizeUniformPresetSizes(r6);
        r6.recycle();
    L22:
        r0.recycle();
        if (supportsAutoSizeText() == true) goto L25;
        this.mAutoSizeTextType = 0;
        return;
    L25:
        if (this.mAutoSizeTextType == 1) goto L27;
        return;
    L27:
        if (this.mHasPresetAutoSizeValues == true) goto L38;
        DisplayMetrics r2 = this.mContext.getResources().getDisplayMetrics();
        if (r1 != UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE) goto L32;
        r1 = TypedValue.applyDimension(2, 12.0f, r2);
    L32:
        if (r4 != UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE) goto L35;
        r4 = TypedValue.applyDimension(2, 112.0f, r2);
    L35:
        if (r13 != UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE) goto L37;
        r13 = 1.0f;
    L37:
        validateAndSetAutoSizeTextTypeUniformConfiguration(r1, r4, r13);
    L38:
        setupAutoSizeText();
        return;
    L16:
        r4 = -1.0f;
        goto L18
    L12:
        r1 = -1.0f;
        goto L14
    L8:
        r13 = -1.0f;
        goto L10
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithConfiguration(int r2, int r3, int r4, int r5) {
        if (supportsAutoSizeText() == false) goto L8;
        DisplayMetrics r0 = this.mContext.getResources().getDisplayMetrics();
        validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(r5, r2, r0), TypedValue.applyDimension(r5, r3, r0), TypedValue.applyDimension(r5, r4, r0));
        if (setupAutoSizeText() == false) goto L9;
        autoSizeText();
        return;
    L9:
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] r6, int r7) {
        if (supportsAutoSizeText() == false) goto L23;
        int r0 = r6.length;
        int r1 = 0;
        if (r0 <= 0) goto L17;
        int[] r2 = new int[r0];
        if (r7 != 0) goto L9;
        r2 = Arrays.copyOf(r6, r0);
    L12:
        this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(r2);
        if (setupAutoSizeUniformPresetSizesConfiguration() == true) goto L19;
        throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(r6));
    L19:
        if (setupAutoSizeText() == false) goto L24;
        autoSizeText();
        return;
    L24:
        return;
    L9:
        DisplayMetrics r3 = this.mContext.getResources().getDisplayMetrics();
    L10:
        if (r1 >= r0) goto L12;
        r2[r1] = Math.round(TypedValue.applyDimension(r7, r6[r1], r3));
        r1 = r1 + 1;
        goto L10
    L17:
        this.mHasPresetAutoSizeValues = false;
        goto L19
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeWithDefaults(int r4) {
        if (supportsAutoSizeText() == false) goto L14;
        if (r4 != 0) goto L6;
        clearAutoSizeConfiguration();
        return;
    L6:
        if (r4 != 1) goto L11;
        DisplayMetrics r5 = this.mContext.getResources().getDisplayMetrics();
        validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(2, 12.0f, r5), TypedValue.applyDimension(2, 112.0f, r5), 1.0f);
        if (setupAutoSizeText() == false) goto L15;
        autoSizeText();
        return;
    L15:
        return;
    L11:
        throw new IllegalArgumentException(a.e(r4, "Unknown auto-size text type: "));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setTextSizeInternal(int r2, float r3) {
        Context r0 = this.mContext;
        if (r0 != null) goto L5;
        Resources r1 = Resources.getSystem();
    L6:
        setRawTextSize(TypedValue.applyDimension(r2, r3, r1.getDisplayMetrics()));
        return;
    L5:
        r1 = r0.getResources();
        goto L6
    }
}
