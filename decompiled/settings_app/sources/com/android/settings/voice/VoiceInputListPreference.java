package com.android.settings.voice;

import android.R;
import android.content.ComponentName;
import android.content.Context;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import com.android.settings.AppListPreferenceWithSettings;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class VoiceInputListPreference extends AppListPreferenceWithSettings {
    private ComponentName mAssistRestrict;
    private final List<Integer> mAvailableIndexes;
    private VoiceInputHelper mHelper;

    private class CustomAdapter extends ArrayAdapter<CharSequence> {
        final /* synthetic */ VoiceInputListPreference this$0;

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return false;
        }

        public CustomAdapter(VoiceInputListPreference r2, Context r3, CharSequence[] r4) {
            this.this$0 = r2;
            super(r3, 17367464, R.id.text1, r4);
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int r1) {
            return VoiceInputListPreference.access$000(this.this$0).contains(Integer.valueOf(r1));
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int r1, View r2, ViewGroup r3) {
            View r4 = super.getView(r1, r2, r3);
            r4.setEnabled(isEnabled(r1));
            return r4;
        }
    }

    @Override // com.android.settings.AppListPreference
    public void setPackageNames(CharSequence[] r1, CharSequence r2) {
    }

    static /* synthetic */ List access$000(VoiceInputListPreference r0) {
        return r0.mAvailableIndexes;
    }

    public VoiceInputListPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mAvailableIndexes = new ArrayList();
        setDialogTitle(com.android.settings.R.string.choose_voice_input_title);
    }

    @Override // com.android.settings.AppListPreference
    protected ListAdapter createListAdapter() {
        return new CustomAdapter(this, getContext(), getEntries());
    }

    @Override // androidx.preference.Preference
    protected boolean persistString(String r8) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r1 >= this.mHelper.mAvailableInteractionInfos.size()) goto L11;
        VoiceInputHelper.InteractionInfo r2 = this.mHelper.mAvailableInteractionInfos.get(r1);
        if (r2.key.equals(r8) == true) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        Settings.Secure.putString(getContext().getContentResolver(), "voice_interaction_service", r8);
        Settings.Secure.putString(getContext().getContentResolver(), "voice_recognition_service", new ComponentName(r2.service.packageName, r2.serviceInfo.getRecognitionService()).flattenToShortString());
        setSummary(getEntry());
        setSettingsComponent(r2.f5settings);
        return true;
    L11:
        if (r0 >= this.mHelper.mAvailableRecognizerInfos.size()) goto L17;
        VoiceInputHelper.RecognizerInfo r3 = this.mHelper.mAvailableRecognizerInfos.get(r0);
        if (r3.key.equals(r8) == true) goto L14;
        r0 = r0 + 1;
        goto L11
    L14:
        Settings.Secure.putString(getContext().getContentResolver(), "voice_interaction_service", "");
        Settings.Secure.putString(getContext().getContentResolver(), "voice_recognition_service", r8);
        setSummary(getEntry());
        setSettingsComponent(r3.f5settings);
        return true;
    L17:
        setSettingsComponent(null);
        return true;
    }

    public void setAssistRestrict(ComponentName r1) {
        this.mAssistRestrict = r1;
    }

    public void refreshVoiceInputs() {
        VoiceInputHelper r0 = new VoiceInputHelper(getContext());
        this.mHelper = r0;
        r0.buildUi();
        ComponentName r1 = this.mAssistRestrict;
        if (r1 != null) goto L5;
        String r2 = "";
    L6:
        this.mAvailableIndexes.clear();
        ArrayList r3 = new ArrayList();
        ArrayList r4 = new ArrayList();
        int r5 = 0;
        int r6 = 0;
    L8:
        if (r6 >= this.mHelper.mAvailableInteractionInfos.size()) goto L13;
        VoiceInputHelper.InteractionInfo r7 = this.mHelper.mAvailableInteractionInfos.get(r6);
        r3.add(r7.appLabel);
        r4.add(r7.key);
        if (r7.key.contentEquals(r2) == false) goto L12;
        this.mAvailableIndexes.add(Integer.valueOf(r6));
    L12:
        r6 = r6 + 1;
        goto L8
    L13:
        boolean r8 = !this.mAvailableIndexes.isEmpty();
        int r9 = r3.size();
    L15:
        if (r5 >= this.mHelper.mAvailableRecognizerInfos.size()) goto L20;
        VoiceInputHelper.RecognizerInfo r10 = this.mHelper.mAvailableRecognizerInfos.get(r5);
        r3.add(r10.label);
        r4.add(r10.key);
        if (r8 == true) goto L19;
        this.mAvailableIndexes.add(Integer.valueOf(r9 + r5));
    L19:
        r5 = r5 + 1;
        goto L15
    L20:
        setEntries((CharSequence[]) r3.toArray(new CharSequence[r3.size()]));
        setEntryValues((CharSequence[]) r4.toArray(new CharSequence[r4.size()]));
        if (this.mHelper.mCurrentVoiceInteraction == null) goto L24;
        setValue(this.mHelper.mCurrentVoiceInteraction.flattenToShortString());
        return;
    L24:
        if (this.mHelper.mCurrentRecognizer == null) goto L26;
        setValue(this.mHelper.mCurrentRecognizer.flattenToShortString());
        return;
    L26:
        setValue(null);
        return;
    L5:
        r2 = r1.flattenToShortString();
        goto L6
    }

    public ComponentName getCurrentService() {
        if (this.mHelper.mCurrentVoiceInteraction == null) goto L7;
        return this.mHelper.mCurrentVoiceInteraction;
    L7:
        if (this.mHelper.mCurrentRecognizer != null) goto L9;
        return null;
    L9:
        return this.mHelper.mCurrentRecognizer;
    }
}
