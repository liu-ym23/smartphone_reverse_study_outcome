package com.obric.oui.forms;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.view.View;
import com.bytedance.securityserver.R;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.utils.log.L;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SuppressLint({"ClickableViewAccessibility"})
public final class OPhoneInputView extends OInputView {
    public int f0;
    public boolean g0;
    public boolean h0;
    public boolean i0;
    public String j0;
    public boolean k0;

    @Metadata
    public static final class Companion {
    }

    @Nullable
    public final String getAreaCode() {
        return this.j0;
    }

    @Override // com.obric.oui.forms.OInputView
    public int getContentViewRes() {
        return R.layout.o_phone_input_view_layout;
    }

    public final boolean getEnableArrowIcon() {
        return this.k0;
    }

    @Override // com.obric.oui.forms.OInputView
    @Nullable
    public String getText() {
        if (this.g0 == false) goto L12;
        Editable r2 = getVInput().getText();
        if (r2 == null) goto L9;
        String r3 = r2.toString();
        if (r3 == null) goto L9;
        return StringsKt.B(r3, " ", "");
    L9:
        return null;
    L12:
        return super.getText();
    }

    @Override // com.obric.oui.forms.OInputView
    public final void i(Editable r11) {
        if (s() == false) goto L57;
        setLimitCountValue(11);
        if (r11 != null) goto L8;
        r11 = getVInput().getText();
    L8:
        if (r11 != null) goto L10;
    L55:
        this.g0 = true;
        this.f0 = getLimitCount();
    L70:
        Editable r12 = getVInput().getText();
        if (r12 == null) goto L73;
        String r13 = r12.toString();
    L74:
        r(r13);
        return;
    L73:
        r13 = null;
        goto L74
    L10:
        if (this.h0 == true) goto L55;
        String r0 = r11.toString();
        StringBuilder r3 = new StringBuilder();
        int r4 = r0.length();
        int r5 = 0;
    L13:
        if (r5 >= r4) goto L18;
        int r6 = r5 + 1;
        char r7 = r0.charAt(r5);
        if (Character.isDigit(r7) == false) goto L17;
        r3.append(r7);
    L17:
        r5 = r6;
        goto L13
    L18:
        String r8 = r3.toString();
        Intrinsics.e(r8, "filterTo(StringBuilder(), predicate).toString()");
        StringBuilder r9 = new StringBuilder();
        int r10 = 0;
        int r14 = 0;
    L20:
        if (r10 >= r8.length()) goto L29;
        char r15 = r8.charAt(r10);
        r10 = r10 + 1;
        int r16 = r14 + 1;
        r9.append(r15);
        if (r14 == 2) goto L26;
        if (r14 == 6) goto L26;
    L28:
        r14 = r16;
    L26:
        if (r14 == StringsKt.q(r8)) goto L28;
        r9.append(' ');
        goto L28
    L29:
        String r17 = r9.toString();
        Intrinsics.e(r17, "StringBuilder().apply(builderAction).toString()");
        if (r17.equals(r0) == true) goto L55;
        this.h0 = true;
        r11.replace(0, r11.length(), r17);
        if (this.g0 == true) goto L76;
    L54:
        this.h0 = false;
        goto L55
    L76:
        Iterator r18 = CollectionsKt.k(new Integer[]{3, 8}).iterator();     // Catch: Exception -> L52
    L37:
        if (r18.hasNext() == false) goto L54;
        int r19 = ((Number) r18.next()).intValue();     // Catch: Exception -> L52
        int r20 = r19 + 1;     // Catch: Exception -> L52
        if (r0.length() < r19) goto L37;
        if (r17.length() < r19) goto L37;
        if (r0.charAt(r19) == ' ') goto L37;
        if (r17.charAt(r19) != ' ') goto L37;
        if (getVInput().getSelectionStart() != r20) goto L37;
        if (getVInput().getSelectionEnd() != r20) goto L37;
        getVInput().setSelection(r19 + 2);     // Catch: Exception -> L52
    L52:
        e = move-exception;
        L.g("OInputView", "Failed to move cursor when formating: " + e.getMessage());
        goto L54
    L57:
        if (this.g0 == false) goto L70;
        if (r11 != null) goto L61;
        r11 = getVInput().getText();
    L61:
        if (r11 != null) goto L63;
    L69:
        this.g0 = false;
        setLimitCountValue(this.f0);
        goto L70
    L63:
        if (this.h0 == true) goto L69;
        String r1 = r11.toString();
        String r21 = StringsKt.B(r1, " ", "");
        if (r21.equals(r1) == true) goto L69;
        this.h0 = true;
        r11.replace(0, r11.length(), r21);
        this.h0 = false;
        goto L69
    }

    @Override // com.obric.oui.forms.OInputView
    public final int j(CharSequence r3) {
        int r0 = 0;
        if (r3 != null) goto L6;
        return 0;
    L6:
        if (this.g0 == false) goto L8;
    L11:
        int r2 = 0;
    L13:
        if (r0 >= r3.length()) goto L23;
        char r1 = r3.charAt(r0);
        r0 = r0 + 1;
        if (Character.isDigit(r1) == false) goto L13;
        r2 = r2 + 1;
        goto L13
    L23:
        return r2;
    L8:
        if (s() == true) goto L11;
        return r3.length();
    }

    public final boolean s() {
        if ((getInputType() & 15) == 3) goto L5;
    L13:
        return false;
    L5:
        if (this.i0 == false) goto L13;
        String r2 = this.j0;
        if (r2 == null) goto L9;
        String r3 = StringsKt.J(r2).toString();
    L11:
        if (Intrinsics.a(r3, "+86") == false) goto L13;
        return true;
    L9:
        r3 = null;
        goto L11
    }

    public final void setAreaClickListener(@NotNull View.OnClickListener r1) {
        Intrinsics.f(r1, "listener");
        throw null;
    }

    public final void setAreaCode(@Nullable String r3) {
        if (r3 == null) goto L10;
        String r0 = this.j0;
        if (r0 != null) goto L6;
    L8:
        this.j0 = r3;
        throw null;
    L6:
        if (StringsKt.p(r0, r3, false) == false) goto L8;
        return;
    }

    public final void setEnableArrowIcon(boolean r2) {
        if (this.k0 != r2) goto L5;
        return;
    L5:
        this.k0 = r2;
    }

    @Override // com.obric.oui.forms.OInputView
    public void setLimitCount(int r2) {
        this.f0 = r2;
        if (this.g0 == false) goto L5;
        r2 = 11;
    L5:
        super.setLimitCount(r2);
    }

    public final void setShowAreaCode(boolean r3) {
        if (getInputType() == 3) goto L6;
        return;
    L6:
        if (this.i0 != r3) goto L8;
        return;
    L8:
        this.i0 = r3;
        ViewExtensionsKt.f(null, r3);
        throw null;
    }
}
