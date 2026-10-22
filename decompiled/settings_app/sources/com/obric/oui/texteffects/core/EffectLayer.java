package com.obric.oui.texteffects.core;

import android.icu.text.PluralRules;
import com.android.setupwizardlib.util.WizardManagerHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextEffectProtocol.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\f\rB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0002\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/texteffects/core/EffectLayer;", "", "()V", "id", "", "getId", "()Ljava/lang/String;", "properties", "", "Lcom/obric/oui/texteffects/core/PropertyTrack;", "getProperties", "()Ljava/util/List;", "ExternalView", "Text", "Lcom/obric/oui/texteffects/core/EffectLayer$Text;", "Lcom/obric/oui/texteffects/core/EffectLayer$ExternalView;", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class EffectLayer {

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J9\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/obric/oui/texteffects/core/EffectLayer$ExternalView;", "Lcom/obric/oui/texteffects/core/EffectLayer;", "id", "", "bindingKey", WizardManagerHelper.THEME_MATERIAL, "Lcom/obric/oui/texteffects/core/MaterialLayerSpec;", "properties", "", "Lcom/obric/oui/texteffects/core/PropertyTrack;", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/oui/texteffects/core/MaterialLayerSpec;Ljava/util/List;)V", "getBindingKey", "()Ljava/lang/String;", "getId", "getMaterial", "()Lcom/obric/oui/texteffects/core/MaterialLayerSpec;", "getProperties", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "", "toString", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ExternalView extends EffectLayer {
        private final String bindingKey;
        private final String id;
        private final MaterialLayerSpec material;
        private final List<PropertyTrack> properties;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ExternalView copy$default(ExternalView r0, String r1, String r2, MaterialLayerSpec r3, List r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.getId();
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.bindingKey;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.material;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.getProperties();
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final String component1() {
            return getId();
        }

        public final String component2() {
            return this.bindingKey;
        }

        public final MaterialLayerSpec component3() {
            return this.material;
        }

        public final List<PropertyTrack> component4() {
            return getProperties();
        }

        public final ExternalView copy(String r1, String r2, MaterialLayerSpec r3, List<PropertyTrack> r4) {
            Intrinsics.checkNotNullParameter(r1, "id");
            Intrinsics.checkNotNullParameter(r2, "bindingKey");
            Intrinsics.checkNotNullParameter(r4, "properties");
            return new ExternalView(r1, r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ExternalView) == true) goto L8;
            return false;
        L8:
            ExternalView r6 = (ExternalView) r5;
            if (Intrinsics.areEqual(getId(), r6.getId()) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.bindingKey, r6.bindingKey) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.material, r6.material) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(getProperties(), r6.getProperties()) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = ((getId().hashCode() * 31) + this.bindingKey.hashCode()) * 31;
            MaterialLayerSpec r1 = this.material;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + getProperties().hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "ExternalView(id=" + getId() + ", bindingKey=" + this.bindingKey + ", material=" + this.material + ", properties=" + getProperties() + ')';
        }

        public /* synthetic */ ExternalView(String r1, String r2, MaterialLayerSpec r3, List r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 4) == 0) goto L5;
            r3 = null;
        L5:
            this(r1, r2, r3, r4);
        }

        @Override // com.obric.oui.texteffects.core.EffectLayer
        public String getId() {
            return this.id;
        }

        public final String getBindingKey() {
            return this.bindingKey;
        }

        public final MaterialLayerSpec getMaterial() {
            return this.material;
        }

        @Override // com.obric.oui.texteffects.core.EffectLayer
        public List<PropertyTrack> getProperties() {
            return this.properties;
        }

        public ExternalView(String r2, String r3, MaterialLayerSpec r4, List<PropertyTrack> r5) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r3, "bindingKey");
            Intrinsics.checkNotNullParameter(r5, "properties");
            super(null);
            this.id = r2;
            this.bindingKey = r3;
            this.material = r4;
            this.properties = r5;
        }
    }

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JA\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/obric/oui/texteffects/core/EffectLayer$Text;", "Lcom/obric/oui/texteffects/core/EffectLayer;", "id", "", "source", "Lcom/obric/oui/texteffects/core/TextSource;", "fill", "Lcom/obric/oui/texteffects/core/FillSpec;", "blend", "Lcom/obric/oui/texteffects/core/BlendSpec;", "properties", "", "Lcom/obric/oui/texteffects/core/PropertyTrack;", "(Ljava/lang/String;Lcom/obric/oui/texteffects/core/TextSource;Lcom/obric/oui/texteffects/core/FillSpec;Lcom/obric/oui/texteffects/core/BlendSpec;Ljava/util/List;)V", "getBlend", "()Lcom/obric/oui/texteffects/core/BlendSpec;", "getFill", "()Lcom/obric/oui/texteffects/core/FillSpec;", "getId", "()Ljava/lang/String;", "getProperties", "()Ljava/util/List;", "getSource", "()Lcom/obric/oui/texteffects/core/TextSource;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "", "toString", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Text extends EffectLayer {
        private final BlendSpec blend;
        private final FillSpec fill;
        private final String id;
        private final List<PropertyTrack> properties;
        private final TextSource source;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Text copy$default(Text r3, String r4, TextSource r5, FillSpec r6, BlendSpec r7, List r8, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = r3.getId();
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = r3.source;
        L8:
            TextSource r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = r3.fill;
        L11:
            FillSpec r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = r3.blend;
        L14:
            BlendSpec r1 = r7;
            if ((r9 & 16) == 0) goto L17;
            r8 = r3.getProperties();
        L17:
            String r12 = r4;
            return r3.copy(r12, r11, r0, r1, r8);
        }

        public final String component1() {
            return getId();
        }

        public final TextSource component2() {
            return this.source;
        }

        public final FillSpec component3() {
            return this.fill;
        }

        public final BlendSpec component4() {
            return this.blend;
        }

        public final List<PropertyTrack> component5() {
            return getProperties();
        }

        public final Text copy(String r7, TextSource r8, FillSpec r9, BlendSpec r10, List<PropertyTrack> r11) {
            Intrinsics.checkNotNullParameter(r7, "id");
            Intrinsics.checkNotNullParameter(r8, "source");
            Intrinsics.checkNotNullParameter(r9, "fill");
            Intrinsics.checkNotNullParameter(r10, "blend");
            Intrinsics.checkNotNullParameter(r11, "properties");
            return new Text(r7, r8, r9, r10, r11);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Text) == true) goto L8;
            return false;
        L8:
            Text r6 = (Text) r5;
            if (Intrinsics.areEqual(getId(), r6.getId()) == true) goto L12;
            return false;
        L12:
            if (this.source == r6.source) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.fill, r6.fill) == true) goto L18;
            return false;
        L18:
            if (this.blend == r6.blend) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(getProperties(), r6.getProperties()) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((getId().hashCode() * 31) + this.source.hashCode()) * 31) + this.fill.hashCode()) * 31) + this.blend.hashCode()) * 31) + getProperties().hashCode();
        }

        public String toString() {
            return "Text(id=" + getId() + ", source=" + this.source + ", fill=" + this.fill + ", blend=" + this.blend + ", properties=" + getProperties() + ')';
        }

        @Override // com.obric.oui.texteffects.core.EffectLayer
        public String getId() {
            return this.id;
        }

        public final TextSource getSource() {
            return this.source;
        }

        public final FillSpec getFill() {
            return this.fill;
        }

        public /* synthetic */ Text(String r7, TextSource r8, FillSpec r9, BlendSpec r10, List r11, int r12, DefaultConstructorMarker r13) {
            if ((r12 & 8) == 0) goto L5;
            r10 = BlendSpec.SRC_OVER;
        L5:
            this(r7, r8, r9, r10, r11);
        }

        public final BlendSpec getBlend() {
            return this.blend;
        }

        @Override // com.obric.oui.texteffects.core.EffectLayer
        public List<PropertyTrack> getProperties() {
            return this.properties;
        }

        public Text(String r2, TextSource r3, FillSpec r4, BlendSpec r5, List<PropertyTrack> r6) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r3, "source");
            Intrinsics.checkNotNullParameter(r4, "fill");
            Intrinsics.checkNotNullParameter(r5, "blend");
            Intrinsics.checkNotNullParameter(r6, "properties");
            super(null);
            this.id = r2;
            this.source = r3;
            this.fill = r4;
            this.blend = r5;
            this.properties = r6;
        }
    }

    public /* synthetic */ EffectLayer(DefaultConstructorMarker r1) {
        this();
    }

    public abstract String getId();

    public abstract List<PropertyTrack> getProperties();

    private EffectLayer() {
    }
}
