package okio.internal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import okio.BufferedSink;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.Source;

/* JADX INFO: compiled from: -FileSystem.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aI\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a\u001c\u0010\r\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0000\u001a\u001c\u0010\u0010\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\nH\u0000\u001a\u001c\u0010\u0013\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\nH\u0000\u001a\u0014\u0010\u0016\u001a\u00020\n*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u001a\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u0014\u0010\u0019\u001a\u00020\u001a*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u001a\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u0003*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"collectRecursively", "", "Lkotlin/sequences/SequenceScope;", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "stack", "Lkotlin/collections/ArrayDeque;", "path", "followSymlinks", "", "postorder", "(Lkotlin/sequences/SequenceScope;Lokio/FileSystem;Lkotlin/collections/ArrayDeque;Lokio/Path;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "commonCopy", "source", "target", "commonCreateDirectories", "dir", "mustCreate", "commonDeleteRecursively", "fileOrDirectory", "mustExist", "commonExists", "commonListRecursively", "Lkotlin/sequences/Sequence;", "commonMetadata", "Lokio/FileMetadata;", "symlinkTarget", "okio"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class _FileSystemKt {

    /* JADX INFO: renamed from: okio.internal._FileSystemKt$collectRecursively$1, reason: invalid class name */
    /* JADX INFO: compiled from: -FileSystem.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "okio.internal._FileSystemKt", f = "-FileSystem.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {113, 132, 142}, m = "collectRecursively", n = {"$this$collectRecursively", "fileSystem", "stack", "path", "followSymlinks", "postorder", "$this$collectRecursively", "fileSystem", "stack", "path", "followSymlinks", "postorder"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "Z$1", "L$0", "L$1", "L$2", "L$3", "Z$0", "Z$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            this.result = r8;
            this.label |= Integer.MIN_VALUE;
            return _FileSystemKt.collectRecursively(null, null, null, null, false, false, this);
        }
    }

    /* JADX INFO: renamed from: okio.internal._FileSystemKt$commonListRecursively$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: -FileSystem.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lokio/Path;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "okio.internal._FileSystemKt$commonListRecursively$1", f = "-FileSystem.kt", i = {0, 0}, l = {93}, m = "invokeSuspend", n = {"$this$sequence", "stack"}, s = {"L$0", "L$1"})
    static final class C04401 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Path $dir;
        final /* synthetic */ boolean $followSymlinks;
        final /* synthetic */ FileSystem $this_commonListRecursively;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        C04401(Path r1, FileSystem r2, boolean r3, Continuation<? super C04401> r4) {
            this.$dir = r1;
            this.$this_commonListRecursively = r2;
            this.$followSymlinks = r3;
            super(2, r4);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            C04401 r0 = new C04401(this.$dir, this.$this_commonListRecursively, this.$followSymlinks, r5);
            r0.L$0 = r4;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super Path> r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(SequenceScope<? super Path> r1, Continuation<? super Unit> r2) {
            return ((C04401) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            Iterator<Path> r2 = (Iterator) this.L$2;
            ArrayDeque r3 = (ArrayDeque) this.L$1;
            SequenceScope r4 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r12);
            ArrayDeque r13 = r3;
            SequenceScope r10 = r4;
        L10:
            if (r2.hasNext() == false) goto L15;
            Path r6 = r2.next();
            this.L$0 = r10;
            this.L$1 = r13;
            this.L$2 = r2;
            this.label = 1;
            SequenceScope r5 = r10;
            ArrayDeque r7 = r13;
            if (_FileSystemKt.collectRecursively(r5, this.$this_commonListRecursively, r7, r6, this.$followSymlinks, false, this) != r0) goto L10;
            return r0;
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            SequenceScope r14 = (SequenceScope) this.L$0;
            ArrayDeque r8 = new ArrayDeque();
            r8.addLast(this.$dir);
            r10 = r14;
            r13 = r8;
            r2 = this.$this_commonListRecursively.list(this.$dir).iterator();
            goto L10
        }
    }

    public static final FileMetadata commonMetadata(FileSystem r2, Path r3) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "path");
        FileMetadata r4 = r2.metadataOrNull(r3);
        if (r4 == null) goto L6;
        return r4;
    L6:
        throw new FileNotFoundException("no such file: " + r3);
    }

    public static final boolean commonExists(FileSystem r1, Path r2) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "path");
        if (r1.metadataOrNull(r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void commonCreateDirectories(FileSystem r3, Path r4, boolean r5) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "dir");
        ArrayDeque r0 = new ArrayDeque();
        Path r1 = r4;
    L3:
        if (r1 == null) goto L7;
        if (r3.exists(r1) == true) goto L7;
        r0.addFirst(r1);
        r1 = r1.parent();
    L7:
        if (r5 == true) goto L9;
    L13:
        Iterator r6 = r0.iterator();
    L15:
        if (r6.hasNext() == false) goto L17;
        r3.createDirectory((Path) r6.next());
        goto L15
    L17:
        return;
    L9:
        if (r0.isEmpty() == false) goto L13;
        throw new IOException(r4 + " already exist.");
    }

    public static final void commonDeleteRecursively(FileSystem r2, Path r3, boolean r4) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "fileOrDirectory");
        Iterator r5 = SequencesKt.sequence(new _FileSystemKt$commonDeleteRecursively$sequence$1(r2, r3, null)).iterator();
    L4:
        if (r5.hasNext() == false) goto L12;
        Path r0 = (Path) r5.next();
        if (r4 == true) goto L8;
    L10:
        boolean r1 = false;
    L11:
        r2.delete(r0, r1);
        goto L4
    L8:
        if (r5.hasNext() == true) goto L10;
        r1 = true;
        goto L11
    }

    public static final Sequence<Path> commonListRecursively(FileSystem r2, Path r3, boolean r4) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "dir");
        return SequencesKt.sequence(new C04401(r3, r2, r4, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v4, types: [kotlin.sequences.SequenceScope] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r17v0, types: [java.lang.Object, kotlin.sequences.SequenceScope, kotlin.sequences.SequenceScope<? super okio.Path>] */
    /* JADX WARN: Type inference failed for: r17v1, types: [kotlin.sequences.SequenceScope] */
    public static final Object collectRecursively(SequenceScope<? super Path> r17, FileSystem r18, ArrayDeque<Path> r19, Path r20, boolean r21, boolean r22, Continuation<? super Unit> r23) {
        Path r1 = r20;
        boolean r2 = r22;
        if ((r23 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r4 = (AnonymousClass1) r23;
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r4.label;
        if (r6 == 0) goto L22;
        if (r6 == 1) goto L21;
        if (r6 == 2) goto L16;
        if (r6 != 3) goto L15;
        ResultKt.throwOnFailure(r3);
    L68:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        boolean r0 = r4.Z$1;
        boolean r7 = r4.Z$0;
        Iterator<Path> r8 = (Iterator) r4.L$4;
        Path r9 = (Path) r4.L$3;
        ArrayDeque<Path> r11 = (ArrayDeque) r4.L$2;
        FileSystem r12 = (FileSystem) r4.L$1;
        SequenceScope r13 = (SequenceScope) r4.L$0;
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L19
        ?? r14 = r13;
    L48:
        if (r8.hasNext() == false) goto L57;
        Path r10 = r8.next();     // Catch: Throwable -> L19
        if (r0 == false) goto L53;
        boolean r15 = true;
    L54:
        r4.L$0 = r14;     // Catch: Throwable -> L19
        r4.L$1 = r12;     // Catch: Throwable -> L19
        r4.L$2 = r11;     // Catch: Throwable -> L19
        r4.L$3 = r9;     // Catch: Throwable -> L19
        r4.L$4 = r8;     // Catch: Throwable -> L19
        r4.Z$0 = r7;     // Catch: Throwable -> L19
        r4.Z$1 = r0;     // Catch: Throwable -> L19
        r4.label = 2;     // Catch: Throwable -> L19
        if (collectRecursively(r14, r12, r11, r10, r7, r15, r4) != r5) goto L48;
        return r5;
    L53:
        r15 = false;
        goto L54
    L57:
        r11.removeLast();
        r2 = r0;
        r1 = r9;
        ?? r16 = r14;
    L63:
        if (r2 == false) goto L70;
        r4.L$0 = null;
        r4.L$1 = null;
        r4.L$2 = null;
        r4.L$3 = null;
        r4.L$4 = null;
        r4.label = 3;
        if (r16.yield(r1, r4) != r5) goto L68;
        return r5;
    L70:
        return Unit.INSTANCE;
    L19:
        th = th;
    L60:
        r11.removeLast();
        throw th;
    L21:
        boolean r24 = r4.Z$1;
        boolean r25 = r4.Z$0;
        Path r26 = (Path) r4.L$3;
        ArrayDeque<Path> r27 = (ArrayDeque) r4.L$2;
        FileSystem r110 = (FileSystem) r4.L$1;
        SequenceScope r111 = (SequenceScope) r4.L$0;
        ResultKt.throwOnFailure(r3);
        r2 = r24;
        boolean r28 = r25;
        r1 = r26;
        r16 = r111;
    L29:
        List<Path> r29 = r110.listOrNull(r1);
        if (r29 != null) goto L33;
        r29 = CollectionsKt.emptyList();
    L33:
        if ((!r29.isEmpty()) == false) goto L63;
        Path r112 = r1;
        int r113 = 0;
    L35:
        if (r28 == true) goto L37;
    L41:
        Path r114 = symlinkTarget(r110, r112);
        if (r114 == null) goto L43;
        r113 = r113 + 1;
        r112 = r114;
        goto L35
    L43:
        if (r28 == true) goto L45;
        if (r113 != 0) goto L63;
    L45:
        r27.addLast(r112);
        r14 = r16;
        r12 = r110;
        r11 = r27;
        r9 = r1;
        r7 = r28;
        r0 = r2;
        r8 = r29.iterator();     // Catch: Throwable -> L58
    L58:
        th = th;
        r11 = r27;
        goto L60
    L37:
        if (r27.contains(r112) == false) goto L41;
        throw new IOException("symlink cycle at " + r1);
    L22:
        ResultKt.throwOnFailure(r3);
        if (r2 == true) goto L27;
        r4.L$0 = r17;
        FileSystem r30 = r18;
        r4.L$1 = r30;
        r27 = r19;
        r4.L$2 = r27;
        r4.L$3 = r1;
        boolean r115 = r21;
        r4.Z$0 = r115;
        r4.Z$1 = r2;
        r4.label = 1;
        if (r17.yield(r1, r4) != r5) goto L28;
        return r5;
    L28:
        r16 = r17;
        r28 = r115;
        r110 = r30;
        goto L29
    L27:
        r30 = r18;
        r27 = r19;
        r115 = r21;
    L7:
        r4 = new AnonymousClass1(r23);
        goto L8
    }

    public static final Path symlinkTarget(FileSystem r1, Path r2) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "path");
        Path r3 = r1.metadata(r2).getSymlinkTarget();
        if (r3 != null) goto L6;
        return null;
    L6:
        Path r4 = r2.parent();
        Intrinsics.checkNotNull(r4);
        return r4.resolve(r3);
    }

    public static final void commonCopy(FileSystem r4, Path r5, Path r6) throws IOException {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "source");
        Intrinsics.checkNotNullParameter(r6, "target");
        Source r7 = r4.source(r5);
        Throwable th = null;
        Source r1 = r7;     // Catch: Throwable -> L26
        BufferedSink r8 = Okio.buffer(r4.sink(r6));     // Catch: Throwable -> L26
        Long r9 = Long.valueOf(r8.writeAll(r1));     // Catch: Throwable -> L11
        if (r8 != null) goto L39;
    L10:
        Throwable th2 = null;
    L18:
        if (th2 != null) goto L25;
        Intrinsics.checkNotNull(r9);     // Catch: Throwable -> L26
        Long r10 = Long.valueOf(r9.longValue());     // Catch: Throwable -> L26
        if (r7 != null) goto L43;
    L33:
        if (th != null) goto L36;
        Intrinsics.checkNotNull(r10);
        return;
    L36:
        throw th;
    L43:
        r7.close();     // Catch: Throwable -> L23
    L23:
        th = th;
        goto L33
    L25:
        throw th2;     // Catch: Throwable -> L26
    L39:
        r8.close();     // Catch: Throwable -> L8
    L8:
        th2 = th;
        goto L18
    L11:
        th = move-exception;
        if (r8 != null) goto L46;
    L17:
        th2 = th;
        r9 = null;
        goto L18
    L46:
        r8.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        ExceptionsKt.addSuppressed(th, th);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        if (r7 != null) goto L37;
    L32:
        th = th;
        r10 = null;
        goto L33
    L37:
        r7.close();     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        ExceptionsKt.addSuppressed(th, th);
        goto L32
    }
}
