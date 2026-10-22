package com.ss.android.pushmanager;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public interface IMessageContext {
    int getAid();

    String getAppName();

    Context getContext();

    String getTweakedChannel();

    String getVersion();

    int getVersionCode();
}
