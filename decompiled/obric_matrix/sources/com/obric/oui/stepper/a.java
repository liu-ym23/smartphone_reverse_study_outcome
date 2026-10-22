package com.obric.oui.stepper;

import android.text.InputFilter;
import android.text.Spanned;

/* JADX INFO: loaded from: classes2.dex */
public class a implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InterfaceC0299a f11436c;

    /* JADX INFO: renamed from: com.obric.oui.stepper.a$a, reason: collision with other inner class name */
    interface InterfaceC0299a {
        void a(int r1);
    }

    public a(int r1, int r2, InterfaceC0299a r3) {
        this.f11434a = r1;
        this.f11435b = r2;
        this.f11436c = r3;
    }

    private boolean a(int r2, int r3, int r4) {
        if (r3 <= r2) goto L7;
        if (r4 < r2) goto L11;
        if (r4 > r3) goto L11;
        return true;
    L11:
        return false;
    L7:
        if (r4 < r3) goto L11;
        if (r4 > r2) goto L11;
        return true;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence r1, int r2, int r3, Spanned r4, int r5, int r6) {
        int r7 = Integer.parseInt(r4.toString() + r1.toString());     // Catch: NumberFormatException -> L11
        if (a(this.f11434a, this.f11435b, r7) == false) goto L6;
        return null;
    L6:
        InterfaceC0299a r0 = this.f11436c;     // Catch: NumberFormatException -> L11
        if (r0 == null) goto L14;
        r0.a(r7);     // Catch: NumberFormatException -> L11
        return "";
    L14:
        return "";
    L15:
        return "";
    }
}
