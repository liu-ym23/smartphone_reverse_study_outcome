package com.bytedance.blockframework.framework.join;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.blockframework.framework.base.BaseBlock;
import com.bytedance.blockframework.framework.core.BlockUnitHandler;
import com.bytedance.blockframework.framework.task.BlockInflater;
import com.bytedance.blockframework.interaction.Event;
import com.bytedance.blockframework.interaction.IBlockMessageCenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: BlockContextImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\tH&J%\u0010\n\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000eH&¢\u0006\u0002\u0010\u000fJ'\u0010\u0010\u001a\u0004\u0018\u0001H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000eH&¢\u0006\u0002\u0010\u000fJ#\u0010\u0011\u001a\u0004\u0018\u0001H\u000b\"\u0004\b\u0000\u0010\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000eH&¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH&J-\u0010\u001c\u001a\u00020\u0003\"\b\b\u0000\u0010\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000e2\u0006\u0010\u001d\u001a\u0002H\u000bH&¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0014H&J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0016H&¨\u0006#"}, d2 = {"Lcom/bytedance/blockframework/framework/join/IBlockContext;", "", "addAfterBindTask", "", "action", "Lkotlin/Function0;", "findBlockHandler", "Lcom/bytedance/blockframework/framework/core/BlockUnitHandler;", "block", "Lcom/bytedance/blockframework/framework/base/BaseBlock;", "findDepend", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/blockframework/framework/join/IBlockDepend;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/bytedance/blockframework/framework/join/IBlockDepend;", "findDependOrNull", "getBlockService", "(Ljava/lang/Class;)Ljava/lang/Object;", "getLayoutInflater", "Lcom/bytedance/blockframework/framework/task/BlockInflater;", "getMessageCenter", "Lcom/bytedance/blockframework/interaction/IBlockMessageCenter;", "getScene", "Lcom/bytedance/blockframework/framework/join/IBlockScene;", "notifyEvent", "event", "Lcom/bytedance/blockframework/interaction/Event;", "registerDepend", "depend", "(Ljava/lang/Class;Lcom/bytedance/blockframework/framework/join/IBlockDepend;)V", "setLayoutInflater", "inflater", "setMessageCenter", "center", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IBlockContext {
    void addAfterBindTask(Function0<Unit> r1);

    BlockUnitHandler findBlockHandler(BaseBlock<?, ?> r1);

    <T extends IBlockDepend> T findDepend(Class<T> r1);

    <T extends IBlockDepend> T findDependOrNull(Class<T> r1);

    <T> T getBlockService(Class<T> r1);

    BlockInflater getLayoutInflater();

    IBlockMessageCenter getMessageCenter();

    IBlockScene getScene();

    void notifyEvent(Event r1);

    <T extends IBlockDepend> void registerDepend(Class<T> r1, T r2);

    void setLayoutInflater(BlockInflater r1);

    void setMessageCenter(IBlockMessageCenter r1);
}
