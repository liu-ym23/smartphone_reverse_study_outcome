package com.android.settings.applications;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settingslib.applications.RecentAppOpsAccess;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class ProcStatsPackageEntry implements Parcelable {
    private static final float ALWAYS_THRESHOLD = 0.95f;
    public static final Parcelable.Creator<ProcStatsPackageEntry> CREATOR = null;
    private static boolean DEBUG = false;
    private static final float SOMETIMES_THRESHOLD = 0.25f;
    private static final String TAG = "ProcStatsEntry";
    long mAvgBgMem;
    long mAvgRunMem;
    long mBgDuration;
    double mBgWeight;
    final ArrayList<ProcStatsEntry> mEntries;
    long mMaxBgMem;
    long mMaxRunMem;
    final String mPackage;
    long mRunDuration;
    double mRunWeight;
    public String mUiLabel;
    public ApplicationInfo mUiTargetApp;
    private long mWindowLength;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ProcStatsPackageEntry(String r2, long r3) {
        this.mEntries = new ArrayList();
        this.mPackage = r2;
        this.mWindowLength = r3;
    }

    public ProcStatsPackageEntry(Parcel r3) {
        ArrayList<ProcStatsEntry> r0 = new ArrayList();
        this.mEntries = r0;
        this.mPackage = r3.readString();
        r3.readTypedList(r0, ProcStatsEntry.CREATOR);
        this.mBgDuration = r3.readLong();
        this.mAvgBgMem = r3.readLong();
        this.mMaxBgMem = r3.readLong();
        this.mBgWeight = r3.readDouble();
        this.mRunDuration = r3.readLong();
        this.mAvgRunMem = r3.readLong();
        this.mMaxRunMem = r3.readLong();
        this.mRunWeight = r3.readDouble();
    }

    public CharSequence getRunningFrequency(Context r4) {
        return getFrequency(this.mRunDuration / this.mWindowLength, r4);
    }

    public CharSequence getBackgroundFrequency(Context r4) {
        return getFrequency(this.mBgDuration / this.mWindowLength, r4);
    }

    public void addEntry(ProcStatsEntry r1) {
        this.mEntries.add(r1);
    }

    public void updateMetrics() {
        this.mMaxBgMem = 0;
        this.mAvgBgMem = 0;
        this.mBgDuration = 0;
        this.mBgWeight = 0.0d;
        this.mMaxRunMem = 0;
        this.mAvgRunMem = 0;
        this.mRunDuration = 0;
        this.mRunWeight = 0.0d;
        int r0 = this.mEntries.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ProcStatsEntry r2 = this.mEntries.get(r1);
        this.mBgDuration = Math.max(r2.mBgDuration, this.mBgDuration);
        this.mAvgBgMem += r2.mAvgBgMem;
        this.mBgWeight += r2.mBgWeight;
        this.mRunDuration = Math.max(r2.mRunDuration, this.mRunDuration);
        this.mAvgRunMem += r2.mAvgRunMem;
        this.mRunWeight += r2.mRunWeight;
        this.mMaxBgMem += r2.mMaxBgMem;
        this.mMaxRunMem += r2.mMaxRunMem;
        r1 = r1 + 1;
        goto L3
    L5:
        long r3 = r0;
        this.mAvgBgMem /= r3;
        this.mAvgRunMem /= r3;
    }

    public void retrieveUiData(Context r3, PackageManager r4) {
        this.mUiTargetApp = null;
        String r0 = this.mPackage;
        this.mUiLabel = r0;
        if ("os".equals(r0) == false) goto L6;
        this.mUiTargetApp = r4.getApplicationInfo(RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME, 41472);     // Catch: PackageManager.NameNotFoundException -> L8
        this.mUiLabel = r3.getString(R.string.process_stats_os_label);     // Catch: PackageManager.NameNotFoundException -> L8
    L9:
        return;
    L6:
        ApplicationInfo r5 = r4.getApplicationInfo(this.mPackage, 41472);     // Catch: PackageManager.NameNotFoundException -> L8
        this.mUiTargetApp = r5;     // Catch: PackageManager.NameNotFoundException -> L8
        this.mUiLabel = r5.loadLabel(r4).toString();     // Catch: PackageManager.NameNotFoundException -> L8
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.mPackage);
        r3.writeTypedList(this.mEntries);
        r3.writeLong(this.mBgDuration);
        r3.writeLong(this.mAvgBgMem);
        r3.writeLong(this.mMaxBgMem);
        r3.writeDouble(this.mBgWeight);
        r3.writeLong(this.mRunDuration);
        r3.writeLong(this.mAvgRunMem);
        r3.writeLong(this.mMaxRunMem);
        r3.writeDouble(this.mRunWeight);
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public static CharSequence getFrequency(float r4, Context r5) {
        if (r4 <= ALWAYS_THRESHOLD) goto L7;
        return r5.getString(R.string.always_running, new Object[]{Utils.formatPercentage((int) (r4 * 100.0f))});
    L7:
        if (r4 <= SOMETIMES_THRESHOLD) goto L11;
        return r5.getString(R.string.sometimes_running, new Object[]{Utils.formatPercentage((int) (r4 * 100.0f))});
    L11:
        return r5.getString(R.string.rarely_running, new Object[]{Utils.formatPercentage((int) (r4 * 100.0f))});
    }
}
