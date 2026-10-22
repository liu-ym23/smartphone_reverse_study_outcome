package com.android.settings.notification;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;

/* JADX INFO: compiled from: IConversationView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/android/settings/notification/IConversationView;", "Lcom/bytedance/news/common/service/manager/IService;", "createToParent", "Landroid/view/View;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface IConversationView extends IService {
    View createToParent(Context r1, ViewGroup r2);
}
