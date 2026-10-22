package com.android.settingslib.mobile.dataservice;

import androidx.lifecycle.LiveData;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface SubscriptionInfoDao {
    int count();

    void deleteBySubId(String r1);

    void insertSubsInfo(SubscriptionInfoEntity... r1);

    LiveData<List<SubscriptionInfoEntity>> queryActiveSubInfos(boolean r1, boolean r2);

    LiveData<List<SubscriptionInfoEntity>> queryAvailableSubInfos();

    SubscriptionInfoEntity querySubInfoById(String r1);
}
