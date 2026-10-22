package com.obric.oui.radio;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.common.oui.e;
import com.obric.common.oui.k;
import com.obric.oui.common.util.j;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.o0.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000e\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0017¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006$"}, d2 = {"Lcom/obric/oui/radio/ORadio;", "Landroidx/appcompat/widget/AppCompatRadioButton;", "Lkotlin/f0;", "a", "()V", "onAttachedToWindow", "", "checked", "setChecked", "(Z)V", "", "text", "Landroid/widget/TextView$BufferType;", WsConstants.KEY_CONNECTION_TYPE, "setText", "(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V", "", "style", "setStyle", "(I)V", "f", "Z", "alwaysLight", "g", "adaptForCSR", "i", "isFitOld", "h", "I", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IZ)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public class ORadio extends AppCompatRadioButton {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f11328f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f11329g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f11330h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f11331i;

    public ORadio(Context r8, AttributeSet r9) {
        this(r8, r9, 0, false, 12, null);
    }

    public ORadio(Context r3, AttributeSet r4, int r5, boolean r6) {
        o.f(r3, "context");
        super(r3, r4, r5);
        this.f11331i = r6;
        this.f11329g = true;
        if (r4 == null) goto L6;
        TypedArray r7 = r3.obtainStyledAttributes(r4, k.G0, r5, 0);
        o.e(r7, "context.obtainStyledAttr….ORadio, defStyleAttr, 0)");
        this.f11331i = r7.getBoolean(k.I0, this.f11331i);
        this.f11330h = r7.getInt(k.K0, 0);
        this.f11329g = r7.getBoolean(k.H0, true);
        this.f11328f = r7.getBoolean(k.J0, false);
        r7.recycle();
    L6:
        if (this.f11331i == true) goto L8;
        a();
        return;
    L8:
        setClickable(true);
    }

    public /* synthetic */ ORadio(Context r2, AttributeSet r3, int r4, boolean r5, int r6, g r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = false;
    L11:
        this(r2, r3, r4, r5);
    }

    private final void a() {
        if (this.f11331i == false) goto L6;
        return;
    L6:
        if (this.f11330h != 1) goto L10;
        int r0 = e.v;
    L8:
        setButtonDrawable(r0);
        setChecked(isChecked());
        return;
    L10:
        if (this.f11328f == false) goto L12;
        r0 = e.G;
        goto L8
    L12:
        r0 = e.F;
        goto L8
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f11331i == false) goto L6;
        return;
    L6:
        if (this.f11329g == false) goto L9;
        Resources r2 = Resources.getSystem();
        o.e(r2, "Resources.getSystem()");
        j.a(this, a.a(TypedValue.applyDimension(1, 44, r2.getDisplayMetrics())));
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r3) {
        super.setChecked(r3);
        if (this.f11331i == false) goto L6;
        return;
    L6:
        if (this.f11330h != 1) goto L12;
        if (r3 == false) goto L9;
        int r4 = 0;
    L10:
        setVisibility(r4);
        return;
    L9:
        r4 = 4;
        goto L10
    }

    public final void setStyle(int r2) {
        if (this.f11331i == false) goto L5;
        return;
    L5:
        this.f11330h = r2;
        a();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence r1, TextView.BufferType r2) {
        super.setText(r1, r2);
    }
}
