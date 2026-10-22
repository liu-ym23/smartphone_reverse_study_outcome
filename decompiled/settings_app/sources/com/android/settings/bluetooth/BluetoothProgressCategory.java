package com.android.settings.bluetooth;

import android.content.Context;
import android.util.AttributeSet;
import com.android.settings.ProgressCategory;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class BluetoothProgressCategory extends ProgressCategory {
    public BluetoothProgressCategory(Context r3, AttributeSet r4) {
        super(r3, r4, R.string.bluetooth_searching_for_devices, true);
    }
}
