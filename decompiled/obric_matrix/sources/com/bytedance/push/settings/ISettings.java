package com.bytedance.push.settings;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface ISettings {
    void registerValChanged(Context r1, String r2, String r3, a r4);

    void unregisterValChanged(a r1);

    void updateSettings(Context r1, JSONObject r2);
}
