package com.android.settings.inputmethod;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.textservice.SpellCheckerInfo;
import android.view.textservice.TextServicesManager;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.R;
import com.android.settings.base.BaseFragment;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.lisitem.OListItemSettings;

/* JADX INFO: loaded from: classes2.dex */
public class SingleSpellCheckerPreference extends Preference {
    private static final boolean DBG = false;
    private static final String TAG = "SingleSpellCheckerPreference";
    private final SpellCheckersSettings mFragment;
    private OListItemSettings mItemCheckbox;
    private int mMyPosition;
    private OCheckBox mOCheckBox;
    private int mPreferenceCount;
    private boolean mSelected;
    private final SpellCheckerInfo mSpellCheckerInfo;

    static {
    }

    static /* synthetic */ void access$000(SingleSpellCheckerPreference r0, View r1) {
        r0.onPreferenceClicked(r1);
    }

    static /* synthetic */ void access$100(SingleSpellCheckerPreference r0, View r1) {
        r0.onDetailsButtonClicked(r1);
    }

    public SingleSpellCheckerPreference(SpellCheckersSettings r2, Intent r3, SpellCheckerInfo r4, TextServicesManager r5) {
        super(r2.getActivity(), null, 0);
        this.mFragment = r2;
        setLayoutResource(R.layout.olist_content_item_text);
        this.mSpellCheckerInfo = r4;
        this.mSelected = false;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r5) {
        super.onBindViewHolder(r5);
        View r6 = r5.itemView;
        OListItemSettings r0 = (OListItemSettings) r6.findViewById(R.id.item_text);
        this.mItemCheckbox = r0;
        r0.setOnClickListener(new AnonymousClass1(this));
        this.mItemCheckbox.setTitleString(getTitle().toString());
        this.mItemCheckbox.mContentElement.setVisibility(8);
        if (this.mOCheckBox != null) goto L5;
        View r1 = LayoutInflater.from(getContext()).inflate(R.layout.o_listitem_leading_checkbox, null, false);
        this.mItemCheckbox.setLeadingView(r1);
        OCheckBox r2 = (OCheckBox) r1.findViewById(R.id.listitem_checkbox);
        this.mOCheckBox = r2;
        r2.setClickable(false);
    L5:
        this.mItemCheckbox.mTrailingElement.setOnClickListener(new AnonymousClass2(this));
        updateSelectedState(this.mSelected);
        int r3 = this.mPreferenceCount;
        if (r3 > 0) goto L8;
    L10:
        int r4 = 0;
    L11:
        r6.setPadding(0, 0, 0, r4);
        return;
    L8:
        if (this.mMyPosition != (r3 - 1)) goto L10;
        r4 = getContext().getResources().getDimensionPixelSize(R.dimen.settings_item_top_bottom_margin);
        goto L11
    }

    private void onPreferenceClicked(View r1) {
        this.mFragment.onPreferenceClick(this);
    }

    public SpellCheckerInfo getSpellCheckerInfo() {
        return this.mSpellCheckerInfo;
    }

    private void updateSelectedState(boolean r2) {
        if (this.mItemCheckbox == null) goto L6;
        this.mOCheckBox.setChecked(r2);
        return;
    }

    public void setSelected(boolean r1) {
        this.mSelected = r1;
        updateSelectedState(r1);
    }

    private void onDetailsButtonClicked(View r4) {
        if (this.mFragment == null) goto L10;
        SpellCheckersDetailSettingsFragment r5 = new SpellCheckersDetailSettingsFragment();
        Bundle r0 = new Bundle();
        r0.putParcelable("spellCheckerInfo", this.mSpellCheckerInfo);
        r0.putInt("back_text_id", R.string.language_item_title_spellling_check_settings);
        r0.putString("title", (String) this.mSpellCheckerInfo.loadLabel(getContext().getPackageManager()));
        r5.setArguments(r0);
        if (this.mFragment.getParentFragment() != null) goto L7;
        return;
    L7:
        if ((this.mFragment.getParentFragment() instanceof BaseFragment) == false) goto L12;
        ((BaseFragment) this.mFragment.getParentFragment()).start(r5);
        return;
    L12:
        return;
    }

    public void setBackgroundStyle(int r1, int r2) {
        this.mPreferenceCount = r1;
        this.mMyPosition = r2;
    }
}
