package com.ttnet.org.chromium.base.compat;

import android.view.Window;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(27)
public final class ApiHelperForOMR1 {
    private ApiHelperForOMR1() {
    }

    public static boolean isWideColorGamut(Window r0) {
        return r0.isWideColorGamut();
    }
}
