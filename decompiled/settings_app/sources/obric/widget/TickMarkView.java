package obric.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import java.util.ArrayList;
import obric.InvokeApi;

/* JADX INFO: loaded from: classes5.dex */
public class TickMarkView extends View {
    static final boolean DBG = false;
    private static int DEFAULT_HEIGHT = 0;
    private static final int DEFAULT_WIDTH = 1080;
    private static final int DEF_MARKER_SIZE = 5;
    private static int LABEL_BOTTOM_MARGIN = 0;
    static final int LABEL_COLOR_SELECTED = 0;
    static final int LABEL_COLOR_UNSELECTED = 0;
    private static int LABEL_INNER_TRANSABLE_Y = 0;
    static final int LABEL_TEXT_SIZE = 30;
    private static int LABEL_TOP_MARGIN = 0;
    private static int LABEL_TRANS_Y_MAX = 0;
    private static int LABEL_TRANS_Y_MIN = 0;
    private static final String TAG = "TickMarkView";
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
    private int mThumbCenterX;
    private int mThumbCenterXMax;
    private int mThumbCenterXMin;
    private int mThumbCenterY;
    private int mThumbDrawableHeight;
    private int mThumbDrawableWidth;
    private float mTouchDownX;
    private TrackTouchListener mTrackListener;
    private int mWidth;

    class Marker {
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

        Marker(final TickMarkView this$0) {
            this.this$0 = this$0;
            this.labelTransY = TickMarkView.access$000();
            this.labelColor = TickMarkView.LABEL_COLOR_UNSELECTED;
        }

        public void animateLabel() {
            boolean r1 = false;
            if (this.focused == false) goto L7;
            this.labelColor = TickMarkView.LABEL_COLOR_SELECTED;
            float r0 = this.labelTransY - 4.0f;
            this.labelTransY = r0;
            if (r0 >= TickMarkView.access$100()) goto L10;
            this.labelTransY = TickMarkView.access$100();
        L11:
            if (r1 == false) goto L13;
            this.this$0.postDelayed(new AnonymousClass1(this), 10);
        L13:
            this.this$0.invalidate();
            return;
        L10:
            r1 = true;
            goto L11
        L7:
            this.labelColor = TickMarkView.LABEL_COLOR_UNSELECTED;
            float r2 = this.labelTransY + 4.0f;
            this.labelTransY = r2;
            if (r2 <= TickMarkView.access$000()) goto L10;
            this.labelTransY = TickMarkView.access$000();
            goto L11
        }
    }

    public interface OnMarkerChangeListener {
        void onMarkerChanged(int newMarkerIndex);
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int currentMarker;

        public SavedState(Parcel source) {
            super(source);
            this.currentMarker = source.readInt();
        }

        public SavedState(Parcelable superState) {
            super(superState);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.currentMarker);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    interface TrackTouchListener {
        void onStartTrack(MotionEvent event);

        void onStopTrack(MotionEvent event);
    }

    private void animateThumbToMarker(int destIndex) {
    }

    void drawDebugLineIfDebugMode(Canvas canvas) {
    }

    static /* synthetic */ int access$000() {
        return LABEL_TRANS_Y_MAX;
    }

    static /* synthetic */ int access$100() {
        return LABEL_TRANS_Y_MIN;
    }

    static {
        LABEL_COLOR_SELECTED = Color.parseColor("#9a000000");
        LABEL_COLOR_UNSELECTED = Color.parseColor("#66000000");
    }

    public TickMarkView(Context context) {
        this(context, null);
    }

    public TickMarkView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TickMarkView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public TickMarkView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initStaticConstants();
        TypedArray r3 = context.obtainStyledAttributes(attrs, R.styleable.TickMarkView, defStyleAttr, defStyleRes);
        int r4 = r3.getInt(R.styleable.TickMarkView_marker_size, 5);     // Catch: Throwable -> L13
        this.mMarkerSize = r4;     // Catch: Throwable -> L13
        verifyMarkerSize(r4);     // Catch: Throwable -> L13
        initMarkers();     // Catch: Throwable -> L13
        this.mCurrentMarker = r3.getInt(R.styleable.TickMarkView_marker, 0);     // Catch: Throwable -> L13
        int r5 = r3.getResourceId(R.styleable.TickMarkView_labels, 0);     // Catch: Throwable -> L13
        if (r5 <= 0) goto L10;
        String[] r6 = getResources().getStringArray(r5);     // Catch: Throwable -> L13
        if (r6.length != this.mMarkerSize) goto L9;
        setMarkerLabels(r6);     // Catch: Throwable -> L13
        goto L10
    L9:
        throw new IllegalArgumentException("illegal argument, the labels array length should be equals with markerSize.");     // Catch: Throwable -> L13
    L10:
        this.mStartMarkerDrawable = getResources().getDrawable(r3.getResourceId(R.styleable.TickMarkView_start_marker_src, R.drawable.tick_mark_track_start));     // Catch: Throwable -> L13
        this.mEndMarkerDrawable = getResources().getDrawable(r3.getResourceId(R.styleable.TickMarkView_end_marker_src, R.drawable.tick_mark_track_end));     // Catch: Throwable -> L13
        this.mMidMarkerDrawable = getResources().getDrawable(r3.getResourceId(R.styleable.TickMarkView_mid_marker_src, R.drawable.tick_mark_track_mid));     // Catch: Throwable -> L13
        this.mBridgeDrawable = getResources().getDrawable(r3.getResourceId(R.styleable.TickMarkView_bridge_src, R.drawable.tick_mark_track_bridge));     // Catch: Throwable -> L13
        this.mThumb = getResources().getDrawable(r3.getResourceId(R.styleable.TickMarkView_thumb, R.drawable.tick_mark_progress_control_2));     // Catch: Throwable -> L13
        initLabelPaintParams();     // Catch: Throwable -> L13
        r3.recycle();
        this.mScaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mPaddingLeft = getPaddingLeft();
        this.mPaddingRight = getPaddingRight();
        this.mPaddingTop = getPaddingTop();
        this.mMarkerDrawableWidth = this.mStartMarkerDrawable.getIntrinsicWidth();
        this.mMarkerDrawableHeight = this.mStartMarkerDrawable.getIntrinsicHeight();
        getThumbSize();
        return;
    L13:
        th = move-exception;
        r3.recycle();
        throw th;
    }

    private void initStaticConstants() {
        DEFAULT_HEIGHT = dp2px(getContext(), 66);
        LABEL_TOP_MARGIN = dp2px(getContext(), 6);
        LABEL_BOTTOM_MARGIN = dp2px(getContext(), 8);
        int r2 = dp2px(getContext(), 8);
        LABEL_INNER_TRANSABLE_Y = r2;
        LABEL_TRANS_Y_MIN = 0;
        LABEL_TRANS_Y_MAX = 0 + r2;
    }

    private void getThumbSize() {
        this.mThumbDrawableWidth = this.mThumb.getIntrinsicWidth();
        this.mThumbDrawableHeight = this.mThumb.getIntrinsicHeight();
    }

    public void setOnMarkerChangeListener(OnMarkerChangeListener listener) {
        this.mMarkerChangeListener = listener;
    }

    private void initLabelPaintParams() {
        if (this.mLabelPaint != null) goto L5;
        this.mLabelPaint = new Paint();
    L5:
        this.mLabelPaint.reset();
        this.mLabelPaint.setTextSize(30.0f);
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
        r1.centerX = this.mThumbCenterXMin + (this.mMarkerDistance * r0);
        r1.centerY = this.mThumbCenterY;
        r0 = r0 + 1;
        goto L4
    }

    public void setMarkerLabels(String[] labels) {
        this.mMarkerLabels = labels;
        invalidate();
    }

    public void setMarkerSize(int size) {
        verifyMarkerSize(size);
        if (size != this.mMarkerSize) goto L5;
        return;
    L5:
        this.mMarkerSize = size;
        initMarkers();
        initMarkerLocation();
    }

    public int getMarkerSize() {
        return this.mMarkerSize;
    }

    private boolean verifyMarkerSize(int size) {
        if (size < 2) goto L7;
        return true;
    L7:
        throw new IllegalArgumentException("illegal marker size, the min marker size should be 2");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (isEnabled() == true) goto L5;
        return false;
    L5:
        int r0 = event.getAction();
        if (r0 == 0) goto L32;
        if (r0 == 1) goto L27;
        if (r0 == 2) goto L18;
        if (r0 == 3) goto L14;
    L38:
        return true;
    L14:
        if (this.mIsDragging == false) goto L16;
        trackTouchEvent(event);
        onStopTrackingTouch(event);
        setPressed(false);
    L16:
        invalidate();
        goto L38
    L18:
        if (this.mIsDragging == false) goto L21;
        trackTouchEvent(event);
        goto L38
    L21:
        if (Math.abs(event.getX() - this.mTouchDownX) <= this.mScaledTouchSlop) goto L38;
        setPressed(true);
        Drawable r1 = this.mThumb;
        if (r1 == null) goto L25;
        invalidate(r1.getBounds());
    L25:
        onStartTrackingTouch(event);
        trackTouchEvent(event);
        attemptClaimDrag();
        goto L38
    L27:
        if (this.mIsDragging == false) goto L29;
        trackTouchEvent(event);
        onStopTrackingTouch(event);
        setPressed(false);
    L30:
        invalidate();
        goto L38
    L29:
        onStartTrackingTouch(event);
        trackTouchEvent(event);
        onStopTrackingTouch(event);
        goto L30
    L32:
        if (InvokeApi.xView.isInScrollingContainer(this) == false) goto L34;
        this.mTouchDownX = event.getX();
        goto L38
    L34:
        setPressed(true);
        Drawable r2 = this.mThumb;
        if (r2 == null) goto L37;
        invalidate(r2.getBounds());
    L37:
        onStartTrackingTouch(event);
        trackTouchEvent(event);
        attemptClaimDrag();
        goto L38
    }

    private void trackTouchEvent(MotionEvent event) {
        int r0 = getThumbCenterXByTouchEvent(event);
        this.mThumbCenterX = r0;
        int r1 = thumbCenterXToMarkerIndex(r0);
        if (r1 == this.mFocusedMarker) goto L5;
        markerFocusChanged(r1);
    L5:
        this.mFocusedMarker = r1;
        int r3 = event.getAction();
        if (r3 != 1) goto L8;
    L11:
        setMarker(r1);
        return;
    L8:
        if (r3 == 3) goto L11;
        updateThumbBounds();
    }

    int getThumbCenterXByTouchEvent(MotionEvent event) {
        int r2 = (int) event.getX();
        int r0 = this.mThumbCenterXMin;
        if (r2 < r0) goto L9;
        int r1 = this.mThumbCenterXMax;
        if (r2 > r1) goto L8;
        return r2;
    L8:
        return r1;
    L9:
        return r0;
    }

    private void updateThumbBounds() {
        Drawable r0 = this.mThumb;
        int r1 = this.mThumbCenterX;
        int r2 = this.mThumbDrawableWidth;
        int r4 = this.mThumbCenterY;
        int r5 = this.mThumbDrawableHeight;
        r0.setBounds(r1 - (r2 / 2), r4 - (r5 / 2), r1 + (r2 / 2), r4 + (r5 / 2));
        invalidate();
    }

    public void setMarker(int index) {
        if (index < 0) goto L13;
        if (index > (this.mMarkerSize - 1)) goto L13;
        this.mThumbCenterX = markerIndexToThumbCenterX(index);
        updateThumbBounds();
        if (this.mCurrentMarker == index) goto L10;
        OnMarkerChangeListener r0 = this.mMarkerChangeListener;
        if (r0 == null) goto L10;
        r0.onMarkerChanged(index);
    L10:
        this.mCurrentMarker = index;
        markerFocusChanged(index);
        return;
    L13:
        throw new IllegalArgumentException("invalid marker index=" + index + ", the index should between 0 and " + (this.mMarkerSize - 1));
    }

    private int markerIndexToThumbCenterX(int index) {
        return this.mMarkers.get(index).centerX;
    }

    int thumbCenterXToMarkerIndex(int thumbCenterX) {
        return Math.round(((thumbCenterX - this.mThumbCenterXMin) * 1.0f) / this.mMarkerDistance);
    }

    private void attemptClaimDrag() {
        ViewParent r1 = getParent();
        if (r1 == null) goto L6;
        r1.requestDisallowInterceptTouchEvent(true);
        return;
    }

    void onStartTrackingTouch(MotionEvent event) {
        this.mIsDragging = true;
        TrackTouchListener r1 = this.mTrackListener;
        if (r1 == null) goto L6;
        r1.onStartTrack(event);
        return;
    }

    void onStopTrackingTouch(MotionEvent event) {
        this.mIsDragging = false;
        TrackTouchListener r1 = this.mTrackListener;
        if (r1 == null) goto L6;
        r1.onStopTrack(event);
        return;
    }

    void setTrackTouchListener(TrackTouchListener listener) {
        this.mTrackListener = listener;
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mWidth = w;
        this.mHeight = h;
        initThumbCenterRange();
        initMarkerLocation();
        updateThumbPosInnerIfSizeChanged();
    }

    void updateThumbPosInnerIfSizeChanged() {
        updateThumbCenter(markerIndexToThumbCenterX(this.mCurrentMarker), this.mThumbCenterY);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int r0 = View.MeasureSpec.getMode(widthMeasureSpec);
        int r1 = View.MeasureSpec.getMode(heightMeasureSpec);
        int r3 = View.MeasureSpec.getSize(widthMeasureSpec);
        int r4 = View.MeasureSpec.getSize(heightMeasureSpec);
        if (r0 != 0) goto L5;
        this.mWidth = DEFAULT_WIDTH;
    L6:
        if (r1 != 0) goto L8;
        this.mHeight = DEFAULT_HEIGHT;
    L9:
        setMeasuredDimension(this.mWidth, this.mHeight);
        initThumbCenterRange();
        initMarkerLocation();
        setMarker(this.mCurrentMarker);
        return;
    L8:
        this.mHeight = r4;
        goto L9
    L5:
        this.mWidth = r3;
        goto L6
    }

    private void initThumbCenterRange() {
        int r0 = this.mWidth;
        int r1 = this.mPaddingLeft;
        int r2 = (r0 - r1) - this.mPaddingRight;
        int r3 = this.mThumbDrawableWidth;
        this.mThumbCenterXMin = (r3 / 2) + r1;
        this.mThumbCenterXMax = (r1 + r2) - (r3 / 2);
        int r4 = (int) (this.mLabelFontMetrics.descent - this.mLabelFontMetrics.ascent);
        this.mThumbCenterY = ((((this.mPaddingTop + LABEL_TOP_MARGIN) + r4) + LABEL_INNER_TRANSABLE_Y) + (this.mMarkerDrawableHeight / 2)) + LABEL_BOTTOM_MARGIN;
    }

    int getThumbMinX() {
        return this.mThumbCenterXMin;
    }

    int getThumbMaxX() {
        return this.mThumbCenterXMax;
    }

    int getThumbY() {
        return this.mThumbCenterY;
    }

    int getThumbX() {
        return this.mThumbCenterX;
    }

    void updateThumbCenter(int x, int y) {
        this.mThumbCenterX = x;
        this.mThumbCenterY = y;
        updateThumbBounds();
    }

    private void initMarkerDistance() {
        this.mMarkerDistance = (this.mThumbCenterXMax - this.mThumbCenterXMin) / (this.mMarkerSize - 1);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawDebugLineIfDebugMode(canvas);
        drawLabels(canvas);
        drawMarkers(canvas);
        drawThumb(canvas);
    }

    private void drawMarkers(Canvas canvas) {
        canvas.save();
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
        r4.draw(canvas);
        if (r6 == false) goto L15;
        this.mBridgeDrawable.setBounds(r2.centerX + (this.mMarkerDrawableWidth / 2), r3, this.mMarkers.get(r1 + 1).centerX - (this.mMarkerDrawableWidth / 2), this.mMarkerDrawableHeight + r3);
        this.mBridgeDrawable.draw(canvas);
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
        canvas.restore();
    }

    void drawThumb(Canvas canvas) {
        canvas.save();
        this.mThumb.draw(canvas);
        canvas.restore();
    }

    Drawable getThumbDrawable() {
        return this.mThumb;
    }

    void setThumbDrawable(Drawable thumb) {
        this.mThumb = thumb;
        getThumbSize();
        initThumbCenterRange();
        updateThumbBounds();
    }

    private void drawLabels(Canvas r7) {
        r7.save();
        float r0 = (Math.abs(this.mLabelFontMetrics.ascent) + this.mPaddingTop) + LABEL_TOP_MARGIN;
        int r1 = 0;
    L4:
        if (r1 >= this.mMarkerSize) goto L13;
        Marker r2 = this.mMarkers.get(r1);
        this.mLabelPaint.setColor(r2.labelColor);
        this.mLabelPaint.setTypeface(Typeface.defaultFromStyle(r2.focused ? 1 : 0));
        String[] r3 = this.mMarkerLabels;
        if (r3 == null) goto L9;
        r2.label = r3[r1];
    L9:
        if (r2.label != null) goto L11;
        String r4 = String.valueOf(r2.index);
    L12:
        r7.drawText(r4, r2.centerX, r2.labelTransY + r0, this.mLabelPaint);
        r1 = r1 + 1;
        goto L4
    L11:
        r4 = r2.label;
        goto L12
    L13:
        r7.restore();
    }

    public float getUnfocusedNormalLabelY() {
        return LABEL_TRANS_Y_MAX + ((Math.abs(this.mLabelFontMetrics.ascent) + this.mPaddingTop) + LABEL_TOP_MARGIN);
    }

    private void markerFocusChanged(final int focusedIndex) {
        ArrayList<Marker> r0 = this.mMarkers;
        monitor-enter(r0);
        Marker r1 = this.mMarkers.get(focusedIndex);     // Catch: Throwable -> L14
        if (r1.focused == true) goto L12;
        r1.focused = true;     // Catch: Throwable -> L14
        int r2 = 0;
    L8:
        if (r2 >= this.mMarkerSize) goto L12;
        if (r2 == focusedIndex) goto L11;
        this.mMarkers.get(r2).focused = false;     // Catch: Throwable -> L14
    L11:
        this.mMarkers.get(r2).animateLabel();     // Catch: Throwable -> L14
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
    protected void onRestoreInstanceState(Parcelable state) {
        SavedState r2 = (SavedState) state;
        super.onRestoreInstanceState(r2.getSuperState());
        setMarker(r2.currentMarker);
    }

    static int dp2px(Context context, int dp) {
        return (int) TypedValue.applyDimension(1, dp, context.getResources().getDisplayMetrics());
    }
}
