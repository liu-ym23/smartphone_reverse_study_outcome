package com.android.settings.slices;

import android.content.Context;
import android.net.Uri;
import com.android.settings.wifi.calling.WifiCallingSliceHelper;

/* JADX INFO: loaded from: classes2.dex */
public interface SlicesFeatureProvider {
    public static final boolean DEBUG = false;

    WifiCallingSliceHelper getNewWifiCallingSliceHelper(Context r1);

    SliceDataConverter getSliceDataConverter(Context r1);

    CustomSliceable getSliceableFromUri(Context r1, Uri r2);

    long getUiSessionToken();

    void indexSliceData(Context r1);

    void indexSliceDataAsync(Context r1);

    void newUiSession();
}
