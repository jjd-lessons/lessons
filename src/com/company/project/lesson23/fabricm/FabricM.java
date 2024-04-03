package com.company.project.lesson23.fabricm;

public class FabricM {
    public static void main(String[] args) {
        Handler handler = Handler.create("file.txt");
        handler.write("данные");
    }
}
