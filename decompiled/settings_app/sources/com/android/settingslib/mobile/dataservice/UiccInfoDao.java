package com.android.settingslib.mobile.dataservice;

import androidx.lifecycle.LiveData;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface UiccInfoDao {
    int count();

    void deleteBySubId(String r1);

    void insertUiccInfo(UiccInfoEntity... r1);

    LiveData<List<UiccInfoEntity>> queryAllUiccInfos();

    LiveData<UiccInfoEntity> queryUiccInfoById(String r1);

    LiveData<List<UiccInfoEntity>> queryUiccInfosByEuicc(boolean r1);
}
