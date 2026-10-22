package com.bytedance.bdlocation.api;

import androidx.annotation.Nullable;
import com.bytedance.bdlocation.callback.UploadCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IShakeManager extends IManager {
    void setConfig(JSONObject r1);

    void startScanTask(Object r1);

    void startShakeUpload(@Nullable Object r1, String r2, JSONObject r3, UploadCallback r4);

    void stopScanTask();
}
