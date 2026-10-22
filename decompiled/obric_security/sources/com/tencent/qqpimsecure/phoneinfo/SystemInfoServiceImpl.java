package com.tencent.qqpimsecure.phoneinfo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageStats;
import android.content.pm.ResolveInfo;
import android.net.NetworkInfo;
import java.util.ArrayList;
import java.util.List;
import tmsdk.common.creator.BaseManagerC;
import tmsdkobf.j9;
import tmsdkobf.m;
import tmsdkobf.o6;
import tmsdkobf.te;

/* JADX INFO: loaded from: classes4.dex */
public class SystemInfoServiceImpl extends BaseManagerC implements te {
    private j9 b;

    public SystemInfoServiceImpl() {
    }

    public void addNetworkChangeListener(te.a r1) {
        this.b.a(r1);
    }

    @Override // tmsdkobf.te
    public void addPackageChangeListener(o6 r1) {
    }

    @Override // tmsdkobf.gf
    public NetworkInfo getActiveNetworkInfo() {
        return this.b.a();
    }

    @Override // tmsdkobf.gf
    public m getAppInfo(String r1, int r2) {
        return null;
    }

    @Override // tmsdkobf.gf
    public m getAppInfo(m r1, int r2) {
        return null;
    }

    public int getAppVersionStatus(String r1, int r2) {
        return 0;
    }

    @Override // tmsdkobf.gf
    public ArrayList<m> getInstalledApp(int r1, int r2) {
        return null;
    }

    public PackageInfo getPackageInfo(String r1, int r2) {
        return null;
    }

    public PackageStats getPackageSizeInfo(String r1) {
        return null;
    }

    public String installApp(boolean r1, String r2, Activity r3, int r4) {
        return null;
    }

    @Override // tmsdkobf.gf
    public boolean isPackageInstalled(String r1) {
        return false;
    }

    public boolean isSysLoadAppFinish() {
        return false;
    }

    @Override // tmsdkobf.b0
    public void onCreate(Context r2) {
        this.b = new j9(r2);
    }

    public List<ResolveInfo> queryBroadcastReceivers(Intent r1, int r2) {
        return null;
    }

    public List<ResolveInfo> queryIntentActivities(Intent r1, int r2) {
        return null;
    }

    public List<ResolveInfo> queryIntentServices(Intent r1, int r2) {
        return null;
    }

    public void removeNetworkChangeListener(te.a r1) {
        this.b.b(r1);
    }

    @Override // tmsdkobf.te
    public void removePackageChangeListener(o6 r1) {
    }
}
