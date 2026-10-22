package com.obric.oui.dialog;

import a.a;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.bytedance.securityserver.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OCommonDialog extends Dialog {
    public static final /* synthetic */ int c = 0;
    public ODialogCommonBinding b;

    @Metadata
    public static final class Builder {
    }

    /* JADX INFO: renamed from: com.obric.oui.dialog.OCommonDialog$onCreate$1, reason: invalid class name */
    @Metadata
    public final class AnonymousClass1 implements DialogInterface.OnKeyListener {
        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r1, int r2, KeyEvent r3) {
            if (r2 != 4) goto L6;
            return true;
        L6:
            return false;
        }
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        requestWindowFeature(1);
        LayoutInflater r0 = LayoutInflater.from(getContext());
        Intrinsics.e(r0, "LayoutInflater.from(context)");
        View r1 = r0.inflate(R.layout.o_dialog_common, null, false);
        Intrinsics.e(r1, "root");
        ODialogCommonBinding r2 = new ODialogCommonBinding();
        View r4 = r1.findViewById(R.id.dialog_title);
        Intrinsics.e(r4, "root.findViewById(R.id.dialog_title)");
        r2.f209a = (TextView) r4;
        View r5 = r1.findViewById(R.id.dialog_message);
        Intrinsics.e(r5, "root.findViewById(R.id.dialog_message)");
        r2.b = (TextView) r5;
        View r6 = r1.findViewById(R.id.cancel);
        Intrinsics.e(r6, "root.findViewById(R.id.cancel)");
        r2.c = (TextView) r6;
        View r8 = r1.findViewById(R.id.confirm);
        Intrinsics.e(r8, "root.findViewById(R.id.confirm)");
        r2.f210d = (TextView) r8;
        this.b = r2;
        setContentView(r1);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setOnKeyListener(new AnonymousClass1());
        ODialogCommonBinding r3 = this.b;
        if (r3 == null) goto L31;
        r3.f209a.setText(null);
        ODialogCommonBinding r9 = this.b;
        if (r9 == null) goto L29;
        r9.b.setVisibility(8);
        ODialogCommonBinding r10 = this.b;
        if (r10 == null) goto L27;
        r10.b.setText(null);
        ODialogCommonBinding r11 = this.b;
        if (r11 == null) goto L25;
        r11.b.getViewTreeObserver().addOnPreDrawListener(new OCommonDialog$setupView$1(this));
        ODialogCommonBinding r12 = this.b;
        if (r12 == null) goto L23;
        r12.f210d.setOnClickListener(new OCommonDialog$setupView$2(this));
        ODialogCommonBinding r13 = this.b;
        if (r13 == null) goto L21;
        r13.c.setOnClickListener(new OCommonDialog$setupView$3(this));
        setOnCancelListener(new OCommonDialog$setupView$4(this));
        Window r14 = getWindow();
        if (r14 == null) goto L33;
        r14.setLayout(-1, -2);
        r14.setGravity(17);
        r14.setBackgroundDrawable(new ColorDrawable(0));
        WindowManager.LayoutParams r15 = r14.getAttributes();
        TypedArray r16 = r14.getWindowStyle();
        Intrinsics.e(r16, "windowStyle");
        Resources r17 = r16.getResources();
        Intrinsics.e(r17, "windowStyle.resources");
        int r18 = r17.getDisplayMetrics().widthPixels;
        Resources r19 = Resources.getSystem();
        Intrinsics.e(r19, "Resources.getSystem()");
        int r20 = r18 - (MathKt.a(TypedValue.applyDimension(1, 24, r19.getDisplayMetrics())) * 2);
        r15.width = r20;
        float r21 = 312;
        if (r20 <= a.d("Resources.getSystem()", 1, r21)) goto L19;
        r15.width = a.d("Resources.getSystem()", 1, r21);
    L19:
        r14.setAttributes(r15);
        return;
    L33:
        return;
    L21:
        Intrinsics.m("binding");
        throw null;
    L23:
        Intrinsics.m("binding");
        throw null;
    L25:
        Intrinsics.m("binding");
        throw null;
    L27:
        Intrinsics.m("binding");
        throw null;
    L29:
        Intrinsics.m("binding");
        throw null;
    L31:
        Intrinsics.m("binding");
        throw null;
    }
}
