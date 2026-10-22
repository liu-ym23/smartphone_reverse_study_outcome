package com.bytedance.android.standard.tools.ui;

import android.view.View;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class AccessibilityUtilsKt {
    public static final void setAccessibilityClassName(@NotNull View r7, @NotNull CharSequence r8) {
        Intrinsics.g(r7, "$this$setAccessibilityClassName");
        Intrinsics.g(r8, "className");
        setAccessibilityOptions(r7, new AccessibilityOptions(null, false, r8, 3, null));
    }

    public static final void setAccessibilityHeading(@NotNull View r7) {
        Intrinsics.g(r7, "$this$setAccessibilityHeading");
        setAccessibilityOptions(r7, new AccessibilityOptions(null, true, null, 5, null));
    }

    public static final void setAccessibilityOptions(@NotNull View r1, @NotNull final AccessibilityOptions r2) {
        Intrinsics.g(r1, "$this$setAccessibilityOptions");
        Intrinsics.g(r2, "options");
        ViewCompat.setAccessibilityDelegate(r1, new AnonymousClass1(r2));
    }

    public static final void setContentDescriptionAndButton(@NotNull View r7, @NotNull String r8) {
        Intrinsics.g(r7, "$this$setContentDescriptionAndButton");
        Intrinsics.g(r8, "desc");
        setAccessibilityOptions(r7, new AccessibilityOptions(r8, false, "android.widget.Button", 2, null));
    }
}
