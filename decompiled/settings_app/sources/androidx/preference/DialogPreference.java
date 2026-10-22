package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.TypedArrayUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class DialogPreference extends Preference {
    private Drawable mDialogIcon;
    private int mDialogLayoutResId;
    private CharSequence mDialogMessage;
    private CharSequence mDialogTitle;
    private CharSequence mNegativeButtonText;
    private CharSequence mPositiveButtonText;

    public interface TargetFragment {
        <T extends Preference> T findPreference(CharSequence r1);
    }

    public DialogPreference(Context r2, AttributeSet r3, int r4, int r5) {
        super(r2, r3, r4, r5);
        TypedArray r6 = r2.obtainStyledAttributes(r3, R.styleable.DialogPreference, r4, r5);
        String r7 = TypedArrayUtils.getString(r6, R.styleable.DialogPreference_dialogTitle, R.styleable.DialogPreference_android_dialogTitle);
        this.mDialogTitle = r7;
        if (r7 != null) goto L5;
        this.mDialogTitle = getTitle();
    L5:
        this.mDialogMessage = TypedArrayUtils.getString(r6, R.styleable.DialogPreference_dialogMessage, R.styleable.DialogPreference_android_dialogMessage);
        this.mDialogIcon = TypedArrayUtils.getDrawable(r6, R.styleable.DialogPreference_dialogIcon, R.styleable.DialogPreference_android_dialogIcon);
        this.mPositiveButtonText = TypedArrayUtils.getString(r6, R.styleable.DialogPreference_positiveButtonText, R.styleable.DialogPreference_android_positiveButtonText);
        this.mNegativeButtonText = TypedArrayUtils.getString(r6, R.styleable.DialogPreference_negativeButtonText, R.styleable.DialogPreference_android_negativeButtonText);
        this.mDialogLayoutResId = TypedArrayUtils.getResourceId(r6, R.styleable.DialogPreference_dialogLayout, R.styleable.DialogPreference_android_dialogLayout, 0);
        r6.recycle();
    }

    public DialogPreference(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public DialogPreference(Context r3, AttributeSet r4) {
        this(r3, r4, TypedArrayUtils.getAttr(r3, R.attr.dialogPreferenceStyle, android.R.attr.dialogPreferenceStyle));
    }

    public DialogPreference(Context r2) {
        this(r2, null);
    }

    public void setDialogTitle(CharSequence r1) {
        this.mDialogTitle = r1;
    }

    public void setDialogTitle(int r2) {
        setDialogTitle(getContext().getString(r2));
    }

    public CharSequence getDialogTitle() {
        return this.mDialogTitle;
    }

    public void setDialogMessage(CharSequence r1) {
        this.mDialogMessage = r1;
    }

    public void setDialogMessage(int r2) {
        setDialogMessage(getContext().getString(r2));
    }

    public CharSequence getDialogMessage() {
        return this.mDialogMessage;
    }

    public void setDialogIcon(Drawable r1) {
        this.mDialogIcon = r1;
    }

    public void setDialogIcon(int r2) {
        this.mDialogIcon = AppCompatResources.getDrawable(getContext(), r2);
    }

    public Drawable getDialogIcon() {
        return this.mDialogIcon;
    }

    public void setPositiveButtonText(CharSequence r1) {
        this.mPositiveButtonText = r1;
    }

    public void setPositiveButtonText(int r2) {
        setPositiveButtonText(getContext().getString(r2));
    }

    public CharSequence getPositiveButtonText() {
        return this.mPositiveButtonText;
    }

    public void setNegativeButtonText(CharSequence r1) {
        this.mNegativeButtonText = r1;
    }

    public void setNegativeButtonText(int r2) {
        setNegativeButtonText(getContext().getString(r2));
    }

    public CharSequence getNegativeButtonText() {
        return this.mNegativeButtonText;
    }

    public void setDialogLayoutResource(int r1) {
        this.mDialogLayoutResId = r1;
    }

    public int getDialogLayoutResource() {
        return this.mDialogLayoutResId;
    }

    @Override // androidx.preference.Preference
    protected void onClick() {
        getPreferenceManager().showDialog(this);
    }
}
