package com.bytedance.bdlocation.callback;

import androidx.annotation.Nullable;
import com.bytedance.bdlocation.entity.region.RegionBean;

/* JADX INFO: loaded from: classes.dex */
public interface RegionUploadCallback {
    void onUpLoadResult(boolean r1, @Nullable RegionBean r2);
}
