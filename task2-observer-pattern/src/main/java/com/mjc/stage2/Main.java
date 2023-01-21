package com.mjc.stage2;

import com.mjc.stage2.entity.Rectangle;
import com.mjc.stage2.entity.RectangleValues;
import com.mjc.stage2.impl.RectangleObserver;
import com.mjc.stage2.repository.RectangleRepository;
import com.mjc.stage2.warehouse.RectangleWarehouse;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(1, 11, 12);
        rectangle1.addObserver(new RectangleObserver());
        Rectangle rectangle2 = new Rectangle(2, 21, 22);
        rectangle2.addObserver(new RectangleObserver());
        Rectangle rectangle3 = new Rectangle(3, 31, 32);
        rectangle3.addObserver(new RectangleObserver());

        RectangleRepository rectangleRepository = RectangleRepository.getInstance();
        rectangleRepository.add(rectangle1);
        rectangleRepository.add(rectangle2);
        rectangleRepository.add(rectangle3);

        RectangleWarehouse rectangleWarehouse = RectangleWarehouse.getInstance();

        for (Rectangle rectangle : rectangleRepository.getRectangles()) {
            double square = rectangle.getSideA() * rectangle.getSideB();
            double perimeter = 2 *(rectangle.getSideA() + rectangle.getSideB());
            rectangleWarehouse.put(rectangle.getId(), new RectangleValues(square, perimeter));
        }

        System.out.println("Rectangle Id 1 values:");
        System.out.println("Square: " + rectangleWarehouse.get(1).getSquare());
        System.out.println("Perimeter: " + rectangleWarehouse.get(1).getPerimeter());
        System.out.println();

        System.out.println("Changing Rectangle Id 1 sideA to 10");
        rectangleRepository.getRectangles().get(0).setSideA(10);
        System.out.println();

        System.out.println("Rectangle Id 1 updated values:");
        System.out.println("Square: " + rectangleWarehouse.get(1).getSquare());
        System.out.println("Perimeter: " + rectangleWarehouse.get(1).getPerimeter());



    }
}
