package com.bytedance.monitor.collector;

import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.thread.ThreadWithHandler;
import com.bytedance.monitor.collector.service.ServiceFollowBean;
import com.bytedance.monitor.collector.service.ServiceTrackMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LooperDispatchMonitor extends AbsMonitor {
    private static int CHECK_TIME_INTERVAL = 0;
    private static final int CHECK_TIME_SIZE = 300;
    private static int GET_STACK_THRESHOLD = 0;
    private static final int MILLION = 1000000;
    private static final int MIN_CACHE_POOL_SIZE = 10;
    private static final int MIN_TICK_TIME = 100;
    public static final String NO_MESSAGE_RUNNING = "no message running";
    private static final int SCHEDULE_TYPE_IDLE = 1;
    private static final int SCHEDULE_TYPE_MESSAGE = 8;
    private static final int SCHEDULE_TYPE_NORMAL = 9;
    private static final String TAG = "LooperDispatchMonitor";
    private static int dumpStackTicks;
    public static boolean dumpStackTimeSwitch;
    private static int[] mStartDumpStackTime;
    private static int[] mTickTimes;
    public static boolean sCheckTimeLevelSwitch;
    public static boolean sNeedCheckTime;
    private static volatile IStackTracer sStackTracer;
    private volatile boolean belongJavaMessage;
    private Runnable checkTimeRunnable;
    private volatile boolean isRunning;
    private int mCachePoolSize;
    private CheckTimeItemList mCheckTimeItemList;
    private String mCurrentMsg;
    FrameCallback mFrameCallback;
    private long mLastCPUTime;
    private String mLastMsg;
    private long mLastSaveTime;
    private long mLastTrigTime;
    private AbsLooperDispatchListener mListener;
    private int mMainThreadId;
    private int mMsgCount;
    private volatile int mMsgNumFlag;
    private ScheduleItemList mScheduleItemList;
    private final ThreadWithHandler mThreadWithHandler;
    private int mTickTime;
    private boolean needFrameInfo;

    private static class CheckTimeItem {
        long cost;
        long delay;
        boolean isMessage;
        int seqNum;
        String stacks;
        long startTime;

        private CheckTimeItem() {
        }

        /* synthetic */ CheckTimeItem(AnonymousClass1 r1) {
            this();
        }

        public JSONObject toJson() {
            JSONObject r0 = new JSONObject();
            r0.put("startTime", this.startTime);     // Catch: JSONException -> L5
            r0.put("cost", this.cost);     // Catch: JSONException -> L5
            r0.put("delay", this.delay);     // Catch: JSONException -> L5
            r0.put("isMessage", String.valueOf(this.isMessage));     // Catch: JSONException -> L5
            r0.put("seqNum", this.seqNum);     // Catch: JSONException -> L5
            r0.put("stack", this.stacks);     // Catch: JSONException -> L5
        L7:
            return r0;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }

        public String toLog() {
            StringBuilder r0 = new StringBuilder("startTime:");
            r0.append(this.startTime).append(",cost:").append(this.cost).append(",delay:").append(this.delay).append(",belongMessage:").append(this.isMessage).append(",flag:").append(this.seqNum);
            return r0.toString();
        }

        void recycle() {
            this.startTime = -1;
            this.cost = -1;
            this.delay = -1;
            this.seqNum = -1;
            this.stacks = null;
        }

        CheckTimeItem copy() {
            CheckTimeItem r0 = new CheckTimeItem();
            r0.startTime = this.startTime;
            r0.cost = this.cost;
            r0.delay = this.delay;
            r0.isMessage = this.isMessage;
            r0.seqNum = this.seqNum;
            r0.stacks = this.stacks;
            return r0;
        }
    }

    private static class CheckTimeItemList {
        CheckTimeItem cachedItem;
        final List<CheckTimeItem> checkTimeItems;
        final int poolSize;
        private int position;

        public CheckTimeItemList(int r2) {
            this.position = 0;
            this.poolSize = r2;
            this.checkTimeItems = new ArrayList(r2);
        }

        CheckTimeItem obtainScheduleItem() {
            CheckTimeItem r0 = this.cachedItem;
            AnonymousClass1 r1 = null;
            if (r0 == null) goto L6;
            this.cachedItem = null;
            return r0;
        L6:
            return new CheckTimeItem(r1);
        }

        void addItem(CheckTimeItem r3) {
            int r0 = this.checkTimeItems.size();
            int r1 = this.poolSize;
            if (r0 >= r1) goto L5;
            this.checkTimeItems.add(r3);
            this.position = this.checkTimeItems.size();
            return;
        L5:
            int r2 = this.position % r1;
            this.position = r2;
            CheckTimeItem r4 = this.checkTimeItems.set(r2, r3);
            r4.recycle();
            this.cachedItem = r4;
            this.position++;
        }

        CheckTimeItem getCurrentItem() {
            int r0 = this.position;
            if (r0 > 0) goto L5;
            if (r0 != 0) goto L9;
            List<CheckTimeItem> r1 = this.checkTimeItems;
            return r1.get(r1.size() - 1);
        L9:
            return null;
        L5:
            return this.checkTimeItems.get(r0 - 1);
        }

        JSONArray dumpItemList() {
            JSONArray r0 = new JSONArray();
            int r3 = 0;
            if (this.checkTimeItems.size() != this.poolSize) goto L12;
            int r1 = this.position - 1;
        L6:
            if (r1 >= this.checkTimeItems.size()) goto L9;
            r0.put(this.checkTimeItems.get(r1).toJson());
            r1 = r1 + 1;
        L9:
            if (r3 >= (this.position - 1)) goto L14;
            r0.put(this.checkTimeItems.get(r3).toJson());
            r3 = r3 + 1;
        L14:
            return r0;
        L12:
            if (r3 >= this.checkTimeItems.size()) goto L14;
            r0.put(this.checkTimeItems.get(r3).toJson());
            r3 = r3 + 1;
            goto L12
        }

        List<CheckTimeItem> dumpItems() {
            ArrayList r0 = new ArrayList();
            int r3 = 0;
            if (this.checkTimeItems.size() != this.poolSize) goto L12;
            int r1 = this.position - 1;
        L6:
            if (r1 >= this.checkTimeItems.size()) goto L9;
            r0.add(this.checkTimeItems.get(r1).copy());
            r1 = r1 + 1;
        L9:
            if (r3 >= (this.position - 1)) goto L14;
            r0.add(this.checkTimeItems.get(r3).copy());
            r3 = r3 + 1;
        L14:
            return r0;
        L12:
            if (r3 >= this.checkTimeItems.size()) goto L14;
            r0.add(this.checkTimeItems.get(r3).copy());
            r3 = r3 + 1;
            goto L12
        }
    }

    public interface FrameCallback {
        void doFrame(long[] r1);
    }

    public static class FrameInfo {
        long animationsStart;
        long drawStart;
        long inputHandlingStart;
        long intendedVsync;
        long performTraversalsStart;

        public FrameInfo() {
        }
    }

    public static class ScheduleItem {
        StackTraceElement[] blockStack;
        long cpuTime;
        String dispatchMsg;
        long duration;
        String evilMsg;
        FrameInfo frameInfo;
        long itemEndTime;
        long lastTrigTime;
        public String mLastScheduleMsg;
        int messageCount;
        StackTraceElement[] seriousBlockStack;
        ServiceFollowBean service;
        public long startTime;
        int type;
        String uuid;

        public ScheduleItem() {
        }

        public void updateBlockInfo(String r2, StackTraceElement[] r3, StackTraceElement[] r4, String r5) {
            if (TextUtils.isEmpty(r2) == true) goto L5;
            this.uuid = r2;
        L5:
            if (r3 == null) goto L7;
            this.blockStack = r3;
        L7:
            if (r4 == null) goto L10;
            this.seriousBlockStack = r4;
        L10:
            if (TextUtils.isEmpty(r5) == true) goto L13;
            this.evilMsg = r5;
            return;
        }

        public JSONObject toJson() {
            JSONObject r0 = new JSONObject();
            r0.put(NotificationCompat.CATEGORY_MESSAGE, Util.parseMessageKey(this.dispatchMsg));     // Catch: JSONException -> L5
            r0.put("cpuDuration", this.cpuTime);     // Catch: JSONException -> L5
            r0.put("duration", this.duration);     // Catch: JSONException -> L5
            r0.put("type", this.type);     // Catch: JSONException -> L5
            r0.put("messageCount", this.messageCount);     // Catch: JSONException -> L5
            r0.put("lastDuration", this.itemEndTime - this.lastTrigTime);     // Catch: JSONException -> L5
            r0.put("start", this.startTime);     // Catch: JSONException -> L5
            r0.put(TraceStatsConsts.STATS_KEY_END, this.itemEndTime);     // Catch: JSONException -> L5
            appendExtInfo(r0);     // Catch: JSONException -> L5
        L7:
            return r0;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }

        public String toLog() {
            return "msg:" + Util.parseMessageKey(this.dispatchMsg) + ",cpuDuration:" + this.cpuTime + ",duration:" + this.duration + ",type:" + this.type + ",messageCount:" + this.messageCount + ",lastDuration:" + (this.itemEndTime - this.lastTrigTime) + ",start:" + this.startTime + ",end:" + this.itemEndTime;
        }

        boolean needPrint() {
            if ((this.itemEndTime - this.lastTrigTime) <= 17) goto L5;
            return true;
        L5:
            if (this.duration > 400) goto L22;
            int r0 = this.messageCount;
            if (r0 <= 300) goto L10;
            return true;
        L10:
            if (r0 >= 20) goto L13;
            return true;
        L13:
            if (this.type != 1) goto L16;
            return true;
        L16:
            if (this.cpuTime < 20) goto L24;
            return false;
        L24:
            return true;
        L22:
            return true;
        }

        private void appendExtInfo(JSONObject r8) throws JSONException {
            StackTraceElement[] r0 = this.blockStack;
            if (r0 == null) goto L5;
            r8.put("block_stack", Util.stackToString(r0));
        L5:
            r8.put("block_uuid", this.uuid);
            StackTraceElement[] r1 = this.seriousBlockStack;
            if (r1 == null) goto L8;
            r8.put("sblock_stack", Util.stackToString(r1));
        L8:
            r8.put("sblock_uuid", this.uuid);
            if (TextUtils.isEmpty(this.evilMsg) == false) goto L12;
            r8.put("evil_msg", this.evilMsg);
        L12:
            if (this.frameInfo == null) goto L14;
            boolean r2 = true;
        L15:
            r8.put("belong_frame", r2);
            FrameInfo r3 = this.frameInfo;
            if (r3 == null) goto L18;
            r8.put("vsyncDelayTime", this.lastTrigTime - (r3.intendedVsync / 1000000));
            r8.put("doFrameTime", (this.frameInfo.inputHandlingStart / 1000000) - this.lastTrigTime);
            r8.put("inputHandlingTime", (this.frameInfo.animationsStart / 1000000) - (this.frameInfo.inputHandlingStart / 1000000));
            r8.put("animationsTime", (this.frameInfo.performTraversalsStart / 1000000) - (this.frameInfo.animationsStart / 1000000));
            r8.put("performTraversalsTime", (this.frameInfo.drawStart / 1000000) - (this.frameInfo.performTraversalsStart / 1000000));
            r8.put("drawTime", this.itemEndTime - (this.frameInfo.drawStart / 1000000));
        L18:
            ServiceFollowBean r4 = this.service;
            if (r4 == null) goto L22;
            r8.put("service_name", r4.mServiceName);
            r8.put("service_what", this.service.mWhat);
            r8.put("service_time", this.service.mTimeStamp);
            r8.put("service_thread", this.service.mThreadName);
            r8.put("service_token", this.service.mToken);
            return;
        L22:
            return;
        L14:
            r2 = false;
            goto L15
        }

        void recycle() {
            this.type = -1;
            this.messageCount = -1;
            this.duration = -1;
            this.dispatchMsg = null;
            this.blockStack = null;
            this.seriousBlockStack = null;
            this.evilMsg = null;
            this.uuid = null;
            this.frameInfo = null;
            this.service = null;
            this.mLastScheduleMsg = null;
        }
    }

    private static class ScheduleItemList {
        ScheduleItem cachedItem;
        int poolSize;
        int position;
        List<ScheduleItem> scheduleItemList;

        ScheduleItemList(int r2) {
            this.scheduleItemList = new ArrayList();
            this.poolSize = r2;
        }

        ScheduleItem obtainScheduleItem(int r2) {
            ScheduleItem r0 = this.cachedItem;
            if (r0 == null) goto L5;
            r0.type = r2;
            ScheduleItem r3 = this.cachedItem;
            this.cachedItem = null;
            return r3;
        L5:
            ScheduleItem r1 = new ScheduleItem();
            r1.type = r2;
            return r1;
        }

        void addItem(ScheduleItem r3) {
            int r0 = this.scheduleItemList.size();
            int r1 = this.poolSize;
            if (r0 >= r1) goto L5;
            this.scheduleItemList.add(r3);
            this.position = this.scheduleItemList.size();
        L7:
            if (ApmAlogHelper.isFeedbackALogEnabled() == true) goto L9;
            return;
        L9:
            if (r3.needPrint() == false) goto L13;
            final String r4 = r3.toLog();
            AsyncEventManager.getInstance().post(new AnonymousClass1(this, r4));
            return;
        L13:
            return;
        L5:
            int r2 = this.position % r1;
            this.position = r2;
            ScheduleItem r5 = this.scheduleItemList.set(r2, r3);
            r5.recycle();
            this.cachedItem = r5;
            this.position++;
            goto L7
        }

        ScheduleItem getCurrentItem() {
            int r0 = this.position;
            if (r0 > 0) goto L7;
            return null;
        L7:
            return this.scheduleItemList.get(r0 - 1);
        }

        List<ScheduleItem> dumpItemList() {
            ArrayList r0 = new ArrayList();
            int r3 = 0;
            if (this.scheduleItemList.size() != this.poolSize) goto L12;
            int r1 = this.position - 1;
        L6:
            if (r1 >= this.scheduleItemList.size()) goto L9;
            r0.add(this.scheduleItemList.get(r1));
            r1 = r1 + 1;
        L9:
            if (r3 >= (this.position - 1)) goto L14;
            r0.add(this.scheduleItemList.get(r3));
            r3 = r3 + 1;
        L14:
            return r0;
        L12:
            if (r3 >= this.scheduleItemList.size()) goto L14;
            r0.add(this.scheduleItemList.get(r3));
            r3 = r3 + 1;
            goto L12
        }
    }

    private static class Stack {
        boolean isIn;
        StackTraceElement stackTraceElement;
        long uptime;

        private Stack() {
        }
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    protected void updateConfig(int r1) {
    }

    static /* synthetic */ boolean access$000(LooperDispatchMonitor r0) {
        return r0.needFrameInfo;
    }

    static /* synthetic */ ScheduleItemList access$100(LooperDispatchMonitor r0) {
        return r0.mScheduleItemList;
    }

    static /* synthetic */ Runnable access$1000(LooperDispatchMonitor r0) {
        return r0.checkTimeRunnable;
    }

    static /* synthetic */ ThreadWithHandler access$1100(LooperDispatchMonitor r0) {
        return r0.mThreadWithHandler;
    }

    static /* synthetic */ String access$1200(LooperDispatchMonitor r0) {
        return r0.mCurrentMsg;
    }

    static /* synthetic */ String access$1202(LooperDispatchMonitor r0, String r1) {
        r0.mCurrentMsg = r1;
        return r1;
    }

    static /* synthetic */ void access$1300(LooperDispatchMonitor r0, boolean r1, long r2) {
        r0.handleMessage(r1, r2);
    }

    static /* synthetic */ int access$1408(LooperDispatchMonitor r2) {
        int r0 = r2.mMsgCount;
        r2.mMsgCount = r0 + 1;
        return r0;
    }

    static /* synthetic */ String access$1502(LooperDispatchMonitor r0, String r1) {
        r0.mLastMsg = r1;
        return r1;
    }

    static /* synthetic */ CheckTimeItemList access$200(LooperDispatchMonitor r0) {
        return r0.mCheckTimeItemList;
    }

    static /* synthetic */ int access$300(LooperDispatchMonitor r0) {
        return r0.mMsgNumFlag;
    }

    static /* synthetic */ int access$400() {
        return dumpStackTicks;
    }

    static /* synthetic */ int access$500() {
        return GET_STACK_THRESHOLD;
    }

    static /* synthetic */ boolean access$600(LooperDispatchMonitor r0) {
        return r0.belongJavaMessage;
    }

    static /* synthetic */ boolean access$602(LooperDispatchMonitor r0, boolean r1) {
        r0.belongJavaMessage = r1;
        return r1;
    }

    static /* synthetic */ IStackTracer access$700() {
        return sStackTracer;
    }

    static /* synthetic */ IStackTracer access$800(LooperDispatchMonitor r0) {
        return r0.getStackTracer();
    }

    static /* synthetic */ int access$900() {
        return CHECK_TIME_INTERVAL;
    }

    static {
        mStartDumpStackTime = new int[]{600, 300};
        mTickTimes = new int[]{200, 100};
        sNeedCheckTime = false;
        sCheckTimeLevelSwitch = false;
        dumpStackTimeSwitch = false;
    }

    public LooperDispatchMonitor(int r2) {
        this(r2, false);
    }

    private IStackTracer getStackTracer() {
        return sStackTracer;
    }

    public static void setStackTracer(IStackTracer r0) {
        sStackTracer = r0;
    }

    public LooperDispatchMonitor(int r4, boolean r5) {
        super(r4, "block_looper_info");
        this.mMsgCount = 0;
        this.mMsgNumFlag = 0;
        this.mCachePoolSize = 100;
        this.mTickTime = 200;
        this.mLastSaveTime = -1;
        this.mLastTrigTime = -1;
        this.mMainThreadId = -1;
        this.mLastCPUTime = -1;
        this.isRunning = false;
        this.needFrameInfo = false;
        this.belongJavaMessage = false;
        this.checkTimeRunnable = new AnonymousClass2(this);
        ServiceTrackMonitor.getInstance().start();
        this.mFrameCallback = new AnonymousClass1(this);
        if (r5 == false) goto L5;
    L8:
        ThreadWithHandler r6 = new ThreadWithHandler("looper_monitor__");
        this.mThreadWithHandler = r6;
        r6.start();
        diffIntervalStrategy();
        this.mCheckTimeItemList = new CheckTimeItemList(300);
        r6.postDelayed(this.checkTimeRunnable, CHECK_TIME_INTERVAL);
        return;
    L5:
        if (sNeedCheckTime == true) goto L8;
        this.mThreadWithHandler = null;
    }

    private void diffIntervalStrategy() {
        boolean r3 = dumpStackTimeSwitch;
        if (r3 == false) goto L5;
    L7:
        if (r3 == false) goto L9;
    L11:
        if (r3 == true) goto L13;
    L15:
        if (r3 == true) goto L17;
        return;
    L17:
        if (sCheckTimeLevelSwitch == true) goto L24;
        int r4 = mTickTimes[0];
        CHECK_TIME_INTERVAL = r4;
        int r0 = mStartDumpStackTime[1];
        GET_STACK_THRESHOLD = r0;
        dumpStackTicks = r0 / r4;
        return;
    L24:
        return;
    L13:
        if (sCheckTimeLevelSwitch == false) goto L15;
        int r5 = mTickTimes[1];
        CHECK_TIME_INTERVAL = r5;
        int r1 = mStartDumpStackTime[1];
        GET_STACK_THRESHOLD = r1;
        dumpStackTicks = r1 / r5;
        return;
    L9:
        if (sCheckTimeLevelSwitch == true) goto L11;
        int r6 = mTickTimes[0];
        CHECK_TIME_INTERVAL = r6;
        int r2 = mStartDumpStackTime[0];
        GET_STACK_THRESHOLD = r2;
        dumpStackTicks = r2 / r6;
        return;
    L5:
        if (sCheckTimeLevelSwitch == false) goto L7;
        int r7 = mTickTimes[1];
        CHECK_TIME_INTERVAL = r7;
        int r8 = mStartDumpStackTime[0];
        GET_STACK_THRESHOLD = r8;
        dumpStackTicks = r8 / r7;
    }

    public static void setDumpStackTicks(int r0) {
        dumpStackTicks = r0;
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    void startHyperMode() {
        super.startHyperMode();
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    void stopHyperMode() {
        super.stopHyperMode();
    }

    private void updateConfig() {
        int r0 = this.mRunMode;
        if (r0 != 0) goto L5;
    L12:
        this.mCachePoolSize = 100;
        this.mTickTime = 300;
        return;
    L5:
        if (r0 == 1) goto L12;
        if (r0 != 2) goto L9;
    L11:
        this.mCachePoolSize = 300;
        this.mTickTime = 200;
        return;
    L9:
        if (r0 == 3) goto L11;
    }

    public void startDispatchMonitor() {
        if (this.isRunning == false) goto L5;
        return;
    L5:
        this.isRunning = true;
        updateConfig();
        this.mScheduleItemList = new ScheduleItemList(this.mCachePoolSize);
        AbsLooperDispatchListener r0 = new AnonymousClass3(this);
        this.mListener = r0;
        LooperMonitor.register(r0);
        LooperUtil.getMessageObject(LooperUtil.getMainMessageQueue());
    }

    private void handleMessage(final boolean r14, final long r15) {
        int r0 = this.mMsgNumFlag + 1;
        this.mMsgNumFlag = r0;
        this.mMsgNumFlag = r0 & 65535;
        this.needFrameInfo = false;
        if (this.mLastSaveTime >= 0) goto L6;
        this.mLastSaveTime = r15;
    L6:
        if (this.mLastTrigTime >= 0) goto L9;
        this.mLastTrigTime = r15;
    L9:
        if (this.mMainThreadId >= 0) goto L11;
        this.mMainThreadId = Process.myTid();
        this.mLastCPUTime = SystemClock.currentThreadTimeMillis();
    L11:
        ServiceFollowBean r10 = ServiceTrackMonitor.getCurrentService();
        ServiceTrackMonitor.clearCurrentService();
        long r2 = r15 - this.mLastSaveTime;
        int r1 = this.mTickTime;
        if (r2 > r1) goto L14;
        if (r10 != null) goto L14;
    L28:
        this.mLastTrigTime = r15;
        final String r11 = this.mCurrentMsg;
        if (this.isHyperMode == false) goto L32;
        final long r5 = SystemClock.currentThreadTimeMillis();
        PerfMonitorManager.getInstance().mThreadWithHandler.post(new AnonymousClass4(this, r14, r15, r5, r11));
        return;
    L32:
        return;
    L14:
        long r3 = this.mLastTrigTime;
        if ((r15 - r3) > r1) goto L19;
        if (r10 != null) goto L19;
        saveScheduleItem(9, r15, this.mCurrentMsg);
    L19:
        if (r14 == false) goto L25;
        if (this.mMsgCount != 0) goto L23;
        saveScheduleItem(1, r15, NO_MESSAGE_RUNNING);
        goto L28
    L23:
        saveScheduleItem(9, r3, this.mLastMsg);
        saveScheduleItem(1, r15, NO_MESSAGE_RUNNING, false, null);
        goto L28
    L25:
        if (this.mMsgCount != 0) goto L27;
        saveScheduleItem(8, r15, this.mCurrentMsg, true, r10);
        goto L28
    L27:
        saveScheduleItem(9, r3, this.mLastMsg, false, null);
        saveScheduleItem(8, r15, this.mCurrentMsg, true, r10);
        goto L28
    }

    private void saveScheduleItem(int r8, long r9, String r11) {
        saveScheduleItem(r8, r9, r11, true, null);
    }

    private void saveScheduleItem(int r5, long r6, String r8, boolean r9, ServiceFollowBean r10) {
        this.needFrameInfo = true;
        ScheduleItem r7 = this.mScheduleItemList.obtainScheduleItem(r5);
        r7.duration = r6 - this.mLastSaveTime;
        if (r9 == false) goto L5;
        long r0 = SystemClock.currentThreadTimeMillis();
        r7.cpuTime = r0 - this.mLastCPUTime;
        this.mLastCPUTime = r0;
    L6:
        r7.messageCount = this.mMsgCount;
        r7.dispatchMsg = r8;
        r7.mLastScheduleMsg = this.mLastMsg;
        r7.startTime = this.mLastSaveTime;
        r7.itemEndTime = r6;
        r7.lastTrigTime = this.mLastTrigTime;
        if (r10 == null) goto L9;
        r7.service = r10;
    L9:
        this.mScheduleItemList.addItem(r7);
        this.mMsgCount = 0;
        this.mLastSaveTime = r6;
        return;
    L5:
        r7.cpuTime = -1;
        goto L6
    }

    public ScheduleItem getLastItem() {
        ScheduleItemList r0 = this.mScheduleItemList;
        if (r0 != null) goto L6;
        return null;
    L6:
        if (this.needFrameInfo == true) goto L9;
        return null;
    L9:
        if (r0.getCurrentItem().type == 8) goto L12;
        return null;
    L12:
        return this.mScheduleItemList.getCurrentItem();
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    void start() {
        super.start();
        startDispatchMonitor();
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    Pair<String, ?> dumpInfo() {
        return new Pair(this.mCollectorType, dumpMessages());
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    Pair<String, ?> dumpInfosRange(long r1, long r3) {
        return new Pair(this.mCollectorType, dumpMessages());
    L4:
        return null;
    }

    public JSONObject dumpMessages() {
        long r0 = SystemClock.uptimeMillis();
        JSONObject r2 = new JSONObject();
        JSONArray r3 = dumpHistoryMsg();
        JSONObject r4 = dumpCurrentMsg(r0);
        JSONArray r1 = dumpPendingMsg(100, r0);
        r2.put("history_message", r3);     // Catch: JSONException -> L5
        r2.put("current_message", r4);     // Catch: JSONException -> L5
        r2.put("pending_messages", r1);     // Catch: JSONException -> L5
        r2.put("check_time_info", dumpCheckTime());     // Catch: JSONException -> L5
    L4:
        return r2;
    }

    public List<ScheduleItem> dumpHistoryMsgItem() {
        ScheduleItemList r0 = this.mScheduleItemList;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.dumpItemList();
    }

    public JSONArray dumpCheckTime() {
        CheckTimeItemList r0 = this.mCheckTimeItemList;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.dumpItemList();
    }

    public JSONArray dumpHistoryMsg() {
        JSONArray r0 = new JSONArray();
        List<ScheduleItem> r4 = this.mScheduleItemList.dumpItemList();     // Catch: Throwable -> L15
        if (r4 != null) goto L6;
        return r0;
    L6:
        Iterator<ScheduleItem> r5 = r4.iterator();     // Catch: Throwable -> L15
        int r1 = 0;
    L8:
        if (r5.hasNext() == false) goto L14;
        ScheduleItem r2 = r5.next();     // Catch: Throwable -> L15
        if (r2 == null) goto L8;
        r1 = r1 + 1;     // Catch: Throwable -> L15
        r0.put(r2.toJson().put(SlardarConfigConsts.CONFIG_ID, r1));     // Catch: Throwable -> L15
    L14:
        return r0;
    }

    public ScheduleItem dumpCurrentMsgItem(long r4) {
        ScheduleItem r0 = new ScheduleItem();
        r0.dispatchMsg = this.mCurrentMsg;
        r0.mLastScheduleMsg = this.mLastMsg;
        r0.duration = r4 - this.mLastTrigTime;
        r0.cpuTime = ProcMonitor.getCpuTime(this.mMainThreadId) - this.mLastCPUTime;
        r0.messageCount = this.mMsgCount;
        return r0;
    }

    private JSONObject dumpCurrentMsg(long r7) {
        JSONObject r0 = new JSONObject();
        r0.put("message", this.mCurrentMsg);     // Catch: Throwable -> L5
        r0.put("currentMessageCost", r7 - this.mLastTrigTime);     // Catch: Throwable -> L5
        r0.put("currentMessageCpu", ProcMonitor.getCpuTime(this.mMainThreadId) - this.mLastCPUTime);     // Catch: Throwable -> L5
        r0.put("messageCount", this.mMsgCount);     // Catch: Throwable -> L5
        r0.put("start", this.mLastTrigTime);     // Catch: Throwable -> L5
        r0.put(TraceStatsConsts.STATS_KEY_END, r7);     // Catch: Throwable -> L5
    L4:
        return r0;
    }

    private JSONArray dumpPendingMsg(int r7, long r8) {
        MessageQueue r6 = LooperUtil.getMainMessageQueue();
        JSONArray r0 = new JSONArray();
        if (r6 != null) goto L24;
        return r0;
    L24:
        monitor-enter(r6);     // Catch: Throwable -> L21
        Message r1 = LooperUtil.getMessageObject(r6);     // Catch: Throwable -> L18
        if (r1 != null) goto L10;
        monitor-exit(r6);     // Catch: Throwable -> L18
        return r0;
    L10:
        int r2 = 0;
        int r3 = 0;
    L11:
        if (r1 == null) goto L16;
        if (r2 >= r7) goto L16;
        r2 = r2 + 1;     // Catch: Throwable -> L18
        r3 = r3 + 1;     // Catch: Throwable -> L18
        JSONObject r4 = toJson(r1, r8);     // Catch: Throwable -> L18
        r4.put(SlardarConfigConsts.CONFIG_ID, r3);     // Catch: JSONException -> L22 Throwable -> L18
    L15:
        r0.put(r4);     // Catch: Throwable -> L18
        r1 = LooperUtil.getNextMessage(r1);     // Catch: Throwable -> L18
    L16:
        monitor-exit(r6);     // Catch: Throwable -> L18
        return r0;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        return r0;
    }

    private static JSONObject toJson(Message r3, long r4) {
        JSONObject r0 = new JSONObject();
        if (r3 != null) goto L20;
        return r0;
    L20:
        r0.put("when", r3.getWhen() - r4);     // Catch: JSONException -> L17
        if (r3.getCallback() == null) goto L8;
        r0.put("callback", String.valueOf(r3.getCallback()));     // Catch: JSONException -> L17
    L8:
        r0.put("what", r3.what);     // Catch: JSONException -> L17
        if (r3.getTarget() == null) goto L11;
        r0.put("target", String.valueOf(r3.getTarget()));     // Catch: JSONException -> L17
    L12:
        r0.put("arg1", r3.arg1);     // Catch: JSONException -> L17
        r0.put("arg2", r3.arg2);     // Catch: JSONException -> L17
        if (r3.obj == null) goto L15;
        r0.put("obj", String.valueOf(r3.obj));     // Catch: JSONException -> L17
    L15:
        r0.put("start", r3.getWhen());     // Catch: JSONException -> L17
        r0.put(TraceStatsConsts.STATS_KEY_END, -1);     // Catch: JSONException -> L17
    L19:
        return r0;
    L11:
        r0.put("barrier", r3.arg1);     // Catch: JSONException -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }
}
