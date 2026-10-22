package com.bytedance.common.wschannel.app;

/* JADX INFO: loaded from: classes3.dex */
public interface ISharedPref {
    boolean getBoolean(String r1, boolean r2);

    float getFloat(String r1, float r2);

    int getInt(String r1, int r2);

    long getLong(String r1, long r2);

    String getString(String r1, String r2);

    void putBoolean(String r1, boolean r2);

    void putFloat(String r1, float r2);

    void putInt(String r1, int r2);

    void putLong(String r1, long r2);

    void putString(String r1, String r2);
}
