package com.obric.oui.window.permission;

import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bytedance.securityserver.R;
import com.obric.oui.dialog.alert.OAlertDialog;
import com.obric.oui.dialog.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.base.AbstractDialog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class PrivacyStatementActivity$createClickableSpan$1 extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PrivacyStatementActivity f322a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f323d;

    public PrivacyStatementActivity$createClickableSpan$1(PrivacyStatementActivity r1, String r2, String r3, Context r4) {
        this.f322a = r1;
        this.b = r2;
        this.c = r3;
        this.f323d = r4;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r5) {
        Intrinsics.f(r5, "widget");
        LinkedHashMap r6 = PrivacyStatementActivity.k;
        PrivacyStatementActivity r0 = this.f322a;
        final PrivacyStatementActivity.LinkClickListener r7 = (PrivacyStatementActivity.LinkClickListener) r6.get(r0.getIntent().getStringExtra("PrivacyStatementActivityInstanceId"));
        boolean r1 = r0.c;
        String r2 = this.b;
        if (r1 == true) goto L12;
        if (r2 != null) goto L6;
        return;
    L6:
        if (r2.length() == 0) goto L24;
        if (r7 == null) goto L23;
        r7.a();
        return;
    L23:
        return;
    L24:
        return;
    L12:
        if (r0.b == false) goto L20;
        if (r2 != null) goto L15;
        return;
    L15:
        if (r2.length() == 0) goto L28;
        if (r7 == null) goto L19;
        r7.a();
        return;
    L19:
        Intent r8 = new Intent(r0, WebViewActivity.class);
        r8.putExtra("extra_url", r2);
        r8.putExtra("extra_title", this.c);
        r0.startActivity(r8);
        return;
    L28:
        return;
    L20:
        OAlertDialogBuilder r3 = new OAlertDialogBuilder(r0);
        r3.u = false;
        String r4 = r0.getString(R.string.privacy_permisssion_dialog_title);
        r3.g = false;
        r3.e = r4;
        r3.f = r0.getString(R.string.privacy_permisssion_dialog_message);
        String r9 = r0.getString(R.string.oui_agree);
        Intrinsics.e(r9, "getString(R.string.oui_agree)");
        r3.c(r9, new PrivacyStatementActivity$createClickableSpan$1$onClick$1(this, r7));
        String r10 = r0.getString(R.string.oui_cancel_only);
        Intrinsics.e(r10, "getString(R.string.oui_cancel_only)");
        r3.b(r10, PrivacyStatementActivity$createClickableSpan$1$onClick$2.b);
        OAlertDialog r11 = r3.a();
        r11.f(r3.c, r3.f222a);
        r11.setCancelable(r3.b);
        AbstractDialog.CloseIconStyle r12 = AbstractDialog.CloseIconStyle.b;
        Pair r13 = r3.f223d;
        r11.a(r12, (Integer) r13.b, (Integer) r13.c);
        r11.show();
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r2) {
        Intrinsics.f(r2, "ds");
        super.updateDrawState(r2);
        r2.setColor(ContextCompat.getColor(this.f323d, R.color.oui_fill_highlighted));
        r2.setUnderlineText(false);
    }
}
