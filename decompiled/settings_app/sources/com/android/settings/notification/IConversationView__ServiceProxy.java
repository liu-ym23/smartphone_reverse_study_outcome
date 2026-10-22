package com.android.settings.notification;

import com.bytedance.news.common.service.manager.IServiceProxy;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class IConversationView__ServiceProxy implements IServiceProxy<IConversationView> {
    public IConversationView__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IConversationView newInstance() {
        return newInstance();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IConversationView newInstance() {
        return new ConversationView();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        r2.put("com.android.settings.notification.IConversationView", "com.android.settings.notification.ConversationView");
    }
}
