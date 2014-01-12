package com.moowork.apirules.internal;

import org.objectweb.asm.Type;

import com.moowork.apirules.Location;
import com.moowork.apirules.Signature;
import com.moowork.apirules.validator.SignatureValidator;

final class ValidatorHelper
{
    private final String ownerClass;

    private final SignatureValidator validator;

    private int lineNumber;

    private String source;

    public ValidatorHelper( final String ownerClass, final SignatureValidator validator )
    {
        this.ownerClass = ownerClass;
        this.validator = validator;
        this.lineNumber = -1;
    }

    public void setSource( final String source )
    {
        this.source = source;
    }

    public void setLineNumber( final int lineNumber )
    {
        this.lineNumber = lineNumber;
    }

    private Signature createSignature( final String str )
    {
        final Location location = new Location( this.source, this.lineNumber );
        return new Signature( this.ownerClass, str, location );
    }

    private void checkSignature( final String str )
    {
        final Signature signature = createSignature( str );
        this.validator.validate( signature );
    }

    public void checkAnnotation( final String desc )
    {
        checkSignature( Type.getType( desc ).getClassName() );
    }
}
