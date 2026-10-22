package com.android.settings.applications;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.android.settings.AppHeader;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AppInfoWithHeader extends AppInfoBase {
    public static final String EXTRA_HIDE_INFO_BUTTON = "hideInfoButton";
    private boolean mCreated;

    public AppInfoWithHeader() {
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r8) {
        super.onActivityCreated(r8);
        if (this.mCreated == false) goto L6;
        OLog.w(TAG, "onActivityCreated: ignoring duplicate call");
        return;
    L6:
        this.mCreated = true;
        if (this.mPackageInfo != null) goto L9;
        return;
    L9:
        AppHeader.createAppHeader(this, this.mPackageInfo.applicationInfo.loadIcon(this.mPm), this.mPackageInfo.applicationInfo.loadLabel(this.mPm), this.mPackageName, this.mPackageInfo.applicationInfo.uid, 0);
    }

    public static Intent getInfoIntent(Fragment r3, String r4) {
        Bundle r0 = r3.getArguments();
        Intent r5 = r3.getActivity().getIntent();
        boolean r2 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = true;
    L8:
        if (r5 != null) goto L10;
    L12:
        r2 = r1;
    L14:
        if (r2 == false) goto L17;
        Intent r6 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        r6.setData(Uri.fromParts("package", r4, null));
        return r6;
    L17:
        return null;
    L10:
        if (r5.getBooleanExtra("hideInfoButton", false) == false) goto L12;
    L5:
        if (r0.getBoolean("hideInfoButton", false) == false) goto L7;
        r1 = false;
        goto L8
    }
}
