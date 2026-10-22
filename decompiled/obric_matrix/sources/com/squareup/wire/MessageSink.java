package com.squareup.wire;

import java.io.Closeable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\n\b\u0000\u0010\u0002 \u0000*\u00020\u00012\u00020\u0003J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/squareup/wire/MessageSink;", "", "T", "Ljava/io/Closeable;", "message", "Lkotlin/f0;", "write", "(Ljava/lang/Object;)V", "cancel", "()V", "wire-runtime"}, k = 1, mv = {1, 1, 15})
public interface MessageSink<T> extends Closeable {
    void cancel();

    void write(T r1);
}
