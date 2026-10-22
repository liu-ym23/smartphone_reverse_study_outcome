package com.obric.oui.panel.header;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BasicPanelHeader.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/panel/header/BasicPanelCustomViewHeader;", "Lcom/obric/oui/panel/header/BasicPanelHeader;", "context", "Landroid/content/Context;", "useAutoSwitchTheme", "", "themeResId", "", "(Landroid/content/Context;ZI)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class BasicPanelCustomViewHeader extends BasicPanelHeader {
    public BasicPanelCustomViewHeader(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, false, 0, 6, null);
    }

    public BasicPanelCustomViewHeader(Context r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ BasicPanelCustomViewHeader(Context r2, boolean r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r2, r3, r4);
    }

    public BasicPanelCustomViewHeader(Context r2, boolean r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4, null);
    }
}
