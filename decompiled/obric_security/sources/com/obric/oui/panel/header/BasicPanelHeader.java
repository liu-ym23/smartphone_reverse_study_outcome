package com.obric.oui.panel.header;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.view.ContextThemeWrapper;
import com.obric.common.oui.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BasicPanelHeader.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B#\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\u0005H\u0004J\u0006\u0010(\u001a\u00020\u0003J\b\u0010)\u001a\u00020$H&J\u0006\u0010*\u001a\u00020$R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0001\u0007+,-./01¨\u00062"}, d2 = {"Lcom/obric/oui/panel/header/BasicPanelHeader;", "", "context", "Landroid/content/Context;", "useAutoSwitchTheme", "", "themeResId", "", "(Landroid/content/Context;ZI)V", "closeClickListenerOnPad", "Landroid/view/View$OnClickListener;", "getCloseClickListenerOnPad", "()Landroid/view/View$OnClickListener;", "setCloseClickListenerOnPad", "(Landroid/view/View$OnClickListener;)V", "getContext", "()Landroid/content/Context;", "forceSupportSwipeToClose", "getForceSupportSwipeToClose", "()Z", "setForceSupportSwipeToClose", "(Z)V", "getThemeResId", "()I", "setThemeResId", "(I)V", "themedContext", "titleOnPad", "", "getTitleOnPad", "()Ljava/lang/String;", "setTitleOnPad", "(Ljava/lang/String;)V", "getUseAutoSwitchTheme", "setUseAutoSwitchTheme", "viewOnPad", "Landroid/view/View;", "generateThemedContext", "baseContext", "autoSwitchDayNight", "getThemedContext", "getView", "getViewOnPad", "Lcom/obric/oui/panel/header/BasicPanelDefaultHeader;", "Lcom/obric/oui/panel/header/BasicPanelCustomViewHeader;", "Lcom/obric/oui/panel/header/BasicPanelDragHeader;", "Lcom/obric/oui/panel/header/BasicPanelNormalTitleBarHeader;", "Lcom/obric/oui/panel/header/BasicPanelTextTitleBarHeader;", "Lcom/obric/oui/panel/header/BasicPanelCompoundTitleBarHeader;", "Lcom/obric/oui/panel/header/BasicPanelButtonTitleBarHeader;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class BasicPanelHeader {
    private View.OnClickListener closeClickListenerOnPad;
    private final Context context;
    private boolean forceSupportSwipeToClose;
    private int themeResId;
    private Context themedContext;
    private String titleOnPad;
    private boolean useAutoSwitchTheme;
    private View viewOnPad;

    public /* synthetic */ BasicPanelHeader(Context r1, boolean r2, int r3, DefaultConstructorMarker r4) {
        this(r1, r2, r3);
    }

    public abstract View getView();

    private BasicPanelHeader(Context r1, boolean r2, int r3) {
        this.context = r1;
        this.useAutoSwitchTheme = r2;
        this.themeResId = r3;
        this.forceSupportSwipeToClose = true;
    }

    public /* synthetic */ BasicPanelHeader(Context r2, boolean r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r2, r3, r4, null);
    }

    public final Context getContext() {
        return this.context;
    }

    public final int getThemeResId() {
        return this.themeResId;
    }

    public final boolean getUseAutoSwitchTheme() {
        return this.useAutoSwitchTheme;
    }

    public final void setThemeResId(int r1) {
        this.themeResId = r1;
    }

    public final void setUseAutoSwitchTheme(boolean r1) {
        this.useAutoSwitchTheme = r1;
    }

    public View.OnClickListener getCloseClickListenerOnPad() {
        return this.closeClickListenerOnPad;
    }

    public void setCloseClickListenerOnPad(View.OnClickListener r1) {
        this.closeClickListenerOnPad = r1;
    }

    public String getTitleOnPad() {
        return this.titleOnPad;
    }

    public void setTitleOnPad(String r1) {
        this.titleOnPad = r1;
    }

    public final boolean getForceSupportSwipeToClose() {
        return this.forceSupportSwipeToClose;
    }

    public final void setForceSupportSwipeToClose(boolean r1) {
        this.forceSupportSwipeToClose = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View getViewOnPad() {
        View r0 = this.viewOnPad;
        if (r0 != null) goto L6;
        AttributeSet r3 = null;
        OPanelPadHeaderView r1 = new OPanelPadHeaderView(getThemedContext(), r3, 2, 0 == true ? 1 : 0);
        this.viewOnPad = r1;
        return r1;
    L6:
        return r0;
    }

    public final Context getThemedContext() {
        Context r0 = this.themedContext;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return generateThemedContext$default(this, this.context, false, 2, null);
    }

    public static /* synthetic */ Context generateThemedContext$default(BasicPanelHeader r0, Context r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = r0.useAutoSwitchTheme;
    L7:
        return r0.generateThemedContext(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateThemedContext");
    }

    protected final Context generateThemedContext(Context r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "baseContext");
        if (this.themeResId != 0) goto L10;
        if (r3 == false) goto L7;
        ContextThemeWrapper r4 = new ContextThemeWrapper(r2, R.style.OBasicPanelDayNightSwitch);
    L8:
        ContextThemeWrapper r5 = r4;
        this.themedContext = r5;
        return r5;
    L7:
        r4 = new ContextThemeWrapper(r2, R.style.OBasicPanelConstLight);
        goto L8
    L10:
        return new ContextThemeWrapper(r2, this.themeResId);
    }
}
