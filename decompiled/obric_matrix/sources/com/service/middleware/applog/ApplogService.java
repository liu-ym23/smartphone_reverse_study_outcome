package com.service.middleware.applog;

import android.content.Context;
import com.bytedance.news.common.service.manager.IService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface ApplogService extends IService {
    void onEvent(Context r1, String r2);

    void onEvent(Context r1, String r2, String r3);

    void onEvent(Context r1, String r2, String r3, String r4, long r5, long r7);

    void onEvent(Context r1, String r2, String r3, String r4, long r5, long r7, JSONObject r9);

    void onEvent(Context r1, String r2, String r3, String r4, long r5, long r7, boolean r9);

    void onEvent(Context r1, String r2, String r3, String r4, long r5, long r7, boolean r9, JSONObject r10);

    void registerHeaderCustomCallback(a r1);
}
