package com.android.settings.applications;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.util.ArrayMap;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.android.internal.app.ProcessMap;
import com.android.internal.app.procstats.DumpUtils;
import com.android.internal.app.procstats.IProcessStats;
import com.android.internal.app.procstats.ProcessState;
import com.android.internal.app.procstats.ProcessStats;
import com.android.internal.app.procstats.ServiceState;
import com.android.internal.util.MemInfoReader;
import com.android.settings.R;
import com.android.settings.utils.NullSafe;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.olog.OLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ProcStatsData {
    private static final boolean DEBUG = false;
    private static final String TAG = "ProcStatsManager";
    static final Comparator<ProcStatsEntry> sEntryCompare = null;
    private static ProcessStats sStatsXfer;
    private Context mContext;
    private long mDuration;
    private MemInfo mMemInfo;
    private int[] mMemStates;
    private PackageManager mPm;
    private IProcessStats mProcessStats;
    private int[] mStates;
    private ProcessStats mStats;
    private boolean mUseUss;
    private long memTotalTime;
    private ArrayList<ProcStatsPackageEntry> pkgEntries;

    public static class MemInfo {
        long baseCacheRam;
        double freeWeight;
        double[] mMemStateWeights;
        long memTotalTime;
        public double realFreeRam;
        public double realTotalRam;
        public double realUsedRam;
        double totalRam;
        double totalScale;
        double usedWeight;
        double weightToRam;

        /* synthetic */ MemInfo(Context r1, ProcessStats.TotalMemoryUseCollection r2, long r3, AnonymousClass1 r5) {
            this(r1, r2, r3);
        }

        public double getWeightToRam() {
            return this.weightToRam;
        }

        private MemInfo(Context r11, ProcessStats.TotalMemoryUseCollection r12, long r13) {
            this.mMemStateWeights = new double[16];
            this.memTotalTime = r13;
            calculateWeightInfo(r11, r12, r13);
            double r14 = r13;
            double r0 = (this.usedWeight * 1024.0d) / r14;
            double r4 = (this.freeWeight * 1024.0d) / r14;
            double r6 = r0 + r4;
            this.totalRam = r6;
            double r8 = this.realTotalRam / r6;
            this.totalScale = r8;
            this.weightToRam = (r8 / r14) * 1024.0d;
            this.realUsedRam = r0 * r8;
            this.realFreeRam = r8 * r4;
            ActivityManager.MemoryInfo r15 = new ActivityManager.MemoryInfo();
            ((ActivityManager) NullSafe.nonNull(r11.getSystemService("activity"))).getMemoryInfo(r15);
            if (r15.hiddenAppThreshold < this.realFreeRam) goto L5;
            this.realUsedRam = r4;
            this.realFreeRam = 0.0d;
            this.baseCacheRam = (long) 0.0d;
            return;
        L5:
            this.realUsedRam += r15.hiddenAppThreshold;
            this.realFreeRam -= r15.hiddenAppThreshold;
            this.baseCacheRam = r15.hiddenAppThreshold;
        }

        private void calculateWeightInfo(Context r3, ProcessStats.TotalMemoryUseCollection r4, long r5) {
            MemInfoReader r6 = new MemInfoReader();
            r6.readMemInfo();
            this.realTotalRam = r6.getTotalSize();
            this.freeWeight = r4.sysMemFreeWeight + r4.sysMemCachedWeight;
            this.usedWeight = r4.sysMemKernelWeight + r4.sysMemNativeWeight;
            if (r4.hasSwappedOutPss == true) goto L5;
            this.usedWeight += r4.sysMemZRamWeight;
        L5:
            int r7 = 0;
        L7:
            if (r7 >= 16) goto L16;
            if (r7 != 9) goto L11;
            this.mMemStateWeights[r7] = 0.0d;
        L15:
            r7 = r7 + 1;
            goto L7
        L11:
            this.mMemStateWeights[r7] = r4.processStateWeight[r7];
            if (r7 < 12) goto L14;
            this.freeWeight += r4.processStateWeight[r7];
            goto L15
        L14:
            this.usedWeight += r4.processStateWeight[r7];
            goto L15
        }
    }

    public ProcStatsData(Context r1, boolean r2) {
        this.mContext = r1;
        this.mPm = r1.getPackageManager();
        this.mProcessStats = IProcessStats.Stub.asInterface(ServiceManager.getService("procstats"));
        this.mMemStates = ProcessStats.ALL_MEM_ADJ;
        this.mStates = ProcessStats.BACKGROUND_PROC_STATES;
        if (r2 == false) goto L6;
        this.mStats = sStatsXfer;
        return;
    }

    public void setTotalTime(int r3) {
        this.memTotalTime = r3;
    }

    public void xferStats() {
        sStatsXfer = this.mStats;
    }

    public void setMemStates(int[] r1) {
        this.mMemStates = r1;
        refreshStats(false);
    }

    public void setStats(int[] r1) {
        this.mStates = r1;
        refreshStats(false);
    }

    public int getMemState() {
        int r1 = this.mStats.mMemFactor;
        if (r1 != (-1)) goto L7;
        return 0;
    L7:
        if (r1 >= 4) goto L9;
        return r1;
    L9:
        return r1 - 4;
    }

    public MemInfo getMemInfo() {
        return this.mMemInfo;
    }

    public long getElapsedTime() {
        return this.mStats.mTimePeriodEndRealtime - this.mStats.mTimePeriodStartRealtime;
    }

    public void setDuration(long r3) {
        if (r3 == this.mDuration) goto L6;
        this.mDuration = r3;
        refreshStats(true);
        return;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public List<ProcStatsPackageEntry> getEntries() {
        return this.pkgEntries;
    }

    public void refreshStats(boolean r11) {
        if (this.mStats == null) goto L5;
        if (r11 == true) goto L5;
    L6:
        this.pkgEntries = new ArrayList();
        long r8 = SystemClock.uptimeMillis();
        this.memTotalTime = DumpUtils.dumpSingleTime(null, null, this.mStats.mMemFactorDurations, this.mStats.mMemFactor, this.mStats.mStartTime, r8);
        ProcessStats.TotalMemoryUseCollection r12 = new ProcessStats.TotalMemoryUseCollection(ProcessStats.ALL_SCREEN_ADJ, this.mMemStates);
        this.mStats.computeTotalMemoryUse(r12, r8);
        this.mMemInfo = new MemInfo(this.mContext, r12, this.memTotalTime, null);
        ProcessStats.ProcessDataCollection r3 = new ProcessStats.ProcessDataCollection(ProcessStats.ALL_SCREEN_ADJ, this.mMemStates, this.mStates);
        ProcessStats.ProcessDataCollection r4 = new ProcessStats.ProcessDataCollection(ProcessStats.ALL_SCREEN_ADJ, this.mMemStates, ProcessStats.NON_CACHED_PROC_STATES);
        createPkgMap(getProcs(r3, r4), r3, r4);
        if (r12.sysMemZRamWeight > 0.0d) goto L9;
    L11:
        ProcStatsPackageEntry r13 = createOsEntry(r3, r4, r12, this.mMemInfo.baseCacheRam);
        this.pkgEntries.add(r13);
        return;
    L9:
        if (r12.hasSwappedOutPss == true) goto L11;
        distributeZRam(r12.sysMemZRamWeight);
    L5:
        load();
        goto L6
    }

    private void createPkgMap(ArrayList<ProcStatsEntry> r11, ProcessStats.ProcessDataCollection r12, ProcessStats.ProcessDataCollection r13) {
        ArrayMap r0 = new ArrayMap();
        int r1 = r11.size() - 1;
    L3:
        if (r1 < 0) goto L8;
        ProcStatsEntry r2 = r11.get(r1);
        r2.evaluateTargetPackage(this.mPm, this.mStats, r12, r13, sEntryCompare, this.mUseUss);
        ProcStatsPackageEntry r3 = (ProcStatsPackageEntry) r0.get(r2.mBestTargetPackage);
        if (r3 != null) goto L7;
        r3 = new ProcStatsPackageEntry(r2.mBestTargetPackage, this.memTotalTime);
        r0.put(r2.mBestTargetPackage, r3);
        this.pkgEntries.add(r3);
    L7:
        r3.addEntry(r2);
        r1 = r1 - 1;
        goto L3
    }

    private void distributeZRam(double r23) {
        long r1 = (long) (r23 / this.memTotalTime);
        int r3 = this.pkgEntries.size() - 1;
        long r4 = 0;
        long r6 = 0;
    L3:
        if (r3 < 0) goto L8;
        ProcStatsPackageEntry r8 = this.pkgEntries.get(r3);
        int r9 = r8.mEntries.size() - 1;
    L5:
        if (r9 < 0) goto L7;
        r6 = r6 + r8.mEntries.get(r9).mRunDuration;
        r9 = r9 - 1;
        goto L5
    L7:
        r3 = r3 - 1;
        goto L3
    L8:
        int r5 = this.pkgEntries.size() - 1;
    L9:
        if (r5 < 0) goto L22;
        if (r6 <= r4) goto L32;
        ProcStatsPackageEntry r10 = this.pkgEntries.get(r5);
        int r11 = r10.mEntries.size() - 1;
        long r12 = r4;
        long r16 = r12;
    L13:
        if (r11 < 0) goto L18;
        ProcStatsEntry r13 = r10.mEntries.get(r11);
        r12 = r12 + r13.mRunDuration;
        if (r13.mRunDuration <= r16) goto L17;
        r16 = r13.mRunDuration;
    L17:
        r11 = r11 - 1;
        goto L13
    L18:
        long r18 = (r1 * r12) / r6;
        if (r18 <= r4) goto L21;
        r1 = r1 - r18;
        r6 = r6 - r12;
        ProcStatsEntry r14 = new ProcStatsEntry(r10.mPackage, 0, this.mContext.getString(R.string.process_stats_os_zram), r16, r18, this.memTotalTime);
        r14.evaluateTargetPackage(this.mPm, this.mStats, null, null, sEntryCompare, this.mUseUss);
        r10.addEntry(r14);
    L21:
        r5 = r5 - 1;
        r4 = 0;
        goto L9
    L32:
        return;
    }

    private ProcStatsPackageEntry createOsEntry(ProcessStats.ProcessDataCollection r18, ProcessStats.ProcessDataCollection r19, ProcessStats.TotalMemoryUseCollection r20, long r21) {
        ProcStatsPackageEntry r2 = new ProcStatsPackageEntry("os", this.memTotalTime);
        if (r20.sysMemNativeWeight <= 0.0d) goto L6;
        String r10 = this.mContext.getString(R.string.process_stats_os_native);
        long r11 = this.memTotalTime;
        double r13 = r20.sysMemNativeWeight;
        long r5 = this.memTotalTime;
        ProcStatsEntry r3 = new ProcStatsEntry("os", 0, r10, r11, (long) (r13 / r5), r5);
        r3.evaluateTargetPackage(this.mPm, this.mStats, r18, r19, sEntryCompare, this.mUseUss);
        r2.addEntry(r3);
    L6:
        if (r20.sysMemKernelWeight <= 0.0d) goto L9;
        String r7 = this.mContext.getString(R.string.process_stats_os_kernel);
        long r8 = this.memTotalTime;
        double r12 = r20.sysMemKernelWeight;
        long r14 = this.memTotalTime;
        ProcStatsEntry r4 = new ProcStatsEntry("os", 0, r7, r8, (long) (r12 / r14), r14);
        r4.evaluateTargetPackage(this.mPm, this.mStats, r18, r19, sEntryCompare, this.mUseUss);
        r2.addEntry(r4);
    L9:
        if (r21 <= 0) goto L11;
        String r6 = this.mContext.getString(R.string.process_stats_os_cache);
        long r15 = this.memTotalTime;
        ProcStatsEntry r1 = new ProcStatsEntry("os", 0, r6, r15, r21 / 1024, r15);
        r1.evaluateTargetPackage(this.mPm, this.mStats, r18, r19, sEntryCompare, this.mUseUss);
        r2.addEntry(r1);
    L11:
        return r2;
    }

    private ArrayList<ProcStatsEntry> getProcs(ProcessStats.ProcessDataCollection r24, ProcessStats.ProcessDataCollection r25) {
        ProcStatsData r0 = this;
        ArrayList<ProcStatsEntry> r1 = new ArrayList();
        ProcessMap r2 = new ProcessMap();
        int r3 = r0.mStats.mPackages.getMap().size();
        int r5 = 0;
    L4:
        if (r5 >= r3) goto L27;
        SparseArray r8 = (SparseArray) r0.mStats.mPackages.getMap().valueAt(r5);
        int r9 = 0;
    L7:
        if (r9 >= r8.size()) goto L26;
        LongSparseArray r10 = (LongSparseArray) r8.valueAt(r9);
        int r11 = 0;
    L10:
        if (r11 >= r10.size()) goto L25;
        ProcessStats.PackageState r12 = (ProcessStats.PackageState) r10.valueAt(r11);
        int r13 = 0;
    L13:
        if (r13 >= r12.mProcesses.size()) goto L24;
        ProcessState r14 = (ProcessState) r12.mProcesses.valueAt(r13);
        int r16 = r3;
        ProcessState r4 = (ProcessState) r0.mStats.mProcesses.get(r14.getName(), r14.getUid());
        if (r4 != null) goto L17;
        OLog.w(TAG, "No process found for pkg " + r12.mPackageName + LibrarianImpl.Constants.SEPARATOR + r12.mUid + " proc name " + r14.getName());
    L23:
        r13 = r13 + 1;
        r3 = r16;
        goto L13
    L17:
        ProcStatsEntry r6 = (ProcStatsEntry) r2.get(r4.getName(), r4.getUid());
        if (r6 != null) goto L22;
        ProcStatsEntry r7 = new ProcStatsEntry(r4, r12.mPackageName, r24, r25, r0.mUseUss);
        if (r7.mRunWeight <= 0.0d) goto L23;
        r2.put(r4.getName(), r4.getUid(), r7);
        r1.add(r7);
        goto L23
    L22:
        r6.addPackage(r12.mPackageName);
        goto L23
    L24:
        r11 = r11 + 1;
        goto L10
    L25:
        r9 = r9 + 1;
        goto L7
    L26:
        r5 = r5 + 1;
        goto L4
    L27:
        int r15 = r0.mStats.mPackages.getMap().size();
        int r17 = 0;
    L28:
        if (r17 >= r15) goto L47;
        SparseArray r18 = (SparseArray) r0.mStats.mPackages.getMap().valueAt(r17);
        int r19 = 0;
    L31:
        if (r19 >= r18.size()) goto L46;
        LongSparseArray r20 = (LongSparseArray) r18.valueAt(r19);
        int r110 = 0;
    L34:
        if (r110 >= r20.size()) goto L45;
        ProcessStats.PackageState r111 = (ProcessStats.PackageState) r20.valueAt(r110);
        int r112 = r111.mServices.size();
        int r113 = 0;
    L36:
        if (r113 >= r112) goto L44;
        ServiceState r114 = (ServiceState) r111.mServices.valueAt(r113);
        if (r114.getProcessName() == null) goto L43;
        ProcStatsEntry r21 = (ProcStatsEntry) r2.get(r114.getProcessName(), r18.keyAt(r19));
        if (r21 == null) goto L42;
        r21.addService(r114);
        goto L43
    L42:
        OLog.w(TAG, "No process " + r114.getProcessName() + LibrarianImpl.Constants.SEPARATOR + r18.keyAt(r19) + " for service " + r114.getName());
    L43:
        r113 = r113 + 1;
        goto L36
    L44:
        r110 = r110 + 1;
        goto L34
    L45:
        r19 = r19 + 1;
        goto L31
    L46:
        r17 = r17 + 1;
        r0 = this;
        goto L28
    L47:
        return r1;
    }

    private void load() {
        ParcelFileDescriptor r2 = this.mProcessStats.getStatsOverTime(this.mDuration);     // Catch: RemoteException -> L9
        this.mStats = new ProcessStats(false);     // Catch: RemoteException -> L9
        ParcelFileDescriptor.AutoCloseInputStream r3 = new ParcelFileDescriptor.AutoCloseInputStream(r2);     // Catch: RemoteException -> L9
        this.mStats.read(r3);     // Catch: RemoteException -> L9
        r3.close();     // Catch: IOException -> L12 RemoteException -> L9
    L6:
        if (this.mStats.mReadError == null) goto L17;
        OLog.w(TAG, "Failure reading process stats: " + this.mStats.mReadError);     // Catch: RemoteException -> L9
        return;
    L17:
        return;
    L9:
        e = move-exception;
        OLog.e(TAG, "RemoteException:", e);
    }

    static {
        sEntryCompare = new AnonymousClass1();
    }
}
