package com.android.settings.accounts;

import android.content.Context;
import android.os.UserHandle;
import android.view.View;
import com.bytedance.news.common.service.manager.IService;

/* JADX INFO: loaded from: classes2.dex */
public interface IAccountAutoSyncItem extends IService {
    View create(Context r1, UserHandle r2, boolean r3);
}
