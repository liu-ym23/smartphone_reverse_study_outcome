package com.obric.matrix.platform.sdk.ones.init;

import com.bytedance.platform.godzilla.common.CrashPortrait;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CrashProvider {

    @NotNull
    public static final CrashProvider INSTANCE = null;

    @NotNull
    private static final String TAG = "CrashProvider";

    @NotNull
    private static final CopyOnWriteArrayList<CrashPortrait> crashPortraitList = null;

    static {
        INSTANCE = new CrashProvider();
        crashPortraitList = new CopyOnWriteArrayList();
    }

    private CrashProvider() {
    }

    @NotNull
    public final List<CrashPortrait> provideCrashPortraits() {
        return crashPortraitList;
    }

    public final void refreshJson(@Nullable String r8) {
        if (r8 != null) goto L5;
    L21:
        MLog.i$default(TAG, "refreshJson: json is null or empty ", null, 4, null);
        crashPortraitList.clear();
        return;
    L5:
        if (StringsKt.t(r8) == true) goto L21;
        if (Intrinsics.a(r8, "null") == true) goto L21;
        JSONObject r1 = new JSONObject(r8);     // Catch: Exception -> L15
        ArrayList r2 = new ArrayList();     // Catch: Exception -> L15
        if (r1.has("crash_portrait") == false) goto L17;
        JSONArray r7 = r1.getJSONArray("crash_portrait");     // Catch: Exception -> L15
        int r3 = r7.length();     // Catch: Exception -> L15
        int r4 = 0;
    L13:
        if (r4 >= r3) goto L17;
        JSONObject r5 = r7.getJSONObject(r4);     // Catch: Exception -> L15
        CrashPortrait r6 = new CrashPortrait();     // Catch: Exception -> L15
        r6.processName = r5.optString("process_name");     // Catch: Exception -> L15
        r6.clazzName = r5.optString("clazz_name");     // Catch: Exception -> L15
        r6.methodName = r5.optString("method_name");     // Catch: Exception -> L15
        r6.threadName = r5.optString("thread_name");     // Catch: Exception -> L15
        r6.appVersion = r5.optString("app_version");     // Catch: Exception -> L15
        r6.updateVersion = r5.optInt("update_version");     // Catch: Exception -> L15
        r6.detailMessage = r5.optString("detail_message");     // Catch: Exception -> L15
        r6.throwableClassName = r5.optString("throwable_class_name");     // Catch: Exception -> L15
        r6.osVersion = r5.optInt("osVersion");     // Catch: Exception -> L15
        r2.add(r6);     // Catch: Exception -> L15
        r4 = r4 + 1;     // Catch: Exception -> L15
    L17:
        CopyOnWriteArrayList<CrashPortrait> r9 = crashPortraitList;     // Catch: Exception -> L15
        r9.clear();     // Catch: Exception -> L15
        r9.addAll(r2);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        MLog.e(TAG, "Failed to refresh crash portrait json " + r8, e);
        crashPortraitList.clear();
    }
}
