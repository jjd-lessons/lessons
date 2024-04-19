package com.company.project.lesson28;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ProductStorage {
    private final List<Product> products;
    private final File file = new File("save.txt");
    private final int maxSize; //10

    public ProductStorage(List<Product> products, int maxSize) {
        this.products = products;
        this.maxSize = maxSize;
    }

    // проблема изменения общего ресурса - synchronized
    // проблема производитель - потребитель - wait / notify
    public synchronized void addProductToList(Product product)
            throws InterruptedException {
        while (products.size() /* == */ >= maxSize) wait();
        products.add(product);
        notify();
    }

    public synchronized void writeProductsFromList()
            throws InterruptedException {
        while (products.size() == 0) wait();
        Product removed = products.removeLast();
        try {
            Files.writeString(file.toPath(), removed.toString(),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        notify();
    }
}
