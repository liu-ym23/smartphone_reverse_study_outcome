package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class IdeaPillsShortcutDialogLayoutBinding implements ViewBinding {
    public final ImageView idIntroImage;
    public final TextView idMessage;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private IdeaPillsShortcutDialogLayoutBinding(LinearLayout r1, ImageView r2, TextView r3) {
        this.rootView = r1;
        this.idIntroImage = r2;
        this.idMessage = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static IdeaPillsShortcutDialogLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static IdeaPillsShortcutDialogLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.idea_pills_shortcut_dialog_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static IdeaPillsShortcutDialogLayoutBinding bind(View r3) {
        int r0 = R.id.id_intro_image;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r3, R.id.id_intro_image);
        if (r1 == null) goto L9;
        r0 = R.id.id_message;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, R.id.id_message);
        if (r2 == null) goto L9;
        return new IdeaPillsShortcutDialogLayoutBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
