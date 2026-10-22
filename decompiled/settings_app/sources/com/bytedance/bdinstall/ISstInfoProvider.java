package com.bytedance.bdinstall;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public interface ISstInfoProvider {
    String getDefaultImeiOrMeid(Context r1);

    String getImei(Context r1, int r2);

    String getMac(Context r1);

    String getMeid(Context r1, int r2);

    String getSerial(Context r1);

    String[] getSimSerialNumbers(Context r1);

    String reflectGetDeviceIdWithSlotIndex(Context r1, int r2);
}
