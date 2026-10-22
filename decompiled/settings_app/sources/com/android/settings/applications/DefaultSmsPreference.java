package com.android.settings.applications;

import android.content.ComponentName;
import android.content.Context;
import android.os.UserHandle;
import android.os.UserManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.android.internal.telephony.SmsApplication;
import com.android.settings.AppListPreference;
import com.android.settings.MultiSimAdapter;
import com.android.settings.SelfAvailablePreference;
import com.android.settings.utils.NullSafe;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultSmsPreference extends AppListPreference implements SelfAvailablePreference {
    public DefaultSmsPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
        loadSmsApps();
    }

    private void loadSmsApps() {
        Collection r0 = SmsApplication.getApplicationCollection(getContext());
        String[] r1 = new String[r0.size()];
        Iterator r2 = r0.iterator();
        int r3 = 0;
    L4:
        if (r2.hasNext() == false) goto L6;
        r1[r3] = ((SmsApplication.SmsApplicationData) r2.next()).mPackageName;
        r3 = r3 + 1;
        goto L4
    L6:
        setPackageNames(r1, getDefaultPackage());
    }

    private String getDefaultPackage() {
        ComponentName r1 = SmsApplication.getDefaultSmsApplication(getContext(), true);
        if (r1 != null) goto L5;
        return null;
    L5:
        return r1.getPackageName();
    }

    @Override // androidx.preference.Preference
    protected boolean persistString(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L7:
        setSummary(getEntry());
        return true;
    L5:
        if (Objects.equals(r2, getDefaultPackage()) == true) goto L7;
        SmsApplication.setDefaultApplication(r2, getContext());
        goto L7
    }

    @Override // com.android.settings.SelfAvailablePreference
    public boolean isAvailable(Context r2) {
        boolean r1 = UserManager.get(r2).getUserInfo(UserHandle.myUserId()).isRestricted();
        TelephonyManager r3 = (TelephonyManager) NullSafe.nonNull(r2.getSystemService(MultiSimAdapter.PHONE_KEY));
        if (r1 == false) goto L5;
    L7:
        return false;
    L5:
        if (r3.isSmsCapable() == false) goto L7;
        return true;
    }

    public static boolean hasSmsPreference(String r1, Context r2) {
        Iterator r3 = SmsApplication.getApplicationCollection(r2).iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (((SmsApplication.SmsApplicationData) r3.next()).mPackageName.equals(r1) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public static boolean isSmsDefault(String r1, Context r2) {
        ComponentName r3 = SmsApplication.getDefaultSmsApplication(r2, true);
        if (r3 != null) goto L5;
    L7:
        return false;
    L5:
        if (r3.getPackageName().equals(r1) == false) goto L7;
        return true;
    }
}
