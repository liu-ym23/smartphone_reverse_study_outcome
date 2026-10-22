package com.android.settings.wifi.assistant;

import android.content.Context;
import android.view.View;
import com.bytedance.news.common.service.manager.IService;

/* JADX INFO: loaded from: classes.dex */
public interface IPrivateDnsItemView extends IService {
    View create(Context r1);

    String launcher();

    int title();
}
