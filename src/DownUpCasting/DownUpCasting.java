package DownUpCasting;


public class DownUpCasting {
    public static void main(String[] args) {

        //Upcasting - este atunci când convertești un obiect de la o subclasă la o superclasă. Este ca și cum ai trata o mașină ca un vehicul general.
        //Upcasting: Tratezi un obiect specific (Car) ca unul mai general (Vechicle). Este automat și sigur.
        System.out.println('\n');
        System.out.println("Up casting");
        Vechicle vechicle1 = new Car();
        vechicle1.drive();


        //DownCasting - este atunci când convertești un obiect de la o superclasă la o subclasă. Este ca și cum ai trata un vehicul general ca o mașină specifică.
        //Tratezi un obiect general (Vechicle) ca unul specific (Car). Trebuie făcut explicit și poate fi riscant.
        System.out.println('\n');
        System.out.println("Down Casting");
        Vechicle vechicle = new Car();
        Car car = (Car) vechicle;
        car.drive();
        car.speedUp();
    }

}
