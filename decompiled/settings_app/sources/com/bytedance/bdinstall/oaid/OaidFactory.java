package com.bytedance.bdinstall.oaid;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
final class OaidFactory {
    OaidFactory() {
    }

    static OaidApi createOaidImpl(Context r0) {
        return new ObricOaidImpl();
    }
}
