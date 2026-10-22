package com.bytedance.android.standard.tools.device;

/* JADX INFO: loaded from: classes3.dex */
public final class SystemPropertiesProxy {
    SystemPropertiesProxy() {
    }

    public String get(String r5) throws Throwable {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke(null, new Object[]{r5});
    }
}
