package kotlin.reflect;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface KCallable<R> extends KAnnotatedElement {

    @Metadata
    public static final class DefaultImpls {
    }

    Object call(Object... r1);

    Object callBy(Map r1);

    List getParameters();

    KType getReturnType();

    List getTypeParameters();

    KVisibility getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
