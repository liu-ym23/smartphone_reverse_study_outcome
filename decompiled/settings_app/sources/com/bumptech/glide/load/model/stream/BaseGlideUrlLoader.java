package com.bumptech.glide.load.model.stream;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseGlideUrlLoader<Model> implements ModelLoader<Model, InputStream> {
    private final ModelLoader<GlideUrl, InputStream> concreteLoader;
    private final ModelCache<Model, GlideUrl> modelCache;

    protected abstract String getUrl(Model r1, int r2, int r3, Options r4);

    protected BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> r2) {
        this(r2, null);
    }

    protected BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> r1, ModelCache<Model, GlideUrl> r2) {
        this.concreteLoader = r1;
        this.modelCache = r2;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<InputStream> buildLoadData(Model r4, int r5, int r6, Options r7) {
        ModelCache<Model, GlideUrl> r0 = this.modelCache;
        if (r0 == null) goto L5;
        GlideUrl r1 = r0.get(r4, r5, r6);
    L6:
        if (r1 != null) goto L14;
        String r2 = getUrl(r4, r5, r6, r7);
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return null;
    L10:
        GlideUrl r3 = new GlideUrl(r2, getHeaders(r4, r5, r6, r7));
        ModelCache<Model, GlideUrl> r8 = this.modelCache;
        if (r8 == null) goto L13;
        r8.put(r4, r5, r6, r3);
    L13:
        r1 = r3;
    L14:
        List<String> r9 = getAlternateUrls(r4, r5, r6, r7);
        ModelLoader.LoadData<InputStream> r10 = this.concreteLoader.buildLoadData(r1, r5, r6, r7);
        if (r10 != null) goto L17;
    L21:
        return r10;
    L17:
        if (r9.isEmpty() == true) goto L21;
        return new ModelLoader.LoadData(r10.sourceKey, getAlternateKeys(r9), r10.fetcher);
    L5:
        r1 = null;
        goto L6
    }

    private static List<Key> getAlternateKeys(Collection<String> r3) {
        ArrayList r0 = new ArrayList(r3.size());
        Iterator<String> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.add(new GlideUrl(r4.next()));
        goto L4
    L6:
        return r0;
    }

    protected List<String> getAlternateUrls(Model r1, int r2, int r3, Options r4) {
        return Collections.emptyList();
    }

    protected Headers getHeaders(Model r1, int r2, int r3, Options r4) {
        return Headers.DEFAULT;
    }
}
