package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class FindPasswordQuestionSettingsBinding implements ViewBinding {
    public final EditText answerEditor;
    public final TextView countdownText;
    private final RelativeLayout rootView;
    public final Spinner spinner;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FindPasswordQuestionSettingsBinding(RelativeLayout r1, EditText r2, TextView r3, Spinner r4, OFloatingTitleBar r5) {
        this.rootView = r1;
        this.answerEditor = r2;
        this.countdownText = r3;
        this.spinner = r4;
        this.viewTitle = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FindPasswordQuestionSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FindPasswordQuestionSettingsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.find_password_question_settings, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FindPasswordQuestionSettingsBinding bind(View r8) {
        int r0 = R.id.answer_editor;
        EditText r4 = (EditText) ViewBindings.findChildViewById(r8, R.id.answer_editor);
        if (r4 == null) goto L13;
        r0 = R.id.countdown_text;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r8, R.id.countdown_text);
        if (r5 == null) goto L13;
        r0 = R.id.spinner;
        Spinner r6 = (Spinner) ViewBindings.findChildViewById(r8, R.id.spinner);
        if (r6 == null) goto L13;
        r0 = R.id.view_title;
        OFloatingTitleBar r7 = (OFloatingTitleBar) ViewBindings.findChildViewById(r8, R.id.view_title);
        if (r7 == null) goto L13;
        return new FindPasswordQuestionSettingsBinding((RelativeLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
