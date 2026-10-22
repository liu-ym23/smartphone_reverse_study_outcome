package com.android.settings.wifi;

import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.Settings;
import com.android.settings.teaevent.TrackerEvent;
import com.android.settings.utils.UIUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import obric.tablet.widget.BytedanceJustifyTextView;

/* JADX INFO: loaded from: classes.dex */
public class AccessPointView extends RelativeLayout implements View.OnClickListener {
    public static final int[] STATE_NONE = null;
    public static final int[] STATE_SECURED = null;
    private ImageView infoIcon;
    private boolean isUseStrictLockScreen;
    private AccessPointInfo mApInfo;
    private ImageView mDetailArrowView;
    private OCardListItem mItemContainer;
    private ImageView mSignalView;
    private TextView mSummary;
    private TextView mSummaryVS;
    private TextView mTitleView;
    private View mTruestLabelView;
    private ViewStub mTrustedLabelStub;

    static {
        STATE_SECURED = new int[]{R.attr.state_encrypted};
        STATE_NONE = new int[0];
    }

    public AccessPointView(Context r2) {
        this(r2, null);
    }

    public AccessPointView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public AccessPointView(Context r7, AttributeSet r8, int r9) {
        super(r7, r8, r9);
        View r10 = LayoutInflater.from(r7).inflate(R.layout.wifi_accesspoint_info_layout, this, true);
        setGravity(16);
        OCardListItem r11 = (OCardListItem) r10.findViewById(R.id.list_item_container);
        this.mItemContainer = r11;
        TextView r12 = (TextView) r11.findViewById(R.id.title);
        this.mTitleView = r12;
        r12.setEllipsize(null);
        this.mTitleView.setSingleLine(false);
        this.mSummary = (TextView) this.mItemContainer.findViewById(R.id.sub_title);
        this.mSignalView = (ImageView) this.mItemContainer.findViewById(R.id.icon);
        ImageView r13 = (ImageView) this.mItemContainer.findViewById(R.id.tail_icon);
        this.infoIcon = r13;
        if (r13 == null) goto L5;
        r13.setScaleType(ImageView.ScaleType.CENTER);
        this.infoIcon.setImageResource(R.drawable.ic_info_button_bold);
        this.infoIcon.setOnClickListener(this);
        UIUtils.expandTouchArea(this.infoIcon, 10);
        UIUtils.INSTANCE.updateMargin(this.infoIcon, -1, -1, UIUtils.INSTANCE.dp2px(7), -1);
    L5:
        this.isUseStrictLockScreen = com.android.settings.Utils.isUseStrictLockScreen(getContext());
    }

    public void bindData(AccessPointInfo r1, int r2, boolean r3) {
        this.mApInfo = r1;
        refresh(r2, r3);
    }

    public void bindData(WifiManager r1, boolean r2, AccessPointInfo r3, int r4, int r5) {
        this.mApInfo = r3;
        refresh(r1, r2, r4, r5);
    }

    public void setTitle(CharSequence r1) {
        this.mTitleView.setText(r1);
    }

    public void setSummary(CharSequence r2, int r3, boolean r4) {
        if (TextUtils.isEmpty(r2) == false) goto L9;
        if (r4 == true) goto L7;
        if (r3 == 0) goto L9;
    L7:
        this.mSummary.setVisibility(8);
        return;
    L9:
        this.mSummary.setVisibility(0);
        if (this.mApInfo.isSafe == false) goto L12;
        this.mSummary.setText(r2);
        this.mSummary.setTextColor(getContext().getColor(R.color.oui_basic_text_3));
        return;
    L12:
        this.mSummary.setText(getContext().getString(R.string.wlan_security_check_risk));
        this.mSummary.setTextColor(getContext().getColor(R.color.oui_functional_red_5));
    }

    private void refresh(int r3, boolean r4) {
        AccessPointInfo r0 = this.mApInfo;
        if (r0 != null) goto L5;
        return;
    L5:
        setTitle(r0.ssid);
        if (this.mApInfo.getState() != NetworkInfo.DetailedState.CONNECTED) goto L8;
        String r1 = parseSummary();
    L9:
        setSummary(r1, r3, r4);
        this.mSignalView.setImageResource(R.drawable.wifi_signal);
        this.mSignalView.setImageLevel(Math.min(this.mApInfo.getLevel(), 3));
        ImageView r5 = this.mSignalView;
        if (this.mApInfo.security == 0) goto L12;
        int[] r6 = STATE_SECURED;
    L13:
        boolean r2 = true;
        r5.setImageState(r6, true);
        this.mItemContainer.showIcon(true);
        if (this.mApInfo.mState == null) goto L16;
    L19:
        if (r2 == false) goto L21;
        this.infoIcon.setVisibility(0);
        return;
    L21:
        this.infoIcon.setVisibility(8);
        return;
    L16:
        if (this.mApInfo.mConfig != null) goto L19;
        r2 = false;
        goto L19
    L12:
        r6 = STATE_NONE;
        goto L13
    L8:
        r1 = "";
        goto L9
    }

    private void refresh(WifiManager r6, boolean r7, int r8, int r9) {
        AccessPointInfo r0 = this.mApInfo;
        if (r0 != null) goto L5;
        return;
    L5:
        setTitle(r0.ssid);
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) this.mItemContainer.getLayoutParams();
        boolean r2 = true;
        if (r7 == true) goto L14;
        if (this.mApInfo.ssid.equals(AccessPoint.removeDoubleQuotes(r6.getConnectionInfo().getSSID())) == true) goto L10;
    L12:
        boolean r10 = false;
    L16:
        String r3 = "";
        if (r10 == true) goto L19;
        r1.topMargin = 0;
    L23:
        setSummary(r3, r8, r7);
        this.mSignalView.setImageResource(R.drawable.wifi_signal);
        this.mSignalView.setImageLevel(Math.min(this.mApInfo.getLevel(), 3));
        ImageView r11 = this.mSignalView;
        if (this.mApInfo.security == 0) goto L26;
        int[] r12 = STATE_SECURED;
    L27:
        r11.setImageState(r12, true);
        this.mItemContainer.showIcon(true);
        this.mItemContainer.setCardPosition(r9);
        OLog.e("AccessPointView", "refresh: view " + this.mItemContainer.getParent() + "  parent = " + getParent() + " position =" + r8 + BytedanceJustifyTextView.TWO_BLANK + this.mApInfo.ssid + " state= " + this.mApInfo.getState());
        if (this.mApInfo.mState == null) goto L30;
    L33:
        if (r2 == false) goto L35;
        this.infoIcon.setVisibility(0);
        return;
    L35:
        this.infoIcon.setVisibility(8);
        return;
    L30:
        if (this.mApInfo.mConfig != null) goto L33;
        r2 = false;
        goto L33
    L26:
        r12 = STATE_NONE;
        goto L27
    L19:
        if (this.mApInfo.getState() != NetworkInfo.DetailedState.CONNECTED) goto L21;
        r3 = parseSummary();
    L21:
        r1.topMargin = UIUtils.INSTANCE.dp2px(16);
        goto L23
    L10:
        if (this.mApInfo.checkSecuritySame(r6.getConnectionInfo()) == false) goto L12;
    L11:
        r10 = true;
        goto L16
    L14:
        if (this.mApInfo.getState() != NetworkInfo.DetailedState.CONNECTED) goto L12;
        goto L12
    }

    private String parseSummary() {
        return Utils.getWifiEntrySummary(this.mApInfo.wifiEntry);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        if (com.android.settings.Utils.isFastDoubleClick() == false) goto L6;
        return;
    L6:
        if (this.infoIcon.getVisibility() == 0) goto L8;
        return;
    L8:
        Bundle r5 = new Bundle();
        r5.putParcelable(AccessPointInfo.EXTRA_WIFI_CONFIGURATION, this.mApInfo.mConfig);
        r5.putSerializable(AccessPointInfo.EXTRA_PSK_TYPE, this.mApInfo.pskType);
        r5.putParcelable(AccessPointInfo.EXTRA_WIFI_INFO, this.mApInfo.mInfo);
        r5.putSerializable(AccessPointInfo.EXTRA_DETAILED_STATE, this.mApInfo.mState);
        r5.putInt("back_text_id", R.string.wifi_settings_title);
        r5.putString("key_chosen_wifientry_key", this.mApInfo.key);
        Intent r0 = new Intent(getContext(), Settings.AccessPointDetailActivity.class);
        r0.putExtras(r5);
        getContext().startActivity(r0);
        TrackerEvent.buttonEvent("settings_wifi_details");
    }

    public View getItemContainer() {
        return this.mItemContainer;
    }
}
