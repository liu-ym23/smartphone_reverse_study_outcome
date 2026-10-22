package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.appcompat.R;
import androidx.emoji2.viewsintegration.EmojiEditTextHelper;

/* JADX INFO: loaded from: classes.dex */
class AppCompatEmojiEditTextHelper {
    private final EmojiEditTextHelper mEmojiEditTextHelper;
    private final EditText mView;

    AppCompatEmojiEditTextHelper(EditText r3) {
        this.mView = r3;
        this.mEmojiEditTextHelper = new EmojiEditTextHelper(r3, false);
    }

    void loadFromAttributes(AttributeSet r4, int r5) {
        TypedArray r6 = this.mView.getContext().obtainStyledAttributes(r4, R.styleable.AppCompatTextView, r5, 0);
        boolean r0 = true;
        if (r6.hasValue(R.styleable.AppCompatTextView_emojiCompatEnabled) == false) goto L6;
        r0 = r6.getBoolean(R.styleable.AppCompatTextView_emojiCompatEnabled, true);     // Catch: Throwable -> L8
    L6:
        r6.recycle();
        setEnabled(r0);
        return;
    L8:
        th = move-exception;
        r6.recycle();
        throw th;
    }

    boolean isEmojiCapableKeyListener(KeyListener r1) {
        return !(r1 instanceof NumberKeyListener);
    }

    void setEnabled(boolean r1) {
        this.mEmojiEditTextHelper.setEnabled(r1);
    }

    boolean isEnabled() {
        return this.mEmojiEditTextHelper.isEnabled();
    }

    KeyListener getKeyListener(KeyListener r2) {
        if (isEmojiCapableKeyListener(r2) == true) goto L5;
        return r2;
    L5:
        return this.mEmojiEditTextHelper.getKeyListener(r2);
    }

    InputConnection onCreateInputConnection(InputConnection r1, EditorInfo r2) {
        return this.mEmojiEditTextHelper.onCreateInputConnection(r1, r2);
    }
}
