package com.android.settings.widget;

import android.content.Context;
import android.view.View;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.R;

/* JADX INFO: loaded from: classes.dex */
public class FakePreference extends Preference {
    private CharSequence title;

    public FakePreference(Context r1) {
        super(r1);
        setLayoutResource(R.layout.fake_preference);
    }

    public FakePreference(Context r1, int r2) {
        this(r1);
        this.title = r1.getResources().getString(r2);
    }

    public FakePreference(Context r1, CharSequence r2) {
        this(r1);
        this.title = r2;
    }

    public FakePreference update() {
        CharSequence r0 = this.title;
        if (r0 == null) goto L5;
        setTitle(r0);
    L5:
        return this;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r2) {
        super.onBindViewHolder(r2);
        View r3 = r2.itemView;
        r3.setClickable(false);
        r3.setFocusable(false);
        r3.setOnTouchListener(new AnonymousClass1(this));
    }
}
