package wr;

import android.view.KeyEvent;
import android.view.inputmethod.BaseInputConnection;
import com.obric.oui.optinput.OOtpInputView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends BaseInputConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OOtpInputView f22898a;

    public c(OOtpInputView r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super(r5, false);
        this.f22898a = r5;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean commitText(CharSequence r5, int r10) {
        if (r5 != null) goto L5;
    L8:
        return true;
    L5:
        if (r5.length() == 0) goto L8;
        this.f22898a.a(r5);
        goto L8
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int r5, int r10) {
        if (this.f22898a.b() == false) goto L6;
        return true;
    L6:
        return super.deleteSurroundingText(r5, r10);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean sendKeyEvent(KeyEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (r5.getAction() != 0) goto L14;
        int r10 = r5.getKeyCode();
        OOtpInputView r11 = this.f22898a;
        if (r10 == 67) goto L7;
        char r12 = (char) r5.getUnicodeChar();
        if (Character.isDigit(r12) == false) goto L14;
        r11.a(String.valueOf(r12));
        return true;
    L7:
        if (r11.b() == false) goto L14;
        return true;
    L14:
        return super.sendKeyEvent(r5);
    }
}
