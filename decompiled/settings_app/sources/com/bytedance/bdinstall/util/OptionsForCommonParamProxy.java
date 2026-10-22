package com.bytedance.bdinstall.util;

import android.text.TextUtils;
import com.bytedance.bdinstall.AppContext;
import com.bytedance.bdinstall.InstallOptions;

/* JADX INFO: loaded from: classes3.dex */
public class OptionsForCommonParamProxy {
    private AppContext mAppContext;
    private InstallOptions mOptions;

    public OptionsForCommonParamProxy(InstallOptions r1) {
        this.mOptions = r1;
    }

    public OptionsForCommonParamProxy(AppContext r1) {
        this.mAppContext = r1;
    }

    public String getChannel() {
        InstallOptions r0 = this.mOptions;
        if (r0 == null) goto L7;
        String r1 = r0.getTweakedChannel();
        if (TextUtils.isEmpty(r1) == true) goto L15;
        return r1;
    L15:
        return this.mOptions.getChannel();
    L7:
        AppContext r2 = this.mAppContext;
        if (r2 == null) goto L12;
        String r3 = r2.getTweakedChannel();
        if (TextUtils.isEmpty(r3) == true) goto L17;
        return r3;
    L17:
        return this.mAppContext.getChannel();
    L12:
        return null;
    }

    public long getAid() {
        InstallOptions r0 = this.mOptions;
        if (r0 == null) goto L7;
        int r2 = r0.getAid();
    L6:
        return r2;
    L7:
        AppContext r3 = this.mAppContext;
        if (r3 == null) goto L10;
        r2 = r3.getAid();
        goto L6
    L10:
        return 0;
    }

    public String getAppName() {
        InstallOptions r0 = this.mOptions;
        if (r0 != null) goto L5;
        AppContext r1 = this.mAppContext;
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.getAppName();
    L5:
        return r0.getAppName();
    }

    public long getVersionCode() {
        InstallOptions r0 = this.mOptions;
        if (r0 != null) goto L5;
        AppContext r2 = this.mAppContext;
        if (r2 != null) goto L9;
        return 0;
    L9:
        return r2.getVersionCode();
    L5:
        return r0.getVersionCode();
    }

    public String getVersion() {
        InstallOptions r0 = this.mOptions;
        if (r0 != null) goto L5;
        AppContext r1 = this.mAppContext;
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.getVersion();
    L5:
        return r0.getVersion();
    }

    public long getManifestVersionCode() {
        InstallOptions r0 = this.mOptions;
        if (r0 != null) goto L5;
        AppContext r2 = this.mAppContext;
        if (r2 != null) goto L9;
        return 0;
    L9:
        return r2.getManifestVersionCode();
    L5:
        return r0.getManifestVersionCode();
    }

    public long getUpdateVersionCode() {
        InstallOptions r0 = this.mOptions;
        if (r0 != null) goto L5;
        AppContext r2 = this.mAppContext;
        if (r2 != null) goto L9;
        return 0;
    L9:
        return r2.getUpdateVersionCode();
    L5:
        return r0.getUpdateVersionCode();
    }
}
