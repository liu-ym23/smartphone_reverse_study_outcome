package kotlin.reflect;

import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
public interface KTypeParameter extends KClassifier {
    List getUpperBounds();
}
