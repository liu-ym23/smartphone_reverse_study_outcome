package com.bytedance.bdlocation.callback;

import androidx.annotation.Nullable;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.exception.BDLocationException;

/* JADX INFO: loaded from: classes.dex */
public interface BDLocationCallback {
    void onError(@Nullable BDLocationException r1);

    void onLocationChanged(@Nullable BDLocation r1);
}
