package com.bytedance.mpaas.smartrouter;

import com.bytedance.news.common.service.manager.IService;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface SmartRouterPluginService extends IService {
    List<a> initPlugins();

    void loadPlugin(a r1);
}
