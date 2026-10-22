package com.android.internal.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class KeyguardLockPatternView extends View {
    private static final int ASPECT_LOCK_HEIGHT = 2;
    private static final int ASPECT_LOCK_WIDTH = 1;
    private static final int ASPECT_SQUARE = 0;
    public static final int BRIGHT_MODE_INDOOR = 0;
    public static final int BRIGHT_MODE_OUTER = 1;
    private static final float DRAG_THRESHHOLD = 0.0f;
    private static final int MILLIS_PER_CIRCLE_ANIMATING = 700;
    private static final boolean PROFILE_DRAWING = false;
    private int LINE_WIDTH;
    private int PATTERN_CIRCLE_RADIUS;
    private int PATTERN_CIRCLE_SIZE;
    private int PATTERN_GRID_RADIUS;
    private int PATTERN_GRID_SIZE;
    private int PATTERN_OFFSET_X;
    private int PATTERN_OFFSET_Y;
    private int PATTERN_PATH_OFFSET_X;
    private int PATTERN_PATH_OFFSET_Y;
    private long mAnimatingPeriodStart;
    private int mAspect;
    private int mBackgroundX;
    private int mBackgroundY;
    private Bitmap mBitmapBackground;
    private Bitmap mBitmapBackgroundIndoor;
    private Bitmap mBitmapBackgroundOuter;
    private Bitmap mBitmapBtnDefault;
    private Bitmap mBitmapBtnTouched;
    private Bitmap mBitmapCircleGreen;
    private Bitmap mBitmapCircleGreenIndoor;
    private Bitmap mBitmapCircleGreenOuter;
    private Bitmap mBitmapCircleRed;
    private Bitmap mBitmapCircleRedIndoor;
    private Bitmap mBitmapCircleRedOuter;
    private int mBitmapHeight;
    private int mBitmapWidth;
    private int mBrightMode;
    private final Matrix mCircleMatrix;
    private int mColorRight;
    private int mColorRightIndoor;
    private int mColorRightOuter;
    private int mColorWrong;
    private int mColorWrongIndoor;
    private int mColorWrongOuter;
    private final Path mCurrentPath;
    private float mDiameterFactor;
    private boolean mDrawingProfilingStarted;
    private boolean mEnableHapticFeedback;
    private boolean mHasLoadRes;
    private float mHitFactor;
    private float mInProgressX;
    private float mInProgressY;
    private boolean mInStealthMode;
    private boolean mInputEnabled;
    private final Rect mInvalidate;
    private OnPatternListener mOnPatternListener;
    private Paint mPaint;
    private Paint mPathPaint;
    private Paint mPathPaintWrong;
    private ArrayList<LockPatternView.Cell> mPattern;
    private DisplayMode mPatternDisplayMode;
    private boolean[][] mPatternDrawLookup;
    private boolean mPatternInProgress;
    private float mSquareHeight;
    private float mSquareWidth;
    private final int mStrokeAlpha;
    private final Rect mTmpInvalidateRect;

    /* JADX INFO: renamed from: com.android.internal.widget.KeyguardLockPatternView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final enum DisplayMode extends Enum<DisplayMode> {
        private static final /* synthetic */ DisplayMode[] $VALUES = null;
        public static final DisplayMode Animate = null;
        public static final DisplayMode Correct = null;
        public static final DisplayMode Wrong = null;

        private static /* synthetic */ DisplayMode[] $values() {
            return new DisplayMode[]{Correct, Animate, Wrong};
        }

        private DisplayMode(String r1, int r2) {
            super(r1, r2);
        }

        public static DisplayMode valueOf(String r1) {
            return (DisplayMode) Enum.valueOf(DisplayMode.class, r1);
        }

        public static DisplayMode[] values() {
            return (DisplayMode[]) $VALUES.clone();
        }

        static {
            Correct = new DisplayMode("Correct", 0);
            Animate = new DisplayMode("Animate", 1);
            Wrong = new DisplayMode("Wrong", 2);
            $VALUES = $values();
        }
    }

    public interface OnPatternListener {
        void onPatternCellAdded(List<LockPatternView.Cell> r1);

        void onPatternCleared();

        void onPatternDetected(List<LockPatternView.Cell> r1);

        void onPatternStart();
    }

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        private final int mDisplayMode;
        private final boolean mInStealthMode;
        private final boolean mInputEnabled;
        private final String mSerializedPattern;
        private final boolean mTactileFeedbackEnabled;

        /* synthetic */ SavedState(Parcel r1, AnonymousClass1 r2) {
            this(r1);
        }

        /* synthetic */ SavedState(Parcelable r1, String r2, int r3, boolean r4, boolean r5, boolean r6, AnonymousClass1 r7) {
            this(r1, r2, r3, r4, r5, r6);
        }

        private SavedState(Parcelable r1, String r2, int r3, boolean r4, boolean r5, boolean r6) {
            super(r1);
            this.mSerializedPattern = r2;
            this.mDisplayMode = r3;
            this.mInputEnabled = r4;
            this.mInStealthMode = r5;
            this.mTactileFeedbackEnabled = r6;
        }

        private SavedState(Parcel r3) {
            super(r3);
            this.mSerializedPattern = r3.readString();
            this.mDisplayMode = r3.readInt();
            this.mInputEnabled = ((Boolean) r3.readValue(null)).booleanValue();
            this.mInStealthMode = ((Boolean) r3.readValue(null)).booleanValue();
            this.mTactileFeedbackEnabled = ((Boolean) r3.readValue(null)).booleanValue();
        }

        public String getSerializedPattern() {
            return this.mSerializedPattern;
        }

        public int getDisplayMode() {
            return this.mDisplayMode;
        }

        public boolean isInputEnabled() {
            return this.mInputEnabled;
        }

        public boolean isInStealthMode() {
            return this.mInStealthMode;
        }

        public boolean isTactileFeedbackEnabled() {
            return this.mTactileFeedbackEnabled;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeString(this.mSerializedPattern);
            r1.writeInt(this.mDisplayMode);
            r1.writeValue(Boolean.valueOf(this.mInputEnabled));
            r1.writeValue(Boolean.valueOf(this.mInStealthMode));
            r1.writeValue(Boolean.valueOf(this.mTactileFeedbackEnabled));
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    private LockPatternView.Cell detectAndAddHit(float r1, float r2) {
        return null;
    }

    private void loadResource() {
    }

    private void sendAccessEvent(int r1) {
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent r1) {
        return false;
    }

    public void setBrightMode(int r2) {
        if (r2 == this.mBrightMode) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        this.mBrightMode = r2;
        updateResources();
        requestRedraw();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private void updateResources() {
        if (this.mHasLoadRes == true) goto L6;
        loadResource();
    L6:
        if (this.mBrightMode != 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        Bitmap r1 = this.mBitmapCircleGreenIndoor;
    L12:
        this.mBitmapCircleGreen = r1;
        if (r0 == false) goto L15;
        Bitmap r2 = this.mBitmapCircleRedIndoor;
    L16:
        this.mBitmapCircleRed = r2;
        if (r0 == false) goto L19;
        Bitmap r3 = this.mBitmapBackgroundIndoor;
    L20:
        this.mBitmapBackground = r3;
        if (r0 == false) goto L23;
        int r4 = this.mColorRightIndoor;
    L24:
        this.mColorRight = r4;
        if (r0 == false) goto L27;
        int r5 = this.mColorWrongIndoor;
    L28:
        this.mColorWrong = r5;
        this.mPathPaint.setColor(r4);
        this.mPathPaintWrong.setColor(this.mColorWrong);
        return;
    L27:
        r5 = this.mColorWrongOuter;
        goto L28
    L23:
        r4 = this.mColorRightOuter;
        goto L24
    L19:
        r3 = this.mBitmapBackgroundOuter;
        goto L20
    L15:
        r2 = this.mBitmapCircleRedOuter;
        goto L16
    L11:
        r1 = this.mBitmapCircleGreenOuter;
        goto L12
    L8:
        r0 = false;
        goto L9
    }

    private void requestRedraw() {
        invalidate();
    }

    public KeyguardLockPatternView(Context r2) {
        this(r2, null);
    }

    public KeyguardLockPatternView(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.mDrawingProfilingStarted = false;
        this.mPaint = new Paint();
        this.mPathPaint = new Paint();
        this.mPathPaintWrong = new Paint();
        this.PATTERN_GRID_SIZE = 201;
        this.PATTERN_GRID_RADIUS = 201 / 2;
        this.PATTERN_CIRCLE_SIZE = 40;
        this.PATTERN_CIRCLE_RADIUS = 40 / 2;
        this.PATTERN_OFFSET_X = 0;
        this.PATTERN_OFFSET_Y = 0;
        this.LINE_WIDTH = 10;
        this.PATTERN_PATH_OFFSET_X = 0;
        this.PATTERN_PATH_OFFSET_Y = 0;
        this.mPattern = new ArrayList(9);
        Class r0 = Boolean.TYPE;
        this.mPatternDrawLookup = (boolean[][]) Array.newInstance(r0, new int[]{3, 3});
        this.mInProgressX = -1.0f;
        this.mInProgressY = -1.0f;
        this.mPatternDisplayMode = DisplayMode.Correct;
        this.mInputEnabled = true;
        this.mInStealthMode = false;
        this.mEnableHapticFeedback = true;
        this.mPatternInProgress = false;
        this.mDiameterFactor = 0.1f;
        this.mStrokeAlpha = 128;
        this.mHitFactor = 0.6f;
        this.mCurrentPath = new Path();
        this.mInvalidate = new Rect();
        this.mTmpInvalidateRect = new Rect();
        this.mBackgroundX = 0;
        this.mBackgroundY = 0;
        this.mCircleMatrix = new Matrix();
        this.mBrightMode = 0;
    }

    public void setInStealthMode(boolean r1) {
        this.mInStealthMode = r1;
    }

    public void setOnPatternListener(OnPatternListener r1) {
        this.mOnPatternListener = r1;
    }

    public void setPattern(DisplayMode r4, List<LockPatternView.Cell> r5) {
        this.mPattern.clear();
        this.mPattern.addAll(r5);
        clearPatternDrawLookup();
        Iterator<LockPatternView.Cell> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        LockPatternView.Cell r0 = r6.next();
        this.mPatternDrawLookup[r0.getRow()][r0.getColumn()] = true;
        goto L4
    L6:
        setDisplayMode(r4);
    }

    public void setDisplayMode(DisplayMode r3) {
        this.mPatternDisplayMode = r3;
        if (r3 == DisplayMode.Animate) goto L5;
    L9:
        invalidate();
        return;
    L5:
        if (this.mPattern.size() == 0) goto L8;
        this.mAnimatingPeriodStart = SystemClock.elapsedRealtime();
        LockPatternView.Cell r4 = this.mPattern.get(0);
        this.mInProgressX = getCenterXForColumn(r4.getColumn());
        this.mInProgressY = getCenterYForRow(r4.getRow());
        clearPatternDrawLookup();
        goto L9
    L8:
        throw new IllegalStateException("you must have a pattern to animate if you want to set the display mode to animate");
    }

    private void notifyCellAdded() {
        OnPatternListener r0 = this.mOnPatternListener;
        if (r0 == null) goto L6;
        r0.onPatternCellAdded(this.mPattern);
        return;
    }

    private void notifyPatternStarted() {
        OnPatternListener r0 = this.mOnPatternListener;
        if (r0 == null) goto L6;
        r0.onPatternStart();
        return;
    }

    private void notifyPatternDetected() {
        OnPatternListener r0 = this.mOnPatternListener;
        if (r0 == null) goto L6;
        r0.onPatternDetected(this.mPattern);
        return;
    }

    private void notifyPatternCleared() {
        OnPatternListener r0 = this.mOnPatternListener;
        if (r0 == null) goto L6;
        r0.onPatternCleared();
        return;
    }

    public void clearPattern() {
        resetPattern();
    }

    private void resetPattern() {
        this.mPattern.clear();
        clearPatternDrawLookup();
        this.mPatternDisplayMode = DisplayMode.Correct;
        invalidate();
    }

    private void clearPatternDrawLookup() {
        int r1 = 0;
    L4:
        if (r1 >= 3) goto L9;
        int r3 = 0;
    L6:
        if (r3 >= 3) goto L8;
        this.mPatternDrawLookup[r1][r3] = false;
        r3 = r3 + 1;
        goto L6
    L8:
        r1 = r1 + 1;
        goto L4
    }

    public void disableInput() {
        this.mInputEnabled = false;
    }

    public void enableInput() {
        this.mInputEnabled = true;
    }

    @Override // android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        this.mSquareWidth = this.mBitmapBackground.getWidth() / 3.0f;
        this.mSquareHeight = this.mBitmapBackground.getHeight() / 3.0f;
    }

    private int resolveMeasured(int r2, int r3) {
        int r1 = View.MeasureSpec.getSize(r2);
        int r4 = View.MeasureSpec.getMode(r2);
        if (r4 == Integer.MIN_VALUE) goto L7;
        if (r4 != 0) goto L9;
        return r3;
    L9:
        return r1;
    L7:
        return Math.max(r1, r3);
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return this.mBitmapWidth * 3;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return this.mBitmapWidth * 3;
    }

    @Override // android.view.View
    protected void onMeasure(int r3, int r4) {
        int r0 = getSuggestedMinimumWidth();
        int r1 = getSuggestedMinimumHeight();
        int r5 = resolveMeasured(r3, r0);
        int r6 = resolveMeasured(r4, r1);
        int r2 = this.mAspect;
        if (r2 != 0) goto L5;
        r5 = Math.min(r5, r6);
        r6 = r5;
    L12:
        setMeasuredDimension(r5, r6);
        return;
    L5:
        if (r2 != 1) goto L7;
        r6 = Math.min(r5, r6);
        goto L12
    L7:
        if (r2 != 2) goto L12;
        r5 = Math.min(r5, r6);
        goto L12
    }

    private void addCellToPattern(LockPatternView.Cell r4) {
        this.mPatternDrawLookup[r4.getRow()][r4.getColumn()] = true;
        this.mPattern.add(r4);
        notifyCellAdded();
    }

    private LockPatternView.Cell checkForNewHit(float r2, float r3) {
        int r4 = getRowHit(r3);
        if (r4 >= 0) goto L5;
        return null;
    L5:
        int r5 = getColumnHit(r2);
        if (r5 >= 0) goto L9;
        return null;
    L9:
        if (this.mPatternDrawLookup[r4][r5] == false) goto L12;
        return null;
    L12:
        return LockPatternView.Cell.of(r4, r5);
    }

    private int getRowHit(float r6) {
        float r0 = this.mSquareHeight * this.mHitFactor;
        int r1 = 0;
    L4:
        if (r1 >= 3) goto L11;
        float r2 = getCenterYForRow(r1);
        float r3 = r0 / 2.0f;
        if (r6 < (r2 - r3)) goto L10;
        if (r6 > (r2 + r3)) goto L10;
        return r1;
    L10:
        r1 = r1 + 1;
        goto L4
    L11:
        return -1;
    }

    private int getColumnHit(float r6) {
        float r0 = this.mSquareWidth * this.mHitFactor;
        int r1 = 0;
    L4:
        if (r1 >= 3) goto L11;
        float r2 = getCenterXForColumn(r1);
        float r3 = r0 / 2.0f;
        if (r6 < (r2 - r3)) goto L10;
        if (r6 > (r2 + r3)) goto L10;
        return r1;
    L10:
        r1 = r1 + 1;
        goto L4
    L11:
        return -1;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        if (this.mInputEnabled == true) goto L5;
    L25:
        return false;
    L5:
        if (isEnabled() == false) goto L25;
        int r0 = r5.getAction();
        if (r0 == 0) goto L23;
        if (r0 != 1) goto L11;
        handleActionUp(r5);
        return true;
    L11:
        if (r0 != 2) goto L13;
        handleActionMove(r5);
        return true;
    L13:
        if (r0 == 3) goto L16;
        return false;
    L16:
        if (this.mPatternInProgress == false) goto L18;
        this.mPatternInProgress = false;
        resetPattern();
        notifyPatternCleared();
    L18:
        return true;
    L23:
        handleActionDown(r5);
        return true;
    }

    private void handleActionMove(MotionEvent r15) {
        float r0 = (this.mSquareWidth * this.mDiameterFactor) * 0.5f;
        int r2 = r15.getHistorySize();
        this.mTmpInvalidateRect.setEmpty();
        int r3 = 0;
        boolean r4 = false;
    L4:
        if (r3 >= (r2 + 1)) goto L28;
        if (r3 >= r2) goto L7;
        float r5 = r15.getHistoricalX(r3);
    L8:
        if (r3 >= r2) goto L10;
        float r6 = r15.getHistoricalY(r3);
    L11:
        LockPatternView.Cell r7 = detectAndAddHit(r5, r6);
        int r8 = this.mPattern.size();
        if (r7 == null) goto L15;
        if (r8 != 1) goto L15;
        this.mPatternInProgress = true;
        notifyPatternStarted();
    L15:
        float r10 = Math.abs(r5 - this.mInProgressX);
        float r11 = Math.abs(r6 - this.mInProgressY);
        if (r10 <= 0.0f) goto L18;
    L19:
        r4 = true;
    L21:
        if (this.mPatternInProgress == false) goto L27;
        if (r8 <= 0) goto L27;
        LockPatternView.Cell r9 = this.mPattern.get(r8 - 1);
        float r12 = getCenterXForColumn(r9.getColumn());
        float r13 = getCenterYForRow(r9.getRow());
        float r14 = Math.min(r12, r5) - r0;
        float r16 = Math.max(r12, r5) + r0;
        float r17 = Math.min(r13, r6) - r0;
        float r18 = Math.max(r13, r6) + r0;
        if (r7 == null) goto L26;
        float r19 = this.mSquareWidth * 0.5f;
        float r110 = this.mSquareHeight * 0.5f;
        float r111 = getCenterXForColumn(r7.getColumn());
        float r20 = getCenterYForRow(r7.getRow());
        r14 = Math.min(r111 - r19, r14);
        r16 = Math.max(r111 + r19, r16);
        r17 = Math.min(r20 - r110, r17);
        r18 = Math.max(r20 + r110, r18);
    L26:
        this.mTmpInvalidateRect.union(Math.round(r14), Math.round(r17), Math.round(r16), Math.round(r18));
    L27:
        r3 = r3 + 1;
        goto L4
    L18:
        if (r11 <= 0.0f) goto L21;
    L10:
        r6 = r15.getY();
        goto L11
    L7:
        r5 = r15.getX();
        goto L8
    L28:
        this.mInProgressX = r15.getX();
        this.mInProgressY = r15.getY();
        if (r4 == false) goto L36;
        this.mInvalidate.union(this.mTmpInvalidateRect);
        invalidate(this.mInvalidate);
        this.mInvalidate.set(this.mTmpInvalidateRect);
        return;
    }

    private void handleActionUp(MotionEvent r1) {
        if (this.mPattern.isEmpty() == true) goto L6;
        this.mPatternInProgress = false;
        notifyPatternDetected();
        invalidate();
        return;
    }

    private void handleActionDown(MotionEvent r8) {
        resetPattern();
        float r0 = r8.getX();
        float r9 = r8.getY();
        LockPatternView.Cell r1 = detectAndAddHit(r0, r9);
        if (r1 == null) goto L6;
        this.mPatternInProgress = true;
        this.mPatternDisplayMode = DisplayMode.Correct;
        notifyPatternStarted();
    L8:
        if (r1 == null) goto L10;
        float r2 = getCenterXForColumn(r1.getColumn());
        float r3 = getCenterYForRow(r1.getRow());
        float r4 = this.mSquareWidth / 2.0f;
        float r5 = this.mSquareHeight / 2.0f;
        invalidate((int) (r2 - r4), (int) (r3 - r5), (int) (r2 + r4), (int) (r3 + r5));
    L10:
        this.mInProgressX = r0;
        this.mInProgressY = r9;
        return;
    L6:
        if (this.mPatternInProgress == false) goto L8;
        this.mPatternInProgress = false;
        notifyPatternCleared();
        goto L8
    }

    private float getCenterXForColumn(int r3) {
        return (((this.PATTERN_OFFSET_X + (r3 * this.PATTERN_GRID_SIZE)) + this.PATTERN_GRID_RADIUS) + this.PATTERN_PATH_OFFSET_X) + this.mBackgroundX;
    }

    private float getCenterYForRow(int r3) {
        return (((this.PATTERN_OFFSET_Y + (r3 * this.PATTERN_GRID_SIZE)) + this.PATTERN_GRID_RADIUS) + this.PATTERN_PATH_OFFSET_Y) + this.mBackgroundY;
    }

    @Override // android.view.View
    protected void onDraw(Canvas r13) {
        if (this.mHasLoadRes == true) goto L5;
        loadResource();
    L5:
        ArrayList<LockPatternView.Cell> r0 = this.mPattern;
        int r1 = r0.size();
        boolean[][] r2 = this.mPatternDrawLookup;
        this.mBackgroundX = (getWidth() - this.mBitmapBackground.getWidth()) / 2;
        int r3 = (getHeight() - this.mBitmapBackground.getHeight()) / 2;
        this.mBackgroundY = r3;
        r13.drawBitmap(this.mBitmapBackground, this.mBackgroundX, r3, this.mPaint);
        if (this.mPatternDisplayMode != DisplayMode.Animate) goto L17;
        int r4 = ((int) (SystemClock.elapsedRealtime() - this.mAnimatingPeriodStart)) % ((r1 + 1) * 700);
        int r5 = r4 / 700;
        clearPatternDrawLookup();
        int r7 = 0;
    L8:
        if (r7 >= r5) goto L10;
        LockPatternView.Cell r8 = r0.get(r7);
        r2[r8.getRow()][r8.getColumn()] = true;
        r7 = r7 + 1;
        goto L8
    L10:
        if (r5 <= 0) goto L13;
        if (r5 >= r1) goto L13;
        boolean r9 = true;
    L14:
        if (r9 == false) goto L16;
        float r6 = (r4 % 700) / 700.0f;
        LockPatternView.Cell r10 = r0.get(r5 - 1);
        float r11 = getCenterXForColumn(r10.getColumn());
        float r12 = getCenterYForRow(r10.getRow());
        LockPatternView.Cell r14 = r0.get(r5);
        float r15 = (getCenterXForColumn(r14.getColumn()) - r11) * r6;
        float r16 = r6 * (getCenterYForRow(r14.getRow()) - r12);
        this.mInProgressX = r11 + r15;
        this.mInProgressY = r12 + r16;
    L16:
        invalidate();
    L13:
        r9 = false;
    L17:
        this.mPathPaint.setStrokeWidth(this.LINE_WIDTH);
        this.mPathPaintWrong.setStrokeWidth(this.LINE_WIDTH);
        Path r17 = this.mCurrentPath;
        r17.rewind();
        if (this.mInStealthMode == true) goto L20;
    L23:
        boolean r18 = true;
    L25:
        if ((this.mPaint.getFlags() & 2) == 0) goto L27;
        boolean r19 = true;
    L28:
        this.mPaint.setFilterBitmap(true);
        if (r18 == false) goto L50;
        int r20 = 0;
        boolean r21 = false;
    L31:
        if (r20 >= r1) goto L41;
        LockPatternView.Cell r22 = r0.get(r20);
        if (r2[r22.getRow()][r22.getColumn()] == false) goto L41;
        float r23 = getCenterXForColumn(r22.getColumn());
        float r24 = getCenterYForRow(r22.getRow());
        if (r20 != 0) goto L38;
        r17.moveTo(r23, r24);
    L39:
        r20 = r20 + 1;
        r21 = true;
        goto L31
    L38:
        r17.lineTo(r23, r24);
    L41:
        if (this.mPatternInProgress == false) goto L43;
    L44:
        if (r21 == false) goto L47;
        r17.lineTo(this.mInProgressX, this.mInProgressY);
    L47:
        if (this.mPatternDisplayMode != DisplayMode.Wrong) goto L49;
        r13.drawPath(r17, this.mPathPaintWrong);
        goto L50
    L49:
        r13.drawPath(r17, this.mPathPaint);
        goto L50
    L43:
        if (this.mPatternDisplayMode != DisplayMode.Animate) goto L47;
    L50:
        int r25 = 0;
    L52:
        if (r25 >= 3) goto L57;
        float r26 = (this.mBackgroundX + this.PATTERN_OFFSET_X) + (this.PATTERN_GRID_SIZE * r25);
        int r27 = 0;
    L54:
        if (r27 >= 3) goto L56;
        drawCircle(r13, (this.mBackgroundY + this.PATTERN_OFFSET_Y) + (this.PATTERN_GRID_SIZE * r27), (int) r26, r2[r25][r27]);
        r27 = r27 + 1;
        goto L54
    L56:
        r25 = r25 + 1;
        goto L52
    L57:
        this.mPaint.setFilterBitmap(r19);
        return;
    L27:
        r19 = false;
        goto L28
    L20:
        if (this.mPatternDisplayMode == DisplayMode.Wrong) goto L23;
        r18 = false;
        goto L25
    }

    private void drawCircle(Canvas r7, int r8, int r9, boolean r10) {
        if (r10 == true) goto L4;
        return;
    L4:
        if (this.mInStealthMode == false) goto L9;
        if (this.mPatternDisplayMode == DisplayMode.Wrong) goto L9;
        return;
    L9:
        if (this.mPatternInProgress == false) goto L12;
        Bitmap r11 = this.mBitmapCircleGreen;
    L22:
        int r0 = this.mBitmapWidth;
        int r1 = this.mBitmapHeight;
        float r2 = this.mSquareWidth;
        int r4 = (int) ((r2 - r0) / 2.0f);
        int r3 = (int) ((this.mSquareHeight - r1) / 2.0f);
        float r5 = Math.min(r2 / r0, 1.0f);
        float r6 = Math.min(this.mSquareHeight / this.mBitmapHeight, 1.0f);
        this.mCircleMatrix.setTranslate(r4 + r8, r3 + r9);
        this.mCircleMatrix.preTranslate(this.mBitmapWidth / 2, this.mBitmapHeight / 2);
        this.mCircleMatrix.preScale(r5, r6);
        this.mCircleMatrix.preTranslate((-this.mBitmapWidth) / 2, (-this.mBitmapHeight) / 2);
        int r12 = this.PATTERN_GRID_RADIUS - this.PATTERN_CIRCLE_RADIUS;
        r7.drawBitmap(r11, r8 + r12, r9 + r12, this.mPaint);
        return;
    L12:
        if (this.mPatternDisplayMode != DisplayMode.Wrong) goto L15;
        r11 = this.mBitmapCircleRed;
        goto L22
    L15:
        if (this.mPatternDisplayMode != DisplayMode.Correct) goto L17;
    L21:
        r11 = this.mBitmapCircleGreen;
        goto L22
    L17:
        if (this.mPatternDisplayMode == DisplayMode.Animate) goto L21;
        throw new IllegalStateException("unknown display mode " + this.mPatternDisplayMode);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), new String(LockPatternUtils.patternToByteArray(this.mPattern)), this.mPatternDisplayMode.ordinal(), this.mInputEnabled, this.mInStealthMode, this.mEnableHapticFeedback, null);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r3) {
        SavedState r4 = (SavedState) r3;
        super.onRestoreInstanceState(r4.getSuperState());
        DisplayMode r0 = DisplayMode.Correct;
        if (r4.getSerializedPattern() != null) goto L5;
        byte[] r1 = null;
    L6:
        setPattern(r0, LockPatternUtils.byteArrayToPattern(r1));
        this.mPatternDisplayMode = DisplayMode.values()[r4.getDisplayMode()];
        this.mInputEnabled = r4.isInputEnabled();
        this.mInStealthMode = r4.isInStealthMode();
        this.mEnableHapticFeedback = r4.isTactileFeedbackEnabled();
        return;
    L5:
        r1 = r4.getSerializedPattern().getBytes();
        goto L6
    }
}
