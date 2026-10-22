package com.android.settings.meeting;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.ToastUtils;
import com.android.settings.wifi.AccessPointInfo;
import com.android.settings.wifi.Summary;
import com.obric.oui.toast.OToast;
import obric.widget.ListContentItemCustom;

/* JADX INFO: loaded from: classes2.dex */
public class TabletAccessPointView extends RelativeLayout {
    static final int[] STATE_NONE = null;
    static final int[] STATE_SECURED = null;
    private AccessPointInfo mApInfo;
    private ListContentItemCustom mItemContainer;
    private ProgressBar mProgressBar;
    private ImageView mSignalView;
    private TextView mSummary;
    private ViewStub mSummaryVS;
    private TextView mTitleView;
    private OToast mToast;

    static {
        STATE_SECURED = new int[]{R.attr.state_encrypted};
        STATE_NONE = new int[0];
    }

    public TabletAccessPointView(Context r2) {
        this(r2, null);
    }

    public TabletAccessPointView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public TabletAccessPointView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        View r5 = LayoutInflater.from(r2).inflate(R.layout.revone_wifi_accesspoint_info_layout, this, true);
        setGravity(16);
        this.mTitleView = (TextView) r5.findViewById(R.id.ap_title);
        this.mSummaryVS = (ViewStub) r5.findViewById(R.id.summary_viewstub);
        this.mSignalView = (ImageView) r5.findViewById(R.id.signal);
        this.mItemContainer = (ListContentItemCustom) r5.findViewById(R.id.list_item_container);
        this.mProgressBar = (ProgressBar) r5.findViewById(R.id.progress_bar);
        this.mToast = ToastUtils.showInView(r2, R.string.wifi_connecting);
    }

    public void bindData(AccessPointInfo r1) {
        this.mApInfo = r1;
        refresh();
    }

    public void setTitle(CharSequence r1) {
        this.mTitleView.setText(r1);
    }

    public TextView getSummaryView() {
        if (this.mSummary != null) goto L6;
        this.mSummary = (TextView) this.mSummaryVS.inflate();
    L6:
        return this.mSummary;
    }

    public void setSummary(CharSequence r3) {
        getSummaryView();
        if (TextUtils.isEmpty(r3) == true) goto L5;
        this.mSummary.setVisibility(0);
    L6:
        this.mSummary.setText(r3);
        return;
    L5:
        this.mSummary.setVisibility(8);
        goto L6
    }

    private void refresh() {
        AccessPointInfo r0 = this.mApInfo;
        if (r0 != null) goto L5;
        return;
    L5:
        setTitle(r0.ssid);
        setSummary(parseSummary());
        if (this.mApInfo.mRssi != Integer.MAX_VALUE) goto L8;
        this.mSignalView.setImageDrawable(null);
        return;
    L8:
        this.mSignalView.setImageResource(R.drawable.revone_wifi_signal);
        this.mSignalView.setImageLevel(this.mApInfo.getLevel());
        ImageView r1 = this.mSignalView;
        if (this.mApInfo.security == 0) goto L11;
        int[] r2 = STATE_SECURED;
    L12:
        r1.setImageState(r2, true);
        return;
    L11:
        r2 = STATE_NONE;
        goto L12
    }

    private String parseSummary() {
        Context r0 = getContext();
        if (this.mApInfo.mState == null) goto L9;
        if (this.mApInfo.mState != NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK) goto L7;
        String r1 = Summary.get(r0, NetworkInfo.DetailedState.CONNECTED);
    L16:
        if (this.mApInfo.mState != NetworkInfo.DetailedState.AUTHENTICATING) goto L18;
    L25:
        this.mProgressBar.setVisibility(0);
        OToast r4 = this.mToast;
        if (r4 == null) goto L28;
        r4.show();
    L28:
        return r1;
    L18:
        if (this.mApInfo.mState == NetworkInfo.DetailedState.CONNECTING) goto L25;
        if (this.mProgressBar.getVisibility() == 8) goto L28;
        this.mProgressBar.setVisibility(8);
        OToast r2 = this.mToast;
        if (r2 == null) goto L28;
        r2.cancel();
        this.mToast = null;
        goto L28
    L7:
        r1 = Summary.get(r0, this.mApInfo.mState);
        goto L16
    L9:
        if (this.mApInfo.mRssi != Integer.MAX_VALUE) goto L12;
        r1 = r0.getString(R.string.wifi_not_in_range);
        goto L16
    L12:
        if (this.mApInfo.mConfig == null) goto L14;
        r1 = r0.getString(R.string.wifi_remembered);
        goto L16
    L14:
        r1 = null;
        goto L16
    }

    public void setBackgroundStyle(int r1) {
        ListContentItemCustom r0 = this.mItemContainer;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setBackgroundStyle(r1);
    }

    public void setBackgroundRes(int r1) {
        ListContentItemCustom r0 = this.mItemContainer;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setBackgroundResource(r1);
    }
}
