package com.android.settings;

import android.content.ClipboardManager;
import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;

/* JADX INFO: loaded from: classes2.dex */
public class CopyablePreference extends Preference {
    public CopyablePreference(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public CopyablePreference(Context r2) {
        this(r2, null);
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r3) {
        super.onBindViewHolder(r3);
        r3.setDividerAllowedAbove(true);
        r3.setDividerAllowedBelow(true);
        r3.itemView.setLongClickable(true);
        r3.itemView.setOnLongClickListener(new AnonymousClass1(this));
    }

    public CharSequence getCopyableText() {
        return getSummary();
    }

    public static void copyPreference(Context r1, CopyablePreference r2) {
        ((ClipboardManager) r1.getSystemService("clipboard")).setText(r2.getCopyableText());
        ToastUtils.show(r1, R.string.text_copied);
    }
}
