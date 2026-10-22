package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final /* synthetic */ class Regex$findAll$2 extends FunctionReferenceImpl implements Function1<MatchResult, MatchResult> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r1) {
        MatchResult r2 = (MatchResult) r1;
        Intrinsics.f(r2, "p0");
        return r2.next();
    }
}
