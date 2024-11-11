package kapyrin.test.anothertest;
public enum EnumDemo {
    ONE {
        private int value = 1;

        public void print() {
            System.out.println("Method specific to ONE: " + value);
        }
    },
    TWO {
        private String message = "This is TWO";

        public void print (){
            System.out.println("Method specific to TWO: " + message);
        }
    },
    Three {
        private double number = 3.14;

        public void print() {
            System.out.println("Method specific to THREE: " + number);
        }
    };

    abstract void print();
}