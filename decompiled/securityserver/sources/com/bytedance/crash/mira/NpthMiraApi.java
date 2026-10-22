package com.bytedance.crash.mira;

import androidx.annotation.Nullable;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class NpthMiraApi {
    static MiraCallbackImpl sMiraCallbackImpl = null;
    private static boolean sMiraInited = false;
    private static PluginInfoCallback sPluginInfoCallback;

    public interface MiraCallbackImpl {
        void setMiraCallbackImpl(MiraPluginEventListener r1);
    }

    public static class MiraPluginEventListener {
        public MiraPluginEventListener() {
        }

        public void onPluginInstallResult(String r1, boolean r2) {
        }

        public void onPluginLoaded(String r1) {
        }
    }

    public interface PluginInfoCallback {
        JSONArray getPluginInfo();
    }

    public NpthMiraApi() {
    }

    @Nullable
    public static JSONArray getPluginInfo() {
        PluginInfoCallback r1 = sPluginInfoCallback;     // Catch: Throwable -> L8
        if (r1 == null) goto L11;
        return r1.getPluginInfo();
    L11:
        return null;
    L12:
        return null;
    }

    public static boolean miraInited() {
        return sMiraInited;
    }

    public static void registerMiraCallback(MiraPluginEventListener r1) {
        MiraCallbackImpl r0 = sMiraCallbackImpl;
        if (r0 == null) goto L9;
        r0.setMiraCallbackImpl(r1);     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static void setMiraCallbackImpl(MiraCallbackImpl r0) {
        sMiraCallbackImpl = r0;
    }

    public static void setMiraInited() {
        sMiraInited = true;
    }

    public static void setPluginInfoCallback(PluginInfoCallback r0) {
        sPluginInfoCallback = r0;
    }
}
