package kotlin.io.path;

import com.bytedance.apm.battery.dao.DBHelper;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystemException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PathRecursiveFunctions.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0082\b¢\u0006\u0002\b\u0006\u001a\u001d\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\b\n\u001a\u001d\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\b\r\u001a&\u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\u0004\b\u0000\u0010\u000f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0005H\u0082\b¢\u0006\u0004\b\u0010\u0010\u0011\u001aw\u0010\u0012\u001a\u00020\t*\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2Q\b\u0002\u0010\u0014\u001aK\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0013\u0012\u0017\u0012\u00150\u0019j\u0002`\u001a¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0007\u001a´\u0001\u0010\u0012\u001a\u00020\t*\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2Q\b\u0002\u0010\u0014\u001aK\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0013\u0012\u0017\u0012\u00150\u0019j\u0002`\u001a¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u00152\u0006\u0010\u001d\u001a\u00020\u001e2C\b\u0002\u0010 \u001a=\u0012\u0004\u0012\u00020!\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\"0\u0015¢\u0006\u0002\b#H\u0007\u001a\f\u0010$\u001a\u00020\u0001*\u00020\tH\u0007\u001a\u001b\u0010%\u001a\f\u0012\b\u0012\u00060\u0019j\u0002`\u001a0&*\u00020\tH\u0002¢\u0006\u0002\b'\u001a'\u0010(\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\t0)2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\b*\u001a'\u0010+\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\t0)2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\b,\u001a5\u0010-\u001a\u00020\u001e*\b\u0012\u0004\u0012\u00020\t0)2\u0006\u0010.\u001a\u00020\t2\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020100\"\u000201H\u0002¢\u0006\u0004\b2\u00103\u001a\u0011\u00104\u001a\u000205*\u00020\"H\u0003¢\u0006\u0002\b6\u001a\u0011\u00104\u001a\u000205*\u00020\u001cH\u0003¢\u0006\u0002\b6¨\u00067"}, d2 = {"collectIfThrows", "", "collector", "Lkotlin/io/path/ExceptionsCollector;", "function", "Lkotlin/Function0;", "collectIfThrows$PathsKt__PathRecursiveFunctionsKt", "insecureEnterDirectory", "path", "Ljava/nio/file/Path;", "insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt", "insecureHandleEntry", "entry", "insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt", "tryIgnoreNoSuchFileException", "R", "tryIgnoreNoSuchFileException$PathsKt__PathRecursiveFunctionsKt", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "copyToRecursively", "target", "onError", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", DBHelper.BATTERY_COL_SOURCE, "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "Lkotlin/io/path/OnErrorResult;", "followLinks", "", "overwrite", "copyAction", "Lkotlin/io/path/CopyActionContext;", "Lkotlin/io/path/CopyActionResult;", "Lkotlin/ExtensionFunctionType;", "deleteRecursively", "deleteRecursivelyImpl", "", "deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt", "enterDirectory", "Ljava/nio/file/SecureDirectoryStream;", "enterDirectory$PathsKt__PathRecursiveFunctionsKt", "handleEntry", "handleEntry$PathsKt__PathRecursiveFunctionsKt", "isDirectory", "entryName", "options", "", "Ljava/nio/file/LinkOption;", "isDirectory$PathsKt__PathRecursiveFunctionsKt", "(Ljava/nio/file/SecureDirectoryStream;Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z", "toFileVisitResult", "Ljava/nio/file/FileVisitResult;", "toFileVisitResult$PathsKt__PathRecursiveFunctionsKt", "kotlin-stdlib-jdk7"}, k = 5, mv = {1, 8, 0}, xi = 49, xs = "kotlin/io/path/PathsKt")
class PathsKt__PathRecursiveFunctionsKt extends PathsKt__PathReadWriteKt {

    /* JADX INFO: compiled from: PathRecursiveFunctions.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r0 = new int[CopyActionResult.values().length];
            r0[CopyActionResult.CONTINUE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[CopyActionResult.TERMINATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[CopyActionResult.SKIP_SUBTREE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L7:
            $EnumSwitchMapping$0 = r0;
            int[] r1 = new int[OnErrorResult.values().length];
            r1[OnErrorResult.TERMINATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L19:
            r1[OnErrorResult.SKIP_SUBTREE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L10:
            $EnumSwitchMapping$1 = r1;
        }
    }

    public PathsKt__PathRecursiveFunctionsKt() {
    }

    public static final /* synthetic */ FileVisitResult access$copyToRecursively$copy(Function3 r0, Path r1, Path r2, Function3 r3, Path r4, BasicFileAttributes r5) {
        return copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(r0, r1, r2, r3, r4, r5);
    }

    public static final /* synthetic */ FileVisitResult access$copyToRecursively$error(Function3 r0, Path r1, Path r2, Path r3, Exception r4) {
        return copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Path copyToRecursively$default(Path r0, Path r1, AnonymousClass1 r2, boolean r3, boolean r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = AnonymousClass1.INSTANCE;
    L6:
        return PathsKt.copyToRecursively(r0, r1, r2, r3, r4);
    }

    public static final Path copyToRecursively(Path r7, Path r8, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> r9, final boolean r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "target");
        Intrinsics.checkNotNullParameter(r9, "onError");
        if (r11 == false) goto L6;
        return PathsKt.copyToRecursively(r7, r8, r9, r10, new AnonymousClass2(r10));
    L6:
        return PathsKt.copyToRecursively$default(r7, r8, r9, r10, null, 8, null);
    }

    public static /* synthetic */ Path copyToRecursively$default(Path r0, Path r1, AnonymousClass3 r2, final boolean r3, Function3 r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = AnonymousClass3.INSTANCE;
    L6:
        if ((r5 & 8) == 0) goto L9;
        r4 = new AnonymousClass4(r3);
    L9:
        return PathsKt.copyToRecursively(r0, r1, r2, r3, r4);
    }

    public static final Path copyToRecursively(final Path r6, final Path r7, final Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> r8, boolean r9, final Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult> r10) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "target");
        Intrinsics.checkNotNullParameter(r8, "onError");
        Intrinsics.checkNotNullParameter(r10, "copyAction");
        LinkOption[] r0 = LinkFollowing.INSTANCE.toLinkOptions(r9);
        LinkOption[] r1 = (LinkOption[]) Arrays.copyOf(r0, r0.length);
        if (Files.exists(r6, (LinkOption[]) Arrays.copyOf(r1, r1.length)) == false) goto L35;
        boolean r2 = false;
        if (Files.exists(r6, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) == false) goto L32;
        if (r9 == true) goto L10;
        if (Files.isSymbolicLink(r6) == true) goto L32;
    L10:
        if (Files.exists(r7, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) == true) goto L12;
    L14:
        boolean r3 = false;
    L15:
        if (r3 == true) goto L17;
    L18:
        Path r4 = r6.toRealPath(new LinkOption[0]);
        if (r3 == false) goto L21;
        r2 = r7.toRealPath(new LinkOption[0]).startsWith(r4);
    L28:
        if (r2 == false) goto L32;
        throw new FileSystemException(r6.toString(), r7.toString(), "Recursively copying a directory into its subdirectory is prohibited.");
    L21:
        Path r5 = r7.getParent();
        if (r5 == null) goto L28;
        if (Files.exists(r5, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) == false) goto L28;
        if (r5.toRealPath(new LinkOption[0]).startsWith(r4) == false) goto L28;
        r2 = true;
        goto L28
    L17:
        if (Files.isSameFile(r6, r7) == true) goto L32;
    L12:
        if (Files.isSymbolicLink(r7) == true) goto L14;
        r3 = true;
    L32:
        PathsKt.visitFileTree$default(r6, 0, r9, new AnonymousClass5(r10, r6, r7, r8), 1, null);
        return r7;
    L35:
        throw new NoSuchFileException(r6.toString(), r7.toString(), "The source file doesn't exist.");
    }

    private static final Path copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt(Path r0, Path r1, Path r2) {
        Path r3 = r1.resolve(PathsKt.relativeTo(r2, r0));
        Intrinsics.checkNotNullExpressionValue(r3, "target.resolve(relativePath)");
        return r3;
    }

    private static final FileVisitResult copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> r0, Path r1, Path r2, Path r3, Exception r4) {
        return toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(r0.invoke(r3, copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt(r1, r2, r3), r4));
    }

    private static final FileVisitResult copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult> r1, Path r2, Path r3, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> r4, Path r5, BasicFileAttributes r6) {
        return toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(r1.invoke(DefaultCopyActionContext.INSTANCE, r5, copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt(r2, r3, r5)));
    L4:
        e = move-exception;
        return copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(r4, r2, r3, r5, e);
    }

    private static final FileVisitResult toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(CopyActionResult r1) {
        int r2 = WhenMappings.$EnumSwitchMapping$0[r1.ordinal()];
        if (r2 == 1) goto L13;
        if (r2 == 2) goto L15;
        if (r2 != 3) goto L10;
        return FileVisitResult.SKIP_SUBTREE;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return FileVisitResult.TERMINATE;
    L13:
        return FileVisitResult.CONTINUE;
    }

    private static final FileVisitResult toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(OnErrorResult r1) {
        int r2 = WhenMappings.$EnumSwitchMapping$1[r1.ordinal()];
        if (r2 == 1) goto L10;
        if (r2 != 2) goto L8;
        return FileVisitResult.SKIP_SUBTREE;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return FileVisitResult.TERMINATE;
    }

    public static final void deleteRecursively(Path r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        List<Exception> r4 = deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt(r3);
        if ((!r4.isEmpty()) == false) goto L10;
        FileSystemException r0 = new FileSystemException("Failed to delete one or more files. See suppressed exceptions for details.");
        Iterator<T> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L9;
        ExceptionsKt.addSuppressed(r0, (Exception) r5.next());
        goto L6
    L9:
        throw r0;
    }

    private static final List<Exception> deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt(Path r8) {
        boolean r1 = false;
        boolean r2 = true;
        ExceptionsCollector r0 = new ExceptionsCollector(0, 1, null);
        Path r4 = r8.getParent();
        if (r4 != null) goto L24;
    L20:
        if (r2 == false) goto L23;
        insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(r8, r0);
    L23:
        return r0.getCollectedExceptions();
    L24:
        DirectoryStream<Path> r5 = Files.newDirectoryStream(r4);     // Catch: Throwable -> L6
    L7:
        if (r5 == null) goto L20;
        DirectoryStream<Path> r6 = r5;
        DirectoryStream<Path> r7 = r6;     // Catch: Throwable -> L15
        if ((r7 instanceof SecureDirectoryStream) == false) goto L12;
        r0.setPath(r4);     // Catch: Throwable -> L15
        Path r3 = r8.getFileName();     // Catch: Throwable -> L15
        Intrinsics.checkNotNullExpressionValue(r3, "this.fileName");     // Catch: Throwable -> L15
        handleEntry$PathsKt__PathRecursiveFunctionsKt((SecureDirectoryStream) r7, r3, r0);     // Catch: Throwable -> L15
    L13:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r6, null);
        r2 = r1;
        goto L20
    L12:
        r1 = true;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);
        throw th;
    L6:
        DirectoryStream r10 = (DirectoryStream) null;
        r5 = null;
        goto L7
    }

    private static final void collectIfThrows$PathsKt__PathRecursiveFunctionsKt(ExceptionsCollector r0, Function0<Unit> r1) {
        r1.invoke();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        r0.collect(e);
    }

    private static final <R> R tryIgnoreNoSuchFileException$PathsKt__PathRecursiveFunctionsKt(Function0<? extends R> r0) {
        return r0.invoke();
    L4:
        return null;
    }

    private static final void handleEntry$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream<Path> r3, Path r4, ExceptionsCollector r5) {
        r5.enterEntry(r4);
    L10:
        e = move-exception;
        r5.collect(e);
    L12:
        r5.exitEntry(r4);
        return;
    L16:
        if (isDirectory$PathsKt__PathRecursiveFunctionsKt(r3, r4, new LinkOption[]{LinkOption.NOFOLLOW_LINKS}) == false) goto L8;
        int r0 = r5.getTotalExceptions();     // Catch: Exception -> L10
        enterDirectory$PathsKt__PathRecursiveFunctionsKt(r3, r4, r5);     // Catch: Exception -> L10
        if (r0 != r5.getTotalExceptions()) goto L18;
        r3.deleteDirectory(r4);     // Catch: Exception -> L10 NoSuchFileException -> L14
        Unit r6 = Unit.INSTANCE;     // Catch: Exception -> L10 NoSuchFileException -> L14
    L15:
    L18:
        goto L12
    L8:
        r3.deleteFile(r4);     // Catch: Exception -> L10 NoSuchFileException -> L14
        Unit r7 = Unit.INSTANCE;     // Catch: Exception -> L10 NoSuchFileException -> L14
        goto L15
    }

    private static final void enterDirectory$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream<Path> r4, Path r5, ExceptionsCollector r6) {
        SecureDirectoryStream<Path> r7 = r4.newDirectoryStream(r5, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});     // Catch: Exception -> L5 NoSuchFileException -> L7
    L8:
        if (r7 == null) goto L31;
        SecureDirectoryStream<Path> r8 = r7;     // Catch: Exception -> L5
        SecureDirectoryStream<Path> r9 = r8;     // Catch: Throwable -> L17
        Iterator<Path> r0 = r9.iterator();     // Catch: Throwable -> L17
    L12:
        if (r0.hasNext() == false) goto L14;
        Path r2 = r0.next().getFileName();     // Catch: Throwable -> L17
        Intrinsics.checkNotNullExpressionValue(r2, "entry.fileName");     // Catch: Throwable -> L17
        handleEntry$PathsKt__PathRecursiveFunctionsKt(r9, r2, r6);     // Catch: Throwable -> L17
        goto L12
    L14:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r8, null);     // Catch: Exception -> L5
        return;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);     // Catch: Exception -> L5
        throw th;     // Catch: Exception -> L5
    L31:
        return;
    L5:
        e = move-exception;
        r6.collect(e);
        return;
    L7:
        r7 = null;
        goto L8
    }

    private static final boolean isDirectory$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream<Path> r2, Path r3, LinkOption... r4) {
        Boolean r5 = Boolean.valueOf(((BasicFileAttributeView) r2.getFileAttributeView(r3, BasicFileAttributeView.class, (LinkOption[]) Arrays.copyOf(r4, r4.length))).readAttributes().isDirectory());     // Catch: NoSuchFileException -> L4
    L5:
        if (r5 != null) goto L11;
        return false;
    L11:
        return r5.booleanValue();
    L4:
        r5 = null;
        goto L5
    }

    private static final void insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(Path r4, ExceptionsCollector r5) {
    L10:
        e = move-exception;
        r5.collect(e);
        return;
    L4:
        if (Files.isDirectory(r4, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1)) == false) goto L8;
        int r0 = r5.getTotalExceptions();     // Catch: Exception -> L10
        insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt(r4, r5);     // Catch: Exception -> L10
        if (r0 != r5.getTotalExceptions()) goto L13;
        Files.deleteIfExists(r4);     // Catch: Exception -> L10
    L13:
        return;
    L8:
        Files.deleteIfExists(r4);     // Catch: Exception -> L10
        goto L13
    }

    private static final void insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt(Path r4, ExceptionsCollector r5) {
        DirectoryStream<Path> r6 = Files.newDirectoryStream(r4);     // Catch: Exception -> L5 NoSuchFileException -> L7
    L8:
        if (r6 == null) goto L31;
        DirectoryStream<Path> r7 = r6;     // Catch: Exception -> L5
        Iterator<Path> r1 = r7.iterator();     // Catch: Throwable -> L17
    L12:
        if (r1.hasNext() == false) goto L14;
        Path r2 = r1.next();     // Catch: Throwable -> L17
        Intrinsics.checkNotNullExpressionValue(r2, "entry");     // Catch: Throwable -> L17
        insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(r2, r5);     // Catch: Throwable -> L17
        goto L12
    L14:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r7, null);     // Catch: Exception -> L5
        return;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);     // Catch: Exception -> L5
        throw th;     // Catch: Exception -> L5
    L31:
        return;
    L5:
        e = move-exception;
        r5.collect(e);
        return;
    L7:
        r6 = null;
        goto L8
    }
}
