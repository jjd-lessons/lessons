package com.company.project.lesson23.strategy;

public class Unit {
    private IAction<Unit> action;

    public Unit(IAction<Unit> action) {
        if (action == null) throw new IllegalArgumentException();
        this.action = action;
    }

    public void changeAction(IAction<Unit> action){
        if (action != null) this.action = action;
    }

    public void move(){
        action.execute(this);
    }

    /*public void move(String data){
        if (data){
            System.out.println("run");
        } else if (data){
            System.out.println("run fast");
        }else if (data){
            System.out.println("sleep");
        }
    }*/
}
