
package com.yelj.hello;

import com.yelj.hello.bean.Person;

interface MRemotePersonService{

    void addPerson(in Person p);

    List<Person> getPersonList();

    void setValue(int value);
}