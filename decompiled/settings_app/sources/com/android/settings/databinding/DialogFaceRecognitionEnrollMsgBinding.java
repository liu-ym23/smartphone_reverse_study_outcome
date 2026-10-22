package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class DialogFaceRecognitionEnrollMsgBinding implements ViewBinding {
    public final OTextView note1;
    public final TextView note2;
    private final OScrollView rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DialogFaceRecognitionEnrollMsgBinding(OScrollView r1, OTextView r2, TextView r3) {
        this.rootView = r1;
        this.note1 = r2;
        this.note2 = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OScrollView getRoot() {
        return this.rootView;
    }

    public static DialogFaceRecognitionEnrollMsgBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DialogFaceRecognitionEnrollMsgBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.dialog_face_recognition_enroll_msg, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DialogFaceRecognitionEnrollMsgBinding bind(View r3) {
        int r0 = R.id.note_1;
        OTextView r1 = (OTextView) ViewBindings.findChildViewById(r3, R.id.note_1);
        if (r1 == null) goto L9;
        r0 = R.id.note_2;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, R.id.note_2);
        if (r2 == null) goto L9;
        return new DialogFaceRecognitionEnrollMsgBinding((OScrollView) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
