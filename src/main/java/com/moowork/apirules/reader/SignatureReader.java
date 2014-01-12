package com.moowork.apirules.reader;

import org.objectweb.asm.ClassReader;

public final class SignatureReader
{
    public ClassSignatures read( final String className, final byte[] data )
    {
        final ClassSignatures signatures = new ClassSignatures( className );
        final ClassReader reader = new ClassReader( data );
        reader.accept( new ClassVisitorImpl( signatures ), ClassReader.SKIP_FRAMES );
        return signatures;
    }
}
