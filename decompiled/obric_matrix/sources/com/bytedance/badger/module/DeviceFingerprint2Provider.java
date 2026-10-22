package com.bytedance.badger.module;

import android.content.Context;
import android.media.MediaDrm;
import com.bytedance.badger.data.BadgerResult;
import java.util.UUID;
import kotlin.a0;
import kotlin.i0.m0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class DeviceFingerprint2Provider extends BadgerModuleBase {
    public DeviceFingerprint2Provider() {
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    protected BadgerResult a(Context r7) {
        o.g(r7, "context");
        byte[] r8 = new MediaDrm(new UUID(-1301668207276963122L, -6645017420763422227L)).getPropertyByteArray("deviceUniqueId");
        o.b(r8, "mediaDrm.getPropertyByte…ROPERTY_DEVICE_UNIQUE_ID)");
        o.g(r8, "bytes");
        StringBuilder r0 = new StringBuilder(r8.length * 2);
        int r1 = r8.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        int r3 = r8[r2] & 255;
        r0.append("0123456789abcdef".charAt(r3 >> 4));
        r0.append("0123456789abcdef".charAt(r3 & 15));
        r2 = r2 + 1;
        goto L3
    L5:
        String r9 = r0.toString();
        o.b(r9, "result.toString()");
        return new BadgerResult.Success(m0.e(a0.a("value", r9)));
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public String getName() {
        return "dfp2";
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public int getPriority() {
        return 0;
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public int getRefreshIntervalSeconds() {
        return -1;
    }
}
