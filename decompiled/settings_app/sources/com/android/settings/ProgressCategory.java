package com.android.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;

/* JADX INFO: loaded from: classes2.dex */
public class ProgressCategory extends ProgressCategoryBase {
    private boolean mBluetoothCategory;
    private int mEmptyTextRes;
    private boolean mNoDeviceFoundAdded;
    private Preference mNoDeviceFoundPreference;
    private boolean mProgress;

    public ProgressCategory(Context r2) {
        this(r2, null);
    }

    public ProgressCategory(Context r2, AttributeSet r3) {
        super(r2, r3, 0);
        this.mProgress = false;
        this.mBluetoothCategory = false;
    }

    public ProgressCategory(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public ProgressCategory(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        this.mProgress = false;
        this.mBluetoothCategory = false;
        setLayoutResource(R.layout.preference_progress_category);
    }

    public ProgressCategory(Context r1, AttributeSet r2, int r3, boolean r4) {
        super(r1, r2);
        this.mProgress = false;
        this.mBluetoothCategory = false;
        setLayoutResource(R.layout.preference_progress_category);
        this.mEmptyTextRes = r3;
        this.mBluetoothCategory = r4;
        setTitle(null);
    }

    public void setEmptyTextRes(int r1) {
        this.mEmptyTextRes = r1;
    }

    @Override // androidx.preference.PreferenceCategory, androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r5) {
        super.onBindViewHolder(r5);
        View r6 = r5.itemView.findViewById(R.id.scanning_progress);
        if (getPreferenceCount() != 0) goto L5;
    L10:
        boolean r0 = true;
    L11:
        r6.setVisibility(8);
        if (this.mProgress == false) goto L17;
        if (this.mBluetoothCategory == true) goto L21;
        setTitle(R.string.bluetooth_searching_for_devices);
    L21:
        if (this.mBluetoothCategory == false) goto L23;
        return;
    L23:
        if (this.mProgress == true) goto L33;
        if (r0 == false) goto L33;
        if (this.mNoDeviceFoundAdded == false) goto L29;
        return;
    L29:
        if (this.mNoDeviceFoundPreference != null) goto L31;
        Preference r7 = new Preference(getContext());
        this.mNoDeviceFoundPreference = r7;
        r7.setLayoutResource(R.layout.preference_empty_list);
        this.mNoDeviceFoundPreference.setTitle(this.mEmptyTextRes);
        this.mNoDeviceFoundPreference.setSelectable(false);
    L31:
        addPreference(this.mNoDeviceFoundPreference);
        this.mNoDeviceFoundAdded = true;
        return;
    L33:
        if (this.mNoDeviceFoundAdded == false) goto L39;
        removePreference(this.mNoDeviceFoundPreference);
        this.mNoDeviceFoundAdded = false;
        return;
    L39:
        return;
    L17:
        if (this.mBluetoothCategory == true) goto L19;
        setTitle(R.string.bluetooth_preference_found_devices);
        goto L21
    L19:
        setTitle(null);
        goto L21
    L5:
        if (getPreferenceCount() == 1) goto L7;
    L9:
        r0 = false;
        goto L11
    L7:
        if (getPreference(0) != this.mNoDeviceFoundPreference) goto L9;
        goto L9
    }

    @Override // com.android.settings.ProgressCategoryBase
    public void setProgress(boolean r1) {
        this.mProgress = r1;
        notifyChanged();
    }

    public void refreshOrder() {
        notifyHierarchyChanged();
    }
}
