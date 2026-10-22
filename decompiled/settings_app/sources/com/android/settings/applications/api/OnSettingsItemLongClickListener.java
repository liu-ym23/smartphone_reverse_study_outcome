package com.android.settings.applications.api;

import android.view.View;
import android.widget.Adapter;
import kotlin.Metadata;

/* JADX INFO: compiled from: OnSettingsItemClickListener.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/android/settings/applications/api/OnSettingsItemLongClickListener;", "", "onItemLongClick", "", "adapter", "Landroid/widget/Adapter;", "view", "Landroid/view/View;", "position", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface OnSettingsItemLongClickListener {
    boolean onItemLongClick(Adapter r1, View r2, int r3);
}
