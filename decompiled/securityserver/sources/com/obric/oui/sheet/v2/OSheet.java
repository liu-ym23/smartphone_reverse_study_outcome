package com.obric.oui.sheet.v2;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.annotation.RequiresApi;
import com.obric.oui.common.util.ResourceUtils;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(30)
@Metadata
public class OSheet extends Dialog {
    public static final /* synthetic */ int b = 0;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final enum Header extends Enum<Header> {
        public static final /* synthetic */ Header[] b = null;

        static {
            b = new Header[]{new Header("CUSTOM", 0), new Header("PAGE", 1), new Header("ACTION", 2), new Header("MODAL", 3), new Header("ONLY_TITLE", 4)};
        }

        public static Header valueOf(String r1) {
            return (Header) Enum.valueOf(Header.class, r1);
        }

        public static Header[] values() {
            return (Header[]) b.clone();
        }
    }

    @Metadata
    public static final enum HeightMode extends Enum<HeightMode> {
        public static final /* synthetic */ HeightMode[] b = null;

        static {
            b = new HeightMode[]{new HeightMode("FULL_HEIGHT", 0), new HeightMode("WRAP_HEIGHT", 1)};
        }

        public static HeightMode valueOf(String r1) {
            return (HeightMode) Enum.valueOf(HeightMode.class, r1);
        }

        public static HeightMode[] values() {
            return (HeightMode[]) b.clone();
        }
    }

    @Metadata
    public final /* synthetic */ class WhenMappings {
        static {
            int[] r0 = new int[HeightMode.values().length];
            r0[0] = 1;
            r0[1] = 2;
            int[] r1 = new int[Header.values().length];
            r1[1] = 1;
            r1[2] = 2;
            r1[3] = 3;
            r1[4] = 4;
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Intrinsics.m("rootContainer");
        throw null;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        Intrinsics.m("headerContainer");
        throw null;
    }

    @Override // android.app.Dialog
    public final void show() {
        Context r0 = getContext();
        Intrinsics.e(r0, "context");
        if (ResourceUtils.a(r0) == true) goto L32;
    L9:
        super.show();
        Window r1 = getWindow();
        if (r1 == null) goto L31;
        r1.setBackgroundDrawableResource(R.color.transparent);
        Context r8 = getContext();
        Intrinsics.e(r8, "context");
        Resources r9 = r8.getResources();
        Intrinsics.e(r9, "context.resources");
        if ((r9.getConfiguration().uiMode & 48) == 32) goto L14;
        boolean r10 = true;
    L15:
        WindowInsetsController r4 = r1.getInsetsController();
        if (r4 != null) goto L18;
    L22:
        WindowInsetsController r5 = r1.getInsetsController();
        if (r5 != null) goto L25;
    L29:
        r1.setNavigationBarContrastEnforced(false);
        r1.setDecorFitsSystemWindows(false);
        r1.clearFlags(134217728);
        r1.addFlags(Integer.MIN_VALUE);
        r1.setNavigationBarColor(0);
        r1.setNavigationBarDividerColor(0);
        r1.addFlags(2);
        Context r11 = r1.getContext();
        Intrinsics.e(r11, "context");
        Resources r12 = r11.getResources();
        Intrinsics.e(r12, "context.resources");
        int r13 = r12.getConfiguration().uiMode;
        r1.getAttributes();
        Intrinsics.m("dimView");
        throw null;
    L25:
        if (r10 == false) goto L27;
        int r14 = 16;
    L28:
        r5.setSystemBarsAppearance(r14, 16);
        goto L29
    L27:
        r14 = 0;
        goto L28
    L18:
        if (r10 == false) goto L20;
        int r7 = 8;
    L21:
        r4.setSystemBarsAppearance(r7, 8);
        goto L22
    L20:
        r7 = 0;
        goto L21
    L14:
        r10 = false;
        goto L15
    L31:
        return;
    L32:
        Intrinsics.m("rootContainer");     // Catch: Exception -> L7
        throw null;     // Catch: Exception -> L7
    L7:
        e = move-exception;
        L.c("OInsetSheet", "adjustContentHeight error", e);
        goto L9
    }
}
