package obric.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes5.dex */
public class CountDownTimerView extends TickMarkView {
    private static final int MSG_COUNT_DOWN = 0;
    private static final String TAG = "CountDownTimerView";
    private boolean isCountingDown;
    private int mBridgeDrawableHeight;
    private int mCountDownFrom;
    private Paint mCountDownLabelPaint;
    private int[] mCountDownSeconds;
    private CountDownStatusListener mCountDownStatusListener;
    private int mCountLeftSeconds;
    private final Handler mHandler;
    private float mMovedDistancePerSecond;
    private int mStartEndDrawableHeight;
    private int mStartEndDrawableWidth;
    private Drawable mTickMarkThumb;
    private Drawable mTimerProgressBridge;
    private Drawable mTimerProgressFullEnd;
    private Drawable mTimerProgressStart;
    private Drawable mTimerThumb;
    private Drawable mTimerTrackEnd;

    public interface CountDownStatusListener {
        void onCancel();

        void onFinish();

        void onStart(int indexFrom);
    }

    private static final class CountingHandler extends Handler {
        private WeakReference<CountDownTimerView> weakReference;

        CountingHandler(CountDownTimerView countDownTimerView) {
            this.weakReference = new WeakReference(countDownTimerView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            WeakReference<CountDownTimerView> r1 = this.weakReference;
            if (r1 != null) goto L5;
            return;
        L5:
            if (r1.get() == null) goto L9;
            CountDownTimerView.access$000(this.weakReference.get());
            return;
        }
    }

    static {
    }

    static /* synthetic */ void access$000(CountDownTimerView r0) {
        r0.refresh();
    }

    static /* synthetic */ boolean access$100(CountDownTimerView r0) {
        return r0.isCountingDown;
    }

    static /* synthetic */ void access$200(CountDownTimerView r0) {
        r0.cancelCountDown();
    }

    static /* synthetic */ void access$300(CountDownTimerView r0, int r1) {
        r0.startCountDown(r1);
    }

    public void setCountDownListener(CountDownStatusListener listener) {
        this.mCountDownStatusListener = listener;
    }

    public CountDownTimerView(Context context) {
        this(context, null);
    }

    public CountDownTimerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CountDownTimerView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public CountDownTimerView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.mCountDownFrom = -1;
        this.mHandler = new CountingHandler(this);
        TypedArray r2 = context.obtainStyledAttributes(attrs, R.styleable.CountDownTimerView, defStyleAttr, defStyleRes);
        Resources r3 = getResources();
        this.mTimerProgressStart = r3.getDrawable(r2.getResourceId(R.styleable.CountDownTimerView_timer_progress_start_src, R.drawable.timer_progress_start_2));
        this.mTimerProgressBridge = r3.getDrawable(r2.getResourceId(R.styleable.CountDownTimerView_timer_progress_bridge_src, R.drawable.timer_progress_bridge_2));
        this.mTimerProgressFullEnd = r3.getDrawable(r2.getResourceId(R.styleable.CountDownTimerView_timer_progress_full_end_src, R.drawable.timer_progress_end_2));
        this.mTimerTrackEnd = r3.getDrawable(r2.getResourceId(R.styleable.CountDownTimerView_timer_track_end_src, R.drawable.timer_track_end));
        this.mTimerThumb = r3.getDrawable(r2.getResourceId(R.styleable.CountDownTimerView_timer_thumb_src, R.drawable.timer_progress_control));
        this.mTickMarkThumb = getThumbDrawable();
        r2.recycle();
        this.mStartEndDrawableWidth = this.mTimerProgressStart.getIntrinsicWidth();
        this.mStartEndDrawableHeight = this.mTimerProgressStart.getIntrinsicHeight();
        this.mBridgeDrawableHeight = this.mTimerProgressBridge.getIntrinsicHeight();
        setTrackTouchListener(new AnonymousClass2(this));
        initCountDownPaint();
        setMarker(0);
    }

    private void initCountDownPaint() {
        if (this.mCountDownLabelPaint != null) goto L5;
        this.mCountDownLabelPaint = new Paint();
    L5:
        this.mCountDownLabelPaint.setColor(LABEL_COLOR_SELECTED);
        this.mCountDownLabelPaint.setTextSize(30.0f);
        this.mCountDownLabelPaint.setTypeface(Typeface.defaultFromStyle(1));
        this.mCountDownLabelPaint.setStyle(Paint.Style.FILL);
        this.mCountDownLabelPaint.setAntiAlias(true);
        this.mCountDownLabelPaint.setTextAlign(Paint.Align.CENTER);
    }

    private String formatTime(int second) {
        int r3 = second / 60;
        int r4 = second % 60;
        if (r3 <= 0) goto L5;
        int r1 = r3 / 60;
        int r5 = r3 % 60;
    L7:
        return String.format("%d:%02d:%02d", new Object[]{Integer.valueOf(r1), Integer.valueOf(r5), Integer.valueOf(r4)});
    L5:
        r5 = 0;
        r1 = 0;
        goto L7
    }

    private void startCountDown(int fromIndex) {
        startCountDown(this.mCountDownSeconds[fromIndex], fromIndex);
        CountDownStatusListener r1 = this.mCountDownStatusListener;
        if (r1 == null) goto L6;
        r1.onStart(fromIndex);
        return;
    }

    private void scheduleCountingPerSecond() {
        this.mHandler.removeMessages(0);
        this.mHandler.sendEmptyMessageDelayed(0, 1000);
    }

    private void getDistancePerSecondMove() {
        if (this.mCountDownSeconds == null) goto L8;
        int r0 = this.mCountDownFrom;
        if (r0 <= 0) goto L9;
        this.mMovedDistancePerSecond = (r0 * (getThumbMaxX() - getThumbMinX())) / ((getMarkerSize() - 1) * this.mCountDownSeconds[this.mCountDownFrom]);
        return;
    L9:
        return;
    }

    public void startCountDown(int leftSecond, int fromIndex) {
        if (this.mCountDownSeconds == null) goto L18;
        if (fromIndex <= 0) goto L16;
        if (fromIndex > (getMarkerSize() - 1)) goto L16;
        if (leftSecond < 0) goto L14;
        if (leftSecond > this.mCountDownSeconds[fromIndex]) goto L14;
        this.isCountingDown = true;
        this.mCountDownFrom = fromIndex;
        this.mCountLeftSeconds = leftSecond;
        setThumbDrawable(this.mTimerThumb);
        getDistancePerSecondMove();
        updateThumbCenter(getThumbCountingX(), getThumbY());
        scheduleCountingPerSecond();
        return;
    L14:
        throw new IllegalArgumentException("illegal args, leftSecond should between 0 and " + this.mCountDownSeconds[fromIndex]);
    L16:
        throw new IllegalArgumentException("illegal fromIndex=" + fromIndex + " the index should between 0 and " + (getMarkerSize() - 1));
    L18:
        throw new NullPointerException("NullPointerException, you have not set mCountDownSeconds through calling setCountDownSeconds()");
    }

    private void refresh() {
        boolean r1 = true;
        this.mCountLeftSeconds--;
        float r0 = getThumbMinX();
        float r2 = this.mMovedDistancePerSecond;
        int r3 = this.mCountLeftSeconds;
        int r4 = (int) (r0 + (r2 * r3));
        if (r3 > 0) goto L6;
        r1 = false;
    L6:
        if (r4 > getThumbMinX()) goto L8;
        r4 = getThumbMinX();
    L8:
        updateThumbCenter(r4, getThumbY());
        if (r1 == false) goto L11;
        scheduleCountingPerSecond();
        return;
    L11:
        finishCountDown();
        setMarker(0);
    }

    private void finishCountDown() {
        setThumbDrawable(this.mTickMarkThumb);
        this.isCountingDown = false;
        this.mHandler.removeMessages(0);
        CountDownStatusListener r2 = this.mCountDownStatusListener;
        if (r2 == null) goto L6;
        r2.onFinish();
        return;
    }

    private void cancelCountDown() {
        setThumbDrawable(this.mTickMarkThumb);
        this.isCountingDown = false;
        this.mHandler.removeMessages(0);
        CountDownStatusListener r2 = this.mCountDownStatusListener;
        if (r2 == null) goto L6;
        r2.onCancel();
        return;
    }

    @Override // obric.widget.TickMarkView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // obric.widget.TickMarkView
    void updateThumbPosInnerIfSizeChanged() {
        getDistancePerSecondMove();
        updateThumbCenter(getThumbCountingX(), getThumbY());
    }

    private int getThumbCountingX() {
        return getThumbMinX() + ((int) (this.mCountLeftSeconds * this.mMovedDistancePerSecond));
    }

    @Override // obric.widget.TickMarkView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (isPressed() == false) goto L5;
    L8:
        super.onDraw(canvas);
        return;
    L5:
        if (this.isCountingDown == false) goto L8;
        drawCountDownProgress(canvas);
        drawThumb(canvas);
        drawCountDownLabel(canvas);
        drawDebugLineIfDebugMode(canvas);
    }

    public void setCountDownSeconds(int[] secondsArray) {
        if (secondsArray.length <= 1) goto L7;
        setMarkerSize(secondsArray.length);
        this.mCountDownSeconds = secondsArray;
        return;
    L7:
        throw new IllegalArgumentException("secondsArray lenth should >1");
    }

    private void drawCountDownProgress(Canvas canvas) {
        this.mTimerProgressStart.setBounds(getThumbMinX() - (this.mStartEndDrawableWidth / 2), getThumbY() - (this.mStartEndDrawableHeight / 2), getThumbMinX() + (this.mStartEndDrawableWidth / 2), getThumbY() + (this.mStartEndDrawableHeight / 2));
        this.mTimerProgressBridge.setBounds(getThumbMinX() + (this.mStartEndDrawableWidth / 2), getThumbY() - (this.mBridgeDrawableHeight / 2), getThumbX(), getThumbY() + (this.mBridgeDrawableHeight / 2));
        this.mBridgeDrawable.setBounds(getThumbX(), getThumbY() - (this.mBridgeDrawableHeight / 2), getThumbMaxX() - (this.mStartEndDrawableWidth / 2), getThumbY() + (this.mBridgeDrawableHeight / 2));
        if (getThumbX() <= (getThumbMaxX() - (this.mStartEndDrawableWidth / 2))) goto L5;
        Drawable r0 = this.mTimerProgressFullEnd;
    L6:
        r0.setBounds(getThumbMaxX() - (this.mStartEndDrawableWidth / 2), getThumbY() - (this.mStartEndDrawableHeight / 2), getThumbMaxX() + (this.mStartEndDrawableWidth / 2), getThumbY() + (this.mStartEndDrawableHeight / 2));
        r0.draw(canvas);
        this.mTimerProgressStart.draw(canvas);
        this.mTimerProgressBridge.draw(canvas);
        this.mBridgeDrawable.draw(canvas);
        return;
    L5:
        r0 = this.mTimerTrackEnd;
        goto L6
    }

    private void drawCountDownLabel(Canvas canvas) {
        canvas.drawText(formatTime(this.mCountLeftSeconds), getThumbX(), getUnfocusedNormalLabelY(), this.mCountDownLabelPaint);
    }
}
