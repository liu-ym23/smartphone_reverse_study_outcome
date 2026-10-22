package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.ss.android.common.ApiConstants;

/* JADX INFO: loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {
    private static final String ACCESSIBILITY_EVENT_CLASS_NAME = "android.widget.Switch";
    private static final int[] CHECKED_STATE_SET = null;
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int THUMB_ANIMATION_DURATION = 250;
    private static final Property<SwitchCompat, Float> THUMB_POS = null;
    private static final int TOUCH_MODE_DOWN = 1;
    private static final int TOUCH_MODE_DRAGGING = 2;
    private static final int TOUCH_MODE_IDLE = 0;
    private boolean mHasThumbTint;
    private boolean mHasThumbTintMode;
    private boolean mHasTrackTint;
    private boolean mHasTrackTintMode;
    private int mMinFlingVelocity;
    private Layout mOffLayout;
    private Layout mOnLayout;
    ObjectAnimator mPositionAnimator;
    private boolean mShowText;
    private boolean mSplitTrack;
    private int mSwitchBottom;
    private int mSwitchHeight;
    private int mSwitchLeft;
    private int mSwitchMinWidth;
    private int mSwitchPadding;
    private int mSwitchRight;
    private int mSwitchTop;
    private TransformationMethod mSwitchTransformationMethod;
    private int mSwitchWidth;
    private final Rect mTempRect;
    private ColorStateList mTextColors;
    private final AppCompatTextHelper mTextHelper;
    private CharSequence mTextOff;
    private CharSequence mTextOn;
    private final TextPaint mTextPaint;
    private Drawable mThumbDrawable;
    float mThumbPosition;
    private int mThumbTextPadding;
    private ColorStateList mThumbTintList;
    private PorterDuff.Mode mThumbTintMode;
    private int mThumbWidth;
    private int mTouchMode;
    private int mTouchSlop;
    private float mTouchX;
    private float mTouchY;
    private Drawable mTrackDrawable;
    private ColorStateList mTrackTintList;
    private PorterDuff.Mode mTrackTintMode;
    private VelocityTracker mVelocityTracker;

    static {
        final Class<Float> r1 = Float.class;
        final String r2 = "thumbPos";
        THUMB_POS = new AnonymousClass1(r1, r2);
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
    }

    public SwitchCompat(@NonNull Context r2) {
        this(r2, null);
    }

    private void animateThumbToCheckedState(boolean r5) {
        if (r5 == false) goto L5;
        float r6 = 1.0f;
    L6:
        ObjectAnimator r7 = ObjectAnimator.ofFloat(this, THUMB_POS, new float[]{r6});
        this.mPositionAnimator = r7;
        r7.setDuration(250);
        this.mPositionAnimator.setAutoCancel(true);
        this.mPositionAnimator.start();
        return;
    L5:
        r6 = 0.0f;
        goto L6
    }

    private void applyThumbTint() {
        Drawable r0 = this.mThumbDrawable;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mHasThumbTint == false) goto L7;
    L8:
        Drawable r1 = DrawableCompat.wrap(r0).mutate();
        this.mThumbDrawable = r1;
        if (this.mHasThumbTint == false) goto L12;
        DrawableCompat.setTintList(r1, this.mThumbTintList);
    L12:
        if (this.mHasThumbTintMode == false) goto L15;
        DrawableCompat.setTintMode(this.mThumbDrawable, this.mThumbTintMode);
    L15:
        if (this.mThumbDrawable.isStateful() == false) goto L20;
        this.mThumbDrawable.setState(getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.mHasThumbTintMode == true) goto L8;
    }

    private void applyTrackTint() {
        Drawable r0 = this.mTrackDrawable;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mHasTrackTint == false) goto L7;
    L8:
        Drawable r1 = DrawableCompat.wrap(r0).mutate();
        this.mTrackDrawable = r1;
        if (this.mHasTrackTint == false) goto L12;
        DrawableCompat.setTintList(r1, this.mTrackTintList);
    L12:
        if (this.mHasTrackTintMode == false) goto L15;
        DrawableCompat.setTintMode(this.mTrackDrawable, this.mTrackTintMode);
    L15:
        if (this.mTrackDrawable.isStateful() == false) goto L20;
        this.mTrackDrawable.setState(getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.mHasTrackTintMode == true) goto L8;
    }

    private void cancelPositionAnimator() {
        ObjectAnimator r0 = this.mPositionAnimator;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    private void cancelSuperTouch(MotionEvent r2) {
        MotionEvent r3 = MotionEvent.obtain(r2);
        r3.setAction(3);
        super.onTouchEvent(r3);
        r3.recycle();
    }

    private static float constrain(float r1, float r2, float r3) {
        if (r1 >= r2) goto L6;
        return r2;
    L6:
        if (r1 > r3) goto L8;
        return r1;
    L8:
        return r3;
    }

    private boolean getTargetCheckedState() {
        if (this.mThumbPosition <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    private int getThumbOffset() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L5;
        float r0 = 1.0f - this.mThumbPosition;
    L7:
        return (int) ((r0 * getThumbScrollRange()) + 0.5f);
    L5:
        r0 = this.mThumbPosition;
        goto L7
    }

    private int getThumbScrollRange() {
        Drawable r0 = this.mTrackDrawable;
        if (r0 == null) goto L10;
        Rect r1 = this.mTempRect;
        r0.getPadding(r1);
        Drawable r2 = this.mThumbDrawable;
        if (r2 == null) goto L7;
        Rect r3 = DrawableUtils.getOpticalBounds(r2);
    L9:
        return ((((this.mSwitchWidth - this.mThumbWidth) - r1.left) - r1.right) - r3.left) - r3.right;
    L7:
        r3 = DrawableUtils.INSETS_NONE;
        goto L9
    L10:
        return 0;
    }

    private boolean hitThumb(float r8, float r9) {
        if (this.mThumbDrawable != null) goto L5;
        return false;
    L5:
        int r0 = getThumbOffset();
        this.mThumbDrawable.getPadding(this.mTempRect);
        int r2 = this.mSwitchTop;
        int r3 = this.mTouchSlop;
        int r4 = r2 - r3;
        int r5 = (this.mSwitchLeft + r0) - r3;
        int r1 = this.mThumbWidth + r5;
        Rect r6 = this.mTempRect;
        int r7 = ((r1 + r6.left) + r6.right) + r3;
        int r10 = this.mSwitchBottom + r3;
        if (r8 > r5) goto L8;
        return false;
    L8:
        if (r8 < r7) goto L10;
        return false;
    L10:
        if (r9 > r4) goto L12;
        return false;
    L12:
        if (r9 >= r10) goto L18;
        return true;
    L18:
        return false;
    }

    private Layout makeLayout(CharSequence r9) {
        TransformationMethod r0 = this.mSwitchTransformationMethod;
        if (r0 == null) goto L5;
        r9 = r0.getTransformation(r9, this);
    L5:
        CharSequence r1 = r9;
        TextPaint r2 = this.mTextPaint;
        if (r1 == null) goto L9;
        int r8 = (int) Math.ceil(Layout.getDesiredWidth(r1, r2));
    L11:
        return new StaticLayout(r1, r2, r8, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    L9:
        r8 = 0;
        goto L11
    }

    private void setSwitchTypefaceByIndex(int r2, int r3) {
        if (r2 != 1) goto L5;
        Typeface r4 = Typeface.SANS_SERIF;
    L12:
        setSwitchTypeface(r4, r3);
        return;
    L5:
        if (r2 != 2) goto L7;
        r4 = Typeface.SERIF;
        goto L12
    L7:
        if (r2 == 3) goto L9;
        r4 = null;
        goto L12
    L9:
        r4 = Typeface.MONOSPACE;
        goto L12
    }

    private void stopDrag(MotionEvent r7) {
        this.mTouchMode = 0;
        boolean r2 = true;
        if (r7.getAction() == 1) goto L5;
    L7:
        boolean r1 = false;
    L8:
        boolean r3 = isChecked();
        if (r1 == false) goto L22;
        this.mVelocityTracker.computeCurrentVelocity(1000);
        float r4 = this.mVelocityTracker.getXVelocity();
        if (Math.abs(r4) > this.mMinFlingVelocity) goto L13;
        r2 = getTargetCheckedState();
    L23:
        if (r2 == r3) goto L25;
        playSoundEffect(0);
    L25:
        setChecked(r2);
        cancelSuperTouch(r7);
        return;
    L13:
        if (ViewUtils.isLayoutRtl(this) == false) goto L19;
        if (r4 < 0.0f) goto L23;
    L17:
        r2 = false;
        goto L23
    L19:
        if (r4 <= 0.0f) goto L17;
    L22:
        r2 = r3;
        goto L23
    L5:
        if (isEnabled() == false) goto L7;
        r1 = true;
        goto L8
    }

    @Override // android.view.View
    public void draw(Canvas r11) {
        Rect r0 = this.mTempRect;
        int r1 = this.mSwitchLeft;
        int r2 = this.mSwitchTop;
        int r3 = this.mSwitchRight;
        int r4 = this.mSwitchBottom;
        int r5 = getThumbOffset() + r1;
        Drawable r6 = this.mThumbDrawable;
        if (r6 == null) goto L5;
        Rect r7 = DrawableUtils.getOpticalBounds(r6);
    L6:
        Drawable r8 = this.mTrackDrawable;
        if (r8 == null) goto L26;
        r8.getPadding(r0);
        int r9 = r0.left;
        r5 = r5 + r9;
        if (r7 == null) goto L24;
        int r10 = r7.left;
        if (r10 <= r9) goto L13;
        r1 = r1 + (r10 - r9);
    L13:
        int r12 = r7.top;
        int r13 = r0.top;
        if (r12 <= r13) goto L16;
        int r14 = (r12 - r13) + r2;
    L17:
        int r15 = r7.right;
        int r16 = r0.right;
        if (r15 <= r16) goto L20;
        r3 = r3 - (r15 - r16);
    L20:
        int r17 = r7.bottom;
        int r18 = r0.bottom;
        if (r17 <= r18) goto L23;
        int r19 = r4 - (r17 - r18);
    L25:
        this.mTrackDrawable.setBounds(r1, r14, r3, r19);
    L23:
        r19 = r4;
        goto L25
    L16:
        r14 = r2;
        goto L17
    L24:
        r14 = r2;
    L26:
        Drawable r20 = this.mThumbDrawable;
        if (r20 == null) goto L31;
        r20.getPadding(r0);
        int r21 = r5 - r0.left;
        int r22 = (r5 + this.mThumbWidth) + r0.right;
        this.mThumbDrawable.setBounds(r21, r2, r22, r4);
        Drawable r23 = getBackground();
        if (r23 == null) goto L31;
        DrawableCompat.setHotspotBounds(r23, r21, r2, r22, r4);
    L31:
        super.draw(r11);
        return;
    L5:
        r7 = DrawableUtils.INSETS_NONE;
        goto L6
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float r2, float r3) {
        super.drawableHotspotChanged(r2, r3);
        Drawable r0 = this.mThumbDrawable;
        if (r0 == null) goto L5;
        DrawableCompat.setHotspot(r0, r2, r3);
    L5:
        Drawable r1 = this.mTrackDrawable;
        if (r1 == null) goto L9;
        DrawableCompat.setHotspot(r1, r2, r3);
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r0 = getDrawableState();
        Drawable r1 = this.mThumbDrawable;
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        Drawable r3 = this.mTrackDrawable;
        if (r3 != null) goto L11;
    L13:
        if (r2 == false) goto L16;
        invalidate();
        return;
    L16:
        return;
    L11:
        if (r3.isStateful() == false) goto L13;
        r2 = r2 | r3.setState(r0);
        goto L13
    L5:
        if (r1.isStateful() == false) goto L7;
        r2 = r1.setState(r0);
        goto L8
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L5;
        int r0 = super.getCompoundPaddingLeft() + this.mSwitchWidth;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r0;
    L9:
        return r0 + this.mSwitchPadding;
    L5:
        return super.getCompoundPaddingLeft();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (ViewUtils.isLayoutRtl(this) == true) goto L5;
        int r0 = super.getCompoundPaddingRight() + this.mSwitchWidth;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r0;
    L9:
        return r0 + this.mSwitchPadding;
    L5:
        return super.getCompoundPaddingRight();
    }

    public boolean getShowText() {
        return this.mShowText;
    }

    public boolean getSplitTrack() {
        return this.mSplitTrack;
    }

    public int getSwitchMinWidth() {
        return this.mSwitchMinWidth;
    }

    public int getSwitchPadding() {
        return this.mSwitchPadding;
    }

    public CharSequence getTextOff() {
        return this.mTextOff;
    }

    public CharSequence getTextOn() {
        return this.mTextOn;
    }

    public Drawable getThumbDrawable() {
        return this.mThumbDrawable;
    }

    public int getThumbTextPadding() {
        return this.mThumbTextPadding;
    }

    @Nullable
    public ColorStateList getThumbTintList() {
        return this.mThumbTintList;
    }

    @Nullable
    public PorterDuff.Mode getThumbTintMode() {
        return this.mThumbTintMode;
    }

    public Drawable getTrackDrawable() {
        return this.mTrackDrawable;
    }

    @Nullable
    public ColorStateList getTrackTintList() {
        return this.mTrackTintList;
    }

    @Nullable
    public PorterDuff.Mode getTrackTintMode() {
        return this.mTrackTintMode;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r0 = this.mThumbDrawable;
        if (r0 == null) goto L5;
        r0.jumpToCurrentState();
    L5:
        Drawable r1 = this.mTrackDrawable;
        if (r1 == null) goto L8;
        r1.jumpToCurrentState();
    L8:
        ObjectAnimator r2 = this.mPositionAnimator;
        if (r2 != null) goto L11;
        return;
    L11:
        if (r2.isStarted() == false) goto L15;
        this.mPositionAnimator.end();
        this.mPositionAnimator = null;
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int r1) {
        int[] r2 = super.onCreateDrawableState(r1 + 1);
        if (isChecked() == false) goto L5;
        View.mergeDrawableStates(r2, CHECKED_STATE_SET);
    L5:
        return r2;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas r10) {
        super.onDraw(r10);
        Rect r0 = this.mTempRect;
        Drawable r1 = this.mTrackDrawable;
        if (r1 == null) goto L5;
        r1.getPadding(r0);
    L6:
        int r2 = this.mSwitchTop;
        int r3 = this.mSwitchBottom;
        int r4 = r2 + r0.top;
        int r5 = r3 - r0.bottom;
        Drawable r6 = this.mThumbDrawable;
        if (r1 != null) goto L9;
    L13:
        int r7 = r10.save();
        if (r6 == null) goto L17;
        r6.draw(r10);
    L17:
        if (getTargetCheckedState() == false) goto L19;
        Layout r8 = this.mOnLayout;
    L20:
        if (r8 == null) goto L29;
        int[] r9 = getDrawableState();
        ColorStateList r11 = this.mTextColors;
        if (r11 == null) goto L24;
        this.mTextPaint.setColor(r11.getColorForState(r9, 0));
    L24:
        this.mTextPaint.drawableState = r9;
        if (r6 == null) goto L27;
        Rect r12 = r6.getBounds();
        int r13 = r12.left + r12.right;
    L28:
        r10.translate((r13 / 2) - (r8.getWidth() / 2), ((r4 + r5) / 2) - (r8.getHeight() / 2));
        r8.draw(r10);
        goto L29
    L27:
        r13 = getWidth();
    L29:
        r10.restoreToCount(r7);
        return;
    L19:
        r8 = this.mOffLayout;
        goto L20
    L9:
        if (this.mSplitTrack == false) goto L12;
        if (r6 == null) goto L12;
        Rect r14 = DrawableUtils.getOpticalBounds(r6);
        r6.copyBounds(r0);
        r0.left += r14.left;
        r0.right -= r14.right;
        int r15 = r10.save();
        r10.clipRect(r0, Region.Op.DIFFERENCE);
        r1.draw(r10);
        r10.restoreToCount(r15);
    L12:
        r1.draw(r10);
        goto L13
    L5:
        r0.setEmpty();
        goto L6
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r1) {
        super.onInitializeAccessibilityEvent(r1);
        r1.setClassName(ACCESSIBILITY_EVENT_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r3) {
        super.onInitializeAccessibilityNodeInfo(r3);
        r3.setClassName(ACCESSIBILITY_EVENT_CLASS_NAME);
        if (isChecked() == false) goto L5;
        CharSequence r2 = this.mTextOn;
    L7:
        if (TextUtils.isEmpty(r2) == true) goto L13;
        CharSequence r0 = r3.getText();
        if (TextUtils.isEmpty(r0) == false) goto L11;
        r3.setText(r2);
        return;
    L11:
        StringBuilder r1 = new StringBuilder();
        r1.append(r0);
        r1.append(' ');
        r1.append(r2);
        r3.setText(r1);
        return;
    L13:
        return;
    L5:
        r2 = this.mTextOff;
        goto L7
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        super.onLayout(r2, r3, r4, r5, r6);
        int r7 = 0;
        if (this.mThumbDrawable == null) goto L9;
        Rect r8 = this.mTempRect;
        Drawable r9 = this.mTrackDrawable;
        if (r9 == null) goto L7;
        r9.getPadding(r8);
    L8:
        Rect r10 = DrawableUtils.getOpticalBounds(this.mThumbDrawable);
        int r11 = Math.max(0, r10.left - r8.left);
        r7 = Math.max(0, r10.right - r8.right);
    L11:
        if (ViewUtils.isLayoutRtl(this) == false) goto L13;
        int r12 = getPaddingLeft() + r11;
        int r13 = ((this.mSwitchWidth + r12) - r11) - r7;
    L14:
        int r14 = getGravity() & ApiConstants.OP_ERROR_UGC_POST_TOO_FAST;
        if (r14 != 16) goto L17;
        int r15 = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
        int r16 = this.mSwitchHeight;
        int r17 = r15 - (r16 / 2);
        int r18 = r16 + r17;
        int r19 = r17;
    L21:
        this.mSwitchLeft = r12;
        this.mSwitchTop = r19;
        this.mSwitchBottom = r18;
        this.mSwitchRight = r13;
        return;
    L17:
        if (r14 == 80) goto L19;
        r19 = getPaddingTop();
        r18 = this.mSwitchHeight + r19;
        goto L21
    L19:
        r18 = getHeight() - getPaddingBottom();
        r19 = r18 - this.mSwitchHeight;
        goto L21
    L13:
        r13 = (getWidth() - getPaddingRight()) - r7;
        r12 = ((r13 - this.mSwitchWidth) + r11) + r7;
        goto L14
    L7:
        r8.setEmpty();
        goto L8
    L9:
        r11 = 0;
        goto L11
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r7, int r8) {
        if (this.mShowText == true) goto L5;
    L10:
        Rect r0 = this.mTempRect;
        Drawable r1 = this.mThumbDrawable;
        int r2 = 0;
        if (r1 == null) goto L13;
        r1.getPadding(r0);
        int r3 = (this.mThumbDrawable.getIntrinsicWidth() - r0.left) - r0.right;
        int r4 = this.mThumbDrawable.getIntrinsicHeight();
    L15:
        if (this.mShowText == false) goto L17;
        int r5 = (this.mThumbTextPadding * 2) + Math.max(this.mOnLayout.getWidth(), this.mOffLayout.getWidth());
    L18:
        this.mThumbWidth = Math.max(r5, r3);
        Drawable r6 = this.mTrackDrawable;
        if (r6 == null) goto L21;
        r6.getPadding(r0);
        r2 = this.mTrackDrawable.getIntrinsicHeight();
    L22:
        int r9 = r0.left;
        int r10 = r0.right;
        Drawable r11 = this.mThumbDrawable;
        if (r11 == null) goto L25;
        Rect r12 = DrawableUtils.getOpticalBounds(r11);
        r9 = Math.max(r9, r12.left);
        r10 = Math.max(r10, r12.right);
    L25:
        int r13 = Math.max(this.mSwitchMinWidth, ((this.mThumbWidth * 2) + r9) + r10);
        int r14 = Math.max(r2, r4);
        this.mSwitchWidth = r13;
        this.mSwitchHeight = r14;
        super.onMeasure(r7, r8);
        if (getMeasuredHeight() >= r14) goto L29;
        setMeasuredDimension(getMeasuredWidthAndState(), r14);
        return;
    L29:
        return;
    L21:
        r0.setEmpty();
        goto L22
    L17:
        r5 = 0;
        goto L18
    L13:
        r3 = 0;
        r4 = 0;
        goto L15
    L5:
        if (this.mOnLayout != null) goto L8;
        this.mOnLayout = makeLayout(this.mTextOn);
    L8:
        if (this.mOffLayout != null) goto L10;
        this.mOffLayout = makeLayout(this.mTextOff);
        goto L10
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent r2) {
        super.onPopulateAccessibilityEvent(r2);
        if (isChecked() == false) goto L5;
        CharSequence r1 = this.mTextOn;
    L6:
        if (r1 == null) goto L9;
        r2.getText().add(r1);
        return;
    L9:
        return;
    L5:
        r1 = this.mTextOff;
        goto L6
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r7) {
        this.mVelocityTracker.addMovement(r7);
        int r0 = r7.getActionMasked();
        if (r0 != 0) goto L5;
        float r1 = r7.getX();
        float r2 = r7.getY();
        if (isEnabled() == true) goto L42;
    L45:
        return super.onTouchEvent(r7);
    L42:
        if (hitThumb(r1, r2) == false) goto L45;
        this.mTouchMode = 1;
        this.mTouchX = r1;
        this.mTouchY = r2;
        goto L45
    L5:
        if (r0 == 1) goto L35;
        if (r0 != 2) goto L8;
        int r3 = this.mTouchMode;
        if (r3 == 1) goto L28;
        if (r3 != 2) goto L45;
        float r8 = r7.getX();
        int r4 = getThumbScrollRange();
        float r5 = r8 - this.mTouchX;
        if (r4 == 0) goto L18;
        float r6 = r5 / r4;
    L22:
        if (ViewUtils.isLayoutRtl(this) == false) goto L24;
        r6 = -r6;
    L24:
        float r9 = constrain(this.mThumbPosition + r6, 0.0f, 1.0f);
        if (r9 == this.mThumbPosition) goto L27;
        this.mTouchX = r8;
        setThumbPosition(r9);
    L27:
        return true;
    L18:
        if (r5 <= 0.0f) goto L20;
        r6 = 1.0f;
        goto L22
    L20:
        r6 = -1.0f;
        goto L22
    L28:
        float r10 = r7.getX();
        float r11 = r7.getY();
        if (Math.abs(r10 - this.mTouchX) <= this.mTouchSlop) goto L31;
    L32:
        this.mTouchMode = 2;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.mTouchX = r10;
        this.mTouchY = r11;
        return true;
    L31:
        if (Math.abs(r11 - this.mTouchY) <= this.mTouchSlop) goto L45;
    L8:
        if (r0 != 3) goto L45;
    L35:
        if (this.mTouchMode != 2) goto L38;
        stopDrag(r7);
        super.onTouchEvent(r7);
        return true;
    L38:
        this.mTouchMode = 0;
        this.mVelocityTracker.clear();
        goto L45
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r2) {
        super.setChecked(r2);
        boolean r3 = isChecked();
        if (getWindowToken() != null) goto L5;
    L7:
        cancelPositionAnimator();
        if (r3 == false) goto L10;
        float r4 = 1.0f;
    L11:
        setThumbPosition(r4);
        return;
    L10:
        r4 = 0.0f;
        goto L11
    L5:
        if (ViewCompat.isLaidOut(this) == false) goto L7;
        animateThumbToCheckedState(r3);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback r1) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, r1));
    }

    public void setShowText(boolean r2) {
        if (this.mShowText == r2) goto L6;
        this.mShowText = r2;
        requestLayout();
        return;
    }

    public void setSplitTrack(boolean r1) {
        this.mSplitTrack = r1;
        invalidate();
    }

    public void setSwitchMinWidth(int r1) {
        this.mSwitchMinWidth = r1;
        requestLayout();
    }

    public void setSwitchPadding(int r1) {
        this.mSwitchPadding = r1;
        requestLayout();
    }

    public void setSwitchTextAppearance(Context r4, int r5) {
        TintTypedArray r6 = TintTypedArray.obtainStyledAttributes(r4, r5, androidx.appcompat.R.styleable.TextAppearance);
        ColorStateList r7 = r6.getColorStateList(androidx.appcompat.R.styleable.TextAppearance_android_textColor);
        if (r7 == null) goto L5;
        this.mTextColors = r7;
    L6:
        int r8 = r6.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);
        if (r8 == 0) goto L11;
        float r9 = r8;
        if (r9 == this.mTextPaint.getTextSize()) goto L11;
        this.mTextPaint.setTextSize(r9);
        requestLayout();
    L11:
        setSwitchTypefaceByIndex(r6.getInt(androidx.appcompat.R.styleable.TextAppearance_android_typeface, -1), r6.getInt(androidx.appcompat.R.styleable.TextAppearance_android_textStyle, -1));
        if (r6.getBoolean(androidx.appcompat.R.styleable.TextAppearance_textAllCaps, false) == false) goto L14;
        this.mSwitchTransformationMethod = new AllCapsTransformationMethod(getContext());
    L15:
        r6.recycle();
        return;
    L14:
        this.mSwitchTransformationMethod = null;
        goto L15
    L5:
        this.mTextColors = getTextColors();
        goto L6
    }

    public void setSwitchTypeface(Typeface r4, int r5) {
        float r0 = 0.0f;
        boolean r1 = false;
        if (r5 <= 0) goto L18;
        if (r4 != null) goto L6;
        Typeface r6 = Typeface.defaultFromStyle(r5);
    L7:
        setSwitchTypeface(r6);
        if (r6 == null) goto L10;
        int r7 = r6.getStyle();
    L11:
        int r8 = (~r7) & r5;
        TextPaint r9 = this.mTextPaint;
        if ((r8 & 1) == 0) goto L14;
        r1 = true;
    L14:
        r9.setFakeBoldText(r1);
        TextPaint r3 = this.mTextPaint;
        if ((r8 & 2) == 0) goto L17;
        r0 = -0.25f;
    L17:
        r3.setTextSkewX(r0);
        return;
    L10:
        r7 = 0;
        goto L11
    L6:
        r6 = Typeface.create(r4, r5);
        goto L7
    L18:
        this.mTextPaint.setFakeBoldText(false);
        this.mTextPaint.setTextSkewX(0.0f);
        setSwitchTypeface(r4);
    }

    public void setTextOff(CharSequence r1) {
        this.mTextOff = r1;
        requestLayout();
    }

    public void setTextOn(CharSequence r1) {
        this.mTextOn = r1;
        requestLayout();
    }

    public void setThumbDrawable(Drawable r3) {
        Drawable r0 = this.mThumbDrawable;
        if (r0 == null) goto L5;
        r0.setCallback(null);
    L5:
        this.mThumbDrawable = r3;
        if (r3 == null) goto L8;
        r3.setCallback(this);
    L8:
        requestLayout();
    }

    public void setThumbPosition(float r1) {
        this.mThumbPosition = r1;
        invalidate();
    }

    public void setThumbResource(int r2) {
        setThumbDrawable(AppCompatResources.getDrawable(getContext(), r2));
    }

    public void setThumbTextPadding(int r1) {
        this.mThumbTextPadding = r1;
        requestLayout();
    }

    public void setThumbTintList(@Nullable ColorStateList r1) {
        this.mThumbTintList = r1;
        this.mHasThumbTint = true;
        applyThumbTint();
    }

    public void setThumbTintMode(@Nullable PorterDuff.Mode r1) {
        this.mThumbTintMode = r1;
        this.mHasThumbTintMode = true;
        applyThumbTint();
    }

    public void setTrackDrawable(Drawable r3) {
        Drawable r0 = this.mTrackDrawable;
        if (r0 == null) goto L5;
        r0.setCallback(null);
    L5:
        this.mTrackDrawable = r3;
        if (r3 == null) goto L8;
        r3.setCallback(this);
    L8:
        requestLayout();
    }

    public void setTrackResource(int r2) {
        setTrackDrawable(AppCompatResources.getDrawable(getContext(), r2));
    }

    public void setTrackTintList(@Nullable ColorStateList r1) {
        this.mTrackTintList = r1;
        this.mHasTrackTint = true;
        applyTrackTint();
    }

    public void setTrackTintMode(@Nullable PorterDuff.Mode r1) {
        this.mTrackTintMode = r1;
        this.mHasTrackTintMode = true;
        applyTrackTint();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable r2) {
        if (super.verifyDrawable(r2) == false) goto L5;
    L10:
        return true;
    L5:
        if (r2 == this.mThumbDrawable) goto L10;
        if (r2 == this.mTrackDrawable) goto L10;
        return false;
    }

    public SwitchCompat(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, androidx.appcompat.R.attr.switchStyle);
    }

    public SwitchCompat(@NonNull Context r12, @Nullable AttributeSet r13, int r14) {
        super(r12, r13, r14);
        this.mThumbTintList = null;
        this.mThumbTintMode = null;
        this.mHasThumbTint = false;
        this.mHasThumbTintMode = false;
        this.mTrackTintList = null;
        this.mTrackTintMode = null;
        this.mHasTrackTint = false;
        this.mHasTrackTintMode = false;
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mTempRect = new Rect();
        ThemeUtils.checkAppCompatTheme(this, getContext());
        TextPaint r2 = new TextPaint(1);
        this.mTextPaint = r2;
        r2.density = getResources().getDisplayMetrics().density;
        TintTypedArray r3 = TintTypedArray.obtainStyledAttributes(r12, r13, androidx.appcompat.R.styleable.SwitchCompat, r14, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r12, androidx.appcompat.R.styleable.SwitchCompat, r13, r3.getWrappedTypeArray(), r14, 0);
        Drawable r4 = r3.getDrawable(androidx.appcompat.R.styleable.SwitchCompat_android_thumb);
        this.mThumbDrawable = r4;
        if (r4 == null) goto L5;
        r4.setCallback(this);
    L5:
        Drawable r5 = r3.getDrawable(androidx.appcompat.R.styleable.SwitchCompat_track);
        this.mTrackDrawable = r5;
        if (r5 == null) goto L8;
        r5.setCallback(this);
    L8:
        this.mTextOn = r3.getText(androidx.appcompat.R.styleable.SwitchCompat_android_textOn);
        this.mTextOff = r3.getText(androidx.appcompat.R.styleable.SwitchCompat_android_textOff);
        this.mShowText = r3.getBoolean(androidx.appcompat.R.styleable.SwitchCompat_showText, true);
        this.mThumbTextPadding = r3.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_thumbTextPadding, 0);
        this.mSwitchMinWidth = r3.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_switchMinWidth, 0);
        this.mSwitchPadding = r3.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_switchPadding, 0);
        this.mSplitTrack = r3.getBoolean(androidx.appcompat.R.styleable.SwitchCompat_splitTrack, false);
        ColorStateList r6 = r3.getColorStateList(androidx.appcompat.R.styleable.SwitchCompat_thumbTint);
        if (r6 == null) goto L11;
        this.mThumbTintList = r6;
        this.mHasThumbTint = true;
    L11:
        PorterDuff.Mode r7 = DrawableUtils.parseTintMode(r3.getInt(androidx.appcompat.R.styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.mThumbTintMode == r7) goto L15;
        this.mThumbTintMode = r7;
        this.mHasThumbTintMode = true;
    L15:
        if (this.mHasThumbTint == false) goto L17;
    L18:
        applyThumbTint();
    L19:
        ColorStateList r8 = r3.getColorStateList(androidx.appcompat.R.styleable.SwitchCompat_trackTint);
        if (r8 == null) goto L22;
        this.mTrackTintList = r8;
        this.mHasTrackTint = true;
    L22:
        PorterDuff.Mode r0 = DrawableUtils.parseTintMode(r3.getInt(androidx.appcompat.R.styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.mTrackTintMode == r0) goto L26;
        this.mTrackTintMode = r0;
        this.mHasTrackTintMode = true;
    L26:
        if (this.mHasTrackTint == false) goto L28;
    L29:
        applyTrackTint();
    L30:
        int r1 = r3.getResourceId(androidx.appcompat.R.styleable.SwitchCompat_switchTextAppearance, 0);
        if (r1 == 0) goto L33;
        setSwitchTextAppearance(r12, r1);
    L33:
        AppCompatTextHelper r9 = new AppCompatTextHelper(this);
        this.mTextHelper = r9;
        r9.loadFromAttributes(r13, r14);
        r3.recycle();
        ViewConfiguration r15 = ViewConfiguration.get(r12);
        this.mTouchSlop = r15.getScaledTouchSlop();
        this.mMinFlingVelocity = r15.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
        return;
    L28:
        if (this.mHasTrackTintMode == false) goto L30;
    L17:
        if (this.mHasThumbTintMode == false) goto L19;
        goto L18
    }

    public void setSwitchTypeface(Typeface r2) {
        if (this.mTextPaint.getTypeface() == null) goto L7;
        if (this.mTextPaint.getTypeface().equals(r2) == true) goto L7;
    L9:
        this.mTextPaint.setTypeface(r2);
        requestLayout();
        invalidate();
        return;
    L7:
        if (this.mTextPaint.getTypeface() != null) goto L11;
        if (r2 != null) goto L9;
        return;
    }
}
