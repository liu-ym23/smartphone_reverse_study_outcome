package com.android.settings.common.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.TwoStatePreference;
import com.android.settings.R;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settingslib.RestrictedLockUtils;
import com.obric.oui.lisitem.OCardListItem;

/* JADX INFO: loaded from: classes2.dex */
public class ORestrictedSwitchPreference extends TwoStatePreference {
    private int mCardCount;
    private int mCardIndex;
    private OCardListItem mCardListItem;
    private RestrictedLockUtils.EnforcedAdmin mDisabledByAdmin;
    private final CompoundButton.OnCheckedChangeListener mSwitchListener;
    private boolean mUseAdminDisabledSummary;

    public ORestrictedSwitchPreference(Context r2) {
        this(r2, null);
    }

    public ORestrictedSwitchPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mCardCount = 1;
        this.mCardIndex = 0;
        this.mSwitchListener = new ORestrictedSwitchPreference$$ExternalSyntheticLambda1(this);
        setLayoutResource(R.layout.preference_ocard_list_item_switch);
    }

    public ORestrictedSwitchPreference(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mCardCount = 1;
        this.mCardIndex = 0;
        this.mSwitchListener = new ORestrictedSwitchPreference$$ExternalSyntheticLambda1(this);
        setLayoutResource(R.layout.preference_ocard_list_item_switch);
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r3) {
        super.onBindViewHolder(r3);
        OCardListItem r0 = (OCardListItem) r3.itemView.findViewById(R.id.card_list_item);
        this.mCardListItem = r0;
        if (r0 == null) goto L5;
    L7:
        OCardListItem r4 = this.mCardListItem;
        if (r4 != null) goto L10;
        return;
    L10:
        r4.setDefaultCustomEndView(1);
        this.mCardListItem.showCustomEnd(true);
        OCardListItemUtils.setTitle(this.mCardListItem, getTitle());
        OCardListItemUtils.setIcon(this.mCardListItem, getIcon());
        bindCardPosition();
        CharSequence r5 = getDisplaySummary();
        if (TextUtils.isEmpty(r5) == false) goto L13;
        this.mCardListItem.showSubTitle(false);
    L14:
        OCardListItemUtils.setOnCheckedChangeListener(this.mCardListItem, null);
        OCardListItemUtils.setChecked(this.mCardListItem, isChecked());
        OCardListItemUtils.setOnCheckedChangeListener(this.mCardListItem, this.mSwitchListener);
        this.mCardListItem.setOnContentClickListener(new ORestrictedSwitchPreference$$ExternalSyntheticLambda0(this));
        bindEnabledState();
        return;
    L13:
        OCardListItemUtils.setSubTitleString(this.mCardListItem, r5.toString());
        goto L14
    L5:
        if ((r3.itemView instanceof OCardListItem) == false) goto L7;
        this.mCardListItem = (OCardListItem) r3.itemView;
        goto L7
    }

    /* JADX INFO: renamed from: lambda$onBindViewHolder$0$com-android-settings-common-preference-ORestrictedSwitchPreference, reason: not valid java name */
    /* synthetic */ void m383xee7ba1d7(View r1) {
        performClick();
    }

    @Override // androidx.preference.TwoStatePreference, androidx.preference.Preference
    protected void onClick() {
        setCheckedFromUser(!isChecked());
    }

    @Override // androidx.preference.TwoStatePreference
    public void setChecked(boolean r3) {
        super.setChecked(r3);
        OCardListItem r0 = this.mCardListItem;
        if (r0 == null) goto L6;
        OCardListItemUtils.setOnCheckedChangeListener(r0, null);
        OCardListItemUtils.setChecked(this.mCardListItem, r3);
        OCardListItemUtils.setOnCheckedChangeListener(this.mCardListItem, this.mSwitchListener);
        return;
    }

    @Override // androidx.preference.Preference
    public void setEnabled(boolean r2) {
        if (r2 == true) goto L4;
    L7:
        super.setEnabled(r2);
        bindEnabledState();
        return;
    L4:
        if (isDisabledByAdmin() == false) goto L7;
        setDisabledByAdmin(null);
    }

    @Override // androidx.preference.Preference
    public void performClick() {
        if (isDisabledByAdmin() == false) goto L6;
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(getContext(), this.mDisabledByAdmin);
        return;
    L6:
        super.performClick();
    }

    public void useAdminDisabledSummary(boolean r1) {
        this.mUseAdminDisabledSummary = r1;
        notifyChanged();
    }

    public void setDisabledByAdmin(RestrictedLockUtils.EnforcedAdmin r2) {
        boolean r0 = isDisabledByAdmin();
        this.mDisabledByAdmin = r2;
        boolean r3 = isDisabledByAdmin();
        if (r0 == r3) goto L5;
        super.setEnabled(!r3);
    L5:
        notifyChanged();
        bindEnabledState();
    }

    public boolean isDisabledByAdmin() {
        if (this.mDisabledByAdmin == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void setCardPosition(int r1, int r2) {
        this.mCardCount = r1;
        this.mCardIndex = r2;
        bindCardPosition();
    }

    private void bindCardPosition() {
        OCardListItem r0 = this.mCardListItem;
        if (r0 == null) goto L6;
        OCardListItemUtils.initCardItemInAdapter(r0, this.mCardCount, this.mCardIndex);
        return;
    }

    private CharSequence getDisplaySummary() {
        if (isDisabledByAdmin() == false) goto L9;
        if (this.mUseAdminDisabledSummary == false) goto L9;
        return getContext().getString(R.string.disabled_by_administrator_summary);
    L9:
        return getSummary();
    }

    private void setCheckedFromUser(boolean r2) {
        if (r2 != isChecked()) goto L7;
        syncCheckedView();
        return;
    L7:
        if (callChangeListener(Boolean.valueOf(r2)) == false) goto L9;
        setChecked(r2);
        return;
    L9:
        syncCheckedView();
    }

    private void syncCheckedView() {
        OCardListItem r0 = this.mCardListItem;
        if (r0 == null) goto L6;
        OCardListItemUtils.setOnCheckedChangeListener(r0, null);
        OCardListItemUtils.setChecked(this.mCardListItem, isChecked());
        OCardListItemUtils.setOnCheckedChangeListener(this.mCardListItem, this.mSwitchListener);
        return;
    }

    private void bindEnabledState() {
        OCardListItem r0 = this.mCardListItem;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setEnabled(isEnabled());
    }

    /* JADX INFO: renamed from: lambda$new$1$com-android-settings-common-preference-ORestrictedSwitchPreference, reason: not valid java name */
    /* synthetic */ void m382x64427a5d(CompoundButton r1, boolean r2) {
        setCheckedFromUser(r2);
    }
}
