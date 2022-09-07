package com.example.Unicorn.store;

public class Unicorn {

    private Long id;
    private String name;
    private int age;
    private Colors color;
    private boolean horn;
    private boolean flyAble;

    public Unicorn(Long id, String name, int age, Colors color, boolean horn, boolean flyAble) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.color = color;
        this.horn = horn;
        this.flyAble = flyAble;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public boolean isHorn() {
        return horn;
    }

    public void setHorn(boolean horn) {
        this.horn = horn;
    }

    public boolean isFlyAble() {
        return flyAble;
    }

    public void setFlyAble(boolean flyAble) {
        this.flyAble = flyAble;
    }
}
