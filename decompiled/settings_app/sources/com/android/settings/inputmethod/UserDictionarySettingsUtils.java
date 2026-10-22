package com.android.settings.inputmethod;

import android.content.Context;
import android.text.TextUtils;
import com.android.settings.R;
import com.android.settings.Utils;

/* JADX INFO: loaded from: classes2.dex */
public class UserDictionarySettingsUtils {
    public UserDictionarySettingsUtils() {
    }

    public static String getLocaleDisplayName(Context r1, String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return r1.getResources().getString(R.string.user_dict_settings_all_languages);
    L7:
        return Utils.createLocaleFromString(r2).getDisplayName(r1.getResources().getConfiguration().locale);
    }
}
