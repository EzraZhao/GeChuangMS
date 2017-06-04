package com.gechuangms.model;

import org.litepal.crud.DataSupport;

/**
 * Created by Ezra on 2017/6/4.
 */

public class GCToken extends DataSupport {

    private boolean token;

    GCToken() {
    }

    public GCToken(boolean token) {
        this.token = token;
    }

    public boolean isToken() {
        return token;
    }

    public void setToken(boolean token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GCToken gcToken = (GCToken) o;

        return token == gcToken.token;

    }

    @Override
    public int hashCode() {
        return (token ? 1 : 0);
    }
}
