package com.android.settingslib.development;

import android.content.Context;
import android.content.Intent;
import android.os.SystemProperties;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import com.android.settingslib.R;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractLogdSizePreferenceController extends DeveloperOptionsPreferenceController implements Preference.OnPreferenceChangeListener {
    public static final String ACTION_LOGD_SIZE_UPDATED = "com.android.settingslib.development.AbstractLogdSizePreferenceController.LOGD_SIZE_UPDATED";
    static final String DEFAULT_SNET_TAG = "I";
    public static final String EXTRA_CURRENT_LOGD_VALUE = "CURRENT_LOGD_VALUE";
    static final String LOW_RAM_CONFIG_PROPERTY_KEY = "ro.config.low_ram";
    private static final String SELECT_LOGD_DEFAULT_SIZE_PROPERTY = "ro.logd.size";
    static final String SELECT_LOGD_DEFAULT_SIZE_VALUE = "262144";
    static final String SELECT_LOGD_MINIMUM_SIZE_VALUE = "65536";
    static final String SELECT_LOGD_OFF_SIZE_MARKER_VALUE = "32768";
    private static final String SELECT_LOGD_RUNTIME_SNET_TAG_PROPERTY = "log.tag.snet_event_log";
    private static final String SELECT_LOGD_SIZE_KEY = "select_logd_size";
    static final String SELECT_LOGD_SIZE_PROPERTY = "persist.logd.size";
    static final String SELECT_LOGD_SNET_TAG_PROPERTY = "persist.log.tag.snet_event_log";
    private static final String SELECT_LOGD_SVELTE_DEFAULT_SIZE_VALUE = "65536";
    static final String SELECT_LOGD_TAG_PROPERTY = "persist.log.tag";
    static final String SELECT_LOGD_TAG_SILENCE = "Settings";
    private ListPreference mLogdSize;

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public String getPreferenceKey() {
        return SELECT_LOGD_SIZE_KEY;
    }

    public AbstractLogdSizePreferenceController(Context r1) {
        super(r1);
    }

    @Override // com.android.settingslib.development.DeveloperOptionsPreferenceController, com.android.settingslib.core.AbstractPreferenceController
    public void displayPreference(PreferenceScreen r2) {
        super.displayPreference(r2);
        if (isAvailable() == false) goto L6;
        this.mLogdSize = (ListPreference) r2.findPreference(SELECT_LOGD_SIZE_KEY);
        return;
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference r2, Object r3) {
        if (r2 != this.mLogdSize) goto L6;
        writeLogdSizeOption(r3);
        return true;
    L6:
        return false;
    }

    public void enablePreference(boolean r2) {
        if (isAvailable() == false) goto L6;
        this.mLogdSize.setEnabled(r2);
        return;
    }

    private String defaultLogdSizeValue() {
        String r1 = SystemProperties.get(SELECT_LOGD_DEFAULT_SIZE_PROPERTY);
        if (r1 == null) goto L7;
        if (r1.length() == 0) goto L7;
        return r1;
    L7:
        if (SystemProperties.get(LOW_RAM_CONFIG_PROPERTY_KEY).equals("true") == false) goto L9;
        return "65536";
    L9:
        return SELECT_LOGD_DEFAULT_SIZE_VALUE;
    }

    public void updateLogdSizeValues() {
        if (this.mLogdSize == null) goto L33;
        String r0 = SystemProperties.get(SELECT_LOGD_TAG_PROPERTY);
        String r1 = SystemProperties.get(SELECT_LOGD_SIZE_PROPERTY);
        if (r0 != null) goto L7;
    L9:
        LocalBroadcastManager.getInstance(this.mContext).sendBroadcastSync(new Intent(ACTION_LOGD_SIZE_UPDATED).putExtra(EXTRA_CURRENT_LOGD_VALUE, r1));
        if (r1 != null) goto L12;
    L13:
        r1 = defaultLogdSizeValue();
    L14:
        String[] r2 = this.mContext.getResources().getStringArray(R.array.select_logd_size_values);
        String[] r3 = this.mContext.getResources().getStringArray(R.array.select_logd_size_titles);
        if (SystemProperties.get(LOW_RAM_CONFIG_PROPERTY_KEY).equals("true") == false) goto L17;
        this.mLogdSize.setEntries(R.array.select_logd_size_lowram_titles);
        r3 = this.mContext.getResources().getStringArray(R.array.select_logd_size_lowram_titles);
        int r4 = 1;
    L18:
        String[] r5 = this.mContext.getResources().getStringArray(R.array.select_logd_size_summaries);
        int r6 = 0;
    L20:
        if (r6 >= r3.length) goto L28;
        if (r1.equals(r2[r6]) == true) goto L27;
        if (r1.equals(r3[r6]) == true) goto L27;
        r6 = r6 + 1;
    L27:
        r4 = r6;
    L28:
        this.mLogdSize.setValue(r2[r4]);
        this.mLogdSize.setSummary(r5[r4]);
        return;
    L17:
        r4 = 2;
        goto L18
    L12:
        if (r1.length() != 0) goto L14;
    L7:
        if (r0.startsWith(SELECT_LOGD_TAG_SILENCE) == false) goto L9;
        r1 = SELECT_LOGD_OFF_SIZE_MARKER_VALUE;
        goto L9
    }

    public void writeLogdSizeOption(Object r8) {
        if (r8 != null) goto L4;
    L6:
        boolean r0 = false;
    L7:
        String r2 = SystemProperties.get(SELECT_LOGD_TAG_PROPERTY);
        String r3 = "";
        if (r2 != null) goto L10;
        r2 = "";
    L10:
        String r4 = r2.replaceAll(",+Settings", "").replaceFirst("^Settings,*", "").replaceAll(",+", ",").replaceFirst(",+$", "");
        if (r0 == false) goto L26;
        String r1 = SystemProperties.get(SELECT_LOGD_SNET_TAG_PROPERTY);
        if (r1 != null) goto L15;
    L16:
        String r5 = SystemProperties.get(SELECT_LOGD_RUNTIME_SNET_TAG_PROPERTY);
        if (r5 != null) goto L19;
    L20:
        SystemProperties.set(SELECT_LOGD_SNET_TAG_PROPERTY, DEFAULT_SNET_TAG);
    L22:
        if (r4.length() == 0) goto L24;
        r4 = "," + r4;
    L24:
        r4 = SELECT_LOGD_TAG_SILENCE + r4;
        r8 = "65536";
        goto L26
    L19:
        if (r5.length() != 0) goto L22;
    L15:
        if (r1.length() != 0) goto L22;
    L26:
        if (r4.equals(r2) == true) goto L28;
        SystemProperties.set(SELECT_LOGD_TAG_PROPERTY, r4);
    L28:
        String r6 = defaultLogdSizeValue();
        if (r8 != null) goto L31;
    L33:
        String r9 = r6;
    L35:
        if (r6.equals(r9) == true) goto L38;
        r3 = r9;
    L38:
        SystemProperties.set(SELECT_LOGD_SIZE_PROPERTY, r3);
        SystemProperties.set("ctl.start", "logd-reinit");
        SystemPropPoker.getInstance().poke();
        updateLogdSizeValues();
        return;
    L31:
        if (r8.toString().length() == 0) goto L33;
        r9 = r8.toString();
        goto L35
    L4:
        if (r8.toString().equals(SELECT_LOGD_OFF_SIZE_MARKER_VALUE) == false) goto L6;
        r0 = true;
        goto L7
    }
}
