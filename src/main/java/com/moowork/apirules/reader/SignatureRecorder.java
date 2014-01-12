package com.moowork.apirules.reader;

import org.objectweb.asm.Type;
import org.objectweb.asm.commons.Method;

final class SignatureRecorder
{
    private final ClassSignatures signatures;

    public SignatureRecorder( final ClassSignatures signatures )
    {
        this.signatures = signatures;
    }

    public String getClassName()
    {
        return this.signatures.getClassName();
    }

    public void addField( final String owner, final String name, final String desc )
    {
        this.signatures.add( Type.getType( desc ).getClassName() );
        this.signatures.add( Type.getObjectType( owner ).getClassName() + "#" + name );
    }

    public void addMethod( final String owner, final String name, final String desc )
    {
        final Method method = new Method( name, desc );
        this.signatures.add( method.getReturnType().getClassName() );
        for ( final Type arg : method.getArgumentTypes() )
        {
            this.signatures.add( arg.getClassName() );
        }

        this.signatures.add( toMethodSignature( owner, method ) );
    }

    public void addAnnotation( final String desc )
    {
        this.signatures.add( Type.getType( desc ).getClassName() );
    }

    private String toMethodSignature( final String owner, final Method method )
    {
        final StringBuilder str = new StringBuilder();
        str.append( Type.getObjectType( owner ).getClassName() ).append( "#" );
        str.append( method.getName() ).append( "(" );

        boolean first = true;
        for ( final Type type : method.getArgumentTypes() )
        {
            if ( first )
            {
                first = false;
            }
            else
            {
                str.append( ", " );
            }

            str.append( type.getClassName() );
        }

        str.append( ")" );
        return str.toString();
    }
}
