package com.moowork.apirules.internal;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.moowork.apirules.validator.SignatureValidator;

public final class ClassVisitorImpl
    extends ClassVisitor
{
    private final ValidatorHelper helper;

    public ClassVisitorImpl( final String owner, final SignatureValidator validator )
    {
        super( Opcodes.ASM4 );
        this.helper = new ValidatorHelper( owner, validator );
    }

    @Override
    public void visitSource( final String source, final String debug )
    {
        this.helper.setSource( source );
        super.visitSource( source, debug );
    }

    @Override
    public AnnotationVisitor visitAnnotation( final String desc, final boolean visible )
    {
        this.helper.checkAnnotation( desc );
        return super.visitAnnotation( desc, visible );
    }

    @Override
    public MethodVisitor visitMethod( final int access, final String name, final String desc, final String signature,
                                      final String[] exceptions )
    {
        return new MethodVisitorImpl( this.helper );
    }

    @Override
    public FieldVisitor visitField( final int access, final String name, final String desc, final String signature, final Object value )
    {
        return new FieldVisitorImpl( this.helper );
    }
}
