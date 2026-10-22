package com.android.settings.servicemanager;

import com.bytedance.news.common.service.manager.IService;

/* JADX INFO: loaded from: classes2.dex */
public interface IEmergencyHelp extends IService {
    int getSubtitle();

    int getTitle();

    boolean isShowEmergency();
}
