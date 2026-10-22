package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.emoji2.viewsintegration.EmojiEditTextHelper;

/* JADX INFO: loaded from: classes.dex */
class AppCompatEmojiEditTextHelper {

    @NonNull
    private final EmojiEditTextHelper mEmojiEditTextHelper;

    @NonNull
    private final EditText mView;

    AppCompatEmojiEditTextHelper(@NonNull EditText r3) {
        this.mView = r3;
        this.mEmojiEditTextHelper = new EmojiEditTextHelper(r3, false);
    }

    @Nullable
    KeyListener getKeyListener(@Nullable KeyListener r2) {
        if (isEmojiCapableKeyListener(r2) == true) goto L5;
        return r2;
    L5:
        return this.mEmojiEditTextHelper.getKeyListener(r2);
    }

    boolean isEmojiCapableKeyListener(KeyListener r1) {
        return !(r1 instanceof NumberKeyListener);
    }

    boolean isEnabled() {
        return this.mEmojiEditTextHelper.isEnabled();
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

    @Nullable
    InputConnection onCreateInputConnection(@Nullable InputConnection r1, @NonNull EditorInfo r2) {
        return this.mEmojiEditTextHelper.onCreateInputConnection(r1, r2);
    }

    void setEnabled(boolean r1) {
        this.mEmojiEditTextHelper.setEnabled(r1);
    }
}
