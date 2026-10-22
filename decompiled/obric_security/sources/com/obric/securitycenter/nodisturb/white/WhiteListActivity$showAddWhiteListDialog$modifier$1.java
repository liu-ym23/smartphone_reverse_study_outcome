package com.obric.securitycenter.nodisturb.white;

import android.text.InputFilter;
import android.text.Spanned;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.forms.OPhoneInputLayout;
import com.obric.oui.utils.KtExt;
import com.obric.securitycenter.nodisturb.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: WhiteListActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/oui/forms/OInputLayout;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class WhiteListActivity$showAddWhiteListDialog$modifier$1 extends Lambda implements Function1<OInputLayout, Unit> {
    final /* synthetic */ Ref.ObjectRef<OInputLayout> $inputView;
    final /* synthetic */ WhiteListActivity this$0;

    /* JADX INFO: renamed from: $r8$lambda$bJ2LhZAe8Xo5h_-EJz1yb0pTQzw, reason: not valid java name */
    public static /* synthetic */ CharSequence m621$r8$lambda$bJ2LhZAe8Xo5h_EJz1yb0pTQzw(CharSequence r0, int r1, int r2, Spanned r3, int r4, int r5) {
        return invoke$lambda$2(r0, r1, r2, r3, r4, r5);
    }

    WhiteListActivity$showAddWhiteListDialog$modifier$1(WhiteListActivity r1, Ref.ObjectRef<OInputLayout> r2) {
        this.this$0 = r1;
        this.$inputView = r2;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(OInputLayout r1) {
        invoke2(r1);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(OInputLayout r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        r4.setHint(this.this$0.getString(R.string.phone_number_hint));
        r4.setInputType(3);
        r4.showClear(true);
        this.$inputView.element = r4;
        KtExt r3 = KtExt.INSTANCE;
        if ((r4 instanceof OPhoneInputLayout) == false) goto L5;
        Object r5 = r4;
    L6:
        OPhoneInputLayout r6 = (OPhoneInputLayout) r5;
        if (r6 == null) goto L9;
        r6.showCustomStart(false);
    L9:
        OEditText r7 = r4.getVInput();
        InputFilter r8 = new WhiteListActivity$showAddWhiteListDialog$modifier$1$$ExternalSyntheticLambda0();
        InputFilter[] r1 = r7.getFilters();
        Intrinsics.checkNotNullExpressionValue(r1, "numberInput.filters");
        List r2 = ArraysKt.toMutableList(r1);
        r2.add(r8);
        r7.setFilters((InputFilter[]) r2.toArray(new InputFilter[0]));
        return;
    L5:
        r5 = null;
        goto L6
    }

    private static final CharSequence invoke$lambda$2(CharSequence r3, int r4, int r5, Spanned r6, int r7, int r8) {
        int r0 = 0;
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        return null;
    L12:
        StringBuilder r2 = new StringBuilder();
        r2.append(r6.subSequence(0, r7));
        r2.append(r6.subSequence(r8, r6.length()));
        String r9 = r2.toString();
        Intrinsics.checkNotNullExpressionValue(r9, "StringBuilder().apply(builderAction).toString()");
        String r10 = r9;
        int r11 = 0;
        int r12 = 0;
    L14:
        if (r11 >= r10.length()) goto L19;
        if (Character.isDigit(r10.charAt(r11)) == false) goto L18;
        r12 = r12 + 1;
    L18:
        r11 = r11 + 1;
        goto L14
    L19:
        int r13 = 11 - r12;
        if (r13 <= 0) goto L22;
        CharSequence r14 = r3.subSequence(r4, r5);
        StringBuilder r15 = new StringBuilder(r14.length());
        int r16 = 0;
    L25:
        if (r0 >= r14.length()) goto L32;
        char r17 = r14.charAt(r0);
        if (Character.isDigit(r17) == false) goto L30;
        if (r16 >= r13) goto L32;
        r16 = r16 + 1;
    L30:
        r15.append(r17);
        r0 = r0 + 1;
    L32:
        if (r15.length() != r14.length()) goto L35;
        return null;
    L35:
        return r15.toString();
    L22:
        return "";
    L5:
        if (r3.length() == 0) goto L8;
        r1 = false;
        goto L10
    }
}
