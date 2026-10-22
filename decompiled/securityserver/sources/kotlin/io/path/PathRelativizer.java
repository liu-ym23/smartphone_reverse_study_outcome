package kotlin.io.path;

import java.nio.file.Paths;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class PathRelativizer {
    static {
        Paths.get("", new String[0]);
        Paths.get("..", new String[0]);
    }
}
