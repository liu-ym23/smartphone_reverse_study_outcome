package com.android.settingslib.development;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemProperties;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import com.android.settingslib.R;
import com.android.settingslib.core.ConfirmationDialogController;
import com.android.settingslib.core.lifecycle.Lifecycle;
import com.android.settingslib.core.lifecycle.LifecycleObserver;
import com.android.settingslib.core.lifecycle.events.OnCreate;
import com.android.settingslib.core.lifecycle.events.OnDestroy;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractLogpersistPreferenceController extends DeveloperOptionsPreferenceController implements Preference.OnPreferenceChangeListener, LifecycleObserver, OnCreate, OnDestroy, ConfirmationDialogController {
    static final String ACTUAL_LOGPERSIST_PROPERTY = "logd.logpersistd";
    static final String ACTUAL_LOGPERSIST_PROPERTY_BUFFER = "logd.logpersistd.buffer";
    private static final String ACTUAL_LOGPERSIST_PROPERTY_ENABLE = "logd.logpersistd.enable";
    private static final String SELECT_LOGPERSIST_KEY = "select_logpersist";
    private static final String SELECT_LOGPERSIST_PROPERTY = "persist.logd.logpersistd";
    private static final String SELECT_LOGPERSIST_PROPERTY_BUFFER = "persist.logd.logpersistd.buffer";
    private static final String SELECT_LOGPERSIST_PROPERTY_CLEAR = "clear";
    static final String SELECT_LOGPERSIST_PROPERTY_SERVICE = "logcatd";
    private static final String SELECT_LOGPERSIST_PROPERTY_STOP = "stop";
    private ListPreference mLogpersist;
    private boolean mLogpersistCleared;
    private final BroadcastReceiver mReceiver;

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public String getPreferenceKey() {
        return SELECT_LOGPERSIST_KEY;
    }

    static /* synthetic */ void access$000(AbstractLogpersistPreferenceController r0, String r1) {
        r0.onLogdSizeSettingUpdate(r1);
    }

    public AbstractLogpersistPreferenceController(Context r1, Lifecycle r2) {
        super(r1);
        this.mReceiver = new AnonymousClass1(this);
        if (isAvailable() == false) goto L7;
        if (r2 == null) goto L8;
        r2.addObserver(this);
        return;
    L8:
        return;
    }

    @Override // com.android.settingslib.development.DeveloperOptionsPreferenceController, com.android.settingslib.core.AbstractPreferenceController
    public boolean isAvailable() {
        return TextUtils.equals(SystemProperties.get("ro.debuggable", "0"), "1");
    }

    @Override // com.android.settingslib.development.DeveloperOptionsPreferenceController, com.android.settingslib.core.AbstractPreferenceController
    public void displayPreference(PreferenceScreen r2) {
        super.displayPreference(r2);
        if (isAvailable() == false) goto L6;
        this.mLogpersist = (ListPreference) r2.findPreference(SELECT_LOGPERSIST_KEY);
        return;
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference r3, Object r4) {
        if (r3 != this.mLogpersist) goto L6;
        writeLogpersistOption(r4, false);
        return true;
    L6:
        return false;
    }

    @Override // com.android.settingslib.core.lifecycle.events.OnCreate
    public void onCreate(Bundle r3) {
        LocalBroadcastManager.getInstance(this.mContext).registerReceiver(this.mReceiver, new IntentFilter(AbstractLogdSizePreferenceController.ACTION_LOGD_SIZE_UPDATED));
    }

    @Override // com.android.settingslib.core.lifecycle.events.OnDestroy
    public void onDestroy() {
        LocalBroadcastManager.getInstance(this.mContext).unregisterReceiver(this.mReceiver);
    }

    public void enablePreference(boolean r2) {
        if (isAvailable() == false) goto L6;
        this.mLogpersist.setEnabled(r2);
        return;
    }

    private void onLogdSizeSettingUpdate(String r4) {
        if (this.mLogpersist == null) goto L16;
        String r0 = SystemProperties.get(ACTUAL_LOGPERSIST_PROPERTY_ENABLE);
        if (r0 != null) goto L7;
    L14:
        writeLogpersistOption(null, true);
        this.mLogpersist.setEnabled(false);
        return;
    L7:
        if (r0.equals("true") == false) goto L14;
        if (r4.equals("32768") == true) goto L14;
        if (DevelopmentSettingsEnabler.isDevelopmentSettingsEnabled(this.mContext) == false) goto L17;
        this.mLogpersist.setEnabled(true);
        return;
    L17:
        return;
    }

    public void updateLogpersistValues() {
        if (this.mLogpersist != null) goto L5;
        return;
    L5:
        String r1 = SystemProperties.get(ACTUAL_LOGPERSIST_PROPERTY);
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        String r2 = SystemProperties.get(ACTUAL_LOGPERSIST_PROPERTY_BUFFER);
        if (r2 != null) goto L11;
    L12:
        r2 = WsChannelMultiProcessSharedProvider.ALL_TYPE;
    L14:
        if (r1.equals(SELECT_LOGPERSIST_PROPERTY_SERVICE) == true) goto L16;
        char r3 = 0;
    L38:
        this.mLogpersist.setValue(this.mContext.getResources().getStringArray(R.array.select_logpersist_values)[r3]);
        this.mLogpersist.setSummary(this.mContext.getResources().getStringArray(R.array.select_logpersist_summaries)[r3]);
        if (r3 == 0) goto L42;
        this.mLogpersistCleared = false;
        return;
    L42:
        if (this.mLogpersistCleared == true) goto L48;
        SystemProperties.set(ACTUAL_LOGPERSIST_PROPERTY, SELECT_LOGPERSIST_PROPERTY_CLEAR);
        SystemPropPoker.getInstance().poke();
        this.mLogpersistCleared = true;
        return;
    L48:
        return;
    L16:
        if (r2.equals("kernel") == false) goto L19;
        r3 = 3;
        goto L38
    L19:
        if (r2.equals(WsChannelMultiProcessSharedProvider.ALL_TYPE) == false) goto L21;
    L36:
        r3 = 1;
        goto L38
    L21:
        if (r2.contains("radio") == true) goto L36;
        if (r2.contains("security") == false) goto L36;
        if (r2.contains("kernel") == false) goto L36;
        if (r2.contains("default") == true) goto L35;
        String[] r4 = {"main", "events", SettingsSwitchKeyUtil.SettingTable.System, "crash"};
        int r5 = 0;
    L30:
        if (r5 >= 4) goto L35;
        if (r2.contains(r4[r5]) == false) goto L36;
        r5 = r5 + 1;
    L35:
        r3 = 2;
        goto L38
    L11:
        if (r2.length() != 0) goto L14;
        goto L12
    }

    protected void setLogpersistOff(boolean r6) {
        SystemProperties.set(SELECT_LOGPERSIST_PROPERTY_BUFFER, "");
        SystemProperties.set(ACTUAL_LOGPERSIST_PROPERTY_BUFFER, "");
        SystemProperties.set(SELECT_LOGPERSIST_PROPERTY, "");
        if (r6 == false) goto L5;
        String r0 = "";
    L6:
        SystemProperties.set(ACTUAL_LOGPERSIST_PROPERTY, r0);
        SystemPropPoker.getInstance().poke();
        if (r6 == false) goto L9;
        updateLogpersistValues();
        return;
    L9:
        int r5 = 0;
    L11:
        if (r5 >= 3) goto L28;
        String r7 = SystemProperties.get(ACTUAL_LOGPERSIST_PROPERTY);
        if (r7 == null) goto L29;
        if (r7.equals("") == true) goto L30;
        Thread.sleep(100);     // Catch: InterruptedException -> L21
    L19:
        r5 = r5 + 1;
        goto L11
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L5:
        r0 = SELECT_LOGPERSIST_PROPERTY_STOP;
        goto L6
    }

    public void writeLogpersistOption(Object r7, boolean r8) {
        if (this.mLogpersist != null) goto L5;
        return;
    L5:
        String r0 = SystemProperties.get("persist.log.tag");
        if (r0 != null) goto L8;
    L10:
        int r3 = 0;
        if (r7 != null) goto L13;
    L33:
        if (r8 == false) goto L36;
        this.mLogpersistCleared = false;
    L43:
        setLogpersistOff(true);
        return;
    L36:
        if (this.mLogpersistCleared == true) goto L43;
        String r9 = SystemProperties.get(ACTUAL_LOGPERSIST_PROPERTY);
        if (r9 == null) goto L43;
        if (r9.equals(SELECT_LOGPERSIST_PROPERTY_SERVICE) == false) goto L43;
        showConfirmationDialog(this.mLogpersist);
        return;
    L13:
        if (r7.toString().equals("") == true) goto L33;
        String r10 = SystemProperties.get(ACTUAL_LOGPERSIST_PROPERTY_BUFFER);
        if (r10 != null) goto L18;
    L20:
        SystemProperties.set(SELECT_LOGPERSIST_PROPERTY_BUFFER, r7.toString());
        SystemProperties.set(SELECT_LOGPERSIST_PROPERTY, SELECT_LOGPERSIST_PROPERTY_SERVICE);
        SystemPropPoker.getInstance().poke();
    L22:
        if (r3 >= 3) goto L31;
        String r11 = SystemProperties.get(ACTUAL_LOGPERSIST_PROPERTY);
        if (r11 == null) goto L46;
        if (r11.equals(SELECT_LOGPERSIST_PROPERTY_SERVICE) == true) goto L31;
    L46:
        Thread.sleep(100);     // Catch: InterruptedException -> L45
    L30:
        r3 = r3 + 1;
    L31:
        updateLogpersistValues();
        return;
    L18:
        if (r10.equals(r7.toString()) == true) goto L20;
        setLogpersistOff(false);
        goto L20
    L8:
        if (r0.startsWith("Settings") == false) goto L10;
        r7 = null;
        r8 = true;
        goto L10
    }
}
