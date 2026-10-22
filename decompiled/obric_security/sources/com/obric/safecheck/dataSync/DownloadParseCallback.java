package com.obric.safecheck.dataSync;

import com.obric.safecheck.data.ParsedData;
import com.obric.safecheck.database.entity.Item;

/* JADX INFO: loaded from: classes4.dex */
public interface DownloadParseCallback {
    void onAllCompleted();

    void onFailure(int taskIndex, String taskUrl, Throwable e);

    void onStartNextTask(int taskIndex, String taskUrl);

    void onSuccess(ParsedData<? extends Item> data);

    void onSuccess(String taskUrl);
}
