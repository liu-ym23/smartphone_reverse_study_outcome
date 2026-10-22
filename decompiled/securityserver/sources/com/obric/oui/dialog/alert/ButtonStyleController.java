package com.obric.oui.dialog.alert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.securityserver.R;
import com.obric.oui.button.OButton;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@Metadata
public final class ButtonStyleController implements StyleController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OButton f211a;
    public OButton b;
    public OButton c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OAlertDialog f212d;
    public View e;
    public final int f;

    @Metadata
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    public @interface ButtonStyle {
    }

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final enum TextColorType extends Enum<TextColorType> {
        public static final /* synthetic */ TextColorType[] b = null;

        static {
            b = new TextColorType[]{new TextColorType("TextReverse", 0), new TextColorType("TextReverse2", 1), new TextColorType("Negative", 2)};
        }

        public static TextColorType valueOf(String r1) {
            return (TextColorType) Enum.valueOf(TextColorType.class, r1);
        }

        public static TextColorType[] values() {
            return (TextColorType[]) b.clone();
        }
    }

    @Metadata
    public final /* synthetic */ class WhenMappings {
        static {
            int[] r0 = new int[TextColorType.values().length];
            r0[2] = 1;
            r0[0] = 2;
            r0[1] = 3;
        }
    }

    public ButtonStyleController(Context r2, int r3) {
        Intrinsics.f(r2, "context");
        this.f = r3;
    }

    public static void c(OButton r1, TextColorType r2) {
        if (r2 == null) goto L16;
        int r3 = r2.ordinal();
        if (r3 != 0) goto L6;
        int r4 = R.color.TextReverse;
    L14:
        r1.setTextColor(ContextCompat.getColor(r1.getContext(), r4));
        return;
    L6:
        if (r3 != 1) goto L8;
        r4 = R.color.TextReverse2;
        goto L14
    L8:
        if (r3 != 2) goto L11;
        r4 = R.color.Negative;
        goto L14
    L11:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.obric.oui.dialog.alert.StyleController
    public final void a(Context r4, FrameLayout r5) {
        Intrinsics.f(r5, "parent");
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-1, -2);
        int r1 = this.f;
        if (r1 != 0) goto L5;
        int r2 = R.layout.o_dialog_button_horizontal;
    L9:
        View r6 = LayoutInflater.from(r4).inflate(r2, r5, false);
        r5.addView(r6, r0);
        this.e = r6;
        if (r6 == null) goto L12;
        r6.setVisibility(8);
    L12:
        this.f211a = (OButton) r6.findViewById(R.id.actionPositive);
        this.b = (OButton) r6.findViewById(R.id.actionNegative);
        this.c = (OButton) r6.findViewById(R.id.actionNeutral);
        FrameLayout r3 = (FrameLayout) r6.findViewById(R.id.custom_container);
        return;
    L5:
        if (r1 == 1) goto L7;
        r2 = R.layout.o_dialog_button_primary;
        goto L9
    L7:
        r2 = R.layout.o_dialog_button_vertical;
        goto L9
    }

    @Override // com.obric.oui.dialog.alert.StyleController
    public final void b(OAlertDialog r2) {
        Intrinsics.f(r2, "dialog");
        this.f212d = r2;
    }
}
