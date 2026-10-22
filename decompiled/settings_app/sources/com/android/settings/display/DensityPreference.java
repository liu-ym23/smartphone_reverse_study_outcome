package com.android.settings.display;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Slog;
import android.view.View;
import android.widget.EditText;
import com.android.settings.CustomEditTextPreference;
import com.android.settings.R;
import com.android.settingslib.display.DisplayDensityUtils;

/* JADX INFO: loaded from: classes2.dex */
public class DensityPreference extends CustomEditTextPreference {
    private static final String TAG = "DensityPreference";

    public DensityPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // androidx.preference.Preference
    public void onAttached() {
        super.onAttached();
        setSummary(getContext().getString(R.string.developer_density_summary, new Object[]{Integer.valueOf(getCurrentSwDp())}));
    }

    private int getCurrentSwDp() {
        DisplayMetrics r2 = getContext().getResources().getDisplayMetrics();
        return (int) (Math.min(r2.widthPixels, r2.heightPixels) / r2.density);
    }

    @Override // com.android.settings.CustomEditTextPreference
    protected void onBindDialogView(View r2) {
        super.onBindDialogView(r2);
        EditText r3 = (EditText) r2.findViewById(android.R.id.edit);
        if (r3 == null) goto L6;
        r3.setInputType(2);
        r3.setText(getCurrentSwDp() + "");
        return;
    }

    @Override // com.android.settings.CustomEditTextPreference
    protected void onDialogClosed(boolean r3) {
        if (r3 == false) goto L10;
        DisplayMetrics r4 = getContext().getResources().getDisplayMetrics();     // Catch: Exception -> L5
        int r0 = Math.max(Integer.parseInt(getText()), 320);     // Catch: Exception -> L5
        int r5 = Math.max((Math.min(r4.widthPixels, r4.heightPixels) * 160) / r0, 120);     // Catch: Exception -> L5
        new DisplayDensityUtils(getContext()).setForcedDisplayDensity(r5);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Couldn't save density", e);
        return;
    }
}
