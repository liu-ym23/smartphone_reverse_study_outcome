package com.android.settings.applications;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.LongSparseArray;
import com.android.internal.app.procstats.ProcessState;
import com.android.internal.app.procstats.ProcessStats;
import com.android.internal.app.procstats.ServiceState;
import com.android.settingslib.applications.RecentAppOpsAccess;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public final class ProcStatsEntry implements Parcelable {
    public static final Parcelable.Creator<ProcStatsEntry> CREATOR = null;
    private static boolean DEBUG = false;
    private static final String TAG = "ProcStatsEntry";
    final long mAvgBgMem;
    final long mAvgRunMem;
    String mBestTargetPackage;
    final long mBgDuration;
    final double mBgWeight;
    public CharSequence mLabel;
    final long mMaxBgMem;
    final long mMaxRunMem;
    final String mName;
    final String mPackage;
    final ArrayList<String> mPackages;
    final long mRunDuration;
    final double mRunWeight;
    ArrayMap<String, ArrayList<Service>> mServices;
    final int mUid;

    public static final class Service implements Parcelable {
        public static final Parcelable.Creator<Service> CREATOR = null;
        final long mDuration;
        final String mName;
        final String mPackage;
        final String mProcess;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public Service(ServiceState r11) {
            this.mPackage = r11.getPackage();
            this.mName = r11.getName();
            this.mProcess = r11.getProcessName();
            this.mDuration = r11.dumpTime(null, null, 0, -1, 0, 0);
        }

        public Service(Parcel r3) {
            this.mPackage = r3.readString();
            this.mName = r3.readString();
            this.mProcess = r3.readString();
            this.mDuration = r3.readLong();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r3, int r4) {
            r3.writeString(this.mPackage);
            r3.writeString(this.mName);
            r3.writeString(this.mProcess);
            r3.writeLong(this.mDuration);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ProcStatsEntry(ProcessState r9, String r10, ProcessStats.ProcessDataCollection r11, ProcessStats.ProcessDataCollection r12, boolean r13) {
        ArrayList<String> r0 = new ArrayList();
        this.mPackages = r0;
        this.mServices = new ArrayMap(1);
        r9.computeProcessData(r11, 0);
        r9.computeProcessData(r12, 0);
        this.mPackage = r9.getPackage();
        this.mUid = r9.getUid();
        this.mName = r9.getName();
        r0.add(r10);
        long r1 = r11.totalTime;
        this.mBgDuration = r1;
        if (r13 == false) goto L5;
        long r2 = r11.avgUss;
    L6:
        this.mAvgBgMem = r2;
        if (r13 == false) goto L9;
        long r14 = r11.maxUss;
    L10:
        this.mMaxBgMem = r14;
        double r15 = r2 * r1;
        this.mBgWeight = r15;
        long r4 = r12.totalTime;
        this.mRunDuration = r4;
        if (r13 == false) goto L13;
        long r6 = r12.avgUss;
    L14:
        this.mAvgRunMem = r6;
        if (r13 == false) goto L17;
        long r16 = r12.maxUss;
    L18:
        this.mMaxRunMem = r16;
        this.mRunWeight = r6 * r4;
        if (DEBUG == false) goto L22;
        OLog.d(TAG, "New proc entry " + r9.getName() + ": dur=" + r1 + " avgpss=" + r2 + " weight=" + r15);
        return;
    L22:
        return;
    L17:
        r16 = r12.maxPss;
        goto L18
    L13:
        r6 = r12.avgPss;
        goto L14
    L9:
        r14 = r11.maxPss;
        goto L10
    L5:
        r2 = r11.avgPss;
        goto L6
    }

    public ProcStatsEntry(String r3, int r4, String r5, long r6, long r8, long r10) {
        this.mPackages = new ArrayList();
        this.mServices = new ArrayMap(1);
        this.mPackage = r3;
        this.mUid = r4;
        this.mName = r5;
        this.mRunDuration = r6;
        this.mBgDuration = r6;
        this.mMaxRunMem = r8;
        this.mAvgRunMem = r8;
        this.mMaxBgMem = r8;
        this.mAvgBgMem = r8;
        double r7 = r10 * r8;
        this.mRunWeight = r7;
        this.mBgWeight = r7;
        if (DEBUG == false) goto L6;
        OLog.d(TAG, "New proc entry " + r5 + ": dur=" + r6 + " avgpss=" + r8 + " weight=" + r7);
        return;
    }

    public ProcStatsEntry(Parcel r6) {
        ArrayList<String> r0 = new ArrayList();
        this.mPackages = r0;
        this.mServices = new ArrayMap(1);
        this.mPackage = r6.readString();
        this.mUid = r6.readInt();
        this.mName = r6.readString();
        r6.readStringList(r0);
        this.mBgDuration = r6.readLong();
        this.mAvgBgMem = r6.readLong();
        this.mMaxBgMem = r6.readLong();
        this.mBgWeight = r6.readDouble();
        this.mRunDuration = r6.readLong();
        this.mAvgRunMem = r6.readLong();
        this.mMaxRunMem = r6.readLong();
        this.mRunWeight = r6.readDouble();
        this.mBestTargetPackage = r6.readString();
        int r1 = r6.readInt();
        if (r1 <= 0) goto L7;
        this.mServices.ensureCapacity(r1);
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L9;
        String r3 = r6.readString();
        ArrayList r4 = new ArrayList();
        r6.readTypedList(r4, Service.CREATOR);
        this.mServices.append(r3, r4);
        r2 = r2 + 1;
        goto L5
    L9:
        return;
    }

    public void addPackage(String r1) {
        this.mPackages.add(r1);
    }

    public void evaluateTargetPackage(PackageManager r24, ProcessStats r25, ProcessStats.ProcessDataCollection r26, ProcessStats.ProcessDataCollection r27, Comparator<ProcStatsEntry> r28, boolean r29) {
        this.mBestTargetPackage = null;
        int r5 = 0;
        if (this.mPackages.size() == 1) goto L5;
        int r2 = 0;
    L11:
        if (r2 >= this.mPackages.size()) goto L17;
        if (RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME.equals(this.mPackages.get(r2)) == true) goto L14;
        r2 = r2 + 1;
        goto L11
    L14:
        this.mBestTargetPackage = this.mPackages.get(r2);
        return;
    L17:
        ArrayList r3 = new ArrayList();
        int r7 = 0;
    L19:
        if (r7 >= this.mPackages.size()) goto L39;
        LongSparseArray r9 = (LongSparseArray) r25.mPackages.get(this.mPackages.get(r7), this.mUid);
        if (r9 == null) goto L37;
        int r10 = 0;
    L25:
        if (r10 >= r9.size()) goto L37;
        ProcessStats.PackageState r11 = (ProcessStats.PackageState) r9.valueAt(r10);
        if (DEBUG == false) goto L30;
        OLog.d(TAG, "Eval pkg of " + this.mName + ", pkg " + r11 + ":");
    L30:
        if (r11 != null) goto L32;
        OLog.w(TAG, "No package state found for " + this.mPackages.get(r7) + LibrarianImpl.Constants.SEPARATOR + this.mUid + " in process " + this.mName);
    L36:
        r10 = r10 + 1;
        goto L25
    L32:
        ProcessState r15 = (ProcessState) r11.mProcesses.get(this.mName);
        if (r15 != null) goto L35;
        OLog.w(TAG, "No process " + this.mName + " found in package state " + this.mPackages.get(r7) + LibrarianImpl.Constants.SEPARATOR + this.mUid);
        goto L36
    L35:
        r3.add(new ProcStatsEntry(r15, r11.mPackageName, r26, r27, r29));
    L37:
        r7 = r7 + 1;
        goto L19
    L39:
        if (r3.size() <= 1) goto L133;
        Collections.sort(r3, r28);
        String r8 = " weight ";
        if (((ProcStatsEntry) r3.get(0)).mRunWeight > (((ProcStatsEntry) r3.get(1)).mRunWeight * 3.0d)) goto L43;
        double r12 = ((ProcStatsEntry) r3.get(0)).mRunWeight;
        long r13 = -1;
        int r14 = 0;
        boolean r16 = false;
    L49:
        if (r14 >= r3.size()) goto L129;
        ProcStatsEntry r17 = (ProcStatsEntry) r3.get(r14);
        ArrayList r18 = r3;
        if (r17.mRunWeight < (r12 / 2.0d)) goto L53;
        ApplicationInfo r1 = r24.getApplicationInfo(r17.mPackage, r5);     // Catch: PackageManager.NameNotFoundException -> L138
        if (r1 != null) goto L62;
    L117:
        String r210 = r8;
        double r21 = r12;
        if (DEBUG == false) goto L128;
        OLog.d(TAG, "Eval pkg of " + this.mName + ": pkg " + r17.mPackage + " has no icon");     // Catch: PackageManager.NameNotFoundException -> L137
    L128:
        r14 = r14 + 1;
        r8 = r210;
        r3 = r18;
        r12 = r21;
        r5 = 0;
    L126:
        if (DEBUG == false) goto L128;
        OLog.d(TAG, "Eval pkg of " + this.mName + ": pkg " + r17.mPackage + " failed finding app info");
        goto L128
    L62:
        if (r1.icon == 0) goto L117;
        if ((r1.flags & 8) != 0) goto L68;
        r210 = r8;
        if (r16 == true) goto L86;
        int r6 = this.mServices.size();
        int r19 = 0;
    L90:
        if (r19 >= r6) goto L95;
        ArrayList<Service> r4 = this.mServices.valueAt(r19);
        int r211 = r6;
        if (r4.get(0).mPackage.equals(r17.mPackage) == true) goto L93;
        r19 = r19 + 1;
        r6 = r211;
        goto L90
    L93:
        ArrayList<Service> r20 = r4;
    L97:
        if (r20 == null) goto L107;
        int r22 = r20.size();
        int r23 = 0;
    L99:
        if (r23 >= r22) goto L107;
        ArrayList<Service> r212 = r20;
        Service r30 = r20.get(r23);
        r21 = r12;
        if (r30.mDuration > 0) goto L103;
        r23 = r23 + 1;
        r20 = r212;
        r12 = r21;
        goto L99
    L103:
        if (DEBUG == false) goto L105;
        OLog.d(TAG, "Eval pkg of " + this.mName + ": pkg " + r17.mPackage + " service " + r30.mName + " run time is " + r30.mDuration);
    L105:
        long r31 = r30.mDuration;
    L109:
        if (r31 <= r13) goto L115;
        if (DEBUG == false) goto L113;
        OLog.d(TAG, "Eval pkg of " + this.mName + ": pkg " + r17.mPackage + " new best run time " + r31);
    L113:
        this.mBestTargetPackage = r17.mPackage;
        r13 = r31;
        goto L128
    L115:
        if (DEBUG == false) goto L128;
        OLog.d(TAG, "Eval pkg of " + this.mName + ": pkg " + r17.mPackage + " run time " + r31 + " not as good as last " + r13);
    L107:
        r21 = r12;
        r31 = 0;
        goto L109
    L95:
        r20 = null;
        goto L97
    L86:
        if (DEBUG == true) goto L87;
    L82:
        r21 = r12;
        goto L128
    L87:
        OLog.d(TAG, "Eval pkg of " + this.mName + ": pkg " + r17.mPackage + " is not persistent");     // Catch: PackageManager.NameNotFoundException -> L136
        goto L82
    L68:
        long r32 = r17.mRunDuration;     // Catch: PackageManager.NameNotFoundException -> L138
        if (r16 == true) goto L71;
    L78:
        r210 = r8;
        if (DEBUG == false) goto L81;
        OLog.d(TAG, "Eval pkg of " + this.mName + ": pkg " + r17.mPackage + " new best pers run time " + r32);     // Catch: PackageManager.NameNotFoundException -> L136
    L81:
        r13 = r32;
        r16 = true;
        goto L82
    L71:
        if (r32 > r13) goto L78;
        if (DEBUG == true) goto L75;
    L56:
        r210 = r8;
        goto L82
    L75:
        r210 = r8;
        OLog.d(TAG, new StringBuilder().append("Eval pkg of ").append(this.mName).append(": pkg ").append(r17.mPackage).append(" pers run time ").append(r32).append(" not as good as last ").append(r13).toString());     // Catch: PackageManager.NameNotFoundException -> L136
    L124:
        r21 = r12;
    L123:
        r210 = r8;
        goto L124
    L53:
        if (DEBUG == false) goto L56;
        OLog.d(TAG, "Eval pkg of " + this.mName + ": pkg " + r17.mPackage + r8 + r17.mRunWeight + " too small");
        goto L56
    L129:
        ArrayList r110 = r3;
        if (TextUtils.isEmpty(this.mBestTargetPackage) == false) goto L168;
        this.mBestTargetPackage = ((ProcStatsEntry) r110.get(0)).mPackage;
        return;
    L168:
        return;
    L43:
        if (DEBUG == false) goto L45;
        OLog.d(TAG, "Eval pkg of " + this.mName + ": best pkg " + ((ProcStatsEntry) r3.get(0)).mPackage + " weight " + ((ProcStatsEntry) r3.get(0)).mRunWeight + " better than " + ((ProcStatsEntry) r3.get(1)).mPackage + " weight " + ((ProcStatsEntry) r3.get(1)).mRunWeight);
    L45:
        this.mBestTargetPackage = ((ProcStatsEntry) r3.get(0)).mPackage;
        return;
    L133:
        if (r3.size() != 1) goto L170;
        this.mBestTargetPackage = ((ProcStatsEntry) r3.get(0)).mPackage;
        return;
    L170:
        return;
    L5:
        if (DEBUG == false) goto L7;
        OLog.d(TAG, "Eval pkg of " + this.mName + ": single pkg " + this.mPackages.get(0));
    L7:
        this.mBestTargetPackage = this.mPackages.get(0);
    }

    public void addService(ServiceState r3) {
        ArrayList<Service> r0 = this.mServices.get(r3.getPackage());
        if (r0 != null) goto L5;
        r0 = new ArrayList();
        this.mServices.put(r3.getPackage(), r0);
    L5:
        r0.add(new Service(r3));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.mPackage);
        r3.writeInt(this.mUid);
        r3.writeString(this.mName);
        r3.writeStringList(this.mPackages);
        r3.writeLong(this.mBgDuration);
        r3.writeLong(this.mAvgBgMem);
        r3.writeLong(this.mMaxBgMem);
        r3.writeDouble(this.mBgWeight);
        r3.writeLong(this.mRunDuration);
        r3.writeLong(this.mAvgRunMem);
        r3.writeLong(this.mMaxRunMem);
        r3.writeDouble(this.mRunWeight);
        r3.writeString(this.mBestTargetPackage);
        int r5 = this.mServices.size();
        r3.writeInt(r5);
        int r0 = 0;
    L3:
        if (r0 >= r5) goto L5;
        r3.writeString(this.mServices.keyAt(r0));
        r3.writeTypedList(this.mServices.valueAt(r0));
        r0 = r0 + 1;
        goto L3
    }

    public int getUid() {
        return this.mUid;
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
