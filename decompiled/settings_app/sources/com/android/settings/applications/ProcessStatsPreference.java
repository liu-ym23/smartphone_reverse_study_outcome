package com.android.settings.applications;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.android.settings.AppProgressPreference;

/* JADX INFO: loaded from: classes2.dex */
public class ProcessStatsPreference extends AppProgressPreference {
    private ProcStatsPackageEntry mEntry;

    public ProcessStatsPreference(Context r2) {
        super(r2, null);
    }

    public void init(ProcStatsPackageEntry r7, PackageManager r8, double r9, double r11, double r13, boolean r15) {
        this.mEntry = r7;
        if (TextUtils.isEmpty(r7.mUiLabel) == false) goto L5;
        String r0 = r7.mPackage;
    L6:
        setTitle(r0);
        boolean r1 = false;
        if (r7.mUiTargetApp == null) goto L9;
        setIcon(r7.mUiTargetApp.loadIcon(r8));
    L11:
        if (r7.mRunWeight <= r7.mBgWeight) goto L13;
        r1 = true;
    L13:
        if (r15 == false) goto L17;
        if (r1 == false) goto L16;
        double r10 = r7.mRunWeight;
    L21:
        double r12 = r10 * r11;
        setSummary(Formatter.formatShortFileSize(getContext(), (long) r12));
        setProgress((int) ((r12 * 100.0d) / r9));
        return;
    L16:
        r10 = r7.mBgWeight;
        goto L21
    L17:
        if (r1 == false) goto L19;
        long r14 = r7.mMaxRunMem;
    L20:
        r10 = r14 * r13;
        r11 = 1024.0d;
        goto L21
    L19:
        r14 = r7.mMaxBgMem;
        goto L20
    L9:
        setIcon(new ColorDrawable(0));
        goto L11
    L5:
        r0 = r7.mUiLabel;
        goto L6
    }

    public ProcStatsPackageEntry getEntry() {
        return this.mEntry;
    }
}
