package com.obric.oui.dialog.alert;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.base.AbstractDialogBuilder;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@Metadata
public class OAlertDialogBuilder extends AbstractDialogBuilder<OAlertDialog> {
    public CharSequence e;
    public CharSequence f;
    public boolean g;
    public Drawable h;
    public Integer i;
    public Integer j;
    public int k;
    public CharSequence l;
    public DialogInterface.OnClickListener m;
    public ButtonStyleController.TextColorType n;
    public CharSequence o;
    public DialogInterface.OnClickListener p;
    public ButtonStyleController.TextColorType q;
    public CharSequence r;
    public DialogInterface.OnClickListener s;
    public ButtonStyleController.TextColorType t;
    public boolean u;
    public StyleController v;
    public final Context w;

    @Metadata
    public interface IImageLoader {
    }

    public OAlertDialogBuilder(Context r3) {
        Intrinsics.f(r3, "context");
        this.f223d = new Pair(null, null);
        this.w = r3;
        this.u = true;
        this.b = false;
    }

    public final OAlertDialog a() {
        Context r0 = this.w;
        Intrinsics.f(r0, "context");
        final OAlertDialog r2 = new OAlertDialog(r0);
        CharSequence r3 = this.e;
        Function1<CharSequence, Unit> r4 = new OAlertDialogBuilder$createDialog$1(this, r2);
        if (TextUtils.isEmpty(r3) == true) goto L5;
        Intrinsics.c(r3);
        r4.invoke(r3);
    L5:
        CharSequence r5 = this.f;
        Function1<CharSequence, Unit> r6 = new OAlertDialogBuilder$createDialog$2(this, r2);
        if (TextUtils.isEmpty(r5) == true) goto L8;
        Intrinsics.c(r5);
        r6.invoke(r5);
    L8:
        Drawable r7 = this.h;
        boolean r8 = true;
        if (r7 == null) goto L14;
        ImageStyleController r9 = new ImageStyleController(r0);
        r9.f213a = r7;
        Integer r10 = this.i;
        Integer r11 = this.j;
        r9.c = r10;
        r9.b = r11;
        r9.f214d = true;
        r2.r = r9;
        FrameLayout r12 = r2.q;
        if (r12 == null) goto L14;
        r12.setVisibility(0);
        Context r13 = r2.getContext();
        Intrinsics.e(r13, "context");
        r9.a(r13, r12);
    L14:
        r2.l = this.u;
        final ButtonStyleController r14 = new ButtonStyleController(r0, this.k);
        r2.v = r14;
        FrameLayout r1 = r2.u;
        if (r1 == null) goto L17;
        Context r15 = r2.getContext();
        Intrinsics.e(r15, "context");
        r14.a(r15, r1);
    L17:
        StyleController r16 = this.v;
        if (r16 == null) goto L23;
        r2.x = r16;
        FrameLayout r17 = r2.w;
        if (r17 == null) goto L23;
        r17.setVisibility(0);
        Context r18 = r2.getContext();
        Intrinsics.e(r18, "context");
        r16.a(r18, r17);
    L23:
        if (this.c == false) goto L25;
    L29:
        r2.setOnShowListener(null);
        r2.setOnDismissListener(null);
        r2.setOnCancelListener(null);
        CharSequence r19 = this.o;
        final DialogInterface.OnClickListener r20 = this.p;
        ButtonStyleController.TextColorType r21 = this.q;
        OButton r22 = r14.f211a;
        if (r22 != null) goto L32;
    L38:
        CharSequence r23 = this.l;
        final DialogInterface.OnClickListener r24 = this.m;
        ButtonStyleController.TextColorType r25 = this.n;
        OButton r26 = r14.b;
        if (r26 != null) goto L41;
    L47:
        CharSequence r27 = this.r;
        final DialogInterface.OnClickListener r28 = this.s;
        ButtonStyleController.TextColorType r29 = this.t;
        OButton r30 = r14.c;
        if (r30 != null) goto L50;
    L56:
        return r2;
    L50:
        if (TextUtils.isEmpty(r27) == false) goto L52;
        r30.setVisibility(8);
        goto L56
    L52:
        View r31 = r14.e;
        if (r31 == null) goto L55;
        r31.setVisibility(0);
    L55:
        r30.setText(r27);
        ButtonStyleController.c(r30, r29);
        r30.setVisibility(0);
        r30.setOnClickListener(new ButtonStyleController$setNeutralButton$$inlined$let$lambda$1(r14, r28));
        goto L56
    L41:
        if (TextUtils.isEmpty(r23) == false) goto L43;
        r26.setVisibility(8);
        goto L47
    L43:
        View r32 = r14.e;
        if (r32 == null) goto L46;
        r32.setVisibility(0);
    L46:
        r26.setText(r23);
        ButtonStyleController.c(r26, r25);
        r26.setVisibility(0);
        r26.setOnClickListener(new ButtonStyleController$setNegativeButton$$inlined$let$lambda$1(r14, r24));
        goto L47
    L32:
        if (TextUtils.isEmpty(r19) == false) goto L34;
        r22.setVisibility(8);
        goto L38
    L34:
        View r33 = r14.e;
        if (r33 == null) goto L37;
        r33.setVisibility(0);
    L37:
        r22.setText(r19);
        ButtonStyleController.c(r22, r21);
        r22.setVisibility(0);
        r22.setOnClickListener(new ButtonStyleController$setPositiveButton$$inlined$let$lambda$1(r14, r20));
        goto L38
    L25:
        if (this.k == 2) goto L28;
        r8 = false;
    L28:
        this.c = r8;
        this.f222a = null;
        goto L29
    }

    public final void b(String r1, final Function2 r2) {
        this.l = r1;
        this.m = new OAlertDialogBuilder$negativeButton$1(r2);
    }

    public final void c(String r1, final Function2 r2) {
        this.o = r1;
        this.p = new OAlertDialogBuilder$positiveButton$1(r2);
    }
}
