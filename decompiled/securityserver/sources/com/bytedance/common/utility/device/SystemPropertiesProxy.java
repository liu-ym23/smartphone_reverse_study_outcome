package com.bytedance.common.utility.device;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class SystemPropertiesProxy {
    public SystemPropertiesProxy() {
    }

    public String get(String r3) {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke(null, new Object[]{r3});
    }
}
