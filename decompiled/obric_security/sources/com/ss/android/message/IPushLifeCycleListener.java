package com.ss.android.message;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes4.dex */
public interface IPushLifeCycleListener {
    void onNotifyDestroy();

    void onNotifyServiceCreate(Context r1);

    void onNotifyServiceStart(Intent r1);
}
