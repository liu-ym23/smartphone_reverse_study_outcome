package com.obric.security.cleaner.trashclear;

import android.content.Context;
import com.obric.security.R;
import com.obric.security.cleaner.CustomRubbishEntity;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tmsdk.fg.module.cleanV2.IScanTaskCallBack;

/* JADX INFO: compiled from: ObricCleanManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u001a\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/security/cleaner/trashclear/ObricCleanManager;", "", "()V", "cleanCustomRubbish", "", "customRubbishEntitys", "", "Lcom/obric/security/cleaner/CustomRubbishEntity;", "callBack", "Lcom/obric/security/cleaner/trashclear/CleanStatusCallBack;", "scanThumbnailImages", "context", "Landroid/content/Context;", "calBack", "Ltmsdk/fg/module/cleanV2/IScanTaskCallBack;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class ObricCleanManager {
    public static final ObricCleanManager INSTANCE = null;

    public final void cleanCustomRubbish(List<? extends CustomRubbishEntity> r1, CleanStatusCallBack r2) {
    }

    static {
        INSTANCE = new ObricCleanManager();
    }

    private ObricCleanManager() {
    }

    public final CustomRubbishEntity scanThumbnailImages(Context r14, IScanTaskCallBack r15) {
        Intrinsics.checkNotNullParameter(r14, "context");
        ArrayList<File> r13 = ThumbnailChecker.INSTANCE.checkThumbnailImages(r14);
        ArrayList<File> r0 = r13;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(((File) r2.next()).getPath());
        goto L4
    L6:
        ArrayList r6 = r1;
        if (r13.isEmpty() == false) goto L12;
        if (r15 == null) goto L27;
        r15.onRubbishFound(new CustomRubbishEntity());
        return null;
    L27:
        return null;
    L12:
        Iterator<T> r16 = r0.iterator();
        long r3 = 0;
    L14:
        if (r16.hasNext() == false) goto L16;
        r3 = r3 + ((File) r16.next()).length();
        goto L14
    L16:
        String r17 = r14.getString(R.string.thumbnail_image);
        Intrinsics.checkNotNullExpressionValue(r17, "context.getString(R.string.thumbnail_image)");
        String r18 = r14.getString(R.string.thumbnail_image_description);
        Intrinsics.checkNotNullExpressionValue(r18, "context.getString(R.stri…mbnail_image_description)");
        CustomRubbishEntity r4 = new CustomRubbishEntity(0, r6, true, r3, r17, "", r18);
        Iterator<T> r5 = r0.iterator();
    L18:
        if (r5.hasNext() == false) goto L20;
        File r7 = (File) r5.next();
        r4.getSinglePathSizeMap().put(r7.getPath(), Long.valueOf(r7.length()));
        goto L18
    L20:
        r4.setSize(r3);
        r4.setAppName(r17);
        r4.setDescription(r18);
        r4.setRubbishType(0);
        r4.setSuggest(true);
        if (r15 == null) goto L23;
        r15.onRubbishFound(r4);
    L23:
        return r4;
    }
}
