package com.company.project.lesson09.sealedtypes;

public final /*sealed*/ /*non-sealed*/ class Auth02 implements IAuth{
    @Override
    public boolean authenticate(String username) {
        return false;
    }
}
