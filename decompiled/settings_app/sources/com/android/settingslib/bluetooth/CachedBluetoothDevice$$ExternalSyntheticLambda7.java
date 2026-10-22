package com.android.settingslib.bluetooth;

import java.util.function.Function;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CachedBluetoothDevice$$ExternalSyntheticLambda7 implements Function {
    public /* synthetic */ CachedBluetoothDevice$$ExternalSyntheticLambda7() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object r1) {
        return Integer.valueOf(((CachedBluetoothDevice) r1).getBatteryLevel());
    }
}
