package com.android.settings.slices;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import com.android.settings.wifi.calling.WifiCallingSliceHelper;
import com.android.settingslib.utils.ThreadUtils;

/* JADX INFO: loaded from: classes2.dex */
public class SlicesFeatureProviderImpl implements SlicesFeatureProvider {
    private SliceDataConverter mSliceDataConverter;
    private SlicesIndexer mSlicesIndexer;
    private long mUiSessionToken;

    public SlicesFeatureProviderImpl() {
    }

    @Override // com.android.settings.slices.SlicesFeatureProvider
    public SliceDataConverter getSliceDataConverter(Context r2) {
        if (this.mSliceDataConverter != null) goto L6;
        this.mSliceDataConverter = new SliceDataConverter(r2.getApplicationContext());
    L6:
        return this.mSliceDataConverter;
    }

    @Override // com.android.settings.slices.SlicesFeatureProvider
    public void newUiSession() {
        this.mUiSessionToken = SystemClock.elapsedRealtime();
    }

    @Override // com.android.settings.slices.SlicesFeatureProvider
    public long getUiSessionToken() {
        return this.mUiSessionToken;
    }

    @Override // com.android.settings.slices.SlicesFeatureProvider
    public void indexSliceDataAsync(Context r1) {
        ThreadUtils.postOnBackgroundThread(getSliceIndexer(r1));
    }

    @Override // com.android.settings.slices.SlicesFeatureProvider
    public void indexSliceData(Context r1) {
        getSliceIndexer(r1).indexSliceData();
    }

    @Override // com.android.settings.slices.SlicesFeatureProvider
    public WifiCallingSliceHelper getNewWifiCallingSliceHelper(Context r1) {
        return new WifiCallingSliceHelper(r1);
    }

    @Override // com.android.settings.slices.SlicesFeatureProvider
    public CustomSliceable getSliceableFromUri(Context r2, Uri r3) {
        Class<? extends CustomSliceable> r1 = CustomSliceRegistry.getSliceClassByUri(CustomSliceRegistry.removeParameterFromUri(r3));
        if (r1 == null) goto L7;
        return CustomSliceable.createInstance(r2, r1);
    L7:
        throw new IllegalArgumentException("No Slice found for uri: " + r3);
    }

    private SlicesIndexer getSliceIndexer(Context r2) {
        if (this.mSlicesIndexer != null) goto L6;
        this.mSlicesIndexer = new SlicesIndexer(r2.getApplicationContext());
    L6:
        return this.mSlicesIndexer;
    }
}
