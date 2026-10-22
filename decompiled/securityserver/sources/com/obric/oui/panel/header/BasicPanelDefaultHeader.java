package com.obric.oui.panel.header;

import a.a;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.bytedance.securityserver.R;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.divider.ODivider;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class BasicPanelDefaultHeader extends BasicPanelHeader {
    public final AppCompatImageView e;
    public final ImageView f;
    public final View g;

    public BasicPanelDefaultHeader(Context r10) {
        super(r10);
        final View r2 = View.inflate(BasicPanelHeader.a(this, r10), R.layout.o_basic_panel_normal_header, null);
        Intrinsics.e(r2, "View.inflate(generateThe…anel_normal_header, null)");
        this.g = r2;
        ContextThemeWrapper r3 = this.f254a;
        if (r3 != null) goto L6;
        r3 = BasicPanelHeader.a(this, r10);
    L6:
        TypedValue r11 = new TypedValue();
        if (r3.getTheme().resolveAttribute(R.attr.oui_PanelDefaultHeaderHeight, r11, true) == true) goto L10;
        r11 = null;
    L10:
        if (r11 != null) goto L12;
    L16:
        float r12 = r3.getResources().getDimension(R.dimen.oui_panel_default_header_height);
    L15:
        int r13 = (int) r12;
        r2.setBackgroundColor(0);
        View r4 = r2.findViewById(R.id.iv_close);
        Intrinsics.e(r4, "rootView.findViewById(R.id.iv_close)");
        AppCompatImageView r5 = (AppCompatImageView) r4;
        this.e = r5;
        View r6 = r2.findViewById(R.id.tv_title);
        Intrinsics.e(r6, "rootView.findViewById(R.id.tv_title)");
        TextView r7 = (TextView) r6;
        View r8 = r2.findViewById(R.id.iv_back);
        Intrinsics.e(r8, "rootView.findViewById(R.id.iv_back)");
        ImageView r9 = (ImageView) r8;
        this.f = r9;
        View r14 = r2.findViewById(R.id.divider);
        Intrinsics.e(r14, "rootView.findViewById(R.id.divider)");
        ODivider r15 = (ODivider) r14;
        Intrinsics.e(r2.findViewById(R.id.grabber), "rootView.findViewById(R.id.grabber)");
        View r16 = r2.findViewById(R.id.main_view);
        Intrinsics.e(r16, "rootView.findViewById(R.id.main_view)");
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if (r17 == null) goto L30;
        r17.height = r13;
        r16.setLayoutParams(r17);
        if (TextUtils.isEmpty(null) == true) goto L25;
        Intrinsics.c(null);
        Boolean r18 = Boolean.FALSE;
        r7.setText(null);
        r7.setCompoundDrawables(null, null, null, null);
        if (r18.equals(Boolean.TRUE) == false) goto L25;
        r7.setTypeface(Typeface.defaultFromStyle(1));
    L25:
        if (ViewCompat.isAttachedToWindow(r2) == false) goto L27;
        int r19 = a.d("Resources.getSystem()", 1, 44);
        ViewExtensionsKt.c(r2, r19, r19, new View[]{r9, r5});
        return;
    L27:
        r2.addOnAttachStateChangeListener(new BasicPanelDefaultHeader$$special$$inlined$doOnAttach$1(r2, this));
        return;
    L30:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L12:
        if (r11.type != 5) goto L16;
        Resources r20 = r3.getResources();
        Intrinsics.e(r20, "context.resources");
        r12 = r11.getDimension(r20.getDisplayMetrics());
        goto L15
    }

    @Override // com.obric.oui.panel.header.BasicPanelHeader
    public final View b() {
        return this.g;
    }
}
