package com.android.settings;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.widget.TextView;
import bytedanceos.util.Features;
import com.android.settings.utils.ResourceUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class ScreenTimeoutController {
    public static final int FALLBACK_SCREEN_TIMEOUT_VALUE = 60000;
    public static final int MEETING_FALLBACK_SCREEN_TIMEOUT_VALUE = 900000;
    public static final int TABLET_FALLBACK_SCREEN_TIMEOUT_VALUE = 600000;
    private static final String TAG = "ScreenTimeout";
    public static final int TYPE_MEETING = 2;
    public static final int TYPE_PHONE = 0;
    public static final int TYPE_TABLET = 1;
    public boolean lockTimeoutLessThanAll;
    private OCardListItem mCardListItem;
    private Context mContext;
    private int mDefTimeout;
    private String mScreenOffSettingsKey;
    private final ContentObserver mTimeoutObserver;
    private TextView mTips;
    private int mType;

    public ScreenTimeoutController(Context r3, OCardListItem r4, TextView r5, int r6) {
        this.lockTimeoutLessThanAll = false;
        final Handler r1 = new Handler();
        this.mTimeoutObserver = new AnonymousClass1(this, r1);
        this.mContext = r3;
        this.mCardListItem = r4;
        this.mTips = r5;
        this.mType = r6;
        if (r6 != 0) goto L5;
        this.mScreenOffSettingsKey = PageConstants.LAUNCH_PAGE_SCREEN_OFF_TIMEOUT;
        this.mDefTimeout = 60000;
        return;
    L5:
        if (r6 != 1) goto L7;
        this.mScreenOffSettingsKey = "revone_screen_off_timeout";
        this.mDefTimeout = 600000;
        return;
    L7:
        if (r6 != 2) goto L10;
        this.mScreenOffSettingsKey = PageConstants.LAUNCH_PAGE_SCREEN_OFF_TIMEOUT;
        this.mDefTimeout = 900000;
        return;
    L10:
        throw new IllegalArgumentException("unsupported screen off type " + r6);
    }

    private int getCurrentTimeOutIndex(long r5) {
        String[] r4 = getValues();
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= r4.length) goto L9;
        if (r5 < Long.parseLong(r4[r0])) goto L8;
        r1 = r0;
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        return r1;
    }

    public int getCurrentTimeout() {
        return android.provider.Settings.System.getInt(this.mContext.getContentResolver(), this.mScreenOffSettingsKey, this.mDefTimeout);
    }

    public void updateTimeoutItem() {
        int r0 = getCurrentTimeout();
        OLog.i(TAG, "Settings get screen timeout key = " + this.mScreenOffSettingsKey + ", value = " + r0);
        if (r0 > 0) goto L5;
        android.provider.Settings.System.putInt(this.mContext.getContentResolver(), this.mScreenOffSettingsKey, this.mDefTimeout);
        r0 = this.mDefTimeout;
    L5:
        String[] r1 = getEntries();
        final long r2 = ((DevicePolicyManager) SettingsApplication.getContext().getSystemService("device_policy")).getMaximumTimeToLock(null);
        if (r2 <= 0) goto L29;
        String[] r3 = (String[]) Arrays.stream(getValues()).filter(new ScreenTimeoutController$$ExternalSyntheticLambda0(r2)).toArray(new ScreenTimeoutController$$ExternalSyntheticLambda1());
        String[] r4 = (String[]) Arrays.copyOf(r1, r3.length);
        int r5 = -1;
        int r6 = 0;
    L9:
        if (r6 >= r3.length) goto L14;
        if (r0 < Long.parseLong(r3[r6])) goto L13;
        r5 = r6;
    L13:
        r6 = r6 + 1;
        goto L9
    L14:
        if (r5 < 0) goto L16;
        int r7 = Integer.parseInt(r3[r5]);
    L17:
        if (r7 <= 0) goto L28;
        android.provider.Settings.System.putInt(this.mContext.getContentResolver(), this.mScreenOffSettingsKey, r7);
        int r8 = getCurrentTimeOutIndex(r7);
        if (r8 != (r4.length - 1)) goto L26;
        int r9 = this.mType;
        if (r9 == 2) goto L25;
        if (r9 == 1) goto L25;
        if (Features.isFeatureUSEnabled(this.mContext).booleanValue() == false) goto L26;
    L25:
        String r10 = r4[r8];
    L27:
        this.mTips.setText(r10);
    L39:
        this.mCardListItem.setCustomEndView(this.mTips);
        return;
    L26:
        r10 = this.mContext.getString(R.string.screen_timeout_summary, new Object[]{r4[r8]});
        goto L27
    L28:
        this.mTips.setText(ResourceUtils.getString(R.string.disabled_by_policy_title));
        this.lockTimeoutLessThanAll = true;
        goto L39
    L16:
        r7 = 0;
        goto L17
    L29:
        int r11 = getCurrentTimeOutIndex(r0);
        if (r11 != (r1.length - 1)) goto L37;
        int r12 = this.mType;
        if (r12 == 2) goto L36;
        if (r12 == 1) goto L36;
        if (Features.isFeatureUSEnabled(this.mContext).booleanValue() == false) goto L37;
    L36:
        String r13 = r1[r11];
    L38:
        this.mTips.setText(r13);
    L37:
        r13 = this.mContext.getString(R.string.screen_timeout_summary, new Object[]{r1[r11]});
        goto L38
    }

    static /* synthetic */ boolean lambda$updateTimeoutItem$0(long r2, String r4) {
        if (Long.parseLong(r4) > r2) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ String[] lambda$updateTimeoutItem$1(int r0) {
        return new String[r0];
    }

    public String[] getEntries() {
        int r0 = this.mType;
        if (r0 != 2) goto L6;
        return this.mContext.getResources().getStringArray(R.array.meeting_screen_timeout_entries);
    L6:
        if (r0 == 1) goto L21;
        String[] r1 = this.mContext.getResources().getStringArray(R.array.screen_timeout_entries);
        String[] r2 = this.mContext.getResources().getStringArray(R.array.screen_timeout_values);
        if (r1.length != r2.length) goto L19;
        if (Features.isFeatureUSEnabled(this.mContext).booleanValue() == true) goto L13;
        String[] r5 = (String[]) Arrays.copyOf(r1, r1.length - 1);
    L15:
        if (r2[0].equals("15000") == true) goto L17;
        return r5;
    L17:
        return (String[]) Arrays.copyOfRange(r5, 1, r5.length);
    L13:
        r5 = r1;
        goto L15
    L19:
        throw new IllegalArgumentException("entries len=" + r1.length + " but values len=" + r2.length);
    L21:
        return this.mContext.getResources().getStringArray(R.array.revone_screen_timeout_entries);
    }

    public String[] getValues() {
        int r0 = this.mType;
        if (r0 != 2) goto L6;
        return this.mContext.getResources().getStringArray(R.array.meeting_screen_timeout_values);
    L6:
        if (r0 == 1) goto L17;
        String[] r1 = this.mContext.getResources().getStringArray(R.array.screen_timeout_values);
        if (Features.isFeatureUSEnabled(this.mContext).booleanValue() == true) goto L11;
        String[] r3 = (String[]) Arrays.copyOf(r1, r1.length - 1);
    L13:
        if (r3[0].equals("15000") == true) goto L15;
        return r3;
    L15:
        return (String[]) Arrays.copyOfRange(r3, 1, r3.length);
    L11:
        r3 = r1;
        goto L13
    L17:
        return this.mContext.getResources().getStringArray(R.array.revone_screen_timeout_values);
    }

    public void onResume() {
        this.mContext.getContentResolver().registerContentObserver(android.provider.Settings.System.getUriFor(this.mScreenOffSettingsKey), true, this.mTimeoutObserver);
    }

    public void onPause() {
        this.mContext.getContentResolver().unregisterContentObserver(this.mTimeoutObserver);
    }
}
