package androidx.preference;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class EditTextPreferenceDialogFragment extends PreferenceDialogFragment {
    private static final String SAVE_STATE_TEXT = "EditTextPreferenceDialogFragment.text";
    private EditText mEditText;
    private CharSequence mText;

    @Override // androidx.preference.PreferenceDialogFragment
    protected boolean needInputMethod() {
        return true;
    }

    @Deprecated
    public EditTextPreferenceDialogFragment() {
    }

    @Deprecated
    public static EditTextPreferenceDialogFragment newInstance(String r3) {
        EditTextPreferenceDialogFragment r0 = new EditTextPreferenceDialogFragment();
        Bundle r1 = new Bundle(1);
        r1.putString("key", r3);
        r0.setArguments(r1);
        return r0;
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (r2 != null) goto L5;
        this.mText = getEditTextPreference().getText();
        return;
    L5:
        this.mText = r2.getCharSequence(SAVE_STATE_TEXT);
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        r2.putCharSequence(SAVE_STATE_TEXT, this.mText);
    }

    @Override // androidx.preference.PreferenceDialogFragment
    protected void onBindDialogView(View r2) {
        super.onBindDialogView(r2);
        EditText r3 = (EditText) r2.findViewById(android.R.id.edit);
        this.mEditText = r3;
        r3.requestFocus();
        EditText r4 = this.mEditText;
        if (r4 == null) goto L7;
        r4.setText(this.mText);
        EditText r1 = this.mEditText;
        r1.setSelection(r1.getText().length());
        return;
    L7:
        throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
    }

    private EditTextPreference getEditTextPreference() {
        return (EditTextPreference) getPreference();
    }

    @Override // androidx.preference.PreferenceDialogFragment
    @Deprecated
    public void onDialogClosed(boolean r2) {
        if (r2 == false) goto L7;
        String r3 = this.mEditText.getText().toString();
        if (getEditTextPreference().callChangeListener(r3) == false) goto L8;
        getEditTextPreference().setText(r3);
        return;
    L8:
        return;
    }
}
