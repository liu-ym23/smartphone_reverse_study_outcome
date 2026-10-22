package com.obric.matrix.platform.sdk.ones.init;

import com.bytedance.platform.godzilla.common.CrashPortrait;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import com.obric.oui.material.MaterialConfigBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: InitHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tJ\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/init/CrashProvider;", "", "()V", "TAG", "", "crashPortraitList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/platform/godzilla/common/CrashPortrait;", "provideCrashPortraits", "", "refreshJson", "", MaterialConfigBuilder.SERIALIZATION_FORMAT_JSON, "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CrashProvider {
    public static final CrashProvider INSTANCE = null;
    private static final String TAG = "CrashProvider";
    private static final CopyOnWriteArrayList<CrashPortrait> crashPortraitList = null;

    private CrashProvider() {
    }

    static {
        INSTANCE = new CrashProvider();
        crashPortraitList = new CopyOnWriteArrayList();
    }

    public final void refreshJson(String r8) {
        String r0 = r8;
        int r1 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
    L24:
        MLog.i$default(TAG, "refreshJson: json is null or empty ", null, 4, null);
        crashPortraitList.clear();
        return;
    L12:
        if (Intrinsics.areEqual(r8, "null") == true) goto L24;
        JSONObject r3 = new JSONObject(r8);     // Catch: Exception -> L21
        ArrayList r4 = new ArrayList();     // Catch: Exception -> L21
        if (r3.has("crash_portrait") == false) goto L19;
        JSONArray r7 = r3.getJSONArray("crash_portrait");     // Catch: Exception -> L21
        int r5 = r7.length();     // Catch: Exception -> L21
    L17:
        if (r1 >= r5) goto L19;
        JSONObject r6 = r7.getJSONObject(r1);     // Catch: Exception -> L21
        CrashPortrait r9 = new CrashPortrait();     // Catch: Exception -> L21
        r9.processName = r6.optString("process_name");     // Catch: Exception -> L21
        r9.clazzName = r6.optString("clazz_name");     // Catch: Exception -> L21
        r9.methodName = r6.optString("method_name");     // Catch: Exception -> L21
        r9.threadName = r6.optString("thread_name");     // Catch: Exception -> L21
        r9.appVersion = r6.optString("app_version");     // Catch: Exception -> L21
        r9.updateVersion = r6.optInt("update_version");     // Catch: Exception -> L21
        r9.detailMessage = r6.optString("detail_message");     // Catch: Exception -> L21
        r9.throwableClassName = r6.optString("throwable_class_name");     // Catch: Exception -> L21
        r9.osVersion = r6.optInt("osVersion");     // Catch: Exception -> L21
        r4.add(r9);     // Catch: Exception -> L21
        r1 = r1 + 1;     // Catch: Exception -> L21
    L19:
        CopyOnWriteArrayList<CrashPortrait> r10 = crashPortraitList;     // Catch: Exception -> L21
        r10.clear();     // Catch: Exception -> L21
        r10.addAll(r4);     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        MLog.e(TAG, "Failed to refresh crash portrait json " + r8, e);
        crashPortraitList.clear();
        return;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r2 = false;
        goto L10
    }

    public final List<CrashPortrait> provideCrashPortraits() {
        return crashPortraitList;
    }
}
