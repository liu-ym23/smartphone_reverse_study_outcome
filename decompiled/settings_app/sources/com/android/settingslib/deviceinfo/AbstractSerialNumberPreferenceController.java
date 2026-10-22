package com.android.settingslib.deviceinfo;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import com.android.settingslib.core.AbstractPreferenceController;

/* JADX INFO: loaded from: classes.dex */
public class AbstractSerialNumberPreferenceController extends AbstractPreferenceController {
    static final String KEY_SERIAL_NUMBER = "serial_number";
    private final String mSerialNumber;

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public String getPreferenceKey() {
        return "serial_number";
    }

    public AbstractSerialNumberPreferenceController(Context r2) {
        this(r2, Build.getSerial());
    }

    AbstractSerialNumberPreferenceController(Context r1, String r2) {
        super(r1);
        this.mSerialNumber = r2;
    }

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public boolean isAvailable() {
        return !TextUtils.isEmpty(this.mSerialNumber);
    }

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public void displayPreference(PreferenceScreen r2) {
        super.displayPreference(r2);
        Preference r3 = r2.findPreference("serial_number");
        if (r3 == null) goto L6;
        r3.setSummary(this.mSerialNumber);
        return;
    }
}
