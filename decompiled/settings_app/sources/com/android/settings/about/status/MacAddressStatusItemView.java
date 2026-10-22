package com.android.settings.about.status;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.util.AttributeSet;
import androidx.lifecycle.Lifecycle;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.about.DeviceStatusItemView;
import com.android.settings.utils.ResourceUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MacAddressStatusItemView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000*\u0001\f\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\b\u0010\u000e\u001a\u00020\u000fH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/android/settings/about/status/MacAddressStatusItemView;", "Lcom/android/settings/about/DeviceStatusItemView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "(Landroid/content/Context;Landroid/util/AttributeSet;ILandroidx/lifecycle/Lifecycle;)V", "mConnectivityReceiver", "com/android/settings/about/status/MacAddressStatusItemView$mConnectivityReceiver$1", "Lcom/android/settings/about/status/MacAddressStatusItemView$mConnectivityReceiver$1;", "updateMacAddress", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MacAddressStatusItemView extends DeviceStatusItemView {
    private final Lifecycle lifecycle;
    private final MacAddressStatusItemView$mConnectivityReceiver$1 mConnectivityReceiver;

    public MacAddressStatusItemView(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, null, 0, null, 14, null);
    }

    public MacAddressStatusItemView(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, 0, null, 12, null);
    }

    public MacAddressStatusItemView(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, r11, null, 8, null);
    }

    public /* synthetic */ MacAddressStatusItemView(Context r2, AttributeSet r3, int r4, Lifecycle r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = null;
    L11:
        this(r2, r3, r4, r5);
    }

    public static final /* synthetic */ MacAddressStatusItemView$mConnectivityReceiver$1 access$getMConnectivityReceiver$p(MacAddressStatusItemView r0) {
        return r0.mConnectivityReceiver;
    }

    public static final /* synthetic */ void access$updateMacAddress(MacAddressStatusItemView r0) {
        r0.updateMacAddress();
    }

    public MacAddressStatusItemView(Context r10, AttributeSet r11, int r12, Lifecycle r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12, r13, 0, 16, null);
        this.lifecycle = r13;
        this.mConnectivityReceiver = new MacAddressStatusItemView$mConnectivityReceiver$1(this);
        if (r13 == null) goto L6;
        r13.addObserver(new AnonymousClass1(this));
        return;
    }

    private final void updateMacAddress() {
        Object r0 = SettingsApplication.getContext().getSystemService("wifi");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        String[] r1 = ((WifiManager) r0).getFactoryMacAddresses();
        boolean r2 = false;
        if (r1 != null) goto L5;
    L11:
        boolean r3 = true;
    L12:
        String r4 = null;
        if (r3 == true) goto L15;
        String r5 = r1[0];
    L16:
        if (r5 != null) goto L18;
    L24:
        r4 = ResourceUtils.getString(R.string.device_info_not_available_mac);
    L25:
        initData(ResourceUtils.getString(R.string.wifi_advanced_mac_address_title), r4);
        return;
    L18:
        if (r5.length() != 0) goto L21;
        r2 = true;
    L21:
        if ((!r2) == false) goto L23;
        r4 = r5;
    L23:
        if (r4 != null) goto L25;
    L15:
        r5 = null;
        goto L16
    L5:
        if (r1.length != 0) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == true) goto L11;
        r3 = false;
        goto L12
    L7:
        r6 = false;
        goto L8
    }
}
