package com.bytedance.apm.core;

import android.app.Activity;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public interface c {
    void onActivityCreated(Activity r1, Bundle r2);

    void onActivityDestroyed(Activity r1);

    void onActivityResumed(Activity r1);

    void onBackground(Activity r1);

    void onFront(Activity r1);
}
