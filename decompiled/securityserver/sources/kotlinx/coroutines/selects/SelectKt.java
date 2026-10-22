package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SelectKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Symbol f439a = null;
    public static final Symbol b = null;
    public static final Symbol c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Symbol f440d = null;
    public static final SeqNumber e = null;

    static {
        f439a = new Symbol("NOT_SELECTED");
        b = new Symbol("ALREADY_SELECTED");
        c = new Symbol("UNDECIDED");
        f440d = new Symbol("RESUMED");
        e = new SeqNumber();
    }
}
