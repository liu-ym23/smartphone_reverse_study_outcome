package com.android.settings.about;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AboutItem.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/android/settings/about/AboutItem;", "", "()V", "cardPosition", "", "getCardPosition", "()I", "setCardPosition", "(I)V", "clickListener", "Landroid/view/View$OnClickListener;", "getClickListener", "()Landroid/view/View$OnClickListener;", "setClickListener", "(Landroid/view/View$OnClickListener;)V", "endIconRes", "getEndIconRes", "setEndIconRes", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "value", "getValue", "setValue", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class AboutItem {
    private int cardPosition;
    private View.OnClickListener clickListener;
    private int endIconRes;
    private String name;
    private String value;

    public AboutItem() {
        this.name = "";
        this.value = "";
        this.cardPosition = 2;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.name = r2;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.value = r2;
    }

    public final int getEndIconRes() {
        return this.endIconRes;
    }

    public final void setEndIconRes(int r1) {
        this.endIconRes = r1;
    }

    public final View.OnClickListener getClickListener() {
        return this.clickListener;
    }

    public final void setClickListener(View.OnClickListener r1) {
        this.clickListener = r1;
    }

    public final int getCardPosition() {
        return this.cardPosition;
    }

    public final void setCardPosition(int r1) {
        this.cardPosition = r1;
    }
}
