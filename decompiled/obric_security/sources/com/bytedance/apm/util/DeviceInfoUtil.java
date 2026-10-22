package com.bytedance.apm.util;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.internal.SpManager;
import com.bytedance.apm.thread.AsyncEventManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DeviceInfoUtil {
    private static final long APP_BYTES_PER_MEGABYTE = 1048576;
    private static final long BYTES_PER_DISK_MEGABYTE = 1073741824;
    private static final long BYTES_PER_MEGABYTE = 536870912;
    private static final long CHECK_FS_INFO_INTERVAL = 604800000;
    private static final String DL_MALLOC = "dlmalloc";
    private static final int INVALID_DATA = -1;
    private static final String JE_MALLOC = "jemalloc";
    private static final String UNKNOWN = "unknown";
    private int mCpuCoreNum;
    private String mCpuModel;
    private double mDataPartitionAvailableRatio;
    private long mDataPartitionAvailableSize;
    private long mDataPartitionTotalSize;
    private boolean mEnabled;
    private boolean mHasJavaHeapLeak;
    private boolean mIsApp64Bit;
    private boolean mIsDevice64Bit;
    private boolean mIsExternalStorageMounted;
    private boolean mIsExternalStorageRemovable;
    private boolean mIsJBAndAbove;
    private long mJavaHeapSizeMaxMega;
    private long mJavaHeapSizeUsedMega;
    private String mMallocImpl;
    private long mNativeHeapSizeMega;
    private int mPhysicMemSizeMega;
    private double mSdcardAvailableRatio;
    private long mSdcardAvailableSize;
    private long mSdcardTotalSize;
    private double mSystemAvailableRatio;
    private long mSystemAvailableSize;
    private long mSystemTotalSize;

    private static class InstanceHolder {
        static final DeviceInfoUtil holder = null;

        private InstanceHolder() {
        }

        static {
            holder = new DeviceInfoUtil(null);
        }
    }

    /* synthetic */ DeviceInfoUtil(AnonymousClass1 r1) {
        this();
    }

    public static DeviceInfoUtil getInstance() {
        return InstanceHolder.holder;
    }

    private DeviceInfoUtil() {
        checkThread();
        this.mEnabled = ApmContext.isDeviceInfoOnPerfDataEnabled();
        initDeviceInfo();
    }

    private void checkThread() {
        if (ThreadUtils.isMainThread() == false) goto L6;
        final Throwable r0 = new Throwable("Don't use DeviceInfoUtil on main thread.");
        AsyncEventManager.getInstance().post(new AnonymousClass1(this, r0));
        return;
    }

    private void initDeviceInfo() {
        if (this.mEnabled == true) goto L8;
        return;
    L8:
        initCpuInfo();     // Catch: Throwable -> L7
        initMemInfo();     // Catch: Throwable -> L7
        initStorageInfo();     // Catch: Throwable -> L7
        return;
    }

    private void initCpuInfo() {
        String r0 = ApmContext.getContext().getApplicationInfo().nativeLibraryDir;
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L7:
        StringBuilder r1 = new StringBuilder();
        if (Build.SUPPORTED_ABIS.length <= 0) goto L16;
        int r2 = 0;
    L11:
        if (r2 >= Build.SUPPORTED_ABIS.length) goto L17;
        r1.append(Build.SUPPORTED_ABIS[r2]);
        if (r2 == (Build.SUPPORTED_ABIS.length - 1)) goto L15;
        r1.append(", ");
    L15:
        r2 = r2 + 1;
    L17:
        String r3 = r1.toString();
        if (r3 != null) goto L20;
    L22:
        initCpuModel();
        return;
    L20:
        if (r3.contains("64") == false) goto L22;
        this.mIsDevice64Bit = true;
        goto L22
    L16:
        r1 = new StringBuilder(Build.CPU_ABI);
        goto L17
    L5:
        if (r0.endsWith("arm64") == false) goto L7;
        this.mIsApp64Bit = true;
        goto L7
    }

    private void initCpuModel() {
        SpManager r0 = SpManager.getInstance();
        String r2 = r0.getString(CommonKey.KEY_SP_CPU_MODEL);
        int r4 = r0.getInt(CommonKey.KEY_SP_CPU_CORE_NUM);
        if (TextUtils.isEmpty(r2) == true) goto L6;
        this.mCpuModel = r2;
        this.mCpuCoreNum = r4;
        return;
    L6:
        updateCpuModel();
        if (TextUtils.isEmpty(this.mCpuModel) == false) goto L9;
        this.mCpuModel = "unknown";
    L9:
        r0.saveAsync(CommonKey.KEY_SP_CPU_MODEL, this.mCpuModel);
        r0.saveAsync(CommonKey.KEY_SP_CPU_CORE_NUM, this.mCpuCoreNum);
    }

    private void updateCpuModel() {
        BufferedReader r0 = null;
        String r1 = null;
        BufferedReader r2 = null;
        BufferedReader r3 = new BufferedReader(new FileReader("/proc/cpuinfo"));     // Catch: Throwable -> L21 Exception -> L25
        int r4 = 0;
    L46:
        String r5 = r3.readLine();     // Catch: Throwable -> L18 Exception -> L20
        if (r5 == null) goto L40;
        String[] r6 = r5.split(":");     // Catch: Throwable -> L18 Exception -> L20
        if (r6.length != 2) goto L46;
        if (r6[0].startsWith("Hardware") == true) goto L12;
        if (r6[0].startsWith("processor") == false) goto L46;
        r4 = r4 + 1;
        goto L46
    L12:
        r1 = r6[1].trim();     // Catch: Throwable -> L18 Exception -> L20
        goto L46
    L40:
        r3.close();     // Catch: Exception -> L35
    L29:
        this.mCpuModel = r1;
        this.mCpuCoreNum = r4;
        if (TextUtils.isEmpty(r1) == true) goto L32;
        return;
    L32:
        if (RomUtils.isHwDevice() == false) goto L59;
        this.mCpuModel = Build.HARDWARE;
        return;
    L59:
        return;
    L20:
        String r7 = r1;
        r2 = r3;
    L26:
        if (r2 != null) goto L42;
    L28:
        r1 = r7;
        goto L29
    L42:
        r2.close();     // Catch: Exception -> L37
    L18:
        th = th;
        r0 = r3;
    L22:
        if (r0 != null) goto L38;
    L24:
        throw th;
    L38:
        r0.close();     // Catch: Exception -> L36
        goto L24
    L25:
        r4 = 0;
        r7 = null;
    L21:
        th = th;
        goto L22
    }

    private void initMemInfo() {
        ActivityManager r0 = (ActivityManager) ApmContext.getContext().getSystemService("activity");
        ActivityManager.MemoryInfo r1 = new ActivityManager.MemoryInfo();
        r0.getMemoryInfo(r1);
        this.mPhysicMemSizeMega = (int) (r1.totalMem / 536870912);
        this.mMallocImpl = JE_MALLOC;
    }

    private String getMallocImpl() {
        File r2 = new File("/system/lib/libc.so");
        if (r2.exists() == true) goto L11;
        return "unknown";
    L11:
        if (ReadElf.hasFuncSymbolInFile(r2, "je_malloc") == true) goto L13;
        return DL_MALLOC;
    L13:
        return JE_MALLOC;
    L10:
        return "unknown";
    }

    private void updateMemInfo() {
        this.mNativeHeapSizeMega = Debug.getNativeHeapAllocatedSize() / 1048576;
        Runtime r0 = Runtime.getRuntime();
        long r4 = r0.maxMemory();
        long r6 = r0.freeMemory();
        long r1 = r0.totalMemory();
        this.mJavaHeapSizeMaxMega = r4 / 1048576;
        long r2 = r1 - r6;
        this.mJavaHeapSizeUsedMega = r2 / 1048576;
        if (r2 <= (r4 * 0.95f)) goto L5;
        boolean r3 = true;
    L6:
        this.mHasJavaHeapLeak = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }

    private void initStorageInfo() {
        this.mIsJBAndAbove = true;
        StatFs r1 = new StatFs(Environment.getRootDirectory().getAbsolutePath());
        if (this.mIsJBAndAbove == false) goto L5;
        this.mSystemAvailableSize = r1.getAvailableBytes();
        this.mSystemTotalSize = r1.getBlockSizeLong() * r1.getBlockCountLong();
    L6:
        this.mSystemAvailableRatio = getAvailableRatio(this.mSystemAvailableSize, this.mSystemTotalSize);
        StatFs r2 = new StatFs(ApmContext.getContext().getFilesDir().getAbsolutePath());     // Catch: Throwable -> L25
        if (this.mIsJBAndAbove == false) goto L10;
        this.mDataPartitionAvailableSize = r2.getAvailableBytes();     // Catch: Throwable -> L25
        this.mDataPartitionTotalSize = r2.getBlockSizeLong() * r2.getBlockCountLong();     // Catch: Throwable -> L25
    L11:
        this.mDataPartitionAvailableRatio = getAvailableRatio(this.mDataPartitionAvailableSize, this.mDataPartitionTotalSize);     // Catch: Throwable -> L25
        goto L30
    L10:
        this.mDataPartitionAvailableSize = ((long) r2.getBlockSize()) * ((long) r2.getAvailableBlocks());     // Catch: Throwable -> L25
        this.mDataPartitionTotalSize = ((long) r2.getBlockSize()) * ((long) r2.getBlockCount());     // Catch: Throwable -> L25
    L30:
        String r0 = Environment.getExternalStorageState();     // Catch: Exception -> L14
    L15:
        boolean r3 = TextUtils.equals(r0, "mounted");
        this.mIsExternalStorageMounted = r3;
        if (r3 == false) goto L22;
        StatFs r4 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());     // Catch: Throwable -> L26
        if (this.mIsJBAndAbove == false) goto L20;
        this.mSdcardAvailableSize = r4.getAvailableBytes();     // Catch: Throwable -> L26
        this.mSdcardTotalSize = r4.getBlockSizeLong() * r4.getBlockCountLong();     // Catch: Throwable -> L26
    L21:
        this.mSdcardAvailableRatio = getAvailableRatio(this.mSdcardAvailableSize, this.mSdcardTotalSize);     // Catch: Throwable -> L26
        goto L23
    L20:
        this.mSdcardAvailableSize = ((long) r4.getBlockSize()) * ((long) r4.getAvailableBlocks());     // Catch: Throwable -> L26
        this.mSdcardTotalSize = ((long) r4.getBlockSize()) * ((long) r4.getBlockCount());     // Catch: Throwable -> L26
        goto L21
    L22:
        this.mSdcardTotalSize = 0;     // Catch: Throwable -> L26
    L23:
        this.mIsExternalStorageRemovable = Environment.isExternalStorageRemovable();
        return;
    L14:
        r0 = null;
        goto L15
    L5:
        this.mSystemAvailableSize = ((long) r1.getBlockSize()) * ((long) r1.getAvailableBlocks());
        this.mSystemTotalSize = ((long) r1.getBlockSize()) * ((long) r1.getBlockCount());
        goto L6
    }

    private double getAvailableRatio(long r3, long r5) {
        if (r5 != 0) goto L7;
        return 0.0d;
    L7:
        return Math.round((r3 / r5) * 100.0d) / 100.0d;
    }

    public void addCpuInfo(JSONObject r3) throws JSONException {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.mEnabled == false) goto L12;
        r3.put(PerfConsts.PERF_KEY_IS_APP_64_BIT, this.mIsApp64Bit);
        r3.put(PerfConsts.PERF_KEY_IS_DEVICE_64_BIT, this.mIsDevice64Bit);
        r3.put(PerfConsts.PERF_KEY_CPU_MODEL, this.mCpuModel);
        int r2 = this.mCpuCoreNum;
        if (r2 <= 0) goto L11;
        r3.put(PerfConsts.PERF_KEY_CPU_CORE_NUM, r2);
        return;
    L11:
        return;
    }

    public void addConstantMemInfo(JSONObject r3) throws JSONException {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.mEnabled == false) goto L9;
        r3.put("apm_physical_mem", this.mPhysicMemSizeMega);
        r3.put("apm_malloc_impl", this.mMallocImpl);
        return;
    }

    public void addRealTimeMemInfo(JSONObject r4) throws JSONException {
        if (r4 != null) goto L4;
        return;
    L4:
        if (this.mEnabled == false) goto L9;
        updateMemInfo();
        r4.put("apm_native_heap_size", this.mNativeHeapSizeMega);
        r4.put("apm_java_heap_leak", this.mHasJavaHeapLeak);
        r4.put("apm_java_heap_used", this.mJavaHeapSizeUsedMega);
        r4.put("apm_java_heap_max", this.mJavaHeapSizeMaxMega);
        return;
    }

    public void addStorageInfo(JSONObject r7) throws JSONException {
        if (r7 != null) goto L4;
        return;
    L4:
        if (this.mEnabled == true) goto L7;
        return;
    L7:
        if (this.mSystemTotalSize == 0) goto L10;
        r7.put(PerfConsts.PERF_KEY_SYSTEM_AVAILABLE_SIZE, this.mSystemAvailableSize / 1048576);
        r7.put(PerfConsts.PERF_KEY_SYSTEM_AVAILABLE_RATIO, this.mSystemAvailableRatio);
    L10:
        if (this.mDataPartitionTotalSize == 0) goto L13;
        r7.put(PerfConsts.PERF_KEY_DATA_AVAILABLE_SIZE, getSize(this.mDataPartitionAvailableSize));
        r7.put(PerfConsts.PERF_KEY_DATA_AVAILABLE_RATIO, this.mDataPartitionAvailableRatio);
    L13:
        if (this.mSdcardTotalSize == 0) goto L16;
        r7.put(PerfConsts.PERF_KEY_SDCARD_AVAILABLE_SIZE, getSize(this.mSdcardAvailableSize));
        r7.put(PerfConsts.PERF_KEY_SDCARD_AVAILABLE_RATIO, this.mSdcardAvailableRatio);
    L16:
        if (this.mIsExternalStorageMounted == false) goto L20;
        r7.put(PerfConsts.PERF_KEY_EXTERNAL_STORAGE_REMOVABLE, this.mIsExternalStorageRemovable);
        return;
    }

    public void addRealTimeDeviceInfo(JSONObject r2) {
        addRealTimeDeviceInfo(r2, false);
    }

    public void addConstantDeviceInfo(JSONObject r2) {
        addConstantDeviceInfo(r2, false);
    }

    public void addRealTimeDeviceInfo(JSONObject r1, boolean r2) {
        if (this.mEnabled == true) goto L9;
        if (r2 == true) goto L9;
        return;
    L9:
        getInstance().addRealTimeMemInfo(r1);     // Catch: JSONException -> L8
        return;
    }

    public void addConstantDeviceInfo(JSONObject r1, boolean r2) {
        if (this.mEnabled == true) goto L9;
        if (r2 == true) goto L9;
        return;
    L9:
        getInstance().addCpuInfo(r1);     // Catch: JSONException -> L8
        getInstance().addConstantMemInfo(r1);     // Catch: JSONException -> L8
        getInstance().addStorageInfo(r1);     // Catch: JSONException -> L8
        return;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    private long getSize(long r3) {
        return r3 / 1073741824;
    }
}
