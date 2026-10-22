package com.android.settings.display;

import android.content.res.Configuration;
import android.os.Bundle;
import com.android.settings.PreviewSeekBarPreferenceFragment;
import com.android.settings.R;
import com.android.settings.search.Indexable;
import com.android.settingslib.display.DisplayDensityUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ScreenZoomSettings extends PreviewSeekBarPreferenceFragment implements Indexable {
    public static final Indexable.SearchIndexProvider SEARCH_INDEX_DATA_PROVIDER = null;
    private int mDefaultDensity;
    private int[] mValues;

    public ScreenZoomSettings() {
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        this.mActivityLayoutResId = R.layout.screen_zoom_activity;
        this.mPreviewSampleResIds = new int[]{R.layout.screen_zoom_preview_1, R.layout.screen_zoom_preview_2, R.layout.screen_zoom_preview_settings};
        DisplayDensityUtils r5 = new DisplayDensityUtils(getContext());
        int r0 = r5.getCurrentIndexForDefaultDisplay();
        if (r0 >= 0) goto L5;
        int r6 = getResources().getDisplayMetrics().densityDpi;
        this.mValues = new int[]{r6};
        this.mEntries = new String[]{getString(DisplayDensityUtils.SUMMARY_DEFAULT)};
        this.mInitialIndex = 0;
        this.mDefaultDensity = r6;
        return;
    L5:
        this.mValues = r5.getDefaultDisplayDensityValues();
        this.mEntries = r5.getDefaultDisplayDensityEntries();
        this.mInitialIndex = r0;
        this.mDefaultDensity = r5.getDefaultDensityForDefaultDisplay();
    }

    @Override // com.android.settings.PreviewSeekBarPreferenceFragment
    protected Configuration createConfig(Configuration r2, int r3) {
        Configuration r0 = new Configuration(r2);
        r0.densityDpi = this.mValues[r3];
        return r0;
    }

    @Override // com.android.settings.PreviewSeekBarPreferenceFragment
    protected void commit() {
        int r0 = this.mValues[this.mCurrentIndex];
        DisplayDensityUtils r1 = new DisplayDensityUtils(getContext());
        if (r0 != this.mDefaultDensity) goto L5;
        r1.clearForcedDisplayDensity();
        return;
    L5:
        r1.setForcedDisplayDensity(r0);
    }

    static {
        SEARCH_INDEX_DATA_PROVIDER = new AnonymousClass1();
    }
}
