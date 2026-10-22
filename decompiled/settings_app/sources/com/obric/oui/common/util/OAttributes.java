package com.obric.oui.common.util;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: OAttributes.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007J \u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ \u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ$\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0010\u001a\u00020\bH\u0007J \u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bJ \u0010\u0012\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0001\u0010\u0007\u001a\u00020\bJ \u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0001\u0010\u0007\u001a\u00020\b¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/common/util/OAttributes;", "", "()V", "resolve", "Landroid/util/TypedValue;", "context", "Landroid/content/Context;", "attributeResId", "", "resolveBoolean", "", "defaultValue", "resolveBooleanOrThrow", "errorMessageComponent", "", "resolveDimension", "defaultDimenResId", "resolveInteger", "resolveOrThrow", "componentView", "Landroid/view/View;", "resolveTypedValueOrThrow", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OAttributes {
    public static final OAttributes INSTANCE = null;

    static {
        INSTANCE = new OAttributes();
    }

    private OAttributes() {
    }

    public final TypedValue resolve(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        TypedValue r1 = new TypedValue();
        if (r2.getTheme().resolveAttribute(r3, r1, true) == true) goto L7;
        return null;
    L7:
        return r1;
    }

    public final TypedValue resolveTypedValueOrThrow(View r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "componentView");
        Context r0 = r3.getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "componentView.getContext()");
        String r5 = r3.getClass().getCanonicalName();
        if (r5 != null) goto L6;
        r5 = "unknown component";
    L6:
        return resolveTypedValueOrThrow(r0, r4, r5);
    }

    public final TypedValue resolveTypedValueOrThrow(Context r4, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r6, "errorMessageComponent");
        TypedValue r3 = resolve(r4, r5);
        if (r3 == null) goto L5;
        return r3;
    L5:
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        String r7 = String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", Arrays.copyOf(new Object[]{r6, r4.getResources().getResourceName(r5)}, 2));
        Intrinsics.checkNotNullExpressionValue(r7, "format(format, *args)");
        throw new IllegalArgumentException(r7);
    }

    public final int resolveOrThrow(Context r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "errorMessageComponent");
        return resolveTypedValueOrThrow(r2, r3, r4).data;
    }

    public final int resolveOrThrow(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "componentView");
        return resolveTypedValueOrThrow(r2, r3).data;
    }

    public final boolean resolveBooleanOrThrow(Context r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "errorMessageComponent");
        if (resolveOrThrow(r2, r3, r4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean resolveBoolean(Context r2, int r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        TypedValue r1 = resolve(r2, r3);
        if (r1 != null) goto L5;
        return r4;
    L5:
        if (r1.type == 18) goto L7;
        return r4;
    L7:
        if (r1.data == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public final int resolveInteger(Context r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        TypedValue r1 = resolve(r2, r3);
        if (r1 != null) goto L5;
        return r4;
    L5:
        if (r1.type == 16) goto L7;
        return r4;
    L7:
        return r1.data;
    }

    public final int resolveDimension(Context r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        TypedValue r1 = resolve(r2, r3);
        if (r1 != null) goto L5;
    L8:
        float r5 = r2.getResources().getDimension(r4);
    L10:
        return (int) r5;
    L5:
        if (r1.type != 5) goto L8;
        r5 = r1.getDimension(r2.getResources().getDisplayMetrics());
        goto L10
    }
}
