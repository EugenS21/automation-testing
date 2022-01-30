package org.netdata.automationtesting.ui.elements;

import org.netdata.automationtesting.ui.pages.IPage;

public interface IModal {

    String getTitle();

    <T extends IPage> T close(T pageToReturnTo);

    <T> T getBody();

    void close();

}
