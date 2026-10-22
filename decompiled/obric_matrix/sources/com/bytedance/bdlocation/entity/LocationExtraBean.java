package com.bytedance.bdlocation.entity;

import androidx.annotation.Nullable;
import com.bytedance.bdlocation.scan.bluetooth.BDBleInfo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LocationExtraBean {
    private List<BDBleInfo> bleInfoList;
    private LogIdCacheEntity logIdCacheEntity;

    public LocationExtraBean() {
    }

    @Nullable
    public List<BDBleInfo> getBleInfoList() {
        return this.bleInfoList;
    }

    @Nullable
    public LogIdCacheEntity getLogIdCacheEntity() {
        return this.logIdCacheEntity;
    }

    public void setBleInfoList(List<BDBleInfo> r1) {
        this.bleInfoList = r1;
    }

    public void setLogIdCacheEntity(LogIdCacheEntity r1) {
        this.logIdCacheEntity = r1;
    }
}
