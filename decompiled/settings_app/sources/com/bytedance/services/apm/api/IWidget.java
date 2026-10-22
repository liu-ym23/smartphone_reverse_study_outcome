package com.bytedance.services.apm.api;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public interface IWidget {
    void destroy();

    String getTag();

    void init(Context r1);

    boolean isOnlyMainProcess();

    void notifyParams(WidgetParams r1);

    void start();

    void stop();
}
