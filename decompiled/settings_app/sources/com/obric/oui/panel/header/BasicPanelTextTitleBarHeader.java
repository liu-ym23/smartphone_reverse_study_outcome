package com.obric.oui.panel.header;

import android.content.Context;
import android.view.View;
import com.obric.oui.titlebar.OTextTitleBar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BasicPanelHeader.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\bJ\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0004\u0018\u00010\n8VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/panel/header/BasicPanelTextTitleBarHeader;", "Lcom/obric/oui/panel/header/BasicPanelHeader;", "context", "Landroid/content/Context;", "useAutoSwitchTheme", "", "(Landroid/content/Context;Z)V", "titleBar", "Lcom/obric/oui/titlebar/OTextTitleBar;", "titleOnPad", "", "getTitleOnPad", "()Ljava/lang/String;", "setTitleOnPad", "(Ljava/lang/String;)V", "getTitleBar", "getView", "Landroid/view/View;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BasicPanelTextTitleBarHeader extends BasicPanelHeader {
    private final OTextTitleBar titleBar;
    private String titleOnPad;

    public BasicPanelTextTitleBarHeader(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        boolean r2 = false;
        this(r4, r2, 2, null);
    }

    public /* synthetic */ BasicPanelTextTitleBarHeader(Context r1, boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        this(r1, r2);
    }

    public BasicPanelTextTitleBarHeader(Context r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, 0, 4, null);
        OTextTitleBar r0 = new OTextTitleBar(r8);
        this.titleBar = r0;
        BasicPanelHeaderKt.initHeader$default(r0, r8, r9, null, 4, null);
    }

    @Override // com.obric.oui.panel.header.BasicPanelHeader
    public void setTitleOnPad(String r1) {
        this.titleOnPad = r1;
    }

    @Override // com.obric.oui.panel.header.BasicPanelHeader
    public String getTitleOnPad() {
        return this.titleBar.getTitleView().getText().toString();
    }

    @Override // com.obric.oui.panel.header.BasicPanelHeader
    public View getView() {
        return this.titleBar;
    }

    public final OTextTitleBar getTitleBar() {
        return this.titleBar;
    }
}
