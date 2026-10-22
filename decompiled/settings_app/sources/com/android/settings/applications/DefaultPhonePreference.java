package com.android.settings.applications;

import android.content.Context;
import android.os.UserHandle;
import android.os.UserManager;
import android.telecom.DefaultDialerManager;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.android.settings.AppListPreference;
import com.android.settings.MultiSimAdapter;
import com.android.settings.SelfAvailablePreference;
import com.android.settings.utils.NullSafe;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultPhonePreference extends AppListPreference implements SelfAvailablePreference {
    private final Context mContext;

    public DefaultPhonePreference(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mContext = r1.getApplicationContext();
        loadDialerApps();
    }

    @Override // androidx.preference.Preference
    protected boolean persistString(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
    L7:
        setSummary(getEntry());
        return true;
    L5:
        if (Objects.equals(r3, getDefaultPackage()) == true) goto L7;
        DefaultDialerManager.setDefaultDialerApplication(getContext(), r3, this.mUserId);
        goto L7
    }

    private void loadDialerApps() {
        List r0 = DefaultDialerManager.getInstalledDialerApplications(getContext(), this.mUserId);
        String[] r1 = new String[r0.size()];
        int r2 = 0;
    L4:
        if (r2 >= r0.size()) goto L6;
        r1[r2] = (String) r0.get(r2);
        r2 = r2 + 1;
        goto L4
    L6:
        setPackageNames(r1, getDefaultPackage(), getSystemPackage());
    }

    private String getDefaultPackage() {
        return DefaultDialerManager.getDefaultDialerApplication(getContext(), this.mUserId);
    }

    private String getSystemPackage() {
        return ((TelecomManager) NullSafe.nonNull(TelecomManager.from(getContext()))).getSystemDialerPackage();
    }

    @Override // com.android.settings.SelfAvailablePreference
    public boolean isAvailable(Context r1) {
        if (((TelephonyManager) r1.getSystemService(MultiSimAdapter.PHONE_KEY)).isVoiceCapable() == true) goto L7;
        return false;
    L7:
        return !((UserManager) r1.getSystemService(PickApplicationActivity.EXTRA_USER)).hasUserRestriction("no_outgoing_calls");
    }

    public static boolean hasPhonePreference(String r1, Context r2) {
        return DefaultDialerManager.getInstalledDialerApplications(r2, UserHandle.myUserId()).contains(r1);
    }

    public static boolean isPhoneDefault(String r1, Context r2) {
        String r3 = DefaultDialerManager.getDefaultDialerApplication(r2, UserHandle.myUserId());
        if (r3 != null) goto L5;
    L7:
        return false;
    L5:
        if (r3.equals(r1) == false) goto L7;
        return true;
    }
}
