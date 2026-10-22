package com.obric.oui.sheet;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.securityserver.R;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.panel.OBasePanelDialog;
import com.obric.oui.panel.OBasicPanelFragment;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@Metadata
public final class OActionSheet extends OBasicPanelFragment {
    public TextView b;
    public TextView c;

    @Metadata
    public static final class Action {
    }

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class OActionSheetBuilder {
    }

    /* JADX INFO: renamed from: com.obric.oui.sheet.OActionSheet$onViewCreated$1, reason: invalid class name */
    @Metadata
    public final class AnonymousClass1 extends View.AccessibilityDelegate {
        @Override // android.view.View.AccessibilityDelegate
        public final void onInitializeAccessibilityNodeInfo(View r2, AccessibilityNodeInfo r3) {
            Intrinsics.f(r2, "host");
            Intrinsics.f(r3, AlogMonitor.ALOG_RESULT_INFO);
            super.onInitializeAccessibilityNodeInfo(r2, r3);
            r3.setClassName("android.widget.ImageButton");
        }
    }

    public final int a(String r3) {
        int r0 = r3.hashCode();
        int r1 = R.color.TextReverse3;
        switch(r0) {
            case -1951390164: goto L21;
            case -1672427580: goto L18;
            case -1210163878: goto L15;
            case -1209866229: goto L12;
            case 1704015448: goto L9;
            case 1915336728: goto L6;
            default: goto L23;
        };
    L23:
        r1 = 0;
    L25:
        return ContextCompat.getColor(requireContext(), r1);
    L6:
        if (r3.equals("extension_subtitle") == false) goto L23;
    L9:
        if (r3.equals("extension_title") == false) goto L23;
    L12:
        if (r3.equals("divider_view") == false) goto L23;
        r1 = R.color.BGInputReverse;
        goto L25
    L15:
        if (r3.equals("divider_line") == false) goto L23;
        r1 = R.color.LineReverse2;
        goto L25
    L18:
        if (r3.equals("item_subtitle") == false) goto L23;
    L21:
        if (r3.equals("item_title") == false) goto L23;
        r1 = R.color.TextReverse;
        goto L25
    }

    @Override // com.obric.oui.panel.OBasicPanelFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r2) {
        Context r1 = requireContext();
        Intrinsics.e(r1, "requireContext()");
        OBasePanelDialog r3 = new OBasePanelDialog(r1, R.style.OBasicPanel);
        r3.p = false;
        r3.w = true;
        r3.A = false;
        return r3;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.f(r1, "inflater");
        return r1.inflate(R.layout.o_view_action_sheet, r2, false);
    }

    @Override // com.obric.oui.panel.OBasicPanelFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        Intrinsics.f(r2, "dialog");
        super.onDismiss(r2);
        throw null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        if ((getDialog() instanceof OBasePanelDialog) == false) goto L11;
        Dialog r1 = getDialog();
        if (r1 == null) goto L10;
        RadiusLayout r2 = ((OBasePanelDialog) r1).I;
        if (r2 == null) goto L12;
        ViewExtensionsKt.d(r2);
        return;
    L12:
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.panel.OBasePanelDialog");
    }

    @Override // com.obric.oui.panel.OBasicPanelFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.f(r4, "view");
        super.onViewCreated(r4, r5);
        LinearLayout r6 = (LinearLayout) r4.findViewById(R.id.action_sheet_layout);
        Drawable r0 = ContextCompat.getDrawable(requireContext(), R.drawable.o_action_sheet_const_bg);
        if (r6 == null) goto L5;
        r6.setBackground(r0);
    L5:
        r4.findViewById(R.id.divider_view).setBackgroundColor(a("divider_view"));
        LinearLayout r7 = (LinearLayout) r4.findViewById(R.id.title_container);
        TextView r1 = (TextView) r7.findViewById(R.id.action_title);
        this.b = r1;
        if (r1 == null) goto L8;
        r1.setTextColor(a("extension_title"));
    L8:
        TextView r2 = (TextView) r7.findViewById(R.id.action_sub_title);
        this.c = r2;
        if (r2 == null) goto L11;
        r2.setTextColor(a("extension_subtitle"));
    L11:
        View r3 = r7.findViewById(R.id.top_divider);
        r3.setBackgroundColor(a("divider_line"));
        r3.setVisibility(4);
        TextView r8 = this.b;
        if (r8 == null) goto L14;
        r8.setVisibility(8);
    L14:
        TextView r9 = this.c;
        if (r9 == null) goto L17;
        r9.setMaxLines(2);
    L17:
        TextView r10 = this.c;
        if (r10 == null) goto L20;
        r10.setVisibility(8);
    L20:
        r7.setVisibility(8);
        TextView r11 = (TextView) r4.findViewById(R.id.cancel_action);
        if (r11 == null) goto L23;
        r11.setTextColor(a("item_title"));
    L23:
        Intrinsics.e(r11, "cancelAction");
        r11.setAccessibilityDelegate(new AnonymousClass1());
        r11.setOnClickListener(new AnonymousClass2(this));
        LinearLayout r12 = (LinearLayout) r4.findViewById(R.id.action_container);
        throw null;
    }
}
