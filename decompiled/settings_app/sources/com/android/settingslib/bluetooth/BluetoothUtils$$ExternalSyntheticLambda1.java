package com.android.settingslib.bluetooth;

import android.bluetooth.BluetoothLeBroadcastReceiveState;
import java.util.function.Predicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BluetoothUtils$$ExternalSyntheticLambda1 implements Predicate {
    public /* synthetic */ BluetoothUtils$$ExternalSyntheticLambda1() {
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object r1) {
        return BluetoothUtils.isConnected((BluetoothLeBroadcastReceiveState) r1);
    }
}
