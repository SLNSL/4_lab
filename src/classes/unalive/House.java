package classes.unalive;

import abstracts.*;
import enums.*;

public class House extends Place {
    public House(Places type){
        super(type);
    }
    public abstract class Room {
        public Walls walls = new Walls();
        private Someone owner;

        Room(){};

        Room(Someone owner){
            this.owner = owner;
        }
        public Someone getOwner() {
            return owner;
        }

        public void setOwner(Someone owner) {
            this.owner = owner;
        }
    }

    public static class Walls {
        private String type = "Стены комнаты";
        private String decor;

        public void setDecor(String decor) {
            this.decor = decor;
        }

        public String getDecor() {
            return decor;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public class BathRoom extends Room {
        private String mission;

        public BathRoom(String mission) {
            this.mission = mission;
        }

        public String getMission() {
            return mission;
        }

        public class Bath{
            private String name = "Ванна";
            private String size;
            private String owner;

            public Bath(String owner, String size){
                this.size = size;
                this.owner = owner;
            }

            public String getName() {
                return name;
            }

            public String getSize() {
                return size;
            }

            public String getOwner() {
                return owner;
            }
        }

    }

    public class BedRoom extends Room {
        private String type = "Cпальня";
        private String color;
        private String size;

        public BedRoom(Someone owner){
            super(owner);
        };
        public BedRoom(String color, String size) {
            this.color = color;
            this.size = size;
        }

        public String getType() {
            return type;
        }

        public String getColor() {
            return color;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public class CupBoard {
            private String name = "Шкаф";
            private String position;
            private String type;
            private String firstThing;
            private String secondThing;
            private String thirdThing;
            private String fourthThing;
            private String fifthThing;
            private String sixthThing;

            public CupBoard(String type, String position) {
                this.type = type;
                this.position = position;
            }

            public void keep(String firstThing, String secondThing, String thirdThing, String fourthThing, String fifthThing, String sixthThing) {
                this.firstThing = firstThing;
                this.secondThing = secondThing;
                this.thirdThing = thirdThing;
                this.fourthThing = fourthThing;
                this.fifthThing = fifthThing;
                this.sixthThing = sixthThing;
            }

            public String getName() {
                return name;
            }

            public String getType() {
                return type;
            }

            public String getPosition() {
                return position;
            }

            public String getThings() {
                return firstThing + ", " + secondThing + ", " + thirdThing + ", " + fourthThing + ", " + fifthThing + ", " + sixthThing;
            }
        }

        public class Bed {
            private String name = "Кровать";
            private String owner;
            private String size;
            private String position;

            public Bed(String owner){
                this.owner = owner;
            }

            public Bed(String owner, String size, String position) {
                this.owner = owner;
                this.size = size;
                this.position = position;
            }

            public String getName() {
                return name;
            }

            public String getPosition() {
                return position;
            }


            public void setSize(String size) {
                this.size = size;
            }


            public String getSize() {
                return size;
            }

            public String getOwner() {
                return owner;
            }
        }
    }
}