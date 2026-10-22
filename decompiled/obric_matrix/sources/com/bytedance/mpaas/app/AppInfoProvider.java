package com.bytedance.mpaas.app;

import com.bytedance.news.common.service.manager.IService;

/* JADX INFO: loaded from: classes.dex */
public interface AppInfoProvider extends IService {
    String getAid();

    String getAppName();

    String getBuildVersion();

    String getChannel();

    String getUpdateVersionCode();

    String getVersionCode();

    String getVersionName();

    boolean isApkDebuggable();
}
