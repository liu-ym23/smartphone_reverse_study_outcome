package com.android.settings.revone;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.android.settings.Constants;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class StylusClickType {
    private static final String[] CLICK_SETTINGS_ID = null;
    private static final String[] SPECIFIED_APP_ID = null;
    private static final int STYLUS_DOUBLE_CLICK = 1;
    private static final int STYLUS_LONG_PRESS = 2;
    private static final int STYLUS_ONE_CLICK = 0;
    private static final int[] TITLE_ID = null;
    private int mClickId;
    private String mSettingsId;
    private int mTitleId;

    private int getType(int r1) {
        if (r1 != 144) goto L5;
        return 0;
    L5:
        if (r1 != 145) goto L7;
        return 1;
    L7:
        if (r1 == 147) goto L9;
        return -1;
    L9:
        return 2;
    }

    static {
        TITLE_ID = new int[]{R.string.one_click, R.string.double_click, R.string.long_press};
        CLICK_SETTINGS_ID = new String[]{Constants.STYLUS_CUSTOM_KEY_ONE_CLICK, Constants.STYLUS_CUSTOM_KEY_DOUBLE_CLICK, Constants.STYLUS_CUSTOM_KEY_LONG_PRESS};
        SPECIFIED_APP_ID = new String[]{Constants.STYLUS_CUSTOM_KEY_APP_ONE_CLICK, Constants.STYLUS_CUSTOM_KEY_APP_DOUBLE_CLICK, Constants.STYLUS_CUSTOM_KEY_LAUNCH_SPECIFIED_APP};
    }

    public StylusClickType(int r2) {
        this.mClickId = r2;
        int r3 = getType(r2);
        if (r3 < 0) goto L6;
        this.mTitleId = TITLE_ID[r3];
        this.mSettingsId = CLICK_SETTINGS_ID[r3];
        return;
    }

    public int getTitleId() {
        return this.mTitleId;
    }

    public String getSettingsId() {
        return this.mSettingsId;
    }

    public String getStylusAppId(Context r2) {
        if (TextUtils.isEmpty(this.mSettingsId) == false) goto L7;
        return null;
    L7:
        return Settings.Global.getString(r2.getContentResolver(), this.mSettingsId);
    }

    public String getSpecifiedAppSettingsId(Context r1) {
        int r0 = getType(this.mClickId);
        if (r0 < 0) goto L7;
        return SPECIFIED_APP_ID[r0];
    L7:
        return SPECIFIED_APP_ID[0];
    }

    public String getSpecifiedApp(Context r2) {
        String r1 = Settings.Global.getString(r2.getContentResolver(), getSpecifiedAppSettingsId(r2));
        if (r1 != null) goto L7;
        return Constants.COM_BYTEDANCE_BYTEDANCESTORE;
    L7:
        return r1;
    }
}
