package com.moowork.apirules.validator;

import com.moowork.apirules.Signature;
import com.moowork.apirules.Violations;

public interface SignatureValidator
{
    public Violations validate( Signature signature );
}
