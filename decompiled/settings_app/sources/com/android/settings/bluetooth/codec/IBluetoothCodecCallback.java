package com.android.settings.bluetooth.codec;

import android.bluetooth.BluetoothCodecConfig;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: IBluetoothCodecCallback.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J<\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH&¨\u0006\u0017"}, d2 = {"Lcom/android/settings/bluetooth/codec/IBluetoothCodecCallback;", "", "onBluetoothServiceConnected", "", "connected", "", "onCodecCapabilitiesQueried", "currentCodecType", "", "supportedSampleRates", "", "supportedBitsPerSample", "currentSampleRate", "currentBitsPerSample", "onCodecCapabilitiesQueriedFailed", "errorMessage", "", "onCodecConfigQueried", "currentCodecConfig", "Landroid/bluetooth/BluetoothCodecConfig;", "onCodecConfigQueriedFailed", "onCodecConfigSetFailed", "onCodecConfigSetSuccess", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface IBluetoothCodecCallback {
    void onBluetoothServiceConnected(boolean r1);

    void onCodecCapabilitiesQueried(int r1, List<Integer> r2, List<Integer> r3, int r4, int r5);

    void onCodecCapabilitiesQueriedFailed(String r1);

    void onCodecConfigQueried(BluetoothCodecConfig r1);

    void onCodecConfigQueriedFailed(String r1);

    void onCodecConfigSetFailed(String r1);

    void onCodecConfigSetSuccess(int r1, int r2);
}
