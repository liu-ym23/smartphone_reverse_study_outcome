package com.bytedance.android.standard.tools.ui;

import android.view.View;
import android.widget.Button;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AccessibilityUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"setAccessibilityClassName", "", "Landroid/view/View;", "className", "", "setAccessibilityHeading", "setAccessibilityOptions", "options", "Lcom/bytedance/android/standard/tools/ui/AccessibilityOptions;", "setContentDescriptionAndButton", "desc", "", "mohist-standard-tools_release"}, k = 2, mv = {1, 1, 15})
public final class AccessibilityUtilsKt {
    public static final void setAccessibilityOptions(View r1, final AccessibilityOptions r2) {
        Intrinsics.checkParameterIsNotNull(r1, "$this$setAccessibilityOptions");
        Intrinsics.checkParameterIsNotNull(r2, "options");
        ViewCompat.setAccessibilityDelegate(r1, new AnonymousClass1(r2));
    }

    public static final void setAccessibilityHeading(View r7) {
        Intrinsics.checkParameterIsNotNull(r7, "$this$setAccessibilityHeading");
        setAccessibilityOptions(r7, new AccessibilityOptions(null, true, null, 5, null));
    }

    public static final void setAccessibilityClassName(View r7, CharSequence r8) {
        Intrinsics.checkParameterIsNotNull(r7, "$this$setAccessibilityClassName");
        Intrinsics.checkParameterIsNotNull(r8, "className");
        setAccessibilityOptions(r7, new AccessibilityOptions(null, false, r8, 3, null));
    }

    public static final void setContentDescriptionAndButton(View r7, String r8) {
        Intrinsics.checkParameterIsNotNull(r7, "$this$setContentDescriptionAndButton");
        Intrinsics.checkParameterIsNotNull(r8, "desc");
        setAccessibilityOptions(r7, new AccessibilityOptions(r8, false, Button.class.getName(), 2, null));
    }
}
