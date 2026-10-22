package com.android.settings.applications.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OActionDialogHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/android/settings/applications/utils/ActionItem;", "", "title", "", "actionStyle", "", "(Ljava/lang/String;I)V", "getActionStyle", "()I", "getTitle", "()Ljava/lang/String;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ActionItem {
    private final int actionStyle;
    private final String title;

    public ActionItem(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "title");
        this.title = r2;
        this.actionStyle = r3;
    }

    public final int getActionStyle() {
        return this.actionStyle;
    }

    public final String getTitle() {
        return this.title;
    }
}
