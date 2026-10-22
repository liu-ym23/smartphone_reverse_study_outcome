package com.android.settings.notification;

import android.R;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.settings.SettingsPreferenceFragment;

/* JADX INFO: loaded from: classes2.dex */
public abstract class EmptyTextSettings extends SettingsPreferenceFragment {
    private TextView mEmpty;

    public EmptyTextSettings() {
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View r4, Bundle r5) {
        super.onViewCreated(r4, r5);
        TextView r6 = new TextView(getContext());
        this.mEmpty = r6;
        r6.setGravity(17);
        TypedValue r7 = new TypedValue();
        getContext().getTheme().resolveAttribute(R.attr.textAppearanceMedium, r7, true);
        this.mEmpty.setTextAppearance(r7.resourceId);
        ((ViewGroup) r4.findViewById(R.id.list_container)).addView(this.mEmpty, new ViewGroup.LayoutParams(-1, -1));
        setEmptyView(this.mEmpty);
    }

    protected void setEmptyText(int r1) {
        this.mEmpty.setText(r1);
    }
}
