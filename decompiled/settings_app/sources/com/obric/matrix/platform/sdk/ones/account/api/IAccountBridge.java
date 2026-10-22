package com.obric.matrix.platform.sdk.ones.account.api;

import com.obric.matrix.platform.sdk.ones.account.IAccountService;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: compiled from: IAccountBridge.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/account/api/IAccountBridge;", "", "addTokenHost", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "onBind", "", "binder", "Lcom/obric/matrix/platform/sdk/ones/account/IAccountService;", "onDisconnect", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IAccountBridge {
    ArrayList<String> addTokenHost();

    void onBind(IAccountService r1);

    void onDisconnect();
}
