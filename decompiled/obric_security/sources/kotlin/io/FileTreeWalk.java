package kotlin.io;

import com.obric.oui.material.MaterialConfigFormatNames;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: FileTreeWalk.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001a\u001b\u001cB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0089\u0001\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b\u00128\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0096\u0002J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0014J\u001a\u0010\u0007\u001a\u00020\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\bJ \u0010\f\u001a\u00020\u00002\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\rJ\u001a\u0010\n\u001a\u00020\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlin/io/FileTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/io/File;", "start", MaterialConfigFormatNames.DIRECTION, "Lkotlin/io/FileWalkDirection;", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)V", "onEnter", "Lkotlin/Function1;", "", "onLeave", "", "onFail", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "f", "Ljava/io/IOException;", "e", "maxDepth", "", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;I)V", "iterator", "", "depth", "function", "DirectoryState", "FileTreeWalkIterator", "WalkState", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FileTreeWalk implements Sequence<File> {
    private final FileWalkDirection direction;
    private final int maxDepth;
    private final Function1<File, Boolean> onEnter;
    private final Function2<File, IOException, Unit> onFail;
    private final Function1<File, Unit> onLeave;
    private final File start;

    /* JADX INFO: compiled from: FileTreeWalk.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\"\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/io/FileTreeWalk$DirectoryState;", "Lkotlin/io/FileTreeWalk$WalkState;", "rootDir", "Ljava/io/File;", "(Ljava/io/File;)V", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static abstract class DirectoryState extends WalkState {
        public DirectoryState(File r2) {
            Intrinsics.checkNotNullParameter(r2, "rootDir");
            super(r2);
        }
    }

    /* JADX INFO: compiled from: FileTreeWalk.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\r\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0082\u0010R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;", "Lkotlin/collections/AbstractIterator;", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk;)V", "state", "Ljava/util/ArrayDeque;", "Lkotlin/io/FileTreeWalk$WalkState;", "computeNext", "", "directoryState", "Lkotlin/io/FileTreeWalk$DirectoryState;", "root", "gotoNext", "BottomUpDirectoryState", "SingleFileState", "TopDownDirectoryState", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class FileTreeWalkIterator extends AbstractIterator<File> {
        private final ArrayDeque<WalkState> state;
        final /* synthetic */ FileTreeWalk this$0;

        /* JADX INFO: compiled from: FileTreeWalk.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$BottomUpDirectoryState;", "Lkotlin/io/FileTreeWalk$DirectoryState;", "rootDir", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "failed", "", "fileIndex", "", "fileList", "", "[Ljava/io/File;", "rootVisited", "step", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
        private final class BottomUpDirectoryState extends DirectoryState {
            private boolean failed;
            private int fileIndex;
            private File[] fileList;
            private boolean rootVisited;
            final /* synthetic */ FileTreeWalkIterator this$0;

            public BottomUpDirectoryState(FileTreeWalkIterator r2, File r3) {
                Intrinsics.checkNotNullParameter(r3, "rootDir");
                this.this$0 = r2;
                super(r3);
            }

            @Override // kotlin.io.FileTreeWalk.WalkState
            public File step() {
                if (this.failed == false) goto L5;
            L19:
                File[] r0 = this.fileList;
                if (r0 == null) goto L26;
                int r3 = this.fileIndex;
                Intrinsics.checkNotNull(r0);
                if (r3 >= r0.length) goto L26;
                File[] r1 = this.fileList;
                Intrinsics.checkNotNull(r1);
                int r2 = this.fileIndex;
                this.fileIndex = r2 + 1;
                return r1[r2];
            L26:
                if (this.rootVisited == true) goto L29;
                this.rootVisited = true;
                return getRoot();
            L29:
                Function1 r4 = FileTreeWalk.access$getOnLeave$p(this.this$0.this$0);
                if (r4 == null) goto L32;
                r4.invoke(getRoot());
            L32:
                return null;
            L5:
                if (this.fileList != null) goto L19;
                Function1 r5 = FileTreeWalk.access$getOnEnter$p(this.this$0.this$0);
                boolean r6 = false;
                if (r5 != null) goto L9;
            L11:
                if (r6 == false) goto L13;
                return null;
            L13:
                File[] r7 = getRoot().listFiles();
                this.fileList = r7;
                if (r7 != null) goto L19;
                Function2 r8 = FileTreeWalk.access$getOnFail$p(this.this$0.this$0);
                if (r8 == null) goto L18;
                r8.invoke(getRoot(), new AccessDeniedException(getRoot(), null, "Cannot list files in a directory", 2, null));
            L18:
                this.failed = true;
                goto L19
            L9:
                if (((Boolean) r5.invoke(getRoot())).booleanValue() == true) goto L11;
                r6 = true;
                goto L11
            }
        }

        /* JADX INFO: compiled from: FileTreeWalk.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$SingleFileState;", "Lkotlin/io/FileTreeWalk$WalkState;", "rootFile", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "visited", "", "step", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
        private final class SingleFileState extends WalkState {
            final /* synthetic */ FileTreeWalkIterator this$0;
            private boolean visited;

            public SingleFileState(FileTreeWalkIterator r2, File r3) {
                Intrinsics.checkNotNullParameter(r3, "rootFile");
                this.this$0 = r2;
                super(r3);
            }

            @Override // kotlin.io.FileTreeWalk.WalkState
            public File step() {
                if (this.visited == false) goto L6;
                return null;
            L6:
                this.visited = true;
                return getRoot();
            }
        }

        /* JADX INFO: compiled from: FileTreeWalk.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$TopDownDirectoryState;", "Lkotlin/io/FileTreeWalk$DirectoryState;", "rootDir", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "fileIndex", "", "fileList", "", "[Ljava/io/File;", "rootVisited", "", "step", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
        private final class TopDownDirectoryState extends DirectoryState {
            private int fileIndex;
            private File[] fileList;
            private boolean rootVisited;
            final /* synthetic */ FileTreeWalkIterator this$0;

            public TopDownDirectoryState(FileTreeWalkIterator r2, File r3) {
                Intrinsics.checkNotNullParameter(r3, "rootDir");
                this.this$0 = r2;
                super(r3);
            }

            @Override // kotlin.io.FileTreeWalk.WalkState
            public File step() {
                if (this.rootVisited == true) goto L13;
                Function1 r0 = FileTreeWalk.access$getOnEnter$p(this.this$0.this$0);
                boolean r2 = false;
                if (r0 != null) goto L7;
            L9:
                if (r2 == false) goto L11;
                return null;
            L11:
                this.rootVisited = true;
                return getRoot();
            L7:
                if (((Boolean) r0.invoke(getRoot())).booleanValue() == true) goto L9;
                r2 = true;
                goto L9
            L13:
                File[] r1 = this.fileList;
                if (r1 == null) goto L23;
                int r3 = this.fileIndex;
                Intrinsics.checkNotNull(r1);
                if (r3 < r1.length) goto L23;
                Function1 r4 = FileTreeWalk.access$getOnLeave$p(this.this$0.this$0);
                if (r4 == null) goto L21;
                r4.invoke(getRoot());
            L21:
                return null;
            L23:
                if (this.fileList != null) goto L37;
                File[] r5 = getRoot().listFiles();
                this.fileList = r5;
                if (r5 != null) goto L29;
                Function2 r6 = FileTreeWalk.access$getOnFail$p(this.this$0.this$0);
                if (r6 == null) goto L29;
                r6.invoke(getRoot(), new AccessDeniedException(getRoot(), null, "Cannot list files in a directory", 2, null));
            L29:
                File[] r7 = this.fileList;
                if (r7 == null) goto L33;
                Intrinsics.checkNotNull(r7);
                if (r7.length != 0) goto L37;
            L33:
                Function1 r8 = FileTreeWalk.access$getOnLeave$p(this.this$0.this$0);
                if (r8 == null) goto L36;
                r8.invoke(getRoot());
            L36:
                return null;
            L37:
                File[] r9 = this.fileList;
                Intrinsics.checkNotNull(r9);
                int r10 = this.fileIndex;
                this.fileIndex = r10 + 1;
                return r9[r10];
            }
        }

        /* JADX INFO: compiled from: FileTreeWalk.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r0 = new int[FileWalkDirection.values().length];
                r0[FileWalkDirection.TOP_DOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[FileWalkDirection.BOTTOM_UP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                $EnumSwitchMapping$0 = r0;
            }
        }

        public FileTreeWalkIterator(FileTreeWalk r3) {
            this.this$0 = r3;
            ArrayDeque<WalkState> r0 = new ArrayDeque();
            this.state = r0;
            if (FileTreeWalk.access$getStart$p(r3).isDirectory() == false) goto L6;
            r0.push(directoryState(FileTreeWalk.access$getStart$p(r3)));
            return;
        L6:
            if (FileTreeWalk.access$getStart$p(r3).isFile() == false) goto L8;
            r0.push(new SingleFileState(this, FileTreeWalk.access$getStart$p(r3)));
            return;
        L8:
            done();
        }

        @Override // kotlin.collections.AbstractIterator
        protected void computeNext() {
            File r0 = gotoNext();
            if (r0 == null) goto L5;
            setNext(r0);
            return;
        L5:
            done();
        }

        private final DirectoryState directoryState(File r3) {
            FileWalkDirection r0 = FileTreeWalk.access$getDirection$p(this.this$0);
            int r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
            if (r1 == 1) goto L10;
            if (r1 != 2) goto L8;
            return new BottomUpDirectoryState(this, r3);
        L8:
            throw new NoWhenBranchMatchedException();
        L10:
            return new TopDownDirectoryState(this, r3);
        }

        private final File gotoNext() {
        L2:
            WalkState r0 = this.state.peek();
            if (r0 == null) goto L4;
            File r1 = r0.step();
            if (r1 == null) goto L8;
            if (Intrinsics.areEqual(r1, r0.getRoot()) == true) goto L17;
            if (r1.isDirectory() == false) goto L17;
            if (this.state.size() >= FileTreeWalk.access$getMaxDepth$p(this.this$0)) goto L17;
            this.state.push(directoryState(r1));
        L17:
            return r1;
        L8:
            this.state.pop();
            goto L2
        L4:
            return null;
        }
    }

    /* JADX INFO: compiled from: FileTreeWalk.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\"\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lkotlin/io/FileTreeWalk$WalkState;", "", "root", "Ljava/io/File;", "(Ljava/io/File;)V", "getRoot", "()Ljava/io/File;", "step", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static abstract class WalkState {
        private final File root;

        public abstract File step();

        public WalkState(File r2) {
            Intrinsics.checkNotNullParameter(r2, "root");
            this.root = r2;
        }

        public final File getRoot() {
            return this.root;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private FileTreeWalk(File r1, FileWalkDirection r2, Function1<? super File, Boolean> r3, Function1<? super File, Unit> r4, Function2<? super File, ? super IOException, Unit> r5, int r6) {
        this.start = r1;
        this.direction = r2;
        this.onEnter = r3;
        this.onLeave = r4;
        this.onFail = r5;
        this.maxDepth = r6;
    }

    public static final /* synthetic */ FileWalkDirection access$getDirection$p(FileTreeWalk r0) {
        return r0.direction;
    }

    public static final /* synthetic */ int access$getMaxDepth$p(FileTreeWalk r0) {
        return r0.maxDepth;
    }

    public static final /* synthetic */ Function1 access$getOnEnter$p(FileTreeWalk r0) {
        return r0.onEnter;
    }

    public static final /* synthetic */ Function2 access$getOnFail$p(FileTreeWalk r0) {
        return r0.onFail;
    }

    public static final /* synthetic */ Function1 access$getOnLeave$p(FileTreeWalk r0) {
        return r0.onLeave;
    }

    public static final /* synthetic */ File access$getStart$p(FileTreeWalk r0) {
        return r0.start;
    }

    /* synthetic */ FileTreeWalk(File r8, FileWalkDirection r9, Function1 r10, Function1 r11, Function2 r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L5;
        r9 = FileWalkDirection.TOP_DOWN;
    L5:
        FileWalkDirection r2 = r9;
        if ((r14 & 32) == 0) goto L8;
        r13 = Integer.MAX_VALUE;
    L8:
        this(r8, r2, r10, r11, r12, r13);
    }

    public FileTreeWalk(File r11, FileWalkDirection r12) {
        Intrinsics.checkNotNullParameter(r11, "start");
        Intrinsics.checkNotNullParameter(r12, MaterialConfigFormatNames.DIRECTION);
        this(r11, r12, null, null, null, 0, 32, null);
    }

    public /* synthetic */ FileTreeWalk(File r1, FileWalkDirection r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = FileWalkDirection.TOP_DOWN;
    L5:
        this(r1, r2);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<File> iterator() {
        return new FileTreeWalkIterator(this);
    }

    public final FileTreeWalk onEnter(Function1<? super File, Boolean> r9) {
        Intrinsics.checkNotNullParameter(r9, "function");
        return new FileTreeWalk(this.start, this.direction, r9, this.onLeave, this.onFail, this.maxDepth);
    }

    public final FileTreeWalk onLeave(Function1<? super File, Unit> r9) {
        Intrinsics.checkNotNullParameter(r9, "function");
        return new FileTreeWalk(this.start, this.direction, this.onEnter, r9, this.onFail, this.maxDepth);
    }

    public final FileTreeWalk onFail(Function2<? super File, ? super IOException, Unit> r9) {
        Intrinsics.checkNotNullParameter(r9, "function");
        return new FileTreeWalk(this.start, this.direction, this.onEnter, this.onLeave, r9, this.maxDepth);
    }

    public final FileTreeWalk maxDepth(int r9) {
        if (r9 <= 0) goto L6;
        return new FileTreeWalk(this.start, this.direction, this.onEnter, this.onLeave, this.onFail, r9);
    L6:
        throw new IllegalArgumentException("depth must be positive, but was " + r9 + '.');
    }
}
