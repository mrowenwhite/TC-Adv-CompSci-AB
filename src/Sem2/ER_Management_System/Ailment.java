package Sem2.ER_Management_System;
import java.util.*;
import java.util.stream.Collectors;


    public class Ailment {
        public int priority;
        private String ailment;
        private ArrayDeque<String> actions;

        public Ailment(String str) {
            ailment = str;
            switch (str) {
                case "knee scratch":
                    this.priority = 1;
                    this.actions = Arrays.stream(new String[]{"Check in", "Evaluate", "Apply Bandage","Finish"}).collect(Collectors.toCollection(ArrayDeque::new));
                    break;
                case "cough":
                    this.priority = 2;
                    this.actions = Arrays.stream(new String[]{"Check in","Evaluate","Proscribe Meds","Finish"}).collect(Collectors.toCollection(ArrayDeque::new));
                    break;
                case "vomiting":
                    this.priority = 3;
                    this.actions = Arrays.stream(new String[]{"Check in","Evaluate","Proscribe Meds","Finish"}).collect(Collectors.toCollection(ArrayDeque::new));
                    break;
                case "heart attack":
                    this.priority = 4;
                    this.actions = Arrays.stream(new String[]{"Check in","Evaluate","Transfer to ER", "Save Patient", "Finish"}).collect(Collectors.toCollection(ArrayDeque::new));
                    break;
                default:
                    this.priority = 0;
                    this.actions = Arrays.stream(new String[]{"INVALID AILMENT"}).collect(Collectors.toCollection(ArrayDeque::new));
            }
        }

        public String toString() {
            return this.ailment;
        }
        public int getPriority() {return priority;}
        public ArrayDeque<String> getActions() {return actions;}
    }
