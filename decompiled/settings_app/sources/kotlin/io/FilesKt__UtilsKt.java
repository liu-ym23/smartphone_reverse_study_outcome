package kotlin.io;

import android.icu.text.PluralRules;
import com.android.settings.applications.PreferredSettingsUtils;
import com.bytedance.apm.constant.TraceStatsConsts;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001a*\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0007\u001a*\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0007\u001a8\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\u001a\b\u0002\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013\u001a&\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u001a\n\u0010\u0019\u001a\u00020\u000f*\u00020\u0002\u001a\u0012\u0010\u001a\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u0012\u0010\u001a\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0001\u001a\n\u0010\u001c\u001a\u00020\u0002*\u00020\u0002\u001a\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d*\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0002¢\u0006\u0002\b\u001e\u001a\u0011\u0010\u001c\u001a\u00020\u001f*\u00020\u001fH\u0002¢\u0006\u0002\b\u001e\u001a\u0012\u0010 \u001a\u00020\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0014\u0010\"\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0012\u0010#\u001a\u00020\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0001\u001a\u0012\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0002\u001a\u0012\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0001\u001a\u0012\u0010'\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u0012\u0010'\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0001\u001a\u0012\u0010(\u001a\u00020\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u001b\u0010)\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002H\u0002¢\u0006\u0002\b*\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004¨\u0006+"}, d2 = {"extension", "", "Ljava/io/File;", "getExtension", "(Ljava/io/File;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath", "nameWithoutExtension", "getNameWithoutExtension", "createTempDir", "prefix", PreferredSettingsUtils.OTHERS_SUFFIX_KEY, "directory", "createTempFile", "copyRecursively", "", "target", "overwrite", "onError", "Lkotlin/Function2;", "Ljava/io/IOException;", "Lkotlin/io/OnErrorAction;", "copyTo", "bufferSize", "", "deleteRecursively", "endsWith", PluralRules.KEYWORD_OTHER, "normalize", "", "normalize$FilesKt__UtilsKt", "Lkotlin/io/FilePathComponents;", "relativeTo", TraceStatsConsts.STATS_BASE_MODULE, "relativeToOrNull", "relativeToOrSelf", "resolve", "relative", "resolveSibling", "startsWith", "toRelativeString", "toRelativeStringOrNull", "toRelativeStringOrNull$FilesKt__UtilsKt", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/FilesKt")
class FilesKt__UtilsKt extends FilesKt__FileTreeWalkKt {
    public FilesKt__UtilsKt() {
    }

    public static /* synthetic */ File createTempDir$default(String r1, String r2, File r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = "tmp";
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = null;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = null;
    L12:
        return FilesKt.createTempDir(r1, r2, r3);
    }

    @Deprecated(message = "Avoid creating temporary directories in the default temp location with this function due to too wide permissions on the newly created directory. Use kotlin.io.path.createTempDirectory instead.")
    public static final File createTempDir(String r1, String r2, File r3) {
        Intrinsics.checkNotNullParameter(r1, "prefix");
        File r4 = File.createTempFile(r1, r2, r3);
        r4.delete();
        if (r4.mkdir() == false) goto L7;
        Intrinsics.checkNotNull(r4);
        return r4;
    L7:
        throw new IOException("Unable to create temporary directory " + r4 + '.');
    }

    public static /* synthetic */ File createTempFile$default(String r1, String r2, File r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = "tmp";
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = null;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = null;
    L12:
        return FilesKt.createTempFile(r1, r2, r3);
    }

    @Deprecated(message = "Avoid creating temporary files in the default temp location with this function due to too wide permissions on the newly created file. Use kotlin.io.path.createTempFile instead or resort to java.io.File.createTempFile.")
    public static final File createTempFile(String r1, String r2, File r3) {
        Intrinsics.checkNotNullParameter(r1, "prefix");
        File r4 = File.createTempFile(r1, r2, r3);
        Intrinsics.checkNotNullExpressionValue(r4, "createTempFile(...)");
        return r4;
    }

    public static final String getExtension(File r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String r3 = r2.getName();
        Intrinsics.checkNotNullExpressionValue(r3, "getName(...)");
        return StringsKt.substringAfterLast(r3, '.', "");
    }

    public static final String getInvariantSeparatorsPath(File r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        if (File.separatorChar == '/') goto L5;
        String r3 = r9.getPath();
        Intrinsics.checkNotNullExpressionValue(r3, "getPath(...)");
        return StringsKt.replace$default(r3, File.separatorChar, IOUtils.DIR_SEPARATOR_UNIX, false, 4, null);
    L5:
        String r10 = r9.getPath();
        Intrinsics.checkNotNullExpressionValue(r10, "getPath(...)");
        return r10;
    }

    public static final String getNameWithoutExtension(File r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        String r4 = r3.getName();
        Intrinsics.checkNotNullExpressionValue(r4, "getName(...)");
        return StringsKt.substringBeforeLast$default(r4, ".", null, 2, null);
    }

    public static final String toRelativeString(File r3, File r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, TraceStatsConsts.STATS_BASE_MODULE);
        String r0 = toRelativeStringOrNull$FilesKt__UtilsKt(r3, r4);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("this and base files have different roots: " + r3 + " and " + r4 + '.');
    }

    public static final File relativeTo(File r1, File r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, TraceStatsConsts.STATS_BASE_MODULE);
        return new File(FilesKt.toRelativeString(r1, r2));
    }

    public static final File relativeToOrSelf(File r1, File r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, TraceStatsConsts.STATS_BASE_MODULE);
        String r3 = toRelativeStringOrNull$FilesKt__UtilsKt(r1, r2);
        if (r3 != null) goto L5;
        return r1;
    L5:
        return new File(r3);
    }

    public static final File relativeToOrNull(File r1, File r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, TraceStatsConsts.STATS_BASE_MODULE);
        String r3 = toRelativeStringOrNull$FilesKt__UtilsKt(r1, r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return new File(r3);
    }

    private static final String toRelativeStringOrNull$FilesKt__UtilsKt(File r14, File r15) {
        FilePathComponents r16 = normalize$FilesKt__UtilsKt(FilesKt.toComponents(r14));
        FilePathComponents r17 = normalize$FilesKt__UtilsKt(FilesKt.toComponents(r15));
        if (Intrinsics.areEqual(r16.getRoot(), r17.getRoot()) == true) goto L5;
        return null;
    L5:
        int r0 = r17.getSize();
        int r2 = r16.getSize();
        int r3 = Math.min(r2, r0);
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L10;
        if (Intrinsics.areEqual(r16.getSegments().get(r4), r17.getSegments().get(r4)) == false) goto L10;
        r4 = r4 + 1;
    L10:
        StringBuilder r5 = new StringBuilder();
        int r6 = r0 - 1;
        if (r4 <= r6) goto L13;
    L20:
        if (r4 >= r2) goto L25;
        if (r4 >= r0) goto L23;
        r5.append(File.separatorChar);
    L23:
        String r18 = File.separator;
        Intrinsics.checkNotNullExpressionValue(r18, "separator");
        CollectionsKt.joinTo$default(CollectionsKt.drop(r16.getSegments(), r4), r5, r18, null, null, 0, null, null, 124, null);
    L25:
        return r5.toString();
    L13:
        if (Intrinsics.areEqual(r17.getSegments().get(r6).getName(), "..") == true) goto L14;
        r5.append("..");
        if (r6 == r4) goto L18;
        r5.append(File.separatorChar);
    L18:
        if (r6 == r4) goto L20;
        r6 = r6 - 1;
        goto L13
    L14:
        return null;
    }

    public static /* synthetic */ File copyTo$default(File r0, File r1, boolean r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = 8192;
    L9:
        return FilesKt.copyTo(r0, r1, r2, r3);
    }

    public static final File copyTo(File r6, File r7, boolean r8, int r9) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "target");
        if (r6.exists() == false) goto L42;
        if (r7.exists() == false) goto L15;
        if (r8 == false) goto L13;
        if (r7.delete() == true) goto L15;
        throw new FileAlreadyExistsException(r6, r7, "Tried to overwrite the destination, but failed to delete it.");
    L13:
        throw new FileAlreadyExistsException(r6, r7, "The destination file already exists.");
    L15:
        if (r6.isDirectory() == true) goto L17;
        File r10 = r7.getParentFile();
        if (r10 == null) goto L24;
        r10.mkdirs();
    L24:
        FileInputStream r11 = new FileInputStream(r6);
        FileInputStream r12 = r11;     // Catch: Throwable -> L36
        FileOutputStream r0 = new FileOutputStream(r7);     // Catch: Throwable -> L36
        ByteStreamsKt.copyTo(r12, r0, r9);     // Catch: Throwable -> L31
    L28:
        CloseableKt.closeFinally(r0, null);     // Catch: Throwable -> L36
        CloseableKt.closeFinally(r11, null);
    L30:
        return r7;
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    L17:
        if (r7.mkdirs() == true) goto L30;
        throw new FileSystemException(r6, r7, "Failed to create target directory.");
    L42:
        throw new NoSuchFileException(r6, null, "The source file doesn't exist.", 2, null);
    }

    public static /* synthetic */ boolean copyRecursively$default(File r0, File r1, boolean r2, AnonymousClass1 r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = AnonymousClass1.INSTANCE;
    L9:
        return FilesKt.copyRecursively(r0, r1, r2, r3);
    }

    public static final boolean copyRecursively(File r11, File r12, boolean r13, final Function2<? super File, ? super IOException, ? extends OnErrorAction> r14) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r12, "target");
        Intrinsics.checkNotNullParameter(r14, "onError");
        if (r11.exists() == false) goto L5;
        Iterator<File> r0 = FilesKt.walkTopDown(r11).onFail(new AnonymousClass2(r14)).iterator();     // Catch: TerminateException -> L47
    L10:
        if (r0.hasNext() == false) goto L46;
        File r3 = r0.next();     // Catch: TerminateException -> L47
        if (r3.exists() == false) goto L15;
        File r5 = new File(r12, FilesKt.toRelativeString(r3, r11));     // Catch: TerminateException -> L47
        if (r5.exists() == false) goto L39;
        if (r3.isDirectory() == true) goto L22;
    L23:
        if (r13 == true) goto L26;
    L24:
        boolean r4 = true;
    L34:
        if (r4 == false) goto L39;
        if (r14.invoke(r5, new FileAlreadyExistsException(r3, r5, "The destination file already exists.")) != OnErrorAction.TERMINATE) goto L10;
        return false;
    L26:
        if (r5.isDirectory() == false) goto L31;
        if (FilesKt.deleteRecursively(r5) == false) goto L24;
    L33:
        r4 = false;
        goto L34
    L31:
        if (r5.delete() == true) goto L33;
    L22:
        if (r5.isDirectory() == false) goto L23;
    L39:
        if (r3.isDirectory() == true) goto L40;
        if (FilesKt.copyTo$default(r3, r5, r13, 0, 4, null).length() == r3.length()) goto L10;
        if (r14.invoke(r3, new IOException("Source file wasn't copied completely, length of destination file differs.")) != OnErrorAction.TERMINATE) goto L10;
        return false;
    L40:
        r5.mkdirs();     // Catch: TerminateException -> L47
        goto L10
    L15:
        if (r14.invoke(r3, new NoSuchFileException(r3, null, "The source file doesn't exist.", 2, null)) != OnErrorAction.TERMINATE) goto L10;
        return false;
    L46:
        return true;
    L47:
        return false;
    L5:
        if (r14.invoke(r11, new NoSuchFileException(r11, null, "The source file doesn't exist.", 2, null)) == OnErrorAction.TERMINATE) goto L8;
        return true;
    L8:
        return false;
    }

    public static final boolean deleteRecursively(File r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Iterator<File> r5 = FilesKt.walkBottomUp(r4).iterator();
    L3:
        boolean r1 = true;
    L5:
        if (r5.hasNext() == false) goto L13;
        File r2 = r5.next();
        if (r2.delete() == true) goto L10;
        if (r2.exists() == false) goto L10;
    L12:
        r1 = false;
    L10:
        if (r1 == false) goto L12;
    L13:
        return r1;
    }

    public static final boolean startsWith(File r3, File r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, PluralRules.KEYWORD_OTHER);
        FilePathComponents r5 = FilesKt.toComponents(r3);
        FilePathComponents r6 = FilesKt.toComponents(r4);
        if (Intrinsics.areEqual(r5.getRoot(), r6.getRoot()) == true) goto L6;
        return false;
    L6:
        if (r5.getSize() >= r6.getSize()) goto L9;
        return false;
    L9:
        return r5.getSegments().subList(0, r6.getSize()).equals(r6.getSegments());
    }

    public static final boolean startsWith(File r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, PluralRules.KEYWORD_OTHER);
        return FilesKt.startsWith(r1, new File(r2));
    }

    public static final boolean endsWith(File r3, File r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, PluralRules.KEYWORD_OTHER);
        FilePathComponents r0 = FilesKt.toComponents(r3);
        FilePathComponents r1 = FilesKt.toComponents(r4);
        if (r1.isRooted() == true) goto L5;
        int r5 = r0.getSize() - r1.getSize();
        if (r5 >= 0) goto L10;
        return false;
    L10:
        return r0.getSegments().subList(r5, r0.getSize()).equals(r1.getSegments());
    L5:
        return Intrinsics.areEqual(r3, r4);
    }

    public static final boolean endsWith(File r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, PluralRules.KEYWORD_OTHER);
        return FilesKt.endsWith(r1, new File(r2));
    }

    public static final File normalize(File r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        FilePathComponents r11 = FilesKt.toComponents(r10);
        File r0 = r11.getRoot();
        List<File> r1 = normalize$FilesKt__UtilsKt(r11.getSegments());
        String r12 = File.separator;
        Intrinsics.checkNotNullExpressionValue(r12, "separator");
        return FilesKt.resolve(r0, CollectionsKt.joinToString$default(r1, r12, null, null, 0, null, null, 62, null));
    }

    private static final FilePathComponents normalize$FilesKt__UtilsKt(FilePathComponents r2) {
        return new FilePathComponents(r2.getRoot(), normalize$FilesKt__UtilsKt(r2.getSegments()));
    }

    private static final List<File> normalize$FilesKt__UtilsKt(List<? extends File> r4) {
        ArrayList r0 = new ArrayList(r4.size());
        Iterator<? extends File> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L16;
        File r1 = r5.next();
        String r2 = r1.getName();
        if (Intrinsics.areEqual(r2, ".") == true) goto L4;
        if (Intrinsics.areEqual(r2, "..") == true) goto L10;
        r0.add(r1);
        goto L4
    L10:
        if (r0.isEmpty() == true) goto L14;
        if (Intrinsics.areEqual(((File) CollectionsKt.last(r0)).getName(), "..") == true) goto L14;
        r0.remove(r0.size() - 1);
    L14:
        r0.add(r1);
        goto L4
    L16:
        return r0;
    }

    public static final File resolve(File r5, File r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "relative");
        if (FilesKt.isRooted(r6) == false) goto L5;
        return r6;
    L5:
        String r7 = r5.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        String r0 = r7;
        if (r0.length() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L15;
        if (StringsKt.endsWith$default(r0, File.separatorChar, false, 2, null) == true) goto L15;
        return new File(r7 + File.separatorChar + r6);
    L15:
        return new File(r7 + r6);
    L8:
        r1 = false;
        goto L9
    }

    public static final File resolve(File r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "relative");
        return FilesKt.resolve(r1, new File(r2));
    }

    public static final File resolveSibling(File r2, File r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "relative");
        FilePathComponents r4 = FilesKt.toComponents(r2);
        if (r4.getSize() != 0) goto L5;
        File r0 = new File("..");
    L7:
        return FilesKt.resolve(FilesKt.resolve(r4.getRoot(), r0), r3);
    L5:
        r0 = r4.subPath(0, r4.getSize() - 1);
        goto L7
    }

    public static final File resolveSibling(File r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "relative");
        return FilesKt.resolveSibling(r1, new File(r2));
    }
}
