package com.android.settings.wifi.p2p;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pDevice;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;

/* JADX INFO: loaded from: classes.dex */
public class WifiP2pPeer extends Preference {
    private static final int SIGNAL_LEVELS = 4;
    private static final int[] STATE_SECURED = null;
    public WifiP2pDevice device;
    private int mBackgroundId;
    private OCardListItem mItemContainer;
    private int mLastPosition;
    private int mLastTotalCount;
    private View.OnClickListener mOnClickListener;
    private final int mRssi;
    private ImageView mSignal;

    /* JADX INFO: renamed from: $r8$lambda$m-SbKiygaBjm9ctcr_w4WLdxRlA, reason: not valid java name */
    public static /* synthetic */ void m724$r8$lambda$mSbKiygaBjm9ctcr_w4WLdxRlA(WifiP2pPeer r0) {
        r0.updateViews();
    }

    @Override // androidx.preference.Preference, java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Preference r1) {
        return compareTo(r1);
    }

    static {
        STATE_SECURED = new int[]{R.attr.state_encrypted};
    }

    public WifiP2pPeer(Context r1, WifiP2pDevice r2) {
        super(r1);
        this.mBackgroundId = 1;
        this.mLastPosition = -1;
        this.mLastTotalCount = -1;
        this.device = r2;
        setLayoutResource(R.layout.wifi_p2p_item_layout);
        setWidgetLayoutResource(R.layout.preference_widget_wifi_signal);
        this.mRssi = 60;
    }

    public void setBackgroundId(int r1) {
        if (r1 <= 0) goto L5;
        this.mBackgroundId = r1;
        return;
    }

    @Override // androidx.preference.Preference
    public void setTitle(CharSequence r1) {
        super.setTitle(r1);
        OCardListItem r0 = this.mItemContainer;
        if (r0 == null) goto L6;
        r0.setTitle(r1);
        return;
    }

    @Override // androidx.preference.Preference
    public void setSummary(CharSequence r1) {
        super.setSummary(r1);
        OCardListItem r0 = this.mItemContainer;
        if (r0 == null) goto L6;
        r0.setSubTitle(r1);
        return;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r3) {
        super.onBindViewHolder(r3);
        OCardListItem r4 = (OCardListItem) r3.findViewById(R.id.list_item_container);
        this.mItemContainer = r4;
        if (r4 != null) goto L5;
        return;
    L5:
        setCardPosition();
        setOnContentClickListener(this.mOnClickListener);
        ImageView r5 = this.mItemContainer.getIconView();
        this.mSignal = r5;
        if (this.mRssi != Integer.MAX_VALUE) goto L8;
        r5.setImageDrawable(null);
    L9:
        this.mItemContainer.post(new WifiP2pPeer$$ExternalSyntheticLambda0(this));
        return;
    L8:
        r5.setImageResource(R.drawable.wifi_signal);
        this.mSignal.setImageState(STATE_SECURED, true);
        goto L9
    }

    private void updateViews() {
        if (TextUtils.isEmpty(this.device.deviceName) == false) goto L5;
        setTitle(this.device.deviceAddress);
    L6:
        refresh();
        return;
    L5:
        setTitle(this.device.deviceName);
        goto L6
    }

    public void setOnContentClickListener(View.OnClickListener r1) {
        this.mOnClickListener = r1;
        OCardListItem r0 = this.mItemContainer;
        if (r0 == null) goto L6;
        r0.setOnContentClickListener(r1);
        return;
    }

    public void setCardPosition(int r1, int r2) {
        this.mLastPosition = r1;
        this.mLastTotalCount = r2;
    }

    private void setCardPosition() {
        OCardListItem r0 = this.mItemContainer;
        if (r0 == null) goto L20;
        int r1 = this.mLastPosition;
        if (r1 < 0) goto L21;
        int r2 = this.mLastTotalCount;
        if (r2 <= 0) goto L22;
        int r3 = 1;
        if (r2 != 1) goto L12;
        r3 = 0;
    L18:
        r0.setCardPosition(r3);
        this.mItemContainer.requestLayout();
        return;
    L12:
        if (r1 == 0) goto L18;
        if (r1 != (r2 - 1)) goto L17;
        r3 = 3;
        goto L18
    L17:
        r3 = 2;
        goto L18
    L22:
        return;
    L21:
        return;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.preference.Preference
    public int compareTo(Preference r3) {
        if ((r3 instanceof WifiP2pPeer) == false) goto L5;
        WifiP2pPeer r4 = (WifiP2pPeer) r3;
        if (this.device.status == r4.device.status) goto L14;
        if (this.device.status >= r4.device.status) goto L11;
        return -1;
    L11:
        return 1;
    L14:
        if (this.device.deviceName == null) goto L18;
        return this.device.deviceName.compareToIgnoreCase(r4.device.deviceName);
    L18:
        return this.device.deviceAddress.compareToIgnoreCase(r4.device.deviceAddress);
    L5:
        return super.compareTo2(r3);
    }

    int getLevel() {
        int r1 = this.mRssi;
        if (r1 != Integer.MAX_VALUE) goto L7;
        return -1;
    L7:
        return WifiManager.calculateSignalLevel(r1, 4);
    }

    private void refresh() {
        if (this.mSignal != null) goto L5;
        return;
    L5:
        Context r0 = getContext();
        this.mSignal.setImageLevel(getLevel());
        setSummary(r0.getResources().getStringArray(R.array.wifi_p2p_status)[this.device.status]);
    }
}
