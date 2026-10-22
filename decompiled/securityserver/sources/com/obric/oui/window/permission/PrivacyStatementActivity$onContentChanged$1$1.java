package com.obric.oui.window.permission;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class PrivacyStatementActivity$onContentChanged$1$1 implements OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PrivacyStatementActivity$onContentChanged$1$1 f324a = null;

    static {
        f324a = new PrivacyStatementActivity$onContentChanged$1$1();
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View r4, WindowInsetsCompat r5) {
        Intrinsics.e(r5, "insets");
        int r3 = r5.getSystemWindowInsetTop();
        int r0 = r5.getSystemWindowInsetBottom();
        Intrinsics.e(r4, BaseSwitches.V);
        r4.setPadding(r4.getPaddingLeft(), r3, r4.getPaddingRight(), r0);
        return r5;
    }
}
