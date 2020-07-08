package LinearTable;

public class Person implements Comparable<Person> {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Person - finalize");
    }

    @Override
    public boolean equals(Object obj) {
        Person person = (Person) obj;
        return this.age==person.age;
    }

    @Override
    public String toString() {
        return "年龄：" + age + "，姓名：" + name;
    }

    @Override
    public int compareTo(Person person) {
        return age - person.age;
    }

}
