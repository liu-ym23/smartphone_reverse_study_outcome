package com.android.settings.applications.manageapplications;

import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.android.settings.R;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.utils.HanziToPinyin;
import com.android.settingslib.applications.ApplicationsState;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public class ApplicationViewHolder extends RecyclerView.ViewHolder {
    final OCardListItem mOListItemGeneral;

    private void updateSummaryVisibility() {
    }

    void setSummary(int r1) {
    }

    void setSummary(CharSequence r1) {
    }

    void updateDisableView(ApplicationInfo r1) {
    }

    ApplicationViewHolder(View r2) {
        super(r2);
        this.mOListItemGeneral = (OCardListItem) r2.findViewById(R.id.special_access_app_item);
    }

    static View newView(ViewGroup r2) {
        return newView(r2, false, -1);
    }

    static View newView(ViewGroup r3, boolean r4, int r5) {
        View r6 = LayoutInflater.from(r3.getContext()).inflate(R.layout.special_access_app_list_item, r3, false);
        OCardListItem r0 = (OCardListItem) r6.findViewById(R.id.special_access_app_item);
        OCardListItemUtils.setIcon(r0, r3.getContext().getDrawable(R.drawable.default_icon));
        if (r4 == false) goto L5;
        r0.showCustomEnd(true);
    L6:
        r0.getContentContainer().setClickable(false);
        return r6;
    L5:
        r0.showCustomEnd(false);
        goto L6
    }

    void setEnabled(boolean r1) {
        OCardListItemUtils.setEnabled(this.mOListItemGeneral, r1);
    }

    public void initCardItemInAdapter(int r1, int r2) {
        OCardListItemUtils.initCardItemInAdapter(this.mOListItemGeneral, r1, r2);
    }

    void setTitle(CharSequence r2, CharSequence r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        OCardListItemUtils.setTitle(this.mOListItemGeneral, r2);
        if (TextUtils.isEmpty(r3) == false) goto L7;
        return;
    L7:
        this.mOListItemGeneral.getTitleView().setContentDescription(r3);
    }

    public void setIcon(Drawable r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        OCardListItemUtils.setIcon(this.mOListItemGeneral, r1);
    }

    public void setBadge(boolean r2) {
        OCardListItem r1 = this.mOListItemGeneral;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r2 == false) goto L7;
        OCardListItemUtils.setIconBadge(r1, R.drawable.settings_oic_doppleganger_badge, 10);
        return;
    L7:
        OCardListItemUtils.setIconBadge(r1, 0, 0);
    }

    void updateSizeText(ApplicationsState.AppEntry r5, CharSequence r6, int r7) {
        if (ManageApplications.DEBUG == false) goto L6;
        OLog.d("ManageApplications", "updateSizeText of " + r5.label + HanziToPinyin.Token.SEPARATOR + r5 + ": " + r5.sizeStr);
    L6:
        if (r5.sizeStr == null) goto L15;
        if (r7 != 1) goto L10;
        setSummary(r5.internalSizeStr);
        return;
    L10:
        if (r7 == 2) goto L12;
        setSummary(r5.sizeStr);
        return;
    L12:
        setSummary(r5.externalSizeStr);
        return;
    L15:
        if (r5.size != (-2)) goto L21;
        setSummary(r6);
        return;
    }

    void updateSwitch(CompoundButton.OnCheckedChangeListener r3, boolean r4, boolean r5) {
        OCardListItem r0 = this.mOListItemGeneral;
        if (r0 == null) goto L6;
        r0.showCustomEnd(true);
        this.mOListItemGeneral.setFocusable(true);
        OCardListItemUtils.setOnCheckedChangeListener(this.mOListItemGeneral, null);
        OCardListItemUtils.setChecked(this.mOListItemGeneral, r5);
        OCardListItemUtils.setOnCheckedChangeListener(this.mOListItemGeneral, r3);
        OCardListItemUtils.setEnabled(this.mOListItemGeneral, r4);
        return;
    }

    void setSwitchOnTouchListener(View.OnTouchListener r2) {
        OCardListItem r0 = this.mOListItemGeneral;
        if (r0 != null) goto L5;
        return;
    L5:
        if (OCardListItemUtils.getSwitchView(r0) == null) goto L9;
        OCardListItemUtils.getSwitchView(this.mOListItemGeneral).setOnTouchListener(r2);
        return;
    }

    void setOnClickListener(View.OnClickListener r1) {
        this.mOListItemGeneral.setOnContentClickListener(r1);
    }
}
