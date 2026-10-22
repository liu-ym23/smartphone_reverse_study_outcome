package com.android.settings.about.status;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.util.AttributeSet;
import androidx.lifecycle.Lifecycle;
import com.android.settings.R;
import com.android.settings.about.DeviceStatusItemView;
import com.android.settings.utils.ResourceUtils;
import com.android.settings.utils.ThreadUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BluetoothAddressStatusItemView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000*\u0001\f\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\b\u0010\u000e\u001a\u00020\u000fH\u0003R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/android/settings/about/status/BluetoothAddressStatusItemView;", "Lcom/android/settings/about/DeviceStatusItemView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "(Landroid/content/Context;Landroid/util/AttributeSet;ILandroidx/lifecycle/Lifecycle;)V", "mConnectivityReceiver", "com/android/settings/about/status/BluetoothAddressStatusItemView$mConnectivityReceiver$1", "Lcom/android/settings/about/status/BluetoothAddressStatusItemView$mConnectivityReceiver$1;", "updateBluetoothAddress", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BluetoothAddressStatusItemView extends DeviceStatusItemView {
    private final Lifecycle lifecycle;
    private final BluetoothAddressStatusItemView$mConnectivityReceiver$1 mConnectivityReceiver;

    public static /* synthetic */ void $r8$lambda$3bBAqy6orMmbfCF3IckxFLOZJFU(BluetoothAdapter r0, BluetoothAddressStatusItemView r1) {
        updateBluetoothAddress$lambda$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$lKOR4HpMOKDRh5iwqaAGVymEWo8(BluetoothAddressStatusItemView r0, String r1) {
        updateBluetoothAddress$lambda$2$lambda$1(r0, r1);
    }

    public BluetoothAddressStatusItemView(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, null, 0, null, 14, null);
    }

    public BluetoothAddressStatusItemView(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, 0, null, 12, null);
    }

    public BluetoothAddressStatusItemView(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, r11, null, 8, null);
    }

    public /* synthetic */ BluetoothAddressStatusItemView(Context r2, AttributeSet r3, int r4, Lifecycle r5, int r6, DefaultConstructorMarker r7) {
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

    public static final /* synthetic */ BluetoothAddressStatusItemView$mConnectivityReceiver$1 access$getMConnectivityReceiver$p(BluetoothAddressStatusItemView r0) {
        return r0.mConnectivityReceiver;
    }

    public static final /* synthetic */ void access$updateBluetoothAddress(BluetoothAddressStatusItemView r0) {
        r0.updateBluetoothAddress();
    }

    public BluetoothAddressStatusItemView(Context r10, AttributeSet r11, int r12, Lifecycle r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12, r13, 0, 16, null);
        this.lifecycle = r13;
        this.mConnectivityReceiver = new BluetoothAddressStatusItemView$mConnectivityReceiver$1(this);
        if (r13 == null) goto L5;
        r13.addObserver(new AnonymousClass1(this));
    L5:
        initData(ResourceUtils.getString(R.string.status_bt_address), ResourceUtils.getString(R.string.device_info_not_available_bt));
    }

    private final void updateBluetoothAddress() {
        final BluetoothAdapter r0 = BluetoothAdapter.getDefaultAdapter();
        ThreadUtils.postOnBackgroundThread(new BluetoothAddressStatusItemView$$ExternalSyntheticLambda0(r0, this));
    }

    private static final void updateBluetoothAddress$lambda$2(BluetoothAdapter r2, final BluetoothAddressStatusItemView r3) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        final String r0 = ResourceUtils.getString(R.string.device_info_not_available_bt);
        if (r2 != null) goto L6;
    L16:
        ThreadUtils.postOnMainThread(new BluetoothAddressStatusItemView$$ExternalSyntheticLambda1(r3, r0));
        return;
    L6:
        if (r2.isEnabled() == false) goto L16;
        String r4 = r2.getAddress();
        if (r4 == null) goto L16;
        if ((!StringsKt.isBlank(r4)) == true) goto L13;
        r4 = null;
    L13:
        if (r4 == null) goto L16;
        r0 = r4;
        goto L16
    }

    private static final void updateBluetoothAddress$lambda$2$lambda$1(BluetoothAddressStatusItemView r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$bluetoothAddress");
        r1.initData(ResourceUtils.getString(R.string.status_bt_address), r2);
    }
}
