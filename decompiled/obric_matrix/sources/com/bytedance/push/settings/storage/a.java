package com.bytedance.push.settings.storage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
final class a implements e {
    a() {
    }

    static Bundle c(String r2, String r3) {
        Bundle r0 = new Bundle();
        r0.putString("_storage_key", r2);
        r0.putString("_key", r3);
        return r0;
    }

    static boolean d(Bundle r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return r1.getBoolean("_result");
    }

    @Override // com.bytedance.push.settings.storage.e
    public String a() {
        return "_contains";
    }

    @Override // com.bytedance.push.settings.storage.e
    public Bundle b(Context r3, String r4, Bundle r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        String r6 = r5.getString("_storage_key");
        String r7 = r5.getString("_key");
        if (TextUtils.isEmpty(r6) == false) goto L8;
        return null;
    L8:
        if (TextUtils.isEmpty(r7) == true) goto L13;
        Bundle r2 = new Bundle();
        r2.putBoolean("_result", com.bytedance.push.settings.e.a().a(r3, true, r6).contains(r7));
        return r2;
    L13:
        return null;
    }
}
