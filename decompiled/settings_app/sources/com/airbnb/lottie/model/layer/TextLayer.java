package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.TextDelegate;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TextLayer extends BaseLayer {
    private final LongSparseArray<String> codePointCache;
    private BaseKeyframeAnimation<Integer, Integer> colorAnimation;
    private final LottieComposition composition;
    private final Map<FontCharacter, List<ContentGroup>> contentsForCharacter;
    private final Paint fillPaint;
    private final LottieDrawable lottieDrawable;
    private final Matrix matrix;
    private final RectF rectF;
    private final StringBuilder stringBuilder;
    private BaseKeyframeAnimation<Integer, Integer> strokeColorAnimation;
    private final Paint strokePaint;
    private BaseKeyframeAnimation<Float, Float> strokeWidthAnimation;
    private final TextKeyframeAnimation textAnimation;
    private BaseKeyframeAnimation<Float, Float> textSizeAnimation;
    private BaseKeyframeAnimation<Float, Float> trackingAnimation;

    /* JADX INFO: renamed from: com.airbnb.lottie.model.layer.TextLayer$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification = null;

        static {
            int[] r0 = new int[DocumentData.Justification.values().length];
            $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification = r0;
            r0[DocumentData.Justification.LEFT_ALIGN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification[DocumentData.Justification.RIGHT_ALIGN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification[DocumentData.Justification.CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    TextLayer(LottieDrawable r3, Layer r4) {
        super(r3, r4);
        this.stringBuilder = new StringBuilder(2);
        this.rectF = new RectF();
        this.matrix = new Matrix();
        final int r1 = 1;
        this.fillPaint = new AnonymousClass1(this, r1);
        this.strokePaint = new AnonymousClass2(this, r1);
        this.contentsForCharacter = new HashMap();
        this.codePointCache = new LongSparseArray();
        this.lottieDrawable = r3;
        this.composition = r4.getComposition();
        TextKeyframeAnimation r5 = r4.getText().createAnimation();
        this.textAnimation = r5;
        r5.addUpdateListener(this);
        addAnimation(r5);
        AnimatableTextProperties r6 = r4.getTextProperties();
        if (r6 != null) goto L5;
    L7:
        if (r6 != null) goto L9;
    L11:
        if (r6 != null) goto L13;
    L15:
        if (r6 != null) goto L17;
        return;
    L17:
        if (r6.tracking == null) goto L21;
        BaseKeyframeAnimation<Float, Float> r7 = r6.tracking.createAnimation();
        this.trackingAnimation = r7;
        r7.addUpdateListener(this);
        addAnimation(this.trackingAnimation);
        return;
    L21:
        return;
    L13:
        if (r6.strokeWidth == null) goto L15;
        BaseKeyframeAnimation<Float, Float> r8 = r6.strokeWidth.createAnimation();
        this.strokeWidthAnimation = r8;
        r8.addUpdateListener(this);
        addAnimation(this.strokeWidthAnimation);
        goto L15
    L9:
        if (r6.stroke == null) goto L11;
        BaseKeyframeAnimation<Integer, Integer> r9 = r6.stroke.createAnimation();
        this.strokeColorAnimation = r9;
        r9.addUpdateListener(this);
        addAnimation(this.strokeColorAnimation);
        goto L11
    L5:
        if (r6.color == null) goto L7;
        BaseKeyframeAnimation<Integer, Integer> r10 = r6.color.createAnimation();
        this.colorAnimation = r10;
        r10.addUpdateListener(this);
        addAnimation(this.colorAnimation);
        goto L7
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF r1, Matrix r2, boolean r3) {
        super.getBounds(r1, r2, r3);
        r1.set(0.0f, 0.0f, this.composition.getBounds().width(), this.composition.getBounds().height());
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    void drawLayer(Canvas r6, Matrix r7, int r8) {
        r6.save();
        if (this.lottieDrawable.useTextGlyphs() == true) goto L5;
        r6.setMatrix(r7);
    L5:
        DocumentData r9 = this.textAnimation.getValue();
        Font r0 = this.composition.getFonts().get(r9.fontName);
        if (r0 != null) goto L9;
        r6.restore();
        return;
    L9:
        BaseKeyframeAnimation<Integer, Integer> r1 = this.colorAnimation;
        if (r1 == null) goto L12;
        this.fillPaint.setColor(r1.getValue().intValue());
    L13:
        BaseKeyframeAnimation<Integer, Integer> r2 = this.strokeColorAnimation;
        if (r2 == null) goto L16;
        this.strokePaint.setColor(r2.getValue().intValue());
    L18:
        if (this.transform.getOpacity() != null) goto L20;
        int r3 = 100;
    L21:
        int r4 = (r3 * 255) / 100;
        this.fillPaint.setAlpha(r4);
        this.strokePaint.setAlpha(r4);
        BaseKeyframeAnimation<Float, Float> r5 = this.strokeWidthAnimation;
        if (r5 == null) goto L24;
        this.strokePaint.setStrokeWidth(r5.getValue().floatValue());
    L26:
        if (this.lottieDrawable.useTextGlyphs() == false) goto L28;
        drawTextGlyphs(r9, r7, r0, r6);
    L29:
        r6.restore();
        return;
    L28:
        drawTextWithFont(r9, r0, r7, r6);
        goto L29
    L24:
        this.strokePaint.setStrokeWidth((r9.strokeWidth * Utils.dpScale()) * Utils.getScale(r7));
        goto L26
    L20:
        r3 = this.transform.getOpacity().getValue().intValue();
        goto L21
    L16:
        this.strokePaint.setColor(r9.strokeColor);
        goto L18
    L12:
        this.fillPaint.setColor(r9.color);
        goto L13
    }

    private void drawTextGlyphs(DocumentData r18, Matrix r19, Font r20, Canvas r21) {
        BaseKeyframeAnimation<Float, Float> r0 = this.textSizeAnimation;
        if (r0 != null) goto L5;
        float r1 = r18.size;
    L6:
        float r11 = r1 / 100.0f;
        float r12 = Utils.getScale(r19);
        String r2 = r18.text;
        float r13 = r18.lineHeight * Utils.dpScale();
        List<String> r14 = getTextLines(r2);
        int r15 = r14.size();
        int r7 = 0;
    L7:
        if (r7 >= r15) goto L9;
        String r3 = r14.get(r7);
        float r4 = getTextLineWidthForGlyphs(r3, r20, r11, r12);
        r21.save();
        applyJustification(r18.justification, r21, r4);
        r21.translate(0.0f, (r7 * r13) - (((r15 - 1) * r13) / 2.0f));
        drawGlyphTextLine(r3, r18, r19, r20, r21, r12, r11);
        r21.restore();
        r7 = r7 + 1;
        goto L7
    L9:
        return;
    L5:
        r1 = r0.getValue().floatValue();
        goto L6
    }

    private void drawGlyphTextLine(String r9, DocumentData r10, Matrix r11, Font r12, Canvas r13, float r14, float r15) {
        int r0 = 0;
    L4:
        if (r0 >= r9.length()) goto L13;
        FontCharacter r1 = this.composition.getCharacters().get(FontCharacter.hashFor(r9.charAt(r0), r12.getFamily(), r12.getStyle()));
        if (r1 == null) goto L12;
        drawCharacterAsGlyph(r1, r11, r15, r10, r13);
        float r2 = ((((float) r1.getWidth()) * r15) * Utils.dpScale()) * r14;
        float r3 = r10.tracking / 10.0f;
        BaseKeyframeAnimation<Float, Float> r4 = this.trackingAnimation;
        if (r4 == null) goto L11;
        r3 = r3 + r4.getValue().floatValue();
    L11:
        r13.translate(r2 + (r3 * r14), 0.0f);
    L12:
        r0 = r0 + 1;
        goto L4
    }

    private void drawTextWithFont(DocumentData r8, Font r9, Matrix r10, Canvas r11) {
        float r0 = Utils.getScale(r10);
        Typeface r12 = this.lottieDrawable.getTypeface(r9.getFamily(), r9.getStyle());
        if (r12 != null) goto L5;
        return;
    L5:
        String r1 = r8.text;
        TextDelegate r2 = this.lottieDrawable.getTextDelegate();
        if (r2 == null) goto L8;
        r1 = r2.getTextInternal(r1);
    L8:
        this.fillPaint.setTypeface(r12);
        BaseKeyframeAnimation<Float, Float> r13 = this.textSizeAnimation;
        if (r13 != null) goto L11;
        float r14 = r8.size;
    L12:
        this.fillPaint.setTextSize(r14 * Utils.dpScale());
        this.strokePaint.setTypeface(this.fillPaint.getTypeface());
        this.strokePaint.setTextSize(this.fillPaint.getTextSize());
        float r15 = r8.lineHeight * Utils.dpScale();
        List<String> r3 = getTextLines(r1);
        int r4 = r3.size();
        int r5 = 0;
    L13:
        if (r5 >= r4) goto L15;
        String r6 = r3.get(r5);
        applyJustification(r8.justification, r11, this.strokePaint.measureText(r6));
        r11.translate(0.0f, (r5 * r15) - (((r4 - 1) * r15) / 2.0f));
        drawFontTextLine(r6, r8, r11, r0);
        r11.setMatrix(r10);
        r5 = r5 + 1;
        goto L13
    L15:
        return;
    L11:
        r14 = r13.getValue().floatValue();
        goto L12
    }

    private List<String> getTextLines(String r2) {
        return Arrays.asList(r2.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private void drawFontTextLine(String r6, DocumentData r7, Canvas r8, float r9) {
        int r1 = 0;
    L4:
        if (r1 >= r6.length()) goto L9;
        String r2 = codePointToString(r6, r1);
        r1 = r1 + r2.length();
        drawCharacterFromFont(r2, r7, r8);
        float r3 = this.fillPaint.measureText(r2, 0, 1);
        float r4 = r7.tracking / 10.0f;
        BaseKeyframeAnimation<Float, Float> r5 = this.trackingAnimation;
        if (r5 == null) goto L8;
        r4 = r4 + r5.getValue().floatValue();
    L8:
        r8.translate(r3 + (r4 * r9), 0.0f);
        goto L4
    }

    private float getTextLineWidthForGlyphs(String r10, Font r11, float r12, float r13) {
        float r0 = 0.0f;
        int r1 = 0;
    L4:
        if (r1 >= r10.length()) goto L10;
        int r2 = FontCharacter.hashFor(r10.charAt(r1), r11.getFamily(), r11.getStyle());
        FontCharacter r3 = this.composition.getCharacters().get(r2);
        if (r3 == null) goto L9;
        r0 = (float) (((double) r0) + (((r3.getWidth() * ((double) r12)) * ((double) Utils.dpScale())) * ((double) r13)));
    L9:
        r1 = r1 + 1;
        goto L4
    L10:
        return r0;
    }

    private void applyJustification(DocumentData.Justification r2, Canvas r3, float r4) {
        int r1 = AnonymousClass3.$SwitchMap$com$airbnb$lottie$model$DocumentData$Justification[r2.ordinal()];
        if (r1 != 2) goto L5;
        r3.translate(-r4, 0.0f);
        return;
    L5:
        if (r1 != 3) goto L11;
        r3.translate((-r4) / 2.0f, 0.0f);
        return;
    }

    private void drawCharacterAsGlyph(FontCharacter r7, Matrix r8, float r9, DocumentData r10, Canvas r11) {
        List<ContentGroup> r12 = getContentsForCharacter(r7);
        int r1 = 0;
    L4:
        if (r1 >= r12.size()) goto L10;
        Path r2 = r12.get(r1).getPath();
        r2.computeBounds(this.rectF, false);
        this.matrix.set(r8);
        this.matrix.preTranslate(0.0f, (-r10.baselineShift) * Utils.dpScale());
        this.matrix.preScale(r9, r9);
        r2.transform(this.matrix);
        if (r10.strokeOverFill == false) goto L8;
        drawGlyph(r2, this.fillPaint, r11);
        drawGlyph(r2, this.strokePaint, r11);
    L9:
        r1 = r1 + 1;
        goto L4
    L8:
        drawGlyph(r2, this.strokePaint, r11);
        drawGlyph(r2, this.fillPaint, r11);
        goto L9
    }

    private void drawGlyph(Path r2, Paint r3, Canvas r4) {
        if (r3.getColor() != 0) goto L6;
        return;
    L6:
        if (r3.getStyle() == Paint.Style.STROKE) goto L8;
    L10:
        r4.drawPath(r2, r3);
        return;
    L8:
        if (r3.getStrokeWidth() != 0.0f) goto L10;
    }

    private void drawCharacterFromFont(String r1, DocumentData r2, Canvas r3) {
        if (r2.strokeOverFill == false) goto L5;
        drawCharacter(r1, this.fillPaint, r3);
        drawCharacter(r1, this.strokePaint, r3);
        return;
    L5:
        drawCharacter(r1, this.strokePaint, r3);
        drawCharacter(r1, this.fillPaint, r3);
    }

    private void drawCharacter(String r8, Paint r9, Canvas r10) {
        if (r9.getColor() != 0) goto L6;
        return;
    L6:
        if (r9.getStyle() == Paint.Style.STROKE) goto L8;
    L10:
        r10.drawText(r8, 0, r8.length(), 0.0f, 0.0f, r9);
        return;
    L8:
        if (r9.getStrokeWidth() != 0.0f) goto L10;
    }

    private List<ContentGroup> getContentsForCharacter(FontCharacter r8) {
        if (this.contentsForCharacter.containsKey(r8) == true) goto L5;
        List<ShapeGroup> r0 = r8.getShapes();
        int r1 = r0.size();
        ArrayList r2 = new ArrayList(r1);
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L9;
        ShapeGroup r4 = r0.get(r3);
        r2.add(new ContentGroup(this.lottieDrawable, this, r4));
        r3 = r3 + 1;
        goto L7
    L9:
        this.contentsForCharacter.put(r8, r2);
        return r2;
    L5:
        return this.contentsForCharacter.get(r8);
    }

    private String codePointToString(String r6, int r7) {
        int r0 = r6.codePointAt(r7);
        int r1 = Character.charCount(r0) + r7;
    L4:
        if (r1 >= r6.length()) goto L9;
        int r2 = r6.codePointAt(r1);
        if (isModifier(r2) == false) goto L9;
        r1 = r1 + Character.charCount(r2);
        r0 = (r0 * 31) + r2;
    L9:
        long r3 = r0;
        if (this.codePointCache.containsKey(r3) == true) goto L12;
        this.stringBuilder.setLength(0);
    L14:
        if (r7 >= r1) goto L16;
        int r4 = r6.codePointAt(r7);
        this.stringBuilder.appendCodePoint(r4);
        r7 = r7 + Character.charCount(r4);
        goto L14
    L16:
        String r8 = this.stringBuilder.toString();
        this.codePointCache.put(r3, r8);
        return r8;
    L12:
        return this.codePointCache.get(r3);
    }

    private boolean isModifier(int r2) {
        if (Character.getType(r2) != 16) goto L5;
    L14:
        return true;
    L5:
        if (Character.getType(r2) == 27) goto L14;
        if (Character.getType(r2) == 6) goto L14;
        if (Character.getType(r2) == 28) goto L14;
        if (Character.getType(r2) == 19) goto L14;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T r3, LottieValueCallback<T> r4) {
        super.addValueCallback(r3, r4);
        if (r3 != LottieProperty.COLOR) goto L13;
        BaseKeyframeAnimation<Integer, Integer> r5 = this.colorAnimation;
        if (r5 == null) goto L7;
        r5.setValueCallback(r4);
        return;
    L7:
        if (r4 != 0) goto L11;
        if (r5 == null) goto L10;
        removeAnimation(r5);
    L10:
        this.colorAnimation = null;
        return;
    L11:
        ValueCallbackKeyframeAnimation r6 = new ValueCallbackKeyframeAnimation(r4);
        this.colorAnimation = r6;
        r6.addUpdateListener(this);
        addAnimation(this.colorAnimation);
        return;
    L13:
        if (r3 != LottieProperty.STROKE_COLOR) goto L23;
        BaseKeyframeAnimation<Integer, Integer> r7 = this.strokeColorAnimation;
        if (r7 == null) goto L17;
        r7.setValueCallback(r4);
        return;
    L17:
        if (r4 != 0) goto L21;
        if (r7 == null) goto L20;
        removeAnimation(r7);
    L20:
        this.strokeColorAnimation = null;
        return;
    L21:
        ValueCallbackKeyframeAnimation r8 = new ValueCallbackKeyframeAnimation(r4);
        this.strokeColorAnimation = r8;
        r8.addUpdateListener(this);
        addAnimation(this.strokeColorAnimation);
        return;
    L23:
        if (r3 != LottieProperty.STROKE_WIDTH) goto L33;
        BaseKeyframeAnimation<Float, Float> r9 = this.strokeWidthAnimation;
        if (r9 == null) goto L27;
        r9.setValueCallback(r4);
        return;
    L27:
        if (r4 != 0) goto L31;
        if (r9 == null) goto L30;
        removeAnimation(r9);
    L30:
        this.strokeWidthAnimation = null;
        return;
    L31:
        ValueCallbackKeyframeAnimation r10 = new ValueCallbackKeyframeAnimation(r4);
        this.strokeWidthAnimation = r10;
        r10.addUpdateListener(this);
        addAnimation(this.strokeWidthAnimation);
        return;
    L33:
        if (r3 != LottieProperty.TEXT_TRACKING) goto L43;
        BaseKeyframeAnimation<Float, Float> r11 = this.trackingAnimation;
        if (r11 == null) goto L37;
        r11.setValueCallback(r4);
        return;
    L37:
        if (r4 != 0) goto L41;
        if (r11 == null) goto L40;
        removeAnimation(r11);
    L40:
        this.trackingAnimation = null;
        return;
    L41:
        ValueCallbackKeyframeAnimation r12 = new ValueCallbackKeyframeAnimation(r4);
        this.trackingAnimation = r12;
        r12.addUpdateListener(this);
        addAnimation(this.trackingAnimation);
        return;
    L43:
        if (r3 != LottieProperty.TEXT_SIZE) goto L63;
        if (r4 != 0) goto L49;
        BaseKeyframeAnimation<Float, Float> r13 = this.textSizeAnimation;
        if (r13 == null) goto L48;
        removeAnimation(r13);
    L48:
        this.textSizeAnimation = null;
        return;
    L49:
        ValueCallbackKeyframeAnimation r14 = new ValueCallbackKeyframeAnimation(r4);
        this.textSizeAnimation = r14;
        r14.addUpdateListener(this);
        addAnimation(this.textSizeAnimation);
        return;
    }
}
