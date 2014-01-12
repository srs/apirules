package com.moowork.apirules.validator;

import java.util.HashSet;
import java.util.Set;

import com.moowork.apirules.Signature;
import com.moowork.apirules.Violations;

public abstract class CachingValidator
    implements SignatureValidator
{
    private final SignatureValidator delegate;

    private final Set<String> validCache;

    public CachingValidator( final SignatureValidator delegate )
    {
        this.delegate = delegate;
        this.validCache = new HashSet<>();
    }

    @Override
    public Violations validate( final Signature signature )
    {
        if ( this.validCache.contains( signature.getSignature() ) )
        {
            return new Violations();
        }

        final Violations result = this.delegate.validate( signature );
        if ( result.isEmpty() )
        {
            this.validCache.add( signature.getSignature() );
        }

        return result;
    }
}
