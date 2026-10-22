package com.android.settings.specialaccess;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.settings.R;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public class SpecialAccessGeneralViewHolder extends RecyclerView.ViewHolder {
    final OCardListItem mOListItemGeneral;

    public void setSummary(int r1) {
    }

    public void setSummary(CharSequence r1) {
    }

    public SpecialAccessGeneralViewHolder(View r2) {
        super(r2);
        this.mOListItemGeneral = (OCardListItem) r2.findViewById(R.id.special_access_app_item);
    }

    public static View newView(ViewGroup r4) {
        View r0 = LayoutInflater.from(r4.getContext()).inflate(R.layout.special_access_app_list_item, r4, false);
        OCardListItem r1 = (OCardListItem) r0.findViewById(R.id.special_access_app_item);
        OCardListItemUtils.setIcon(r1, r4.getContext().getDrawable(R.drawable.default_icon));
        r1.setDefaultCustomEndView(3);
        r1.getContentContainer().setClickable(false);
        return r0;
    }

    public static View newPressableView(ViewGroup r3) {
        View r0 = LayoutInflater.from(r3.getContext()).inflate(R.layout.special_access_app_list_item, r3, false);
        OCardListItem r1 = (OCardListItem) r0.findViewById(R.id.special_access_app_item);
        OCardListItemUtils.setIcon(r1, r3.getContext().getDrawable(R.drawable.default_icon));
        r1.setDefaultCustomEndView(3);
        r1.getContentContainer().setClickable(true);
        return r0;
    }

    void setEnabled(boolean r1) {
        OCardListItemUtils.setEnabled(this.mOListItemGeneral, r1);
    }

    public void initCardItemInAdapter(int r1, int r2) {
        OCardListItemUtils.initCardItemInAdapter(this.mOListItemGeneral, r1, r2);
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

    public void setOnClickListener(View.OnClickListener r1) {
        this.mOListItemGeneral.setOnContentClickListener(r1);
    }

    public void showTailIcon() {
        this.mOListItemGeneral.showTailIcon(true);
    }
}
