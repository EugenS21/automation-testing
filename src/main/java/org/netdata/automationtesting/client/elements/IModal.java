package org.netdata.automationtesting.client.elements;

import org.netdata.automationtesting.client.pages.IPage;

public interface IModal {

    String getTitle();

    <T extends IPage> T close(T pageToReturnTo);

    <T> T getBody();

    void close();

}
