package androidx.core.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class DocumentsContractCompat {
    private static final String PATH_TREE = "tree";

    public static final class DocumentCompat {
        public static final int FLAG_VIRTUAL_DOCUMENT = 512;

        private DocumentCompat() {
        }
    }

    @RequiresApi(19)
    private static class DocumentsContractApi19Impl {
        private DocumentsContractApi19Impl() {
        }

        @DoNotInline
        public static Uri buildDocumentUri(String r0, String r1) {
            return DocumentsContract.buildDocumentUri(r0, r1);
        }

        @DoNotInline
        static boolean deleteDocument(ContentResolver r0, Uri r1) {
            return DocumentsContract.deleteDocument(r0, r1);
        }

        @DoNotInline
        static String getDocumentId(Uri r0) {
            return DocumentsContract.getDocumentId(r0);
        }

        @DoNotInline
        static boolean isDocumentUri(Context r0, @Nullable Uri r1) {
            return DocumentsContract.isDocumentUri(r0, r1);
        }
    }

    @RequiresApi(21)
    private static class DocumentsContractApi21Impl {
        private DocumentsContractApi21Impl() {
        }

        @DoNotInline
        static Uri buildChildDocumentsUri(String r0, String r1) {
            return DocumentsContract.buildChildDocumentsUri(r0, r1);
        }

        @DoNotInline
        static Uri buildChildDocumentsUriUsingTree(Uri r0, String r1) {
            return DocumentsContract.buildChildDocumentsUriUsingTree(r0, r1);
        }

        @DoNotInline
        static Uri buildDocumentUriUsingTree(Uri r0, String r1) {
            return DocumentsContract.buildDocumentUriUsingTree(r0, r1);
        }

        @DoNotInline
        public static Uri buildTreeDocumentUri(String r0, String r1) {
            return DocumentsContract.buildTreeDocumentUri(r0, r1);
        }

        @DoNotInline
        static Uri createDocument(ContentResolver r0, Uri r1, String r2, String r3) {
            return DocumentsContract.createDocument(r0, r1, r2, r3);
        }

        @DoNotInline
        static String getTreeDocumentId(Uri r0) {
            return DocumentsContract.getTreeDocumentId(r0);
        }

        @DoNotInline
        static Uri renameDocument(@NonNull ContentResolver r0, @NonNull Uri r1, @NonNull String r2) {
            return DocumentsContract.renameDocument(r0, r1, r2);
        }
    }

    @RequiresApi(24)
    private static class DocumentsContractApi24Impl {
        private DocumentsContractApi24Impl() {
        }

        @DoNotInline
        static boolean isTreeUri(@NonNull Uri r0) {
            return DocumentsContract.isTreeUri(r0);
        }

        @DoNotInline
        static boolean removeDocument(ContentResolver r0, Uri r1, Uri r2) {
            return DocumentsContract.removeDocument(r0, r1, r2);
        }
    }

    private DocumentsContractCompat() {
    }

    @Nullable
    public static Uri buildChildDocumentsUri(@NonNull String r2, @Nullable String r3) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return DocumentsContractApi21Impl.buildChildDocumentsUri(r2, r3);
    }

    @Nullable
    public static Uri buildChildDocumentsUriUsingTree(@NonNull Uri r2, @NonNull String r3) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return DocumentsContractApi21Impl.buildChildDocumentsUriUsingTree(r2, r3);
    }

    @Nullable
    public static Uri buildDocumentUri(@NonNull String r2, @NonNull String r3) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return null;
    L5:
        return DocumentsContractApi19Impl.buildDocumentUri(r2, r3);
    }

    @Nullable
    public static Uri buildDocumentUriUsingTree(@NonNull Uri r2, @NonNull String r3) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return DocumentsContractApi21Impl.buildDocumentUriUsingTree(r2, r3);
    }

    @Nullable
    public static Uri buildTreeDocumentUri(@NonNull String r2, @NonNull String r3) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return DocumentsContractApi21Impl.buildTreeDocumentUri(r2, r3);
    }

    @Nullable
    public static Uri createDocument(@NonNull ContentResolver r2, @NonNull Uri r3, @NonNull String r4, @NonNull String r5) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return DocumentsContractApi21Impl.createDocument(r2, r3, r4, r5);
    }

    @Nullable
    public static String getDocumentId(@NonNull Uri r2) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return null;
    L5:
        return DocumentsContractApi19Impl.getDocumentId(r2);
    }

    @Nullable
    public static String getTreeDocumentId(@NonNull Uri r2) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return DocumentsContractApi21Impl.getTreeDocumentId(r2);
    }

    public static boolean isDocumentUri(@NonNull Context r2, @Nullable Uri r3) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return DocumentsContractApi19Impl.isDocumentUri(r2, r3);
    }

    public static boolean isTreeUri(@NonNull Uri r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 21) goto L6;
        return false;
    L6:
        if (r0 >= 24) goto L14;
        List<String> r4 = r3.getPathSegments();
        if (r4.size() >= 2) goto L10;
        return false;
    L10:
        if (PATH_TREE.equals(r4.get(0)) == false) goto L16;
        return true;
    L16:
        return false;
    L14:
        return DocumentsContractApi24Impl.isTreeUri(r3);
    }

    public static boolean removeDocument(@NonNull ContentResolver r2, @NonNull Uri r3, @NonNull Uri r4) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 24) goto L7;
        return DocumentsContractApi24Impl.removeDocument(r2, r3, r4);
    L7:
        if (r0 >= 19) goto L9;
        return false;
    L9:
        return DocumentsContractApi19Impl.deleteDocument(r2, r3);
    }

    @Nullable
    public static Uri renameDocument(@NonNull ContentResolver r2, @NonNull Uri r3, @NonNull String r4) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return DocumentsContractApi21Impl.renameDocument(r2, r3, r4);
    }
}
