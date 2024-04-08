package com.company.project.lesson24.ioapi;

import java.io.IOException;

public class Lesson24 {
    public static void main(String[] args) {
        Resource resource = new Resource();

        try {
            resource.resourceVoid();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            // resource.close();
        }

        finally {
            resource.close();
        }

        // try with resources java 7
        try(Resource resource00 = new Resource()) {
            resource00.resourceVoid();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
