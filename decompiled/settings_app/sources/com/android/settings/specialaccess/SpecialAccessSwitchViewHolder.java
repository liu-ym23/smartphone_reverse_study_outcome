package com.android.settings.specialaccess;

import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.android.settings.R;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settingslib.applications.ApplicationsState;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public class SpecialAccessSwitchViewHolder extends RecyclerView.ViewHolder {
    final OCardListItem mOListItemGeneral;

    private void updateSummaryVisibility() {
    }

    public void setSummary(int r1) {
    }

    public void setSummary(CharSequence r1) {
    }

    void updateDisableView(ApplicationInfo r1) {
    }

    void updateSizeText(ApplicationsState.AppEntry r1, CharSequence r2, int r3) {
    }

    public SpecialAccessSwitchViewHolder(View r2) {
        super(r2);
        this.mOListItemGeneral = (OCardListItem) r2.findViewById(R.id.special_access_app_item);
    }

    public static View newView(ViewGroup r1) {
        return newView(r1, true);
    }

    static View newView(ViewGroup r4, boolean r5) {
        View r0 = LayoutInflater.from(r4.getContext()).inflate(R.layout.special_access_app_list_item, r4, false);
        OCardListItem r1 = (OCardListItem) r0.findViewById(R.id.special_access_app_item);
        OCardListItemUtils.setIcon(r1, r4.getContext().getDrawable(R.drawable.default_icon));
        r1.getContentContainer().setClickable(false);
        if (r5 == false) goto L5;
        r1.showCustomEnd(true);
    L6:
        return r0;
    L5:
        r1.showCustomEnd(false);
        goto L6
    }

    public void initCardItemInAdapter(int r1, int r2) {
        OCardListItemUtils.initCardItemInAdapter(this.mOListItemGeneral, r1, r2);
    }

    public void setEnabled(boolean r1) {
        OCardListItemUtils.setEnabled(this.mOListItemGeneral, r1);
    }

    public void setTitle(CharSequence r2, CharSequence r3) {
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
        OCardListItemUtils.setIconBadge(r1, R.drawable.settings_oic_doppleganger_badge, 18);
        return;
    L7:
        OCardListItemUtils.setIconBadge(r1, 0, 0);
    }

    public void updateSwitch(CompoundButton.OnCheckedChangeListener r3, boolean r4, boolean r5) {
        OCardListItem r0 = this.mOListItemGeneral;
        if (r0 == null) goto L6;
        r0.showCustomEnd(true);
        this.mOListItemGeneral.setFocusable(true);
        OCardListItemUtils.setOnCheckedChangeListener(this.mOListItemGeneral, r3);
        OCardListItemUtils.setChecked(this.mOListItemGeneral, r5);
        OCardListItemUtils.setEnabled(this.mOListItemGeneral, r4);
        return;
    }

    public void setSwitchOnTouchListener(View.OnTouchListener r2) {
        OCardListItem r0 = this.mOListItemGeneral;
        if (r0 != null) goto L5;
        return;
    L5:
        if (OCardListItemUtils.getSwitchView(r0) == null) goto L9;
        OCardListItemUtils.getSwitchView(this.mOListItemGeneral).setOnTouchListener(r2);
        return;
    }
}
