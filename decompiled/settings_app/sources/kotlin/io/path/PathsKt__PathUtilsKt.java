package kotlin.io.path;

import android.icu.text.PluralRules;
import androidx.exifinterface.media.ExifInterface;
import com.android.settings.ApnEditor;
import com.android.settings.applications.PreferredSettingsUtils;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.librarian.LibrarianImpl;
import java.io.IOException;
import java.net.URI;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileStore;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PathUtils.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Ì\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a*\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00012\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001a\"\u00020\u0001H\u0087\b¢\u0006\u0002\u0010\u001b\u001a?\u0010\u001c\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0007¢\u0006\u0002\u0010!\u001a6\u0010\u001c\u001a\u00020\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010\"\u001aK\u0010#\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0007¢\u0006\u0002\u0010%\u001aB\u0010#\u001a\u00020\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010&\u001a\u001c\u0010'\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u00022\n\u0010)\u001a\u0006\u0012\u0002\b\u00030*H\u0001\u001a4\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020,2\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.¢\u0006\u0002\b1H\u0007\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a\r\u00102\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u00103\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a.\u00104\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u0002070\u001a\"\u000207H\u0087\b¢\u0006\u0002\u00108\u001a\u001f\u00104\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\b\b\u0002\u00109\u001a\u00020:H\u0087\b\u001a.\u0010;\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010<\u001a.\u0010=\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010<\u001a.\u0010>\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010<\u001a\u0015\u0010?\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u0002H\u0087\b\u001a-\u0010@\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0007¢\u0006\u0002\u0010<\u001a6\u0010A\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010B\u001a\r\u0010C\u001a\u000200*\u00020\u0002H\u0087\b\u001a\r\u0010D\u001a\u00020:*\u00020\u0002H\u0087\b\u001a\u0015\u0010E\u001a\u00020\u0002*\u00020\u00022\u0006\u0010F\u001a\u00020\u0002H\u0087\n\u001a\u0015\u0010E\u001a\u00020\u0002*\u00020\u00022\u0006\u0010F\u001a\u00020\u0001H\u0087\n\u001a&\u0010G\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010I\u001a2\u0010J\u001a\u0002HK\"\n\b\u0000\u0010K\u0018\u0001*\u00020L*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010M\u001a4\u0010N\u001a\u0004\u0018\u0001HK\"\n\b\u0000\u0010K\u0018\u0001*\u00020L*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010M\u001a\r\u0010O\u001a\u00020P*\u00020\u0002H\u0087\b\u001a\r\u0010Q\u001a\u00020R*\u00020\u0002H\u0087\b\u001a.\u0010S\u001a\u000200*\u00020\u00022\b\b\u0002\u0010T\u001a\u00020\u00012\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002000.H\u0087\bø\u0001\u0000\u001a0\u0010V\u001a\u0004\u0018\u00010W*\u00020\u00022\u0006\u0010X\u001a\u00020\u00012\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010Y\u001a&\u0010Z\u001a\u00020[*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010\\\u001a(\u0010]\u001a\u0004\u0018\u00010^*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010_\u001a,\u0010`\u001a\b\u0012\u0004\u0012\u00020b0a*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010c\u001a&\u0010d\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010I\u001a\r\u0010e\u001a\u00020:*\u00020\u0002H\u0087\b\u001a\r\u0010f\u001a\u00020:*\u00020\u0002H\u0087\b\u001a\r\u0010g\u001a\u00020:*\u00020\u0002H\u0087\b\u001a&\u0010h\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010I\u001a\u0015\u0010i\u001a\u00020:*\u00020\u00022\u0006\u0010F\u001a\u00020\u0002H\u0087\b\u001a\r\u0010j\u001a\u00020:*\u00020\u0002H\u0087\b\u001a\r\u0010k\u001a\u00020:*\u00020\u0002H\u0087\b\u001a\u001c\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00020m*\u00020\u00022\b\b\u0002\u0010T\u001a\u00020\u0001H\u0007\u001a.\u0010n\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u0002070\u001a\"\u000207H\u0087\b¢\u0006\u0002\u00108\u001a\u001f\u0010n\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\b\b\u0002\u00109\u001a\u00020:H\u0087\b\u001a&\u0010o\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010I\u001a2\u0010p\u001a\u0002Hq\"\n\b\u0000\u0010q\u0018\u0001*\u00020r*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010s\u001a<\u0010p\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010W0t*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00012\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010u\u001a\r\u0010v\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0014\u0010w\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0007\u001a\u0016\u0010x\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0007\u001a\u0014\u0010y\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0007\u001a8\u0010z\u001a\u00020\u0002*\u00020\u00022\u0006\u0010X\u001a\u00020\u00012\b\u0010{\u001a\u0004\u0018\u00010W2\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010|\u001a\u0015\u0010}\u001a\u00020\u0002*\u00020\u00022\u0006\u0010{\u001a\u00020[H\u0087\b\u001a\u0015\u0010~\u001a\u00020\u0002*\u00020\u00022\u0006\u0010{\u001a\u00020^H\u0087\b\u001a\u001b\u0010\u007f\u001a\u00020\u0002*\u00020\u00022\f\u0010{\u001a\b\u0012\u0004\u0012\u00020b0aH\u0087\b\u001a\u000f\u0010\u0080\u0001\u001a\u00020\u0002*\u00030\u0081\u0001H\u0087\b\u001aF\u0010\u0082\u0001\u001a\u0003H\u0083\u0001\"\u0005\b\u0000\u0010\u0083\u0001*\u00020\u00022\b\b\u0002\u0010T\u001a\u00020\u00012\u001b\u0010\u0084\u0001\u001a\u0016\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00020\u0085\u0001\u0012\u0005\u0012\u0003H\u0083\u00010.H\u0087\bø\u0001\u0000¢\u0006\u0003\u0010\u0086\u0001\u001a3\u0010\u0087\u0001\u001a\u000200*\u00020\u00022\r\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020,2\n\b\u0002\u0010\u0089\u0001\u001a\u00030\u008a\u00012\t\b\u0002\u0010\u008b\u0001\u001a\u00020:H\u0007\u001aJ\u0010\u0087\u0001\u001a\u000200*\u00020\u00022\n\b\u0002\u0010\u0089\u0001\u001a\u00030\u008a\u00012\t\b\u0002\u0010\u008b\u0001\u001a\u00020:2\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.¢\u0006\u0002\b1H\u0007\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001\u001a0\u0010\u008c\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u0085\u0001*\u00020\u00022\u0014\u00106\u001a\u000b\u0012\u0007\b\u0001\u0012\u00030\u008d\u00010\u001a\"\u00030\u008d\u0001H\u0007¢\u0006\u0003\u0010\u008e\u0001\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001f\u0010\u0007\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u001e\u0010\r\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u001e\u0010\u0010\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u001f\u0010\u0013\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u008f\u0001"}, d2 = {"extension", "", "Ljava/nio/file/Path;", "getExtension$annotations", "(Ljava/nio/file/Path;)V", "getExtension", "(Ljava/nio/file/Path;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath$annotations", "getInvariantSeparatorsPath", "invariantSeparatorsPathString", "getInvariantSeparatorsPathString$annotations", "getInvariantSeparatorsPathString", "name", "getName$annotations", "getName", "nameWithoutExtension", "getNameWithoutExtension$annotations", "getNameWithoutExtension", "pathString", "getPathString$annotations", "getPathString", "Path", "path", TraceStatsConsts.STATS_BASE_MODULE, "subpaths", "", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;", "createTempDirectory", "directory", "prefix", "attributes", "Ljava/nio/file/attribute/FileAttribute;", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "(Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createTempFile", PreferredSettingsUtils.OTHERS_SUFFIX_KEY, "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "(Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "fileAttributeViewNotAvailable", "", "attributeViewClass", "Ljava/lang/Class;", "fileVisitor", "Ljava/nio/file/FileVisitor;", "builderAction", "Lkotlin/Function1;", "Lkotlin/io/path/FileVisitorBuilder;", "", "Lkotlin/ExtensionFunctionType;", "absolute", "absolutePathString", "copyTo", "target", "options", "Ljava/nio/file/CopyOption;", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;", "overwrite", "", "createDirectories", "(Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createDirectory", "createFile", "createLinkPointingTo", "createParentDirectories", "createSymbolicLinkPointingTo", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "deleteExisting", "deleteIfExists", "div", PluralRules.KEYWORD_OTHER, "exists", "Ljava/nio/file/LinkOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z", "fileAttributesView", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Ljava/nio/file/attribute/FileAttributeView;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileAttributeView;", "fileAttributesViewOrNull", "fileSize", "", "fileStore", "Ljava/nio/file/FileStore;", "forEachDirectoryEntry", "glob", "action", "getAttribute", "", "attribute", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/lang/Object;", "getLastModifiedTime", "Ljava/nio/file/attribute/FileTime;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileTime;", "getOwner", "Ljava/nio/file/attribute/UserPrincipal;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/UserPrincipal;", "getPosixFilePermissions", "", "Ljava/nio/file/attribute/PosixFilePermission;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/util/Set;", "isDirectory", "isExecutable", "isHidden", "isReadable", "isRegularFile", "isSameFileAs", "isSymbolicLink", "isWritable", "listDirectoryEntries", "", "moveTo", "notExists", "readAttributes", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/nio/file/attribute/BasicFileAttributes;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/BasicFileAttributes;", "", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/util/Map;", "readSymbolicLink", "relativeTo", "relativeToOrNull", "relativeToOrSelf", "setAttribute", "value", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/Object;[Ljava/nio/file/LinkOption;)Ljava/nio/file/Path;", "setLastModifiedTime", "setOwner", "setPosixFilePermissions", "toPath", "Ljava/net/URI;", "useDirectoryEntries", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/sequences/Sequence;", "(Ljava/nio/file/Path;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "visitFileTree", "visitor", "maxDepth", "", "followLinks", "walk", "Lkotlin/io/path/PathWalkOption;", "(Ljava/nio/file/Path;[Lkotlin/io/path/PathWalkOption;)Lkotlin/sequences/Sequence;", "kotlin-stdlib-jdk7"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/path/PathsKt")
class PathsKt__PathUtilsKt extends PathsKt__PathRecursiveFunctionsKt {
    public PathsKt__PathUtilsKt() {
    }

    public static /* synthetic */ void getExtension$annotations(Path r0) {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use invariantSeparatorsPathString property instead.", replaceWith = @ReplaceWith(expression = "invariantSeparatorsPathString", imports = {}))
    public static /* synthetic */ void getInvariantSeparatorsPath$annotations(Path r0) {
    }

    public static /* synthetic */ void getInvariantSeparatorsPathString$annotations(Path r0) {
    }

    public static /* synthetic */ void getName$annotations(Path r0) {
    }

    public static /* synthetic */ void getNameWithoutExtension$annotations(Path r0) {
    }

    public static /* synthetic */ void getPathString$annotations(Path r0) {
    }

    public static final String getName(Path r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Path r2 = r1.getFileName();
        if (r2 == null) goto L5;
        String r3 = r2.toString();
    L6:
        if (r3 != null) goto L9;
        return "";
    L9:
        return r3;
    L5:
        r3 = null;
        goto L6
    }

    public static final String getNameWithoutExtension(Path r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Path r4 = r3.getFileName();
        if (r4 == null) goto L8;
        String r5 = r4.toString();
        if (r5 == null) goto L8;
        String r6 = StringsKt.substringBeforeLast$default(r5, ".", null, 2, null);
        if (r6 == null) goto L8;
        return r6;
    L8:
        return "";
    }

    public static final String getExtension(Path r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Path r3 = r2.getFileName();
        if (r3 == null) goto L11;
        String r4 = r3.toString();
        if (r4 == null) goto L12;
        String r5 = StringsKt.substringAfterLast(r4, '.', "");
        if (r5 != null) goto L10;
        return "";
    L10:
        return r5;
    L12:
        return "";
    L11:
        return "";
    }

    private static final String getPathString(Path r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.toString();
    }

    public static final String getInvariantSeparatorsPathString(Path r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        String r2 = r7.getFileSystem().getSeparator();
        if (Intrinsics.areEqual(r2, LibrarianImpl.Constants.SEPARATOR) == true) goto L6;
        String r1 = r7.toString();
        Intrinsics.checkNotNull(r2);
        return StringsKt.replace$default(r1, r2, LibrarianImpl.Constants.SEPARATOR, false, 4, null);
    L6:
        return r7.toString();
    }

    private static final String getInvariantSeparatorsPath(Path r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return PathsKt.getInvariantSeparatorsPathString(r1);
    }

    private static final Path absolute(Path r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Path r2 = r1.toAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(r2, "toAbsolutePath(...)");
        return r2;
    }

    private static final String absolutePathString(Path r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.toAbsolutePath().toString();
    }

    public static final Path relativeTo(Path r4, Path r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, TraceStatsConsts.STATS_BASE_MODULE);
        return PathRelativizer.INSTANCE.tryRelativeTo(r4, r5);
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e.getMessage() + "\nthis path: " + r4 + "\nbase path: " + r5, e);
    }

    public static final Path relativeToOrSelf(Path r1, Path r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, TraceStatsConsts.STATS_BASE_MODULE);
        Path r3 = PathsKt.relativeToOrNull(r1, r2);
        if (r3 != null) goto L6;
        return r1;
    L6:
        return r3;
    }

    public static final Path relativeToOrNull(Path r1, Path r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, TraceStatsConsts.STATS_BASE_MODULE);
        return PathRelativizer.INSTANCE.tryRelativeTo(r1, r2);
    L5:
        return null;
    }

    static /* synthetic */ Path copyTo$default(Path r0, Path r1, boolean r2, int r3, Object r4) throws IOException {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "target");
        if (r2 == false) goto L8;
        CopyOption[] r5 = {StandardCopyOption.REPLACE_EXISTING};
    L9:
        Path r6 = Files.copy(r0, r1, (CopyOption[]) Arrays.copyOf(r5, r5.length));
        Intrinsics.checkNotNullExpressionValue(r6, "copy(...)");
        return r6;
    L8:
        r5 = new CopyOption[0];
        goto L9
    }

    private static final Path copyTo(Path r2, Path r3, boolean r4) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "target");
        if (r4 == false) goto L5;
        CopyOption[] r5 = {StandardCopyOption.REPLACE_EXISTING};
    L6:
        Path r6 = Files.copy(r2, r3, (CopyOption[]) Arrays.copyOf(r5, r5.length));
        Intrinsics.checkNotNullExpressionValue(r6, "copy(...)");
        return r6;
    L5:
        r5 = new CopyOption[0];
        goto L6
    }

    private static final Path copyTo(Path r1, Path r2, CopyOption... r3) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "target");
        Intrinsics.checkNotNullParameter(r3, "options");
        Path r4 = Files.copy(r1, r2, (CopyOption[]) Arrays.copyOf(r3, r3.length));
        Intrinsics.checkNotNullExpressionValue(r4, "copy(...)");
        return r4;
    }

    private static final boolean exists(Path r1, LinkOption... r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "options");
        return Files.exists(r1, (LinkOption[]) Arrays.copyOf(r2, r2.length));
    }

    private static final boolean notExists(Path r1, LinkOption... r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "options");
        return Files.notExists(r1, (LinkOption[]) Arrays.copyOf(r2, r2.length));
    }

    private static final boolean isRegularFile(Path r1, LinkOption... r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "options");
        return Files.isRegularFile(r1, (LinkOption[]) Arrays.copyOf(r2, r2.length));
    }

    private static final boolean isDirectory(Path r1, LinkOption... r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "options");
        return Files.isDirectory(r1, (LinkOption[]) Arrays.copyOf(r2, r2.length));
    }

    private static final boolean isSymbolicLink(Path r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Files.isSymbolicLink(r1);
    }

    private static final boolean isExecutable(Path r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Files.isExecutable(r1);
    }

    private static final boolean isHidden(Path r1) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Files.isHidden(r1);
    }

    private static final boolean isReadable(Path r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Files.isReadable(r1);
    }

    private static final boolean isWritable(Path r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Files.isWritable(r1);
    }

    private static final boolean isSameFileAs(Path r1, Path r2) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, PluralRules.KEYWORD_OTHER);
        return Files.isSameFile(r1, r2);
    }

    public static /* synthetic */ List listDirectoryEntries$default(Path r0, String r1, int r2, Object r3) throws IOException {
        if ((r2 & 1) == 0) goto L6;
        r1 = ApnEditor.APN_TYPE_ALL;
    L6:
        return PathsKt.listDirectoryEntries(r0, r1);
    }

    public static final List<Path> listDirectoryEntries(Path r1, String r2) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "glob");
        DirectoryStream<Path> r3 = Files.newDirectoryStream(r1, r2);
        DirectoryStream<Path> r4 = r3;     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L6
        List<Path> r5 = CollectionsKt.toList(r4);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r3, null);
        return r5;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    }

    static /* synthetic */ Object useDirectoryEntries$default(Path r0, String r1, Function1 r2, int r3, Object r4) throws IOException {
        if ((r3 & 1) == 0) goto L5;
        r1 = ApnEditor.APN_TYPE_ALL;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "glob");
        Intrinsics.checkNotNullParameter(r2, "block");
        DirectoryStream<Path> r5 = Files.newDirectoryStream(r0, r1);
        DirectoryStream<Path> r6 = r5;     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r6);     // Catch: Throwable -> L14
        Object r7 = r2.invoke(CollectionsKt.asSequence(r6));     // Catch: Throwable -> L14
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L10;
        CloseableKt.closeFinally(r5, null);
    L12:
        InlineMarker.finallyEnd(1);
        return r7;
    L10:
        if (r5 == null) goto L12;
        r5.close();
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == true) goto L22;
        if (r5 != null) goto L30;
    L23:
        InlineMarker.finallyEnd(1);
        throw th;
    L30:
        r5.close();     // Catch: Throwable -> L25
        goto L23
    L22:
        CloseableKt.closeFinally(r5, th);
        goto L23
    }

    private static final <T> T useDirectoryEntries(Path r2, String r3, Function1<? super Sequence<? extends Path>, ? extends T> r4) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "glob");
        Intrinsics.checkNotNullParameter(r4, "block");
        DirectoryStream<Path> r5 = Files.newDirectoryStream(r2, r3);
        DirectoryStream<Path> r1 = r5;     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L11
        T r6 = r4.invoke(CollectionsKt.asSequence(r1));     // Catch: Throwable -> L11
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L7;
        CloseableKt.closeFinally(r5, null);
    L9:
        InlineMarker.finallyEnd(1);
        return r6;
    L7:
        if (r5 == null) goto L9;
        r5.close();
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == true) goto L19;
        if (r5 != null) goto L25;
    L20:
        InlineMarker.finallyEnd(1);
        throw th;
    L25:
        r5.close();     // Catch: Throwable -> L22
        goto L20
    L19:
        CloseableKt.closeFinally(r5, th);
        goto L20
    }

    static /* synthetic */ void forEachDirectoryEntry$default(Path r1, String r2, Function1 r3, int r4, Object r5) throws IOException {
        if ((r4 & 1) == 0) goto L5;
        r2 = ApnEditor.APN_TYPE_ALL;
    L5:
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "glob");
        Intrinsics.checkNotNullParameter(r3, "action");
        DirectoryStream<Path> r6 = Files.newDirectoryStream(r1, r2);
        DirectoryStream<Path> r7 = r6;     // Catch: Throwable -> L18
        Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L18
        Iterator<Path> r8 = r7.iterator();     // Catch: Throwable -> L18
    L8:
        if (r8.hasNext() == false) goto L10;
        r3.invoke(r8.next());     // Catch: Throwable -> L18
        goto L8
    L10:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L18
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L14;
        CloseableKt.closeFinally(r6, null);
    L16:
        InlineMarker.finallyEnd(1);
        return;
    L14:
        if (r6 == null) goto L16;
        r6.close();
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == true) goto L26;
        if (r6 != null) goto L32;
    L27:
        InlineMarker.finallyEnd(1);
        throw th;
    L32:
        r6.close();     // Catch: Throwable -> L29
        goto L27
    L26:
        CloseableKt.closeFinally(r6, th);
        goto L27
    }

    private static final void forEachDirectoryEntry(Path r3, String r4, Function1<? super Path, Unit> r5) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "glob");
        Intrinsics.checkNotNullParameter(r5, "action");
        DirectoryStream<Path> r6 = Files.newDirectoryStream(r3, r4);
        DirectoryStream<Path> r1 = r6;     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L15
        Iterator<Path> r2 = r1.iterator();     // Catch: Throwable -> L15
    L5:
        if (r2.hasNext() == false) goto L7;
        r5.invoke(r2.next());     // Catch: Throwable -> L15
        goto L5
    L7:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L15
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L11;
        CloseableKt.closeFinally(r6, null);
    L13:
        InlineMarker.finallyEnd(1);
        return;
    L11:
        if (r6 == null) goto L13;
        r6.close();
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == true) goto L23;
        if (r6 != null) goto L31;
    L24:
        InlineMarker.finallyEnd(1);
        throw th;
    L31:
        r6.close();     // Catch: Throwable -> L26
        goto L24
    L23:
        CloseableKt.closeFinally(r6, th);
        goto L24
    }

    private static final long fileSize(Path r2) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return Files.size(r2);
    }

    private static final void deleteExisting(Path r1) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Files.delete(r1);
    }

    private static final boolean deleteIfExists(Path r1) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Files.deleteIfExists(r1);
    }

    private static final Path createDirectory(Path r1, FileAttribute<?>... r2) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "attributes");
        Path r3 = Files.createDirectory(r1, (FileAttribute[]) Arrays.copyOf(r2, r2.length));
        Intrinsics.checkNotNullExpressionValue(r3, "createDirectory(...)");
        return r3;
    }

    private static final Path createDirectories(Path r1, FileAttribute<?>... r2) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "attributes");
        Path r3 = Files.createDirectories(r1, (FileAttribute[]) Arrays.copyOf(r2, r2.length));
        Intrinsics.checkNotNullExpressionValue(r3, "createDirectories(...)");
        return r3;
    }

    public static final Path createParentDirectories(Path r3, FileAttribute<?>... r4) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "attributes");
        Path r0 = r3.getParent();
        if (r0 != null) goto L5;
    L13:
        return r3;
    L5:
        if (Files.isDirectory(r0, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) == true) goto L13;
        FileAttribute[] r5 = (FileAttribute[]) Arrays.copyOf(r4, r4.length);     // Catch: FileAlreadyExistsException -> L8
        Intrinsics.checkNotNullExpressionValue(Files.createDirectories(r0, (FileAttribute[]) Arrays.copyOf(r5, r5.length)), "createDirectories(...)");     // Catch: FileAlreadyExistsException -> L8
    L8:
        e = move-exception;
        if (Files.isDirectory(r0, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) == true) goto L13;
        throw e;
    }

    private static final Path moveTo(Path r1, Path r2, CopyOption... r3) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "target");
        Intrinsics.checkNotNullParameter(r3, "options");
        Path r4 = Files.move(r1, r2, (CopyOption[]) Arrays.copyOf(r3, r3.length));
        Intrinsics.checkNotNullExpressionValue(r4, "move(...)");
        return r4;
    }

    static /* synthetic */ Path moveTo$default(Path r0, Path r1, boolean r2, int r3, Object r4) throws IOException {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "target");
        if (r2 == false) goto L8;
        CopyOption[] r5 = {StandardCopyOption.REPLACE_EXISTING};
    L9:
        Path r6 = Files.move(r0, r1, (CopyOption[]) Arrays.copyOf(r5, r5.length));
        Intrinsics.checkNotNullExpressionValue(r6, "move(...)");
        return r6;
    L8:
        r5 = new CopyOption[0];
        goto L9
    }

    private static final Path moveTo(Path r2, Path r3, boolean r4) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "target");
        if (r4 == false) goto L5;
        CopyOption[] r5 = {StandardCopyOption.REPLACE_EXISTING};
    L6:
        Path r6 = Files.move(r2, r3, (CopyOption[]) Arrays.copyOf(r5, r5.length));
        Intrinsics.checkNotNullExpressionValue(r6, "move(...)");
        return r6;
    L5:
        r5 = new CopyOption[0];
        goto L6
    }

    private static final FileStore fileStore(Path r1) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        FileStore r2 = Files.getFileStore(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "getFileStore(...)");
        return r2;
    }

    private static final Object getAttribute(Path r1, String r2, LinkOption... r3) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "attribute");
        Intrinsics.checkNotNullParameter(r3, "options");
        return Files.getAttribute(r1, r2, (LinkOption[]) Arrays.copyOf(r3, r3.length));
    }

    private static final Path setAttribute(Path r1, String r2, Object r3, LinkOption... r4) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "attribute");
        Intrinsics.checkNotNullParameter(r4, "options");
        Path r5 = Files.setAttribute(r1, r2, r3, (LinkOption[]) Arrays.copyOf(r4, r4.length));
        Intrinsics.checkNotNullExpressionValue(r5, "setAttribute(...)");
        return r5;
    }

    private static final /* synthetic */ <V extends FileAttributeView> V fileAttributesViewOrNull(Path r2, LinkOption... r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "options");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        return (V) Files.getFileAttributeView(r2, FileAttributeView.class, (LinkOption[]) Arrays.copyOf(r3, r3.length));
    }

    private static final /* synthetic */ <V extends FileAttributeView> V fileAttributesView(Path r4, LinkOption... r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "options");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        V r6 = (V) Files.getFileAttributeView(r4, FileAttributeView.class, (LinkOption[]) Arrays.copyOf(r5, r5.length));
        if (r6 != null) goto L5;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        PathsKt.fileAttributeViewNotAvailable(r4, FileAttributeView.class);
        throw new KotlinNothingValueException();
    L5:
        return r6;
    }

    public static final Void fileAttributeViewNotAvailable(Path r3, Class<?> r4) {
        Intrinsics.checkNotNullParameter(r3, "path");
        Intrinsics.checkNotNullParameter(r4, "attributeViewClass");
        throw new UnsupportedOperationException("The desired attribute view type " + r4 + " is not available for the file " + r3 + '.');
    }

    private static final /* synthetic */ <A extends BasicFileAttributes> A readAttributes(Path r2, LinkOption... r3) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "options");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
        A r4 = (A) Files.readAttributes(r2, BasicFileAttributes.class, (LinkOption[]) Arrays.copyOf(r3, r3.length));
        Intrinsics.checkNotNullExpressionValue(r4, "readAttributes(...)");
        return r4;
    }

    private static final Map<String, Object> readAttributes(Path r1, String r2, LinkOption... r3) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "attributes");
        Intrinsics.checkNotNullParameter(r3, "options");
        Map<String, Object> r4 = Files.readAttributes(r1, r2, (LinkOption[]) Arrays.copyOf(r3, r3.length));
        Intrinsics.checkNotNullExpressionValue(r4, "readAttributes(...)");
        return r4;
    }

    private static final FileTime getLastModifiedTime(Path r1, LinkOption... r2) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "options");
        FileTime r3 = Files.getLastModifiedTime(r1, (LinkOption[]) Arrays.copyOf(r2, r2.length));
        Intrinsics.checkNotNullExpressionValue(r3, "getLastModifiedTime(...)");
        return r3;
    }

    private static final Path setLastModifiedTime(Path r1, FileTime r2) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "value");
        Path r3 = Files.setLastModifiedTime(r1, r2);
        Intrinsics.checkNotNullExpressionValue(r3, "setLastModifiedTime(...)");
        return r3;
    }

    private static final UserPrincipal getOwner(Path r1, LinkOption... r2) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "options");
        return Files.getOwner(r1, (LinkOption[]) Arrays.copyOf(r2, r2.length));
    }

    private static final Path setOwner(Path r1, UserPrincipal r2) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "value");
        Path r3 = Files.setOwner(r1, r2);
        Intrinsics.checkNotNullExpressionValue(r3, "setOwner(...)");
        return r3;
    }

    private static final Set<PosixFilePermission> getPosixFilePermissions(Path r1, LinkOption... r2) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "options");
        Set<PosixFilePermission> r3 = Files.getPosixFilePermissions(r1, (LinkOption[]) Arrays.copyOf(r2, r2.length));
        Intrinsics.checkNotNullExpressionValue(r3, "getPosixFilePermissions(...)");
        return r3;
    }

    private static final Path setPosixFilePermissions(Path r1, Set<? extends PosixFilePermission> r2) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "value");
        Path r3 = Files.setPosixFilePermissions(r1, r2);
        Intrinsics.checkNotNullExpressionValue(r3, "setPosixFilePermissions(...)");
        return r3;
    }

    private static final Path createLinkPointingTo(Path r1, Path r2) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "target");
        Path r3 = Files.createLink(r1, r2);
        Intrinsics.checkNotNullExpressionValue(r3, "createLink(...)");
        return r3;
    }

    private static final Path createSymbolicLinkPointingTo(Path r1, Path r2, FileAttribute<?>... r3) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "target");
        Intrinsics.checkNotNullParameter(r3, "attributes");
        Path r4 = Files.createSymbolicLink(r1, r2, (FileAttribute[]) Arrays.copyOf(r3, r3.length));
        Intrinsics.checkNotNullExpressionValue(r4, "createSymbolicLink(...)");
        return r4;
    }

    private static final Path readSymbolicLink(Path r1) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Path r2 = Files.readSymbolicLink(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "readSymbolicLink(...)");
        return r2;
    }

    private static final Path createFile(Path r1, FileAttribute<?>... r2) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "attributes");
        Path r3 = Files.createFile(r1, (FileAttribute[]) Arrays.copyOf(r2, r2.length));
        Intrinsics.checkNotNullExpressionValue(r3, "createFile(...)");
        return r3;
    }

    static /* synthetic */ Path createTempFile$default(String r1, String r2, FileAttribute[] r3, int r4, Object r5) throws IOException {
        if ((r4 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r2 = null;
    L8:
        Intrinsics.checkNotNullParameter(r3, "attributes");
        Path r6 = Files.createTempFile(r1, r2, (FileAttribute[]) Arrays.copyOf(r3, r3.length));
        Intrinsics.checkNotNullExpressionValue(r6, "createTempFile(...)");
        return r6;
    }

    private static final Path createTempFile(String r1, String r2, FileAttribute<?>... r3) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "attributes");
        Path r4 = Files.createTempFile(r1, r2, (FileAttribute[]) Arrays.copyOf(r3, r3.length));
        Intrinsics.checkNotNullExpressionValue(r4, "createTempFile(...)");
        return r4;
    }

    public static /* synthetic */ Path createTempFile$default(Path r1, String r2, String r3, FileAttribute[] r4, int r5, Object r6) throws IOException {
        if ((r5 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = null;
    L9:
        return PathsKt.createTempFile(r1, r2, r3, r4);
    }

    public static final Path createTempFile(Path r2, String r3, String r4, FileAttribute<?>... r5) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "attributes");
        if (r2 == null) goto L5;
        Path r6 = Files.createTempFile(r2, r3, r4, (FileAttribute[]) Arrays.copyOf(r5, r5.length));
        Intrinsics.checkNotNullExpressionValue(r6, "createTempFile(...)");
        return r6;
    L5:
        Path r7 = Files.createTempFile(r3, r4, (FileAttribute[]) Arrays.copyOf(r5, r5.length));
        Intrinsics.checkNotNullExpressionValue(r7, "createTempFile(...)");
        return r7;
    }

    static /* synthetic */ Path createTempDirectory$default(String r0, FileAttribute[] r1, int r2, Object r3) throws IOException {
        if ((r2 & 1) == 0) goto L5;
        r0 = null;
    L5:
        Intrinsics.checkNotNullParameter(r1, "attributes");
        Path r4 = Files.createTempDirectory(r0, (FileAttribute[]) Arrays.copyOf(r1, r1.length));
        Intrinsics.checkNotNullExpressionValue(r4, "createTempDirectory(...)");
        return r4;
    }

    private static final Path createTempDirectory(String r1, FileAttribute<?>... r2) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "attributes");
        Path r3 = Files.createTempDirectory(r1, (FileAttribute[]) Arrays.copyOf(r2, r2.length));
        Intrinsics.checkNotNullExpressionValue(r3, "createTempDirectory(...)");
        return r3;
    }

    public static /* synthetic */ Path createTempDirectory$default(Path r0, String r1, FileAttribute[] r2, int r3, Object r4) throws IOException {
        if ((r3 & 2) == 0) goto L6;
        r1 = null;
    L6:
        return PathsKt.createTempDirectory(r0, r1, r2);
    }

    public static final Path createTempDirectory(Path r2, String r3, FileAttribute<?>... r4) throws IOException {
        Intrinsics.checkNotNullParameter(r4, "attributes");
        if (r2 == null) goto L5;
        Path r5 = Files.createTempDirectory(r2, r3, (FileAttribute[]) Arrays.copyOf(r4, r4.length));
        Intrinsics.checkNotNullExpressionValue(r5, "createTempDirectory(...)");
        return r5;
    L5:
        Path r6 = Files.createTempDirectory(r3, (FileAttribute[]) Arrays.copyOf(r4, r4.length));
        Intrinsics.checkNotNullExpressionValue(r6, "createTempDirectory(...)");
        return r6;
    }

    private static final Path div(Path r1, Path r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, PluralRules.KEYWORD_OTHER);
        Path r3 = r1.resolve(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "resolve(...)");
        return r3;
    }

    private static final Path div(Path r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, PluralRules.KEYWORD_OTHER);
        Path r3 = r1.resolve(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "resolve(...)");
        return r3;
    }

    private static final Path Path(String r1) {
        Intrinsics.checkNotNullParameter(r1, "path");
        Path r2 = Paths.get(r1, new String[0]);
        Intrinsics.checkNotNullExpressionValue(r2, "get(...)");
        return r2;
    }

    private static final Path Path(String r1, String... r2) {
        Intrinsics.checkNotNullParameter(r1, TraceStatsConsts.STATS_BASE_MODULE);
        Intrinsics.checkNotNullParameter(r2, "subpaths");
        Path r3 = Paths.get(r1, (String[]) Arrays.copyOf(r2, r2.length));
        Intrinsics.checkNotNullExpressionValue(r3, "get(...)");
        return r3;
    }

    private static final Path toPath(URI r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Path r2 = Paths.get(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "get(...)");
        return r2;
    }

    public static final Sequence<Path> walk(Path r1, PathWalkOption... r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "options");
        return new PathTreeWalk(r1, r2);
    }

    public static /* synthetic */ void visitFileTree$default(Path r0, FileVisitor r1, int r2, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = Integer.MAX_VALUE;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = false;
    L8:
        PathsKt.visitFileTree(r0, r1, r2, r3);
    }

    public static final void visitFileTree(Path r1, FileVisitor<Path> r2, int r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "visitor");
        if (r4 == false) goto L5;
        Set r5 = SetsKt.setOf(FileVisitOption.FOLLOW_LINKS);
    L6:
        Files.walkFileTree(r1, r5, r3, r2);
        return;
    L5:
        r5 = SetsKt.emptySet();
        goto L6
    }

    public static /* synthetic */ void visitFileTree$default(Path r0, int r1, boolean r2, Function1 r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = Integer.MAX_VALUE;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r2 = false;
    L8:
        PathsKt.visitFileTree(r0, r1, r2, r3);
    }

    public static final void visitFileTree(Path r1, int r2, boolean r3, Function1<? super FileVisitorBuilder, Unit> r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r4, "builderAction");
        PathsKt.visitFileTree(r1, PathsKt.fileVisitor(r4), r2, r3);
    }

    public static final FileVisitor<Path> fileVisitor(Function1<? super FileVisitorBuilder, Unit> r1) {
        Intrinsics.checkNotNullParameter(r1, "builderAction");
        FileVisitorBuilderImpl r0 = new FileVisitorBuilderImpl();
        r1.invoke(r0);
        return r0.build();
    }
}
