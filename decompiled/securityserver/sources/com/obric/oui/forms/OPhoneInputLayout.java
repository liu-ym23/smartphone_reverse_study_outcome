package com.obric.oui.forms;

import android.annotation.SuppressLint;
import android.view.View;
import com.bytedance.securityserver.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SuppressLint({"ClickableViewAccessibility"})
public class OPhoneInputLayout extends OInputLayout {
    public String k;
    public boolean l;

    @Metadata
    public static final class Companion {
    }

    @Nullable
    public final String getAreaCode() {
        return this.k;
    }

    public final boolean getEnableArrowIcon() {
        return this.l;
    }

    @Override // com.obric.oui.forms.OInputLayout
    @Nullable
    public CharSequence getText() {
        return super.getText();
    }

    public final void setAreaClickListener(@NotNull View.OnClickListener r1) {
        Intrinsics.f(r1, "listener");
        throw null;
    }

    public final void setAreaCode(@Nullable String r3) {
        if (r3 == null) goto L10;
        String r0 = this.k;
        if (r0 != null) goto L6;
    L8:
        this.k = r3;
        throw null;
    L6:
        if (StringsKt.p(r0, r3, false) == false) goto L8;
        return;
    }

    @Override // com.obric.oui.forms.OInputLayout
    public void setCustomStart(int r1) {
        super.setCustomStart(R.layout.o_input_custom_start_area_code);
    }

    @Override // com.obric.oui.forms.OInputLayout
    public void setDefaultCustomStart(int r1) {
        super.setCustomStart(R.layout.o_input_custom_start_area_code);
    }

    public final void setEnableArrowIcon(boolean r2) {
        if (this.l != r2) goto L5;
        return;
    L5:
        this.l = r2;
    }

    @Override // com.obric.oui.forms.OInputLayout
    public void setType(int r1) {
        if (r1 == 0) goto L4;
        return;
    L4:
        super.setType(r1);
    }
}
