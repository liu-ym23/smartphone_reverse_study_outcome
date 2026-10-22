package com.ss.android.init.tasks;

import com.bytedance.news.common.service.manager.IService;
import d.b.p.a.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/init/tasks/GodzillaInitTaskHook;", "Lcom/bytedance/news/common/service/manager/IService;", "Ld/b/p/a/a$b;", "config", "Lkotlin/f0;", "before", "(Ld/b/p/a/a$b;)V", "after", "()V", "", "hook", "()Z", "launch_release"}, k = 1, mv = {1, 1, 15})
public interface GodzillaInitTaskHook extends IService {
    void after();

    void before(a.b r1);

    boolean hook();
}
