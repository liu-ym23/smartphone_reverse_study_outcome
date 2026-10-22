package com.obric.baseservice.privacy;

import android.content.Context;
import android.provider.Settings;
import com.bytedance.privacy.bridge.IEnvBridge;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PrivacyEnvBridge.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/baseservice/privacy/PrivacyEnvBridge;", "Lcom/bytedance/privacy/bridge/IEnvBridge;", "()V", "SETTINGS_MATRIX_ENV_IS_BOE", "", "appContext", "Landroid/content/Context;", "init", "", "context", "onIsBoeEnv", "", "baseservice_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PrivacyEnvBridge implements IEnvBridge {
    public static final PrivacyEnvBridge INSTANCE = null;
    private static final String SETTINGS_MATRIX_ENV_IS_BOE = "matrix_env_status_is_boe";
    private static Context appContext;

    static {
        INSTANCE = new PrivacyEnvBridge();
    }

    private PrivacyEnvBridge() {
    }

    public final void init(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        appContext = r1.getApplicationContext();
    }

    @Override // com.bytedance.privacy.bridge.IEnvBridge
    public boolean onIsBoeEnv() {
        Context r2 = appContext;
        if (r2 != null) goto L6;
        return false;
    L6:
        if (Settings.Global.getInt(r2.getContentResolver(), SETTINGS_MATRIX_ENV_IS_BOE, 0) == 1) goto L8;
        return false;
    L8:
        return true;
    }
}
