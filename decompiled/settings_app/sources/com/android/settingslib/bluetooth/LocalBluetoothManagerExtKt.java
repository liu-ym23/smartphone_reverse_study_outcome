package com.android.settingslib.bluetooth;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: LocalBluetoothManagerExt.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"headsetAudioModeChanges", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/android/settingslib/bluetooth/LocalBluetoothManager;", "getHeadsetAudioModeChanges", "(Lcom/android/settingslib/bluetooth/LocalBluetoothManager;)Lkotlinx/coroutines/flow/Flow;", "app_debug"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LocalBluetoothManagerExtKt {
    public static final Flow<Unit> getHeadsetAudioModeChanges(LocalBluetoothManager r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return FlowKt.callbackFlow(new LocalBluetoothManagerExtKt$headsetAudioModeChanges$1(r2, null));
    }
}
