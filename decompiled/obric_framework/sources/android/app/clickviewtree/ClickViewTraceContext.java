package android.app.clickviewtree;

import android.app.assist.AssistStructure;
import android.os.Build;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewRootImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ClickViewTraceContext {
    private static final long MIN_TRACE_INTERVAL_MILLIS = 30;
    private static final long PENDING_TOUCH_CLICK_TIMEOUT_MILLIS = 1000;
    private static final String TAG = "ClickViewTraceContext";
    private static final ThreadLocal<TraceState> sCurrentTrace = null;
    private static final ThreadLocal<long[]> sLastTraceUptime = null;
    private static final ThreadLocal<PendingTouchClick> sPendingTouchClick = null;

    private static final class PendingTouchClick {
        private final AssistStructure mAssistStructure;
        private final String mConsumeReason;
        private final WeakReference<View> mConsumerView;
        private final long mCreatedAtElapsedMillis;
        private final ClickEventInfo mEvent;

        PendingTouchClick(TraceState state) {
            this.mConsumerView = new WeakReference(TraceState.m27$$Nest$fgetmConsumerView(state));
            this.mEvent = ClickViewTraceContext.m20$$Nest$smbuildMotionEventInfo(TraceState.m29$$Nest$fgetmEvent(state), ClickViewTreeConstants.TRIGGER_SOURCE_MOTION_EVENT, ClickViewTreeConstants.CLICK_CLASSIFICATION_TOUCH_CONFIRMED_CLICK, TraceState.m28$$Nest$fgetmDisplayId(state));
            this.mAssistStructure = state.consumerAssistStructure();
            this.mConsumeReason = TraceState.m25$$Nest$fgetmConsumeReason(state);
            this.mCreatedAtElapsedMillis = SystemClock.elapsedRealtime();
        }

        boolean matches(View view) {
            if ((SystemClock.elapsedRealtime() - this.mCreatedAtElapsedMillis) <= ClickViewTraceContext.PENDING_TOUCH_CLICK_TIMEOUT_MILLIS) goto L7;
            ClickViewTraceContext.m18$$Nest$sfgetsPendingTouchClick().remove();
            return false;
        L7:
            if (this.mConsumerView.get() != view) goto L10;
            return true;
        L10:
            return false;
        }

        ClickViewTreeRecord buildConfirmedRecord() {
            ClickViewTreeRecord.Builder r0 = ClickViewTreeRecord.builder().setEvent(ClickEventInfo.builder().setEventId(this.mEvent.eventId).setTriggerSource(ClickViewTreeConstants.TRIGGER_SOURCE_MOTION_EVENT).setClickClassification(ClickViewTreeConstants.CLICK_CLASSIFICATION_TOUCH_CONFIRMED_CLICK).setDisplayId(this.mEvent.displayId).setDownTimeMillis(this.mEvent.downTimeMillis).setUpTimeMillis(this.mEvent.upTimeMillis).setX(this.mEvent.x).setY(this.mEvent.y).setRawX(this.mEvent.rawX).setRawY(this.mEvent.rawY).setCoordinateSource(this.mEvent.coordinateSource).setSource(this.mEvent.source).setButtonState(this.mEvent.buttonState).setMetaState(this.mEvent.metaState).build()).setAssistStructure(this.mAssistStructure).setConsumeReason(this.mConsumeReason).setClickClassification(ClickViewTreeConstants.CLICK_CLASSIFICATION_TOUCH_CONFIRMED_CLICK);
            if (this.mAssistStructure == null) goto L5;
            String r1 = ClickViewTreeConstants.STATUS_SUCCESS;
        L7:
            return r0.setStatus(r1).setMatchedBy(ClickViewTreeConstants.MATCHED_BY_NONE).build();
        L5:
            r1 = ClickViewTreeConstants.STATUS_SECURE_BLOCKED;
            goto L7
        }
    }

    private static final class TraceState {
        private AssistStructure mAssistStructure;
        private boolean mAssistStructureBuilt;
        private boolean mCaptureBlocked;
        private boolean mClickPerformed;
        private String mConsumeReason;
        private int mConsumerDepth;
        private View mConsumerView;
        private final ArrayList<View> mDispatchStack;
        private final int mDisplayId;
        private final MotionEvent mEvent;
        private View mInterceptingView;
        private boolean mReported;
        private String mTriggerSource;
        private boolean mWindowHandled;

        /* JADX INFO: renamed from: -$$Nest$fgetmClickPerformed, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m24$$Nest$fgetmClickPerformed(TraceState r0) {
            return r0.mClickPerformed;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmConsumeReason, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m25$$Nest$fgetmConsumeReason(TraceState r0) {
            return r0.mConsumeReason;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmConsumerDepth, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m26$$Nest$fgetmConsumerDepth(TraceState r0) {
            return r0.mConsumerDepth;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmConsumerView, reason: not valid java name */
        static /* bridge */ /* synthetic */ View m27$$Nest$fgetmConsumerView(TraceState r0) {
            return r0.mConsumerView;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmDisplayId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m28$$Nest$fgetmDisplayId(TraceState r0) {
            return r0.mDisplayId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmEvent, reason: not valid java name */
        static /* bridge */ /* synthetic */ MotionEvent m29$$Nest$fgetmEvent(TraceState r0) {
            return r0.mEvent;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmReported, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m30$$Nest$fgetmReported(TraceState r0) {
            return r0.mReported;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmReported, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m31$$Nest$fputmReported(TraceState r0, boolean r1) {
            r0.mReported = r1;
        }

        TraceState(MotionEvent event, int displayId) {
            this.mDispatchStack = new ArrayList();
            this.mConsumeReason = "NONE";
            this.mTriggerSource = ClickViewTreeConstants.TRIGGER_SOURCE_MOTION_EVENT;
            this.mConsumerDepth = -1;
            this.mEvent = event;
            this.mDisplayId = displayId;
        }

        void setWindowHandled(boolean handled) {
            this.mWindowHandled = handled;
        }

        void pushView(View view) {
            if (view == null) goto L5;
            this.mDispatchStack.add(view);
            return;
        }

        void popView(View view) {
            int lastIndex = this.mDispatchStack.size() - 1;
            if (lastIndex < 0) goto L9;
            if (this.mDispatchStack.get(lastIndex) != view) goto L9;
            this.mDispatchStack.remove(lastIndex);
            return;
        L9:
            if (view == null) goto L20;
            int i = lastIndex;
        L11:
            if (i < 0) goto L20;
            if (this.mDispatchStack.get(i) == view) goto L14;
            i = i - 1;
            goto L11
        L14:
            this.mDispatchStack.remove(i);
            if (ClickViewTraceContext.m22$$Nest$smisDebugEnabled() == false) goto L29;
            Log.w(ClickViewTraceContext.TAG, "ClickViewTree[STACK_MISMATCH] recovered pop of " + view.getClass().getName() + " at index " + i + " (stackSize=" + (lastIndex + 1) + ")");
            return;
        L29:
            return;
        L20:
            if (ClickViewTraceContext.m22$$Nest$smisDebugEnabled() == false) goto L30;
            StringBuilder r2 = new StringBuilder().append("ClickViewTree[STACK_MISMATCH] view not found: ");
            if (view != null) goto L24;
            String r3 = "null";
        L25:
            Log.w(ClickViewTraceContext.TAG, r2.append(r3).append(" stackSize=").append(lastIndex + 1).toString());
            return;
        L24:
            r3 = view.getClass().getName();
            goto L25
        }

        void recordDispatchResult(View view, boolean handled) {
            if (handled == true) goto L4;
            return;
        L4:
            if (this.mConsumerView == null) goto L6;
            return;
        L6:
            if ((view instanceof ViewGroup) == true) goto L11;
            recordConsumer(view, "UNKNOWN");
            return;
        }

        void recordConsumer(View view, String consumeReason) {
            int depth = this.mDispatchStack.size();
            if (view != null) goto L5;
            return;
        L5:
            if (depth < this.mConsumerDepth) goto L14;
            this.mConsumerView = view;
            this.mConsumerDepth = depth;
            if (consumeReason != null) goto L10;
            String r1 = "UNKNOWN";
        L11:
            this.mConsumeReason = r1;
            return;
        L10:
            r1 = consumeReason;
            goto L11
        }

        void recordClick(View view, String triggerSource) {
            this.mClickPerformed = true;
            if (triggerSource != null) goto L5;
            String r0 = "UNKNOWN";
        L6:
            this.mTriggerSource = r0;
            recordConsumer(view, ClickViewTreeConstants.CONSUME_REASON_PERFORM_CLICK);
            return;
        L5:
            r0 = triggerSource;
            goto L6
        }

        void recordIntercept(View parent, boolean intercepted) {
            if (intercepted == false) goto L5;
            this.mInterceptingView = parent;
            return;
        }

        boolean isInterceptingView(View view) {
            if (view != null) goto L4;
        L6:
            return false;
        L4:
            if (view != this.mInterceptingView) goto L6;
            return true;
        }

        void recordChildDispatchResult(ViewGroup parent, View child, boolean cancel, boolean handled) {
            if (handled == false) goto L11;
            if (child != null) goto L5;
            return;
        L5:
            if (this.mConsumerView != null) goto L13;
            if (cancel == false) goto L8;
            String r0 = "UNKNOWN";
        L9:
            recordConsumer(child, r0);
            return;
        L8:
            r0 = ClickViewTreeConstants.CONSUME_REASON_ON_TOUCH_EVENT;
            goto L9
        L13:
            return;
        }

        ClickViewTreeRecord buildRecord() {
            String clickClassification = getClickClassification();
            AssistStructure structure = consumerAssistStructure();
            return ClickViewTreeRecord.builder().setEvent(ClickViewTraceContext.m20$$Nest$smbuildMotionEventInfo(this.mEvent, this.mTriggerSource, clickClassification, this.mDisplayId)).setAssistStructure(structure).setConsumeReason(this.mConsumeReason).setClickClassification(clickClassification).setStatus(resolveStatus(structure)).setMatchedBy(ClickViewTreeConstants.MATCHED_BY_NONE).build();
        }

        private String resolveStatus(AssistStructure structure) {
            if (structure == null) goto L6;
            return ClickViewTreeConstants.STATUS_SUCCESS;
        L6:
            if (this.mCaptureBlocked == false) goto L8;
            return ClickViewTreeConstants.STATUS_SECURE_BLOCKED;
        L8:
            return ClickViewTreeConstants.STATUS_NO_CONSUMER;
        }

        AssistStructure consumerAssistStructure() {
            if (this.mAssistStructureBuilt == true) goto L10;
            if (ClickViewTraceContext.m21$$Nest$smisCaptureBlockedByAncestry(this.mConsumerView) == false) goto L7;
            this.mCaptureBlocked = true;
            this.mAssistStructure = null;
        L8:
            this.mAssistStructureBuilt = true;
            goto L10
        L7:
            int depth = ClickViewTraceContext.resolveCaptureDepth(this.mConsumerView, 5, ClickViewTreeConstants.MAX_VIEW_NODE_COUNT);
            ClickViewTraceContext.m23$$Nest$smlogStage("CAPTURE_DEPTH", "consumer=" + this.mConsumerView.getClass().getName() + " depth=" + depth + " maxDepth=5 maxNodes=" + ClickViewTreeConstants.MAX_VIEW_NODE_COUNT);
            this.mAssistStructure = ClickViewTraceContext.m19$$Nest$smbuildAssistStructure(this.mConsumerView, depth);
        L10:
            return this.mAssistStructure;
        }

        private String getClickClassification() {
            if (this.mClickPerformed == false) goto L7;
            return ClickViewTreeConstants.CLICK_CLASSIFICATION_TOUCH_CONFIRMED_CLICK;
        L7:
            if (this.mConsumerView == null) goto L9;
            return ClickViewTreeConstants.CLICK_CLASSIFICATION_TOUCH_CONSUMED_NO_CLICK;
        L9:
            if (this.mWindowHandled == true) goto L15;
            return ClickViewTreeConstants.CLICK_CLASSIFICATION_TOUCH_NOT_CONSUMED;
        L15:
            return ClickViewTreeConstants.CLICK_CLASSIFICATION_TOUCH_CONSUMED_NO_CLICK;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsPendingTouchClick, reason: not valid java name */
    static /* bridge */ /* synthetic */ ThreadLocal m18$$Nest$sfgetsPendingTouchClick() {
        return sPendingTouchClick;
    }

    /* JADX INFO: renamed from: -$$Nest$smbuildAssistStructure, reason: not valid java name */
    static /* bridge */ /* synthetic */ AssistStructure m19$$Nest$smbuildAssistStructure(View r0, int r1) {
        return buildAssistStructure(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smbuildMotionEventInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ ClickEventInfo m20$$Nest$smbuildMotionEventInfo(MotionEvent r0, String r1, String r2, int r3) {
        return buildMotionEventInfo(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$smisCaptureBlockedByAncestry, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m21$$Nest$smisCaptureBlockedByAncestry(View r0) {
        return isCaptureBlockedByAncestry(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smisDebugEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m22$$Nest$smisDebugEnabled() {
        return isDebugEnabled();
    }

    /* JADX INFO: renamed from: -$$Nest$smlogStage, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m23$$Nest$smlogStage(String r0, String r1) {
        logStage(r0, r1);
    }

    static {
        sCurrentTrace = new ThreadLocal();
        sPendingTouchClick = new ThreadLocal();
        sLastTraceUptime = ThreadLocal.withInitial(new ClickViewTraceContext$$ExternalSyntheticLambda0());
    }

    static /* synthetic */ long[] lambda$static$0() {
        return new long[1];
    }

    private ClickViewTraceContext() {
    }

    public static void beginTrace(MotionEvent event, View rootView, int displayId) {
        if (event != null) goto L4;
        return;
    L4:
        if (event.getActionMasked() == 1) goto L7;
        return;
    L7:
        if (shouldTraceMotionEvent(event, rootView) == true) goto L9;
        return;
    L9:
        long nowUptime = SystemClock.uptimeMillis();
        long[] lastTrace = sLastTraceUptime.get();
        if ((nowUptime - lastTrace[0]) >= MIN_TRACE_INTERVAL_MILLIS) goto L12;
        return;
    L12:
        lastTrace[0] = nowUptime;
        sCurrentTrace.set(new TraceState(event, displayId));
        logStage("TRACE_BEGIN", "eventId=" + event.getId() + " displayId=" + displayId);
    }

    public static void endTrace(MotionEvent event, boolean handled) {
        TraceState state = sCurrentTrace.get();
        if (state != null) goto L30;
        return;
    L30:
        state.setWindowHandled(handled);     // Catch: Throwable -> L27
        boolean deferred = true;
        if (TraceState.m30$$Nest$fgetmReported(state) == true) goto L8;
        ClickViewTreeReporter.report(state.buildRecord());     // Catch: Throwable -> L27
        TraceState.m31$$Nest$fputmReported(state, true);     // Catch: Throwable -> L27
    L8:
        View consumerView = TraceState.m27$$Nest$fgetmConsumerView(state);     // Catch: Throwable -> L27
        if (consumerView != null) goto L11;
    L13:
        deferred = false;
    L14:
        StringBuilder r4 = new StringBuilder().append("consumer=");     // Catch: Throwable -> L27
        if (consumerView != null) goto L17;
        String r5 = ClickViewTreeConstants.MATCHED_BY_NONE;
    L18:
        StringBuilder r6 = r4.append(r5).append(" consumeReason=").append(TraceState.m25$$Nest$fgetmConsumeReason(state)).append(" consumerDepth=").append(TraceState.m26$$Nest$fgetmConsumerDepth(state)).append(" windowHandled=").append(handled).append(" outcome=");     // Catch: Throwable -> L27
        if (deferred == false) goto L21;
        String r7 = "reported_pending_click";
    L22:
        logStage("TRACE_END", r6.append(r7).toString());     // Catch: Throwable -> L27
        if (deferred == false) goto L25;
        final PendingTouchClick pending = new PendingTouchClick(state);     // Catch: Throwable -> L27
        sPendingTouchClick.set(pending);     // Catch: Throwable -> L27
        consumerView.postDelayed(new ClickViewTraceContext$$ExternalSyntheticLambda1(pending), PENDING_TOUCH_CLICK_TIMEOUT_MILLIS);     // Catch: Throwable -> L27
    L25:
        sCurrentTrace.remove();
        return;
    L21:
        r7 = "reported";
        goto L22
    L17:
        r5 = consumerView.getClass().getName();     // Catch: Throwable -> L27
        goto L18
    L11:
        if (TraceState.m24$$Nest$fgetmClickPerformed(state) == true) goto L13;
    L27:
        th = move-exception;
        sCurrentTrace.remove();
        throw th;
    }

    static /* synthetic */ void lambda$endTrace$1(PendingTouchClick pending) {
        if (sPendingTouchClick.get() != pending) goto L6;
        sPendingTouchClick.remove();
        return;
    }

    public static void onViewDispatchStart(View view, MotionEvent event) {
        TraceState state = sCurrentTrace.get();
        if (state == null) goto L6;
        state.pushView(view);
        return;
    }

    public static void onViewDispatchEnd(View view, MotionEvent event, boolean handled) {
        TraceState state = sCurrentTrace.get();
        if (state != null) goto L11;
        return;
    L11:
        state.recordDispatchResult(view, handled);     // Catch: Throwable -> L8
        state.popView(view);
        return;
    L8:
        th = move-exception;
        state.popView(view);
        throw th;
    }

    public static void onTouchListenerResult(View view, MotionEvent event, boolean handled) {
        TraceState state = sCurrentTrace.get();
        if (state == null) goto L7;
        if (handled == false) goto L8;
        state.recordConsumer(view, ClickViewTreeConstants.CONSUME_REASON_ON_TOUCH_LISTENER);
        return;
    L8:
        return;
    }

    public static void onTouchEventResult(View view, MotionEvent event, boolean handled) {
        TraceState state = sCurrentTrace.get();
        if (state == null) goto L11;
        if (handled == true) goto L6;
        return;
    L6:
        if (state.isInterceptingView(view) == false) goto L8;
        String reason = ClickViewTreeConstants.CONSUME_REASON_VIEW_GROUP_INTERCEPT;
    L9:
        state.recordConsumer(view, reason);
        return;
    L8:
        reason = ClickViewTreeConstants.CONSUME_REASON_ON_TOUCH_EVENT;
        goto L9
    }

    public static void onViewGroupDispatchStart(ViewGroup parent, MotionEvent event) {
        TraceState state = sCurrentTrace.get();
        if (state == null) goto L6;
        state.pushView(parent);
        return;
    }

    public static void onViewGroupDispatchEnd(ViewGroup parent, MotionEvent event, boolean handled) {
        TraceState state = sCurrentTrace.get();
        if (state != null) goto L11;
        return;
    L11:
        state.recordDispatchResult(parent, handled);     // Catch: Throwable -> L8
        state.popView(parent);
        return;
    L8:
        th = move-exception;
        state.popView(parent);
        throw th;
    }

    public static void onViewGroupIntercept(ViewGroup parent, MotionEvent event, boolean intercepted) {
        TraceState state = sCurrentTrace.get();
        if (state == null) goto L6;
        state.recordIntercept(parent, intercepted);
        return;
    }

    public static void onViewGroupChildDispatchResult(ViewGroup parent, View child, MotionEvent event, boolean cancel, boolean handled) {
        TraceState state = sCurrentTrace.get();
        if (state == null) goto L6;
        state.recordChildDispatchResult(parent, child, cancel, handled);
        return;
    }

    public static void onPerformClick(View view) {
        mergePerformClickIntoTouch(view);
    }

    private static void mergePerformClickIntoTouch(View view) {
        if (view != null) goto L4;
        return;
    L4:
        if (isAutoActionDisplay(view) == false) goto L19;
        TraceState state = sCurrentTrace.get();
        if (state == null) goto L10;
        state.recordClick(view, ClickViewTreeConstants.TRIGGER_SOURCE_MOTION_EVENT);
        ClickViewTreeRecord record = state.buildRecord();
        ClickViewTreeReporter.report(record);
        TraceState.m31$$Nest$fputmReported(state, true);
        logStage("CLICK_CONFIRMED", "path=in_trace consumer=" + view.getClass().getName());
        return;
    L10:
        PendingTouchClick pending = sPendingTouchClick.get();
        if (pending != null) goto L13;
        return;
    L13:
        if (pending.matches(view) == false) goto L18;
        sPendingTouchClick.remove();
        logStage("CLICK_CONFIRMED", "path=pending consumer=" + view.getClass().getName() + " reported=false");
        return;
    L18:
        return;
    }

    private static boolean shouldTraceMotionEvent(MotionEvent event, View rootView) {
        if (event != null) goto L4;
    L16:
        return false;
    L4:
        if (event.isFromSource(2) == false) goto L16;
        if (event.isTouchEvent() == false) goto L16;
        if (isAutoActionDisplay(rootView) == false) goto L16;
        if (isInjectListenerPresent() == false) goto L16;
        if (isCallUserTakeover() == true) goto L16;
        if (isSecureWindow(rootView) == true) goto L16;
        return true;
    }

    private static boolean isSecureWindow(View rootView) {
        boolean secure = false;
        if (rootView != null) goto L5;
        return false;
    L5:
        ViewRootImpl root = rootView.getViewRootImpl();
        if (root != null) goto L9;
        return false;
    L9:
        if ((root.getWindowFlags() & 8192) == 0) goto L11;
        secure = true;
    L11:
        if (secure == false) goto L13;
        logCaptureBlocked("secure_window", rootView);
    L13:
        return secure;
    }

    private static boolean isInjectListenerPresent() {
        return SystemProperties.getBoolean(ClickViewTreeConstants.INJECT_LISTENER_PROPERTY, false);
    }

    private static boolean isCallUserTakeover() {
        return SystemProperties.getBoolean(ClickViewTreeConstants.CALL_USER_PROPERTY, false);
    }

    private static boolean isAutoActionDisplay(View view) {
        if (view != null) goto L4;
    L8:
        return false;
    L4:
        if (view.getDisplay() == null) goto L8;
        if ("auto_action".equals(view.getDisplay().getName()) == false) goto L8;
        return true;
    }

    private static ClickEventInfo buildMotionEventInfo(MotionEvent event, String triggerSource, String clickClassification, int displayId) {
        ClickEventInfo.Builder builder = ClickEventInfo.builder().setEventId(String.valueOf(event.getId())).setTriggerSource(triggerSource).setClickClassification(clickClassification).setDisplayId(displayId).setDownTimeMillis(event.getDownTime()).setUpTimeMillis(event.getEventTime()).setCoordinateSource(ClickViewTreeConstants.COORDINATE_SOURCE_INPUT_EVENT).setSource(ClickViewTreeConstants.formatSource(event.getSource())).setButtonState(event.getButtonState()).setMetaState(event.getMetaState());
        if (event.getPointerCount() <= 0) goto L6;
        builder.setX(event.getX()).setY(event.getY()).setRawX(event.getRawX()).setRawY(event.getRawY());
    L6:
        return builder.build();
    }

    private static AssistStructure buildAssistStructure(View root, int maxDepth) {
        if (root != null) goto L5;
        return null;
    L5:
        return new AssistStructure(false, 0, true, root, maxDepth);
    }

    private static boolean isCaptureBlockedByAncestry(View view) {
        View node = view;
    L3:
        if (node == null) goto L16;
        if (node.isAssistBlocked() == true) goto L6;
        Object r1 = node.getParent();
        if ((r1 instanceof View) == false) goto L14;
        View r2 = (View) r1;
    L15:
        node = r2;
        goto L3
    L14:
        r2 = null;
        goto L15
    L6:
        if (node != view) goto L8;
        String r3 = "assist_blocked_self";
    L9:
        logCaptureBlocked(r3, node);
        return true;
    L8:
        r3 = "assist_blocked_ancestor";
        goto L9
    L16:
        return false;
    }

    private static void logCaptureBlocked(String reason, View node) {
        logStage("CAPTURE_BLOCKED", "reason=" + reason + " node=" + node.getClass().getName());
    }

    private static boolean isDebugEnabled() {
        if (Build.IS_DEBUGGABLE == true) goto L5;
        return false;
    L5:
        if (SystemProperties.getBoolean(ClickViewTreeConstants.DEBUG_PROPERTY, false) == false) goto L9;
        return true;
    L9:
        return false;
    }

    private static void logStage(String stage, String detail) {
        if (isDebugEnabled() == false) goto L6;
        Log.d(TAG, "ClickViewTree[" + stage + "] " + detail);
        return;
    }

    static int resolveCaptureDepth(View root, int maxDepth, int maxNodes) {
        if (root != null) goto L6;
        return 0;
    L6:
        boolean debug = isDebugEnabled();
        if (debug == false) goto L9;
        ArrayList<Integer> dist = new ArrayList();
    L10:
        String stopReason = "tree_end";
        int rejectedLevel = 0;
        ArrayList<View> currentLevel = new ArrayList();
        currentLevel.add(root);
        int cumulative = 0;
        int depth = 0;
    L12:
        if (currentLevel.isEmpty() == true) goto L52;
        if (maxDepth <= 0) goto L16;
        if (depth < maxDepth) goto L16;
        stopReason = "depth_cap";
    L16:
        int levelCount = currentLevel.size();
        if (maxNodes > 0) goto L19;
    L21:
        cumulative = cumulative + levelCount;
        depth = depth + 1;
        if (dist == null) goto L24;
        dist.add(Integer.valueOf(levelCount));
    L24:
        if (maxNodes <= 0) goto L27;
        if (cumulative != maxNodes) goto L27;
        stopReason = "node_budget_exact";
    L27:
        ArrayList<View> nextLevel = new ArrayList();
        int i = 0;
    L28:
        if (i >= levelCount) goto L50;
        View view = currentLevel.get(i);
        if ((view instanceof ViewGroup) == false) goto L49;
        ViewGroup group = (ViewGroup) view;
        if (group.isAssistBlocked() == true) goto L49;
        if (group.isLaidOut() == false) goto L37;
    L39:
        int childCount = group.getChildCount();
        int j = 0;
    L40:
        if (j >= childCount) goto L49;
        boolean debug2 = debug;
        View child = group.getChildAt(j);
        if (child == null) goto L46;
        if (child.getVisibility() != 0) goto L46;
        nextLevel.add(child);
    L46:
        j = j + 1;
        debug = debug2;
        goto L40
    L37:
        if (group.isAttachedToWindow() == true) goto L39;
    L49:
        i = i + 1;
        debug = debug;
        goto L28
    L50:
        currentLevel = nextLevel;
        goto L12
    L19:
        if ((cumulative + levelCount) <= maxNodes) goto L21;
        stopReason = "node_budget_overflow";
        rejectedLevel = levelCount;
    L52:
        if (debug == false) goto L54;
        logStage("CAPTURE_PROBE", "depth=" + depth + " nodesWithinDepth=" + cumulative + " stopReason=" + stopReason + " rejectedLevel=" + rejectedLevel + " maxDepth=" + maxDepth + " maxNodes=" + maxNodes + " dist=" + dist);
    L54:
        return depth;
    L9:
        dist = null;
        goto L10
    }
}
