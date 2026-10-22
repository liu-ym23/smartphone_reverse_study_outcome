package com.bytedance.apm.perf;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.data.type.PerfData;
import com.bytedance.apm.internal.SpManager;
import com.bytedance.apm.listener.IStorageCheckListener;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.CommonMonitorUtil;
import com.bytedance.apm.util.ParseUtils;
import com.bytedance.apm.util.TopK;
import com.bytedance.common.wschannel.WsConstants;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class StorageCollector extends AbstractPerfCollector {
    private static final String EXTERNAL_PREFIX = "external";
    private static final String INTERNAL_PREFIX = "internal";
    private static long MAX_STORAGE_CHECK_VALUE_BYTES = 17179869184L;
    private static final String TAG = "MonitorStorage";
    private static final long UNIT = 1073741824;
    private static String mInsideDataPath;
    private static String mOutsideDataPath;
    private boolean isExceptionDiskSwitch;
    private TopK<FileNode> mDirListTopK;
    private long mDiskAppUsedThresholdBytes;
    private List<String> mDiskCustomedPaths;
    private List<String> mDiskCustomedRelativePaths;
    private List<DiskInfoNode> mDiskInfoNodes;
    private TopK<FileNode> mFileListTopK;
    private long mFolderSizeThresholdBytes;
    private boolean mHasUploadUsedStorage;
    private List<String> mIgnoredPaths;
    private List<String> mIgnoredRelativePaths;
    private boolean mInitException;
    private String mInsideCachePath;
    private long mInsideCacheSize;
    private long mInsideDataSize;
    private long mOutdatedIntervalMs;
    private TopK<OutdatedNode> mOutdatedListTopK;
    private String mOutsideCachePath;
    private long mOutsideCacheSize;
    private long mOutsideDataSize;
    private int mReportFileMaxCount;
    private IStorageCheckListener mStorageCheckListener;

    public static class DiskInfoNode {
        public static final String TYPE_CUSTOMED = "custom";
        public static final String TYPE_NORMAL = "normal";
        public boolean isFolder;
        public List<DiskInfoNode> nextDisk;
        public String path;
        public String reportType;
        public long size;
        public float sizeRate;

        private DiskInfoNode() {
            this.reportType = "normal";
            this.nextDisk = new ArrayList();
        }

        private String parsePath() {
            String r2 = this.path;
            if (r2.contains(StorageCollector.access$900()) == false) goto L6;
            return r2.replace(StorageCollector.access$900(), StorageCollector.INTERNAL_PREFIX);
        L6:
            if (r2.contains(StorageCollector.access$1000()) == true) goto L8;
            return r2;
        L8:
            return r2.replace(StorageCollector.access$1000(), StorageCollector.EXTERNAL_PREFIX);
        }

        public JSONObject toJson() {
            JSONObject r0 = new JSONObject();
            r0.put(ApmTrafficStats.KEY_PATH, parsePath());     // Catch: JSONException -> L9
            r0.put(PerfConsts.PERF_DISK_FILE_SIZE, this.size);     // Catch: JSONException -> L9
            r0.put("size_rate", this.sizeRate);     // Catch: JSONException -> L9
            r0.put("is_folder", this.isFolder);     // Catch: JSONException -> L9
            r0.put("report_type", this.reportType);     // Catch: JSONException -> L9
            if (this.nextDisk.isEmpty() == true) goto L14;
            JSONArray r1 = new JSONArray();     // Catch: JSONException -> L9
            Iterator<DiskInfoNode> r4 = this.nextDisk.iterator();     // Catch: JSONException -> L9
        L7:
            if (r4.hasNext() == false) goto L11;
            r1.put(r4.next().toJson());     // Catch: JSONException -> L9
            goto L7
        L11:
            r0.put("next_disk", r1);     // Catch: JSONException -> L9
        L14:
            return r0;
        L9:
            e = move-exception;
            e.printStackTrace();
            goto L14
        }

        public /* synthetic */ DiskInfoNode(AnonymousClass1 r1) {
            this();
        }
    }

    public static class FileNode implements Comparable {
        private int num;
        private String path;
        public long size;

        public FileNode() {
        }

        public static /* synthetic */ String access$200(FileNode r0) {
            return r0.path;
        }

        private String parsePath() {
            String r2 = this.path;
            if (r2.contains(StorageCollector.access$900()) == false) goto L6;
            return r2.replace(StorageCollector.access$900(), StorageCollector.INTERNAL_PREFIX);
        L6:
            if (r2.contains(StorageCollector.access$1000()) == true) goto L8;
            return r2;
        L8:
            return r2.replace(StorageCollector.access$1000(), StorageCollector.EXTERNAL_PREFIX);
        }

        @Override // java.lang.Comparable
        public int compareTo(Object r4) {
            long r0 = this.size;
            long r3 = ((FileNode) r4).size;
            if (r0 != r3) goto L7;
            return 0;
        L7:
            if (r0 <= r3) goto L10;
            return 1;
        L10:
            return -1;
        }

        public JSONObject toJSON() {
            JSONObject r0 = new JSONObject();     // Catch: Exception -> L6
            r0.put("name", parsePath());     // Catch: Exception -> L6
            r0.put(PerfConsts.PERF_DISK_FILE_SIZE, this.size);     // Catch: Exception -> L6
            int r4 = this.num;     // Catch: Exception -> L6
            if (r4 <= 0) goto L5;
            r0.put(PerfConsts.PERF_DISK_FILE_NUM, r4);     // Catch: Exception -> L6
        L5:
            return r0;
        L6:
            return null;
        }

        public FileNode(String r1, long r2, int r4) {
            this.path = r1;
            this.size = r2;
            this.num = r4;
        }
    }

    public class Node {
        private int childAccuCount;
        private int childCount;
        private boolean isChildExceedThreshold;
        private boolean isOutdated;
        private long outdateInterval;
        public Node parent;
        private String path;
        public long size;
        final /* synthetic */ StorageCollector this$0;

        private Node(StorageCollector r1) {
            this.this$0 = r1;
        }

        public static /* synthetic */ String access$400(Node r0) {
            return r0.path;
        }

        public static /* synthetic */ String access$402(Node r0, String r1) {
            r0.path = r1;
            return r1;
        }

        public static /* synthetic */ int access$502(Node r0, int r1) {
            r0.childCount = r1;
            return r1;
        }

        public static /* synthetic */ int access$510(Node r2) {
            int r0 = r2.childCount;
            r2.childCount = r0 - 1;
            return r0;
        }

        public static /* synthetic */ boolean access$600(Node r0) {
            return r0.isOutdated;
        }

        public static /* synthetic */ boolean access$602(Node r0, boolean r1) {
            r0.isOutdated = r1;
            return r1;
        }

        public static /* synthetic */ long access$702(Node r0, long r1) {
            r0.outdateInterval = r1;
            return r1;
        }

        private void calcTotalSize() {
            if (TextUtils.equals(this.path, StorageCollector.access$900()) == false) goto L6;
            StorageCollector.access$1402(this.this$0, this.size);
            return;
        L6:
            if (TextUtils.equals(this.path, StorageCollector.access$1000()) == false) goto L9;
            StorageCollector.access$1502(this.this$0, this.size);
            return;
        L9:
            if (TextUtils.equals(this.path, StorageCollector.access$1600(this.this$0)) == false) goto L12;
            StorageCollector.access$1702(this.this$0, this.size);
            return;
        L12:
            if (TextUtils.equals(this.path, StorageCollector.access$1800(this.this$0)) == false) goto L18;
            StorageCollector.access$1902(this.this$0, this.size);
            return;
        }

        private boolean isFull() {
            if (this.childAccuCount != this.childCount) goto L5;
            return true;
        L5:
            return false;
        }

        public void appendChildInfo(long r8) {
            this.size += r8;
            this.childAccuCount++;
            if (this.parent != null) goto L5;
            return;
        L5:
            if (isFull() == true) goto L7;
            return;
        L7:
            if (this.isChildExceedThreshold == false) goto L10;
            this.parent.isChildExceedThreshold = true;
        L10:
            if (this.size >= StorageCollector.access$1100(this.this$0)) goto L12;
        L14:
            this.parent.appendChildInfo(this.size);
            if (this.isOutdated == false) goto L17;
            StorageCollector.access$1300(this.this$0, this.path, this.size, this.childCount, this.outdateInterval);
        L17:
            calcTotalSize();
            return;
        L12:
            if (this.isChildExceedThreshold == true) goto L14;
            StorageCollector.access$1200(this.this$0, this.path, this.size, this.childAccuCount, this.childCount);
            this.parent.isChildExceedThreshold = true;
            goto L14
        }

        public /* synthetic */ Node(StorageCollector r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    public static class OutdatedNode extends FileNode {
        private int num;
        private long outdatedInterval;
        private String path;
        public long size;

        public OutdatedNode(String r1, long r2, int r4, long r5) {
            this.path = r1;
            this.size = r2;
            this.num = r4;
            this.outdatedInterval = r5;
        }

        private String parsePath() {
            String r2 = this.path;
            if (r2.contains(StorageCollector.access$900()) == false) goto L6;
            return r2.replace(StorageCollector.access$900(), StorageCollector.INTERNAL_PREFIX);
        L6:
            if (r2.contains(StorageCollector.access$1000()) == true) goto L8;
            return r2;
        L8:
            return r2.replace(StorageCollector.access$1000(), StorageCollector.EXTERNAL_PREFIX);
        }

        @Override // com.bytedance.apm.perf.StorageCollector.FileNode, java.lang.Comparable
        public int compareTo(Object r4) {
            long r0 = this.outdatedInterval;
            long r3 = ((OutdatedNode) r4).outdatedInterval;
            if (r0 != r3) goto L7;
            return 0;
        L7:
            if (r0 <= r3) goto L10;
            return 1;
        L10:
            return -1;
        }

        @Override // com.bytedance.apm.perf.StorageCollector.FileNode
        public JSONObject toJSON() {
            JSONObject r0 = new JSONObject();     // Catch: Exception -> L7
            r0.put("name", parsePath());     // Catch: Exception -> L7
            r0.put(PerfConsts.PERF_DISK_FILE_SIZE, this.size);     // Catch: Exception -> L7
            int r1 = this.num;     // Catch: Exception -> L7
            if (r1 <= 0) goto L5;
            r0.put(PerfConsts.PERF_DISK_FILE_NUM, r1);     // Catch: Exception -> L7
        L5:
            r0.put(PerfConsts.PERF_DISK_FILE_OUTDATE_INTERVAL, this.outdatedInterval);     // Catch: Exception -> L7
            return r0;
        L7:
            return null;
        }
    }

    public StorageCollector() {
        this.mDiskAppUsedThresholdBytes = 524288000;
        this.mFolderSizeThresholdBytes = 524288000;
        this.mReportFileMaxCount = 20;
        this.mOutdatedIntervalMs = 2592000000L;
        this.mDiskCustomedRelativePaths = new ArrayList();
        this.mIgnoredRelativePaths = new ArrayList();
        this.mIgnoredPaths = new ArrayList();
        this.mDiskCustomedPaths = new ArrayList();
        this.mCollectorSettingKey = "disk";
    }

    public static /* synthetic */ long access$000(StorageCollector r2) {
        return r2.mDiskAppUsedThresholdBytes;
    }

    public static /* synthetic */ IStorageCheckListener access$100(StorageCollector r0) {
        return r0.mStorageCheckListener;
    }

    public static /* synthetic */ String access$1000() {
        return mOutsideDataPath;
    }

    public static /* synthetic */ long access$1100(StorageCollector r2) {
        return r2.mFolderSizeThresholdBytes;
    }

    public static /* synthetic */ void access$1200(StorageCollector r0, String r1, long r2, int r4, int r5) {
        r0.appendExceptionFolderQueue(r1, r2, r4, r5);
    }

    public static /* synthetic */ void access$1300(StorageCollector r0, String r1, long r2, int r4, long r5) {
        r0.appendOutdatedFileQueue(r1, r2, r4, r5);
    }

    public static /* synthetic */ long access$1402(StorageCollector r0, long r1) {
        r0.mInsideDataSize = r1;
        return r1;
    }

    public static /* synthetic */ long access$1502(StorageCollector r0, long r1) {
        r0.mOutsideDataSize = r1;
        return r1;
    }

    public static /* synthetic */ String access$1600(StorageCollector r0) {
        return r0.mInsideCachePath;
    }

    public static /* synthetic */ long access$1702(StorageCollector r0, long r1) {
        r0.mInsideCacheSize = r1;
        return r1;
    }

    public static /* synthetic */ String access$1800(StorageCollector r0) {
        return r0.mOutsideCachePath;
    }

    public static /* synthetic */ long access$1902(StorageCollector r0, long r1) {
        r0.mOutsideCacheSize = r1;
        return r1;
    }

    public static /* synthetic */ String access$900() {
        return mInsideDataPath;
    }

    private void appendExceptionFileQueue(String r3, long r4) {
        if (ApmContext.isDebugMode() == false) goto L6;
        Logger.d(TAG, new String[]{"appendExceptionFileQueue: path: " + r3 + ", size: " + r4});
    L6:
        if (r4 <= MAX_STORAGE_CHECK_VALUE_BYTES) goto L9;
        return;
    L9:
        if (this.mFileListTopK != null) goto L11;
        this.mFileListTopK = new TopK(this.mReportFileMaxCount);
    L11:
        this.mFileListTopK.add(new FileNode(r3, r4, 1));
    }

    private void appendExceptionFolderQueue(String r3, long r4, int r6, int r7) {
        if (ApmContext.isDebugMode() == false) goto L6;
        Log.d(TAG, "appendExceptionFolderQueue: path: " + r3 + ":  size: " + r4 + " , accumulateNum: " + r6 + " , num: " + r7);
    L6:
        if (r4 <= MAX_STORAGE_CHECK_VALUE_BYTES) goto L9;
        return;
    L9:
        if (this.mDirListTopK != null) goto L11;
        this.mDirListTopK = new TopK(this.mReportFileMaxCount);
    L11:
        this.mDirListTopK.add(new FileNode(r3, r4, r7));
    }

    private void appendOutdatedFileQueue(String r9, long r10, int r12, long r13) {
        if (ApmContext.isDebugMode() == false) goto L6;
        Logger.d(TAG, new String[]{"appendutdatedFileQueue: path: " + r9 + ", size: " + r10});
    L6:
        if (r10 >= WsConstants.DEFAULT_IO_LIMIT) goto L8;
        return;
    L8:
        if (r10 <= MAX_STORAGE_CHECK_VALUE_BYTES) goto L11;
        return;
    L11:
        if (this.mOutdatedListTopK != null) goto L13;
        this.mOutdatedListTopK = new TopK(this.mReportFileMaxCount);
    L13:
        this.mOutdatedListTopK.add(new OutdatedNode(r9, r10, r12, r13));
    }

    private long byte2G(long r3) {
        return r3 / UNIT;
    }

    private void calculateDiskInfo(File r10, int r11, boolean r12, List<DiskInfoNode> r13) {
        if (r11 > 2) goto L49;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.exists() == true) goto L8;
        return;
    L8:
        if (this.mIgnoredPaths.contains(r10.getAbsolutePath()) == true) goto L53;
        int r3 = 0;
        AnonymousClass1 r4 = null;
        if (r10.isDirectory() == false) goto L37;
        if (r12 == false) goto L36;
        File[] r14 = r10.listFiles();
        if (r14 != null) goto L16;
        return;
    L16:
        if (r14.length == 0) goto L48;
        int r1 = r14.length;
    L19:
        if (r3 >= r1) goto L54;
        File r2 = r14[r3];
        if (r2 == null) goto L34;
        if (r2.exists() == false) goto L34;
        if (this.mIgnoredPaths.contains(r2.getAbsolutePath()) == true) goto L34;
        DiskInfoNode r5 = new DiskInfoNode(r4);
        r5.isFolder = r2.isDirectory();
        r5.path = r2.getAbsolutePath();
        if (r2.isDirectory() == false) goto L33;
        ArrayList r6 = new ArrayList();
        r5.nextDisk = r6;
        if (r11 != 2) goto L32;
        r5.size = getFolderSize(r2);
    L32:
        calculateDiskInfo(r2, r11 + 1, r12, r6);
        r13.add(r5);
        goto L34
    L33:
        r5.size = r2.length();
        r13.add(r5);
    L34:
        r3 = r3 + 1;
        goto L19
    L54:
        return;
    L48:
        return;
    L36:
        DiskInfoNode r15 = new DiskInfoNode(r4);
        r15.isFolder = true;
        r15.reportType = "custom";
        r15.path = r10.getAbsolutePath();
        r15.size = getFolderSize(r10);
        r13.add(r15);
        return;
    L37:
        DiskInfoNode r9 = new DiskInfoNode(r4);
        r9.isFolder = false;
        r9.path = r10.getAbsolutePath();
        r9.size = r10.length();
        if (r12 == true) goto L40;
        r9.reportType = "custom";
    L40:
        r13.add(r9);
        return;
    L53:
        return;
    }

    private static List<String> convertFileNodeList(TopK<? extends FileNode> r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        LinkedList r0 = new LinkedList();
        Iterator r3 = r2.sortedList().iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r0.add(FileNode.access$200((FileNode) r3.next()));
        goto L7
    L9:
        return r0;
    }

    private long getFolderSize(File r7) {
        long r0 = 0;
        File[] r8 = r7.listFiles();     // Catch: Exception -> L14
        if (r8 != null) goto L6;
    L19:
        return 0;
    L6:
        if (r8.length == 0) goto L19;
        int r2 = r8.length;     // Catch: Exception -> L14
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L21;
        File r4 = r8[r3];     // Catch: Exception -> L14
        if (r4.isDirectory() == false) goto L16;
        long r5 = getFolderSize(r4);     // Catch: Exception -> L14
    L13:
        r0 = r0 + r5;     // Catch: Exception -> L14
        r3 = r3 + 1;
        goto L9
    L16:
        r5 = r4.length();     // Catch: Exception -> L14
    L21:
        return r0;
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L21
    }

    private float getRate(long r1, BigDecimal r3) {
        return (float) new BigDecimal(r1).divide(r3, 4, 4).doubleValue();
    }

    private void handleUsedStorageNew() {
        checkExceptionDisk();     // Catch: Throwable -> L4
        sendData(this.mInsideDataSize + this.mOutsideDataSize, this.mInsideCacheSize + this.mOutsideCacheSize, Environment.getDataDirectory().getTotalSpace() + Environment.getRootDirectory().getTotalSpace(), Environment.getDataDirectory().getFreeSpace());     // Catch: Throwable -> L4
        SpManager.getInstance().saveAsync(PerfConsts.DISK_SP_KEY_CHECK_TIME, System.currentTimeMillis());     // Catch: Throwable -> L4
        return;
    }

    private void handleUsedStorageOld() {
        sendData(CommonMonitorUtil.getUsedStorageSize(ApmContext.getContext()), CommonMonitorUtil.getUsedCacheSize(ApmContext.getContext()), CommonMonitorUtil.getDiskTotalSize(), Environment.getDataDirectory().getFreeSpace());     // Catch: Exception -> L4
        return;
    }

    private void initPaths() {
        if (mInsideDataPath == null) goto L5;
        return;
    L5:
        Context r0 = ApmContext.getContext();
        r0.getPackageName();     // Catch: Exception -> L33
        mInsideDataPath = r0.getFilesDir().getParent();     // Catch: Exception -> L33
        this.mInsideCachePath = r0.getCacheDir().getAbsolutePath();     // Catch: Exception -> L33
        mOutsideDataPath = r0.getExternalFilesDir(null).getParentFile().getAbsolutePath();     // Catch: Exception -> L33
        File r1 = r0.getExternalCacheDir();     // Catch: Exception -> L33
        if (r1 == null) goto L9;
        this.mOutsideCachePath = r1.getAbsolutePath();     // Catch: Exception -> L33
    L9:
        List<String> r2 = this.mIgnoredRelativePaths;     // Catch: Exception -> L33
        if (r2 == null) goto L21;
        Iterator<String> r3 = r2.iterator();     // Catch: Exception -> L33
    L14:
        if (r3.hasNext() == false) goto L21;
        String r4 = r3.next();     // Catch: Exception -> L33
        if (r4.contains(INTERNAL_PREFIX) == true) goto L17;
        if (r4.contains(EXTERNAL_PREFIX) == false) goto L14;
        this.mIgnoredPaths.add(r4.replace(EXTERNAL_PREFIX, mOutsideDataPath));     // Catch: Exception -> L33
        goto L14
    L17:
        this.mIgnoredPaths.add(r4.replace(INTERNAL_PREFIX, mInsideDataPath));     // Catch: Exception -> L33
    L21:
        List<String> r5 = this.mDiskCustomedRelativePaths;     // Catch: Exception -> L33
        if (r5 == null) goto L53;
        Iterator<String> r6 = r5.iterator();     // Catch: Exception -> L33
    L24:
        if (r6.hasNext() == false) goto L54;
        String r7 = r6.next();     // Catch: Exception -> L33
        if (r7.contains(INTERNAL_PREFIX) == true) goto L28;
        if (r7.contains(EXTERNAL_PREFIX) == false) goto L24;
        this.mDiskCustomedPaths.add(r7.replace(EXTERNAL_PREFIX, mOutsideDataPath));     // Catch: Exception -> L33
        goto L24
    L28:
        this.mDiskCustomedPaths.add(r7.replace(INTERNAL_PREFIX, mInsideDataPath));     // Catch: Exception -> L33
        goto L24
    L54:
        return;
    L53:
        return;
    L33:
        this.mInitException = true;
    }

    private boolean isIgnoredNode(DiskInfoNode r3) {
        Iterator<String> r2 = this.mIgnoredPaths.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        String r0 = r2.next();
        if (r3.path.contains(r0) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private long isOutOfDate(long r3) {
        long r0 = System.currentTimeMillis() - r3;
        if (r0 >= this.mOutdatedIntervalMs) goto L5;
        return 0;
    L5:
        if (r0 >= 62899200000L) goto L9;
        return r0;
    L9:
        return 0;
    }

    private void sendData(long r8, long r10, long r12, long r14) {
        if (ApmContext.isDebugMode() == false) goto L6;
        Logger.i(DebugLogger.TAG_PERF, new String[]{"disk: data: " + r8 + " , cache: " + r10 + " , total: " + r12 + " , free: " + r14});     // Catch: Exception -> L87
    L6:
        long r0 = MAX_STORAGE_CHECK_VALUE_BYTES;     // Catch: Exception -> L87
        if (r8 <= r0) goto L9;
        long r2 = r0;
    L11:
        if (r10 > r0) goto L14;
        r0 = r10;
    L14:
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L87
        if (r8 <= 0) goto L18;
        r4.put("data", r2);     // Catch: Exception -> L87
    L18:
        if (r10 <= 0) goto L21;
        r4.put("cache", r0);     // Catch: Exception -> L87
    L21:
        if (r12 <= 0) goto L24;
        r4.put(PerfConsts.PERF_DISK_TOTAL, byte2G(r12));     // Catch: Exception -> L87
    L24:
        if (r14 <= 0) goto L26;
        r4.put(PerfConsts.PERF_DISK_ROM_FREE, byte2G(r14));     // Catch: Exception -> L87
    L26:
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L87
        if (this.isExceptionDiskSwitch == true) goto L29;
    L85:
        sendPerfLog(new PerfData("disk", SlardarSettingsConsts.PERF_DISK_SAMPLE_METRIC, false, r4, null, r15));     // Catch: Exception -> L87
        return;
    L29:
        if (r2 <= this.mDiskAppUsedThresholdBytes) goto L85;
        if (this.mFileListTopK == null) goto L40;
        JSONArray r9 = new JSONArray();     // Catch: Exception -> L87
        Iterator r11 = this.mFileListTopK.sortedList().iterator();     // Catch: Exception -> L87
    L34:
        if (r11.hasNext() == false) goto L38;
        JSONObject r13 = ((FileNode) r11.next()).toJSON();     // Catch: Exception -> L87
        if (r13 == null) goto L34;
        r9.put(r13);     // Catch: Exception -> L87
        goto L34
    L38:
        r15.put(PerfConsts.PERF_DISK_TOP_USAGE, r9);     // Catch: Exception -> L87
    L40:
        if (this.mDirListTopK == null) goto L49;
        JSONArray r16 = new JSONArray();     // Catch: Exception -> L87
        Iterator r17 = this.mDirListTopK.sortedList().iterator();     // Catch: Exception -> L87
    L43:
        if (r17.hasNext() == false) goto L47;
        JSONObject r18 = ((FileNode) r17.next()).toJSON();     // Catch: Exception -> L87
        if (r18 == null) goto L43;
        r16.put(r18);     // Catch: Exception -> L87
        goto L43
    L47:
        r15.put(PerfConsts.PERF_DISK_EXCEPTION_FOLDERS, r16);     // Catch: Exception -> L87
    L49:
        if (this.mOutdatedListTopK == null) goto L57;
        JSONArray r19 = new JSONArray();     // Catch: Exception -> L87
        Iterator r20 = this.mOutdatedListTopK.sortedList().iterator();     // Catch: Exception -> L87
    L52:
        if (r20.hasNext() == false) goto L56;
        JSONObject r110 = ((OutdatedNode) r20.next()).toJSON();     // Catch: Exception -> L87
        if (r110 == null) goto L52;
        r19.put(r110);     // Catch: Exception -> L87
        goto L52
    L56:
        r15.put(PerfConsts.PERF_DISK_OUTDATED_FILES, r19);     // Catch: Exception -> L87
    L57:
        List<DiskInfoNode> r21 = this.mDiskInfoNodes;     // Catch: Exception -> L87
        if (r21 == null) goto L82;
        if (r21.isEmpty() == true) goto L82;
        BigDecimal r22 = new BigDecimal(r2);     // Catch: Exception -> L87
        JSONArray r23 = new JSONArray();     // Catch: Exception -> L87
        Iterator<DiskInfoNode> r111 = this.mDiskInfoNodes.iterator();     // Catch: Exception -> L87
    L63:
        if (r111.hasNext() == false) goto L80;
        DiskInfoNode r112 = r111.next();     // Catch: Exception -> L87
        if (isIgnoredNode(r112) == false) goto L67;
        r112.sizeRate = 0.0f;     // Catch: Exception -> L87
    L68:
        List<DiskInfoNode> r113 = r112.nextDisk;     // Catch: Exception -> L87
        if (r113 == null) goto L79;
        if (r113.size() <= 0) goto L79;
        Iterator<DiskInfoNode> r114 = r113.iterator();     // Catch: Exception -> L87
    L74:
        if (r114.hasNext() == false) goto L79;
        DiskInfoNode r115 = r114.next();     // Catch: Exception -> L87
        if (isIgnoredNode(r115) == true) goto L77;
        r115.sizeRate = getRate(r115.size, r22);     // Catch: Exception -> L87
        goto L74
    L77:
        r115.sizeRate = 0.0f;     // Catch: Exception -> L87
    L79:
        r23.put(r112.toJson());     // Catch: Exception -> L87
        goto L63
    L67:
        r112.sizeRate = getRate(r112.size, r22);     // Catch: Exception -> L87
        goto L68
    L80:
        r15.put(PerfConsts.PERF_DISK_DISK_INFO, r23);     // Catch: Exception -> L87
    L82:
        if (this.mStorageCheckListener == null) goto L84;
        final List<String> r116 = convertFileNodeList(this.mFileListTopK);     // Catch: Exception -> L87
        final List<String> r117 = convertFileNodeList(this.mDirListTopK);     // Catch: Exception -> L87
        final List<String> r118 = convertFileNodeList(this.mOutdatedListTopK);     // Catch: Exception -> L87
        final long r119 = r2;
        AsyncEventManager.getInstance().submitTask(new AnonymousClass1(this, r119, r116, r117, r118));     // Catch: Exception -> L87
    L84:
        this.mFileListTopK = null;     // Catch: Exception -> L87
        this.mDirListTopK = null;     // Catch: Exception -> L87
        this.mOutdatedListTopK = null;     // Catch: Exception -> L87
        this.mDiskInfoNodes = null;     // Catch: Exception -> L87
        goto L85
    L9:
        r2 = r8;
    }

    public void checkExceptionDisk() {
        String[] r8 = {mInsideDataPath, mOutsideDataPath};
        this.mDiskInfoNodes = new ArrayList();
        int r10 = 0;
    L4:
        if (r10 >= 2) goto L58;
        String r0 = r8[r10];
        calculateDiskInfo(new File(r0), 1, true, this.mDiskInfoNodes);
        File r1 = new File(r0);
        AnonymousClass1 r12 = null;
        Node r2 = new Node(this, r12);
        Node.access$402(r2, r0);
        r2.parent = new Node(this, r12);
        File[] r3 = r1.listFiles();
        if (r3 == null) goto L57;
        if (r3.length == 0) goto L57;
        Node.access$502(r2, r3.length);
        LinkedList r13 = new LinkedList();
        r13.offer(r2);
    L12:
        if (r13.isEmpty() == true) goto L57;
        int r14 = r13.size();
        int r15 = 0;
    L14:
        if (r15 >= r14) goto L12;
        Node r4 = (Node) r13.poll();
        if (r4 != null) goto L19;
        int r16 = r10;
    L18:
        LinkedList r6 = r13;
    L55:
        r15 = r15 + 1;
        r13 = r6;
        r10 = r16;
        r12 = null;
        goto L14
    L19:
        String r5 = Node.access$400(r4);
        File r7 = new File(r5);
        if (r7.exists() == true) goto L22;
    L23:
        r16 = r10;
        r6 = r13;
        Node.access$510(r4.parent);
        goto L55
    L22:
        if (this.mIgnoredPaths.contains(r5) == true) goto L23;
        if (r7.isFile() == false) goto L36;
        r16 = r10;
        long r9 = r7.length();
        if (r9 <= 0) goto L29;
        appendExceptionFileQueue(r5, r9);
    L29:
        Node r11 = r4.parent;
        if (r11 == null) goto L18;
        r11.appendChildInfo(r9);
        if (Node.access$600(r4.parent) == true) goto L18;
        long r17 = isOutOfDate(r7.lastModified());
        if (r17 <= 0) goto L18;
        appendOutdatedFileQueue(r5, r9, 0, r17);
        goto L18
    L36:
        r16 = r10;
        File[] r18 = r7.listFiles();
        if (r18 != null) goto L39;
    L40:
        r6 = r13;
        r4.parent.appendChildInfo(0);
        goto L55
    L39:
        if (r18.length == 0) goto L40;
        Node.access$502(r4, r18.length);
        int r19 = r18.length;
        int r20 = 0;
    L42:
        if (r20 >= r19) goto L18;
        File r21 = r18[r20];
        Node r22 = new Node(this, r12);
        r22.parent = r4;
        Node.access$402(r22, r21.getAbsolutePath());
        if (r21.isDirectory() == true) goto L46;
    L51:
        LinkedList r23 = r13;
    L52:
        r23.offer(r22);
        r20 = r20 + 1;
        r13 = r23;
        r12 = null;
        goto L42
    L46:
        if (Node.access$600(r4) == true) goto L51;
        LinkedList r110 = r13;
        long r111 = isOutOfDate(r21.lastModified());
        if (r111 <= 0) goto L50;
        Node.access$602(r22, true);
        Node.access$702(r22, r111);
    L50:
        r23 = r110;
    L57:
        r10 = r10 + 1;
        goto L4
    L58:
        List<String> r24 = this.mDiskCustomedPaths;
        if (r24 != null) goto L61;
    L66:
        Iterator<DiskInfoNode> r25 = this.mDiskInfoNodes.iterator();
    L68:
        if (r25.hasNext() == false) goto L79;
        DiskInfoNode r26 = r25.next();
        if ("normal".equals(r26.reportType) == false) goto L68;
        List<DiskInfoNode> r27 = r26.nextDisk;
        if (r27 == null) goto L68;
        if (r27.isEmpty() == true) goto L68;
        Iterator<DiskInfoNode> r28 = r27.iterator();
    L77:
        if (r28.hasNext() == false) goto L68;
        r26.size += r28.next().size;
        goto L77
    L79:
        return;
    L61:
        if (r24.size() <= 0) goto L66;
        Iterator<String> r29 = this.mDiskCustomedPaths.iterator();
    L64:
        if (r29.hasNext() == false) goto L66;
        calculateDiskInfo(new File(r29.next()), 1, false, this.mDiskInfoNodes);
        goto L64
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void doConfig(JSONObject r10) {
        boolean r0 = r10.optBoolean("dump_switch", true);
        this.isExceptionDiskSwitch = r0;
        if (r0 == false) goto L23;
        long r2 = SpManager.getInstance().getLong(PerfConsts.DISK_SP_KEY_CHECK_TIME);
        long r4 = System.currentTimeMillis() - r2;
        if (r4 >= 86400000) goto L10;
        if (r4 <= 0) goto L10;
        this.mHasUploadUsedStorage = true;
    L10:
        if (r10.optInt("dump_threshold") <= 0) goto L13;
        this.mDiskAppUsedThresholdBytes = ((long) r10.optInt("dump_threshold")) * 1048576;
    L13:
        if (r10.optInt("abnormal_folder_size") <= 0) goto L16;
        this.mFolderSizeThresholdBytes = ((long) r10.optInt("abnormal_folder_size")) * 1048576;
    L16:
        if (r10.optInt("dump_top_count") <= 0) goto L19;
        this.mReportFileMaxCount = r10.optInt("dump_top_count");
    L19:
        if (r10.optInt("outdated_days") <= 0) goto L21;
        this.mOutdatedIntervalMs = ((long) r10.optInt("outdated_days")) * 86400000;
    L21:
        this.mDiskCustomedRelativePaths = ParseUtils.parseMapList(r10, "disk_customed_paths");
        this.mIgnoredRelativePaths = ParseUtils.parseList(r10, "ignored_relative_paths");
    L23:
        if (r10.optBoolean("enable_collect_apm6", false) == false) goto L26;
        this.mHasUploadUsedStorage = true;
        return;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public boolean isTimerMonitor() {
        return true;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onStart() {
        boolean r0 = isBackground();
        if (this.mHasUploadUsedStorage == true) goto L16;
        if (r0 == false) goto L17;
        initPaths();
        if (this.mInitException == false) goto L11;
        this.mHasUploadUsedStorage = true;
        return;
    L11:
        if (this.isExceptionDiskSwitch == false) goto L13;
        handleUsedStorageNew();
    L14:
        this.mHasUploadUsedStorage = true;
        stop();
        destroy();
        return;
    L13:
        handleUsedStorageOld();
        goto L14
    L17:
        return;
    }

    public void setStorageCheckListener(IStorageCheckListener r1) {
        this.mStorageCheckListener = r1;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public long workInternalMs() {
        return 120000;
    }
}
