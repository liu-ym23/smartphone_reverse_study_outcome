package com.bytedance.push.settings;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public interface ILocalSettings {
    void registerValChanged(Context r1, String r2, String r3, a r4);

    void unregisterValChanged(a r1);
}
