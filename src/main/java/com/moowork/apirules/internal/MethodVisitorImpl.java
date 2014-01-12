package com.moowork.apirules.internal;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

final class MethodVisitorImpl
    extends MethodVisitor
{
    private final ValidatorHelper helper;

    public MethodVisitorImpl( final ValidatorHelper helper )
    {
        super( Opcodes.ASM4 );
        this.helper = helper;
    }

    @Override
    public void visitLineNumber( final int line, final Label start )
    {
        this.helper.setLineNumber( line );
        super.visitLineNumber( line, start );
    }

    @Override
    public AnnotationVisitor visitAnnotation( final String desc, final boolean visible )
    {
        this.helper.checkAnnotation( desc );
        return super.visitAnnotation( desc, visible );
    }
}
