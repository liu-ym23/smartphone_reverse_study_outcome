package com.bytedance.bdlocation.trace;

import androidx.annotation.Nullable;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.callback.LocateCallback;
import com.bytedance.bdlocation.exception.BDLocationException;

/* JADX INFO: loaded from: classes.dex */
public interface TraceCallback extends LocateCallback {
    void onError(@Nullable BDLocationException r1);

    void onLocationChanged(@Nullable BDLocation r1);

    void onStart(LocationTrace r1);

    void onStop();
}
