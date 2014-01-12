package com.moowork.apirules.reader;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;

final class FieldVisitorImpl
    extends FieldVisitor
{
    private final SignatureRecorder recorder;

    public FieldVisitorImpl( final SignatureRecorder recorder )
    {
        super( Opcodes.ASM4 );
        this.recorder = recorder;
    }

    @Override
    public AnnotationVisitor visitAnnotation( final String desc, final boolean visible )
    {
        this.recorder.addAnnotation( desc );
        return super.visitAnnotation( desc, visible );
    }
}
