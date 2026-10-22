package d.c.f.a.a.i;

import androidx.core.os.EnvironmentCompat;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static int a(String r8) {
        r8.hashCode();
        byte r7 = -1;
        switch(r8.hashCode()) {
            case -1914072202: goto L46;
            case -1683996557: goto L42;
            case -1579985851: goto L38;
            case -1307634203: goto L34;
            case -1224383234: goto L30;
            case 656304759: goto L26;
            case 957714404: goto L22;
            case 1019542023: goto L18;
            case 1721672898: goto L14;
            case 1793127518: goto L10;
            case 2113652014: goto L6;
            default: goto L49;
        };
    L49:
        switch(r7) {
            case 0: goto L55;
            case 1: goto L54;
            case 2: goto L54;
            case 3: goto L53;
            case 4: goto L52;
            case 5: goto L51;
            case 6: goto L55;
            case 7: goto L54;
            case 8: goto L54;
            case 9: goto L54;
            case 10: goto L54;
            default: goto L50;
        };
    L50:
        return 1;
    L51:
        return 3;
    L52:
        return 2;
    L53:
        return 4;
    L54:
        return 6;
    L55:
        return 5;
    L6:
        if (r8.equals("LocalContentUriFetchProducer") == false) goto L49;
        r7 = 10;
        goto L49
    L10:
        if (r8.equals("LocalContentUriThumbnailFetchProducer") == false) goto L49;
        r7 = 9;
        goto L49
    L14:
        if (r8.equals("DataFetchProducer") == false) goto L49;
        r7 = 8;
        goto L49
    L18:
        if (r8.equals("LocalAssetFetchProducer") == false) goto L49;
        r7 = 7;
        goto L49
    L22:
        if (r8.equals("BitmapMemoryCacheProducer") == false) goto L49;
        r7 = 6;
        goto L49
    L26:
        if (r8.equals("DiskCacheProducer") == false) goto L49;
        r7 = 5;
        goto L49
    L30:
        if (r8.equals("NetworkFetchProducer") == false) goto L49;
        r7 = 4;
        goto L49
    L34:
        if (r8.equals("EncodedMemoryCacheProducer") == false) goto L49;
        r7 = 3;
        goto L49
    L38:
        if (r8.equals("LocalFileFetchProducer") == false) goto L49;
        r7 = 2;
        goto L49
    L42:
        if (r8.equals("LocalResourceFetchProducer") == false) goto L49;
        r7 = 1;
        goto L49
    L46:
        if (r8.equals("BitmapMemoryCacheGetProducer") == false) goto L49;
        r7 = 0;
        goto L49
    }

    public static String b(int r1) {
        if (r1 != 2) goto L5;
        return "network";
    L5:
        if (r1 != 3) goto L7;
        return "disk";
    L7:
        if (r1 != 4) goto L9;
        return "memory_encoded";
    L9:
        if (r1 != 5) goto L11;
        return "memory_bitmap";
    L11:
        if (r1 == 6) goto L14;
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L14:
        return "local";
    }
}
