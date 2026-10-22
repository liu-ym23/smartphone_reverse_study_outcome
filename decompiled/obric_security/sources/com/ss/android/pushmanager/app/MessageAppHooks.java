package com.ss.android.pushmanager.app;

import android.content.Context;
import com.ss.android.pushmanager.IMessageContext;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class MessageAppHooks {
    private static InitHook mInitHook;
    private static PushHook sPushHook;

    public interface InitHook {
        void tryInit(Context r1);
    }

    public interface PushHook {
        Map<String, String> getHttpCommonParams();

        String getMessageAction();

        IMessageContext getMessageContext();

        String getMessageKeyData();

        Class getNotifyServiceClass();

        String getRomInfo();

        String getSessionKey();

        boolean isSswoActivityisFinish();

        void onEvent(Context r1, String r2, String r3, String r4, long r5, long r7, JSONObject r9);
    }

    static {
    }

    public MessageAppHooks() {
    }

    public static void setInitHook(InitHook r0) {
        mInitHook = r0;
    }

    public static InitHook getInitHook() {
        return mInitHook;
    }

    public static PushHook getPushHook() {
        return sPushHook;
    }

    public static void setPushHook(PushHook r0) {
        sPushHook = r0;
    }
}
