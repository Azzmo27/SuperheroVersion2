package org.example.comparators;

import org.example.Superhero;

import java.util.Comparator;


public class StrengthComparator implements Comparator<Superhero> {
    @Override
    public int compare(Superhero superhero1, Superhero superhero2){
        return Integer.compare(superhero1.getStrength(),superhero2.getStrength());

    }
}



