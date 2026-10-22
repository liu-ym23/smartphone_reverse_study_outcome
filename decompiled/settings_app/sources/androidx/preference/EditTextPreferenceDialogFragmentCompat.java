package androidx.preference;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: classes.dex */
public class EditTextPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {
    private static final String SAVE_STATE_TEXT = "EditTextPreferenceDialogFragment.text";
    private EditText mEditText;
    private CharSequence mText;

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    protected boolean needInputMethod() {
        return true;
    }

    public EditTextPreferenceDialogFragmentCompat() {
    }

    public static EditTextPreferenceDialogFragmentCompat newInstance(String r3) {
        EditTextPreferenceDialogFragmentCompat r0 = new EditTextPreferenceDialogFragmentCompat();
        Bundle r1 = new Bundle(1);
        r1.putString("key", r3);
        r0.setArguments(r1);
        return r0;
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (r2 != null) goto L5;
        this.mText = getEditTextPreference().getText();
        return;
    L5:
        this.mText = r2.getCharSequence(SAVE_STATE_TEXT);
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        r2.putCharSequence(SAVE_STATE_TEXT, this.mText);
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    protected void onBindDialogView(View r2) {
        super.onBindDialogView(r2);
        EditText r3 = (EditText) r2.findViewById(android.R.id.edit);
        this.mEditText = r3;
        if (r3 == null) goto L9;
        r3.requestFocus();
        this.mEditText.setText(this.mText);
        EditText r4 = this.mEditText;
        r4.setSelection(r4.getText().length());
        if (getEditTextPreference().getOnBindEditTextListener() == null) goto L10;
        getEditTextPreference().getOnBindEditTextListener().onBindEditText(this.mEditText);
        return;
    L10:
        return;
    L9:
        throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
    }

    private EditTextPreference getEditTextPreference() {
        return (EditTextPreference) getPreference();
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    public void onDialogClosed(boolean r2) {
        if (r2 == false) goto L7;
        String r3 = this.mEditText.getText().toString();
        EditTextPreference r1 = getEditTextPreference();
        if (r1.callChangeListener(r3) == false) goto L8;
        r1.setText(r3);
        return;
    L8:
        return;
    }
}
