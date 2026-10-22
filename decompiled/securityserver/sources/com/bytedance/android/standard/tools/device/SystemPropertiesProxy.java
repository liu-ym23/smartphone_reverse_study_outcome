package com.bytedance.android.standard.tools.device;

/* JADX INFO: loaded from: classes.dex */
public final class SystemPropertiesProxy {
    public SystemPropertiesProxy() {
    }

    public String get(String r3) {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke(null, new Object[]{r3});
    }
}
