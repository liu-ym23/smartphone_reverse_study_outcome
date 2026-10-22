package com.ss.android.message;

import android.content.Context;
import com.ss.android.pushmanager.IMessageContext;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface IPushLifeAdapter extends IPushLifeCycleListener {

    public interface IPushDepend {
        void onEvent(Context r1, String r2, String r3, String r4, long r5, long r7, JSONObject r9);

        void onEventV3(String r1, JSONObject r2);
    }

    void handleAppLogUpdate(Context r1, Map<String, String> r2);

    void initOnApplication(Context r1, IMessageContext r2);

    void onSetSettingsData(Context r1, JSONObject r2);

    void setPushDepend(IPushDepend r1);
}
