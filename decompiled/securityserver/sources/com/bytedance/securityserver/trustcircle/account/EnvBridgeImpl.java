package com.bytedance.securityserver.trustcircle.account;

import android.app.Application;
import android.provider.Settings;
import com.bytedance.privacy.bridge.IEnvBridge;

/* JADX INFO: loaded from: classes.dex */
public class EnvBridgeImpl implements IEnvBridge {
    public static volatile EnvBridgeImpl b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f73a;

    public EnvBridgeImpl(Application r1) {
        this.f73a = r1;
    }

    @Override // com.bytedance.privacy.bridge.IEnvBridge
    public final boolean a() {
        if (Settings.Global.getInt(this.f73a.getContentResolver(), "matrix_env_status_is_boe", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }
}
