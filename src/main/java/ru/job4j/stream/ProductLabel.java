package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class ProductLabel {

    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(p -> p.getStandard() - p.getActual() <= 3)
                .filter(p -> p.getStandard() - p.getActual() >= 0)
                .map(i -> new Label(i.getName(), i.getPrice() / 2))
                .map(l -> l.toString())
                .collect(Collectors.toList());
    }
}
