package com.bytedance.badger.data;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/badger/data/BadgerNativeUpdateCallback;", "", "Lcom/bytedance/badger/data/BadgerUpdateInfo;", LocationMonitorConst.INFO, "Lkotlin/f0;", "onUpdate", "(Lcom/bytedance/badger/data/BadgerUpdateInfo;)V", "badger-api_release"}, k = 1, mv = {1, 1, 15})
public interface BadgerNativeUpdateCallback {
    void onUpdate(BadgerUpdateInfo r1);
}
