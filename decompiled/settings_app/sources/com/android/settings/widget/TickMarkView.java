package com.android.settings.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class TickMarkView extends View {
    static final boolean DBG = false;
    private static final int DEFAULT_HEIGHT = 82;
    private static final int DEFAULT_WIDTH = 1080;
    private static final int DEF_MARKER_SIZE = 5;
    private static final int LABEL_BOTTOM_MARGIN = 8;
    static final int LABEL_COLOR_SELECTED = 0;
    static final int LABEL_COLOR_UNSELECTED = 0;
    static final int LABEL_FOCUS_TEXT_SIZE = 0;
    private static final int LABEL_INNER_TRANSABLE_Y = 8;
    static final int LABEL_TEXT_SIZE = 0;
    private static final int LABEL_TOP_MARGIN = 16;
    private static final int PAINT_STROKE_WIDTH = 6;
    private static final String TAG = "TickMarkView";
    private static int sDefaultHeight;
    private static int sLabelBottomMargin;
    private static int sLabelInnerTransableY;
    private static int sLabelTopMargin;
    private static int sLabelTransYMax;
    private static int sLabelTransYMin;
    Drawable mBridgeDrawable;
    private int mCurrentMarker;
    private Drawable mEndMarkerDrawable;
    private int mFocusedMarker;
    private int mHeight;
    private boolean mIsDragging;
    private Paint.FontMetrics mLabelFontMetrics;
    private Paint mLabelPaint;
    private OnMarkerChangeListener mMarkerChangeListener;
    private int mMarkerDistance;
    private int mMarkerDrawableHeight;
    private int mMarkerDrawableWidth;
    private String[] mMarkerLabels;
    private int mMarkerSize;
    private ArrayList<Marker> mMarkers;
    private Drawable mMidMarkerDrawable;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private int mScaledTouchSlop;
    private Drawable mStartMarkerDrawable;
    private Paint mTestPaint;
    private Drawable mThumb;
    private int mThumbCenterMaxX;
    private int mThumbCenterMinX;
    private int mThumbCenterX;
    private int mThumbCenterY;
    private int mThumbDrawableHeight;
    private int mThumbDrawableWidth;
    private float mTouchDownX;
    private TrackTouchListener mTrackListener;
    private int mWidth;

    class Marker {
        private static final int DELAY_MILLS = 10;
        private static final float MOVE_SPEED = 4.0f;
        static final int TYPE_END = 2;
        static final int TYPE_MID = 1;
        static final int TYPE_START = 0;
        int centerX;
        int centerY;
        boolean focused;
        int index;
        String label;
        int labelColor;
        float labelTransY;
        final /* synthetic */ TickMarkView this$0;
        int type;

        Marker(TickMarkView r1) {
            this.this$0 = r1;
            this.labelTransY = TickMarkView.access$000();
            this.labelColor = TickMarkView.LABEL_COLOR_UNSELECTED;
        }

        public void animateLabel(final boolean r5) {
            boolean r1 = false;
            if (this.focused == false) goto L11;
            this.labelColor = TickMarkView.LABEL_COLOR_SELECTED;
            if (r5 == false) goto L7;
            this.labelTransY -= MOVE_SPEED;
        L9:
            if (this.labelTransY >= TickMarkView.access$100()) goto L18;
            this.labelTransY = TickMarkView.access$100();
        L19:
            if (r1 == false) goto L21;
            this.this$0.postDelayed(new AnonymousClass1(this, r5), 10);
        L21:
            this.this$0.invalidate();
            return;
        L18:
            r1 = true;
            goto L19
        L7:
            this.labelTransY = TickMarkView.access$100() - 1;
            goto L9
        L11:
            this.labelColor = TickMarkView.LABEL_COLOR_UNSELECTED;
            if (r5 == false) goto L14;
            this.labelTransY += MOVE_SPEED;
        L16:
            if (this.labelTransY <= TickMarkView.access$000()) goto L18;
            this.labelTransY = TickMarkView.access$000();
            goto L19
        L14:
            this.labelTransY = TickMarkView.access$000() + 1;
            goto L16
        }
    }

    public interface OnMarkerChangeListener {
        void onMarkerChanged(int r1);
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int currentMarker;

        public SavedState(Parcel r1) {
            super(r1);
            this.currentMarker = r1.readInt();
        }

        public SavedState(Parcelable r1) {
            super(r1);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.currentMarker);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    interface TrackTouchListener {
        void onStartTrack(MotionEvent r1);

        void onStopTrack(MotionEvent r1);
    }

    void drawDebugLineIfDebugMode(Canvas r1) {
    }

    static /* synthetic */ int access$000() {
        return sLabelTransYMax;
    }

    static /* synthetic */ int access$100() {
        return sLabelTransYMin;
    }

    static {
        LABEL_COLOR_SELECTED = Color.parseColor("#cc000000");
        LABEL_COLOR_UNSELECTED = Color.parseColor("#cc000000");
        LABEL_TEXT_SIZE = SettingsApplication.getContext().getResources().getDimensionPixelSize(R.dimen.tick_mark_view_label);
        LABEL_FOCUS_TEXT_SIZE = SettingsApplication.getContext().getResources().getDimensionPixelSize(R.dimen.tick_mark_view_label_focus);
    }

    public TickMarkView(Context r2) {
        this(r2, null);
    }

    public TickMarkView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public TickMarkView(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public TickMarkView(Context r4, AttributeSet r5, int r6, int r7) {
        super(r4, r5, r6, r7);
        initStaticConstants();
        TypedArray r8 = r4.obtainStyledAttributes(r5, R.styleable.TickMarkView, r6, r7);
        int r9 = r8.getInt(4, 5);     // Catch: Throwable -> L13
        this.mMarkerSize = r9;     // Catch: Throwable -> L13
        verifyMarkerSize(r9);     // Catch: Throwable -> L13
        initMarkers();     // Catch: Throwable -> L13
        this.mCurrentMarker = r8.getInt(3, 0);     // Catch: Throwable -> L13
        int r10 = r8.getResourceId(2, 0);     // Catch: Throwable -> L13
        if (r10 <= 0) goto L10;
        String[] r11 = getResources().getStringArray(r10);     // Catch: Throwable -> L13
        if (r11.length != this.mMarkerSize) goto L9;
        setMarkerLabels(r11);     // Catch: Throwable -> L13
        goto L10
    L9:
        throw new IllegalArgumentException("illegal argument, the labels array length should be equals with markerSize.");     // Catch: Throwable -> L13
    L10:
        this.mStartMarkerDrawable = getResources().getDrawable(r8.getResourceId(6, R.drawable.progress_track_segment_left));     // Catch: Throwable -> L13
        this.mEndMarkerDrawable = getResources().getDrawable(r8.getResourceId(1, R.drawable.progress_track_segment_right));     // Catch: Throwable -> L13
        this.mMidMarkerDrawable = getResources().getDrawable(r8.getResourceId(5, R.drawable.progress_track_segment_dot));     // Catch: Throwable -> L13
        this.mBridgeDrawable = getResources().getDrawable(r8.getResourceId(0, R.drawable.progress_track_segment_middle));     // Catch: Throwable -> L13
        this.mThumb = getResources().getDrawable(r8.getResourceId(7, R.drawable.color_seekbar_thumb_selector));     // Catch: Throwable -> L13
        initLabelPaintParams();     // Catch: Throwable -> L13
        r8.recycle();
        this.mScaledTouchSlop = ViewConfiguration.get(r4).getScaledTouchSlop();
        this.mPaddingLeft = getPaddingLeft();
        this.mPaddingRight = getPaddingRight();
        this.mPaddingTop = getPaddingTop();
        this.mMarkerDrawableWidth = this.mStartMarkerDrawable.getIntrinsicWidth();
        this.mMarkerDrawableHeight = this.mStartMarkerDrawable.getIntrinsicHeight();
        getThumbSize();
        return;
    L13:
        th = move-exception;
        r8.recycle();
        throw th;
    }

    private void initStaticConstants() {
        sDefaultHeight = dp2px(getContext(), 82);
        sLabelTopMargin = dp2px(getContext(), 16);
        sLabelBottomMargin = dp2px(getContext(), 8);
        int r2 = dp2px(getContext(), 8);
        sLabelInnerTransableY = r2;
        sLabelTransYMin = 0;
        sLabelTransYMax = 0 + r2;
    }

    private void getThumbSize() {
        this.mThumbDrawableWidth = this.mThumb.getIntrinsicWidth();
        this.mThumbDrawableHeight = this.mThumb.getIntrinsicHeight();
    }

    public void setOnMarkerChangeListener(OnMarkerChangeListener r1) {
        this.mMarkerChangeListener = r1;
    }

    private void initLabelPaintParams() {
        if (this.mLabelPaint != null) goto L5;
        this.mLabelPaint = new Paint();
    L5:
        this.mLabelPaint.reset();
        this.mLabelPaint.setTextSize(LABEL_TEXT_SIZE);
        this.mLabelPaint.setStyle(Paint.Style.FILL);
        this.mLabelPaint.setAntiAlias(true);
        this.mLabelPaint.setTextAlign(Paint.Align.CENTER);
        this.mLabelFontMetrics = this.mLabelPaint.getFontMetrics();
    }

    private void initMarkers() {
        if (this.mMarkers != null) goto L5;
        this.mMarkers = new ArrayList(this.mMarkerSize);
    L5:
        this.mMarkers.clear();
        int r1 = 0;
    L7:
        if (r1 >= this.mMarkerSize) goto L16;
        Marker r2 = new Marker(this);
        if (r1 != 0) goto L12;
        r2.type = 0;
    L15:
        r2.index = r1;
        this.mMarkers.add(r2);
        r1 = r1 + 1;
        goto L7
    L12:
        if (r1 != (this.mMarkerSize - 1)) goto L14;
        r2.type = 2;
        goto L15
    L14:
        r2.type = 1;
        goto L15
    L16:
        this.mMarkers.trimToSize();
    }

    private void initMarkerLocation() {
        initMarkerDistance();
        int r0 = 0;
    L4:
        if (r0 >= this.mMarkerSize) goto L6;
        Marker r1 = this.mMarkers.get(r0);
        r1.centerX = this.mThumbCenterMinX + (this.mMarkerDistance * r0);
        r1.centerY = this.mThumbCenterY;
        r0 = r0 + 1;
        goto L4
    }

    public void setMarkerLabels(String[] r1) {
        this.mMarkerLabels = r1;
        invalidate();
    }

    public void setMarkerLabels(String r5, String r6, String r7, int r8, int r9) {
        this.mMarkerLabels = new String[r9];
        int r1 = 1;
    L3:
        if (r1 >= r9) goto L5;
        this.mMarkerLabels[r1] = "";
        r1 = r1 + 1;
        goto L3
    L5:
        String[] r2 = this.mMarkerLabels;
        r2[0] = r5;
        r2[r8] = r7;
        r2[r9 - 1] = r6;
        invalidate();
    }

    public void setMarkerSize(int r2) {
        verifyMarkerSize(r2);
        if (r2 != this.mMarkerSize) goto L5;
        return;
    L5:
        this.mMarkerSize = r2;
        initMarkers();
        initMarkerLocation();
    }

    public int getMarkerSize() {
        return this.mMarkerSize;
    }

    private boolean verifyMarkerSize(int r1) {
        if (r1 < 2) goto L7;
        return true;
    L7:
        throw new IllegalArgumentException("illegal marker size, the min marker size should be 2");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        if (isEnabled() == true) goto L5;
        return false;
    L5:
        int r0 = r5.getAction();
        if (r0 == 0) goto L32;
        if (r0 == 1) goto L27;
        if (r0 == 2) goto L18;
        if (r0 == 3) goto L14;
    L38:
        return true;
    L14:
        if (this.mIsDragging == false) goto L16;
        trackTouchEvent(r5);
        onStopTrackingTouch(r5);
        setPressed(false);
    L16:
        invalidate();
        goto L38
    L18:
        if (this.mIsDragging == false) goto L21;
        trackTouchEvent(r5);
        goto L38
    L21:
        if (Math.abs(r5.getX() - this.mTouchDownX) <= this.mScaledTouchSlop) goto L38;
        setPressed(true);
        Drawable r1 = this.mThumb;
        if (r1 == null) goto L25;
        invalidate(r1.getBounds());
    L25:
        onStartTrackingTouch(r5);
        trackTouchEvent(r5);
        attemptClaimDrag();
        goto L38
    L27:
        if (this.mIsDragging == false) goto L29;
        trackTouchEvent(r5);
        onStopTrackingTouch(r5);
        setPressed(false);
    L30:
        invalidate();
        goto L38
    L29:
        onStartTrackingTouch(r5);
        trackTouchEvent(r5);
        onStopTrackingTouch(r5);
        goto L30
    L32:
        if (isInScrollingContainer() == false) goto L34;
        this.mTouchDownX = r5.getX();
        goto L38
    L34:
        setPressed(true);
        Drawable r2 = this.mThumb;
        if (r2 == null) goto L37;
        invalidate(r2.getBounds());
    L37:
        onStartTrackingTouch(r5);
        trackTouchEvent(r5);
        attemptClaimDrag();
        goto L38
    }

    private void trackTouchEvent(MotionEvent r4) {
        int r0 = getThumbCenterXByTouchEvent(r4);
        this.mThumbCenterX = r0;
        int r1 = thumbCenterXToMarkerIndex(r0);
        if (r1 == this.mFocusedMarker) goto L5;
        markerFocusChanged(r1, true);
    L5:
        this.mFocusedMarker = r1;
        int r5 = r4.getAction();
        if (r5 != 1) goto L8;
    L11:
        setMarker(r1);
        return;
    L8:
        if (r5 == 3) goto L11;
        updateThumbBounds();
    }

    int getThumbCenterXByTouchEvent(MotionEvent r2) {
        int r3 = (int) r2.getX();
        int r0 = this.mThumbCenterMinX;
        if (r3 < r0) goto L9;
        int r1 = this.mThumbCenterMaxX;
        if (r3 > r1) goto L8;
        return r3;
    L8:
        return r1;
    L9:
        return r0;
    }

    private void updateThumbBounds() {
        Drawable r0 = this.mThumb;
        if (r0 == null) goto L5;
        int r1 = this.mThumbCenterX;
        int r2 = this.mThumbDrawableWidth;
        int r4 = this.mThumbCenterY;
        int r5 = this.mThumbDrawableHeight;
        r0.setBounds(r1 - (r2 / 2), r4 - (r5 / 2), r1 + (r2 / 2), r4 + (r5 / 2));
    L5:
        invalidate();
    }

    public void setMarker(int r4) {
        if (r4 < 0) goto L13;
        if (r4 > (this.mMarkerSize - 1)) goto L13;
        this.mThumbCenterX = markerIndexToThumbCenterX(r4);
        updateThumbBounds();
        if (this.mCurrentMarker == r4) goto L10;
        OnMarkerChangeListener r0 = this.mMarkerChangeListener;
        if (r0 == null) goto L10;
        r0.onMarkerChanged(r4);
    L10:
        this.mCurrentMarker = r4;
        markerFocusChanged(r4, false);
        return;
    L13:
        throw new IllegalArgumentException("invalid marker index=" + r4 + ", the index should between 0 and " + (this.mMarkerSize - 1));
    }

    private int markerIndexToThumbCenterX(int r1) {
        return this.mMarkers.get(r1).centerX;
    }

    int thumbCenterXToMarkerIndex(int r2) {
        return Math.round(((r2 - this.mThumbCenterMinX) * 1.0f) / this.mMarkerDistance);
    }

    private void attemptClaimDrag() {
        if (this.mParent == null) goto L6;
        this.mParent.requestDisallowInterceptTouchEvent(true);
        return;
    }

    void onStartTrackingTouch(MotionEvent r2) {
        this.mIsDragging = true;
        TrackTouchListener r1 = this.mTrackListener;
        if (r1 == null) goto L6;
        r1.onStartTrack(r2);
        return;
    }

    void onStopTrackingTouch(MotionEvent r2) {
        this.mIsDragging = false;
        TrackTouchListener r1 = this.mTrackListener;
        if (r1 == null) goto L6;
        r1.onStopTrack(r2);
        return;
    }

    void setTrackTouchListener(TrackTouchListener r1) {
        this.mTrackListener = r1;
    }

    @Override // android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.mWidth = r1;
        this.mHeight = r2;
        initThumbCenterRange();
        initMarkerLocation();
        updateThumbPosInnerIfSizeChanged();
    }

    void updateThumbPosInnerIfSizeChanged() {
        updateThumbCenter(markerIndexToThumbCenterX(this.mCurrentMarker), this.mThumbCenterY);
    }

    @Override // android.view.View
    protected void onMeasure(int r3, int r4) {
        int r0 = View.MeasureSpec.getMode(r3);
        int r1 = View.MeasureSpec.getMode(r4);
        int r5 = View.MeasureSpec.getSize(r3);
        int r6 = View.MeasureSpec.getSize(r4);
        if (r0 != 0) goto L5;
        this.mWidth = DEFAULT_WIDTH;
    L6:
        if (r1 != 0) goto L8;
        this.mHeight = sDefaultHeight;
    L9:
        setMeasuredDimension(this.mWidth, this.mHeight);
        initThumbCenterRange();
        initMarkerLocation();
        setMarker(this.mCurrentMarker);
        return;
    L8:
        this.mHeight = r6;
        goto L9
    L5:
        this.mWidth = r5;
        goto L6
    }

    private void initThumbCenterRange() {
        int r0 = this.mWidth;
        int r1 = this.mPaddingLeft;
        int r2 = (r0 - r1) - this.mPaddingRight;
        int r3 = this.mThumbDrawableWidth;
        this.mThumbCenterMinX = (r3 / 2) + r1;
        this.mThumbCenterMaxX = (r1 + r2) - (r3 / 2);
        int r4 = (int) (this.mLabelFontMetrics.descent - this.mLabelFontMetrics.ascent);
        this.mThumbCenterY = ((((this.mPaddingTop + sLabelTopMargin) + r4) + sLabelInnerTransableY) + (this.mMarkerDrawableHeight / 2)) + sLabelBottomMargin;
    }

    int getThumbMinX() {
        return this.mThumbCenterMinX;
    }

    int getThumbMaxX() {
        return this.mThumbCenterMaxX;
    }

    int getThumbY() {
        return this.mThumbCenterY;
    }

    int getThumbX() {
        return this.mThumbCenterX;
    }

    void updateThumbCenter(int r1, int r2) {
        this.mThumbCenterX = r1;
        this.mThumbCenterY = r2;
        updateThumbBounds();
    }

    private void initMarkerDistance() {
        this.mMarkerDistance = (this.mThumbCenterMaxX - this.mThumbCenterMinX) / (this.mMarkerSize - 1);
    }

    @Override // android.view.View
    protected void onDraw(Canvas r1) {
        super.onDraw(r1);
        drawDebugLineIfDebugMode(r1);
        drawLabels(r1);
        drawMarkers(r1);
        drawThumb(r1);
    }

    private void drawMarkers(Canvas r11) {
        r11.save();
        int r1 = 0;
    L4:
        if (r1 >= this.mMarkerSize) goto L16;
        Marker r2 = this.mMarkers.get(r1);
        int r3 = r2.centerY - (this.mMarkerDrawableHeight / 2);
        boolean r6 = true;
        if (r2.type != 0) goto L9;
        Drawable r4 = this.mStartMarkerDrawable;
    L12:
        r4.setBounds(r2.centerX - (this.mMarkerDrawableWidth / 2), r3, r2.centerX + (this.mMarkerDrawableWidth / 2), this.mMarkerDrawableHeight + r3);
        r4.draw(r11);
        if (r6 == false) goto L15;
        this.mBridgeDrawable.setBounds(r2.centerX + (this.mMarkerDrawableWidth / 2), r3, this.mMarkers.get(r1 + 1).centerX - (this.mMarkerDrawableWidth / 2), this.mMarkerDrawableHeight + r3);
        this.mBridgeDrawable.draw(r11);
    L15:
        r1 = r1 + 1;
        goto L4
    L9:
        if (r2.type != 2) goto L11;
        r4 = this.mEndMarkerDrawable;
        r6 = false;
        goto L12
    L11:
        r4 = this.mMidMarkerDrawable;
        goto L12
    L16:
        r11.restore();
    }

    void drawThumb(Canvas r1) {
        r1.save();
        this.mThumb.draw(r1);
        r1.restore();
    }

    Drawable getThumbDrawable() {
        return this.mThumb;
    }

    void setThumbDrawable(Drawable r1) {
        this.mThumb = r1;
        getThumbSize();
        initThumbCenterRange();
        updateThumbBounds();
    }

    private void drawLabels(Canvas r7) {
        r7.save();
        float r0 = (Math.abs(this.mLabelFontMetrics.ascent) + this.mPaddingTop) + sLabelTopMargin;
        int r1 = 0;
    L4:
        if (r1 >= this.mMarkerSize) goto L17;
        Marker r2 = this.mMarkers.get(r1);
        this.mLabelPaint.setColor(r2.labelColor);
        Paint r3 = this.mLabelPaint;
        if (r2.focused == false) goto L8;
        int r4 = LABEL_FOCUS_TEXT_SIZE;
    L9:
        r3.setTextSize(r4);
        String[] r5 = this.mMarkerLabels;
        if (r5 == null) goto L13;
        r2.label = r5[r1];
    L13:
        if (r2.label != null) goto L15;
        String r6 = String.valueOf(r2.index);
    L16:
        r7.drawText(r6, r2.centerX, r2.labelTransY + r0, this.mLabelPaint);
        r1 = r1 + 1;
        goto L4
    L15:
        r6 = r2.label;
        goto L16
    L8:
        r4 = LABEL_TEXT_SIZE;
        goto L9
    L17:
        r7.restore();
    }

    public float getUnfocusedNormalLabelY() {
        return sLabelTransYMax + ((Math.abs(this.mLabelFontMetrics.ascent) + this.mPaddingTop) + sLabelTopMargin);
    }

    private void markerFocusChanged(int r5, boolean r6) {
        ArrayList<Marker> r0 = this.mMarkers;
        monitor-enter(r0);
        Marker r1 = this.mMarkers.get(r5);     // Catch: Throwable -> L14
        if (r1.focused == true) goto L12;
        r1.focused = true;     // Catch: Throwable -> L14
        int r2 = 0;
    L8:
        if (r2 >= this.mMarkerSize) goto L12;
        if (r2 == r5) goto L11;
        this.mMarkers.get(r2).focused = false;     // Catch: Throwable -> L14
    L11:
        this.mMarkers.get(r2).animateLabel(r6);     // Catch: Throwable -> L14
        r2 = r2 + 1;     // Catch: Throwable -> L14
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.currentMarker = this.mCurrentMarker;
        return r1;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r2) {
        SavedState r3 = (SavedState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        setMarker(r3.currentMarker);
    }

    static int dp2px(Context r1, int r2) {
        return (int) TypedValue.applyDimension(1, r2, r1.getResources().getDisplayMetrics());
    }
}
