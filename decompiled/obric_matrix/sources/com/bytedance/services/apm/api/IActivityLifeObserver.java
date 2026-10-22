package com.bytedance.services.apm.api;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes.dex */
public interface IActivityLifeObserver {
    void onActivityCreated(Activity r1, Bundle r2);

    void onActivityPause(Activity r1);

    void onActivityResume(Activity r1);

    void onActivityStarted(Activity r1);

    void onBackground(Activity r1);

    void onChange(Activity r1, Fragment r2);

    void onFront(Activity r1);
}
