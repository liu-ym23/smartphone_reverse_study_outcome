package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.emoji2.viewsintegration.EmojiTextViewHelper;

/* JADX INFO: loaded from: classes.dex */
class AppCompatEmojiTextHelper {

    @NonNull
    private final EmojiTextViewHelper mEmojiTextViewHelper;

    @NonNull
    private final TextView mView;

    AppCompatEmojiTextHelper(@NonNull TextView r3) {
        this.mView = r3;
        this.mEmojiTextViewHelper = new EmojiTextViewHelper(r3, false);
    }

    @NonNull
    InputFilter[] getFilters(@NonNull InputFilter[] r1) {
        return this.mEmojiTextViewHelper.getFilters(r1);
    }

    public boolean isEnabled() {
        return this.mEmojiTextViewHelper.isEnabled();
    }

    void loadFromAttributes(@Nullable AttributeSet r4, int r5) {
        TypedArray r6 = this.mView.getContext().obtainStyledAttributes(r4, R.styleable.AppCompatTextView, r5, 0);
        int r7 = R.styleable.AppCompatTextView_emojiCompatEnabled;     // Catch: Throwable -> L8
        boolean r1 = true;
        if (r6.hasValue(r7) == false) goto L6;
        r1 = r6.getBoolean(r7, true);     // Catch: Throwable -> L8
    L6:
        r6.recycle();
        setEnabled(r1);
        return;
    L8:
        th = move-exception;
        r6.recycle();
        throw th;
    }

    void setAllCaps(boolean r1) {
        this.mEmojiTextViewHelper.setAllCaps(r1);
    }

    void setEnabled(boolean r1) {
        this.mEmojiTextViewHelper.setEnabled(r1);
    }

    @Nullable
    public TransformationMethod wrapTransformationMethod(@Nullable TransformationMethod r1) {
        return this.mEmojiTextViewHelper.wrapTransformationMethod(r1);
    }
}
