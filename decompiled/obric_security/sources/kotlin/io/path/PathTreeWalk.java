package kotlin.io.path;

import com.bytedance.frameworks.baselib.network.http.util.HttpStatus;
import com.bytedance.framwork.core.sdklib.DBHelper;
import java.nio.file.FileSystemLoopException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: PathTreeWalk.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0002J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0002J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0096\u0002JE\u0010\u0018\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0018\u0010\u001f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0!\u0012\u0004\u0012\u00020\u00190 H\u0082Hø\u0001\u0000¢\u0006\u0002\u0010\"R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lkotlin/io/path/PathTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/nio/file/Path;", "start", "options", "", "Lkotlin/io/path/PathWalkOption;", "(Ljava/nio/file/Path;[Lkotlin/io/path/PathWalkOption;)V", "followLinks", "", "getFollowLinks", "()Z", "includeDirectories", "getIncludeDirectories", "isBFS", "linkOptions", "Ljava/nio/file/LinkOption;", "getLinkOptions", "()[Ljava/nio/file/LinkOption;", "[Lkotlin/io/path/PathWalkOption;", "bfsIterator", "", "dfsIterator", "iterator", "yieldIfNeeded", "", "Lkotlin/sequences/SequenceScope;", "node", "Lkotlin/io/path/PathNode;", "entriesReader", "Lkotlin/io/path/DirectoryEntriesReader;", "entriesAction", "Lkotlin/Function1;", "", "(Lkotlin/sequences/SequenceScope;Lkotlin/io/path/PathNode;Lkotlin/io/path/DirectoryEntriesReader;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PathTreeWalk implements Sequence<Path> {
    private final PathWalkOption[] options;
    private final Path start;

    /* JADX INFO: renamed from: kotlin.io.path.PathTreeWalk$bfsIterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: PathTreeWalk.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Ljava/nio/file/Path;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlin.io.path.PathTreeWalk$bfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1}, l = {184, 190}, m = "invokeSuspend", n = {"$this$iterator", DBHelper.TABLE_QUEUE, "entriesReader", "pathNode", "this_$iv", "path$iv", "$this$iterator", DBHelper.TABLE_QUEUE, "entriesReader"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        final /* synthetic */ PathTreeWalk this$0;

        AnonymousClass1(PathTreeWalk r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r3);
            r0.L$0 = r2;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super Path> r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(SequenceScope<? super Path> r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00f3 -> B:11:0x007d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00f5 -> B:11:0x007d). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            DirectoryEntriesReader r2 = (DirectoryEntriesReader) this.L$2;
            ArrayDeque r5 = (ArrayDeque) this.L$1;
            SequenceScope r6 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r13);
        L12:
            if ((!r5.isEmpty()) == false) goto L35;
            PathNode r14 = (PathNode) r5.removeFirst();
            PathTreeWalk r7 = this.this$0;
            Path r8 = r14.getPath();
            LinkOption[] r9 = PathTreeWalk.access$getLinkOptions(r7);
            LinkOption[] r10 = (LinkOption[]) Arrays.copyOf(r9, r9.length);
            if (Files.isDirectory(r8, (LinkOption[]) Arrays.copyOf(r10, r10.length)) == true) goto L16;
            if (Files.exists(r8, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1)) == false) goto L12;
            this.L$0 = r6;
            this.L$1 = r5;
            this.L$2 = r2;
            this.L$3 = null;
            this.L$4 = null;
            this.L$5 = null;
            this.label = 2;
            if (r6.yield(r8, this) != r0) goto L12;
            return r0;
        L16:
            if (PathTreeWalkKt.access$createsCycle(r14) == true) goto L28;
            if (PathTreeWalk.access$getIncludeDirectories(r7) == false) goto L24;
            this.L$0 = r6;
            this.L$1 = r5;
            this.L$2 = r2;
            this.L$3 = r14;
            this.L$4 = r7;
            this.L$5 = r8;
            this.label = 1;
            if (r6.yield(r8, this) != r0) goto L22;
            return r0;
        L22:
            SequenceScope r11 = r6;
            PathNode r12 = r14;
            DirectoryEntriesReader r15 = r2;
            Path r3 = r8;
            ArrayDeque r16 = r5;
            PathTreeWalk r17 = r7;
        L23:
            r14 = r12;
            r6 = r11;
            ArrayDeque r18 = r16;
            r8 = r3;
            r2 = r15;
            r7 = r17;
            r5 = r18;
        L24:
            LinkOption[] r19 = PathTreeWalk.access$getLinkOptions(r7);
            LinkOption[] r20 = (LinkOption[]) Arrays.copyOf(r19, r19.length);
            if (Files.isDirectory(r8, (LinkOption[]) Arrays.copyOf(r20, r20.length)) == false) goto L12;
            r5.addAll(r2.readEntries(r14));
            goto L12
        L28:
            throw new FileSystemLoopException(r8.toString());
        L35:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            r3 = (Path) this.L$5;
            r17 = (PathTreeWalk) this.L$4;
            r12 = (PathNode) this.L$3;
            r15 = (DirectoryEntriesReader) this.L$2;
            r16 = (ArrayDeque) this.L$1;
            r11 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r13);
            goto L23
        L10:
            ResultKt.throwOnFailure(r13);
            SequenceScope r110 = (SequenceScope) this.L$0;
            ArrayDeque r4 = new ArrayDeque();
            DirectoryEntriesReader r21 = new DirectoryEntriesReader(PathTreeWalk.access$getFollowLinks(this.this$0));
            r4.addLast(new PathNode(PathTreeWalk.access$getStart$p(this.this$0), PathTreeWalkKt.access$keyOf(PathTreeWalk.access$getStart$p(this.this$0), PathTreeWalk.access$getLinkOptions(this.this$0)), null));
            r6 = r110;
            r5 = r4;
            r2 = r21;
            goto L12
        }
    }

    /* JADX INFO: renamed from: kotlin.io.path.PathTreeWalk$dfsIterator$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PathTreeWalk.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Ljava/nio/file/Path;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlin.io.path.PathTreeWalk$dfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3}, l = {184, 190, 199, HttpStatus.SC_RESET_CONTENT}, m = "invokeSuspend", n = {"$this$iterator", "stack", "entriesReader", "startNode", "this_$iv", "path$iv", "$this$iterator", "stack", "entriesReader", "$this$iterator", "stack", "entriesReader", "pathNode", "this_$iv", "path$iv", "$this$iterator", "stack", "entriesReader"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2"})
    static final class C04081 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        final /* synthetic */ PathTreeWalk this$0;

        C04081(PathTreeWalk r1, Continuation<? super C04081> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            C04081 r0 = new C04081(this.this$0, r3);
            r0.L$0 = r2;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super Path> r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(SequenceScope<? super Path> r1, Continuation<? super Unit> r2) {
            return ((C04081) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x01d5 -> B:36:0x0142). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x01d7 -> B:36:0x0142). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r19) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L14;
            if (r2 == 1) goto L13;
            if (r2 == 2) goto L12;
            if (r2 == 3) goto L11;
            if (r2 == 4) goto L12;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            Path r3 = (Path) this.L$5;
            PathTreeWalk r6 = (PathTreeWalk) this.L$4;
            PathNode r9 = (PathNode) this.L$3;
            DirectoryEntriesReader r10 = (DirectoryEntriesReader) this.L$2;
            ArrayDeque r11 = (ArrayDeque) this.L$1;
            SequenceScope r12 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r19);
        L50:
            SequenceScope r16 = r12;
            Path r13 = r3;
            DirectoryEntriesReader r4 = r10;
            PathNode r14 = r9;
            SequenceScope r15 = r16;
            ArrayDeque r17 = r11;
            PathTreeWalk r18 = r6;
            ArrayDeque r7 = r17;
        L51:
            LinkOption[] r110 = PathTreeWalk.access$getLinkOptions(r18);
            LinkOption[] r111 = (LinkOption[]) Arrays.copyOf(r110, r110.length);
            if (Files.isDirectory(r13, (LinkOption[]) Arrays.copyOf(r111, r111.length)) == false) goto L37;
            r14.setContentIterator(r4.readEntries(r14).iterator());
            r7.addLast(r14);
        L37:
            if ((!r7.isEmpty()) == false) goto L63;
            Iterator<PathNode> r112 = ((PathNode) r7.last()).getContentIterator();
            Intrinsics.checkNotNull(r112);
            if (r112.hasNext() == true) goto L40;
            r7.removeLast();
            goto L37
        L40:
            r14 = r112.next();
            r18 = this.this$0;
            r13 = r14.getPath();
            LinkOption[] r113 = PathTreeWalk.access$getLinkOptions(r18);
            LinkOption[] r114 = (LinkOption[]) Arrays.copyOf(r113, r113.length);
            if (Files.isDirectory(r13, (LinkOption[]) Arrays.copyOf(r114, r114.length)) == true) goto L43;
            if (Files.exists(r13, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1)) == false) goto L37;
            this.L$0 = r15;
            this.L$1 = r7;
            this.L$2 = r4;
            this.L$3 = null;
            this.L$4 = null;
            this.L$5 = null;
            this.label = 4;
            if (r15.yield(r13, this) != r1) goto L37;
            return r1;
        L43:
            if (PathTreeWalkKt.access$createsCycle(r14) == true) goto L55;
            if (PathTreeWalk.access$getIncludeDirectories(r18) == false) goto L51;
            this.L$0 = r15;
            this.L$1 = r7;
            this.L$2 = r4;
            this.L$3 = r14;
            this.L$4 = r18;
            this.L$5 = r13;
            this.label = 3;
            if (r15.yield(r13, this) != r1) goto L49;
            return r1;
        L49:
            r10 = r4;
            r3 = r13;
            r12 = r15;
            r9 = r14;
            r11 = r7;
            r6 = r18;
            goto L50
        L55:
            throw new FileSystemLoopException(r13.toString());
        L63:
            return Unit.INSTANCE;
        L12:
            r4 = (DirectoryEntriesReader) this.L$2;
            r7 = (ArrayDeque) this.L$1;
            r15 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r19);
            goto L37
        L13:
            Path r5 = (Path) this.L$5;
            PathTreeWalk r8 = (PathTreeWalk) this.L$4;
            PathNode r20 = (PathNode) this.L$3;
            DirectoryEntriesReader r115 = (DirectoryEntriesReader) this.L$2;
            ArrayDeque r116 = (ArrayDeque) this.L$1;
            SequenceScope r117 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r19);
        L24:
            Path r118 = r5;
            ArrayDeque r21 = r116;
            PathNode r119 = r20;
            r15 = r117;
            PathTreeWalk r120 = r8;
        L25:
            LinkOption[] r22 = PathTreeWalk.access$getLinkOptions(r120);
            LinkOption[] r23 = (LinkOption[]) Arrays.copyOf(r22, r22.length);
            if (Files.isDirectory(r118, (LinkOption[]) Arrays.copyOf(r23, r23.length)) == false) goto L35;
            r119.setContentIterator(r115.readEntries(r119).iterator());
            r21.addLast(r119);
        L35:
            r7 = r21;
            r4 = r115;
            goto L37
        L14:
            ResultKt.throwOnFailure(r19);
            r15 = (SequenceScope) this.L$0;
            r21 = new ArrayDeque();
            r115 = new DirectoryEntriesReader(PathTreeWalk.access$getFollowLinks(this.this$0));
            r119 = new PathNode(PathTreeWalk.access$getStart$p(this.this$0), PathTreeWalkKt.access$keyOf(PathTreeWalk.access$getStart$p(this.this$0), PathTreeWalk.access$getLinkOptions(this.this$0)), null);
            r120 = this.this$0;
            r118 = r119.getPath();
            LinkOption[] r121 = PathTreeWalk.access$getLinkOptions(r120);
            LinkOption[] r122 = (LinkOption[]) Arrays.copyOf(r121, r121.length);
            if (Files.isDirectory(r118, (LinkOption[]) Arrays.copyOf(r122, r122.length)) == false) goto L31;
            if (PathTreeWalkKt.access$createsCycle(r119) == true) goto L29;
            if (PathTreeWalk.access$getIncludeDirectories(r120) == false) goto L25;
            this.L$0 = r15;
            this.L$1 = r21;
            this.L$2 = r115;
            this.L$3 = r119;
            this.L$4 = r120;
            this.L$5 = r118;
            this.label = 1;
            if (r15.yield(r118, this) != r1) goto L23;
            return r1;
        L23:
            r8 = r120;
            r117 = r15;
            r20 = r119;
            r116 = r21;
            r5 = r118;
            goto L24
        L29:
            throw new FileSystemLoopException(r118.toString());
        L31:
            if (Files.exists(r118, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1)) == false) goto L35;
            this.L$0 = r15;
            this.L$1 = r21;
            this.L$2 = r115;
            this.label = 2;
            if (r15.yield(r118, this) != r1) goto L35;
            return r1;
        }
    }

    public PathTreeWalk(Path r2, PathWalkOption[] r3) {
        Intrinsics.checkNotNullParameter(r2, "start");
        Intrinsics.checkNotNullParameter(r3, "options");
        this.start = r2;
        this.options = r3;
    }

    public static final /* synthetic */ boolean access$getFollowLinks(PathTreeWalk r0) {
        return r0.getFollowLinks();
    }

    public static final /* synthetic */ boolean access$getIncludeDirectories(PathTreeWalk r0) {
        return r0.getIncludeDirectories();
    }

    public static final /* synthetic */ LinkOption[] access$getLinkOptions(PathTreeWalk r0) {
        return r0.getLinkOptions();
    }

    public static final /* synthetic */ Path access$getStart$p(PathTreeWalk r0) {
        return r0.start;
    }

    private final boolean getFollowLinks() {
        return ArraysKt.contains(this.options, PathWalkOption.FOLLOW_LINKS);
    }

    private final LinkOption[] getLinkOptions() {
        return LinkFollowing.INSTANCE.toLinkOptions(getFollowLinks());
    }

    private final boolean getIncludeDirectories() {
        return ArraysKt.contains(this.options, PathWalkOption.INCLUDE_DIRECTORIES);
    }

    private final boolean isBFS() {
        return ArraysKt.contains(this.options, PathWalkOption.BREADTH_FIRST);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<Path> iterator() {
        if (isBFS() == false) goto L6;
        return bfsIterator();
    L6:
        return dfsIterator();
    }

    private final Object yieldIfNeeded(SequenceScope<? super Path> r5, PathNode r6, DirectoryEntriesReader r7, Function1<? super List<PathNode>, Unit> r8, Continuation<? super Unit> r9) {
        Path r0 = r6.getPath();
        LinkOption[] r1 = access$getLinkOptions(this);
        LinkOption[] r2 = (LinkOption[]) Arrays.copyOf(r1, r1.length);
        if (Files.isDirectory(r0, (LinkOption[]) Arrays.copyOf(r2, r2.length)) == false) goto L15;
        if (PathTreeWalkKt.access$createsCycle(r6) == true) goto L13;
        if (access$getIncludeDirectories(this) == false) goto L9;
        InlineMarker.mark(0);
        r5.yield(r0, r9);
        InlineMarker.mark(1);
    L9:
        LinkOption[] r4 = access$getLinkOptions(this);
        LinkOption[] r10 = (LinkOption[]) Arrays.copyOf(r4, r4.length);
        if (Files.isDirectory(r0, (LinkOption[]) Arrays.copyOf(r10, r10.length)) == false) goto L19;
        r8.invoke(r7.readEntries(r6));
    L19:
        return Unit.INSTANCE;
    L13:
        throw new FileSystemLoopException(r0.toString());
    L15:
        if (Files.exists(r0, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1)) == false) goto L19;
        InlineMarker.mark(0);
        r5.yield(r0, r9);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    private final Iterator<Path> dfsIterator() {
        return SequencesKt.iterator(new C04081(this, null));
    }

    private final Iterator<Path> bfsIterator() {
        return SequencesKt.iterator(new AnonymousClass1(this, null));
    }
}
