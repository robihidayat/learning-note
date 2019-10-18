package com.robihidayat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.robihidayat.dto.AcquirerItems;

import lombok.ToString;


/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        
        List<String> listOfStrings = Arrays.asList("1", "2", "3", "4", "5");

        List<AcquirerItems> people = getPeopleFromDatabasePseudoMethod();

        List<String> expectedValues = Arrays.asList("john", "joe", "bill");


        System.out.println(listOfStrings.stream()
            .filter(e->e.equals("2"))
            .collect(Collectors.toList())
            );
    }

    private static List<AcquirerItems> getPeopleFromDatabasePseudoMethod(){



        return items;
    

    }
        


}
