package com.bytedance.bdinstall;

import android.text.TextUtils;
import obric.time.HttpHeadTimeFetcher;

/* JADX INFO: loaded from: classes3.dex */
public class InstallUrl implements Cloneable {
    private final String mUriActive;
    private final String mUriRegister;

    public static InstallUrl createUriByDomain(String r2) {
        return new InstallUrl(r2 + "/service/2/device_register/", r2 + "/service/2/app_alert_check/");
    }

    public InstallUrl(String r1, String r2) {
        this.mUriRegister = forceHttpsUrl(r1);
        this.mUriActive = forceHttpsUrl(r2);
    }

    private String forceHttpsUrl(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
    L9:
        return r1;
    L5:
        if (r1.startsWith(HttpHeadTimeFetcher.FETCHER_TYPE) == true) goto L9;
        throw new IllegalArgumentException("url protocol should be https");
    }

    public String getRegisterUri() {
        return this.mUriRegister;
    }

    public String getActiveUri() {
        return this.mUriActive;
    }

    public String toString() {
        return "{r='" + this.mUriRegister + "', a='" + this.mUriActive + "'}";
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof InstallUrl) == false) goto L14;
        InstallUrl r6 = (InstallUrl) r5;
        if (TextUtils.equals(this.mUriActive, r6.mUriActive) == false) goto L13;
        if (TextUtils.equals(this.mUriRegister, r6.mUriRegister) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }
}
