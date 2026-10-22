package obric.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

/* JADX INFO: loaded from: classes5.dex */
public class SecurityEditorText extends EditText {
    public SecurityEditorText(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public SecurityEditorText(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public SecurityEditorText(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r3) {
        InputConnection r2 = super.onCreateInputConnection(r3);
        if (r3.extras != null) goto L5;
        r3.extras = new Bundle();
    L5:
        r3.extras.putBoolean("ignoreSwitchSecurityMethodSettings", true);
        return r2;
    }
}
