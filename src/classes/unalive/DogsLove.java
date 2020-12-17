package classes.unalive;

import abstracts.*;
import enums.*;

public class DogsLove {
    public static void WhatDoesHeLoves(Animal dog){
        if (dog.getName() == "Роланд") {
            System.out.print(dog.getName() + " в особенности");
        } else {
            System.out.print(dog.getName());
        }
        System.out.print(" любит бродить по улицам, особенно в центре города по причинам: ");
        for (ReasonToLove reasons : ReasonToLove.getReasons()) {
            System.out.printf("%s, ",reasons.getType());
        }
        System.out.print("которые улавливало только тонкое обоняние собак");
        System.out.println();
    }

}
