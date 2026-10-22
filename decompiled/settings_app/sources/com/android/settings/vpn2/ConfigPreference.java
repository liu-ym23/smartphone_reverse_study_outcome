package com.android.settings.vpn2;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.preference.Preference;
import com.android.internal.net.VpnProfile;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class ConfigPreference extends ManageablePreference23 {
    private VpnProfile mProfile;
    private int mState;

    @Override // androidx.preference.Preference, java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Preference r1) {
        return compareTo(r1);
    }

    ConfigPreference(Context r1, View.OnClickListener r2, VpnProfile r3) {
        super(r1, null, r2);
        this.mState = -1;
        setIcon(R.drawable.settings_oicon_oic_rectangle_vpn);
    }

    public VpnProfile getProfile() {
        return this.mProfile;
    }

    public void setProfile(VpnProfile r3) {
        VpnProfile r0 = this.mProfile;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.name;
    L6:
        if (r3 == null) goto L9;
        r1 = r3.name;
    L9:
        if (TextUtils.equals(r2, r1) == true) goto L11;
        setTitle(r1);
        notifyHierarchyChanged();
    L11:
        this.mProfile = r3;
        return;
    L5:
        r2 = null;
        goto L6
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.preference.Preference
    public int compareTo(Preference r3) {
        if (getOrder() == Integer.MAX_VALUE) goto L7;
        return getOrder() - r3.getOrder();
    L7:
        if ((r3 instanceof ConfigPreference) == false) goto L17;
        ConfigPreference r4 = (ConfigPreference) r3;
        int r0 = r4.mState - this.mState;
        if (r0 != 0) goto L28;
        int r1 = this.mProfile.name.compareTo(r4.mProfile.name);
        if (r1 != 0) goto L29;
        int r2 = this.mProfile.type - r4.mProfile.type;
        if (r2 == 0) goto L15;
        return r2;
    L15:
        return this.mProfile.key.compareTo(r4.mProfile.key);
    L29:
        return r1;
    L28:
        return r0;
    L17:
        if ((r3 instanceof AppPreference) == false) goto L27;
        AppPreference r5 = (AppPreference) r3;
        if (this.mState != 3) goto L21;
        return -1;
    L21:
        if (r5.getState() != 3) goto L31;
        return 1;
    L31:
        return -1;
    L27:
        return super.compareTo2(r3);
    }
}
