package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.UrlUriLoader;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class HttpUriLoader extends UrlUriLoader<InputStream> {

    @Deprecated
    public static class Factory extends UrlUriLoader.StreamFactory {
        public Factory() {
        }
    }

    public HttpUriLoader(ModelLoader<GlideUrl, InputStream> r1) {
        super(r1);
    }
}
