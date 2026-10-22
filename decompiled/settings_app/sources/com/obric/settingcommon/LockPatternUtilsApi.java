package com.obric.settingcommon;

import android.os.UserHandle;
import com.android.internal.widget.LockPatternUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class LockPatternUtilsApi {
    public LockPatternUtilsApi() {
    }

    static boolean isSecure(LockPatternUtils r1) {
        return r1.isSecure(UserHandle.myUserId());
    }

    static boolean isVisiblePatternEnabled(LockPatternUtils r1) {
        return r1.isVisiblePatternEnabled(UserHandle.myUserId());
    }

    static void setVisiblePatternEnabled(LockPatternUtils r1, boolean r2) {
        r1.setVisiblePatternEnabled(r2, UserHandle.myUserId());
    }
}
