package com.ss.android.init.tasks;

import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/ss/android/init/tasks/TTNetInitTaskHook;", "Lcom/bytedance/news/common/service/manager/IService;", "Lkotlin/f0;", "before", "()V", "after", "", "hook", "()Z", "init_ttnet_release"}, k = 1, mv = {1, 1, 15})
public interface TTNetInitTaskHook extends IService {
    void after();

    void before();

    boolean hook();
}
