package com.android.settingslib.mobile.dataservice;

import androidx.lifecycle.LiveData;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface MobileNetworkInfoDao {
    int count();

    void deleteBySubId(String r1);

    void insertMobileNetworkInfo(MobileNetworkInfoEntity... r1);

    LiveData<List<MobileNetworkInfoEntity>> queryAllMobileNetworkInfos();

    MobileNetworkInfoEntity queryMobileNetworkInfoBySubId(String r1);

    LiveData<List<MobileNetworkInfoEntity>> queryMobileNetworkInfosByMobileDataStatus(boolean r1);
}
