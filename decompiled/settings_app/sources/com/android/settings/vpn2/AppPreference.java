package com.android.settings.vpn2;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.UserHandle;
import android.view.View;
import androidx.preference.Preference;
import com.android.internal.net.VpnConfig;

/* JADX INFO: loaded from: classes2.dex */
public class AppPreference extends ManageablePreference23 {
    public static final int STATE_CONNECTED = 3;
    public static final int STATE_DISCONNECTED = 0;
    private String mName;
    private String mPackageName;
    private int mUid;

    @Override // androidx.preference.Preference, java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Preference r1) {
        return compareTo(r1);
    }

    static {
        STATE_DISCONNECTED = STATE_NONE;
    }

    public AppPreference(Context r3, View.OnClickListener r4, String r5, int r6) {
        Drawable r0 = null;
        super(r3, null, r4);
        this.mPackageName = r5;
        this.mUid = r6;
        Context r7 = getUserContext();     // Catch: PackageManager.NameNotFoundException -> L16
        PackageManager r8 = r7.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L16
        if (r8 != null) goto L19;
        return;
    L19:
        PackageInfo r9 = r8.getPackageInfo(this.mPackageName, 0);     // Catch: PackageManager.NameNotFoundException -> L15
        if (r9 == null) goto L11;
        r0 = r9.applicationInfo.loadIcon(r8);     // Catch: PackageManager.NameNotFoundException -> L15
        CharSequence r10 = VpnConfig.getVpnLabel(r7, this.mPackageName);     // Catch: PackageManager.NameNotFoundException -> L15
        if (r10 == null) goto L11;
        r5 = r10.toString();     // Catch: PackageManager.NameNotFoundException -> L15
    L11:
        if (r0 != null) goto L13;
        r0 = r8.getDefaultActivityIcon();     // Catch: PackageManager.NameNotFoundException -> L16
    L13:
        this.mName = r5;
        setTitle(r5);
        setIcon(r0);
    }

    public PackageInfo getPackageInfo() {
        PackageManager r1 = getUserContext().getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L8
        if (r1 == null) goto L11;
        return r1.getPackageInfo(this.mPackageName, 0);
    L11:
        return null;
    L12:
        return null;
    }

    public String getLabel() {
        return this.mName;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public int getUid() {
        return this.mUid;
    }

    private Context getUserContext() throws PackageManager.NameNotFoundException {
        UserHandle r0 = new UserHandle(UserHandle.getUserId(this.mUid));
        return getContext().createPackageContextAsUser(getContext().getPackageName(), 0, r0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.preference.Preference
    public int compareTo(Preference r3) {
        if (getOrder() == Integer.MAX_VALUE) goto L7;
        return getOrder() - r3.getOrder();
    L7:
        if ((r3 instanceof AppPreference) == false) goto L17;
        AppPreference r4 = (AppPreference) r3;
        int r0 = r4.mState - this.mState;
        if (r0 != 0) goto L22;
        int r1 = this.mName.compareToIgnoreCase(r4.mName);
        if (r1 != 0) goto L23;
        int r2 = this.mPackageName.compareTo(r4.mPackageName);
        if (r2 == 0) goto L15;
        return r2;
    L15:
        return this.mUid - r4.mUid;
    L23:
        return r1;
    L22:
        return r0;
    L17:
        if ((r3 instanceof ConfigPreference) == false) goto L21;
        return -((ConfigPreference) r3).compareTo(this);
    L21:
        return super.compareTo2(r3);
    }
}
