package kotlin.text;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface MatchResult {

    @Metadata
    public static final class DefaultImpls {
    }

    @Metadata
    public static final class Destructured {
    }

    String getValue();

    MatchResult next();
}
