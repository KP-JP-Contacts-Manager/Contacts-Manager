package ContactsManager;

public class Person {
    private String name;
    private long number;

    Person(String name, long number){
        this.name = name;
        this.number= number;
    }

    public String getName() {
        return name;
    }

    public long getNumber() {
        return number;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

//    public void setNumber(String number) {
//        this.number = number;
//    }


}
