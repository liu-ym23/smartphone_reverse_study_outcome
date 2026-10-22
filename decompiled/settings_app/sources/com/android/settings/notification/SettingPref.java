package com.android.settings.notification;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.provider.Settings;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.DropDownPreference;
import androidx.preference.Preference;
import androidx.preference.TwoStatePreference;
import com.android.settings.SettingsPreferenceFragment;

/* JADX INFO: loaded from: classes2.dex */
public class SettingPref {
    public static final int TYPE_GLOBAL = 1;
    public static final int TYPE_SYSTEM = 2;
    protected final int mDefault;
    protected DropDownPreference mDropDown;
    private final String mKey;
    protected final String mSetting;
    protected TwoStatePreference mTwoState;
    protected final int mType;
    private final Uri mUri;
    private final int[] mValues;

    public boolean isApplicable(Context r1) {
        return true;
    }

    public SettingPref(int r1, String r2, String r3, int r4, int... r5) {
        this.mType = r1;
        this.mKey = r2;
        this.mSetting = r3;
        this.mDefault = r4;
        this.mValues = r5;
        this.mUri = getUriFor(r1, r3);
    }

    protected String getCaption(Resources r1, int r2) {
        throw new UnsupportedOperationException();
    }

    public Preference init(SettingsPreferenceFragment r8) {
        final FragmentActivity r0 = r8.getActivity();
        Preference r1 = r8.getPreferenceScreen().findPreference(this.mKey);
        if (r1 == null) goto L8;
        if (isApplicable(r0) == true) goto L8;
        r8.getPreferenceScreen().removePreference(r1);
        r1 = null;
    L8:
        if ((r1 instanceof TwoStatePreference) == false) goto L11;
        this.mTwoState = (TwoStatePreference) r1;
    L17:
        update(r0);
        if (this.mTwoState == null) goto L22;
        r1.setOnPreferenceChangeListener(new AnonymousClass1(this, r0));
        return this.mTwoState;
    L22:
        if (this.mDropDown == null) goto L25;
        r1.setOnPreferenceChangeListener(new AnonymousClass2(this, r0));
        return this.mDropDown;
    L25:
        return null;
    L11:
        if ((r1 instanceof DropDownPreference) == false) goto L17;
        this.mDropDown = (DropDownPreference) r1;
        int[] r9 = this.mValues;
        CharSequence[] r3 = new CharSequence[r9.length];
        CharSequence[] r10 = new CharSequence[r9.length];
        int r4 = 0;
    L14:
        if (r4 >= this.mValues.length) goto L16;
        r3[r4] = getCaption(r0.getResources(), this.mValues[r4]);
        r10[r4] = Integer.toString(this.mValues[r4]);
        r4 = r4 + 1;
        goto L14
    L16:
        this.mDropDown.setEntries(r3);
        this.mDropDown.setEntryValues(r10);
        goto L17
    }

    protected boolean setSetting(Context r2, int r3) {
        return putInt(this.mType, r2.getContentResolver(), this.mSetting, r3);
    }

    public Uri getUri() {
        return this.mUri;
    }

    public String getKey() {
        return this.mKey;
    }

    public void update(Context r4) {
        int r5 = getInt(this.mType, r4.getContentResolver(), this.mSetting, this.mDefault);
        TwoStatePreference r0 = this.mTwoState;
        if (r0 == null) goto L8;
        if (r5 == 0) goto L6;
        boolean r3 = true;
    L7:
        r0.setChecked(r3);
        return;
    L6:
        r3 = false;
        goto L7
    L8:
        DropDownPreference r6 = this.mDropDown;
        if (r6 == null) goto L13;
        r6.setValue(Integer.toString(r5));
        return;
    }

    private static Uri getUriFor(int r1, String r2) {
        if (r1 == 1) goto L11;
        if (r1 != 2) goto L9;
        return Settings.System.getUriFor(r2);
    L9:
        throw new IllegalArgumentException();
    L11:
        return Settings.Global.getUriFor(r2);
    }

    protected static boolean putInt(int r1, ContentResolver r2, String r3, int r4) {
        if (r1 == 1) goto L11;
        if (r1 != 2) goto L9;
        return Settings.System.putInt(r2, r3, r4);
    L9:
        throw new IllegalArgumentException();
    L11:
        return Settings.Global.putInt(r2, r3, r4);
    }

    protected static int getInt(int r1, ContentResolver r2, String r3, int r4) {
        if (r1 == 1) goto L11;
        if (r1 != 2) goto L9;
        return Settings.System.getInt(r2, r3, r4);
    L9:
        throw new IllegalArgumentException();
    L11:
        return Settings.Global.getInt(r2, r3, r4);
    }
}
