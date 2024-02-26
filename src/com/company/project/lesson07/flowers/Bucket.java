package com.company.project.lesson07.flowers;

public class Bucket {
    private Flower[] flowers;
    private int index;

    public Bucket(int numberOfFlowers) {
        if (numberOfFlowers <= 0) throw new IllegalArgumentException("размер букета - положительно число");
        this.flowers = new Flower[numberOfFlowers];
    }
    // в букет можно добавлять цветы, которые начинаются на a
    public boolean addFlower(Flower flower) {
        if (flower == null) throw new IllegalArgumentException("передайте цветок");
        if (!flower.getName().startsWith("a")
                || !flower.getName().startsWith("A")) return false;
        if (index == flowers.length) return false;
        flowers[index] = flower;
        index++;
        /*for (int i = 0; i < flowers.length; i++) {
            if (flowers[i] == null) {
                flowers[i] = flower; // [f1, f2, f3, f4, f4]
                return true;
            }
        }*/
        return true;
    }

    /*public void setFlowers(Flower[] flowers) {
        this.flowers = flowers;
    }*/

    public Flower[] getFlowers() {
        return flowers;
    }
    /*public Flower getFlowerByIndex(int index) {
        return flowers;
    }*/
}
