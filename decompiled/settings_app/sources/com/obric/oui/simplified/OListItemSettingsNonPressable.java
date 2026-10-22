package com.obric.oui.simplified;

import android.content.Context;
import android.util.AttributeSet;
import com.obric.oui.lisitem.OListItemSettings;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OListItemSettingsNonPressable.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/obric/oui/simplified/OListItemSettingsNonPressable;", "Lcom/obric/oui/lisitem/OListItemSettings;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isPressable", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class OListItemSettingsNonPressable extends OListItemSettings {
    @Override // com.obric.oui.layout.OUIFrameLayout
    public boolean isPressable() {
        return false;
    }

    public /* synthetic */ OListItemSettingsNonPressable(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public OListItemSettingsNonPressable(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }
}
