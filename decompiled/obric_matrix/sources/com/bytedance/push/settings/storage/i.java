package com.bytedance.push.settings.storage;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public interface i {
    boolean a(String r1);

    String b(String r1);

    long c(String r1);

    boolean contains(String r1);

    int d(String r1);

    float e(String r1);

    SharedPreferences.Editor edit();

    boolean getBoolean(String r1, boolean r2);

    float getFloat(String r1, float r2);

    int getInt(String r1, int r2);

    long getLong(String r1, long r2);

    String getString(String r1, String r2);

    void registerValChanged(Context r1, String r2, String r3, com.bytedance.push.settings.a r4);

    void unregisterValChanged(com.bytedance.push.settings.a r1);
}
