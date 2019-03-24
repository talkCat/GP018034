package bxc.staticproxy;

import bxc.Person;

public class Facther implements Person {

    private Son person;

    public Facther(Son person)
    {
        this.person = person;
    }

    @Override
    public void findLove() {
        System.out.println("儿子，我给你找个对象，有啥要求啊？");
        person.findLove();
        System.out.println("爸爸的任务完成了");
    }
}
