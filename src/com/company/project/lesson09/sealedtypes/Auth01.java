package com.company.project.lesson09.sealedtypes;

public /*sealed*/ /*final*/ non-sealed class Auth01 implements IAuth{
    @Override
    public boolean authenticate(String username) {
        return false;
    }
}
