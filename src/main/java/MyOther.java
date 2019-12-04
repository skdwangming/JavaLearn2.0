import org.junit.jupiter.api.Test;


public class MyOther {

    class Person{
        String name;
        int age;
        Person(String name,int age){
            this.name = name;
            this.age = age;
        }

        public int hashCode(){
            return name.toUpperCase().hashCode()*age;
        }

        public boolean equals(Person p){
            if(p == null){
                return false;
            }
            if (this == p){
                return true;
            }
            if(this.getClass() != p.getClass()){
                return false;
            }
            Person person = (Person)p;
            return name.equals(person.name) && age == person.age;
        }
    }


    @Test
    public void test1() {
        Person gg = new Person("gg", 11);
        Person GG = new Person("GG", 11);
        System.out.println(gg.hashCode());
        System.out.println(GG.hashCode());
        System.out.println(gg.equals(GG));
    }

    @Test
    public void test2() {

    }

    @Test
    public void test3() {

    }

    @Test
    public void test4() {

    }

    @Test
    public void test5() {

    }

    @Test
    public void test6() {

    }

    @Test
    public void test7() {

    }
}

