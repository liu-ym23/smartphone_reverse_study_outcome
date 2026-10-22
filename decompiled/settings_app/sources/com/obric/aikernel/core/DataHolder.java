package com.obric.aikernel.core;

import com.obric.aikernel.sdk.AIKernelConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataHolder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/obric/aikernel/core/DataHolder;", "", "()V", "config", "Lcom/obric/aikernel/sdk/AIKernelConfig;", "getConfig", "()Lcom/obric/aikernel/sdk/AIKernelConfig;", "setConfig", "(Lcom/obric/aikernel/sdk/AIKernelConfig;)V", "sdkVersion", "", "getSdkVersion", "()Ljava/lang/String;", "setSdkVersion", "(Ljava/lang/String;)V", "useAuthProvider", "", "getUseAuthProvider", "()Z", "setUseAuthProvider", "(Z)V", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DataHolder {
    public static final DataHolder INSTANCE = null;
    private static AIKernelConfig config;
    private static String sdkVersion;
    private static boolean useAuthProvider;

    private DataHolder() {
    }

    public final AIKernelConfig getConfig() {
        return config;
    }

    public final void setConfig(AIKernelConfig r1) {
        config = r1;
    }

    static {
        INSTANCE = new DataHolder();
        sdkVersion = "";
    }

    public final String getSdkVersion() {
        return sdkVersion;
    }

    public final void setSdkVersion(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        sdkVersion = r1;
    }

    public final boolean getUseAuthProvider() {
        return useAuthProvider;
    }

    public final void setUseAuthProvider(boolean r1) {
        useAuthProvider = r1;
    }
}
