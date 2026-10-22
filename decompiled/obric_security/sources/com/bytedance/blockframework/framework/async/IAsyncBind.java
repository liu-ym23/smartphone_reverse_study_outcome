package com.bytedance.blockframework.framework.async;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: IAsyncBlock.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J5\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00018\u00002\u001c\u0010\u0006\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b\u0012\u0004\u0012\u00020\u00040\u0007j\u0002`\tH&¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH&J\u0017\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000H'¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/blockframework/framework/async/IAsyncBind;", "MODEL", "", "asyncBind", "", "model", "syncInvoke", "Lkotlin/Function1;", "Lkotlin/Function0;", "Lcom/bytedance/blockframework/framework/async/SyncInvoke;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "enableAsyncBind", "", "syncBind", "(Ljava/lang/Object;)V", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IAsyncBind<MODEL> {
    void asyncBind(MODEL r1, Function1<? super Function0<Unit>, Unit> r2);

    boolean enableAsyncBind();

    void syncBind(MODEL r1);
}
