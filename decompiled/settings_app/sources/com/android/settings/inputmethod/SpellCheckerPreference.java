package com.android.settings.inputmethod;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.textservice.SpellCheckerInfo;
import androidx.appcompat.app.AlertDialog;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.CustomListPreference;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
class SpellCheckerPreference extends CustomListPreference {
    private Intent mIntent;
    private final SpellCheckerInfo[] mScis;

    static /* synthetic */ void access$000(SpellCheckerPreference r0) {
        r0.onSettingsButtonClicked();
    }

    public SpellCheckerPreference(Context r6, SpellCheckerInfo[] r7) {
        super(r6, null);
        this.mScis = r7;
        setWidgetLayoutResource(R.layout.preference_widget_settings);
        CharSequence[] r0 = new CharSequence[r7.length];
        CharSequence[] r1 = new CharSequence[r7.length];
        int r2 = 0;
    L4:
        if (r2 >= r7.length) goto L6;
        r0[r2] = r7[r2].loadLabel(r6.getPackageManager());
        r1[r2] = String.valueOf(r2);
        r2 = r2 + 1;
        goto L4
    L6:
        setEntries(r0);
        setEntryValues(r1);
    }

    @Override // com.android.settings.CustomListPreference
    protected void onPrepareDialogBuilder(AlertDialog.Builder r3, DialogInterface.OnClickListener r4) {
        r3.setTitle(R.string.choose_spell_checker);
        r3.setSingleChoiceItems(getEntries(), findIndexOfValue(getValue()), r4);
    }

    public void setSelected(SpellCheckerInfo r4) {
        if (r4 != null) goto L5;
        setValue(null);
        return;
    L5:
        int r0 = 0;
    L6:
        SpellCheckerInfo[] r1 = this.mScis;
        if (r0 >= r1.length) goto L13;
        if (r1[r0].getId().equals(r4.getId()) == true) goto L10;
        r0 = r0 + 1;
        goto L6
    L10:
        setValueIndex(r0);
        return;
    }

    @Override // androidx.preference.ListPreference
    public void setValue(String r4) {
        super.setValue(r4);
        if (r4 == null) goto L5;
        int r5 = Integer.parseInt(r4);
    L7:
        if (r5 != (-1)) goto L10;
        this.mIntent = null;
        return;
    L10:
        SpellCheckerInfo r6 = this.mScis[r5];
        String r0 = r6.getSettingsActivity();
        if (TextUtils.isEmpty(r0) == false) goto L13;
        this.mIntent = null;
        return;
    L13:
        Intent r1 = new Intent("android.intent.action.MAIN");
        this.mIntent = r1;
        r1.setClassName(r6.getPackageName(), r0);
        return;
    L5:
        r5 = -1;
        goto L7
    }

    @Override // androidx.preference.Preference
    public boolean callChangeListener(Object r2) {
        if (r2 == null) goto L4;
        SpellCheckerInfo r3 = this.mScis[Integer.parseInt((String) r2)];
    L5:
        if (r3 != null) goto L7;
        return true;
    L7:
        return super.callChangeListener(r3);
    L4:
        r3 = null;
        goto L5
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r2) {
        super.onBindViewHolder(r2);
        View r3 = r2.findViewById(R.id.settings_button);
        if (this.mIntent == null) goto L5;
        int r0 = 0;
    L6:
        r3.setVisibility(r0);
        r3.setOnClickListener(new AnonymousClass1(this));
        return;
    L5:
        r0 = 4;
        goto L6
    }

    private void onSettingsButtonClicked() {
        Context r0 = getContext();
        Intent r1 = this.mIntent;     // Catch: ActivityNotFoundException -> L7
        if (r1 == null) goto L10;
        r0.startActivity(r1);     // Catch: ActivityNotFoundException -> L7
        return;
    L10:
        return;
    }
}
