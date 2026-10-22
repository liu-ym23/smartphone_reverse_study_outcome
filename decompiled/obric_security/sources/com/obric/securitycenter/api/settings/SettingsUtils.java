package com.obric.securitycenter.api.settings;

import android.content.Context;
import com.bytedance.keva.KevaImpl;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.matrix.platform.sdk.ones.settings.MatrixSettingsConfig;
import com.obric.matrix.platform.sdk.ones.settings.MatrixSettingsManager;
import com.obric.matrix.platform.sdk.ones.settings.SettingsUpdateListener;
import com.obric.olog.OLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SettingsUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0014\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/obric/securitycenter/api/settings/SettingsUtils;", "", "()V", "TAG", "", "appContext", "Landroid/content/Context;", "settingsUpdateListener", "Lcom/obric/matrix/platform/sdk/ones/settings/SettingsUpdateListener;", "getSettingsUpdateListener", "()Lcom/obric/matrix/platform/sdk/ones/settings/SettingsUpdateListener;", "getAppContext", "getAppContext$api_release", "getSettingsConfig", "Lcom/google/gson/JsonObject;", "initSettingsConfig", "", "context", "parseSettingsToJsonObject", "settings", "updateSettingsInternal", "api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SettingsUtils {
    public static final SettingsUtils INSTANCE = null;
    private static final String TAG = "SettingsUtils";
    private static volatile Context appContext;
    private static final SettingsUpdateListener settingsUpdateListener = null;

    private SettingsUtils() {
    }

    public static final /* synthetic */ void access$updateSettingsInternal(SettingsUtils r0, String r1) {
        r0.updateSettingsInternal(r1);
    }

    public final Context getAppContext$api_release() {
        return appContext;
    }

    static {
        INSTANCE = new SettingsUtils();
        settingsUpdateListener = new SettingsUtils$settingsUpdateListener$1();
    }

    public final SettingsUpdateListener getSettingsUpdateListener() {
        return settingsUpdateListener;
    }

    public final void initSettingsConfig(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Context r5 = r4.getApplicationContext();
        appContext = r5;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        SettingsUtils r1 = this;     // Catch: Throwable -> L5
        MatrixSettingsConfig r2 = new MatrixSettingsConfig.Builder().setPackageName("com.obric.security").setVersionCode(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD).setIsBoe(true).setVersionName("1.0.0").build();     // Catch: Throwable -> L5
        MatrixSettingsManager.Companion r3 = MatrixSettingsManager.Companion;     // Catch: Throwable -> L5
        Intrinsics.checkNotNullExpressionValue(r5, "applicationContext");     // Catch: Throwable -> L5
        r3.init(r5, r2);     // Catch: Throwable -> L5
        updateSettingsInternal(MatrixSettingsManager.Companion.getInstance().getAllSettings());     // Catch: Throwable -> L5
        MatrixSettingsManager.Companion.getInstance().addSettingsUpdateListener(settingsUpdateListener);     // Catch: Throwable -> L5
        Object r6 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r7 = Result.m777exceptionOrNullimpl(r6);
        if (r7 == null) goto L13;
        OLog.w(TAG, "init settings config failed", r7);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final void updateSettingsInternal(String r1) {
        SettingsManager.updateSettingsConfig(parseSettingsToJsonObject(r1));
    }

    public final JsonObject getSettingsConfig() {
        if (MatrixSettingsManager.Companion.isInited() == false) goto L5;
        JsonObject r1 = parseSettingsToJsonObject(MatrixSettingsManager.Companion.getInstance().getAllSettings());
        if (r1 == null) goto L9;
        return r1;
    L9:
        return new JsonObject();
    L5:
        return new JsonObject();
    }

    private final JsonObject parseSettingsToJsonObject(String r3) {
        String r2 = r3;
        if (r2 != null) goto L5;
    L8:
        boolean r4 = true;
    L10:
        if (r4 == false) goto L12;
        return null;
    L12:
        if (Intrinsics.areEqual(r3, "null") == true) goto L26;
        JsonElement r5 = JsonParser.parseString(r3);     // Catch: Throwable -> L18
        if (r5.isJsonObject() == false) goto L24;
        return r5.getAsJsonObject();
    L24:
        return null;
    L18:
        th = move-exception;
        OLog.w(TAG, "parse settings failed", th);
        JsonObject r6 = (JsonObject) null;
        return null;
    L26:
        return null;
    L5:
        if (StringsKt.isBlank(r2) == true) goto L8;
        r4 = false;
        goto L10
    }
}
