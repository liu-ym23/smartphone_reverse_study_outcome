package com.bytedance.apm.block;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.PerfConfig;
import com.bytedance.apm.block.trace.MainThreadMonitor;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.ExceptionTypeName;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.ExceptionLogData;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.thread.ThreadWithHandler;
import com.bytedance.apm.trace.fps.FpsTracer;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.common.util.JellyBeanV16Compat;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.monitor.collector.AbsLooperDispatchListener;
import com.bytedance.monitor.collector.LooperDispatchMonitor;
import com.bytedance.monitor.collector.LooperUtil;
import com.bytedance.monitor.collector.PerfMonitorManager;
import com.obric.matrix.platform.sdk.ones.internal.monitor.EventConstants;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class StackThread {
    private static final String INVALID_STACK = "Invalid Stack\n";
    private static final int LIMIT_STACK_DEPTH = 40;
    private static final long MAX_SAVE_LOG_NUM = 60;
    private static final long MAX_SAVE_LOG_TIME = 60000;
    private static final String TAG = "StackThread";
    private static long evilThresholdMs = 1000;
    private static boolean isNativePollOnceEnable = false;
    private static boolean isSamplingStackEnable = false;
    private static volatile StackThread sINSTANCE;
    private volatile boolean belongDump;
    private final StringBuilder catonDumpSb;
    private boolean dumpingPollOnceStack;
    private volatile boolean enableGfxMonitor;
    private boolean isNeedMonitorBlock;
    private boolean isNeedMonitorSeriousBlock;
    private boolean isSliverDump;
    private final String mBlockDetectorClassName;
    private long mBlockInterval;
    private LinkedList<ExceptionLogData> mBlockLogData;
    private BlockRecord mCurrentRecord;
    private boolean mEnableDumpStack;
    private BlockRecord mLastBlockRecord;
    private final Runnable mRunnable;
    private long mSeriousBlockInterval;
    private final Runnable mSeriousBlockRunnable;
    private ThreadWithHandler mThreadWithHandler;
    private volatile boolean mWithSeriousBlock;
    private final StringBuilder sb;

    static {
    }

    static /* synthetic */ long access$000(StackThread r2) {
        return r2.mBlockInterval;
    }

    static /* synthetic */ BlockRecord access$100(StackThread r0) {
        return r0.mCurrentRecord;
    }

    static /* synthetic */ void access$1000(StackThread r0, BlockRecord r1, String r2, boolean r3) throws JSONException {
        r0.reportSeriousBlock(r1, r2, r3);
    }

    static /* synthetic */ void access$1100(StackThread r0, BlockRecord r1, String r2) throws JSONException {
        r0.reportMessageKey(r1, r2);
    }

    static /* synthetic */ void access$1200(StackThread r0, long r1) {
        r0.reportPerfInfo(r1);
    }

    static /* synthetic */ LinkedList access$1300(StackThread r0) {
        return r0.mBlockLogData;
    }

    static /* synthetic */ boolean access$1402(StackThread r0, boolean r1) {
        r0.belongDump = r1;
        return r1;
    }

    static /* synthetic */ boolean access$200(StackThread r0) {
        return r0.isSliverDump;
    }

    static /* synthetic */ String access$300(StackThread r0) {
        return r0.mBlockDetectorClassName;
    }

    static /* synthetic */ StringBuilder access$400(StackThread r0) {
        return r0.catonDumpSb;
    }

    static /* synthetic */ JSONObject access$500(StackThread r0) {
        return r0.getMemoryInfo();
    }

    static /* synthetic */ long access$600(StackThread r2) {
        return r2.mSeriousBlockInterval;
    }

    static /* synthetic */ boolean access$700(StackThread r0) {
        return r0.mEnableDumpStack;
    }

    static /* synthetic */ void access$800(StackThread r0, boolean r1, BlockRecord r2, String r3) throws JSONException {
        r0.reportBlock(r1, r2, r3);
    }

    static /* synthetic */ boolean access$900(StackThread r0) {
        return r0.mWithSeriousBlock;
    }

    private StackThread() {
        this.mWithSeriousBlock = false;
        this.mBlockInterval = PerfConsts.DEFAULT_BLOCK_INTERVAL_MS;
        this.mSeriousBlockInterval = 5000;
        this.dumpingPollOnceStack = false;
        this.mEnableDumpStack = true;
        this.catonDumpSb = new StringBuilder(1200);
        this.sb = new StringBuilder(1200);
        this.mLastBlockRecord = null;
        this.belongDump = false;
        this.enableGfxMonitor = false;
        this.isNeedMonitorBlock = true;
        this.isNeedMonitorSeriousBlock = true;
        this.mBlockLogData = new LinkedList();
        this.isSliverDump = false;
        this.mRunnable = new AnonymousClass1(this);
        this.mSeriousBlockRunnable = new AnonymousClass2(this);
        this.mBlockDetectorClassName = StackThread.class.getName();
    }

    static StackThread getInstance() {
        if (sINSTANCE != null) goto L15;
        monitor-enter(StackThread.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sINSTANCE != null) goto L9;
        sINSTANCE = new StackThread();     // Catch: Throwable -> L11
    L9:
        monitor-exit(StackThread.class);     // Catch: Throwable -> L11
    L15:
        return sINSTANCE;
    }

    public void init() {
        ThreadWithHandler r0 = new ThreadWithHandler(TAG);
        this.mThreadWithHandler = r0;
        r0.start();
    }

    public void setSliverDump(boolean r1) {
        this.isSliverDump = r1;
    }

    public static void setEvilThresholdMs(long r2) {
        if (r2 >= 70) goto L5;
        r2 = 1000;
    L5:
        evilThresholdMs = r2;
    }

    public static void setIsSamplingStackEnable(boolean r0) {
        isSamplingStackEnable = r0;
    }

    public void setEnableGfxMonitor(boolean r1) {
        this.enableGfxMonitor = r1;
    }

    private JSONObject getMemoryInfo() {
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L7
        Context r0 = ApmContext.getContext();     // Catch: Exception -> L7
        if (r0 == null) goto L5;
        ActivityManager r1 = (ActivityManager) r0.getSystemService("activity");     // Catch: Exception -> L7
        ActivityManager.MemoryInfo r2 = new ActivityManager.MemoryInfo();     // Catch: Exception -> L7
        r1.getMemoryInfo(r2);     // Catch: Exception -> L7
        r4.put("availMem", r2.availMem);     // Catch: Exception -> L7
        r4.put("lowMemory", r2.lowMemory);     // Catch: Exception -> L7
        r4.put("threshold", r2.threshold);     // Catch: Exception -> L7
        r4.put("totalMem", JellyBeanV16Compat.getTotalMem(r2));     // Catch: Exception -> L7
    L5:
        Runtime r3 = Runtime.getRuntime();     // Catch: Exception -> L7
        r4.put("max_memory", r3.maxMemory());     // Catch: Exception -> L7
        r4.put("free_memory", r3.freeMemory());     // Catch: Exception -> L7
        r4.put("total_memory", r3.totalMemory());     // Catch: Exception -> L7
        return r4;
    L7:
        return null;
    }

    public void printStart(String r7) {
        if (this.mThreadWithHandler.isReady() == true) goto L5;
        return;
    L5:
        if (isNativePollOnceEnable == false) goto L12;
        if (this.dumpingPollOnceStack == false) goto L12;
        BlockRecord r0 = this.mCurrentRecord;     // Catch: Exception -> L28
        r0.endTime = AbsLooperDispatchListener.uptime;     // Catch: Exception -> L28
        if ((this.mCurrentRecord.endTime - this.mCurrentRecord.beginTime) <= this.mBlockInterval) goto L12;
        this.mCurrentRecord.isPollOnce = true;     // Catch: Exception -> L28
        this.mCurrentRecord.belongFrame = false;     // Catch: Exception -> L28
        BlockRecord r1 = this.mCurrentRecord;     // Catch: Exception -> L28
        r1.belongDump = this.belongDump;     // Catch: Exception -> L28
        handleSingleStack(this.mCurrentRecord.getCopy());     // Catch: Exception -> L28
    L12:
        if (this.mLastBlockRecord != null) goto L14;
    L16:
        BlockRecord r2 = this.mCurrentRecord;     // Catch: Exception -> L28
        if (r2 != null) goto L19;
        this.mCurrentRecord = new BlockRecord(AbsLooperDispatchListener.uptime, r7);     // Catch: Exception -> L28
    L21:
        if (this.mEnableDumpStack == false) goto L32;
        this.mThreadWithHandler.postDelayed(this.mRunnable, this.mBlockInterval);     // Catch: Exception -> L28
        if (this.mWithSeriousBlock == true) goto L25;
        return;
    L25:
        if (this.isNeedMonitorSeriousBlock == false) goto L34;
        this.mThreadWithHandler.postDelayed(this.mSeriousBlockRunnable, this.mSeriousBlockInterval);     // Catch: Exception -> L28
        return;
    L34:
        return;
    L32:
        return;
    L19:
        r2.reset(AbsLooperDispatchListener.uptime, r7);     // Catch: Exception -> L28
        goto L21
    L14:
        if (MainThreadMonitor.getMonitor().mainThreadInfo.isInputDelayed() == false) goto L16;
        this.mLastBlockRecord.delayInputEvent = true;     // Catch: Exception -> L28
    }

    public void printEnd(boolean r10) {
        if (this.mThreadWithHandler.isReady() == false) goto L55;
        BlockRecord r0 = this.mLastBlockRecord;     // Catch: Exception -> L52
        if (r0 == null) goto L9;
        if (r10 == false) goto L8;
        r0.delayDoFrame = true;     // Catch: Exception -> L52
    L8:
        dealBlockRecord(this.mLastBlockRecord);     // Catch: Exception -> L52
        this.mLastBlockRecord = null;     // Catch: Exception -> L52
    L9:
        BlockRecord r1 = this.mCurrentRecord;     // Catch: Exception -> L52
        if (r1 != null) goto L12;
        return;
    L12:
        if (r1.beginTime >= 0) goto L14;
        return;
    L14:
        if (this.mCurrentRecord.endTime != (-1)) goto L58;
        BlockRecord r2 = this.mCurrentRecord;     // Catch: Exception -> L52
        r2.endTime = AbsLooperDispatchListener.uptime;     // Catch: Exception -> L52
        if (this.mEnableDumpStack == false) goto L20;
        this.mThreadWithHandler.removeCallbacks(this.mRunnable);     // Catch: Exception -> L52
        this.mThreadWithHandler.removeCallbacks(this.mSeriousBlockRunnable);     // Catch: Exception -> L52
    L20:
        if ((this.mCurrentRecord.endTime - this.mCurrentRecord.beginTime) <= this.mBlockInterval) goto L31;
        fillScene(this.mCurrentRecord);     // Catch: Exception -> L52
        BlockRecord r3 = this.mCurrentRecord;     // Catch: Exception -> L52
        r3.currentTime = System.currentTimeMillis();     // Catch: Exception -> L52
        if (this.mEnableDumpStack == true) goto L24;
        this.mCurrentRecord.ignoreStack = true;     // Catch: Exception -> L52
    L24:
        this.mCurrentRecord.belongFrame = r10;     // Catch: Exception -> L52
        BlockRecord r4 = this.mCurrentRecord;     // Catch: Exception -> L52
        r4.belongDump = this.belongDump;     // Catch: Exception -> L52
        handleSingleStack(this.mCurrentRecord.getCopy());     // Catch: Exception -> L52
        if ((this.mCurrentRecord.endTime - this.mCurrentRecord.beginTime) <= this.mSeriousBlockInterval) goto L31;
        if (r10 == false) goto L31;
        if (this.enableGfxMonitor == false) goto L31;
        GFXInfo.getDisplayList();     // Catch: Exception -> L52
    L31:
        if (isSamplingStackEnable == false) goto L42;
        if ((this.mCurrentRecord.endTime - this.mCurrentRecord.beginTime) <= evilThresholdMs) goto L42;
        if (TextUtils.isEmpty(this.mCurrentRecord.lastScene) == false) goto L38;
        fillScene(this.mCurrentRecord);     // Catch: Exception -> L52
    L38:
        if (this.mCurrentRecord.currentTime != 0) goto L40;
        BlockRecord r5 = this.mCurrentRecord;     // Catch: Exception -> L52
        r5.currentTime = System.currentTimeMillis();     // Catch: Exception -> L52
    L40:
        reportStackTrace(r10, this.mCurrentRecord.getCopy());     // Catch: Exception -> L52
    L42:
        if (isNativePollOnceEnable == false) goto L59;
        Message r11 = LooperUtil.getMessageObject(LooperUtil.getMainMessageQueue());     // Catch: Exception -> L52
        if (r11 != null) goto L46;
        return;
    L46:
        long r6 = SystemClock.uptimeMillis();     // Catch: Exception -> L52
        if (r11.getTarget() != null) goto L49;
        return;
    L49:
        if (r11.getWhen() >= r6) goto L61;
        this.dumpingPollOnceStack = true;     // Catch: Exception -> L52
        this.mCurrentRecord.reset(r6, null);     // Catch: Exception -> L52
        this.mThreadWithHandler.postDelayed(this.mRunnable, this.mBlockInterval);     // Catch: Exception -> L52
        return;
    L61:
        return;
    L59:
        return;
    L58:
        return;
    L55:
        return;
    }

    public void setNeedMonitorBlock(boolean r1) {
        this.isNeedMonitorBlock = r1;
    }

    public void setNeedMonitorSeriousBlock(boolean r1) {
        this.isNeedMonitorSeriousBlock = r1;
    }

    public void setBlockInterval(long r3) {
        if (r3 >= 70) goto L5;
        r3 = PerfConsts.DEFAULT_BLOCK_INTERVAL_MS;
    L5:
        this.mBlockInterval = r3;
        checkBlockInterval();
    }

    public void setSeriousBlockInterval(long r3) {
        if (r3 >= this.mBlockInterval) goto L5;
        r3 = 5000;
    L5:
        this.mSeriousBlockInterval = r3;
        checkBlockInterval();
    }

    public void setEnableDumpStack(boolean r1) {
        this.mEnableDumpStack = r1;
    }

    private void checkBlockInterval() {
        long r0 = this.mSeriousBlockInterval;
        long r2 = this.mBlockInterval;
        if (r0 >= r2) goto L6;
        this.mSeriousBlockInterval = r2 + 50;
        return;
    }

    public void setWithSeriousBlock(boolean r1) {
        this.mWithSeriousBlock = r1;
    }

    private StackTraceElement[] buildStack(StackTraceElement[] r5) {
        if (r5 == null) goto L5;
        return r5;
    L5:
        return new StackTraceElement[]{new StackTraceElement(INVALID_STACK, "a", "a.java", 1)};
    }

    private void handleSingleStack(BlockRecord r6) {
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isValid == true) goto L8;
        r6.reset();
    L8:
        if ((r6.endTime - r6.beginTime) < this.mSeriousBlockInterval) goto L10;
        boolean r0 = true;
    L11:
        r6.isSeriousBlock = r0;
        LooperDispatchMonitor.ScheduleItem r1 = PerfMonitorManager.getInstance().getLastMessageItem();
        if (r1 == null) goto L19;
        StackTraceElement[] r2 = buildStack(r6.stackTrace);
        if (r6.isSeriousBlock == false) goto L16;
        StackTraceElement[] r3 = buildStack(r6.stackTrace2);
    L17:
        r1.updateBlockInfo("uuid", r2, r3, null);
        goto L19
    L16:
        r3 = null;
    L19:
        if (r6.isPollOnce == false) goto L21;
        dealBlockRecord(r6);
        return;
    L21:
        this.mLastBlockRecord = r6;
        return;
    L10:
        r0 = false;
        goto L11
    }

    private void dealBlockRecord(final BlockRecord r3) {
        AsyncEventManager.getInstance().post(new AnonymousClass3(this, r3));
    }

    private void reportBlock(boolean r4, BlockRecord r5, String r6) throws JSONException {
        if (this.isNeedMonitorBlock == true) goto L5;
        return;
    L5:
        JSONObject r0 = packRecord(r5);
        r0.put("stack", r5.trace);
        r0.put("message", r6);
        r0.put("ignore_stack", this.mCurrentRecord.ignoreStack);
        r0.put("event_type", "lag");
        r0.put("filters", getFilterJson(r4, r5, r6));
        r0.put("custom", getCustomJson());
        ExceptionLogData r7 = new ExceptionLogData("block_monitor", r0, r5.beginTime);
        checkAndPutLogData(r7);
        CommonDataPipeline.getInstance().handle(r7);
    }

    private void checkAndPutLogData(ExceptionLogData r5) {
    L3:
        if (this.mBlockLogData.size() == 0) goto L13;
        if ((r5.crashTime() - this.mBlockLogData.getFirst().crashTime()) < 0) goto L12;
        if ((r5.crashTime() - this.mBlockLogData.getFirst().crashTime()) > 60000) goto L12;
        if (this.mBlockLogData.size() <= 60) goto L13;
        this.mBlockLogData.removeFirst();
    L12:
        this.mBlockLogData.removeFirst();
    L13:
        this.mBlockLogData.addLast(r5);
    }

    private void reportSeriousBlock(BlockRecord r17, String r18, boolean r19) throws JSONException {
        if (this.isNeedMonitorSeriousBlock == true) goto L5;
        return;
    L5:
        JSONObject r3 = getFilterJson(r17.belongFrame, r17, r18);
        r3.put("sbuuid", "empty");
        JSONObject r4 = packRecord(r17);
        r4.put("message", r18);
        if (r17.stackTrace != null) goto L8;
    L41:
        r4.put(CommonKey.KEY_STACK_COST, r17.traceTime2 - r17.traceTime);
        r4.put("filters", r3);
        r4.put("event_type", ExceptionTypeName.EXCEPTION_EVENT_TYPE_SERIOUS_LAG);
        r4.put("block_looper_info", r17.looperMessages);
        r4.put(CommonKey.KEY_BLOCK_CPU_INFO, r17.cpuInfo);
        r4.put(CommonKey.KEY_BLOCK_MEMORY_INFO, r17.memoryInfo);
        r4.put("custom", r17.perfInfo);
        r4.put(CommonKey.KEY_BLOCK_ERROR_INFO, r19);
        ExceptionLogData r2 = new ExceptionLogData("serious_block_monitor", r4, r17.beginTime);
        checkAndPutLogData(r2);
        CommonDataPipeline.getInstance().handle(r2);
        return;
    L8:
        if (r17.stackTrace2 == null) goto L41;
        int r5 = r17.stackTrace.length;
        int r6 = r17.stackTrace2.length;
        int r8 = 0;
        int r9 = 0;
    L11:
        if (r8 >= Math.min(r5, r6)) goto L19;
        int r11 = (r5 - r8) - 1;
        int r13 = (r6 - r8) - 1;
        if (r17.stackTrace[r11].equals(r17.stackTrace2[r13]) == false) goto L15;
        r9 = r9 + 1;
        r8 = r8 + 1;
        goto L11
    L15:
        if (isSameMethod(r17.stackTrace[r11], r17.stackTrace2[r13]) == false) goto L19;
        r9 = r9 + 1;
    L19:
        if (r9 != 0) goto L21;
        r3.put(CommonKey.KEY_SERIOUS_STACK_COINCIDE, "none");
    L33:
        this.sb.setLength(0);
    L34:
        if (r9 <= 0) goto L37;
        int r14 = r5 - r9;
        this.sb.append("\tat ").append(r17.stackTrace[r14].getClassName()).append(LibrarianImpl.Constants.DOT).append(r17.stackTrace[r14].getMethodName()).append("(").append(r17.stackTrace[r14].getFileName()).append(":").append(r17.stackTrace[r14].getLineNumber()).append(")\n");
        r9 = r9 - 1;
        goto L34
    L37:
        if (this.sb.length() != 0) goto L39;
        String r7 = r17.trace;
    L40:
        r4.put("stack", r7);
        r3.put("sbuuid", r17.uuid);
        goto L41
    L39:
        r7 = this.sb.toString();
        goto L40
    L21:
        if (r9 != r5) goto L24;
        if (r9 != r6) goto L24;
        r3.put(CommonKey.KEY_SERIOUS_STACK_COINCIDE, "full");
    L24:
        r3.put(CommonKey.KEY_SERIOUS_STACK_COINCIDE, "part");
        this.sb.setLength(0);
        int r15 = 0;
    L26:
        if (r15 > (r5 - r9)) goto L28;
        this.sb.append("\tat ").append(r17.stackTrace[r15].getClassName()).append(LibrarianImpl.Constants.DOT).append(r17.stackTrace[r15].getMethodName()).append("(").append(r17.stackTrace[r15].getFileName()).append(":").append(r17.stackTrace[r15].getLineNumber()).append(")\n");
        r15 = r15 + 1;
        goto L26
    L28:
        r4.put(CommonKey.KEY_STACK1, this.sb.toString());
        this.sb.setLength(0);
        int r16 = 0;
    L30:
        if (r16 > (r6 - r9)) goto L32;
        this.sb.append("\tat ").append(r17.stackTrace2[r16].getClassName()).append(LibrarianImpl.Constants.DOT).append(r17.stackTrace2[r16].getMethodName()).append("(").append(r17.stackTrace2[r16].getFileName()).append(":").append(r17.stackTrace2[r16].getLineNumber()).append(")\n");
        r16 = r16 + 1;
        goto L30
    L32:
        r4.put(CommonKey.KEY_STACK2, this.sb.toString());
        goto L33
    }

    private void reportStackTrace(final boolean r3, final BlockRecord r4) {
        AsyncEventManager.getInstance().post(new AnonymousClass4(this, r4, r3));
    }

    private void reportMessageKey(BlockRecord r4, String r5) throws JSONException {
        if (PerfConfig.isReportMessage() == false) goto L6;
        JSONObject r3 = packRecord(r4);
        JSONObject r0 = PerfFilterManager.getInstance().getPerfFiltersJson(true);
        r0.put("crash_section", ApmContext.getTimeRange(r4.currentTime));
        r0.put("belong_frame", String.valueOf(r4.belongFrame));
        r0.put("belong_dump", String.valueOf(r4.belongDump));
        r0.put("block_stack_type", "messageKey");
        r3.put("filters", r0);
        r3.put("event_type", "lag");
        r3.put("stack", "at " + r5 + ".*(a.java:-1)");
        ExceptionLogData r6 = new ExceptionLogData("block_monitor", r3);
        r6.forceSample();
        CommonDataPipeline.getInstance().handle(r6);
        return;
    }

    private JSONObject getFilterJson(boolean r3, BlockRecord r4, String r5) throws JSONException {
        JSONObject r2 = PerfFilterManager.getInstance().getPerfFiltersJson(true);
        r2.put("crash_section", ApmContext.getTimeRange(r4.currentTime));
        r2.put("belong_frame", String.valueOf(r3));
        r2.put("belong_dump", String.valueOf(r4.belongDump));
        r2.put(CommonKey.KEY_BLOCK_INPUT, String.valueOf(r4.delayInputEvent));
        r2.put(CommonKey.KEY_BLOCK_FRAME, String.valueOf(r4.delayDoFrame));
        r2.put(CommonKey.KEY_BLOCK_MESSAGE, r5);
        r2.put("block_stack_type", "stack");
        r2.put("buuid", r4.uuid);
        r2.put(CommonKey.KEY_BELONG_POLL_ONCE, String.valueOf(r4.isPollOnce));
        Map<String, String> r6 = BlockDetectorUtil.getTags();
        if (r6 != null) goto L5;
    L10:
        return r2;
    L5:
        if (r6.isEmpty() == true) goto L10;
        Iterator<Map.Entry<String, String>> r7 = r6.entrySet().iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        Map.Entry<String, String> r8 = r7.next();
        r2.put(r8.getKey(), r8.getValue());
        goto L8
    }

    private JSONObject getCustomJson() {
        JSONObject r3 = new JSONObject();
        Map<String, String> r0 = BlockDetectorUtil.getTags();     // Catch: JSONException -> L13
        if (r0 == null) goto L12;
        if (r0.isEmpty() == true) goto L12;
        Iterator<Map.Entry<String, String>> r1 = r0.entrySet().iterator();     // Catch: JSONException -> L13
    L9:
        if (r1.hasNext() == false) goto L12;
        Map.Entry<String, String> r2 = r1.next();     // Catch: JSONException -> L13
        r3.put(r2.getKey(), r2.getValue());     // Catch: JSONException -> L13
    L12:
        return r3;
    }

    private JSONObject packRecord(BlockRecord r6) {
        long r0 = r6.endTime - r6.beginTime;
        JSONObject r5 = new JSONObject();
        r5.put("timestamp", r6.currentTime);     // Catch: JSONException -> L5
        r5.put(CommonKey.KEY_CRASH_TIME, r6.currentTime);     // Catch: JSONException -> L5
        r5.put("is_main_process", ApmContext.isMainProcess());     // Catch: JSONException -> L5
        r5.put("process_name", ApmContext.getCurrentProcessName());     // Catch: JSONException -> L5
        r5.put("block_duration", r0);     // Catch: JSONException -> L5
        r5.put("last_scene", r6.lastScene);     // Catch: JSONException -> L5
    L7:
        return r5;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    private void fillScene(BlockRecord r2) {
        String r1 = FpsTracer.getInjectScene();
        if (TextUtils.isEmpty(r1) == false) goto L5;
        r2.lastScene = ActivityLifeObserver.getInstance().getTopActivityClassName();
        return;
    L5:
        r2.lastScene = r1 + "," + ActivityLifeObserver.getInstance().getTopActivityClassName();
    }

    static boolean isSameMethod(StackTraceElement r4, StackTraceElement r5) {
        if (r4 != r5) goto L6;
        return true;
    L6:
        if (r4 == null) goto L18;
        if (r5 == null) goto L18;
        if (r4.getClassName().equals(r5.getClassName()) == false) goto L17;
        if (objectEquals(r4.getMethodName(), r5.getMethodName()) == false) goto L17;
        if (objectEquals(r4.getFileName(), r5.getFileName()) == false) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    static boolean objectEquals(Object r0, Object r1) {
        if (r0 == r1) goto L8;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.equals(r1) == false) goto L7;
    L8:
        return true;
    }

    void forceReportLogData() {
        final long r0 = SystemClock.uptimeMillis();
        AsyncEventManager.getInstance().post(new AnonymousClass5(this, r0));
    }

    void sigQuit() {
        AsyncEventManager.getInstance().post(new AnonymousClass6(this));
    }

    void sigQuitEnd() {
        AsyncEventManager.getInstance().post(new AnonymousClass7(this));
    }

    private void reportPerfInfo(long r5) {
        String r6 = MethodCollector.getInstance().getEvilMethod(0, r5);     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r6) == false) goto L6;
        return;
    L6:
        JSONObject r7 = PerfMonitorManager.getInstance().dumpInfos();     // Catch: Throwable -> L8
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L8
        r0.put("is_main_process", ApmContext.isMainProcess());     // Catch: Throwable -> L8
        r0.put("block_duration", 5000);     // Catch: Throwable -> L8
        r0.put("stack", r6);     // Catch: Throwable -> L8
        r0.put("stack_key", "1048574\n");     // Catch: Throwable -> L8
        r0.put("scene", "anr");     // Catch: Throwable -> L8
        r0.put(EventConstants.EVENT_KEY_COST_TIME, 5000);     // Catch: Throwable -> L8
        r0.put("method_time", 5000);     // Catch: Throwable -> L8
        r0.put("message", "anr");     // Catch: Throwable -> L8
        r0.put("event_type", "lag_drop_frame");     // Catch: Throwable -> L8
        JSONObject r4 = PerfFilterManager.getInstance().getPerfFiltersJson(true);     // Catch: Throwable -> L8
        r4.put("crash_section", ApmContext.getTimeRange(System.currentTimeMillis()));     // Catch: Throwable -> L8
        r4.put(CommonKey.KEY_TRACE_TYPE, "ANR");     // Catch: Throwable -> L8
        r0.put("custom", r7);     // Catch: Throwable -> L8
        r0.put("filters", r4);     // Catch: Throwable -> L8
        CommonDataPipeline.getInstance().handle(new ExceptionLogData("drop_frame_stack", r0));     // Catch: Throwable -> L8
        return;
    }
}
