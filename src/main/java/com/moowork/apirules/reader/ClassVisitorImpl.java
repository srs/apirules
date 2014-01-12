package com.moowork.apirules.reader;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

final class ClassVisitorImpl
    extends ClassVisitor
{
    private final SignatureRecorder recorder;

    public ClassVisitorImpl( final ClassSignatures signatures )
    {
        super( Opcodes.ASM4 );
        this.recorder = new SignatureRecorder( signatures );
    }

    @Override
    public AnnotationVisitor visitAnnotation( final String desc, final boolean visible )
    {
        this.recorder.addAnnotation( desc );
        return super.visitAnnotation( desc, visible );
    }

    @Override
    public FieldVisitor visitField( final int access, final String name, final String desc, final String signature, final Object value )
    {
        this.recorder.addField( this.recorder.getClassName(), name, desc );
        return new FieldVisitorImpl( this.recorder );
    }

    @Override
    public MethodVisitor visitMethod( final int access, final String name, final String desc, final String signature,
                                      final String[] exceptions )
    {
        this.recorder.addMethod( this.recorder.getClassName(), name, desc );
        return new MethodVisitorImpl( this.recorder );
    }

    @Override
    public void visitSource( final String source, final String debug )
    {
        super.visitSource( source, debug );
    }
}
