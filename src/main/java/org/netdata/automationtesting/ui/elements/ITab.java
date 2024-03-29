package org.netdata.automationtesting.ui.elements;

public interface ITab {

    String getTitle();

    <T> T getBody(Class<T> clazz);

    void open();

}
