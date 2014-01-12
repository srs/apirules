package com.moowork.apirules.reader;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

final class MethodVisitorImpl
    extends MethodVisitor
{
    private final SignatureRecorder recorder;

    private int lineNumber;

    public MethodVisitorImpl( final SignatureRecorder recorder )
    {
        super( Opcodes.ASM4 );
        this.recorder = recorder;
    }

    @Override
    public void visitMethodInsn( final int opcode, final String owner, final String name, final String desc )
    {
        this.recorder.addMethod( owner, name, desc );
        super.visitMethodInsn( opcode, owner, name, desc );
    }

    @Override
    public AnnotationVisitor visitAnnotation( final String desc, final boolean visible )
    {
        this.recorder.addAnnotation( desc );
        return super.visitAnnotation( desc, visible );
    }

    @Override
    public void visitFieldInsn( final int opcode, final String owner, final String name, final String desc )
    {
        this.recorder.addField( owner, name, desc );
        super.visitFieldInsn( opcode, owner, name, desc );
    }

    @Override
    public AnnotationVisitor visitParameterAnnotation( final int parameter, final String desc, final boolean visible )
    {
        this.recorder.addAnnotation( desc );
        return super.visitParameterAnnotation( parameter, desc, visible );
    }

    @Override
    public void visitLineNumber( final int line, final Label start )
    {
        this.lineNumber = line;
        super.visitLineNumber( line, start );
    }
}
