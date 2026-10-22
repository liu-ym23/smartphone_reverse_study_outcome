package com.android.settingslib.bluetooth;

import android.bluetooth.BluetoothLeBroadcastMetadata;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocalBluetoothLeBroadcastMetadata.kt */
/* JADX INFO: loaded from: classes.dex */
@Deprecated(message = "Replace with BluetoothLeBroadcastMetadataExt")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/settingslib/bluetooth/LocalBluetoothLeBroadcastMetadata;", "", "()V", "metadata", "Landroid/bluetooth/BluetoothLeBroadcastMetadata;", "(Landroid/bluetooth/BluetoothLeBroadcastMetadata;)V", "convertToBroadcastMetadata", "qrCodeString", "", "convertToQrCodeString", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LocalBluetoothLeBroadcastMetadata {
    private final BluetoothLeBroadcastMetadata metadata;

    public LocalBluetoothLeBroadcastMetadata(BluetoothLeBroadcastMetadata r1) {
        this.metadata = r1;
    }

    public LocalBluetoothLeBroadcastMetadata() {
        this(null);
    }

    public final String convertToQrCodeString() {
        BluetoothLeBroadcastMetadata r1 = this.metadata;
        if (r1 == null) goto L6;
        String r2 = BluetoothLeBroadcastMetadataExt.INSTANCE.toQrCodeString(r1);
        if (r2 == null) goto L6;
        return r2;
    L6:
        return "";
    }

    public final BluetoothLeBroadcastMetadata convertToBroadcastMetadata(String r1) {
        Intrinsics.checkNotNullParameter(r1, "qrCodeString");
        return BluetoothLeBroadcastMetadataExt.INSTANCE.convertToBroadcastMetadata(r1);
    }
}
