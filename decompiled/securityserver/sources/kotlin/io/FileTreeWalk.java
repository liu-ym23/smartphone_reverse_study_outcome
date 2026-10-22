package kotlin.io;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractIterator;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FileTreeWalk implements Sequence<File> {

    @Metadata
    public static abstract class DirectoryState extends WalkState {
    }

    @Metadata
    public final class FileTreeWalkIterator extends AbstractIterator<File> {
        public final ArrayDeque e;

        @Metadata
        public final class BottomUpDirectoryState extends DirectoryState {
            @Override // kotlin.io.FileTreeWalk.WalkState
            public final File a() {
                throw null;
            }
        }

        @Metadata
        public final class SingleFileState extends WalkState {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f341a;

            @Override // kotlin.io.FileTreeWalk.WalkState
            public final File a() {
                if (this.f341a == false) goto L6;
                return null;
            L6:
                this.f341a = true;
                throw null;
            }
        }

        @Metadata
        public final class TopDownDirectoryState extends DirectoryState {
            @Override // kotlin.io.FileTreeWalk.WalkState
            public final File a() {
                throw null;
            }
        }

        @Metadata
        public /* synthetic */ class WhenMappings {
            static {
                int[] r0 = new int[FileWalkDirection.values().length];
                r0[0] = 1;
                r0[1] = 2;
            }
        }

        public FileTreeWalkIterator(FileTreeWalk r2) {
            this.e = new ArrayDeque();
            r2.getClass();
            throw null;
        }

        @Override // kotlin.collections.AbstractIterator
        public final void a() {
        L2:
            ArrayDeque r0 = this.e;
            WalkState r1 = (WalkState) r0.peek();
            if (r1 == null) goto L4;
            if (r1.a() != null) goto L10;
            r0.pop();
            goto L2
        L10:
            throw null;
        L4:
            b();
        }
    }

    @Metadata
    public static abstract class WalkState {
        public abstract File a();
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        new FileTreeWalkIterator(this);
        throw null;
    }
}
