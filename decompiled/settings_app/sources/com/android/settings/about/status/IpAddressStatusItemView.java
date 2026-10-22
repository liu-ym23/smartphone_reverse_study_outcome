package com.android.settings.about.status;

import android.content.Context;
import android.icu.lang.UCharacter;
import android.net.ConnectivityManager;
import android.util.AttributeSet;
import androidx.lifecycle.Lifecycle;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.Utils;
import com.android.settings.about.DeviceStatusItemView;
import com.android.settings.utils.ResourceUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IpAddressStatusItemView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000*\u0001\f\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\b\u0010\u000e\u001a\u00020\u000fH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/android/settings/about/status/IpAddressStatusItemView;", "Lcom/android/settings/about/DeviceStatusItemView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "(Landroid/content/Context;Landroid/util/AttributeSet;ILandroidx/lifecycle/Lifecycle;)V", "mConnectivityReceiver", "com/android/settings/about/status/IpAddressStatusItemView$mConnectivityReceiver$1", "Lcom/android/settings/about/status/IpAddressStatusItemView$mConnectivityReceiver$1;", "updateIpAddress", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class IpAddressStatusItemView extends DeviceStatusItemView {
    private final Lifecycle lifecycle;
    private final IpAddressStatusItemView$mConnectivityReceiver$1 mConnectivityReceiver;

    public IpAddressStatusItemView(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, null, 0, null, 14, null);
    }

    public IpAddressStatusItemView(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, 0, null, 12, null);
    }

    public IpAddressStatusItemView(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, r11, null, 8, null);
    }

    public /* synthetic */ IpAddressStatusItemView(Context r2, AttributeSet r3, int r4, Lifecycle r5, int r6, DefaultConstructorMarker r7) {
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

    public static final /* synthetic */ IpAddressStatusItemView$mConnectivityReceiver$1 access$getMConnectivityReceiver$p(IpAddressStatusItemView r0) {
        return r0.mConnectivityReceiver;
    }

    public static final /* synthetic */ void access$updateIpAddress(IpAddressStatusItemView r0) {
        r0.updateIpAddress();
    }

    public IpAddressStatusItemView(Context r8, AttributeSet r9, int r10, Lifecycle r11) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10, r11, UCharacter.UnicodeBlock.SORA_SOMPENG_ID);
        this.lifecycle = r11;
        this.mConnectivityReceiver = new IpAddressStatusItemView$mConnectivityReceiver$1(this);
        if (r11 == null) goto L6;
        r11.addObserver(new AnonymousClass1(this));
        return;
    }

    private final void updateIpAddress() {
        Object r0 = SettingsApplication.getContext().getSystemService("connectivity");
        String r2 = null;
        if ((r0 instanceof ConnectivityManager) == false) goto L5;
        ConnectivityManager r1 = (ConnectivityManager) r0;
    L6:
        if (r1 == null) goto L8;
        r2 = Utils.getDefaultIpAddresses(r1);
    L8:
        if (r2 != null) goto L10;
        r2 = ResourceUtils.getString(R.string.device_info_not_available_ip);
    L10:
        initData(ResourceUtils.getString(R.string.wifi_advanced_ip_address_title), r2);
        return;
    L5:
        r1 = null;
        goto L6
    }
}
