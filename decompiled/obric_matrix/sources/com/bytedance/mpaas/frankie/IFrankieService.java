package com.bytedance.mpaas.frankie;

import com.bytedance.news.common.service.manager.IService;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/mpaas/frankie/IFrankieService;", "Lcom/bytedance/news/common/service/manager/IService;", "", "", "getPatchInfo", "()Ljava/util/List;", "launch_release"}, k = 1, mv = {1, 1, 15})
public interface IFrankieService extends IService {
    List<String> getPatchInfo();
}
