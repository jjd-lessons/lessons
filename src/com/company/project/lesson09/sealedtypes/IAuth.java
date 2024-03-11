package com.company.project.lesson09.sealedtypes;

public sealed interface IAuth /*extends Runnable*/ permits Auth01, Auth02 {
    boolean authenticate(String username);
}
