package com.bytedance.blockframework.framework.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: BlockGenerator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/blockframework/framework/core/BlockGenerator;", "", "generate", "", "action", "Lkotlin/Function1;", "Lcom/bytedance/blockframework/framework/core/SubBlockCreator;", "Lkotlin/ExtensionFunctionType;", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface BlockGenerator {
    void generate(Function1<? super SubBlockCreator, Unit> r1);
}
