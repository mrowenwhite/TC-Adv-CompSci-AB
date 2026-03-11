package Sem2.ER_Management_System;
import java.util.*;
import java.util.stream.Collectors;

    public class Ailment {
        public int priority;
        private ArrayDeque<String> actions;
        public Ailment(int priority, ArrayDeque<String> actions) {
            this.priority = priority;
            this.actions = actions;
        }

        public Ailment(String str) {
            if (str.equalsIgnoreCase("knee scratch")){
                this.priority = 4;
                this.actions = Arrays.stream(new String[]{"Check in", "Evaluate", "Apply", "Bandage","Finish"}).collect(Collectors.toCollection(ArrayDeque::new));
            }
            if (str.equalsIgnoreCase("cough")){
                this.priority = 3;
                this.actions = Arrays.stream(new String[]{"Check in","Evaluate","Proscribe Meds","Finish"}).collect(Collectors.toCollection(ArrayDeque::new));
            }
            if (str.equalsIgnoreCase("vomiting")){
                this.priority = 2;
                this.actions = Arrays.stream(new String[]{"Check in","Evaluate","Proscribe Meds","Finish"}).collect(Collectors.toCollection(ArrayDeque::new));
            }
            if (str.equalsIgnoreCase("heart attack")){
                this.priority = 1;
                this.actions = Arrays.stream(new String[]{"Check in","Evaluate","Transfer to ER", "Save Patient", "Finish"}).collect(Collectors.toCollection(ArrayDeque::new));
            }
            else  {
                this.priority = 9999;
                this.actions = Arrays.stream(new String[]{"INVALID AILMENT"}).collect(Collectors.toCollection(ArrayDeque::new));
            }
        }

        public int getPriority() {return priority;}
        public ArrayDeque<String> getActions() {return actions;}
    }
