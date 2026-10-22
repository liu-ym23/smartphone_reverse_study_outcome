package tmsdkobf;

import com.bytedance.librarian.LibrarianImpl;
import tmsdk.common.tcc.DeepCleanSAFEngine;

/* JADX INFO: loaded from: classes5.dex */
public abstract class gg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final char[] f219a = null;

    static {
        f219a = new char[]{DeepCleanSAFEngine.DetailPath.KEY, DeepCleanSAFEngine.DetailPath.DETAIL_PATH, DeepCleanSAFEngine.DetailPath.FILENAME, DeepCleanSAFEngine.DetailPath.FILESIZE, DeepCleanSAFEngine.DetailPath.CTIME, DeepCleanSAFEngine.DetailPath.MTIME, DeepCleanSAFEngine.DetailPath.ATIME, DeepCleanSAFEngine.DetailPath.IMPORTANT, '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static String a(long r8) {
        int[] r0 = {(int) ((r8 >> 24) & 255), (int) ((r8 >> 16) & 255), (int) ((r8 >> 8) & 255), (int) (r8 & 255)};
        return Integer.toString(r0[3]) + LibrarianImpl.Constants.DOT + Integer.toString(r0[2]) + LibrarianImpl.Constants.DOT + Integer.toString(r0[1]) + LibrarianImpl.Constants.DOT + Integer.toString(r0[0]);
    }
}
