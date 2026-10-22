package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
class TypefaceCompatBaseImpl {
    private static final int INVALID_KEY = 0;
    private static final String TAG = "TypefaceCompatBaseImpl";
    private ConcurrentHashMap<Long, FontResourcesParserCompat.FontFamilyFilesResourceEntry> mFontFamilies;

    private interface StyleExtractor<T> {
        int getWeight(T r1);

        boolean isItalic(T r1);
    }

    TypefaceCompatBaseImpl() {
        this.mFontFamilies = new ConcurrentHashMap();
    }

    private static <T> T findBestFont(T[] r1, int r2, StyleExtractor<T> r3) {
        if ((r2 & 1) != 0) goto L5;
        int r0 = 400;
    L7:
        if ((r2 & 2) == 0) goto L9;
        boolean r4 = true;
    L11:
        return (T) findBestFont(r1, r0, r4, r3);
    L9:
        r4 = false;
        goto L11
    L5:
        r0 = 700;
        goto L7
    }

    private static <T> T findBestFont(T[] r8, int r9, boolean r10, StyleExtractor<T> r11) {
        int r0 = r8.length;
        T r1 = null;
        int r2 = Integer.MAX_VALUE;
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L13;
        T r5 = r8[r4];
        int r6 = Math.abs(r11.getWeight(r5) - r9) * 2;
        if (r11.isItalic(r5) != r10) goto L7;
        int r7 = 0;
    L8:
        int r12 = r6 + r7;
        if (r1 == null) goto L11;
        if (r2 > r12) goto L11;
    L12:
        r4 = r4 + 1;
    L11:
        r1 = r5;
        r2 = r12;
        goto L12
    L7:
        r7 = 1;
        goto L8
    L13:
        return r1;
    }

    private static long getUniqueKey(Typeface r6) {
        if (r6 != null) goto L13;
        return 0;
    L13:
        Field r4 = Typeface.class.getDeclaredField("native_instance");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L10
        r4.setAccessible(true);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L10
        return ((Number) r4.get(r6)).longValue();
    L7:
        e = move-exception;
        Log.e(TAG, "Could not retrieve font from family.", e);
        return 0;
    L10:
        e = move-exception;
        Log.e(TAG, "Could not retrieve font from family.", e);
        return 0;
    }

    protected FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] r2, int r3) {
        return (FontsContractCompat.FontInfo) findBestFont(r2, r3, new AnonymousClass1(this));
    }

    protected Typeface createFromInputStream(Context r1, InputStream r2) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            java.io.File r0 = androidx.core.graphics.TypefaceCompatUtil.getTempFile(r1)
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            boolean r2 = androidx.core.graphics.TypefaceCompatUtil.copyToFile(r0, r2)     // Catch: java.lang.Throwable -> L1e java.lang.RuntimeException -> L23
            if (r2 != 0) goto L12
            r0.delete()
            return r1
        L12:
            java.lang.String r2 = r0.getPath()     // Catch: java.lang.Throwable -> L1e java.lang.RuntimeException -> L23
            android.graphics.Typeface r1 = android.graphics.Typeface.createFromFile(r2)     // Catch: java.lang.Throwable -> L1e java.lang.RuntimeException -> L23
            r0.delete()
            return r1
        L1e:
            r1 = move-exception
            r0.delete()
            throw r1
        L23:
            r0.delete()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompatBaseImpl.createFromInputStream(android.content.Context, java.io.InputStream):android.graphics.Typeface");
    }

    public Typeface createFromFontInfo(Context r3, CancellationSignal r4, FontsContractCompat.FontInfo[] r5, int r6) {
        InputStream r1 = null;
        if (r5.length >= 1) goto L19;
        return null;
    L19:
        InputStream r7 = r3.getContentResolver().openInputStream(findBestInfo(r5, r6).getUri());     // Catch: Throwable -> L12 IOException -> L15
    L21:
        Typeface r2 = createFromInputStream(r3, r7);     // Catch: Throwable -> L10 IOException -> L18
        TypefaceCompatUtil.closeQuietly(r7);
        return r2;
    L10:
        th = th;
        r1 = r7;
    L13:
        TypefaceCompatUtil.closeQuietly(r1);
        throw th;
    L16:
        TypefaceCompatUtil.closeQuietly(r7);
        return null;
    L15:
        r7 = null;
    L12:
        th = th;
        goto L13
    }

    private FontResourcesParserCompat.FontFileResourceEntry findBestEntry(FontResourcesParserCompat.FontFamilyFilesResourceEntry r2, int r3) {
        return (FontResourcesParserCompat.FontFileResourceEntry) findBestFont(r2.getEntries(), r3, new AnonymousClass2(this));
    }

    private FontResourcesParserCompat.FontFileResourceEntry findBestEntry(FontResourcesParserCompat.FontFamilyFilesResourceEntry r2, int r3, boolean r4) {
        return (FontResourcesParserCompat.FontFileResourceEntry) findBestFont(r2.getEntries(), r3, r4, new AnonymousClass3(this));
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context r7, FontResourcesParserCompat.FontFamilyFilesResourceEntry r8, Resources r9, int r10) {
        FontResourcesParserCompat.FontFileResourceEntry r0 = findBestEntry(r8, r10);
        if (r0 != null) goto L6;
        return null;
    L6:
        Typeface r11 = TypefaceCompat.createFromResourcesFontFile(r7, r9, r0.getResourceId(), r0.getFileName(), 0, r10);
        addFontFamily(r11, r8);
        return r11;
    }

    Typeface createFromFontFamilyFilesResourceEntry(Context r7, FontResourcesParserCompat.FontFamilyFilesResourceEntry r8, Resources r9, int r10, boolean r11) {
        FontResourcesParserCompat.FontFileResourceEntry r12 = findBestEntry(r8, r10, r11);
        if (r12 != null) goto L6;
        return null;
    L6:
        Typeface r13 = TypefaceCompat.createFromResourcesFontFile(r7, r9, r12.getResourceId(), r12.getFileName(), 0, 0);
        addFontFamily(r13, r8);
        return r13;
    }

    public Typeface createFromResourcesFontFile(Context r1, Resources r2, int r3, String r4, int r5) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            java.io.File r0 = androidx.core.graphics.TypefaceCompatUtil.getTempFile(r1)
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            boolean r2 = androidx.core.graphics.TypefaceCompatUtil.copyToFile(r0, r2, r3)     // Catch: java.lang.Throwable -> L1e java.lang.RuntimeException -> L23
            if (r2 != 0) goto L12
            r0.delete()
            return r1
        L12:
            java.lang.String r2 = r0.getPath()     // Catch: java.lang.Throwable -> L1e java.lang.RuntimeException -> L23
            android.graphics.Typeface r1 = android.graphics.Typeface.createFromFile(r2)     // Catch: java.lang.Throwable -> L1e java.lang.RuntimeException -> L23
            r0.delete()
            return r1
        L1e:
            r1 = move-exception
            r0.delete()
            throw r1
        L23:
            r0.delete()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompatBaseImpl.createFromResourcesFontFile(android.content.Context, android.content.res.Resources, int, java.lang.String, int):android.graphics.Typeface");
    }

    Typeface createWeightStyle(Context r1, Typeface r2, int r3, boolean r4) {
        Typeface r0 = WeightTypefaceApi14.createWeightStyle(this, r1, r2, r3, r4);     // Catch: RuntimeException -> L4
    L5:
        if (r0 != null) goto L8;
        return r2;
    L8:
        return r0;
    L4:
        r0 = null;
        goto L5
    }

    FontResourcesParserCompat.FontFamilyFilesResourceEntry getFontFamily(Typeface r5) {
        long r0 = getUniqueKey(r5);
        if (r0 != 0) goto L7;
        return null;
    L7:
        return this.mFontFamilies.get(Long.valueOf(r0));
    }

    private void addFontFamily(Typeface r5, FontResourcesParserCompat.FontFamilyFilesResourceEntry r6) {
        long r0 = getUniqueKey(r5);
        if (r0 == 0) goto L6;
        this.mFontFamilies.put(Long.valueOf(r0), r6);
        return;
    }
}
