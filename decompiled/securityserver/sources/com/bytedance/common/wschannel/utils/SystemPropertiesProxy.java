package com.bytedance.common.wschannel.utils;

import android.os.SystemProperties;

/* JADX INFO: loaded from: classes.dex */
class SystemPropertiesProxy {
    private Object mSystemProperties;

    public SystemPropertiesProxy() {
    }

    private Object getSystemProperties() {
        if (this.mSystemProperties != null) goto L19;
        monitor-enter(SystemPropertiesProxy.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.mSystemProperties == null) goto L20;
    L14:
        monitor-exit(SystemPropertiesProxy.class);     // Catch: Throwable -> L12
        goto L19
    L20:
        this.mSystemProperties = Class.forName("android.os.SystemProperties").newInstance();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L12
    L19:
        return this.mSystemProperties;
    }

    public String get(String r4) {
        return SystemProperties.get(r4);
    L4:
        th = move-exception;
        th.printStackTrace();
        Object r3 = getSystemProperties();     // Catch: IllegalArgumentException -> L8 Throwable -> L10
    L17:
        return (String) r3.getClass().getMethod("get", new Class[]{String.class}).invoke(r3, new Object[]{r4});
    L8:
        e = move-exception;
        throw e;
    L10:
        return "";
    }

    public Boolean getBoolean(String r5, boolean r6) {
        return Boolean.valueOf(SystemProperties.getBoolean(r5, r6));
    L4:
        th = move-exception;
        th.printStackTrace();
        Object r4 = getSystemProperties();     // Catch: IllegalArgumentException -> L8 Throwable -> L10
        goto L11
    L17:
        return (Boolean) r4.getClass().getMethod("getBoolean", new Class[]{String.class, Boolean.TYPE}).invoke(r4, new Object[]{r5, Boolean.valueOf(r6)});
    L8:
        e = move-exception;
        throw e;
    L11:
        return Boolean.valueOf(r6);
    }

    public Integer getInt(String r5, int r6) {
        return Integer.valueOf(SystemProperties.getInt(r5, r6));
    L4:
        th = move-exception;
        th.printStackTrace();
        Object r4 = getSystemProperties();     // Catch: IllegalArgumentException -> L8 Throwable -> L10
        goto L11
    L17:
        return (Integer) r4.getClass().getMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(r4, new Object[]{r5, Integer.valueOf(r6)});
    L8:
        e = move-exception;
        throw e;
    L11:
        return Integer.valueOf(r6);
    }

    public Long getLong(String r5, long r6) {
        return Long.valueOf(SystemProperties.getLong(r5, r6));
    L4:
        th = move-exception;
        th.printStackTrace();
        Object r4 = getSystemProperties();     // Catch: IllegalArgumentException -> L8 Throwable -> L10
        goto L11
    L17:
        return (Long) r4.getClass().getMethod("getLong", new Class[]{String.class, Integer.TYPE}).invoke(r4, new Object[]{r5, Long.valueOf(r6)});
    L8:
        e = move-exception;
        throw e;
    L11:
        return Long.valueOf(r6);
    }

    public String get(String r4, String r5) {
        return SystemProperties.get(r4);
    L5:
        th = move-exception;
        th.printStackTrace();
        Object r3 = getSystemProperties();     // Catch: IllegalArgumentException -> L9 Throwable -> L13
        goto L18
    L11:
        return (String) r3.getClass().getMethod("get", new Class[]{String.class, String.class}).invoke(r3, new Object[]{r4, r5});
    L9:
        e = move-exception;
        throw e;
    L18:
        return r5;
    }
}
