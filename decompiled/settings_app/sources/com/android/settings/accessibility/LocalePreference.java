package com.android.settings.accessibility;

import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.ListPreference;
import com.android.internal.app.LocalePicker;
import com.android.settings.R;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class LocalePreference extends ListPreference {
    public LocalePreference(Context r1, AttributeSet r2) {
        super(r1, r2);
        init(r1);
    }

    public LocalePreference(Context r1) {
        super(r1);
        init(r1);
    }

    public void init(Context r7) {
        int r0 = 0;
        List r1 = LocalePicker.getAllAssetLocales(r7, false);
        int r2 = r1.size();
        int r3 = r2 + 1;
        CharSequence[] r4 = new CharSequence[r3];
        CharSequence[] r5 = new CharSequence[r3];
        r4[0] = r7.getResources().getString(R.string.locale_default);
        r5[0] = "";
    L3:
        if (r0 >= r2) goto L5;
        LocalePicker.LocaleInfo r8 = (LocalePicker.LocaleInfo) r1.get(r0);
        r0 = r0 + 1;
        r4[r0] = r8.toString();
        r5[r0] = r8.getLocale().toString();
        goto L3
    L5:
        setEntries(r4);
        setEntryValues(r5);
    }
}
