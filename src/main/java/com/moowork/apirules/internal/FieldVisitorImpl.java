package com.moowork.apirules.internal;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;

final class FieldVisitorImpl
    extends FieldVisitor
{
    private final ValidatorHelper helper;

    public FieldVisitorImpl( final ValidatorHelper helper )
    {
        super( Opcodes.ASM4 );
        this.helper = helper;
    }

    @Override
    public AnnotationVisitor visitAnnotation( final String desc, final boolean visible )
    {
        this.helper.checkAnnotation( desc );
        return super.visitAnnotation( desc, visible );
    }
}
