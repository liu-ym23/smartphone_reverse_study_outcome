package com.android.settings.vpn2;

import com.android.internal.util.Preconditions;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
class AppVpnInfo implements Comparable {
    public final String packageName;
    public final int userId;

    public AppVpnInfo(int r1, String r2) {
        this.userId = r1;
        this.packageName = (String) Preconditions.checkNotNull(r2);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object r3) {
        AppVpnInfo r4 = (AppVpnInfo) r3;
        int r0 = this.packageName.compareTo(r4.packageName);
        if (r0 == 0) goto L5;
        return r0;
    L5:
        return r4.userId - this.userId;
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof AppVpnInfo) == false) goto L10;
        AppVpnInfo r5 = (AppVpnInfo) r4;
        if (this.userId == r5.userId) goto L7;
        return false;
    L7:
        if (Objects.equals(this.packageName, r5.packageName) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.packageName, Integer.valueOf(this.userId)});
    }
}
