package com.obric.matrix.common_api;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H&¨\u0006\f"}, d2 = {"Lcom/obric/matrix/common_api/IBadgeApi;", "Lcom/bytedance/news/common/service/manager/IService;", "updateBadge", "", "context", "Landroid/content/Context;", "pkg", "", "setNum", "", "addNum", TypedValues.TransitionType.S_FROM, "common_api_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IBadgeApi extends IService {
    void updateBadge(Context r1, String r2, int r3, int r4, String r5);
}
