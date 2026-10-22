package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class UserDictionaryAddWordFullscreenBinding implements ViewBinding {
    public final EditText edittext;
    private final LinearLayout rootView;
    public final LinearLayout userDictSettingsAddDialogTop;
    public final Spinner userDictionaryAddLocale;
    public final TextView userDictionaryAddLocaleLabel;
    public final EditText userDictionaryAddShortcut;
    public final TextView userDictionaryAddShortcutLabel;
    public final GridLayout userDictionaryAddWordGrid;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private UserDictionaryAddWordFullscreenBinding(LinearLayout r1, EditText r2, LinearLayout r3, Spinner r4, TextView r5, EditText r6, TextView r7, GridLayout r8) {
        this.rootView = r1;
        this.edittext = r2;
        this.userDictSettingsAddDialogTop = r3;
        this.userDictionaryAddLocale = r4;
        this.userDictionaryAddLocaleLabel = r5;
        this.userDictionaryAddShortcut = r6;
        this.userDictionaryAddShortcutLabel = r7;
        this.userDictionaryAddWordGrid = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static UserDictionaryAddWordFullscreenBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static UserDictionaryAddWordFullscreenBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.user_dictionary_add_word_fullscreen, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static UserDictionaryAddWordFullscreenBinding bind(View r11) {
        int r0 = R.id.edittext;
        EditText r4 = (EditText) ViewBindings.findChildViewById(r11, R.id.edittext);
        if (r4 == null) goto L17;
        LinearLayout r5 = (LinearLayout) r11;
        r0 = R.id.user_dictionary_add_locale;
        Spinner r6 = (Spinner) ViewBindings.findChildViewById(r11, R.id.user_dictionary_add_locale);
        if (r6 == null) goto L17;
        r0 = R.id.user_dictionary_add_locale_label;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r11, R.id.user_dictionary_add_locale_label);
        if (r7 == null) goto L17;
        r0 = R.id.user_dictionary_add_shortcut;
        EditText r8 = (EditText) ViewBindings.findChildViewById(r11, R.id.user_dictionary_add_shortcut);
        if (r8 == null) goto L17;
        r0 = R.id.user_dictionary_add_shortcut_label;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r11, R.id.user_dictionary_add_shortcut_label);
        if (r9 == null) goto L17;
        r0 = R.id.user_dictionary_add_word_grid;
        GridLayout r10 = (GridLayout) ViewBindings.findChildViewById(r11, R.id.user_dictionary_add_word_grid);
        if (r10 == null) goto L17;
        return new UserDictionaryAddWordFullscreenBinding(r5, r4, r5, r6, r7, r8, r9, r10);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
