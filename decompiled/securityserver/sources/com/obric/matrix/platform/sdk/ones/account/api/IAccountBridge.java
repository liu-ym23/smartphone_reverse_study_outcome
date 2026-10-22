package com.obric.matrix.platform.sdk.ones.account.api;

import com.obric.matrix.platform.sdk.ones.account.IAccountService;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface IAccountBridge {
    @NotNull
    ArrayList<String> addTokenHost();

    void onBind(@NotNull IAccountService r1);

    void onDisconnect();
}
