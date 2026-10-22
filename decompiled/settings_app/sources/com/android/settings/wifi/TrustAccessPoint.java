package com.android.settings.wifi;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.R;
import com.android.settings.WifiConfigurationSmtOnly;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.oswitch.OSwitch;

/* JADX INFO: loaded from: classes.dex */
public class TrustAccessPoint extends AccessPoint {
    private boolean isLandAndisExitdisplay;
    private int mBackgroundId;
    private CompoundButton.OnCheckedChangeListener mCheckListener;
    private View.OnClickListener mClickListener;
    private boolean mEditMode;
    private boolean mIsUseStrictLockScreen;
    private OListItemSettings mItemContainer;
    private ImageView mRemoveView;
    private OSwitch mSwitch;

    public TrustAccessPoint(Context r1, WifiConfiguration r2, boolean r3) {
        super(r1, r2);
        this.mEditMode = false;
        this.mBackgroundId = 3;
        this.isLandAndisExitdisplay = r3;
        if (r3 == false) goto L5;
        int r4 = R.layout.trust_access_point_land_layout;
    L6:
        setLayoutResource(r4);
        return;
    L5:
        r4 = R.layout.trust_access_point_layout;
        goto L6
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener r1) {
        this.mCheckListener = r1;
    }

    @Override // com.android.settings.wifi.AccessPoint, androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r2) {
        super.onBindViewHolder(r2);
        View r3 = r2.itemView;
        this.mIsUseStrictLockScreen = com.android.settings.Utils.isUseStrictLockScreen(r3.getContext());
        this.mItemContainer = (OListItemSettings) r3.findViewById(R.id.list_item_container);
        OSwitch r4 = new OSwitch(getContext());
        this.mSwitch = r4;
        r4.setClickable(true);
        this.mSwitch.setTag(getConfig());
        this.mSwitch.setChecked(WifiConfigurationSmtOnly.get_isTrustedAp(getConfig()));
        this.mSwitch.setOnCheckedChangeListener(this.mCheckListener);
        this.mItemContainer.setTrailingView(this.mSwitch);
        ImageView r5 = this.mItemContainer.mIvContent;
        this.mRemoveView = r5;
        r5.setImageResource(R.drawable.ic_remove);
        this.mRemoveView.setTag(getConfig());
        this.mRemoveView.setId(R.id.item_remove_view);
        this.mRemoveView.setOnClickListener(this.mClickListener);
        setRemoveImageViewVisibility();
        refresh();
    }

    public void setRemovedImageOnClickListener(View.OnClickListener r1) {
        this.mClickListener = r1;
    }

    public void setEditMode(boolean r1) {
        this.mEditMode = r1;
        notifyChanged();
    }

    private void setRemoveImageViewVisibility() {
        boolean r0 = isCurrentConnected();
        int r2 = 8;
        if (this.mRemoveView != null) goto L5;
    L10:
        OSwitch r1 = this.mSwitch;
        if (r1 != null) goto L13;
        return;
    L13:
        if (this.mEditMode == false) goto L15;
    L18:
        r1.setVisibility(r2);
        return;
    L15:
        if (this.mIsUseStrictLockScreen == true) goto L18;
        r2 = 0;
        goto L18
    L5:
        if (this.mEditMode == false) goto L8;
        if (r0 == true) goto L8;
        this.mItemContainer.mContentElement.setVisibility(0);
        this.mRemoveView.setVisibility(0);
    L9:
        this.mItemContainer.updateState();
    L8:
        this.mItemContainer.mContentElement.setVisibility(4);
        this.mRemoveView.setVisibility(8);
        goto L9
    }

    private boolean isCurrentConnected() {
        android.net.wifi.WifiInfo r0 = getInfo();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getNetworkId() != getConfig().networkId) goto L7;
        return true;
    }

    @Override // com.android.settings.wifi.AccessPoint
    public void setBackgroundId(int r1) {
        this.mBackgroundId = r1;
    }

    @Override // androidx.preference.Preference
    public void setTitle(CharSequence r1) {
        super.setTitle(r1);
        OListItemSettings r0 = this.mItemContainer;
        if (r0 == null) goto L6;
        r0.setTitleString(r1.toString());
        return;
    }

    @Override // androidx.preference.Preference
    public void setSummary(CharSequence r3) {
        super.setSummary(r3);
        if (this.mItemContainer != null) goto L6;
        return;
    L6:
        if (isCurrentConnected() == false) goto L8;
        this.mItemContainer.setSubTitleString(r3.toString() + getContext().getResources().getString(R.string.currently_connected_network_text));
        return;
    L8:
        this.mItemContainer.setSubTitleString(r3.toString());
    }
}
