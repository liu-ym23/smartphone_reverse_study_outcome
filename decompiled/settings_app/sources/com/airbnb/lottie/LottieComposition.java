package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LottieComposition {
    private Rect bounds;
    private SparseArrayCompat<FontCharacter> characters;
    private float endFrame;
    private Map<String, Font> fonts;
    private float frameRate;
    private boolean hasDashPattern;
    private Map<String, LottieImageAsset> images;
    private LongSparseArray<Layer> layerMap;
    private List<Layer> layers;
    private List<Marker> markers;
    private int maskAndMatteCount;
    private final PerformanceTracker performanceTracker;
    private Map<String, List<Layer>> precomps;
    private float startFrame;
    private final HashSet<String> warnings;

    /* JADX INFO: renamed from: com.airbnb.lottie.LottieComposition$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    @Deprecated
    public static class Factory {

        private static final class ListenerAdapter implements LottieListener<LottieComposition>, Cancellable {
            private boolean cancelled;
            private final OnCompositionLoadedListener listener;

            /* synthetic */ ListenerAdapter(OnCompositionLoadedListener r1, AnonymousClass1 r2) {
                this(r1);
            }

            @Override // com.airbnb.lottie.LottieListener
            public /* bridge */ /* synthetic */ void onResult(LottieComposition r1) {
                onResult2(r1);
            }

            private ListenerAdapter(OnCompositionLoadedListener r2) {
                this.cancelled = false;
                this.listener = r2;
            }

            /* JADX INFO: renamed from: onResult, reason: avoid collision after fix types in other method */
            public void onResult2(LottieComposition r2) {
                if (this.cancelled == false) goto L5;
                return;
            L5:
                this.listener.onCompositionLoaded(r2);
            }

            @Override // com.airbnb.lottie.Cancellable
            public void cancel() {
                this.cancelled = true;
            }
        }

        private Factory() {
        }

        @Deprecated
        public static Cancellable fromAssetFileName(Context r2, String r3, OnCompositionLoadedListener r4) {
            ListenerAdapter r0 = new ListenerAdapter(r4, null);
            LottieCompositionFactory.fromAsset(r2, r3).addListener(r0);
            return r0;
        }

        @Deprecated
        public static Cancellable fromRawFile(Context r2, int r3, OnCompositionLoadedListener r4) {
            ListenerAdapter r0 = new ListenerAdapter(r4, null);
            LottieCompositionFactory.fromRawRes(r2, r3).addListener(r0);
            return r0;
        }

        @Deprecated
        public static Cancellable fromInputStream(InputStream r2, OnCompositionLoadedListener r3) {
            ListenerAdapter r0 = new ListenerAdapter(r3, null);
            LottieCompositionFactory.fromJsonInputStream(r2, null).addListener(r0);
            return r0;
        }

        @Deprecated
        public static Cancellable fromJsonString(String r2, OnCompositionLoadedListener r3) {
            ListenerAdapter r0 = new ListenerAdapter(r3, null);
            LottieCompositionFactory.fromJsonString(r2, null).addListener(r0);
            return r0;
        }

        @Deprecated
        public static Cancellable fromJsonReader(JsonReader r2, OnCompositionLoadedListener r3) {
            ListenerAdapter r0 = new ListenerAdapter(r3, null);
            LottieCompositionFactory.fromJsonReader(r2, null).addListener(r0);
            return r0;
        }

        @Deprecated
        public static LottieComposition fromFileSync(Context r0, String r1) {
            return LottieCompositionFactory.fromAssetSync(r0, r1).getValue();
        }

        @Deprecated
        public static LottieComposition fromInputStreamSync(InputStream r1) {
            return LottieCompositionFactory.fromJsonInputStreamSync(r1, null).getValue();
        }

        @Deprecated
        public static LottieComposition fromInputStreamSync(InputStream r0, boolean r1) {
            if (r1 == false) goto L5;
            Logger.warning("Lottie now auto-closes input stream!");
        L5:
            return LottieCompositionFactory.fromJsonInputStreamSync(r0, null).getValue();
        }

        @Deprecated
        public static LottieComposition fromJsonSync(Resources r0, JSONObject r1) {
            return LottieCompositionFactory.fromJsonSync(r1, null).getValue();
        }

        @Deprecated
        public static LottieComposition fromJsonSync(String r1) {
            return LottieCompositionFactory.fromJsonStringSync(r1, null).getValue();
        }

        @Deprecated
        public static LottieComposition fromJsonSync(JsonReader r1) throws IOException {
            return LottieCompositionFactory.fromJsonReaderSync(r1, null).getValue();
        }
    }

    public LottieComposition() {
        this.performanceTracker = new PerformanceTracker();
        this.warnings = new HashSet();
        this.maskAndMatteCount = 0;
    }

    public void init(Rect r1, float r2, float r3, float r4, List<Layer> r5, LongSparseArray<Layer> r6, Map<String, List<Layer>> r7, Map<String, LottieImageAsset> r8, SparseArrayCompat<FontCharacter> r9, Map<String, Font> r10, List<Marker> r11) {
        this.bounds = r1;
        this.startFrame = r2;
        this.endFrame = r3;
        this.frameRate = r4;
        this.layers = r5;
        this.layerMap = r6;
        this.precomps = r7;
        this.images = r8;
        this.characters = r9;
        this.fonts = r10;
        this.markers = r11;
    }

    public void addWarning(String r1) {
        Logger.warning(r1);
        this.warnings.add(r1);
    }

    public void setHasDashPattern(boolean r1) {
        this.hasDashPattern = r1;
    }

    public void incrementMatteOrMaskCount(int r2) {
        this.maskAndMatteCount += r2;
    }

    public boolean hasDashPattern() {
        return this.hasDashPattern;
    }

    public int getMaskAndMatteCount() {
        return this.maskAndMatteCount;
    }

    public ArrayList<String> getWarnings() {
        HashSet<String> r2 = this.warnings;
        return new ArrayList(Arrays.asList(r2.toArray(new String[r2.size()])));
    }

    public void setPerformanceTrackingEnabled(boolean r1) {
        this.performanceTracker.setEnabled(r1);
    }

    public PerformanceTracker getPerformanceTracker() {
        return this.performanceTracker;
    }

    public Layer layerModelForId(long r1) {
        return this.layerMap.get(r1);
    }

    public Rect getBounds() {
        return this.bounds;
    }

    public float getDuration() {
        return (long) ((getDurationFrames() / this.frameRate) * 1000.0f);
    }

    public float getStartFrame() {
        return this.startFrame;
    }

    public float getEndFrame() {
        return this.endFrame;
    }

    public float getFrameRate() {
        return this.frameRate;
    }

    public List<Layer> getLayers() {
        return this.layers;
    }

    public List<Layer> getPrecomps(String r1) {
        return this.precomps.get(r1);
    }

    public SparseArrayCompat<FontCharacter> getCharacters() {
        return this.characters;
    }

    public Map<String, Font> getFonts() {
        return this.fonts;
    }

    public List<Marker> getMarkers() {
        return this.markers;
    }

    public Marker getMarker(String r4) {
        this.markers.size();
        int r0 = 0;
    L4:
        if (r0 >= this.markers.size()) goto L9;
        Marker r1 = this.markers.get(r0);
        if (r1.matchesName(r4) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r1;
    L9:
        return null;
    }

    public boolean hasImages() {
        return !this.images.isEmpty();
    }

    public Map<String, LottieImageAsset> getImages() {
        return this.images;
    }

    public float getDurationFrames() {
        return this.endFrame - this.startFrame;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("LottieComposition:\n");
        Iterator<Layer> r3 = this.layers.iterator();
    L4:
        if (r3.hasNext() == false) goto L7;
        r0.append(r3.next().toString("\t"));
        goto L4
    L7:
        return r0.toString();
    }
}
