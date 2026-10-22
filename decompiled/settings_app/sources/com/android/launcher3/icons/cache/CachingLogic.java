package com.android.launcher3.icons.cache;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.LocaleList;
import android.os.UserHandle;
import com.android.launcher3.icons.BitmapInfo;

/* JADX INFO: loaded from: classes.dex */
public interface CachingLogic<T> {
    default boolean addToMemCache() {
        return true;
    }

    ComponentName getComponent(T r1);

    default CharSequence getDescription(T r1, CharSequence r2) {
        return r2;
    }

    default String getKeywords(T r1, LocaleList r2) {
        return null;
    }

    CharSequence getLabel(T r1);

    UserHandle getUser(T r1);

    BitmapInfo loadIcon(Context r1, T r2);

    default long getLastUpdatedTime(T r1, PackageInfo r2) {
        return r2.lastUpdateTime;
    }
}
