package com.android.settings.bluetooth;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.Intent;
import android.os.UserManager;
import com.android.settings.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RequestPermissionHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002\u001a\u001e\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002\u001a\f\u0010\b\u001a\u00020\t*\u00020\u0002H\u0002¨\u0006\n"}, d2 = {"getDisableMessage", "", "Landroid/content/Context;", "name", "", "getEnableMessage", "timeout", "", "isDisallowBluetooth", "", "app_neridaCnRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class RequestPermissionHelperKt {
    public static final /* synthetic */ String access$getDisableMessage(Context r0, CharSequence r1) {
        return getDisableMessage(r0, r1);
    }

    public static final /* synthetic */ String access$getEnableMessage(Context r0, int r1, CharSequence r2) {
        return getEnableMessage(r0, r1, r2);
    }

    public static final /* synthetic */ boolean access$isDisallowBluetooth(Context r0) {
        return isDisallowBluetooth(r0);
    }

    private static final boolean isDisallowBluetooth(Context r2) {
        Object r0 = r2.getSystemService(UserManager.class);
        Intrinsics.checkNotNull(r0);
        if (((UserManager) r0).hasUserRestriction("no_bluetooth") == false) goto L8;
        Object r1 = r2.getSystemService(DevicePolicyManager.class);
        Intrinsics.checkNotNull(r1);
        Intent r3 = ((DevicePolicyManager) r1).createAdminSupportIntent("no_bluetooth");
        if (r3 == null) goto L7;
        r3.setPackage(r2.getPackageName());
        r2.startActivity(r3);
    L7:
        return true;
    L8:
        return false;
    }

    private static final String getEnableMessage(Context r3, int r4, CharSequence r5) {
        if (r4 >= 0) goto L8;
        if (r5 != null) goto L6;
        String r6 = r3.getString(R.string.bluetooth_ask_enablement_no_name);
    L7:
        Intrinsics.checkNotNull(r6);
    L17:
        return r6;
    L6:
        r6 = r3.getString(R.string.bluetooth_ask_enablement, new Object[]{r5});
        goto L7
    L8:
        if (r4 != 0) goto L13;
        if (r5 != null) goto L11;
        r6 = r3.getString(R.string.bluetooth_ask_enablement_and_lasting_discovery_no_name);
    L12:
        Intrinsics.checkNotNull(r6);
        goto L17
    L11:
        r6 = r3.getString(R.string.bluetooth_ask_enablement_and_lasting_discovery, new Object[]{r5});
        goto L12
    L13:
        if (r5 != null) goto L15;
        r6 = r3.getString(R.string.bluetooth_ask_enablement_and_discovery_no_name, new Object[]{Integer.valueOf(r4)});
    L16:
        Intrinsics.checkNotNull(r6);
        goto L17
    L15:
        r6 = r3.getString(R.string.bluetooth_ask_enablement_and_discovery, new Object[]{r5, Integer.valueOf(r4)});
        goto L16
    }

    private static final String getDisableMessage(Context r3, CharSequence r4) {
        if (r4 != null) goto L5;
        String r5 = r3.getString(R.string.bluetooth_ask_disablement_no_name);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
        return r5;
    L5:
        String r6 = r3.getString(R.string.bluetooth_ask_disablement, new Object[]{r4});
        Intrinsics.checkNotNullExpressionValue(r6, "getString(...)");
        return r6;
    }
}
