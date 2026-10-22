package com.obric.oui.forms;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.common.oui.g;
import com.obric.oui.common.util.j;
import d.g.d.f.f.b;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u001c\u0010\u0012J\u0015\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\"\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b\"\u0010#J\u0019\u0010$\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b$\u0010\u000bJ\u0015\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0002¢\u0006\u0004\b&\u0010\u0018J\r\u0010'\u001a\u00020\u0002¢\u0006\u0004\b'\u0010\u0004R\u0016\u0010*\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00104R\u0018\u0010:\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u00104R\u0016\u0010B\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u00104¨\u0006C"}, d2 = {"Lcom/obric/oui/forms/OPhoneInputView;", "Lcom/obric/oui/forms/OInputView;", "", "W", "()Z", "Lkotlin/f0;", "U", "()V", "Landroid/text/Editable;", "editable", "T", "(Landroid/text/Editable;)V", "V", "", "getContentViewRes", "()I", "", "getText", "()Ljava/lang/String;", "limit", "setLimitCount", "(I)V", "show", "setShowAreaCode", "(Z)V", "s", "setAreaCode", "(Ljava/lang/String;)V", "getAreaCode", "Landroid/view/View$OnClickListener;", "listener", "setAreaClickListener", "(Landroid/view/View$OnClickListener;)V", "", "C", "(Ljava/lang/CharSequence;)I", "x", "enableArrow", "setEnableArrowIcon", "getEnableArrowIcon", "k0", "I", "originLimitCount", "Landroid/widget/LinearLayout;", "p0", "Landroid/widget/LinearLayout;", "vAreaCodeContainer", "Landroid/widget/TextView;", "q0", "Landroid/widget/TextView;", "vAreaCodeText", "s0", "Z", "enableArrowIcon", "m0", "isTextFormating", "o0", "Ljava/lang/String;", "areaCode", "Landroid/widget/ImageView;", "r0", "Landroid/widget/ImageView;", "vArrowIcon", "l0", "isChinesePhoneNumber", "n0", "showAreaCode", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
@SuppressLint({"ClickableViewAccessibility"})
public final class OPhoneInputView extends OInputView {
    private int k0;
    private boolean l0;
    private boolean m0;
    private boolean n0;
    private String o0;
    private final LinearLayout p0;
    private final TextView q0;
    private final ImageView r0;
    private boolean s0;

    static {
    }

    private final void T(Editable r11) {
        if (this.m0 == false) goto L5;
        return;
    L5:
        String r0 = r11.toString();
        StringBuilder r1 = new StringBuilder();
        int r2 = r0.length();
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L11;
        int r5 = r4 + 1;
        char r6 = r0.charAt(r4);
        if (Character.isDigit(r6) == false) goto L10;
        r1.append(r6);
    L10:
        r4 = r5;
        goto L6
    L11:
        String r3 = r1.toString();
        o.e(r3, "filterTo(StringBuilder(), predicate).toString()");
        StringBuilder r7 = new StringBuilder();
        int r8 = 0;
        int r9 = 0;
    L13:
        if (r8 >= r3.length()) goto L22;
        char r10 = r3.charAt(r8);
        r8 = r8 + 1;
        int r12 = r9 + 1;
        r7.append(r10);
        if (r9 == 2) goto L19;
        if (r9 == 6) goto L19;
    L21:
        r9 = r12;
    L19:
        if (r9 == k.K(r3)) goto L21;
        r7.append(' ');
        goto L21
    L22:
        String r13 = r7.toString();
        o.e(r13, "StringBuilder().apply(builderAction).toString()");
        if (o.a(r13, r0) == false) goto L25;
        return;
    L25:
        this.m0 = true;
        r11.replace(0, r11.length(), r13);
        if (this.l0 == true) goto L48;
    L46:
        this.m0 = false;
        return;
    L48:
        Iterator r14 = r.j(new Integer[]{3, 8}).iterator();     // Catch: Exception -> L44
    L29:
        if (r14.hasNext() == false) goto L46;
        int r15 = ((Number) r14.next()).intValue();     // Catch: Exception -> L44
        int r16 = r15 + 1;     // Catch: Exception -> L44
        if (r0.length() < r15) goto L29;
        if (r13.length() < r15) goto L29;
        if (r0.charAt(r15) == ' ') goto L29;
        if (r13.charAt(r15) != ' ') goto L29;
        if (getVInput().getSelectionStart() != r16) goto L29;
        if (getVInput().getSelectionEnd() != r16) goto L29;
        getVInput().setSelection(r16 + 1);     // Catch: Exception -> L44
    L44:
        e = move-exception;
        b.j("OInputView", "Failed to move cursor when formating: " + e.getMessage());
        goto L46
    }

    private final void U() {
        Editable r0 = getVInput().getText();
        if (r0 == null) goto L5;
        int r1 = r0.length();
    L11:
        getVInput().setSelection(r1);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        b.j("OInputView", "Failed to move cursor to end: " + e.getMessage());
        return;
    L5:
        r1 = 0;
        goto L11
    }

    private final void V(Editable r8) {
        if (this.m0 == false) goto L5;
        return;
    L5:
        String r0 = r8.toString();
        String r1 = k.w(r0, " ", "", false, 4, null);
        if (o.a(r1, r0) == false) goto L8;
        return;
    L8:
        this.m0 = true;
        r8.replace(0, r8.length(), r1);
        this.m0 = false;
    }

    private final boolean W() {
        if ((getInputType() & 15) == 3) goto L5;
    L13:
        return false;
    L5:
        if (this.n0 == false) goto L13;
        String r2 = this.o0;
        if (r2 == null) goto L9;
        String r3 = k.G0(r2).toString();
    L11:
        if (o.a(r3, "+86") == false) goto L13;
        return true;
    L9:
        r3 = null;
        goto L11
    }

    @Override // com.obric.oui.forms.OInputView
    public int C(CharSequence r3) {
        int r0 = 0;
        if (r3 != null) goto L6;
        return 0;
    L6:
        if (this.l0 == false) goto L8;
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
        if (W() == true) goto L11;
        return r3.length();
    }

    public final String getAreaCode() {
        return this.o0;
    }

    @Override // com.obric.oui.forms.OInputView
    public int getContentViewRes() {
        return g.u;
    }

    public final boolean getEnableArrowIcon() {
        return this.s0;
    }

    @Override // com.obric.oui.forms.OInputView
    public String getText() {
        if (this.l0 == false) goto L12;
        Editable r6 = getVInput().getText();
        if (r6 == null) goto L9;
        String r0 = r6.toString();
        if (r0 == null) goto L9;
        return k.w(r0, " ", "", false, 4, null);
    L9:
        return null;
    L12:
        return super.getText();
    }

    public final void setAreaClickListener(View.OnClickListener r2) {
        o.f(r2, "listener");
        this.p0.setOnClickListener(r2);
    }

    public final void setAreaCode(String r5) {
        if (r5 == null) goto L10;
        String r0 = this.o0;
        if (r0 != null) goto L6;
    L8:
        this.o0 = r5;
        this.q0.setText(r5);
        x(getVInput().getText());
        U();
        return;
    L6:
        if (k.p(r0, r5, false, 2, null) == false) goto L8;
        return;
    }

    public final void setEnableArrowIcon(boolean r2) {
        if (this.s0 != r2) goto L5;
        return;
    L5:
        this.s0 = r2;
        ImageView r1 = this.r0;
        if (r1 == null) goto L12;
        if (r2 == false) goto L9;
        float r3 = 1.0f;
    L10:
        r1.setAlpha(r3);
        return;
    L9:
        r3 = 0.3f;
        goto L10
    }

    @Override // com.obric.oui.forms.OInputView
    public void setLimitCount(int r2) {
        this.k0 = r2;
        if (this.l0 == false) goto L5;
        r2 = 11;
    L5:
        super.setLimitCount(r2);
    }

    public final void setShowAreaCode(boolean r3) {
        if (getInputType() == 3) goto L6;
        return;
    L6:
        if (this.n0 != r3) goto L8;
        return;
    L8:
        this.n0 = r3;
        j.j(this.p0, r3);
        x(getVInput().getText());
    }

    @Override // com.obric.oui.forms.OInputView
    public void x(Editable r2) {
        if (W() == false) goto L12;
        setLimitCountValue(11);
        if (r2 != null) goto L8;
        r2 = getVInput().getText();
    L8:
        if (r2 == null) goto L10;
        T(r2);
    L10:
        this.l0 = true;
        this.k0 = getLimitCount();
    L19:
        Editable r3 = getVInput().getText();
        if (r3 == null) goto L22;
        String r4 = r3.toString();
    L23:
        S(r4);
        return;
    L22:
        r4 = null;
        goto L23
    L12:
        if (this.l0 == false) goto L19;
        if (r2 != null) goto L16;
        r2 = getVInput().getText();
    L16:
        if (r2 == null) goto L18;
        V(r2);
    L18:
        this.l0 = false;
        setLimitCountValue(this.k0);
        goto L19
    }
}
