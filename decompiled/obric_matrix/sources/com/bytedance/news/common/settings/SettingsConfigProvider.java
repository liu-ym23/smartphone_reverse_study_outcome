package com.bytedance.news.common.settings;

import com.bytedance.news.common.service.manager.IService;

/* JADX INFO: loaded from: classes.dex */
public interface SettingsConfigProvider extends IService {
    b getConfig();

    d getLazyConfig();
}
