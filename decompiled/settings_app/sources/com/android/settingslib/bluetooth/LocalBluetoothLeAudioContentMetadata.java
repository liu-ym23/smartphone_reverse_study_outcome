package com.android.settingslib.bluetooth;

import android.bluetooth.BluetoothLeAudioContentMetadata;

/* JADX INFO: loaded from: classes.dex */
public class LocalBluetoothLeAudioContentMetadata {
    private static final String TAG = "LocalBluetoothLeAudioContentMetadata";
    private final BluetoothLeAudioContentMetadata mContentMetadata;
    private final String mLanguage;
    private String mProgramInfo;
    private final byte[] mRawMetadata;

    LocalBluetoothLeAudioContentMetadata(BluetoothLeAudioContentMetadata r2) {
        this.mContentMetadata = r2;
        this.mProgramInfo = r2.getProgramInfo();
        this.mLanguage = r2.getLanguage();
        this.mRawMetadata = r2.getRawMetadata();
    }

    public void setProgramInfo(String r1) {
        this.mProgramInfo = r1;
    }

    public String getProgramInfo() {
        return this.mProgramInfo;
    }
}
