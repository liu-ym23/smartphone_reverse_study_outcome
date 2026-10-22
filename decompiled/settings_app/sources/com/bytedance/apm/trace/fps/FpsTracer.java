package com.bytedance.apm.trace.fps;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.View;
import android.view.WindowManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.block.FluencySceneManager;
import com.bytedance.apm.samplers.SamplerHelper;
import com.bytedance.apm.thread.AsyncEventManager;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class FpsTracer {
    private static final int FACTOR = 10000;
    private static final long FAKE_FRAME_TIME = 10;
    private static final Long MAX_INTERVAL = null;
    private static final int MIN_DROP_FRAME = 0;
    private static final String MODIFY_SCENE_TIPS = "modify scene on work thread.";
    private static final Long MONITOR_INTERVAL = null;
    private static final int OFFSET_TO_MS = 100;
    private static final String SCROLL_SPEED = "scroll_speed";
    private static final String SCROLL_TIME = "total_scroll_time";
    private static final String TAG = "FpsTracer";
    private static boolean sFullFpsTracer = false;
    private boolean mCollectWhenNotHit;
    private int mCounter;
    private final JSONObject mExtra;
    private FPSRecordView mFPSFpsRecordView;
    private volatile boolean mFPSState;
    private Choreographer.FrameCallback mFrameCallback;
    private LinkedList<Integer> mFrameCostList;
    private IDropFrameCallback mIDropFrameCallback;
    private IFPSCallBack mIFPSCallBack;
    private IFrameCallBack mIFrameCallBack;
    private IHtrFrmaeCallback mIHtrFrameCallback;
    private long mLastFrameNanos;
    private RealFpsTracer mRealFpsTracer;
    private float mScrollDistanceX;
    private float mScrollDistanceY;
    private float mScrollSpeedX;
    private float mScrollSpeedY;
    private long mStartTimeNanos;
    private String mType;
    private WindowManager mWindowManager;
    private HashMap<String, String> tags;

    private class FPSRecordView extends View {
        private int mCounter;
        private long mStartTime;
        final /* synthetic */ FpsTracer this$0;

        static /* synthetic */ long access$002(FPSRecordView r0, long r1) {
            r0.mStartTime = r1;
            return r1;
        }

        static /* synthetic */ int access$302(FPSRecordView r0, int r1) {
            r0.mCounter = r1;
            return r1;
        }

        public FPSRecordView(FpsTracer r1, Context r2) {
            this.this$0 = r1;
            super(r2);
            this.mStartTime = -1;
            this.mCounter = 0;
        }

        @Override // android.view.View
        protected void onDraw(Canvas r5) {
            if (this.mStartTime != (-1)) goto L5;
            this.mStartTime = SystemClock.elapsedRealtime();
            this.mCounter = 0;
        L7:
            if (FpsTracer.access$500(this.this$0) == null) goto L9;
            FpsTracer.access$500(this.this$0).onFrame(SystemClock.elapsedRealtime());
        L9:
            long r0 = SystemClock.elapsedRealtime() - this.mStartTime;
            if (r0 <= FpsTracer.access$1700().longValue()) goto L16;
            double r2 = (((double) this.mCounter) / r0) * FpsTracer.access$1800().longValue();
            if (FpsTracer.access$1900(this.this$0) == null) goto L14;
            FpsTracer.access$1900(this.this$0).fpsCallBack(r2);
        L14:
            FpsAggregateManger.getInstance().aggregate(FpsTracer.access$2000(this.this$0), FpsTracer.access$1100(this.this$0), (float) r2);
            FpsTracer.access$2100(this.this$0);
            return;
        L16:
            return;
        L5:
            this.mCounter++;
            goto L7
        }
    }

    public interface IBlockTimeCallBack {
        void blockTimeCallBack(long r1, int r3);
    }

    public interface IDropFrameCallback {
        void dropFrame(JSONObject r1);
    }

    public interface IFPSCallBack {
        void fpsCallBack(double r1);
    }

    public interface IFrameCallBack {
        void onFrame(long r1);
    }

    public interface IHtrFrmaeCallback {
        void dropHtrFrame(JSONObject r1, int r2);
    }

    static /* synthetic */ boolean access$100(FpsTracer r0) {
        return r0.mFPSState;
    }

    static /* synthetic */ IDropFrameCallback access$1000(FpsTracer r0) {
        return r0.mIDropFrameCallback;
    }

    static /* synthetic */ String access$1100(FpsTracer r0) {
        return r0.mType;
    }

    static /* synthetic */ float access$1200(FpsTracer r0) {
        return r0.mScrollSpeedX;
    }

    static /* synthetic */ float access$1300(FpsTracer r0) {
        return r0.mScrollSpeedY;
    }

    static /* synthetic */ float access$1400(FpsTracer r0) {
        return r0.mScrollDistanceX;
    }

    static /* synthetic */ float access$1500(FpsTracer r0) {
        return r0.mScrollDistanceY;
    }

    static /* synthetic */ JSONObject access$1600(FpsTracer r0) {
        return r0.mExtra;
    }

    static /* synthetic */ Long access$1700() {
        return MONITOR_INTERVAL;
    }

    static /* synthetic */ Long access$1800() {
        return MAX_INTERVAL;
    }

    static /* synthetic */ IFPSCallBack access$1900(FpsTracer r0) {
        return r0.mIFPSCallBack;
    }

    static /* synthetic */ FPSRecordView access$200(FpsTracer r0) {
        return r0.mFPSFpsRecordView;
    }

    static /* synthetic */ HashMap access$2000(FpsTracer r0) {
        return r0.tags;
    }

    static /* synthetic */ void access$2100(FpsTracer r0) {
        r0.endLowJellyBean();
    }

    static /* synthetic */ long access$400(FpsTracer r2) {
        return r2.mStartTimeNanos;
    }

    static /* synthetic */ long access$402(FpsTracer r0, long r1) {
        r0.mStartTimeNanos = r1;
        return r1;
    }

    static /* synthetic */ IFrameCallBack access$500(FpsTracer r0) {
        return r0.mIFrameCallBack;
    }

    static /* synthetic */ int access$604(FpsTracer r1) {
        int r0 = r1.mCounter + 1;
        r1.mCounter = r0;
        return r0;
    }

    static /* synthetic */ long access$700(FpsTracer r2) {
        return r2.mLastFrameNanos;
    }

    static /* synthetic */ long access$702(FpsTracer r0, long r1) {
        r0.mLastFrameNanos = r1;
        return r1;
    }

    static /* synthetic */ void access$800(FpsTracer r0, long r1, long r3) {
        r0.doDropCompute(r1, r3);
    }

    static /* synthetic */ int access$900(int r0, float r1) {
        return getDroppedCount(r0, r1);
    }

    static {
        MONITOR_INTERVAL = 200L;
        MAX_INTERVAL = 1000L;
    }

    public FpsTracer(String r2) {
        this(r2, true);
    }

    public FpsTracer(String r2, boolean r3) {
        this(r2, r3, null);
    }

    public FpsTracer(String r4, boolean r5, JSONObject r6) {
        this.mFPSState = false;
        this.mIFrameCallBack = null;
        this.tags = new HashMap();
        this.mScrollSpeedX = 0.0f;
        this.mScrollSpeedY = 0.0f;
        this.mScrollDistanceX = 0.0f;
        this.mScrollDistanceY = 0.0f;
        this.mFPSFpsRecordView = null;
        this.mWindowManager = null;
        this.mStartTimeNanos = -1;
        this.mLastFrameNanos = -1;
        this.mCounter = 0;
        this.mExtra = r6;
        if (sFullFpsTracer == false) goto L6;
        this.mRealFpsTracer = new RealFpsTracer(r4, r5, r6);
        return;
    L6:
        this.mType = r4;
        this.mCollectWhenNotHit = r5;
        this.mFrameCostList = new LinkedList();
    }

    public void setDropFrameCallback(IDropFrameCallback r2) {
        RealFpsTracer r0 = this.mRealFpsTracer;
        if (r0 == null) goto L5;
        r0.setDropFrameCallback(r2);
    L5:
        this.mIDropFrameCallback = r2;
    }

    public void setHtrFrameCallback(IHtrFrmaeCallback r2) {
        RealFpsTracer r0 = this.mRealFpsTracer;
        if (r0 == null) goto L5;
        r0.setHtrFrameCallback(r2);
    L5:
        this.mIHtrFrameCallback = r2;
    }

    public void addTag(String r1, String r2) {
        this.tags.put(r1, r2);
    }

    public void removeTag(String r1) {
        this.tags.remove(r1);
    }

    public void setIFrameCallBack(IFrameCallBack r2) {
        RealFpsTracer r0 = this.mRealFpsTracer;
        if (r0 == null) goto L5;
        r0.setIFrameCallBack(r2);
    L5:
        this.mIFrameCallBack = r2;
    }

    public void setScrollSpeed(float r2, float r3) {
        RealFpsTracer r0 = this.mRealFpsTracer;
        if (r0 == null) goto L6;
        r0.setScrollSpeed(r2, r3);
        return;
    L6:
        this.mScrollSpeedX = r2;
        this.mScrollSpeedY = r3;
    }

    public void setScrollDistance(float r2, float r3) {
        RealFpsTracer r0 = this.mRealFpsTracer;
        if (r0 == null) goto L6;
        r0.setScrollDistance(r2, r3);
        return;
    L6:
        this.mScrollDistanceX = r2;
        this.mScrollDistanceY = r3;
    }

    public boolean getMonitorFPSStatus() {
        return this.mFPSState;
    }

    public void setIFPSCallBack(IFPSCallBack r2) {
        RealFpsTracer r0 = this.mRealFpsTracer;
        if (r0 == null) goto L5;
        r0.setIFPSCallBack(r2);
    L5:
        this.mIFPSCallBack = r2;
    }

    public void setIBlockTimeCallBack(IBlockTimeCallBack r1) {
        RealFpsTracer r0 = this.mRealFpsTracer;
        if (r0 == null) goto L6;
        r0.setIBlockTimeCallBack(r1);
        return;
    }

    public static void setFullFpsTracer(boolean r0) {
        sFullFpsTracer = r0;
    }

    public void startRecyclerView(RecyclerView r2) {
        RealFpsTracer r0 = this.mRealFpsTracer;
        if (r0 == null) goto L6;
        r0.startRecyclerView(r2);
        return;
    L6:
        if (r2 != null) goto L8;
        return;
    L8:
        r2.addOnScrollListener(new AnonymousClass1(this));
    }

    public void start() {
        RealFpsTracer r0 = this.mRealFpsTracer;
        if (r0 == null) goto L7;
        r0.start();
        return;
    L7:
        if (this.mFPSState == false) goto L10;
        return;
    L10:
        if (this.mCollectWhenNotHit == false) goto L12;
    L14:
        resetScrollInfo();
        startHighJellyBean();
        addScene(this.mType);
        this.mFPSState = true;
        return;
    L12:
        if (isNeedTraceFps() == true) goto L14;
    }

    private void resetScrollInfo() {
        this.mScrollSpeedX = 0.0f;
        this.mScrollSpeedY = 0.0f;
        this.mScrollDistanceX = 0.0f;
        this.mScrollDistanceY = 0.0f;
    }

    public synchronized void stop() {
        monitor-enter(this);
        RealFpsTracer r0 = this.mRealFpsTracer;     // Catch: Throwable -> L11
        if (r0 == null) goto L8;
        r0.stop();     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L8:
        endHighJellyBean();     // Catch: Throwable -> L11
        removeScene(this.mType);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private boolean isSampleHit() {
        return SamplerHelper.getPerfFpsAllowSwitch("fps", this.mType);
    }

    private boolean isFpsDropSampleHit() {
        return SamplerHelper.getPerfFpsAllowSwitch("fps_drop", this.mType);
    }

    public boolean isNeedTraceFps() {
        if (ApmContext.isNeedSalvage() == true) goto L5;
    L9:
        return false;
    L5:
        if (isFpsDropSampleHit() == false) goto L7;
    L8:
        return true;
    L7:
        if (isSampleHit() == false) goto L9;
        goto L8
    }

    private void startHighJellyBean() {
        monitor-enter(this);
        this.mFrameCostList.clear();     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        startJellyBean();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void endHighJellyBean() {
        if (this.mFPSState == true) goto L5;
        return;
    L5:
        calculateFps();
        if (this.mFrameCallback == null) goto L8;
        Choreographer.getInstance().removeFrameCallback(this.mFrameCallback);
    L8:
        doReport();
        this.mFPSState = false;
    }

    private void startLowJellyBean() {
        FPSRecordView.access$002(this.mFPSFpsRecordView, -1);
        WindowManager.LayoutParams r0 = new WindowManager.LayoutParams(-2, -2, 2005, 0, -3);
        r0.gravity = 51;
        r0.flags = 24;
        r0.height = 1;
        r0.width = 1;
        this.mWindowManager.removeView(this.mFPSFpsRecordView);     // Catch: Exception -> L6
    L4:
        this.mWindowManager.addView(this.mFPSFpsRecordView, r0);
        this.mFPSFpsRecordView.postDelayed(new AnonymousClass2(this), 10);
    }

    private void endLowJellyBean() {
        if (this.mFPSState == true) goto L10;
        return;
    L10:
        this.mWindowManager.removeView(this.mFPSFpsRecordView);     // Catch: Exception -> L9
        FPSRecordView.access$002(this.mFPSFpsRecordView, -1);     // Catch: Exception -> L9
        FPSRecordView.access$302(this.mFPSFpsRecordView, 0);     // Catch: Exception -> L9
    L7:
        this.mFPSState = false;
    }

    private void startJellyBean() {
        this.mStartTimeNanos = -1;
        this.mLastFrameNanos = -1;
        this.mCounter = 0;
        this.mFrameCallback = new AnonymousClass3(this);
        Choreographer.getInstance().postFrameCallback(this.mFrameCallback);     // Catch: Exception -> L5
        return;
    L5:
        this.mFPSState = false;
        this.mStartTimeNanos = -1;
        this.mLastFrameNanos = -1;
        this.mCounter = 0;
        this.mFrameCallback = null;
    }

    private void calculateFps() {
        long r0 = this.mLastFrameNanos - this.mStartTimeNanos;
        if (r0 <= 0) goto L12;
        int r2 = this.mCounter;
        if (r2 <= 1) goto L13;
        long r3 = (((((long) (r2 - 1)) * 1000) * 1000) * 1000) / r0;
        IFPSCallBack r1 = this.mIFPSCallBack;
        if (r1 == null) goto L10;
        r1.fpsCallBack(r3);
    L10:
        FpsAggregateManger.getInstance().aggregate(this.tags, this.mType, r3);
        return;
    L13:
        return;
    }

    private void doDropCompute(long r5, long r7) {
        if (this.mLastFrameNanos > 0) goto L5;
        return;
    L5:
        long r8 = r7 - r5;
        if ((r8 / 1000000) > 0) goto L8;
        return;
    L8:
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L10:
        if (this.mFrameCostList.size() <= 20000) goto L12;
        this.mFrameCostList.poll();     // Catch: Throwable -> L15
    L12:
        this.mFrameCostList.add(Integer.valueOf(((int) r8) / 10000));     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
    }

    private void doReport() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mFrameCostList.isEmpty() == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L7:
        final LinkedList<Integer> r0 = this.mFrameCostList;     // Catch: Throwable -> L11
        this.mFrameCostList = new LinkedList();     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        AsyncEventManager.getInstance().post(new AnonymousClass4(this, r0));
    }

    public static String getInjectScene() {
        return FluencySceneManager.getInjectScene();
    }

    public static void addScene(String r0) {
        FluencySceneManager.addScene(r0);
    }

    public static void removeScene(String r0) {
        FluencySceneManager.removeScene(r0);
    }

    private static int getDroppedCount(int r1, float r2) {
        int r3 = (int) (r2 * 100.0f);
        return ((r1 + (r3 - 1)) / r3) - 1;
    }
}
