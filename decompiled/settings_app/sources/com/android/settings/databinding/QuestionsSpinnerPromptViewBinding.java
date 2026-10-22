package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class QuestionsSpinnerPromptViewBinding implements ViewBinding {
    public final TextView promptView;
    private final TextView rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private QuestionsSpinnerPromptViewBinding(TextView r1, TextView r2) {
        this.rootView = r1;
        this.promptView = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextView getRoot() {
        return this.rootView;
    }

    public static QuestionsSpinnerPromptViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static QuestionsSpinnerPromptViewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.questions_spinner_prompt_view, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static QuestionsSpinnerPromptViewBinding bind(View r1) {
        if (r1 == null) goto L6;
        TextView r2 = (TextView) r1;
        return new QuestionsSpinnerPromptViewBinding(r2, r2);
    L6:
        throw new NullPointerException("rootView");
    }
}
