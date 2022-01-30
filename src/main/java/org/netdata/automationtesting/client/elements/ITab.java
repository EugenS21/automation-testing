package org.netdata.automationtesting.client.elements;

public interface ITab {

    String getTitle();

    <T> T getBody(Class<T> clazz);

    void open();

}
