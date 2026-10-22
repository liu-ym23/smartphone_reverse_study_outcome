package androidx.dynamicanimation.animation;

import android.icu.text.DateFormat;
import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.dynamicanimation.animation.DynamicAnimation;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class DynamicAnimation<T extends DynamicAnimation<T>> implements AnimationHandler.AnimationFrameCallback {
    public static final ViewProperty ALPHA = null;
    public static final float MIN_VISIBLE_CHANGE_ALPHA = 0.00390625f;
    public static final float MIN_VISIBLE_CHANGE_PIXELS = 1.0f;
    public static final float MIN_VISIBLE_CHANGE_ROTATION_DEGREES = 0.1f;
    public static final float MIN_VISIBLE_CHANGE_SCALE = 0.002f;
    public static final ViewProperty ROTATION = null;
    public static final ViewProperty ROTATION_X = null;
    public static final ViewProperty ROTATION_Y = null;
    public static final ViewProperty SCALE_X = null;
    public static final ViewProperty SCALE_Y = null;
    public static final ViewProperty SCROLL_X = null;
    public static final ViewProperty SCROLL_Y = null;
    private static final float THRESHOLD_MULTIPLIER = 0.75f;
    public static final ViewProperty TRANSLATION_X = null;
    public static final ViewProperty TRANSLATION_Y = null;
    public static final ViewProperty TRANSLATION_Z = null;
    private static final float UNSET = Float.MAX_VALUE;
    public static final ViewProperty X = null;
    public static final ViewProperty Y = null;
    public static final ViewProperty Z = null;
    private final ArrayList<OnAnimationEndListener> mEndListeners;
    private long mLastFrameTime;
    float mMaxValue;
    float mMinValue;
    private float mMinVisibleChange;
    final FloatPropertyCompat mProperty;
    boolean mRunning;
    boolean mStartValueIsSet;
    final Object mTarget;
    private final ArrayList<OnAnimationUpdateListener> mUpdateListeners;
    float mValue;
    float mVelocity;

    static class MassState {
        float mValue;
        float mVelocity;

        MassState() {
        }
    }

    public interface OnAnimationEndListener {
        void onAnimationEnd(DynamicAnimation r1, boolean r2, float r3, float r4);
    }

    public interface OnAnimationUpdateListener {
        void onAnimationUpdate(DynamicAnimation r1, float r2, float r3);
    }

    public static abstract class ViewProperty extends FloatPropertyCompat<View> {
        /* synthetic */ ViewProperty(String r1, AnonymousClass1 r2) {
            this(r1);
        }

        private ViewProperty(String r1) {
            super(r1);
        }
    }

    abstract float getAcceleration(float r1, float r2);

    abstract boolean isAtEquilibrium(float r1, float r2);

    abstract void setValueThreshold(float r1);

    abstract boolean updateValueAndVelocity(long r1);

    static {
        final String r1 = "translationX";
        TRANSLATION_X = new AnonymousClass1(r1);
        final String r2 = "translationY";
        TRANSLATION_Y = new AnonymousClass2(r2);
        final String r3 = "translationZ";
        TRANSLATION_Z = new AnonymousClass3(r3);
        final String r4 = "scaleX";
        SCALE_X = new AnonymousClass4(r4);
        final String r5 = "scaleY";
        SCALE_Y = new AnonymousClass5(r5);
        final String r6 = "rotation";
        ROTATION = new AnonymousClass6(r6);
        final String r7 = "rotationX";
        ROTATION_X = new AnonymousClass7(r7);
        final String r8 = "rotationY";
        ROTATION_Y = new AnonymousClass8(r8);
        final String r9 = MaterialConfigFormatNames.X;
        X = new AnonymousClass9(r9);
        final String r10 = "y";
        Y = new AnonymousClass10(r10);
        final String r11 = DateFormat.ABBR_SPECIFIC_TZ;
        Z = new AnonymousClass11(r11);
        final String r12 = "alpha";
        ALPHA = new AnonymousClass12(r12);
        final String r13 = "scrollX";
        SCROLL_X = new AnonymousClass13(r13);
        final String r14 = "scrollY";
        SCROLL_Y = new AnonymousClass14(r14);
    }

    DynamicAnimation(final FloatValueHolder r3) {
        this.mVelocity = 0.0f;
        this.mValue = Float.MAX_VALUE;
        this.mStartValueIsSet = false;
        this.mRunning = false;
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -Float.MAX_VALUE;
        this.mLastFrameTime = 0;
        this.mEndListeners = new ArrayList();
        this.mUpdateListeners = new ArrayList();
        this.mTarget = null;
        final String r1 = "FloatValueHolder";
        this.mProperty = new AnonymousClass15(this, r1, r3);
        this.mMinVisibleChange = 1.0f;
    }

    <K> DynamicAnimation(K r3, FloatPropertyCompat<K> r4) {
        this.mVelocity = 0.0f;
        this.mValue = Float.MAX_VALUE;
        this.mStartValueIsSet = false;
        this.mRunning = false;
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -Float.MAX_VALUE;
        this.mLastFrameTime = 0;
        this.mEndListeners = new ArrayList();
        this.mUpdateListeners = new ArrayList();
        this.mTarget = r3;
        this.mProperty = r4;
        if (r4 != ROTATION) goto L5;
    L19:
        this.mMinVisibleChange = 0.1f;
        return;
    L5:
        if (r4 == ROTATION_X) goto L19;
        if (r4 == ROTATION_Y) goto L19;
        if (r4 != ALPHA) goto L13;
        this.mMinVisibleChange = 0.00390625f;
        return;
    L13:
        if (r4 != SCALE_X) goto L15;
    L18:
        this.mMinVisibleChange = 0.00390625f;
        return;
    L15:
        if (r4 == SCALE_Y) goto L18;
        this.mMinVisibleChange = 1.0f;
    }

    public T setStartValue(float r1) {
        this.mValue = r1;
        this.mStartValueIsSet = true;
        return this;
    }

    public T setStartVelocity(float r1) {
        this.mVelocity = r1;
        return this;
    }

    public T setMaxValue(float r1) {
        this.mMaxValue = r1;
        return this;
    }

    public T setMinValue(float r1) {
        this.mMinValue = r1;
        return this;
    }

    public T addEndListener(OnAnimationEndListener r2) {
        if (this.mEndListeners.contains(r2) == true) goto L5;
        this.mEndListeners.add(r2);
    L5:
        return this;
    }

    public void removeEndListener(OnAnimationEndListener r1) {
        removeEntry(this.mEndListeners, r1);
    }

    public T addUpdateListener(OnAnimationUpdateListener r2) {
        if (isRunning() == true) goto L9;
        if (this.mUpdateListeners.contains(r2) == true) goto L7;
        this.mUpdateListeners.add(r2);
    L7:
        return this;
    L9:
        throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
    }

    public void removeUpdateListener(OnAnimationUpdateListener r1) {
        removeEntry(this.mUpdateListeners, r1);
    }

    public T setMinimumVisibleChange(float r2) {
        if (r2 <= 0.0f) goto L7;
        this.mMinVisibleChange = r2;
        setValueThreshold(r2 * 0.75f);
        return this;
    L7:
        throw new IllegalArgumentException("Minimum visible change must be positive.");
    }

    public float getMinimumVisibleChange() {
        return this.mMinVisibleChange;
    }

    private static <T> void removeNullEntries(ArrayList<T> r2) {
        int r0 = r2.size() - 1;
    L3:
        if (r0 < 0) goto L8;
        if (r2.get(r0) != null) goto L7;
        r2.remove(r0);
    L7:
        r0 = r0 - 1;
        goto L3
    }

    private static <T> void removeEntry(ArrayList<T> r1, T r2) {
        int r3 = r1.indexOf(r2);
        if (r3 < 0) goto L6;
        r1.set(r3, null);
        return;
    }

    public void start() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
        if (this.mRunning == true) goto L10;
        startAnimationInternal();
        return;
    L10:
        return;
    L9:
        throw new AndroidRuntimeException("Animations may only be started on the main thread");
    }

    public void cancel() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
        if (this.mRunning == false) goto L10;
        endAnimationInternal(true);
        return;
    L10:
        return;
    L9:
        throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
    }

    public boolean isRunning() {
        return this.mRunning;
    }

    private void startAnimationInternal() {
        if (this.mRunning == true) goto L14;
        this.mRunning = true;
        if (this.mStartValueIsSet == true) goto L7;
        this.mValue = getPropertyValue();
    L7:
        float r0 = this.mValue;
        if (r0 > this.mMaxValue) goto L13;
        if (r0 < this.mMinValue) goto L13;
        AnimationHandler.getInstance().addAnimationFrameCallback(this, 0);
        return;
    L13:
        throw new IllegalArgumentException("Starting value need to be in between min value and max value");
    }

    @Override // androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallback
    public boolean doAnimationFrame(long r5) {
        long r0 = this.mLastFrameTime;
        if (r0 != 0) goto L6;
        this.mLastFrameTime = r5;
        setPropertyValue(this.mValue);
        return false;
    L6:
        this.mLastFrameTime = r5;
        boolean r6 = updateValueAndVelocity(r5 - r0);
        float r7 = Math.min(this.mValue, this.mMaxValue);
        this.mValue = r7;
        float r8 = Math.max(r7, this.mMinValue);
        this.mValue = r8;
        setPropertyValue(r8);
        if (r6 == false) goto L9;
        endAnimationInternal(false);
    L9:
        return r6;
    }

    private void endAnimationInternal(boolean r5) {
        int r0 = 0;
        this.mRunning = false;
        AnimationHandler.getInstance().removeCallback(this);
        this.mLastFrameTime = 0;
        this.mStartValueIsSet = false;
    L4:
        if (r0 >= this.mEndListeners.size()) goto L9;
        if (this.mEndListeners.get(r0) == null) goto L8;
        this.mEndListeners.get(r0).onAnimationEnd(this, r5, this.mValue, this.mVelocity);
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        removeNullEntries(this.mEndListeners);
    }

    void setPropertyValue(float r4) {
        this.mProperty.setValue(this.mTarget, r4);
        int r5 = 0;
    L4:
        if (r5 >= this.mUpdateListeners.size()) goto L9;
        if (this.mUpdateListeners.get(r5) == null) goto L8;
        this.mUpdateListeners.get(r5).onAnimationUpdate(this, this.mValue, this.mVelocity);
    L8:
        r5 = r5 + 1;
        goto L4
    L9:
        removeNullEntries(this.mUpdateListeners);
    }

    float getValueThreshold() {
        return this.mMinVisibleChange * 0.75f;
    }

    private float getPropertyValue() {
        return this.mProperty.getValue(this.mTarget);
    }
}
