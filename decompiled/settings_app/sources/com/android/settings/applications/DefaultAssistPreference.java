package com.android.settings.applications;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.UserHandle;
import android.provider.Settings;
import android.service.voice.VoiceInteractionServiceInfo;
import android.util.AttributeSet;
import com.android.internal.app.AssistUtils;
import com.android.settings.AppListPreferenceWithSettings;
import com.android.settings.R;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultAssistPreference extends AppListPreferenceWithSettings {
    private static final String TAG = "DefaultAssistPreference";
    private final AssistUtils mAssistUtils;
    private final List<Info> mAvailableAssistants;

    private static class Info {
        public final ComponentName component;
        public final VoiceInteractionServiceInfo voiceInteractionServiceInfo;

        Info(ComponentName r1) {
            this.component = r1;
            this.voiceInteractionServiceInfo = null;
        }

        Info(ComponentName r1, VoiceInteractionServiceInfo r2) {
            this.component = r1;
            this.voiceInteractionServiceInfo = r2;
        }

        public boolean isVoiceInteractionService() {
            if (this.voiceInteractionServiceInfo == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
    }

    public DefaultAssistPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mAvailableAssistants = new ArrayList();
        setShowItemNone(true);
        setDialogTitle(R.string.choose_assist_title);
        this.mAssistUtils = new AssistUtils(r1);
    }

    @Override // androidx.preference.Preference
    protected boolean persistString(String r3) {
        Info r4 = findAssistantByPackageName(r3);
        if (r4 != null) goto L7;
        setAssistNone();
        return true;
    L7:
        if (r4.isVoiceInteractionService() == false) goto L9;
        setAssistService(r4);
    L10:
        return true;
    L9:
        setAssistActivity(r4);
        goto L10
    }

    private void setAssistNone() {
        Settings.Secure.putString(getContext().getContentResolver(), "assistant", "");
        Settings.Secure.putString(getContext().getContentResolver(), "voice_interaction_service", "");
        Settings.Secure.putString(getContext().getContentResolver(), "voice_recognition_service", getDefaultRecognizer());
        setSummary(getContext().getText(R.string.default_assist_none));
        setSettingsComponent(null);
    }

    private void setAssistService(Info r5) {
        String r0 = r5.component.flattenToShortString();
        String r1 = new ComponentName(r5.component.getPackageName(), r5.voiceInteractionServiceInfo.getRecognitionService()).flattenToShortString();
        Settings.Secure.putString(getContext().getContentResolver(), "assistant", r0);
        Settings.Secure.putString(getContext().getContentResolver(), "voice_interaction_service", r0);
        Settings.Secure.putString(getContext().getContentResolver(), "voice_recognition_service", r1);
        setSummary(getEntry());
        String r2 = r5.voiceInteractionServiceInfo.getSettingsActivity();
        if (r2 != null) goto L5;
        ComponentName r6 = null;
    L6:
        setSettingsComponent(r6);
        return;
    L5:
        r6 = new ComponentName(r5.component.getPackageName(), r2);
        goto L6
    }

    private void setAssistActivity(Info r3) {
        Settings.Secure.putString(getContext().getContentResolver(), "assistant", r3.component.flattenToShortString());
        Settings.Secure.putString(getContext().getContentResolver(), "voice_interaction_service", "");
        Settings.Secure.putString(getContext().getContentResolver(), "voice_recognition_service", getDefaultRecognizer());
        setSummary(getEntry());
        setSettingsComponent(null);
    }

    private String getDefaultRecognizer() {
        ResolveInfo r2 = getContext().getPackageManager().resolveService(new Intent("android.speech.RecognitionService"), 128);
        if (r2 != null) goto L5;
    L9:
        OLog.w(TAG, "Unable to resolve default voice recognition service.");
        return "";
    L5:
        if (r2.serviceInfo == null) goto L9;
        return new ComponentName(r2.serviceInfo.packageName, r2.serviceInfo.name).flattenToShortString();
    }

    private Info findAssistantByPackageName(String r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.mAvailableAssistants.size()) goto L9;
        Info r1 = this.mAvailableAssistants.get(r0);
        if (r1.component.getPackageName().equals(r4) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r1;
    L9:
        return null;
    }

    private void addAssistServices() {
        PackageManager r0 = getContext().getPackageManager();
        List<ResolveInfo> r1 = r0.queryIntentServices(new Intent("android.service.voice.VoiceInteractionService"), 128);
        int r2 = 0;
    L4:
        if (r2 >= r1.size()) goto L10;
        ResolveInfo r3 = r1.get(r2);
        VoiceInteractionServiceInfo r4 = new VoiceInteractionServiceInfo(r0, r3.serviceInfo);
        if (r4.getSupportsAssist() == false) goto L9;
        this.mAvailableAssistants.add(new Info(new ComponentName(r3.serviceInfo.packageName, r3.serviceInfo.name), r4));
    L9:
        r2 = r2 + 1;
        goto L4
    }

    private void addAssistActivities() {
        List<ResolveInfo> r0 = getContext().getPackageManager().queryIntentActivities(new Intent("android.intent.action.ASSIST"), 65536);
        int r1 = 0;
    L4:
        if (r1 >= r0.size()) goto L6;
        ResolveInfo r2 = r0.get(r1);
        this.mAvailableAssistants.add(new Info(new ComponentName(r2.activityInfo.packageName, r2.activityInfo.name)));
        r1 = r1 + 1;
        goto L4
    }

    public ComponentName getCurrentAssist() {
        return this.mAssistUtils.getAssistComponentForUser(UserHandle.myUserId());
    }

    public void refreshAssistApps() {
        this.mAvailableAssistants.clear();
        addAssistServices();
        addAssistActivities();
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= this.mAvailableAssistants.size()) goto L10;
        String r2 = this.mAvailableAssistants.get(r1).component.getPackageName();
        if (r0.contains(r2) == true) goto L9;
        r0.add(r2);
    L9:
        r1 = r1 + 1;
        goto L4
    L10:
        ComponentName r3 = getCurrentAssist();
        CharSequence[] r4 = (CharSequence[]) r0.toArray(new String[r0.size()]);
        if (r3 != null) goto L13;
        String r5 = null;
    L14:
        setPackageNames(r4, r5);
        return;
    L13:
        r5 = r3.getPackageName();
        goto L14
    }
}
