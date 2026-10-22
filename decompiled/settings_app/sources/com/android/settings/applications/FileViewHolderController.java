package com.android.settings.applications;

import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes2.dex */
public interface FileViewHolderController {
    void onClick(Fragment r1);

    void queryStats();

    void setupView(AppViewHolder r1);

    boolean shouldShow();
}
