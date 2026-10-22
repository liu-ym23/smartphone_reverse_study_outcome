package com.android.settings.notification;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.preference.DropDownPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.R;
import com.android.settingslib.RestrictedLockUtils;
import com.android.settingslib.RestrictedPreferenceHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RestrictedDropDownPreference extends DropDownPreference {
    private final RestrictedPreferenceHelper mHelper;
    private final AdapterView.OnItemSelectedListener mItemSelectedListener;
    private Preference.OnPreferenceClickListener mPreClickListener;
    private List<RestrictedItem> mRestrictedItems;
    private ReselectionSpinner mSpinner;
    private boolean mUserClicked;

    public static class ReselectionSpinner extends Spinner {
        private RestrictedDropDownPreference pref;

        public ReselectionSpinner(Context r1, AttributeSet r2) {
            super(r1, r2);
        }

        public void setPreference(RestrictedDropDownPreference r1) {
            this.pref = r1;
        }

        @Override // android.widget.AbsSpinner, android.widget.AdapterView
        public void setSelection(int r3) {
            int r0 = getSelectedItemPosition();
            super.setSelection(r3);
            if (r3 == r0) goto L5;
            return;
        L5:
            if (RestrictedDropDownPreference.access$400(this.pref) == false) goto L11;
            RestrictedDropDownPreference.access$500(this.pref, false);
            RestrictedItem r4 = RestrictedDropDownPreference.access$600(this.pref, r3);
            if (r4 == null) goto L12;
            RestrictedLockUtils.sendShowAdminSupportDetailsIntent(getContext(), r4.enforcedAdmin);
            return;
        L12:
            return;
        }
    }

    private class RestrictedArrayItemAdapter extends ArrayAdapter<String> {
        private static final int TEXT_RES_ID = 16908308;
        final /* synthetic */ RestrictedDropDownPreference this$0;

        public RestrictedArrayItemAdapter(RestrictedDropDownPreference r2, Context r3) {
            this.this$0 = r2;
            super(r3, R.layout.spinner_dropdown_restricted_item, 16908308);
        }

        @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
        public View getDropDownView(int r1, View r2, ViewGroup r3) {
            View r4 = super.getView(r1, r2, r3);
            boolean r0 = RestrictedDropDownPreference.access$300(this.this$0, getItem(r1));
            TextView r5 = (TextView) r4.findViewById(16908308);
            if (r5 == null) goto L5;
            r5.setEnabled(!r0);
        L5:
            View r6 = r4.findViewById(R.id.restricted_icon);
            if (r6 == null) goto L11;
            if (r0 == false) goto L9;
            int r7 = 0;
        L10:
            r6.setVisibility(r7);
            goto L11
        L9:
            r7 = 8;
        L11:
            return r4;
        }
    }

    public static class RestrictedItem {
        public final RestrictedLockUtils.EnforcedAdmin enforcedAdmin;
        public final CharSequence entry;
        public final CharSequence entryValue;

        public RestrictedItem(CharSequence r1, CharSequence r2, RestrictedLockUtils.EnforcedAdmin r3) {
            this.entry = r1;
            this.entryValue = r2;
            this.enforcedAdmin = r3;
        }
    }

    static /* synthetic */ boolean access$000(RestrictedDropDownPreference r0) {
        return r0.mUserClicked;
    }

    static /* synthetic */ boolean access$002(RestrictedDropDownPreference r0, boolean r1) {
        r0.mUserClicked = r1;
        return r1;
    }

    static /* synthetic */ RestrictedItem access$100(RestrictedDropDownPreference r0, CharSequence r1) {
        return r0.getRestrictedItemForEntryValue(r1);
    }

    static /* synthetic */ ReselectionSpinner access$200(RestrictedDropDownPreference r0) {
        return r0.mSpinner;
    }

    static /* synthetic */ boolean access$300(RestrictedDropDownPreference r0, CharSequence r1) {
        return r0.isRestrictedForEntry(r1);
    }

    static /* synthetic */ boolean access$400(RestrictedDropDownPreference r0) {
        return r0.isUserClicked();
    }

    static /* synthetic */ void access$500(RestrictedDropDownPreference r0, boolean r1) {
        r0.setUserClicked(r1);
    }

    static /* synthetic */ RestrictedItem access$600(RestrictedDropDownPreference r0, int r1) {
        return r0.getRestrictedItemForPosition(r1);
    }

    public RestrictedDropDownPreference(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.mRestrictedItems = new ArrayList();
        this.mUserClicked = false;
        this.mItemSelectedListener = new AnonymousClass1(this);
        setLayoutResource(R.layout.restricted_preference_dropdown);
        setWidgetLayoutResource(R.layout.restricted_icon);
        this.mHelper = new RestrictedPreferenceHelper(r2, this, r3);
    }

    @Override // androidx.preference.DropDownPreference
    protected ArrayAdapter createAdapter() {
        return new RestrictedArrayItemAdapter(this, getContext());
    }

    @Override // androidx.preference.ListPreference
    public void setValue(String r2) {
        if (getRestrictedItemForEntryValue(r2) == null) goto L5;
        return;
    L5:
        super.setValue(r2);
    }

    @Override // androidx.preference.DropDownPreference, androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r3) {
        ReselectionSpinner r0 = (ReselectionSpinner) r3.itemView.findViewById(R.id.spinner);
        this.mSpinner = r0;
        r0.setPreference(this);
        super.onBindViewHolder(r3);
        this.mHelper.onBindViewHolder(r3);
        this.mSpinner.setOnItemSelectedListener(this.mItemSelectedListener);
        View r4 = r3.findViewById(R.id.restricted_icon);
        if (r4 != null) goto L5;
        return;
    L5:
        if (isDisabledByAdmin() == false) goto L7;
        int r2 = 0;
    L8:
        r4.setVisibility(r2);
        return;
    L7:
        r2 = 8;
        goto L8
    }

    private boolean isRestrictedForEntry(CharSequence r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        Iterator<RestrictedItem> r2 = this.mRestrictedItems.iterator();
    L7:
        if (r2.hasNext() == false) goto L12;
        if (r3.equals(r2.next().entry) == false) goto L7;
        return true;
    L12:
        return false;
    }

    private RestrictedItem getRestrictedItemForEntryValue(CharSequence r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        Iterator<RestrictedItem> r3 = this.mRestrictedItems.iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        RestrictedItem r1 = r3.next();
        if (r4.equals(r1.entryValue) == false) goto L7;
        return r1;
    L11:
        return null;
    }

    private RestrictedItem getRestrictedItemForPosition(int r2) {
        if (r2 >= 0) goto L4;
        return null;
    L4:
        if (r2 < getEntryValues().length) goto L7;
        return null;
    L7:
        return getRestrictedItemForEntryValue(getEntryValues()[r2]);
    }

    public void addRestrictedItem(RestrictedItem r1) {
        this.mRestrictedItems.add(r1);
    }

    @Override // androidx.preference.Preference
    public void performClick() {
        Preference.OnPreferenceClickListener r0 = this.mPreClickListener;
        if (r0 == null) goto L8;
        if (r0.onPreferenceClick(this) == false) goto L8;
        return;
    L8:
        if (this.mHelper.performClick() == true) goto L11;
        this.mUserClicked = true;
        super.performClick();
        return;
    }

    @Override // androidx.preference.Preference
    public void setEnabled(boolean r2) {
        if (r2 == true) goto L4;
    L7:
        super.setEnabled(r2);
        return;
    L4:
        if (isDisabledByAdmin() == false) goto L7;
        this.mHelper.setDisabledByAdmin(null);
    }

    public void setDisabledByAdmin(RestrictedLockUtils.EnforcedAdmin r2) {
        if (this.mHelper.setDisabledByAdmin(r2) == false) goto L6;
        notifyChanged();
        return;
    }

    public void setOnPreClickListener(Preference.OnPreferenceClickListener r1) {
        this.mPreClickListener = r1;
    }

    public boolean isDisabledByAdmin() {
        return this.mHelper.isDisabledByAdmin();
    }

    private void setUserClicked(boolean r1) {
        this.mUserClicked = r1;
    }

    private boolean isUserClicked() {
        return this.mUserClicked;
    }
}
