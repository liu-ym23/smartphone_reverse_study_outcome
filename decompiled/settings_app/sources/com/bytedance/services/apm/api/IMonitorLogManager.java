package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface IMonitorLogManager extends IService {
    void deleteLegacyLogByIds(String r1, String r2);

    void getLegacyLog(long r1, long r3, String r5, IMonitorLogQueryCallback r6);

    List<JSONObject> getRecentUiActionRecords();
}
