package kotlin.io;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final enum FileWalkDirection extends Enum<FileWalkDirection> {
    public static final /* synthetic */ FileWalkDirection[] b = null;

    static {
        b = new FileWalkDirection[]{new FileWalkDirection("TOP_DOWN", 0), new FileWalkDirection("BOTTOM_UP", 1)};
    }

    public static FileWalkDirection valueOf(String r1) {
        return (FileWalkDirection) Enum.valueOf(FileWalkDirection.class, r1);
    }

    public static FileWalkDirection[] values() {
        return (FileWalkDirection[]) b.clone();
    }
}
