package com.obric.oui.dialog;

import android.app.Dialog;
import android.content.res.Configuration;
import kotlin.Metadata;

/* JADX INFO: compiled from: DialogExtInterface.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/dialog/DialogExtInterface;", "", "OnConfigurationListener", "OnDismissAnimListener", "OnShowAnimListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DialogExtInterface {

    /* JADX INFO: compiled from: DialogExtInterface.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/dialog/DialogExtInterface$OnConfigurationListener;", "", "onConfigurationChanged", "", "dialog", "Landroid/app/Dialog;", "configuration", "Landroid/content/res/Configuration;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnConfigurationListener {
        void onConfigurationChanged(Dialog r1, Configuration r2);
    }

    /* JADX INFO: compiled from: DialogExtInterface.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/dialog/DialogExtInterface$OnDismissAnimListener;", "", "onDismissAnimEnd", "", "dialog", "Landroid/app/Dialog;", "onDismissAnimStart", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnDismissAnimListener {
        void onDismissAnimEnd(Dialog r1);

        void onDismissAnimStart(Dialog r1);
    }

    /* JADX INFO: compiled from: DialogExtInterface.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/dialog/DialogExtInterface$OnShowAnimListener;", "", "onShowAnimEnd", "", "dialog", "Landroid/app/Dialog;", "onShowAnimStart", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnShowAnimListener {
        void onShowAnimEnd(Dialog r1);

        void onShowAnimStart(Dialog r1);
    }
}
