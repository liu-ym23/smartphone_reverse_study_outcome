package okhttp3.internal.io;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface FileSystem {
    public static final Companion Companion = null;

    @JvmField
    @NotNull
    public static final FileSystem SYSTEM = null;

    @Metadata
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        @Metadata
        public static final class SystemFileSystem implements FileSystem {
            public SystemFileSystem() {
            }

            @Override // okhttp3.internal.io.FileSystem
            @NotNull
            public Sink appendingSink(@NotNull File r1) {
                Intrinsics.f(r1, "file");
                return Okio.appendingSink(r1);
            L5:
                r1.getParentFile().mkdirs();
                return Okio.appendingSink(r1);
            }

            @Override // okhttp3.internal.io.FileSystem
            public void delete(@NotNull File r3) {
                Intrinsics.f(r3, "file");
                if (r3.delete() == false) goto L5;
                return;
            L5:
                if (r3.exists() == true) goto L8;
                return;
            L8:
                throw new IOException("failed to delete " + r3);
            }

            @Override // okhttp3.internal.io.FileSystem
            public void deleteContents(@NotNull File r5) {
                Intrinsics.f(r5, "directory");
                File[] r0 = r5.listFiles();
                if (r0 == null) goto L16;
                int r6 = r0.length;
                int r1 = 0;
            L5:
                if (r1 >= r6) goto L14;
                File r2 = r0[r1];
                Intrinsics.e(r2, "file");
                if (r2.isDirectory() == false) goto L10;
                deleteContents(r2);
            L10:
                if (r2.delete() == false) goto L13;
                r1 = r1 + 1;
                goto L5
            L13:
                throw new IOException("failed to delete " + r2);
            L14:
                return;
            L16:
                throw new IOException("not a readable directory: " + r5);
            }

            @Override // okhttp3.internal.io.FileSystem
            public boolean exists(@NotNull File r1) {
                Intrinsics.f(r1, "file");
                return r1.exists();
            }

            @Override // okhttp3.internal.io.FileSystem
            public void rename(@NotNull File r3, @NotNull File r4) {
                Intrinsics.f(r3, "from");
                Intrinsics.f(r4, TypedValues.TransitionType.S_TO);
                delete(r4);
                if (r3.renameTo(r4) == false) goto L6;
                return;
            L6:
                throw new IOException("failed to rename " + r3 + " to " + r4);
            }

            @Override // okhttp3.internal.io.FileSystem
            @NotNull
            public Sink sink(@NotNull File r4) {
                Intrinsics.f(r4, "file");
                return Okio.sink$default(r4, false, 1, null);
            L5:
                r4.getParentFile().mkdirs();
                return Okio.sink$default(r4, false, 1, null);
            }

            @Override // okhttp3.internal.io.FileSystem
            public long size(@NotNull File r1) {
                Intrinsics.f(r1, "file");
                return r1.length();
            }

            @Override // okhttp3.internal.io.FileSystem
            @NotNull
            public Source source(@NotNull File r1) {
                Intrinsics.f(r1, "file");
                return Okio.source(r1);
            }

            @NotNull
            public String toString() {
                return "FileSystem.SYSTEM";
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        SYSTEM = new Companion.SystemFileSystem();
    }

    @NotNull
    Sink appendingSink(@NotNull File r1);

    void delete(@NotNull File r1);

    void deleteContents(@NotNull File r1);

    boolean exists(@NotNull File r1);

    void rename(@NotNull File r1, @NotNull File r2);

    @NotNull
    Sink sink(@NotNull File r1);

    long size(@NotNull File r1);

    @NotNull
    Source source(@NotNull File r1);
}
