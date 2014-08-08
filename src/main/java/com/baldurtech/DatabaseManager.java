package com.baldurtech;

public interface DatabaseManager {
    public int executeUpdate(String sql,Object... params);
}
