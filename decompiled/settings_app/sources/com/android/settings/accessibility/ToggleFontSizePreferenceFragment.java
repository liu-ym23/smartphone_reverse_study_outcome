package com.android.settings.accessibility;

import android.content.ContentResolver;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.Settings;
import com.android.settings.PreviewSeekBarPreferenceFragment;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class ToggleFontSizePreferenceFragment extends PreviewSeekBarPreferenceFragment {
    private float[] mValues;

    public ToggleFontSizePreferenceFragment() {
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r5) {
        super.onCreate(r5);
        this.mActivityLayoutResId = R.layout.font_size_activity;
        int r1 = 0;
        this.mPreviewSampleResIds = new int[]{R.layout.font_size_preview};
        Resources r6 = getContext().getResources();
        ContentResolver r0 = getContext().getContentResolver();
        this.mEntries = r6.getStringArray(R.array.entries_font_size);
        String[] r7 = r6.getStringArray(R.array.entryvalues_font_size);
        this.mInitialIndex = fontSizeValueToIndex(Settings.System.getFloat(r0, "font_scale", 1.0f), r7);
        this.mValues = new float[r7.length];
    L4:
        if (r1 >= r7.length) goto L6;
        this.mValues[r1] = Float.parseFloat(r7[r1]);
        r1 = r1 + 1;
        goto L4
    }

    @Override // com.android.settings.PreviewSeekBarPreferenceFragment
    protected Configuration createConfig(Configuration r2, int r3) {
        Configuration r0 = new Configuration(r2);
        r0.fontScale = this.mValues[r3];
        return r0;
    }

    @Override // com.android.settings.PreviewSeekBarPreferenceFragment
    protected void commit() {
        if (getContext() != null) goto L5;
        return;
    L5:
        Settings.System.putFloat(getContext().getContentResolver(), "font_scale", this.mValues[this.mCurrentIndex]);
    }

    public static int fontSizeValueToIndex(float r6, String[] r7) {
        float r0 = Float.parseFloat(r7[0]);
        int r2 = 1;
    L4:
        if (r2 >= r7.length) goto L11;
        float r3 = Float.parseFloat(r7[r2]);
        if (r6 < (r0 + ((r3 - r0) * 0.5f))) goto L8;
        r2 = r2 + 1;
        r0 = r3;
        goto L4
    L8:
        return r2 - 1;
    L11:
        return r7.length - 1;
    }
}
