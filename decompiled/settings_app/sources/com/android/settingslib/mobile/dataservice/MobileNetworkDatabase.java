package com.android.settingslib.mobile.dataservice;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.GlobalProxyLancet;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class MobileNetworkDatabase extends RoomDatabase {
    public static final String TAG = "MobileNetworkDatabase";
    private static MobileNetworkDatabase sInstance;
    private static final Object sLOCK = null;

    public abstract MobileNetworkInfoDao mMobileNetworkInfoDao();

    public abstract SubscriptionInfoDao mSubscriptionInfoDao();

    public abstract UiccInfoDao mUiccInfoDao();

    public MobileNetworkDatabase() {
    }

    static {
        sLOCK = new Object();
    }

    public static MobileNetworkDatabase getInstance(Context r3) {
        Object r0 = sLOCK;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (Objects.isNull(sInstance) == false) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "createDatabase.");     // Catch: Throwable -> L10
        sInstance = (MobileNetworkDatabase) Room.inMemoryDatabaseBuilder(r3, MobileNetworkDatabase.class).fallbackToDestructiveMigration().enableMultiInstanceInvalidation().build();     // Catch: Throwable -> L10
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return sInstance;
    }

    public void insertSubsInfo(SubscriptionInfoEntity... r3) {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "insertSubInfo");
        mSubscriptionInfoDao().insertSubsInfo(r3);
    }

    public void insertUiccInfo(UiccInfoEntity... r3) {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "insertUiccInfo");
        mUiccInfoDao().insertUiccInfo(r3);
    }

    public void insertMobileNetworkInfo(MobileNetworkInfoEntity... r3) {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "insertMobileNetworkInfo");
        mMobileNetworkInfoDao().insertMobileNetworkInfo(r3);
    }

    public LiveData<List<SubscriptionInfoEntity>> queryAvailableSubInfos() {
        return mSubscriptionInfoDao().queryAvailableSubInfos();
    }

    public SubscriptionInfoEntity querySubInfoById(String r1) {
        return mSubscriptionInfoDao().querySubInfoById(r1);
    }

    public LiveData<List<MobileNetworkInfoEntity>> queryAllMobileNetworkInfo() {
        return mMobileNetworkInfoDao().queryAllMobileNetworkInfos();
    }

    public MobileNetworkInfoEntity queryMobileNetworkInfoById(String r1) {
        return mMobileNetworkInfoDao().queryMobileNetworkInfoBySubId(r1);
    }

    public LiveData<List<UiccInfoEntity>> queryAllUiccInfo() {
        return mUiccInfoDao().queryAllUiccInfos();
    }

    public LiveData<UiccInfoEntity> queryUiccInfoById(String r1) {
        return mUiccInfoDao().queryUiccInfoById(r1);
    }

    public void deleteSubInfoBySubId(String r1) {
        mSubscriptionInfoDao().deleteBySubId(r1);
    }

    public void deleteMobileNetworkInfoBySubId(String r1) {
        mMobileNetworkInfoDao().deleteBySubId(r1);
    }

    public void deleteUiccInfoBySubId(String r1) {
        mUiccInfoDao().deleteBySubId(r1);
    }
}
