package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.HorizontalOptionCheckView;

/* JADX INFO: loaded from: classes2.dex */
public final class LongPressHomePreviewCheckLayoutBinding implements ViewBinding {
    public final HorizontalOptionCheckView accessTextRecognition;
    public final HorizontalOptionCheckView accessTextVoiceCommand;
    public final HorizontalOptionCheckView idHomeLongPress;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private LongPressHomePreviewCheckLayoutBinding(LinearLayout r1, HorizontalOptionCheckView r2, HorizontalOptionCheckView r3, HorizontalOptionCheckView r4) {
        this.rootView = r1;
        this.accessTextRecognition = r2;
        this.accessTextVoiceCommand = r3;
        this.idHomeLongPress = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LongPressHomePreviewCheckLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LongPressHomePreviewCheckLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.long_press_home_preview_check_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static LongPressHomePreviewCheckLayoutBinding bind(View r4) {
        int r0 = R.id.access_text_recognition;
        HorizontalOptionCheckView r1 = (HorizontalOptionCheckView) ViewBindings.findChildViewById(r4, R.id.access_text_recognition);
        if (r1 == null) goto L11;
        r0 = R.id.access_text_voice_command;
        HorizontalOptionCheckView r2 = (HorizontalOptionCheckView) ViewBindings.findChildViewById(r4, R.id.access_text_voice_command);
        if (r2 == null) goto L11;
        r0 = R.id.id_home_long_press;
        HorizontalOptionCheckView r3 = (HorizontalOptionCheckView) ViewBindings.findChildViewById(r4, R.id.id_home_long_press);
        if (r3 == null) goto L11;
        return new LongPressHomePreviewCheckLayoutBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
